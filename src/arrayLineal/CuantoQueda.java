/**
 * 
 */
package arrayLineal;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author federicoruiz 18 jun 2023 17:10:29
 * 
 *         ¿Cuánto queda? Realiza un programa que lea 5 números (entre 1 y 50)
 *         que representan los kilómetros de cada etapa del Camino de Santiago.
 *         Los peregrinos van con un niño que siempre está preguntando “¿cuánto
 *         queda? El programa debe imprimir los kilómetros que quedan al
 *         comenzar cada una de las etapas. Utiliza el envoltorio Arrays para
 *         imprimir los valores.
 */
public class CuantoQueda {

	private Integer[] etapas;
	private Integer[] kilometrosRestantes;
	private Scanner sc;
	private int total;

	public Integer[] comprobarEntrada() {
		
		etapas = new Integer[5];
		sc = new Scanner(System.in);
		for (int i = 0; i < etapas.length; i++) {
			System.out.print("Etapa " + (i + 1) + ": ");
			String input = sc.nextLine();
			if (input.matches("[0-9]{1,2}") && !input.contains(" ")) {
				int num = Integer.parseInt(input);
				if (num <= 50 && num >= 1) {
					System.out.println("ok");
					etapas[i] = num;
				} else {
					System.out.println("Solo numeros entre [1-50]");
					i--;
				}

			} else {
				System.out.println("Solo numeros sin espacios");
				i--;
			}
		}
		sc.close();
		kilometrosRestantes = cuantosKmQuedan(etapas);
		return kilometrosRestantes;
	}

	public Integer[] cuantosKmQuedan(Integer[] etapa) {
		
		kilometrosRestantes = new Integer[5];
		for (Integer km : etapas) {
			total += km;
		}
		kilometrosRestantes[0] = total;

		for (int i = 1; i < etapas.length; i++) {
			kilometrosRestantes[i] = total - etapas[i - 1];
			total = total - etapas[i - 1];
		}
		return kilometrosRestantes;
	}

	public static void main(String[] args) {
		CuantoQueda objeto = new CuantoQueda();
		System.out.println(Arrays.toString(objeto.comprobarEntrada()));

	}
}
