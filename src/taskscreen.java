import net.miginfocom.swing.MigLayout;
import java.util.ArrayList;
import java.awt.event.*;
import java.time.LocalDate;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class TaskScreen {

	private JFrame frame;
	private JTable table;
	public Color baseUI = new Color(187,187,187);
	private ArrayList<JCheckBox> taskBoxes = new ArrayList<JCheckBox>();
	private static ArrayList<Task> tasks= new ArrayList<Task>();
	private JTextField textField;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		String[] mem = new String[1];
		mem[0]="Gabe";
		LocalDate[] rem = new LocalDate[1];
		rem[0]=LocalDate.of(4,12,15);
		tasks.add(new Task("Just Do It, Nike(tm)", 1, rem, mem));
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TaskScreen window = new TaskScreen(tasks);
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
	public TaskScreen(ArrayList<Task> tasks) {
		TaskScreen.tasks=tasks;
		for(Task task: tasks) {
			taskBoxes.add(new ExtendedJCheckBox(task.name, task));
		}
		taskBoxes.add(new JCheckBox("Just Do It, Nike(tm): Priority 1"));
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
		
		
		table=new JTable();
		table.setBounds(new Rectangle(0, 0, 285, 472));
		table.setFocusable(false);
		table.setRowSelectionAllowed(false);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
			},
			new String[] {
				"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		
		
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
		Box verticalBox = Box.createVerticalBox();
		verticalBox.setRequestFocusEnabled(false);
		for(JCheckBox taskBox : taskBoxes) {
			verticalBox.add(taskBox);
			taskBox.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					verticalBox.remove(taskBox);
//					verticalBox.update(g);
					System.out.println(verticalBox);
					verticalBox.add(new JCheckBox("Just Do It, Nike(tm): Priority 1"));
					System.out.println(verticalBox);
					frame.repaint();
				}

			});
		}
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setBounds(16, 97, 571, 945);
		splitPane.setResizeWeight(0.5);
		splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		splitPane.setLeftComponent(verticalBox);
		splitPane.setRightComponent(table);
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(2).setResizable(false);
		table.getColumnModel().getColumn(3).setResizable(false);
		table.getColumnModel().getColumn(4).setResizable(false);
		table.getColumnModel().getColumn(5).setResizable(false);
		table.getColumnModel().getColumn(6).setResizable(false);
//		table.setRowHeight((splitPane.getLastDividerLocation()*1080Bounds(new Rectangle(0, 0, 285, 472));
		
		
		
		JPopupMenu popupMenu = new JPopupMenu();
		addPopup(frame.getContentPane(), popupMenu);
		popupMenu.setBounds(50, 0, 60, 16);
		
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