package com.example.javadb.servlets;

import com.example.javadb.dao.RegioneJpaDAO;
import com.example.javadb.entities.Regione;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

/**
 * Servlet implementation class RegioniServlet
 */
public class RegioniServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// otteniamo i dati per il Model
		RegioneJpaDAO rJpaDao = new RegioneJpaDAO();
		// "regioni" diventa il Model pieno di dati
		List<Regione> regioni = rJpaDao.findAll();

		// passare il model "regioni" alla regioni.jsp (View)
		request.setAttribute("elenco-regioni", regioni);

		// attivare la regioni.jsp (View) perchè completi la response
		RequestDispatcher rd = request.getRequestDispatcher("regioni.jsp");
		rd.forward(request, response); // cedo il controllo

	}

}
