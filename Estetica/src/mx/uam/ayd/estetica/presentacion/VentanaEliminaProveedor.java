package mx.uam.ayd.estetica.presentacion;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Window.Type;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import mx.uam.ayd.estetica.modelo.Cuenta;
import mx.uam.ayd.estetica.modelo.Proveedor;

public class VentanaEliminaProveedor extends JFrame {

	/* declaracion de componentes usados */
	private JPanel jPanelContenedor;
	private ControlEliminaProveedor CEP;
	private JTable jTableProveedores;
	private JScrollPane scrollPaneContenedorTablaProveedor;
	private JButton jButtonEliminar;
	private JButton jButtonRegresar;
	private String[] encabezadosJTable;
	private JLabel jLabelTitulo;
	// array que almacenara los productos
	private ArrayList<Proveedor> listaProveedores;

	/* modelo utilizado en el diseño de la tabla */
	private DefaultTableModel modeloJTable = new DefaultTableModel() { // se define el modelo que ocupará la tabla
		Class[] types = new Class[] {
				// definimos los tipos que va a aceptar cada celda
				java.lang.Integer.class, java.lang.String.class, java.lang.String.class,java.lang.String.class ,java.lang.String.class  };

		// Función que asignará el tipo de campo que asignaste previamente
		public Class getColumnClass(int columnIndex) {
			return types[columnIndex];
		}
	};

	public VentanaEliminaProveedor(ControlEliminaProveedor CEP) {
		
		setType(Type.UTILITY);
		setTitle("PROVEEDORES");
		setBackground(Color.WHITE);
		this.CEP = CEP;

		/* inicializacion de componentes */
		jPanelContenedor = new JPanel();
		jPanelContenedor.setBackground(Color.WHITE);
		jTableProveedores = new JTable(modeloJTable) {
			// evitamos q se pueda editar algunas columnas, nos interesa que no se pueda
			// modificar el id
			public boolean isCellEditable(int rowIndex, int colIndex) {
				return colIndex != 0;
			}
		};

		/* configuracion de las ventanas */
		jTableProveedores.setFillsViewportHeight(true);
		jTableProveedores.setBackground(Color.WHITE);
		jTableProveedores.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPaneContenedorTablaProveedor = new JScrollPane();
		jButtonEliminar = new JButton("Eliminar");
		jButtonEliminar.setBackground(new Color(0, 204, 204));
		jButtonRegresar = new JButton("Regresar");
		jButtonRegresar.setBackground(new Color(51, 204, 255));
		encabezadosJTable = new String[] { "ID","NombreProvedor", "Domicilio", "Descripcion","Telefono"};

		/*
		 * array de provedores temporal, utilizado para almacenar la informacion de la
		 * base de datos
		 */
		listaProveedores = new ArrayList<Proveedor>(Arrays.asList(CEP.dameProveedores()));

		/* configuraciones graficas de los componentes */
		jPanelContenedor.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(jPanelContenedor);
		jPanelContenedor.setLayout(null);

		/* scrol que contiene la tabla */
		scrollPaneContenedorTablaProveedor.setBounds(12, 47, 427, 228);

		jButtonEliminar.setBounds(167, 287, 105, 25);
		jButtonRegresar.setBounds(339, 287, 100, 25);

		modeloJTable.setColumnIdentifiers(encabezadosJTable); // agregamos los encambezados al jtable

		setBounds(100, 100, 459, 358);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		jTableProveedores.getColumnModel().getColumn(0).setPreferredWidth(116); // armamos el jtable, pegamos toda la
																				// informacion
		scrollPaneContenedorTablaProveedor.setViewportView(jTableProveedores); // agreamos un scrollaljtable

		// agregamos todos los elemntos al contenedor

		jPanelContenedor.add(scrollPaneContenedorTablaProveedor);
		jPanelContenedor.add(jButtonEliminar);
		jPanelContenedor.add(jButtonRegresar);

		/* estilo del titulo */
		jLabelTitulo = new JLabel("Proveedoress:");
		jLabelTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		jLabelTitulo.setForeground(new Color(105, 105, 105));
		jLabelTitulo.setBackground(new Color(0, 0, 0));
		jLabelTitulo.setFont(new Font("DejaVu Serif", Font.BOLD, 20));
		jLabelTitulo.setBounds(12, 12, 212, 15);
		jPanelContenedor.add(jLabelTitulo);

		/*
		 * for que crea cada fila para el jTable, con la informacion recuperada de la
		 * base de datos
		 */
		
		for (int i = 0; i < listaProveedores.size(); i++) {
	
				/* arma la tabla que agregara al jtable */
				Object[] nuevaFilaJTable = { listaProveedores.get(i).dameId(), listaProveedores.get(i).dameNombre(),listaProveedores.get(i).dameDomicilio(),listaProveedores.get(i).dameDescripcion(),listaProveedores.get(i).dameTelefono()};

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

		jButtonEliminar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				/* variable que almacenara el numero de la fila seleccionada */
				int filaSeleccionada = jTableProveedores.getSelectedRow();

				/* dialogo que pide confirmacion de cambios */
				int dialogResult = JOptionPane.showConfirmDialog(null,
						"¿Deseas eliminar al empleado de la linea? " + (filaSeleccionada + 1));
				/* si se acepta el dialogo, hacemos la accion de modificar */
				if (dialogResult == JOptionPane.YES_OPTION) {
					try {

							CEP.quitaProveedor(Integer.parseInt(jTableProveedores.getValueAt(filaSeleccionada, 0).toString() + ""));
							modeloJTable.removeRow((filaSeleccionada)); // borramos la fila q se modifico
														
					
					} catch (Exception error) {
						System.out.println("ocurrio un error al intentar eliminar");
					}
				}

			}
		});
	}// fin del constructor

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}