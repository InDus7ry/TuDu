import java.io.Serializable;

//@author Gabe Wong
//@version %I%

public class Task extends Item implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int priority;
	private boolean complete=false;
	private String info;
	public Task(String name, int priority, String[] reminders, String[] members) {
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
	
	public int getPriority() {
		return priority;
	}
	public void complete() {
		complete=true;
	}
	public void uncomplete() {
		complete=false;
	}
	public boolean isComplete() {
		return complete;
	}
	@Override
	public String toString() {
		return name+"; "+priority+"; "+reminders+"; "+members;
	}
	
}
