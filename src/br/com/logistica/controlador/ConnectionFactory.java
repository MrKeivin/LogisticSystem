package br.com.logistica.controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class ConnectionFactory {

		public Connection getConnection(){
			try{
				Class.forName("oracle.jdbc.driver.OracleDriver");
				return
						(Connection) DriverManager.getConnection("jdbc:mysql://8081/Sistemalogistica", "root","");
			}catch(SQLException e){
				throw new RuntimeException(e);
			}catch(ClassNotFoundException e){
				throw new RuntimeException(e);
			}
		}
}
