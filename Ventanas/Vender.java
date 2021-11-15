package inversiones;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.*;
import java.awt.Color;

public class Vender {
	
	private ConexionAcciones conexion;
	private ConexionHistorial historial;
	private ConexionUsuarios cartera;
	private ConexionEmpresas valor;
	private JFrame ventanaVender;
	private JTextField textCantidad, textValor;
	private JButton btnCompletar, btnCancelar;
	private JLabel lblCantidad;
	private JCheckBox checkValor;
	private String nombreGuardado, empresaSeleccionada;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Vender window = new Vender(null, null);
					window.ventanaVender.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Vender(String nombreGuardado, String empresaSeleccionada) {
		this.nombreGuardado = nombreGuardado;
		this.empresaSeleccionada = empresaSeleccionada;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		ventanaVender = new JFrame();
		addVentana();
		
		btnCancelar = new JButton("");
		addBtnCancelar();
		btnCancelar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
		        Principal principal = new Principal(nombreGuardado);
		        principal.main(null);
		        ventanaVender.setVisible(false);
			}
		});
		
		lblCantidad = new JLabel("Cantidad");
		addLblCantidad();
		
		textCantidad = new JTextField();
		addTextCantidad();
		
		textValor = new JTextField();
		addTextValor();
		
		checkValor = new JCheckBox("Valor");
		addCheckValor();
		
		btnCompletar = new JButton("");
		addBtnCompletar();
		btnCompletar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int cantidad = Integer.parseInt(textCantidad.getText());
				if(cantidad > 0) {
					if (empresaSeleccionada.equals("amazon")) {
						try {
							operacionesDeVenta(cantidad);
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
						
					} else if (empresaSeleccionada.equals("apple")) {
						try {
							operacionesDeVenta(cantidad);
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
						
					} else if (empresaSeleccionada.equals("facebook")) {
						try {
							operacionesDeVenta(cantidad);
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
						
					} else if (empresaSeleccionada.equals("google")) {
						try {
							operacionesDeVenta(cantidad);
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
						
					} else if (empresaSeleccionada.equals("linkedin")) {
						try {
							operacionesDeVenta(cantidad);
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
						
					} else if (empresaSeleccionada.equals("twitch")) {
						try {
							operacionesDeVenta(cantidad);
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
						
					} else if (empresaSeleccionada.equals("microsoft")) {
						try {
							operacionesDeVenta(cantidad);
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
						
					} else if (empresaSeleccionada.equals("git")) {
						try {
							operacionesDeVenta(cantidad);
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
						
					} else if (empresaSeleccionada.equals("paypal")) {
						try {
							operacionesDeVenta(cantidad);
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
						
					}
					
				} else {
					JOptionPane.showMessageDialog(btnCompletar, "Introduce una cantidad de acciones válida", "Error", 2, null);
				}
				
			}
		});
		
	}
	
	public void operacionesDeVenta(int acciones) throws SQLException {
		conexion.updateOperacion(empresaSeleccionada, nombreGuardado, accionesTotales(acciones));
		historial.insertaTransaccion(ID, nombreGuardado, empresaSeleccionada, textCantidad.getText(), "venta");
		cartera.setSaldo(nombreGuardado, dineroGanado(acciones));
	}
	
	public double dineroGanado(int acciones) throws SQLException{
		return (cartera.getSaldo(nombreGuardado)) + valor.getValorAccion(empresaSeleccionada) * acciones;
	}
	
	public int accionesTotales(int acciones) throws SQLException {
		return conexion.getNumeroAcciones(empresaSeleccionada, nombreGuardado) - acciones;
	}

	private void addVentana() {
		ventanaVender.getContentPane().setBackground(Color.WHITE);
		ventanaVender.setTitle("Vender");
		ventanaVender.setBounds(100, 100, 450, 300);
		ventanaVender.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventanaVender.getContentPane().setLayout(null);
	}

	private void addCheckValor() {
		checkValor.setBackground(Color.WHITE);
		checkValor.setBounds(120, 106, 60, 23);
		ventanaVender.getContentPane().add(checkValor);
	}

	private void addBtnCompletar() {
		btnCompletar.setIcon(new ImageIcon("C:\\Users\\ro_cl\\Downloads\\Completar.png"));
		btnCompletar.setBackground(Color.WHITE);
		btnCompletar.setBounds(154, 177, 127, 42);
		ventanaVender.getContentPane().add(btnCompletar);
	}

	private void addTextValor() {
		textValor.setBounds(187, 109, 86, 20);
		textValor.setColumns(10);
		ventanaVender.getContentPane().add(textValor);
	}

	private void addTextCantidad() {
		textCantidad.setBounds(187, 71, 86, 20);
		textCantidad.setColumns(10);
		ventanaVender.getContentPane().add(textCantidad);
	}

	private void addLblCantidad() {
		lblCantidad.setBounds(120, 74, 60, 14);
		ventanaVender.getContentPane().add(lblCantidad);
	}

	private void addBtnCancelar() {
		btnCancelar.setIcon(new ImageIcon("C:\\Users\\ro_cl\\Downloads\\Cancelar.png"));
		btnCancelar.setBackground(Color.WHITE);
		btnCancelar.setBounds(10, 11, 110, 23);
		ventanaVender.getContentPane().add(btnCancelar);
	}
}
