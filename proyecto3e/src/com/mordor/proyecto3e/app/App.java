package com.mordor.proyecto3e.app;

import java.awt.EventQueue;

import com.alee.laf.WebLookAndFeel;
import com.mordor.proyecto3e.conexion.MyOracleDataBase;
import com.mordor.proyecto3e.controlador.Controlador;
import com.mordor.proyecto3e.controlador.ControladorTabla;
import com.mordor.proyecto3e.elemento.Empleado;
import com.mordor.proyecto3e.elemento.MyTableModel;
import com.mordor.proyecto3e.modelo.MordorLogin;
import com.mordor.proyecto3e.modelo.MordorLoginInsert;
import com.mordor.proyecto3e.modelo.MordorPreference;
import com.mordor.proyecto3e.modelo.TablaEmpleado;

public class App {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					 WebLookAndFeel.install ();
					
					MordorLogin frame = new MordorLogin();
					MyOracleDataBase modelo = new MyOracleDataBase();
					Controlador controlador = new Controlador(frame,modelo);
					controlador.go();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
