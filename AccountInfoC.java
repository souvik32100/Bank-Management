import java.lang.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;

public class AccountInfoC extends JFrame implements ActionListener
{
	private JLabel lb1,lb2,lb4,lb5,lb6,imgLabel;
	private JTextField tf1;
	private JButton bt1,bt2,bt3;
	private JPanel panel;
	private String cusName="",phnNo="",accNo="";
	private double balance=0;
	private EmployeeHome ch;
	private ImageIcon img;
	public AccountInfoC(EmployeeHome ch)
	{
		super("Customer Info");
		this.ch=ch;
		
		this.setSize(800,550);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel=new JPanel();
		panel.setLayout(null);
		Font f1 = new Font("Helvetica", Font.BOLD, 15);
		
		lb1=new JLabel("Account ID:  ");
		lb1.setBounds(100,100,150,40);
		lb1.setForeground(Color.WHITE);
		lb1.setFont(f1);
		panel.add(lb1);
		
		tf1=new JTextField();
		tf1.setBounds(210,100,150,40);
		panel.add(tf1);
		
		bt3=new JButton("Find");
		bt3.setBounds(370,100,80,40);
		bt3.addActionListener(this);
		panel.add(bt3);
		
		
		
		
		lb2=new JLabel("Customer Name : "+cusName);
		lb2.setForeground(Color.WHITE);
		lb2.setBounds(100,150,300,40);
		lb2.setFont(f1);
		panel.add(lb2);
		
		lb4=new JLabel("Balance 	:	 "+balance);
		lb4.setBounds(100,200,300,40);
		lb4.setForeground(Color.WHITE);
		lb4.setFont(f1);
		panel.add(lb4);
		
		lb5=new JLabel("Phone No 	: 	"+phnNo);
		lb5.setBounds(100,250,300,40);
		lb5.setForeground(Color.WHITE);
		lb5.setFont(f1);
		panel.add(lb5);
		
		lb6=new JLabel("Account No 	: 	"+accNo);
		lb6.setBounds(100,300,300,40);
		lb6.setForeground(Color.WHITE);
		lb6.setFont(f1);
		panel.add(lb6);
		
		
		bt1=new JButton("Back");
		bt1.setBounds(260,350,80,30);
		bt1.addActionListener(this);
		panel.add(bt1);
		
		bt2=new JButton("Logout");
		bt2.setBounds(400,350,80,30);
		bt2.addActionListener(this);
		panel.add(bt2);

		img = new ImageIcon("image.jpg");
		imgLabel = new JLabel(img);
		imgLabel.setBounds(0, 0, 800, 600);
		panel.add(imgLabel);
		
		this.add(panel);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource().equals(bt1))
		{
			ch.setVisible(true);
			this.setVisible(false);
			
		}
		else if(ae.getSource().equals(bt2))
		{
			Login l=new Login();
			l.setVisible(true);
			this.setVisible(false);
			
		}
		
		else if(ae.getSource().equals(bt3))
		{
			findInfo();
		}
		
		else{}
		
		
	}
	
	
	public void findInfo()
	{
		String query1 = "SELECT `Balance` FROM `account` where `accountNumber`=(SELECT `accountNumber` from `customer` where `Accountid`='"+tf1.getText()+"');";     
        String query2="SELECT * from `customer` where `accountid`='"+tf1.getText()+"'";
		Connection con=null;//for connection
        Statement st = null;//for query execution
		ResultSet rs = null;//to get row by row result from DB
		System.out.println(query1);
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");//load driver
			System.out.println("driver loaded");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oop1e14","root","");
			System.out.println("connection done");//connection with database established
			st = con.createStatement();//create statement
			System.out.println("statement created");
			rs = st.executeQuery(query1);//getting result
			System.out.println("results received");
			
			boolean flag=false;	
			while(rs.next())
			{
				
				balance=rs.getDouble("balance");
				flag=true;
				
				
				lb4.setText("Balance   :  "+balance);
				
				
			}
			rs = st.executeQuery(query2);
			while(rs.next())
			{
				accNo=rs.getString("AccountNumber");
				cusName=rs.getString("customerName");
				phnNo=rs.getString("phoneNumber");
				lb6.setText("Account No: "+accNo);
				flag=true;
				lb2.setText("Customer Name:"+cusName);
				lb5.setText("Phone No: "+"+880"+phnNo);
			}
			
			if(flag==false)
			{
				JOptionPane.showMessageDialog(this, "Not Found!!");
			}
			
		}
        catch(Exception ex)
		{
			System.out.println("Exception : " +ex.getMessage());
        }
		
		
	}
}