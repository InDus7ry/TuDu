//@author Gabe Wong
//@version %I%

import java.time.LocalTime;
import java.util.ArrayList;

public class Item {
	public ArrayList<String> members;
	public String info;
	
	LocalTime[] reminders;
	public Item(LocalTime[] reminders, String[] members) {
		this.reminders=reminders;
		for(String s : members) {
			this.members.add(s);
		}
	}
	
	/*
	 * The method used for external access to members. 
	 * @return members
	 */
	public ArrayList<String> returnMembers() {
		return members;
	}
	
	/*
	 * The method used to send reminder strings.
	 * @return info
	 */
	public String sendReminder() {
		return info;
	}
	/*
	 * The method used to add metadata:
	 */
	public void changeData(LocalTime[] reminders, String[] members) {
		this.reminders=reminders;
		for(String s : members) {
			this.members.add(s);
		}
	}
}
