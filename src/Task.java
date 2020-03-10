//@author Gabe Wong
//@version %I%

import java.time.*;
import java.util.ArrayList;
public class Task extends Item{
	private int priority;
	public Task(int priority, LocalTime[] reminders, String[] members) {
		super(reminders, members);
		this.priority=priority;
		this.reminders=reminders;
	}
	
	/*
	 * The method used for external access to members. 
	 * @return members
	 */
	@Override
	public ArrayList<String> returnMembers() {
		return members;
	}
	
	/*
	 * The method used to send reminder strings.
	 * @return info
	 */
	@Override
	public String sendReminder() {
		return info;
	}
}
