package cn.backpackerxl.book.util;

/**
 * @author: backpackerxl
 * @create: 2021/10/30
 * @filename: StringToJSON
 **/
public class StringToJSON {
    private String key;
    private String value;

    public StringToJSON() {
    }

    public StringToJSON(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String toJSON() {
        return "{" +
                "\"" + key + '\"' +
                ":\"" + value + '\"' +
                '}';
    }
}
