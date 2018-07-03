package ru.yandex.sergaidm;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "SearchByRoomsNumberServlet", urlPatterns = { "/flatsbyrooms" })
public class SearchByRoomsNumberServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		ManagerDAO managerDAO = new ManagerDAO();
		FlatDAO flatsDB = managerDAO.getFlatDAO();
		String roomsString = request.getParameter("rooms");
		int roomsNumber = Integer.parseInt(roomsString);
		if (!flatsDB.getFlatsByRoomsNumber(roomsNumber).isEmpty()) {
			request.setAttribute("foundFlats", flatsDB.getFlatsByRoomsNumber(roomsNumber));
			request.setAttribute("information", "Found flats at the specified number of rooms");
		} else {
			request.setAttribute("information", "Flats with the specified number of rooms are not available in the database");
		}
		RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/foundflats.jsp");
		requestDispatcher.forward(request, response);
	}

}
