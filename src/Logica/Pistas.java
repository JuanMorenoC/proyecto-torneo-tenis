package Logica;

/**
 * Importamos las librerias
 */

import java.util.ArrayList;

/**
 * Clase  pistas
 * su funcion es recibir las informacion de la pistas para ser almacenadas en un objeto
 */
public class Pistas {
	private String nombrePista;
	private int capacidad;
	public ArrayList<Pistas>pistas = new ArrayList<>();

	/**
	 * Constrcutor Pistas
	 * @param nombrePista
	 * @param capacidad
	 */
	public Pistas(String nombrePista, int capacidad) {
		super();
		this.nombrePista = nombrePista;
		this.capacidad = capacidad;
	} 
	
	public String getNombrePista() {
		return nombrePista;
	}

	public void setNombrePista(String nombrePista) {
		this.nombrePista = nombrePista;
	}

	public int getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}

}//Fin de la clase Pistas