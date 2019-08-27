package cha10;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBC_test {
    public static void main(String[] args) {
        Connection conn = DBUtil.get_conn();
        PreparedStatement pst = null;
        ResultSet re = null;
        try {

            //Statement st = conn.createStatement();
            String sql = "insert into person values('郭龙', '25', '白银')";
            pst = conn.prepareStatement(sql);
            pst.execute();
            String sql1 = "select * from person";
            pst = conn.prepareStatement(sql1);
            pst.execute();
            re = pst.executeQuery(sql1);

            while (re.next()){
                System.out.print("name:" + re.getString(1) + " age:" +re.getString(2) + " address:" + re.getString(3) +"\n");

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        DBUtil.close_conn(conn, null, pst);

    }
}
