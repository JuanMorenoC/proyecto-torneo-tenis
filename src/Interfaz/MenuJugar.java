package Interfaz;

/**
 * Importamos las librerias
 * Importamos de la Logica la persistencia
 */

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import Logica.Persistencia;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.awt.event.ActionEvent;

/**
 * Clase MenuJugar
 * Su funcion es servir de menu principal para acceder a las fases del torneo
 * Octavos de final, cuartos de final, semifial y final
 * tambien para acceder al menu principal
 */
public class MenuJugar {

	private JFrame frame;
	private OctavosDeFinal mOctavosFinal;
	private CuartosDeFinal mCuartosFinal;
	private SemiFinal mSemiFinal;
	private Final mFinal;
	private Menu menuPrincipal;
	public Persistencia p;

	/**
	 * Constructor MenuJugar
	 * mandamos como parametro la persistencia
	 * @param p
	 * llamamos el metodo initialize
	 */
	public MenuJugar(Persistencia p) {
		this.p = p;
		initialize();
	}

	/**
	 * Metodo initialize
	 * estan todos los componentes con los botones de la ventana MenuJugar
	 * y sus atributos
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblMenuJugar = new JLabel("Menu Jugar");
		lblMenuJugar.setBounds(178, 11, 94, 14);
		frame.getContentPane().add(lblMenuJugar);

		JButton btnOctavosDeFinal = new JButton("Octavos de Final");
		btnOctavosDeFinal.addActionListener(new ActionListener() {
			
			/**
			 * ActionPerformed del boton Octavos de Final
			 * primero comparamos el tamaño de jugadores si son iguales
			 * a el total de jugadores permitidos para jugar esta fase de octavos de final
			 * de lo contrario no se podria jugar
			 * inicializamos el objeto de clase Octavos de Final para acceder a esta clase
			 * mandamos como parametro la persistencia
			 * le damos visibilidad a la ventana de Octavos de Final
			 * y accedemos al metodo dispose para cerrar la ventana una vez que ya no estemos en ella
			 */
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == btnOctavosDeFinal) {
					if (p.jugadores.size() == 16) {
						
						mOctavosFinal = new OctavosDeFinal(p);
						mOctavosFinal.getFrame().setVisible(true);
						frame.dispose();
					} else {
						JOptionPane.showMessageDialog(null, "No se puede jugar");
					}
				}
			}
		});
		btnOctavosDeFinal.setBounds(142, 65, 130, 23);
		frame.getContentPane().add(btnOctavosDeFinal);

		JButton btnCuartosDeFinal = new JButton("Cuartos de Final");
		btnCuartosDeFinal.addActionListener(new ActionListener() {
			
			/**
			 * ActionPerformed del boton Cuartos de Final
			 * primero recorremos en for los jugadores con el estado 2 
			 * que nos asegura si clasificaron a cuartos de final
			 * luego comparamos el tamaño de jugadores si son iguales
			 * a el total de jugadores permitidos para jugar esta fase de cuartos de final
			 * de lo contrario no se podria jugar
			 * inicializamos el objeto de clase Cuartos de Final para acceder a esta clase
			 * mandamos como parametro la persistencia
			 * le damos visibilidad a la ventana de Cuartos de Final
			 * y accedemos al metodo dispose para cerrar la ventana una vez que ya no estemos en ella
			 */
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == btnCuartosDeFinal) {
					int contador=0;
					for (int i = 0; i < p.getJugadores().size(); i++) {
						if(p.getJugadores().get(i).getEstado()==2)
							contador++;
					}
						if(contador==8) {
						mCuartosFinal = new CuartosDeFinal(p);
						mCuartosFinal.getFrame().setVisible(true);
						frame.dispose();
					} else {
						JOptionPane.showMessageDialog(null, "No se puede jugar");
					}
				}
			}
		});
		btnCuartosDeFinal.setBounds(142, 99, 130, 23);
		frame.getContentPane().add(btnCuartosDeFinal);

		JButton btnSemifinal = new JButton("Semifinal");
		btnSemifinal.addActionListener(new ActionListener() {
			
			/**
			 * ActionPerformed del boton SemiFinal
			 * primero recorremos en for los jugadores con el estado 3 
			 * que nos asegura si clasificaron a Semifinal
			 * luego comparamos el tamaño de jugadores si son iguales
			 * a el total de jugadores permitidos para jugar esta fase de Semifinal
			 * de lo contrario no se podria jugar
			 * inicializamos el objeto de clase SemiFinal para acceder a esta clase
			 * mandamos como parametro la persistencia
			 * le damos visibilidad a la ventana de SemiFinal
			 * y accedemos al metodo dispose para cerrar la ventana una vez que ya no estemos en ella
			 */
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == btnSemifinal) {
					int contador=0;
					for (int i = 0; i < p.getJugadores().size(); i++) {
						if(p.getJugadores().get(i).getEstado()==3)
							contador++;
					}
						if(contador==4) {
						mSemiFinal = new SemiFinal(p);
						mSemiFinal.getFrame().setVisible(true);
						frame.dispose();
					} else {
						JOptionPane.showMessageDialog(null, "No se puede jugar");
					}
				}
			}
		});
		btnSemifinal.setBounds(142, 133, 130, 23);
		frame.getContentPane().add(btnSemifinal);

		JButton btnFinal = new JButton("Final");
		btnFinal.addActionListener(new ActionListener() {
			
			/**
			 * ActionPerformed del boton Final
			 * primero recorremos en for los jugadores con el estado 4 
			 * que nos asegura si clasificaron a Final
			 * luego comparamos el tamaño de jugadores si son iguales
			 * a el total de jugadores permitidos para jugar esta fase de Final
			 * de lo contrario no se podria jugar
			 * inicializamos el objeto de clase Final para acceder a esta clase
			 * mandamos como parametro la persistencia
			 * le damos visibilidad a la ventana de Final
			 * y accedemos al metodo dispose para cerrar la ventana una vez que ya no estemos en ella
			 */
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == btnFinal) {
					int contador=0;
					for (int i = 0; i < p.getJugadores().size(); i++) {
						if(p.getJugadores().get(i).getEstado()==4)
							contador++;
					}
						if(contador==2) {
						mFinal = new Final(p);
						mFinal.getFrame().setVisible(true);
						frame.dispose();
					} else {
						JOptionPane.showMessageDialog(null, "No se puede jugar");
					}
				}
			}
		});
		btnFinal.setBounds(142, 167, 130, 23);
		frame.getContentPane().add(btnFinal);

		JButton btnMenu = new JButton("Menu");
		btnMenu.addActionListener(new ActionListener() {
			
			/**
			 * ActionPerformed del boton Menu
			 * inicializamos el objeto de clase Menu para acceder a esta clase
			 * mandamos como parametro la persistencia
			 * le damos visibilidad a la ventana de Menu
			 * y accedemos al metodo dispose para cerrar la ventana una vez que ya no estemos en ella
			 */
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == btnMenu) {
					menuPrincipal = new Menu(p);
					menuPrincipal.setVisible(true);
					frame.setVisible(false);
					frame.dispose();
				}
			}
		});
		btnMenu.setBounds(142, 201, 130, 23);
		frame.getContentPane().add(btnMenu);
	}

	/**
	 * metodo de getFrame para obtener todos los atributos del JFrame de la ventana Menu Jugar
	 * @return frame de la ventana Menu Jugar
	 */
	public JFrame getFrame() {
		return frame;
	}

	/**
	 * metodo de setFrame para modificar el JFrame de la ventana Menu Jugar
	 * @param frame
	 */
	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

}//Fin de la Clase MenuJugar