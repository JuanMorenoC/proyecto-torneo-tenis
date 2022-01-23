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
import java.util.ArrayList;
import java.awt.event.ActionEvent;

/**
 * Clase SemiFinal
 * Su funcion es jugar los partidos de Semifinal
 * y tener en cuenta los puntos el tiempo, la cancha y los jugadores quienes compuiten
 */
public class SemiFinal {

	private JFrame frame;
	private JTable table;
	private MenuJugar mJugar;
	private GenerarPartido generar;
	private DefaultTableModel modeloSemi;
	private Persistencia p;
	private ArrayList<Jugador>jugadores;
	ArrayList<Jugador>ganadores;

	/**
	 * Constructor SemiFinal
	 * mandamos como parametro la persistencia
	 * @param p
	 * obtenemos los jugadores de la clase persistencia
	 * llamamos el metodo initialize y mostrarJugadoresAleatoriosSemi
	 */
	public SemiFinal(Persistencia p) {
		this.p=p;
		jugadores=p.getJugadores();
		ganadores=new ArrayList<Jugador>(); //Declaracion del Arraylist ganadores
		initialize();
		mostrarJugadoresAleatoriosSemi();
	}

	/**
	 * Metodo mostrarJugadoresAleatoriosSemi
	 * por medio de un for recorremos hasta 2 reiteraciones que son el total de partidos
	 * creamos e inicializamos el objeto de un arreglo de tamaño 2
	 * para luego rellenarlo  obteniendo el nombre del primer y segundo jugador
	 * luego lo añadimos al modelo por filas, para luego ser mostrados en la tabla
	 */
	public void mostrarJugadoresAleatoriosSemi()
	{
		
		for (Jugador jugador : jugadores) {
			if(jugador.getEstado()>=3) {
				ganadores.add(jugador);
			}
		}
		
		for (int i = 0,con=2; i < 2; i++,con++) {
			Object[] arreglo = new Object[2];
			
			arreglo[0] = ganadores.get(i).getNombre();
			
				arreglo[1] = ganadores.get(con).getNombre();
			
			
			
			modeloSemi.addRow(arreglo);
		}
	}
	/**
	 * Metodo initialize
	 * Contiene todo los componentes de la ventana Semi y sus atributos
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 633, 453);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblSemiFinal = new JLabel("Semi Final");
		lblSemiFinal.setBounds(257, 11, 95, 14);
		frame.getContentPane().add(lblSemiFinal);
		
		JPanel panel = new JPanel();
		panel.setBounds(35, 50, 391, 150);
		frame.getContentPane().add(panel);
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 390, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		
		/**
		 * Modelo de la tabla
		 */
		modeloSemi = new DefaultTableModel(
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
		table.setModel(modeloSemi);
		scrollPane.setViewportView(table);
		panel.setLayout(gl_panel);
		
		JButton btnJuego = new JButton("Jugar ");
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
				if(e.getSource() == btnJuego)
				{
					Jugador jugador;
					for (int i = 0, con = 2; i < 2; i++, con++) {
						generar = new GenerarPartido(ganadores.get(i), ganadores.get(con));
						jugador=generar.juegoSET(ganadores.get(i), ganadores.get(con));
						Pistas pista=p.obtenerPistaAleatoria();
						JOptionPane.showMessageDialog(null,
								"Pistas "+pista.getNombrePista()+"\n"+
								"Tiempo "+p.obtenerTiempoAleatoria(ganadores.get(i), ganadores.get(con))+"\n"+
								"Juego " + (i + 1) + "\n \n" + ganadores.get(i).getNombre() + "  "
										+ ganadores.get(i).mostrarPuntos() + "\n" + ganadores.get(con).getNombre() + "  "
										+ ganadores.get(con).mostrarPuntos());
						JOptionPane.showMessageDialog(null, "el ganador es "+jugador.getNombre());
						p.cambiarEstado(jugador);
						p.sumarPuntos(jugador, null);
						p.crearPartido(pista, jugador.getHora(), jugador.getMinutos(), jugadores.get(i),
								jugadores.get(con));
				}
			}
			}
		});
		btnJuego.setBounds(450, 97, 89, 23);
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
				if(e.getSource() == btnMenuJugar)
				{
					mJugar=new MenuJugar(p);
					mJugar.getFrame().setVisible(true);
					frame.dispose();
				}
			}
		});
		btnMenuJugar.setBounds(208, 240, 144, 23);
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
	 * metodo de getFrame para obtener todos los atributos del JFrame de la ventana SemiFinal
	 * @return frame de la ventana SemiFinal
	 */
	public JFrame getFrame() {
		return frame;
	}

	/**
	 * metodo de setFrame para modificar el JFrame de la ventana SemiFinal
	 * @param frame
	 */
	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

}//Fin de la Clase SemiFinal