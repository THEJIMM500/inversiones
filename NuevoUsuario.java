package inversiones;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;

public class NuevoUsuario {

	private JFrame ventanaRegistro;
	private JTextField textUsuario;
	private JTextField textContrasena;
	private JTextField textConfirmar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NuevoUsuario window = new NuevoUsuario();
					window.ventanaRegistro.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public NuevoUsuario() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		ventanaRegistro = new JFrame();
		ventanaRegistro.setTitle("Registro");
		ventanaRegistro.setBounds(100, 100, 450, 300);
		ventanaRegistro.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblUsuario = new JLabel("Nombre de usuario");
		
		textUsuario = new JTextField();
		textUsuario.setColumns(10);
		
		JLabel lblContrasena = new JLabel("Contrase\u00F1a");
		
		textContrasena = new JTextField();
		textContrasena.setColumns(10);
		
		JLabel lblConfirmar = new JLabel("Confirma contrase\u00F1a");
		
		textConfirmar = new JTextField();
		textConfirmar.setColumns(10);
		
		JButton btnCrearCuenta = new JButton("Crear cuenta");
		
		JButton btnRetroceder = new JButton("Retroceder");
		GroupLayout groupLayout = new GroupLayout(ventanaRegistro.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(72)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(lblConfirmar)
								.addComponent(lblContrasena)
								.addComponent(lblUsuario)
								.addComponent(textUsuario, GroupLayout.DEFAULT_SIZE, 283, Short.MAX_VALUE)
								.addComponent(textContrasena)
								.addComponent(textConfirmar)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(162)
							.addComponent(btnCrearCuenta))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnRetroceder)))
					.addContainerGap(79, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnRetroceder)
					.addGap(22)
					.addComponent(lblUsuario)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textUsuario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblContrasena)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textContrasena, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblConfirmar)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textConfirmar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnCrearCuenta)
					.addContainerGap(15, Short.MAX_VALUE))
		);
		ventanaRegistro.getContentPane().setLayout(groupLayout);
	}
}
