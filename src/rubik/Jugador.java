/**
 * 
 */
package rubik;

/**
 * @author federicoruiz
 * 28 jun 2023 13:40:33
 */
public class Jugador {

	private String nombre;
	private String apellido;
	private int numeroMovimientos;
	private int objetivo;
	private Modelo modelo;
	private Controlador controlador;
	
	Jugador(String nombre, String apellido){
		this.nombre = nombre;
		this.apellido = apellido;
	}
	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * @return the apellido
	 */
	public String getApellido() {
		return apellido;
	}
	/**
	 * @param apellido the apellido to set
	 */
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	/**
	 * @return the numeroMovimientos
	 */
	public int getNumeroMovimientos() {
		return numeroMovimientos;
	}
	/**
	 * @param numeroMovimientos the numeroMovimientos to set
	 */
	public void setNumeroMovimientos(int numeroMovimientos) {
		this.numeroMovimientos = numeroMovimientos;
	}
	/**
	 * @return the objetivo
	 */
	public int getObjetivo() {
		return objetivo;
	}
	/**
	 * @param objetivo the objetivo to set
	 */
	public void setObjetivo(int objetivo) {
		this.objetivo = objetivo;
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
	
	
	
	
}
