package inversiones;

import java.awt.EventQueue;

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
		
		JLabel lblCancelar = new JLabel("Cancelar");
		
		JLabel lblCantidad = new JLabel("Cantidad");
		
		textCantidad = new JTextField();
		textCantidad.setColumns(10);
		
		textValor = new JTextField();
		textValor.setColumns(10);
		
		btnCompletar = new JButton("Completar");
		
		JCheckBox chckbxValor = new JCheckBox("Valor");
		GroupLayout groupLayout = new GroupLayout(ventanaComprar.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblCancelar))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(120)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblCantidad)
								.addComponent(chckbxValor))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(textValor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(textCantidad, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(154)
							.addComponent(btnCompletar)))
					.addContainerGap(113, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblCancelar)
							.addGap(49)
							.addComponent(lblCantidad)
							.addGap(18)
							.addComponent(chckbxValor))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(textCantidad, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(textValor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(48)
					.addComponent(btnCompletar)
					.addContainerGap(58, Short.MAX_VALUE))
		);
		ventanaComprar.getContentPane().setLayout(groupLayout);
	}
}
