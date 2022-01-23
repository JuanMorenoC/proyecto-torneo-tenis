package Main;

/**
 *                          Proyecto Final Abierto de Australia de Tenis
 * 
 *                                
 *                                @author Diego Alejandro Calvo
 *                                @author Juan David Moreno Cifuentes
 * 
 *                            Presentado a: Diana Marcela Rivera Valencia
 * 
 *                                 Materia: Fundamentos de Algoritmia
 * 
 *                                      Universidad del Quindio
 *                                                2017
 */

/**
 * Se Importa la Interfaz Menu donde es el menu principal del juego
 * Se importa la Logica de Persistencia donde estan todos los jugadores
 */

import Interfaz.Menu;
import Logica.Persistencia;

/**
 * Clase Main: es la clase principal donde arranca el juego
 */

public class Main {
	private static Menu m;
	private static Persistencia p;
	
	/**
	 * Arranca la aplicacion 
	 */
	
	/**
	 * Metodo Main metodo principal 
	 * empezamos a iniciarlizar el objeto de clase Persistencia y Menu 
	 * donde estaremos instanciandola hacias las clases
	 * mandamos como parametro ma la clase Menu la persistencia
	 * y permitimos la visibilidad para la clase Menu para asi llamarlo
	 * @param args
	 */
	public static void main(String[] args) {
		p = new Persistencia();
		m = new Menu(p);
		m.setVisible(true);
	}
}//Fin de la Clase Main
