import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class select_funcUI extends JFrame implements ActionListener {

    JButton jb1, jb2= null;
    JRadioButton jrb1, jrb2, jrb3 = null;
    JPanel jp1, jp2, jp3, jp4= null;
    ButtonGroup bg=null;

    public static void main(String[] args)
    {
        select_funcUI  ui=new select_funcUI();
    }

    public select_funcUI(){

        jb1 = new JButton("确定");
        jb2 = new JButton("退出");

        jb1.addActionListener(this);
        jb2.addActionListener(this);

        jrb1 = new JRadioButton("创建新车辆车牌号");
        jrb2 = new JRadioButton("插入已有维修记录");
        jrb3 = new JRadioButton("查询车辆维修信息");

        bg=new ButtonGroup();
        bg.add(jrb1);
        bg.add(jrb2);
        bg.add(jrb3);
        jrb2.setSelected(true);  //初始页面默认选择权限为 学生

        jp1=new JPanel();
        jp2=new JPanel();
        jp3=new JPanel();
        jp4=new JPanel();

        jp1.add(jrb1);
        jp2.add(jrb2);
        jp3.add(jrb3);
        jp4.add(jb1);
        jp4.add(jb2);

        this.add(jp1);
        this.add(jp2);
        this.add(jp3);
        this.add(jp4);

        this.setLayout(new GridLayout(4,1));            //选择GridLayout布局管理器
        this.setTitle("功能选择");
        this.setSize(300,200);
        this.setLocation(400, 200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    //设置当关闭窗口时，保证JVM也退出
        this.setVisible(true);
        this.setResizable(true);

    }

    public void actionPerformed(ActionEvent e){

        if (e.getActionCommand() == "确定"){
            if(jrb1.isSelected())
            {
                //进入创建新车辆车牌号
                createNewUI cn = new createNewUI();
                dispose();
            }else if(jrb2.isSelected()) {
                //进入插入已有维修记录
                insertCarUI ic = new insertCarUI();
                dispose();
            }else if (jrb3.isSelected()){
                //进入查询界面
                System.out.println("进入查询");
                dispose();
            }


        }else if (e.getActionCommand() == "退出"){
            System.exit(0);
        }

    }



}
