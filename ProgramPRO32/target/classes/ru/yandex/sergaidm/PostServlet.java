package ru.yandex.sergaidm;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "PostServlet", urlPatterns = { "/send" })
public class PostServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		String surname = request.getParameter("surname");
		PrintWriter pw = response.getWriter();
		pw.println("<p><strong>Hello, " + name + " " + surname + "! </strong></p>");
		String text = HTMLReader.textFromFile(new File("E:\\JavaProjects\\ProgramPRO32\\src\\main\\webapp\\Questions.html"));
		pw.print(text);
		pw.close();
	}

}