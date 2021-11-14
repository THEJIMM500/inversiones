package inversiones;

import java.sql.*;

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
	
	public boolean insertOperacion(String empresa, String usuario, String acciones) throws SQLException {
		int numero_acciones = Integer.parseInt(acciones);
		if (numero_acciones > 0) {
			String sentencia = "INSERT INTO accionesCompradas (nombre_empresa, usuario, numero_acciones) values ('"+empresa+"', '"+usuario+"', '"+acciones+"');";
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

	public String getNumeroAcciones(String valor) throws SQLException {
		String sentencia = "SELECT `"+campoNumeroAcciones+"` FROM `accionesCompradas` WHERE `"+campoNumeroAcciones+"` = \""+valor+"\";";
		Statement canuto = Conector.createStatement();
		ResultSet resultado = canuto.executeQuery(sentencia);
		resultado.next();
		String valorDevolver = resultado.getString(campoNumeroAcciones);
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
	
}

