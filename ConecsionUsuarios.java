package inversiones;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConecsionUsuarios {
		private Connection Conector;
	public ConecsionUsuarios() throws SQLException {
		String user = "root";
		String password = "";
		String url = "jdbc:mysql://localhost:3306/inversiones";
		Conector = DriverManager.getConnection(url, user, password);
	}
	
	
	
	public boolean registrarUsuario(String nombre, String contrase�a) throws SQLException {
		if(exiteUsuario(nombre,contrase�a)== true) {
			String sentencia = "INSERT INTO clientes (usuario, contrase�a) values ('"+nombre+"', '"+contrase�a+"');";
			Statement canuto = Conector.createStatement();
			canuto.executeUpdate(sentencia);
			canuto.close();
			return true;
		}else {
			return false;
		}
	}
	private boolean exiteUsuario(String nombre, String contrase�a) throws SQLException {
		String sentencia = "SELECT `usuario`,`contrase�a` FROM `clientes` WHERE `usuario` = \""+nombre+"\" AND `contrase�a` = \""+contrase�a+"\";";
		Statement canuto = Conector.createStatement();
		canuto.executeUpdate(sentencia);
		canuto.close();
		
		return false;
	}
}
