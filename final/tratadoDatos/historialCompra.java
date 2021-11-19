package tratadoDatos;

public class historialCompra {
	private int ID;
	private String empresa;
	private String usuario;
	private String tipoTransacion;
	private String fecha;
	private double valorCompra;
	public historialCompra(int iD, String empresa, String usuario, String tipoTransacion, String fecha,
			double valorCompra) {
		super();
		ID = iD;
		this.empresa = empresa;
		this.usuario = usuario;
		this.tipoTransacion = tipoTransacion;
		this.fecha = fecha;
		this.valorCompra = valorCompra;
	}
	public int getID() {
		return ID;
	}
	@Override
	public String toString() {
		return "historialCompra [ID=" + ID + ", empresa=" + empresa + ", usuario=" + usuario + ", tipoTransacion="
				+ tipoTransacion + ", fecha=" + fecha + ", valorCompra=" + valorCompra + "]";
	}
	public String getEmpresa() {
		return empresa;
	}
	public String getUsuario() {
		return usuario;
	}
	public String getTipoTransacion() {
		return tipoTransacion;
	}
	public String getFecha() {
		return fecha;
	}
	public double getValorCompra() {
		return valorCompra;
	}
}
