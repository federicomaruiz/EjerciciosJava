/**
 * 
 */
package ejercicioExamen;

/**
 * @author federicoruiz
 * 24 jun 2023 13:32:44
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Modelo modelo = new Modelo();
		Controlador controlador = new Controlador();
		Vista vista = new Vista();
		
		modelo.setVista(vista);
		controlador.setModelo(modelo);
		controlador.setVista(vista);
		vista.setModelo(modelo);
		vista.setControlador(controlador);
		controlador.iniciarApp();

	}

}
