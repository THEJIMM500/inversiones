package inversiones;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Empresa implements Runnable{
	private String nombre;
	private double valor;
	private boolean SubePrecio;
	private int CamboiosDePrecio;
	private Connection Conector;
	
	public Empresa(String nombre, double valor) throws SQLException {
		super();
		this.nombre = nombre;
		this.valor = valor;
		this.SubePrecio = true;
		this.CamboiosDePrecio =numeroDeCambiosPrecio();
		ConectarBaseDeDatos();
		
	}
	private void ConectarBaseDeDatos() throws SQLException {
		String user = "root";
		String password = "";
		String url = "jdbc:mysql://localhost:3306/inversiones";
		Conector = DriverManager.getConnection(url, user, password);
	}
	private boolean subePrecio(){
		int numero = (int) Math.round(Math.random()*1);
		if(numero==1) {
			return true;
		}else {
			return false;
		}
	}
	private int numeroDeCambiosPrecio() {
		return (int) (Math.round(Math.random()*5));
	}
	private void cambiarValor() {
		
		if(SubePrecio== true) {
			double incremento = Math.random()*5;		
			valor= valor+incremento;
			
			if(valor>1000) {
				valor=1000;
			}
		}else {
			double decremneto = Math.random()*5;		
			valor= valor-decremneto;
			if(valor<0.01) {
				valor=0.01;
			}
		}
	}
	private void actualizarBaseFatos() throws SQLException {
		BigDecimal valorRondeado=new BigDecimal(valor).setScale(2, RoundingMode.HALF_UP);
		String sentenciaSQL= "UPDATE `empresas` SET `valor_accion`=+"+valorRondeado+" WHERE `nombre`=\""+nombre+"\";";
		Statement canuto = Conector.createStatement();
		canuto.executeUpdate(sentenciaSQL);
		canuto.close();
	}
	public String getNombre() {
		return nombre;
	}
	public double getValor() {
		return valor;
	}
	public void run() {
		// TODO Auto-generated method stub
		int cont=0;
		while(true) {
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			cambiarValor();
			try {
				actualizarBaseFatos();
				//System.out.println("Valor cambiado");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Me he roto");
			}			
			if(cont==CamboiosDePrecio) {
				SubePrecio=subePrecio();
				CamboiosDePrecio=numeroDeCambiosPrecio();
				cont=-1;
			}
			cont++;
		}
	}
	
}
