package cn.backpackerxl.entity;

/**
 * @author: backpackerxl
 * @create: 2021/11/23
 * @filename: BookType
 **/
public class BookType {
    private int id;
    private String typeName;

    public BookType() {
    }

    public BookType(int id, String typeName) {
        this.id = id;
        this.typeName = typeName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    @Override
    public String toString() {
        return "BookType{" +
                "id=" + id +
                ", typeName='" + typeName + '\'' +
                '}';
    }
}
