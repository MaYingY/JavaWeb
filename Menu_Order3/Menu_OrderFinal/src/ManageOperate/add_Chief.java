package ManageOperate;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JTextField;
import javax.swing.JButton;

import Dao.ManageOperate;

public class add_Chief implements ActionListener {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	JButton btnNewButton;
	JButton btnNewButton_1;

	/**
	 * Create the application.
	 */
	public add_Chief() {
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
		
		JLabel lblNewLabel = new JLabel("\u6DFB\u52A0\u53A8\u5E08");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 14));
		lblNewLabel.setBounds(210, 26, 78, 24);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u7F16\u53F7");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(125, 108, 54, 15);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u59D3\u540D");
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(125, 183, 54, 15);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("\u5BC6\u7801");
		lblNewLabel_3.setFont(new Font("宋体", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(125, 248, 54, 15);
		frame.getContentPane().add(lblNewLabel_3);
		
		textField = new JTextField();
		textField.setBounds(210, 105, 151, 21);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(210, 180, 151, 21);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(210, 245, 151, 21);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		btnNewButton = new JButton("\u6DFB\u52A0");
		btnNewButton.setBounds(143, 300, 93, 23);
		btnNewButton.addActionListener(this);
		frame.getContentPane().add(btnNewButton);
		
		btnNewButton_1 = new JButton("\u91CD\u7F6E");
		btnNewButton_1.setBounds(268, 300, 93, 23);
		frame.getContentPane().add(btnNewButton_1);
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//添加
		if(e.getSource() == btnNewButton) {
			int id = Integer.parseInt(textField.getText());
			ManageOperate man = new ManageOperate();
			try {
				man.addChief(id, textField_1.getText(), textField_2.getText());
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

}
