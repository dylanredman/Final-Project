package code;

import java.awt.EventQueue;

import gui.SignInScreen;

public class Driver {
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignInScreen gui = new SignInScreen("Log-In");
					gui.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}
	

}
