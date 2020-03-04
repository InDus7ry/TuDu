//@author Gabe Wong
//@version %I%

import java.util.ArrayList;
public class Task implements Item{
	private ArrayList<String> members;
	private String info;
	
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
