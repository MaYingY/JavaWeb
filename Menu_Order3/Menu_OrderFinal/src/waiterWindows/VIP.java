package waiterWindows;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import waiterManage.CustomerVIP;

import entity.Tools;

public class VIP {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	/**
	 * @wbp.parser.entryPoint
	 */
	public VIP() {
		initialize();

	}
	private void initialize() {
		frame = new JFrame();
		frame.setVisible(true);
		frame.setBounds(100, 100, 472, 336);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("欢迎注册新会员");
		lblNewLabel.setBounds(168, 4, 200, 50);
		frame.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("姓名");
		lblNewLabel_1.setBounds(71, 74, 87, 33);
		frame.getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("联系方式");
		lblNewLabel_2.setBounds(71, 131, 87, 33);
		frame.getContentPane().add(lblNewLabel_2);

		final JButton btnNewButton = new JButton("确认");
		btnNewButton.setBounds(126, 212, 96, 33);
		btnNewButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				String name = textField.getText();
				String tell = textField_1.getText();
				Tools tools = new Tools();
				if (tools.IsInteger(tell)) {
					long tel = Long.parseLong(tell);
					CustomerVIP cVip = new CustomerVIP();
					cVip.add(name, tel);
					JOptionPane.showMessageDialog(btnNewButton, "会员注册成功，会员号："
							+ cVip.id, "提示", JOptionPane.WARNING_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(btnNewButton, "输入信息有误", "提示",
							JOptionPane.WARNING_MESSAGE);
				}

			}
		});
		frame.getContentPane().add(btnNewButton);

		textField = new JTextField();
		textField.setBounds(181, 79, 140, 24);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setBounds(181, 136, 140, 24);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
	}
}
