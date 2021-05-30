package com.mordor.proyecto3e.controlador;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.alee.laf.table.WebTable;
import com.mordor.proyecto3e.conexion.MyOracleDataBase;
import com.mordor.proyecto3e.elemento.Empleado;
import com.mordor.proyecto3e.elemento.MyTableModel;
import com.mordor.proyecto3e.modelo.AddEmpleado;
import com.mordor.proyecto3e.modelo.TablaEmpleado;

public class ControladorTabla implements ActionListener {

	private TablaEmpleado te;
	private AddEmpleado ae;
	private MyTableModel<Empleado> mtm;
	private MyOracleDataBase modelo;
	
	List<Empleado> data;
	 	
	public ControladorTabla(TablaEmpleado te,MyOracleDataBase modelo, MyTableModel<Empleado> mtm) {
		this.te = te;
		this.modelo=modelo;
		this.mtm=mtm;
		inicializar();
	}
	
	private void inicializar() {
		Controlador.addJinternalFrame(te);
		Controlador.centrar(te);
		te.setVisible(true);
		
		te.getBtnAdd().addActionListener(this);
		te.getBtnDelete().addActionListener(this);
		te.getBtnClose().addActionListener(this);
		
		te.getBtnAdd().setActionCommand("tableadd");
		te.getBtnDelete().setActionCommand("delete");
		te.getBtnClose().setActionCommand("close");
		
	}
	public void actionPerformed(ActionEvent arg0) {

		String comando = arg0.getActionCommand();

		if (comando.equals("tableadd")) {
			tableAdd();
		}else if(comando.equals("close")) {
			close();
		}else if(comando.equals("addEmployed")) {
			addEmployed();
		}else if(comando.equals("delete")) {
			deleteEmployed();
		}
	}

	private void deleteEmployed() {
		int i = te.getTable().getSelectedRow();
		
		ArrayList<Empleado> empleados = modelo.getEmpleados();
		
		mtm = new MyTableModel<Empleado>(empleados);
		
		String dni = mtm.getEmployee(i).getDNI();
		mtm.removeRowAt(te.getTable().getSelectedRow());
		
		Empleado empleado = new Empleado(dni);
		
		modelo.removeEmpleado(empleado);
		
		
		mtm.removeEmployee(empleados.get(empleados.size() - 1));
				
	}

	private void addEmployed() {
		String dni = ae.getTextdni().getText();
		String nombre = ae.getTextname().getText();
		String apellidos = ae.getTextsurname().getText();
		String cp = ae.getTextcp().getText();
		String email = ae.getTextemail().getText();
		Date date = new java.sql.Date( ae.getTextfecha().getDate().getTime());
		String job = ae.getTextjob().getText();
		String address = ae.getTextaddress().getText();
		String pass = String.valueOf(ae.getTextpass().getPassword());
		
		
		Empleado empleado = new Empleado(dni,nombre,apellidos,cp,email,date,job,address,pass);
		
		modelo.addEmpleadoBD(empleado);
		
		ArrayList<Empleado> empleados = modelo.getEmpleados();
		
		mtm = new MyTableModel<Empleado>(empleados);
		
		mtm.addEmployee(empleados.get(empleados.size() - 1));

	}

	private void close() {
		te.dispose();
		
	}

	private void tableAdd() {
		
		
		ae= new AddEmpleado();
		
		Controlador.addJinternalFrame(ae);
		Controlador.centrar(ae);
		
		ae.setVisible(true);
		
		ae.getBtnSave().addActionListener(this);
		
		
		ae.getBtnSave().setActionCommand("addEmployed");
	}
		
}
