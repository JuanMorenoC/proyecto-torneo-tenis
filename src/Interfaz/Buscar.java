package Interfaz;

/**
 * Importamos las librerias
 * tambien importamos la Logica de Pistas, Persistencia y Jugador
 */

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Logica.Jugador;
import Logica.Persistencia;
import Logica.Pistas;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

/**
 * Clase Buscar: Su función es buscar el jugador por su nombre
 * tambien busca la cancha por su nombre especificamente detallado
 * ambos buscan la información sea del Jugador ó de la cancha
 */
public class Buscar {

	private JFrame frame;
	private JTextField textNombre;
	private String nombre, nombreLabel, puestoLabel, puntosLabel, edadLabel, cancha;
	private Consultar mConsultar;
	private Jugador mj, mj2;
	private String nombreJ;
	private int edad;
	private int puesto;
	private int puntos;
	private Persistencia p;
	private JTextField textCancha;

	/**
	 * Constructor de la clase Buscar
	 * mandamos como parametro la persistencia
	 * @param p 
	 * Aqui accedemos a la información de los jugadores por medio
	 * del objeto de la clase Persistencia
	 * y llamamos el metodo que inicia la ventana Buscar con sus atributos
	 */
	public Buscar(Persistencia p) {
		this.p = p;
		mj = p.jugadores.get(0);
		mj2 = p.jugadores.get(8);
		initialize();
	}

	/**
	 * Metodo initialize: esta inicializa el frame
	 * contiene todos los Action Performed de cada boton
	 * y los atributos de la ventana Buscar
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 297);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblBuscarJugadores = new JLabel("Buscar");
		lblBuscarJugadores.setBounds(204, 11, 55, 14);
		frame.getContentPane().add(lblBuscarJugadores);

		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(76, 60, 46, 14);
		frame.getContentPane().add(lblNombre);

		textNombre = new JTextField();
		textNombre.setBounds(158, 57, 201, 20);
		frame.getContentPane().add(textNombre);
		textNombre.setColumns(10);

		JButton btnBuscar = new JButton("Buscar Jugador");
		btnBuscar.addActionListener(new ActionListener() {
			
			/**
			 * Action Performed del boton Buscar Jugador
			 * obtenemos el nombre del Jugador del JTextField del nombre
			 * mandamos como parametro el nombre del Jugador al metodo buscarJugador
			 * y accedemos al metodo dispose para cerrar la ventana una vez que ya no estemos en ella
			 */
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == btnBuscar) {
					nombre = textNombre.getText();
					buscarJugador(nombre);
					frame.dispose();
				}
			}
		});
		btnBuscar.setBounds(76, 85, 169, 23);
		frame.getContentPane().add(btnBuscar);

		JButton btnMenu = new JButton("Menu");
		btnMenu.addActionListener(new ActionListener() {
			
			/**
			 * ActionPerformed del boton Menu
			 * este accede al menu de Consultar por medio del instanciamiento del objeto de clase Consultar
			 * y accedemos al metodo dispose para cerrar la ventana una vez que ya no estemos en ella
			 */
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == btnMenu) {
					mConsultar = new Consultar(p);
					mConsultar.getFrame().setVisible(true);
					frame.dispose();
				}
			}
		});
		btnMenu.setBounds(170, 218, 89, 23);
		frame.getContentPane().add(btnMenu);

		JLabel lblCancha = new JLabel("Cancha:");
		lblCancha.setBounds(76, 142, 46, 14);
		frame.getContentPane().add(lblCancha);

		textCancha = new JTextField();
		textCancha.setBounds(158, 139, 201, 20);
		frame.getContentPane().add(textCancha);
		textCancha.setColumns(10);

		JButton btnBuscarCancha = new JButton("Buscar Cancha");
		btnBuscarCancha.addActionListener(new ActionListener() {
			
			/**
			 * Action Performed del boton Buscar Jugador
			 * obtenemos el nombre del Jugador del JTextField del nombre
			 * mandamos como parametro el nombre del Jugador al metodo buscarJugador
			 * y accedemos al metodo dispose para cerrar la ventana una vez que ya no estemos en ella
			 */
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == btnBuscarCancha) {
					cancha = textCancha.getText();
					buscarCancha(cancha);
				}
			}
		});
		btnBuscarCancha.setBounds(76, 170, 169, 23);
		frame.getContentPane().add(btnBuscarCancha);
	}

	/**
	 * Metodo buscarJugador
	 * aqui se manda como parametro el nombre del jugador a buscar
	 * @param nombre
	 * con el nombre del jugador se compara con los nombres de la lista de jugadores 
	 * que esta guardado en el ArrayList y se obtiene el resto de informacion
	 * para imprimirlo por JOption
	 * cabe destacar que utilizmos el forEach como un mecanismo más adecuado para buscar
	 */
	public void buscarJugador(String nombre) {

		for (Jugador mostrarJugador : p.jugadores) {
			if (mostrarJugador.getNombre().equalsIgnoreCase(nombre)) {
				JOptionPane.showMessageDialog(null, "\nNombre:  " + mostrarJugador.getNombre() + "\nEdad:  "
						+ mostrarJugador.getEdad() + "\nPuntos:   " + mostrarJugador.getPuntosObtenidos());
			}
		}

	}
	
	/**
	 * Metodo buscarCancha
	 * sun función es buscar la cancha por su nombre
	 * mandamos como parametro la nombre la cancha
	 * @param cancha
	 * se busca la cancha por medio de un forEach donde accedemos al ArrayList pista
	 * por medio del instanciamiento de la clase Pista y asi accede a la información
	 * de las pistas.
	 * Aqui se compara con el nombre de la cacnha que debe estar especificamente detallado todo el nombre
	 * para facilitar su busqueda y ya se imprime por JOption
	 */
	public void buscarCancha(String cancha) {
		for (Pistas mostrarPista : p.pistas) {
			if (mostrarPista.getNombrePista().equalsIgnoreCase(cancha)) {
				JOptionPane.showMessageDialog(null,
						"Cancha:   " + mostrarPista.getNombrePista() + "\nCapacidad:   " + mostrarPista.getCapacidad());
			}
		}
	}

	/**
	 * metodo de getFrame para obtener todos los atributos del JFrame de la ventana buscar
	 * @return frame de la ventana Buscar
	 */
	public JFrame getFrame() {
		return frame;
	}

	/**
	 * metodo de setFrame para modificar el JFrame de la ventana buscar
	 * @param frame
	 */
	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
}//Fin de la Clase Buscar