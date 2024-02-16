package fecha;

/**
 * Clase con los contenidos para verificar Fechas
 */
public class Fecha {
	/**
	 * contiene información de los días
	 */
	private int d; //d�a
	/**
	 * contiene información de los meses
	 */
	private int m; //mes
	/**
	 * contiene información de los años
	 */
	private int a; //a�o

	/**
	 * Constructor sin parámetros
	 */
	public Fecha() {

	}

	/**
	 * Contructor con parámetros
	 * @param dia contiene información de los días
	 * @param mes contiene información de los meses
	 * @param anio contiene información de los años
	 */
	public Fecha(int dia, int mes, int anio) {
		this.d = dia;
		this.m = mes;
		this.a = anio;
	}

	
	/**
	 * Comprueba que una fecha sea o no correcta, también verifica bisiestos
	 * @return Devuelve true si la fecha es correcta, false si no lo es
	 */
	public boolean fechaCorrecta() {
		boolean diaCorrecto, mesCorrecto, anioCorrecto;
		anioCorrecto = a > 0;
		mesCorrecto = m >= 1 && m <= 12;
		switch (m) {
		case 2:
			if (esBisiesto()) {
				diaCorrecto = d >= 1 && d <= 29;
			} else {
				diaCorrecto = d >= 1 && d <= 28;
			}
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			diaCorrecto = d >= 1 && d <= 30;
			break;
		default:
			diaCorrecto = d >= 1 && d <= 31;
		}
		return diaCorrecto && mesCorrecto && anioCorrecto;
	}

	/**
	 *  Método esBisiesto. Solo lo usa fechaCorrecta, por eso es privado
	 * @return devuelve true si es bisiesto, false si no lo es
	 */
	private boolean esBisiesto() {
		boolean esBisiesto = (a % 4 == 0 && a % 100 != 0 || a % 400 == 0);
		return esBisiesto;
	}

	/**
	 * Método diaSiguiente
	 */
	public void diaSiguiente() {
		d++;
		if (!fechaCorrecta()) {
			d = 1;
			m++;
			if (!fechaCorrecta()) {
				m = 1;
				a++;
			}
		}
	}

	/**
	 * Método toString
	 * @return Devuelve una fecha en formato dd-mm-aaaa
	 */
	public String toString() {
		if (d < 10 && m < 10) {
			return "0" + d + "-0" + m + "-" + a;
		} else if (d < 10 && m >= 10) {
			return "0" + d + "-" + m + "-" + a;
		} else if (d >= 10 && m < 10) {
			return d + "-0" + m + "-" + a;
		} else {
			return d + "-" + m + "-" + a;
		}
	}

}
