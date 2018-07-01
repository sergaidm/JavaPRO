package ru.yandex.sergaidm;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "SaleServlet", urlPatterns = { "/sale" })
public class SaleServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		ManagerDAO managerDAO = new ManagerDAO();
		FlatDAODatabaseImplementation flatsDB = managerDAO.getFlatsDB();
		String idString = request.getParameter("id");
		int id = Integer.parseInt(idString);
		if (flatsDB.getFlatByID(id).isExist(id)) {
			flatsDB.delete(id);
			request.setAttribute("information", "Selected flat is sold");
		} else {
			request.setAttribute("information", "This flat doesn't exist");
		}
		RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/result.jsp");
		requestDispatcher.forward(request, response);
	}

}
