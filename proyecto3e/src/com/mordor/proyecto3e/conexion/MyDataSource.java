package com.mordor.proyecto3e.conexion;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import com.mysql.cj.jdbc.MysqlDataSource;

import oracle.jdbc.pool.OracleDataSource;



public class MyDataSource {
	private static String defaultProperties = "db.properties";


	public static DataSource getOracleDataSource() {

		// Propiedades donde tenemos los datos de acceso a la BD

		Properties props = new Properties();

		// Objeto DataSource que devolveremos

		OracleDataSource mysqlDS = null;

		try (FileInputStream fis = new FileInputStream(defaultProperties)) {

			// Cargamos las propiedades

			props.load(fis);

			// Generamos el DataSource con los datos URL, user y passwd necesarios

			mysqlDS = new OracleDataSource();

			mysqlDS.setURL(props.getProperty("ORACLE_DB_URL"));
			mysqlDS.setUser(props.getProperty("ORACLE_DB_USERNAME"));
			mysqlDS.setPassword(props.getProperty("ORACLE_DB_PASSWORD"));

		} catch (IOException e) {

			e.printStackTrace();

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return mysqlDS;

	}
	
}

