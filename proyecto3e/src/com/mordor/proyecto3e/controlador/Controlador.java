package com.mordor.proyecto3e.controlador;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

import javax.swing.JInternalFrame;
import javax.swing.JTextField;
import javax.swing.text.JTextComponent;

import com.mordor.proyecto3e.conexion.MyOracleDataBase;
import com.mordor.proyecto3e.elemento.Empleado;
import com.mordor.proyecto3e.elemento.MyTableModel;
import com.mordor.proyecto3e.modelo.MordorLogin;
import com.mordor.proyecto3e.modelo.MordorLoginInsert;
import com.mordor.proyecto3e.modelo.MordorPreference;
import com.mordor.proyecto3e.modelo.TablaEmpleado;

public class Controlador implements ActionListener {

	private static Container desktopPane;
	private MordorLogin mordorLogin;
	private MordorLoginInsert mordorLoginIn;
	private MordorPreference mordorPre;
	private MyOracleDataBase myOracleDataBase;
	private MyTableModel<Empleado> mtm;
	MyOracleDataBase modelo;
	private JTextComponent jTextField;

	
	public Controlador(MordorLogin mordorLogin, MyOracleDataBase modelo) {
		this.mordorLogin = mordorLogin;
		this.modelo = modelo;

		inicializar();

	}

	private void inicializar() {
		
		desktopPane=mordorLogin.getDesktopPane();
		mordorLogin.getButton_tabla().addActionListener(this);
		mordorLogin.getBtnOpcionLogin().addActionListener(this);
		mordorLogin.getBtnNewButton_preference().addActionListener(this);
		mordorLogin.getBtnNewButton_preference().addActionListener(this);

		mordorLogin.getButton_tabla().setActionCommand("tabla");
		mordorLogin.getBtnOpcionLogin().setActionCommand("login");
		mordorLogin.getBtnNewButton_preference().setActionCommand("preference");
		mordorLogin.getBtnNewButton().setActionCommand("logout");
	}

	public void go() {
		mordorLogin.setVisible(true);

		// mordorLoginIn.setVisible(true);

	}

	public void actionPerformed(ActionEvent arg0) {

		String comando = arg0.getActionCommand();

		if (comando.equals("login")) {
			login();
		} else if (comando.equals("preference")) {
			preference();
		} else if (comando.equals("logout")) {
			logout();
		} else if (comando.equals("tabla")) {
			tabla();
		} else if (comando.equals("Enter")) {
			conectarseSesion();
		}

	}

	private void tabla() {
		TablaEmpleado te = new TablaEmpleado();
		ControladorTabla ct = new ControladorTabla(te,modelo,mtm);
	}

	private void logout() {
		// TODO Auto-generated method stub

	}

	private void preference() {
		
		mordorPre = new MordorPreference();
		mordorLogin.getDesktopPane().add(mordorPre);
		mordorPre.setVisible(true);
		
		leerDBProperties();
		
		mordorPre.setTextField_user(null);
		mordorPre.setTextField_URL(null);
		mordorPre.setTxt_driver(null);
		mordorPre.setTextField_password(null);
		
		grabarDBProperties();

	}

	private void grabarDBProperties() {
		try(OutputStream salida = new FileOutputStream("db.properties")){
			
			Properties propiedades = new Properties();
			
			propiedades.setProperty("ORACLE_DB_DRIVERS_CLASS", "oracle.jdbc.driver.OracleDriver");
			propiedades.setProperty("ORACLE_DB_URL", "jdbc:oracle:thin:@192.168.1.60:1539:xe");
			propiedades.setProperty("ORACLE_DB_USERNAME", "C##QUINTANILLA");
			propiedades.setProperty("ORACLE_DB_PASSWORD", "123456");
			
			propiedades.store(salida, null);
			
		}catch(Exception e) {
			
		}
		
	}

	private void leerDBProperties() {
			
		try(InputStream lectura = new FileInputStream("db.properties")){			
			
			Properties propiedades = new Properties();
			
			propiedades.load(lectura);
			
			propiedades.getProperty("ORACLE_DB_DRIVERS_CLASS");
			propiedades.getProperty("ORACLE_DB_URL");
			propiedades.getProperty("ORACLE_DB_USERNAME");
			propiedades.getProperty("ORACLE_DB_PASSWORD");
			
			mordorPre.getTxt_driver().setText(propiedades.getProperty("ORACLE_DB_DRIVERS_CLASS"));
			mordorPre.getTextField_URL().setText(propiedades.getProperty("ORACLE_DB_URL"));
			mordorPre.getTextField_user().setText(propiedades.getProperty("ORACLE_DB_USERNAME"));
			mordorPre.getTextField_password().setText(propiedades.getProperty("ORACLE_DB_PASSWORD"));
			
		}catch(Exception e){
			
		}
		
		
	}

	private void login() {
		myOracleDataBase = new MyOracleDataBase();
		mordorLoginIn = new MordorLoginInsert();
		mordorLogin.getDesktopPane().add(mordorLoginIn);
		mordorLoginIn.setVisible(true);

		mordorLoginIn.getBtnEnter().addActionListener(this);

		mordorLoginIn.getBtnEnter().setActionCommand("Enter");

	}

	private void conectarseSesion() {
		
		
		if (myOracleDataBase.authenticate(mordorLoginIn.getTextField_usesr().getText(),
				String.valueOf(mordorLoginIn.getPasswordField().getPassword()))==true) {
			mordorLogin.getBtnNewButton_preference().setEnabled(true);
			mordorLoginIn.setVisible(false);
			mordorLogin.getButton_tabla().setEnabled(true);
			
		
		}
	}
	static void addJinternalFrame(JInternalFrame jif) {
		desktopPane.add(jif);
		centrar(jif);
		try {
			jif.setSelected(true);
		}catch (PropertyVetoException e) {
			e.printStackTrace();
		}
	}
	static void centrar(JInternalFrame jif) {
		Dimension deskSize = desktopPane.getSize();
		Dimension ifSize = jif.getSize();
		jif.setLocation((deskSize.width - ifSize.width)/2, ((deskSize.height - ifSize.height)/2));
	}
}
