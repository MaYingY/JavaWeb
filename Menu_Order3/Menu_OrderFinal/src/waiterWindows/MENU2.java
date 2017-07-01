package waiterWindows;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import waiterManage.AddMenu;
import waiterManage.DeskDao;

public class MENU2 {

	private JFrame frame;
	public MENU2() {
		initialize();
	}
	private void initialize() {
		frame = new JFrame();
		frame.setVisible(true);
		frame.setBounds(100, 100, 550, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("欢迎光临好运来饭店");
		lblNewLabel.setBounds(202, 10, 141, 35);
		frame.getContentPane().add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 106, 257, 123);
		frame.getContentPane().add(panel);
		panel.setLayout(new GridLayout(4, 1, 0, 0));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 281, 257, 123);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(new GridLayout(2, 2, 0, 0));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(277, 106, 257, 123);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(new GridLayout(2, 2, 0, 0));
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(277, 281, 247, 123);
		frame.getContentPane().add(panel_3);
		panel_3.setLayout(new GridLayout(2, 2, 0, 0));
		
		JLabel lblNewLabel_1 = new JLabel("烧菜");
		lblNewLabel_1.setBounds(10, 81, 54, 15);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("凉菜");
		lblNewLabel_2.setBounds(277, 81, 54, 15);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("汤");
		lblNewLabel_3.setBounds(10, 256, 54, 15);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("特色菜");
		lblNewLabel_4.setBounds(277, 256, 54, 15);
		frame.getContentPane().add(lblNewLabel_4);
		int coun = 0;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager
					.getConnection(
							"jdbc:mysql://localhost:3306/menu?user=root&password=1&useUnicode=true&characterEncoding=utf-8",
							"root", "");
			String sql = "select * from dish";
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			
			while (resultSet.next()) {
				coun++;
			}
			resultSet = statement.executeQuery(sql);
			int i = 0;
			final JRadioButton button[] = new JRadioButton[coun];
			int flag=0;
			while (resultSet.next()) {
				String  nameString=resultSet.getString(2);
				double price = resultSet.getDouble(3);
				flag=resultSet.getInt(5);
				button[i] = new JRadioButton(nameString+" "+price);
				button[i].validate();
				if(flag==1){
					panel.add(button[i]);
				}
				else if(flag==3) {
					panel_1.add(button[i]);
				}
				else if(flag==2){
					panel_2.add(button[i]);
				}
				else {
					panel_3.add(button[i]);
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
			comboBox.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11"}));
			comboBox.setBounds(90, 41, 32, 21);
			frame.getContentPane().add(comboBox);

			final int num=coun;
			final JButton btnNewButton = new JButton("确认");
			btnNewButton.setBounds(204, 414, 93, 23);
			btnNewButton.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent arg0) {
					int j=0;
					AddMenu addmenu = new AddMenu();
					int desk=comboBox.getSelectedIndex()+1;
					DeskDao dao= new DeskDao();
					dao.change(desk, 1);
					while(j<num){
						if(button[j].isSelected()){
							addmenu.add(j+1, button[j].getText(), desk,1);	
						}
						j++;
					}
					JOptionPane.showMessageDialog(btnNewButton, "点餐成功", "提示", JOptionPane.WARNING_MESSAGE);
					frame.dispose();
				}
			});
			frame.getContentPane().add(btnNewButton);	
		} catch (Exception e) {
		}
	}
}
