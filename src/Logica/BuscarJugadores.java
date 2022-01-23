package Logica;

/**
 * Importamos todo de la interfaz
 */

import Interfaz.*;

/**
 * Clase buscarJugador
 * validar la eliminacion
 */

public class BuscarJugadores 
{
	private Persistencia p ;
	
	/**
	 * Metodo validarEliminación
	 * @param nombre
	 * @return boolean
	 * busca e jugador para validar si esta eliminado o no
	 */
	public boolean validarEliminacion(String nombre)
	{
		
		boolean validando = false;
		for(Jugador jugador: p.jugadores)
		{
			if(jugador.getNombre().equalsIgnoreCase(nombre))
			{
				validando = true;
			}
			else
			{
				validando = false;
			}
		}
		return validando;
	}
}//Fin de la Clase buscarJugador