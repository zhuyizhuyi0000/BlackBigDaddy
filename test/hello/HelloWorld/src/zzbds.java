import java.awt.Toolkit;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.TitledBorder;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class zzbds {
	int width =Toolkit.getDefaultToolkit().getScreenSize().width;
	int height =Toolkit.getDefaultToolkit().getScreenSize().height;
	private JTable table_k;
	private JTable table_1;
	private JTable table_2;
	private JTable table_3;
	private JTable table_4;
	private JTable table_5;
	private JTable table_6;
	/**
	 * @wbp.parser.entryPoint
	 */
	public zzbds(){
		JFrame frame2 = new JFrame();
		frame2.setTitle("ÏêÏ¸½á¹û");
		frame2.setSize(1100,700);
		frame2.setLocation((width-1100)/2, (height-700)/2);
		frame2.setResizable(true);
		frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel_k = new JPanel();
		panel_k.setBorder(new TitledBorder(null, "\u7A7A\u94FE\u63A5", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLUE));
		
		JPanel panel_k1 = new JPanel();
		panel_k1.setBorder(new TitledBorder(null, "\u975E\u6B63\u5E38\u94FE\u63A5", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLUE));
		
		JPanel panel_k2 = new JPanel();
		panel_k2.setBorder(new TitledBorder(null, "\u975E\u6E38\u620F\u5E73\u53F0\u57DF\u5185\u94FE\u63A5", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLUE));
		
		JPanel panel_k3 = new JPanel();
		panel_k3.setBorder(new TitledBorder(null, "\u5E73\u53F0\u57DF\u4E0B\u975E\u5B98\u7F51\u5185\u94FE\u63A5", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLUE));
		
		JPanel panel_k4 = new JPanel();
		panel_k4.setBorder(new TitledBorder(null, "\u5B98\u7F51\u57DF\u5185\u94FE\u63A5", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLUE));
		
		JPanel panel_k5 = new JPanel();
		panel_k5.setBorder(new TitledBorder(null, "\u5E26\u53C2\u6570\u94FE\u63A5", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLUE));
		
		JPanel panel_k6 = new JPanel();
		panel_k6.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\u68C0\u6D4B\u5230\u7684\u5217\u8868\u9875\u94FE\u63A5", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 255)));
		GroupLayout groupLayout = new GroupLayout(frame2.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(panel_k, GroupLayout.PREFERRED_SIZE, 537, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(panel_k1, GroupLayout.DEFAULT_SIZE, 537, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(panel_k2, GroupLayout.PREFERRED_SIZE, 537, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(panel_k5, GroupLayout.DEFAULT_SIZE, 537, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(panel_k3, GroupLayout.PREFERRED_SIZE, 537, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(panel_k6, GroupLayout.DEFAULT_SIZE, 537, Short.MAX_VALUE))
						.addComponent(panel_k4, GroupLayout.DEFAULT_SIZE, 1080, Short.MAX_VALUE))
					.addGap(2))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(panel_k1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(panel_k, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_k2, GroupLayout.PREFERRED_SIZE, 161, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel_k5, GroupLayout.PREFERRED_SIZE, 161, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_k3, GroupLayout.PREFERRED_SIZE, 161, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel_k6, GroupLayout.PREFERRED_SIZE, 161, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panel_k4, GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
					.addContainerGap())
		);
		panel_k4.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane_k6 = new JScrollPane();
		panel_k4.add(scrollPane_k6);
		
		table_6 = new JTable();
		table_6.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u94FE\u63A5", "\u94FE\u63A5\u540D\u79F0", "\u6253\u5F00\u65B9\u5F0F", "\u6765\u81EA\u7236\u94FE", "", "title", "\u72B6\u6001"
			}
		));
		table_6.getColumnModel().getColumn(0).setPreferredWidth(220);
		table_6.getColumnModel().getColumn(0).setMinWidth(220);
		table_6.getColumnModel().getColumn(0).setMaxWidth(220);
		table_6.getColumnModel().getColumn(1).setPreferredWidth(220);
		table_6.getColumnModel().getColumn(1).setMinWidth(220);
		table_6.getColumnModel().getColumn(1).setMaxWidth(220);
		table_6.getColumnModel().getColumn(2).setPreferredWidth(60);
		table_6.getColumnModel().getColumn(2).setMinWidth(60);
		table_6.getColumnModel().getColumn(2).setMaxWidth(60);
		table_6.getColumnModel().getColumn(3).setPreferredWidth(220);
		table_6.getColumnModel().getColumn(3).setMinWidth(220);
		table_6.getColumnModel().getColumn(3).setMaxWidth(220);
		table_6.getColumnModel().getColumn(4).setPreferredWidth(30);
		table_6.getColumnModel().getColumn(4).setMinWidth(30);
		table_6.getColumnModel().getColumn(4).setMaxWidth(30);
		table_6.getColumnModel().getColumn(5).setPreferredWidth(200);
		table_6.getColumnModel().getColumn(5).setMinWidth(200);
		table_6.getColumnModel().getColumn(5).setMaxWidth(200);
		table_6.getColumnModel().getColumn(6).setPreferredWidth(80);
		table_6.getColumnModel().getColumn(6).setMinWidth(80);
		table_6.getColumnModel().getColumn(6).setMaxWidth(80);
		scrollPane_k6.setViewportView(table_6);
		panel_k6.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane_k5 = new JScrollPane();
		panel_k6.add(scrollPane_k5);
		
		table_4 = new JTable();
		table_4.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u94FE\u63A5", "\u94FE\u63A5\u540D\u79F0", "\u6253\u5F00\u65B9\u5F0F", "\u6765\u81EA\u7236\u94FE", ""
			}
		));
		table_4.getColumnModel().getColumn(0).setPreferredWidth(140);
		table_4.getColumnModel().getColumn(0).setMinWidth(140);
		table_4.getColumnModel().getColumn(0).setMaxWidth(140);
		table_4.getColumnModel().getColumn(1).setPreferredWidth(130);
		table_4.getColumnModel().getColumn(1).setMinWidth(130);
		table_4.getColumnModel().getColumn(1).setMaxWidth(130);
		table_4.getColumnModel().getColumn(2).setPreferredWidth(60);
		table_4.getColumnModel().getColumn(2).setMinWidth(60);
		table_4.getColumnModel().getColumn(2).setMaxWidth(60);
		table_4.getColumnModel().getColumn(3).setPreferredWidth(130);
		table_4.getColumnModel().getColumn(3).setMinWidth(130);
		table_4.getColumnModel().getColumn(3).setMaxWidth(130);
		table_4.getColumnModel().getColumn(4).setPreferredWidth(30);
		table_4.getColumnModel().getColumn(4).setMinWidth(30);
		table_4.getColumnModel().getColumn(4).setMaxWidth(30);
		scrollPane_k5.setViewportView(table_4);
		panel_k3.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane_k2 = new JScrollPane();
		panel_k3.add(scrollPane_k2);
		
		table_2 = new JTable();
		table_2.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u94FE\u63A5", "\u94FE\u63A5\u540D\u79F0", "\u6253\u5F00\u65B9\u5F0F", "\u6765\u81EA\u7236\u94FE", ""
			}
		));
		table_2.getColumnModel().getColumn(0).setPreferredWidth(130);
		table_2.getColumnModel().getColumn(0).setMinWidth(130);
		table_2.getColumnModel().getColumn(0).setMaxWidth(130);
		table_2.getColumnModel().getColumn(1).setPreferredWidth(130);
		table_2.getColumnModel().getColumn(1).setMinWidth(130);
		table_2.getColumnModel().getColumn(1).setMaxWidth(130);
		table_2.getColumnModel().getColumn(2).setPreferredWidth(60);
		table_2.getColumnModel().getColumn(2).setMinWidth(60);
		table_2.getColumnModel().getColumn(2).setMaxWidth(60);
		table_2.getColumnModel().getColumn(3).setPreferredWidth(140);
		table_2.getColumnModel().getColumn(3).setMinWidth(140);
		table_2.getColumnModel().getColumn(3).setMaxWidth(140);
		table_2.getColumnModel().getColumn(4).setPreferredWidth(30);
		table_2.getColumnModel().getColumn(4).setMinWidth(30);
		table_2.getColumnModel().getColumn(4).setMaxWidth(30);
		scrollPane_k2.setViewportView(table_2);
		panel_k5.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane_k3 = new JScrollPane();
		panel_k5.add(scrollPane_k3);
		
		table_3 = new JTable();
		table_3.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u94FE\u63A5", "\u94FE\u63A5\u540D\u79F0", "\u6253\u5F00\u65B9\u5F0F", "\u6765\u81EA\u7236\u94FE", ""
			}
		));
		table_3.getColumnModel().getColumn(0).setPreferredWidth(160);
		table_3.getColumnModel().getColumn(0).setMinWidth(160);
		table_3.getColumnModel().getColumn(0).setMaxWidth(160);
		table_3.getColumnModel().getColumn(1).setPreferredWidth(110);
		table_3.getColumnModel().getColumn(1).setMinWidth(110);
		table_3.getColumnModel().getColumn(1).setMaxWidth(110);
		table_3.getColumnModel().getColumn(2).setPreferredWidth(60);
		table_3.getColumnModel().getColumn(2).setMinWidth(60);
		table_3.getColumnModel().getColumn(2).setMaxWidth(60);
		table_3.getColumnModel().getColumn(3).setPreferredWidth(130);
		table_3.getColumnModel().getColumn(3).setMinWidth(130);
		table_3.getColumnModel().getColumn(3).setMaxWidth(130);
		table_3.getColumnModel().getColumn(4).setPreferredWidth(30);
		table_3.getColumnModel().getColumn(4).setMinWidth(30);
		table_3.getColumnModel().getColumn(4).setMaxWidth(30);
		scrollPane_k3.setViewportView(table_3);
		panel_k2.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane_k1 = new JScrollPane();
		panel_k2.add(scrollPane_k1);
		
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u94FE\u63A5", "\u94FE\u63A5\u540D\u79F0", "\u6253\u5F00\u65B9\u5F0F", "\u6765\u81EA\u7236\u94FE", ""
			}
		));
		table_1.getColumnModel().getColumn(0).setPreferredWidth(150);
		table_1.getColumnModel().getColumn(0).setMinWidth(150);
		table_1.getColumnModel().getColumn(0).setMaxWidth(150);
		table_1.getColumnModel().getColumn(1).setPreferredWidth(100);
		table_1.getColumnModel().getColumn(1).setMinWidth(100);
		table_1.getColumnModel().getColumn(1).setMaxWidth(100);
		table_1.getColumnModel().getColumn(2).setPreferredWidth(60);
		table_1.getColumnModel().getColumn(2).setMinWidth(60);
		table_1.getColumnModel().getColumn(2).setMaxWidth(60);
		table_1.getColumnModel().getColumn(3).setPreferredWidth(150);
		table_1.getColumnModel().getColumn(3).setMinWidth(150);
		table_1.getColumnModel().getColumn(3).setMaxWidth(150);
		table_1.getColumnModel().getColumn(4).setPreferredWidth(30);
		table_1.getColumnModel().getColumn(4).setMinWidth(30);
		table_1.getColumnModel().getColumn(4).setMaxWidth(30);
		scrollPane_k1.setViewportView(table_1);
		
		JScrollPane scrollPane_k4 = new JScrollPane();
		GroupLayout gl_panel_k1 = new GroupLayout(panel_k1);
		gl_panel_k1.setHorizontalGroup(
			gl_panel_k1.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane_k4, GroupLayout.PREFERRED_SIZE, 521, GroupLayout.PREFERRED_SIZE)
		);
		gl_panel_k1.setVerticalGroup(
			gl_panel_k1.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane_k4, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE)
		);
		
		table_5 = new JTable();
		table_5.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u94FE\u63A5", "\u94FE\u63A5\u540D\u79F0", "\u6253\u5F00\u65B9\u5F0F", "\u6765\u81EA\u7236\u94FE", ""
			}
		));
		table_5.getColumnModel().getColumn(0).setPreferredWidth(135);
		table_5.getColumnModel().getColumn(0).setMinWidth(135);
		table_5.getColumnModel().getColumn(0).setMaxWidth(135);
		table_5.getColumnModel().getColumn(1).setPreferredWidth(135);
		table_5.getColumnModel().getColumn(1).setMinWidth(135);
		table_5.getColumnModel().getColumn(1).setMaxWidth(135);
		table_5.getColumnModel().getColumn(2).setPreferredWidth(60);
		table_5.getColumnModel().getColumn(2).setMinWidth(60);
		table_5.getColumnModel().getColumn(2).setMaxWidth(60);
		table_5.getColumnModel().getColumn(3).setPreferredWidth(130);
		table_5.getColumnModel().getColumn(3).setMinWidth(130);
		table_5.getColumnModel().getColumn(3).setMaxWidth(130);
		table_5.getColumnModel().getColumn(4).setPreferredWidth(30);
		table_5.getColumnModel().getColumn(4).setMinWidth(30);
		table_5.getColumnModel().getColumn(4).setMaxWidth(30);
		scrollPane_k4.setViewportView(table_5);
		panel_k1.setLayout(gl_panel_k1);
		panel_k.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane_k = new JScrollPane();
		panel_k.add(scrollPane_k);
		
		table_k = new JTable();
		table_k.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u94FE\u63A5", "\u94FE\u63A5\u540D\u79F0", "\u6253\u5F00\u65B9\u5F0F", "\u6765\u81EA\u7236\u94FE", ""
			}
		));
		table_k.getColumnModel().getColumn(0).setPreferredWidth(60);
		table_k.getColumnModel().getColumn(0).setMinWidth(60);
		table_k.getColumnModel().getColumn(0).setMaxWidth(60);
		table_k.getColumnModel().getColumn(1).setPreferredWidth(130);
		table_k.getColumnModel().getColumn(1).setMinWidth(130);
		table_k.getColumnModel().getColumn(1).setMaxWidth(130);
		table_k.getColumnModel().getColumn(2).setPreferredWidth(80);
		table_k.getColumnModel().getColumn(2).setMinWidth(80);
		table_k.getColumnModel().getColumn(2).setMaxWidth(80);
		table_k.getColumnModel().getColumn(3).setPreferredWidth(190);
		table_k.getColumnModel().getColumn(3).setMinWidth(190);
		table_k.getColumnModel().getColumn(3).setMaxWidth(190);
		table_k.getColumnModel().getColumn(4).setPreferredWidth(30);
		table_k.getColumnModel().getColumn(4).setMinWidth(30);
		table_k.getColumnModel().getColumn(4).setMaxWidth(30);
		scrollPane_k.setViewportView(table_k);
		frame2.getContentPane().setLayout(groupLayout);
		frame2.setVisible(true);
	}
	public static void main(String args[]) throws IOException
	{

		   URL u = new URL ( "http://www.example.com/" ); 
		   HttpURLConnection huc =  ( HttpURLConnection )  u.openConnection (); 
		   huc.setRequestMethod ("GET"); 
		   huc.connect () ; 
		   int code = huc.getResponseCode ();
		   System.out.print(code);
		    zzbds dd= new zzbds();
	}
}
