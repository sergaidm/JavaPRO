package ru.yandex.sergaidm;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ExecuteServlet", urlPatterns = { "/execute" })
public class ExecuteServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String method = request.getParameter("method");
		if ("addFlat".equals(method)) {			
			response.sendRedirect("addingflat.jsp");			
		} else if ("saleFlat".equals(method)) {
			response.sendRedirect("saleflat.jsp");			
		} else if ("setPrice".equals(method)) {
			response.sendRedirect("changeprice.jsp");
		} else if ("flatsByPrice".equals(method)) {
			response.sendRedirect("flatsbyprice.jsp");
		} else if ("flatsByRoomsNumber".equals(method)) {
			response.sendRedirect("flatsbyroomsnumber.jsp");
		}		
	}

}