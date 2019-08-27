import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class insertCar2 extends JFrame implements ActionListener {

    JButton jb1, jb2 = null;
    JPanel jp1, jp2, jp3, jp4 = null;
    JTextField jtf1, jtf2, jtf3 = null;
    JLabel jlb1, jlb2, jlb3 = null;

    DBUtil db = new DBUtil();
    Connection conn = db.get_conn();
    PreparedStatement pst = null;
    Statement stmt = null;

    public insertCar2(String jt){

        String j = jt;

        jb1=new JButton("确认");
        jb2=new JButton("退出");


        jb1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                try {
                    String sql = "insert into " + jt + " values (?, ? ,?, ?)";
                    pst = conn.prepareStatement(sql);
                    pst.setString(1, jt);
                    pst.setString(2, jtf1.getText());
                    pst.setString(3, jtf3.getText());
                    pst.setString(4, jtf2.getText());
                    int result = pst.executeUpdate();
                    if (result == 1){
                        JOptionPane.showMessageDialog(null, jt + "车信息插入成功");
                        clear();
                        DBUtil.close_conn(conn, stmt, pst);
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });

        jb2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        jp1=new JPanel();
        jp2=new JPanel();
        jp3=new JPanel();
        jp4=new JPanel();

        jlb1=new JLabel("输入车主姓名");
        jlb2=new JLabel("输入维修日期");
        jlb3=new JLabel("输入维修记录");

        jtf1=new JTextField(20);
        jtf2=new JTextField(20);
        jtf3=new JTextField(20);

        jp1.add(jlb1);
        jp1.add(jtf1);

        jp2.add(jlb2);
        jp2.add(jtf2);

        jp3.add(jlb3);
        jp3.add(jtf3);

        jp4.add(jb1);
        jp4.add(jb2);

        this.add(jp1);
        this.add(jp2);
        this.add(jp3);
        this.add(jp4);

        this.setLayout(new GridLayout(4,1));            //选择GridLayout布局管理器
        this.setTitle("汽车维修管理系统");
        this.setSize(500,300);
        this.setLocation(400, 200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    //设置当关闭窗口时，保证JVM也退出
        this.setVisible(true);
        this.setResizable(true);
    }

    public void actionPerformed(ActionEvent event){

    }
    public  void clear()
    {
        jtf1.setText("");
        jtf3.setText("");
        jtf2.setText("");
    }
}
