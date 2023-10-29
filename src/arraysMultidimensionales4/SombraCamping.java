/**
 * 
 */
package arraysMultidimensionales4;

/**
 * @author federicoruiz
 * 29 oct 2023 19:51:15
 * 
 * 
 * @author federicoruiz 23 nov 2022 17:56:59 
 * Objetivo: En un camping de 10x10, donde cada árbol da sombra en las 8 parcelas que
 * tiene a su alrededor (sin sobrepasar los límites del camping).
 * Realiza un programa que solicite las coordenadas de 4 árboles y nos
 * diga la cantidad de parcelas que tienen sombra. Las coordenadas van 0
 * a 9 y se entiende que siempre se van a introducir valores válidos.
 */

import java.util.Scanner;

public class SombraCamping {
    private static final int CAMPING_SIZE = 10;
    private static final int NUM_ARBOLES = 4;
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Boolean[][] camping = new Boolean[CAMPING_SIZE][CAMPING_SIZE];
        int sombraTotal = 0;

        for (int i = 0; i < NUM_ARBOLES; i++) {
            int fila = obtenerCoordenada("Arbol " + (i + 1) + " fila(0-9): ");
            int columna = obtenerCoordenada("Arbol " + (i + 1) + " columna(0-9): ");
            camping[fila][columna] = true;
            marcarSombra(camping, fila, columna);
        }

        sc.close();

        for (int i = 0; i < CAMPING_SIZE; i++) {
            for (int j = 0; j < CAMPING_SIZE; j++) {
                if (camping[i][j] != null) {
                    sombraTotal++;
                }
            }
        }

        System.out.println("La sombra total es de: " + sombraTotal);
    }

    private static int obtenerCoordenada(String mensaje) {
        int coordenada;
        do {
            System.out.print(mensaje);
            while (!sc.hasNextInt()) {
                System.out.println("Dato invalido, introduce un número entero");
                sc.next();
            }
            coordenada = sc.nextInt();
            if (coordenada < 0 || coordenada >= CAMPING_SIZE) {
                System.out.println("Coordenada fuera de rango (0-" + (CAMPING_SIZE - 1) + ")");
            }
        } while (coordenada < 0 || coordenada >= CAMPING_SIZE);
        return coordenada;
    }

    private static void marcarSombra(Boolean[][] camping, int fila, int columna) {
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                int nuevaFila = fila + i;
                int nuevaColumna = columna + j;
                if (nuevaFila >= 0 && nuevaFila < CAMPING_SIZE && nuevaColumna >= 0 && nuevaColumna < CAMPING_SIZE) {
                    camping[nuevaFila][nuevaColumna] = true;
                }
            }
        }
    }
}
