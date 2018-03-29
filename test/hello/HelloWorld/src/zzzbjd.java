import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTabbedPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Panel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;




public class zzzbjd {
	int width =Toolkit.getDefaultToolkit().getScreenSize().width;
	int height =Toolkit.getDefaultToolkit().getScreenSize().height;

	public zzzbjd(){
		JFrame frame3 = new JFrame();
		frame3.setTitle("ÏêÏ¸½á¹û");
		frame3.setSize(1100,700);
		frame3.setLocation((width-1100)/2, (height-700)/2);
		frame3.setResizable(true);
		frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		
		JButton btnNewButton = new JButton("New button");
		
		GroupLayout groupLayout = new GroupLayout(frame3.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(22)
							.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, 372, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(63)
							.addComponent(btnNewButton)))
					.addContainerGap(698, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, 223, GroupLayout.PREFERRED_SIZE)
					.addGap(40)
					.addComponent(btnNewButton)
					.addContainerGap(380, Short.MAX_VALUE))
		);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("New tab", null, panel, null);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("New tab", null, panel_1, null);
		
		Panel panel_2 = new Panel();
		tabbedPane.addTab("New tab", null, panel_2, null);
		
		final JProgressBar progressBar = new JProgressBar();
		progressBar.setIndeterminate(true);
		panel_2.add(progressBar);
		frame3.getContentPane().setLayout(groupLayout);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		frame3.setVisible(true);
	}
	public static void main(String args[]){
		zzzbjd ff =new zzzbjd() ;
	}
}
