package inversiones;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.sql.SQLException;

import javax.swing.*;

import tratadoDatos.ConexionUsuarios;

import java.awt.Component;
import java.awt.Desktop;
import java.awt.Color;
import java.awt.Font;

public class InicioCAT {

	private JFrame ventanaCAT;
	private JTextField textUsuario;
	private JPasswordField passwordContrasena;
	private ConexionUsuarios conexion;
	private JLabel lblTitulo, lblUsuario, lblContrasena;
	private JButton btnInicio;
	private String nombreGuardado;


	public InicioCAT() {
		try {
			conexion = new ConexionUsuarios();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		initialize();
		ventanaCAT.setVisible(true);
		
	}


	private void initialize() {
		ventanaCAT = new JFrame();
		addVentana();
		
		lblTitulo = new JLabel("Soporte CAT");
		lblTitulo.setFont(new Font("Gabriola", Font.BOLD, 41));
		addLblTitulo();
		
		lblUsuario = new JLabel("Administrador");
		lblUsuario.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		addLblUsuario();
		
		lblContrasena = new JLabel("Contrase\u00F1a");
		lblContrasena.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		addLblContrasena();
		
		textUsuario = new JTextField();
		addTextUsuario();
		
		passwordContrasena = new JPasswordField();
		addTextContrasena();
		addBtnEnlace();
		
		btnInicio = new JButton("");
		addBtnInicio();
		btnInicio.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					if ((conexion.iniciarSesion(textUsuario.getText(), passwordContrasena.getText()) == 0) && (textUsuario.getText().equals("admin"))) {
					    
						String url = "http://localhost/phpmyadmin/index.php";
						Desktop.getDesktop().browse(URI.create(url));	
					    
					} else if(conexion.iniciarSesion(textUsuario.getText(), passwordContrasena.getText()) == 1){
						JOptionPane.showMessageDialog(btnInicio, "Las credenciales no coinciden", "Error", 2, null);
					} else if(conexion.iniciarSesion(textUsuario.getText(), passwordContrasena.getText()) ==-1) {
						JOptionPane.showMessageDialog(btnInicio, "El usuario no existe", "Error", 2, null);
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		addBtnRegistro();
	}

	private void addBtnEnlace() {
	}

	public void addVentana() {
		ventanaCAT.getContentPane().setBackground(Color.WHITE);
		ventanaCAT.setTitle("Servicio CAT");
		ventanaCAT.setBounds(100, 100, 740, 430);
		ventanaCAT.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventanaCAT.getContentPane().setLayout(null);
	}

	public void addBtnRegistro() {
	}

	public void addBtnInicio() {
		btnInicio.setBackground(Color.WHITE);
		btnInicio.setIcon(new ImageIcon("Iniciar sesion.png"));
		btnInicio.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnInicio.setBounds(260, 250, 150, 45);
		btnInicio.setBorder(null);
		ventanaCAT.getContentPane().add(btnInicio);
	}

	public void addTextContrasena() {
		passwordContrasena.setBounds(352, 174, 116, 20);
		ventanaCAT.getContentPane().add(passwordContrasena);
	}

	public void addTextUsuario() {
		textUsuario.setBounds(352, 129, 116, 20);
		ventanaCAT.getContentPane().add(textUsuario);
		textUsuario.setColumns(10);
	}

	public void addLblContrasena() {
		lblContrasena.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblContrasena.setBounds(214, 172, 128, 20);
		ventanaCAT.getContentPane().add(lblContrasena);
	}

	public void addLblUsuario() {
		lblUsuario.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblUsuario.setBounds(214, 127, 128, 20);
		ventanaCAT.getContentPane().add(lblUsuario);
	}

	public void addLblTitulo() {
		lblTitulo.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblTitulo.setBounds(260, 27, 190, 70);
		ventanaCAT.getContentPane().add(lblTitulo);
	}
	
	public void addLabel(JLabel label, int x, int y, int w, int h) {
		label.setAlignmentX(Component.CENTER_ALIGNMENT);
		label.setBounds(x, y, w, h);
		ventanaCAT.getContentPane().add(label);
	}
	
}
