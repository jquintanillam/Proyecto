package com.mordor.proyecto3e.conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.sql.DataSource;

import com.mordor.proyecto3e.abstrac.AlmacenarDatosDB;
import com.mordor.proyecto3e.elemento.Empleado;

public class MyOracleDataBase implements AlmacenarDatosDB  {

	public ArrayList<Empleado> getCustomEmpleados(String where) {

		ArrayList<Empleado> empleados = new ArrayList<Empleado>();

		DataSource ds = MyDataSource.getOracleDataSource();

		String query = "SELECT * FROM EMPLEADO";

		if (where != null)
			query += " WHERE " + where;

		try (Connection con = ds.getConnection();
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(query)) {

			Empleado empleado;

			while (rs.next()) {
				empleado = new Empleado( rs.getString("DNI"), rs.getString("nombre"),
						rs.getString("apellidos"), rs.getString("CP"), rs.getString("email"), rs.getDate("fechaNac"),
						rs.getString("cargo"), rs.getString("domicilio"), rs.getString("password"));

				empleados.add(empleado);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return empleados;
	}

	public ArrayList<Empleado> getEmpleadosPorCP(String cp) {
		// TODO Auto-generated method stub
		return getCustomEmpleados("CP='" + cp + "'");
	}

	public ArrayList<Empleado> getEmpleadosPorCargo(String cargo) {
		return getCustomEmpleados("cargo='" + cargo + "'");
	}

	public ArrayList<Empleado> getEmpleados() {
		return getCustomEmpleados(null);

	}

	public Empleado getEmpleadoPorDNI(String dni) {
		ArrayList<Empleado> empleados = getCustomEmpleados("DNI='" + dni + "'");
		if (empleados.size() == 0)
			return null;
		else
			return empleados.get(0);
	}

	public boolean updateEmpleado(Empleado empleado) {

		boolean actualizado = false;

		DataSource ds = MyDataSource.getOracleDataSource();

		try (Connection con = ds.getConnection(); Statement stmt = con.createStatement();) {

			String query = "UPDATE EMPLEADO SET nombre='" + empleado.getNombre() + "', " + 
												"apellidos='" + empleado.getApellidos() + "'," + 
												((empleado.getDomicilio() != null) ? "domicilio='" + empleado.getDomicilio() + "'," : "") + 
												((empleado.getCP() != null) ? "CP='" + empleado.getCP() + "'," : "") + 
												"email='" + empleado.getEmail() + "'," + 
												"fechaNac=TO_DATE('" + empleado.getFechaNac()+"','yyyy-mm-dd')" + "," + 
												"cargo='" + empleado.getCargo() + "' " + 
												"WHERE DNI='" + empleado.getDNI() + "'";
			
			System.out.println(query);

			if (stmt.executeUpdate(query) == 1)
				actualizado = true;

		} catch (SQLException e) {

			e.printStackTrace();

		}
		return actualizado;
	}

	public boolean deleteEmpleado(String dni) {
		
		
		return false;
	}

	public boolean authenticate(String dni, String password) {
		boolean encriptado =false;
		DataSource ds = MyDataSource.getOracleDataSource();
		String query = "SELECT COUNT(*) FROM EMPLEADO WHERE DNI=? AND password=ENCRYPT_PASWD.encrypt_val(?)";
		
		try(Connection con = ds.getConnection(); PreparedStatement pstmt = con.prepareStatement(query)){
			
			int pos = 0;
			pstmt.setString(++pos, dni);
			pstmt.setString(++pos, password);
			
			ResultSet rs = pstmt.executeQuery();
			
			rs.next();
			if(rs.getInt(1)==1) {
				encriptado = true;
			}
			
		}catch(SQLException e) {
			
		}
		return encriptado;
	}
	public boolean addEmpleadoBD(Empleado empleado) {

		boolean insertado = false;

		DataSource ds = MyDataSource.getOracleDataSource();
		
		String query = "INSERT INTO EMPLEADO (dni,nombre,apellidos,domicilio,cp,email,fechanac,cargo,password) VALUES (?,?,?,?,?,?,?,?,ENCRYPT_PASWD.encrypt_val(?))";

		try (Connection con = ds.getConnection(); PreparedStatement pstmt = con.prepareStatement(query);) {

			int pos = 0;
			pstmt.setString(++pos, empleado.getDNI());
			pstmt.setString(++pos, empleado.getNombre());
			pstmt.setString(++pos, empleado.getApellidos());
			pstmt.setString(++pos, empleado.getDomicilio());
			pstmt.setString(++pos, empleado.getCP());
			pstmt.setString(++pos, empleado.getEmail());
			pstmt.setDate(++pos, empleado.getFechaNac());
			pstmt.setString(++pos, empleado.getCargo());
			pstmt.setString(++pos, empleado.getPassword());
			
			pstmt.executeQuery();

			
				insertado = true;

		} catch (SQLException e) {

			e.printStackTrace();

		}
		return insertado;
	}
	
	public boolean removeEmpleado(Empleado empleado) {

		boolean insertado = false;

		DataSource ds = MyDataSource.getOracleDataSource();
		
		String query = "DELETE FROM EMPLEADO WHERE dni='?'";

		try (Connection con = ds.getConnection(); PreparedStatement pstmt = con.prepareStatement(query);) {

			int pos = 0;
			pstmt.setString(++pos, empleado.getDNI());
			
			
			pstmt.executeQuery();

			
				insertado = true;

		} catch (SQLException e) {

			e.printStackTrace();

		}
		return insertado;
	}
}