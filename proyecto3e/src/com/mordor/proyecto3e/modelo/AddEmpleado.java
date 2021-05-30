package com.mordor.proyecto3e.modelo;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JPasswordField;

import com.alee.extended.date.WebDateField;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.sql.Date;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;

public class AddEmpleado extends JInternalFrame {
	private JTextField textname;
	private JTextField textsurname;
	private JTextField textaddress;
	private JTextField textcp;
	private JTextField textemail;
	private WebDateField textfecha;
	private JButton btnSave;
	private JButton btnCancel;
	private JTextField textdni;
	private JPasswordField textpass;
	private JTextField textJob;

	/**
	 * Create the frame.
	 */
	public AddEmpleado() {
		setBounds(100, 100, 500, 351);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		JLabel lblDni = DefaultComponentFactory.getInstance().createLabel("DNI");
		lblDni.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblDni = new GridBagConstraints();
		gbc_lblDni.anchor = GridBagConstraints.WEST;
		gbc_lblDni.insets = new Insets(0, 0, 5, 5);
		gbc_lblDni.gridx = 1;
		gbc_lblDni.gridy = 1;
		getContentPane().add(lblDni, gbc_lblDni);
		
		textdni = new JTextField();
		GridBagConstraints gbc_textdni = new GridBagConstraints();
		gbc_textdni.insets = new Insets(0, 0, 5, 0);
		gbc_textdni.fill = GridBagConstraints.HORIZONTAL;
		gbc_textdni.gridx = 2;
		gbc_textdni.gridy = 1;
		getContentPane().add(textdni, gbc_textdni);
		textdni.setColumns(10);
		
		JLabel lblName = DefaultComponentFactory.getInstance().createLabel("Name");
		GridBagConstraints gbc_lblName = new GridBagConstraints();
		gbc_lblName.anchor = GridBagConstraints.WEST;
		gbc_lblName.insets = new Insets(0, 0, 5, 5);
		gbc_lblName.gridx = 1;
		gbc_lblName.gridy = 2;
		getContentPane().add(lblName, gbc_lblName);
		
		textname = new JTextField();
		GridBagConstraints gbc_textname = new GridBagConstraints();
		gbc_textname.insets = new Insets(0, 0, 5, 0);
		gbc_textname.fill = GridBagConstraints.HORIZONTAL;
		gbc_textname.gridx = 2;
		gbc_textname.gridy = 2;
		getContentPane().add(textname, gbc_textname);
		textname.setColumns(10);
		
		JLabel lblSurname = DefaultComponentFactory.getInstance().createLabel("Surname");
		GridBagConstraints gbc_lblSurname = new GridBagConstraints();
		gbc_lblSurname.anchor = GridBagConstraints.WEST;
		gbc_lblSurname.insets = new Insets(0, 0, 5, 5);
		gbc_lblSurname.gridx = 1;
		gbc_lblSurname.gridy = 3;
		getContentPane().add(lblSurname, gbc_lblSurname);
		
		textsurname = new JTextField();
		GridBagConstraints gbc_textsurname = new GridBagConstraints();
		gbc_textsurname.insets = new Insets(0, 0, 5, 0);
		gbc_textsurname.fill = GridBagConstraints.HORIZONTAL;
		gbc_textsurname.gridx = 2;
		gbc_textsurname.gridy = 3;
		getContentPane().add(textsurname, gbc_textsurname);
		textsurname.setColumns(10);
		
		JLabel lblAddress = DefaultComponentFactory.getInstance().createLabel("Address");
		GridBagConstraints gbc_lblAddress = new GridBagConstraints();
		gbc_lblAddress.anchor = GridBagConstraints.WEST;
		gbc_lblAddress.insets = new Insets(0, 0, 5, 5);
		gbc_lblAddress.gridx = 1;
		gbc_lblAddress.gridy = 4;
		getContentPane().add(lblAddress, gbc_lblAddress);
		
		textaddress = new JTextField();
		GridBagConstraints gbc_textaddress = new GridBagConstraints();
		gbc_textaddress.insets = new Insets(0, 0, 5, 0);
		gbc_textaddress.fill = GridBagConstraints.HORIZONTAL;
		gbc_textaddress.gridx = 2;
		gbc_textaddress.gridy = 4;
		getContentPane().add(textaddress, gbc_textaddress);
		textaddress.setColumns(10);
		
		JLabel lblCp = DefaultComponentFactory.getInstance().createLabel("CP");
		GridBagConstraints gbc_lblCp = new GridBagConstraints();
		gbc_lblCp.anchor = GridBagConstraints.WEST;
		gbc_lblCp.insets = new Insets(0, 0, 5, 5);
		gbc_lblCp.gridx = 1;
		gbc_lblCp.gridy = 5;
		getContentPane().add(lblCp, gbc_lblCp);
		
		textcp = new JTextField();
		GridBagConstraints gbc_textcp = new GridBagConstraints();
		gbc_textcp.insets = new Insets(0, 0, 5, 0);
		gbc_textcp.fill = GridBagConstraints.HORIZONTAL;
		gbc_textcp.gridx = 2;
		gbc_textcp.gridy = 5;
		getContentPane().add(textcp, gbc_textcp);
		textcp.setColumns(10);
		
		JLabel lblEmail = DefaultComponentFactory.getInstance().createLabel("Email");
		GridBagConstraints gbc_lblEmail = new GridBagConstraints();
		gbc_lblEmail.anchor = GridBagConstraints.WEST;
		gbc_lblEmail.insets = new Insets(0, 0, 5, 5);
		gbc_lblEmail.gridx = 1;
		gbc_lblEmail.gridy = 6;
		getContentPane().add(lblEmail, gbc_lblEmail);
		
		textemail = new JTextField();
		GridBagConstraints gbc_textemail = new GridBagConstraints();
		gbc_textemail.insets = new Insets(0, 0, 5, 0);
		gbc_textemail.fill = GridBagConstraints.HORIZONTAL;
		gbc_textemail.gridx = 2;
		gbc_textemail.gridy = 6;
		getContentPane().add(textemail, gbc_textemail);
		textemail.setColumns(10);
		
		JLabel lblBirthday = DefaultComponentFactory.getInstance().createLabel("Birthday");
		GridBagConstraints gbc_lblBirthday = new GridBagConstraints();
		gbc_lblBirthday.anchor = GridBagConstraints.WEST;
		gbc_lblBirthday.insets = new Insets(0, 0, 5, 5);
		gbc_lblBirthday.gridx = 1;
		gbc_lblBirthday.gridy = 7;
		getContentPane().add(lblBirthday, gbc_lblBirthday);
		
		textfecha = new WebDateField();
		GridBagConstraints gbc_textfecha = new GridBagConstraints();
		gbc_textfecha.insets = new Insets(0, 0, 5, 0);
		gbc_textfecha.fill = GridBagConstraints.HORIZONTAL;
		gbc_textfecha.gridx = 2;
		gbc_textfecha.gridy = 7;
		getContentPane().add(textfecha, gbc_textfecha);
		
		
		JLabel lblJobPosition = DefaultComponentFactory.getInstance().createLabel("Job position");
		GridBagConstraints gbc_lblJobPosition = new GridBagConstraints();
		gbc_lblJobPosition.anchor = GridBagConstraints.EAST;
		gbc_lblJobPosition.insets = new Insets(0, 0, 5, 5);
		gbc_lblJobPosition.gridx = 1;
		gbc_lblJobPosition.gridy = 8;
		getContentPane().add(lblJobPosition, gbc_lblJobPosition);
		
		textJob = new JTextField();
		GridBagConstraints gbc_textJob = new GridBagConstraints();
		gbc_textJob.insets = new Insets(0, 0, 5, 0);
		gbc_textJob.fill = GridBagConstraints.HORIZONTAL;
		gbc_textJob.gridx = 2;
		gbc_textJob.gridy = 8;
		getContentPane().add(textJob, gbc_textJob);
		textJob.setColumns(10);
		
		JLabel lblPassword = DefaultComponentFactory.getInstance().createLabel("Password");
		GridBagConstraints gbc_lblPassword = new GridBagConstraints();
		gbc_lblPassword.anchor = GridBagConstraints.EAST;
		gbc_lblPassword.insets = new Insets(0, 0, 5, 5);
		gbc_lblPassword.gridx = 1;
		gbc_lblPassword.gridy = 9;
		getContentPane().add(lblPassword, gbc_lblPassword);
		
		textpass = new JPasswordField();
		GridBagConstraints gbc_textpass = new GridBagConstraints();
		gbc_textpass.insets = new Insets(0, 0, 5, 0);
		gbc_textpass.fill = GridBagConstraints.HORIZONTAL;
		gbc_textpass.gridx = 2;
		gbc_textpass.gridy = 9;
		getContentPane().add(textpass, gbc_textpass);
		textpass.setColumns(10);
		
		btnSave = new JButton("Save");
		GridBagConstraints gbc_btnSave = new GridBagConstraints();
		gbc_btnSave.insets = new Insets(0, 0, 0, 5);
		gbc_btnSave.gridx = 1;
		gbc_btnSave.gridy = 10;
		getContentPane().add(btnSave, gbc_btnSave);
		
		btnCancel = new JButton("Cancel");
		GridBagConstraints gbc_btnCancel = new GridBagConstraints();
		gbc_btnCancel.gridx = 2;
		gbc_btnCancel.gridy = 10;
		getContentPane().add(btnCancel, gbc_btnCancel);

	}

	public JButton getBtnSave() {
		return btnSave;
	}

	public JButton getBtnCancel() {
		return btnCancel;
	}

	public JTextField getTextname() {
		return textname;
	}

	public JTextField getTextsurname() {
		return textsurname;
	}

	public JTextField getTextcp() {
		return textcp;
	}

	public JTextField getTextemail() {
		return textemail;
	}

	public WebDateField getTextfecha() {
		return textfecha;
	}

	public JTextField getTextjob() {
		return textJob;
	}
	
	public JTextField getTextaddress() {
		return textaddress;
	}

	public JPasswordField getTextpass() {
		return textpass;
	}

	public JTextField getTextdni() {
		return textdni;
	}
	
	

}
