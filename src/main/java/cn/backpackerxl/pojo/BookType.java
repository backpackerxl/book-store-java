package cn.backpackerxl.pojo;

/**
 * @author: backpackerxl
 * @create: 2021/11/23
 * @filename: BookType
 **/
public class BookType {
    private int id;
    private String typeName;
    private int numbers;

    public BookType() {
    }

    public BookType(int id, String typeName, int numbers) {
        this.id = id;
        this.typeName = typeName;
        this.numbers = numbers;
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

    public int getNumbers() {
        return numbers;
    }

    public void setNumbers(int numbers) {
        this.numbers = numbers;
    }

    @Override
    public String toString() {
        return "BookType{" +
                "id=" + id +
                ", typeName='" + typeName + '\'' +
                ", numbers=" + numbers +
                '}';
    }
}
