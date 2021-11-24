package cn.backpackerxl.dao;

import cn.backpackerxl.entity.Compents;
import cn.backpackerxl.pojo.UserCommpment;

import java.util.List;

/**
 * @author: backpackerxl
 * @create: 2021/11/24
 * @filename: CommentDao
 **/
public interface CommentDao {
    int addComment(Compents compents);

    List<UserCommpment> findAllByBookCode(String bookCode);
}
