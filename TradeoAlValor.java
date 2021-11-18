package basesDatos;

import tratadoDatos.ConexionEmpresas;
import tratadoDatos.ConexionHistorial;
import tratadoDatos.ConexionUsuarios;

public class TradeoAlValor implements Runnable{
	private double PrecioObjetivo;
	private String nombreUsuariio;
	private String nombreEmpresa;
	private int acciones;
	private boolean compra;
	private ConexionHistorial conexionHistorial;
	private ConexionUsuarios conexionUsuarios;
	private ConexionEmpresas conexionEmpresas;
	private ConexionAcciones conexionAcciones;
	
	public TradeoAlValor(double precioObjetivo, String nombreUsuariio, String nombreEmpresa, boolean compra) {
		super();
		conexionAcciones = new ConexionAcciones();
		conexionHistorial= new ConexionHistorial();
		conexionUsuarios = new ConexionUsuarios();
		conexionEmpresas = new ConexionEmpresas();
		this.PrecioObjetivo = precioObjetivo;
		this.nombreUsuariio = nombreUsuariio;
		this.nombreEmpresa = nombreEmpresa;
		this.compra = compra;
	}
	
	private void hacerOperacion() {
		
		conexionAcciones.actualizarBaseDatos(nombreEmpresa, nombreUsuariio, acciones, compra);
		if(boolean==true){
			conexionHistorial.insertaTransaccion(0, nombreUsuariio, "nombreEmpresa", acciones, "compra");
			conexionUsuarios.setSaldo(nombreUsuariio, (conexionUsuarios.getSaldo+ PrecioObjetivo));
		}else {
			conexionHistorial.insertaTransaccion(0, nombreUsuariio, "nombreEmpresa", acciones, "compra");
			conexionUsuarios.setSaldo(nombreUsuariio, (conexionUsuarios.getSaldo- PrecioObjetivo));
		}
			
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int tiempo =0;tiempo <30;tiempo++) {
			hacerOperacion();
			
			Thread.sleep(60000);
		}
	}
}
