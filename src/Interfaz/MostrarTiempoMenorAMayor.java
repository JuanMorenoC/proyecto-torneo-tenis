package Interfaz;

/**
 * Importamos las librerias
 * Importamos  de Logica la clase Jugador, Partido y Persistencia
 */

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import Logica.Jugador;
import Logica.Partido;
import Logica.Persistencia;

import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.GroupLayout.Alignment;

/**
 * Clase Mostrar Tiempo Menor a Mayor
 * su funcion es mostrar la cancha con los jugadores
 * ya con el tiempo desde Menor a Mayor tiempo
 */
public class MostrarTiempoMenorAMayor extends JFrame {

	private JPanel contentPane;
	private JTable table;
	public ArrayList<Partido> partidos;//Declaracion ArrayList partidos
	private DefaultTableModel md;
	private Consultar menuPrincipal;
	public Persistencia p;


	public MostrarTiempoMenorAMayor(Persistencia p) {
		this.p = p;
		this.partidos = p.getPartidos();
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
		md = new DefaultTableModel(new Object[][] {}, new String[] { "Cancha", "Tiempo", "Jugador 1","Jugador 2" });

		/**
		 * se agrega el modelo de la tabla a la tabla para mostrar la información
		 */
		table = new JTable(md);
		rellenarTabla();
		contentPane.setLayout(null);
		scrollPane.setViewportView(table);
		contentPane.add(scrollPane);
		JButton btnMenu = new JButton("Menu");
		btnMenu.addActionListener(new ActionListener() {
			
			/**
			 * ActionPerformed del boton Menu
			 * inicializamos el objeto de clase Consultar
			 * le mandamos por parametro la persistencia
			 * le damos visibilidad de la ventana Consultar
			 */
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == btnMenu) {
					menuPrincipal = new Consultar(p);
					menuPrincipal.getFrame().setVisible(true);
					setVisible(false);
				}

			}
		});
		btnMenu.setBounds(175, 281, 89, 23);
		contentPane.add(btnMenu);
	}
	
	/**
	 * Metodo Rellenar Tabla
	 * por medio de un forEach recorremos el ArrayList de los jugadores
	 *  creamos e inicializamos el objeto de un arreglo de tamaño 4
	 *  para luego rellenarlo  obteniendo el nombre de la pista, tiempo y nombres de los 2 jugadores
	 *  luego lo añadimos al modelo por filas, para luego ser mostrados
	 */
	private void rellenarTabla() {

		for (Partido partido : partidos) {
			Object[] arreglo = new Object[4];
			arreglo[0] = partido.getPista().getNombrePista();
			arreglo[1] = partido.getHora()*60+partido.getMinuto();
			arreglo[2] = partido.getJugador1().getNombre();
			arreglo[3] = partido.getJugador2().getNombre();
			md.addRow(arreglo);
		}

	}
	
	/**
	 * Metodo Burbuja
	 * recorremos el ArrayList partidos
	 * para comparar los partidos y asi saber cual es el partido con mayor tiempo y con menor tiempo
	 * pero ya organizados y modificarlos en el mismo ArrayList partidos
	 */
	public void burbuja()
    {
		int i, j;
		Partido aux,aux2;// Declaramos 2 objetos de clase Partido como auxiliares
		
        for(i=0;i<partidos.size();i++)
             for(j=0;j<partidos.size()-i-1;j++)
                  if(partidos.get(j+1).compareTo(partidos.get(j))>0){
                     aux=partidos.get(j+1);
                     aux2=partidos.get(j);
                     partidos.set(j+1,aux2);
                     partidos.set(j, aux);
                  }
    }
}//Fin de la Clase MostrarTiempoMenorAMayor