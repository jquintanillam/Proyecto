package com.mordor.proyecto3e.modelo;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.util.ArrayList;

import javax.swing.DefaultCellEditor;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableColumn;


import com.alee.laf.table.WebTable;
import com.alee.laf.table.editors.WebDateEditor;
import com.mordor.proyecto3e.conexion.MyOracleDataBase;
import com.mordor.proyecto3e.elemento.Empleado;
import com.mordor.proyecto3e.elemento.MyTableModel;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TablaEmpleado extends JInternalFrame implements TableModelListener {

	private JPanel contentPane;
	private WebTable table;
	static TablaEmpleado frame;
	//private JMenuItem mntmDeleteRow;
	private JPopupMenu popupMenu;
	private JMenuItem mntmAddRow_1;
	private JMenuItem mntmDeleteRow_1;
	private JButton btnAdd;
	private JButton btnDelete;
	private JButton btnClose;

	/**
	 * Create the frame.
	 */
	public TablaEmpleado() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 549, 289);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JScrollPane scrollPane = new JScrollPane();
		
		btnAdd = new JButton("Add");
		
		btnDelete = new JButton("Delete");
		
		btnClose = new JButton("Close");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(scrollPane)
							.addContainerGap())
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addComponent(btnAdd)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnDelete)
							.addGap(18)
							.addComponent(btnClose)
							.addGap(2))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 193, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnClose)
						.addComponent(btnAdd)
						.addComponent(btnDelete))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);

		table = new WebTable();
		table.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
		table.setVisibleRowCount(5);
		table.optimizeColumnWidths(true);
		table.setOptimizeRowHeight(true);
		table.setEditable(true);
		scrollPane.setViewportView(table);

		popupMenu = new JPopupMenu();

		mntmAddRow_1 = new JMenuItem("Add row");
		popupMenu.add(mntmAddRow_1);

		mntmDeleteRow_1 = new JMenuItem("Delete row");
		popupMenu.add(mntmDeleteRow_1);

		contentPane.setLayout(gl_contentPane);

		MyOracleDataBase modelo = new MyOracleDataBase();
		ArrayList<Empleado> empleados = modelo.getEmpleados();

		MyTableModel<Empleado> mtm = new MyTableModel<Empleado>(empleados);
		table.setModel(mtm);

		table.setDefaultEditor(Date.class, new WebDateEditor());

		// Adding comboBox just to edit the company position in the WebTable
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.addItem("mecanico");
		comboBox.addItem("administrativo");
		comboBox.addItem("comercial");
		comboBox.addItem("gerente");

		TableColumn column = table.getColumn("Cargo");
		column.setCellEditor(new DefaultCellEditor(comboBox));

		mtm.addTableModelListener(this);

		mtm.addEmployee(empleados.get(empleados.size() - 1));

		table.addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent e) {
				if (e.getButton() == MouseEvent.BUTTON3) {

					int row = table.rowAtPoint(e.getPoint());

					if (row < 0 || row >= table.getRowCount())
						table.clearSelection();
					else if (table.getSelectedRowCount() <= 1) {
						table.setSelectedRow(row);
						popupMenu.show(table, e.getX(), e.getY());
					} else if (table.getSelectedRowCount() > 1) {
						popupMenu.show(table, e.getX(), e.getY());
					}

				}
			}
		});
	}
	

	public JButton getBtnAdd() {
		return btnAdd;
	}


	public JButton getBtnDelete() {
		return btnDelete;
	}


	public JButton getBtnClose() {
		return btnClose;
	}


	public WebTable getTable() {
		return table;
	}


	@Override
	public void tableChanged(TableModelEvent arg0) {
		if (arg0.getType() == TableModelEvent.UPDATE) {

			MyTableModel<?> mtm = (MyTableModel<?>) table.getModel();
			System.out.println("Se ha actualizado el empleado: " + mtm.getEmployee(arg0.getFirstRow()));
		}

	}
}