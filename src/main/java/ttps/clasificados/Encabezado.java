package ttps.clasificados;

import jakarta.servlet.http.HttpServlet;
import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Encabezado
 */
@WebServlet(description = "servlet para agregar encabezado al servlet de Menú", urlPatterns = { "/Encabezado" })
public class Encabezado extends HttpServlet {
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, jakarta.servlet.http.HttpServletResponse response) throws ServletException, IOException {
		SitioClasificado sc= (SitioClasificado) this.getServletContext().getAttribute("sitio");
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.println("<header>" + sc.getNombre() + " |Email: " + sc.getEmail() + " |Teléfono: " + sc.getTelefono()+ "</header>");
	}

}
