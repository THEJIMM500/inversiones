package inversiones;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.Color;
import javax.swing.table.DefaultTableModel;

import tratadoDatos.ConexionHistorial;
import tratadoDatos.historialCompra;

import javax.swing.*;

public class Movimientos {

	private JFrame ventanaMovimientos;
	private JTable tableHistorial;
	private ConexionHistorial conexion;
	private JScrollPane scrollPane;
	private DefaultTableModel model;
	private JButton btnRetroceder;
	private String nombreGuardado;

	
	public Movimientos(String nombreGuardado) throws SQLException {
		this.nombreGuardado = nombreGuardado;
		initialize();
		ventanaMovimientos.setVisible(true);
	}

	private void initialize() throws SQLException {
		
		ventanaMovimientos = new JFrame();
		addVentana();

		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 77, 414, 173);
		ventanaMovimientos.getContentPane().add(scrollPane);
		
		model = new DefaultTableModel();
		tableHistorial = new JTable(model);
		addTableHistorial();
		
		scrollPane.setViewportView(tableHistorial);
		
		btnRetroceder = new JButton("");
		addBtnRetroceder();
		btnRetroceder.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
		        new Principal(nombreGuardado);
		        ventanaMovimientos.setVisible(false);
			}
		});
		
	}

	private void addVentana() {
		ventanaMovimientos.setTitle("Movimientos");
		ventanaMovimientos.getContentPane().setForeground(Color.WHITE);
		ventanaMovimientos.setBounds(100, 100, 450, 300);
		ventanaMovimientos.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventanaMovimientos.getContentPane().setLayout(null);
	}

	private void addTableHistorial() throws SQLException {
		tableHistorial.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Usuario", "Empresa", "Valor", "Tipo", "Fecha"
			}
		));
		
		conexion = new ConexionHistorial();
		ArrayList<Integer> listaIds = conexion.getIds(nombreGuardado);
		historialCompra nombre = null;
		int columnas = tableHistorial.getModel().getColumnCount();
		Object[] fila = new Object[columnas];
		for (int i = 0; i < listaIds.size(); i++) {
			nombre = conexion.getHistorial(listaIds.get(i));
			fila[0] = nombre.getID();
			fila[1] = nombre.getUsuario();
			fila[2] = nombre.getEmpresa();
			fila[3] = nombre.getValorCompra();
			fila[4] = nombre.getTipoTransacion();
			fila[5] = nombre.getFecha();
			((DefaultTableModel) tableHistorial.getModel()).addRow(fila);			
		}
	}
	
	private void addBtnRetroceder() {
		btnRetroceder.setBackground(Color.WHITE);
		btnRetroceder.setIcon(new ImageIcon("C:\\Users\\ro_cl\\Documents\\DAM\\Programaci\u00F3n\\Eclipse\\eclipse-workspace\\2\u00BAdam\\Retroceder.png"));
		btnRetroceder.setBounds(10, 11, 136, 33);
		btnRetroceder.setBorder(null);
		ventanaMovimientos.getContentPane().add(btnRetroceder);
	}
}