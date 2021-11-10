package inversiones;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.*;
import java.awt.Component;
import java.awt.Color;

public class InicioSesion {

	private JFrame ventanaInicioSesion;
	private JTextField textUsuario;
	private JPasswordField passwordContrasena;
	private ConecsionUsuarios conexion;
	private JLabel lblTitulo, lblUsuario, lblContrasena;
	private JButton btnInicio, btnRegistro;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InicioSesion window = new InicioSesion();
					window.ventanaInicioSesion.setVisible(true);
					//window.ventanaInicioSesion.setExtendedState(JFrame.MAXIMIZED_BOTH);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public InicioSesion() {
		try {
			conexion = new ConecsionUsuarios();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		initialize();
		ventanaInicioSesion.setVisible(true);
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		ventanaInicioSesion = new JFrame();
		addVentana();
		
		lblTitulo = new JLabel("ESCOLAPInversions");
		addLblTitulo();
		
		lblUsuario = new JLabel("Usuario");
		addLblUsuario();
		
		lblContrasena = new JLabel("Contrase\u00F1a");
		addLblContrasena();
		
		textUsuario = new JTextField();
		addTextUsuario();
		
		passwordContrasena = new JPasswordField();
		addTextContrasena();
		
		btnInicio = new JButton("");
		addBtnInicio();
		btnInicio.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					if (conexion.iniciarSesion(textUsuario.getText(), passwordContrasena.getText()) == 0) {
					    Principal principal = new Principal();
					    principal.main(null);
					    ventanaInicioSesion.setVisible(false);
					} else {
						JOptionPane.showMessageDialog(btnInicio, "Error de autentificación", "Error", 2, null);
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
		        NuevoUsuario registro = new NuevoUsuario();
		        registro.main(null);
		        ventanaInicioSesion.setVisible(false);
			}
		});
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
		btnRegistro.setIcon(new ImageIcon("C:\\Users\\ro_cl\\Downloads\\Registro.png"));
		btnRegistro.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnRegistro.setBounds(348, 240, 150, 45);
		ventanaInicioSesion.getContentPane().add(btnRegistro);
	}

	public void addBtnInicio() {
		btnInicio.setBackground(Color.WHITE);
		btnInicio.setIcon(new ImageIcon("C:\\Users\\ro_cl\\Downloads\\Iniciar sesion.png"));
		btnInicio.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnInicio.setBounds(188, 240, 150, 45);
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
		lblContrasena.setBounds(214, 177, 70, 14);
		ventanaInicioSesion.getContentPane().add(lblContrasena);
	}

	public void addLblUsuario() {
		lblUsuario.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblUsuario.setBounds(214, 132, 70, 14);
		ventanaInicioSesion.getContentPane().add(lblUsuario);
	}

	public void addLblTitulo() {
		lblTitulo.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblTitulo.setBounds(284, 68, 120, 20);
		ventanaInicioSesion.getContentPane().add(lblTitulo);
	}
	
	public void addLabel(JLabel label, int x, int y, int w, int h) {
		label.setAlignmentX(Component.CENTER_ALIGNMENT);
		label.setBounds(x, y, w, h);
		ventanaInicioSesion.getContentPane().add(label);
	}
	
}
