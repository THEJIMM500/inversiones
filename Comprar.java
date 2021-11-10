package inversiones;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.Color;
import javax.swing.ImageIcon;


public class Comprar {

	private JFrame ventanaComprar;
	private JTextField textCantidad, textValor;
	private JButton btnCompletar, btnCancelar;
	private JLabel lblCantidad;
	private JCheckBox chckbxValor;

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
		addVentana();
		
		btnCancelar = new JButton("");
		addBtnCancelar();
		btnCancelar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
		        Principal principal = new Principal();
		        principal.main(null);
		        ventanaComprar.setVisible(false);
			}
		});
		
		lblCantidad = new JLabel("Cantidad");
		addLblCantidad(lblCantidad);
		
		textCantidad = new JTextField();
		addTextCantidad();
		
		textValor = new JTextField();
		addTextValor();
		
		btnCompletar = new JButton("");
		addBtnCompletar();
		
		chckbxValor = new JCheckBox("Valor");
		addChckValor(chckbxValor);
		
	}

	public void addVentana() {
		ventanaComprar.getContentPane().setBackground(Color.WHITE);
		ventanaComprar.setTitle("Comprar");
		ventanaComprar.setBounds(100, 100, 450, 300);
		ventanaComprar.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventanaComprar.getContentPane().setLayout(null);
	}

	public void addLblCantidad(JLabel lblCantidad) {
		lblCantidad.setBounds(120, 74, 60, 14);
		ventanaComprar.getContentPane().add(lblCantidad);
	}

	public void addChckValor(JCheckBox chckbxValor) {
		chckbxValor.setBackground(Color.WHITE);
		chckbxValor.setBounds(120, 106, 60, 23);
		ventanaComprar.getContentPane().add(chckbxValor);
	}

	public void addBtnCompletar() {
		btnCompletar.setIcon(new ImageIcon("C:\\Users\\ro_cl\\Downloads\\Completar.png"));
		btnCompletar.setBackground(Color.WHITE);
		btnCompletar.setBounds(154, 177, 127, 42);
		ventanaComprar.getContentPane().add(btnCompletar);
	}

	public void addTextValor() {
		textValor.setBounds(187, 109, 86, 20);
		textValor.setColumns(10);
		ventanaComprar.getContentPane().add(textValor);
	}

	public void addTextCantidad() {
		textCantidad.setBounds(187, 71, 86, 20);
		textCantidad.setColumns(10);
		ventanaComprar.getContentPane().add(textCantidad);
	}

	public void addBtnCancelar() {
		btnCancelar.setIcon(new ImageIcon("C:\\Users\\ro_cl\\Downloads\\Cancelar.png"));
		btnCancelar.setBackground(Color.WHITE);
		btnCancelar.setBounds(10, 11, 110, 23);
		ventanaComprar.getContentPane().add(btnCancelar);
	}
}
