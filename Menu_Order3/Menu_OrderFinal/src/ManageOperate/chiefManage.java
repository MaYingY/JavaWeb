package ManageOperate;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class chiefManage implements ActionListener {

	private JFrame frame;
	JButton addChief;
	JButton delChief;
	JButton chiefMenu;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					chiefManage window = new chiefManage();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public chiefManage() {
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
		//标题
		JLabel lblNewLabel = new JLabel("\u53A8\u5E08\u7BA1\u7406");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 14));
		lblNewLabel.setBounds(214, 10, 69, 48);
		frame.getContentPane().add(lblNewLabel);
		//添加厨师
		addChief = new JButton("\u6DFB\u52A0\u53A8\u5E08");
		addChief.setBounds(190, 116, 112, 31);
		addChief.addActionListener(this);
		frame.getContentPane().add(addChief);
		//删除厨师
		delChief = new JButton("\u5220\u9664\u53A8\u5E08");
		delChief.setBounds(190, 194, 112, 31);
		delChief.addActionListener(this);
		frame.getContentPane().add(delChief);
		//厨师菜单
		chiefMenu = new JButton("\u67E5\u770B\u83DC\u54C1");
		chiefMenu.addActionListener(this);
		chiefMenu.setBounds(190, 274, 112, 31);
		frame.getContentPane().add(chiefMenu);
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == addChief) {
			add_Chief add = new add_Chief();
		}
		if(e.getSource() == delChief) {
			del_Chief del = new del_Chief();
		}
	}

}
