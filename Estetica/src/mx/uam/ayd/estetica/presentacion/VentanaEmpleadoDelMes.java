package mx.uam.ayd.estetica.presentacion;

import java.awt.Color;
import java.awt.Font;
import java.awt.Window.Type;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class VentanaEmpleadoDelMes extends JFrame{

	private JPanel jPanelContenedor;
	private ControlEmpleadoDelmes CEM;
	private JTable jTableInventario;
	private JScrollPane scrollPaneContenedorTablaInventario;
	private JButton jButtonRegresar;
	private String[] encabezadosJTable;
	private JLabel jLabelTitulo;
	private JLabel jLabelEmpleado;
	
	private DefaultTableModel modeloJTable = new DefaultTableModel() { // se define el modelo que ocupará la tabla
		Class[] types = new Class[] {
				// definimos los tipos que va a aceptar cada celda
				java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class };

		// Función que asignará el tipo de campo que asignaste previamente
		public Class getColumnClass(int columnIndex) {
			return types[columnIndex];
		}
	};
	public VentanaEmpleadoDelMes(ControlEmpleadoDelmes CEM) {
		this.CEM=CEM;
		setType(Type.UTILITY);
		setTitle("Inventario");
		setBackground(Color.WHITE);
		jPanelContenedor = new JPanel();
		jPanelContenedor.setBackground(Color.WHITE);
		jTableInventario = new JTable(modeloJTable) {
			// evitamos q se pueda editar algunas columnas, nos interesa que no se pueda
			// modificar el id
			public boolean isCellEditable(int rowIndex, int colIndex) {
				return colIndex != 0;
			}
		};
		
		/* configuracion de las ventanas */
		jTableInventario.setFillsViewportHeight(true);
		jTableInventario.setBackground(Color.WHITE);
		jTableInventario.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPaneContenedorTablaInventario = new JScrollPane();
		jButtonRegresar = new JButton("Regresar");
		jButtonRegresar.setBackground(new Color(0, 204, 204));
		encabezadosJTable = new String[] { "Empleado", "N.Trabajos", "Salario" };
		
		/* configuraciones graficas de los componentes */
		jPanelContenedor.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(jPanelContenedor);
		jPanelContenedor.setLayout(null);

		/* scrol que contiene la tabla */
		scrollPaneContenedorTablaInventario.setBounds(20, 100, 390, 170);

		jButtonRegresar.setBounds(167, 287, 105, 25);

		modeloJTable.setColumnIdentifiers(encabezadosJTable);
		setBounds(100, 100, 440, 358);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		jTableInventario.getColumnModel().getColumn(2).setPreferredWidth(100);
		scrollPaneContenedorTablaInventario.setViewportView(jTableInventario);
		
		jPanelContenedor.add(scrollPaneContenedorTablaInventario);
		jPanelContenedor.add(jButtonRegresar);

		/* estilo del titulo */
		jLabelTitulo = new JLabel("Empleado del Mes");
		jLabelTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		jLabelTitulo.setForeground(new Color(105, 105, 105));
		jLabelTitulo.setBackground(new Color(0, 0, 0));
		jLabelTitulo.setFont(new Font("DejaVu Serif", Font.BOLD, 20));
		jLabelTitulo.setBounds(100, 15, 250, 20);
		jPanelContenedor.add(jLabelTitulo);
		//Empleado
		jLabelEmpleado = new JLabel("Miriam");
		jLabelEmpleado.setHorizontalAlignment(SwingConstants.CENTER);
		jLabelEmpleado.setForeground(new Color(105, 105, 105));
		jLabelEmpleado.setBackground(new Color(0, 0, 0));
		jLabelEmpleado.setFont(new Font("DejaVu Serif", Font.BOLD, 20));
		jLabelEmpleado.setBounds(180, 45, 100, 20);
		jPanelContenedor.add(jLabelEmpleado);
		
		
	}

}
