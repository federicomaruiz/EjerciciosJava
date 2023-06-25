/**
 * 
 */
package ejercicioExamen;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Color;

/**
 * @author federicoruiz 24 jun 2023 13:33:10
 */
public class Vista extends JFrame {

	private JPanel contentPane;
	private Controlador controlador;
	private Modelo modelo;
	private JTable table;
	private JLabel lblFrase;
	private JLabel lblNewLabel;
	private JTextField txtFrase;
	private JTextField txtNumero;
	private JTextField txtGanador;
	private DefaultTableModel tModel;
	private JLabel lblNumeroErr;
	private JLabel lblFraseErr;
	private boolean comprobarFrase = false;
	private boolean comprobarNumero = false;
	private JButton btnCargar;
	private JButton btnGanador;
	private JButton btnGuardar;
	private JLabel lblGanador;

	/**
	 * Create the frame.
	 */
	public Vista() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(25, 6, 408, 148);
		contentPane.add(scrollPane);

		table = new JTable();
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		scrollPane.setViewportView(table);


		txtFrase = new JTextField();
		txtFrase.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String frase = (String) getTxtFrase().getText();
				comprobarFrase = controlador.validarFrase(frase);
				if (!comprobarFrase) {
					lblFraseErr.setVisible(true);
				} else {
					lblFraseErr.setVisible(false);
				}
				if (comprobarFrase && comprobarNumero) {
					btnCargar.setEnabled(true);
				} else {
					btnCargar.setEnabled(false);
				}
			}
		});
		txtFrase.setColumns(10);
		txtFrase.setBounds(25, 186, 272, 26);
		contentPane.add(txtFrase);

		txtNumero = new JTextField();
		txtNumero.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String numero = (String) getTxtNumero().getText();
				comprobarNumero = controlador.validarNumero(numero);
				if (!comprobarNumero) {
					lblNumeroErr.setVisible(true);
				} else {
					lblNumeroErr.setVisible(false);
				}
				if (comprobarFrase && comprobarNumero) {
					btnCargar.setEnabled(true);
				} else {
					btnCargar.setEnabled(false);
				}
			}
		});
		txtNumero.setColumns(10);
		txtNumero.setBounds(315, 186, 43, 26);
		contentPane.add(txtNumero);

		btnCargar = new JButton("Cargar");
		btnCargar.setEnabled(false);
		btnCargar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String frase = getTxtFrase().getText().toLowerCase();
				String numero = getTxtNumero().getText().toLowerCase();
				controlador.cargarDatos(frase, numero);
				btnGuardar.setEnabled(true);
				btnGanador.setEnabled(true);
				btnCargar.setEnabled(false);
				vaciasCampos();
			}

			private void vaciasCampos() {
				txtFrase.setText("");
				txtNumero.setText("");
				
			}
		});
		btnCargar.setBounds(6, 237, 87, 29);
		contentPane.add(btnCargar);

		btnGanador = new JButton("Ganador");
		btnGanador.setEnabled(false);
		btnGanador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlador.calcularGanador();
			}
		});
		btnGanador.setBounds(357, 237, 87, 29);
		contentPane.add(btnGanador);

		lblFrase = new JLabel("Frase");
		lblFrase.setBounds(25, 166, 61, 16);
		contentPane.add(lblFrase);

		lblNewLabel = new JLabel("Numero");
		lblNewLabel.setBounds(315, 166, 61, 16);
		contentPane.add(lblNewLabel);

		txtGanador = new JTextField();
		txtGanador.setBounds(98, 237, 260, 26);
		contentPane.add(txtGanador);
		txtGanador.setColumns(10);

		tModel = new DefaultTableModel(new Object[][] {}, new String[] { "Numero jugador", "Frase", "Letra" });

		table.setModel(tModel);

		btnGuardar = new JButton("Guardar");
		btnGuardar.setEnabled(false);
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlador.guardar();
			}
		});
		btnGuardar.setBounds(6, 208, 80, 29);
		contentPane.add(btnGuardar);

		lblFraseErr = new JLabel("Solo letras");
		lblFraseErr.setVisible(false);
		lblFraseErr.setForeground(Color.RED);
		lblFraseErr.setBounds(98, 166, 117, 16);
		contentPane.add(lblFraseErr);

		lblNumeroErr = new JLabel("Numeros [1-26]");
		lblNumeroErr.setVisible(false);
		lblNumeroErr.setForeground(Color.RED);
		lblNumeroErr.setBounds(303, 213, 101, 16);
		contentPane.add(lblNumeroErr);
		
		lblGanador = new JLabel("GANADOR");
		lblGanador.setBounds(174, 213, 87, 16);
		contentPane.add(lblGanador);
	}

	/**
	 * @return the controlador
	 */
	public Controlador getControlador() {
		return controlador;
	}

	/**
	 * @param controlador the controlador to set
	 */
	public void setControlador(Controlador controlador) {
		this.controlador = controlador;
	}

	/**
	 * @return the modelo
	 */
	public Modelo getModelo() {
		return modelo;
	}

	/**
	 * @param modelo the modelo to set
	 */
	public void setModelo(Modelo modelo) {
		this.modelo = modelo;
	}

	/**
	 * @return the table
	 */
	public JTable getTable() {
		return table;
	}

	/**
	 * @param table the table to set
	 */
	public void setTable(JTable table) {
		this.table = table;
	}

	/**
	 * @return the txtFrase
	 */
	public JTextField getTxtFrase() {
		return txtFrase;
	}

	/**
	 * @param txtFrase the txtFrase to set
	 */
	public void setTxtFrase(JTextField txtFrase) {
		this.txtFrase = txtFrase;
	}

	/**
	 * @return the txtNumero
	 */
	public JTextField getTxtNumero() {
		return txtNumero;
	}

	/**
	 * @param txtNumero the txtNumero to set
	 */
	public void setTxtNumero(JTextField txtNumero) {
		this.txtNumero = txtNumero;
	}

	/**
	 * @return the txtGanador
	 */
	public JTextField getTxtGanador() {
		return txtGanador;
	}

	/**
	 * @param txtGanador the txtGanador to set
	 */
	public void setTxtGanador(JTextField txtGanador) {
		this.txtGanador = txtGanador;
	}

	/**
	 * @return the tModel
	 */
	public DefaultTableModel gettModel() {
		return tModel;
	}

	/**
	 * @param tModel the tModel to set
	 */
	public void settModel(DefaultTableModel tModel) {
		this.tModel = tModel;
	}
}
