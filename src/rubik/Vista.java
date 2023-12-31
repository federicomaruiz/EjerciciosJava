/**
 * 
 */
package rubik;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Color;

/**
 * @author federicoruiz 26 jun 2023 11:07:34
 */
public class Vista extends JFrame {

	private JPanel contentPane;
	private JTextField txtNombreApellido;
	private JComboBox comboBoxJugadores;
	private JComboBox comboBoxTablero;
	private JTextField txtSuma;
	private JTextField txtObjetivo;
	private JTextField txtNumMov;
	private JTable tabla;
	private Controlador controlador;
	private Modelo modelo;
	private DefaultTableModel tModel;
	private JComboBox comboBoxNumero;
	private JComboBox comboBoxFilaColumna;
	private JComboBox comboBoxSentido;
	private JLabel lblNombreErr;
	private JLabel lblTamaño;
	private JLabel lblJugadores;
	private JButton btnCargar;
	private JButton btnEmpezar;

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

		lblTamaño = new JLabel("Tamaño tablero");
		lblTamaño.setBounds(26, 22, 106, 16);
		contentPane.add(lblTamaño);

		comboBoxTablero = new JComboBox();
		comboBoxTablero.setModel(new DefaultComboBoxModel(new String[] { "16", "36" }));
		comboBoxTablero.setMaximumRowCount(2);
		comboBoxTablero.setBounds(144, 18, 77, 27);
		contentPane.add(comboBoxTablero);

		lblJugadores = new JLabel("Numero jugadores");
		lblJugadores.setBounds(26, 67, 128, 16);
		contentPane.add(lblJugadores);

		comboBoxJugadores = new JComboBox();
		comboBoxJugadores.setModel(new DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6" }));
		comboBoxJugadores.setMaximumRowCount(6);
		comboBoxJugadores.setBounds(144, 63, 77, 27);
		contentPane.add(comboBoxJugadores);

		JLabel lblNombreApellido = new JLabel("Nombre y apellido");
		lblNombreApellido.setBounds(26, 119, 128, 16);
		contentPane.add(lblNombreApellido);

		txtNombreApellido = new JTextField();
		txtNombreApellido.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String input = txtNombreApellido.getText();
				controlador.validarNombre(input);
			}
		});
		txtNombreApellido.setBounds(159, 114, 149, 26);
		contentPane.add(txtNombreApellido);
		txtNombreApellido.setColumns(10);

		JLabel lblObjetivo = new JLabel("Objetivo");
		lblObjetivo.setBounds(244, 22, 61, 16);
		contentPane.add(lblObjetivo);

		JLabel lblSuma = new JLabel("Suma actual");
		lblSuma.setBounds(247, 52, 89, 16);
		contentPane.add(lblSuma);

		JLabel lblNumMov = new JLabel("Numero movimientos");
		lblNumMov.setBounds(247, 80, 149, 16);
		contentPane.add(lblNumMov);

		txtObjetivo = new JTextField();
		txtObjetivo.setBounds(314, 17, 36, 26);
		contentPane.add(txtObjetivo);
		txtObjetivo.setColumns(10);

		txtSuma = new JTextField();
		txtSuma.setColumns(10);
		txtSuma.setBounds(337, 47, 36, 26);
		contentPane.add(txtSuma);

		txtNumMov = new JTextField();
		txtNumMov.setColumns(10);
		txtNumMov.setBounds(392, 75, 36, 26);
		contentPane.add(txtNumMov);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(269, 149, 175, 117);
		contentPane.add(scrollPane);

		tabla = new JTable();
		scrollPane.setViewportView(tabla);

		JLabel lblSentido = new JLabel("Sentido");
		lblSentido.setBounds(26, 208, 83, 16);
		contentPane.add(lblSentido);

		JLabel lblNumero = new JLabel("Numero ");
		lblNumero.setBounds(26, 250, 61, 16);
		contentPane.add(lblNumero);

		JLabel lblFilaColumna = new JLabel("Fila o Columna");
		lblFilaColumna.setBounds(26, 166, 106, 16);
		contentPane.add(lblFilaColumna);

		setComboBoxNumero(new JComboBox());
		getComboBoxNumero().setModel(new DefaultComboBoxModel(new String[] { "1", "2", "3", "4" }));
		getComboBoxNumero().setMaximumRowCount(6);
		getComboBoxNumero().setBounds(99, 246, 77, 27);
		contentPane.add(getComboBoxNumero());

		JButton btnMover = new JButton("Mover");
		btnMover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlador.nMovimiento();
				String tipo = (String) comboBoxFilaColumna.getSelectedItem();
				String sentido = (String) comboBoxSentido.getSelectedItem();
				String numString = (String) getComboBoxNumero().getSelectedItem();
				int numero = Integer.parseInt(numString);
				controlador.movimiento(tipo, sentido, numero);
				int objetivo = Integer.parseInt(txtObjetivo.getText());
				int total = Integer.parseInt(txtSuma.getText());
				controlador.ganador(objetivo, total);
				//controlador.turnosJugador();
			}
		});
		btnMover.setBounds(188, 241, 83, 29);
		contentPane.add(btnMover);

		btnEmpezar = new JButton("Empezar");
		btnEmpezar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tamanio = (String) comboBoxTablero.getSelectedItem();
				String jugadores = (String) comboBoxJugadores.getSelectedItem();
				int tam = Integer.parseInt(tamanio);
				int numJugadores = Integer.parseInt(jugadores);
				controlador.cargarTablero(tam,numJugadores);
				btnEmpezar.setVisible(false);
				//controlador.limpiarInicio();
			}
		});
		btnEmpezar.setBounds(337, 114, 83, 29);
		contentPane.add(btnEmpezar);

		comboBoxFilaColumna = new JComboBox();
		comboBoxFilaColumna.setModel(new DefaultComboBoxModel(new String[] { "Fila", "Columna" }));
		comboBoxFilaColumna.setMaximumRowCount(2);
		comboBoxFilaColumna.setBounds(133, 162, 135, 27);
		contentPane.add(comboBoxFilaColumna);

		comboBoxSentido = new JComboBox();
		comboBoxSentido.setModel(new DefaultComboBoxModel(new String[] { "Ascendente", "Descendente" }));
		comboBoxSentido.setMaximumRowCount(2);
		comboBoxSentido.setBounds(86, 204, 135, 27);
		contentPane.add(comboBoxSentido);

		lblNombreErr = new JLabel("Solo letras");
		lblNombreErr.setVisible(false);
		lblNombreErr.setForeground(Color.RED);
		lblNombreErr.setBounds(175, 102, 77, 16);
		contentPane.add(lblNombreErr);

		btnCargar = new JButton("Cargar");
		btnCargar.setVisible(false);
		btnCargar.setBounds(327, 114, 100, 29);
		contentPane.add(btnCargar);
	}

	/**
	 * @return the txtNombreApellido
	 */
	public JTextField getTxtNombreApellido() {
		return txtNombreApellido;
	}

	/**
	 * @param txtNombreApellido the txtNombreApellido to set
	 */
	public void setTxtNombreApellido(JTextField txtNombreApellido) {
		this.txtNombreApellido = txtNombreApellido;
	}

	/**
	 * @return the comboBox
	 */
	public JComboBox getComboBox() {
		return comboBoxJugadores;
	}

	/**
	 * @param comboBox the comboBox to set
	 */
	public void setComboBox(JComboBox comboBox) {
		this.comboBoxJugadores = comboBox;
	}

	/**
	 * @return the comboBoxTablero
	 */
	public JComboBox getComboBoxTablero() {
		return comboBoxTablero;
	}

	/**
	 * @param comboBoxTablero the comboBoxTablero to set
	 */
	public void setComboBoxTablero(JComboBox comboBoxTablero) {
		this.comboBoxTablero = comboBoxTablero;
	}

	/**
	 * @return the txtSuma
	 */
	public JTextField getTxtSuma() {
		return txtSuma;
	}

	/**
	 * @param txtSuma the txtSuma to set
	 */
	public void setTxtSuma(JTextField txtSuma) {
		this.txtSuma = txtSuma;
	}

	/**
	 * @return the txtObjetivo
	 */
	public JTextField getTxtObjetivo() {
		return txtObjetivo;
	}

	/**
	 * @param txtObjetivo the txtObjetivo to set
	 */
	public void setTxtObjetivo(JTextField txtObjetivo) {
		this.txtObjetivo = txtObjetivo;
	}

	/**
	 * @return the txtNumMov
	 */
	public JTextField getTxtNumMov() {
		return txtNumMov;
	}

	/**
	 * @param txtNumMov the txtNumMov to set
	 */
	public void setTxtNumMov(JTextField txtNumMov) {
		this.txtNumMov = txtNumMov;
	}

	/**
	 * @return the tabla
	 */
	public JTable getTabla() {
		return tabla;
	}

	/**
	 * @param tabla the tabla to set
	 */
	public void setTabla(JTable tabla) {
		this.tabla = tabla;
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

	/**
	 * @return the comboBoxNumero
	 */
	public JComboBox getComboBoxNumero() {
		return comboBoxNumero;
	}

	/**
	 * @param comboBoxNumero the comboBoxNumero to set
	 */
	public void setComboBoxNumero(JComboBox comboBoxNumero) {
		this.comboBoxNumero = comboBoxNumero;
	}

	/**
	 * @return the lblNombreErr
	 */
	public JLabel getLblNombreErr() {
		return lblNombreErr;
	}

	/**
	 * @param lblNombreErr the lblNombreErr to set
	 */
	public void setLblNombreErr(JLabel lblNombreErr) {
		this.lblNombreErr = lblNombreErr;
	}

	/**
	 * @return the comboBoxJugadores
	 */
	public JComboBox getComboBoxJugadores() {
		return comboBoxJugadores;
	}

	/**
	 * @param comboBoxJugadores the comboBoxJugadores to set
	 */
	public void setComboBoxJugadores(JComboBox comboBoxJugadores) {
		this.comboBoxJugadores = comboBoxJugadores;
	}

	/**
	 * @return the lblTamaño
	 */
	public JLabel getLblTamaño() {
		return lblTamaño;
	}

	/**
	 * @param lblTamaño the lblTamaño to set
	 */
	public void setLblTamaño(JLabel lblTamaño) {
		this.lblTamaño = lblTamaño;
	}

	/**
	 * @return the lblJugadores
	 */
	public JLabel getLblJugadores() {
		return lblJugadores;
	}

	/**
	 * @param lblJugadores the lblJugadores to set
	 */
	public void setLblJugadores(JLabel lblJugadores) {
		this.lblJugadores = lblJugadores;
	}

	/**
	 * @return the btnCargar
	 */
	public JButton getBtnCargar() {
		return btnCargar;
	}

	/**
	 * @param btnCargar the btnCargar to set
	 */
	public void setBtnCargar(JButton btnCargar) {
		this.btnCargar = btnCargar;
	}

	/**
	 * @return the btnEmpezar
	 */
	public JButton getBtnEmpezar() {
		return btnEmpezar;
	}

	/**
	 * @param btnEmpezar the btnEmpezar to set
	 */
	public void setBtnEmpezar(JButton btnEmpezar) {
		this.btnEmpezar = btnEmpezar;
	}

}
