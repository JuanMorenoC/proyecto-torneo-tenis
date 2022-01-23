package Logica;

/**
 * Importamos las librerias
 */

import java.util.ArrayList;

import javax.swing.JOptionPane;

/**
 * Clase Mayor y Menor
 * su funcion es recorrer el arreglo de los jugadres y comienza a sacar los tiempos 
 * desde mayor a menor
 */
public class Mayor_y_Menor {
	public Persistencia p;

	/**
	 * Constructor Mayor Y Menor
	 * @param p
	 */
	public Mayor_y_Menor(Persistencia p) {
		this.p=p;
	}

	/**
	 * Metodo calcularMayor
	 * @param p
	 * Calcula el jugador con mas tiempo
	 */
	public void calcularMAyor(Persistencia p) {
		Jugador x = null;
		int horas = 0;
		int minutos = 0;
		for (int i = 0; i < p.jugadores.size(); i++) {
			if (p.jugadores.get(i).getHora() == 0 && p.jugadores.get(i).getMinutos() == 0) {
				JOptionPane.showMessageDialog(null, "No hay tiempos registrados");
			} else {
				if (p.jugadores.get(i).getHora() > horas || p.jugadores.get(i).getMinutos() > minutos) {
					horas=p.jugadores.get(i).getHora();
					minutos=p.jugadores.get(i).getMinutos();
					x = p.jugadores.get(i);
				}
			}
		}

		JOptionPane.showMessageDialog(null, "el Jugador con mayor tiempo en cancha es " + x.getNombre() + " con "
				+ x.getHora() + ":" + x.getMinutos());

	}

	/**
	 * Metodo calcularMenor
	 * @param p
	 * Calcula el jugador con menos tiempo
	 */
	public void calcularMenor(Persistencia p) {
		Jugador y = null;
		int horas=1;
		int minutos=1;
		for (int i = 0; i < p.jugadores.size(); i++) {
			if (p.jugadores.get(i).getHora() == 0 && p.jugadores.get(i).getMinutos() == 0) {
				JOptionPane.showMessageDialog(null, "No hay tiempos registrados");
			} else {
				if (p.jugadores.get(i).getHora() <= horas || p.jugadores.get(i).getMinutos() <= minutos) {
					horas=p.jugadores.get(i).getHora();
					minutos=p.jugadores.get(i).getMinutos();
					y = p.jugadores.get(i);
				}
			}
		}
		JOptionPane.showMessageDialog(null, "el Jugador con menor tiempo en cancha es " + y.getNombre() + " con "
				+ y.getHora() + ":" + y.getMinutos());
	}
}//Fin de la clase Mayor y Mneor