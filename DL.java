//����Ա����ͨ�û���¼
package wage_management;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

class DL extends JFrame implements ActionListener 
{
	public DL() {
	}
	ImageIcon im = new ImageIcon("2.jpg");
	JLabel a2 = new JLabel(im);
	JFrame frame = new JFrame("ְ��/����Ա��½");
	JLabel label1 = new JLabel("�û���");
	JLabel label2 = new JLabel("����");
	JButton logonButton1 = new JButton("����Ա��¼");
	JButton logonButton2 = new JButton("ְ����¼");
	JButton cancelButton = new JButton("�˳�");


	JTextField username = new JTextField(9);
	JPasswordField password = new JPasswordField(9);
	static String t1;
	static String t2;



	public void create() 
	{
		JPanel p = (JPanel) frame.getContentPane();
		JPanel p1 = new JPanel();
		p.setLayout(new FlowLayout());
		p.add(a2);
		p.add(label1);
		p.setSize(5, 5);
		p.setLocation(4, 8);
		
		p.add(username);
		p.setSize(100, 200);
		p.setLocation(800, 800);
		
		p.add(label2);
		p.setSize(50, 20);
		p.setLocation(40, 80);
		
		p.add(password);
		p.setSize(100, 20);
		p.setLocation(80, 120);
		
		p.add(logonButton1);

		p.add(logonButton2);

		p.add(cancelButton);

		//p.setBackground(Color.gray);
		p.setVisible(true);
		logonButton1.addActionListener(this);
		logonButton2.addActionListener(this);
		cancelButton.addActionListener(this);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setBounds(400, 120, 500, 220);
		frame.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) 
	{

		t1 = username.getText();
		t2 = password.getText();
		if(e.getSource()==logonButton1)
		{
			if( username.getText().equals("admin") == true
					&& (password.getText().equals("admin") == true)) 
			{
				JOptionPane.showMessageDialog(this, "��¼�ɹ���");
				GZGLZJM gz = new GZGLZJM();
				gz.create();
				frame.dispose();
			} 
			else {
				JOptionPane.showMessageDialog(null, "�����û������������");
			}

		}
		if (e.getSource()==logonButton2)
		{
			try {
				Connection con;
				Statement ps;
				ResultSet rs;
				String sql = null;
				Class.forName("com.mysql.jdbc.Driver");
				Class.forName("com.mysql.jdbc.Driver").newInstance();
				con = DriverManager.getConnection( 
						"jdbc:mysql://localhost:3306/wage management","root","123456"); 
				sql="select  * from  workerinfo where name='"+t1+"' and password='"+t2+"'";
				ps = (PreparedStatement) con.prepareStatement(sql);

				rs = ps.executeQuery(sql);

				if(rs.next())
				{
					if(rs.getString("name").equals(t1) && rs.getString("password").equals(t2))
					{
						YGDLJM yg = new YGDLJM();
						yg.create();
						frame.dispose();
						JOptionPane.showMessageDialog(this, "��¼�ɹ���");
						this.dispose();
					}
				}
				else {

					JOptionPane.showMessageDialog(this, "�����û������������");
				}
			}catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if (cancelButton.equals(e.getSource())) // �˳�

		{
			System.exit(0);
		}
	}
}

