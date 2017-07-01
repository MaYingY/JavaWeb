package WineOperate;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Dao.ChiefOperate;
import Dao.ManageOperate;

public class mod_Wine implements ActionListener {
	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	JButton mod;
	JButton reset;
	JComboBox<String> comboBox;
	ChiefOperate chiefOperate = new ChiefOperate();

	/**
	 * Create the application.
	 */
	public mod_Wine() {
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
		JLabel head = new JLabel("\u6DFB\u52A0\u83DC\u54C1");
		head.setFont(new Font("宋体", Font.PLAIN, 16));
		head.setForeground(Color.BLACK);
		head.setBounds(208, 23, 106, 42);
		frame.getContentPane().add(head);
		//编号
		JLabel id = new JLabel("\u7F16\u53F7");
		id.setFont(new Font("宋体", Font.PLAIN, 14));
		id.setBounds(138, 69, 64, 37);
		frame.getContentPane().add(id);
		//菜名
		JLabel name = new JLabel("\u9152\u540D");
		name.setFont(new Font("宋体", Font.PLAIN, 14));
		name.setBounds(138, 116, 46, 42);
		frame.getContentPane().add(name);
		//价格
		JLabel price = new JLabel("\u4EF7\u683C");
		price.setFont(new Font("宋体", Font.PLAIN, 14));
		price.setBounds(138, 168, 46, 40);
		frame.getContentPane().add(price);
		//类型
		JLabel type = new JLabel("\u7C7B\u578B");
		type.setFont(new Font("宋体", Font.PLAIN, 14));
		type.setBounds(138, 234, 46, 15);
		frame.getContentPane().add(type);
		//编号
		textField = new JTextField();
		textField.setBounds(218, 75, 164, 26);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		//菜名
		textField_1 = new JTextField();
		textField_1.setBounds(218, 122, 164, 26);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		//价格
		textField_2 = new JTextField();
		textField_2.setBounds(218, 176, 164, 26);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		//修改按钮
		mod = new JButton("\u4FEE\u6539");
		mod.setBounds(167, 301, 75, 23);
		mod.addActionListener(this);
		frame.getContentPane().add(mod);
		//重置按钮
		reset = new JButton("\u91CD\u7F6E");
		reset.setBounds(302, 301, 75, 23);
		frame.getContentPane().add(reset);
		//下拉列表
		comboBox = new JComboBox();
		comboBox.setBounds(218, 230, 164, 23);
		comboBox.addItem("白酒");
		comboBox.addItem("啤酒");
		frame.getContentPane().add(comboBox);
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == mod) {
			int id = (int)Integer.parseInt(textField.getText());
			double price = Double.parseDouble(textField_2.getText());
			int type = comboBox.getSelectedIndex() + 1;
			try {
				chiefOperate.modMenu(id, textField_1.getText(), price, type);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

}
