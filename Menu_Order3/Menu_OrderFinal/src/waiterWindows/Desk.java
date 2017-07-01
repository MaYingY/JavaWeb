package waiterWindows;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JButton;

import waiterManage.DeskDao;

public class Desk {
	private JFrame frame;

	public Desk() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setVisible(true);
		frame.setBounds(100, 100, 550, 400);
		// frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("房间预订");
		lblNewLabel.setBounds(151, 10, 200, 50);
		frame.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("大号（10-15人）");
		lblNewLabel_1.setBounds(0, 66, 90, 33);
		frame.getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("中号（5-9）");
		lblNewLabel_2.setBounds(0, 140, 107, 33);
		frame.getContentPane().add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("小号（2-4）");
		lblNewLabel_3.setBounds(0, 208, 200, 50);
		frame.getContentPane().add(lblNewLabel_3);

		DeskDao deskDao = new DeskDao();
		final ButtonGroup buttonGroup1 = new ButtonGroup();
		final JRadioButton rdbtnNewRadioButton = new JRadioButton("1");
		if (!deskDao.search(1)) {
			rdbtnNewRadioButton.setSelected(true);
			rdbtnNewRadioButton.setEnabled(false);
		}
		rdbtnNewRadioButton.setBounds(23, 96, 121, 23);
		// buttonGroup1.add(rdbtnNewRadioButton);
		frame.getContentPane().add(rdbtnNewRadioButton);

		final JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("2");
		rdbtnNewRadioButton_1.setBounds(151, 96, 121, 23);
		if (!deskDao.search(2)) {
			rdbtnNewRadioButton_1.setSelected(true);
			rdbtnNewRadioButton_1.setEnabled(false);
		}
		// buttonGroup1.add(rdbtnNewRadioButton_1);
		frame.getContentPane().add(rdbtnNewRadioButton_1);

		final JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("3");
		rdbtnNewRadioButton_2.setBounds(274, 96, 121, 23);
		if (!deskDao.search(3)) {
			rdbtnNewRadioButton_2.setSelected(true);
			rdbtnNewRadioButton_2.setEnabled(false);
		}
		// buttonGroup1.add(rdbtnNewRadioButton_2);
		frame.getContentPane().add(rdbtnNewRadioButton_2);

		final JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("4");
		rdbtnNewRadioButton_3.setBounds(397, 96, 121, 23);
		if (!deskDao.search(4)) {
			rdbtnNewRadioButton_3.setSelected(true);
			rdbtnNewRadioButton_3.setEnabled(false);
		}
		// buttonGroup1.add(rdbtnNewRadioButton_3);
		frame.getContentPane().add(rdbtnNewRadioButton_3);

		final JRadioButton rdbtnNewRadioButton_4 = new JRadioButton("5");
		rdbtnNewRadioButton_4.setBounds(23, 179, 121, 23);
		if (!deskDao.search(5)) {
			rdbtnNewRadioButton_4.setSelected(true);
			rdbtnNewRadioButton_4.setEnabled(false);
		}
		// buttonGroup1.add(rdbtnNewRadioButton_4);
		frame.getContentPane().add(rdbtnNewRadioButton_4);

		final JRadioButton rdbtnNewRadioButton_5 = new JRadioButton("6");
		rdbtnNewRadioButton_5.setBounds(151, 179, 121, 23);
		if (!deskDao.search(6)) {
			rdbtnNewRadioButton_5.setSelected(true);
			rdbtnNewRadioButton_5.setEnabled(false);
		}
		// buttonGroup1.add(rdbtnNewRadioButton_5);
		frame.getContentPane().add(rdbtnNewRadioButton_5);

		final JRadioButton rdbtnNewRadioButton_6 = new JRadioButton("7");
		rdbtnNewRadioButton_6.setBounds(274, 179, 121, 23);
		if (!deskDao.search(7)) {
			rdbtnNewRadioButton_6.setSelected(true);
			rdbtnNewRadioButton_6.setEnabled(false);
		}
		// buttonGroup1.add(rdbtnNewRadioButton_6);
		frame.getContentPane().add(rdbtnNewRadioButton_6);

		final JRadioButton rdbtnNewRadioButton_7 = new JRadioButton("8");
		rdbtnNewRadioButton_7.setBounds(397, 179, 121, 23);
		if (!deskDao.search(8)) {
			rdbtnNewRadioButton_7.setSelected(true);
			rdbtnNewRadioButton_7.setEnabled(false);
		}
		// buttonGroup1.add(rdbtnNewRadioButton_7);
		frame.getContentPane().add(rdbtnNewRadioButton_7);

		final JRadioButton rdbtnNewRadioButton_8 = new JRadioButton("9");
		rdbtnNewRadioButton_8.setBounds(23, 264, 121, 23);
		if (!deskDao.search(9)) {
			rdbtnNewRadioButton_8.setSelected(true);
			rdbtnNewRadioButton_8.setEnabled(false);
		}
		// buttonGroup1.add(rdbtnNewRadioButton_8);
		frame.getContentPane().add(rdbtnNewRadioButton_8);

		final JRadioButton rdbtnNewRadioButton_9 = new JRadioButton("10");
		rdbtnNewRadioButton_9.setBounds(151, 264, 121, 23);
		if (!deskDao.search(10)) {
			rdbtnNewRadioButton_9.setSelected(true);
			rdbtnNewRadioButton_9.setEnabled(false);
		}
		// buttonGroup1.add(rdbtnNewRadioButton_9);
		frame.getContentPane().add(rdbtnNewRadioButton_9);

		final JRadioButton rdbtnNewRadioButton_10 = new JRadioButton("11");
		rdbtnNewRadioButton_10.setBounds(274, 264, 121, 23);
		if (!deskDao.search(11)) {
			rdbtnNewRadioButton_10.setSelected(true);
			rdbtnNewRadioButton_10.setEnabled(false);
		}
		// buttonGroup1.add(rdbtnNewRadioButton_10);
		frame.getContentPane().add(rdbtnNewRadioButton_10);

		final JRadioButton rdbtnNewRadioButton_11 = new JRadioButton("12");
		rdbtnNewRadioButton_11.setBounds(397, 264, 121, 23);
		if (!deskDao.search(12)) {
			rdbtnNewRadioButton_11.setSelected(true);
			rdbtnNewRadioButton_11.setEnabled(false);
		}
		// buttonGroup1.add(rdbtnNewRadioButton_11);
		frame.getContentPane().add(rdbtnNewRadioButton_11);

		final JButton btnNewButton = new JButton("确认");
		btnNewButton.setBounds(210, 317, 93, 23);
		btnNewButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				DeskDao deskDao = new DeskDao();
				if (rdbtnNewRadioButton.isSelected()) {
					deskDao.change(1, 1);
				}
				if (rdbtnNewRadioButton_1.isSelected()) {
					deskDao.change(2, 1);
				}
				if (rdbtnNewRadioButton_2.isSelected()) {
					deskDao.change(3, 1);
				}
				if (rdbtnNewRadioButton_3.isSelected()) {
					deskDao.change(4, 1);
				}
				if (rdbtnNewRadioButton_4.isSelected()) {
					deskDao.change(5, 1);
				}
				if (rdbtnNewRadioButton_5.isSelected()) {
					deskDao.change(6, 1);
				}
				if (rdbtnNewRadioButton_6.isSelected()) {
					deskDao.change(7, 1);
				}
				if (rdbtnNewRadioButton_7.isSelected()) {
					deskDao.change(8, 1);
				}
				if (rdbtnNewRadioButton_8.isSelected()) {
					deskDao.change(9, 1);
				}
				if (rdbtnNewRadioButton_9.isSelected()) {
					deskDao.change(10, 1);
				}
				if (rdbtnNewRadioButton_10.isSelected()) {
					deskDao.change(11, 1);
				}
				if (rdbtnNewRadioButton_11.isSelected()) {
					deskDao.change(12, 1);
				}
				JOptionPane.showMessageDialog(btnNewButton, "预订成功");
				frame.dispose();
			}
		});
		frame.getContentPane().add(btnNewButton);
	}
}
