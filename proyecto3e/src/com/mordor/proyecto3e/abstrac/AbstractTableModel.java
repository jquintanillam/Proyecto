package com.mordor.proyecto3e.abstrac;

import javax.swing.event.TableModelEvent;

public abstract class AbstractTableModel {
	
	public abstract Object getValueAt(int row, int col);
	
	public abstract void setValueAt(Object aValue, int rowIndex, int columnIndex);	
}
