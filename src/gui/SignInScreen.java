package gui;

import code.*;
import gui.MainMenu;
import gui.CreateAccount;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.*;
	
	

public class SignInScreen extends JFrame implements ActionListener {
	
	private JTextField userTxtFld = new JTextField();
	private JTextField passwordTxtFld = new JTextField();
	
	private JLabel userID = new JLabel("User ID:");
	private JLabel passwordLbl = new JLabel("Password:");
	private JLabel welcomeLbl = new JLabel("Century State Banking");
	private JLabel lblOr = new JLabel("or");
	
	private JButton loginBtn = new JButton("Login");
	private JButton createBtn = new JButton("Create Account");
	
	private static final int FNAME = 0;
	private static final int LNAME = 1;
	private static final int ADDRESS = 2;
	private static final int AGE = 3;
	private static final int SSN = 4;
	
	private static final int CHECKING = 5;
	private static final int SAVINGS = 6;
	private static final int PASSWORD = 7;
	private static final int ACCOUNTNUMBER = 8;
	
	
	private ArrayList<BankAccount> accounts = new ArrayList<>(); //places all users in here to then search for the user who wants access
		
		public SignInScreen(String title) {
			super(title);
			setSize(550, 437);// gives the frame more size
			setVisible(true);//makes it so that the gui pops up
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			setUpTextFieldsAndLabels();
			setUpButtons();
			setContentPane();
		}

		@Override
		public void actionPerformed(ActionEvent arg0) {
		}
		
		
		public void setContentPane() {
			getContentPane().setLayout(null);
			getContentPane().add(userID);
			getContentPane().add(passwordLbl);
			getContentPane().add(userTxtFld);
			getContentPane().add(passwordTxtFld);
			getContentPane().add(welcomeLbl);
			getContentPane().add(loginBtn);
			getContentPane().add(createBtn);
			getContentPane().add(lblOr);
		}
		
		
		public void setUpTextFieldsAndLabels() {
			//label
			userID.setFont(new Font("Tahoma", Font.PLAIN, 25));
			userID.setBounds(134, 133, 99, 20);
			
			//label
			passwordLbl.setFont(new Font("Tahoma", Font.PLAIN, 25));
			passwordLbl.setBounds(114, 177, 128, 20);
			
			//textfield
			userTxtFld.setFont(new Font("Tahoma", Font.PLAIN, 25));
			userTxtFld.setBounds(240, 132, 180, 29);
			userTxtFld.setColumns(10);
			
			//textfield
			passwordTxtFld.setFont(new Font("Tahoma", Font.PLAIN, 25));
			passwordTxtFld.setBounds(240, 177, 180, 29);
			passwordTxtFld.setColumns(10);

			//label
			welcomeLbl.setForeground(new Color(255, 140, 0));
			welcomeLbl.setFont(new Font("Tahoma", Font.BOLD, 35));
			welcomeLbl.setBounds(66, 37, 411, 43);
			
			//Label
			lblOr.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblOr.setBounds(251, 267, 26, 20);
		}
		
		
		public void setUpButtons() {
			//********************* Log in button ********************************
			loginBtn.setFont(new Font("Tahoma", Font.PLAIN, 25));
			loginBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String fileName = "Users.txt";
					int id = Integer.parseInt(userTxtFld.getText());
					String pass = passwordTxtFld.getText();		
					
					try {
						Scanner inFile = new Scanner(new FileInputStream(fileName));

						while (inFile.hasNextLine()) {
							String line = inFile.nextLine();
							String[] bankAccountProperties = line.split(",");
								
								
							String fName = bankAccountProperties[FNAME];
							String lName = bankAccountProperties[LNAME];
							String address = bankAccountProperties[ADDRESS];
							int age = Integer.parseInt(bankAccountProperties[AGE]);
							int ssn = Integer.parseInt(bankAccountProperties[SSN]);
							double checking = Double.parseDouble(bankAccountProperties[CHECKING]);
							double savings = Double.parseDouble(bankAccountProperties[SAVINGS]);
							String password = bankAccountProperties[PASSWORD];
							int accountNumber = Integer.parseInt(bankAccountProperties[ACCOUNTNUMBER]);
							
							Customer customer = new Customer(fName, lName, address, age, ssn);
							BankAccount bankAccount = new BankAccount(checking, savings, password, accountNumber, customer);
	
							accounts.add(bankAccount);
						}
						inFile.close();
							
					} catch (FileNotFoundException e2) {
						System.out.println(fileName + " doesn't exist!");
					}		
						
				for (BankAccount bankAccount : accounts) {
					if(bankAccount.getAccountNumber() == id && bankAccount.getPassword().equals(pass)) {
						int index = accounts.indexOf(bankAccount);
						MainMenu mm = new MainMenu("Main Menu", bankAccount, index);
						mm.setVisible(true);
						setVisible(false);
					}
					else if(bankAccount.getAccountNumber() != id && bankAccount.getPassword().equals(pass)) {
						JOptionPane.showMessageDialog(null, "Invalid ID! Please retry.");
					}
					else if(bankAccount.getAccountNumber() == id && !bankAccount.getPassword().equals(pass)) {
						JOptionPane.showMessageDialog(null, "Invalid Password! Please retry.");
					}
				}	
				}});
			loginBtn.setBounds(183, 222, 153, 29);
			//*********************************************************************************************************
			
			//*********************** Create Account Button*************************************
			createBtn.setFont(new Font("Tahoma", Font.PLAIN, 25));
			createBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					CreateAccount ca = new CreateAccount("Create Account");
					ca.setSize(1100, 750);
					ca.setVisible(true);
					setVisible(false);
				}
			});
			createBtn.setBounds(155, 301, 210, 36);
			//**************************************************************************************
			
			
		}
}
