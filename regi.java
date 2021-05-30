import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.ButtonGroup;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.JList;

public class regi extends JFrame {

	private JPanel contentPane;
	private JTextField user;
	private JTextField efield;
	private JTextField pass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					regi frame = new regi();
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
	public regi() {
		getContentPane().setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 483);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		user = new JTextField();
		user.setBounds(131, 82, 102, 20);
		contentPane.add(user);
		user.setColumns(10);
	
		efield = new JTextField();
		efield.setBounds(131, 130, 102, 20);
		contentPane.add(efield);
		efield.setColumns(10);
		
		pass = new JTextField();
		pass.setBounds(131, 185, 102, 20);
		contentPane.add(pass);
		pass.setColumns(10);
		
		ButtonGroup group = new ButtonGroup();
		
		JLabel email = new JLabel("Email");
		email.setFont(new Font("Calibri", Font.BOLD, 14));
		email.setBounds(23, 136, 46, 14);
		contentPane.add(email);
		
		JLabel Pass = new JLabel("Password");
		Pass.setFont(new Font("Calibri", Font.BOLD, 14));
		Pass.setBounds(23, 182, 62, 30);
		contentPane.add(Pass);
		
		JLabel username = new JLabel("Username");
		username.setFont(new Font("Calibri", Font.BOLD, 14));
		username.setBounds(23, 88, 62, 14);
		contentPane.add(username);
		
		JRadioButton male = new JRadioButton("Male");
		male.setSelected(true);
		male.setBounds(107, 262, 109, 23);
		contentPane.add(male);
		
		JRadioButton female = new JRadioButton("Female");
		female.setSelected(true);
		female.setBounds(239, 262, 109, 23);
		contentPane.add(female);
		
		ButtonGroup Group = new ButtonGroup();
	    group.add(male);
	    group.add(female);
	 
	    if(male.isSelected()) {
	    	System.out.println("Male");
	    }else {
	    	System.out.println("female");
	    }
		
		JLabel registration = new JLabel("Registration Form");
		registration.setFont(new Font("Calibri", Font.BOLD, 16));
		registration.setBounds(140, 11, 132, 41);
		contentPane.add(registration);
		
		JButton Cancel = new JButton("Cancel");
		Cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login l1= new Login();
		        l1.setSize(550, 450); 
		        l1.setVisible(true);
			}
		});
		Cancel.setBounds(193, 319, 89, 23);
		contentPane.add(Cancel);
		
		JButton submit = new JButton("submit");
		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Gender=null;
				if(male.isSelected())
				{
					Gender="Male";
				}
				if(female.isSelected()) {
					Gender="Female";
				}
					
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/regis","root","root");
					PreparedStatement ps=conn.prepareStatement("insert into user(Username,email,password,Gender)values(?,?,?,?);");
					ps.setString(1,user.getText());
					ps.setString(2,efield.getText());
					ps.setString(3,pass.getText());
					ps.setString(4,Gender);
					
					
					int x=ps.executeUpdate();
					if(x>0) {
						System.out.println("Registration is Succeful...");
						
						JOptionPane.showMessageDialog(submit,"You have succesfully register login now ");
						home h1=new home();
						
						h1.show();
						h1.setVisible(true);
						dispose();

						
					}else {
						JOptionPane.showMessageDialog(submit,"Registration Unsucceful");

					}

				
				}catch(Exception e1) {
					System.out.println(e1);
				}
			
				
			}
		});
		submit.setBounds(81, 319, 89, 23);
		contentPane.add(submit);
		
		
		
		JLabel lblNewLabel = new JLabel("Gender");
		lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 14));
		lblNewLabel.setBounds(23, 266, 62, 14);
		contentPane.add(lblNewLabel);
		
		
		
	}
}
