package Interfaz;

/**
 * Importamos las librerias
 * Importamos todo la Logica
 */

import Logica.*;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Clase TablaJugadores
 * Su función es mostrar la información de los jugadores con toda su información
 */
public class TablaJugadores extends JFrame {

	private JPanel contentPane;
	private JTable table;
	public ArrayList<Jugador> jugadores;
	private Jugador jT;
	private DefaultTableModel md;
	private Menu menuPrincipal;
	private int ranking;
	public Persistencia p;

	private int puntos;

	/**
	 * Constructor TablaJugadores
	 * mandamos como parametro la persistencia
	 * @param p
	 * contiene tambien todos ls componentes de la ventana Tabla de Jugadores
	 */
	public TablaJugadores(Persistencia p) {
		this.p = p;
		this.jugadores = p.getJugadores();
		burbuja();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 354);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(15, 16, 417, 242);
		
		/**
		 * Modelo de la tabla
		 */
		md = new DefaultTableModel(new Object[][] {}, new String[] { "Nombre", "Edad", "Puntos Obtenidos" });

		/**
		 * se agrega el modelo de la tabla a la tabla para mostrar la información
		 */
		table = new JTable(md);
		rellenarTabla();
		contentPane.setLayout(null);
		scrollPane.setViewportView(table);
		contentPane.add(scrollPane);

		JButton btnMenu = new JButton("Menu");
		JButton editar = new JButton("Editar");

		btnMenu.addActionListener(new ActionListener() {
			
			/**
			 * ActionPerformed del boton Menu
			 * inicializamos la clase Menu
			 * mandamos como parametro la persistencia
			 * y le damos visibilidad a la ventana Menu
			 */
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == btnMenu) {
					menuPrincipal = new Menu(p);
					menuPrincipal.setVisible(true);
				}

			}
		});
		btnMenu.setBounds(175, 281, 89, 23);
		contentPane.add(btnMenu);
		editar.addActionListener(new ActionListener() {
			
			/**
			 * ActionPerformed del boton Editar
			 * llamamos el metodo modificarJugador
			 */
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == editar) {
					modificarJugador();
				}

			}
		});
		editar.setBounds(290, 281, 89, 23);
		contentPane.add(editar);

	}

	/**
	 * Metodo Rellenar Tabla
	 * por medio de un forEach recorremos el ArrayList de los jugadores
	 *  creamos e inicializamos el objeto de un arreglo de tamaño 3
	 *  para luego rellenarlo  obteniendo el nombre, edad y puntos del jugador
	 *  luego lo añadimos al modelo por filas, para luego ser mostrados
	 */
	private void rellenarTabla() {

		for (Jugador jugador : jugadores) {
			Object[] arreglo = new Object[3];
			arreglo[0] = jugador.getNombre();
			arreglo[1] = jugador.getEdad();
			arreglo[2] = jugador.getPuntosObtenidos();
			md.addRow(arreglo);
		}

	}

	/**
	 * Metodo modificarJugador
	 * aqui se obtiene el valor o el dato modificado de la tabla en dada posicion de la fila seleccionada
	 * se declara un objeto de clase Jugador 
	 * donde se manda por parametro nombre, edad, puntos y estado del jugador
	 * para luego llamar el metodo de modificarJugador y mandarle por parametro el objeto
	 */
	public void modificarJugador() {
		int a = table.getSelectedRow();//Declaro una variable de la fila seleccionada
		String nombre = (String) table.getValueAt(a, 0);
		String edad = String.valueOf(table.getValueAt(a, 1));
		String puntos = String.valueOf(table.getValueAt(a, 2));
		Jugador jugador = new Jugador(nombre, Integer.parseInt(edad), Integer.parseInt(puntos), 1);

		modificarJugador(jugador);

	}

	/**
	 * Metodo modificarJugador
	 * llega por parametro el objeto Jugador de la Jugador
	 * @param jugador
	 * se recorre por un for el Arraylist jugadores
	 * se compara el nombre del jugador con los nombres del Arraylist jugadores
	 * y se modifica segun en su posición el jugador a modificar el dato
	 */
	private void modificarJugador(Jugador jugador) {
		for (int i = 0; i < jugadores.size(); i++) {
			if (jugador.getNombre().equalsIgnoreCase(jugadores.get(i).getNombre())) {
				jugadores.set(i, jugador);
			}
		}

	}

	/**
	 * Metodo getJugadores
	 * @return ArrayList de clase Jugador
	 */
	public ArrayList<Jugador> getJugadores() {
		return jugadores;
	}

	/**
	 * Metodo setJugadores
	 * recibe como parametro el ArrayList jugadores
	 * @param jugadores
	 */
	public void setJugadores(ArrayList<Jugador> jugadores) {
		this.jugadores = jugadores;
	}

	/**
	 * Metodo Burbuja
	 * recorremos el ArrayList jugadores
	 * para comparar los jugadores y asi ordenarlos
	 * y modificarlos en el mismo ArrayList jugador
	 */
	public void burbuja()
    {
		int i, j;
		Jugador aux,aux2;
		
        for(i=0;i<jugadores.size();i++)
             for(j=0;j<jugadores.size()-i-1;j++)
                  if(jugadores.get(j+1).compareTo(jugadores.get(j))<0){
                     aux=jugadores.get(j+1);
                     aux2=jugadores.get(j);
                     jugadores.set(j+1,aux2);
                     jugadores.set(j, aux);
                  }
    }
}//Fin de la Clase TablaJugador