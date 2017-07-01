package waiterWindows;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import javax.swing.JComboBox;
import javax.swing.JButton;
import entity.Tools;

import javax.swing.JTextArea;

import waiterManage.AddMenu;
import waiterManage.CustomerVIP;

public class WaiterCal {

	private JFrame frame;
	private JTextField textField_1;
	private JTextField textField;
	private JTextField textField_2;
	public WaiterCal() {
		initialize();
	}
	private void initialize() {
		frame = new JFrame();
		frame.setVisible(true);
		frame.setBounds(100, 100, 421, 363);
		// frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("结账系统");
		lblNewLabel.setBounds(168, 22, 64, 24);
		frame.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("桌号");
		lblNewLabel_1.setBounds(20, 56, 40, 24);
		frame.getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("账单");
		lblNewLabel_2.setBounds(20, 149, 54, 21);
		frame.getContentPane().add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("总计");
		lblNewLabel_3.setBounds(20, 231, 40, 21);
		frame.getContentPane().add(lblNewLabel_3);

		textField_1 = new JTextField();
		textField_1.setBounds(72, 230, 64, 24);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);

		final JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "1", "2",
				"3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));
		comboBox.setBounds(70, 56, 32, 24);
		frame.getContentPane().add(comboBox);

		final JTextArea textArea = new JTextArea();
		textArea.setBounds(74, 148, 200, 66);
		frame.getContentPane().add(textArea);

		final JButton btnNewButton = new JButton("确认");
		btnNewButton.setBounds(240, 57, 93, 23);
		btnNewButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				int dek = comboBox.getSelectedIndex();
				Tools tools = new Tools();
				AddMenu addmenu = new AddMenu();
				double re = addmenu.total(textArea, dek + 1);

				CustomerVIP cVip = new CustomerVIP();
				String idString = textField.getText();
				if (idString.equals("")) {
					textField_1.setText(re + " ");
					addmenu.del(dek + 1);
				} else if (tools.IsInteger(idString)) {
					int id = Integer.parseInt(idString);
					if (idString.equals("") || cVip.IfExit(id)) {
						textField_1.setText(re + " ");
						re = re * 0.8;
						DecimalFormat df = new DecimalFormat("#.##");
						textField_2.setText(df.format(re) + " ");

					} else {
						JOptionPane.showMessageDialog(btnNewButton, "会员号不存在",
								"提示", JOptionPane.WARNING_MESSAGE);
					}
				} else {
					JOptionPane.showMessageDialog(btnNewButton, "会员号不存在", "提示",
							JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		frame.getContentPane().add(btnNewButton);

		final JButton btnNewButton_1 = new JButton("确认收费");
		btnNewButton_1.setBounds(139, 292, 93, 23);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(btnNewButton_1, "收费成功", "提示",
						JOptionPane.WARNING_MESSAGE);
				frame.dispose();
			}
		});
		frame.getContentPane().add(btnNewButton_1);
		JLabel lblNewLabel_4 = new JLabel("会员号");
		lblNewLabel_4.setBounds(20, 103, 40, 24);
		frame.getContentPane().add(lblNewLabel_4);

		textField = new JTextField();
		textField.setBounds(70, 105, 66, 21);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel_5 = new JLabel("会员价");
		lblNewLabel_5.setBounds(20, 269, 40, 24);
		frame.getContentPane().add(lblNewLabel_5);

		textField_2 = new JTextField();
		textField_2.setBounds(72, 270, 64, 23);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
	}
}
