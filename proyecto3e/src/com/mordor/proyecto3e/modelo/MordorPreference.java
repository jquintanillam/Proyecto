package com.mordor.proyecto3e.modelo;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.JButton;

public class MordorPreference extends JInternalFrame {
	private JTextField txt_driver;
	private JTextField textField_URL;
	private JTextField textField_user;
	private JTextField textField_password;
	
	
	
	/**
	 * Create the frame.
	 */
	public MordorPreference() {
		setBounds(100, 100, 450, 300);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		
		JLabel lblDrivers = new JLabel("Drivers");
		
		JLabel lblUrl = new JLabel("URL");
		
		JLabel lblUser = new JLabel("User");
		
		JLabel lblPassword = new JLabel("Password");
		
		txt_driver = new JTextField();
		txt_driver.setHorizontalAlignment(SwingConstants.LEFT);
		txt_driver.setColumns(10);
		
		textField_URL = new JTextField();
		textField_URL.setColumns(10);
		
		textField_user = new JTextField();
		textField_user.setColumns(10);
		
		textField_password = new JTextField();
		textField_password.setText("");
		textField_password.setColumns(10);
		
		JButton btnSalir = new JButton("Salir");
		
		JButton btnEnter = new JButton("Enter");
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblPassword)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(textField_password, GroupLayout.PREFERRED_SIZE, 277, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel.createSequentialGroup()
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addComponent(lblDrivers)
										.addComponent(lblUrl)
										.addComponent(lblUser))
									.addGap(32)
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addComponent(textField_user, GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE)
										.addComponent(textField_URL, GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE)
										.addComponent(txt_driver, GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE))))
							.addGap(69))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(btnSalir)
							.addPreferredGap(ComponentPlacement.RELATED, 182, Short.MAX_VALUE)
							.addComponent(btnEnter)
							.addContainerGap())))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(21)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDrivers)
						.addComponent(txt_driver, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(35)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblUrl)
						.addComponent(textField_URL, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(41)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblUser)
						.addComponent(textField_user, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(53)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPassword)
						.addComponent(textField_password, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnSalir)
						.addComponent(btnEnter))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);

	}



	public JTextField getTxt_driver() {
		return txt_driver;
	}



	public void setTxt_driver(JTextField txt_driver) {
		this.txt_driver = txt_driver;
	}



	public JTextField getTextField_URL() {
		return textField_URL;
	}



	public void setTextField_URL(JTextField textField_URL) {
		this.textField_URL = textField_URL;
	}



	public JTextField getTextField_user() {
		return textField_user;
	}



	public void setTextField_user(JTextField textField_user) {
		this.textField_user = textField_user;
	}



	public JTextField getTextField_password() {
		return textField_password;
	}



	public void setTextField_password(JTextField textField_password) {
		this.textField_password = textField_password;
	}
}
