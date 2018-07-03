package ru.yandex.sergaidm;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "StartingServlet", urlPatterns = { "/start" })
public class StartingServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ManagerDAO managerDAO = new ManagerDAO();
		FlatDAO flatsDB = managerDAO.getFlatDAO();
		List<Flat> flats = flatsDB.getFlatsList();
		request.setAttribute("flats", flats);
		RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/database.jsp");
		requestDispatcher.forward(request, response);
	}

}