package mx.uam.ayd.estetica.presentacion;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import mx.uam.ayd.estetica.Aplicacion;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

public class VentanaPrincipal extends JFrame {

	/*********************   control  ******************************/
	private JPanel contentPane;
	private Aplicacion control;
	private JLabel jLabelInventario;
	private JLabel jLabelAgenda;
	private JLabel jLabelServicio;
	private JLabel jLabelEmpleado;
	private JLabel jLabelCuenta;
	private JButton jButtonConsultarInventario;
	private JButton jButtonModificarInventario;
	private JButton jButtonConsultarCita;
	private JButton jButtonModificarCita;
	private JButton jButtonCancelarCita;
	private JButton jButtonConsultarTrabajo;
	private JButton jButtonModificarTrabajo;
	private JButton jButtonAñadirEmpleado;
	private JButton jButtonConsultarEmpleado = new JButton("Consultar");
	private JButton jButtonConsultarSalario;
	private JButton jButtonAñadirCuenta;
	private JButton jButtonEliminarCuenta;
	/*********************   Constructor  ******************************/
	public VentanaPrincipal(Aplicacion control) {
		this.control = control;

		/******   Init de la Ventana Principal  ******/
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 422, 645);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		jLabelInventario = new JLabel("Inventario");
		jLabelInventario.setFont(new Font("Dialog", Font.BOLD, 16));
		jLabelInventario.setBounds(12, 12, 96, 15);
		contentPane.add(jLabelInventario);

		jLabelAgenda = new JLabel("Agenda");
		jLabelAgenda.setFont(new Font("Dialog", Font.BOLD, 16));
		jLabelAgenda.setBounds(12, 145, 96, 15);
		contentPane.add(jLabelAgenda);

		jLabelServicio = new JLabel("Servicio");
		jLabelServicio.setFont(new Font("Dialog", Font.BOLD, 16));
		jLabelServicio.setBounds(12, 276, 96, 15);
		contentPane.add(jLabelServicio);
		
		jLabelEmpleado = new JLabel("Empleados");
		jLabelEmpleado.setFont(new Font("Dialog", Font.BOLD, 16));
		jLabelEmpleado.setBounds(12, 399, 96, 15);
		contentPane.add(jLabelEmpleado);
		
		jLabelCuenta = new JLabel("Cuenta");
		jLabelCuenta.setFont(new Font("Dialog", Font.BOLD, 16));
		jLabelCuenta.setBounds(12, 520, 96, 15);
		contentPane.add(jLabelCuenta);

		/***********************   BOTONES Y EVENTOS  *************************/
		
		/******   INVENTARIO  ******/
		//CONSULTAR
		jButtonConsultarInventario = new JButton("Consultar");
		jButtonConsultarInventario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				control.modificaConsultaInventario();
			}
		});
		jButtonConsultarInventario.setBounds(143, 41, 114, 64);
		contentPane.add(jButtonConsultarInventario);

		//MODIFICAR
		jButtonModificarInventario = new JButton("Modificar");
		jButtonModificarInventario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				control.modificaConsultaInventario();
			}
		});
		jButtonModificarInventario.setBounds(294, 41, 114, 64);
		contentPane.add(jButtonModificarInventario);

		/******   CITAS  ******/

		//CONSULTA
		jButtonConsultarCita = new JButton("Consultar");
		jButtonConsultarCita.setFont(new Font("Dialog", Font.BOLD, 9));
		jButtonConsultarCita.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				control.modificaConsultaCita();
			}
		});
		jButtonConsultarCita.setBounds(104, 171, 85, 64);
		contentPane.add(jButtonConsultarCita);

		//MODIFICAR
		jButtonModificarCita = new JButton("Modificar");
		jButtonModificarCita.setFont(new Font("Dialog", Font.BOLD, 9));
		jButtonModificarCita.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				control.modificaConsultaCita();
			}
		});
		jButtonModificarCita.setBounds(220, 170, 85, 66);
		contentPane.add(jButtonModificarCita);

		//CANCELAR
		jButtonCancelarCita = new JButton("Cancelar");
		jButtonCancelarCita.setFont(new Font("Dialog", Font.BOLD, 9));
		jButtonCancelarCita.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				control.modificaConsultaCita();
			}
		});
		jButtonCancelarCita.setBounds(323, 170, 85, 66);
		contentPane.add(jButtonCancelarCita);

		/******   TRABAJO  ******/

		//CONSULTA
		jButtonConsultarTrabajo = new JButton("Consultar");
		jButtonConsultarTrabajo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				control.modificaConsultaTrabajo();
			}
		});
		jButtonConsultarTrabajo.setBounds(143, 303, 114, 66);
		contentPane.add(jButtonConsultarTrabajo);

		//MODIFICAR
		jButtonModificarTrabajo = new JButton("Modificar");
		jButtonModificarTrabajo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				control.modificaConsultaTrabajo();
			}
		});
		jButtonModificarTrabajo.setBounds(294, 303, 114, 66);
		contentPane.add(jButtonModificarTrabajo);
		
		/******   EMPLEADO  ******/
		//AñADIR
		
		jButtonAñadirEmpleado = new JButton("Añadir");
		jButtonAñadirEmpleado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				control.añadirEmpleado();
			}
		});
		jButtonAñadirEmpleado.setBounds(10, 430, 85, 64);
		contentPane.add(jButtonAñadirEmpleado);
		
		//CONSULTAR
		jButtonConsultarEmpleado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				control.modificaConsultaEmpleado();
				
			}
		});
		jButtonConsultarEmpleado.setBounds(107, 430, 96, 64);
		contentPane.add(jButtonConsultarEmpleado);
		
		//Consultar sueldo
		
		jButtonConsultarSalario = new JButton("Sueldo");
		jButtonConsultarSalario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				control.consultaSalario();
			}
		});
		jButtonConsultarSalario.setBounds(215, 430, 90, 64);
		contentPane.add(jButtonConsultarSalario);
		
		JButton jButtonEliminarEmpleado = new JButton("Eliminar");
		jButtonEliminarEmpleado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				control.modificaConsultaEmpleado();
				
			}
		});
		jButtonEliminarEmpleado.setBounds(312, 430, 96, 64);
		contentPane.add(jButtonEliminarEmpleado);
		
		jButtonAñadirCuenta = new JButton("Añadir");
		jButtonAñadirCuenta.setBounds(10, 550, 96, 64);
		jButtonAñadirCuenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				control.añadirCuenta();;
			}
		});
		contentPane.add(jButtonAñadirCuenta);
		
		JButton btnElimiarcuenta = new JButton("ElimiarCuenta");
		btnElimiarcuenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				control.eliminarCuenta();
				}
		});
		btnElimiarcuenta.setBounds(155, 549, 150, 46);
		contentPane.add(btnElimiarcuenta);
		
		
		

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
