import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.ButtonGroup;
import javax.swing.ButtonGroup;
import javax.swing.ButtonGroup;
import javax.swing.ButtonGroup;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;

public class JavaExam extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JavaExam frame = new JavaExam();
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
	public JavaExam() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 361, 438);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Q1.Which is the latest version of JDK?");
		lblNewLabel.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblNewLabel.setBounds(20, 33, 292, 14);
		contentPane.add(lblNewLabel);
		
		
		JRadioButton b1 = new JRadioButton("JDK 15");
		b1.setBounds(20, 54, 109, 23);
		contentPane.add(b1);

		
		JRadioButton b2 = new JRadioButton("JDK 8.5");
		b2.setBounds(20, 105, 109, 23);
		contentPane.add(b2);
		
		JRadioButton b3 = new JRadioButton("JDK 9");
		b3.setBounds(20, 154, 109, 23);
		contentPane.add(b3);
		
		JRadioButton b4 = new JRadioButton("JDK 16");
		b4.setBounds(20, 206, 109, 23);
		contentPane.add(b4);
		
		ButtonGroup group = new ButtonGroup();
	    group.add(b1);
	    group.add(b2);
	    group.add(b3);
	    group.add(b4);
	    String Correct="JDK 16";
	   
	    JButton btnNewButton = new JButton("Save");
	    btnNewButton.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		String User_Ans=null;
	    		if(b1.isSelected()) {
	    			User_Ans="JDK 15";
	    		}
	    		if(b2.isSelected()) {
	    			User_Ans="JDK 8.5";
	    		}
	    		if(b3.isSelected()) {
	    			User_Ans="JDK 9";
	    		}
	    		if(b4.isSelected()) {
	    			User_Ans="JDK 16";
	    		}
	    		
	    		try {
	    			Class.forName("com.mysql.jdbc.Driver");
	    			Connection conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/regis","root","root");
					PreparedStatement ps=conn.prepareStatement("insert into Ans_data(Q_no,Correct_Ans,users_ans)values(?,?,?);");
					ps.setInt(1,1);
					ps.setString(2,Correct);
					ps.setString(3,User_Ans);
				
					int x=ps.executeUpdate();
				
	    			
	    		}catch(Exception e1){
	    			System.out.println(e1);
	    			
	    		}
	    		
	    	}
	    });
	    btnNewButton.setBounds(65, 328, 89, 23);
	    contentPane.add(btnNewButton);
	    
	    JButton Q2 = new JButton("Next");
	    Q2.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		Q2 q2=new Q2();
				
				q2.show();
				q2.setVisible(true);
				dispose();
	    	}
	    });
	    Q2.setBounds(167, 328, 89, 23);
	    contentPane.add(Q2);
	    
	  
	    
	}	

	public void showJavaExam() {
		// TODO Auto-generated method stub
		
	}
}
