package cn.backpackerxl.service.impl;

import cn.backpackerxl.dao.CommentDao;
import cn.backpackerxl.dao.impl.CommentDaoImpl;
import cn.backpackerxl.entity.Compents;
import cn.backpackerxl.pojo.CommentFactory;
import cn.backpackerxl.pojo.UserCommpment;
import cn.backpackerxl.service.CommentService;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: backpackerxl
 * @create: 2021/11/24
 * @filename: CommentServiceImp
 **/
public class CommentServiceImp implements CommentService {
    CommentDao commentDao = new CommentDaoImpl();

    @Override
    public int addComment(Compents compents) {
        return commentDao.addComment(compents);
    }

    @Override
    public List<CommentFactory> findAllByBookCode(String bookCode) {
        return combineChildren(commentDao.findAllByBookCode(bookCode));
    }

    /**
     * 找出顶级评论并创建评论数据工厂
     * @param userCommentList 原始数据集合
     * @return 评论模型数据
     */
    private List<CommentFactory> combineChildren(List<UserCommpment> userCommentList) {
        List<CommentFactory> commentFactoryList = new ArrayList<>();
        List<UserCommpment> children = new ArrayList<>();
        for (UserCommpment userCommpment : userCommentList) {
            if (userCommpment.getParentCommentId() == 0) {
                commentFactoryList.add(new CommentFactory(userCommpment));
            } else {
                children.add(userCommpment);
            }
        }
        recursively(children, commentFactoryList);
        children.clear();
        return commentFactoryList;
    }

    /**
     * 循环找出顶级评论下的所有子评论
     * @param children 子评论集合
     * @param commentFactoryList 顶级评论数据集合
     */
    private void recursively(List<UserCommpment> children, List<CommentFactory> commentFactoryList) {
        List<UserCommpment> temp = new ArrayList<>(); //创建临时存放区
        //先找出第一级子评论
        for (UserCommpment userCommpment : children) {
            for (CommentFactory commentFactory1 : commentFactoryList) {
                if (userCommpment.getParentCommentId() == commentFactory1.getUserCommpment().getId()) {
                    temp.add(userCommpment);
                    //将找到的评论信息设置到当前工厂数据对象中
                    commentFactory1.setUserCommentList(temp);
                    temp = new ArrayList<>();
                    break;
                }
            }
        }
        //找出第一级子评论下的所有评论信息
        for (UserCommpment userCommpment : children) {
            for (CommentFactory commentFactory1 : commentFactoryList) {
                if (commentFactory1.getUserCommentList() != null) {
                    for (UserCommpment userComment1 : commentFactory1.getUserCommentList()) {
                        if (userCommpment.getParentCommentId() == userComment1.getId()) {
                            //先保存已经找出来的数据
                            temp = commentFactory1.getUserCommentList();
                            //将新找到的评论信息和已有的评论信息进行合并操作
                            temp.add(userCommpment);
                            //将合并后的评论信息设置到当前工厂数据对象中
                            commentFactory1.setUserCommentList(temp);
                            break;
                        }
                    }
                }
            }
        }
    }
}
