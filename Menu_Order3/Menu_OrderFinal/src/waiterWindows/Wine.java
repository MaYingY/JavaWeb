package waiterWindows;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JRadioButton;

import waiterManage.AddMenu;
import waiterManage.DeskDao;


import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Wine {

	private JFrame frame;

	public Wine() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setVisible(true);
		frame.setBounds(100, 100, 478, 363);
		// frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("欢迎光临好运来酒店");
		lblNewLabel.setBounds(144, 10, 200, 50);
		frame.getContentPane().add(lblNewLabel);

		JPanel panel = new JPanel();
		panel.setBounds(10, 105, 200, 163);
		frame.getContentPane().add(panel);
		panel.setLayout(new GridLayout(4, 1, 0, 0));

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(239, 105, 200, 163);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(new GridLayout(4, 1, 0, 0));

		JLabel lblNewLabel_1 = new JLabel("啤酒");
		lblNewLabel_1.setBounds(10, 72, 62, 23);
		frame.getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("白酒");
		lblNewLabel_2.setBounds(241, 72, 62, 23);
		frame.getContentPane().add(lblNewLabel_2);
		int coun = 0;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager
					.getConnection(
							"jdbc:mysql://localhost:3306/menu?user=root&password=1&useUnicode=true&characterEncoding=utf-8",
							"root", "");
			String sql = "select * from wine";
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);

			while (resultSet.next()) {
				coun++;
			}
			resultSet = statement.executeQuery(sql);
			int i = 0;
			final JRadioButton button[] = new JRadioButton[coun];
			int flag = 0;
			while (resultSet.next()) {
				String nameString = resultSet.getString(2);
				double price = resultSet.getDouble(3);
				flag = resultSet.getInt(4);
				button[i] = new JRadioButton(nameString + " " + price);
				button[i].validate();
				if (flag == 1) {
					panel.add(button[i]);
				} else if (flag == 2) {
					panel_1.add(button[i]);
				}
				i++;
			}
			panel.setVisible(true);
			panel.validate();
			frame.getContentPane().add(panel);
			JLabel lblNewLabel_5 = new JLabel("桌号");
			lblNewLabel_5.setBounds(10, 44, 54, 15);
			frame.getContentPane().add(lblNewLabel_5);

			final JComboBox comboBox = new JComboBox();
			comboBox.setModel(new DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11" }));
			comboBox.setBounds(90, 41, 32, 21);
			frame.getContentPane().add(comboBox);

			final int num = coun;
			final JButton btnNewButton = new JButton("确认");
			btnNewButton.setBounds(174, 292, 93, 23);
			btnNewButton.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent arg0) {
					int j = 0;
					AddMenu addmenu = new AddMenu();
					int desk = comboBox.getSelectedIndex() + 1;
					DeskDao dao = new DeskDao();
					dao.change(desk, 0);
					while (j < num) {
						if (button[j].isSelected()) {
							addmenu.add(j + 1, button[j].getText(), desk, 0);
						}
						j++;
					}
					JOptionPane.showMessageDialog(btnNewButton, "下单成功", "提示",
							JOptionPane.WARNING_MESSAGE);
					frame.dispose();
				}
			});
			frame.getContentPane().add(btnNewButton);
		} catch (Exception e) {
		}
	}
}
