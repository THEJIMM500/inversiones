package tratadoDatos;

import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class ConexionHistorial {
	
	private Connection Conector;
	private final String campoID = "id";
	private final String campoUsuario = "usuario";
	private final String campoNombreEmpresa = "nombre_empresa";
	private final String campoValorCompra = "valor_compra";
	private final String campoTipoTransaccion = "tipo_transaccion";
	private final String campoFechaTransaccion = "fecha_transaccion";
	
	public ConexionHistorial() throws SQLException {
		String user = "root";
		String password = "";
		String url = "jdbc:mysql://localhost:3306/inversiones";
		Conector = DriverManager.getConnection(url, user, password);
	}
	
	public boolean insertaTransaccion(int ID, String usuario, String empresa, String valor, String tipo) throws SQLException {
		//El campo ID tiene que ser un campo único para cada entrada
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		String fecha = dtf.format(now);
		int numeroID = ultimoID();
        
		int valor_compra = Integer.parseInt(valor);
		if (valor_compra > 0) {
			String sentencia = "INSERT INTO historial (id, usuario, nombre_empresa, valor_compra, tipo_transaccion, fecha_transaccion) values ('"+numeroID+"', '"+usuario+"', '"+empresa+"', '"+valor+"', '"+tipo+"', '"+fecha+"');";
			Statement canuto = Conector.createStatement();
			canuto.executeUpdate(sentencia);
			canuto.close();
			return true;
		}
        
		return false;
	}
	public int ultimoID() throws SQLException {
		int ID=0;
		String sentencia = "SELECT `"+campoID+"` FROM `historial` ORDER BY "+campoID+" DESC;";
		Statement canuto = Conector.createStatement();
		ResultSet resultado = canuto.executeQuery(sentencia);
		if(!resultado.first()) {
			resultado.close();
			canuto.close();

		}else {
			ID=resultado.getInt(campoID);
			resultado.close();
			canuto.close();
			ID++;
			
		}
		return ID;
	}
	
	public ArrayList<Integer> getIds(String usuario) throws SQLException {
		ArrayList<Integer> listaIds = new ArrayList<Integer>();
		String sentencia = "SELECT `"+campoID+"` FROM `historial` WHERE `"+campoUsuario+"` = \""+usuario+"\";";
		Statement canuto = Conector.createStatement();
		ResultSet resultado = canuto.executeQuery(sentencia);
		while(resultado.next()) {
			int ID = resultado.getInt(campoID);
			listaIds.add(ID);
		}
		resultado.close();
		canuto.close();
		return listaIds;
	}
	public historialCompra getHistorial(int ID) throws SQLException {
		String sentencia = "SELECT `"+campoID+"`,`"+campoUsuario+"`,`"+campoNombreEmpresa+"`,`"+campoValorCompra+"`,`"+campoTipoTransaccion+"`,`"+campoFechaTransaccion+"` FROM `historial` WHERE `"+campoID+"` = "+ID+";";
		Statement canuto = Conector.createStatement();
		ResultSet resultado = canuto.executeQuery(sentencia);
		resultado.next();
		String usuario= resultado.getString(campoUsuario);
		String empresa= resultado.getString(campoNombreEmpresa);
		double valorDevolver = resultado.getDouble(campoValorCompra);
		String tipoTransicion = resultado.getString(campoTipoTransaccion);
		String FechaTransicion = resultado.getString(campoFechaTransaccion);
		resultado.close();
		canuto.close();
		
		return new historialCompra(ID, empresa,usuario, tipoTransicion, FechaTransicion, valorDevolver);
	}
	
}