package inversiones;

import java.sql.SQLException;

public class pruevas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CambiarPrecioAcciones a = null;
		try {
			 a = new CambiarPrecioAcciones();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Thread b = new Thread(a);
		b.start();
		
		
		
	}

}
