import javax.swing.*;//图形界面
import java.awt.*;//图形界面
import java.awt.event.*;//引入事件包
public class zzzzzzzd extends JFrame implements ActionListener{
private JLabel r,area;
private JTextField jtr,jtarea; //创建文本框
private JButton OK,Cancle;
public zzzzzzzd(){
 r=new JLabel("请输入圆半径");
 area=new JLabel("圆面积是：");
jtr=new JTextField();
jtarea=new JTextField();
OK=new JButton("计算");
Cancle=new JButton("取消");
}
public void launchTextField(){
jtarea.setEditable(false);//文本框不可编辑
jtr.requestFocus();//使文本框获得焦点也就是说，鼠标在哪里开始！                  
OK.addActionListener(this);//为OK按钮注册监听器
Cancle.addActionListener(this);//
Container c=getContentPane();//内容嵌板，比如将按钮，标签添到内容嵌板上！
c.setLayout(new GridLayout(3,2));//创建一个将容器划分为3行2列的对象
c.add(r);//加入标签
c.add(jtr);//加入文本框
c.add(area);
c.add(jtarea);
c.add(OK);
c.add(Cancle);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//关闭窗口退出程序!
pack();//自动调节控件大小
setVisible(true);//始终显示图形界面
}
public void actionPerformed(ActionEvent e){
Object source=e.getSource();//获得事件源，就相当于先定义后使用
double R=0.0,S=0.0;
if(source==OK){
try{
R=Double.parseDouble(jtr.getText());
S=3.14*R*R;
jtarea.setText(Double.toString(S));
}
catch(NumberFormatException ne){
JOptionPane.showMessageDialog(null,"请输入正确的数字格式","错误提示",JOptionPane.ERROR_MESSAGE);
jtr.selectAll();//选中所有文本内容
}
}
if(source==Cancle){
jtr.setText("");
jtarea.setText("");
}
jtr.requestFocus();//文本框获得焦点
}

public static void main(String args[]){
TextField tf=new TextField();
//tf.setTitle("文本框");
//tf.launchTextField();
}
}

