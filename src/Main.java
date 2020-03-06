//@author Gabe Wong
//@version %I%

import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.JFrame;

public class Main {
	public static void main(String[] args) {
		ArrayList<Task> tasks;
		ArrayList<Event> events;
		JFrame frame= new JFrame("TuDu");
		frame.setPreferredSize(new Dimension(607, 1080));
		frame.setMinimumSize(new Dimension(607, 1080));
		frame.setMaximumSize(new Dimension(607, 1080));
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.add(new GUI());
		frame.setVisible(true);
		GUI mgui = new GUI();
	}
}
