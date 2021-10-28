package inversiones;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Saldo {

	private JFrame ventanaSaldo;
	private JTextField textCantidad;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Saldo window = new Saldo();
					window.ventanaSaldo.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Saldo() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		ventanaSaldo = new JFrame();
		ventanaSaldo.setTitle("Saldo");
		ventanaSaldo.setBounds(100, 100, 450, 300);
		ventanaSaldo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton btnRetroceder = new JButton("Retroceder");
		btnRetroceder.setBounds(10, 11, 87, 23);
		btnRetroceder.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
		        Principal principal = new Principal();
		        principal.main(null);
		        ventanaSaldo.setVisible(false);
			}
		});
		
		JLabel lblCartera = new JLabel("Cartera");
		lblCartera.setBounds(106, 72, 37, 14);
		
		JTextPane textPaneSaldo = new JTextPane();
		textPaneSaldo.setBounds(188, 72, 133, 20);
		
		JButton btnIngresar = new JButton("Ingresar");
		btnIngresar.setBounds(151, 164, 73, 23);
		
		JButton btnRetirar = new JButton("Retirar");
		btnRetirar.setBounds(151, 205, 65, 23);
		
		JLabel lblCantidad = new JLabel("Cantidad");
		lblCantidad.setBounds(100, 110, 43, 14);
		
		textCantidad = new JTextField();
		textCantidad.setBounds(188, 110, 133, 20);
		textCantidad.setColumns(10);
		ventanaSaldo.getContentPane().setLayout(null);
		ventanaSaldo.getContentPane().add(btnRetroceder);
		ventanaSaldo.getContentPane().add(btnRetirar);
		ventanaSaldo.getContentPane().add(btnIngresar);
		ventanaSaldo.getContentPane().add(lblCantidad);
		ventanaSaldo.getContentPane().add(lblCartera);
		ventanaSaldo.getContentPane().add(textCantidad);
		ventanaSaldo.getContentPane().add(textPaneSaldo);
	}
}
