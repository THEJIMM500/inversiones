package inversiones;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

public class Principal {

	private JFrame ventanaPrincipal;
	private JLabel lblUsuario;
	private JButton btnVender, btnComprar, btnDatosPersonales, btnMovimientos, btnSaldo, btnCerrarSesion;
	private JPanel panelOpciones;
	private JPanel panel_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal window = new Principal();
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
	public Principal() {
		initialize();
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
		
		panelOpciones = new JPanel();
		addPanelOpciones();
		
		btnDatosPersonales = new JButton("");
		addBtnDatosPersonales();
		btnDatosPersonales.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
		        DatosPersonales datos = new DatosPersonales();
		        datos.main(null);
		        ventanaPrincipal.setVisible(false);
			}
		});
		
		btnMovimientos = new JButton("");
		addBtnMovimientos();
		btnMovimientos.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
		        Movimientos movimientos = new Movimientos();
		        movimientos.main(null);
		        ventanaPrincipal.setVisible(false);
			}
		});
		
		btnSaldo = new JButton("");
		addBtnSaldo();
		btnSaldo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
		        Saldo saldo = new Saldo();
		        saldo.main(null);
		        ventanaPrincipal.setVisible(false);
			}
		});
		
		btnCerrarSesion = new JButton("");
		addBtnCerrarSesion();
		btnCerrarSesion.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
		        InicioSesion inicio = new InicioSesion();
		        inicio.main(null);
		        ventanaPrincipal.setVisible(false);
			}
		});
		
		panel_1 = new JPanel();
		panel_1.setBounds(195, 70, 327, 268);
		ventanaPrincipal.getContentPane().add(panel_1);

	}

	public void addVentana() {
		ventanaPrincipal.getContentPane().setBackground(Color.WHITE);
		ventanaPrincipal.setTitle("Principal");
		ventanaPrincipal.setBounds(100, 100, 740, 430);
		ventanaPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventanaPrincipal.getContentPane().setLayout(null);
	}

	public void addBtnCerrarSesion() {
		btnCerrarSesion.setBackground(Color.WHITE);
		btnCerrarSesion.setIcon(new ImageIcon("C:\\Users\\ro_cl\\Downloads\\icon_sign-out.png"));
		panelOpciones.add(btnCerrarSesion);
	}

	public void addBtnSaldo() {
		btnSaldo.setBackground(Color.WHITE);
		btnSaldo.setIcon(new ImageIcon("C:\\Users\\ro_cl\\Downloads\\icon_credit-card.png"));
		panelOpciones.add(btnSaldo);
	}

	public void addBtnMovimientos() {
		btnMovimientos.setBackground(Color.WHITE);
		btnMovimientos.setIcon(new ImageIcon("C:\\Users\\ro_cl\\Downloads\\icon_exchange.png"));
		panelOpciones.add(btnMovimientos);
	}

	public void addBtnDatosPersonales() {
		btnDatosPersonales.setBackground(Color.WHITE);
		btnDatosPersonales.setIcon(new ImageIcon("C:\\Users\\ro_cl\\Downloads\\icon_book.png"));
		panelOpciones.add(btnDatosPersonales);
	}

	public void addPanelOpciones() {
		panelOpciones.setBackground(Color.WHITE);
		panelOpciones.setBounds(10, 70, 100, 310);
		ventanaPrincipal.getContentPane().add(panelOpciones);
	}

	public void addBtnComprar() {
		btnComprar.setIcon(new ImageIcon("C:\\Users\\ro_cl\\Downloads\\Comprar.png"));
		btnComprar.setBackground(Color.WHITE);
		btnComprar.setBounds(549, 113, 142, 47);
		ventanaPrincipal.getContentPane().add(btnComprar);
	}

	public void addBtnVender() {
		btnVender.setIcon(new ImageIcon("C:\\Users\\ro_cl\\Downloads\\Vender.png"));
		btnVender.setBounds(549, 232, 142, 46);
		ventanaPrincipal.getContentPane().add(btnVender);
	}

	public void addLblUsuario() {
		lblUsuario.setBounds(10, 11, 46, 14);
		ventanaPrincipal.getContentPane().add(lblUsuario);
	}
}
