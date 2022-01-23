package Interfaz;

/**
 * Importamos las librerias
 * Importamos Logica de Buscar ugadores y persistencia
 */

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;

import Logica.BuscarJugadores;
import Logica.Persistencia;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Clase Eliminar
 * Su funcion es buscar el jugador por su nombre y eliminarlo
 */
public class Eliminar {

	private JFrame frame;
	private JTextField textNombre;
	private Consultar mConsultar;
	private String nombre;
	private BuscarJugadores bj;
	private Persistencia p;

	/**
	 * Constructor de la clase Eliminar
	 * mandamos como parametro la persistencia
	 * @param p
	 * y llamamos el metodo initialize para comenzar a llamar el JFrame de la ventana Eliminar 
	 * y sus atributos
	 */
	public Eliminar(Persistencia p) {
		this.p = p;
		initialize();
	}

	/**
	 * Metodo initialize donde esta todo el contenido del frame 
	 * todos los botones y atributos y componentes estan aqui detallados
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 220);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblEliminar = new JLabel("Eliminar Jugador");
		lblEliminar.setBounds(169, 11, 138, 14);
		frame.getContentPane().add(lblEliminar);

		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(40, 60, 89, 14);
		frame.getContentPane().add(lblNombre);

		textNombre = new JTextField();
		textNombre.setBounds(139, 57, 198, 20);
		frame.getContentPane().add(textNombre);
		textNombre.setColumns(10);

		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			
			/**
			 * ActionPerformed del boton Eliminar
			 * aqui obtenemos el nombre del jugador por medio del JTextField
			 * y mandamos como parametro el nombre del jugador en el metodo eliminarJugador
			 * para ser eliminado
			 */
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == btnEliminar) {
					nombre = textNombre.getText();
					eliminarJugador(nombre);
				}
			}
		});
		btnEliminar.setBounds(40, 117, 89, 23);
		frame.getContentPane().add(btnEliminar);

		JButton btnMenuConsultar = new JButton("Menu Consultar");
		btnMenuConsultar.addActionListener(new ActionListener() {
			
			/**
			 * ActionPerformed del boton Menu Consultar
			 * su funcion es llamar la clase Consultar por medio del objeto de clase Consultar
			 * obtenemos el frame de la ventana Consultar y le damos visibilidad para acceder a ella
			 */
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == btnMenuConsultar) {
					mConsultar = new Consultar(p);
					mConsultar.getFrame().setVisible(true);

				}
			}
		});
		btnMenuConsultar.setBounds(212, 117, 125, 23);
		frame.getContentPane().add(btnMenuConsultar);
	}

	/**
	 * Metodo eliminarJugador
	 * sus funciones buscar el jugador del ArrayList jugadores
	 * compara el nombre del jugador y luego lo elimina 
	 * valida tambien si se elimino o no el jugador y lo muestra por JOption si ya fue o no eliminado
	 * manda por parametro el nombre del jugador 
	 * @param nombre
	 */
	public void eliminarJugador(String nombre)
	{
		boolean validar = false;
		
		for(int i=0 ; i<p.jugadores.size() ; i++)
		{
			if(p.jugadores.get(i).getNombre().equalsIgnoreCase(nombre))
			{
				
				p.jugadores.remove(i);
				JOptionPane.showMessageDialog(null, "El Jugador " + nombre + " ya esta Eliminado");
				validar=true;
			}
		}
		if(!validar) {
			JOptionPane.showMessageDialog(null, "El nombre " + nombre + " no se encuentra");
		}
	}

	/**
	 * metodo de getFrame para obtener todos los atributos del JFrame de la ventana Eliminar
	 * @return frame de la ventana Eliminar
	 */
	public JFrame getFrame() {
		return frame;
	}

	/**
	 * metodo de setFrame para modificar el JFrame de la ventana Eliminar
	 * @param frame
	 */
	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
}//Fin de la Clase Eliminar