package ru.yandex.sergaidm;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "SearchByPriceServlet", urlPatterns = { "/flatsbyprice" })
public class SearchByPriceServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		ManagerDAO managerDAO = new ManagerDAO();
		FlatDAODatabaseImplementation flatsDB = managerDAO.getFlatsDB();
		String beginString = request.getParameter("begin");
		String endString = request.getParameter("end");
		String currency = request.getParameter("currency");
		double begin = Double.parseDouble(beginString);
		double end = Double.parseDouble(endString);
		request.setAttribute("foundFlats", flatsDB.getFlatsByPrice(begin, end, currency));
		request.setAttribute("information", "Found flats at the specified price range");
		RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/foundflats.jsp");
		requestDispatcher.forward(request, response);
	}

}
