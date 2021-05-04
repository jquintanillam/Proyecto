package com.mordor.proyecto3e.modelo;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JToolBar;
import javax.swing.JDesktopPane;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MordorLogin extends JFrame {

	private JPanel contentPane;
	private JButton btnOpcionLogin;
	private JButton btnNewButton;
	private JButton btnNewButton_preference;
	private JDesktopPane desktopPane;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public MordorLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 692, 585);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("FILE");
		menuBar.add(mnFile);
		
		JMenu mnExit = new JMenu("EXIT");
		menuBar.add(mnExit);
		
		btnNewButton_preference = new JButton("Preferences");
		btnNewButton_preference.setIcon(new ImageIcon(MordorLogin.class.getResource("/imganes/outline_settings_black_24dp.png")));
		mnExit.add(btnNewButton_preference);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JToolBar toolBar = new JToolBar();
		toolBar.putClientProperty("styleId", "attached-north");
		contentPane.add(toolBar, BorderLayout.NORTH);
		
		btnOpcionLogin = new JButton(" ");
		btnOpcionLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnOpcionLogin.setIcon(new ImageIcon(MordorLogin.class.getResource("/imganes/outline_login_black_24dp.png")));
		toolBar.add(btnOpcionLogin);
		
		btnNewButton = new JButton(" ");
		btnNewButton.setIcon(new ImageIcon(MordorLogin.class.getResource("/imganes/outline_logout_black_24dp.png")));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		toolBar.add(btnNewButton);
		
		desktopPane = new JDesktopPane();
		contentPane.add(desktopPane, BorderLayout.CENTER);
		
		
		
	}

	public JDesktopPane getDesktopPane() {
		return desktopPane;
	}

	public JPanel getContentPane() {
		return contentPane;
	}

	public JButton getBtnOpcionLogin() {
		return btnOpcionLogin;
	}

	public JButton getBtnNewButton() {
		return btnNewButton;
	}

	public JButton getBtnNewButton_preference() {
		return btnNewButton_preference;
	}
}
