/**
 * 
 */
package rubik;

import javax.swing.JOptionPane;

/**
 * @author federicoruiz 26 jun 2023 11:07:10
 */
public class Controlador {

	Modelo modelo;
	Vista vista;

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
	 * @return the vista
	 */
	public Vista getVista() {
		return vista;
	}

	/**
	 * @param vista the vista to set
	 */
	public void setVista(Vista vista) {
		this.vista = vista;
	}

	/**
	 * 
	 */
	public void nMovimiento() {
		modelo.nMovimiento();

	}

	/**
	 * @param tipo
	 * @param sentido
	 * @param numero
	 */
	public void movimiento(String tipo, String sentido, int numero) {
		modelo.movimiento(sentido, tipo, numero);
		modelo.sumaActual();
	}

	/**
	 * @param tam
	 * @param jug
	 */
	public void cargarTablero(int tam) {
		modelo.cargarTablero(tam);
		

	}

	/**
	 * @param objetivo
	 * @param total
	 */
	public void ganador(int objetivo, int total) {
		if (total == objetivo) {
			JOptionPane.showMessageDialog(null, "Has ganado!!!");
			vista.setVisible(false);
			System.exit(0);
		}

	}

	/**
	 * @param input
	 * Compruebo que el nombre solo tenga letras y le dejo espacios en blanco
	 * Voy agarrar la ultima entrada que va ser el apellido el resto sera todo parte del nombre
	 */
	public void validarNombre(String input) {
		String nombre = "";
		String apellido = "";
		String[] cadena;
		if (input.matches("[a-zA-Z\s]+")) {
			 cadena = input.split("[ +]");
			for (int i = 0; i < cadena.length; i++) {
				if((i+1) == cadena.length ) {
					apellido = cadena[i];
				}else {
					nombre += cadena[i] + " ";
				}
			}
			vista.getLblNombreErr().setVisible(false);
		}else {
			vista.getLblNombreErr().setVisible(true);
		}
	}



	/**
	 * Una ves que definio el tamaño de tablero y numero de jugadores escondo los campos
	 */
	public void limpiarInicio() {
		vista.getLblJugadores().setVisible(false);
		vista.getLblTamaño().setVisible(false);
		vista.getComboBoxJugadores().setVisible(false);
		vista.getComboBoxTablero().setVisible(false);
		vista.getBtnEmpezar().setVisible(false);
		vista.getBtnCargar().setVisible(true);
		
	}

	

}
