package inversiones;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.*;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import tratadoDatos.ComprobarDatos;
import tratadoDatos.ConexionUsuarios;

import java.awt.Color;
import java.awt.Font;

public class CambiarDatos {

	private JFrame ventanaCambiarDatos;
	private JLabel lblNombre, lblApellidos, lblNtarjeta, lblTelefono, lblCorreo, lblDireccion, lblFechaNac;
	private JTextField textNombre, textApellidos, textNtarjeta, textTelefono, textCorreo, textDireccion, textFechaNac;
	private JButton btnVerificar, btnModificar, btnRetroceder;
	private String nombreGuardado;
	private ConexionUsuarios conexion;
	static Properties propiedadesEmail;
	static Session sesionEmail;
	static MimeMessage mensajeEmail;

	
	public CambiarDatos(String nombreGuardado) {
		this.nombreGuardado=nombreGuardado;
		initialize();
		ventanaCambiarDatos.setVisible(true);
		try {
			conexion= new ConexionUsuarios();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	
	private void initialize() {
		ventanaCambiarDatos = new JFrame();
		addVentana();		
		
		lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		addLblNombre();
		
		lblApellidos = new JLabel("Apellidos");
		lblApellidos.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		addLblApellidos();
		
		lblNtarjeta = new JLabel("N\u00BA de tarjeta");
		lblNtarjeta.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		addLblNtarjeta();
		
		lblTelefono = new JLabel("Tel\u00E9fono");
		lblTelefono.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		addLblTelefono();
		
		lblCorreo = new JLabel("Correo");
		lblCorreo.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		addLblCorreo();
		
		lblDireccion = new JLabel("Direcci\u00F3n");
		lblDireccion.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		addLblDireccion();
		
		lblFechaNac = new JLabel("Fecha de nacimiento");
		lblFechaNac.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
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
		        new DatosPersonales(nombreGuardado);
		        ventanaCambiarDatos.setVisible(false);
			}
		});
		
		btnVerificar = new JButton("");
		addBtnCambiarContrasena();
		btnVerificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					propiedadesServidorEmail();
					crearMensajeEmail();
					enviarEmail();
					conexion.validar(nombreGuardado);
				} catch (AddressException e1) {
					e1.printStackTrace();
				} catch (MessagingException e1) {
					e1.printStackTrace();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}

			}
		});
		
		btnModificar = new JButton("");
		addBtnModificar();
		btnModificar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					if(ComprobarDatos.nombreValido(textNombre.getText())==true&&  ComprobarDatos.apellidoValido(textApellidos.getText())&&
							ComprobarDatos.nTarjetaValido(textNtarjeta.getText())&& ComprobarDatos.direccionValido(textDireccion.getText())) {
						
						conexion.setNombre(nombreGuardado, textNombre.getText());
						conexion.setApellido(nombreGuardado, textApellidos.getText());
						conexion.setCorreo(nombreGuardado, textCorreo.getText());
						conexion.setDirecion(nombreGuardado, textDireccion.getText());
						conexion.setFechaNaci(nombreGuardado, textFechaNac.getText());
						conexion.setNtarjeta(nombreGuardado, textNtarjeta.getText());
						conexion.setTelefono(nombreGuardado, textTelefono.getText());
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				
		        new DatosPersonales(nombreGuardado);
		        ventanaCambiarDatos.setVisible(false);
			}
		});
		ventanaCambiarDatos.setVisible(true);
	}

	public void addVentana() {
		ventanaCambiarDatos.getContentPane().setBackground(Color.WHITE);
		ventanaCambiarDatos.setTitle("Cambiar datos personales");
		ventanaCambiarDatos.setBounds(100, 100, 450, 635);
		ventanaCambiarDatos.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventanaCambiarDatos.getContentPane().setLayout(null);
	}

	public void addBtnModificar() {
		btnModificar.setIcon(new ImageIcon("Modificar campos.png"));
		btnModificar.setBackground(Color.WHITE);
		btnModificar.setBounds(122, 524, 190, 44);
		btnModificar.setBorder(null);
		ventanaCambiarDatos.getContentPane().add(btnModificar);
	}

	public void addBtnCambiarContrasena() {
		btnVerificar.setBackground(Color.WHITE);
		btnVerificar.setIcon(new ImageIcon("C:\\Users\\ro_cl\\Documents\\DAM\\Programaci\u00F3n\\Eclipse\\eclipse-workspace\\2\u00BAdam\\Completar.png"));
		btnVerificar.setBounds(153, 471, 127, 42);
		btnVerificar.setBorder(null);
		ventanaCambiarDatos.getContentPane().add(btnVerificar);
	}

	public void addBtnRetroceder() {
		btnRetroceder.setBackground(Color.WHITE);
		btnRetroceder.setIcon(new ImageIcon("Retroceder.png"));
		btnRetroceder.setBounds(10, 11, 136, 33);
		btnRetroceder.setBorder(null);
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
		lblFechaNac.setBounds(72, 404, 283, 20);
		ventanaCambiarDatos.getContentPane().add(lblFechaNac);
	}

	public void addLblDireccion() {
		lblDireccion.setBounds(72, 230, 283, 20);
		ventanaCambiarDatos.getContentPane().add(lblDireccion);
	}

	public void addLblCorreo() {
		lblCorreo.setBounds(72, 288, 283, 20);
		ventanaCambiarDatos.getContentPane().add(lblCorreo);
	}

	public void addLblTelefono() {
		lblTelefono.setBounds(72, 346, 283, 20);
		ventanaCambiarDatos.getContentPane().add(lblTelefono);
	}

	public void addLblNtarjeta() {
		lblNtarjeta.setBounds(72, 172, 283, 20);
		ventanaCambiarDatos.getContentPane().add(lblNtarjeta);
	}

	public void addLblApellidos() {
		lblApellidos.setBounds(72, 114, 283, 20);
		ventanaCambiarDatos.getContentPane().add(lblApellidos);
	}

	public void addLblNombre() {
		lblNombre.setBounds(72, 56, 283, 20);
		ventanaCambiarDatos.getContentPane().add(lblNombre);
	}
	
	public static void propiedadesServidorEmail() {

		String puerto = "587";
		
		propiedadesEmail = System.getProperties();
		propiedadesEmail.put("mail.smtp.port", puerto);
		propiedadesEmail.put("mail.smtp.auth", "true");
		propiedadesEmail.put("mail.smtp.starttls.enable", "true");

	}
	
	public static void crearMensajeEmail() throws AddressException, MessagingException {
		
		String[] destinatario = { "rodrigocuberolozano@escolapiosdegetafe.es" };

		for (int i = 0; i < destinatario.length; i++) {
			System.out.println(destinatario[i]);
		}
		
		String asunto = "Correo de verificación";
		String texto = "Has completado la verificación de usuario para ESCOLAPInversions.";

		sesionEmail = Session.getDefaultInstance(propiedadesEmail, null);
		mensajeEmail = new MimeMessage(sesionEmail);

		for (int i = 0; i < destinatario.length; i++) {
			mensajeEmail.addRecipient(Message.RecipientType.TO, new InternetAddress(destinatario[i]));
		}

		mensajeEmail.setSubject(asunto);
		mensajeEmail.setContent(texto, "text/html");
	}
	
	public static void enviarEmail() throws AddressException, MessagingException {

		String host = "smtp.gmail.com";
		
		String remitente = "rodrigocuberolozano@escolapiosdegetafe.es";
		String contrasena = "Poli&CataEscolapios";	
		
		Transport transport = sesionEmail.getTransport("smtp");

		transport.connect(host, remitente, contrasena);
		transport.sendMessage(mensajeEmail, mensajeEmail.getAllRecipients());
		transport.close();
		System.out.println("Email enviado de forma satisfactoria.");
	}

}
