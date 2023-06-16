package principal;

import org.hibernate.Session;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import daoImp.ConfigHibernate;
import entidad.Empleado;
import entidad.TipoCuenta;
import entidad.Usuario;

public class Main {

	public static void main(String[] args) {
		
		ConfigHibernate ch = new ConfigHibernate();
		Session session = ch.abrirConexion();
		
		ApplicationContext appContext = new ClassPathXmlApplicationContext("resources/Beans.xml");
		Empleado empleado = (Empleado)appContext.getBean("EmpleadoPepe");
		TipoCuenta tipocuenta = (TipoCuenta)appContext.getBean("TipoCuentaVendedor");
		Usuario usuario = (Usuario)appContext.getBean("UsuarioInicial");
		
		session.save(empleado);
		ch.cerrarSession();

	}

}
