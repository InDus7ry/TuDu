import java.util.Comparator;

public class TaskComparator implements Comparator<Task>{

	@Override
	public int compare(Task task1, Task task2) {
//		System.out.println(task1 + "vs" + task2);
		int compare = Integer.valueOf(task1.getPriority()).compareTo(task2.getPriority());
//		System.out.println("intitial" + compare);
		if(compare == 0) {
			compare=task1.getName().compareTo(task2.getName());
		}
//		System.out.println("final " + compare);
		return compare;
	}

}
