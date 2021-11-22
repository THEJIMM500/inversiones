package inversiones;

import java.sql.SQLException;

import actualizadorAcciones.CambiarPrecioAcciones;

public class Main {

	public static void main(String[] args) {
		InicioSesion ventana1 = new InicioSesion();
		try {
			CambiarPrecioAcciones acctualizador = new CambiarPrecioAcciones();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
