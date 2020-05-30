import java.lang.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;
public class LastTransaction extends JFrame implements ActionListener
{
	private JLabel lb1,lb2,lb3,lb4,imgLabel;
	private JButton bt1,bt2;
	private JPanel panel;
	private String accNo,type,accId,date;
	private double amount=0;
	private CustomerHome ch;
	private ImageIcon img;
	public LastTransaction(String accId,CustomerHome ch)
	{
		super("Account Info");
		this.setSize(800,550);
		this.ch=ch;
		this.accId=accId;
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel=new JPanel();
		panel.setLayout(null);
		Font f1 = new Font("Helvetica", Font.BOLD, 20);
		lb3=new JLabel("Transferred to  :  "+accNo);
		lb3.setBounds(180,370,400,30);
		lb3.setForeground(Color.WHITE);
		lb3.setFont(f1);
		panel.add(lb3);

		findInfo(accId);

		

		accNo="";
		
		lb1=new JLabel("Transaction Type:  "+type);
		lb1.setBounds(180,160,400,30);
		lb1.setForeground(Color.WHITE);
		lb1.setFont(f1);
		panel.add(lb1);
		
		lb2=new JLabel("Amount   :  "+amount);
		lb2.setBounds(180,230,400,30);
		lb2.setForeground(Color.WHITE);
		lb2.setFont(f1);
		panel.add(lb2);

		lb4=new JLabel("Date :  "+date);
		lb4.setBounds(180,300,400,30);
		lb4.setForeground(Color.WHITE);
		lb4.setFont(f1);
		panel.add(lb4);
		
		
		
		bt1=new JButton("Back");
		bt1.setBounds(200,450,120,40);
		bt1.addActionListener(this);
		panel.add(bt1);
		
		bt2=new JButton("Logout");
		bt2.setBounds(380,450,120,40);
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
		String query = "SELECT * from `Transaction` where `accountNumber`=(select `accountNumber` from Customer where accountId='"+id+"');";     
        String query2="SELECT * from Transaction2 where `accountNumber`=(select `accountNumber` from Customer where accountId='"+id+"');";
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
				amount=rs.getDouble("amount");
				type=rs.getString("Transactiontype");
				date=rs.getString("Date");


			}
			rs=st.executeQuery(query2);
			while(rs.next())
			{
				
				accNo=rs.getString("SendTo");
				lb3.setText("Transferred to  :  "+accNo);
				System.out.println("Transferred to  :  "+accNo);


			}
		}
        catch(Exception ex)
		{
			System.out.println("Exception : " +ex.getMessage());
        }
	}
}