package cn.backpackerxl.book.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBForTable {
    private String table;
    public DBForTable(String table) {
        this.table = table;
    }

    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    public ResultSet findByName(String name){
        try {
            String sql = "select * from "+ this.table + " where name = ?";
            System.out.println(sql);
            connection = DButils.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setNString(1, name);
            resultSet = preparedStatement.executeQuery();
//            return resultSet;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }
}
