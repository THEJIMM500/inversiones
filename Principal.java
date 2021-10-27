package inversiones;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;

public class Principal {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal window = new Principal();
					window.frame.setVisible(true);
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
		frame = new JFrame();
		frame.setBounds(100, 100, 740, 430);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setBounds(10, 11, 46, 14);
		frame.getContentPane().add(lblUsuario);
		
		JButton btnDatosPersonales = new JButton("DatosPersonales");
		btnDatosPersonales.setBounds(10, 82, 89, 23);
		frame.getContentPane().add(btnDatosPersonales);
		
		JButton btnMovimientos = new JButton("Movimientos");
		btnMovimientos.setBounds(10, 137, 89, 23);
		frame.getContentPane().add(btnMovimientos);
		
		JButton btnSaldo = new JButton("Saldo");
		btnSaldo.setBounds(10, 193, 89, 23);
		frame.getContentPane().add(btnSaldo);
		
		JButton btnCerrarSesion = new JButton("Cerrar sesi\u00F3n");
		btnCerrarSesion.setBounds(10, 254, 89, 23);
		frame.getContentPane().add(btnCerrarSesion);
		
		JButton btnVender = new JButton("Vender");
		btnVender.setBounds(625, 233, 89, 23);
		frame.getContentPane().add(btnVender);
		
		JButton btnComprar = new JButton("Comprar");
		btnComprar.setBounds(625, 112, 89, 23);
		frame.getContentPane().add(btnComprar);
	}

}
