package MenusOperate;


import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

import Dao.ManageOperate;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import javax.swing.JComboBox;

public class addMenu implements ActionListener{

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	JButton add;
	JButton reset;
	ManageOperate manageOperate = new ManageOperate();
	private JComboBox<String> comboBox;
	/**
	 * Create the application.
	 */
	public addMenu() {
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
		JLabel name = new JLabel("\u83DC\u540D");
		name.setFont(new Font("宋体", Font.PLAIN, 14));
		name.setBounds(138, 116, 46, 42);
		frame.getContentPane().add(name);
		//价格
		JLabel price = new JLabel("\u4EF7\u683C");
		price.setFont(new Font("宋体", Font.PLAIN, 14));
		price.setBounds(138, 168, 46, 40);
		frame.getContentPane().add(price);
		//主厨编号
		JLabel chiefId = new JLabel("\u4E3B\u53A8\u7F16\u53F7");
		chiefId.setFont(new Font("宋体", Font.PLAIN, 14));
		chiefId.setBounds(115, 205, 58, 50);
		frame.getContentPane().add(chiefId);
		//类型
		JLabel type = new JLabel("\u7C7B\u578B");
		type.setFont(new Font("宋体", Font.PLAIN, 14));
		type.setBounds(138, 278, 46, 15);
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
		//主厨编号
		textField_3 = new JTextField();
		textField_3.setBounds(218, 218, 164, 26);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		//添加按钮
		add = new JButton("\u6DFB\u52A0");
		add.setBounds(176, 315, 75, 23);
		add.addActionListener(this);
		frame.getContentPane().add(add);
		//重置按钮
		reset = new JButton("\u91CD\u7F6E");
		reset.setBounds(305, 315, 75, 23);
		frame.getContentPane().add(reset);
		//下拉列表
		comboBox = new JComboBox();
		comboBox.setBounds(218, 270, 164, 23);
		comboBox.addItem("烧菜");
		comboBox.addItem("凉菜");
		comboBox.addItem("汤");
		comboBox.addItem("特色菜");
		frame.getContentPane().add(comboBox);
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == add) {
			int id = (int)Integer.parseInt(textField.getText());
			int chief = (int)Integer.parseInt(textField_3.getText());
			double price = Double.parseDouble(textField_2.getText());
			int type = comboBox.getSelectedIndex() + 1;
			try {
				ManageOperate.addMenu(id, textField_1.getText(), price, chief, type);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
}
