package ru.yandex.sergaidm;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "ChangingServlet", urlPatterns = { "/changeprice" })
public class ChangingServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String numberString = request.getParameter("number");
		String costString = request.getParameter("cost");
		String currency = request.getParameter("currency");
		int number = Integer.parseInt(numberString);
		double cost = Double.parseDouble(costString);
		HttpSession session = request.getSession();
		FlatsList flats = (FlatsList) session.getAttribute("flats");
		String information = "";
		try {
			if (number >= 1 && number <= (flats.getLastFlat() + 1)) {
				Flat flat = flats.getFlatByNumber(number -1);
				flat.setPrice(new Price(cost, currency));
				information = "A new price is set for the flat";
			} else {
				information = "This flat doesn't exist";
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			information = "There are no more flats for sale in the agency";
		}
		session.setAttribute("information", information);
		response.sendRedirect("methodexecutionresult.jsp");
	}

}
