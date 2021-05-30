import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class home extends JFrame {

	private JPanel contentPane;
	protected JavaExam JavaExam;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					home frame = new home();
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
	public home() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Home");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(194, 11, 52, 40);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Start Exam");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(btnNewButton,"All the best");
				JavaExam jfrm1= new JavaExam();
		        jfrm1.setSize(550, 450); 
		        jfrm1.setVisible(true);
		       
		   dispose();				
		   				
			}
		});
		btnNewButton.setBounds(38, 166, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Start Exam");
		btnNewButton_1.setBounds(259, 166, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JTextPane txtpnTimeForThe = new JTextPane();
		txtpnTimeForThe.setText("Java\r\nTime :- 10Minutes\r\nQuetions:-10\r\nMarks:-10");
		txtpnTimeForThe.setBounds(10, 51, 117, 92);
		contentPane.add(txtpnTimeForThe);
		
		JTextPane txtpnCTime = new JTextPane();
		txtpnCTime.setText("C++\r\nTime :- 10Minutes\r\nQuetions:-10\r\nMarks:-10");
		txtpnCTime.setBounds(259, 51, 129, 92);
		contentPane.add(txtpnCTime);
	}

	protected void showJavaExam() {
		// TODO Auto-generated method stub
		
	}
}
