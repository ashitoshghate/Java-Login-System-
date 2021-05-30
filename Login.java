import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 363, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Login For Exam");
		lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 18));
		lblNewLabel.setBounds(108, 11, 134, 32);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("UserName");
		lblNewLabel_1.setFont(new Font("Calibri", Font.BOLD, 12));
		lblNewLabel_1.setBounds(49, 79, 101, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setFont(new Font("Calibri", Font.BOLD, 12));
		lblNewLabel_2.setBounds(59, 109, 61, 14);
		contentPane.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(120, 74, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(120, 104, 86, 20);
		contentPane.add(passwordField);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
			 
				try{  
					 Class.forName("com.mysql.jdbc.Driver"); 
					Connection conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/regis","root","root");
					      
					PreparedStatement ps=conn.prepareStatement("select Username,password from user where Username=? And password=?;");  
					ps.setString(1,textField.getText());  
					ps.setString(2,passwordField.getText());  
					
					ResultSet rs=ps.executeQuery();  
					while (rs.next()) {
						String user=rs.getString("Username");
						String pass=rs.getString("password");
						JOptionPane.showMessageDialog(btnNewButton,"You have succesfully login ");
						System.out.println("Username: "+rs.getString("Username"));
						System.out.println("Password: "+rs.getString("password"));
						System.out.println("Login Success");
					}
					
					home h1=new home();
					
					h1.show();
					h1.setVisible(true);
					dispose();

				
				     ps.close();
					 
					  
					
					/*	
						
					*/
					

				      
					}catch(SQLException e1)
				
				{
						  e1.printStackTrace();
						} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}  
					
					}  
				
				
					
				
				
				
			
		});
		btnNewButton.setBounds(108, 170, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Register");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				regi r1= new regi();
		        r1.setSize(550, 450); 
		        r1.setVisible(true);
		       
		   dispose();
			}
		});
		btnNewButton_1.setBounds(204, 170, 89, 23);
		contentPane.add(btnNewButton_1);
	}
}
