package Logica;

/**
 * Importamos las librerias 
 */

import java.util.ArrayList;

/**
 * Clase Persistencia
 * Su funcion es guardar la informacion de los jugadores
 * crea el jugador
 * crea el partido
 * suma lo spuntos obtenidos
 * obtiene el tiempo
 */
public class Persistencia {
	public ArrayList<Jugador> jugadores;
	public ArrayList<Pistas> pistas;
	public String tiempo;
	private ArrayList<Partido> partidos;

	/**
	 * Constructor Persistencia
	 */
	public Persistencia() {
		jugadores = new ArrayList<Jugador>();
		pistas = new ArrayList<Pistas>();
		partidos = new ArrayList<Partido>();
		crearJugador();
	}

	/**
	 * metodo crearJugador
	 * contiene la informacion de los jugadores y de las pistas
	 */
	private void crearJugador() {
		Jugador j1 = new Jugador("Rafael Nadal", 31, 10465, 1);
		Jugador j2 = new Jugador("Roger Federer", 33, 8505, 1);
		Jugador j3 = new Jugador("Andy Murray", 28, 5290, 1);
		Jugador j4 = new Jugador("Marin Cilic", 30, 4505, 1);
		Jugador j5 = new Jugador("Alexander Zverev", 25, 4400, 1);
		Jugador j6 = new Jugador("Dominic Thiem", 24, 3935, 1);
		Jugador j7 = new Jugador("Novak Djokovic", 28, 3765, 1);
		Jugador j8 = new Jugador("Grigor Dimitrov", 27, 3650, 1);
		Jugador j9 = new Jugador("Stan Wawrinka", 27, 3450, 1);
		Jugador j10 = new Jugador("David Goffin", 24, 2840, 1);
		Jugador j11 = new Jugador("Pablo Carreño", 34, 2650, 1);
		Jugador j12 = new Jugador("Milos Raonic", 25, 2600, 1);
		Jugador j13 = new Jugador("John Isner", 30, 2550, 1);
		Jugador j14 = new Jugador("Sam Querrey", 34, 2525, 1);
		Jugador j15 = new Jugador("Jo-Wilfried Tsonga", 28, 2450, 1);
		Jugador j16 = new Jugador("Kei Nishikori", 25, 2475, 1);
		jugadores.add(j1);
		jugadores.add(j2);
		jugadores.add(j3);
		jugadores.add(j4);
		jugadores.add(j5);
		jugadores.add(j6);
		jugadores.add(j7);
		jugadores.add(j8);
		jugadores.add(j9);
		jugadores.add(j10);
		jugadores.add(j11);
		jugadores.add(j12);
		jugadores.add(j13);
		jugadores.add(j14);
		jugadores.add(j15);
		jugadores.add(j16);

		Pistas pista1 = new Pistas("Rod Laver Arena", 15000);
		Pistas pista2 = new Pistas("Hisense Arena", 9500);
		Pistas pista3 = new Pistas("Margaret Court Arena", 7500);
		pistas.add(pista1);
		pistas.add(pista2);
		pistas.add(pista3);
	}

	/**
	 * Metodo obtenerPistaAleatoria
	 * @return objeto de la clase pista
	 */
	public Pistas obtenerPistaAleatoria() {
		int indiceAleatoria = (int) (Math.random() * (pistas.size() - 1)) + 1;
		return pistas.get(indiceAleatoria);
	}

	/**
	 * Metodo para cambiarEstado
	 * @param jugador
	 * busca el jugador y le cambia el estado dependiendo de la fase a la que haya clasificado
	 */
	public void cambiarEstado(Jugador jugador) {
		for (int i = 0; i < jugadores.size(); i++) {
			if (jugador.getNombre().equalsIgnoreCase(jugadores.get(i).getNombre())) {
				int a = jugador.getEstado();
				jugador.setEstado(a + 1);

			}

		}

	}

	/**
	 * Metodo crear Partido
	 * @param pista
	 * @param hora
	 * @param minuto
	 * @param jugador1
	 * @param jugador2
	 * crea el objeto de clase Partido y lo agrega en el ArrayList partidos
	 */
	public void crearPartido(Pistas pista, int hora, int minuto, Jugador jugador1, Jugador jugador2) {
		Partido partido = new Partido(pista, jugador1, jugador2, hora, minuto);
		partidos.add(partido);
	}

	/**
	 * Metodo sumarPuntos
	 * suma todos los puntos dependiendo de la fase a la que haya clasificado o haya estado
	 * @param jugador
	 * @param jugador2
	 */
	public void sumarPuntos(Jugador jugador, Jugador jugador2) {

		if (jugador.getEstado() == 2) {
			int a = jugador.getPuntosObtenidos();
			int b = 180;
			jugador.setPuntosObtenidos(a + b);
		} else if (jugador.getEstado() == 3) {
			int a = jugador.getPuntosObtenidos();
			int b = 360;
			jugador.setPuntosObtenidos(a + b);
		} else if (jugador.getEstado() == 4) {
			int a = jugador.getPuntosObtenidos();
			int b = 720;
			jugador.setPuntosObtenidos(a + b);
		} else if (jugador.getEstado() == 5) {

			if (jugador2.getEstado() == 4) {
				int b = jugador2.getPuntosObtenidos();
				int d = 1200;
				jugador2.setPuntosObtenidos(b + d);
			} else {
				int a = jugador.getPuntosObtenidos();
				int c = 2000;
				jugador.setPuntosObtenidos(a + c);
			}

		} else {
			if (jugador.getEstado() == 4) {
				int b = jugador.getPuntosObtenidos();
				int d = 1200;
				jugador.setPuntosObtenidos(b + d);
			}
			int a = jugador2.getPuntosObtenidos();
			int c = 2000;
			jugador2.setPuntosObtenidos(a + c);

		}

	}

	/**
	 * Metodo obtenerTiempoAleatorio
	 * obtiene el tiempo aleatorio  por horas y minutos del partido
	 * @param x
	 * @param y
	 * @return
	 */
	public String obtenerTiempoAleatoria(Jugador x, Jugador y) {
		int h = (int) (Math.random() * 3 + 1);
		int m = (int) (Math.random() * 59 + 1);
		tiempo = h + ":" + m;
		for (int i = 0; i < jugadores.size(); i++) {
			x.setHora(h);
			x.setMinutos(m);
			y.setHora(h);
			y.setMinutos(m);
		}
		return tiempo;
	}

	public ArrayList<Jugador> getJugadores() {
		return jugadores;
	}

	public void setJugadores(ArrayList<Jugador> jugadores) {
		this.jugadores = jugadores;
	}

	public ArrayList<Partido> getPartidos() {
		return partidos;
	}

	public void setPartidos(ArrayList<Partido> partidos) {
		this.partidos = partidos;
	}
}//Fin de la clase persistencia