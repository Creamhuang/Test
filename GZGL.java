//���ʹ���_����Ա
package wage_management;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
public class GZGL extends JFrame implements ActionListener {

	JFrame f = new JFrame("���ʹ���");
	JButton b1 = new JButton("¼��");
	JButton b2 = new JButton("�޸�");
	JButton b3 = new JButton("ɾ��");
	JButton b4 = new JButton("��ѯ����");
	JButton b5 = new JButton("����");
	JTextField tf1 = new JTextField(4);
	JTextField tf2 = new JTextField(4);
	JTextField tf3 = new JTextField(4);
	JTextField tf4 = new JTextField(4);
	JTextField tf5 = new JTextField(6);
	JTextField tf6 = new JTextField(7);
	String[] cloum = { "ְ����", "����", "����", "�»�������","��н"};
	Object[][] row = new Object[30][5];
	JTable table = new JTable(row, cloum);
	JScrollPane scrollpane = new JScrollPane(table);//������
	JSplitPane splitpane = new JSplitPane(JSplitPane.VERTICAL_SPLIT);//�ָ�
	public void create() {
		JPanel p = (JPanel) f.getContentPane();
		p.setLayout(new FlowLayout());
		p.add(scrollpane);
		p.add(splitpane);
		JPanel p1 = new JPanel();
		p1.add(b1);
		p1.add(b2);
		p1.add(b3);
		p1.add(b4);
		p1.add(b5);
		JPanel p2 = new JPanel();
		//p2.setBackground(Color.gray);
		p2.add(scrollpane);
		JPanel p3 = new JPanel();
		p.setLayout(new FlowLayout());
		p.add(new JLabel(""));
		p.add(new JLabel("ְ����"));
		p.add(tf1);
		p.add(new JLabel("����"));
		p.add(tf2);
		p.add(new JLabel("����"));
		p.add(tf3);
		p.add(new JLabel("�»�������"));
		p.add(tf4);
		p.add(new JLabel("��н"));
		p.add(tf5);
		p.add(new JLabel("        �ڴ˴�����ְ���ŵ������ɾ��"));
		p.add(tf6);
		splitpane.add(p1, splitpane.TOP);
		splitpane.add(p2, splitpane.BOTTOM);
		splitpane.setDividerLocation(50);
		//p.setBackground(Color.gray);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		f.setBounds(400, 120, 500, 600);
		f.setResizable(true);// ���Ե��������С
		f.setVisible(true);
	}
	public void actionPerformed(ActionEvent e) {
		if (b1.equals(e.getSource())) { // ¼��
			Connection con;
			Statement sql;
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e1) {
				System.out.println("" + e1);
			}
			try {
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/wage management","root","123456");
				sql = con.createStatement();
				String insertStr = "INSERT INTO welfare (no,name,jt)VALUES('"+tf1.getText()+"','"+tf2.getText()+"','"+tf3.getText()+"');";

				sql.executeUpdate(insertStr);
				String insertStr1 = "INSERT INTO wageinfo (no,name,jb)VALUES('"+tf1.getText()+"','"+tf2.getText()+"','"+tf4.getText()+"');";
				sql.executeUpdate(insertStr1);
				con.close();
				JOptionPane.showMessageDialog(this, "¼��ɹ���");
			} catch (SQLException e1) {
				JOptionPane.showMessageDialog(this, "¼��ʧ�ܣ�");
			}
		}
		if (b2.equals(e.getSource())) {// �޸�
			Connection con;
			Statement sql;
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e1) {
				System.out.println("" + e1);
			}
			try {
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/wage management","root","123456");
				sql = con.createStatement();
				String updateStr = "UPDATE  welfare  SET jt='"+tf3.getText()+"',name='"+tf2.getText()+"'where no='"+tf1.getText()+"';";
				sql.executeUpdate(updateStr);
				String updateStr1 = "UPDATE  wageinfo  SET jb='"+tf4.getText()+"',name='"+tf2.getText()+"'where no='"+tf1.getText()+"';";
				sql.executeUpdate(updateStr1);
				JOptionPane.showMessageDialog(this, "�޸ĳɹ���");
				con.close();
			} catch (SQLException e1) {
				JOptionPane.showMessageDialog(this, "��Ϣ�����ڣ�");
			}
		}

		if (b3.equals(e.getSource())) {// ɾ��
			Connection con;
			Statement sql;
			ResultSet rs;
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e1) {
				System.out.println("" + e1);
			}
			try {
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/wage management","root","123456");
				sql = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
						ResultSet.CONCUR_READ_ONLY);
				sql.executeUpdate("DELETE FROM wageinfo  where  no='"+tf6.getText()+"';");
				sql.executeUpdate("DELETE FROM welfare  where  no='"+tf6.getText()+"';");
				JOptionPane.showMessageDialog(this, "ɾ���ɹ���");
				con.close();
			} catch (SQLException e1) {
				JOptionPane.showMessageDialog(this, "ɾ��ʧ�ܣ�");
			}

		}

		if (b4.equals(e.getSource())) {// ��ѯȫ��
			Connection con;
			Statement sql;
			ResultSet rs;
			//Vector vector = new Vector();
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e1) {
				JOptionPane.showMessageDialog(this, "�������ݿ�ʧ�ܣ�");
			}
			try {
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/wage management","root","123456");
				sql = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
						ResultSet.CONCUR_READ_ONLY);
				if (b4.equals(e.getSource())) {

					for (int i = 0; i < 30; i++)
						for (int j = 0; j < 4; j++)
							table.setValueAt("", i, j);
					rs = sql.executeQuery("select distinct * from  wageinfo ,welfare  where   wageinfo.name=welfare.name");
					int k = -1;
					while (rs.next()) {

						++k;
						String no = rs.getString(1);
						String name = rs.getString(2);
						String jb = rs.getString(3);
						String jt = rs.getString(6);
						int  sum=	rs.getInt(3)+rs.getInt(6);


						table.setValueAt(no, k, 0);
						table.setValueAt(name, k, 1);
						table.setValueAt(jb, k, 3);
						table.setValueAt(jt, k, 2);
						table.setValueAt(sum,k,4);

					}
				}
			} catch (SQLException e1) {
				JOptionPane.showMessageDialog(this, "��ѯʧ�ܣ�");
			}
		}

		if (b5.equals(e.getSource())) {// ����
			GZGLZJM gl=new GZGLZJM();
			gl.create();

			f.dispose();

		}
	}
}
