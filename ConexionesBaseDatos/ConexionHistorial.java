package inversiones;

import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ConexionHistorial {
	
	private Connection Conector;
	private final String campoID = "id";
	private final String campoUsuario = "usuario";
	private final String campoNombreEmpresa = "nombre_empresa";
	private final String campoValorCompra = "valor_compra";
	private final String campoTipoTransaccion = "tipo_transaccion";
	private final String campoFechaTransaccion = "fecha_transaccion";
	private int ID = 1;
	
	public ConexionHistorial() throws SQLException {
		String user = "root";
		String password = "";
		String url = "jdbc:mysql://localhost:3306/inversiones";
		Conector = DriverManager.getConnection(url, user, password);
	}
	
	public String insertaTransaccion(String usuario, String empresa, String valor, String tipo) throws SQLException {

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String fecha = dtf.format(now);
		
		String sentencia = "INSERT INTO historial (id, usuario, nombre_empresa, valor_compra, tipo_transaccion, fecha_transaccion)"
				+ "values ('"+ID+"', '"+usuario+"', '"+empresa+"', '"+valor+"', '"+tipo+"', '"+fecha+"');";
		Statement canuto = Conector.createStatement();
		ResultSet resultado = canuto.executeQuery(sentencia);
		resultado.next();
		String valorDevolver = resultado.getString(campoValorCompra);
		resultado.close();
		canuto.close();
		ID++;
		return valorDevolver;
	}
	
	public String getID(String usuario) throws SQLException {
		String sentencia = "SELECT `"+campoID+"` FROM `historial` WHERE `"+campoUsuario+"` = \""+usuario+"\";";
		Statement canuto = Conector.createStatement();
		ResultSet resultado = canuto.executeQuery(sentencia);
		resultado.next();
		String valorDevolver = resultado.getString(campoValorCompra);
		resultado.close();
		canuto.close();
		return valorDevolver;
	}
	
	public String getValorCompra(String usuario) throws SQLException {
		String sentencia = "SELECT `"+campoValorCompra+"` FROM `historial` WHERE `"+campoUsuario+"` = \""+usuario+"\";";
		Statement canuto = Conector.createStatement();
		ResultSet resultado = canuto.executeQuery(sentencia);
		resultado.next();
		String valorDevolver = resultado.getString(campoValorCompra);
		resultado.close();
		canuto.close();
		return valorDevolver;
	}
	
	public String getTipoTransaccion(String usuario) throws SQLException {
		String sentencia = "SELECT `"+campoTipoTransaccion+"` FROM `historial` WHERE `"+campoUsuario+"` = \""+usuario+"\";";
		Statement canuto = Conector.createStatement();
		ResultSet resultado = canuto.executeQuery(sentencia);
		resultado.next();
		String valorDevolver = resultado.getString(campoTipoTransaccion);
		resultado.close();
		canuto.close();
		return valorDevolver;
	}
	
	public String getFechaTransaccion(String usuario) throws SQLException {
		String sentencia = "SELECT `"+campoFechaTransaccion+"` FROM `historial` WHERE `"+campoUsuario+"` = \""+usuario+"\";";
		Statement canuto = Conector.createStatement();
		ResultSet resultado = canuto.executeQuery(sentencia);
		resultado.next();
		String valorDevolver = resultado.getString(campoFechaTransaccion);
		resultado.close();
		canuto.close();
		return valorDevolver;
	}

}
