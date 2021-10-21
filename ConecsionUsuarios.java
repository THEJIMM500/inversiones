package inversiones;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConecsionUsuarios {
		private Connection Conector;
		private final String campoUsuario ="usuario";
		private final String campoContraseña ="contraseña";
	public ConecsionUsuarios() throws SQLException {
		String user = "root";
		String password = "";
		String url = "jdbc:mysql://localhost:3306/inversiones";
		Conector = DriverManager.getConnection(url, user, password);
	}
	
	
	
	public boolean registrarUsuario(String nombre, String contraseña) throws SQLException {
		if(exiteUsuario(nombre)== false) {
			String sentencia = "INSERT INTO clientes (usuario, contraseña) values ('"+nombre+"', '"+contraseña+"');";
			Statement canuto = Conector.createStatement();
			canuto.executeUpdate(sentencia);
			canuto.close();
			return true;
		}else {
			return false;
		}
	}
	public int iniciarSesion(String nombre, String contraseña) throws SQLException {
		
		if(exiteUsuario(nombre)==true) {
			String sentencia = "SELECT `"+campoUsuario+"`,`"+campoContraseña+"`  FROM `clientes` WHERE `usuario` = \""+nombre+"\";";
			Statement canuto = Conector.createStatement();
			ResultSet resultado = canuto.executeQuery(sentencia);
			resultado.next();
			String nombreLeido=resultado.getString(campoUsuario);
			String contraseñaLeida=resultado.getString(campoContraseña);
			if(nombreLeido.equals(nombre)&&contraseñaLeida.equals(contraseña)) {
				resultado.close();
				canuto.close();
				return 0;
			}else {
				resultado.close();
				canuto.close();
				return 1;
			}
		}
		return -1;
	}
	private boolean exiteUsuario(String nombre) throws SQLException {
		String sentencia = "SELECT `usuario` FROM `clientes` WHERE `usuario` = \""+nombre+"\";";
		Statement canuto = Conector.createStatement();
		ResultSet resultado = canuto.executeQuery(sentencia);
		
		if(!resultado.first()) {
			resultado.close();
			canuto.close();
			return false;
		}else {
			resultado.close();
			canuto.close();
			return true;
		}
	}
	public String getNombreUsuario(String Usuario) throws SQLException {
		String sentencia = "SELECT `"+campoUsuario+"` FROM `clientes` WHERE `"+campoUsuario+"` = \""+Usuario+"\";";
		Statement canuto = Conector.createStatement();
		ResultSet resultado = canuto.executeQuery(sentencia);
		resultado.next();
		String valorDevolver=resultado.getString(campoUsuario);
		resultado.close();
		canuto.close();
		return valorDevolver;
	}
	public String getContraseña(String Usuario) throws SQLException {
		String sentencia = "SELECT `"+campoContraseña+"` FROM `clientes` WHERE `"+campoUsuario+"` = \""+Usuario+"\";";
		Statement canuto = Conector.createStatement();
		ResultSet resultado = canuto.executeQuery(sentencia);
		resultado.next();
		String valorDevolver=resultado.getString(campoContraseña);
		resultado.close();
		canuto.close();
		return valorDevolver;
	}
}
