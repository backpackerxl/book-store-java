package cn.backpackerxl.book.util;
/**
 * @author: backpackerxl
 * @create: 2021/10/28
 * @filename: DButils
 **/

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class DButils {
    private static DataSource dataSource;

    static {
        try {
            InputStream inputStream = new FileInputStream(getPath());
            Properties properties = new Properties();
            properties.load(inputStream);
            dataSource = DruidDataSourceFactory.createDataSource(properties);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 返回数据源对象
     *
     * @return
     */
    public static DataSource getDataSource() {
        return (DataSource) dataSource;
    }

    /**
     * 通过数据库连接池连接
     *
     * @return
     * @throws SQLException
     */
    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    /**
     * 关闭结果集
     *
     * @param resultSet
     * @throws SQLException
     */
    public static void closeResult(ResultSet resultSet) throws SQLException {
        if (resultSet != null) {
            resultSet.close();
        }
    }

    /**
     * 关闭处理对象
     *
     * @param preparedStatement
     * @throws SQLException
     */
    public static void closePreparedStatement(PreparedStatement preparedStatement) throws SQLException {
        if (preparedStatement != null) {
            preparedStatement.close();
        }
    }

    /**
     * 关闭连接
     *
     * @param connection
     * @throws SQLException
     */
    public static void closeConnection(Connection connection) throws SQLException {
        if (connection != null) {
            connection.close();
        }
    }

    /**
     * 用于释放查询的资源
     *
     * @param connection
     * @param preparedStatement
     * @param resultSet
     */
    public static void close(Connection connection, PreparedStatement preparedStatement, ResultSet resultSet) {
        try {
            closeResult(resultSet);
            closePreparedStatement(preparedStatement);
            closeConnection(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    /**
     * 用于释放增删改的资源
     *
     * @param connection
     * @param preparedStatement
     */
    public static void close(Connection connection, PreparedStatement preparedStatement) {
        try {
            closePreparedStatement(preparedStatement);
            closeConnection(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取配置文件
     *
     * @return
     */
    private static String getPath() {
        URL path = DButils.class.getResource("/");
        String url = path.toString().substring(6, 36);
        String burl = "/src/main/resources/druid.properties";
        return url + burl;
    }
}
