package ChiefManage;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JTextField;
import javax.swing.JButton;

import Dao.ChiefOperate;

public class ModInfo implements ActionListener {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	JButton mod;
	JButton reset;
	/**
	 * Create the application.
	 */
	public ModInfo() {
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 550, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		//标题
		JLabel head = new JLabel("\u4FE1\u606F\u4FEE\u6539");
		head.setFont(new Font("宋体", Font.PLAIN, 14));
		head.setBounds(241, 23, 101, 53);
		frame.getContentPane().add(head);
		//用户名
		JLabel name = new JLabel("\u7528\u6237\u540D");
		name.setFont(new Font("宋体", Font.PLAIN, 14));
		name.setBounds(164, 121, 54, 15);
		frame.getContentPane().add(name);
		
		textField = new JTextField();
		textField.setBounds(280, 118, 123, 21);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(280, 214, 123, 21);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		//密码
		JLabel passwd = new JLabel("\u5BC6\u7801");
		passwd.setFont(new Font("宋体", Font.PLAIN, 14));
		passwd.setBounds(164, 220, 54, 15);
		frame.getContentPane().add(passwd);
		//修改
		mod = new JButton("\u4FEE\u6539");
		mod.setBounds(199, 299, 70, 23);
		mod.addActionListener(this);
		frame.getContentPane().add(mod);
		//重置
		reset = new JButton("\u91CD\u7F6E");
		reset.setBounds(295, 299, 63, 23);
		frame.getContentPane().add(reset);
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == mod) {
			ChiefOperate chief = new ChiefOperate();
			try {
				chief.modInfo(textField.getText(), textField_1.getText());
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
}
