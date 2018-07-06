package gui;

import code.*;
import java.awt.GridLayout;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;

public class MainMenu extends JFrame {
	private Customer customer;
	private BankAccount bankAccount;
	
	private static final int ROWS = 5;
	private static final int COLUMNS = 1;
	private final JPanel menuPanel = new JPanel();
	private final JPanel viewPanel = new JPanel();
	private final JButton btnTransfer = new JButton("Transfer");
	private final JButton btnDeposit = new JButton("Deposit");
	private final JButton btnWithdraw = new JButton("Withdraw");
	private final JButton btnSignOut = new JButton("Sign Out");
	private final JLabel lblNewLabel = new JLabel("Welcome " + customer.getFristName() + 
			" " + customer.getLastName() + " to First Century Banking" );
	
		
		public MainMenu(String title) {
			super(title);
			setSize(400, 400);
			setVisible(true);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			
			createPanels();
			addPanelsToFrame();
			
			}
		
		
		
		public void createPanels() {
			
		}
		
		public void addPanelsToFrame() {
			getContentPane().setLayout(new BorderLayout(0, 0));
			
			getContentPane().add(menuPanel, BorderLayout.WEST);
			menuPanel.setLayout(new GridLayout(6, 1, 0, 0));
			
			JButton btnProfile = new JButton("Profile");
			menuPanel.add(btnProfile);
			
			JButton btnMyAccounts = new JButton("My Accounts");
			menuPanel.add(btnMyAccounts);
			
			menuPanel.add(btnTransfer);
			
			menuPanel.add(btnDeposit);
			
			menuPanel.add(btnWithdraw);
			
			menuPanel.add(btnSignOut);
			
			getContentPane().add(viewPanel, BorderLayout.CENTER);
			viewPanel.setLayout(new BorderLayout(0, 0));
			lblNewLabel.setBackground(new Color(255, 140, 0));
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			
			viewPanel.add(lblNewLabel, BorderLayout.CENTER);
		}
		
		
		
		public static void main(String[] args) {
			MainMenu gui = new MainMenu("Main Menu"); 
}
		
		
}
