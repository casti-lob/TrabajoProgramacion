package bbdd;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Principal {
	public static Scanner teclado = new Scanner(System.in);
	public static void main(String[] args) {
		try {
			Connection c = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/ORCLCDB.localdomain", "dummy", "dummy");
			
			
			DatabaseMetaData infoBD= c.getMetaData();
			System.out.println("Base de datos: " + infoBD.getDatabaseProductName());
			System.out.println("Version: " + infoBD.getDatabaseProductVersion());
			addUser(c);
		} catch (Exception ex) {
			System.out.println(ex);
		}

	}
	public static void addUser(Connection c) throws SQLException {
		
		//Pedimos los datos
		String nif,nombre,apellidos;
		int edad;
		System.out.println("Introduce nif");
		nif=teclado.nextLine();
		
		Statement instruccion = (Statement) c.createStatement();
		String query ="insert into personas values('"+nif+"')";//Metemos la instrucción DML
		
		if(!instruccion.execute(query)){//
			System.out.println("error en la sentencia: "+query);
			
		}else {
			System.out.println("Registro insertado");
		}
	}
	public static void consultar(Connection c) throws SQLException {
		Statement instruccion = c.createStatement();
		
		ResultSet resultado = instruccion.executeQuery("Select * from personas");
		System.out.println(resultado);
		while (resultado.next()) {
			System.out.println(resultado.getString("nif"));
		}
		
	}
	
}
