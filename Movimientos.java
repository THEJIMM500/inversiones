package inversiones;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Movimientos {

	private JFrame ventanaMovimientos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Movimientos window = new Movimientos();
					window.ventanaMovimientos.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Movimientos() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		ventanaMovimientos = new JFrame();
		ventanaMovimientos.setTitle("Movimientos");
		ventanaMovimientos.setBounds(100, 100, 450, 300);
		ventanaMovimientos.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblEmpresa = new JLabel("Empresa");
		lblEmpresa.setBounds(113, 52, 41, 14);
		
		JTextPane textPaneGanancias = new JTextPane();
		textPaneGanancias.setBounds(220, 52, 124, 20);
		
		JButton btnRetroceder = new JButton("Retroceder");
		btnRetroceder.setBounds(10, 11, 87, 23);
		btnRetroceder.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
		        Principal principal = new Principal();
		        principal.main(null);
		        ventanaMovimientos.setVisible(false);
			}
		});
		
		JList listHistorial = new JList();
		listHistorial.setBounds(65, 125, 279, 108);
		ventanaMovimientos.getContentPane().setLayout(null);
		ventanaMovimientos.getContentPane().add(btnRetroceder);
		ventanaMovimientos.getContentPane().add(listHistorial);
		ventanaMovimientos.getContentPane().add(lblEmpresa);
		ventanaMovimientos.getContentPane().add(textPaneGanancias);
	}
}
