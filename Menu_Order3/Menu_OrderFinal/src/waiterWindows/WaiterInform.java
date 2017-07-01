package waiterWindows;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JButton;

public class WaiterInform {

	private JFrame frame;
	public WaiterInform(int sid) {
		int id=sid;
		initialize(id);
	}
	private void initialize(final int id) {
		frame = new JFrame();
		frame.setVisible(true);
		frame.setBounds(100, 100, 450, 300);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("取消预订");
		btnNewButton.setBounds(164, 55, 93, 23);
		btnNewButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
			WaiterCancle wCancle = new WaiterCancle();
				
			}
		});
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("结账");
		btnNewButton_1.setBounds(164, 103, 93, 23);
		btnNewButton_1.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				WaiterCal waiterCal = new WaiterCal();	
			}
		});
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("会员注册");
		btnNewButton_2.setBounds(164, 146, 93, 23);
		btnNewButton_2.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				VIP vip=new VIP();	
			}
		});
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("修改密码");
		btnNewButton_3.setBounds(164, 191, 93, 23);
		btnNewButton_3.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				WaiterPass waiterPass =new WaiterPass(id);
			}
		});
		frame.getContentPane().add(btnNewButton_3);
	}
}
