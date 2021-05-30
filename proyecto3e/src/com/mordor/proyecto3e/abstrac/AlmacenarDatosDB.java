package com.mordor.proyecto3e.abstrac;

import java.util.ArrayList;

import com.mordor.proyecto3e.elemento.Empleado;

public interface AlmacenarDatosDB {

	public ArrayList<Empleado> getEmpleados();
	public ArrayList<Empleado> getEmpleadosPorCP(String cp);
	public ArrayList<Empleado> getEmpleadosPorCargo(String cargo);
	public Empleado getEmpleadoPorDNI(String dni);
	public boolean updateEmpleado(Empleado empleado);
	public boolean deleteEmpleado(String dni);
	public boolean authenticate(String dni,String password);
}
