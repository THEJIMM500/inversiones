package inversiones;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.Color;

public class Saldo {

	private JFrame ventanaSaldo;
	private JTextField textCantidad;
	private JButton btnRetroceder, btnIngresar, btnRetirar;
	private JLabel lblCartera, lblCantidad;
	private JTextPane textPaneSaldo;


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
		addVentana();
		
		btnRetroceder = new JButton("");
		addBtnRetroceder();
		btnRetroceder.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
		        Principal principal = new Principal();
		        principal.main(null);
		        ventanaSaldo.setVisible(false);
			}
		});
		
		lblCartera = new JLabel("Cartera");
		addLblCartera();
		
		textPaneSaldo = new JTextPane();
		addTextPaneSaldo();
		
		btnIngresar = new JButton("");
		addBtnIngresar();
		
		btnRetirar = new JButton("");
		addBtnRetirar();
		
		lblCantidad = new JLabel("Cantidad");
		addLblCantidad();
		
		textCantidad = new JTextField();
		addTextCantidad();

	}

	public void addVentana() {
		ventanaSaldo.getContentPane().setBackground(Color.WHITE);
		ventanaSaldo.setTitle("Saldo");
		ventanaSaldo.setBounds(100, 100, 450, 300);
		ventanaSaldo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventanaSaldo.getContentPane().setLayout(null);
	}

	public void addTextCantidad() {
		textCantidad.setBounds(188, 110, 133, 20);
		textCantidad.setColumns(10);
		ventanaSaldo.getContentPane().add(textCantidad);
	}

	public void addLblCantidad() {
		lblCantidad.setBounds(100, 110, 43, 14);
		ventanaSaldo.getContentPane().add(lblCantidad);
	}

	public void addBtnRetirar() {
		btnRetirar.setIcon(new ImageIcon("C:\\Users\\ro_cl\\Downloads\\Retirar saldo.png"));
		btnRetirar.setBackground(Color.WHITE);
		btnRetirar.setBounds(151, 205, 161, 44);
		ventanaSaldo.getContentPane().add(btnRetirar);
	}

	public void addBtnIngresar() {
		btnIngresar.setBackground(Color.WHITE);
		btnIngresar.setIcon(new ImageIcon("C:\\Users\\ro_cl\\Downloads\\Ingresar saldo.png"));
		btnIngresar.setBounds(151, 164, 160, 44);
		ventanaSaldo.getContentPane().add(btnIngresar);
	}

	public void addTextPaneSaldo() {
		textPaneSaldo.setBounds(188, 72, 133, 20);
		ventanaSaldo.getContentPane().add(textPaneSaldo);
	}

	public void addLblCartera() {
		lblCartera.setBounds(106, 72, 37, 14);
		ventanaSaldo.getContentPane().add(lblCartera);
	}

	public void addBtnRetroceder() {
		btnRetroceder.setIcon(new ImageIcon("C:\\Users\\ro_cl\\Downloads\\Retroceder.png"));
		btnRetroceder.setBounds(10, 11, 136, 33);
		ventanaSaldo.getContentPane().add(btnRetroceder);
	}
}
