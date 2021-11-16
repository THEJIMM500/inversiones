package inversiones;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Prueba {

	public static void main(String[] args) {
		//InicioSesion inicio = new InicioSesion();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        System.out.println(dtf.format(now));
        Date date = new Date(121, 9, 27);
        System.out.println(date);

	}

}
