package inversiones;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.*;

import tratadoDatos.ConexionAcciones;
import tratadoDatos.ConexionEmpresas;
import tratadoDatos.ConexionHistorial;
import tratadoDatos.ConexionUsuarios;

import java.awt.Color;
import java.awt.Font;

public class Vender {
	
	private ConexionAcciones conexionAcciones;
	private ConexionHistorial conexionHistorial;
	private ConexionUsuarios conexionUsuarios;
	private ConexionEmpresas conexionEmpresas;
	private JFrame ventanaVender;
	private JTextField textCantidad, textValor;
	private JButton btnCompletar, btnCancelar;
	private JLabel lblCantidad;
	private JCheckBox checkValor;
	private String nombreGuardado;
	private Enum<Empresas>empresaSeleccionada;
	private int ID;
	private TradeoAlValor tradeo;


	public Vender(String nombreGuardado, Enum<Empresas> empresaSelecionada) {
		this.nombreGuardado = nombreGuardado;
		this.empresaSeleccionada = empresaSelecionada;
		initialize();
		ventanaVender.setVisible(true);
		try {
			conexionAcciones=new ConexionAcciones();
			conexionHistorial=new ConexionHistorial();
			conexionUsuarios= new ConexionUsuarios();
			conexionEmpresas = new ConexionEmpresas();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
		        ventanaVender.setVisible(false);
			}
		});
		
		lblCantidad = new JLabel("Cantidad");
		lblCantidad.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		addLblCantidad();
		
		textCantidad = new JTextField();
		addTextCantidad();
		
		textValor = new JTextField();
		addTextValor();
		
		checkValor = new JCheckBox("Valor");
		checkValor.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		addCheckValor();
		
		btnCompletar = new JButton("");
		addBtnCompletar();
		btnCompletar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int numeroAccioneActuales = 0;
				double valorActual=0;
				double saldoActual=0;
				
				if (checkValor.isSelected()) {
					System.out.println("Haz lo de la casilla marcada");
					
					double precioObjetivo = Double.parseDouble(textValor.getText());
					if (precioObjetivo > 0) {
						try {
							saldoActual = conexionUsuarios.getSaldo(nombreGuardado);
							valorActual = 0;
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
						
						int numeroAccionesAVender = Integer.parseInt(textCantidad.getText());
							if(numeroAccionesAVender > 0) {
								if (empresaSeleccionada== Empresas.Amazon ) {
									
									try {
										numeroAccioneActuales = conexionAcciones.getNumeroAcciones("Amazon", nombreGuardado);
										valorActual = conexionEmpresas.getValorAccion("Amazon");
										if(numeroAccioneActuales>=numeroAccionesAVender) {
											tradeo = new TradeoAlValor(precioObjetivo, "Amazon", nombreGuardado, false);
											JOptionPane.showMessageDialog(btnCompletar, "Venta realizada", "Venta", 3, null);
										}else {
											JOptionPane.showMessageDialog(btnCompletar, "Acciones insuficiente", "Error", 2, null);
										}
									} catch (SQLException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
									
								} else if (empresaSeleccionada== Empresas.Apple) {
									try {
										numeroAccioneActuales = conexionAcciones.getNumeroAcciones("Apple", nombreGuardado);
										valorActual = conexionEmpresas.getValorAccion("Apple");
										if(numeroAccioneActuales>=numeroAccionesAVender) {
											tradeo = new TradeoAlValor(precioObjetivo, "Apple", nombreGuardado, false);
											JOptionPane.showMessageDialog(btnCompletar, "Venta realizada", "Venta", 3, null);
										}else {
											JOptionPane.showMessageDialog(btnCompletar, "Acciones insuficiente", "Error", 2, null);
										}
									} catch (SQLException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
									
								} else if (empresaSeleccionada== Empresas.Facebook) {
									try {
										numeroAccioneActuales = conexionAcciones.getNumeroAcciones("Facebook", nombreGuardado);
										valorActual = conexionEmpresas.getValorAccion("Facebook");
										if(numeroAccioneActuales>=numeroAccionesAVender) {
											tradeo = new TradeoAlValor(precioObjetivo, "Facebook", nombreGuardado, false);
											JOptionPane.showMessageDialog(btnCompletar, "Venta realizada", "Venta", 3, null);
										}else {
											JOptionPane.showMessageDialog(btnCompletar, "Acciones insuficiente", "Error", 2, null);
										}
									} catch (SQLException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
									
								} else if (empresaSeleccionada== Empresas.Google) {
									try {
										numeroAccioneActuales = conexionAcciones.getNumeroAcciones("Google", nombreGuardado);
										valorActual = conexionEmpresas.getValorAccion("Google");
										if(numeroAccioneActuales>=numeroAccionesAVender) {
											tradeo = new TradeoAlValor(precioObjetivo, "Google", nombreGuardado, false);
											JOptionPane.showMessageDialog(btnCompletar, "Venta realizada", "Venta", 3, null);
										}else {
											JOptionPane.showMessageDialog(btnCompletar, "Acciones insuficiente", "Error", 2, null);
										}
									} catch (SQLException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
									
								} else if (empresaSeleccionada== Empresas.Linkedin) {
									
									try {
										numeroAccioneActuales = conexionAcciones.getNumeroAcciones("Linkedin", nombreGuardado);
										valorActual = conexionEmpresas.getValorAccion("Linkedin");
										if(numeroAccioneActuales>=numeroAccionesAVender) {
											tradeo = new TradeoAlValor(precioObjetivo, "Linkedin", nombreGuardado, false);
											JOptionPane.showMessageDialog(btnCompletar, "Venta realizada", "Venta", 3, null);
										}else {
											JOptionPane.showMessageDialog(btnCompletar, "Acciones insuficiente", "Error", 2, null);
										}
									} catch (SQLException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
									
								} else if (empresaSeleccionada== Empresas.Twitch) {
									try {
										numeroAccioneActuales = conexionAcciones.getNumeroAcciones("Twitch", nombreGuardado);
										valorActual = conexionEmpresas.getValorAccion("Twitch");
										if(numeroAccioneActuales>=numeroAccionesAVender) {
											tradeo = new TradeoAlValor(precioObjetivo, "Twitch", nombreGuardado, false);
											JOptionPane.showMessageDialog(btnCompletar, "Venta realizada", "Venta", 3, null);
										}else {
											JOptionPane.showMessageDialog(btnCompletar, "Acciones insuficiente", "Error", 2, null);
										}
									} catch (SQLException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
									
								} else if (empresaSeleccionada== Empresas.Microsoft) {
									try {
										numeroAccioneActuales = conexionAcciones.getNumeroAcciones("Microsoft", nombreGuardado);
										valorActual = conexionEmpresas.getValorAccion("Microsoft");
										if(numeroAccioneActuales>=numeroAccionesAVender) {
											tradeo = new TradeoAlValor(precioObjetivo, "Microsoft", nombreGuardado, false);
											JOptionPane.showMessageDialog(btnCompletar, "Venta realizada", "Venta", 3, null);
										}else {
											JOptionPane.showMessageDialog(btnCompletar, "Acciones insuficiente", "Error", 2, null);
										}
									} catch (SQLException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
									
								} else if (empresaSeleccionada==  Empresas.Git) {
									
									try {
										numeroAccioneActuales = conexionAcciones.getNumeroAcciones("GitHub", nombreGuardado);
										valorActual = conexionEmpresas.getValorAccion("Git");
										if(numeroAccioneActuales>=numeroAccionesAVender) {
											tradeo = new TradeoAlValor(precioObjetivo, "GitHub", nombreGuardado, false);
											JOptionPane.showMessageDialog(btnCompletar, "Venta realizada", "Venta", 3, null);
										}else {
											JOptionPane.showMessageDialog(btnCompletar, "Acciones insuficiente", "Error", 2, null);
										}
									} catch (SQLException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
									
								} else if (empresaSeleccionada==  Empresas.Paypal) {
									try {
										numeroAccioneActuales = conexionAcciones.getNumeroAcciones("Paypal", nombreGuardado);
										valorActual = conexionEmpresas.getValorAccion("Paypal");
										if(numeroAccioneActuales>=numeroAccionesAVender) {
											tradeo = new TradeoAlValor(precioObjetivo, "Paypal", nombreGuardado, false);
											JOptionPane.showMessageDialog(btnCompletar, "Venta realizada", "Venta", 3, null);
										}else {
											JOptionPane.showMessageDialog(btnCompletar, "Acciones insuficiente", "Error", 2, null);
										}
									} catch (SQLException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
								}
								
							} else {
								JOptionPane.showMessageDialog(btnCompletar, "Introduce una cantidad de válida", "Error", 2, null);
							}
					}
				} else {
				
				try {
					saldoActual = conexionUsuarios.getSaldo(nombreGuardado);
					valorActual = 0;
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				
				int numeroAccionesAVender = Integer.parseInt(textCantidad.getText());
					if(numeroAccionesAVender > 0) {
						if (empresaSeleccionada== Empresas.Amazon ) {
							
							try {
								numeroAccioneActuales = conexionAcciones.getNumeroAcciones("Amazon", nombreGuardado);
								valorActual = conexionEmpresas.getValorAccion("Amazon");
								if(numeroAccioneActuales>=numeroAccionesAVender) {
									venderAmazon();
									conexionUsuarios.setSaldo(nombreGuardado, (saldoActual + (valorActual*numeroAccionesAVender)));
									JOptionPane.showMessageDialog(btnCompletar, "Venta realizada", "Venta", 3, null);
								}else {
									JOptionPane.showMessageDialog(btnCompletar, "Acciones insuficiente", "Error", 2, null);
								}
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							
						} else if (empresaSeleccionada== Empresas.Apple) {
							try {
								numeroAccioneActuales = conexionAcciones.getNumeroAcciones("Apple", nombreGuardado);
								valorActual = conexionEmpresas.getValorAccion("Apple");
								if(numeroAccioneActuales>=numeroAccionesAVender) {
									venderAmazon();
									conexionUsuarios.setSaldo(nombreGuardado, (saldoActual + (valorActual*numeroAccionesAVender)));
									JOptionPane.showMessageDialog(btnCompletar, "Venta realizada", "Venta", 3, null);
								}else {
									JOptionPane.showMessageDialog(btnCompletar, "Acciones insuficiente", "Error", 2, null);
								}
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							
						} else if (empresaSeleccionada== Empresas.Facebook) {
							try {
								numeroAccioneActuales = conexionAcciones.getNumeroAcciones("Facebook", nombreGuardado);
								valorActual = conexionEmpresas.getValorAccion("Facebook");
								if(numeroAccioneActuales>=numeroAccionesAVender) {
									venderAmazon();
									conexionUsuarios.setSaldo(nombreGuardado, (saldoActual + (valorActual*numeroAccionesAVender)));
									JOptionPane.showMessageDialog(btnCompletar, "Venta realizada", "Venta", 3, null);
								}else {
									JOptionPane.showMessageDialog(btnCompletar, "Acciones insuficiente", "Error", 2, null);
								}
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							
						} else if (empresaSeleccionada== Empresas.Google) {
							try {
								numeroAccioneActuales = conexionAcciones.getNumeroAcciones("Google", nombreGuardado);
								valorActual = conexionEmpresas.getValorAccion("Google");
								if(numeroAccioneActuales>=numeroAccionesAVender) {
									venderAmazon();
									conexionUsuarios.setSaldo(nombreGuardado, (saldoActual + (valorActual*numeroAccionesAVender)));
									JOptionPane.showMessageDialog(btnCompletar, "Venta realizada", "Venta", 3, null);
								}else {
									JOptionPane.showMessageDialog(btnCompletar, "Acciones insuficiente", "Error", 2, null);
								}
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							
						} else if (empresaSeleccionada== Empresas.Linkedin) {
							
							try {
								numeroAccioneActuales = conexionAcciones.getNumeroAcciones("Linkedin", nombreGuardado);
								valorActual = conexionEmpresas.getValorAccion("Linkedin");
								if(numeroAccioneActuales>=numeroAccionesAVender) {
									venderAmazon();
									conexionUsuarios.setSaldo(nombreGuardado, (saldoActual + (valorActual*numeroAccionesAVender)));
									JOptionPane.showMessageDialog(btnCompletar, "Venta realizada", "Venta", 3, null);
								}else {
									JOptionPane.showMessageDialog(btnCompletar, "Acciones insuficiente", "Error", 2, null);
								}
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							
						} else if (empresaSeleccionada== Empresas.Twitch) {
							try {
								numeroAccioneActuales = conexionAcciones.getNumeroAcciones("Twitch", nombreGuardado);
								valorActual = conexionEmpresas.getValorAccion("Twitch");
								if(numeroAccioneActuales>=numeroAccionesAVender) {
									venderAmazon();
									conexionUsuarios.setSaldo(nombreGuardado, (saldoActual + (valorActual*numeroAccionesAVender)));
									JOptionPane.showMessageDialog(btnCompletar, "Venta realizada", "Venta", 3, null);
								}else {
									JOptionPane.showMessageDialog(btnCompletar, "Acciones insuficiente", "Error", 2, null);
								}
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							
						} else if (empresaSeleccionada== Empresas.Microsoft) {
							try {
								numeroAccioneActuales = conexionAcciones.getNumeroAcciones("Microsoft", nombreGuardado);
								valorActual = conexionEmpresas.getValorAccion("Microsoft");
								if(numeroAccioneActuales>=numeroAccionesAVender) {
									venderAmazon();
									conexionUsuarios.setSaldo(nombreGuardado, (saldoActual + (valorActual*numeroAccionesAVender)));
									JOptionPane.showMessageDialog(btnCompletar, "Venta realizada", "Venta", 3, null);
								}else {
									JOptionPane.showMessageDialog(btnCompletar, "Acciones insuficiente", "Error", 2, null);
								}
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							
						} else if (empresaSeleccionada==  Empresas.Git) {
							
							try {
								numeroAccioneActuales = conexionAcciones.getNumeroAcciones("Git", nombreGuardado);
								valorActual = conexionEmpresas.getValorAccion("Git");
								if(numeroAccioneActuales>=numeroAccionesAVender) {
									venderAmazon();
									conexionUsuarios.setSaldo(nombreGuardado, (saldoActual + (valorActual*numeroAccionesAVender)));
									JOptionPane.showMessageDialog(btnCompletar, "Venta realizada", "Venta", 3, null);
								}else {
									JOptionPane.showMessageDialog(btnCompletar, "Acciones insuficiente", "Error", 2, null);
								}
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							
						} else if (empresaSeleccionada==  Empresas.Paypal) {
							try {
								numeroAccioneActuales = conexionAcciones.getNumeroAcciones("Paypal", nombreGuardado);
								valorActual = conexionEmpresas.getValorAccion("Paypal");
								if(numeroAccioneActuales>=numeroAccionesAVender) {
									venderAmazon();
									conexionUsuarios.setSaldo(nombreGuardado, (saldoActual + (valorActual*numeroAccionesAVender)));
									JOptionPane.showMessageDialog(btnCompletar, "Venta realizada", "Venta", 3, null);
								}else {
									JOptionPane.showMessageDialog(btnCompletar, "Acciones insuficiente", "Error", 2, null);
								}
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
						
					} else {
						JOptionPane.showMessageDialog(btnCompletar, "Introduce una cantidad de válida", "Error", 2, null);
					}
				}
			
			}
		});
		
	}
	
	/*public void operacionesDeVenta(int acciones) throws SQLException {
		conexionAcciones.updateOperacion(empresaSeleccionada, nombreGuardado, accionesTotales(acciones));
		conexionHistorial.insertaTransaccion(ID, nombreGuardado, empresaSeleccionada, textCantidad.getText(), "venta");
		conexionUsuarios.setSaldo(nombreGuardado, dineroGanado(acciones));
	}
	
	public double dineroGanado(int acciones) throws SQLException{
		return (conexionUsuarios.getSaldo(nombreGuardado)) + conexionEmpresas.getValorAccion(empresaSeleccionada) * acciones;
	}
	
	public int accionesTotales(int acciones) throws SQLException {
		return conexionAcciones.getNumeroAcciones(empresaSeleccionada, nombreGuardado) - acciones;
	}*/

	private void addVentana() {
		ventanaVender.getContentPane().setBackground(Color.WHITE);
		ventanaVender.setTitle("Vender");
		ventanaVender.setBounds(100, 100, 450, 300);
		ventanaVender.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventanaVender.getContentPane().setLayout(null);
	}

	private void addCheckValor() {
		checkValor.setBackground(Color.WHITE);
		checkValor.setBounds(120, 106, 86, 23);
		ventanaVender.getContentPane().add(checkValor);
	}

	private void addBtnCompletar() {
		btnCompletar.setIcon(new ImageIcon("C:\\Users\\ro_cl\\Downloads\\Completar.png"));
		btnCompletar.setBackground(Color.WHITE);
		btnCompletar.setBounds(154, 177, 127, 42);
		btnCompletar.setBorder(null);
		ventanaVender.getContentPane().add(btnCompletar);
	}

	private void addTextValor() {
		textValor.setBounds(230, 109, 86, 20);
		textValor.setColumns(10);
		ventanaVender.getContentPane().add(textValor);
	}

	private void addTextCantidad() {
		textCantidad.setBounds(230, 76, 86, 20);
		textCantidad.setColumns(10);
		ventanaVender.getContentPane().add(textCantidad);
	}

	private void addLblCantidad() {
		lblCantidad.setBounds(120, 74, 86, 20);
		ventanaVender.getContentPane().add(lblCantidad);
	}

	private void addBtnCancelar() {
		btnCancelar.setIcon(new ImageIcon("C:\\Users\\ro_cl\\Downloads\\Cancelar.png"));
		btnCancelar.setBackground(Color.WHITE);
		btnCancelar.setBounds(10, 11, 110, 23);
		btnCancelar.setBorder(null);
		ventanaVender.getContentPane().add(btnCancelar);
	}
	private void comprarPaypal() throws SQLException {
		int acciones = Integer.parseInt(textCantidad.getText());
		conexionAcciones.actualizarBaseDatos("Paypal", nombreGuardado, acciones, false);
		conexionHistorial.insertaTransaccion(ID, nombreGuardado, "Paypal", textCantidad.getText(), "compra");
}

private void comprarGit() throws SQLException {
	int acciones = Integer.parseInt(textCantidad.getText());
	conexionAcciones.actualizarBaseDatos("GitHub", nombreGuardado, acciones, false);
	conexionHistorial.insertaTransaccion(ID, nombreGuardado, "GitHub", textCantidad.getText(), "compra");
}

private void comprarMicrosoft() throws SQLException {
	int acciones = Integer.parseInt(textCantidad.getText());
	conexionAcciones.actualizarBaseDatos("GitHub", nombreGuardado, acciones, false);
	conexionHistorial.insertaTransaccion(ID, nombreGuardado, "Microsoft", textCantidad.getText(), "compra");
}

private void comprarTwitch() throws SQLException {
	int acciones = Integer.parseInt(textCantidad.getText());
	conexionAcciones.actualizarBaseDatos("Twitch", nombreGuardado, acciones, false);
	conexionHistorial.insertaTransaccion(ID, nombreGuardado, "Twitch", textCantidad.getText(), "compra");
}

private void comprarLinkedin() throws SQLException {
	int acciones = Integer.parseInt(textCantidad.getText());
	conexionAcciones.actualizarBaseDatos("Linkedin", nombreGuardado, acciones, false);
	conexionHistorial.insertaTransaccion(ID, nombreGuardado, "Linkedin", textCantidad.getText(), "compra");
}

private void comprarGoogle() throws SQLException {
	int acciones = Integer.parseInt(textCantidad.getText());
	conexionAcciones.actualizarBaseDatos("GitHub", nombreGuardado, acciones, false);
	conexionHistorial.insertaTransaccion(ID, nombreGuardado, "Google", textCantidad.getText(), "compra");		
}

private void comprarFacebook() throws SQLException {
	int acciones = Integer.parseInt(textCantidad.getText());
	conexionAcciones.actualizarBaseDatos("Facebook", nombreGuardado, acciones, false);
	conexionHistorial.insertaTransaccion(ID, nombreGuardado, "Facebook", textCantidad.getText(), "compra");

}

private void comprarApple() throws SQLException {
	int acciones = Integer.parseInt(textCantidad.getText());
	conexionAcciones.actualizarBaseDatos("Apple", nombreGuardado, acciones, false);
	conexionHistorial.insertaTransaccion(ID, nombreGuardado, "Apple", textCantidad.getText(), "compra");
	
}

private void venderAmazon() throws SQLException {
	int acciones = Integer.parseInt(textCantidad.getText());
	conexionAcciones.actualizarBaseDatos("Amazon", nombreGuardado, acciones, false);
	conexionHistorial.insertaTransaccion(ID, nombreGuardado, "Amazon", textCantidad.getText(), "venta");
	
}
}
