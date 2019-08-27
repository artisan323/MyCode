import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainUI extends JFrame implements ActionListener {


    JButton jb1, jb2= null;     //定义按钮
    JPanel jp1, jp2, jp3= null; //定义区域
    JTextField jtf = null;      //定义输入文本框
    JLabel jlb1, jlb2 = null;   //定义标签
    JPasswordField jpf = null;  //密码框
    ButtonGroup bg = null;

    //设定用户名和密码
    final String stu_name="赵铭轩";
    final String stu_pwd="123456";

    public static void main(String[] args) {
        MainUI mUI=new MainUI();
    }

    public MainUI(){
        //创建组件
        jb1=new JButton("登陆");
        jb2=new JButton("退出");

        //设置监听
        jb1.addActionListener(this);
        jb2.addActionListener(this);

        //创建三个区域
        jp1=new JPanel();
        jp2=new JPanel();
        jp3=new JPanel();

        //标签
        jlb1=new JLabel("用户名：");
        jlb2=new JLabel("密    码：");

        jtf=new JTextField(10);
        jpf=new JPasswordField(10);

        jp1.add(jlb1);      //区域1添加用户名和输入框
        jp1.add(jtf);

        jp2.add(jlb2);      //区域2添加密码和输入框
        jp2.add(jpf);

        jp3.add(jb1);       //添加登陆等按钮
        jp3.add(jb2);

        //加入JFrame中
        this.add(jp1);
        this.add(jp2);
        this.add(jp3);

        this.setLayout(new GridLayout(3,1));            //选择GridLayout布局管理器
        this.setTitle("汽车维修管理系统");
        this.setSize(300,200);
        this.setLocation(400, 200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    //设置当关闭窗口时，保证JVM也退出
        this.setVisible(true);
        this.setResizable(true);
    }

    public void actionPerformed(ActionEvent e){

        if (e.getActionCommand() == "登陆"){
            login();
        }else if (e.getActionCommand() == "退出"){
            System.exit(0);
        }

    }

    public void login(){
        if (stu_name.equals(jtf.getText()) && stu_pwd.equals(jpf.getText())){
            dispose();
            clear();
            select_funcUI ui = new select_funcUI();
        }else {
            JOptionPane.showMessageDialog(null,"用户名或者密码错误！\n请重新输入","提示消息",JOptionPane.ERROR_MESSAGE);
            clear();  //清空输入框
        }
    }

    public  void clear()
    {
        jtf.setText("");
        jpf.setText("");
    }

}
