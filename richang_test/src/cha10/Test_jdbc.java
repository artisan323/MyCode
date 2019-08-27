package cha10;

import java.sql.*;

public class Test_jdbc {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost/JDBC?useSSL=false";
        String user = "zhaomingxuan";
        String password = "123456";

        try{
            //1加载驱动
            Class.forName("com.mysql.cj.jdbc.Driver");

            //2连接数据库
            Connection conn = DriverManager.getConnection(url, user, password);

            //3创建执行sql语句的类 Statement
            Statement st = conn.createStatement();

            //4执行sql语句
            String sql = "select * from person";
            ResultSet re = st.executeQuery(sql);

            //5获取结果
            while (re.next()){
                System.out.print("name:" + re.getString(1) + " age:" +re.getString(2) + " address:" + re.getString(3) +"\n");
            }


            //6关闭数据库
            st.close();
            conn.close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
