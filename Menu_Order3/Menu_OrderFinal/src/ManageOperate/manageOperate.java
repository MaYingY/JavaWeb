package ManageOperate;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;

import WindowsAll.menuManage;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class manageOperate implements ActionListener{

	private JFrame frame;
	JButton chiefManage;
	private JButton waiterManage;
	private JButton menuSearch;

	/**
	 * Launch the application.
	 */
	/**
	 * Create the application.
	 */
	public manageOperate() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(300,300, 550, 400);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		//标题
		JLabel headName = new JLabel("\u6B22\u8FCE\u6765\u5230\u597D\u8FD0\u6765\u996D\u5E97\uFF01");
		headName.setBounds(187, 26, 147, 41);
		frame.getContentPane().add(headName);
		//厨师管理
		chiefManage = new JButton("\u53A8\u5E08\u7BA1\u7406");
		chiefManage.setBounds(172, 115, 110, 41);
		chiefManage.addActionListener(this);
		frame.getContentPane().add(chiefManage);
		//服务员管理
		waiterManage = new JButton("\u670D\u52A1\u5458\u7BA1\u7406");
		waiterManage.setBounds(172, 195, 110, 41);
		waiterManage.addActionListener(this);
		frame.getContentPane().add(waiterManage);
		//菜单管理
		menuSearch = new JButton("\u83DC\u5355\u67E5\u8BE2");
		menuSearch.setBounds(172, 274, 110, 46);
		menuSearch.addActionListener(this);
		frame.getContentPane().add(menuSearch);
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == chiefManage) {
			chiefManage chief = new chiefManage();
		}
		if(e.getSource() == waiterManage) {
			waiterManage waiter = new waiterManage();
		}
		if(e.getSource() == menuSearch) {
			chiefMenu chief = new chiefMenu();
		}
	}
}
