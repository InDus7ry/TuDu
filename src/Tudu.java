import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPasswordField;
import java.awt.GridLayout;
import javax.swing.DropMode;
import javax.swing.JButton;
import javax.swing.JSeparator;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;
import net.miginfocom.swing.MigLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Component;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import java.awt.Rectangle;

public class Tudu {

	private JFrame frame;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JPasswordField passwordField_1;
	private JTextField textField;
	public Color baseUI = new Color(187,187,187);
	private JSeparator separator;
	private JSeparator separator_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tudu window = new Tudu();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Tudu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setForeground(new Color(0, 0, 0));
		frame.getContentPane().setFont(new Font("Myriad Pro SemiExt", Font.PLAIN, 32));
		frame.getContentPane().setBackground(new Color(187,187,187));
		frame.setPreferredSize(new Dimension(607, 1080));
		frame.setMinimumSize(new Dimension(607, 1080));
		frame.setMaximumSize(new Dimension(607, 1080));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new MigLayout("", "[100px][407px,grow][100px]", "[400][][][][][][][][][][][][][][][][][][]"));
		
		JLabel lblNewLabel = new JLabel("TuDu");
		lblNewLabel.setFont(new Font("Myriad Pro SemiExt", Font.PLAIN, 99));
		frame.getContentPane().add(lblNewLabel, "cell 1 0,alignx center,aligny center");
		
		lblNewLabel_1 = new JLabel("Username:");
		lblNewLabel_1.setFont(new Font("Myriad Pro SemiExt", Font.PLAIN, 20));
		frame.getContentPane().add(lblNewLabel_1, "cell 1 1");
		
		textField = new JTextField();
		textField.setToolTipText("");
		textField.setOpaque(false);
		textField.setBorder(null);
		textField.setBackground(baseUI);
		textField.setFont(new Font("Myriad Pro SemiExt", Font.PLAIN, 28));
		frame.getContentPane().add(textField, "cell 1 2,growx,aligny baseline");
		textField.setColumns(10);
		
		separator = new JSeparator();
		separator.setBackground(new Color(0, 0, 0));
		separator.setForeground(new Color(0, 0, 0));
		frame.getContentPane().add(separator, "cell 1 3,growx,aligny top");
		
		lblNewLabel_2 = new JLabel("Password:");
		lblNewLabel_2.setFont(new Font("Myriad Pro SemiExt", Font.PLAIN, 20));
		frame.getContentPane().add(lblNewLabel_2, "cell 1 4");
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBorder(null);
		passwordField_1.setBackground(baseUI);
		passwordField_1.setFont(new Font("Myriad Pro SemiExt", Font.PLAIN, 28));
		passwordField_1.setColumns(1);
		frame.getContentPane().add(passwordField_1, "cell 1 5,growx,aligny baseline");
		
		separator_1 = new JSeparator();
		separator_1.setBackground(new Color(0, 0, 0));
		separator_1.setForeground(new Color(0, 0, 0));
		frame.getContentPane().add(separator_1, "cell 1 6,growx,aligny top");
	}
}
