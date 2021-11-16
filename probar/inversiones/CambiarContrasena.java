package inversiones;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.Color;

public class CambiarContrasena {

	private JFrame ventanaCambiarContrasena;
	private JTextField textContrasena, textConfirmar;
	private JLabel lblContrasena, lblConfirmar;
	private JButton btnCambiarContrasena, btnRetroceder;
	public String nombreGuardado;

	
	public CambiarContrasena(String nombreGuardado) {
		initialize();
		this.nombreGuardado = nombreGuardado;
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		ventanaCambiarContrasena = new JFrame();
		addVentana();
		
		lblContrasena = new JLabel("Contrase\u00F1a");
		addLblContrasena();
		
		textContrasena = new JTextField();
		addTextContrasena();
		
		lblConfirmar = new JLabel("Confirma contrase\u00F1a");
		addLblConfirmar();
		
		textConfirmar = new JTextField();
		addTextConfirmar();
		
		btnCambiarContrasena = new JButton("");
		addBtnCambiarContrasena();
		
		btnRetroceder = new JButton("");
		addBtnRetroceder();
		btnRetroceder.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
		        new DatosPersonales(nombreGuardado);
		       
		        ventanaCambiarContrasena.setVisible(false);
			}
		});
		ventanaCambiarContrasena.setVisible(true);
	}

	public void addVentana() {
		ventanaCambiarContrasena.getContentPane().setBackground(Color.WHITE);
		ventanaCambiarContrasena.setTitle("Cambiar contrase\u00F1a");
		ventanaCambiarContrasena.setBounds(100, 100, 450, 335);
		ventanaCambiarContrasena.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventanaCambiarContrasena.getContentPane().setLayout(null);
	}

	public void addBtnRetroceder() {
		btnRetroceder.setIcon(new ImageIcon(".//recursos/Retroceder.png"));
		btnRetroceder.setBackground(Color.WHITE);
		btnRetroceder.setBounds(10, 11, 136, 33);
		ventanaCambiarContrasena.getContentPane().add(btnRetroceder);
	}

	public void addBtnCambiarContrasena() {
		btnCambiarContrasena.setIcon(new ImageIcon(".//recursos/Cambiar contrase\u00F1a.png"));
		btnCambiarContrasena.setBackground(Color.WHITE);
		btnCambiarContrasena.setBounds(110, 213, 210, 44);
		btnCambiarContrasena.setBorder(null);
		ventanaCambiarContrasena.getContentPane().add(btnCambiarContrasena);
	}

	public void addTextConfirmar() {
		textConfirmar.setBounds(72, 152, 283, 20);
		textConfirmar.setColumns(10);
		ventanaCambiarContrasena.getContentPane().add(textConfirmar);
	}

	public void addLblConfirmar() {
		lblConfirmar.setBounds(72, 132, 150, 14);
		ventanaCambiarContrasena.getContentPane().add(lblConfirmar);
	}

	public void addTextContrasena() {
		textContrasena.setBounds(72, 94, 283, 20);
		textContrasena.setColumns(10);
		ventanaCambiarContrasena.getContentPane().add(textContrasena);
	}

	public void addLblContrasena() {
		lblContrasena.setBounds(72, 74, 155, 14);
		ventanaCambiarContrasena.getContentPane().add(lblContrasena);
	}
	
	public void addLabel(JLabel label, int x, int y, int w, int h) {
		label.setBounds(x, y, w, h);
		ventanaCambiarContrasena.getContentPane().add(label);
	}
	
}