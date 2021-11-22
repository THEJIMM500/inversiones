package inversiones;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URI;
import java.sql.SQLException;

import javax.swing.*;

import tratadoDatos.ConexionUsuarios;

import java.awt.Component;
import java.awt.Desktop;
import java.awt.Color;
import java.awt.Font;

public class InicioSesion {

	private JFrame ventanaInicioSesion;
	private JTextField textUsuario;
	private JPasswordField passwordContrasena;
	private ConexionUsuarios conexion;
	private JLabel lblTitulo, lblUsuario, lblContrasena;
	private JButton btnInicio, btnRegistro;
	private String nombreGuardado;
	private JButton btnEnlace;


	public InicioSesion() {
		try {
			conexion = new ConexionUsuarios();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		initialize();
		ventanaInicioSesion.setVisible(true);
		
	}


	private void initialize() {
		ventanaInicioSesion = new JFrame();
		addVentana();
		
		lblTitulo = new JLabel("ESCOLAPInversions");
		lblTitulo.setFont(new Font("Gabriola", Font.BOLD, 41));
		addLblTitulo();
		
		lblUsuario = new JLabel("Usuario");
		lblUsuario.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		addLblUsuario();
		
		lblContrasena = new JLabel("Contrase\u00F1a");
		lblContrasena.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		addLblContrasena();
		
		textUsuario = new JTextField();
		addTextUsuario();
		
		passwordContrasena = new JPasswordField();
		addTextContrasena();
		
		btnEnlace = new JButton("");
		addBtnEnlace();
		btnEnlace.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {					
					String url = "http://localhost/phpmyadmin/index.php";
					Desktop.getDesktop().browse(URI.create(url));					
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		
		btnInicio = new JButton("");
		addBtnInicio();
		btnInicio.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					if (conexion.iniciarSesion(textUsuario.getText(), passwordContrasena.getText()) == 0) {
						
					    Principal principal = new Principal(textUsuario.getText());
					//    principal.main(null);
					    ventanaInicioSesion.setVisible(false);
					    nombreGuardado = textUsuario.getText();
					} else if(conexion.iniciarSesion(textUsuario.getText(), passwordContrasena.getText()) == 1){
						JOptionPane.showMessageDialog(btnInicio, "Las credenciales no coinciden", "Error", 2, null);
					}else if(conexion.iniciarSesion(textUsuario.getText(), passwordContrasena.getText()) ==-1) {
						JOptionPane.showMessageDialog(btnInicio, "El usuario no existe", "Error", 2, null);
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		btnRegistro = new JButton("");
		addBtnRegistro();
		btnRegistro.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
		        new NuevoUsuario(nombreGuardado);
		        ventanaInicioSesion.setVisible(false);
			}
		});
	}

	private void addBtnEnlace() {
		btnEnlace.setBackground(Color.WHITE);
		btnEnlace.setText("<html><FONT color=\"#000099\"><U>Soporte del CAT</U></FONT></HTML>");
		btnEnlace.setBounds(290, 315, 100, 23);
		btnEnlace.setBorder(null);
		ventanaInicioSesion.getContentPane().add(btnEnlace);
	}

	public void addVentana() {
		ventanaInicioSesion.getContentPane().setBackground(Color.WHITE);
		ventanaInicioSesion.setTitle("Iniciar sesi\u00F3n");
		ventanaInicioSesion.setBounds(100, 100, 740, 430);
		ventanaInicioSesion.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventanaInicioSesion.getContentPane().setLayout(null);
	}

	public void addBtnRegistro() {
		btnRegistro.setBackground(Color.WHITE);
		btnRegistro.setIcon(new ImageIcon("Registro.png"));
		btnRegistro.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnRegistro.setBounds(355, 240, 137, 45);
		btnRegistro.setBorder(null);
		ventanaInicioSesion.getContentPane().add(btnRegistro);
	}

	public void addBtnInicio() {
		btnInicio.setBackground(Color.WHITE);
		btnInicio.setIcon(new ImageIcon("Iniciar sesion.png"));
		btnInicio.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnInicio.setBounds(188, 240, 150, 45);
		btnInicio.setBorder(null);
		ventanaInicioSesion.getContentPane().add(btnInicio);
	}

	public void addTextContrasena() {
		passwordContrasena.setBounds(352, 174, 116, 20);
		ventanaInicioSesion.getContentPane().add(passwordContrasena);
	}

	public void addTextUsuario() {
		textUsuario.setBounds(352, 129, 116, 20);
		ventanaInicioSesion.getContentPane().add(textUsuario);
		textUsuario.setColumns(10);
	}

	public void addLblContrasena() {
		lblContrasena.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblContrasena.setBounds(214, 172, 100, 20);
		ventanaInicioSesion.getContentPane().add(lblContrasena);
	}

	public void addLblUsuario() {
		lblUsuario.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblUsuario.setBounds(214, 127, 100, 20);
		ventanaInicioSesion.getContentPane().add(lblUsuario);
	}

	public void addLblTitulo() {
		lblTitulo.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblTitulo.setBounds(202, 28, 280, 70);
		ventanaInicioSesion.getContentPane().add(lblTitulo);
	}
	
	public void addLabel(JLabel label, int x, int y, int w, int h) {
		label.setAlignmentX(Component.CENTER_ALIGNMENT);
		label.setBounds(x, y, w, h);
		ventanaInicioSesion.getContentPane().add(label);
	}
	
}
