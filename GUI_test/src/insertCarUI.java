import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class insertCarUI extends JFrame implements ActionListener {

    JButton jb1, jb2= null;
    JRadioButton jrb1, jrb2, jrb3 = null;
    JLabel jlb = null;
    JTextField jtf = null;
    JPanel jp1, jp2 = null;

    DBUtil db = new DBUtil();
    Connection conn = db.get_conn();
    PreparedStatement pst = null;
    Statement stmt = null;

    public static void main(String[] args) {
        insertCarUI ic = new insertCarUI();
    }

    public insertCarUI(){

        jb1=new JButton("确认");
        jb2=new JButton("退出");

        jb1.addActionListener(this);
        jb2.addActionListener(this);

        jp1=new JPanel();
        jp2=new JPanel();

        jlb=new JLabel("请输入需要添加信息的车牌号：");

        jtf=new JTextField(10);

        jp1.add(jlb);
        jp1.add(jtf);

        jp2.add(jb1);
        jp2.add(jb2);

        this.add(jp1);
        this.add(jp2);

        this.setLayout(new GridLayout(2,1));            //选择GridLayout布局管理器
        this.setTitle("汽车维修管理系统");
        this.setSize(300,200);
        this.setLocation(400, 200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    //设置当关闭窗口时，保证JVM也退出
        this.setVisible(true);
        this.setResizable(true);

    }

    public void actionPerformed(ActionEvent e){
        if (e.getActionCommand() == "确认"){
            if (createNewUI.isTable(jtf.getText(), conn) == false){
                JOptionPane.showMessageDialog(null,"该车信息不存在，请检查后重试","提示消息",JOptionPane.WARNING_MESSAGE);
            }else{
                //进入插入信息页面
                dispose();
                insertCar2 ic2 = new insertCar2(jtf.getText());
                DBUtil.close_conn(conn, stmt, pst);
            }
        }else if (e.getActionCommand() == "退出"){
            System.exit(0);
        }

    }

}
