import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.sun.jdi.connect.spi.Connection;

import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.awt.event.ActionEvent;
import java.sql.*;

public class Q2 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Q2 frame = new Q2();
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
	public Q2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 471);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Q2.What is the new name of java ?");
		lblNewLabel.setBounds(10, 43, 308, 27);
		contentPane.add(lblNewLabel);
		
		JRadioButton ans1 = new JRadioButton("None of this ");
		ans1.setBounds(22, 116, 109, 23);
		contentPane.add(ans1);
		
		JRadioButton ans2 = new JRadioButton("C#");
		ans2.setBounds(22, 162, 109, 23);
		contentPane.add(ans2);
		
		JRadioButton ans3 = new JRadioButton("Jsp");
		ans3.setBounds(22, 212, 109, 23);
		contentPane.add(ans3);
		
		JRadioButton ans4 = new JRadioButton("Jakarta");
		ans4.setBounds(22, 271, 109, 23);
		contentPane.add(ans4);
		
		ButtonGroup group = new ButtonGroup();
	    group.add(ans1);
	    group.add(ans2);
	    group.add(ans3);
	    group.add(ans4);
	    String Correct="Jakarta";
		
		JButton q1 = new JButton("privious");
		q1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JavaExam j1=new JavaExam();
				
				j1.show();
				j1.setVisible(true);
				dispose();

			}
		});
		q1.setBounds(42, 364, 89, 23);
		contentPane.add(q1);
		
		JButton Save = new JButton("Save");
		Save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Selection=null;
	    		if(ans1.isSelected()) {
	    			Selection="None Of This";
	    		}
	    		if(ans2.isSelected()) {
	    			Selection="C#";
	    		}
	    		if(ans3.isSelected()) {
	    			Selection="JSP";
	    		}
	    		if(ans4.isSelected()) {
	    			Selection="Jakarta";
	    			System.out.println("Correct Ans");
	    			
	    		}
	    		
				try {
	    			Class.forName("com.mysql.jdbc.Driver");
	    			java.sql.Connection conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/regis","root","root");
					PreparedStatement ps=conn.prepareStatement("insert into Ans_data(Q_no,Correct_Ans,users_ans)values(?,?,?);");
					ps.setInt(1,2);
					ps.setString(2,Correct);
					ps.setString(3,Selection);
					
					int x=ps.executeUpdate();
	    			
	    		}catch(Exception e1){
	    			System.out.println(e1);
	    			
	    		}
				
			}
		});
		Save.setBounds(141, 364, 89, 23);
		contentPane.add(Save);
		
		JButton Next = new JButton("Next");
		Next.setBounds(252, 364, 89, 23);
		contentPane.add(Next);
	}

}
