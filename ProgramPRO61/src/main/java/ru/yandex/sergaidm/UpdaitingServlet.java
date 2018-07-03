package ru.yandex.sergaidm;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "UpdaitingServlet", urlPatterns = { "/updating" })
public class UpdaitingServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		ManagerDAO managerDAO = new ManagerDAO();
		FlatDAO flatsDB = managerDAO.getFlatDAO();
		EntityManager entityManager = ManagerDAO.getEntityManager();
		String idString = request.getParameter("id");
		String address = request.getParameter("address");
		String roomsNumberString = request.getParameter("roomsNumber");
		String floorString = request.getParameter("floor");
		String costString = request.getParameter("cost");
		String currency = request.getParameter("currency");
		int id = Integer.parseInt(idString);
		int roomsNumber = Integer.parseInt(roomsNumberString);
		int floor = Integer.parseInt(floorString);
		double cost = Double.parseDouble(costString);		
		try {
			flatsDB.update(id, address, roomsNumber, floor, new Price(cost, currency));
			request.setAttribute("information", "Database row " + id + " is updated");
		} catch (EntityNotFoundException | IllegalStateException e) {
			entityManager.getTransaction().rollback();
			request.setAttribute("information", "This row doesn't exist");
		}
		RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/result.jsp");
		requestDispatcher.forward(request, response);
	}

}
