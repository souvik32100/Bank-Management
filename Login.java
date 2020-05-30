import java.lang.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;
public class Login extends JFrame implements ActionListener
{
	private JButton bt1,bt2;
	private JLabel lb1,lb2,imgLabel,wlcm,prcd;
	private JTextField text;
	private JPasswordField passField;
	private JPanel panel;
	private ImageIcon img;
	
	public Login()
	{
		super("Login");
		this.setSize(800,550);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel=new JPanel();
		panel.setLayout(null);

		Font f1 = new Font("Helvetica", Font.BOLD, 22);
		Font f2 = new Font("Helvetica", Font.BOLD, 18);

		wlcm= new JLabel("Welcome");
		wlcm.setBounds(330,50,100,50);
		wlcm.setFont(f1);
		wlcm.setForeground(Color.cyan);
		panel.add(wlcm);

		prcd= new JLabel("Please enter your login credentials to proceed");
		prcd.setBounds(190,100,450,50);
		prcd.setFont(f2);
		prcd.setForeground(Color.cyan);
		panel.add(prcd);

		lb1=new JLabel("User ID:");
        lb1.setBounds(250,200,100,30);
        lb1.setForeground(Color.WHITE);
		panel.add(lb1);
		
		lb2= new JLabel("Password:");
		lb2.setBounds(250,270,100,30);
		lb2.setForeground(Color.WHITE);
		panel.add(lb2);
		
		text=new JTextField();
		text.setBounds(380,200,100,30);
		panel.add(text);
		
		passField=new JPasswordField();
		passField.setBounds(380,270,100,30);
		panel.add(passField);
		
		bt1=new JButton("LOGIN");
		bt1.setBounds(260,350,80,30);
		bt1.addActionListener(this);
		panel.add(bt1);
		
		bt2=new JButton("EXIT");
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
		String text = ae.getActionCommand();
		
		if(text.equals(bt1.getText()))
		{
			checkLogin();
		}
		else if(text.equals(bt2.getText()))
		{
			System.exit(0);
		}
		else{}
	}
	
	public void checkLogin()
	{
		String query = "SELECT `accountId`, `password`, `status` FROM `login`;";     
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
			
			boolean flag = false;			
			while(rs.next())
			{
                String userId = rs.getString("accountId");
                String password = rs.getString("password");
				int status = rs.getInt("status");
				
				if(userId.equals(text.getText()) && password.equals(passField.getText()))
				{
					flag=true;
					if(status==1)
					{
						EmployeeHome eh = new EmployeeHome(userId);
						eh.setVisible(true);
						this.setVisible(false);
					}
					else if(status==0)
					{
						CustomerHome ch = new CustomerHome(userId);
						ch.setVisible(true);
						this.setVisible(false);
					}
					else{}
				}
			}
			if(!flag)
			{
				JOptionPane.showMessageDialog(this,"Invalid ID or Password"); 
			}
		}
        catch(Exception ex)
		{
			System.out.println("Exception : " +ex.getMessage());
        }
        finally
		{
            try
			{
                if(rs!=null)
					rs.close();

                if(st!=null)
					st.close();

                if(con!=null)
					con.close();
            }
            catch(Exception ex){}
        }
	}
	
	
}