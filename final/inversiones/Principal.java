package inversiones;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.*;

import actualizadorAcciones.Empresa;
import tratadoDatos.ConexionEmpresas;
import tratadoDatos.ConexionUsuarios;

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
	private String nombreGuardado;
	private Empresas empresaSelecionada;
	private JTextArea textValor;
	private JLabel lblValor;
	private ConexionEmpresas conexionEmpresas;
	private ConexionUsuarios conexionUsuarios;


	public Principal(String nombreGuardado) {
		this.nombreGuardado = nombreGuardado;
		try {
			conexionEmpresas = new ConexionEmpresas();
			conexionUsuarios = new ConexionUsuarios();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		initialize();
		ventanaPrincipal.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		ventanaPrincipal = new JFrame();
		addVentana();
		
		lblUsuario = new JLabel(nombreGuardado);
		lblUsuario.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		addLblUsuario();
		
		lblValor = new JLabel("Valor actual");
		addLblValor();
		
		textValor = new JTextArea();
		addTextValor();
		
		btnVender = new JButton("");
		addBtnVender();
		btnVender.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					if((conexionUsuarios.getValidado(nombreGuardado) == 0)) {
						JOptionPane.showMessageDialog(btnVender, "Aún no has validado tu usuario", "Error de validación", 2, null);
					} else {
						if (empresaSelecionada  ==null) {
							JOptionPane.showMessageDialog(btnVender, "Selecciona una empresa", "Error", 0, null);
						} else {
					        new Vender(nombreGuardado, empresaSelecionada);
					        ventanaPrincipal.setVisible(false);
						}
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		btnComprar = new JButton("");
		addBtnComprar();
		btnComprar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					if((conexionUsuarios.getValidado(nombreGuardado) == 0)) {
						JOptionPane.showMessageDialog(btnVender, "Aún no has validado a tu usuario", "Error de validación", 2, null);
					} else {
						if (empresaSelecionada  ==null) {
							JOptionPane.showMessageDialog(btnVender, "Selecciona una empresa", "Error", 0, null);
						} else {
					        new Comprar(nombreGuardado, empresaSelecionada);			       
					        ventanaPrincipal.setVisible(false);
						}
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				

			}
		});
		
		menuBar = new JMenuBar();
		
		menuOpciones = new JMenu("");
		
		addMenuBar();
		
		btnDatosPersonales = new JMenuItem("Datos personales");
		btnDatosPersonales.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		addBtnDatosPersonales();
		btnDatosPersonales.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
		        new DatosPersonales(nombreGuardado);
		  
		        ventanaPrincipal.setVisible(false);
			}
		});
		
		btnMovimientos = new JMenuItem("Movimientos");
		btnMovimientos.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		addBtnMovimientos();
		btnMovimientos.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
		        try {
					new Movimientos(nombreGuardado);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
		        ventanaPrincipal.setVisible(false);
			}
		});
		
		btnSaldo = new JMenuItem("Saldo");
		btnSaldo.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		addBtnSaldo();
		btnSaldo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
		        new Saldo(nombreGuardado);
		    
		        ventanaPrincipal.setVisible(false);
			}
		});
		
		btnCerrarSesion = new JMenuItem("Cerrar sesión");
		btnCerrarSesion.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		addBtnCerrarSesion();
		btnCerrarSesion.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
		        new InicioSesion();
		   
		        ventanaPrincipal.setVisible(false);
			}
		});
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(226, 57, 240, 200);
		ventanaPrincipal.getContentPane().add(scrollPane);
		
		panelEmpresas = new JPanel();
		panelEmpresas.setBackground(Color.WHITE);
		addPanelEmpresas();
		
		btnAmazon = new JButton("");
		addBtnAmazon();
		btnAmazon.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				empresaSelecionada= Empresas.Amazon;
				double valorAcciones;
				try {
					valorAcciones = conexionEmpresas.getValorAccion("Amazon");
					textValor.setText(valorAcciones+"€");
					lblValor.setText("Valor actual de Amazon");
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		btnApple = new JButton("");
		addBtnApple();
		btnApple.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				empresaSelecionada= Empresas.Apple;
				double valorAcciones;
				try {
					valorAcciones = conexionEmpresas.getValorAccion("Apple");
					textValor.setText(valorAcciones+"€");
					lblValor.setText("Valor actual de Apple");
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		btnFacebook = new JButton("");
		addBtnFacebook();
		btnFacebook.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				empresaSelecionada= Empresas.Facebook;
				double valorAcciones;
				try {
					valorAcciones = conexionEmpresas.getValorAccion("Facebook");
					textValor.setText(valorAcciones+"€");
					lblValor.setText("Valor actual de Facebook");
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		btnGoogle = new JButton("");
		addBtnGoogle();
		btnGoogle.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				empresaSelecionada= Empresas.Google;
				double valorAcciones;
				try {
					valorAcciones = conexionEmpresas.getValorAccion("Google");
					textValor.setText(valorAcciones+"€");
					lblValor.setText("Valor actual de Google");
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		btnLinkedin = new JButton("");
		addBtnLinkedin();
		btnLinkedin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				empresaSelecionada= Empresas.Linkedin;
				double valorAcciones;
				try {
					valorAcciones = conexionEmpresas.getValorAccion("Linkedin");
					textValor.setText(valorAcciones+"€");
					lblValor.setText("Valor actual de Linkedin");
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		btnTwitch = new JButton("");
		addBtnTwitch();
		btnTwitch.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				empresaSelecionada= Empresas.Twitch;
				double valorAcciones;
				try {
					valorAcciones = conexionEmpresas.getValorAccion("Twitch");
					textValor.setText(valorAcciones+"€");
					lblValor.setText("Valor actual de Twitch");
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		btnMicrosoft = new JButton("");
		addBtnMicrosoft();
		btnMicrosoft.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				empresaSelecionada= Empresas.Microsoft;
				double valorAcciones;
				try {
					valorAcciones = conexionEmpresas.getValorAccion("Microsoft");
					textValor.setText(valorAcciones+"€");
					lblValor.setText("Valor actual de Microsoft");
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		btnGit = new JButton("");
		addBtnGit();
		btnGit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				empresaSelecionada= Empresas.Git;
				double valorAcciones;
				try {
					valorAcciones = conexionEmpresas.getValorAccion("GitHub");
					textValor.setText(valorAcciones+"€");
					lblValor.setText("Valor actual de GitHub");
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		btnPaypal = new JButton("");
		addBtnPaypal();
		btnPaypal.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				empresaSelecionada= Empresas.Paypal;
				double valorAcciones;
				try {
					valorAcciones = conexionEmpresas.getValorAccion("Paypal");
					textValor.setText(valorAcciones+"€");
					lblValor.setText("Valor actual de Paypal");
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		
	}

	private void addLblValor() {
		lblValor.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		lblValor.setBounds(241, 302, 225, 20);
		ventanaPrincipal.getContentPane().add(lblValor);
	}

	private void addTextValor() {
		textValor.setFont(new Font("Monospaced", Font.BOLD, 15));
		textValor.setBounds(306, 333, 130, 20);
		ventanaPrincipal.getContentPane().add(textValor);
	}

	private void addMenuBar() {
		menuBar.setBackground(Color.WHITE);
		menuBar.setBounds(10, 36, 70, 60);
		ventanaPrincipal.getContentPane().add(menuBar);
		menuOpciones.setIcon(new ImageIcon("icon_user.png"));
		menuBar.add(menuOpciones);
	}

	private void addBtnPaypal() {
		btnPaypal.setIcon(new ImageIcon("icon_paypal.png"));
		btnPaypal.setPreferredSize(new Dimension(70, 70));
		btnPaypal.setBackground(Color.WHITE);
		gbc_btnPaypal = new GridBagConstraints();
		gbc_btnPaypal.gridx = 2;
		gbc_btnPaypal.gridy = 2;
		panelEmpresas.add(btnPaypal, gbc_btnPaypal);
	}

	private void addBtnGit() {
		btnGit.setIcon(new ImageIcon("icon_git.png"));
		btnGit.setPreferredSize(new Dimension(70, 70));
		btnGit.setBackground(Color.WHITE);
		gbc_btnGit = new GridBagConstraints();
		gbc_btnGit.insets = new Insets(0, 0, 0, 5);
		gbc_btnGit.gridx = 1;
		gbc_btnGit.gridy = 2;
		panelEmpresas.add(btnGit, gbc_btnGit);
	}

	private void addBtnMicrosoft() {
		btnMicrosoft.setIcon(new ImageIcon("icon_windows.png"));
		btnMicrosoft.setPreferredSize(new Dimension(70, 70));
		btnMicrosoft.setBackground(Color.WHITE);
		gbc_btnMicrosoft = new GridBagConstraints();
		gbc_btnMicrosoft.insets = new Insets(0, 0, 0, 5);
		gbc_btnMicrosoft.gridx = 0;
		gbc_btnMicrosoft.gridy = 2;
		panelEmpresas.add(btnMicrosoft, gbc_btnMicrosoft);
	}

	private void addBtnTwitch() {
		btnTwitch.setIcon(new ImageIcon("icon_twitch.png"));
		btnTwitch.setPreferredSize(new Dimension(70, 70));
		btnTwitch.setBackground(Color.WHITE);
		gbc_btnTwitch = new GridBagConstraints();
		gbc_btnTwitch.insets = new Insets(0, 0, 5, 0);
		gbc_btnTwitch.gridx = 2;
		gbc_btnTwitch.gridy = 1;
		panelEmpresas.add(btnTwitch, gbc_btnTwitch);
	}

	private void addBtnLinkedin() {
		btnLinkedin.setIcon(new ImageIcon("icon_linkedin-square.png"));
		btnLinkedin.setPreferredSize(new Dimension(70, 70));
		btnLinkedin.setBackground(Color.WHITE);
		gbc_btnLinkedin = new GridBagConstraints();
		gbc_btnLinkedin.insets = new Insets(0, 0, 5, 5);
		gbc_btnLinkedin.gridx = 1;
		gbc_btnLinkedin.gridy = 1;
		panelEmpresas.add(btnLinkedin, gbc_btnLinkedin);
	}

	private void addBtnGoogle() {
		btnGoogle.setIcon(new ImageIcon("icon_google.png"));
		btnGoogle.setPreferredSize(new Dimension(70, 70));
		btnGoogle.setBackground(Color.WHITE);
		gbc_btnGoogle = new GridBagConstraints();
		gbc_btnGoogle.insets = new Insets(0, 0, 5, 5);
		gbc_btnGoogle.gridx = 0;
		gbc_btnGoogle.gridy = 1;
		panelEmpresas.add(btnGoogle, gbc_btnGoogle);
	}

	private void addBtnFacebook() {
		btnFacebook.setIcon(new ImageIcon("icon_facebook-official.png"));
		btnFacebook.setPreferredSize(new Dimension(70, 70));
		btnFacebook.setBackground(Color.WHITE);
		gbc_btnFacebook = new GridBagConstraints();
		gbc_btnFacebook.insets = new Insets(0, 0, 5, 0);
		gbc_btnFacebook.gridx = 2;
		gbc_btnFacebook.gridy = 0;
		panelEmpresas.add(btnFacebook, gbc_btnFacebook);
	}

	private void addBtnApple() {
		btnApple.setIcon(new ImageIcon("icon_apple.png"));
		btnApple.setPreferredSize(new Dimension(70, 70));
		btnApple.setBackground(Color.WHITE);
		gbc_btnApple = new GridBagConstraints();
		gbc_btnApple.insets = new Insets(0, 0, 5, 5);
		gbc_btnApple.gridx = 1;
		gbc_btnApple.gridy = 0;
		panelEmpresas.add(btnApple, gbc_btnApple);
	}

	private void addBtnAmazon() {
		btnAmazon.setIcon(new ImageIcon("icon_amazon.png"));
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
		btnCerrarSesion.setIcon(new ImageIcon("icon_sign-out.png"));
		btnCerrarSesion.setBackground(Color.WHITE);
		menuOpciones.add(btnCerrarSesion);
	}

	private void addBtnSaldo() {
		btnSaldo.setIcon(new ImageIcon("icon_credit-card.png"));
		btnSaldo.setBackground(Color.WHITE);
		menuOpciones.add(btnSaldo);
	}

	private void addBtnMovimientos() {
		btnMovimientos.setIcon(new ImageIcon("icon_exchange.png"));
		btnMovimientos.setBackground(Color.WHITE);
		menuOpciones.add(btnMovimientos);
	}

	private void addBtnDatosPersonales() {
		btnDatosPersonales.setBackground(Color.WHITE);
		btnDatosPersonales.setIcon(new ImageIcon("icon_book.png"));
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
		btnComprar.setIcon(new ImageIcon("Comprar.png"));
		btnComprar.setBackground(Color.WHITE);
		btnComprar.setBounds(549, 113, 142, 47);
		btnComprar.setBorder(null);
		ventanaPrincipal.getContentPane().add(btnComprar);
	}

	public void addBtnVender() {
		btnVender.setIcon(new ImageIcon("Vender.png"));
		btnVender.setBackground(Color.WHITE);
		btnVender.setBounds(549, 232, 142, 46);
		btnVender.setBorder(null);
		ventanaPrincipal.getContentPane().add(btnVender);
	}

	public void addLblUsuario() {
		lblUsuario.setBounds(10, 11, 100, 20);
		ventanaPrincipal.getContentPane().add(lblUsuario);
	}
}
