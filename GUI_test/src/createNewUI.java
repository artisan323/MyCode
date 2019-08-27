import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class createNewUI extends JFrame implements ActionListener {

    DBUtil db = new DBUtil();
    Connection conn = db.get_conn();
    PreparedStatement pst = null;
    Statement stmt = null;
    //car c = new car();

    JButton jb1, jb2= null;
    JLabel jlb1,jlb2,jlb3, jlb4=null;
    JTextField jtf1, jtf2, jtf3, jtf4 = null;
    JPanel jp1, jp2, jp3, jp4, jp5= null;

    public static void main(String[] args) {
        createNewUI cu = new createNewUI();
    }

    public createNewUI(){

        jb1=new JButton("确认");
        jb2=new JButton("退出");

        jb1.addActionListener(this);
        jb2.addActionListener(this);

        jp1=new JPanel();
        jp2=new JPanel();
        jp3=new JPanel();
        jp4=new JPanel();
        jp5=new JPanel();

        jlb1=new JLabel("车牌号  ：");
        jlb2=new JLabel("车主姓名：");
        jlb3=new JLabel("维修记录：");
        jlb4=new JLabel("维修时间：");

        jtf1=new JTextField(20);
        jtf2=new JTextField(20);
        jtf3=new JTextField(20);
        jtf4=new JTextField(20);

        jp1.add(jlb1);
        jp1.add(jtf1);

        jp2.add(jlb2);
        jp2.add(jtf2);

        jp3.add(jlb3);
        jp3.add(jtf3);

        jp4.add(jlb4);
        jp4.add(jtf4);

        jp5.add(jb1);
        jp5.add(jb2);

        this.add(jp1);
        this.add(jp2);
        this.add(jp3);
        this.add(jp4);
        this.add(jp5);

        this.setLayout(new GridLayout(5,2));            //选择GridLayout布局管理器
        this.setTitle("新建车辆维修信息");
        this.setSize(500,300);
        this.setLocation(400, 200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    //设置当关闭窗口时，保证JVM也退出
        this.setVisible(true);
        this.setResizable(true);

    }


    public void actionPerformed(ActionEvent e){
        if (e.getActionCommand() == "确认"){
            if (isTable(jtf1.getText(), conn)){
                JOptionPane.showMessageDialog(null,"该车信息已存在！","提示消息",JOptionPane.WARNING_MESSAGE);
            } else {
                try {

                    //新建一个该车辆自己的表
                    String sql1 = "create table " + jtf1.getText() + "(pate_number VARCHAR(255) NOT null,mast_name VARCHAR(100) not null, remark VARCHAR(2550), date VARCHAR(255))";
                    pst = conn.prepareStatement(sql1);
                    int result0 = pst.executeUpdate();

                    /*if (result0 == 1){
                        System.out.println("创建" + jtf1.getText() + "信息成功");
                        System.out.println(c.toString());
                    }*/

                    //往该表插入数据
                    String sql2 = "insert into " + jtf1.getText() + " values (?, ?, ?, ?)";
                    pst = conn.prepareStatement(sql2);
                    pst.setString(1, jtf1.getText());
                    pst.setString(2, jtf2.getText());
                    pst.setString(3, jtf3.getText());
                    pst.setString(4, jtf4.getText());
                    int result = pst.executeUpdate();
                    //pst.execute();
                    if (result == 1){
                        JOptionPane.showMessageDialog(null, jtf1.getText() + "车信息插入成功");
                        clear();
                    }
                    DBUtil.close_conn(conn, stmt, pst);

                } catch (SQLException en) {
                    en.printStackTrace();
                }
            }


        }else if (e.getActionCommand() == "退出"){
            System.exit(0);
        }


    }
    public  void clear()
    {
        jtf1.setText("");
        jtf3.setText("");
        jtf4.setText("");
        jtf2.setText("");
    }
    public static boolean isTable(String name, Connection conn){
        boolean flag = false;
        try {
            DatabaseMetaData meta = (DatabaseMetaData)conn.getMetaData();
            ResultSet rs = meta.getTables(null, null, name, null);
            flag = rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }

}
