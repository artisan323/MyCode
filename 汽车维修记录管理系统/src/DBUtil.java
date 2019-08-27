import java.sql.*;

public class DBUtil {
    //创建连接
    public static Connection get_conn(){
        String url = "jdbc:mysql://localhost/Car?useSSL=false";
        String user = "root";
        String password = "root";
        Connection conn = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, password);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    //关闭连接
    public static void close_conn(Connection conn, Statement st, PreparedStatement pst){
        if (conn != null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (st != null){
            try {
                st.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (pst != null){
            try {
                pst.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


}
