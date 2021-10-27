package inversiones;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

public class DatosPersonales {

	private JFrame ventanaDatosPersonales;
	private JTextField textNombre;
	private JTextField textApellidos;
	private JTextField textNtarjeta;
	private JTextField textTelefono;
	private JTextField textCorreo;
	private JTextField textDireccion;
	private JLabel lblFechaNac;
	private JTextField textFechaNac;
	private JButton btnCambiarContrasena;
	private JButton btnModificar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DatosPersonales window = new DatosPersonales();
					window.ventanaDatosPersonales.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public DatosPersonales() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		ventanaDatosPersonales = new JFrame();
		ventanaDatosPersonales.setTitle("Datos personales");
		ventanaDatosPersonales.setBounds(100, 100, 450, 580);
		ventanaDatosPersonales.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblNtarjeta = new JLabel(" N\u00BA de tarjeta");
		
		JLabel lblApellidos = new JLabel("Apellidos");
		
		JLabel lblNombre = new JLabel("Nombre");
		
		textNombre = new JTextField();
		textNombre.setColumns(10);
		
		textApellidos = new JTextField();
		textApellidos.setColumns(10);
		
		textNtarjeta = new JTextField();
		textNtarjeta.setColumns(10);
		
		JButton btnRetroceder = new JButton("Retroceder");
		
		textTelefono = new JTextField();
		textTelefono.setColumns(10);
		
		JLabel lblTelefono = new JLabel("Tel\u00E9fono");
		
		textCorreo = new JTextField();
		textCorreo.setColumns(10);
		
		JLabel lblCorreo = new JLabel("Correo");
		
		textDireccion = new JTextField();
		textDireccion.setColumns(10);
		
		JLabel lblDireccion = new JLabel("Direcci\u00F3n");
		
		lblFechaNac = new JLabel("Fecha de nacimiento");
		
		textFechaNac = new JTextField();
		textFechaNac.setColumns(10);
		
		btnCambiarContrasena = new JButton("Cambiar contrase\u00F1a");
		
		btnModificar = new JButton("Modificar campos");
		GroupLayout groupLayout = new GroupLayout(ventanaDatosPersonales.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(btnRetroceder, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(62)
									.addComponent(lblNombre, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(62)
									.addComponent(textNombre, GroupLayout.PREFERRED_SIZE, 283, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(62)
									.addComponent(lblApellidos, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(62)
									.addComponent(textApellidos, GroupLayout.PREFERRED_SIZE, 283, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(62)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
										.addComponent(lblDireccion, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
										.addComponent(textDireccion, GroupLayout.DEFAULT_SIZE, 283, Short.MAX_VALUE)
										.addComponent(lblNtarjeta, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
										.addComponent(textNtarjeta, GroupLayout.DEFAULT_SIZE, 283, Short.MAX_VALUE)
										.addComponent(lblCorreo, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
										.addComponent(textCorreo, GroupLayout.DEFAULT_SIZE, 283, Short.MAX_VALUE)
										.addComponent(lblTelefono, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
										.addComponent(textTelefono, GroupLayout.DEFAULT_SIZE, 283, Short.MAX_VALUE)
										.addComponent(lblFechaNac)
										.addComponent(textFechaNac)))))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(167)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(btnModificar)
								.addComponent(btnCambiarContrasena))))
					.addContainerGap(79, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnRetroceder)
					.addGap(22)
					.addComponent(lblNombre)
					.addGap(6)
					.addComponent(textNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblApellidos)
					.addGap(6)
					.addComponent(textApellidos, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblNtarjeta)
					.addGap(6)
					.addComponent(textNtarjeta, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblDireccion)
					.addGap(6)
					.addComponent(textDireccion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblCorreo)
					.addGap(6)
					.addComponent(textCorreo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblTelefono)
					.addGap(6)
					.addComponent(textTelefono, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblFechaNac)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textFechaNac, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnCambiarContrasena)
					.addGap(18)
					.addComponent(btnModificar)
					.addContainerGap(15, Short.MAX_VALUE))
		);
		ventanaDatosPersonales.getContentPane().setLayout(groupLayout);
	}

}
