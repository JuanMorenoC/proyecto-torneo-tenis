package Interfaz;

/**
 * Importamos las librerias
 * Importamos de Logica la clase Jugador y Persistencia
 */

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Logica.Jugador;
import Logica.Persistencia;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Clase RegistrarJugador
 * Su función es registrar el Jugador con la información requerida
 * nombre, edad y puntos
 */
public class RegistrarJugador {

	private JFrame frame;
	private JTextField textNombre;
	private JTextField textEdad;
	private JTextField textPuntos;
	public String nombre;
	public int edad, puntos, puesto;
	private Persistencia p;
	private Menu menu;

	/**
	 * Constructor RegistarJugador
	 * mandamos como parametro la persistencia
	 * @param p
	 * llamamos el metodo initialize
	 */
	public RegistrarJugador(Persistencia p) {
		this.p=p;
		initialize();
	}

	/**
	 * Metodo initialize
	 * Contiene todos lo componentes y botones de esta ventana Registar Jugador
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 383, 260);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblRegistrarJugador = new JLabel("Registrar Jugador");
		lblRegistrarJugador.setBounds(133, 11, 126, 14);
		frame.getContentPane().add(lblRegistrarJugador);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(31, 58, 61, 14);
		frame.getContentPane().add(lblNombre);
		
		textNombre = new JTextField();
		textNombre.setBounds(102, 55, 228, 20);
		frame.getContentPane().add(textNombre);
		textNombre.setColumns(10);
		
		JLabel lblEdad = new JLabel("Edad:");
		lblEdad.setBounds(31, 97, 46, 14);
		frame.getContentPane().add(lblEdad);
		
		textEdad = new JTextField();
		textEdad.setBounds(102, 94, 228, 20);
		frame.getContentPane().add(textEdad);
		textEdad.setColumns(10);
		
		JLabel lblPuntosRanking = new JLabel("Puntos Ranking:");
		lblPuntosRanking.setBounds(31, 136, 96, 14);
		frame.getContentPane().add(lblPuntosRanking);
		
		textPuntos = new JTextField();
		textPuntos.setBounds(133, 133, 197, 20);
		frame.getContentPane().add(textPuntos);
		textPuntos.setColumns(10);
		
		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.addActionListener(new ActionListener() {
			
			/**
			 * ActionPerformed del boton Registrar
			 * obtenemos el nombre, edad y puntos por medio de los JTextField
			 * creamos e inicializamos el obeto de clase Jugador
			 * y mandamos como parametro el nombre, edad y puntos del jugador
			 * luego lo añadimos al ArrayList jugadores y mostarmos como mensae que ya esta registrado
			 */
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == btnRegistrar)
				{
					nombre = textNombre.getText();
					edad = Integer.parseInt(textEdad.getText());
					puntos = Integer.parseInt(textPuntos.getText());
					Jugador j17 = new Jugador(nombre, edad, puntos,1);
					p.jugadores.add(j17);
					JOptionPane.showMessageDialog(null, "Jugador Registrado");
				}
			}
		});
		btnRegistrar.setBounds(31, 184, 89, 23);
		frame.getContentPane().add(btnRegistrar);
		
		JButton btnMenu = new JButton("Menu");
		btnMenu.addActionListener(new ActionListener() {
			
			/**
			 * ActionPerformed del boton menu
			 * inicializamos el objeto de clase Menu
			 * mandamos como parametro la persistencia
			 * le damos visibilidad a la ventana Menu
			 * y accedemos al metodo dispose para cerrar la ventana una vez que ya eno estemos en ella 
			 */
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == btnMenu)
				{
					menu=new Menu(p);
					menu.setVisible(true);
					frame.dispose();
				}
			}
		});
		btnMenu.setBounds(241, 184, 89, 23);
		frame.getContentPane().add(btnMenu);
	}

	/**
	 * metodo de getFrame para obtener todos los atributos del JFrame de la ventana RegistrarJugador
	 * @return frame de la ventana RegistrarJugador
	 */
	public JFrame getFrame() {
		return frame;
	}

	/**
	 * metodo de setFrame para modificar el JFrame de la ventana RegistrarJugador
	 * @param frame
	 */
	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
}//Fin de la Clase RegistrarJugador