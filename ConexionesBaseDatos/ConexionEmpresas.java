package inversiones;

import java.sql.*;

public class ConexionEmpresas {
	
	private Connection Conector;
	private final String campoNombre = "nombre";
	private final String campoValorAccion = "valor_accion";
	
	public ConexionEmpresas() throws SQLException {
		String user = "root";
		String password = "";
		String url = "jdbc:mysql://localhost:3306/inversiones";
		Conector = DriverManager.getConnection(url, user, password);
	}

	public String getNombreEmpresa(String empresa) throws SQLException {
		String sentencia = "SELECT `"+campoNombre+"` FROM `empresas` WHERE `"+campoNombre+"` = \""+empresa+"\";";
		Statement canuto = Conector.createStatement();
		ResultSet resultado = canuto.executeQuery(sentencia);
		resultado.next();
		String valorDevolver = resultado.getString(campoNombre);
		resultado.close();
		canuto.close();
		return valorDevolver;
	}

	public double getValorAccion(String empresa) throws SQLException {
		String sentencia = "SELECT `"+campoValorAccion+"` FROM `empresas` WHERE `"+campoNombre+"` = \""+empresa+"\";";
		Statement canuto = Conector.createStatement();
		ResultSet resultado = canuto.executeQuery(sentencia);
		resultado.next();
		Double valorDevolver = resultado.getDouble(campoValorAccion);
		resultado.close();
		canuto.close();
		return valorDevolver;
	}
	
	public void setNombreEmpresa(String nombre, String empresa) throws SQLException {
		String sentencia = "UPDATE `empresas` SET `"+campoNombre+"`=\""+nombre+"\" WHERE `"+campoNombre+"`= \""+empresa+"\";";
		Statement canuto = Conector.createStatement();
		canuto.executeUpdate(sentencia);
		canuto.close();
	}
	
	public void setValorAccion(String valor, String empresa) throws SQLException {
		String sentencia = "UPDATE `empresas` SET `"+campoValorAccion+"`=\""+valor+"\" WHERE `"+campoNombre+"`= \""+empresa+"\";";
		Statement canuto = Conector.createStatement();
		canuto.executeUpdate(sentencia);
		canuto.close();
	}
	
}
