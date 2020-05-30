import java.lang.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;
public class EmployeeHome extends JFrame implements ActionListener
{
	private JButton bt1,bt2,bt3,bt4,bt5,bt6,bt7,bt8,bt9;
	private JLabel lb1,imgLabel;
	private JPanel panel;
	private String accId,role;
	private ImageIcon img;
	public EmployeeHome(String accId)
	{
		super("Employee Home");
		this.accId=accId;
		this.setSize(800,550);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel=new JPanel();
		panel.setLayout(null);

		Font f1 = new Font("Helvetica", Font.BOLD, 15);
		
		
		findDB(accId);
		
		lb1=new JLabel("Welcome, "+accId);
        lb1.setBounds(50,40,150,30);
        lb1.setForeground(Color.GREEN);
        lb1.setFont(f1);
		panel.add(lb1);
		
		bt1=new JButton("My Info");
		bt1.setBounds(150,100,200,40);
		bt1.addActionListener(this);
		panel.add(bt1);
		
		bt2=new JButton("Customer Info");
		bt2.setBounds(450,100,200,40);
		bt2.addActionListener(this);
		panel.add(bt2);
		
		bt3=new JButton("Update My Info");
		bt3.setBounds(150,160,200,40);
		bt3.addActionListener(this);
		panel.add(bt3);
		
		bt4=new JButton("Create Account");
		bt4.setBounds(450,160,200,40);
		bt4.addActionListener(this);
		panel.add(bt4);
		
		bt5=new JButton("Withdraw/Deposit/Transfer");
		bt5.setBounds(150,220,500,40);
		bt5.addActionListener(this);
		panel.add(bt5);
		
	if(role.equals("Manager")){
		
		bt7=new JButton("Employee Info");
		bt7.setBounds(150,280,500,40);
		bt7.addActionListener(this);
		panel.add(bt7);
		
		bt8=new JButton("Add Employee");
		bt8.setBounds(150,340,500,40);
		bt8.addActionListener(this);
		panel.add(bt8);
		
		bt9=new JButton("Update Employee Info");
		bt9.setBounds(150,400,500,40);
		bt9.addActionListener(this);
		panel.add(bt9);
		
		
		
		}
		
		bt6=new JButton("Logout");
		bt6.setBounds(650,10,100,40);
		bt6.addActionListener(this);
		panel.add(bt6);
		
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
			OwnInfoE e=new OwnInfoE(accId,this);
			e.setVisible(true);
			this.setVisible(false);
		}
		
		else if(ae.getSource().equals(bt2))
		{
			AccountInfoC c=new AccountInfoC(this);
			c.setVisible(true);
			this.setVisible(false);
			
		}
		else if(ae.getSource().equals(bt6))
		{
			Login o=new Login();
			o.setVisible(true);
			this.setVisible(false);
		}
		else if(ae.getSource().equals(bt4))
		{
			CreatCustomer c=new CreatCustomer(this);
			c.setVisible(true);
			this.setVisible(false);
		}
		else if(ae.getSource().equals(bt3))
		{
			UpdateInfoE c=new UpdateInfoE(accId,this);
			c.setVisible(true);
			this.setVisible(false);
		}
		else if(ae.getSource().equals(bt7))
		{
			EmployeeInfo e=new EmployeeInfo(this);
			e.setVisible(true);
			this.setVisible(false);
		}
		else if(ae.getSource().equals(bt9))
		{
			UpdateEmp e=new UpdateEmp(this);
			e.setVisible(true);
			this.setVisible(false);
		}

		else if(ae.getSource().equals(bt5))
		{
			Transaction e=new Transaction(this);
			e.setVisible(true);
			this.setVisible(false);
		}
		else if(ae.getSource().equals(bt8))
		{
			CreatEmp e=new CreatEmp(this);
			e.setVisible(true);
			this.setVisible(false);
		}
		

	}
	
	public void findDB(String id)
	{
		String query = "SELECT `role` FROM `employee` where `accountid`='"+id+"';";     
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
				role=rs.getString("role");
				System.out.println(role);		
				
			}
			
		}
        catch(Exception ex)
		{
			System.out.println("Exception : " +ex.getMessage());
        }
		
		
	}
	
}