package inversiones;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.Color;

public class NuevoUsuario {

	private JFrame ventanaRegistro;
	private JTextField textUsuario, textContrasena, textConfirmar;
	private JLabel lblUsuario, lblContrasena, lblConfirmar;
	private JButton btnCrearCuenta, btnRetroceder;
	public String nombreGuardado;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NuevoUsuario window = new NuevoUsuario(null);
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
	public NuevoUsuario(String nombreGuardado) {
		initialize();
		this.nombreGuardado = nombreGuardado;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		ventanaRegistro = new JFrame();
		addVentana();
		
		lblUsuario = new JLabel("Nombre de usuario");
		addLblUsuario();
		//addLabel(lblUsuario, 72, 56, 92, 14);
		
		textUsuario = new JTextField();
		addTextUsuario();
		
		lblContrasena = new JLabel("Contrase\u00F1a");
		addLblContrasena();
		
		textContrasena = new JTextField();
		addTextContrasena();
		
		lblConfirmar = new JLabel("Confirma contrase\u00F1a");
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
		        InicioSesion inicio = new InicioSesion();
		        inicio.main(null);
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
		btnRetroceder.setIcon(new ImageIcon("C:\\Users\\ro_cl\\Downloads\\Retroceder.png"));
		btnRetroceder.setBackground(Color.WHITE);
		btnRetroceder.setBounds(10, 11, 136, 33);
		ventanaRegistro.getContentPane().add(btnRetroceder);
	}

	public void addBtnCrearCuenta() {
		btnCrearCuenta.setIcon(new ImageIcon("C:\\Users\\ro_cl\\Downloads\\Crear cuenta.png"));
		btnCrearCuenta.setBackground(Color.WHITE);
		btnCrearCuenta.setBounds(141, 229, 152, 45);
		ventanaRegistro.getContentPane().add(btnCrearCuenta);
	}

	public void addTextConfirmar() {
		textConfirmar.setBounds(72, 192, 283, 20);
		textConfirmar.setColumns(10);
		ventanaRegistro.getContentPane().add(textConfirmar);
	}

	public void addLblConfirmar() {
		lblConfirmar.setBounds(72, 172, 150, 14);
		ventanaRegistro.getContentPane().add(lblConfirmar);
	}

	public void addTextContrasena() {
		textContrasena.setBounds(72, 134, 283, 20);
		textContrasena.setColumns(10);
		ventanaRegistro.getContentPane().add(textContrasena);
	}

	public void addLblContrasena() {
		lblContrasena.setBounds(72, 114, 155, 14);
		ventanaRegistro.getContentPane().add(lblContrasena);
	}

	public void addTextUsuario() {
		textUsuario.setBounds(72, 76, 283, 20);
		textUsuario.setColumns(10);
		ventanaRegistro.getContentPane().add(textUsuario);
	}

	public void addLblUsuario() {
		lblUsuario.setBounds(72, 56, 150, 14);
		ventanaRegistro.getContentPane().add(lblUsuario);
	}
	
	public void addLabel(JLabel label, int x, int y, int w, int h) {
		label.setBounds(x, y, w, h);
		ventanaRegistro.getContentPane().add(label);
	}
	
}
