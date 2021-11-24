package test;

import java.lang.annotation.*;
import java.lang.reflect.*;

/**
 * @author: backpackerxl
 * @create: 2021/11/22
 * @filename: TestAnnotation
 **/
public class TestAnnotation {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException {
        Class clazz = Class.forName("test.Student");
        Annotation[] annotations = clazz.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation);
        }
        Table table = (Table) clazz.getAnnotation(Table.class);
        String value = table.value();
        System.out.println(value);

        Field[] f = clazz.getDeclaredFields();
        for (Field field : f) {
            FieldColumn column = field.getAnnotation(FieldColumn.class);
            System.out.println(column.columnName()+"\t"+column.type());
        }
    }
}

@Table("t_user")
class Student {
    @FieldColumn(columnName = "id", type = "int")
    private int id;
    @FieldColumn(columnName = "age", type = "int")
    private int age;
    @FieldColumn(columnName = "name", type = "String")
    private String name;

    public Student(int id, int age, String name) {
        this.id = id;
        this.age = age;
        this.name = name;
    }

    public Student() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface Table {
    String value();
}

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface FieldColumn {
    String columnName();

    String type();
}
