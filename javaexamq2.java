import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;

import java.awt.GridBagLayout;
import java.awt.CardLayout;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;
import java.sql.*;

public class javaexamq2 extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					javaexamq2 frame = new javaexamq2();
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
	public javaexamq2() {
		setBounds(100, 100, 450, 425);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		getContentPane().add(panel);
		panel.setLayout(new CardLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1, "name_2754668895969808");
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Q2.What is the new name of java ?");
		lblNewLabel.setBounds(21, 36, 357, 32);
		panel_1.add(lblNewLabel);
		
		JRadioButton ans1 = new JRadioButton("Jakarta");
		ans1.setBounds(6, 119, 109, 23);
		panel_1.add(ans1);
		
		JRadioButton ans2 = new JRadioButton("C#");
		ans2.setBounds(6, 165, 109, 23);
		panel_1.add(ans2);
		
		JRadioButton ans3 = new JRadioButton("JSP");
		ans3.setBounds(6, 217, 109, 23);
		panel_1.add(ans3);
		
		JRadioButton ans4 = new JRadioButton("None of this");
		ans4.setBounds(6, 261, 109, 23);
		panel_1.add(ans4);
		
		ButtonGroup group = new ButtonGroup();
	    group.add(ans1);
	    group.add(ans2);
	    group.add(ans3);
	    group.add(ans4);
	    String Correct="Jakarta";
	    
		
		JButton Q1 = new JButton("Previous");
		Q1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JavaExam j1=new JavaExam();
				
				j1.show();
				j1.setVisible(true);
				dispose();

			}
		});
		Q1.setBounds(47, 333, 89, 23);
		panel_1.add(Q1);
		
		JButton Save = new JButton("Save");
		Save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Selection=null;
	    		if(ans1.isSelected()) {
	    			Selection="Jakarta";
	    		}
	    		if(ans2.isSelected()) {
	    			Selection="C#";
	    		}
	    		if(ans3.isSelected()) {
	    			Selection="JSP";
	    		}
	    		if(ans4.isSelected()) {
	    			Selection="None Of This";
	    		}
				try {
	    			Class.forName("com.mysql.jdbc.Driver");
	    			Connection conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/regis","root","root");
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
		Save.setBounds(172, 333, 89, 23);
		panel_1.add(Save);
		
		JButton Q3 = new JButton("Next");
		Q3.setBounds(289, 333, 89, 23);
		panel_1.add(Q3);

	}
}
