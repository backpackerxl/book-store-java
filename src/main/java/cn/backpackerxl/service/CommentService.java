package cn.backpackerxl.service;

import cn.backpackerxl.entity.Compents;
import cn.backpackerxl.pojo.CommentFactory;
import cn.backpackerxl.pojo.UserCommpment;

import java.util.List;

/**
 * @author: backpackerxl
 * @create: 2021/11/24
 * @filename: Comment
 **/
public interface CommentService {
    int addComment(Compents compents);

    List<CommentFactory> findAllByBookCode(String bookCode);
}
