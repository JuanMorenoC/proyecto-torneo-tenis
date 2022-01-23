package Interfaz;

/**
 * Importamos las librerias
 * Importamos de Logica la clase GenerarPartido, Jugador, Persistencia y Pistas
 */

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Logica.GenerarPartido;
import Logica.Jugador;
import Logica.Persistencia;
import Logica.Pistas;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

/**
 * Clase Final
 * Su funcion es jugar los partidos de Final
 * y tener en cuenta los puntos el tiempo, la cancha y los jugadores quienes compiten
 */
public class Final {

	private JFrame frame;
	private JTable table;
	private MenuJugar mJugar;
	private DefaultTableModel modeloFinal;
	private Persistencia p;
	private GenerarPartido generar;
	private ArrayList<Jugador>jugadores;
	private ArrayList<Jugador>ganadores;

	/**
	 * Constructor Final
	 * mandamos como parametro la persistencia
	 * @param p
	 * obtenemos los jugadores de la clase persistencia
	 * llamamos el metodo initialize y mostrarJugadoresAleatoriosFinal
	 */
	public Final(Persistencia p) {
		this.p=p;
		jugadores=p.getJugadores();
		ganadores=new ArrayList<Jugador>();
		initialize();
		mostrarJugadoresAleatoriosFinal();
		
	}

	/**
	 * Metodo mostrarJugadoresAleatoriosFinal
	 * por medio de un for recorremos hasta 1 reiteraciones que son el total de partidos
	 * creamos e inicializamos el objeto de un arreglo de tamaño 2
	 * para luego rellenarlo  obteniendo el nombre del primer y segundo jugador
	 * luego lo añadimos al modelo por filas, para luego ser mostrados en la tabla
	 */
	public void mostrarJugadoresAleatoriosFinal()
	{
		
		for (Jugador jugador : jugadores) {
			if(jugador.getEstado()>=4) {
				ganadores.add(jugador);
			}
		}
		
		for (int i = 0; i < 1; i++) {
			Object[] arreglo = new Object[2];
			
			arreglo[0] = ganadores.get(i).getNombre();
			
				arreglo[1] = ganadores.get(1).getNombre();
			
			
			
			modeloFinal.addRow(arreglo);
		}
	}
	/**
	 * Metodo initialize
	 * Contiene todo los componentes de la ventana Final y sus atributos
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 585, 283);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblFinal = new JLabel("Final");
		lblFinal.setBounds(249, 11, 46, 14);
		frame.getContentPane().add(lblFinal);
		
		JPanel panel = new JPanel();
		panel.setBounds(33, 64, 390, 85);
		frame.getContentPane().add(panel);
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 389, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		
		/**
		 * Modelo de la tabla
		 */
		modeloFinal = new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Jugador 1", "Jugador 2"
				}
			);
		
		/**
		 * se agrega el modelo de la tabla a la tabla para mostrar la informacion
		 */
		table = new JTable();
		table.setModel(modeloFinal);
		scrollPane.setViewportView(table);
		panel.setLayout(gl_panel);
		
		JButton btnJuego = new JButton("Juego");
		btnJuego.addActionListener(new ActionListener() {
			
			/**
			 * ActionPerformed del boton Jugar
			 * por medio de un for recorremos hasta 1 reiteraciones que son el total de partidos
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
				if(e.getSource() == btnJuego)
				{
					Jugador jugador;
					for (int i = 0; i < 1; i++) {
						generar = new GenerarPartido(ganadores.get(0), ganadores.get(1));
						jugador=generar.juegoSET(ganadores.get(0), ganadores.get(1));
						Pistas pista=p.obtenerPistaAleatoria();
						JOptionPane.showMessageDialog(null,
								"Pistas "+p.pistas.get(0).getNombrePista()+"\n"+
								"Tiempo "+p.obtenerTiempoAleatoria(ganadores.get(0), ganadores.get(1))+"\n"+
								"Juego " + (i + 1) + "\n \n" + ganadores.get(0).getNombre() + "  "
										+ ganadores.get(0).mostrarPuntos() + "\n" + ganadores.get(1).getNombre() + "  "
										+ ganadores.get(1).mostrarPuntos());
						JOptionPane.showMessageDialog(null, "el ganador es "+jugador.getNombre());
						p.cambiarEstado(jugador);
						p.sumarPuntos(ganadores.get(0), ganadores.get(1));
						p.crearPartido(pista, jugador.getHora(), jugador.getMinutos(), jugadores.get(0),
								jugadores.get(1));
				}
				}
			}
		});
		btnJuego.setBounds(440, 108, 89, 23);
		frame.getContentPane().add(btnJuego);
		
		JButton btnMenu = new JButton("Menu Jugar");
		btnMenu.addActionListener(new ActionListener() {
			/**
			 * ActionPerformed del boton Menu Jugar
			 * inicializamos el objeto de la clase MenuJugar
			 * mandamos como parametro la persistencia
			 * le damos visibilidad a la ventana MenuJugar
			 * y accedemos al metodo dispose para cerrar la ventana una vez que ya no estemos en ella
			 */
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == btnMenu)
				{
					mJugar=new MenuJugar(p);
					mJugar.getFrame().setVisible(true);
					frame.dispose();
				}
			}
		});
		btnMenu.setBounds(183, 188, 130, 23);
		frame.getContentPane().add(btnMenu);
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
	 * metodo de getFrame para obtener todos los atributos del JFrame de la ventana Final
	 * @return frame de la ventana Final
	 */
	public JFrame getFrame() {
		return frame;
	}

	/**
	 * metodo de setFrame para modificar el JFrame de la ventana Final
	 * @param frame
	 */
	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
}//Fin de la Clase Final