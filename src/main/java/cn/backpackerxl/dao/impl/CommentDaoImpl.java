package cn.backpackerxl.dao.impl;

import cn.backpackerxl.dao.CommentDao;
import cn.backpackerxl.entity.Compents;
import cn.backpackerxl.pojo.UserCommpment;
import cn.backpackerxl.util.DButils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: backpackerxl
 * @create: 2021/11/24
 * @filename: CommentDaoImpl
 **/
public class CommentDaoImpl implements CommentDao {
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    @Override
    public int addComment(Compents compents) {
        int target = 0;
        try {
            connection = DButils.getConnection();
            preparedStatement = connection.prepareStatement("insert into t_compents value(id,?,?,?,?,? )");
            preparedStatement.setDate(1, (Date) compents.getCreateTime());
            preparedStatement.setInt(2, compents.getUserId());
            preparedStatement.setNString(3, compents.getContent());
            preparedStatement.setNString(4, compents.getProductCode());
            preparedStatement.setInt(5, compents.getParentCommentId());
            target = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DButils.close(connection, preparedStatement);
        }
        return target;
    }

    @Override
    public List<UserCommpment> findAllByBookCode(String bookCode) {
        List<UserCommpment> commentList = new ArrayList<>();
        String sql = "select tc.id, tu.name, tu.user_img, tc.content, tc.create_time, tc.product_code, tc.parent_comment_id from t_compents tc left join t_user tu on tc.user_id = tu.id where product_code = ?";
        try {
            connection = DButils.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setNString(1, bookCode);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String userImg = resultSet.getString(3);
                String content = resultSet.getString(4);
                Date createTime = resultSet.getDate(5);
                String productCode = resultSet.getString(6);
                int parentCommentId = resultSet.getInt(7);
                UserCommpment userCommpment = new UserCommpment(id, name, userImg, content, createTime, productCode, parentCommentId);
                commentList.add(userCommpment);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DButils.close(connection, preparedStatement, resultSet);
        }
        return commentList;
    }
}
