package ru.yandex.sergaidm;

import java.io.IOException;

import javax.persistence.EntityNotFoundException;
import javax.persistence.NoResultException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "SearchByIDServlet", urlPatterns = { "/flatbyid" })
public class SearchByIDServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		ManagerDAO managerDAO = new ManagerDAO();
		FlatDAO flatsDB = managerDAO.getFlatDAO();
		String idString = request.getParameter("id");
		int id = Integer.parseInt(idString);
		try {
			request.setAttribute("foundFlat", flatsDB.getFlatByID(id));
			request.setAttribute("information", "Flat at the specified index number");
		} catch (NoResultException e) {
			request.setAttribute("information", "This flat doesn't exist");
		}
		RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/getflatbyid.jsp");
		requestDispatcher.forward(request, response);

	}

}
