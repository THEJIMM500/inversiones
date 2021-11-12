package inversiones;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.Color;
import javax.swing.ImageIcon;

public class Vender {

	private JFrame ventanaVender;
	private JTextField textCantidad, textValor;
	private JButton btnCompletar, btnCancelar;
	private JLabel lblCantidad;
	private JCheckBox chckbxValor;
	private String nombreGuardado;

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
		ventanaVender.getContentPane().setBackground(Color.WHITE);
		ventanaVender.setTitle("Vender");
		ventanaVender.setBounds(100, 100, 450, 300);
		ventanaVender.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventanaVender.getContentPane().setLayout(null);
		
		btnCancelar = new JButton("");
		btnCancelar.setIcon(new ImageIcon("C:\\Users\\ro_cl\\Downloads\\Cancelar.png"));
		btnCancelar.setBackground(Color.WHITE);
		btnCancelar.setBounds(10, 11, 110, 23);
		ventanaVender.getContentPane().add(btnCancelar);
		btnCancelar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
		        Principal principal = new Principal(nombreGuardado);
		        principal.main(null);
		        ventanaVender.setVisible(false);
			}
		});
		
		lblCantidad = new JLabel("Cantidad");
		lblCantidad.setBounds(120, 74, 60, 14);
		ventanaVender.getContentPane().add(lblCantidad);
		
		textCantidad = new JTextField();
		textCantidad.setBounds(187, 71, 86, 20);
		textCantidad.setColumns(10);
		ventanaVender.getContentPane().add(textCantidad);
		
		textValor = new JTextField();
		textValor.setBounds(187, 109, 86, 20);
		textValor.setColumns(10);
		ventanaVender.getContentPane().add(textValor);
		
		btnCompletar = new JButton("");
		btnCompletar.setIcon(new ImageIcon("C:\\Users\\ro_cl\\Downloads\\Completar.png"));
		btnCompletar.setBackground(Color.WHITE);
		btnCompletar.setBounds(154, 177, 127, 42);
		ventanaVender.getContentPane().add(btnCompletar);
		
		chckbxValor = new JCheckBox("Valor");
		chckbxValor.setBackground(Color.WHITE);
		chckbxValor.setBounds(120, 106, 60, 23);
		ventanaVender.getContentPane().add(chckbxValor);
		
	}
}
