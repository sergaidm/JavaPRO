package ru.yandex.sergaidm;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "MainServlet", urlPatterns = { "/" })
public class MainServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String text = HTMLReader.textFromFile(new File("E:/JavaProjects/ProgramPRO31/WebContent/Registration.html"));
		PrintWriter pw = response.getWriter();
		pw.println(text);
		pw.close();
	}	

}