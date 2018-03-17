package mx.uam.ayd.estetica;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import mx.uam.ayd.estetica.negocio.ServicioCuenta;
import mx.uam.ayd.estetica.persistencia.DAOCuentas;


public class Login extends JFrame{
	
	private DAOCuentas daoCuentas;
	private ServicioCuenta servicioCuenta;
	
	JLabel usuario;
	JLabel contraseña;
	JTextField tf_usuario;
	JPasswordField tf_contraseña;
	JButton ingresar;
	JButton salir;

	public Login() {
		
		
		//inicializamos el DAOCuenta
		daoCuentas = new DAOCuentas();
		//inicializamos los Servicios
		servicioCuenta = new ServicioCuenta(daoCuentas);
		
				
		setTitle("Login");
		setLocationRelativeTo(null);
		setLayout(null);
		setSize(250,250);
		llenadoInit();
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public void llenadoInit() {
		
		usuario = new JLabel("Usuario: ");
		contraseña= new JLabel("Contraseña: ");
		tf_usuario = new JTextField("");
		tf_contraseña = new JPasswordField();
		ingresar = new JButton("Ingresar");
		salir = new JButton("Salir");
		
		usuario.setBounds(20,20,80,10);
		tf_usuario.setBounds(100,18,100,20);
		contraseña.setBounds(20,50,100,10);
		tf_contraseña.setBounds(110,45,100,20);
		
		ingresar.setBounds(20,110,100,28);
		salir.setBounds(130,110,100,28);
		
	ingresar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				if((tf_usuario.getText().equals("miriam"))&&(String.valueOf(tf_contraseña.getPassword()).equals("123"))) {
					Aplicacion app = new Aplicacion();
					dispose();
					app.inicia();
				}else {
					Aplicacion2 app = new Aplicacion2();
					dispose();
					app.inicia();
					
				}
				
				
			}
		});
		
		salir.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				
			}
		});
		
		
		add(usuario);
		add(contraseña);
		add(tf_usuario);
		add(tf_contraseña);
		add(ingresar);
		add(salir);
		
		
		
	}

	//arranca el Sistema
		public static void main(String[] args) {
			Login log = new Login();
			
		}
	


}
