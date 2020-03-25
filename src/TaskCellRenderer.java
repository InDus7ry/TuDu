import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

class TaskCellRenderer extends JLabel implements ListCellRenderer<Object>{
	DefaultListModel<Task> model;
	ArrayList<Color> colors = new ArrayList<Color>();
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	TaskCellRenderer(DefaultListModel<Task> model){
		this.model=model;
		colors.add(Color.red);
		colors.add(Color.orange);
		colors.add(Color.yellow);
		colors.add(Color.white);
	}
	
	@Override
	public Component getListCellRendererComponent(JList<? extends Object> list, Object value,
			int index, boolean isSelected, boolean cellHasFocus) {
		setText(((Task) value).getName());
		setFont(new Font("Myriad Pro SemiExt", Font.PLAIN, 20));
		setBackground(colors.get(((Task) value).getPriority() - 1));
		if (isSelected) {
			model.elementAt(index).complete();
			model.remove(index);
		}
		setEnabled(list.isEnabled());
		setOpaque(true);
		return this;
	}
}
