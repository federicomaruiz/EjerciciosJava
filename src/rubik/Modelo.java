/**
 * 
 */
package rubik;

import java.util.Iterator;
import java.util.Random;

import javax.swing.table.DefaultTableModel;

/**
 * @author federicoruiz 26 jun 2023 11:06:59
 */
public class Modelo {

	Vista vista;
	DefaultTableModel miTabla;

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

	public void cargarTablero(int a) {
		int count = 0;
		int tablero = 0;
		int sumador = 1;
		if (a == 16) {
			tablero = 4;
		} else {
			tablero = 6;
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

		vista.getTabla().setModel(miTabla);
		calcularObjetivo();
		sumaActual();
		ganaAlaPrimera();

	}



	/**
	 * 
	 */
	private void ganaAlaPrimera() {
		int obj = Integer.parseInt(vista.getTxtObjetivo().getText());
		int suma = Integer.parseInt(vista.getTxtSuma().getText());
		while(suma == obj) {
			calcularObjetivo();
		}
		
	}

	public int calcularObjetivo() {
		Random random = new Random();
		int numeroAleatorio = random.nextInt(49) + 10;
		vista.getTxtObjetivo().setText(String.valueOf(numeroAleatorio));
		return numeroAleatorio;
	}

	public void sumaActual() {
		int sumaTotal = 0;

		sumaTotal += (int) vista.getTabla().getValueAt(1, 1);
		sumaTotal += (int) vista.getTabla().getValueAt(1, 2);
		sumaTotal += (int) vista.getTabla().getValueAt(2, 1);
		sumaTotal += (int) vista.getTabla().getValueAt(2, 2);

		vista.getTxtSuma().setText(String.valueOf(sumaTotal));
	}

	public void movimiento(String direccion, String tipo, int num) {
		num--;
		if (tipo.equals("Columna")) {
			int uno = (int) vista.getTabla().getValueAt(0, num);
			int dos = (int) vista.getTabla().getValueAt(1, num);
			int tres = (int) vista.getTabla().getValueAt(2, num);
			int cuatro = (int) vista.getTabla().getValueAt(3, num);

			if (direccion.equals("Ascendente")) {
				vista.getTabla().setValueAt(cuatro, 0, num);
				vista.getTabla().setValueAt(uno, 1, num);
				vista.getTabla().setValueAt(dos, 2, num);
				vista.getTabla().setValueAt(tres, 3, num);

			} else {
				vista.getTabla().setValueAt(dos, 0, num);
				vista.getTabla().setValueAt(tres, 1, num);
				vista.getTabla().setValueAt(cuatro, 2, num);
				vista.getTabla().setValueAt(uno, 3, num);
			}

		} else {
			int uno = (int) vista.getTabla().getValueAt(num, 0);
			int dos = (int) vista.getTabla().getValueAt(num, 1);
			int tres = (int) vista.getTabla().getValueAt(num, 2);
			int cuatro = (int) vista.getTabla().getValueAt(num, 3);
			if (direccion.equals("Ascendente")) {
				vista.getTabla().setValueAt(cuatro, num, 0);
				vista.getTabla().setValueAt(uno, num, 1);
				vista.getTabla().setValueAt(dos, num, 2);
				vista.getTabla().setValueAt(tres, num, 3);
			} else {
				vista.getTabla().setValueAt(dos, num, 0);
				vista.getTabla().setValueAt(tres, num, 1);
				vista.getTabla().setValueAt(cuatro, num, 2);
				vista.getTabla().setValueAt(uno, num, 3);
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
	 * 
	 */
	public void nMovimiento() {
		int movimiento;
		if(vista.getTxtNumMov().getText().equals("")) {
			movimiento = 0;
		}else {
		 movimiento = Integer.parseInt(vista.getTxtNumMov().getText());	
		}
		movimiento++;
		String mov = String.valueOf(movimiento);
		vista.getTxtNumMov().setText(mov);
		
	}

}
