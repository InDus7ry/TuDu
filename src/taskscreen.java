import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.*;

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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.JPopupMenu;
import java.awt.Component;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JRadioButton;

public class taskscreen {

	private JFrame frame;
	private JTable table;
	public Color baseUI = new Color(187,187,187);
	private ArrayList<JCheckBox> Tasks = new ArrayList<JCheckBox>();
	private JTextField textField;

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
		Tasks.add(new JCheckBox("Just Do It, Nike(tm): Priority 1"));
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
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("TuDu");
		lblNewLabel.setBounds(16, 16, 472, 73);
		lblNewLabel.setPreferredSize(new Dimension(607, 146));
		lblNewLabel.setFont(new Font("Myriad Pro SemiExt", Font.PLAIN, 28));
		lblNewLabel.setBackground(baseUI);
		
		
		
		
		JButton btnNewButton = new JButton("Settings");
		btnNewButton.setBounds(492, 16, 95, 73);
		btnNewButton.setPreferredSize(new Dimension(89, 146));
		btnNewButton.setIcon(null);
		btnNewButton.setBackground(baseUI);
		
		
		JButton btnNewButton_1 = new JButton("Add Item");
		btnNewButton_1.setPreferredSize(new Dimension(89, 146));
		btnNewButton_1.setBackground(new Color(187, 187, 187));
		btnNewButton_1.setBounds(470, 950, 95, 73);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frame.repaint();
			}

		});
		
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setBounds(16, 97, 571, 945);
		splitPane.setResizeWeight(0.5);
		splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		
		
		Box verticalBox = Box.createVerticalBox();
		for(JCheckBox task : Tasks) {
			verticalBox.add(task);
			task.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					verticalBox.remove(task);
					frame.repaint();
				}

			});
		}
		splitPane.setLeftComponent(verticalBox);
		splitPane.setRightComponent(table);
		
		JPopupMenu popupMenu = new JPopupMenu();
		popupMenu.setBounds(0, 0, 60, 16);
		frame.getContentPane().add(popupMenu);
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		popupMenu.add(lblNewLabel_1);
		
		textField = new JTextField();
		popupMenu.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Type");
		popupMenu.add(lblNewLabel_2);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Task");
		popupMenu.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Event");
		popupMenu.add(rdbtnNewRadioButton_1);
		
		
		frame.getContentPane().add(lblNewLabel);
		frame.getContentPane().add(btnNewButton_1);
		frame.getContentPane().add(btnNewButton);
		frame.getContentPane().add(splitPane);
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}