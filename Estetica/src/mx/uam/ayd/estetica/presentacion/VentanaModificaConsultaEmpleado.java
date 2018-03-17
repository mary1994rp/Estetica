package mx.uam.ayd.estetica.presentacion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import mx.uam.ayd.estetica.modelo.Empleado;
import mx.uam.ayd.estetica.modelo.Producto;
import javax.swing.ListSelectionModel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

public class VentanaModificaConsultaEmpleado extends JFrame {

	/* declaracion de componentes usados */
	private JPanel jPanelContenedor;
	private ControlModificaConsultaEmpleado CMCE;
	private JTable jTableEmpleado;
	private JScrollPane scrollPaneContenedorTablaEmpleado;
	private JButton jButtonGuardar;
	private JButton jButtonRegresar;
	private String[] encabezadosJTable;
	private JLabel jLabelTitulo;
	// array que almacenara los productos
	private ArrayList<Empleado> listaEmpleados;

	/* modelo utilizado en el diseño de la tabla */
	private DefaultTableModel modeloJTable = new DefaultTableModel() { // se define el modelo que ocupará la tabla
		Class[] types = new Class[] {
				// definimos los tipos que va a aceptar cada celda
				java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class  };

		// Función que asignará el tipo de campo que asignaste previamente
		public Class getColumnClass(int columnIndex) {
			return types[columnIndex];
		}
	};

	public VentanaModificaConsultaEmpleado(ControlModificaConsultaEmpleado CMCE) {
		
		setType(Type.UTILITY);
		setTitle("Empleados");
		setBackground(Color.WHITE);
		this.CMCE = CMCE;

		/* inicializacion de componentes */
		jPanelContenedor = new JPanel();
		jPanelContenedor.setBackground(Color.WHITE);
		jTableEmpleado = new JTable(modeloJTable) {
			// evitamos q se pueda editar algunas columnas, nos interesa que no se pueda
			// modificar el id
			public boolean isCellEditable(int rowIndex, int colIndex) {
				return colIndex != 0;
			}
		};

		/* configuracion de las ventanas */
		jTableEmpleado.setFillsViewportHeight(true);
		jTableEmpleado.setBackground(Color.WHITE);
		jTableEmpleado.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPaneContenedorTablaEmpleado = new JScrollPane();
		jButtonGuardar = new JButton("Guardar");
		jButtonGuardar.setBackground(new Color(0, 204, 204));
		jButtonRegresar = new JButton("Regresar");
		jButtonRegresar.setBackground(new Color(51, 204, 255));
		encabezadosJTable = new String[] { "Id", "Nombre", "Apellido", "Domicilio", "Fecha", "Sueldo" };

		/*
		 * array de productos temporal, utilizado para almacenar la informacion de la
		 * base de datos
		 */
		listaEmpleados = new ArrayList<Empleado>(Arrays.asList(CMCE.dameEmpleados()));

		/* configuraciones graficas de los componentes */
		jPanelContenedor.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(jPanelContenedor);
		jPanelContenedor.setLayout(null);

		/* scrol que contiene la tabla */
		scrollPaneContenedorTablaEmpleado.setBounds(12, 47, 427, 228);

		jButtonGuardar.setBounds(167, 287, 105, 25);
		jButtonRegresar.setBounds(339, 287, 100, 25);

		modeloJTable.setColumnIdentifiers(encabezadosJTable); // agregamos los encambezados al jtable

		setBounds(100, 100, 459, 358);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		jTableEmpleado.getColumnModel().getColumn(3).setPreferredWidth(116); // armamos el jtable, pegamos toda la
																				// informacion
		scrollPaneContenedorTablaEmpleado.setViewportView(jTableEmpleado); // agreamos un scrollaljtable

		// agregamos todos los elemntos al contenedor

		jPanelContenedor.add(scrollPaneContenedorTablaEmpleado);
		jPanelContenedor.add(jButtonGuardar);
		jPanelContenedor.add(jButtonRegresar);

		/* estilo del titulo */
		jLabelTitulo = new JLabel("Empleados:");
		jLabelTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		jLabelTitulo.setForeground(new Color(105, 105, 105));
		jLabelTitulo.setBackground(new Color(0, 0, 0));
		jLabelTitulo.setFont(new Font("DejaVu Serif", Font.BOLD, 20));
		jLabelTitulo.setBounds(12, 12, 145, 15);
		jPanelContenedor.add(jLabelTitulo);

		/*
		 * for que crea cada fila para el jTable, con la informacion recuperada de la
		 * base de datos
		 */
		
		for (int i = 0; i < listaEmpleados.size(); i++) {
	
				/* arma la tabla que agregara al jtable */
				Object[] nuevaFilaJTable = { listaEmpleados.get(i).dameId(), listaEmpleados.get(i).dameNombre(),
						listaEmpleados.get(i).dameApellido(), listaEmpleados.get(i).dameDomicilio(), listaEmpleados.get(i).dameFecha(), 120 };

				/* agrega una nueva fila al jtable */
				modeloJTable.addRow(nuevaFilaJTable); // agregamos la fila al jTable
			
		}

		/* eventos */

		jButtonRegresar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose(); // oculta la ventana
			}
		});

		jButtonGuardar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				/* variable que almacenara el numero de la fila seleccionada */
				int filaSeleccionada = jTableEmpleado.getSelectedRow();

				/* dialogo que pide confirmacion de cambios */
				int dialogResult = JOptionPane.showConfirmDialog(null,
						"Has modificado la linea " + (filaSeleccionada + 1) + "¿Deseas guardar los cambios?");
				/* si se acepta el dialogo, hacemos la accion de modificar */
				if (dialogResult == JOptionPane.YES_OPTION) {
					try {

						/*
						 * creamos un producto temporal con la informacion modificada en el jTable, para
						 * poder pasarselo como parametro al Control
						 */

						Empleado tempEmpleado = new Empleado(
								jTableEmpleado.getValueAt(filaSeleccionada, 1).toString() + "",
								jTableEmpleado.getValueAt(filaSeleccionada, 2).toString() + "",
								jTableEmpleado.getValueAt(filaSeleccionada, 3).toString() + "",
								jTableEmpleado.getValueAt(filaSeleccionada, 4).toString() + "",
								Integer.parseInt(jTableEmpleado.getValueAt(filaSeleccionada, 3).toString() + ""));//integer??

						/*
						 * le pasamos al metodo actualizaProducto, del control, el nuevo Productotemporal, con
						 * la informacion obtenida en el jtable asi como el identidicador (id), del
						 * producto original, que deseamos sea modificado
						 */

						/*actualizaproductos(producto, id,empleado)
						 * si regresa true esta bien hecha la actualizacion
						 * */
					
					
					} catch (Exception error) {
						System.out.println("ocurrio un error al intentar actualizar");
					}
				}

			}
		});
	}// fin del constructor
}
