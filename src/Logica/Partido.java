package Logica;

/**
 * Clase Partio
 * su funcion es obtener los datos del partido 
 */

public class Partido implements Comparable<Partido> {

	private Pistas pista;

	private Jugador jugador1;
	private Jugador jugador2;
	private int hora;
	private int minuto;

	/**
	 * Constructor de la clase partido
	 * @param pista
	 * @param jugador1
	 * @param jugador2
	 * @param hora
	 * @param minuto
	 */
	public Partido(Pistas pista, Jugador jugador1, Jugador jugador2, int hora, int minuto) {

		this.pista = pista;
		this.jugador1 = jugador1;
		this.jugador2 = jugador2;
		this.hora = hora;
		this.minuto = minuto;
	}

	public Pistas getPista() {
		return pista;
	}

	public void setPista(Pistas pista) {
		this.pista = pista;
	}

	public Jugador getJugador1() {
		return jugador1;
	}

	public void setJugador1(Jugador jugador1) {
		this.jugador1 = jugador1;
	}

	public Jugador getJugador2() {
		return jugador2;
	}

	public void setJugador2(Jugador jugador2) {
		this.jugador2 = jugador2;
	}

	public int getHora() {
		return hora;
	}

	public void setHora(int hora) {
		this.hora = hora;
	}

	public int getMinuto() {
		return minuto;
	}

	public void setMinuto(int minuto) {
		this.minuto = minuto;
	}

	/**
	 * Metodo compareTo
	 */
	public int compareTo(Partido o) {
		if((this.hora*60)+this.minuto>(o.getHora()*60)+o.getMinuto()) { 
			return -1;
		}else if((this.hora*60)+this.minuto<(o.getHora()*60)+o.getMinuto()) {
			return 1;
		}else { 
			return 0;
		}
	}

}// Fin de la clase Partido