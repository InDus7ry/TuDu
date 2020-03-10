import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;

import javax.swing.*;
import javax.swing.border.LineBorder;

import net.miginfocom.swing.MigLayout;


public class GUI {

	private JFrame frame;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JPasswordField passwordField_1;
	private JTextField textField;
	public Color baseUI = new Color(187,187,187);
	private JSeparator separator;
	private JSeparator separator_1;
	private String username;
	private char[] password;
	private JButton btnNewButton;
	private char[] truePass;
	private String trueUser;

	/**
	 * Create the application.
	 */
	public GUI() {
		truePass=new char[10];
		for(int i=0; i<truePass.length; i++) {
			truePass[i]="Password12".charAt(i);
		}
		trueUser="Username";
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		/**
		 * Set up the frame
		 */
		frame = new JFrame();
		frame.setVisible(true);
		frame.getContentPane().setForeground(new Color(0, 0, 0));
		frame.getContentPane().setFont(new Font("Myriad Pro SemiExt", Font.PLAIN, 32));
		frame.getContentPane().setBackground(baseUI);
		frame.setPreferredSize(new Dimension(607, 1080));
		frame.setMinimumSize(new Dimension(607, 1080));
		frame.setMaximumSize(new Dimension(607, 1080));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new MigLayout("", "[100px][407px,grow][100px]", "[400][][][][][][][][][][][][][][][][][][]"));
		
		/**
		 * Add logo
		 */
		
		JLabel lblNewLabel = new JLabel("TuDu");
		lblNewLabel.setFont(new Font("Myriad Pro SemiExt", Font.PLAIN, 99));
		frame.getContentPane().add(lblNewLabel, "cell 1 0,alignx center,aligny center");
		
		/**
		 * Add username label
		 */
		
		lblNewLabel_1 = new JLabel("Username:");
		lblNewLabel_1.setFont(new Font("Myriad Pro SemiExt", Font.PLAIN, 20));
		frame.getContentPane().add(lblNewLabel_1, "cell 1 1");
		
		/**
		 * Add username field
		 */
		
		textField = new JTextField();
		textField.setOpaque(false);
		textField.setBorder(null);
		textField.setBackground(baseUI);
		textField.setFont(new Font("Myriad Pro SemiExt", Font.PLAIN, 28));
		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Arrays.equals(passwordField_1.getPassword(), truePass) && textField.getText().equals(trueUser)) {
					System.out.println("Succ");
				} else {
					System.out.println("Fail");
				}
			}
		});
		frame.getContentPane().add(textField, "cell 1 2,growx,aligny baseline");
		
		/**
		 * Add username underline
		 */
		
		separator = new JSeparator();
		separator.setBackground(new Color(0, 0, 0));
		separator.setForeground(new Color(0, 0, 0));
		frame.getContentPane().add(separator, "cell 1 3,growx,aligny top");
		
		/**
		 * Add password label
		 */
		
		lblNewLabel_2 = new JLabel("Password:");
		lblNewLabel_2.setFont(new Font("Myriad Pro SemiExt", Font.PLAIN, 20));
		frame.getContentPane().add(lblNewLabel_2, "cell 1 4");
		
		/**
		 * Add password field
		 */
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBorder(null);
		passwordField_1.setBackground(baseUI);
		passwordField_1.setFont(new Font("Myriad Pro SemiExt", Font.PLAIN, 28));
		passwordField_1.setColumns(1);
		passwordField_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Arrays.equals(passwordField_1.getPassword(), truePass) && textField.getText().equals(trueUser)) {
					System.out.println("Succ");
				} else {
					System.out.println("Fail");
				}
			}
		});
		frame.getContentPane().add(passwordField_1, "cell 1 5,growx,aligny baseline");
		
		/**
		 * Add password underline
		 */
		
		separator_1 = new JSeparator();
		separator_1.setBackground(new Color(0, 0, 0));
		separator_1.setForeground(new Color(0, 0, 0));
		frame.getContentPane().add(separator_1, "cell 1 6,growx,aligny top");
		
		/**
		 * Add submit button
		 */
		
		btnNewButton = new JButton("Login");
		btnNewButton.setPreferredSize(new Dimension(100, 50));
		LineBorder btnBorder= new LineBorder(new Color(0,0,0));
		btnNewButton.setMargin(new Insets(100, 100, 100, 100));
		btnNewButton.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setBorder(btnBorder);
		btnNewButton.setFont(new Font("Myriad Pro SemiExt", Font.PLAIN, 20));
		btnNewButton.setBackground(baseUI);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Arrays.equals(passwordField_1.getPassword(), truePass) && textField.getText().equals(trueUser)) {
					System.out.println("Succ");
				} else {
					System.out.println("Fail");
				}
			}
		});
		frame.getContentPane().add(btnNewButton, "cell 1 7,alignx right,growy");
	}
}