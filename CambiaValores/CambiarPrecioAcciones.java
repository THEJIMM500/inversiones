package inversiones;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CambiarPrecioAcciones implements Runnable{
	private Connection Conector;
	public CambiarPrecioAcciones() throws SQLException {
		String user = "root";
		String password = "";
		String url = "jdbc:mysql://localhost:3306/inversiones";
		Conector = DriverManager.getConnection(url, user, password);
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		String sentencia = "SELECT * FROM `empresas`;";
		try {
			Statement canuto = Conector.createStatement();
			ResultSet resultado = canuto.executeQuery(sentencia);
			while(resultado.next()==true) {
				String nombre=resultado.getString("nombre");
				double valor =resultado.getDouble("valor_accion");
				Empresa empresa= new Empresa(nombre, valor);
				Thread empezar = new Thread(empresa);
				empezar.start();
			}
			resultado.next();
			resultado.close();
			canuto.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("no fufa");
		}
	}
}
