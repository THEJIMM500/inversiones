package inversiones;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;

public class NuevoUsuario {

	private JFrame ventanaRegistro;
	private JTextField textUsuario;
	private JTextField textContrasena;
	private JTextField textConfirmar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NuevoUsuario window = new NuevoUsuario();
					window.ventanaRegistro.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public NuevoUsuario() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		ventanaRegistro = new JFrame();
		ventanaRegistro.setTitle("Registro");
		ventanaRegistro.setBounds(100, 100, 450, 300);
		ventanaRegistro.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventanaRegistro.getContentPane().setLayout(null);
		
		JLabel lblUsuario = new JLabel("Nombre de usuario");
		lblUsuario.setBounds(72, 56, 92, 14);
		ventanaRegistro.getContentPane().add(lblUsuario);
		
		textUsuario = new JTextField();
		textUsuario.setBounds(72, 76, 283, 20);
		textUsuario.setColumns(10);
		ventanaRegistro.getContentPane().add(textUsuario);
		
		JLabel lblContrasena = new JLabel("Contrase\u00F1a");
		lblContrasena.setBounds(72, 114, 56, 14);
		ventanaRegistro.getContentPane().add(lblContrasena);
		
		textContrasena = new JTextField();
		textContrasena.setBounds(72, 134, 283, 20);
		textContrasena.setColumns(10);
		ventanaRegistro.getContentPane().add(textContrasena);
		
		JLabel lblConfirmar = new JLabel("Confirma contrase\u00F1a");
		lblConfirmar.setBounds(72, 172, 102, 14);
		ventanaRegistro.getContentPane().add(lblConfirmar);
		
		textConfirmar = new JTextField();
		textConfirmar.setBounds(72, 192, 283, 20);
		textConfirmar.setColumns(10);
		ventanaRegistro.getContentPane().add(textConfirmar);
		
		JButton btnCrearCuenta = new JButton("Crear cuenta");
		btnCrearCuenta.setBounds(162, 223, 95, 23);
		ventanaRegistro.getContentPane().add(btnCrearCuenta);
		
		JButton btnRetroceder = new JButton("Retroceder");
		btnRetroceder.setBounds(10, 11, 87, 23);
		ventanaRegistro.getContentPane().add(btnRetroceder);
		btnRetroceder.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
		        InicioSesion inicio = new InicioSesion();
		        inicio.main(null);
		        ventanaRegistro.setVisible(false);
			}
		});
	}
}
