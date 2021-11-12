package inversiones;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.Color;

public class Movimientos {

	private JFrame ventanaMovimientos;
	private JLabel lblEmpresa;
	private JTextPane textPaneGanancias;
	private JButton btnRetroceder;
	private JList listHistorial;
	private String nombreGuardado;

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
		addVentana();
		
		lblEmpresa = new JLabel("Empresa");
		addLblEmpresa();
		
		textPaneGanancias = new JTextPane();
		addTextPaneGanancias();
		
		btnRetroceder = new JButton("");
		addBtnRetroceder();
		btnRetroceder.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
		        Principal principal = new Principal(nombreGuardado);
		        principal.main(null);
		        ventanaMovimientos.setVisible(false);
			}
		});
		
		listHistorial = new JList();
		addListHistorial();
		
	}

	public void addVentana() {
		ventanaMovimientos.getContentPane().setBackground(Color.WHITE);
		ventanaMovimientos.setTitle("Movimientos");
		ventanaMovimientos.setBounds(100, 100, 450, 300);
		ventanaMovimientos.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventanaMovimientos.getContentPane().setLayout(null);
	}

	public void addListHistorial() {
		listHistorial.setBounds(65, 125, 279, 108);
		ventanaMovimientos.getContentPane().add(listHistorial);
	}

	public void addBtnRetroceder() {
		btnRetroceder.setIcon(new ImageIcon("C:\\Users\\ro_cl\\Downloads\\Retroceder.png"));
		btnRetroceder.setBounds(10, 11, 136, 33);
		ventanaMovimientos.getContentPane().add(btnRetroceder);
	}

	public void addTextPaneGanancias() {
		textPaneGanancias.setBounds(220, 52, 124, 20);
		ventanaMovimientos.getContentPane().add(textPaneGanancias);
	}

	public void addLblEmpresa() {
		lblEmpresa.setBounds(113, 52, 41, 14);
		ventanaMovimientos.getContentPane().add(lblEmpresa);
	}
}
