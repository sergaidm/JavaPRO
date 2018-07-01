package ru.yandex.sergaidm;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "SearchByAddressServlet", urlPatterns = { "/flatsbyaddress" })
public class SearchByAddressServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		ManagerDAO managerDAO = new ManagerDAO();
		FlatDAODatabaseImplementation flatsDB = managerDAO.getFlatsDB();
		String address = request.getParameter("address");
		request.setAttribute("foundFlats", flatsDB.getFlatsByAddress(address));
		request.setAttribute("information", "Found flats at the specified address");
		RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/foundflats.jsp");
		requestDispatcher.forward(request, response);
	}

}
