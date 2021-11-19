package tratadoDatos;

public class ComprobarDatos {
	
	public static boolean nombreUsuarioValido(String NombreUsuario){
		if(NombreUsuario.length()>0 && NombreUsuario.length()<31){
			return true;
		}else {
			return false;
		}
	}
	
	public static boolean contraseñaValido(String Contraseña){
		if(Contraseña.length()>0 && Contraseña.length()<31){
			return true;
		}else {
			return false;
		}
	}
	public static boolean nombreValido(String Nombre){
		if(Nombre.length()>0 && Nombre.length()<31){
			return true;
		}else {
			return false;
		}
	}
	public static boolean apellidoValido(String Apellido){
		if(Apellido.length()>0 && Apellido.length()<31){
			return true;
		}else {
			return false;
		}
	}
	public static boolean nTarjetaValido(String nTarjeta){
		if(nTarjeta.length()>0 && nTarjeta.length()<31){
			return true;
		}else {
			return false;
		}
	}
	public static boolean direccionValido(String Direccion){
		if(Direccion.length()>0 && Direccion.length()<31){
			return true;
		}else {
			return false;
		}
	}
	public static boolean correoValido(String Correo){
		
		int PosicionArroba = 0;
		int PosicionPunto=0;
		if(Correo.length()>0 && Correo.length()<31){
			for(int cont=0;cont <Correo.length();cont++) {
				char Arroba = Correo.charAt(cont);
				if(Arroba=='@') {
					PosicionArroba=cont;
				}else {
					return false;
				}
			}
			for(int cont=0;cont <Correo.length();cont++) {
				char Punto = Correo.charAt(cont);
				if(Punto=='.') {
					PosicionPunto=cont;
				}else {
					return false;
				}
			}
			if(PosicionArroba+3<PosicionPunto) {
				return true;
			}else {
				return false;
			}
			
		}else {
			return false;
		}
	}
	
	public static boolean telefonoValido(String Telefono) {
		boolean sonNumeros = true;
		for(int cont=0;cont <Telefono.length();cont++) {
			if(Telefono.charAt(cont)=='0'||Telefono.charAt(cont)=='1'||Telefono.charAt(cont)=='2'||Telefono.charAt(cont)=='0'
					||Telefono.charAt(cont)=='3'||Telefono.charAt(cont)=='4'||Telefono.charAt(cont)=='5'||Telefono.charAt(cont)=='6'
					||Telefono.charAt(cont)=='7'||Telefono.charAt(cont)=='8'||Telefono.charAt(cont)=='9') {
		
			}else {
				sonNumeros=false;
			}
		}
		return sonNumeros;
	}
	
	public static boolean saldoValido(String saldo) {
		if(Double.parseDouble(saldo)<1) {
			return false;
		}else {
			return true;
		}
	}
}
