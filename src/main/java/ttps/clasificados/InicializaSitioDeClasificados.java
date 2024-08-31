package ttps.clasificados;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;


/*Este Listener escucha la creación y la destrucción de la aplicacion. 
 * Con esto puedo ejecutar codigo antes de que se ejecute cualquier servlet,
 * JSP o filtro.
 */
@WebListener
public class InicializaSitioDeClasificados implements ServletContextListener {

  
    public void contextDestroyed(ServletContextEvent sce) { }
    
    
    public void contextInitialized(ServletContextEvent servletContextEvent) {	
    	//pasen contexto
    	ServletContext contexto= servletContextEvent.getServletContext();
    	
    	/*Se crea un objeto Sitio clasificado y esa instancia 
    	 * la guarda en el contexto de la aplicación con la clave:
    	 * "sitio"
    	 */
    	contexto.setAttribute("sitio", crearSitioDeClasificados(servletContextEvent));
    	
    }
    
    
    private SitioClasificado crearSitioDeClasificados(ServletContextEvent servletContextEvent) {
    	String nombreSitio= servletContextEvent.getServletContext().getInitParameter("nombre");
    	String email = servletContextEvent.getServletContext().getInitParameter("email");
    	String telefono = servletContextEvent.getServletContext().getInitParameter("telefono");
    	return new SitioClasificado(nombreSitio,email,telefono);
    }
	
}
