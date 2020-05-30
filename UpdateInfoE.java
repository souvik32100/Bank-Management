import java.lang.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;


public class UpdateInfoE extends JFrame implements ActionListener
{
	private JLabel lb1,lb2,lb3,imgLabel;
	private JTextField tf1,tf2;
	private JButton bt1,bt2,bt3,bt4;
	private String accid;
	private EmployeeHome ch;
	private String empName,empPhone;
	private JPanel panel;
	private ImageIcon img;
	public UpdateInfoE(String accid, EmployeeHome ch)
	{
		super("Update My Info");
		this.accid=accid;
		this.ch=ch;
		this.setSize(550,500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel=new JPanel();
		panel.setLayout(null);
		Font f1 = new Font("Helvetica", Font.BOLD, 15);
		
		findInfo(accid);
		
		lb1=new JLabel("Name :");
		lb1.setBounds(80,70,150,40);
		lb1.setForeground(Color.WHITE);
		lb1.setFont(f1);		
		panel.add(lb1);
		
		tf1=new JTextField(empName);
		tf1.setBounds(240,70,150,40);
		panel.add(tf1);
		
		lb2=new JLabel("Phone :");
		lb2.setBounds(80,130,150,40);
		lb2.setFont(f1);
		lb2.setForeground(Color.WHITE);
		
		panel.add(lb2);

		lb3=new JLabel("+880");
		lb3.setBounds(190,130,550,40);
		lb3.setFont(f1);
		lb3.setForeground(Color.WHITE);
		panel.add(lb3);

		tf2=new JTextField(empPhone);
		tf2.setBounds(240,130,150,40);
		panel.add(tf2);
		
		bt1=new JButton("Change Password");
		bt1.setBounds(100,240,150,40);
		bt1.addActionListener(this);
		panel.add(bt1);
		
		bt2=new JButton("Back");
		bt2.setBounds(100,300,150,40);
		bt2.addActionListener(this);
		panel.add(bt2);
		
		bt3=new JButton("Logout");
		bt3.setBounds(270,240,150,40);
		bt3.addActionListener(this);
		panel.add(bt3);
		
		bt4=new JButton("Update");
		bt4.setBounds(270,300,150,40);
		bt4.addActionListener(this);
		panel.add(bt4);
		
		img = new ImageIcon("image.jpg");
		imgLabel = new JLabel(img);
		imgLabel.setBounds(0, 0, 800, 600);
		panel.add(imgLabel);
		
		this.add(panel);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource().equals(bt2))
		{
			ch.setVisible(true);
			this.setVisible(false);
			
		}
		else if(ae.getSource().equals(bt3))
		{
			Login l=new Login();
			l.setVisible(true);
			this.setVisible(false);
			
		}
		else if(ae.getSource().equals(bt4))
		{
			updateDB(accid);
			
			ch.setVisible(true);
			this.setVisible(false);
			
		}
		else if(ae.getSource().equals(bt1))
		{
			PasswordChangeE p=new PasswordChangeE(accid,this);
			p.setVisible(true);
			this.setVisible(false);
			
		}
		
		else{}
		
		
	}
	
	public void findInfo(String id)
	{
		String query = "SELECT * from `employee` where `accountid`='"+id+"';";     
        Connection con=null;//for connection
        Statement st = null;//for query execution
		ResultSet rs = null;//to get row by row result from DB
		System.out.println(query);
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");//load driver
			System.out.println("driver loaded");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oop1e14","root","");
			System.out.println("connection done");//connection with database established
			st = con.createStatement();//create statement
			System.out.println("statement created");
			rs = st.executeQuery(query);//getting result
			System.out.println("results received");
			
				
			while(rs.next())
			{
				empName=rs.getString("empName");
				empPhone=rs.getString("phoneNumber");			
				
			}
			
		}
        catch(Exception ex)
		{
			System.out.println("Exception : " +ex.getMessage());
        }
	}
	
	public void updateDB(String id)
	{
		
		String query = "UPDATE `employee` set empName='"+tf1.getText()+"',phoneNumber='"+tf2.getText()+"' WHERE AccountId='"+id+"'";	
        Connection con=null;//for connection
        Statement st = null;//for query execution
		System.out.println(query);
		
		try
		{
			double x=Double.parseDouble(tf2.getText());
			Class.forName("com.mysql.jdbc.Driver");//load driver
			System.out.println("driver loaded");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oop1e14","root","");
			System.out.println("connection done");//connection with database established
			st = con.createStatement();//create statement
			System.out.println("statement created");
			st.executeUpdate(query);//getting result
			
			JOptionPane.showMessageDialog(this,"Succesfuly Updated"); 
			
		}
        catch(Exception ex)
		{
			JOptionPane.showMessageDialog(this,"No Character Allow in phone number"); 
        }
		
	}
	
}