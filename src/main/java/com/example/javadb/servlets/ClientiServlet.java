package com.example.javadb.servlets;

import com.example.javadb.dao.ClientiJpaDAO;
import com.example.javadb.entities.Cliente;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

/**
 * Servlet implementation class ClientiServlet
 */
public class ClientiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ClientiJpaDAO dao = new ClientiJpaDAO();
		List<Cliente> clienti = dao.findAll();

		request.setAttribute("elenco-clienti", clienti);

		RequestDispatcher rd = request.getRequestDispatcher("clienti.jsp");
		rd.forward(request, response);
	}

}
