package ManageOperate;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class waiterManage implements ActionListener {

	private JFrame frame;
	JButton addChief;
	JButton delChief;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					waiterManage window = new waiterManage();
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
	public waiterManage() {
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
		JLabel lblNewLabel = new JLabel("\u670D\u52A1\u5458\u7BA1\u7406");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 14));
		lblNewLabel.setBounds(200, 10, 88, 48);
		frame.getContentPane().add(lblNewLabel);
		//添加服务员
		addChief = new JButton("\u6DFB\u52A0\u670D\u52A1\u5458");
		addChief.setBounds(190, 116, 112, 31);
		addChief.addActionListener(this);
		frame.getContentPane().add(addChief);
		//删除服务员
		delChief = new JButton("\u5220\u9664\u670D\u52A1\u5458");
		delChief.setBounds(190, 194, 112, 31);
		delChief.addActionListener(this);
		frame.getContentPane().add(delChief);
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == addChief) {
			add_Waiter add = new add_Waiter();
		}
		if(e.getSource() == delChief) {
			del_Waiter del = new del_Waiter();
		}
	}

}
