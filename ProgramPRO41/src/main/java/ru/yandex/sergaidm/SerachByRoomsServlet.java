package ru.yandex.sergaidm;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "SerachByRoomsServlet", urlPatterns = { "/flatsbyrooms" })
public class SerachByRoomsServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String roomsNumberString = request.getParameter("rooms");
		int roomsNumber = Integer.parseInt(roomsNumberString);
		HttpSession session = request.getSession();
		FlatsList flats = (FlatsList) session.getAttribute("flats");
		String information = "List of flats by the number of rooms";
		session.setAttribute("sortedflats", flats.flatsByRoomsNumber(roomsNumber));
		session.setAttribute("information", information);
		response.sendRedirect("foundflatsbyroomsnumber.jsp");
	}

}
