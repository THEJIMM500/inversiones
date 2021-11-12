package inversiones;



import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.Color;

public class DatosPersonales {

	private JFrame ventanaDatosPersonales;
	private JLabel lblNombre, lblApellidos, lblNtarjeta, lblTelefono, lblCorreo, lblDireccion, lblFechaNac;
	private JTextArea textNombre, textApellidos, textNtarjeta, textTelefono, textCorreo, textDireccion, textFechaNac;
	private JButton btnCambiarContrasena, btnModificar, btnRetroceder;
	private String nombreGuardado;

	
	public DatosPersonales(String nombre) {
		initialize();
		nombreGuardado=nombre;
	}

	
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
		
		textNombre = new JTextArea();
		addTextNombre();
		
		textApellidos = new JTextArea();
		addTextApellidos();
		
		textNtarjeta = new JTextArea();
		addTextNtarjeta();
		
		textTelefono = new JTextArea();
		addTextTelefono();
		
		textCorreo = new JTextArea();
		addTextCorreo();
		
		textDireccion = new JTextArea();
		addTextDireccion();
		
		textFechaNac = new JTextArea();
		addTextFechaNac();
		
		crearBotonRetroceder();
		
		btnCambiarContrasena = new JButton("");
		addBtnCambiarContrasena();
		btnCambiarContrasena.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
		        new CambiarContrasena(nombreGuardado);
		        ventanaDatosPersonales.setVisible(false);
			}
		});
		
		btnModificar = new JButton("");
		addBtnModificar();
		btnModificar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
		        new CambiarDatos(nombreGuardado);
		        ventanaDatosPersonales.setVisible(false);
			}
		});
		ventanaDatosPersonales.setVisible(true);
	}


	private void crearBotonRetroceder() {
		btnRetroceder = new JButton("");
		addBtnRetroceder();
		btnRetroceder.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
		        new Principal(nombreGuardado);
		        ventanaDatosPersonales.setVisible(false);
			}
		});
	}

	public void addVentana() {
		ventanaDatosPersonales.getContentPane().setBackground(Color.WHITE);
		ventanaDatosPersonales.setTitle("Datos personales");
		ventanaDatosPersonales.setBounds(100, 100, 450, 635);
		ventanaDatosPersonales.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventanaDatosPersonales.getContentPane().setLayout(null);
	}

	public void addBtnModificar() {
		btnModificar.setIcon(new ImageIcon(".//recursos/Modificar campos.png"));
		btnModificar.setBackground(Color.WHITE);
		btnModificar.setBounds(122, 524, 190, 44);
		btnModificar.setBorder(null);
		ventanaDatosPersonales.getContentPane().add(btnModificar);
	}

	public void addBtnCambiarContrasena() {
		btnCambiarContrasena.setBackground(Color.WHITE);
		btnCambiarContrasena.setIcon(new ImageIcon(".//recursos/Cambiar contrase\u00F1a.png"));
		btnCambiarContrasena.setBounds(112, 469, 210, 44);
		btnCambiarContrasena.setBorder(null);
		ventanaDatosPersonales.getContentPane().add(btnCambiarContrasena);
	}

	public void addBtnRetroceder() {
		btnRetroceder.setBackground(Color.WHITE);
		btnRetroceder.setIcon(new ImageIcon(".//recursos/Retroceder.png"));
		btnRetroceder.setBounds(10, 11, 136, 33);
		btnRetroceder.setBorder(null);
		ventanaDatosPersonales.getContentPane().add(btnRetroceder);
	}

	public void addTextFechaNac() {
		textFechaNac.setBounds(72, 424, 283, 20);
		textFechaNac.setColumns(10);
		textFechaNac.setBackground(Color.LIGHT_GRAY);
		ventanaDatosPersonales.getContentPane().add(textFechaNac);
	}

	public void addTextDireccion() {
		textDireccion.setBounds(72, 250, 283, 20);
		textDireccion.setColumns(10);
		textDireccion.setBackground(Color.LIGHT_GRAY);
		ventanaDatosPersonales.getContentPane().add(textDireccion);
	}

	public void addTextCorreo() {
		textCorreo.setBounds(72, 308, 283, 20);
		textCorreo.setColumns(10);
		textCorreo.setBackground(Color.LIGHT_GRAY);
		ventanaDatosPersonales.getContentPane().add(textCorreo);
	}

	public void addTextTelefono() {
		textTelefono.setBounds(72, 366, 283, 20);
		textTelefono.setColumns(10);
		textTelefono.setBackground(Color.LIGHT_GRAY);
		ventanaDatosPersonales.getContentPane().add(textTelefono);
	}

	public void addTextNtarjeta() {
		textNtarjeta.setBounds(72, 192, 283, 20);
		textNtarjeta.setColumns(10);
		textNtarjeta.setBackground(Color.LIGHT_GRAY);
		ventanaDatosPersonales.getContentPane().add(textNtarjeta);
	}

	public void addTextApellidos() {
		textApellidos.setBounds(72, 134, 283, 20);
		textApellidos.setColumns(10);
		textApellidos.setBackground(Color.LIGHT_GRAY);
		ventanaDatosPersonales.getContentPane().add(textApellidos);
	}

	public void addTextNombre() {
		textNombre.setBounds(72, 76, 283, 20);
		textNombre.setColumns(10);
		textNombre.setBackground(Color.LIGHT_GRAY);
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