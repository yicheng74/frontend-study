package com.mavenday1;

import org.junit.Test;
import org.junit.Assert; 
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JdbcTest{
    @Test
    public void testUpdate() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");


        String url ="jdbc:mysql://localhost:3306/web01";
        String username = "root";
        String password = "758258";
        try (Connection connection = DriverManager.getConnection(url, username, password);
             Statement statement = connection.createStatement()) {
            int i = statement.executeUpdate("update `user` set age = 25 where id = 1");
        }//dml

       

    }


    @Test
    public void testSelect() throws Exception {
        String URL ="jdbc:mysql://localhost:3306/web01";
        String USER = "root";
        String PASSWORD = "758258";

        
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            // 1. 注册 JDBC 驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            // 2. 打开连接
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            // 3. 执行查询（使用 ? 占位符）
            String sql = "SELECT id, username, password, name, age " +
                         "FROM user " +
                         "WHERE username = ? AND password = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, "daqiao");
            stmt.setString(2, "123456");
            rs = stmt.executeQuery();
            // 4. 处理结果集
            while (rs.next()) {
                int id = rs.getInt("id");
                String username = rs.getString("username");
                String pwd = rs.getString("password");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                System.out.println(
                        "id=" + id +
                        ", username=" + username +
                        ", password=" + pwd +
                        ", name=" + name +
                        ", age=" + age
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 5. 释放资源
            try {
                if (rs != null) rs.close();
            } catch (Exception ignored) {}
            try {
                if (stmt != null) stmt.close();
            } catch (Exception ignored) {}
            try {
                if (conn != null) conn.close();
            } catch (Exception ignored) {}
        }
    }
}