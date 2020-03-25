//@author Gabe Wong
//@version %I%

import java.io.Serializable;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;

public class Event extends Item implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String dateTime;
	private String durationIn;
	private LocalDate date;
	private LocalTime time;
	private Duration duration;
	public Event(String name, String dateTime, String duration, String[] reminders, String[] members) {
		super(name, reminders, members);
		this.dateTime=dateTime;
		this.durationIn=duration;
		for(String s : members) {
			this.members.add(s);
		}
		String[] dT = dateTime.split(";");
		this.date=convertToDate(dT[0]);
		this.time=convertToTime(dT[1]);
		this.duration=convertToDuration(durationIn);
	}
	
	public LocalDate getDate() {
		return date;
	}
	
	public LocalTime getTime() {
		return time;
	}
	
	public Duration getDuration() {
		return duration;
	}
	
	public String getDateTime() {
		return dateTime;
	}
	
	/*
	 * The method used to change metadata:
	 */
	public void changeData(String name, String dateTime, String duration, String[] reminders, String[] members) {
		super.changeData(name, reminders, members);
		this.dateTime=dateTime;
		this.durationIn=duration;
		this.reminders=reminders;
		for(String s : members) {
			this.members.add(s);
		}
	}

	@Override
	public String toString() {
		return "Event [dateTime=" + dateTime + ", durationIn=" + durationIn + ", name=" + name + "]";
	}
	
	
}
