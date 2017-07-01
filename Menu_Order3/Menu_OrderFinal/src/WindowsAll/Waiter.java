package WindowsAll;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import javax.swing.JPasswordField;
import javax.swing.JButton;


import waiterWindows.WaiterInform;


import entity.Enwaiter;
import entity.Tools;

public class Waiter {

	private JFrame frame;
	private JPasswordField passwordField;

	public Waiter() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setVisible(true);
		frame.setBounds(100, 100, 418, 300);
		// frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel label = new JLabel("\u670D\u52A1\u5458\u767B\u5F55\u7CFB\u7EDF");
		label.setBounds(147, 35, 128, 30);
		frame.getContentPane().add(label);

		JLabel label_1 = new JLabel("账号");// 账号
		label_1.setBounds(93, 80, 37, 15);
		frame.getContentPane().add(label_1);

		final JTextPane textPane = new JTextPane();
		textPane.setBounds(147, 74, 110, 21);
		frame.getContentPane().add(textPane);

		JLabel label_2 = new JLabel("密码");// 密码
		label_2.setBounds(93, 125, 54, 15);
		frame.getContentPane().add(label_2);

		passwordField = new JPasswordField();
		passwordField.setBounds(147, 122, 110, 21);
		frame.getContentPane().add(passwordField);

		final JButton button = new JButton("确认");
		button.setBounds(113, 177, 71, 23);
		button.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				String idString = textPane.getText();
				Tools tools = new Tools();
				Enwaiter enwaiter = new Enwaiter();
				if (tools.IsInteger(idString)&&!idString.equals("")) {
					int id = Integer.parseInt(idString);
					String passwString = passwordField.getText();
					Domain.WaiterClass waiterClass = enwaiter.wav(id);
					if (enwaiter.flag&&!passwString.equals("")) {
						String string = waiterClass.passwd;
						if (string.equals(passwString)) {
							WaiterInform waiterInform = new WaiterInform(id);
							frame.dispose();
						} else {
							passwordField.setText("");
                 JOptionPane.showMessageDialog(button, "账号或密码不正确", "提示",
								JOptionPane.WARNING_MESSAGE);
						}
					} else {
						passwordField.setText("");
		                 JOptionPane.showMessageDialog(button, "账号或密码不正确", "提示",
										JOptionPane.WARNING_MESSAGE);
					}

				} else {
					JOptionPane.showMessageDialog(button, "账号或密码不正确", "提示",
							JOptionPane.WARNING_MESSAGE);
					passwordField.setText("");
				}
			}
		});
		frame.getContentPane().add(button);
	}
}