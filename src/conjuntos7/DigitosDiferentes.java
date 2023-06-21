/**
 * 
 */
package conjuntos7;

import java.util.HashSet;
import java.util.Scanner;

/**
 * @author federicoruiz 21 jun 2023 14:01:37
 * 
 *         Dígitos diferentes El programa debe leer un número que puede tener
 *         hasta 20 dígitos y debe mostrar la cantidad de dígitos diferentes que
 *         contine el número introducido.
 */
public class DigitosDiferentes {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		HashSet<Integer> lista = new HashSet<>();
		boolean valido = false;

		do {
			System.out.print("Ingrese una cadena de numeros : ");
			String input = sc.nextLine();
			if (input.matches("[0-9]+")) {
				for (int i = 0; i < input.length(); i++) {
					lista.add((int) input.charAt(i));
				}
				valido=true;
			} else {
				System.out.println("Solo ingrese numeros sin espacios");
			}
		} while (!valido);
		System.out.println(lista.size());
		sc.close();
	}
}
