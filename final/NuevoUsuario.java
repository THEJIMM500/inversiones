package inversiones;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.*;

import tratadoDatos.ComprobarDatos;
import tratadoDatos.ConexionUsuarios;

import java.awt.Color;
import java.awt.Font;

public class NuevoUsuario {

	private JFrame ventanaRegistro;
	private JTextField textUsuario, textContrasena, textConfirmar;
	private JLabel lblUsuario, lblContrasena, lblConfirmar;
	private JButton btnCrearCuenta, btnRetroceder;
	public String nombreGuardado;
	private ConexionUsuarios conexion;

	
	public NuevoUsuario(String nombreGuardado) {
		initialize();
		try {
			conexion= new ConexionUsuarios();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.nombreGuardado = nombreGuardado;
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		ventanaRegistro = new JFrame();
		addVentana();
		ventanaRegistro.setVisible(true);
		
		lblUsuario = new JLabel("Nombre de usuario");
		lblUsuario.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		addLblUsuario();
		//addLabel(lblUsuario, 72, 56, 92, 14);
		
		textUsuario = new JTextField();
		addTextUsuario();
		
		lblContrasena = new JLabel("Contrase\u00F1a");
		lblContrasena.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		addLblContrasena();
		
		textContrasena = new JTextField();
		addTextContrasena();
		
		lblConfirmar = new JLabel("Confirma contrase\u00F1a");
		lblConfirmar.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		addLblConfirmar();
		
		textConfirmar = new JTextField();
		addTextConfirmar();
		
		btnCrearCuenta = new JButton("");
		addBtnCrearCuenta();
		
		btnRetroceder = new JButton("");
		addBtnRetroceder();
		btnRetroceder.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
		        new InicioSesion();
		        ventanaRegistro.setVisible(false);
			}
		});
	}

	public void addVentana() {
		ventanaRegistro.getContentPane().setBackground(Color.WHITE);
		ventanaRegistro.setTitle("Registro");
		ventanaRegistro.setBounds(100, 100, 450, 335);
		ventanaRegistro.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventanaRegistro.getContentPane().setLayout(null);
	}

	public void addBtnRetroceder() {
		btnRetroceder.setIcon(new ImageIcon("Retroceder.png"));
		btnRetroceder.setBackground(Color.WHITE);
		btnRetroceder.setBounds(10, 11, 136, 33);
		btnRetroceder.setBorder(null);
		ventanaRegistro.getContentPane().add(btnRetroceder);
	}

	public void addBtnCrearCuenta() {
		btnCrearCuenta.setIcon(new ImageIcon("Crear cuenta.png"));
		btnCrearCuenta.setBackground(Color.WHITE);
		btnCrearCuenta.setBounds(141, 229, 152, 45);
		btnCrearCuenta.setBorder(null);
		btnCrearCuenta.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(ComprobarDatos.nombreUsuarioValido(textUsuario.getText())== true
						&&ComprobarDatos.contraseñaValido(textContrasena.getText())== true){
					
					if(textContrasena.getText().equals(textConfirmar.getText())==true) {
				        try {
							if(conexion.registrarUsuario(textUsuario.getText(),textContrasena.getText())) {
								JOptionPane.showMessageDialog(btnCrearCuenta, "Usuario creado. Ahora será redirigido a la pantalla de inicio.", "Operacion existosa", 1, null);
								Thread.sleep(1000);
								new InicioSesion();
								ventanaRegistro.setVisible(false);
							}
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (InterruptedException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}else {
						JOptionPane.showMessageDialog(btnCrearCuenta, "Las contraseñas no coinciden.", "Error en los valores", 0, null);
					}
				}else {
					JOptionPane.showMessageDialog(btnCrearCuenta, "El Usauario o la contraseña son"
							+ " demasiado extensos. Asegurese de que ninguno supere los 30 caracteres.", "Error en los valores", 0, null);
				}
				
				
				
			}
		});
		ventanaRegistro.getContentPane().add(btnCrearCuenta);
	}

	public void addTextConfirmar() {
		textConfirmar.setBounds(72, 192, 283, 20);
		textConfirmar.setColumns(10);
		ventanaRegistro.getContentPane().add(textConfirmar);
	}

	public void addLblConfirmar() {
		lblConfirmar.setBounds(72, 172, 283, 20);
		ventanaRegistro.getContentPane().add(lblConfirmar);
	}

	public void addTextContrasena() {
		textContrasena.setBounds(72, 134, 283, 20);
		textContrasena.setColumns(10);
		ventanaRegistro.getContentPane().add(textContrasena);
	}

	public void addLblContrasena() {
		lblContrasena.setBounds(72, 114, 283, 20);
		ventanaRegistro.getContentPane().add(lblContrasena);
	}

	public void addTextUsuario() {
		textUsuario.setBounds(72, 76, 283, 20);
		textUsuario.setColumns(10);
		ventanaRegistro.getContentPane().add(textUsuario);
	}

	public void addLblUsuario() {
		lblUsuario.setBounds(72, 56, 283, 20);
		ventanaRegistro.getContentPane().add(lblUsuario);
	}
	
	public void addLabel(JLabel label, int x, int y, int w, int h) {
		label.setBounds(x, y, w, h);
		ventanaRegistro.getContentPane().add(label);
	}
	
}

