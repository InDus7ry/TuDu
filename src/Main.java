//@author Gabe Wong
//@version %I%

import java.awt.EventQueue;

public class Main {
	public static void main(String[] args) {
		GUI taskScr;
		taskScr = new GUI();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					taskScr.start();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}
}