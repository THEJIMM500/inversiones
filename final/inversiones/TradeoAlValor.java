package inversiones;

import java.sql.SQLException;

import tratadoDatos.ConexionAcciones;
import tratadoDatos.ConexionEmpresas;
import tratadoDatos.ConexionHistorial;
import tratadoDatos.ConexionUsuarios;

public class TradeoAlValor implements Runnable{
	private double PrecioObjetivo;
	private String nombreUsuario;
	private String nombreEmpresa;
	private int acciones;
	private boolean compra;
	private ConexionHistorial conexionHistorial;
	private ConexionUsuarios conexionUsuarios;
	private ConexionEmpresas conexionEmpresas;
	private ConexionAcciones conexionAcciones;
	
	public TradeoAlValor(double precioObjetivo, String nombreUsuario, String nombreEmpresa, boolean compra) {
		super();
		try {
			conexionAcciones = new ConexionAcciones();
			conexionHistorial= new ConexionHistorial();
			conexionUsuarios = new ConexionUsuarios();
			conexionEmpresas = new ConexionEmpresas();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.PrecioObjetivo = precioObjetivo;
		this.nombreUsuario = nombreUsuario;
		this.nombreEmpresa = nombreEmpresa;
		this.compra = compra;
	}
	
	private void hacerOperacion() throws SQLException {
		
		conexionAcciones.actualizarBaseDatos(nombreEmpresa, nombreUsuario, acciones, compra);
		if(compra==true){
			conexionHistorial.insertaTransaccion(0, nombreUsuario, nombreEmpresa, acciones+"", "compra");
			conexionUsuarios.setSaldo(nombreUsuario, (conexionUsuarios.getSaldo(nombreUsuario)+ PrecioObjetivo));
		}else {
			conexionHistorial.insertaTransaccion(0, nombreUsuario, nombreEmpresa, acciones+"", "compra");
			conexionUsuarios.setSaldo(nombreUsuario, (conexionUsuarios.getSaldo(nombreUsuario)- PrecioObjetivo));
		}
			
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int tiempo =0;tiempo <30;tiempo++) {
			try {
				if(PrecioObjetivo==conexionEmpresas.getValorAccion(nombreEmpresa)) {
				hacerOperacion();
				tiempo=30;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				Thread.sleep(60000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
