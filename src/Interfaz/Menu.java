package Interfaz;

/**
 * Importamos la Logica de Jugador y Persistencia
 * tambien importamos las librerias de swing, util y awt
 */

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Logica.Jugador;
import Logica.Persistencia;

/**
 * Clase Menu donde sera el menu principal del juego
 */
public class Menu extends JFrame {

	private JPanel contentPane;
	private TablaJugadores tj;
	private MenuJugar juego;
	private Consultar mConsulta;
	private RegistrarJugador registro;
	public ArrayList<Jugador> jugadores;//Declaracion del ArrayList de jugadores de clase Jugador
	public Persistencia p;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Constructor de la Clase Menu mandamos como parametro la persistencia
	 * Creacion del JFrame
	 * @param p 
	 * @param jugadores 
	 */
	public Menu(Persistencia p) {
		this.p=p;
		jugadores=p.getJugadores();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 349);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel titulo = new JLabel("Menu");
		titulo.setBounds(185, 11, 31, 22);
		contentPane.add(titulo);
		
		JButton jugar = new JButton("Jugar");
		jugar.addActionListener(new ActionListener() {
			
			/**
			 * ActionPerformed del Boton Jugar mandamos la persistencia como parametro,
			 * le damos visibilidad para activarlo e instanciamos la clase para acceder a ella
			 */
			public void actionPerformed(ActionEvent e) {
				juego=new MenuJugar(p);
				juego.getFrame().setVisible(true);
				setVisible(false);
			}
		});
		jugar.setBounds(126, 77, 171, 23);
		contentPane.add(jugar);
		
		JButton tablaJugadores = new JButton("Tabla de Jugadores");
		tablaJugadores.addActionListener(new ActionListener() {
			
			/**
			 * ActionPerformed del Boton Tabla de Jugadores mandamos la persistencia como parametro,
			 * le damos visibilidad para activarlo e instanciamos la clase para acceder a ella
			 */
			public void actionPerformed(ActionEvent e) {
				tj=new TablaJugadores(p);
				tj.setVisible(true);
				setVisible(false);
			}
		});
		tablaJugadores.setBounds(126, 111, 171, 23);
		contentPane.add(tablaJugadores);
		
		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			
			/**
			 * ActionPerformed del Boton Consultar mandamos la persistencia como parametro,
			 * le damos visibilidad para activarlo e instanciamos la clase para acceder a ella
			 */
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == btnConsultar)
				{
					mConsulta=new Consultar(p);
					mConsulta.getFrame().setVisible(true);
					setVisible(false);
				}
			}
		});
		btnConsultar.setBounds(126, 145, 171, 23);
		contentPane.add(btnConsultar);
		
		JButton btnRegistroDeJugadores = new JButton("Registro de Jugadores");
		btnRegistroDeJugadores.addActionListener(new ActionListener() {
			
			/**
			 * ActionPerformed del Boton Registro de Jugadores mandamos la persistencia como parametro,
			 * le damos visibilidad para activarlo e instanciamos la clase para acceder a ella
			 */
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == btnRegistroDeJugadores)
				{
					registro=new RegistrarJugador(p);
					registro.getFrame().setVisible(true);
					setVisible(false);
				}
			}
		});
		btnRegistroDeJugadores.setBounds(126, 179, 171, 23);
		contentPane.add(btnRegistroDeJugadores);
	}
	
}//Fin de la Clase Menu