/**
 * 
 */
package ejercicioExamen;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


import javax.swing.JOptionPane;

/**
 * @author federicoruiz 24 jun 2023 13:31:54
 */
public class Modelo {

	private Vista vista;
	HashMap<Integer, String> jugadorFrase = new HashMap<>();
	List<String> letra = new ArrayList<>();
	private final String archivo = "jugadores.csv";  

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
	 * @return the jugadorFrase
	 */
	public HashMap<Integer, String> getJugadorFrase() {
		return jugadorFrase;
	}

	/**
	 * @return the letra
	 */
	public List<String> getLetra() {
		return letra;
	}

	/**
	 * @param frase
	 * @param numero
	 */
	public void cargarDatos(String frase, String letra) {
		int numeroJugador = jugadorFrase.size() + 1;
		jugadorFrase.put(numeroJugador, frase); // guardo la frase y el numero de jugador
		cargarTabla(numeroJugador, frase, letra);

	}

	/**
	 * @param letra2
	 * @param frase
	 * @param numeroJugador
	 * @param frase
	 * @param numero
	 */
	public void cargarTabla(int numeroJugador, String frase, String letra) {
		String numero = String.valueOf(numeroJugador);
		String[] agregaDato = { numero, frase, letra };
		vista.gettModel().addRow(agregaDato);
		vista.getTable().setModel(vista.gettModel());

	}

	/**
	 * 
	 */
	public void guardar() {
		
		int filas = vista.getTable().getRowCount(); 
		File file = new File(archivo);  
		FileWriter fw; 
		try {
			fw = new FileWriter(file,true);
			for (int i = 0; i < filas; i++) {
				String nJugador = (String)vista.getTable().getValueAt(i, 0);
				String frase = (String)vista.getTable().getValueAt(i, 1);
				String letra = (String)vista.getTable().getValueAt(i, 2);
				fw.write(String.format(nJugador + " " + frase +  " " + letra + "\n ") ); 
			}
			fw.flush();
			fw.close();

		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Nose pudo guardar el fichero");
			e.printStackTrace();
		}
		
		
	}

}
