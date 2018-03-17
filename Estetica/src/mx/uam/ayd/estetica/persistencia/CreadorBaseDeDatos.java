package mx.uam.ayd.estetica.persistencia;


import java.sql.Connection;
import java.sql.Statement;

public class CreadorBaseDeDatos {

	/**
	 * @param args
	 */
	
	public static void main(String[] args)
	{
		try
		{
			//inicia la conexion con la base de datos
			Connection connection = ManejadorBD.dameConnection();
			//inicia el statement para poder usar los querys
			Statement statement = connection.createStatement();
			
			//crea tabla Producto en la base de datos y dos productos para prueba
			
			statement.execute("create table Producto(idProducto INTEGER PRIMARY KEY not null GENERATED ALWAYS AS IDENTITY (START WITH 0, INCREMENT BY 1), nombre varchar(40), marca varchar(40), pzaExistencia int)"); // , CONSTRAINT primary_key PRIMARY KEY (autorId)
			statement.execute("insert into Producto values (DEFAULT,'ninguno','ninguno',0)",Statement.RETURN_GENERATED_KEYS);
			statement.execute("insert into Producto values (DEFAULT,'Kit 81', 'Wella', 19)",Statement.RETURN_GENERATED_KEYS);
			statement.execute("insert into Producto values (DEFAULT,'LE VERNIS', 'Chanel', 23)",Statement.RETURN_GENERATED_KEYS);

			System.out.println("Tabla de Productos creada exitosamente");
			
			
			//crea tabla Empleado en la base de datos y 5 empleados
			statement.execute("create table Empleado(idEmpleado INTEGER PRIMARY KEY not null GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), nombre varchar(40))"); // , CONSTRAINT primary_key PRIMARY KEY (autorId)
			statement.execute("insert into Empleado values (DEFAULT,'Miriam')",Statement.RETURN_GENERATED_KEYS);
			statement.execute("insert into Empleado values (DEFAULT,'Dulce')",Statement.RETURN_GENERATED_KEYS);
			statement.execute("insert into Empleado values (DEFAULT,'Ricardo')",Statement.RETURN_GENERATED_KEYS);
			statement.execute("insert into Empleado values (DEFAULT,'yahir')",Statement.RETURN_GENERATED_KEYS);
			statement.execute("insert into Empleado values (DEFAULT,'Karina')",Statement.RETURN_GENERATED_KEYS);
			System.out.println("Tabla de Empleados creada exitosamente");
			
			//crea tabla Trabajo en la base de datos
			statement.execute("create table Trabajo(idTrabajo INTEGER PRIMARY KEY not null GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), nombre varchar(40), idEmpleado int, descripcion varchar(80), monto double, fecha date, idProducto int, pzaUsadas int)"); // , CONSTRAINT primary_key PRIMARY KEY (autorId)
			statement.execute("insert into Trabajo values (DEFAULT,'uñas',1,'No se uso todo el esmalte',150.0,'2017-11-10',1,1)",Statement.RETURN_GENERATED_KEYS);
			statement.execute("insert into Trabajo values (DEFAULT,'Tinte',2,'Se ocupo el tinte completo',90.0,'2017-10-09',1,1)",Statement.RETURN_GENERATED_KEYS);
			System.out.println("Tabla de Trabajos creada exitosamente");
			
			//crea tabla Cita en la base de datos
			statement.execute("create table Cita(idCita INTEGER PRIMARY KEY not null GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), idEmpleado int, nombreCliente varchar(80), fecha timestamp, descripcion varchar(300))"); // , CONSTRAINT primary_key PRIMARY KEY (autorId)
			statement.execute("insert into Cita values (DEFAULT,1,'angel','2017-12-07 12:00:00','hola')",Statement.RETURN_GENERATED_KEYS);
			statement.execute("insert into Cita values (DEFAULT,2,'esteban','2017-12-07 12:00:00','corte de peluca')",Statement.RETURN_GENERATED_KEYS);
			System.out.println("Tabla de Cita creada exitosamente");
			
			//termina la conexion con la base de datos
			ManejadorBD.termina();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}




	}

}
