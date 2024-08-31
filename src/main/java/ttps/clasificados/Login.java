package ttps.clasificados;

import java.io.IOException;
import java.util.ArrayList;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	
	private ArrayList<Usuario> userList;

	@Override
	public void init() throws ServletException {
		super.init();
		userList = new ArrayList();
		userList.add(new Usuario("publicador","1234",role.PUBLICADOR.toString()));
		userList.add(new Usuario("administrador","1234",role.ADMINISTRADOR.toString()));
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user= request.getParameter("user");
		String password= request.getParameter("password");
		String perfil = "";
		boolean authenticated =false;
		
		for(Usuario u: this.userList) {			
			if(u.getUser().equals(user) && u.getPassword().equals(password)) {
				authenticated=true;
				perfil=  u.getType().toString();
				break;
			}	
		}
		if (authenticated) {
			RequestDispatcher dispatcher= getServletContext().getRequestDispatcher("/Menu");
			if (dispatcher != null) {
				request.setAttribute("perfil", perfil); 
				dispatcher.forward(request, response);
				return;
			}
		}
		response.sendRedirect("/clasificados/error.html");
		
	}
	

}


//Version sendRedirect

/*
@WebServlet("/Login")
public class Login extends HttpServlet {
	
	private ArrayList<Usuario> userList;

	@Override
	public void init() throws ServletException {
		super.init();
		userList = new ArrayList();
		userList.add(new Usuario("publicador","1234",role.PUBLICADOR.toString()));
		userList.add(new Usuario("administrador","1234",role.ADMINISTRADOR.toString()));
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user= request.getParameter("user");
		String password= request.getParameter("password");
		String perfil = "";
		boolean authenticated =false;
		System.out.println(userList.toString());
		
		for(Usuario u: this.userList) {
			System.out.println(u.getPassword() + " " + u.getUser());
			System.out.println(password+ " " + user);
			
			if(u.getUser().equals(user) && u.getPassword().equals(password)) {
				authenticated=true;
				perfil=  u.getType().toString();
				break;
			}	
		}
		if (authenticated) {
			if(perfil.equals(role.ADMINISTRADOR.toString())) {
				response.sendRedirect("/clasificados/administrador.html");
				return;
			}
			response.sendRedirect("/clasificados/publicador.html");				
			return;
		}
		response.sendRedirect("/clasificados/error.html");
		
	}

}
*/