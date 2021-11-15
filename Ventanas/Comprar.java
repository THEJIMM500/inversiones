package inversiones;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.*;

import com.mysql.jdbc.Connection;

import java.awt.Color;


public class Comprar {
	
	private ConexionAcciones conexion;
	private ConexionHistorial historial;
	private ConexionUsuarios cartera;
	private ConexionEmpresas valor;
	private JFrame ventanaComprar;
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
					Comprar window = new Comprar(null, null);
					window.ventanaComprar.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Comprar(String nombreGuardado, String empresaSeleccionada) {
		this.nombreGuardado = nombreGuardado;
		this.empresaSeleccionada = empresaSeleccionada;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		ventanaComprar = new JFrame();
		addVentana();
		
		btnCancelar = new JButton("");
		addBtnCancelar();
		btnCancelar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
		        Principal principal = new Principal(nombreGuardado);
		        principal.main(null);
		        ventanaComprar.setVisible(false);
			}
		});
		
		lblCantidad = new JLabel("Cantidad");
		addLblCantidad(lblCantidad);
		
		textCantidad = new JTextField();
		addTextCantidad();
		
		textValor = new JTextField();
		addTextValor();
		
		checkValor = new JCheckBox("Valor");
		addChckValor(checkValor);
		if (checkValor.isSelected()) {
			
		}
		
		btnCompletar = new JButton("");
		addBtnCompletar();
		btnCompletar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int cantidad = Integer.parseInt(textCantidad.getText());
				if(cantidad > 0) {
					if (empresaSeleccionada.equals("amazon")) {
						try {
							operacionesDeCompra(cantidad);
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
						
					} else if (empresaSeleccionada.equals("apple")) {
						try {
							operacionesDeCompra(cantidad);
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
						
					} else if (empresaSeleccionada.equals("facebook")) {
						try {
							operacionesDeCompra(cantidad);
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
						
					} else if (empresaSeleccionada.equals("google")) {
						try {
							operacionesDeCompra(cantidad);
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
						
					} else if (empresaSeleccionada.equals("linkedin")) {
						try {
							operacionesDeCompra(cantidad);
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
						
					} else if (empresaSeleccionada.equals("twitch")) {
						try {
							operacionesDeCompra(cantidad);
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
						
					} else if (empresaSeleccionada.equals("microsoft")) {
						try {
							operacionesDeCompra(cantidad);
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
						
					} else if (empresaSeleccionada.equals("git")) {
						try {
							operacionesDeCompra(cantidad);
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
						
					} else if (empresaSeleccionada.equals("paypal")) {
						try {
							operacionesDeCompra(cantidad);
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
	
	public void operacionesDeCompra(int acciones) throws SQLException {
		conexion.insertOperacion(empresaSeleccionada, nombreGuardado, accionesTotales(acciones));
		historial.insertaTransaccion(ID, nombreGuardado, empresaSeleccionada, textCantidad.getText(), "compra");
		cartera.setSaldo(nombreGuardado, dineroGastado(acciones));
	}
	
	public double dineroGastado(int acciones) throws SQLException {
		return cartera.getSaldo(nombreGuardado) - (valor.getValorAccion(empresaSeleccionada) * acciones);
	}
	
	public int accionesTotales(int acciones) throws SQLException {
		return acciones - conexion.getNumeroAcciones(empresaSeleccionada, nombreGuardado);
	}

	public void addVentana() {
		ventanaComprar.getContentPane().setBackground(Color.WHITE);
		ventanaComprar.setTitle("Comprar");
		ventanaComprar.setBounds(100, 100, 450, 300);
		ventanaComprar.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventanaComprar.getContentPane().setLayout(null);
	}

	public void addLblCantidad(JLabel lblCantidad) {
		lblCantidad.setBounds(120, 74, 60, 14);
		ventanaComprar.getContentPane().add(lblCantidad);
	}

	public void addChckValor(JCheckBox chckbxValor) {
		chckbxValor.setBackground(Color.WHITE);
		chckbxValor.setBounds(120, 106, 60, 23);
		ventanaComprar.getContentPane().add(chckbxValor);
	}

	public void addBtnCompletar() {
		btnCompletar.setIcon(new ImageIcon("C:\\Users\\ro_cl\\Downloads\\Completar.png"));
		btnCompletar.setBackground(Color.WHITE);
		btnCompletar.setBounds(154, 177, 127, 42);
		ventanaComprar.getContentPane().add(btnCompletar);
	}

	public void addTextValor() {
		textValor.setBounds(187, 109, 86, 20);
		textValor.setColumns(10);
		ventanaComprar.getContentPane().add(textValor);
	}

	public void addTextCantidad() {
		textCantidad.setBounds(187, 71, 86, 20);
		textCantidad.setColumns(10);
		ventanaComprar.getContentPane().add(textCantidad);
	}

	public void addBtnCancelar() {
		btnCancelar.setIcon(new ImageIcon("C:\\Users\\ro_cl\\Downloads\\Cancelar.png"));
		btnCancelar.setBackground(Color.WHITE);
		btnCancelar.setBounds(10, 11, 110, 23);
		ventanaComprar.getContentPane().add(btnCancelar);
	}
}
