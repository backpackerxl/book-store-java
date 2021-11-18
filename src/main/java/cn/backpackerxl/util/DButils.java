package cn.backpackerxl.util;
/**
 * @author: backpackerxl
 * @create: 2021/10/28
 * @filename: DButils
 **/

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class DButils {
    private static DataSource dataSource;

    static {
        try {
            InputStream resourceAsStream = DButils.class.getClassLoader().getResourceAsStream("druid.properties");
            Properties properties = new Properties();
            properties.load(resourceAsStream);
            dataSource = DruidDataSourceFactory.createDataSource(properties);
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
}
