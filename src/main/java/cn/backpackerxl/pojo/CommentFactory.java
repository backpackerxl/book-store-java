package cn.backpackerxl.pojo;

import java.util.List;

/**
 * @author: backpackerxl
 * @create: 2021/11/24
 * @filename: CommentFactory
 **/
public class CommentFactory {
    private UserCommpment userCommpment;
    private List<UserCommpment> userCommentList;

    public CommentFactory(UserCommpment userCommpment) {
        this.userCommpment = userCommpment;
    }


    public UserCommpment getUserCommpment() {
        return userCommpment;
    }

    public void setUserCommpment(UserCommpment userCommpment) {
        this.userCommpment = userCommpment;
    }

    public List<UserCommpment> getUserCommentList() {
        return userCommentList;
    }

    public void setUserCommentList(List<UserCommpment> userCommentList) {
        this.userCommentList = userCommentList;
    }

    @Override
    public String toString() {
        return "CommentFactory{" +
                "userCommpment=" + userCommpment +
                ", userCommentList=" + userCommentList +
                '}';
    }
}
