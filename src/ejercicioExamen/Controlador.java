/**
 * 
 */
package ejercicioExamen;

/**
 * @author federicoruiz 24 jun 2023 13:32:07
 */
public class Controlador {

	private Modelo modelo;
	private Vista vista;
	private final String ABECEDARIO = "abcdefghijklmnopqrstuvwxyz";
	float puntosMax = 0;
	String jugadorGanador;
	String letraEspecial = "ñ";

	/**
	 * @return the modelo
	 */
	public Modelo getModelo() {
		return modelo;
	}

	/**
	 * @param modelo the modelo to set
	 */
	public void setModelo(Modelo modelo) {
		this.modelo = modelo;
	}

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

	/**
	 * 
	 */
	public void iniciarApp() {
		vista.setVisible(true);

	}

	/**
	 * @param frase
	 * @param numero
	 */
	public void cargarDatos(String frase, String numero) {
		String letra = convertirLetra(numero);
		modelo.cargarDatos(frase, letra);

	}

	/**
	 * @param numero
	 */
	private String convertirLetra(String numero) {
		String letra = "/0";
		for (int i = 0; i < ABECEDARIO.length(); i++) {
			if ((i + 1) == Integer.parseInt(numero)) {
				char caracter = ABECEDARIO.charAt(i);
				letra = Character.toString(caracter);
			}

		}
		return letra;
	}

	/**
	 * @return the puntosMax
	 */
	public float getPuntosMax() {
		return puntosMax;
	}

	/**
	 * @return the jugadorGanador
	 */
	public String getJugadorGanador() {
		return jugadorGanador;
	}

	/**
	 * 
	 */
	public void calcularGanador() {
		int filas = vista.getTable().getRowCount();

		float puntos;

		for (int i = 0; i < filas; i++) {
			puntos = 0;
			String jugador = (String) vista.getTable().getValueAt(i, 0);
			String frase = (String) vista.getTable().getValueAt(i, 1); // accedo a la columna de la frase
			String letra = (String) vista.getTable().getValueAt(i, 2);

			String[] frases = frase.split("[ ]");

			for (int j = 0; j < frases.length; j++) {
				for (int j2 = 0; j2 < frases[j].length(); j2++) {
					String letraBuscar = Character.toString(frases[j].charAt(j2));
					if (letraBuscar.equals(letra)) {
						if (j == 0) {
							puntos += 10;

						} else {
							float punt = 10 / (j + 1);
							puntos += punt;
						}
					}
					if (letraBuscar.equals(letraEspecial)) {
						if (j == 0) {
							puntos += 50;
						} else {
							float punt = 50 / (j + 1);
							puntos += punt;
						}
					}
				}
			}
			if (puntos > puntosMax) {
				puntosMax = puntos;
				jugadorGanador = jugador;
			}
		}
		pintarGanador();
	}

	/**
	 * 
	 */
	private void pintarGanador() {
		vista.getTxtGanador().setText("Jugador numero :" + getJugadorGanador() + "-" + getPuntosMax());

	}

	/**
	 * @param frase
	 * 
	 */
	public boolean validarFrase(String frase) {
		if (frase.matches("[a-zA-ZñÑáéíóúÁÉÍÓÚ\s]+")) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * @param numero
	 */
	public boolean validarNumero(String numero) {
		if(numero.matches("([1-9]|1[0-9]|2[0-6])")) {
			return true;
		
		}else {
			return false;
		}
		
		
	}

	/**
	 * 
	 */
	public void guardar() {
		modelo.guardar();
		
	}

}
