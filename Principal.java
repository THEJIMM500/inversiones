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
		        DatosPersonales datos = new DatosPersonales();
		        datos.main(null);
		        ventanaPrincipal.setVisible(false);
			}
		});
		
		JButton btnMovimientos = new JButton("Movimientos");
		btnMovimientos.setBounds(10, 137, 89, 23);
		ventanaPrincipal.getContentPane().add(btnMovimientos);
		btnMovimientos.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
		        Movimientos movimientos = new Movimientos();
		        movimientos.main(null);
		        ventanaPrincipal.setVisible(false);
			}
		});
		
		JButton btnSaldo = new JButton("Saldo");
		btnSaldo.setBounds(10, 193, 89, 23);
		ventanaPrincipal.getContentPane().add(btnSaldo);
		btnSaldo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
		        Saldo saldo = new Saldo();
		        saldo.main(null);
		        ventanaPrincipal.setVisible(false);
			}
		});
		
		JButton btnCerrarSesion = new JButton("Cerrar sesi\u00F3n");
		btnCerrarSesion.setBounds(10, 254, 89, 23);
		ventanaPrincipal.getContentPane().add(btnCerrarSesion);
		btnCerrarSesion.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
		        InicioSesion inicio = new InicioSesion();
		        inicio.main(null);
		        ventanaPrincipal.setVisible(false);
			}
		});
		
		JButton btnVender = new JButton("Vender");
		btnVender.setBounds(625, 233, 89, 23);
		ventanaPrincipal.getContentPane().add(btnVender);
		btnVender.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
		        Vender vender = new Vender();
		        vender.main(null);
		        ventanaPrincipal.setVisible(false);
			}
		});
		
		JButton btnComprar = new JButton("Comprar");
		btnComprar.setBounds(625, 112, 89, 23);
		ventanaPrincipal.getContentPane().add(btnComprar);
		btnComprar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
		        Comprar comprar = new Comprar();
		        comprar.main(null);
		        ventanaPrincipal.setVisible(false);
			}
		});
	}

}