package inversiones;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.Color;

public class Principal {

	private JFrame ventanaPrincipal;
	private JLabel lblUsuario;
	private JButton btnVender, btnComprar;
	private JPanel panel_1;
	private JMenuBar menuBar;
	private JMenu menuOpciones;
	private JMenuItem btnDatosPersonales, btnMovimientos, btnSaldo, btnCerrarSesion;
	private String nombreGuardado;

	
	public Principal(String nombreGuardado) {
		initialize();
		this.nombreGuardado = nombreGuardado;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		ventanaPrincipal = new JFrame();
		addVentana();
		
		lblUsuario = new JLabel("Usuario");
		addLblUsuario();
		
		btnVender = new JButton("");
		addBtnVender();
		btnVender.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
		       // Vender vender = new Vender();
		      //  vender.main(null);
		        ventanaPrincipal.setVisible(false);
			}
		});
		
		btnComprar = new JButton("");
		addBtnComprar();
		btnComprar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
		       // Comprar comprar = new Comprar();
		        //comprar.main(null);
		        ventanaPrincipal.setVisible(false);
			}
		});		
		
		panel_1 = new JPanel();
		panel_1.setBounds(195, 70, 327, 268);
		ventanaPrincipal.getContentPane().add(panel_1);
		
		menuBar = new JMenuBar();
		menuBar.setBackground(Color.WHITE);
		menuBar.setBounds(10, 36, 70, 60);
		ventanaPrincipal.getContentPane().add(menuBar);
		
		menuOpciones = new JMenu("");
		menuOpciones.setIcon(new ImageIcon(".//recursos/icon_user.png"));
		menuBar.add(menuOpciones);
		
		btnDatosPersonales = new JMenuItem("Datos personales");
		addBtnDatosPersonales();
		btnDatosPersonales.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
		        new DatosPersonales(nombreGuardado);
		        ventanaPrincipal.setVisible(false);
			}
		});
		
		btnMovimientos = new JMenuItem("Movimientos");
		addBtnMovimientos();
		btnMovimientos.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
		      //  Movimientos movimientos = new Movimientos();
		      
		        ventanaPrincipal.setVisible(false);
			}
		});
		
		btnSaldo = new JMenuItem("Saldo");
		addBtnSaldo();
		btnSaldo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
		      //  Saldo saldo = new Saldo();
		   
		        ventanaPrincipal.setVisible(false);
			}
		});
		
		btnCerrarSesion = new JMenuItem("Cerrar sesi�n");
		addBtnCerrarSesion();
		btnCerrarSesion.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
		        new InicioSesion();
		   
		        ventanaPrincipal.setVisible(false);
			}
		});
		ventanaPrincipal.setVisible(true);

	}

	private void addBtnCerrarSesion() {
		btnCerrarSesion.setIcon(new ImageIcon(".//recursos/icon_sign-out.png"));
		btnCerrarSesion.setBackground(Color.WHITE);
		menuOpciones.add(btnCerrarSesion);
	}

	private void addBtnSaldo() {
		btnSaldo.setIcon(new ImageIcon(".//recursos/icon_credit-card.png"));
		btnSaldo.setBackground(Color.WHITE);
		menuOpciones.add(btnSaldo);
	}

	private void addBtnMovimientos() {
		btnMovimientos.setIcon(new ImageIcon(".//recursos/icon_exchange.png"));
		btnMovimientos.setBackground(Color.WHITE);
		menuOpciones.add(btnMovimientos);
	}

	private void addBtnDatosPersonales() {
		btnDatosPersonales.setBackground(Color.WHITE);
		btnDatosPersonales.setIcon(new ImageIcon(".//recursos/icon_book.png"));
		menuOpciones.add(btnDatosPersonales);
	}

	public void addVentana() {
		ventanaPrincipal.getContentPane().setBackground(Color.WHITE);
		ventanaPrincipal.setTitle("Principal");
		ventanaPrincipal.setBounds(100, 100, 740, 430);
		ventanaPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventanaPrincipal.getContentPane().setLayout(null);
	}

	public void addBtnComprar() {
		btnComprar.setIcon(new ImageIcon(".//recursos/Comprar.png"));
		btnComprar.setBackground(Color.WHITE);
		btnComprar.setBounds(549, 113, 142, 47);
		btnComprar.setBorder(null);
		ventanaPrincipal.getContentPane().add(btnComprar);
	}

	public void addBtnVender() {
		btnVender.setIcon(new ImageIcon(".//recursos/Vender.png"));
		btnVender.setBounds(549, 232, 142, 46);
		btnVender.setBorder(null);
		ventanaPrincipal.getContentPane().add(btnVender);
	}

	public void addLblUsuario() {
		lblUsuario.setBounds(10, 11, 60, 14);
		ventanaPrincipal.getContentPane().add(lblUsuario);
	}
}