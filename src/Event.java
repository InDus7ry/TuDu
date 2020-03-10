//@author Gabe Wong
//@version %I%

import java.time.*;

public class Event extends Item{
	private LocalDate date;
	private LocalTime time; 
	private Duration duration;
	LocalTime[] reminders;
	public Event(LocalDate date, LocalTime time, Duration duration, LocalTime[] reminders, String[] members) {
		super(reminders, members);
		this.date=date;
		this.time=time;
		this.duration=duration;
		this.reminders=reminders;
		for(String s : members) {
			this.members.add(s);
		}
	}
	
	/*
	 * The method used to add metadata:
	 */
	public void changeData(LocalDate date, LocalTime time, Duration duration, LocalTime[] reminders, String[] members) {
		super.changeData(reminders, members);
		this.date=date;
		this.time=time;
		this.duration=duration;
		this.reminders=reminders;
		for(String s : members) {
			this.members.add(s);
		}
	}
}
