package cn.itcast.mybatis.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author frank  zhangmingming@itcast.cn
 * @Description:  该方法主要是演示jdbc开发中问题的总结
 * @Package cn.itcast.mybatis.jdbc
 * @ClassName: cn.itcast.mybatis.jdbc.JdbcTest
 * @date 2017年08月17日 14:14
 */
public class JdbcTest {

    public static void main(String [] args){
        //数据库连接
        Connection connection = null;
        //预编译的Statement，jdbc和数据库通过Statement通信，Statement中封装了sql语句及参数

        PreparedStatement preparedStatement = null;
        //结果集
        ResultSet resultSet = null;

        try {
            // 加载数据库驱动
            Class.forName("com.mysql.jdbc.Driver");

            // 通过驱动管理类获取数据库链接
            connection = DriverManager
                    .getConnection(
                            "jdbc:mysql://localhost:3306/mybatis?characterEncoding=utf-8",
                            "root", "store");
            // 定义sql语句 ?表示占位符
            //预编译的Statement好处：可以提高数据库的性能，使用占位符可以有效防止sql注入
            String sql = "select * from user where  username = ? ";
            // 获取预处理statement
            preparedStatement = connection.prepareStatement(sql);
            // 设置参数，第一个参数为sql语句中参数的序号（从1开始），第二个参数为设置的参数值
            preparedStatement.setString(1, "王五");
            // 向数据库发出sql执行查询，查询出结果集
            resultSet = preparedStatement.executeQuery();
            // 遍历查询结果集
            while (resultSet.next()) {
                System.out.println(resultSet.getString("id") + "  "
                        + resultSet.getString("username"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 释放资源
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        }
    }

}
