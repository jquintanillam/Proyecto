package com.mordor.proyecto3e.elemento;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JPopupMenu;
import javax.swing.event.TableModelEvent;
import javax.swing.table.AbstractTableModel;

import com.alee.laf.table.WebTable;
import com.mordor.proyecto3e.modelo.AddEmpleado;

public class MyTableModel<T> extends AbstractTableModel {

	private final String[] HEADER = { "DNI", "Nombre", "FechaNac","Domicilio","CP","Email","Apellido","Cargo" };
	private WebTable table;

	List<Empleado> data;

	public MyTableModel(List<Empleado> data) {
		this.data = data;
	}

	@Override
	public int getColumnCount() {

		return HEADER.length;
	}

	@Override
	public int getRowCount() {
		return data.size();
	}

	@Override
	public String getColumnName(int column) {
		return HEADER[column];
	}
	
	@Override
	public Class<?> getColumnClass(int columnIndex) {
		switch(columnIndex) {
		case 2: return Date.class;
		default: return String.class;
		}
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		if (columnIndex == 0)
			return false;
		else
			return true;
	
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		switch (columnIndex) {

		case 1:
			data.get(rowIndex).setNombre(aValue.toString());
			break;
		case 2:
			java.util.Date fecha = (java.util.Date)aValue;
			data.get(rowIndex).setFechaNac(new java.sql.Date(fecha.getTime()));
			break;
		case 3:
			data.get(rowIndex).setDomicilio(aValue.toString());
			break;
		case 4:
			data.get(rowIndex).setCP(aValue.toString());
			break;
		case 5:
			data.get(rowIndex).setEmail(aValue.toString());
			break;
		case 6:
			data.get(rowIndex).setApellidos(aValue.toString());
			break;
		case 7:
			data.get(rowIndex).setCargo(aValue.toString());
			break;
		}

		fireTableCellUpdated(rowIndex, columnIndex);
	}

	@Override
	public Object getValueAt(int row, int col) {
		switch (col) {
		case 0:
			return data.get(row).getDNI();

		case 1:
			return data.get(row).getNombre();

		case 2:
			return data.get(row).getFechaNac();

		case 3:
			return data.get(row).getDomicilio();
		case 4:
			return data.get(row).getCP();
		case 5:
			return data.get(row).getEmail();
		case 6:
			
			return data.get(row).getApellidos();
		case 7:
			return data.get(row).getCargo();
		}
		return null;
	}

	public void addEmployee(Empleado empleado) {
		data.add(empleado);
		fireTableRowsInserted(data.size() - 1, data.size() - 1);

	}
	public ArrayList<Empleado> getEmployee(int[] rows) {
		ArrayList<Empleado> empleados = new ArrayList<Empleado>();
		
		for(int row : rows)
			empleados.add(getEmployee(row));
		
		return empleados;
	}

	public Empleado getEmployee(int row) {
		if (row < 0 || row >= data.size())
			return null;
		else
			return data.get(row);
	}

	public void removeEmployee(Empleado employee) {
		int pos = data.indexOf(employee);
		data.remove(employee);
		fireTableRowsDeleted(pos, pos);
	}
	public void removeRowAt(int row) {
		data.remove(row);
		fireTableRowsDeleted(row, row);
	}

	public void removeEmployee(String dni) {
		boolean encontrado = false;

		Iterator<Empleado> it = data.iterator();

		Empleado e;
		int pos = 0;

		while (!encontrado && it.hasNext()) {
			e = it.next();
			if (e.getDNI().compareTo(dni) == 0) {
				encontrado = true;
				it.remove();
			} else {
				pos++;
			}

		}
		if (encontrado)
			fireTableRowsDeleted(pos, pos);
	}



	public void tableChanged(TableModelEvent arg0) {

	if (arg0.getType() == TableModelEvent.UPDATE) {		
		
		MyTableModel<T> mtm = (MyTableModel<T>)table.getModel();
		System.out.println("Se ha actualizado el empleado: " +
						mtm.getEmployee(arg0.getFirstRow()));
		}
	}
		
	public void tableDelete(TableModelEvent arg0) {

		if (arg0.getType() == TableModelEvent.DELETE) {		
			
			MyTableModel<T> mtm = (MyTableModel<T>)table.getModel();
			System.out.println("Se ha borrado el empleado: " +
							mtm.getEmployee(arg0.getFirstRow()));
		}

	}

private static void addPopup(Component component, final JPopupMenu popup) {
	component.addMouseListener(new MouseAdapter() {
		public void mousePressed(MouseEvent e) {
			if (e.isPopupTrigger()) {
				showMenu(e);
			}
		}
		public void mouseReleased(MouseEvent e) {
			if (e.isPopupTrigger()) {
				showMenu(e);
			}
		}
		private void showMenu(MouseEvent e) {
			popup.show(e.getComponent(), e.getX(), e.getY());
		}
	});
}

	
}

