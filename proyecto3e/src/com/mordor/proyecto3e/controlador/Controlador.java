package com.mordor.proyecto3e.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.mordor.proyecto3e.modelo.MordorLogin;
import com.mordor.proyecto3e.modelo.MordorLoginInsert;
import com.mordor.proyecto3e.modelo.MordorPreference;

public class Controlador implements ActionListener{

	private MordorLogin mordorLogin;
	private MordorLoginInsert mordorLoginIn;
	private MordorPreference mordorPre;
	
	public Controlador(MordorLogin mordorLogin , MordorLoginInsert mordorLoginIn, MordorPreference mordorPre) {
		this.mordorLogin = mordorLogin;
		this.mordorLoginIn = mordorLoginIn;
		this.mordorPre = mordorPre;
		
		inicializar();
		
	}

	private void inicializar() {
		mordorLogin.getBtnOpcionLogin().addActionListener( this);
		mordorLogin.getBtnNewButton_preference().addActionListener( this);
		mordorLogin.getBtnNewButton_preference().addActionListener(this);
		
		mordorLogin.getBtnOpcionLogin().setActionCommand("login");
		mordorLogin.getBtnNewButton_preference().setActionCommand("preference");
		mordorLogin.getBtnNewButton().setActionCommand("logout");
	}

	public void go() {
		mordorLogin.setVisible(true);
		
		//mordorLoginIn.setVisible(true);
		
	}
	
	public void actionPerformed(ActionEvent arg0) {
		
		String comando = arg0.getActionCommand();
	
		if(comando.equals("login")) {
			login();
		}else if(comando.equals("preference")) {
			preference();
		}else if(comando.equals("logout")) {
			logout();
		}
		
	
	}

	private void logout() {
		// TODO Auto-generated method stub
		
	}

	private void preference() {
		mordorPre = new MordorPreference();
		mordorLogin.getDesktopPane().add(mordorPre);
		mordorPre.setVisible(true);
		
	}

	private void login() {
		mordorLoginIn = new MordorLoginInsert();
		mordorLogin.getDesktopPane().add(mordorLoginIn);
		mordorLoginIn.setVisible(true);
	}
}
