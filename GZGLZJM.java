//���ʹ������
package wage_management;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

class GZGLZJM extends JFrame implements ActionListener {

	JFrame f = new JFrame("���ʹ���ϵͳ");
	JButton b1 = new JButton("���ʹ���");
	JButton b2 = new JButton("Ա����Ϣ����");
	JButton b3 = new JButton("����");
	ImageIcon im = new ImageIcon("3.jpg");
	JLabel a1 = new JLabel(im);

	void create() {
		JPanel p = (JPanel) f.getContentPane();//��ʼ��������
		p.setLayout(new FlowLayout());
		p.add(a1);
		p.add(b1);
		p.add(b2);
		p.add(b3);

		//p.setBackground(Color.gray);
		p.setVisible(true);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		f.setBounds(400, 120, 500, 200);
		f.setVisible(true);

	}

	public void actionPerformed(ActionEvent e) {

		if (b3.equals(e.getSource())) {// ����
			DL d = new DL();
			d.create();
			f.dispose();
		}

		if (b2.equals(e.getSource())) {// Ա����Ϣ����
			YGGL yg = new YGGL();
			yg.create();
			f.dispose();
		}
		if (b1.equals(e.getSource())) {// ���ʹ���


			GZGL gz = new GZGL();
			gz.create();
			f.dispose();
		}
	}
}

