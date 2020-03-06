//@author Gabe Wong
//@version %I%

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class GUI extends JPanel{
	private int[] color;
	
	private int w;
	private int h;
	
	public GUI(){
		w=0;
		h=0;
		setLayout(null);
		JButton button = new JButton("Hamburger");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				w+=10;
				h+=10;
				repaint();
			}
		});
		button.setBounds(400, 100, 150, 30);
		add(button);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		setBackground(Color.WHITE);
		g.setColor(Color.BLACK);
		
	}
	private void drawLogin() {
		
	}
	private void drawCalendar() {
		
	}
	private void drawTasklist() {
		
	}
	private void drawOptions() {
		
	}
}
