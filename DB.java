//ϵͳ��¼
package wage_management;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

class DB extends JFrame implements ActionListener {
	JFrame frame = new JFrame("��ӭ������ҵ���ʹ���ϵͳ");
	JLabel label = new JLabel("", JLabel.CENTER);
	JButton button1 = new JButton("����ϵͳ");
	JButton button2 = new JButton("�˳�ϵͳ");
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

	public void actionPerformed(ActionEvent e) {//��¼
		if (button1.equals(e.getSource())) {
			DL dl = new DL();
			dl.create();
			frame.dispose();

		}
		if (button2.equals(e.getSource())) {// �˳�
			System.exit(0);

		}
	}
}
