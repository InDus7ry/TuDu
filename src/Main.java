//@author Gabe Wong
//@version %I%

import java.awt.EventQueue;
import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {
		ArrayList<Task> tasks;
		ArrayList<Event> events;
		GUI mgui = new GUI();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mgui.initialize();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}