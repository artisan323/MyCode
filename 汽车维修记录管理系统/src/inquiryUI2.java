import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.ArrayList;

public class inquiryUI2 extends JFrame implements ActionListener {

    JButton jb = null;
    JPanel jp1, jp2, jp3, jp4 = null;
    JTextArea jta = null;
    JLabel jlb1, jlb2, jlb3, jlb4, jlb5= null;

    DBUtil db = new DBUtil();
    Connection conn = db.get_conn();
    PreparedStatement pst = null;
    Statement stmt = null;

    ArrayList<car> carList = new ArrayList<car>();

    public inquiryUI2(String jt){

        jb = new JButton("删除此车信息");
        jb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String sql = "drop table " + jt;
                try {
                    pst = conn.prepareStatement(sql);
                    pst.executeUpdate();
                    JOptionPane.showMessageDialog(null, jt + "车信息删除成功");

                } catch (SQLException e1) {
                    e1.printStackTrace();
                }

            }
        });

        jp1=new JPanel();
        jp2=new JPanel();
        jp3=new JPanel();
        jp4=new JPanel();

        jta = new JTextArea();

        String s = null;
        for (car e : get_massage(jt)){
            s = e.getName();
            jta.append(e.toString());
        }

        jlb1=new JLabel("车牌号：");
        jlb2=new JLabel("维修信息：");
        jlb4=new JLabel("姓名：");
        jlb5=new JLabel(s);
        jlb3=new JLabel(jt);

        jp1.add(jlb1);
        jp1.add(jlb3);

        jp2.add(jlb4);
        jp2.add(jlb5);

        jp3.add(jlb2);
        jp3.add(jta);

        jp4.add(jb);

        this.add(jp1);
        this.add(jp2);
        this.add(jp3);
        this.add(jp4);

        this.setLayout(new FlowLayout());
        this.setTitle("汽车维修信息管理系统");
        this.setSize(400,250);
        this.setLocation(400, 200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    //设置当关闭窗口时，保证JVM也退出
        this.setVisible(true);
        this.setResizable(true);

    }

    public ArrayList<car> get_massage(String r) {
        String sql = "select pate_number, mast_name, date, remark from " + r;
        String result = null;
        try {
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                String Plate_number = rs.getString("pate_number");
                String mast_name = rs.getString("mast_name");
                String c_date = rs.getString("date");
                String remark = rs.getString("remark");
                car c = new car(Plate_number, mast_name, remark, c_date);
                carList.add(c);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return carList;
    }
    public void actionPerformed(ActionEvent event){

    }

}
