//@author Gabe Wong
//@version %I%

import java.awt.EventQueue;
import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {
		ArrayList<Task> tasks = new ArrayList<Task>();
		@SuppressWarnings("unused")
		ArrayList<Event> events = new ArrayList<Event>();
		LoginScreen login = new LoginScreen();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login.initialize();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		String[] mem = new String[1];
		mem[0]="Gabe";
		int[] rem = new int[1];
		rem[0]=5;
		tasks.add(new Task("Just Do It, Nike(tm)", 1, adjust(rem, LocalDate.of(4,20,50)), mem));
		Task temp = tasks.get(0);
		System.out.println(temp.returnMembers());
		System.out.println(temp.sendReminder());
		
	}
	public static LocalDate[] adjust(int[] rems, LocalDate date) {
		LocalDate[] adjusted=new LocalDate[rems.length];
		for(int i: rems) {
			date.minus(i, ChronoUnit.HOURS);
		}
		return adjusted;
	}
}