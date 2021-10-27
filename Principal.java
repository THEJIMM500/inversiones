package inversiones;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Principal {

	private JFrame ventanaPrincipal;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal window = new Principal();
					window.ventanaPrincipal.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Principal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		ventanaPrincipal = new JFrame();
		ventanaPrincipal.setTitle("Principal");
		ventanaPrincipal.setBounds(100, 100, 740, 430);
		ventanaPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventanaPrincipal.getContentPane().setLayout(null);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setBounds(10, 11, 46, 14);
		ventanaPrincipal.getContentPane().add(lblUsuario);
		
		JButton btnDatosPersonales = new JButton("DatosPersonales");
		btnDatosPersonales.setBounds(10, 82, 89, 23);
		ventanaPrincipal.getContentPane().add(btnDatosPersonales);
		btnDatosPersonales.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
		        Principal principal = new Principal();
		        principal.main(null);
		        btnDatosPersonales.setVisible(false);
			}
		});
		
		JButton btnMovimientos = new JButton("Movimientos");
		btnMovimientos.setBounds(10, 137, 89, 23);
		ventanaPrincipal.getContentPane().add(btnMovimientos);
		
		JButton btnSaldo = new JButton("Saldo");
		btnSaldo.setBounds(10, 193, 89, 23);
		ventanaPrincipal.getContentPane().add(btnSaldo);
		
		JButton btnCerrarSesion = new JButton("Cerrar sesi\u00F3n");
		btnCerrarSesion.setBounds(10, 254, 89, 23);
		ventanaPrincipal.getContentPane().add(btnCerrarSesion);
		
		JButton btnVender = new JButton("Vender");
		btnVender.setBounds(625, 233, 89, 23);
		ventanaPrincipal.getContentPane().add(btnVender);
		
		JButton btnComprar = new JButton("Comprar");
		btnComprar.setBounds(625, 112, 89, 23);
		ventanaPrincipal.getContentPane().add(btnComprar);
	}


}
