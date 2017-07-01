package MenusOperate;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.JTableHeader;

import Dao.Main;

public class searchDishText extends JFrame {
	// 定义组件
	private JScrollPane scpDemo;
	private JTableHeader jth;
	private JTable tabDemo;
	private JButton btnShow;

	Main ma = new Main();
	// 构造方法
	public searchDishText() {
		// 窗体的相关属性的定义
		super("JTable数据绑定示例");
		this.setSize(330, 400);
		this.setLayout(null);
		this.setLocation(100, 50);
		// 创建组件
		this.scpDemo = new JScrollPane();
		this.scpDemo.setBounds(10, 50, 300, 270);
		this.btnShow = new JButton("显示数据");
		this.btnShow.setBounds(10, 10, 300, 30);
		// 给按钮注册监听
		this.btnShow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				try {
					btnShow_ActionPerformed(ae);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		// 将组件加入到窗体中
		add(this.scpDemo);
		add(this.btnShow);
		// 显示窗体
		this.setVisible(true);
	}

	// 点击按钮时的事件处理
	public void btnShow_ActionPerformed(ActionEvent ae) throws ClassNotFoundException {
		Statement statement = null;
		// 以下是连接数据源和显示数据的具体处理方法，请注意下
		try {
			Connection connection = ma.getConn();
			String sql = "select * from dishes"; 

			PreparedStatement pstm = connection.prepareStatement(sql);
			// 执行查询
			ResultSet resultSet = pstm.executeQuery();
			// 计算有多少条记录
			int count = 0;
			while(resultSet.next()){
			count++;
			}
			resultSet = pstm.executeQuery();
			JRadioButton rButton[]=new JRadioButton[count];
			Object[][] info = new Object[count][5];
			JRadioButton radioButton[]=new JRadioButton[count];
			count = 0;
			while (resultSet.next()) {
				info[count][0] = resultSet.getInt("id");
				//info[count][1]=radioButton[count].setText(resultSet.getString("name"));
				info[count][1] = resultSet.getString("name");
				info[count][2] = resultSet.getDouble("price");
				info[count][3] = resultSet.getInt("chief");
				info[count][4] = resultSet.getInt("type");
				count++;

			}
			// 定义表头
			String[] title = { "编号", "名称", "价格", "主厨", "类型" };
			// 创建JTable
			this.tabDemo = new JTable(info, title);
			// 显示表头
			this.jth = this.tabDemo.getTableHeader();
			// 将JTable加入到带滚动条的面板中
			this.scpDemo.getViewport().add(tabDemo);
		} catch (SQLException sqle) {
			JOptionPane.showMessageDialog(null, "数据操作错误", "错误",
					JOptionPane.ERROR_MESSAGE);
		}
	}
}