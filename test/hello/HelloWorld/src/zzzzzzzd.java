import javax.swing.*;//ͼ�ν���
import java.awt.*;//ͼ�ν���
import java.awt.event.*;//�����¼���
public class zzzzzzzd extends JFrame implements ActionListener{
private JLabel r,area;
private JTextField jtr,jtarea; //�����ı���
private JButton OK,Cancle;
public zzzzzzzd(){
 r=new JLabel("������Բ�뾶");
 area=new JLabel("Բ����ǣ�");
jtr=new JTextField();
jtarea=new JTextField();
OK=new JButton("����");
Cancle=new JButton("ȡ��");
}
public void launchTextField(){
jtarea.setEditable(false);//�ı��򲻿ɱ༭
jtr.requestFocus();//ʹ�ı����ý���Ҳ����˵����������￪ʼ��                  
OK.addActionListener(this);//ΪOK��ťע�������
Cancle.addActionListener(this);//
Container c=getContentPane();//����Ƕ�壬���罫��ť����ǩ������Ƕ���ϣ�
c.setLayout(new GridLayout(3,2));//����һ������������Ϊ3��2�еĶ���
c.add(r);//�����ǩ
c.add(jtr);//�����ı���
c.add(area);
c.add(jtarea);
c.add(OK);
c.add(Cancle);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//�رմ����˳�����!
pack();//�Զ����ڿؼ���С
setVisible(true);//ʼ����ʾͼ�ν���
}
public void actionPerformed(ActionEvent e){
Object source=e.getSource();//����¼�Դ�����൱���ȶ����ʹ��
double R=0.0,S=0.0;
if(source==OK){
try{
R=Double.parseDouble(jtr.getText());
S=3.14*R*R;
jtarea.setText(Double.toString(S));
}
catch(NumberFormatException ne){
JOptionPane.showMessageDialog(null,"��������ȷ�����ָ�ʽ","������ʾ",JOptionPane.ERROR_MESSAGE);
jtr.selectAll();//ѡ�������ı�����
}
}
if(source==Cancle){
jtr.setText("");
jtarea.setText("");
}
jtr.requestFocus();//�ı����ý���
}

public static void main(String args[]){
TextField tf=new TextField();
//tf.setTitle("�ı���");
//tf.launchTextField();
}
}

