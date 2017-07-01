package waiterWindows;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class Wind {

	private JFrame frame;
	public Wind() {
		initialize();
	}
	private void initialize() {
		frame = new JFrame();
		frame.setVisible(true);
		frame.setBounds(100, 100, 550, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton button = new JButton("\u670D\u52A1\u5458");//服务员
		button.setBounds(99, 98, 107, 48);
		button.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
			
				Waiter waiter = new Waiter();
			}
		});
		frame.getContentPane().add(button);
		
		JButton btnNewButton = new JButton("\u53A8\u5E08");//厨师
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setBounds(312, 98, 107, 48);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u7BA1\u7406\u5458");//管理员
		btnNewButton_1.setBounds(99, 221, 107, 48);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("\u987E\u5BA2");//顾客
		btnNewButton_2.setBounds(312, 221, 107, 48);
		btnNewButton_2.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				Customer sCustomer=new Customer();	
			}
		});
		frame.getContentPane().add(btnNewButton_2);
		
		JLabel lblNewLabel = new JLabel("\u6B22\u8FCE\u5149\u4E34\u597D\u8FD0\u6765\u996D\u5E97");
		lblNewLabel.setBounds(195, 32, 138, 26);
		frame.getContentPane().add(lblNewLabel);
	}
}
