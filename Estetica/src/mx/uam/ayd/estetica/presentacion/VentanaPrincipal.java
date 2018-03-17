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
	private JButton jButtonAñadirInventario;
	private JButton jButtonConsultarInventario;
	private JButton jButtonModificarInventario;
	private JButton jButtonAñadirCita; 
	private JButton jButtonConsultarCita;
	private JButton jButtonModificarCita;
	private JButton jButtonCancelarCita;
	private JButton jButtonAñadirTrabajo;
	private JButton jButtonConsultarTrabajo;
	private JButton jButtonModificarTrabajo;
	
	/*********************   Constructor  ******************************/
	public VentanaPrincipal(Aplicacion control) {
		this.control = control;

		/******   Init de la Ventana Principal  ******/
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 422, 451);
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

		/***********************   BOTONES Y EVENTOS  *************************/
		
		/******   INVENTARIO  ******/
		//AÑADIR
		jButtonAñadirInventario = new JButton("Añadir");
		jButtonAñadirInventario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				control.añadirInventario();
			}
		});
		jButtonAñadirInventario.setBounds(17, 39, 114, 66);
		contentPane.add(jButtonAñadirInventario);

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
		jButtonModificarInventario.setBounds(269, 41, 114, 64);
		contentPane.add(jButtonModificarInventario);

		/******   CITAS  ******/
		//AÑADIR
		jButtonAñadirCita = new JButton("Añadir");
		jButtonAñadirCita.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				control.añadirCita();
			}
		});
		jButtonAñadirCita.setBounds(12, 171, 85, 66);
		contentPane.add(jButtonAñadirCita);

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
		jButtonModificarCita.setBounds(201, 171, 85, 66);
		contentPane.add(jButtonModificarCita);

		//CANCELAR
		jButtonCancelarCita = new JButton("Cancelar");
		jButtonCancelarCita.setFont(new Font("Dialog", Font.BOLD, 9));
		jButtonCancelarCita.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				control.modificaConsultaCita();
			}
		});
		jButtonCancelarCita.setBounds(298, 171, 85, 66);
		contentPane.add(jButtonCancelarCita);

		/******   TRABAJO  ******/
		//AÑADIR
		jButtonAñadirTrabajo = new JButton("Añadir");
		jButtonAñadirTrabajo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				control.añadirTrabajo();
			}
		});
		jButtonAñadirTrabajo.setBounds(12, 303, 114, 66);
		contentPane.add(jButtonAñadirTrabajo);

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
		jButtonModificarTrabajo.setBounds(269, 303, 114, 66);
		contentPane.add(jButtonModificarTrabajo);
	}
}