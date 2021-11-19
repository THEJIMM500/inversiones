package inversiones;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.*;

import tratadoDatos.ConexionUsuarios;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;

public class Saldo {

	private JFrame ventanaSaldo;
	private JTextField textCantidad;
	private JButton btnRetroceder, btnIngresar, btnRetirar;
	private JLabel lblCartera, lblCantidad;
	private JTextArea textSaldo;
	private String nombreGuardado;
	private ConexionUsuarios conexion;




	public Saldo(String nombreGuardado) {
		initialize();
		this.nombreGuardado=nombreGuardado;
		ventanaSaldo.setVisible(true);
		try {
			conexion = new ConexionUsuarios();
			textSaldo.setText(conexion.getSaldo(nombreGuardado)+"€");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	
	private void initialize() {
		ventanaSaldo = new JFrame();
		addVentana();
		
		btnRetroceder = new JButton("");
		btnRetroceder.setBackground(Color.WHITE);
		addBtnRetroceder();
		btnRetroceder.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
		        Principal principal = new Principal(nombreGuardado);
		        ventanaSaldo.setVisible(false);
			}
		});
		
		lblCartera = new JLabel("Cartera");
		lblCartera.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		addLblCartera();
		

		textSaldo = new JTextArea();
		textSaldo.setBackground(SystemColor.menu);
		addTextPaneSaldo();
		
		btnIngresar = new JButton("");
		addBtnIngresar();
		
		btnRetirar = new JButton("");
		addBtnRetirar();
		
		lblCantidad = new JLabel("Cantidad");
		lblCantidad.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		addLblCantidad();
		
		textCantidad = new JTextField();
		textCantidad.setBackground(Color.WHITE);
		addTextCantidad();

	}

	public void addVentana() {
		ventanaSaldo.getContentPane().setBackground(Color.WHITE);
		ventanaSaldo.setTitle("Saldo");
		ventanaSaldo.setBounds(100, 100, 450, 300);
		ventanaSaldo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventanaSaldo.getContentPane().setLayout(null);
	}

	public void addTextCantidad() {
		textCantidad.setBounds(188, 110, 133, 20);
		textCantidad.setColumns(10);
		ventanaSaldo.getContentPane().add(textCantidad);
	}

	public void addLblCantidad() {
		lblCantidad.setBounds(100, 110, 78, 20);
		ventanaSaldo.getContentPane().add(lblCantidad);
	}

	public void addBtnRetirar() {
		btnRetirar.setIcon(new ImageIcon("Retirar saldo.png"));
		btnRetirar.setBackground(Color.WHITE);
		btnRetirar.setBounds(151, 205, 161, 44);
		btnRetirar.setBorder(null);
		btnRetirar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
		      try {
				operar(false);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			}
		});
		ventanaSaldo.getContentPane().add(btnRetirar);
	}

	public void addBtnIngresar() {
		btnIngresar.setBackground(Color.WHITE);
		btnIngresar.setIcon(new ImageIcon("Ingresar saldo.png"));
		btnIngresar.setBounds(151, 164, 160, 44);
		btnIngresar.setBorder(null);
		btnIngresar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
		      try {
				operar(true);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			}
		});
		ventanaSaldo.getContentPane().add(btnIngresar);
	}

	public void addTextPaneSaldo() {
		textSaldo.setBounds(188, 72, 133, 20);
		ventanaSaldo.getContentPane().add(textSaldo);
	}

	public void addLblCartera() {
		lblCartera.setBounds(106, 72, 72, 20);
		ventanaSaldo.getContentPane().add(lblCartera);
	}

	public void addBtnRetroceder() {
		btnRetroceder.setIcon(new ImageIcon("Retroceder.png"));
		btnRetroceder.setBounds(10, 11, 136, 33);
		btnRetroceder.setBorder(null);
		ventanaSaldo.getContentPane().add(btnRetroceder);
	}
	private void operar(boolean ingresa) throws SQLException {
		double saldo=conexion.getSaldo(nombreGuardado);
		double cantidad= Double.parseDouble(textCantidad.getText());
		double nuevoSaldo=saldo;
		if(ingresa==true) {
			nuevoSaldo= saldo+cantidad;
			conexion.setSaldo(nombreGuardado, nuevoSaldo);
		}else {
			if(saldo>=cantidad) {
				nuevoSaldo= saldo-cantidad;
				conexion.setSaldo(nombreGuardado, nuevoSaldo);
			}else{
				JOptionPane.showMessageDialog(btnRetirar, "Saldo insuficiente", "Error", 2, null);
			}
		}
		textSaldo.setText(nuevoSaldo+"");
	}
}
