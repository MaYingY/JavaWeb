package WindowsAll;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import waiterWindows.Customer;

import ChiefManage.ChiefLogin;
import ChiefManage.Chief_Operate;
import Domain.Chief;
import ManageOperate.manageLogin;

public class windows<chiefLogin> implements ActionListener{

	private JFrame frame;
	private JButton chiefLogin;
	private JButton btnNewButton;
	private JButton btnNewButton_1;

	private JButton manageLogin;
	private JLabel lblNewLabel;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					windows window = new windows();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * Create the application.
	 */
	public windows() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(200, 200, 550, 400);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		//管理员登录
		manageLogin = new JButton("\u7BA1\u7406\u5458\u767B\u5F55");
		manageLogin.setBounds(22, 116, 200, 50);
		manageLogin.addActionListener(this);
		frame.getContentPane().add(manageLogin);
		//厨师登录
		chiefLogin = new JButton("\u53A8\u5E08\u767B\u5F55");
		chiefLogin.setBounds(22, 208, 200, 50);
		chiefLogin.addActionListener(this);
		frame.getContentPane().add(chiefLogin);
		//服务员登录
		btnNewButton = new JButton("\u670D\u52A1\u5458\u767B\u5F55");
		btnNewButton.addActionListener(this);
		btnNewButton.setBounds(298, 116, 200, 50);
		frame.getContentPane().add(btnNewButton);
		//顾客登录
		btnNewButton_1 = new JButton("\u987E\u5BA2");
		btnNewButton_1.setBounds(298, 208, 200, 50);
		frame.getContentPane().add(btnNewButton_1);
		btnNewButton_1.addActionListener(this);
		lblNewLabel = new JLabel("\u6B22\u8FCE\u6765\u5230\u597D\u8FD0\u6765\u996D\u5E97\uFF01");
		lblNewLabel.setBounds(184, 10, 137, 46);
		frame.getContentPane().add(lblNewLabel);
		
		
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == manageLogin){
			manageLogin ma = new manageLogin();
			frame.dispose();	
		}
		if(e.getSource() == chiefLogin) {
			ChiefLogin chief = new ChiefLogin();
			frame.dispose();
		}
		if(e.getSource() == btnNewButton) {
			Waiter waiter = new Waiter();
		}
		if(e.getSource() == btnNewButton_1) {
			Customer customer = new Customer();
		}
	}

}
