package mx.uam.ayd.estetica.presentacion;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import mx.uam.ayd.estetica.modelo.Empleado;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaA�adirCuenta extends JFrame {

	private ControlA�adirCuenta controlA�adirCuenta;
	private Empleado[] empleados;
	
	private JPanel contentPane;
	private JTextField JTextFieldNombre;
	private JTextField JTextFieldContrase�a;
	private JLabel JLabelNombre;
	private JLabel JLabelContrase�a;
	private JLabel JLabelEncabezado;
	private JComboBox JcomboBoxEmpleados;
	private JButton JButtonA�adir;
	private JButton JButtonRegresar;
	
	public VentanaA�adirCuenta(ControlA�adirCuenta controlA�adirCuenta) {
		this.controlA�adirCuenta=controlA�adirCuenta;
		//Configuracion de la ventana
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 455, 325);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBackground(Color.WHITE);
		
		//Configuracion de los componentes
		JButtonA�adir = new JButton("A�adir");
		JButtonA�adir.setBounds(56, 250, 117, 25);
		contentPane.add(JButtonA�adir);
		
		JTextFieldNombre = new JTextField();
		JTextFieldNombre.setBounds(234, 85, 151, 19);
		contentPane.add(JTextFieldNombre);
		JTextFieldNombre.setColumns(10);
		
		JLabelNombre = new JLabel("Nombre de cuenta :");
		JLabelNombre.setFont(new Font("Century Schoolbook L", Font.BOLD | Font.ITALIC, 13));
		JLabelNombre.setBounds(56, 89, 138, 15);
		contentPane.add(JLabelNombre);
		
		JLabelContrase�a = new JLabel("Contrase�a :");
		JLabelContrase�a.setFont(new Font("Century Schoolbook L", Font.BOLD | Font.ITALIC, 13));
		JLabelContrase�a.setBounds(78, 136, 102, 15);
		contentPane.add(JLabelContrase�a);
		
		JLabelEncabezado = new JLabel("Crea una nueva Cuenta");
		JLabelEncabezado.setFont(new Font("MathJax_Math", Font.BOLD | Font.ITALIC, 18));
		JLabelEncabezado.setBounds(99, 12, 242, 40);
		contentPane.add(JLabelEncabezado);
		
		JTextFieldContrase�a = new JTextField();
		JTextFieldContrase�a.setBounds(234, 132, 151, 19);
		contentPane.add(JTextFieldContrase�a);
		JTextFieldContrase�a.setColumns(10);
		
		
		JcomboBoxEmpleados = new JComboBox();
		JcomboBoxEmpleados.setBounds(231, 188, 102, 24);
		empleados = controlA�adirCuenta.dameEmpleados();
		JcomboBoxEmpleados.setModel(new DefaultComboBoxModel(controlA�adirCuenta.dameEmpleadosNombre(empleados)));
		
		
		contentPane.add(JcomboBoxEmpleados);
		
		JLabel JLabelEmpleado = new JLabel("Empleado");
		JLabelEmpleado.setFont(new Font("Century Schoolbook L", Font.BOLD | Font.ITALIC, 13));
		JLabelEmpleado.setBounds(138, 195, 102, 15);
		contentPane.add(JLabelEmpleado);
		
		JButtonRegresar = new JButton("Regresar");
		JButtonRegresar.setBounds(243, 250, 117, 25);
		contentPane.add(JButtonRegresar);
		
		//Eventos de los botones
		JButtonA�adir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(JLabelNombre.getText().equals("") || JLabelContrase�a.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Termina de llenar los datos");
				}else {
				String nombre = JTextFieldNombre.getText();
				String nombreEmpleado = JcomboBoxEmpleados.getSelectedItem().toString();
				Empleado empleado = controlA�adirCuenta.buscaEmpleado(nombreEmpleado, empleados);
				String contrase�a = JTextFieldContrase�a.getText();
				if(controlA�adirCuenta.a�adirCuenta(nombre, empleado, contrase�a)) {
					JOptionPane.showMessageDialog(null, "Se ha a�adido correctamente");
				}
			}
			}
		});
		
		JButtonRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
	}
}