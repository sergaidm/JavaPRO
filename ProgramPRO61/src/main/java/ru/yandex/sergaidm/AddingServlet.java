package ru.yandex.sergaidm;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "AddingServlet", urlPatterns = { "/adding" })
public class AddingServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		ManagerDAO managerDAO = new ManagerDAO();
		FlatDAO flatsDB = managerDAO.getFlatDAO();
		String address = request.getParameter("address");
		String roomsNumberString = request.getParameter("roomsNumber");
		String floorString = request.getParameter("floor");
		String costString = request.getParameter("cost");
		String currency = request.getParameter("currency");
		int roomsNumber = Integer.parseInt(roomsNumberString);
		int floor = Integer.parseInt(floorString);
		double cost = Double.parseDouble(costString);
		flatsDB.insert(new Flat(address, roomsNumber, floor, new Price(cost, currency)));
		request.setAttribute("information", "New flat is added for sale");
		RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/result.jsp");
		requestDispatcher.forward(request, response);
	}

}
