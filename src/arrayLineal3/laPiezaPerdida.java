/**
 * 
 */
package arrayLineal3;

import java.util.Scanner;

/**
 * @author federicoruiz 19 jun 2023 15:45:19
 * 
 *         La pieza perdida Un puzle infantil tiene 5 piezas y se ha perdido
 *         una. Por suerte, cada pieza está numerada. Realiza un programa que
 *         lea 4 números, que representan las piezas que hay y muestre por
 *         pantalla la pieza que falta.
 */
public class laPiezaPerdida {

	public static void main(String[] args) {

		Integer[] piezasTengo = new Integer[5];
		Integer[] piezasFaltan = new Integer[4];
		Scanner sc = new Scanner(System.in);
		int totalPiezas = 0;
		int piezaFalta;
		final int sumaTotal = 15;

		piezasTengo[0] = 1;
		piezasTengo[1] = 2;
		piezasTengo[2] = 3;
		piezasTengo[3] = 4;
		piezasTengo[4] = 5;

		for (int i = 0; i < piezasFaltan.length; i++) {
			System.out.print("Pieza (1-5) :");
			String input = sc.nextLine();
			if(input.matches("[1-5]") && !input.contains(" ")) {
				piezasFaltan[i] = Integer.parseInt(input);
				totalPiezas += piezasFaltan[i];	
			}else {
				System.out.println("Solo numeros del 1-5 sin espacios");
				i--;
			}
		}
		sc.close();
		piezaFalta = sumaTotal - totalPiezas;
		System.out.println(piezaFalta);
	}
}
