package inversiones;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.Component;

public class InicioSesion {

	private JFrame ventanaInicioSesion;
	private JTextField textUsuario;
	private JPasswordField passwordContrasena;

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
		initialize();
		ventanaInicioSesion.setVisible(true);
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		ventanaInicioSesion = new JFrame();
		ventanaInicioSesion.setTitle("Iniciar sesi\u00F3n");
		ventanaInicioSesion.setBounds(100, 100, 740, 430);
		ventanaInicioSesion.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventanaInicioSesion.getContentPane().setLayout(null);
		
		JLabel lblTitulo = new JLabel("ESCOLAPInversions");
		lblTitulo.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblTitulo.setBounds(160, 11, 120, 20);
		ventanaInicioSesion.getContentPane().add(lblTitulo);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblUsuario.setBounds(90, 75, 70, 14);
		ventanaInicioSesion.getContentPane().add(lblUsuario);
		
		JLabel lblContrasena = new JLabel("Contrase\u00F1a");
		lblContrasena.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblContrasena.setBounds(90, 120, 70, 14);
		ventanaInicioSesion.getContentPane().add(lblContrasena);
		
		textUsuario = new JTextField();
		textUsuario.setBounds(228, 72, 116, 20);
		ventanaInicioSesion.getContentPane().add(textUsuario);
		textUsuario.setColumns(10);
		
		passwordContrasena = new JPasswordField();
		passwordContrasena.setBounds(228, 117, 116, 20);
		ventanaInicioSesion.getContentPane().add(passwordContrasena);
		
		JButton btnInicio = new JButton("Iniciar sesi\u00F3n");
		btnInicio.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnInicio.setBounds(86, 183, 120, 25);
		ventanaInicioSesion.getContentPane().add(btnInicio);		
		btnInicio.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
		        Principal principal = new Principal();
		        principal.main(null);
		        ventanaInicioSesion.setVisible(false);
			}
		});
		
		JButton btnRegistro = new JButton("Registrarse");
		btnRegistro.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnRegistro.setBounds(224, 183, 120, 25);
		ventanaInicioSesion.getContentPane().add(btnRegistro);
		btnRegistro.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
		        NuevoUsuario registro = new NuevoUsuario();
		        registro.main(null);
		        ventanaInicioSesion.setVisible(false);
			}
		});
	}
	
}
