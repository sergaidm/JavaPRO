package ru.yandex.sergaidm;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "AddingServlet", urlPatterns = { "/adding" })
public class AddingServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String address = request.getParameter("address");
		String roomsNumberString = request.getParameter("roomsnumber");
		String floorString = request.getParameter("floor");
		String costString = request.getParameter("cost");
		String currency = request.getParameter("currency");
		int roomsNumber = Integer.parseInt(roomsNumberString);
		int floor = Integer.parseInt(floorString);
		double cost = Double.parseDouble(costString);		
		HttpSession session = request.getSession();
		FlatsList flats = (FlatsList)session.getAttribute("flats");
		flats.addFlat(new Flat(address, roomsNumber, floor, new Price(cost, currency)));
		String information = "New flat is added for sale";
		session.setAttribute("information", information);
		response.sendRedirect("methodexecutionresult.jsp");
	}

}
