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

public class MordorLoginInsert extends JInternalFrame {

	private JPanel contentPane;
	private JTextField textField_password;
	private JTextField textField_usesr;

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
		
		textField_password = new JTextField();
		textField_password.setColumns(10);
		
		textField_usesr = new JTextField();
		textField_usesr.setColumns(10);
		
		JLabel lblIntroducirUsuario = new JLabel("Introduce usuario");
		
		JLabel lblIntroduceContrasea = new JLabel("Introduce contraseña");
		
		JButton btnEnter = new JButton("Enter");
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
					.addContainerGap(311, Short.MAX_VALUE)
					.addComponent(btnEnter)
					.addContainerGap())
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(134)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(textField_password, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
							.addComponent(lblIntroducirUsuario, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(textField_usesr)
								.addComponent(lblIntroduceContrasea, Alignment.TRAILING))))
					.addContainerGap(140, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
					.addContainerGap(42, Short.MAX_VALUE)
					.addComponent(lblIntroducirUsuario)
					.addGap(18)
					.addComponent(textField_usesr, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(41)
					.addComponent(lblIntroduceContrasea)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(textField_password, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(48)
					.addComponent(btnEnter)
					.addContainerGap())
		);
		panel.setLayout(gl_panel);
	}
}
