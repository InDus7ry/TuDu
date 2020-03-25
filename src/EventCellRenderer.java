import java.awt.Component;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

class EventCellRenderer extends JLabel implements ListCellRenderer<Object>{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	EventCellRenderer(){
	}
	
	@Override
	public Component getListCellRendererComponent(JList<? extends Object> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
		setText(((Event)value).getName() + " @ " + ((Event)value).getTime() + " on " + ((Event)value).getDateTime().substring(0,10));
		setFont(new Font("Myriad Pro SemiExt", Font.PLAIN, 20));
		if (isSelected) {
			setBackground(list.getSelectionBackground());
        } else {
        	setBackground(list.getBackground());
        }
		setEnabled(list.isEnabled());
        setOpaque(true);
		return this;
	}
}
