package Logica;

/**
 * Importamos las librerias
 */

import java.util.Random;

import javax.swing.JOptionPane;


/**
 * Clase GenerarPartido
 * Su funcion es generar el partido
 * Generar los puntos y define el ganador
 */
public class GenerarPartido {

	private Jugador jugadorA;
	private Jugador jugadorB;

	/**
	 * Metodo Generar Partido 
	 * mandamos como parametro los dos jugadores
	 * @param jugadorA
	 * @param jugadorB
	 */
	public GenerarPartido(Jugador jugadorA, Jugador jugadorB) { 
		this.jugadorA = jugadorA;
		this.jugadorB = jugadorB;
	}

	/**
	 * Metodo juegoSet
	 * mandamos como parametro los 2 jugadores
	 * @param x
	 * @param y
	 * @return Objeto de clase Jugador
	 * genera los puntos y define el ganador
	 */
	public Jugador juegoSET(Jugador x, Jugador y) {
		int s1[] = new int[5];
		int s2[] = new int[5];

		int a = 0;
		int b = 0;
		int juegosGanadosJugador1=0;
		int juegosGanadosJugador2=0;
		for (int i = 0; i < s2.length; i++) {
			if (juegosGanadosJugador1==3) {
				break;
			}
			else if(juegosGanadosJugador2==3) {
				break;
			}
			while(true) {
				int c = (int) (Math.random() * 2 + 1);
				
				if(a>6) {
					a=0;
					b=0;
					juegosGanadosJugador1++;
					break;
				}
				else if(b>6) {
					a=0;
					b=0;
					juegosGanadosJugador2++;
					break;
				}
				else {
					if (c==1) {
						s1[i]=a++;
					}
					else {
						s2[i]=b++;
					}
				}
			}

		}
		
		x.setPuntos(s1);
		y.setPuntos(s2);
		if (juegosGanadosJugador1>juegosGanadosJugador2) {
			return x;
		}
		else {
			return y;
		}
		
	}
}// Fin de la clase GenerarPartido