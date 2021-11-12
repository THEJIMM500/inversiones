package inversiones;

import java.awt.EventQueue;
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

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal window = new Principal(null);
					window.ventanaPrincipal.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
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
		        Vender vender = new Vender();
		        vender.main(null);
		        ventanaPrincipal.setVisible(false);
			}
		});
		
		btnComprar = new JButton("");
		addBtnComprar();
		btnComprar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
		        Comprar comprar = new Comprar();
		        comprar.main(null);
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
		menuOpciones.setIcon(new ImageIcon("C:\\Users\\ro_cl\\Downloads\\icon_user.png"));
		menuBar.add(menuOpciones);
		
		btnDatosPersonales = new JMenuItem("Datos personales");
		addBtnDatosPersonales();
		btnDatosPersonales.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
		        DatosPersonales datos = new DatosPersonales();
		        datos.main(null);
		        ventanaPrincipal.setVisible(false);
			}
		});
		
		btnMovimientos = new JMenuItem("Movimientos");
		addBtnMovimientos();
		btnMovimientos.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
		        Movimientos movimientos = new Movimientos();
		        movimientos.main(null);
		        ventanaPrincipal.setVisible(false);
			}
		});
		
		btnSaldo = new JMenuItem("Saldo");
		addBtnSaldo();
		btnSaldo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
		        Saldo saldo = new Saldo();
		        saldo.main(null);
		        ventanaPrincipal.setVisible(false);
			}
		});
		
		btnCerrarSesion = new JMenuItem("Cerrar sesión");
		addBtnCerrarSesion();
		btnCerrarSesion.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
		        InicioSesion inicio = new InicioSesion();
		        inicio.main(null);
		        ventanaPrincipal.setVisible(false);
			}
		});

	}

	private void addBtnCerrarSesion() {
		btnCerrarSesion.setIcon(new ImageIcon("C:\\Users\\ro_cl\\Downloads\\icon_sign-out.png"));
		btnCerrarSesion.setBackground(Color.WHITE);
		menuOpciones.add(btnCerrarSesion);
	}

	private void addBtnSaldo() {
		btnSaldo.setIcon(new ImageIcon("C:\\Users\\ro_cl\\Downloads\\icon_credit-card.png"));
		btnSaldo.setBackground(Color.WHITE);
		menuOpciones.add(btnSaldo);
	}

	private void addBtnMovimientos() {
		btnMovimientos.setIcon(new ImageIcon("C:\\Users\\ro_cl\\Downloads\\icon_exchange.png"));
		btnMovimientos.setBackground(Color.WHITE);
		menuOpciones.add(btnMovimientos);
	}

	private void addBtnDatosPersonales() {
		btnDatosPersonales.setBackground(Color.WHITE);
		btnDatosPersonales.setIcon(new ImageIcon("C:\\Users\\ro_cl\\Downloads\\icon_book.png"));
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
		btnComprar.setIcon(new ImageIcon("C:\\Users\\ro_cl\\Downloads\\Comprar.png"));
		btnComprar.setBackground(Color.WHITE);
		btnComprar.setBounds(549, 113, 142, 47);
		btnComprar.setBorder(null);
		ventanaPrincipal.getContentPane().add(btnComprar);
	}

	public void addBtnVender() {
		btnVender.setIcon(new ImageIcon("C:\\Users\\ro_cl\\Downloads\\Vender.png"));
		btnVender.setBounds(549, 232, 142, 46);
		btnVender.setBorder(null);
		ventanaPrincipal.getContentPane().add(btnVender);
	}

	public void addLblUsuario() {
		lblUsuario.setBounds(10, 11, 60, 14);
		ventanaPrincipal.getContentPane().add(lblUsuario);
	}
}
