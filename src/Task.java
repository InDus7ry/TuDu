//@author Gabe Wong
//@version %I%

import java.time.*;
import java.util.ArrayList;
public class Task extends Item{
	private int priority;
	private boolean complete=false;
	private String info;
	public Task(String name, int priority, LocalDate[] reminders, String[] members) {
		super(name, reminders, members);
		this.priority=priority;
		this.reminders=reminders;
	}
	@Override
	public String sendReminder() {
		info=name;
		info+=": Priority "+priority;
		return info;
	}
	public void complete() {
		complete=true;
	}
	public void uncomplete() {
		complete=false;
	}
	@Override
	public String toString() {
		return "Task [priority=" + priority + ", complete=" + complete + ", info=" + info + "]";
	}
	
}
