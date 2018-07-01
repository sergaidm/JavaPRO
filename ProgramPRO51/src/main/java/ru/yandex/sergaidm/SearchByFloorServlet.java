package ru.yandex.sergaidm;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "SearchByFloorServlet", urlPatterns = { "/flatsbyfloor" })
public class SearchByFloorServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		ManagerDAO managerDAO = new ManagerDAO();
		FlatDAODatabaseImplementation flatsDB = managerDAO.getFlatsDB();
		String floorString = request.getParameter("floor");
		int floor = Integer.parseInt(floorString);
		if (!flatsDB.getFlatsByFloor(floor).isEmpty()) {
			request.setAttribute("foundFlats", flatsDB.getFlatsByFloor(floor));
			request.setAttribute("information", "Found flats at the specified floor");
		} else {
			request.setAttribute("information", "Flats located on the specified floor are not available in the database");
		}
		RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/foundflats.jsp");
		requestDispatcher.forward(request, response);
	}

}
