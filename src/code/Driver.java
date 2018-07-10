package code;

/*
 * This Program is designed to be a personal Banking helper. It keeps track of account information and
 * profile information. These "users" are given login information to remember and accounts that hold all there information in a file that can get called later.
 * Authors: Dylan Redman and Devin Lee
 * Final Project
 * Date: 7/10/2018
 * Class CSCI 1082
 */

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
