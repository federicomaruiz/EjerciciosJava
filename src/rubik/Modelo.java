/**
 * 
 */
package rubik;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;

import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

/**
 * @author federicoruiz 26 jun 2023 11:06:59
 */
public class Modelo {

	Vista vista;
	DefaultTableModel miTabla;
	int tablero;
	HashMap<Integer, DefaultTableModel> jugadores = new HashMap<>();
	int turno = 0;
	int totalJugadores;
	boolean primeraVuelta = false;

	public Vista getVista() {
		return vista;
	}

	/**
	 * @param vista the vista to set
	 */
	public void setVista(Vista vista) {
		this.vista = vista;
	}

	/*
	 * Creo el tablero dependiendo el tamaño, si es de 36 agrego al comboBoxNumero 2
	 * numeros mas para que pueda acceder a mover las ultimas dos filas tambien
	 * Luego de pintar el tablero, llamo a calcularObjetivo, sumaActual y
	 * ganaAlaPrimera para comprobar que no haya ganado sin hacer movimientos
	 */
	public void cargarTablero(int tamaño, int numJugadores) {
		totalJugadores = numJugadores;
		int count = 0;
		int sumador = 1;
		if (tamaño == 16) {
			tablero = 4;
		} else {
			tablero = 6;
			vista.getComboBoxNumero().setModel(new DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6" }));
		}
		miTabla = new DefaultTableModel();
		Object[] contenido = new Object[tablero];

		for (int i = 0; i < contenido.length; i++) {
			miTabla.addColumn("-");
		}

		while (count < tablero) {

			for (int j = 0; j < contenido.length; j++) {
				contenido[j] = (sumador);
				sumador++;
			}

			miTabla.addRow(contenido);
			count++;
		}

		/*
		 * for (int i = 0; i < numJugadores; i++) { jugadores.put(i, miTabla);
		 * System.out.println("jugador " + i); }
		 */
		// turnosJugador();
		vista.getTabla().setModel(miTabla);
		calcularObjetivo();
		sumaActual();
		ganaAlaPrimera();

	}

	/**
	 * 
	 * 
	 * public void turnosJugador() {
	 * 
	 * if((turno < totalJugadores) && !(primeraVuelta)){
	 * vista.getTabla().setModel(jugadores.get(turno)); calcularObjetivo();
	 * sumaActual(); ganaAlaPrimera(); }else if((turno < totalJugadores) &&
	 * (primeraVuelta)){ vista.getTabla().setModel(jugadores.get(turno));
	 * System.out.println("entra ya todo especifo"); sumaActual(); }else {
	 * System.out.println("reseteo turno"); primeraVuelta = true; turno = 0;
	 * turnosJugador(); } turno ++;
	 * 
	 * }
	 */

	/**
	 * Compruebo que por casualidad no haya ganado a la primera si es asi vuelvo a
	 * calcular un nuevo objetivo
	 */
	private void ganaAlaPrimera() {
		int obj = Integer.parseInt(vista.getTxtObjetivo().getText());
		int suma = Integer.parseInt(vista.getTxtSuma().getText());
		while (suma == obj) {
			calcularObjetivo();
		}

	}

	/*
	 * Calculo el objetivo dependiendo el tamaño del cuadrado, un numero random
	 */

	public int calcularObjetivo() {

		int tamaño = tablero == 4 ? 4 : 6;

		if (tamaño == 4) {
			tamaño = 49;
		} else {
			tamaño = 129;
		}

		Random random = new Random();
		int numeroAleatorio = random.nextInt(tamaño) + 10;
		vista.getTxtObjetivo().setText(String.valueOf(numeroAleatorio));
		return numeroAleatorio;
	}

	/*
	 * Calculo la suma actual de los 4 cuadrados centrales, depeniendo siempre si el
	 * cuadrado es 4x4 o 6x6 luego actualizo el campo
	 */
	public void sumaActual() {
		int sumaTotal = 0;
		int filaInicio = 0;
		int columnaInicio = 0;

		if (tablero == 4) {
			filaInicio = 1;
			columnaInicio = 1;
		} else {
			filaInicio = 2;
			columnaInicio = 2;
		}

		for (int i = filaInicio; i < filaInicio + 2; i++) {
			for (int j = columnaInicio; j < columnaInicio + 2; j++) {
				sumaTotal += (int) vista.getTabla().getValueAt(i, j);
			}
		}

		vista.getTxtSuma().setText(String.valueOf(sumaTotal));
	}

	/*
	 * Primeor num-- para ir por el numero indicado por el usuario (aqui empieza en
	 * 0) miro si es columna o fila guardo los valores en un array de enteros Miro
	 * si el movimiento va ser ascendente o descendente Luego recorro el tamaño de
	 * la tabla y voy movimiendo los numeros actualizando la tabla
	 * 
	 */
	public void movimiento(String direccion, String tipo, int num) {
		num--;

		int tamaño = tablero == 4 ? 4 : 6;

		if (tipo.equals("Columna")) {
			int[] valores = new int[tamaño];
			for (int i = 0; i < tamaño; i++) {
				valores[i] = (int) vista.getTabla().getValueAt(i, num);
			}

			if (direccion.equals("Ascendente")) {
				for (int i = 0; i < tamaño - 1; i++) {
					vista.getTabla().setValueAt(valores[i + 1], i, num);
				}
				vista.getTabla().setValueAt(valores[0], tamaño - 1, num);
			} else {
				vista.getTabla().setValueAt(valores[tamaño - 1], 0, num);
				for (int i = 0; i < tamaño - 1; i++) {
					vista.getTabla().setValueAt(valores[i], i + 1, num);
				}
			}
		} else {
			int[] valores = new int[tamaño];
			for (int i = 0; i < tamaño; i++) {
				valores[i] = (int) vista.getTabla().getValueAt(num, i);
			}

			if (direccion.equals("Ascendente")) {
				for (int i = 0; i < tamaño - 1; i++) {
					vista.getTabla().setValueAt(valores[i + 1], num, i);
				}
				vista.getTabla().setValueAt(valores[0], num, tamaño - 1);
			} else {
				vista.getTabla().setValueAt(valores[tamaño - 1], num, 0);
				for (int i = 0; i < tamaño - 1; i++) {
					vista.getTabla().setValueAt(valores[i], num, i + 1);
				}
			}
		}
	}

	/**
	 * @return the miTabla
	 */
	public DefaultTableModel getMiTabla() {
		return miTabla;
	}

	/**
	 * @param miTabla the miTabla to set
	 */
	public void setMiTabla(DefaultTableModel miTabla) {
		this.miTabla = miTabla;
	}

	/**
	 * Voy contando cuantos movimientos realizo
	 */
	public void nMovimiento() {
		int movimiento;
		if (vista.getTxtNumMov().getText().equals("")) {
			movimiento = 0;
		} else {
			movimiento = Integer.parseInt(vista.getTxtNumMov().getText());
		}
		movimiento++;
		String mov = String.valueOf(movimiento);
		vista.getTxtNumMov().setText(mov);

	}

}
