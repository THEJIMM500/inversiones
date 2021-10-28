package inversiones;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.GroupLayout.Alignment;

public class Vender {

	private JFrame ventanaVender;
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
					Vender window = new Vender();
					window.ventanaVender.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Vender() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		ventanaVender = new JFrame();
		ventanaVender.setTitle("Vender");
		ventanaVender.setBounds(100, 100, 450, 300);
		ventanaVender.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(10, 11, 89, 23);
		ventanaVender.getContentPane().add(btnCancelar);
		btnCancelar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
		        Principal principal = new Principal();
		        principal.main(null);
		        ventanaVender.setVisible(false);
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
		ventanaVender.getContentPane().setLayout(null);
		ventanaVender.getContentPane().add(lblCantidad);
		ventanaVender.getContentPane().add(chckbxValor);
		ventanaVender.getContentPane().add(textValor);
		ventanaVender.getContentPane().add(textCantidad);
		ventanaVender.getContentPane().add(btnCompletar);
		
	}
}
