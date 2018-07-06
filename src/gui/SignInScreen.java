package gui;

import code.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
	
	

public class SignInScreen extends JFrame implements ActionListener {
	private JTextField userTxtFld;
	private JTextField passwordTxtFld;
	
	
		
		
		public SignInScreen(String title) {
			super(title);
			setSize(400, 400);// gives the frame more size
			setVisible(true);//makes it so that the gui pops up
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			getContentPane().setLayout(null);
			
			JLabel userID = new JLabel("User ID:");
			userID.setBounds(84, 127, 69, 20);
			getContentPane().add(userID);
			
			JLabel passwordLbl = new JLabel("Password:");
			passwordLbl.setBounds(72, 169, 95, 20);
			getContentPane().add(passwordLbl);
			
			userTxtFld = new JTextField();
			userTxtFld.setBounds(150, 124, 146, 26);
			getContentPane().add(userTxtFld);
			userTxtFld.setColumns(10);
			
			passwordTxtFld = new JTextField();
			passwordTxtFld.setBounds(150, 166, 146, 26);
			getContentPane().add(passwordTxtFld);
			passwordTxtFld.setColumns(10);
			
			JLabel welcomeLbl = new JLabel("Welcome To Century State");
			welcomeLbl.setForeground(new Color(255, 140, 0));
			welcomeLbl.setFont(new Font("Tahoma", Font.BOLD, 22));
			welcomeLbl.setBounds(39, 16, 305, 43);
			getContentPane().add(welcomeLbl);
			
			JLabel welcome2Lbl = new JLabel("Banking");
			welcome2Lbl.setFont(new Font("Tahoma", Font.BOLD, 22));
			welcome2Lbl.setForeground(new Color(255, 140, 0));
			welcome2Lbl.setBounds(137, 62, 103, 26);
			getContentPane().add(welcome2Lbl);
			
			JButton loginBtn = new JButton("Login");
			loginBtn.setBounds(137, 209, 115, 29);
			getContentPane().add(loginBtn);
			
			JButton createBtn = new JButton("Create Account");
			createBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
				}
			});
			
			
			createBtn.setBounds(119, 260, 153, 29);
			getContentPane().add(createBtn);
			
			
		}
		

		public void actionPerformed(ActionEvent callingButtonEvent) {
			String nameOfCallingBtn = callingButtonEvent.getActionCommand();
			System.out.println(nameOfCallingBtn+ " button clicked!");
		}
		
		public static void main(String[] args) {
			SignInScreen gui = new SignInScreen("Log-In");
			
}
}
