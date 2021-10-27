package inversiones;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.JTextField;

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
		
		JLabel lblCartera = new JLabel("Cartera");
		
		JTextPane textPaneSaldo = new JTextPane();
		
		JButton btnIngresar = new JButton("Ingresar");
		
		JButton btnRetirar = new JButton("Retirar");
		
		JLabel lblCantidad = new JLabel("Cantidad");
		
		textCantidad = new JTextField();
		textCantidad.setColumns(10);
		GroupLayout groupLayout = new GroupLayout(ventanaSaldo.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnRetroceder))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(151)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(btnRetirar)
								.addComponent(btnIngresar)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(100)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblCantidad)
								.addComponent(lblCartera))
							.addGap(45)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(textCantidad)
								.addComponent(textPaneSaldo, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(119, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnRetroceder)
					.addGap(38)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(textPaneSaldo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblCartera))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblCantidad)
						.addComponent(textCantidad, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(34)
					.addComponent(btnIngresar)
					.addGap(18)
					.addComponent(btnRetirar)
					.addContainerGap(33, Short.MAX_VALUE))
		);
		ventanaSaldo.getContentPane().setLayout(groupLayout);
	}
}
