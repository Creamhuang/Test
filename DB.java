//系统登录
package wage_management;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

class DB extends JFrame implements ActionListener {
	JFrame frame = new JFrame("欢迎进入企业工资管理系统");
	JLabel label = new JLabel("", JLabel.CENTER);
	JButton button1 = new JButton("进入系统");
	JButton button2 = new JButton("退出系统");
	ImageIcon im = new ImageIcon("1.jpg");
	JLabel a1 = new JLabel(im);

	void Create() {
		JPanel pcontentPane = (JPanel) frame.getContentPane();
		pcontentPane.add(a1);
		pcontentPane.add(label);
		pcontentPane.setLayout(new FlowLayout());
		pcontentPane.add(button1);
		pcontentPane.add(button2);	
		pcontentPane.setVisible(true);
		button1.addActionListener(this);
		button2.addActionListener(this);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setBounds(400, 120, 550, 180);
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		DB dome = new DB();
		dome.Create();
	}

	public void actionPerformed(ActionEvent e) {//登录
		if (button1.equals(e.getSource())) {
			DL dl = new DL();
			dl.create();
			frame.dispose();

		}
		if (button2.equals(e.getSource())) {// 退出
			System.exit(0);

		}
	}
}
