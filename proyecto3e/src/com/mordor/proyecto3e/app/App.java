package com.mordor.proyecto3e.app;

import java.awt.EventQueue;

import com.mordor.proyecto3e.controlador.Controlador;
import com.mordor.proyecto3e.modelo.MordorLogin;
import com.mordor.proyecto3e.modelo.MordorLoginInsert;
import com.mordor.proyecto3e.modelo.MordorPreference;

public class App {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MordorLogin frame = new MordorLogin();
					MordorLoginInsert login = new MordorLoginInsert();
					MordorPreference pre = new MordorPreference();
					Controlador controlador = new Controlador(frame, login, pre);
					controlador.go();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
