package Logica;

/**
 * importamos las librerias
 */

import java.util.ArrayList;

/**
 *Clase Jugador
 *su funcion es obtener y registrar la informacion del jugador
 */
public class Jugador implements Comparable<Jugador>{

	private String nombre;
	private int edad;
	private int[] puntos;
	private int puntosObtenidos;
	private int hora;
	private int minutos;
	private int estado;

	/**
	 * Constructor de la clase Jugador
	 * @param nombre
	 * @param edad
	 * @param puntosObtenidos
	 * @param estado
	 */
	public Jugador(String nombre, int edad, int puntosObtenidos,int estado)  {
		
		this.nombre = nombre;
		this.edad = edad; 
		this.puntos = new int[5];
		this.puntosObtenidos=puntosObtenidos; 
		this.estado=estado;

	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public int[] getPuntos() {
		return puntos;
	}

	public void setPuntos(int[] puntos) {
		this.puntos = puntos;
	}

	public int getPuntosObtenidos() {
		return puntosObtenidos;
	}

	public void setPuntosObtenidos(int puntosObtenidos) {
		this.puntosObtenidos = puntosObtenidos;
	}

	public int getHora() {
		return hora;
	}

	public void setHora(int hora) {
		this.hora = hora;
	}

	public int getMinutos() {
		return minutos;
	}

	public void setMinutos(int minutos) {
		this.minutos = minutos;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	/**
	 * Metodo mostrarPuntos
	 * @return Cadena tipo String donde muestra los puntos del partido
	 */
	public String mostrarPuntos() {
		String res="";
		for (int i = 0; i < puntos.length; i++) {
			res+="  "+puntos[i];
		}
		return res;
	}

	/**
	 * Metodo compareTo
	 * @return entero 
	 * compara y manda 1 si es mayor o -1 si es menor
	 */
	public int compareTo(Jugador o) {
		if(this.puntosObtenidos>o.getPuntosObtenidos()) { 
			return -1;
		}else if(this.puntosObtenidos<o.getPuntosObtenidos()) {
			return 1;
		}else { 
			return 0;
		}
	}// Fin de la clase Jugador	


}
