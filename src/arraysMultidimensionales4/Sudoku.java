/**
 * 
 */
package arraysMultidimensionales4;

import java.util.Scanner;
import java.util.HashSet;

/**
 * 
 * @author federicoruiz 23 nov 2022 16:36:49
 * Objetivo: Realizar un programa que sirva para saber si un sudoku está bien
 * resuelto o no. El tablero será una versión reducida de 3 x 3 en el
 * que en cada casilla debe haber un dígito entre 1 y 9 y tan solo se
 * debe comprobar que no hay dígitos repetidos. El programa escribirá
 * “SI” en caso de estar bien hecho y “NO” en caso contrario.    
 */
 

public class Sudoku {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] sudoku = new int[3][3];
		HashSet<Integer> numeros = new HashSet<>();

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				int coordenada;
				do {
					System.out.print("Introduzca la coordenada (" + (i + 1) + "," + (j + 1) + "): ");
					while (!sc.hasNextInt()) {
						System.out.println("Dato inválido. Introduzca un número entero.");
						sc.next();
					}
					coordenada = sc.nextInt();
					sc.nextLine(); // Limpio el scanner

					if (coordenada < 1 || coordenada > 9) {
						System.out.println("Número fuera de rango. Introduzca un número entre 1 y 9.");
					}
				} while (coordenada < 1 || coordenada > 9);

				if (numeros.contains(coordenada)) {
					System.out.println("Número repetido. Introduzca un número diferente.");
					j--;
				} else {
					numeros.add(coordenada);
					sudoku[i][j] = coordenada;
				}
			}
		}
		sc.close();

		if (esSudokuValido(sudoku)) {
			System.out.print("SI");
		} else {
			System.out.print("NO");
		}
	}

	private static boolean esSudokuValido(int[][] sudoku) {
		HashSet<Integer> numeros = new HashSet<>();
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				int numero = sudoku[i][j];
				if (numeros.contains(numero)) {
					return false; // Si encuentra un número repetido, retorna false
				}
				numeros.add(numero);
			}
		}
		return true; // Si no encuentra números repetidos, retorna true
	}
}
