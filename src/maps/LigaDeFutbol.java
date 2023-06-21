/**
 * 
 */
package maps;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

/**
 * @author federicoruiz 21 jun 2023 9:56:13
 * 
 * 
 *         Estamos organizando una liga de futbol y queremos saber la
 *         clasificación general tras cada partido. El resultado de cada partido
 *         tiene el siguiente formato: Equipo1 Goles1 Equipo2 Goles2, donde
 *         Equipo 1 y 2 son los nombres de los equipos y Goles 1 y 2 los goles
 *         que han marcada respectivamente. La victoria se puntúa con 3 puntos y
 *         el empate con 1. ¿Serías capaz de hacer un programa que muestre la
 *         clasificación tras leer cada resultado? El programa debe finalizar
 *         cuando se escribe la palabra “fin”
 */
public class LigaDeFutbol {

	public static void mostrarClasificacion(HashMap<String, Integer> equipos) {
		for (Entry<String, Integer> entry : equipos.entrySet()) {
			String key = entry.getKey();
			Integer val = entry.getValue();
			System.out.println(key + " - " + val);
		}
	}

	public static void actualizarClasificacion(String entrada, HashMap<String, Integer> equipos) {
		String[] unResultado = new String[0];
		unResultado = entrada.split("[ ]");
		int resultadoEquipo1 = Integer.parseInt(unResultado[1]);
		int resultadoEquipo2 = Integer.parseInt(unResultado[3]);

		if (resultadoEquipo1 > resultadoEquipo2) {
			resultadoEquipo1 = 3;
			resultadoEquipo2 = 0;
		} else if (resultadoEquipo1 < resultadoEquipo2) {
			resultadoEquipo1 = 0;
			resultadoEquipo2 = 3;
		} else {
			resultadoEquipo1 = 1;
			resultadoEquipo2 = 1;
		}

		if (equipos.containsKey(unResultado[0])) {
			int puntos = equipos.get(unResultado[0]);
			resultadoEquipo1 += puntos;
			equipos.replace(unResultado[0], resultadoEquipo1);
		} else {
			equipos.put(unResultado[0], resultadoEquipo1);
		}

		if (equipos.containsKey(unResultado[2])) {
			int puntos = equipos.get(unResultado[2]);
			resultadoEquipo2 += puntos;
			equipos.replace(unResultado[2], resultadoEquipo2);
		} else {
			equipos.put(unResultado[2], resultadoEquipo2);
		}
	}

	public static void main(String[] args) {
		HashMap<String, Integer> equipos = new HashMap<>();
		Scanner sc = new Scanner(System.in);
		String input;
		do {
			input = sc.nextLine();

			if (input.matches("[a-zA-ZñÑáéíóúÁÉÍÓÚ]+[\s][0-9]{1,2}[\s][a-zA-ZZñÑáéíóúÁÉÍÓÚ]+[\s][0-9]{1,2}")) {
				input = input.toLowerCase();
				actualizarClasificacion(input, equipos);
				mostrarClasificacion(equipos);
			} else if (input.trim().equals("fin")) {
				System.out.println("Cerrando programa...");
			} else {
				System.out.println("Error de entrada , escriba este formato [equipo 3 equipos 0]");
			}

		} while (!input.trim().equals("fin"));
		sc.close();
	}

}
