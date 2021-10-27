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
		private final String campoNombre ="nombre";
		private final String campoApellido="apellido";
		private final String campoNtarjeta="ntarjeta";
		private final String campoDirecion="direcion";
		private final String campoCorreo="correo";
		private final String campoTelefono="telefono";
		private final String campoFechanac="fechanac";
		private final String campoSaldo="saldo";
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
				return 0;// Valor que regresa si se inicia sesion
			}else {
				resultado.close();
				canuto.close();
				return 1;//Valor que regresa si la contraseña no coincide
			}
		}
		return -1;//Valor que regresa si el usuario no existe 
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
	public void setContraseña(String Usuario, String Contraseña) throws SQLException {
		String sentencia = "UPDATE `clientes` SET `"+campoContraseña+"`=\""+Contraseña+"\" WHERE `"+campoUsuario+"`= \""+Usuario+"\";";
		Statement canuto = Conector.createStatement();
		canuto.executeUpdate(sentencia);
		canuto.close();
	}
	public void setNombre(String Usuario, String Nombre) throws SQLException {
		String sentencia = "UPDATE `clientes` SET `"+campoNombre+"`=\""+Nombre+"\" WHERE `"+campoUsuario+"`= \""+Usuario+"\";";
		Statement canuto = Conector.createStatement();
		canuto.executeUpdate(sentencia);
		canuto.close();
	}
	public String getNombre(String Usuario) throws SQLException {
		String sentencia = "SELECT `"+campoNombre+"` FROM `clientes` WHERE `"+campoUsuario+"` = \""+Usuario+"\";";
		Statement canuto = Conector.createStatement();
		ResultSet resultado = canuto.executeQuery(sentencia);
		resultado.next();
		String valorDevolver=resultado.getString(campoNombre);
		resultado.close();
		canuto.close();
		return valorDevolver;
	}
	public void setApellido(String Usuario, String Apellido) throws SQLException {
		String sentencia = "UPDATE `clientes` SET `"+campoApellido+"`=\""+Apellido+"\" WHERE `"+campoUsuario+"`= \""+Usuario+"\";";
		Statement canuto = Conector.createStatement();
		canuto.executeUpdate(sentencia);
		canuto.close();
	}
	public String getApellido(String Usuario) throws SQLException {
		String sentencia = "SELECT `"+campoApellido+"` FROM `clientes` WHERE `"+campoUsuario+"` = \""+Usuario+"\";";
		Statement canuto = Conector.createStatement();
		ResultSet resultado = canuto.executeQuery(sentencia);
		resultado.next();
		String valorDevolver=resultado.getString(campoApellido);
		resultado.close();
		canuto.close();
		return valorDevolver;
	}
	public void setNtarjeta(String Usuario, String Ntarjeta) throws SQLException {
		String sentencia = "UPDATE `clientes` SET `"+campoNtarjeta+"`=\""+Ntarjeta+"\" WHERE `"+campoUsuario+"`= \""+Usuario+"\";";
		Statement canuto = Conector.createStatement();
		canuto.executeUpdate(sentencia);
		canuto.close();
	}
	public String getNtargeta(String Usuario) throws SQLException {
		String sentencia = "SELECT `"+campoNtarjeta+"` FROM `clientes` WHERE `"+campoUsuario+"` = \""+Usuario+"\";";
		Statement canuto = Conector.createStatement();
		ResultSet resultado = canuto.executeQuery(sentencia);
		resultado.next();
		String valorDevolver=resultado.getString(campoNtarjeta);
		resultado.close();
		canuto.close();
		return valorDevolver;
	}
	public void setDirecion(String Usuario, String Direcion) throws SQLException {
		String sentencia = "UPDATE `clientes` SET `"+campoDirecion+"`=\""+Direcion+"\" WHERE `"+campoUsuario+"`= \""+Usuario+"\";";
		Statement canuto = Conector.createStatement();
		canuto.executeUpdate(sentencia);
		canuto.close();
	}
	public String getDirecion(String Usuario) throws SQLException {
		String sentencia = "SELECT `"+campoDirecion+"` FROM `clientes` WHERE `"+campoUsuario+"` = \""+Usuario+"\";";
		Statement canuto = Conector.createStatement();
		ResultSet resultado = canuto.executeQuery(sentencia);
		resultado.next();
		String valorDevolver=resultado.getString(campoDirecion);
		resultado.close();
		canuto.close();
		return valorDevolver;
	}
	public void setCorreo(String Usuario, String Correo) throws SQLException {
		String sentencia = "UPDATE `clientes` SET `"+campoCorreo+"`=\""+Correo+"\" WHERE `"+campoUsuario+"`= \""+Usuario+"\";";
		Statement canuto = Conector.createStatement();
		canuto.executeUpdate(sentencia);
		canuto.close();
	}
	public String getCorreo(String Usuario) throws SQLException {
		String sentencia = "SELECT `"+campoCorreo+"` FROM `clientes` WHERE `"+campoUsuario+"` = \""+Usuario+"\";";
		Statement canuto = Conector.createStatement();
		ResultSet resultado = canuto.executeQuery(sentencia);
		resultado.next();
		String valorDevolver=resultado.getString(campoCorreo);
		resultado.close();
		canuto.close();
		return valorDevolver;
	}
	public void setTelefono(String Usuario, String Telefono) throws SQLException {
		String sentencia = "UPDATE `clientes` SET `"+campoTelefono+"`=\""+Telefono+"\" WHERE `"+campoUsuario+"`= \""+Usuario+"\";";
		Statement canuto = Conector.createStatement();
		canuto.executeUpdate(sentencia);
		canuto.close();
	}
	public String getTelefono(String Usuario) throws SQLException {
		String sentencia = "SELECT `"+campoCorreo+"` FROM `clientes` WHERE `"+campoTelefono+"` = \""+Usuario+"\";";
		Statement canuto = Conector.createStatement();
		ResultSet resultado = canuto.executeQuery(sentencia);
		resultado.next();
		String valorDevolver=resultado.getString(campoTelefono);
		resultado.close();
		canuto.close();
		return valorDevolver;
	}
	public void setFechaNaci(String Usuario, String Fecha) throws SQLException {
		String sentencia = "UPDATE `clientes` SET `"+campoFechanac+"`=\""+Fecha+"\" WHERE `"+campoUsuario+"`= \""+Usuario+"\";";
		Statement canuto = Conector.createStatement();
		canuto.executeUpdate(sentencia);
		canuto.close();
	}
	public String getFechaNaci(String Usuario) throws SQLException {
		String sentencia = "SELECT `"+campoFechanac+"` FROM `clientes` WHERE `"+campoUsuario+"` = \""+Usuario+"\";";
		Statement canuto = Conector.createStatement();
		ResultSet resultado = canuto.executeQuery(sentencia);
		resultado.next();
		String valorDevolver=resultado.getString(campoFechanac);
		resultado.close();
		canuto.close();
		return valorDevolver;
	}public void setSaldo(String Usuario, String Fecha) throws SQLException {
		String sentencia = "UPDATE `clientes` SET `"+campoSaldo+"`=\""+Fecha+"\" WHERE `"+campoUsuario+"`= \""+Usuario+"\";";
		Statement canuto = Conector.createStatement();
		canuto.executeUpdate(sentencia);
		canuto.close();
	}
	public String getSaldo(String Usuario) throws SQLException {
		String sentencia = "SELECT `"+campoCorreo+"` FROM `clientes` WHERE `"+campoSaldo+"` = \""+Usuario+"\";";
		Statement canuto = Conector.createStatement();
		ResultSet resultado = canuto.executeQuery(sentencia);
		resultado.next();
		String valorDevolver=resultado.getString(campoSaldo);
		resultado.close();
		canuto.close();
		return valorDevolver;
	}
}
