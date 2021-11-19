package tratadoDatos;


import java.sql.*;

import com.mysql.jdbc.Connection;

public class ConexionAcciones {
	
	private Connection Conector;
	private final String campoNombreEmpresa = "nombre_empresa";
	private final String campoUsuario = "usuario";
	private final String campoNumeroAcciones = "numero_acciones";
	
	public ConexionAcciones() throws SQLException {
		String user = "root";
		String password = "";
		String url = "jdbc:mysql://localhost:3306/inversiones";
		Conector = DriverManager.getConnection(url, user, password);
	}
	
	public boolean insertOperacion(String empresa, String usuario, int acciones) throws SQLException {
		if (acciones > 0) {
			String sentencia = "INSERT INTO accionesCompradas (nombre_empresa, usuario, numero_acciones) values ('"+empresa+"', '"+usuario+"', '"+acciones+"');";
			Statement canuto = Conector.createStatement();
			canuto.executeUpdate(sentencia);
			canuto.close();
			return true;
		} else {
			return false;
		}
	}
	
	public boolean updateOperacion(String empresa, String usuario, int acciones) throws SQLException {
		if (acciones > 0) {
			String sentencia = "UPDATE accionesCompradas set numero_acciones = '"+acciones+"' WHERE usuario = '"+usuario+"' AND nombre_empresa = '"+empresa+"' ;";
			Statement canuto = Conector.createStatement();
			canuto.executeUpdate(sentencia);
			canuto.close();
			return true;
		} else {
			return false;
		}
	}
	
	public boolean deleteOperacion(String empresa, String usuario) throws SQLException {
			String sentencia = "DELETE FROM accionesCompradas WHERE nombre_empresa = '"+empresa+"' AND usuario = '"+usuario+"';";
			Statement canuto = Conector.createStatement();
			canuto.executeUpdate(sentencia);
			canuto.close();
			return true;
	}

	public String getNombreEmpresa(String empresa) throws SQLException {
		String sentencia = "SELECT `"+campoNombreEmpresa+"` FROM `accionesCompradas` WHERE `"+campoNombreEmpresa+"` = \""+empresa+"\";";
		Statement canuto = Conector.createStatement();
		ResultSet resultado = canuto.executeQuery(sentencia);
		resultado.next();
		String valorDevolver = resultado.getString(campoNombreEmpresa);
		resultado.close();
		canuto.close();
		return valorDevolver;
	}
	
	public String getUsuario(String usuario) throws SQLException {
		String sentencia = "SELECT `"+campoUsuario+"` FROM `accionesCompradas` WHERE `"+campoUsuario+"` = \""+usuario+"\";";
		Statement canuto = Conector.createStatement();
		ResultSet resultado = canuto.executeQuery(sentencia);
		resultado.next();
		String valorDevolver = resultado.getString(campoUsuario);
		resultado.close();
		canuto.close();
		return valorDevolver;
	}

	public int getNumeroAcciones(String empresa, String usuario) throws SQLException {
		String sentencia = "SELECT `"+campoNumeroAcciones+"` FROM `accionesCompradas` WHERE `"+campoNombreEmpresa+"`=\""+empresa+"\" AND `"+campoUsuario+"`=\""+usuario+"\";";
		Statement canuto = Conector.createStatement();
		ResultSet resultado = canuto.executeQuery(sentencia);
		resultado.next();
		int valorDevolver = resultado.getInt(campoNumeroAcciones);
		resultado.close();
		canuto.close();
		return valorDevolver;
	}
	
	public void setNumeroAcciones(String valor, String usuario, String empresa) throws SQLException {
		String sentencia = "UPDATE `empresas` SET `"+campoNumeroAcciones+"`=\""+valor+"\" WHERE `"+campoNombreEmpresa+"`=\""+empresa+"\" AND `"+campoUsuario+"`=\""+usuario+"\";";
		Statement canuto = Conector.createStatement();
		canuto.executeUpdate(sentencia);
		canuto.close();
	}
	
	public void actualizarBaseDatos(String empresa, String usuario, int acciones, boolean compra) throws SQLException {
		
		if(exiteLaTupla(usuario, empresa)==true) {
			int accionesNuevas=0;
			if(compra=true) {
				accionesNuevas=getNumeroAcciones(empresa, usuario)+ acciones;
			}else {
				accionesNuevas=getNumeroAcciones(empresa, usuario)- acciones;
			}
			updateOperacion(empresa, usuario, accionesNuevas);
			
		}else {
			 insertOperacion(empresa, usuario, acciones);
		}
	}
	private boolean exiteLaTupla(String nombre, String Empresa) throws SQLException {
		String sentencia = "SELECT `nombre_empresa` usuario,  FROM `clientes` WHERE nombre_empresa = "+Empresa+"' AND usuario = '"+nombre+"';";
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
}
