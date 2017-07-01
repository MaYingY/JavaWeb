package MenusOperate;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import Dao.ManageOperate;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;

public class delMenu implements ActionListener{

	private JFrame frame;
	private JTextField textField;
	JButton delete;
	JButton reset;
	ManageOperate manageOperate = new ManageOperate();
	/**
	 * Create the application.
	 */
	public delMenu() {
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(320, 320, 550, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		//标题
		JLabel head = new JLabel("\u5220\u9664\u83DC\u54C1");
		head.setFont(new Font("宋体", Font.PLAIN, 16));
		head.setForeground(Color.BLACK);
		head.setBounds(208, 23, 106, 42);
		frame.getContentPane().add(head);
		//菜名
		JLabel name = new JLabel("\u83DC\u540D");
		name.setFont(new Font("宋体", Font.PLAIN, 14));
		name.setBounds(150, 108, 34, 50);
		frame.getContentPane().add(name);
		//菜名框
		textField = new JTextField();
		textField.setBounds(206, 119, 139, 29);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		//删除
		delete = new JButton("\u5220\u9664");
		delete.setBounds(162, 248, 71, 23);
		delete.addActionListener(this);
		frame.getContentPane().add(delete);
		//重置
		reset = new JButton("\u91CD\u7F6E");
		reset.setBounds(294, 248, 71, 23);
		frame.getContentPane().add(reset);
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == delete) {
			try {
				String name = textField.getText();
				manageOperate.deleteMenu(name);
				frame.dispose();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	} 

}
