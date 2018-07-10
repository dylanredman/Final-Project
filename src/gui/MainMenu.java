package gui;

import code.*;
import java.awt.GridLayout;
import gui.SignInScreen;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JTextArea;

public class MainMenu extends JFrame{
	private BankAccount bankAccount;
	private int index; // Using index to keep track of which object/line in our txt file we took our user from
	
	private DecimalFormat df = new DecimalFormat("0.00"); //decimal format since money only goes into the hundredths
	
	private JFrame f =new JFrame();
	
	private JPanel menuPanel = new JPanel();
	private JPanel viewPanel = new JPanel();
	private JPanel profilePanel = new JPanel();
	private JPanel myAccountsPanel = new JPanel();
	private JPanel transferPanel = new JPanel();
	private JPanel depositPanel = new JPanel();
	private JPanel withdrawPanel = new JPanel();
	private JPanel panel1 = new JPanel();
	private JPanel panel2 = new JPanel();
	private JPanel topPanel1 = new JPanel();
	private JPanel topPanel2 = new JPanel();
	private JPanel topPanel = new JPanel();
	private JPanel botPanel = new JPanel();
	private JPanel emptyPanel = new JPanel();
	
	private JLabel lblName = new JLabel("Name:");
	private JLabel ageLbl = new JLabel("Age:");
	private JLabel lblAddress = new JLabel("Address:");
	private JLabel lblSocialSecurity = new JLabel("Social Security:");
	private JLabel lblAccountNumber = new JLabel("Account Number:");
	private JLabel lblPassword = new JLabel("Password:");
	private JLabel lblWelcomeToCentury = new JLabel("Welcome to Century State Banking");
	private JLabel lblCheckingAccount = new JLabel("Checking Account:");
	private JLabel lblSavingsAccount = new JLabel("Savings Account:");
	private JLabel lblTransferAmount = new JLabel(" Transfer Amount:");
	private JLabel lblTransferingFrom = new JLabel("Transfering From:");
	private JLabel lblTransferingTo = new JLabel("     Transfering To:");
	private JLabel lblDepositAmount = new JLabel(" Deposit Amount:");
	private JLabel lblAccountToDeposit = new JLabel("Account to Deposit In:");
	private JLabel lblWithdrawAmount = new JLabel(" Withdraw Amount:");
	private JLabel lblAccountToWithdraw = new JLabel("Account to Withdraw From:");

	private JButton btnMyAccounts = new JButton("My Accounts");
	private JButton btnProfile = new JButton("Profile");
	private JButton btnTransfer = new JButton("Transfer");
	private JButton btnDeposit = new JButton("Deposit");
	private JButton btnWithdraw = new JButton("Withdraw");
	private JButton btnSignOut = new JButton("Sign Out");
	private JButton transferBtn = new JButton("Transfer");
	private JButton depositBtn = new JButton("Deposit");
	private JButton btnWithdraw_1 = new JButton("Withdraw");
	
	private JTextField nameTxtFld = new JTextField();
	private JTextField addressTxtFld = new JTextField();
	private JTextField ageTxtFld = new JTextField();
	private JTextField ssnTxtFld = new JTextField();
	private JTextField accountNumTxtFld = new JTextField();
	private JTextField passwordTxtFld = new JTextField();
	private JTextField checkingTxtFld = new JTextField();
	private JTextField savingsTxtFld = new JTextField();
	private JTextField transferAmtTxtFld = new JTextField();
	private JTextField depositAmount = new JTextField();
	private JTextField withdrawAmountTxtFld = new JTextField();
	
	//Static values for our line split---- Customer object
	private static final int FNAME = 0;
	private static final int LNAME = 1;
	private static final int ADDRESS = 2;
	private static final int AGE = 3;
	private static final int SSN = 4;
	
	//Static values for our line Split----BankAccount object
	private static final int CHECKING = 5;
	private static final int SAVINGS = 6;
	private static final int PASSWORD = 7;
	private static final int ACCOUNTNUMBER = 8;
	
	
	private ArrayList<BankAccount> accounts = new ArrayList<>();

	private String[] options = {"", "Savings", "Checking"}; // for our combo boxes
	
	private final JTextArea transferTxtArea = new JTextArea();//text area for output to user
	private final JTextArea depositTxtArea = new JTextArea();
	private final JTextArea withdrawTxtArea = new JTextArea();
	
	private JComboBox<String> toComboBox = new JComboBox<>(options);
	private JComboBox<String> depositComboBox = new JComboBox<>(options);
	private JComboBox<String> fromComboBox = new JComboBox<>(options);
	private JComboBox<String> withdrawComboBox = new JComboBox<>(options);
	
	private FlowLayout flowLayout;
	
		public MainMenu(String title, BankAccount bankacc, int indexx) {
			super(title);
			bankAccount = bankacc;
			index = indexx;

			setSize(662, 614);
			setVisible(false);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			
			setLayouts();
			addLabelsAndTextAreas();
			setUpButtons();
			setUpTextFields();
			addPanelsToFrame();
			
			
			}
		
		public void setUpButtons() {
			
			//************************************Main menu buttons*********************************
			//Profile menu button**********
			btnProfile.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent arg0) {
					CardLayout c = (CardLayout) (viewPanel.getLayout()); //Action listener
					c.show(viewPanel, "profile");
				}
			});
			btnProfile.setFont(new Font("Tahoma", Font.BOLD, 20));
			btnProfile.setForeground(new Color(0, 0, 0));
			btnProfile.setBackground(new Color(255, 140, 0));
			
			
			//My Accounts menu Button**********
			btnMyAccounts.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					CardLayout c = (CardLayout) (viewPanel.getLayout()); //Action listener
					c.show(viewPanel, "accounts");
				}
			});
			btnMyAccounts.setFont(new Font("Tahoma", Font.BOLD, 20));
			btnMyAccounts.setBackground(new Color(255, 140, 0));
			btnMyAccounts.setForeground(new Color(0, 0, 0));
			
			
			//Transfer menu Button********
			btnTransfer.setForeground(new Color(0, 0, 0));
			btnTransfer.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					CardLayout c = (CardLayout) (viewPanel.getLayout()); //Action listener
					c.show(viewPanel, "transfer");
					transferAmtTxtFld.setText("");
					toComboBox.setSelectedIndex(0);
					fromComboBox.setSelectedIndex(0);
					transferTxtArea.setText("");
				}
			});
			btnTransfer.setFont(new Font("Tahoma", Font.BOLD, 20));
			btnTransfer.setBackground(new Color(255, 140, 0));
			
			
			//Deposit menu Button**********
			btnDeposit.setForeground(new Color(0, 0, 0));
			btnDeposit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					CardLayout c = (CardLayout) (viewPanel.getLayout());//Action listener
					c.show(viewPanel, "deposit");
					depositTxtArea.setText("");
					depositAmount.setText("");
					depositComboBox.setSelectedIndex(0);
				}
			});
			btnDeposit.setFont(new Font("Tahoma", Font.BOLD, 20));
			btnDeposit.setBackground(new Color(255, 140, 0));
			
			
			//Withdraw menu Button********
			btnWithdraw.setForeground(new Color(0, 0, 0));
			btnWithdraw.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					CardLayout c = (CardLayout) (viewPanel.getLayout());//Action listener
					c.show(viewPanel, "withdraw");
					withdrawAmountTxtFld.setText("");
					withdrawComboBox.setSelectedIndex(0);
					withdrawTxtArea.setText("");
				}
			});
			btnWithdraw.setFont(new Font("Tahoma", Font.BOLD, 20));
			btnWithdraw.setBackground(new Color(255, 140, 0));
			
			
			//SignOut menu button**********
			btnSignOut.setForeground(new Color(0, 0, 0));
			btnSignOut.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				    int a=JOptionPane.showConfirmDialog(f,"Do you want to save changes before exiting?");  //Action Listener
				    if(a==JOptionPane.YES_OPTION){  
				        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
				        setVisible(false);
				        SignInScreen ss = new SignInScreen("Log-In");
				        ss.setVisible(true);
				        			        
				        String fileName = "Users.txt";	
						
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
							
							accounts.set(index, bankAccount);
							
							
							//clears file
							PrintWriter writer = new PrintWriter(fileName);
							writer.print("");
							writer.close();
							
							//writes updated accounts
							PrintWriter outputFile = new PrintWriter(new FileOutputStream(fileName, true));
							for (BankAccount bankAccount : accounts) {
								outputFile.println(bankAccount.toString());
							}
							outputFile.close();
		
							inFile.close();	
						} catch (FileNotFoundException e2) {
							System.out.println(fileName + " doesn't exist!");
						}
				        
				    } 
				    else if(a == JOptionPane.NO_OPTION){
				    	f.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
				    }
				    else if(a == JOptionPane.CANCEL_OPTION){
				    	f.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
				    }	
					
				}
			});
			btnSignOut.setFont(new Font("Tahoma", Font.BOLD, 20));
			btnSignOut.setBackground(new Color(255, 140, 0));
			//*****************************************************************************************
			
			
			//************* Transfer Button in transfer screen*************
			transferBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					double amount = Double.parseDouble(transferAmtTxtFld.getText());
					String choice1 = fromComboBox.getItemAt(fromComboBox.getSelectedIndex());
					String choice2 = toComboBox.getItemAt(toComboBox.getSelectedIndex());
					
					
					if(choice1.equals("") || choice2.equals("")) {
						transferTxtArea.append("Please select the accounts to transfer from and to.\n");
					}
					else if(choice1.equals("Savings") && choice2.equals("Savings")) {
						transferTxtArea.append("Declined! Can not transfer to the same account!\n");
					}
					else if(choice1.equals("Checking") && choice2.equals("Checking")) {
						transferTxtArea.append("Declined! Can not transfer to the same account!\n");
					}
					else if(choice1.equals("Savings") && choice2.equals("Checking")){
						if(amount > 0 && amount <= bankAccount.getSavings()) {
							bankAccount.setSavings(bankAccount.getSavings() - amount);
							bankAccount.setChecking(bankAccount.getChecking() + amount);
							transferTxtArea.append("Transfer Successful!\n");
							checkingTxtFld.setText("$" + df.format(bankAccount.getChecking()));
							savingsTxtFld.setText("$" + df.format(bankAccount.getSavings()));
							
							}
						else {
							transferTxtArea.append("Invalid Input! Amount surpasses account funds or amount is negative!\n");
						}
					}
					else if(choice1.equals("Checking") && choice2.equals("Savings")){
						if(amount > 0 && amount <= bankAccount.getChecking()) {
							transferTxtArea.append("Transfer Successful!\n");
							bankAccount.setSavings(bankAccount.getSavings() + amount);
							bankAccount.setChecking(bankAccount.getChecking() - amount);
							checkingTxtFld.setText("$" + df.format(bankAccount.getChecking()));
							savingsTxtFld.setText("$" + df.format(bankAccount.getSavings()));
							}
						else {
							transferTxtArea.append("Invalid Input! Amount surpasses account funds or amount is negative!\n");
						}
						
					}
					
				}
			});
			transferBtn.setFont(new Font("Tahoma", Font.PLAIN, 30));
			transferBtn.setBackground(new Color(255, 255, 255));
			//************************************************************************************************
			
			//************* Deposit Button in deposit screen****************
			depositBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					double amount = Double.parseDouble(depositAmount.getText());
					String choice = depositComboBox.getItemAt(depositComboBox.getSelectedIndex());
					
					if(choice.equals("Savings") && amount > 0) {
						bankAccount.setSavings(bankAccount.getSavings() + amount);
						depositTxtArea.setText("Deposit Successful!\n");
						savingsTxtFld.setText("$" + df.format(bankAccount.getSavings()));
					}
					else if(choice.equals("Checking") && amount > 0) {
						bankAccount.setChecking(bankAccount.getChecking() + amount);
						depositTxtArea.setText("Deposit Successful!\n");
						checkingTxtFld.setText("$" + df.format(bankAccount.getChecking()));
					}
					else if(choice.equals("")) {
						depositTxtArea.setText("Declined! Please select an account to deposit in!\n");
					}
					else {
						depositTxtArea.setText("Declined! Deposit amount is negative or invalid! Please retry.\n");
					}	
					
				}
			});
			depositBtn.setFont(new Font("Tahoma", Font.BOLD, 30));
			depositBtn.setBackground(new Color(255, 255, 255));
			//***************************************************************************************
			
			//********************Withdraw Button in Withdraw*******************
			btnWithdraw_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					double amount = Double.parseDouble(withdrawAmountTxtFld.getText());
					String choice = withdrawComboBox.getItemAt(withdrawComboBox.getSelectedIndex());
					
					if(choice.equals("Savings") && amount > 0 && amount <= bankAccount.getSavings()) {
						bankAccount.setSavings(bankAccount.getSavings() - amount);
						withdrawTxtArea.setText("Withdraw Successful!\n");
						savingsTxtFld.setText("$" + df.format(bankAccount.getSavings()));
					}
					else if(choice.equals("Checking") && amount > 0 && amount <= bankAccount.getChecking()) {
						bankAccount.setChecking(bankAccount.getChecking() - amount);
						withdrawTxtArea.setText("Withdraw Successful!\n");
						checkingTxtFld.setText("$" + df.format(bankAccount.getChecking()));
					}
					else if(choice.equals("")) {
						withdrawTxtArea.setText("Declined! Please select an account to withdraw from!\n");
					}
					else {
						withdrawTxtArea.setText("Declined! Withdraw amount is negative or invalid! Please retry.\n");
					}
					
				}
			});
			
			btnWithdraw_1.setFont(new Font("Tahoma", Font.BOLD, 30));
			btnWithdraw_1.setBackground(new Color(255, 255, 255));
		}
		
		
		public void setUpTextFields() {
			depositAmount.setFont(new Font("Tahoma", Font.PLAIN, 20));
			depositAmount.setColumns(10);
			
			withdrawAmountTxtFld.setFont(new Font("Tahoma", Font.PLAIN, 20));
			withdrawAmountTxtFld.setColumns(10);
			
			transferAmtTxtFld.setFont(new Font("Tahoma", Font.PLAIN, 20));
			transferAmtTxtFld.setColumns(10);
			
			savingsTxtFld.setFont(new Font("Tahoma", Font.PLAIN, 25));
			savingsTxtFld.setText("$" + bankAccount.getSavings());
			savingsTxtFld.setBackground(new Color(255, 255, 255));
			savingsTxtFld.setEditable(false);
			savingsTxtFld.setColumns(15);
			
			checkingTxtFld.setFont(new Font("Tahoma", Font.PLAIN, 25));
			checkingTxtFld.setText("$" + bankAccount.getChecking());
			checkingTxtFld.setBackground(new Color(255, 255, 255));
			checkingTxtFld.setEditable(false);
			checkingTxtFld.setColumns(15);			

			passwordTxtFld.setText(bankAccount.getPassword());
			passwordTxtFld.setBackground(new Color(255, 255, 255));
			passwordTxtFld.setEditable(false);
			passwordTxtFld.setColumns(10);
			
			accountNumTxtFld.setText("" + bankAccount.getAccountNumber());
			accountNumTxtFld.setBackground(Color.WHITE);
			accountNumTxtFld.setForeground(Color.RED);
			accountNumTxtFld.setFont(new Font("Tahoma", Font.BOLD, 20));
			accountNumTxtFld.setEditable(false);
			accountNumTxtFld.setColumns(15);
			
			ssnTxtFld.setText("" + bankAccount.getCustomer().getSsn());
			ssnTxtFld.setBackground(Color.WHITE);
			ssnTxtFld.setEditable(false);
			ssnTxtFld.setColumns(13);
			
			ageTxtFld.setText("" + bankAccount.getCustomer().getAge());
			ageTxtFld.setBackground(Color.WHITE);
			ageTxtFld.setEditable(false);
			ageTxtFld.setColumns(8);
			
			addressTxtFld.setText(bankAccount.getCustomer().getaddress());
			addressTxtFld.setBackground(Color.WHITE);
			addressTxtFld.setEditable(false);
			addressTxtFld.setColumns(15);			
			
			String fname = bankAccount.getCustomer().getFristName();
			String lname = bankAccount.getCustomer().getLastName();
			nameTxtFld.setText(fname + " " + lname);
			nameTxtFld.setBackground(Color.WHITE);
			nameTxtFld.setEditable(false);
			nameTxtFld.setColumns(10);
		}
		
		
		public void addPanelsToFrame() {
			getContentPane().setLayout(new BorderLayout(0, 0));
			getContentPane().add(menuPanel, BorderLayout.WEST);
			getContentPane().add(viewPanel, BorderLayout.CENTER);
			
			
			menuPanel.setLayout(new GridLayout(6, 1, 0, 0));
			menuPanel.add(btnProfile);
			menuPanel.add(btnMyAccounts);
			menuPanel.add(btnTransfer);
			menuPanel.add(btnDeposit);
			menuPanel.add(btnWithdraw);
			menuPanel.add(btnSignOut);
			
			viewPanel.setLayout(new CardLayout(0, 0));
			viewPanel.add(emptyPanel, "name_3550034601258780");
			viewPanel.add(profilePanel, "profile");
			viewPanel.add(myAccountsPanel, "accounts");
			viewPanel.add(transferPanel, "transfer");
			viewPanel.add(depositPanel, "deposit");
			viewPanel.add(withdrawPanel, "withdraw");
			
			emptyPanel.setBackground(new Color(255, 255, 255));
			emptyPanel.setLayout(new BorderLayout(0, 0));
			emptyPanel.add(lblWelcomeToCentury, BorderLayout.CENTER);	
			
			profilePanel.setBackground(Color.WHITE);
			profilePanel.add(lblName);			
			profilePanel.add(nameTxtFld);
			profilePanel.add(lblAddress);
			profilePanel.add(addressTxtFld);		
			profilePanel.add(ageLbl);
			profilePanel.add(ageTxtFld);		
			profilePanel.add(lblSocialSecurity);
			profilePanel.add(ssnTxtFld);
			profilePanel.add(lblAccountNumber);
			profilePanel.add(accountNumTxtFld);
			profilePanel.add(lblPassword);
			profilePanel.add(passwordTxtFld);
			
			myAccountsPanel.setBackground(new Color(255, 255, 255));
			myAccountsPanel.add(lblCheckingAccount);
			myAccountsPanel.add(checkingTxtFld);
			myAccountsPanel.add(lblSavingsAccount);
			myAccountsPanel.add(savingsTxtFld);
			
			transferPanel.setLayout(new GridLayout(2, 1, 0, 0));
			transferPanel.add(panel1);
			panel1.add(lblTransferAmount);
			panel1.add(transferAmtTxtFld);
			panel1.add(lblTransferingFrom);
			panel1.add(fromComboBox);
			fromComboBox.setBackground(new Color(255, 255, 255));
			fromComboBox.setFont(new Font("Tahoma", Font.PLAIN, 25));
			panel1.add(lblTransferingTo);
			panel1.add(toComboBox);
			toComboBox.setBackground(new Color(255, 255, 255));
			toComboBox.setFont(new Font("Tahoma", Font.PLAIN, 25));
			panel1.add(transferBtn);
			transferPanel.add(panel2);
			panel2.setLayout(new BorderLayout(0, 0));
			panel2.add(transferTxtArea, BorderLayout.CENTER);	
			
			depositPanel.setBackground(new Color(255, 255, 255));
			depositPanel.setLayout(new GridLayout(2, 1, 0, 0));
			topPanel.setBackground(new Color(255, 255, 255));
			depositPanel.add(topPanel);
			depositPanel.add(botPanel);
			topPanel.add(lblDepositAmount);
			topPanel.add(depositAmount);
			topPanel.add(lblAccountToDeposit);
			topPanel.add(depositComboBox);
			topPanel.add(depositBtn);
			depositComboBox.setBackground(new Color(255, 255, 255));
			depositComboBox.setFont(new Font("Tahoma", Font.PLAIN, 25));
			botPanel.setLayout(new BorderLayout(0, 0));
			botPanel.add(depositTxtArea, BorderLayout.CENTER);
			
			withdrawPanel.setBackground(new Color(255, 255, 255));
			withdrawPanel.setLayout(new GridLayout(2, 1, 0, 0));
			topPanel1.setBackground(new Color(255, 255, 255));
			panel1.setBackground(new Color(255, 255, 255));
			withdrawPanel.add(topPanel1);
			withdrawPanel.add(topPanel2);
			topPanel1.add(lblWithdrawAmount);
			topPanel1.add(withdrawAmountTxtFld);
			topPanel1.add(lblAccountToWithdraw);
			topPanel1.add(withdrawComboBox);
			topPanel1.add(btnWithdraw_1);
			withdrawComboBox.setBackground(new Color(255, 255, 255));
			withdrawComboBox.setFont(new Font("Tahoma", Font.PLAIN, 25));
			topPanel2.setBackground(new Color(255, 255, 255));
			topPanel2.setLayout(new BorderLayout(0, 0));
			topPanel2.add(withdrawTxtArea, BorderLayout.CENTER);
		}
		
		
		
		public void addLabelsAndTextAreas() {
			//start up menu
			lblWelcomeToCentury.setForeground(new Color(255, 140, 0));
			lblWelcomeToCentury.setFont(new Font("Tahoma", Font.BOLD, 27));
			lblWelcomeToCentury.setHorizontalAlignment(SwingConstants.CENTER);
			
			//profile
			lblName.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 20));
			ageLbl.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblSocialSecurity.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblAccountNumber.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
			
			//My Accounts
			lblCheckingAccount.setFont(new Font("Tahoma", Font.BOLD, 20));
			lblSavingsAccount.setFont(new Font("Tahoma", Font.BOLD, 20));
			transferPanel.setBackground(new Color(255, 255, 255));
			
			//Transfer
			lblTransferAmount.setFont(new Font("Tahoma", Font.BOLD, 20));
			lblTransferingFrom.setFont(new Font("Tahoma", Font.BOLD, 25));
			lblTransferingTo.setFont(new Font("Tahoma", Font.BOLD, 25));
			transferTxtArea.setFont(new Font("Tahoma", Font.PLAIN, 16));
			transferTxtArea.setEditable(false);
			transferTxtArea.setBackground(new Color(255, 255, 255));
			
			//Deposit
			lblDepositAmount.setFont(new Font("Tahoma", Font.BOLD, 20));
			lblAccountToDeposit.setFont(new Font("Tahoma", Font.BOLD, 20));
			depositTxtArea.setFont(new Font("Tahoma", Font.PLAIN, 16));
			depositTxtArea.setEditable(false);
			depositTxtArea.setBackground(new Color(255, 255, 255));
			
			//Withdraw
			lblWithdrawAmount.setFont(new Font("Tahoma", Font.BOLD, 20));
			lblAccountToWithdraw.setFont(new Font("Tahoma", Font.BOLD, 20));
			withdrawTxtArea.setFont(new Font("Tahoma", Font.PLAIN, 16));
			withdrawTxtArea.setEditable(false);
			
		}
		
		
		
		public void setLayouts() {
			flowLayout = (FlowLayout) topPanel1.getLayout();
			flowLayout.setVgap(35);

			flowLayout = (FlowLayout) topPanel.getLayout();
			flowLayout.setVgap(35);
		
			flowLayout = (FlowLayout) panel1.getLayout();
			flowLayout.setVgap(30);
			
			flowLayout = (FlowLayout) profilePanel.getLayout();
			flowLayout.setVgap(30);
			
			flowLayout = (FlowLayout) myAccountsPanel.getLayout();
			flowLayout.setVgap(35);
		}
		
		
}
