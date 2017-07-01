package ChiefManage;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JButton;

import Dao.Main;
import Domain.LookMenu;

public class lookMenu {

	private JFrame frame;
	/**
	 * Create the application.
	 */
	public lookMenu() {
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */



	private void initialize() {
		frame = new JFrame();
		frame.setVisible(true);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(67, 35, 280, 172);
		frame.getContentPane().add(panel);
		panel.setLayout(new GridLayout(10, 1, 0, 0));

		JLabel lblNewLabel = new JLabel("代做菜单");
		lblNewLabel.setBounds(177, 10, 54, 15);
		frame.getContentPane().add(lblNewLabel);
		int coun = 0;
		try {
			Main ma = new Main();
			Connection connection = ma.getConn();
			String sql = "select * from menu where chief = 1";
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);

			while (resultSet.next()) {
				coun++;
			}
			resultSet = statement.executeQuery(sql);
			int i = 0;
			final JRadioButton button[] = new JRadioButton[coun];
			while (resultSet.next()) {
				int stat = resultSet.getInt(5);
				if (stat == 0) {
					button[i] = new JRadioButton(resultSet.getString(2));
					button[i].validate();
					panel.add(button[i]);
					i++;
				}
			}
		} catch (Exception e) {
		}

		JButton btnNewButton = new JButton("确定");
		btnNewButton.setBounds(169, 217, 93, 23);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				LookMenu chief = new LookMenu();
				chief.name(1, 2);
				frame.dispose();

			}
		});
		frame.getContentPane().add(btnNewButton);

	}


}
