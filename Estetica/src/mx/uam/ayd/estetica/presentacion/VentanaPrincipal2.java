package mx.uam.ayd.estetica.presentacion;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import mx.uam.ayd.estetica.Aplicacion2;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

public class VentanaPrincipal2 extends JFrame {

	/*********************   control  ******************************/
	private JPanel contentPane;
	private Aplicacion2 control;
	private JLabel jLabelInventario;
	private JLabel jLabelAgenda;
	private JLabel jLabelServicio;
	private JButton jButtonAñadirInventario;
	private JButton jButtonAñadirCita; 
	private JButton jButtonAñadirTrabajo;
	private JButton jButtonVenderProducto;

	
	/*********************   Constructor  ******************************/
	public VentanaPrincipal2(Aplicacion2 control) {
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
		jLabelInventario.setBounds(159, 12, 96, 15);
		contentPane.add(jLabelInventario);

		jLabelAgenda = new JLabel("Agenda");
		jLabelAgenda.setFont(new Font("Dialog", Font.BOLD, 16));
		jLabelAgenda.setBounds(176, 117, 96, 15);
		contentPane.add(jLabelAgenda);

		jLabelServicio = new JLabel("Servicio");
		jLabelServicio.setFont(new Font("Dialog", Font.BOLD, 16));
		jLabelServicio.setBounds(159, 242, 96, 15);
		contentPane.add(jLabelServicio);

		/***********************   BOTONES Y EVENTOS  *************************/
		
		/******   INVENTARIO  ******/
		//AñADIR
		jButtonAñadirInventario = new JButton("Añadir");
		jButtonAñadirInventario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				control.añadirInventario();
			}
		});
		jButtonAñadirInventario.setBounds(29, 38, 114, 66);
		contentPane.add(jButtonAñadirInventario);

		//VenderProducto
		jButtonVenderProducto = new JButton("Vender Producto");
		jButtonVenderProducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				control.venderProducto();
			}
		});
		jButtonVenderProducto.setBounds(159, 39, 153, 66);
		contentPane.add(jButtonVenderProducto);
				
		/******   CITAS  ******/
		//AñADIR
		jButtonAñadirCita = new JButton("Añadir");
		jButtonAñadirCita.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				control.añadirCita();
			}
		});
		jButtonAñadirCita.setBounds(159, 148, 85, 66);
		contentPane.add(jButtonAñadirCita);

		/******   TRABAJO  ******/
		//AñADIR
		jButtonAñadirTrabajo = new JButton("Añadir");
		jButtonAñadirTrabajo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				control.añadirTrabajo();
			}
		});
		jButtonAñadirTrabajo.setBounds(148, 273, 114, 66);
		contentPane.add(jButtonAñadirTrabajo);
	}
}