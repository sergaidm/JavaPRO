package ru.yandex.sergaidm;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "SearchByPriceServlet", urlPatterns = { "/flatsbyprice" })
public class SearchByPriceServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String beginString = request.getParameter("begin");
		String endString = request.getParameter("end");
		double begin = Double.parseDouble(beginString);
		double end = Double.parseDouble(endString);		
		HttpSession session = request.getSession();
		FlatsList flats = (FlatsList) session.getAttribute("flats");
		String information = "List of flats at the specified price range";
		session.setAttribute("sortedflats", flats.flatsByPrice(begin, end));
		session.setAttribute("information", information);
		response.sendRedirect("foundflatsbyprice.jsp");
	}

}
