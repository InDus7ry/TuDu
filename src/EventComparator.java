import java.util.Comparator;

public class EventComparator implements Comparator<Event> {

	@Override
	public int compare(Event event1, Event event2) {
//		System.out.println("Comparing");
		int comp = event1.getDate().compareTo(event2.getDate());
		if(comp==0) {
			return event1.getTime().compareTo(event2.getTime());
		} else {
			return comp;
		}
	}

}
