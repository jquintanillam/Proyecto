package com.mordor.proyecto3e.elemento;

import java.util.List;

public class MyCustomerTableModel extends MyTableModel<Customer>{

	public MyCustomerTableModel(List<Customer> data) {
		super(new String[] {"hola"}, data);
		// TODO Auto-generated constructor stub
	}

}
