import java.lang.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;
public class AccountInfo extends JFrame implements ActionListener
{
	private JLabel lb1,lb2,imgLabel;
	private JButton bt1,bt2;
	private JPanel panel;
	private String accid,acc;
	private double balance;
	private CustomerHome ch;
	private ImageIcon img;
	public AccountInfo(String accid,CustomerHome ch)
	{
		super("My Balance");
		this.ch=ch;
		this.accid=accid;
		this.setSize(800,550);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel=new JPanel();
		panel.setLayout(null);
		findInfo(accid);
		
		Font f1 = new Font("Helvetica", Font.BOLD, 20);

		lb1=new JLabel("Account Number:  "+acc);
		lb1.setBounds(180,180,400,30);
		lb1.setForeground(Color.WHITE);
		lb1.setFont(f1);
		panel.add(lb1);
		
		lb2=new JLabel("Balance   :  "+balance);
		lb2.setBounds(180,250,400,30);
		lb2.setForeground(Color.WHITE);
		lb2.setFont(f1);
		panel.add(lb2);
		
		bt1=new JButton("Back");
		bt1.setBounds(200,350,120,40);
		bt1.addActionListener(this);
		panel.add(bt1);
		
		bt2=new JButton("Logout");
		bt2.setBounds(380,350,120,40);
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
		else{}
		
		
	}
	
	
	public void findInfo(String id)
	{
		String query = "SELECT `accountNumber`, `balance` FROM `account` where `accountNumber`=(SELECT `accountNumber` from `customer` where `accountid`='"+id+"');";     
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
				acc=rs.getString("AccountNumber");
				balance=rs.getDouble("balance");			
				
			}
			
		}
        catch(Exception ex)
		{
			System.out.println("Exception : " +ex.getMessage());
        }
		
		
	}
}