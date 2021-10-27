package inversiones;

import java.awt.EventQueue;

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
		
		JLabel lblCancelar = new JLabel("Cancelar");
		
		JLabel lblCantidad = new JLabel("Cantidad");
		
		textCantidad = new JTextField();
		textCantidad.setColumns(10);
		
		textValor = new JTextField();
		textValor.setColumns(10);
		
		btnCompletar = new JButton("Completar");
		
		JCheckBox chckbxValor = new JCheckBox("Valor");
		GroupLayout groupLayout = new GroupLayout(ventanaVender.getContentPane());
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
		ventanaVender.getContentPane().setLayout(groupLayout);
	}

}
