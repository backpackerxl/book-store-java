package cn.backpackerxl.entity;


import java.util.Date;

/**
 * @author: backpackerxl
 * @create: 2021/11/22
 * @filename: Compents
 **/
public class Compents {
    private int id;
    private Date createTime;
    private int userId;
    private String content;
    private String productCode;
    private int parentCommentId;

    public Compents() {
    }

    public Compents(int id, Date createTime, int userId, String content, String productCode, int parentCommentId) {
        this.id = id;
        this.createTime = createTime;
        this.userId = userId;
        this.content = content;
        this.productCode = productCode;
        this.parentCommentId = parentCommentId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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
        return "Compents{" +
                "id=" + id +
                ", createTime=" + createTime +
                ", userId='" + userId + '\'' +
                ", content='" + content + '\'' +
                ", productCode='" + productCode + '\'' +
                ", parentCommentId=" + parentCommentId +
                '}';
    }
}
