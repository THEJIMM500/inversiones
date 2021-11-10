package inversiones;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.Color;

public class DatosPersonales {

	private JFrame ventanaDatosPersonales;
	private JLabel lblNombre, lblApellidos, lblNtarjeta, lblTelefono, lblCorreo, lblDireccion, lblFechaNac;
	private JTextField textNombre, textApellidos, textNtarjeta, textTelefono, textCorreo, textDireccion, textFechaNac;
	private JButton btnCambiarContrasena, btnModificar, btnRetroceder;

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
		addVentana();		
		
		lblNombre = new JLabel("Nombre");
		addLblNombre();
		
		lblApellidos = new JLabel("Apellidos");
		addLblApellidos();
		
		lblNtarjeta = new JLabel("N\u00BA de tarjeta");
		addLblNtarjeta();
		
		lblTelefono = new JLabel("Tel\u00E9fono");
		addLblTelefono();
		
		lblCorreo = new JLabel("Correo");
		addLblCorreo();
		
		lblDireccion = new JLabel("Direcci\u00F3n");
		addLblDireccion();
		
		lblFechaNac = new JLabel("Fecha de nacimiento");
		addLblFechaNac();
		
		textNombre = new JTextField();
		addTextNombre();
		
		textApellidos = new JTextField();
		addTextApellidos();
		
		textNtarjeta = new JTextField();
		addTextNtarjeta();
		
		textTelefono = new JTextField();
		addTextTelefono();
		
		textCorreo = new JTextField();
		addTextCorreo();
		
		textDireccion = new JTextField();
		addTextDireccion();
		
		textFechaNac = new JTextField();
		addTextFechaNac();
		
		btnRetroceder = new JButton("");
		addBtnRetroceder();
		btnRetroceder.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
		        Principal principal = new Principal();
		        principal.main(null);
		        ventanaDatosPersonales.setVisible(false);
			}
		});
		
		btnCambiarContrasena = new JButton("");
		addBtnCambiarContrasena();
		
		btnModificar = new JButton("");
		addBtnModificar();
		
	}

	public void addVentana() {
		ventanaDatosPersonales.getContentPane().setBackground(Color.WHITE);
		ventanaDatosPersonales.setTitle("Datos personales");
		ventanaDatosPersonales.setBounds(100, 100, 450, 635);
		ventanaDatosPersonales.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventanaDatosPersonales.getContentPane().setLayout(null);
	}

	public void addBtnModificar() {
		btnModificar.setIcon(new ImageIcon("C:\\Users\\ro_cl\\Downloads\\Modificar campos.png"));
		btnModificar.setBackground(Color.WHITE);
		btnModificar.setBounds(122, 524, 190, 44);
		ventanaDatosPersonales.getContentPane().add(btnModificar);
	}

	public void addBtnCambiarContrasena() {
		btnCambiarContrasena.setBackground(Color.WHITE);
		btnCambiarContrasena.setIcon(new ImageIcon("C:\\Users\\ro_cl\\Downloads\\Cambiar contrase\u00F1a.png"));
		btnCambiarContrasena.setBounds(112, 469, 210, 44);
		ventanaDatosPersonales.getContentPane().add(btnCambiarContrasena);
	}

	public void addBtnRetroceder() {
		btnRetroceder.setBackground(Color.WHITE);
		btnRetroceder.setIcon(new ImageIcon("C:\\Users\\ro_cl\\Downloads\\Retroceder.png"));
		btnRetroceder.setBounds(10, 11, 136, 33);
		ventanaDatosPersonales.getContentPane().add(btnRetroceder);
	}

	public void addTextFechaNac() {
		textFechaNac.setBounds(72, 424, 283, 20);
		textFechaNac.setColumns(10);
		ventanaDatosPersonales.getContentPane().add(textFechaNac);
	}

	public void addTextDireccion() {
		textDireccion.setBounds(72, 250, 283, 20);
		textDireccion.setColumns(10);
		ventanaDatosPersonales.getContentPane().add(textDireccion);
	}

	public void addTextCorreo() {
		textCorreo.setBounds(72, 308, 283, 20);
		textCorreo.setColumns(10);
		ventanaDatosPersonales.getContentPane().add(textCorreo);
	}

	public void addTextTelefono() {
		textTelefono.setBounds(72, 366, 283, 20);
		textTelefono.setColumns(10);
		ventanaDatosPersonales.getContentPane().add(textTelefono);
	}

	public void addTextNtarjeta() {
		textNtarjeta.setBounds(72, 192, 283, 20);
		textNtarjeta.setColumns(10);
		ventanaDatosPersonales.getContentPane().add(textNtarjeta);
	}

	public void addTextApellidos() {
		textApellidos.setBounds(72, 134, 283, 20);
		textApellidos.setColumns(10);
		ventanaDatosPersonales.getContentPane().add(textApellidos);
	}

	public void addTextNombre() {
		textNombre.setBounds(72, 76, 283, 20);
		textNombre.setColumns(10);
		ventanaDatosPersonales.getContentPane().add(textNombre);
	}

	public void addLblFechaNac() {
		lblFechaNac.setBounds(72, 404, 101, 14);
		ventanaDatosPersonales.getContentPane().add(lblFechaNac);
	}

	public void addLblDireccion() {
		lblDireccion.setBounds(72, 230, 90, 14);
		ventanaDatosPersonales.getContentPane().add(lblDireccion);
	}

	public void addLblCorreo() {
		lblCorreo.setBounds(72, 288, 56, 14);
		ventanaDatosPersonales.getContentPane().add(lblCorreo);
	}

	public void addLblTelefono() {
		lblTelefono.setBounds(72, 346, 100, 14);
		ventanaDatosPersonales.getContentPane().add(lblTelefono);
	}

	public void addLblNtarjeta() {
		lblNtarjeta.setBounds(72, 172, 100, 14);
		ventanaDatosPersonales.getContentPane().add(lblNtarjeta);
	}

	public void addLblApellidos() {
		lblApellidos.setBounds(72, 114, 56, 14);
		ventanaDatosPersonales.getContentPane().add(lblApellidos);
	}

	public void addLblNombre() {
		lblNombre.setBounds(72, 56, 90, 14);
		ventanaDatosPersonales.getContentPane().add(lblNombre);
	}

}
