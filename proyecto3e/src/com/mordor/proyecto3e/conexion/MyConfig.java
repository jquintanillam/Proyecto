//package com.mordor.proyecto3e.conexion;
//
//import java.io.FileInputStream;
//import java.io.IOException;
//import java.sql.Connection;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.Properties;
//
//import javax.sql.DataSource;
//
//import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
//
//import com.mysql.cj.jdbc.MysqlDataSource;
//import com.mysql.cj.xdevapi.Statement;
//
//import oracle.jdbc.datasource.OracleDataSource;
//
//public class MyConfig {
//
//	private static String defaultFile = "db.propierties";
//	private String defaultproperties = "app.propierties";
////	private Properties properties;
//
//	private String key = "jquintanillam";
//	private Map<String, String> propiedadesSeguras;
//
//	
//	
//
//	private void checkEncriptedProperties() throws Exception {
//
//		// Creamos un map con todas las propiedades que deben ser encriptadas,
//
//		// junto con las propiedades que nos indican el estado de estas.
//
//		propiedadesSeguras = new HashMap<String, String>();
//
//		propiedadesSeguras.put("ORACLE_DB_USERNAME", "IS_ORACLE_DB_USERNAME_ENCRYPTED");
//
//		propiedadesSeguras.put("ORACLE_DB_PASSWORD", "IS_ORACLE_DB_PASSWORD_ENCRYPTED");
//
//		// Si no existe la propiedad que indica si esta encriptado una key,
//
//		// la creamos y la ponemos a false
//
//		for (String isEncripted : propiedadesSeguras.values()) {
//
//			if (!properties.containsKey(isEncripted))
//
//				properties.put(isEncripted, "false");
//
//		}
//
//		// Encriptamos las claves si fuera necesario antes de leer las propiedades
//
//		for (String property : propiedadesSeguras.keySet())
//
//			encryptPropertyValue(property, propiedadesSeguras.get(property));
//
//		// Guardamos las propiedades.
//
//		// De esta forma las propiedades que no estaban encriptadas,
//
//		// pasaran a disco encriptadas
//
//		guardar();
//
//	}
//
//	private void encryptPropertyValue(String propertyKey, String isPropertyKeyEncrypted) {
//
//		// Retrieve boolean properties value to see if password is already
//
//		// encrypted or not
//
//		String isEncrypted = properties.getProperty(isPropertyKeyEncrypted);
//
//		// Check if password is encrypted?
//
//		if (isEncrypted.equals("false")) {
//
//			String tmpPwd = properties.getProperty(propertyKey);
//
//			String encryptedPassword = encrypt(tmpPwd);
//
//			// Overwrite password with encrypted password in the properties file
//
//			// using Apache Commons Cinfiguration library
//
//			properties.setProperty(propertyKey, encryptedPassword);
//
//			// Set the boolean flag to true to indicate future encryption
//
//			// operation that password is already encrypted
//
//			properties.setProperty(isPropertyKeyEncrypted, "true");
//
//			// Save the properties file
//
//			guardar();
//
//		}
//
//	}
//
//	private void guardar() {
//		// TODO Auto-generated method stub
//		
//	}
//
//	private String encrypt(String tmpPwd) {
//
//		// Encrypt
//
//		StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
//
//		encryptor.setPassword(key);
//
//		String encryptedPassword = encryptor.encrypt(tmpPwd);
//
//		return encryptedPassword;
//
//	}
//
//	private String decryptPropertyValue(String propertyKey) {
//
//		String encryptedPropertyValue = properties.getProperty(propertyKey);
//
//		StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
//
//		encryptor.setPassword(key);
//
//		String decryptedPropertyValue = encryptor.decrypt(encryptedPropertyValue);
//
//		return decryptedPropertyValue;
//
//	}
//}
