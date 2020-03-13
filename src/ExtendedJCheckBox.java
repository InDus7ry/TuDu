import javax.swing.JCheckBox;

public class ExtendedJCheckBox extends JCheckBox {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Task task;
	public ExtendedJCheckBox(String text, Task task) {
		super(text);
		this.task=task;
	}
	@Override
	public String toString() {
		return "ExtendedJCheckBox [task=" + task + "]";
	}
	
}
