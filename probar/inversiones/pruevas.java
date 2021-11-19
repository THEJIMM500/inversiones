package inversiones;

import java.sql.SQLException;

import actualizadorAcciones.CambiarPrecioAcciones;
import tratadoDatos.ConexionHistorial;
import tratadoDatos.ConexionUsuarios;
import tratadoDatos.historialCompra;

public class pruevas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		ConexionHistorial c=null;
		
		try {
			 c = new ConexionHistorial();
			 historialCompra a= c.getHistorial(0);
			System.out.println(a.toString());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
	}

}
