//@author Gabe Wong
//@version %I%

import java.awt.EventQueue;
import java.time.*;
import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {
		ArrayList<Task> tasks = new ArrayList<Task>();
		@SuppressWarnings("unused")
		ArrayList<Event> events = new ArrayList<Event>();
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
		String[] mem = new String[1];
		mem[0]="Gabe";
		LocalTime[] rem = new LocalTime[1];
		rem[0]=LocalTime.of(4,20,50,69);
		tasks.add(new Task("Just Do It, Nike(tm)", 1, rem, mem));
		Task temp = tasks.get(0);
		System.out.println(temp.returnMembers());
		System.out.println(temp.sendReminder());
		
	}
}