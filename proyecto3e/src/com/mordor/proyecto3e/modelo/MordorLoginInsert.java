package com.mordor.proyecto3e.modelo;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JPasswordField;

public class MordorLoginInsert extends JInternalFrame {

	private JPanel contentPane;
	private JTextField textField_usesr;
	private JPasswordField passwordField;
	private JButton btnEnter;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public MordorLoginInsert() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);

		textField_usesr = new JTextField();
		textField_usesr.setColumns(10);

		JLabel lblIntroducirUsuario = new JLabel("Introduce usuario");

		JLabel lblIntroduceContrasea = new JLabel("Introduce contraseña");

		btnEnter = new JButton("Enter");

		passwordField = new JPasswordField();
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup().addContainerGap(346, Short.MAX_VALUE).addComponent(btnEnter)
						.addContainerGap())
				.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup().addGap(134).addGroup(gl_panel
						.createParallelGroup(Alignment.TRAILING)
						.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, 165, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblIntroducirUsuario, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(textField_usesr, 166, 166, 166)
								.addComponent(lblIntroduceContrasea, Alignment.TRAILING)))
						.addContainerGap(130, Short.MAX_VALUE)));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup().addContainerGap(34, Short.MAX_VALUE)
						.addComponent(lblIntroducirUsuario).addGap(18)
						.addComponent(textField_usesr, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addGap(41).addComponent(lblIntroduceContrasea).addGap(18)
						.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addGap(41).addComponent(btnEnter).addContainerGap()));
		panel.setLayout(gl_panel);
	}

	public JPasswordField getPasswordField() {
		return passwordField;
	}

	public JTextField getTextField_usesr() {
		return textField_usesr;
	}

	public JButton getBtnEnter() {
		return btnEnter;
	}

}
