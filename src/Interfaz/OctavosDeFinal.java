package Interfaz;

/**
 * Importamos las librerias
 * Importamos de Logica la clase GenerarPartido, Jugador, Persistencia y Pistas
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Logica.GenerarPartido;
import Logica.Jugador;
import Logica.Persistencia;
import Logica.Pistas;

/**
 * Clase Octavos de Final
 * Su funcion es jugar los partidos de octavos de final
 * y tener en cuenta los puntos el tiempo, la cancha y los jugadores quienes compuiten
 */
public class OctavosDeFinal {

	private JFrame frame;
	private JTable table;
	private MenuJugar mJugar;
	private DefaultTableModel modeloOctavos;
	public ArrayList<Jugador> jugadores;
	public Persistencia p;
	private GenerarPartido generar;
	private boolean validacion;

	/**
	 * Constructor Octavos de Final
	 * mandamos como parametro la persistencia
	 * @param p
	 * obtenemos los jugadores de la clase persistencia
	 * llamamos el metodo initialize y mostrarJugadoresAleatoriosOctavos
	 */
	public OctavosDeFinal(Persistencia p) {
		this.p = p;
		jugadores = p.getJugadores();

		initialize();
		mostrarJugadoresAleatoriosOctavos();

	}

	/**
	 * Metodo mostrarJugadoresAleatoriosOctavos
	 * por medio de un for recorremos hasta 8 reiteraciones que son el total de partidos
	 * creamos e inicializamos el objeto de un arreglo de tamaño 2
	 * para luego rellenarlo  obteniendo el nombre del primer y segundo jugador
	 * luego lo añadimos al modelo por filas, para luego ser mostrados en la tabla
	 */
	public void mostrarJugadoresAleatoriosOctavos() {

		for (int i = 0, con = 8; i < 8; i++, con++) {
			Object[] arreglo = new Object[2];

			arreglo[0] = jugadores.get(i).getNombre();

			arreglo[1] = jugadores.get(con).getNombre();

			modeloOctavos.addRow(arreglo);
		}

	}

	/**
	 * Metodo initialize
	 * Contiene todo los componentes de la ventana Octavos y sus atributos
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 569, 502);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblOctavosDeFinal = new JLabel("Octavos de Final");
		lblOctavosDeFinal.setBounds(204, 11, 136, 14);
		frame.getContentPane().add(lblOctavosDeFinal);

		JPanel panel = new JPanel();
		panel.setBounds(47, 53, 391, 320);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 392, 321);
		panel.add(scrollPane);

		/**
		 * Modelo de la tabla
		 */
		modeloOctavos = new DefaultTableModel(new Object[][] {}, new String[] { "Jugador 1", "Jugador 2" });
		
		/**
		 * se agrega el modelo de la tabla a la tabla para mostrar la informacion
		 */
		table = new JTable();
		table.setModel(modeloOctavos);
		scrollPane.setViewportView(table);

		JButton btnJuego = new JButton("Jugar");
		btnJuego.addActionListener(new ActionListener() {
			
			/**
			 * ActionPerformed del boton Jugar
			 * por medio de un for recorremos hasta 8 reiteraciones que son el total de partidos
			 * inicilizamos el objeto de la clase GenerarPartido donde mandamos como parametro los 2 jugadores
			 * llenamos el objeto jugador obteniendo los puntos que se han generado
			 * obtenemos la pista que se ha generado aleatoriamente
			 * mostarmos por medio de un JOption la pista el tiempo los nombres de los jugadores y los puntos generados
			 * mostarmos por medio de un JOption el ganador del partido
			 * por medio del objeto de clase perisntencia instanciamos y llamamos el metodo cambiarEstado
			 * para mandar como parametro la informacion del jugador y asi cambiar su estado
			 * por medio del objeto de clase perisntencia instanciamos y llamamos el metodo sumarPuntos
			 * para mandar como parametro la informacion del jugador y asi sumar los puntos obtenidos
			 * por medio del objeto de clase perisntencia instanciamos y llamamos el metodo crearPartido
			 * para mandar como parametro la informacion del jugador y asi cear el siqguiente partido
			 */
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == btnJuego) {
					

						Jugador jugador; //Declaramos el objeto de clase Jugador
						for (int i = 0, con = 8; i < 8; i++, con++) {
							generar = new GenerarPartido(jugadores.get(i), jugadores.get(con));
							jugador = generar.juegoSET(jugadores.get(i), jugadores.get(con));
							Pistas pista = p.obtenerPistaAleatoria();
							JOptionPane.showMessageDialog(null,
									"Pistas " + pista.getNombrePista() + "\n" + "Tiempo "
											+ p.obtenerTiempoAleatoria(jugadores.get(i), jugadores.get(con)) + "\n"
											+ "Juego " + (i + 1) + "\n \n" + jugadores.get(i).getNombre() + "  "
											+ jugadores.get(i).mostrarPuntos() + "\n" + jugadores.get(con).getNombre()
											+ "  " + jugadores.get(con).mostrarPuntos());
							JOptionPane.showMessageDialog(null, "el ganador es " + jugador.getNombre());
							p.cambiarEstado(jugador);
							p.sumarPuntos(jugador, null);
							p.crearPartido(pista, jugador.getHora(), jugador.getMinutos(), jugadores.get(i),
									jugadores.get(con));

						}


				}
			}
		});
		btnJuego.setBounds(446, 79, 86, 23);
		frame.getContentPane().add(btnJuego);

		JButton btnMenuJugar = new JButton("Menu Jugar");
		btnMenuJugar.addActionListener(new ActionListener() {
			
			/**
			 * ActionPerformed del boton Menu Jugar
			 * inicializamos el objeto de la clase MenuJugar
			 * mandamos como parametro la persistencia
			 * le damos visibilidad a la ventana MenuJugar
			 * y accedemos al metodo dispose para cerrar la ventana una vez que ya no estemos en ella
			 */
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == btnMenuJugar) {
					mJugar = new MenuJugar(p);
					mJugar.getFrame().setVisible(true);
					frame.setVisible(false);
					frame.dispose();
				}
			}
		});
		btnMenuJugar.setBounds(215, 429, 125, 23);
		frame.getContentPane().add(btnMenuJugar);
	}

	/**
	 * Metodo buscarJugador
	 * mandamos como parametro el nombre del jugador
	 * @param nombre
	 * @return Objeto de clase Jugador
	 */
	protected Jugador buscarjugador(String nombre) {

		for (Jugador jugador : jugadores) {
			if (jugador.getNombre().equalsIgnoreCase(nombre)) {

				return jugador;
			}
		}

		return null;
	}

	/**
	 * metodo de getFrame para obtener todos los atributos del JFrame de la ventana Octavos de final
	 * @return frame de la ventana Octavos de final
	 */
	public JFrame getFrame() {
		return frame;
	}

	/**
	 * metodo de setFrame para modificar el JFrame de la ventana Octavos de final
	 * @param frame
	 */
	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

}//Fin de la Clase Octavos de Final