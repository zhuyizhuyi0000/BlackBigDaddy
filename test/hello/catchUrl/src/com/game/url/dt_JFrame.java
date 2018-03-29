package com.game.url;

import com.game.p.LinkState;
import com.game.url.catchUrl;
import com.game.url.catchUrl_dy;
import java.awt.Component;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import javax.swing.*; 
import javax.swing.plaf.FontUIResource;

import java.awt.Color;
import java.awt.BorderLayout;
import java.util.Enumeration;
import java.util.Iterator;
import java.awt.GridLayout;
import javax.swing.GroupLayout.Alignment;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.FlowLayout;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class dt_JFrame extends JFrame {
	
	int width =Toolkit.getDefaultToolkit().getScreenSize().width;
	int height =Toolkit.getDefaultToolkit().getScreenSize().height;
	private JTextField textField_gw;
	private JTextField txtHttp;
	private JButton button;
	private JComboBox comboBox_pt;
	private static String gwgw = "";
	private static String gwhtmlgw = "";
	private static String pt = "";
	private static String htmlcx = "";
	private static String dyym = "";
	private static String dylj = "";
	private static JTextField textField_allList;
	private static JTextField textField_allLink;
	private static JTextField textField_lbList;
	private static JTextArea textArea;
	private static JTextArea textArea_1;
	private static JTable table;
	private static JTable table_gwgw;
	private static JTable table_can;
	private static JTable table_fpt;
	private static JButton btnNewButton_save;
	private static JButton btnNewButton_news;
	private static JButton button_dyjg;
	private static JTable table_k;
	private static JTable table_1;
	private static JTable table_2;
	private static JTable table_3;
	private static JTable table_4;
	private static JTable table_5;
	private static JTable table_6;
	private JFrame frame2;
	private static JProgressBar progressBar;
	private static JProgressBar progressBar_dy;
	private JTextField textField_dylj;
	private JTextField textField_dycx;
	private JTextField textField_dyym;
	private static JTable table_dyall;
	private static JTable table_gjz;
	private static JTable table_dybh;
	private static JTable table_dybbh;
	private static JTextField textField;
	private static JTextArea textArea_2;
	/**
	 * @throws HeadlessException
	 */
	public dt_JFrame() throws HeadlessException
		{
		
		this.setTitle("工具");
		this.setSize(1010,630);
		this.setLocation((width-1010)/2, (height-630)/2);
		this.setResizable(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		
		
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(tabbedPane, GroupLayout.DEFAULT_SIZE, 1006, Short.MAX_VALUE)
					.addGap(3))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(tabbedPane, GroupLayout.DEFAULT_SIZE, 588, Short.MAX_VALUE)
					.addGap(0))
		);
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("官网链接检查工具", null, panel_3, null);
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "\u67E5\u8BE2\u9879", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 70, 213)));
		
		comboBox_pt = new JComboBox();
		comboBox_pt.setModel(new DefaultComboBoxModel(new String[] {"\u8BF7\u9009\u62E9\u6240\u5C5E\u5E73\u53F0\uFF1A", "http://youxi.baidu.com", "http://game.skycn.com"}));
		
		JLabel label = new JLabel("\u6240\u5C5E\u5E73\u53F0\uFF1A");
		
		JLabel label_1 = new JLabel("\u6E38\u620F\u7F29\u5199\uFF1A");
		label_1.setToolTipText("\u53EF\u4EE5\u4E0E\u94FE\u63A5\u4E2D\u7F29\u5199\u4E0D\u4E00\u81F4\uFF0C\u4EE5\u4FDD\u8BC1\u53EF\u4E0E\u7F16\u8F91\u786E\u8BA4\u7684\u6E38\u620F\u7F29\u5199\u4E00\u81F4");
		
		textField_gw = new JTextField();
		textField_gw.setToolTipText("\u53EF\u4EE5\u4E0E\u94FE\u63A5\u4E2D\u7F29\u5199\u4E0D\u4E00\u81F4\uFF0C\u4EE5\u4FDD\u8BC1\u53EF\u4E0E\u7F16\u8F91\u786E\u8BA4\u7684\u6E38\u620F\u7F29\u5199\u4E00\u81F4");
		textField_gw.setColumns(10);
		
		JLabel label_2 = new JLabel("\u5B98\u7F51\u94FE\u63A5\uFF1A");
		label_2.setToolTipText("\u8BF7\u4EE5\u201Chttp://\u201D\u5F00\u5934\uFF0C\u4EE5\u201C/\u201D\u7ED3\u5C3E\uFF0C\u5982\u201Chttp://youxi.baidu.com/hp/index/\u201D");
		
		JLabel lblzqhpxzcq = new JLabel("\u5982\uFF1Azq\u3001hp\u3001xzcq");
		lblzqhpxzcq.setForeground(Color.RED);
		
		txtHttp = new JTextField();
		txtHttp.setToolTipText("\u8BF7\u4EE5\u201Chttp://\u201D\u5F00\u5934\uFF0C\u4EE5\u201C/\u201D\u7ED3\u5C3E\uFF0C\u5982\u201Chttp://youxi.baidu.com/hp/index/\u201D");
		txtHttp.setText("http://");
		txtHttp.setColumns(10);
		
		button = new JButton("\u5F00\u59CB\u67E5\u8BE2");
		button.setToolTipText("\u8BF7\u5B8C\u6574\u8F93\u5165\u5B98\u7F51\u7F51\u5740\u3001\u6E38\u620F\u7F29\u5199\u53CA\u6240\u5C5E\u5E73\u53F0");
		button.addActionListener(new ActionListener() {                //按钮飞起
			public void actionPerformed(ActionEvent e) {
				gwhtmlgw = txtHttp.getText();
				gwgw = textField_gw.getText();
				pt =comboBox_pt.getSelectedItem().toString();
				if(gwhtmlgw.equals("") || gwhtmlgw == null || gwhtmlgw.length() <= 0 ){
					JOptionPane.showMessageDialog(null,"官网链接不能为空");
				}else if(!catchUrl.isHTML(gwhtmlgw)){
					JOptionPane.showMessageDialog(null,"填入的官网链接不是链接或缺少http://");
				}else if(!catchUrl.isGWHTML(gwhtmlgw)){
					JOptionPane.showMessageDialog(null,"不符合官网格式，或没有以/结尾");
				}else if(gwgw.equals("") || gwgw == null || gwgw.length() <= 0){
					JOptionPane.showMessageDialog(null,"游戏缩写不能为空");
				}else if(pt.equals("\u8BF7\u9009\u62E9\u6240\u5C5E\u5E73\u53F0\uFF1A")){
					JOptionPane.showMessageDialog(null,"请选择平台");
				}else {
							catchUrl q =new catchUrl();
							Thread t=new Thread(q);
							t.start();	
							progressBar.setStringPainted(true);
							System.out.println("start..");
							
				}
			}
		});
		
		JLabel label_3 = new JLabel("\u8BF7\u4EE5\u201C/\u201D\u7ED3\u5C3E");
		label_3.setForeground(Color.RED);
		
			
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(label)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(comboBox_pt, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(label_1)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(textField_gw, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblzqhpxzcq))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(label_2)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(txtHttp)))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(label_3)
							.addGap(26))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(13)
							.addComponent(button, GroupLayout.PREFERRED_SIZE, 73, Short.MAX_VALUE)
							.addGap(18))))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_2)
						.addComponent(txtHttp, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_3))
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(18)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(label_1)
								.addComponent(textField_gw, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblzqhpxzcq))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(label)
								.addComponent(comboBox_pt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_panel.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(button, GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE)))
					.addContainerGap())
		);
		panel.setLayout(gl_panel);
		JPanel panel_jd = new JPanel();
		panel_jd.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "\u8FDB\u5EA6\u6761", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 70, 213)));
		
		progressBar = new JProgressBar();
		GroupLayout gl_panel_jd = new GroupLayout(panel_jd);
		gl_panel_jd.setHorizontalGroup(
			gl_panel_jd.createParallelGroup(Alignment.LEADING)
				.addComponent(progressBar, GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE)
		);
		gl_panel_jd.setVerticalGroup(
			gl_panel_jd.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_jd.createSequentialGroup()
					.addComponent(progressBar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel_jd.setLayout(gl_panel_jd);
		
		btnNewButton_news = new JButton("\u67E5\u770B\u8BE6\u7EC6");
		btnNewButton_news.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				frame2.setVisible(true);
				
			}
		});
		btnNewButton_news.setEnabled(false);
		
		btnNewButton_save = new JButton("\u7ED3\u679C\u5BFC\u51FA");
		btnNewButton_save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				/////////////////////
				saveFile();
			}
		});
		btnNewButton_save.setEnabled(false);
		
		JPanel panel_tj = new JPanel();
		panel_tj.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "\u7ED3\u679C\u7EDF\u8BA1", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 70, 213)));
		
		JLabel lblNewLabel = new JLabel("\u6355\u6349\u94FE\u63A5");
		lblNewLabel.setToolTipText("\u4E00\u5171\u6355\u6349\u5230\u7684\u6240\u6709\u94FE\u63A5");
		
		JLabel lblNewLabel_1 = new JLabel("\u6761   \u5B98\u7F51\u57DF\u4E0B\u94FE\u63A5");
		lblNewLabel_1.setToolTipText("\u6E38\u620F\u5E73\u53F0\u5B98\u7F51\u57DF\u4E0B\u7684\u6240\u6709\u94FE\u63A5");
		
		JLabel lblNewLabel_2 = new JLabel("\u6761  \u5217\u8868\u9875&\u6587\u7AE0\u9875");
		lblNewLabel_2.setToolTipText("\u5217\u8868\u9875\u53CA\u62BD\u6D4B\u76845\u4E2A\u6587\u7AE0\u9875");
		
		textField_allList = new JTextField();
		textField_allList.setToolTipText("\u4E00\u5171\u6355\u6349\u5230\u7684\u6240\u6709\u94FE\u63A5");
		textField_allList.setEditable(false);
		textField_allList.setColumns(3);
		
		textField_allLink = new JTextField();
		textField_allLink.setToolTipText("\u6E38\u620F\u5E73\u53F0\u5B98\u7F51\u57DF\u4E0B\u7684\u6240\u6709\u94FE\u63A5");
		textField_allLink.setEditable(false);
		textField_allLink.setColumns(2);
		
		textField_lbList = new JTextField();
		textField_lbList.setToolTipText("\u5217\u8868\u9875\u53CA\u62BD\u6D4B\u76845\u4E2A\u6587\u7AE0\u9875");
		textField_lbList.setEditable(false);
		textField_lbList.setColumns(2);
		
		JLabel label_6 = new JLabel("\u6761");
		GroupLayout gl_panel_tj = new GroupLayout(panel_tj);
		gl_panel_tj.setHorizontalGroup(
			gl_panel_tj.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_tj.createSequentialGroup()
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textField_allList, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel_1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textField_allLink, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel_2)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textField_lbList, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(label_6, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(31, Short.MAX_VALUE))
		);
		gl_panel_tj.setVerticalGroup(
			gl_panel_tj.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_tj.createSequentialGroup()
					.addGap(8)
					.addGroup(gl_panel_tj.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(textField_allList, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1)
						.addComponent(textField_allLink, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_2)
						.addComponent(textField_lbList, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_6))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel_tj.setLayout(gl_panel_tj);
		JPanel panel_yc = new JPanel();
		panel_yc.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "\u5F02\u5E38\u3001\u6B7B\u94FE\u4EE5\u53CA\u672A\u68C0\u6D4B\u7684\u5F85\u6D4B\u8BD5\u9875", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 70, 213)));
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_panel_yc = new GroupLayout(panel_yc);
		gl_panel_yc.setHorizontalGroup(
			gl_panel_yc.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 394, Short.MAX_VALUE)
		);
		gl_panel_yc.setVerticalGroup(
			gl_panel_yc.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_yc.createSequentialGroup()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		
		textArea = new JTextArea();
		textArea.setEditable(false);
		scrollPane.setViewportView(textArea);
		panel_yc.setLayout(gl_panel_yc);
		
		JPanel panel_zc = new JPanel();
		panel_zc.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "\u5B98\u7F51\u57DF\u4E0B\u518D\u6B21\u62BD\u6D4B\u6293\u53D6\u7684\u9875\u9762", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 70, 213)));
		panel_zc.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane_1 = new JScrollPane();
		panel_zc.add(scrollPane_1);
		
		textArea_1 = new JTextArea();
		textArea_1.setEditable(false);
		scrollPane_1.setViewportView(textArea_1);
		
		JPanel panel_kl = new JPanel();
		panel_kl.setToolTipText("99\u8868\u793A\uFF1A\u7A7A\u94FE\u63A5\uFF1B88\u8868\u793A\uFF1A\u94FE\u63A5\u4E0D\u7B26\u5408html\u683C\u5F0F");
		panel_kl.setForeground(Color.BLACK);
		panel_kl.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "\u7A7A\u94FE\u63A5\u6216\u975E\u6B63\u5E38\u7F51\u5740", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 70, 213)));
		panel_kl.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setToolTipText("99\u8868\u793A\uFF1A\u7A7A\u94FE\u63A5\uFF1B88\u8868\u793A\uFF1A\u94FE\u63A5\u4E0D\u7B26\u5408html\u683C\u5F0F");
		panel_kl.add(scrollPane_2);
		
		table = new JTable();
		table.setToolTipText("99\u8868\u793A\uFF1A\u7A7A\u94FE\u63A5\uFF1B88\u8868\u793A\uFF1A\u94FE\u63A5\u4E0D\u7B26\u5408html\u683C\u5F0F");
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u94FE\u63A5", "\u94FE\u63A5\u540D\u79F0", "\u6765\u81EA\u7236\u94FE", "\u6253\u5F00\u65B9\u6CD5", ""
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(60);
		table.getColumnModel().getColumn(0).setMinWidth(2);
		table.getColumnModel().getColumn(1).setPreferredWidth(80);
		table.getColumnModel().getColumn(1).setMinWidth(8);
		table.getColumnModel().getColumn(2).setPreferredWidth(260);
		table.getColumnModel().getColumn(2).setMinWidth(26);
		table.getColumnModel().getColumn(3).setPreferredWidth(60);
		table.getColumnModel().getColumn(3).setMinWidth(6);
		table.getColumnModel().getColumn(4).setPreferredWidth(30);
		table.getColumnModel().getColumn(4).setMinWidth(3);
		scrollPane_2.setViewportView(table);
		
		JPanel panel_pt = new JPanel();
		panel_pt.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "\u975E\u6E38\u620F\u5E73\u53F0\u57DF\u5185\u94FE\u63A5", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 70, 213)));
		
		JScrollPane scrollPane_3 = new JScrollPane();
		GroupLayout gl_panel_pt = new GroupLayout(panel_pt);
		gl_panel_pt.setHorizontalGroup(
			gl_panel_pt.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane_3, GroupLayout.DEFAULT_SIZE, 548, Short.MAX_VALUE)
		);
		gl_panel_pt.setVerticalGroup(
			gl_panel_pt.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane_3, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
		);
		
		table_fpt = new JTable();
		table_fpt.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u94FE\u63A5", "\u94FE\u63A5\u540D\u79F0", "\u6765\u81EA\u7236\u94FE", "\u6253\u5F00\u65B9\u5F0F", ""
			}
		));
		table_fpt.getColumnModel().getColumn(0).setPreferredWidth(160);
		table_fpt.getColumnModel().getColumn(0).setMinWidth(16);
		table_fpt.getColumnModel().getColumn(1).setPreferredWidth(80);
		table_fpt.getColumnModel().getColumn(1).setMinWidth(8);
		table_fpt.getColumnModel().getColumn(2).setPreferredWidth(160);
		table_fpt.getColumnModel().getColumn(2).setMinWidth(16);
		table_fpt.getColumnModel().getColumn(3).setPreferredWidth(60);
		table_fpt.getColumnModel().getColumn(3).setMinWidth(6);
		table_fpt.getColumnModel().getColumn(4).setPreferredWidth(30);
		table_fpt.getColumnModel().getColumn(4).setMinWidth(3);
		table_fpt.setToolTipText("7\u8868\u793A\u542B\u201C\uFF1F\u201D\u53C2\u6570\uFF1B8\u8868\u793A\u5E73\u53F0\u5185\u975E\u5B98\u7F51\u57DF\u4E0B\u94FE\u63A5");
		scrollPane_3.setViewportView(table_fpt);
		panel_pt.setLayout(gl_panel_pt);
		
		JPanel panel_1 = new JPanel();
		panel_1.setToolTipText("7\u8868\u793A\u542B\u201C\uFF1F\u201D\u53C2\u6570\uFF1B8\u8868\u793A\u5E73\u53F0\u5185\u975E\u5B98\u7F51\u57DF\u4E0B\u94FE\u63A5");
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "\u542B\u201C\uFF1F\u201D\u53C2\u6570\u53CA\u5E73\u53F0\u5185\u975E\u5B98\u7F51\u57DF\u4E0B\u94FE\u63A5", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 70, 213)));
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane_4 = new JScrollPane();
		scrollPane_4.setToolTipText("7\u8868\u793A\u542B\u201C\uFF1F\u201D\u53C2\u6570\uFF1B8\u8868\u793A\u5E73\u53F0\u5185\u975E\u5B98\u7F51\u57DF\u4E0B\u94FE\u63A5");
		panel_1.add(scrollPane_4);
		
		table_can = new JTable();
		table_can.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u94FE\u63A5", "\u94FE\u63A5\u540D\u79F0", "\u6765\u81EA\u7236\u94FE", "\u6253\u5F00\u65B9\u5F0F", ""
			}
		));
		table_can.getColumnModel().getColumn(0).setPreferredWidth(160);
		table_can.getColumnModel().getColumn(0).setMinWidth(16);
		table_can.getColumnModel().getColumn(1).setPreferredWidth(80);
		table_can.getColumnModel().getColumn(1).setMinWidth(8);
		table_can.getColumnModel().getColumn(2).setPreferredWidth(160);
		table_can.getColumnModel().getColumn(2).setMinWidth(16);
		table_can.getColumnModel().getColumn(3).setPreferredWidth(60);
		table_can.getColumnModel().getColumn(3).setMinWidth(6);
		table_can.getColumnModel().getColumn(4).setPreferredWidth(30);
		table_can.getColumnModel().getColumn(4).setMinWidth(3);
		table_can.setToolTipText("7\u8868\u793A\u542B\u201C\uFF1F\u201D\u53C2\u6570\uFF1B8\u8868\u793A\u5E73\u53F0\u5185\u975E\u5B98\u7F51\u57DF\u4E0B\u94FE\u63A5");
		scrollPane_4.setViewportView(table_can);
		
		JPanel panel_2 = new JPanel();
		panel_2.setToolTipText("1\u8868\u793A\u5217\u8868\u9875\uFF1B2\u8868\u793A\u6587\u7AE0\u9875\uFF1B3\u8868\u793A\u6E38\u620F\u7F29\u5199\u540E\u6709\u5176\u4ED6\u4E1C\u897F\u7684\u94FE\u63A5");
		panel_2.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "\u5B98\u7F51\u5185\u94FE\u63A5", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 70, 213)));
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane_5 = new JScrollPane();
		scrollPane_5.setToolTipText("1\u8868\u793A\u5217\u8868\u9875\uFF1B2\u8868\u793A\u6587\u7AE0\u9875\uFF1B3\u8868\u793A\u6E38\u620F\u7F29\u5199\u540E\u6709\u5176\u4ED6\u4E1C\u897F\u7684\u94FE\u63A5");
		panel_2.add(scrollPane_5);
		
		table_gwgw = new JTable();
		table_gwgw.setToolTipText("1\u8868\u793A\u5217\u8868\u9875\uFF1B2\u8868\u793A\u6587\u7AE0\u9875\uFF1B3\u8868\u793A\u6E38\u620F\u7F29\u5199\u540E\u6709\u5176\u4ED6\u4E1C\u897F\u7684\u94FE\u63A5");
		table_gwgw.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u94FE\u63A5", "\u94FE\u63A5\u540D\u79F0", "\u6765\u81EA\u7236\u94FE", "\u6253\u5F00\u65B9\u5F0F", ""
			}
		));
		table_gwgw.getColumnModel().getColumn(0).setPreferredWidth(160);
		table_gwgw.getColumnModel().getColumn(0).setMinWidth(16);
		table_gwgw.getColumnModel().getColumn(1).setPreferredWidth(80);
		table_gwgw.getColumnModel().getColumn(1).setMinWidth(8);
		table_gwgw.getColumnModel().getColumn(2).setPreferredWidth(160);
		table_gwgw.getColumnModel().getColumn(2).setMinWidth(16);
		table_gwgw.getColumnModel().getColumn(3).setPreferredWidth(60);
		table_gwgw.getColumnModel().getColumn(3).setMinWidth(6);
		table_gwgw.getColumnModel().getColumn(4).setPreferredWidth(30);
		table_gwgw.getColumnModel().getColumn(4).setMinWidth(3);
		scrollPane_5.setViewportView(table_gwgw);
		GroupLayout gl_panel_3 = new GroupLayout(panel_3);
		gl_panel_3.setHorizontalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addGroup(gl_panel_3.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel_zc, GroupLayout.DEFAULT_SIZE, 418, Short.MAX_VALUE)
						.addComponent(panel_tj, GroupLayout.DEFAULT_SIZE, 418, Short.MAX_VALUE)
						.addComponent(panel_yc, 0, 0, Short.MAX_VALUE)
						.addGroup(gl_panel_3.createSequentialGroup()
							.addGroup(gl_panel_3.createParallelGroup(Alignment.TRAILING)
								.addComponent(panel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE)
								.addGroup(gl_panel_3.createSequentialGroup()
									.addComponent(panel_jd, GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnNewButton_news, GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnNewButton_save, GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE)))
							.addGap(4)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 560, Short.MAX_VALUE)
						.addComponent(panel_pt, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 560, Short.MAX_VALUE)
						.addComponent(panel_kl, GroupLayout.DEFAULT_SIZE, 560, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panel_3.setVerticalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addGroup(gl_panel_3.createParallelGroup(Alignment.BASELINE)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel_kl, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_panel_3.createSequentialGroup()
							.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
								.addComponent(panel_jd, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_panel_3.createSequentialGroup()
									.addGap(13)
									.addGroup(gl_panel_3.createParallelGroup(Alignment.BASELINE)
										.addComponent(btnNewButton_news)
										.addComponent(btnNewButton_save))))
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(panel_tj, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE))
						.addComponent(panel_pt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(10)
					.addGroup(gl_panel_3.createParallelGroup(Alignment.BASELINE)
						.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel_yc, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_3.createParallelGroup(Alignment.BASELINE)
						.addComponent(panel_zc, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(37, Short.MAX_VALUE))
		);
		panel_3.setLayout(gl_panel_3);
		
		JPanel panel_4 = new JPanel();
		tabbedPane.addTab("单一页面链接检查", null, panel_4, null);
		
		JPanel panel_dycx = new JPanel();
		panel_dycx.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "\u67E5\u8BE2\u9879", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 70, 213)));
		
		JLabel label_5 = new JLabel("\u94FE\u63A5\u4E2D\u5173\u952E\u5B57\uFF1A");
		label_5.setToolTipText("\u5173\u952E\u5B57\u662F\u4E3A\u7ED3\u679C\u5206\u7C7B\uFF0C\u4E0D\u5F71\u54CD\u6240\u6709\u94FE\u63A5\u6293\u53D6");
		
		textField_dylj = new JTextField();
		textField_dylj.setToolTipText("\u5173\u952E\u5B57\u662F\u4E3A\u7ED3\u679C\u5206\u7C7B\uFF0C\u4E0D\u5F71\u54CD\u6240\u6709\u94FE\u63A5\u6293\u53D6");
		textField_dylj.setColumns(10);
		
		JLabel label_8 = new JLabel("\u67E5\u8BE2\u94FE\u63A5\uFF1A");
		label_8.setToolTipText("\u8BF7\u4EE5\u201Chttp://\u201D\u5F00\u5934");
		
		textField_dycx = new JTextField();
		textField_dycx.setToolTipText("\u8BF7\u4EE5\u201Chttp://\u201D\u5F00\u5934");
		textField_dycx.setText("http://");
		textField_dycx.setColumns(10);
		
		JLabel label_4 = new JLabel("\u9875\u9762\u4E2D\u5173\u952E\u5B57\uFF1A");
		label_4.setToolTipText("\u5173\u952E\u5B57\u662F\u4E3A\u7ED3\u679C\u5206\u7C7B\uFF0C\u4E0D\u5F71\u54CD\u6240\u6709\u94FE\u63A5\u6293\u53D6");
		
		textField_dyym = new JTextField();
		textField_dyym.setToolTipText("\u5173\u952E\u5B57\u662F\u4E3A\u7ED3\u679C\u5206\u7C7B\uFF0C\u4E0D\u5F71\u54CD\u6240\u6709\u94FE\u63A5\u6293\u53D6");
		textField_dyym.setColumns(10);
		
		JLabel lblyouxibaiducomhpzq = new JLabel("\u5982\uFF1Ayouxi.baidu.com");
		lblyouxibaiducomhpzq.setForeground(Color.RED);
		
		JLabel label_7 = new JLabel("\u5982\uFF1A\u79EF\u5206\u3001\u91D1\u8C46");
		label_7.setForeground(Color.RED);
		
		JButton button_dy = new JButton("\u5F00\u59CB\u67E5\u8BE2");
		button_dy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				htmlcx = textField_dycx.getText();
				dylj = textField_dylj.getText();
				dyym = textField_dyym.getText();
				if(htmlcx.equals("") || htmlcx == null || htmlcx.length() <= 0 ){
					JOptionPane.showMessageDialog(null,"不能为空");
				}else if(!catchUrl_dy.isHTML(htmlcx)){
					JOptionPane.showMessageDialog(null,"填入的链接不是链接或缺少http://");
				}else if(htmlcx.equals("http://")){
					JOptionPane.showMessageDialog(null,"填入的链接");
				}else{
					catchUrl_dy w =new catchUrl_dy();
					Thread f=new Thread(w);
					f.start();	
//							progressBar_dy.setStringPainted(true);
							System.out.println("start..");
			}
			}
		}
		);
		button_dy.setToolTipText("\u8BF7\u5B8C\u6574\u8F93\u5165\u5B98\u7F51\u7F51\u5740\u3001\u6E38\u620F\u7F29\u5199\u53CA\u6240\u5C5E\u5E73\u53F0");
		GroupLayout gl_panel_dycx = new GroupLayout(panel_dycx);
		gl_panel_dycx.setHorizontalGroup(
			gl_panel_dycx.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_dycx.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_dycx.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_panel_dycx.createSequentialGroup()
							.addGroup(gl_panel_dycx.createParallelGroup(Alignment.LEADING)
								.addComponent(label_8)
								.addComponent(label_5))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel_dycx.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_panel_dycx.createSequentialGroup()
									.addGroup(gl_panel_dycx.createParallelGroup(Alignment.LEADING)
										.addComponent(textField_dyym, GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE)
										.addComponent(textField_dylj, GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE))
									.addGap(18)
									.addGroup(gl_panel_dycx.createParallelGroup(Alignment.LEADING)
										.addComponent(lblyouxibaiducomhpzq, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE)
										.addComponent(label_7, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)))
								.addComponent(textField_dycx, GroupLayout.PREFERRED_SIZE, 191, GroupLayout.PREFERRED_SIZE)))
						.addComponent(label_4))
					.addGap(18)
					.addComponent(button_dy)
					.addGap(22))
		);
		gl_panel_dycx.setVerticalGroup(
			gl_panel_dycx.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_dycx.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_dycx.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_dycx.createSequentialGroup()
							.addGroup(gl_panel_dycx.createParallelGroup(Alignment.BASELINE)
								.addComponent(label_8)
								.addComponent(textField_dycx, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panel_dycx.createParallelGroup(Alignment.BASELINE)
								.addComponent(label_5)
								.addComponent(textField_dylj, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblyouxibaiducomhpzq))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panel_dycx.createParallelGroup(Alignment.BASELINE)
								.addComponent(label_4)
								.addComponent(textField_dyym, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_7)))
						.addComponent(button_dy, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel_dycx.setLayout(gl_panel_dycx);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "\u8FDB\u5EA6", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 70, 213)));
		
		progressBar_dy = new JProgressBar();
		GroupLayout gl_panel_6 = new GroupLayout(panel_6);
		gl_panel_6.setHorizontalGroup(
			gl_panel_6.createParallelGroup(Alignment.LEADING)
				.addGap(0, 240, Short.MAX_VALUE)
				.addComponent(progressBar_dy, GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE)
		);
		gl_panel_6.setVerticalGroup(
			gl_panel_6.createParallelGroup(Alignment.LEADING)
				.addGap(0, 46, Short.MAX_VALUE)
				.addGroup(gl_panel_6.createSequentialGroup()
					.addComponent(progressBar_dy, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel_6.setLayout(gl_panel_6);
		
		button_dyjg = new JButton("\u5BFC\u51FA\u7ED3\u679C");
		button_dyjg.setEnabled(false);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "\u5F02\u5E38\u3001\u6B7B\u94FE\u4EE5\u53CA\u672A\u68C0\u6D4B\u7684\u5F85\u6D4B\u8BD5\u9875", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 70, 213)));
		
		JScrollPane scrollPane_6 = new JScrollPane();
		GroupLayout gl_panel_7 = new GroupLayout(panel_7);
		gl_panel_7.setHorizontalGroup(
			gl_panel_7.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane_6, GroupLayout.DEFAULT_SIZE, 406, Short.MAX_VALUE)
		);
		gl_panel_7.setVerticalGroup(
			gl_panel_7.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_7.createSequentialGroup()
					.addComponent(scrollPane_6, GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
					.addGap(0))
		);
		
		textArea_2 = new JTextArea();
		textArea_2.setEditable(false);
		scrollPane_6.setViewportView(textArea_2);
		panel_7.setLayout(gl_panel_7);
		
		JPanel panel_8 = new JPanel();
		panel_8.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "\u6355\u83B7\u94FE\u63A5", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 70, 213)));
		
		JScrollPane scrollPane_7 = new JScrollPane();
		GroupLayout gl_panel_8 = new GroupLayout(panel_8);
		gl_panel_8.setHorizontalGroup(
			gl_panel_8.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane_7, GroupLayout.DEFAULT_SIZE, 447, Short.MAX_VALUE)
		);
		gl_panel_8.setVerticalGroup(
			gl_panel_8.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane_7, GroupLayout.DEFAULT_SIZE, 373, Short.MAX_VALUE)
		);
		
		table_dyall = new JTable();
		table_dyall.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u94FE\u63A5", "\u94FE\u63A5\u540D", "\u6253\u5F00\u65B9\u5F0F"
			}
		));
		table_dyall.getColumnModel().getColumn(0).setPreferredWidth(225);
		table_dyall.getColumnModel().getColumn(0).setMinWidth(18);
		table_dyall.getColumnModel().getColumn(1).setPreferredWidth(160);
		table_dyall.getColumnModel().getColumn(2).setPreferredWidth(45);
		table_dyall.getColumnModel().getColumn(2).setMinWidth(6);
		scrollPane_7.setViewportView(table_dyall);
		panel_8.setLayout(gl_panel_8);
		
		JPanel panel_9 = new JPanel();
		panel_9.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "\u4E0D\u5305\u542B\u5173\u952E\u5B57\u7684\u94FE\u63A5", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 70, 213)));
		
		JScrollPane scrollPane_8 = new JScrollPane();
		GroupLayout gl_panel_9 = new GroupLayout(panel_9);
		gl_panel_9.setHorizontalGroup(
			gl_panel_9.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane_8, GroupLayout.DEFAULT_SIZE, 447, Short.MAX_VALUE)
		);
		gl_panel_9.setVerticalGroup(
			gl_panel_9.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane_8, GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
		);
		
		table_dybbh = new JTable();
		table_dybbh.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u94FE\u63A5", "\u94FE\u63A5\u540D", "\u6253\u5F00\u65B9\u5F0F"
			}
		));
		table_dybbh.getColumnModel().getColumn(0).setPreferredWidth(225);
		table_dybbh.getColumnModel().getColumn(1).setPreferredWidth(185);
		table_dybbh.getColumnModel().getColumn(2).setPreferredWidth(45);
		scrollPane_8.setViewportView(table_dybbh);
		panel_9.setLayout(gl_panel_9);
		
		JPanel panel_10 = new JPanel();
		panel_10.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "\u5305\u542B\u5173\u952E\u5B57\u7684\u94FE\u63A5", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 70, 213)));
		
		JScrollPane scrollPane_9 = new JScrollPane();
		GroupLayout gl_panel_10 = new GroupLayout(panel_10);
		gl_panel_10.setHorizontalGroup(
			gl_panel_10.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_10.createSequentialGroup()
					.addComponent(scrollPane_9, GroupLayout.DEFAULT_SIZE, 505, Short.MAX_VALUE)
					.addGap(2))
		);
		gl_panel_10.setVerticalGroup(
			gl_panel_10.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane_9, GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
		);
		
		table_dybh = new JTable();
		table_dybh.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u94FE\u63A5", "\u94FE\u63A5\u540D", "\u6253\u5F00\u65B9\u5F0F"
			}
		));
		table_dybh.getColumnModel().getColumn(0).setPreferredWidth(225);
		table_dybh.getColumnModel().getColumn(1).setPreferredWidth(185);
		table_dybh.getColumnModel().getColumn(2).setPreferredWidth(45);
		table_dybh.getColumnModel().getColumn(2).setMinWidth(6);
		scrollPane_9.setViewportView(table_dybh);
		panel_10.setLayout(gl_panel_10);
		
		JPanel panel_11 = new JPanel();
		panel_11.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "\u5173\u952E\u5B57", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 70, 213)));
		
		JScrollPane scrollPane_10 = new JScrollPane();
		GroupLayout gl_panel_11 = new GroupLayout(panel_11);
		gl_panel_11.setHorizontalGroup(
			gl_panel_11.createParallelGroup(Alignment.LEADING)
				.addGap(0, 459, Short.MAX_VALUE)
				.addComponent(scrollPane_10, GroupLayout.DEFAULT_SIZE, 447, Short.MAX_VALUE)
		);
		gl_panel_11.setVerticalGroup(
			gl_panel_11.createParallelGroup(Alignment.LEADING)
				.addGap(0, 112, Short.MAX_VALUE)
				.addGroup(gl_panel_11.createSequentialGroup()
					.addComponent(scrollPane_10, GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
					.addGap(0))
		);
		
		table_gjz = new JTable();
		table_gjz.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u5185\u5BB9", "\u6807\u7B7E"
			}
		));
		table_gjz.getColumnModel().getColumn(0).setPreferredWidth(165);
		table_gjz.getColumnModel().getColumn(1).setPreferredWidth(225);
		scrollPane_10.setViewportView(table_gjz);
		panel_11.setLayout(gl_panel_11);
		
		JLabel label_9 = new JLabel("\u5171\u6355\u83B7\u94FE\u63A5");
		label_9.setForeground(Color.BLACK);
		
		textField = new JTextField();
		textField.setToolTipText("\u4E00\u5171\u6355\u6349\u5230\u7684\u6240\u6709\u94FE\u63A5");
		textField.setEditable(false);
		textField.setColumns(3);
		
		JLabel label_10 = new JLabel("\u6761");
		label_10.setForeground(Color.BLACK);
		GroupLayout gl_panel_4 = new GroupLayout(panel_4);
		gl_panel_4.setHorizontalGroup(
			gl_panel_4.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_4.createSequentialGroup()
					.addGroup(gl_panel_4.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel_8, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(panel_dycx, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_4.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel_11, GroupLayout.DEFAULT_SIZE, 503, Short.MAX_VALUE)
						.addComponent(panel_10, 0, 0, Short.MAX_VALUE)
						.addComponent(panel_9, GroupLayout.DEFAULT_SIZE, 503, Short.MAX_VALUE)
						.addGroup(gl_panel_4.createSequentialGroup()
							.addComponent(panel_6, GroupLayout.DEFAULT_SIZE, 268, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(label_9)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(label_10, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(button_dyjg))
						.addComponent(panel_7, GroupLayout.DEFAULT_SIZE, 503, Short.MAX_VALUE))
					.addGap(26))
		);
		gl_panel_4.setVerticalGroup(
			gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_4.createSequentialGroup()
					.addGroup(gl_panel_4.createParallelGroup(Alignment.LEADING, false)
						.addComponent(panel_dycx, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel_4.createSequentialGroup()
							.addGroup(gl_panel_4.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_4.createSequentialGroup()
									.addGap(24)
									.addGroup(gl_panel_4.createParallelGroup(Alignment.BASELINE)
										.addComponent(button_dyjg)
										.addComponent(label_9)
										.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(label_10)))
								.addGroup(gl_panel_4.createSequentialGroup()
									.addContainerGap()
									.addComponent(panel_6, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(panel_7, 0, 0, Short.MAX_VALUE)))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_4.createParallelGroup(Alignment.BASELINE)
						.addComponent(panel_8, GroupLayout.DEFAULT_SIZE, 398, Short.MAX_VALUE)
						.addGroup(gl_panel_4.createSequentialGroup()
							.addGap(8)
							.addComponent(panel_9, GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(panel_10, GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
							.addGap(8)
							.addComponent(panel_11, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		panel_4.setLayout(gl_panel_4);
		
		JPanel panel_5 = new JPanel();
		tabbedPane.addTab("NEW TAB", null, panel_5, null);
		getContentPane().setLayout(groupLayout);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menu = new JMenu("\u83DC\u5355");
		menuBar.add(menu);
		
		JMenuItem menuItem = new JMenuItem("\u9000\u51FA");
		menu.add(menuItem);
	
		
		this.setVisible(true);

		//////////////
		frame2 = new JFrame();
		frame2.setTitle("详细结果");
		frame2.setSize(1100,700);
		frame2.setLocation((width-1100)/2, (height-700)/2);
		frame2.setResizable(true);
		frame2.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		
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
		GroupLayout groupLayout1 = new GroupLayout(frame2.getContentPane());
		groupLayout1.setHorizontalGroup(
			groupLayout1.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout1.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout1.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout1.createSequentialGroup()
							.addComponent(panel_k, GroupLayout.PREFERRED_SIZE, 537, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(panel_k1, GroupLayout.DEFAULT_SIZE, 537, Short.MAX_VALUE))
						.addGroup(groupLayout1.createSequentialGroup()
							.addComponent(panel_k2, GroupLayout.PREFERRED_SIZE, 537, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(panel_k5, GroupLayout.DEFAULT_SIZE, 537, Short.MAX_VALUE))
						.addGroup(groupLayout1.createSequentialGroup()
							.addComponent(panel_k3, GroupLayout.PREFERRED_SIZE, 537, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(panel_k6, GroupLayout.DEFAULT_SIZE, 537, Short.MAX_VALUE))
						.addComponent(panel_k4, GroupLayout.DEFAULT_SIZE, 1080, Short.MAX_VALUE))
					.addGap(2))
		);
		groupLayout1.setVerticalGroup(
			groupLayout1.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout1.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout1.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(panel_k1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(panel_k, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout1.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_k2, GroupLayout.PREFERRED_SIZE, 161, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel_k5, GroupLayout.PREFERRED_SIZE, 161, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout1.createParallelGroup(Alignment.LEADING)
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
		table_6.getColumnModel().getColumn(0).setMinWidth(22);
		table_6.getColumnModel().getColumn(1).setPreferredWidth(220);
		table_6.getColumnModel().getColumn(1).setMinWidth(22);
		table_6.getColumnModel().getColumn(2).setPreferredWidth(60);
		table_6.getColumnModel().getColumn(2).setMinWidth(6);
		table_6.getColumnModel().getColumn(3).setPreferredWidth(220);
		table_6.getColumnModel().getColumn(3).setMinWidth(22);
		table_6.getColumnModel().getColumn(4).setPreferredWidth(30);
		table_6.getColumnModel().getColumn(4).setMinWidth(3);
		table_6.getColumnModel().getColumn(5).setPreferredWidth(200);
		table_6.getColumnModel().getColumn(5).setMinWidth(20);
		table_6.getColumnModel().getColumn(6).setPreferredWidth(80);
		table_6.getColumnModel().getColumn(6).setMinWidth(8);
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
		table_4.getColumnModel().getColumn(0).setMinWidth(14);
		table_4.getColumnModel().getColumn(1).setPreferredWidth(130);
		table_4.getColumnModel().getColumn(1).setMinWidth(13);
		table_4.getColumnModel().getColumn(2).setPreferredWidth(60);
		table_4.getColumnModel().getColumn(2).setMinWidth(6);
		table_4.getColumnModel().getColumn(3).setPreferredWidth(130);
		table_4.getColumnModel().getColumn(3).setMinWidth(13);
		table_4.getColumnModel().getColumn(4).setPreferredWidth(30);
		table_4.getColumnModel().getColumn(4).setMinWidth(3);
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
		table_2.getColumnModel().getColumn(0).setMinWidth(13);
		table_2.getColumnModel().getColumn(1).setPreferredWidth(130);
		table_2.getColumnModel().getColumn(1).setMinWidth(13);
		table_2.getColumnModel().getColumn(2).setPreferredWidth(60);
		table_2.getColumnModel().getColumn(2).setMinWidth(6);
		table_2.getColumnModel().getColumn(3).setPreferredWidth(140);
		table_2.getColumnModel().getColumn(3).setMinWidth(14);
		table_2.getColumnModel().getColumn(4).setPreferredWidth(30);
		table_2.getColumnModel().getColumn(4).setMinWidth(3);
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
		table_3.getColumnModel().getColumn(0).setMinWidth(16);
		table_3.getColumnModel().getColumn(1).setPreferredWidth(110);
		table_3.getColumnModel().getColumn(1).setMinWidth(11);
		table_3.getColumnModel().getColumn(2).setPreferredWidth(60);
		table_3.getColumnModel().getColumn(2).setMinWidth(6);
		table_3.getColumnModel().getColumn(3).setPreferredWidth(130);
		table_3.getColumnModel().getColumn(3).setMinWidth(13);
		table_3.getColumnModel().getColumn(4).setPreferredWidth(30);
		table_3.getColumnModel().getColumn(4).setMinWidth(3);
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
		table_1.getColumnModel().getColumn(0).setMinWidth(15);
		table_1.getColumnModel().getColumn(1).setPreferredWidth(100);
		table_1.getColumnModel().getColumn(1).setMinWidth(10);
		table_1.getColumnModel().getColumn(2).setPreferredWidth(60);
		table_1.getColumnModel().getColumn(2).setMinWidth(6);
		table_1.getColumnModel().getColumn(3).setPreferredWidth(150);
		table_1.getColumnModel().getColumn(3).setMinWidth(15);
		table_1.getColumnModel().getColumn(4).setPreferredWidth(30);
		table_1.getColumnModel().getColumn(4).setMinWidth(3);
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
		table_5.getColumnModel().getColumn(0).setMinWidth(13);
		table_5.getColumnModel().getColumn(1).setPreferredWidth(135);
		table_5.getColumnModel().getColumn(1).setMinWidth(13);
		table_5.getColumnModel().getColumn(2).setPreferredWidth(60);
		table_5.getColumnModel().getColumn(2).setMinWidth(6);
		table_5.getColumnModel().getColumn(3).setPreferredWidth(130);
		table_5.getColumnModel().getColumn(3).setMinWidth(13);
		table_5.getColumnModel().getColumn(4).setPreferredWidth(30);
		table_5.getColumnModel().getColumn(4).setMinWidth(3);
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
		table_k.getColumnModel().getColumn(0).setMinWidth(6);
		table_k.getColumnModel().getColumn(1).setPreferredWidth(130);
		table_k.getColumnModel().getColumn(1).setMinWidth(13);
		table_k.getColumnModel().getColumn(2).setPreferredWidth(80);
		table_k.getColumnModel().getColumn(2).setMinWidth(8);
		table_k.getColumnModel().getColumn(3).setPreferredWidth(190);
		table_k.getColumnModel().getColumn(3).setMinWidth(19);
		table_k.getColumnModel().getColumn(4).setPreferredWidth(30);
		table_k.getColumnModel().getColumn(4).setMinWidth(3);
		scrollPane_k.setViewportView(table_k);
		frame2.getContentPane().setLayout(groupLayout1);
		
		//////////////
	}

	public static String getGW()
	{
		return gwgw;
	}
	public static String getGWTHML()
	{
		return gwhtmlgw;
	}
	public static String getCxlj()
	{
		return htmlcx;
	}
	public static String getPT()
	{
		return pt;
	}
	public static String getDylj()
	{
		return dylj;
	}
	public static String getDyym()
	{
		return dyym;
	}
	public static void settextArea(String message)
	{
		textArea.append(message);
	}
	public static void settextArea1(String message)
	{
		textArea_1.append(message);
	}
	public static void setallList(String message)
	{
		textField_allList.setText(message);
	}
	public static void setallLink(String message)
	{
		textField_allLink.setText(message);
	}
	public static void setlbLink(String message)
	{
		textField_lbList.setText(message);
	}
	public static void settextField(String message)
	{
		textField.setText(message);
	}
	
	public static void settableKL(String linkff_link, String linkff_name,
			String linkff_tar, String linkff_far,int level) {
		DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
		String[] arr =new String[5];
		arr[0] = linkff_link;
		arr[1] = linkff_name;
		arr[2] = linkff_far;
		arr[3] = linkff_tar;
		arr[4] = String.valueOf(level);
		tableModel.addRow(arr);
		table.setAutoCreateRowSorter(true);
	}
	public static void settableGW(String linkff_link, String linkff_name,
			String linkff_tar, String linkff_far,int level) {
		DefaultTableModel tableModel = (DefaultTableModel) table_gwgw.getModel();
		String[] arr =new String[5];
		arr[0] = linkff_link;
		arr[1] = linkff_name;
		arr[2] = linkff_far;
		arr[3] = linkff_tar;
		arr[4] = String.valueOf(level);
		tableModel.addRow(arr);
		table_gwgw.setAutoCreateRowSorter(true);
	}
	public static void settableCAN(String linkff_link, String linkff_name,
			String linkff_tar, String linkff_far,int level) {
		DefaultTableModel tableModel = (DefaultTableModel) table_can.getModel();
		String[] arr =new String[5];
		arr[0] = linkff_link;
		arr[1] = linkff_name;
		arr[2] = linkff_far;
		arr[3] = linkff_tar;
		arr[4] = String.valueOf(level);
		tableModel.addRow(arr);
		table_can.setAutoCreateRowSorter(true);
	}
	public static void settableFPT(String linkff_link, String linkff_name,
			String linkff_tar, String linkff_far,int level) {
		DefaultTableModel tableModel = (DefaultTableModel) table_fpt.getModel();
		String[] arr =new String[5];
		arr[0] = linkff_link;
		arr[1] = linkff_name;
		arr[2] = linkff_far;
		arr[3] = linkff_tar;
		arr[4] = String.valueOf(level);
		tableModel.addRow(arr);
		table_fpt.setAutoCreateRowSorter(true);
	}
	public static void settable_k(String linkff_link, String linkff_name,
			String linkff_tar, String linkff_far,int level) {
		DefaultTableModel tableModel = (DefaultTableModel) table_k.getModel();
		String[] arr =new String[5];
		arr[0] = linkff_link;
		arr[1] = linkff_name;
		arr[2] = linkff_tar;
		arr[3] = linkff_far;
		arr[4] = String.valueOf(level);
		tableModel.addRow(arr);
		table_k.setAutoCreateRowSorter(true);
	}
	public static void settable_1(String linkff_link, String linkff_name,
			String linkff_tar, String linkff_far,int level) {
		DefaultTableModel tableModel = (DefaultTableModel) table_1.getModel();
		String[] arr =new String[5];
		arr[0] = linkff_link;
		arr[1] = linkff_name;
		arr[2] = linkff_tar;
		arr[3] = linkff_far;
		arr[4] = String.valueOf(level);
		tableModel.addRow(arr);
		table_1.setAutoCreateRowSorter(true);
	}
	public static void settable_2(String linkff_link, String linkff_name,
			String linkff_tar, String linkff_far,int level) {
		DefaultTableModel tableModel = (DefaultTableModel) table_2.getModel();
		String[] arr =new String[5];
		arr[0] = linkff_link;
		arr[1] = linkff_name;
		arr[2] = linkff_tar;
		arr[3] = linkff_far;
		arr[4] = String.valueOf(level);
		tableModel.addRow(arr);
		table_2.setAutoCreateRowSorter(true);
	}
	public static void settable_3(String linkff_link, String linkff_name,
			String linkff_tar, String linkff_far,int level) {
		DefaultTableModel tableModel = (DefaultTableModel) table_3.getModel();
		String[] arr =new String[5];
		arr[0] = linkff_link;
		arr[1] = linkff_name;
		arr[2] = linkff_tar;
		arr[3] = linkff_far;
		arr[4] = String.valueOf(level);
		tableModel.addRow(arr);
		table_3.setAutoCreateRowSorter(true);
	}
	public static void settable_4(String linkff_link, String linkff_name,
			String linkff_tar, String linkff_far,int level) {
		DefaultTableModel tableModel = (DefaultTableModel) table_4.getModel();
		String[] arr =new String[5];
		arr[0] = linkff_link;
		arr[1] = linkff_name;
		arr[2] = linkff_tar;
		arr[3] = linkff_far;
		arr[4] = String.valueOf(level);
		tableModel.addRow(arr);
		table_4.setAutoCreateRowSorter(true);
	}
	public static void settable_5(String linkff_link, String linkff_name,
			String linkff_tar, String linkff_far,int level) {
		DefaultTableModel tableModel = (DefaultTableModel) table_5.getModel();
		String[] arr =new String[5];
		arr[0] = linkff_link;
		arr[1] = linkff_name;
		arr[2] = linkff_tar;
		arr[3] = linkff_far;
		arr[4] = String.valueOf(level);
		tableModel.addRow(arr);
		table_5.setAutoCreateRowSorter(true);
	}
	public static void settable_6(String linkff_link, String linkff_name,
			String linkff_tar, String linkff_far,int level,String title) {
		DefaultTableModel tableModel = (DefaultTableModel) table_6.getModel();
		String[] arr =new String[6];
		arr[0] = linkff_link;
		arr[1] = linkff_name;
		arr[2] = linkff_tar;
		arr[3] = linkff_far;
		arr[4] = String.valueOf(level);
		arr[5] = title;
		tableModel.addRow(arr);
		table_6.setAutoCreateRowSorter(true);
	}
	public static void settable_dyall(String linkff_link, String linkff_name,
			String linkff_tar) {
		DefaultTableModel tableModel = (DefaultTableModel) table_dyall.getModel();
		String[] arr =new String[6];
		arr[0] = linkff_link;
		arr[1] = linkff_name;
		arr[2] = linkff_tar;
		tableModel.addRow(arr);
		table_dyall.setAutoCreateRowSorter(true);
	}
	public static void settable_dybh(String linkff_link, String linkff_name,
			String linkff_tar) {
		DefaultTableModel tableModel = (DefaultTableModel) table_dybh.getModel();
		String[] arr =new String[6];
		arr[0] = linkff_link;
		arr[1] = linkff_name;
		arr[2] = linkff_tar;
		tableModel.addRow(arr);
		table_dybh.setAutoCreateRowSorter(true);
	}
	public static void settable_dybbh(String linkff_link, String linkff_name,
			String linkff_tar) {
		DefaultTableModel tableModel = (DefaultTableModel) table_dybbh.getModel();
		String[] arr =new String[6];
		arr[0] = linkff_link;
		arr[1] = linkff_name;
		arr[2] = linkff_tar;
		tableModel.addRow(arr);
		table_dybbh.setAutoCreateRowSorter(true);
	}
	public static void settable_gjz(String linkff_name,
			String all) {
		DefaultTableModel tableModel = (DefaultTableModel) table_gjz.getModel();
		String[] arr =new String[6];
		arr[0] = linkff_name;
		arr[1] = all;
		tableModel.addRow(arr);
		table_gjz.setAutoCreateRowSorter(true);
	}
	public static void setbutton()
	{

			btnNewButton_save.setEnabled(true);
			btnNewButton_news.setEnabled(true);

	}
	public static void setbutton_dy()
	{

		button_dyjg.setEnabled(true);

	}
		
	public  void saveFile()
	{
		File file = null;
		JFileChooser fc =new JFileChooser();
		fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		fc.setDialogType(JFileChooser.SAVE_DIALOG);
		fc.showSaveDialog(this);
		try{
			file =fc.getSelectedFile();
			if(!file.exists()){
				file.createNewFile();
			}}catch(Exception e){}

			Writer out =null;
			try
			{
				out = new FileWriter(file);
			}catch(IOException e)
			{
				e.printStackTrace();
			}
			try {
				out.write("链接"+"\t"+"链接名称"+"\t"+"打开方法"+"\t"+"来自父链"+"\t"+"\n"+"\n");
				out.write("空链接："+"\n");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try{
			     for (Iterator<LinkState> iterator = catchUrl.allList.iterator(); iterator.hasNext();)	//所有链接
			     {
			         LinkState linkstate =iterator.next();
			         if(linkstate.getlevel() == 99){
			         out.write(linkstate.getlink().toString()+"\t");
			         out.write(linkstate.getname().toString()+"\t");
			         out.write(linkstate.gettar().toString()+"\t");
			         out.write(linkstate.father_link().toString()+"\t");
			         out.write("\n");}
			     }
			     }catch (Exception e) {
			       e.printStackTrace();
			     }
			try {
				out.write("\n"+"\n"+"非完整链接的："+"\n");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try{
			     for (Iterator<LinkState> iterator = catchUrl.allList.iterator(); iterator.hasNext();)	//所有链接
			     {
			         LinkState linkstate =iterator.next();
			         if(linkstate.getlevel() == 88){
				         out.write(linkstate.getlink().toString()+"\t");
				         out.write(linkstate.getname().toString()+"\t");
				         out.write(linkstate.gettar().toString()+"\t");
				         out.write(linkstate.father_link().toString()+"\t");
			         out.write("\n");}
			     }
			     }catch (Exception e) {
			       e.printStackTrace();
			     }
			try {
				out.write("\n"+"\n"+"非域名内链接："+"\n");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try{
			     for (Iterator<LinkState> iterator = catchUrl.allList.iterator(); iterator.hasNext();)	//所有链接
			     {
			         LinkState linkstate =iterator.next();
			         if(linkstate.getlevel() == 9){
				         out.write(linkstate.getlink().toString()+"\t");
				         out.write(linkstate.getname().toString()+"\t");
				         out.write(linkstate.gettar().toString()+"\t");
				         out.write(linkstate.father_link().toString()+"\t");
			         out.write("\n");}
			     }
			     }catch (Exception e) {
			       e.printStackTrace();
			     }
			try {
				out.write("\n"+"\n"+"带参数的链接："+"\n");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try{
			     for (Iterator<LinkState> iterator = catchUrl.allList.iterator(); iterator.hasNext();)	//所有链接
			     {
			         LinkState linkstate =iterator.next();
			         if(linkstate.getlevel() == 8){
				         out.write(linkstate.getlink().toString()+"\t");
				         out.write(linkstate.getname().toString()+"\t");
				         out.write(linkstate.gettar().toString()+"\t");
				         out.write(linkstate.father_link().toString()+"\t");
			         out.write("\n");}
			     }
			     }catch (Exception e) {
			       e.printStackTrace();
			     }
			try {
				out.write("\n"+"\n"+"平台内链，非此官网下链接："+"\n");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try{
			     for (Iterator<LinkState> iterator = catchUrl.allList.iterator(); iterator.hasNext();)	//所有链接
			     {
			         LinkState linkstate =iterator.next();
			         if(linkstate.getlevel() == 7){
				         out.write(linkstate.getlink().toString()+"\t");
				         out.write(linkstate.getname().toString()+"\t");
				         out.write(linkstate.gettar().toString()+"\t");
				         out.write(linkstate.father_link().toString()+"\t");
			         out.write("\n");}
			     }
			     }catch (Exception e) {
			       e.printStackTrace();
			     }
			try {
				out.write("\n"+"\n"+"列表页："+"\n");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try{
			     for (Iterator<LinkState> iterator = catchUrl.allList.iterator(); iterator.hasNext();)	//所有链接
			     {
			         LinkState linkstate =iterator.next();
			         if(linkstate.getlevel() == 1){
				         out.write(linkstate.getlink().toString()+"\t");
				         out.write(linkstate.getname().toString()+"\t");
				         out.write(linkstate.gettar().toString()+"\t");
				         out.write(linkstate.father_link().toString()+"\t");
			         out.write("\n");}
			     }
			     }catch (Exception e) {
			       e.printStackTrace();
			     }
			try {
				out.write("\n"+"\n"+"其他页："+"\n");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try{
			     for (Iterator<LinkState> iterator = catchUrl.allList.iterator(); iterator.hasNext();)	//所有链接
			     {
			         LinkState linkstate =iterator.next();
			         if(linkstate.getlevel() == 3 ||linkstate.getlevel() == 2){
				         out.write(linkstate.getlink().toString()+"\t");
				         out.write(linkstate.getname().toString()+"\t");
				         out.write(linkstate.gettar().toString()+"\t");
				         out.write(linkstate.father_link().toString()+"\t");
			         out.write("\n");}
			     }
			     }catch (Exception e) {
			       e.printStackTrace();
			     }
			try
			{
				out.close();
			}
			catch(IOException e2)
			{
				e2.printStackTrace();
			}
	}

	public static void setprogressBar(int i) {
		progressBar.setValue(i); 	
	}
	public static void setprogressBar_dy(int e) {
		progressBar_dy.setValue(e); 	
	}
	public static void settextArea_dy(String dS) {
		// TODO Auto-generated method stub
		textArea_2.append(dS);
	}
}
