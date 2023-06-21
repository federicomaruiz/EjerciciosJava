/**
 * 
 */
package arrayLineal3;

import java.util.Scanner;

/**
 * @author federicoruiz 18 jun 2023 16:07:25
 * 
 *         Mayor diferencia Realiza un programa que solicite las notas de 5
 *         alumnos y luego muestre la mayor diferencia entre las notas. Las
 *         notas se deben almacenar en un array y se deben utilizar bucles de
 *         tipo for.
 */
public class MayorDiferencia {

	private Scanner sc;
	private int[] notas;

	public int solicitarNotas(int notas[]) {
		int min = 10;
		int max = 0;
		for (int i = 0; i < notas.length; i++) {
			if (notas[i] > max) {
				max = notas[i];
			}
			if (notas[i] < min) {
				min = notas[i];
			}
		}
		int resultado = max - min;
		return resultado;
	}

	public void comprobar() {
		sc = new Scanner(System.in);
		notas = new int[5];
		for (int i = 0; i < notas.length; i++) {
			System.out.print("Introduzca la nota del alumno " + (i + 1) + ": ");
			while (true) {
				String input = sc.nextLine();
				if (!input.isEmpty() && !input.contains(" ")) {
					try {
						notas[i] = Integer.parseInt(input);
						break;
					} catch (NumberFormatException e) {
						System.out.println("Error: Ingrese un número entero válido sin espacios en blanco");
						System.out.print("Introduzca la nota del alumno " + (i + 1) + ": ");
					}
				} else {
					System.out.println("Error: Ingrese un número entero válido sin espacios en blanco");
					System.out.print("Introduzca la nota del alumno " + (i + 1) + ": ");
				}
			}
		}
		sc.close();
		int respuesta = solicitarNotas(notas);
		System.out.println("La diferencia es " + respuesta);
	}

	public static void main(String[] args) {

		MayorDiferencia objeto = new MayorDiferencia();
		objeto.comprobar();

	}

}
