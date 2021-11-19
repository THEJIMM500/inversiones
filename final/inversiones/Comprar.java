package inversiones;

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

//cambiar el saldo
public class Comprar {
	
	private ConexionAcciones conexionAcciones;
	private ConexionEmpresas conexionEmpresas;
	private ConexionHistorial conexionHistorial;
	private ConexionUsuarios conexionUsuarios;
	private JFrame ventanaComprar;
	private JTextField textCantidad, textValor;
	private JButton btnCompletar, btnCancelar;
	private JLabel lblCantidad;
	private JCheckBox checkValor;
	private String nombreGuardado;
	Enum<Empresas> empresaSeleccionada;
	private int ID;
	private TradeoAlValor tradeo;

	public Comprar(String nombreGuardado, Enum<Empresas> empresaSelecionada) {
		this.nombreGuardado = nombreGuardado;
		this.empresaSeleccionada = empresaSelecionada;
		try {
			conexionAcciones=new ConexionAcciones();
			conexionHistorial=new ConexionHistorial();
			conexionUsuarios= new ConexionUsuarios();
			conexionEmpresas = new ConexionEmpresas();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		initialize();
		ventanaComprar.setVisible(true);
	}

	
	private void initialize() {
		ventanaComprar = new JFrame();
		addVentana();
		
		btnCancelar = new JButton("");
		addBtnCancelar();
		btnCancelar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
		        new Principal(nombreGuardado);
		        ventanaComprar.setVisible(false);
			}
		});
		
		lblCantidad = new JLabel("Cantidad");
		lblCantidad.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		addLblCantidad(lblCantidad);
		
		textCantidad = new JTextField();
		addTextCantidad();
		
		textValor = new JTextField();
		addTextValor();
		
		checkValor = new JCheckBox("Valor");
		checkValor.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		addChckValor(checkValor);
		if (checkValor.isSelected()) {
			
		}
		
		btnCompletar = new JButton("");
		addBtnCompletar();
		btnCompletar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				double saldoActual = 0;
				double valorActual=0;
				
				if (checkValor.isSelected()) {
					System.out.println("Haz lo de la casilla marcada");
					
					double precioObjetivo = Double.parseDouble(textValor.getText());
					if (precioObjetivo > 0) {						
						int numeroAcciones = Integer.parseInt(textCantidad.getText());
						if(numeroAcciones > 0) {
							if (empresaSeleccionada== Empresas.Amazon ) {
								
								try {
									valorActual = conexionEmpresas.getValorAccion("Amazon");
									if(saldoActual>(valorActual*numeroAcciones)) {
										tradeo = new TradeoAlValor(precioObjetivo, "Amazon", nombreGuardado, true);
										JOptionPane.showMessageDialog(btnCompletar, "Compra realizada", "Compra", 3, null);
									}else {
										JOptionPane.showMessageDialog(btnCompletar, "Saldo insuficiente", "Error", 2, null);
									}
								} catch (SQLException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
								
							} else if (empresaSeleccionada== Empresas.Apple) {
								try {
									valorActual = conexionEmpresas.getValorAccion("Apple");
									if(saldoActual>(valorActual*numeroAcciones)) {
										tradeo = new TradeoAlValor(precioObjetivo, "Apple", nombreGuardado, true);
										JOptionPane.showMessageDialog(btnCompletar, "Compra realizada", "Compra", 3, null);
									}else {
										JOptionPane.showMessageDialog(btnCompletar, "Saldo insuficiente", "Error", 2, null);
									}
								} catch (SQLException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
								
							} else if (empresaSeleccionada== Empresas.Facebook) {
								try {
									valorActual = conexionEmpresas.getValorAccion("Facebook");
									if(saldoActual>(valorActual*numeroAcciones)) {
										tradeo = new TradeoAlValor(precioObjetivo, "Facebook", nombreGuardado, true);
										JOptionPane.showMessageDialog(btnCompletar, "Compra realizada", "Compra", 3, null);
									}else {
										JOptionPane.showMessageDialog(btnCompletar, "Saldo insuficiente", "Error", 2, null);
									}
								} catch (SQLException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
								
							} else if (empresaSeleccionada== Empresas.Google) {
								try {
									valorActual = conexionEmpresas.getValorAccion("Google");
									if(saldoActual>(valorActual*numeroAcciones)) {
										tradeo = new TradeoAlValor(precioObjetivo, "Google", nombreGuardado, true);
										JOptionPane.showMessageDialog(btnCompletar, "Compra realizada", "Compra", 3, null);
									}else {
										JOptionPane.showMessageDialog(btnCompletar, "Saldo insuficiente", "Error", 2, null);
									}
								} catch (SQLException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
								
							} else if (empresaSeleccionada== Empresas.Linkedin) {
								
								try {
									valorActual = conexionEmpresas.getValorAccion("Linkedin");
									if(saldoActual>(valorActual*numeroAcciones)) {
										tradeo = new TradeoAlValor(precioObjetivo, "Linkedin", nombreGuardado, true);
										JOptionPane.showMessageDialog(btnCompletar, "Compra realizada", "Compra", 3, null);
									}else {
										JOptionPane.showMessageDialog(btnCompletar, "Saldo insuficiente", "Error", 2, null);
									}
								} catch (SQLException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
								
							} else if (empresaSeleccionada== Empresas.Twitch) {
								try {
									valorActual = conexionEmpresas.getValorAccion("Twitch");
									if(saldoActual>(valorActual*numeroAcciones)) {
										tradeo = new TradeoAlValor(precioObjetivo, "Twitch", nombreGuardado, true);
										JOptionPane.showMessageDialog(btnCompletar, "Compra realizada", "Compra", 3, null);
									}else {
										JOptionPane.showMessageDialog(btnCompletar, "Saldo insuficiente", "Error", 2, null);
									}
								} catch (SQLException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
								
							} else if (empresaSeleccionada== Empresas.Microsoft) {
								try {
									valorActual = conexionEmpresas.getValorAccion("Microsoft");
									if(saldoActual>(valorActual*numeroAcciones)) {
										tradeo = new TradeoAlValor(precioObjetivo, "Microsoft", nombreGuardado, true);
										JOptionPane.showMessageDialog(btnCompletar, "Compra realizada", "Compra", 3, null);
									}else {
										JOptionPane.showMessageDialog(btnCompletar, "Saldo insuficiente", "Error", 2, null);
									}
								} catch (SQLException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
								
							} else if (empresaSeleccionada==  Empresas.Git) {
								
								try {
									valorActual = conexionEmpresas.getValorAccion("GitHub");
									if(saldoActual>(valorActual*numeroAcciones)) {
										tradeo = new TradeoAlValor(precioObjetivo, "GitHub", nombreGuardado, true);
										JOptionPane.showMessageDialog(btnCompletar, "Compra realizada", "Compra", 3, null);
									}else {
										JOptionPane.showMessageDialog(btnCompletar, "Saldo insuficiente", "Error", 2, null);
									}
								} catch (SQLException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
								
							} else if (empresaSeleccionada==  Empresas.Paypal) {
								try {
									valorActual = conexionEmpresas.getValorAccion("Paypal");
									if(saldoActual>(valorActual*numeroAcciones)) {
										tradeo = new TradeoAlValor(precioObjetivo, "Paypal", nombreGuardado, true);
										JOptionPane.showMessageDialog(btnCompletar, "Compra realizada", "Compra", 3, null);
									}else {
										JOptionPane.showMessageDialog(btnCompletar, "Saldo insuficiente", "Error", 2, null);
									}
								} catch (SQLException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
							}
							
						} else {
							JOptionPane.showMessageDialog(btnCompletar, "Introduce una cantidad válida", "Error", 2, null);
						}
						
					}
				} else {
				
				try {
					saldoActual = conexionUsuarios.getSaldo(nombreGuardado);
					valorActual = 0;
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				
				int numeroAcciones = Integer.parseInt(textCantidad.getText());
					if(numeroAcciones > 0) {
						if (empresaSeleccionada== Empresas.Amazon ) {
							
							try {
								valorActual = conexionEmpresas.getValorAccion("Amazon");
								if(saldoActual>(valorActual*numeroAcciones)) {
									comprarAmazon();
									conexionUsuarios.setSaldo(nombreGuardado, (saldoActual-(valorActual*numeroAcciones)));
									JOptionPane.showMessageDialog(btnCompletar, "Compra realizada", "Compra", 3, null);
								}else {
									JOptionPane.showMessageDialog(btnCompletar, "Saldo insuficiente", "Error", 2, null);
								}
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							
						} else if (empresaSeleccionada== Empresas.Apple) {
							try {
								valorActual = conexionEmpresas.getValorAccion("Apple");
								if(saldoActual>(valorActual*numeroAcciones)) {
									comprarApple();
									conexionUsuarios.setSaldo(nombreGuardado, (saldoActual-(valorActual*numeroAcciones)));
									JOptionPane.showMessageDialog(btnCompletar, "Compra realizada", "Compra", 3, null);
								}else {
									JOptionPane.showMessageDialog(btnCompletar, "Saldo insuficiente", "Error", 2, null);
								}
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							
						} else if (empresaSeleccionada== Empresas.Facebook) {
							try {
								valorActual = conexionEmpresas.getValorAccion("Facebook");
								if(saldoActual>(valorActual*numeroAcciones)) {
									comprarFacebook();
									conexionUsuarios.setSaldo(nombreGuardado, (saldoActual-(valorActual*numeroAcciones)));
									JOptionPane.showMessageDialog(btnCompletar, "Compra realizada", "Compra", 3, null);
								}else {
									JOptionPane.showMessageDialog(btnCompletar, "Saldo insuficiente", "Error", 2, null);
								}
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							
						} else if (empresaSeleccionada== Empresas.Google) {
							try {
								valorActual = conexionEmpresas.getValorAccion("Google");
								if(saldoActual>(valorActual*numeroAcciones)) {
									comprarGoogle();
									conexionUsuarios.setSaldo(nombreGuardado, (saldoActual-(valorActual*numeroAcciones)));
									JOptionPane.showMessageDialog(btnCompletar, "Compra realizada", "Compra", 3, null);
								}else {
									JOptionPane.showMessageDialog(btnCompletar, "Saldo insuficiente", "Error", 2, null);
								}
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							
						} else if (empresaSeleccionada== Empresas.Linkedin) {
							
							try {
								valorActual = conexionEmpresas.getValorAccion("Linkedin");
								if(saldoActual>(valorActual*numeroAcciones)) {
									comprarLinkedin();
									conexionUsuarios.setSaldo(nombreGuardado, (saldoActual-(valorActual*numeroAcciones)));
									JOptionPane.showMessageDialog(btnCompletar, "Compra realizada", "Compra", 3, null);
								}else {
									JOptionPane.showMessageDialog(btnCompletar, "Saldo insuficiente", "Error", 2, null);
								}
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							
						} else if (empresaSeleccionada== Empresas.Twitch) {
							try {
								valorActual = conexionEmpresas.getValorAccion("Twitch");
								if(saldoActual>(valorActual*numeroAcciones)) {
									comprarTwitch();
									conexionUsuarios.setSaldo(nombreGuardado, (saldoActual-(valorActual*numeroAcciones)));
									JOptionPane.showMessageDialog(btnCompletar, "Compra realizada", "Compra", 3, null);
								}else {
									JOptionPane.showMessageDialog(btnCompletar, "Saldo insuficiente", "Error", 2, null);
								}
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							
						} else if (empresaSeleccionada== Empresas.Microsoft) {
							try {
								valorActual = conexionEmpresas.getValorAccion("Microsoft");
								if(saldoActual>(valorActual*numeroAcciones)) {
									comprarMicrosoft();
									conexionUsuarios.setSaldo(nombreGuardado, (saldoActual-(valorActual*numeroAcciones)));
									JOptionPane.showMessageDialog(btnCompletar, "Compra realizada", "Compra", 3, null);
								}else {
									JOptionPane.showMessageDialog(btnCompletar, "Saldo insuficiente", "Error", 2, null);
								}
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							
						} else if (empresaSeleccionada==  Empresas.Git) {
							
							try {
								valorActual = conexionEmpresas.getValorAccion("GitHub");
								if(saldoActual>(valorActual*numeroAcciones)) {
									comprarGit();
									conexionUsuarios.setSaldo(nombreGuardado, (saldoActual-(valorActual*numeroAcciones)));
									JOptionPane.showMessageDialog(btnCompletar, "Compra realizada", "Compra", 3, null);
								}else {
									JOptionPane.showMessageDialog(btnCompletar, "Saldo insuficiente", "Error", 2, null);
								}
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							
						} else if (empresaSeleccionada==  Empresas.Paypal) {
							try {
								valorActual = conexionEmpresas.getValorAccion("Paypal");
								if(saldoActual>(valorActual*numeroAcciones)) {
									comprarPaypal();
									conexionUsuarios.setSaldo(nombreGuardado, (saldoActual-(valorActual*numeroAcciones)));
									JOptionPane.showMessageDialog(btnCompletar, "Compra realizada", "Compra", 3, null);
								}else {
									JOptionPane.showMessageDialog(btnCompletar, "Saldo insuficiente", "Error", 2, null);
								}
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
						
					} else {
						JOptionPane.showMessageDialog(btnCompletar, "Introduce una cantidad válida", "Error", 2, null);
					}
				}
			
			}
		});
		
	}

	public void addVentana() {
		ventanaComprar.getContentPane().setBackground(Color.WHITE);
		ventanaComprar.setTitle("Comprar");
		ventanaComprar.setBounds(100, 100, 450, 300);
		ventanaComprar.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventanaComprar.getContentPane().setLayout(null);
	}

	public void addLblCantidad(JLabel lblCantidad) {
		lblCantidad.setBounds(120, 74, 86, 20);
		ventanaComprar.getContentPane().add(lblCantidad);
	}

	public void addChckValor(JCheckBox chckbxValor) {
		chckbxValor.setBackground(Color.WHITE);
		chckbxValor.setBounds(120, 106, 86, 23);
		ventanaComprar.getContentPane().add(chckbxValor);
	}

	public void addBtnCompletar() {
		btnCompletar.setIcon(new ImageIcon("C:\\Users\\ro_cl\\Downloads\\Completar.png"));
		btnCompletar.setBackground(Color.WHITE);
		btnCompletar.setBounds(154, 177, 127, 42);
		btnCompletar.setBorder(null);
		ventanaComprar.getContentPane().add(btnCompletar);
	}

	public void addTextValor() {
		textValor.setBounds(230, 109, 86, 20);
		textValor.setColumns(10);
		ventanaComprar.getContentPane().add(textValor);
	}

	public void addTextCantidad() {
		textCantidad.setBounds(230, 76, 86, 20);
		textCantidad.setColumns(10);
		ventanaComprar.getContentPane().add(textCantidad);
	}

	public void addBtnCancelar() {
		btnCancelar.setIcon(new ImageIcon("C:\\Users\\ro_cl\\Downloads\\Cancelar.png"));
		btnCancelar.setBackground(Color.WHITE);
		btnCancelar.setBounds(10, 11, 110, 23);
		btnCancelar.setBorder(null);
		ventanaComprar.getContentPane().add(btnCancelar);
	}
	private void comprarPaypal() throws SQLException {
		int acciones = Integer.parseInt(textCantidad.getText());
		conexionAcciones.actualizarBaseDatos("Paypal", nombreGuardado, acciones, true);
		conexionHistorial.insertaTransaccion(ID, nombreGuardado, "Paypal", textCantidad.getText(), "compra");
	}

	private void comprarGit() throws SQLException {
		int acciones = Integer.parseInt(textCantidad.getText());
		conexionAcciones.actualizarBaseDatos("GitHub", nombreGuardado, acciones, true);
		conexionHistorial.insertaTransaccion(ID, nombreGuardado, "GitHub", textCantidad.getText(), "compra");
	}

	private void comprarMicrosoft() throws SQLException {
		int acciones = Integer.parseInt(textCantidad.getText());
		conexionAcciones.actualizarBaseDatos("Microsoft", nombreGuardado, acciones, true);
		conexionHistorial.insertaTransaccion(ID, nombreGuardado, "Microsoft", textCantidad.getText(), "compra");
	}

	private void comprarTwitch() throws SQLException {
		int acciones = Integer.parseInt(textCantidad.getText());
		conexionAcciones.actualizarBaseDatos("Twitch", nombreGuardado, acciones, true);
		conexionHistorial.insertaTransaccion(ID, nombreGuardado, "Twitch", textCantidad.getText(), "compra");
	}

	private void comprarLinkedin() throws SQLException {
		int acciones = Integer.parseInt(textCantidad.getText());
		conexionAcciones.actualizarBaseDatos("Linkedin", nombreGuardado, acciones, true);
		conexionHistorial.insertaTransaccion(ID, nombreGuardado, "Linkedin", textCantidad.getText(), "compra");
	}

	private void comprarGoogle() throws SQLException {
		int acciones = Integer.parseInt(textCantidad.getText());
		conexionAcciones.actualizarBaseDatos("GitHub", nombreGuardado, acciones, true);
		conexionHistorial.insertaTransaccion(ID, nombreGuardado, "Google", textCantidad.getText(), "compra");		
	}

	private void comprarFacebook() throws SQLException {
		int acciones = Integer.parseInt(textCantidad.getText());
		conexionAcciones.actualizarBaseDatos("Facebook", nombreGuardado, acciones, true);
		conexionHistorial.insertaTransaccion(ID, nombreGuardado, "Facebook", textCantidad.getText(), "compra");
	
	}

	private void comprarApple() throws SQLException {
		int acciones = Integer.parseInt(textCantidad.getText());
		conexionAcciones.actualizarBaseDatos("Apple", nombreGuardado, acciones, true);
		conexionHistorial.insertaTransaccion(ID, nombreGuardado, "Apple", textCantidad.getText(), "compra");
		
	}

	private void comprarAmazon() throws SQLException {
		int acciones = Integer.parseInt(textCantidad.getText());
		conexionAcciones.actualizarBaseDatos("Amazon", nombreGuardado, acciones, true);
		conexionHistorial.insertaTransaccion(ID, nombreGuardado, "Amazon", textCantidad.getText(), "compra");
		
	}
}
