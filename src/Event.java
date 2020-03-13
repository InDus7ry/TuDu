//@author Gabe Wong
//@version %I%

import java.time.*;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;

public class Event extends Item{
	private LocalDate date;
	private LocalTime time; 
	private Duration duration;
	private LocalDate[] hourReminders;
	public Event(String name, LocalDate date, LocalTime time, Duration duration, LocalDate[] hourReminders, String[] members) {
		super(name, hourReminders, members);
		this.date=date;
		this.time=time;
		this.duration=duration;
		this.hourReminders=hourReminders;
		for(String s : members) {
			this.members.add(s);
		}
	}
	
	/*
	 * The method used to add metadata:
	 */
	public void changeData(LocalDate date, LocalTime time, Duration duration, LocalDate[] reminders, String[] members) {
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
