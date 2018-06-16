package ru.yandex.sergaidm;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "CountingServlet", urlPatterns = { "/counting" })
public class CountingServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String text = request.getParameter("text");	
		Counter counter = new Counter();
		String statistic = counter.lettersCounter(counter.textToLetters(text));
		PrintWriter pw = response.getWriter();
		pw.println(statistic);
		pw.close();
	}

}