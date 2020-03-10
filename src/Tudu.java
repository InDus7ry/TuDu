import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import net.miginfocom.swing.MigLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Component;
import javax.swing.UIManager;
import java.awt.Rectangle;

public class Tudu {

	private JFrame frame;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JTextField textField;
	public Color baseUI = new Color(187,187,187);
	private JSeparator separator;
	private JSeparator separator_1;
	private JPasswordField passwordField;

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
		frame.getContentPane().setLayout(new MigLayout("", "[100px][407px,grow][100px]", "[400][][][][][][][][][][][][][][][][][][][][][]"));
		
		JLabel lblNewLabel = new JLabel("TuDu");
		lblNewLabel.setFont(new Font("Myriad Pro SemiExt", Font.PLAIN, 99));
		frame.getContentPane().add(lblNewLabel, "cell 1 0,alignx center,growy");
		
		lblNewLabel_1 = new JLabel("Username:");
		lblNewLabel_1.setFont(new Font("Myriad Pro SemiExt", Font.PLAIN, 20));
		frame.getContentPane().add(lblNewLabel_1, "cell 1 1,grow");
		
		textField = new JTextField();
		textField.setToolTipText("");
		textField.setOpaque(false);
		textField.setBorder(null);
		textField.setBackground(baseUI);
		textField.setFont(new Font("Myriad Pro SemiExt", Font.PLAIN, 28));
		frame.getContentPane().add(textField, "cell 1 2,grow");
		textField.setColumns(10);
		
		separator_1 = new JSeparator();
		separator_1.setBackground(new Color(0, 0, 0));
		separator_1.setForeground(new Color(0, 0, 0));
		frame.getContentPane().add(separator_1, "cell 1 3,grow");
		
		lblNewLabel_2 = new JLabel("Password:");
		lblNewLabel_2.setFont(new Font("Myriad Pro SemiExt", Font.PLAIN, 20));
		frame.getContentPane().add(lblNewLabel_2, "cell 1 4,grow");
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Dialog", Font.PLAIN, 28));
		passwordField.setBorder(null);
		passwordField.setBackground(baseUI);
		frame.getContentPane().add(passwordField, "cell 1 5,growx");
		
		separator = new JSeparator();
		separator.setBackground(new Color(0, 0, 0));
		separator.setForeground(new Color(0, 0, 0));
		frame.getContentPane().add(separator, "cell 1 6,grow");
	}
}
