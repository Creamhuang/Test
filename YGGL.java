//Ա����Ϣ����_����Ա
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
public class YGGL extends JFrame implements ActionListener {

	JFrame f = new JFrame("Ա����Ϣ����");
	JButton b1 = new JButton("�����Ա����Ϣ");
	JButton b2 = new JButton("�޸�Ա����Ϣ");
	JButton b3 = new JButton("ɾ��Ա����Ϣ");
	JButton b4 = new JButton("��ѯ����Ա����Ϣ");
	JButton b5 = new JButton("����");
	JTextField tf1 = new JTextField(4);
	JTextField tf2 = new JTextField(4);
	JTextField tf3 = new JTextField(4);
	JTextField tf4 = new JTextField(4);
	JTextField tf5 = new JTextField(4);
	JTextField tf6 = new JTextField(4);
	JTextField tf7 = new JTextField(6);
	JTextField tf8 = new JTextField(7);
	
	String[] cloum = { "ְ����", "����", "�Ա�","����","�»�������", "����","��н","��½����"};
	Object[][] row = new Object[30][8];
	JTable table = new JTable(row, cloum);
	JScrollPane scrollpane = new JScrollPane(table);
	JSplitPane splitpane = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
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
		p.setLayout(new FlowLayout());
		p.add(new JLabel(""));
		p.add(new JLabel("ְ����"));
		p.add(tf1);
		p.add(new JLabel("����"));
		p.add(tf2);
		p.add(new JLabel("�Ա� "));
		p.add(tf3);
		p.add(new JLabel("����"));
		p.add(tf4);
		
		p.add(new JLabel("�»�������"));
		p.add(tf5);
		p.add(new JLabel("����"));
		p.add(tf6);
		p.add(new JLabel("��½����"));
		p.add(tf7);
		p.add(new JLabel("          �ڴ˴�����ְ���ŵ������ɾ��"));
		p.add(tf8);
		splitpane.add(p1, splitpane.TOP);
		splitpane.add(p2, splitpane.BOTTOM);
		splitpane.setDividerLocation(50);
	//	p.setBackground(Color.gray);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		f.setBounds(400, 120, 600, 600);
		f.setResizable(true);// ���Ե��������С
		f.setVisible(true);
	}
	public void actionPerformed(ActionEvent e) {
		if (b1.equals(e.getSource())) { // �����Ա����Ϣ
			Connection con;
			Statement sql;
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e1) {
				JOptionPane.showMessageDialog(this, "�������ݿ�ʧ�ܣ�");
			}
			try {
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/wage management","root","123456");
				sql = con.createStatement();
				String insertStr = "INSERT INTO welfare (no,name,jt)VALUES('"+tf1.getText()+"','"+tf2.getText()+"','"+tf6.getText()+"');";

				sql.executeUpdate(insertStr);
				String insertStr1 = "INSERT INTO wageinfo (no,name,jb)VALUES('"+tf1.getText()+"','"+tf2.getText()+"','"+tf5.getText()+"');";
				sql.executeUpdate(insertStr1);
				String insertStr2 = "INSERT INTO workerinfo (no,name,sex,department,password)VALUES('"+tf1.getText()+"','"+tf2.getText()+"','"+tf3.getText()+"','"+tf4.getText()+"','"+tf7.getText()+"');";
				sql.executeUpdate(insertStr2);
				JOptionPane.showMessageDialog(this, "��ӳɹ���");
				con.close();
			} catch (SQLException e1) {
				JOptionPane.showMessageDialog(this, "���ʧ�ܣ�");
			}
		}
		if (b2.equals(e.getSource())) {// �޸�Ա����Ϣ
			Connection con;
			Statement sql;
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e1) {
				JOptionPane.showMessageDialog(this, "�������ݿ�ʧ�ܣ�");
			}
			try {
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/wage management","root","123456");
				sql = con.createStatement();
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/wage management","root","123456");
				sql = con.createStatement();
				String updateStr = "UPDATE  welfare  SET jt='"+tf6.getText()+"',name='"+tf2.getText()+"'where no='"+tf1.getText()+"';";
				sql.executeUpdate(updateStr);
				String updateStr1 = "UPDATE  wageinfo  SET jb='"+tf5.getText()+"',name='"+tf2.getText()+"'where no='"+tf1.getText()+"';";
				sql.executeUpdate(updateStr1);
				
				sql.executeUpdate(updateStr1);
				String updateStr2 =  "UPDATE  workerinfo  SET name='"+tf2.getText()+"',sex='"+tf3.getText()+"',department='"+tf4.getText()+"',password='"+tf7.getText()+"'where no='"+tf1.getText()+"';";
				sql.executeUpdate(updateStr2);
				JOptionPane.showMessageDialog(this, "�޸ĳɹ���");
				con.close();
			} catch (SQLException e1) {
				JOptionPane.showMessageDialog(this, "�޸�ʧ�ܣ�");
			}
		}

		if (b3.equals(e.getSource())) {// ɾ��Ա����Ϣ
			Connection con;
			Statement sql;
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e1) {
				JOptionPane.showMessageDialog(this, "�������ݿ�ʧ�ܣ�");
			}
			try {
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/wage management","root","123456");
				sql = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
						ResultSet.CONCUR_READ_ONLY);
				sql.executeUpdate("DELETE FROM wageinfo  where  no='"+tf8.getText()+"';");
				sql.executeUpdate("DELETE FROM welfare  where  no='"+tf8.getText()+"';");
				sql.executeUpdate("DELETE FROM workerinfo  where  no='"+tf8.getText()+"';");
				JOptionPane.showMessageDialog(this, "ɾ���ɹ���");
				con.close();
			} catch (SQLException e1) {
				JOptionPane.showMessageDialog(this, "ɾ��ʧ�ܣ�");
			}

		}

		if (b4.equals(e.getSource())) {// ��ѯȫ��Ա����Ϣ
			Connection con;
			Statement sql;
			ResultSet rs;
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
						for (int j = 0; j < 6; j++)
							table.setValueAt("", i, j);
					rs = sql.executeQuery("select distinct * from  wageinfo ,welfare,workerinfo  where   wageinfo.no=welfare.no and wageinfo.no=workerinfo.no ;");
					int k = -1;
					while (rs.next()) {

						++k;
						String no = rs.getString("no");
						String name = rs.getString("name");
						String sex=rs.getString("sex");
						String department=rs.getString("department");
						String jb = rs.getString("jb");
						String jt = rs.getString("jt");
						int  sum=	rs.getInt("jb")+rs.getInt("jt");
						String mi = rs.getString("password");


						table.setValueAt(no, k, 0);//ְ�����
						table.setValueAt(name, k, 1);//ְ������
						table.setValueAt(sex, k, 2);//�Ա�
						table.setValueAt(department, k, 3);//����
						table.setValueAt(jb, k, 4);//ְ����������
						table.setValueAt(jt, k, 5);//����
						table.setValueAt(sum,k,6);//�ܹ���
						table.setValueAt(mi,k,7);//��¼����

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
