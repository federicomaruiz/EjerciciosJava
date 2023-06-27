/**
 * 
 */
package rubik;

import javax.swing.JOptionPane;

/**
 * @author federicoruiz
 * 26 jun 2023 11:07:10
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
	public void cargarTablero(int tam, int jug) {
		modelo.cargarTablero(tam);
		
	}
	/**
	 * @param objetivo
	 * @param total
	 */
	public void ganador(int objetivo, int total) {
		if(total == objetivo) {
			JOptionPane.showMessageDialog(null, "Has ganado!!!");
			vista.setVisible(false);
		}
		
	}
	
	
}
