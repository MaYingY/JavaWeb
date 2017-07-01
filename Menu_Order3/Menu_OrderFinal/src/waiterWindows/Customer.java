package waiterWindows;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Customer {

	private JFrame frame;
	public Customer() {
		initialize();
	}
	private void initialize() {
		frame = new JFrame();
		frame.setVisible(true);
		frame.setBounds(100, 100, 550, 400);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("\u6B22\u8FCE\u5149\u4E34\u597D\u8FD0\u6765\u996D\u5E97");
		label.setBounds(193, 31, 143, 45);
		frame.getContentPane().add(label);
		
		JButton button = new JButton("点餐");//点餐
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Menu sMenu = new Menu();
				MENU2 menu2 = new MENU2();
			}
		});
		button.setBounds(198, 114, 87, 45);
		frame.getContentPane().add(button);
		
		JButton button_1 = new JButton("房间预订");//房间预订
		button_1.setBounds(198, 230, 87, 45);
		button_1.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				Desk desk = new Desk();
			}
		});
		frame.getContentPane().add(button_1);
		
		JButton btnNewButton = new JButton("点酒");
		btnNewButton.setBounds(198, 169, 87, 45);
		btnNewButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				Wine wine = new Wine();
			}
		});
		frame.getContentPane().add(btnNewButton);
	}

}
