package inversiones;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

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
		lblNtarjeta.setBounds(72, 172, 100, 14);
		
		JLabel lblApellidos = new JLabel("Apellidos");
		lblApellidos.setBounds(72, 114, 56, 14);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(72, 56, 90, 14);
		
		textNombre = new JTextField();
		textNombre.setBounds(72, 76, 283, 20);
		textNombre.setColumns(10);
		
		textApellidos = new JTextField();
		textApellidos.setBounds(72, 134, 283, 20);
		textApellidos.setColumns(10);
		
		textNtarjeta = new JTextField();
		textNtarjeta.setBounds(72, 192, 283, 20);
		textNtarjeta.setColumns(10);
		
		JButton btnRetroceder = new JButton("Retroceder");
		btnRetroceder.setBounds(10, 11, 87, 23);
		btnRetroceder.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
		        Principal principal = new Principal();
		        principal.main(null);
		        ventanaDatosPersonales.setVisible(false);
			}
		});
		
		textTelefono = new JTextField();
		textTelefono.setBounds(72, 366, 283, 20);
		textTelefono.setColumns(10);
		
		JLabel lblTelefono = new JLabel("Tel\u00E9fono");
		lblTelefono.setBounds(72, 346, 100, 14);
		
		textCorreo = new JTextField();
		textCorreo.setBounds(72, 308, 283, 20);
		textCorreo.setColumns(10);
		
		JLabel lblCorreo = new JLabel("Correo");
		lblCorreo.setBounds(72, 288, 56, 14);
		
		textDireccion = new JTextField();
		textDireccion.setBounds(72, 250, 283, 20);
		textDireccion.setColumns(10);
		
		JLabel lblDireccion = new JLabel("Direcci\u00F3n");
		lblDireccion.setBounds(72, 230, 90, 14);
		
		lblFechaNac = new JLabel("Fecha de nacimiento");
		lblFechaNac.setBounds(72, 404, 101, 14);
		
		textFechaNac = new JTextField();
		textFechaNac.setBounds(72, 424, 283, 20);
		textFechaNac.setColumns(10);
		
		btnCambiarContrasena = new JButton("Cambiar contrase\u00F1a");
		btnCambiarContrasena.setBounds(167, 462, 131, 23);
		
		btnModificar = new JButton("Modificar campos");
		btnModificar.setBounds(167, 503, 117, 23);
		ventanaDatosPersonales.getContentPane().setLayout(null);
		ventanaDatosPersonales.getContentPane().add(btnRetroceder);
		ventanaDatosPersonales.getContentPane().add(lblNombre);
		ventanaDatosPersonales.getContentPane().add(textNombre);
		ventanaDatosPersonales.getContentPane().add(lblApellidos);
		ventanaDatosPersonales.getContentPane().add(textApellidos);
		ventanaDatosPersonales.getContentPane().add(lblDireccion);
		ventanaDatosPersonales.getContentPane().add(textDireccion);
		ventanaDatosPersonales.getContentPane().add(lblNtarjeta);
		ventanaDatosPersonales.getContentPane().add(textNtarjeta);
		ventanaDatosPersonales.getContentPane().add(lblCorreo);
		ventanaDatosPersonales.getContentPane().add(textCorreo);
		ventanaDatosPersonales.getContentPane().add(lblTelefono);
		ventanaDatosPersonales.getContentPane().add(textTelefono);
		ventanaDatosPersonales.getContentPane().add(lblFechaNac);
		ventanaDatosPersonales.getContentPane().add(textFechaNac);
		ventanaDatosPersonales.getContentPane().add(btnModificar);
		ventanaDatosPersonales.getContentPane().add(btnCambiarContrasena);
	}

}
