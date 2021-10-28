package inversiones;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JCheckBox;


public class Comprar {

	private JFrame ventanaComprar;
	private JTextField textCantidad;
	private JTextField textValor;
	private JButton btnCompletar;
	private JButton btnCancelar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Comprar window = new Comprar();
					window.ventanaComprar.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Comprar() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		ventanaComprar = new JFrame();
		ventanaComprar.setTitle("Comprar");
		ventanaComprar.setBounds(100, 100, 450, 300);
		ventanaComprar.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(10, 11, 89, 23);
		ventanaComprar.getContentPane().add(btnCancelar);
		btnCancelar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
		        Principal principal = new Principal();
		        principal.main(null);
		        ventanaComprar.setVisible(false);
			}
		});
		
		JLabel lblCantidad = new JLabel("Cantidad");
		lblCantidad.setBounds(120, 74, 43, 14);
		
		textCantidad = new JTextField();
		textCantidad.setBounds(187, 71, 86, 20);
		textCantidad.setColumns(10);
		
		textValor = new JTextField();
		textValor.setBounds(187, 109, 86, 20);
		textValor.setColumns(10);
		
		btnCompletar = new JButton("Completar");
		btnCompletar.setBounds(154, 177, 81, 23);
		
		JCheckBox chckbxValor = new JCheckBox("Valor");
		chckbxValor.setBounds(120, 106, 49, 23);
		ventanaComprar.getContentPane().setLayout(null);
		ventanaComprar.getContentPane().add(lblCantidad);
		ventanaComprar.getContentPane().add(chckbxValor);
		ventanaComprar.getContentPane().add(textValor);
		ventanaComprar.getContentPane().add(textCantidad);
		ventanaComprar.getContentPane().add(btnCompletar);
		
	}
}
