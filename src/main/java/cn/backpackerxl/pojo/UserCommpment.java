package cn.backpackerxl.pojo;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

/**
 * @author: backpackerxl
 * @create: 2021/11/24
 * @filename: Commpment
 **/
public class UserCommpment {
    @JSONField(ordinal = 1)
    private int id;
    @JSONField(ordinal = 2)
    private String name;
    @JSONField(ordinal = 3, name = "user_img")
    private String userImg;
    @JSONField(ordinal = 4)
    private String content;
    @JSONField(ordinal = 5)
    private Date createTime;
    @JSONField(ordinal = 6, name = "product_id")
    private String productCode;
    @JSONField(ordinal = 7, name = "parent_comment_id")
    private int parentCommentId;


    public UserCommpment() {
    }

    public UserCommpment(int id, String name, String userImg, String content, Date createTime, String productCode, int parentCommentId) {
        this.id = id;
        this.name = name;
        this.userImg = userImg;
        this.content = content;
        this.createTime = createTime;
        this.productCode = productCode;
        this.parentCommentId = parentCommentId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserImg() {
        return userImg;
    }

    public void setUserImg(String userImg) {
        this.userImg = userImg;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public int getParentCommentId() {
        return parentCommentId;
    }

    public void setParentCommentId(int parentCommentId) {
        this.parentCommentId = parentCommentId;
    }

    @Override
    public String toString() {
        return "UserCommpment{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", userImg='" + userImg + '\'' +
                ", content='" + content + '\'' +
                ", createTime=" + createTime +
                ", productCode='" + productCode + '\'' +
                ", parentCommentId=" + parentCommentId +
                '}';
    }
}
