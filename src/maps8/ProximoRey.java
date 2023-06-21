/**
 * 
 */
package maps8;

import java.util.LinkedHashMap;
import java.util.Scanner;

/**
 * @author federicoruiz 21 jun 2023 11:30:46
 * 
 * 
 *         Jaimito está estudiando historia y acaba de idear una idea para saber
 *         el número que le corresponde a un rey. Primero va a leer todos los
 *         reyes de una dinastía en orden cronológico, de tal forma que, si
 *         cuando lee un nombre ya ha reinado otro, le corresponde un número más
 *         que el anterior. Después de leer toda la dinastía, debe leerse otro
 *         nombre para saber el número que le toca. ¿Serías capaz de hacer el
 *         mismo programa que Jaimito?
 */
public class ProximoRey {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		LinkedHashMap<String, Integer> reyes = new LinkedHashMap<>();
		Scanner sc = new Scanner(System.in);
		String input;
		String[] nombres = new String[0];
		boolean valido = false;

		do {
			System.out.print("Escribe los reyes : ");
			input = sc.nextLine();
			if (input.matches("[a-zA-ZñÑáéíóúÁÉÍÓÚ\s]+")) {
				nombres = input.split("[ +]");
				for (String rey : nombres) {
					if (reyes.containsKey(rey)) {
						int numero = reyes.get(rey);
						reyes.replace(rey, numero + 1);
						valido = true;
					} else {
						reyes.put(rey, 1);
					}
				}
			} else {
				System.out.println("mal");
			}
		} while (!valido);

		valido = false;

		do {
			System.out.print("Escribe el proximo rey : ");
			input = sc.nextLine();
			if (input.matches("[a-zA-ZñÑáéíóúÁÉÍÓÚ]+")) {
				if (reyes.containsKey(input)) {
					System.out.println("Va ser el numero : " + (reyes.get(input) + 1));
				} else {
					System.out.println("Va ser el numero : 1");
				}
				valido = true;
			} else {
				System.out.println("Escribe un nombre correcto");
			}
		} while (!valido);
		sc.close();
	}

}
