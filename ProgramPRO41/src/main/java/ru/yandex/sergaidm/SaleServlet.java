package ru.yandex.sergaidm;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "SaleServlet", urlPatterns = { "/sale" })
public class SaleServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String numberString = request.getParameter("number");
		int number = Integer.parseInt(numberString);
		HttpSession session = request.getSession();
		FlatsList flats = (FlatsList) session.getAttribute("flats");
		String information = "";
		try {
			if (number >= 1 && number <= (flats.getLastFlat() + 1)) {
				flats.saleFlat(number - 1);
				information = "Selected flat is sold";
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
