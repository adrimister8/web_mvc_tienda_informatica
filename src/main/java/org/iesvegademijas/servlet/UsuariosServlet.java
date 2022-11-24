package org.iesvegademijas.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import static java.util.stream.Collectors.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.iesvegademijas.dao.UsuarioDAO;
import org.iesvegademijas.dao.UsuarioDAOImpl;
import org.iesvegademijas.model.Usuario;

public class UsuariosServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
		
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		RequestDispatcher dispatcher = null;
				
		String pathInfo = request.getPathInfo(); 
		
		
			
		if (pathInfo == null || "/".equals(pathInfo)) {
			UsuarioDAO usuDAO = new UsuarioDAOImpl();
				
			request.setAttribute("listausuarios", usuDAO.getAll());
			
			
			//GET 
			//	/fabricantes/
			//	/fabricantes
			
	
			dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/usuarios.jsp");
			        		       
		} else {
			// GET
			// 		/usuario/{id}
			// 		/usuario/{id}/
			// 		/usuario/edit/{id}
			// 		/usuario/edit/{id}/
			// 		/usuario/create
			// 		/usuario/create/
			
			pathInfo = pathInfo.replaceAll("/$", "");
			String[] pathParts = pathInfo.split("/");
			
			if (pathParts.length == 2 && "crear".equals(pathParts[1])) {
				
				// GET
				// /fabricantes/create								
				
				dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/crear-usuario.jsp");								
			
			} else if (pathParts.length == 2) {
				UsuarioDAO proDAO = new UsuarioDAOImpl();
				// GET
				// /usuarios/{id}
				try {
					
					request.setAttribute("usuario",proDAO.find(Integer.parseInt(pathParts[1])));
				
					
					dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/detalle-usuario.jsp");
					        								
				} catch (NumberFormatException nfe) {
					nfe.printStackTrace();
					dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/usuarios.jsp");
				}
				
			} else if (pathParts.length == 3 && "editar".equals(pathParts[1]) ) {
				UsuarioDAO usuDAO = new UsuarioDAOImpl();
				
				// GET
				// /usuarios/edit/{id}
				try {
					
					
					
					request.setAttribute("usuario",usuDAO.find(Integer.parseInt(pathParts[2])));
					dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/editar-usuario.jsp");
					        								
				} catch (NumberFormatException nfe) {
					nfe.printStackTrace();
					dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/usuarios.jsp");
				}
				
				
			} else {
				
				System.out.println("Opción POST no soportada.");
				dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/usuarios.jsp");
			
			}
			
		}
		
		dispatcher.forward(request, response);
			 
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		RequestDispatcher dispatcher;
		String __method__ = request.getParameter("__method__");
		
		if (__method__ == null) {
			// Crear uno nuevo
			UsuarioDAO usuDAO = new UsuarioDAOImpl();
			
			String usuario = request.getParameter("usuario");
			String password = request.getParameter("password");
			String rol = request.getParameter("rol");
			
			Usuario nuevoUsu = new Usuario();
			nuevoUsu.setUsuario(usuario);
			nuevoUsu.setPassword(password);
			nuevoUsu.setRol(rol);
			usuDAO.create(nuevoUsu);			
			
		} else if (__method__ != null && "put".equalsIgnoreCase(__method__)) {			
			// Actualizar uno existente
			//Dado que los forms de html sólo soportan method GET y POST utilizo parámetro oculto para indicar la operación de actulización PUT.
			doPut(request, response);
			
		
		} else if (__method__ != null && "delete".equalsIgnoreCase(__method__)) {			
			// Actualizar uno existente
			//Dado que los forms de html sólo soportan method GET y POST utilizo parámetro oculto para indicar la operación de actulización DELETE.
			doDelete(request, response);
			
			
			
		} else {
			
			System.out.println("Opción POST no soportada.");
			
		}
		
		response.sendRedirect("/tienda_informatica/usuarios");
		//response.sendRedirect("/tienda_informatica/fabricantes");
		
		
	}
	
	
	@Override
	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		UsuarioDAO usuDAO = new UsuarioDAOImpl();
		String codigo = request.getParameter("codigo");
		String usuario = request.getParameter("usuario");
		String password = request.getParameter("password");
		String rol = request.getParameter("rol");
		Usuario usu = new Usuario();
		
		try {
			
			int id = Integer.parseInt(codigo);
			
			usu.setCodigo(id);
			usu.setUsuario(usuario);
			usu.setPassword(password);
			usu.setRol(rol);
			usuDAO.update(usu);
			
		} catch (NumberFormatException nfe) {
			nfe.printStackTrace();
		}
		
	}
	
	@Override
	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		RequestDispatcher dispatcher;
		UsuarioDAO usuDAO = new UsuarioDAOImpl();
		String codigo = request.getParameter("codigo");
		
		try {
			
			int id = Integer.parseInt(codigo);
		
		usuDAO.delete(id);
			
		} catch (NumberFormatException nfe) {
			nfe.printStackTrace();
		}
		
	}
	
}
