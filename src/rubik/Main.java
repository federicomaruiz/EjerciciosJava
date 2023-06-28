/**
 * 
 */
package rubik;

/**
 * @author federicoruiz
 * 26 jun 2023 11:07:21
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
		vista.setVisible(true);

	}

}
