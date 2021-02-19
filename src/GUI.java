import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.DefaultListSelectionModel;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSlider;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.UIManager;
import javax.swing.WindowConstants;

public class GUI {
	private Color backgroundUI;
	private Color foregroundUI;
	private ArrayList<Task> tasks= new ArrayList<Task>();
	private ArrayList<Event> events = new ArrayList<Event>();
	private ArrayList<String> realPasses = new ArrayList<String>();
	private ArrayList<String> realUsers= new ArrayList<String>();
	private Stack<String> preferencesStack = new Stack<String>();
	private DefaultListModel<Task> taskModel = new DefaultListModel<>();
	private JList<Task> taskList = new JList<>(taskModel); 
	private DefaultListModel<Event> eventModel = new DefaultListModel<>();
	private JList<Event> eventList = new JList<>(eventModel);
	

	/**
	 * Create the application.
	 * @throws FileNotFoundException 
	 */
	public GUI(){
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void start() {
		
		
		try {
			loadPreferences();
			loadUsers();
			loadItems();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		JFrame tempFrame = new JFrame();
		
		setBackground(backgroundUI, tempFrame);
		
		JPanel loginPanel = new JPanel(new GridLayout(2,2,5,5));
		JTextField usernameField = new JTextField();
		JPasswordField passwordField = new JPasswordField();
		loginPanel.add(new JLabel("Username:"));
		loginPanel.add(usernameField);
		loginPanel.add(new JLabel("Password:"));
		loginPanel.add(passwordField);
//		loginPanel.setBackground(backgroundUI);
//		loginPanel.setForeground(foregroundUI);
		int result = JOptionPane.showConfirmDialog(tempFrame, loginPanel, "TuDu", JOptionPane.YES_NO_OPTION);		
		if (result == JOptionPane.OK_OPTION) {
			String secret = "SARS-CoV-2";
			if(realUsers.contains(AES.encrypt(usernameField.getText(), secret)) && realPasses.get(realUsers.indexOf(AES.encrypt(usernameField.getText(), secret))).contentEquals(AES.encrypt(new String(passwordField.getPassword()), secret))) {
				draw();
			} else {
				Main.main(null);
			}
		} else {
			System.exit(0);
		}
	}
	
	
	/*
	 * Method for loading encrypted username and password strings into realUsers and realPasses arrays for use.
	 * @throws FileNotFoundException
	 */
	private void loadUsers() throws FileNotFoundException{
		try {
			File user = new File("data\\users.txt");
			Scanner sc  = new Scanner(user);
			int i=0;
			while(sc.hasNextLine()) {
				if( i%2==0) {
					realUsers.add(sc.nextLine());
				}else if(i%2!=0){
					realPasses.add(sc.nextLine());
				}
				i++;
			}
			sc.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			realUsers.add("YHzpt2RGFNux6OVadOcN8A==");
			realPasses.add("BzPC5f/HeYnXMqEEE/ZpGQ==");
			e.printStackTrace();
		}
	}
	
//	private void addUsers(String username, String password) throws FileNotFoundException{
//		File user = new File("src\\\\users.txt");
//		PrintWriter pw = new PrintWriter(new FileOutputStream(user), true);
//		pw.println(username);
//		pw.println(password);
//		pw.close();
//	}
	
	private void loadPreferences(){
		try {
			File preferences = new File("data\\preferences.txt");
			Scanner sc = new Scanner(preferences);
			preferencesStack.clear();
			while(sc.hasNextLine()){
				preferencesStack.push(sc.nextLine());
			}
			sc.close();
			foregroundUI = Color.decode(preferencesStack.pop().substring(17,24));
			backgroundUI = Color.decode(preferencesStack.pop().substring(17,24));
//		System.out.println(foregroundUI);
//		System.out.println(backgroundUI);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private void setPreferences(Color backgroundColor, Color foregroundColor) throws FileNotFoundException{
		File preferences = new File("data\\preferences.txt");
		PrintWriter pw = new PrintWriter(preferences);
		pw.println("backgroundColor: "+String.format("#%06x", Integer.valueOf(backgroundUI.getRGB() & 0xFFFFFF)));
		pw.println("foregroundColor: "+String.format("#%06x", Integer.valueOf(foregroundUI.getRGB() & 0xFFFFFF)));
		pw.close();
	}
	
	private void setBackground(Color c, Frame f) {
		UIManager.put("OptionPane.background", c);
		UIManager.put("Panel.background", c);
		refresh(f,c);
	}
	
	private void refresh(Container parent, Color col){
		
	    for(Component c : parent.getComponents()){
	    	
	        if(c instanceof Container){
	        	
	            if(c instanceof JComponent){
	            	
            		c.setBackground(col);
//            		c.updateUI();
	            	
	            }
	            refresh((Container) c, col);
	        }
	    }
	}
	
	/*
	 * Method for drawing the task screen.
	 */
	private void draw() {
		JFrame frame = new JFrame("TuDu");
		
		frame.setIconImage(null);
		frame.setPreferredSize(new Dimension(607, 1080));
		frame.setMinimumSize(new Dimension(607, 1080));
		frame.setMaximumSize(new Dimension(607, 1080));
		frame.setResizable(false);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JSplitPane splitPane = new JSplitPane();
		
		JLabel logoLabel = new JLabel("TuDu");
		
		JButton settingsButton = new JButton("Settings");
		
		JButton addItemButton = new JButton("Add Item");
		
		JButton viewCompleteButton = new JButton("Completed");
		
		
		
//		JTable table = new JTable();
//		table.setBounds(new Rectangle(0, 0, 285, 472));
//		table.setFocusable(false);
//		table.setRowSelectionAllowed(false);
//		table.setModel(new DefaultTableModel(
//			new Object[][] {
//				{null, null, null, null, null, null, null},
//				{null, null, null, null, null, null, null},
//				{null, null, null, null, null, null, null},
//				{null, null, null, null, null, null, null},
//				{null, null, null, null, null, null, null},
//			},
//			new String[] {
//				"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"
//			}
//		) {
//			private static final long serialVersionUID = 1L;
//			boolean[] columnEditables = new boolean[] {
//				false, false, false, false, false, false, false
//			};
//			@Override
//			public boolean isCellEditable(int row, int column) {
//				return columnEditables[column];
//			}
//		});
//		table.getColumnModel().getColumn(0).setResizable(false);
//		table.getColumnModel().getColumn(1).setResizable(false);
//		table.getColumnModel().getColumn(2).setResizable(false);
//		table.getColumnModel().getColumn(3).setResizable(false);
//		table.getColumnModel().getColumn(4).setResizable(false);
//		table.getColumnModel().getColumn(5).setResizable(false);
//		table.getColumnModel().getColumn(6).setResizable(false);

		
		

		splitPane.setBounds(16, 97, 571, 945);
		splitPane.setResizeWeight(0.5);
		splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		
//		ListSelectionModel to prevent overselection by FuryComputers https://stackoverflow.com/questions/2528344/jtaskList-deselect-when-clicking-an-already-selected-item

		taskList.setSelectionModel(new DefaultListSelectionModel() {
		    private static final long serialVersionUID = 1L;

		    boolean gestureStarted = false;

		    @Override
		    public void setSelectionInterval(int index0, int index1) {
		        if(!gestureStarted){
		            if (isSelectedIndex(index0)) {
		                super.removeSelectionInterval(index0, index1);
		            } else {
		                super.addSelectionInterval(index0, index1);
		            }
		        }
		        gestureStarted = true;
		    }

		    @Override
		    public void setValueIsAdjusting(boolean isAdjusting) {
		        if (isAdjusting == false) {
		            gestureStarted = false;
		        }
		    }

		});
		
		taskList.setCellRenderer(new TaskCellRenderer(taskModel));
		
		JPanel taskPanel = new JPanel();
		
		JLabel taskLabel = new JLabel("Tasks: ");
		
		taskLabel.setFont(new Font("Myriad Pro SemiExt", Font.PLAIN, 28));
		
		taskPanel.add(taskLabel);
		
		taskPanel.add(taskList);
		
		splitPane.setLeftComponent(taskPanel);
		
		eventList.setCellRenderer(new EventCellRenderer());
		
		JPanel eventPanel = new JPanel();
		
		JLabel eventLabel = new JLabel("Events: ");
		
		eventLabel.setFont(new Font("Myriad Pro SemiExt", Font.PLAIN, 28));
		
		eventPanel.add(eventLabel);
		
		eventPanel.add(eventList);
		
		splitPane.setRightComponent(eventPanel);
		
		logoLabel.setBounds(16, 16, 472, 73);
		logoLabel.setPreferredSize(new Dimension(607, 146));
		logoLabel.setFont(new Font("Myriad Pro SemiExt", Font.PLAIN, 40));
		logoLabel.setBackground(backgroundUI);
		
		frame.getContentPane().add(logoLabel);
		
		addItemButton.setPreferredSize(new Dimension(89, 146));
		addItemButton.setBackground(new Color(187, 187, 187));
		addItemButton.setBounds(292, 16, 95, 73);
		addItemButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				drawAdd(frame);
			}
		});
		
		frame.getContentPane().add(addItemButton);
		
		viewCompleteButton.setBounds(392, 16, 95, 73);
		viewCompleteButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Box completeBox = Box.createVerticalBox();
				for(Task task: tasks) {
					if(task.isComplete()) {
						completeBox.add(new JLabel(task.getName()));
					}
				}
				JOptionPane.showMessageDialog(frame, completeBox);
			}
		});
		
		frame.getContentPane().add(viewCompleteButton);
		
		settingsButton.setBounds(492, 16, 95, 73);
		settingsButton.setPreferredSize(new Dimension(89, 146));
		settingsButton.setIcon(null);
		settingsButton.setBackground(backgroundUI);
		settingsButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				drawOptions(frame);
			}
		});
		
		frame.getContentPane().add(settingsButton);
		
		frame.getContentPane().add(splitPane);
		
		syncLists();
		
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				saveItems();
				System.exit(0);
			}
		});
		
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
			}
		});
		
		setBackground(backgroundUI, frame);
		
		frame.setVisible(true);
		
	}
	
	private void loadItems() {
		
		try {
			File count = new File("data\\counts.txt");
			Scanner sc = new Scanner(count);
			int taskCount = Integer.valueOf(sc.next());
			int eventCount = Integer.valueOf(sc.next());
			sc.close();
			File taskFile = new File("data\\taskFile.txt");
			File eventFile = new File("data\\eventFile.txt");
			FileInputStream tIn = new FileInputStream(taskFile);
			ObjectInputStream taskIn = new ObjectInputStream(tIn);
			
//			System.out.println(taskCount);
			
			for(int i = 0; i < taskCount; i++) {
				tasks.add((Task)taskIn.readObject());
			}
			
			taskIn.close();
			tIn.close();
			
			FileInputStream eIn = new FileInputStream(eventFile);
			ObjectInputStream eventIn = new ObjectInputStream(eIn);
			
//			System.out.println(eventCount);
			
			for(int i = 0; i < eventCount; i++) {
				events.add((Event)eventIn.readObject());
			}
			
			eventIn.close();
			eIn.close();
			
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		} catch (IOException e) {
			System.out.println("Error initializing stream");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private void drawOptions(JFrame frame) {
		JDialog options = new JDialog(frame, "Options");
		Box optCont = Box.createVerticalBox();
		JLabel titl = new JLabel("Options");
		JLabel backCol = new JLabel("Background Color");
//		JLabel foreCol = new JLabel("Foreground Color");
		JTextField backHex = new JTextField();
//		JTextField foreHex = new JTextField();
		JButton logOut = new JButton("Quit Program");
		JButton confirm= new JButton("Confirm");
		JButton cancel = new JButton("Cancel");
		titl.setFont(new Font("Myriad Pro SemiExt", Font.PLAIN, 28));
		optCont.add(titl);
		optCont.add(backCol);
		optCont.add(backHex);
//		optCont.add(foreCol);
//		optCont.add(foreHex);
		optCont.add(logOut);
		optCont.add(confirm);
		optCont.add(cancel);
		optCont.setVisible(true);
		options.add(optCont);
		options.setSize(400, 600);
		options.setVisible(true);
		backHex.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					backgroundUI=Color.decode(backHex.getText());
					backHex.setBackground(backgroundUI);
					setPreferences(backgroundUI, foregroundUI);
				} catch(Exception ex) {
					JOptionPane.showMessageDialog(options, "Invalid Hex Code [#XXXXXX]");
				}
			}
			
		});
//		foreHex.addActionListener(new ActionListener() {
//
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				try {
//					backgroundUI=Color.decode(foreHex.getText());
//					foreHex.setBackground(backgroundUI);
//				} catch(Exception ex) {
//					JOptionPane.showMessageDialog(options, "Invalid Hex Code [#XXXXXX]");
//				}
//			}
//			
//		});
		logOut.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
			
		});
		cancel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				options.dispose();
			}
			
		});
		confirm.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setBackground(backgroundUI, frame);
				options.dispose();
			}
			
		});
		
	}

	private void syncLists() {
		taskModel.clear();
		Collections.sort(tasks, new TaskComparator());
		for(Task task: tasks) {
			if(!task.isComplete()) {
			taskModel.addElement(task);
			}
		}
		
		eventModel.clear();
		Collections.sort(events, new EventComparator());
		for(Event event: events) {
			eventModel.addElement(event);
		}
		saveItems();
	}
		
	private void saveItems() {
		File taskFile = new File("data\\taskFile.txt");
		File eventFile = new File("data\\eventFile.txt");
		try {
			FileOutputStream tOut = new FileOutputStream(taskFile);
			ObjectOutputStream taskOut = new ObjectOutputStream(tOut);
			
			for(Task task: tasks) {
				taskOut.writeObject(task);
			}
			
			taskOut.close();
			tOut.close();
			
			FileOutputStream eOut = new FileOutputStream(eventFile);
			ObjectOutputStream eventOut = new ObjectOutputStream(eOut);
			
			for(Event event: events) {
				eventOut.writeObject(event);
			}
			
			eventOut.close();
			eOut.close();
			
			File counts = new File("data\\counts.txt");
			
			PrintWriter pw = new PrintWriter(counts);
			
			pw.println(tasks.size());
			pw.println(events.size());
			
			pw.close();
			
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		} catch (IOException e) {
			System.out.println("Error initializing stream");
		}
	}
		
	private void drawAdd(JFrame frame) {
		
		JDialog addItemDialog = new JDialog(frame, "Add Item");
		
		addItemDialog.setSize(new Dimension(400, 600));
		
//		JFrame createFrame = new JFrame("Add Item");
		
		JPanel panel = new JPanel();
		
		ArrayList<String> reminderList = new ArrayList<String>();
		
		ArrayList<String> memberList = new ArrayList<String>();
		
		panel.setSize(new Dimension(300, 600));
		
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		JLabel titleLabel = new JLabel("Create New Task or Event");
		
		JLabel nameLabel = new JLabel("Name:");
		
		JLabel memberLabel = new JLabel("Members");
		
		final JLabel membersList = new JLabel();
		
		JButton memberButton = new JButton("Add member");
		
		JLabel reminderLabel = new JLabel("Reminders");
		
		final JLabel remindersList = new JLabel();
		
		JButton reminderButton = new JButton("Add reminder");
		
		JTextField nameField = new JTextField();
		
		JLabel typeLabel = new JLabel("Choose Type");
		
		JToggleButton typeButton = new JToggleButton("Task");
		
		JPanel taskPanel = new JPanel();
		
		JPanel eventPanel = new JPanel();
		
		JButton saveButton = new JButton("Save");
		
		titleLabel.setFont(new Font("Tahoma", Font.PLAIN, 19));
		
		panel.add(titleLabel);	
		
		panel.add(nameLabel);
		
		nameField.setMaximumSize(new Dimension(300,20));
		
		panel.add(nameField);

		panel.add(memberLabel);
		
		panel.add(membersList);
		
		memberButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String entry = JOptionPane.showInputDialog(panel, "Member: ");
				if(!entry.equals(null) && !entry.equals("")) {
					memberList.add(entry);
				}
				membersList.setText(memberList.toString());
			}
		});
		
		panel.add(memberButton);
		
		panel.add(reminderLabel);
		
		panel.add(remindersList);

		reminderButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String entry = JOptionPane.showInputDialog(panel, "MM/DD/YYYY; HH:MM");
				if(!entry.equals(null) && !entry.equals("") && entry.length()== 17) {
					//regex for date by Dany Lauener
					//regex for time by Carlos R. L. Rodrigues (slightly modified)
//					System.out.println(entry.substring(0,10));
//					System.out.println(entry.substring(10,12));
//					System.out.println(entry.substring(12));
					if(entry.substring(0,10).matches("^(((0?[1-9]|1[012])/(0?[1-9]|1\\d|2[0-8])|(0?[13456789]|1[012])/(29|30)|"
							+ "(0?[13578]|1[02])/31)/(19|[2-9]\\d)\\d{2}|0?2/29/((19|[2-9]\\d)(0[48]|[2468][048]|[13579][26])|"
							+ "(([2468][048]|[3579][26])00)))$") && entry.substring(10,12).equals("; ")
							&& entry.substring(12).matches("^(([0-1]?[0-9])|([2][0-3])):([0-5]?[0-9])?$")) {
						reminderList.add(entry);	
					} else {
						JOptionPane.showMessageDialog(panel, "Incorrect formatting");
					}
				}
				remindersList.setText(reminderList.toString());
			}
		});
		
		panel.add(reminderButton);
		
		panel.add(typeLabel);
		
		typeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				typeButton.setText((typeButton.isSelected() ? "Event" : "Task") );
				if(typeButton.isSelected()) {

					eventPanel.setVisible(true);
					
					taskPanel.setVisible(false);

					
				} else {
					
					taskPanel.setVisible(true);
					
					eventPanel.setVisible(false);

				}
			}
		});
		
		panel.add(typeButton);
		
		/*
		 * Panel show when making tasks (the deafault)
		 */
		
		JLabel taskLabel = new JLabel("Task-specific properties");
		
		JLabel priorityLabel = new JLabel("Priority");
		
		JSlider slider = new JSlider(1, 4, 1);
		
		taskPanel.setLayout(new BoxLayout(taskPanel, BoxLayout.Y_AXIS));

		taskPanel.add(taskLabel);
		
		taskPanel.add(priorityLabel);
		
		slider.setAlignmentX(Component.LEFT_ALIGNMENT);
		
		slider.setSize(600,20);
		
		slider.setMaximumSize(new Dimension(600,20));
		
//		slider.createStandardLabels(1,1);
//		
//		slider.setMajorTickSpacing(1);
//		
//		slider.setPaintTicks(true);
//		
//		slider.setPaintLabels(true);
//		
//		slider.setSnapToTicks(true);
//		
//		slider.updateUI();
		
		taskPanel.add(slider);
		
		panel.add(taskPanel);
		
		/*
		 * Panel show when making events (not default)
		 */
		
		JLabel eventLabel = new JLabel("Event-specific properties");

		JLabel dateLabel = new JLabel("Date and Time");
		
		JLabel daLabel = new JLabel();
		
		JButton dateButton = new JButton("Set date and time");
		
		JLabel durationLabel = new JLabel("Duration");
		
		JLabel durLabel = new JLabel();
		
		JButton durationButton = new JButton("Set duration");
		
		eventPanel.setLayout(new BoxLayout(eventPanel, BoxLayout.Y_AXIS));
		
		eventPanel.add(eventLabel);
		
		eventPanel.add(dateLabel);
		
		eventPanel.add(daLabel);
		
		dateButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String entry=JOptionPane.showInputDialog(panel, "MM/DD/YYYY; HH:MM");
				if(!entry.equals(null) && !entry.equals("") && entry.length()== 17) {
					if(entry.substring(0,10).matches("^(((0?[1-9]|1[012])/(0?[1-9]|1\\d|2[0-8])|(0?[13456789]|1[012])/(29|30)|"
							+ "(0?[13578]|1[02])/31)/(19|[2-9]\\d)\\d{2}|0?2/29/((19|[2-9]\\d)(0[48]|[2468][048]|[13579][26])|"
							+ "(([2468][048]|[3579][26])00)))$") && entry.substring(10,12).equals("; ")
							&& entry.substring(12).matches("^(([0-1]?[0-9])|([2][0-3])):([0-5]?[0-9])?$")) {
						daLabel.setText(entry);
						dateButton.setText("Edit date and time");
					} else {
						JOptionPane.showMessageDialog(panel, "Incorrect formatting");
					}
				}
			}
		});
		
		eventPanel.add(dateButton);
		
		eventPanel.add(durationLabel);
		
		eventPanel.add(durLabel);
		
		durationButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String entry = JOptionPane.showInputDialog(panel, "HH:MM");
				if(entry.matches("\\d\\d:\\d\\d")) {
					durLabel.setText(entry);
				} else {
					JOptionPane.showMessageDialog(panel, "Incorrect formatting");
				}
			}
			
		});
		
		eventPanel.add(durationButton);
		
		taskPanel.setVisible(true);
		
		eventPanel.setVisible(false);
		
				
		
		panel.add(eventPanel);
		
		saveButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (!nameField.getText().equals(null) && !nameField.getText().equals("")) {
					String[] members = new String[memberList.size()];
					int i = 0;
					for (String s : memberList) {
						members[i] = s;
						i++;
					}
					String[] reminders = new String[reminderList.size()];
					i = 0;
					for (String s : reminderList) {
						reminders[i] = s;
						i++;
					}
					String name = nameField.getText();
					if (!typeButton.isSelected()) {

						int priority = slider.getValue();

						tasks.add(new Task(name, priority, reminders, members));

//						System.out.println(b);

//						System.out.println(tasks);

						syncLists();

						addItemDialog.dispose();

					} else if(!daLabel.getText().equals(null) && !daLabel.getText().equals("") && !durLabel.getText().equals(null) && !durLabel.getText().equals("")){

						events.add(new Event(name, daLabel.getText(), durLabel.getText(), reminders, members));

						syncLists();

						addItemDialog.dispose();
					} else {
						JOptionPane.showMessageDialog(panel, "Make sure everything is filled out");
					}
				} else {
					JOptionPane.showMessageDialog(panel, "Make sure everything is filled out");
				}
									
			}
		});
		
		saveButton.setVisible(true);
		
		panel.add(saveButton);
		
		panel.setVisible(true);
		
		addItemDialog.add(panel);
		
		addItemDialog.setVisible(true);		
	}
	
	
}