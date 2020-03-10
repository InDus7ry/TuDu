import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JSplitPane;
import java.awt.BorderLayout;
import java.awt.Color;

import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import java.awt.SystemColor;
import javax.swing.Box;

public class taskscreen {

	private JFrame frame;
	private JTable table;
	public Color baseUI = new Color(187,187,187);
	private JCheckBox[] Tasks;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					taskscreen window = new taskscreen();
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
	public taskscreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(baseUI);
		frame.setPreferredSize(new Dimension(607, 1080));
		frame.setMinimumSize(new Dimension(607, 1080));
		frame.setMaximumSize(new Dimension(607, 1080));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBackground(baseUI);
		frame.getContentPane().setLayout(new MigLayout("", "[571px]", "[][][1019px]"));
		
		JLabel lblNewLabel = new JLabel("TuDu");
		lblNewLabel.setPreferredSize(new Dimension(607, 146));
		lblNewLabel.setFont(new Font("Myriad Pro SemiExt", Font.PLAIN, 28));
		lblNewLabel.setBackground(baseUI);
		frame.getContentPane().add(lblNewLabel, "flowx,cell 0 0,alignx center,aligny center");
		
		
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setResizeWeight(0.5);
		splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		frame.getContentPane().add(splitPane, "cell 0 2,grow");
		
		Box verticalBox = Box.createVerticalBox();
		splitPane.setLeftComponent(verticalBox);
		
		table = new JTable();
		splitPane.setRightComponent(table);
		
		JButton btnNewButton = new JButton("Settings");
		btnNewButton.setPreferredSize(new Dimension(89, 146));
		btnNewButton.setIcon(null);
		btnNewButton.setBackground(baseUI);
		frame.getContentPane().add(btnNewButton, "cell 0 0");
	}
}