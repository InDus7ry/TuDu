//@author Gabe Wong
//@version %I%

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import javax.swing.JComponent;

public class Item extends JComponent{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected ArrayList<String> members = new ArrayList<String>();
	protected String name;
	protected String[] reminders;
	
	
	protected Item(String name, String[] reminders, String[] members) {
		this.reminders=reminders;
		this.name=name;
		for(String s : members) {
			this.members.add(s);
		}
	}
	
	protected LocalTime convertToTime(String time) {
		time=time.trim();
		
		return LocalTime.of(Integer.valueOf(time.substring(0,2)),
				Integer.valueOf(time.substring(3,5)));
		
	}
	
	protected LocalDate convertToDate(String date) {
		
		return LocalDate.of(Integer.valueOf(date.substring(6,8)), 
				Integer.valueOf(date.substring(0,2)), 
				Integer.valueOf(date.substring(3,5)));
		
	}
	
	protected Duration convertToDuration(String duration) {
		
		return Duration.ofHours(Integer.valueOf(duration.substring(0,2))).
				plus(Duration.ofMinutes(Integer.valueOf(duration.substring(3,5))));
		
	}
	
	public String getName() {
		return name;
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
		return name;
	}
	/*
	 * The method used to add metadata:
	 */
	public void changeData(String name, String[] reminders, String[] members) {
		this.name=name;
		this.reminders=reminders;
		for(String s : members) {
			this.members.add(s);
		}
	}
}
