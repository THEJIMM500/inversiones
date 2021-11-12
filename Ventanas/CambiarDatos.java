package inversiones;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.Color;

public class CambiarDatos {

	private JFrame ventanaCambiarDatos;
	private JLabel lblNombre, lblApellidos, lblNtarjeta, lblTelefono, lblCorreo, lblDireccion, lblFechaNac;
	private JTextField textNombre, textApellidos, textNtarjeta, textTelefono, textCorreo, textDireccion, textFechaNac;
	private JButton btnCambiarContrasena, btnModificar, btnRetroceder;
	private String nombreGuardado;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CambiarDatos window = new CambiarDatos();
					window.ventanaCambiarDatos.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CambiarDatos() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		ventanaCambiarDatos = new JFrame();
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
		        DatosPersonales datos = new DatosPersonales();
		        datos.main(null);
		        ventanaCambiarDatos.setVisible(false);
			}
		});
		
		btnCambiarContrasena = new JButton("");
		addBtnCambiarContrasena();
		
		btnModificar = new JButton("");
		addBtnModificar();
		
	}

	public void addVentana() {
		ventanaCambiarDatos.getContentPane().setBackground(Color.WHITE);
		ventanaCambiarDatos.setTitle("Cambiar datos personales");
		ventanaCambiarDatos.setBounds(100, 100, 450, 635);
		ventanaCambiarDatos.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventanaCambiarDatos.getContentPane().setLayout(null);
	}

	public void addBtnModificar() {
		btnModificar.setIcon(new ImageIcon("C:\\Users\\ro_cl\\Downloads\\Modificar campos.png"));
		btnModificar.setBackground(Color.WHITE);
		btnModificar.setBounds(122, 524, 190, 44);
		ventanaCambiarDatos.getContentPane().add(btnModificar);
	}

	public void addBtnCambiarContrasena() {
		btnCambiarContrasena.setBackground(Color.WHITE);
		btnCambiarContrasena.setIcon(new ImageIcon("C:\\Users\\ro_cl\\Downloads\\Cambiar contrase\u00F1a.png"));
		btnCambiarContrasena.setBounds(112, 469, 210, 44);
		ventanaCambiarDatos.getContentPane().add(btnCambiarContrasena);
	}

	public void addBtnRetroceder() {
		btnRetroceder.setBackground(Color.WHITE);
		btnRetroceder.setIcon(new ImageIcon("C:\\Users\\ro_cl\\Downloads\\Retroceder.png"));
		btnRetroceder.setBounds(10, 11, 136, 33);
		ventanaCambiarDatos.getContentPane().add(btnRetroceder);
	}

	public void addTextFechaNac() {
		textFechaNac.setBounds(72, 424, 283, 20);
		textFechaNac.setColumns(10);
		ventanaCambiarDatos.getContentPane().add(textFechaNac);
	}

	public void addTextDireccion() {
		textDireccion.setBounds(72, 250, 283, 20);
		textDireccion.setColumns(10);
		ventanaCambiarDatos.getContentPane().add(textDireccion);
	}

	public void addTextCorreo() {
		textCorreo.setBounds(72, 308, 283, 20);
		textCorreo.setColumns(10);
		ventanaCambiarDatos.getContentPane().add(textCorreo);
	}

	public void addTextTelefono() {
		textTelefono.setBounds(72, 366, 283, 20);
		textTelefono.setColumns(10);
		ventanaCambiarDatos.getContentPane().add(textTelefono);
	}

	public void addTextNtarjeta() {
		textNtarjeta.setBounds(72, 192, 283, 20);
		textNtarjeta.setColumns(10);
		ventanaCambiarDatos.getContentPane().add(textNtarjeta);
	}

	public void addTextApellidos() {
		textApellidos.setBounds(72, 134, 283, 20);
		textApellidos.setColumns(10);
		ventanaCambiarDatos.getContentPane().add(textApellidos);
	}

	public void addTextNombre() {
		textNombre.setBounds(72, 76, 283, 20);
		textNombre.setColumns(10);
		ventanaCambiarDatos.getContentPane().add(textNombre);
	}

	public void addLblFechaNac() {
		lblFechaNac.setBounds(72, 404, 101, 14);
		ventanaCambiarDatos.getContentPane().add(lblFechaNac);
	}

	public void addLblDireccion() {
		lblDireccion.setBounds(72, 230, 90, 14);
		ventanaCambiarDatos.getContentPane().add(lblDireccion);
	}

	public void addLblCorreo() {
		lblCorreo.setBounds(72, 288, 56, 14);
		ventanaCambiarDatos.getContentPane().add(lblCorreo);
	}

	public void addLblTelefono() {
		lblTelefono.setBounds(72, 346, 100, 14);
		ventanaCambiarDatos.getContentPane().add(lblTelefono);
	}

	public void addLblNtarjeta() {
		lblNtarjeta.setBounds(72, 172, 100, 14);
		ventanaCambiarDatos.getContentPane().add(lblNtarjeta);
	}

	public void addLblApellidos() {
		lblApellidos.setBounds(72, 114, 56, 14);
		ventanaCambiarDatos.getContentPane().add(lblApellidos);
	}

	public void addLblNombre() {
		lblNombre.setBounds(72, 56, 90, 14);
		ventanaCambiarDatos.getContentPane().add(lblNombre);
	}

}
