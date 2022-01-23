package Interfaz;

/**
 * Importamos las librerias
 * Importamos de Logica la clase Jugador, Mayor y Menor y la Persistencia
 */

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JOptionPane;

import Logica.Jugador;
import Logica.Mayor_y_Menor;
import Logica.Persistencia;

/**
 * Clase Consultar:
 * Su función es realizar las respectivas consultas
 * ya sea de Buscar Jugador o eliminarlo
 * obtener el de los mayores tiempos y menores tiempos
 * y consultas de canchas y su asistencia 
 */
public class Consultar {

	private JFrame frame;
	private Buscar b;
	private Menu menu;
	private Eliminar mEliminar;
	private Persistencia p;
	private Mayor_y_Menor mn;
	private MostrarTiempoMenorAMayor mos;
	/**
	 * Launch the application.
	 */
	

	/**
	 * Constructor de Consultar
	 * mandamos como parametro la persistencia
	 * inicializamos el objeto de clase Mayor y Menor 
	 * llamamos el metodo initialize
	 */
	public Consultar(Persistencia p) {
		this.p=p;
		mn=new Mayor_y_Menor(p);
		initialize();
	}

	/**
	 * Metodo initialize:
	 * Contiene todos los componentes y botones de esta ventana Consultar
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 304);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblConsultar = new JLabel("Consultar");
		lblConsultar.setBounds(185, 11, 74, 14);
		frame.getContentPane().add(lblConsultar);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			
			/**
			 * Action Performed del boton Buscar
			 * inicializamos el objeto de la clase Buscar para acceder a esta clase
			 * y le damos visibilidad a esta ventana Buscar
			 * tambien le mandamos como paramtero la persistencia a la clase Buscar
			 * y accedemos al metodo dispose para cerrar la ventana una vez que ya eno estemos en ella
			 */
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == btnBuscar)
				{
					b=new Buscar(p);
					b.getFrame().setVisible(true);
					frame.dispose();
				}
			}
		});
		btnBuscar.setBounds(22, 51, 124, 23);
		frame.getContentPane().add(btnBuscar);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			
			/**
			 * Action Performed del boton Eliminar
			 * inicializamos el obeto de la clase Eliminar para acceder a esta clase
			 * y le damos visibilidad a esta ventana Eliminar
			 * tambien le mandamos como paramtero la persistencia a la clase Eliminar
			 * y accedemos al metodo dispose para cerrar la ventana una vez que ya eno estemos en ella
			 */
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == btnEliminar)
				{
					mEliminar=new Eliminar(p);
					mEliminar.getFrame().setVisible(true);
					frame.dispose();
				}
			}
		});
		btnEliminar.setBounds(22, 85, 124, 23);
		frame.getContentPane().add(btnEliminar);
		
		
		JButton btnMenu = new JButton("Menu");
		btnMenu.addActionListener(new ActionListener() {
			
			/**
			 * Action Performed del boton Menu
			 * inicializamos el obeto de la clase Menu para acceder a esta clase
			 * y le damos visibilidad a esta ventana Menu
			 * tambien le mandamos como paramtero la persistencia a la clase Menu
			 * y accedemos al metodo dispose para cerrar la ventana una vez que ya no estemos en ella
			 */
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == btnMenu)
				{
					menu=new Menu(p);
					menu.setVisible(true);
					frame.setVisible(false);
					frame.dispose();
				}
			}
		});
		btnMenu.setBounds(158, 217, 124, 23);
		frame.getContentPane().add(btnMenu);
		
		JButton btnJugadorConMas = new JButton("Jugador Con Mas Tiempo");
		btnJugadorConMas.addActionListener(new ActionListener() {
			
			/**
			 * Action Performed del boton Jugador Con Mas Tiempo
			 * inicializamos el objeto de la clase CalcularMayor para acceder a esta clase
			 * le mandamos como paramtero la persistencia a la clase calcularMayor
			 */
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == btnJugadorConMas)
				{
					mn.calcularMAyor(p);
				}
			}
		});
		btnJugadorConMas.setBounds(185, 51, 209, 23);
		frame.getContentPane().add(btnJugadorConMas);
		
		JButton btnJugadorConMenos = new JButton("Jugador Con Menos Tiempo");
		btnJugadorConMenos.addActionListener(new ActionListener() {
			
			/**
			 * Action Performed del boton Jugador Con Menos Tiempo
			 * inicializamos el objeto de la clase CalcularMenor para acceder a esta clase
			 * le mandamos como paramtero la persistencia a la clase calcularMenor
			 */
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == btnJugadorConMenos)
				{
					mn.calcularMenor(p);
				}
			}
		});
		btnJugadorConMenos.setBounds(185, 85, 209, 23);
		frame.getContentPane().add(btnJugadorConMenos);
		
		JButton btnResultados = new JButton("Mostrar tiempo de menor a mayor");
		btnResultados.addActionListener(new ActionListener() {
			
			/**
			 * Action Performed del boton Mostrar tiempo de menor a mayor
			 * inicializamos el objeto de la clase Mostrar tiempo de menor a mayor para acceder a esta clase
			 * y le damos visibilidad a esta ventana Mostrar tiempo de menor a mayor
			 * tambien le mandamos como paramtero la persistencia a la clase Mostrar tiempo de menor a mayor
			 * y accedemos al metodo dispose para cerrar la ventana una vez que ya no estemos en ella
			 */
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == btnResultados)
				{
					mos=new MostrarTiempoMenorAMayor(p);
					mos.setVisible(true);
					frame.dispose();
				}
			}
		});
		btnResultados.setBounds(185, 153, 209, 23);
		frame.getContentPane().add(btnResultados);
		
		JButton btnCanchaConMayor = new JButton("Cancha Con Mayor Asistencia");
		btnCanchaConMayor.addActionListener(new ActionListener() {
			
			/**
			 * ActionPerformed del boton Cancha con Mayor Asistencia
			 * se recorre el ArrayList jugadores por medio de un for
			 * para obetener su estado y saber si ya es 5 o 4 y asi saber si el torneo termino
			 * para poder establecer obtener la cancha ya con sus respectivos asistencias
			 * y asi saber cual fue la cancha con mayor asistencia mostrando por JOption
			 */
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == btnCanchaConMayor)
				{
					Jugador x = null,y = null;
					for (int i = 0; i < p.jugadores.size(); i++) {
						if (p.jugadores.get(i).getEstado()==5) {
							x=p.jugadores.get(i);
						}
						else if(p.jugadores.get(i).getEstado()==4) {
							y=p.jugadores.get(i);
						}
					}
					JOptionPane.showMessageDialog(null, "La cancha con mayor asistencia fue "+p.pistas.get(0).getNombrePista()+"\n"+
															"En la final con los jugadores "+x.getNombre()+" , "+y.getNombre());
				}
			}
		});
		btnCanchaConMayor.setBounds(185, 119, 209, 23);
		frame.getContentPane().add(btnCanchaConMayor);
	}

	/**
	 * metodo de getFrame para obtener todos los atributos del JFrame de la ventana Consultar
	 * @return frame de la ventana Consultar
	 */
	public JFrame getFrame() {
		return frame;
	}

	/**
	 * metodo de setFrame para modificar el JFrame de la ventana Consultar
	 * @param frame
	 */
	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
}//Fin de la Clase Consultar