package inversiones;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import java.awt.*;

public class Principal {

	private JFrame ventanaPrincipal;
	private JLabel lblUsuario;
	private JButton btnVender, btnComprar;
	private JMenuBar menuBar;
	private JMenu menuOpciones;
	private JMenuItem btnDatosPersonales, btnMovimientos, btnSaldo, btnCerrarSesion;
	private JScrollPane scrollPane;
	private JPanel panelEmpresas;
	private GridBagLayout gbl_panel;
	private JButton btnAmazon, btnApple, btnFacebook, btnGoogle, btnLinkedin, btnTwitch, btnMicrosoft, btnGit, btnPaypal;
	private GridBagConstraints gbc_btnAmazon, gbc_btnApple, gbc_btnFacebook, gbc_btnGoogle, gbc_btnLinkedin, gbc_btnTwitch, gbc_btnMicrosoft, gbc_btnGit, gbc_btnPaypal;
	private String nombreGuardado, empresaSeleccionada = "ninguna";

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
		this.nombreGuardado = nombreGuardado;		
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
				if (empresaSeleccionada.equals("ninguna")) {
					JOptionPane.showMessageDialog(btnVender, "Selecciona una empresa", "Error", 0, null);
				} else {
			        Vender vender = new Vender(nombreGuardado, empresaSeleccionada);
			        vender.main(null);
			        ventanaPrincipal.setVisible(false);
				}
			}
		});
		
		btnComprar = new JButton("");
		addBtnComprar();
		btnComprar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (empresaSeleccionada.equals("ninguna")) {
					JOptionPane.showMessageDialog(btnVender, "Selecciona una empresa", "Error", 0, null);
				} else {
			        Comprar comprar = new Comprar(nombreGuardado, empresaSeleccionada);
			        comprar.main(null);
			        ventanaPrincipal.setVisible(false);
				}
			}
		});
		
		menuBar = new JMenuBar();
		
		menuOpciones = new JMenu("");
		
		addMenuBar();
		
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
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(159, 65, 230, 250);
		ventanaPrincipal.getContentPane().add(scrollPane);
		
		panelEmpresas = new JPanel();
		panelEmpresas.setBackground(Color.WHITE);
		addPanelEmpresas();
		
		btnAmazon = new JButton("");
		addBtnAmazon();
		btnAmazon.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
		        Empresa empresa = new Empresa("amazon");
				empresaSeleccionada = String.valueOf(empresa.getNombreEmpresa());
			}
		});
		
		btnApple = new JButton("");
		addBtnApple();
		btnApple.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
		        Empresa empresa = new Empresa("apple");
				empresaSeleccionada = String.valueOf(empresa.getNombreEmpresa());
			}
		});
		
		btnFacebook = new JButton("");
		addBtnFacebook();
		btnFacebook.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
		        Empresa empresa = new Empresa("facebook");
				empresaSeleccionada = String.valueOf(empresa.getNombreEmpresa());
			}
		});
		
		btnGoogle = new JButton("");
		addBtnGoogle();
		btnGoogle.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
		        Empresa empresa = new Empresa("google");
				empresaSeleccionada = String.valueOf(empresa.getNombreEmpresa());
			}
		});
		
		btnLinkedin = new JButton("");
		addBtnLinkedin();
		btnLinkedin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
		        Empresa empresa = new Empresa("linkedin");
				empresaSeleccionada = String.valueOf(empresa.getNombreEmpresa());
			}
		});
		
		btnTwitch = new JButton("");
		addBtnTwitch();
		btnTwitch.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
		        Empresa empresa = new Empresa("twitch");
				empresaSeleccionada = String.valueOf(empresa.getNombreEmpresa());
			}
		});
		
		btnMicrosoft = new JButton("");
		addBtnMicrosoft();
		btnMicrosoft.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
		        Empresa empresa = new Empresa("microsoft");
				empresaSeleccionada = String.valueOf(empresa.getNombreEmpresa());
			}
		});
		
		btnGit = new JButton("");
		addBtnGit();
		btnGit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
		        Empresa empresa = new Empresa("git");
				empresaSeleccionada = String.valueOf(empresa.getNombreEmpresa());
			}
		});
		
		btnPaypal = new JButton("");
		addBtnPaypal();
		btnPaypal.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
		        Empresa empresa = new Empresa("paypal");
				empresaSeleccionada = String.valueOf(empresa.getNombreEmpresa());
			}
		});
		
	}

	private void addMenuBar() {
		menuBar.setBackground(Color.WHITE);
		menuBar.setBounds(10, 36, 70, 60);
		ventanaPrincipal.getContentPane().add(menuBar);
		menuOpciones.setIcon(new ImageIcon("C:\\Users\\ro_cl\\Documents\\DAM\\Programaci\u00F3n\\Eclipse\\eclipse-workspace\\2\u00BAdam\\icon_user.png"));
		menuBar.add(menuOpciones);
	}

	private void addBtnPaypal() {
		btnPaypal.setIcon(new ImageIcon("C:\\Users\\ro_cl\\Documents\\DAM\\Programaci\u00F3n\\Eclipse\\eclipse-workspace\\2\u00BAdam\\icon_paypal.png"));
		btnPaypal.setPreferredSize(new Dimension(70, 70));
		btnPaypal.setBackground(Color.WHITE);
		gbc_btnPaypal = new GridBagConstraints();
		gbc_btnPaypal.gridx = 2;
		gbc_btnPaypal.gridy = 2;
		panelEmpresas.add(btnPaypal, gbc_btnPaypal);
	}

	private void addBtnGit() {
		btnGit.setIcon(new ImageIcon("C:\\Users\\ro_cl\\Documents\\DAM\\Programaci\u00F3n\\Eclipse\\eclipse-workspace\\2\u00BAdam\\icon_git.png"));
		btnGit.setPreferredSize(new Dimension(70, 70));
		btnGit.setBackground(Color.WHITE);
		gbc_btnGit = new GridBagConstraints();
		gbc_btnGit.insets = new Insets(0, 0, 0, 5);
		gbc_btnGit.gridx = 1;
		gbc_btnGit.gridy = 2;
		panelEmpresas.add(btnGit, gbc_btnGit);
	}

	private void addBtnMicrosoft() {
		btnMicrosoft.setIcon(new ImageIcon("C:\\Users\\ro_cl\\Documents\\DAM\\Programaci\u00F3n\\Eclipse\\eclipse-workspace\\2\u00BAdam\\icon_windows.png"));
		btnMicrosoft.setPreferredSize(new Dimension(70, 70));
		btnMicrosoft.setBackground(Color.WHITE);
		gbc_btnMicrosoft = new GridBagConstraints();
		gbc_btnMicrosoft.insets = new Insets(0, 0, 0, 5);
		gbc_btnMicrosoft.gridx = 0;
		gbc_btnMicrosoft.gridy = 2;
		panelEmpresas.add(btnMicrosoft, gbc_btnMicrosoft);
	}

	private void addBtnTwitch() {
		btnTwitch.setIcon(new ImageIcon("C:\\Users\\ro_cl\\Documents\\DAM\\Programaci\u00F3n\\Eclipse\\eclipse-workspace\\2\u00BAdam\\icon_twitch.png"));
		btnTwitch.setPreferredSize(new Dimension(70, 70));
		btnTwitch.setBackground(Color.WHITE);
		gbc_btnTwitch = new GridBagConstraints();
		gbc_btnTwitch.insets = new Insets(0, 0, 5, 0);
		gbc_btnTwitch.gridx = 2;
		gbc_btnTwitch.gridy = 1;
		panelEmpresas.add(btnTwitch, gbc_btnTwitch);
	}

	private void addBtnLinkedin() {
		btnLinkedin.setIcon(new ImageIcon("C:\\Users\\ro_cl\\Documents\\DAM\\Programaci\u00F3n\\Eclipse\\eclipse-workspace\\2\u00BAdam\\icon_linkedin-square.png"));
		btnLinkedin.setPreferredSize(new Dimension(70, 70));
		btnLinkedin.setBackground(Color.WHITE);
		gbc_btnLinkedin = new GridBagConstraints();
		gbc_btnLinkedin.insets = new Insets(0, 0, 5, 5);
		gbc_btnLinkedin.gridx = 1;
		gbc_btnLinkedin.gridy = 1;
		panelEmpresas.add(btnLinkedin, gbc_btnLinkedin);
	}

	private void addBtnGoogle() {
		btnGoogle.setIcon(new ImageIcon("C:\\Users\\ro_cl\\Documents\\DAM\\Programaci\u00F3n\\Eclipse\\eclipse-workspace\\2\u00BAdam\\icon_google.png"));
		btnGoogle.setPreferredSize(new Dimension(70, 70));
		btnGoogle.setBackground(Color.WHITE);
		gbc_btnGoogle = new GridBagConstraints();
		gbc_btnGoogle.insets = new Insets(0, 0, 5, 5);
		gbc_btnGoogle.gridx = 0;
		gbc_btnGoogle.gridy = 1;
		panelEmpresas.add(btnGoogle, gbc_btnGoogle);
	}

	private void addBtnFacebook() {
		btnFacebook.setIcon(new ImageIcon("C:\\Users\\ro_cl\\Documents\\DAM\\Programaci\u00F3n\\Eclipse\\eclipse-workspace\\2\u00BAdam\\icon_facebook-official.png"));
		btnFacebook.setPreferredSize(new Dimension(70, 70));
		btnFacebook.setBackground(Color.WHITE);
		gbc_btnFacebook = new GridBagConstraints();
		gbc_btnFacebook.insets = new Insets(0, 0, 5, 0);
		gbc_btnFacebook.gridx = 2;
		gbc_btnFacebook.gridy = 0;
		panelEmpresas.add(btnFacebook, gbc_btnFacebook);
	}

	private void addBtnApple() {
		btnApple.setIcon(new ImageIcon("C:\\Users\\ro_cl\\Documents\\DAM\\Programaci\u00F3n\\Eclipse\\eclipse-workspace\\2\u00BAdam\\icon_apple.png"));
		btnApple.setPreferredSize(new Dimension(70, 70));
		btnApple.setBackground(Color.WHITE);
		gbc_btnApple = new GridBagConstraints();
		gbc_btnApple.insets = new Insets(0, 0, 5, 5);
		gbc_btnApple.gridx = 1;
		gbc_btnApple.gridy = 0;
		panelEmpresas.add(btnApple, gbc_btnApple);
	}

	private void addBtnAmazon() {
		btnAmazon.setIcon(new ImageIcon("C:\\Users\\ro_cl\\Documents\\DAM\\Programaci\u00F3n\\Eclipse\\eclipse-workspace\\2\u00BAdam\\icon_amazon.png"));
		btnAmazon.setPreferredSize(new Dimension(70, 70));
		btnAmazon.setBackground(Color.WHITE);
		gbc_btnAmazon = new GridBagConstraints();
		gbc_btnAmazon.insets = new Insets(0, 0, 5, 5);
		gbc_btnAmazon.gridx = 0;
		gbc_btnAmazon.gridy = 0;
		panelEmpresas.add(btnAmazon, gbc_btnAmazon);
	}

	private void addPanelEmpresas() {
		scrollPane.setViewportView(panelEmpresas);
		gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		panelEmpresas.setLayout(gbl_panel);
	}

	private void addBtnCerrarSesion() {
		btnCerrarSesion.setIcon(new ImageIcon("C:\\Users\\ro_cl\\Documents\\DAM\\Programaci\u00F3n\\Eclipse\\eclipse-workspace\\2\u00BAdam\\icon_sign-out.png"));
		btnCerrarSesion.setBackground(Color.WHITE);
		menuOpciones.add(btnCerrarSesion);
	}

	private void addBtnSaldo() {
		btnSaldo.setIcon(new ImageIcon("C:\\Users\\ro_cl\\Documents\\DAM\\Programaci\u00F3n\\Eclipse\\eclipse-workspace\\2\u00BAdam\\icon_credit-card.png"));
		btnSaldo.setBackground(Color.WHITE);
		menuOpciones.add(btnSaldo);
	}

	private void addBtnMovimientos() {
		btnMovimientos.setIcon(new ImageIcon("C:\\Users\\ro_cl\\Documents\\DAM\\Programaci\u00F3n\\Eclipse\\eclipse-workspace\\2\u00BAdam\\icon_exchange.png"));
		btnMovimientos.setBackground(Color.WHITE);
		menuOpciones.add(btnMovimientos);
	}

	private void addBtnDatosPersonales() {
		btnDatosPersonales.setBackground(Color.WHITE);
		btnDatosPersonales.setIcon(new ImageIcon("C:\\Users\\ro_cl\\Documents\\DAM\\Programaci\u00F3n\\Eclipse\\eclipse-workspace\\2\u00BAdam\\icon_book.png"));
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
		btnComprar.setIcon(new ImageIcon("C:\\Users\\ro_cl\\Documents\\DAM\\Programaci\u00F3n\\Eclipse\\eclipse-workspace\\2\u00BAdam\\Comprar.png"));
		btnComprar.setBackground(Color.WHITE);
		btnComprar.setBounds(549, 113, 142, 47);
		btnComprar.setBorder(null);
		ventanaPrincipal.getContentPane().add(btnComprar);
	}

	public void addBtnVender() {
		btnVender.setIcon(new ImageIcon("C:\\Users\\ro_cl\\Documents\\DAM\\Programaci\u00F3n\\Eclipse\\eclipse-workspace\\2\u00BAdam\\Vender.png"));
		btnVender.setBackground(Color.WHITE);
		btnVender.setBounds(549, 232, 142, 46);
		btnVender.setBorder(null);
		ventanaPrincipal.getContentPane().add(btnVender);
	}

	public void addLblUsuario() {
		lblUsuario.setBounds(10, 11, 60, 14);
		ventanaPrincipal.getContentPane().add(lblUsuario);
	}
}
