package ru.yandex.sergaidm;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "AddingServlet", urlPatterns = { "/adding" })
public class AddingServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private BulletinBoard bulletins = new BulletinBoard();

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String creator = request.getParameter("creator");
		String text = request.getParameter("text");
		bulletins.addBulletin(new Bulletin(creator, text));
		HttpSession session = request.getSession(true);
		session.setAttribute("bulletins", bulletins.getBulletins());
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/bulletins.jsp");
		dispatcher.forward(request, response);
	}

}
