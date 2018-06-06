package ru.yandex.sergaidm;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "QuestionsServlet", urlPatterns = { "/questions" })
public class PostServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		String surname = request.getParameter("surname");	
		response.setContentType( "text/html" );
		String text = "<p><strong>Привет, " + name + " " + surname + "! </strong></p>"
				+ "<!DOCTYPE html><html><head><meta http-equiv=\"Content-Type\" content=\"text/html;  charset=\"UTF-8\">" 
				+ "<title>Questionnaire</title></head><body><form method=\"post\" action=\"statistic\">" 
				+ "<ol><li><p><strong>Your favorite genre of computer games:</strong></p>"
				+ "<p><input name=\"game\" type=\"radio\" value=\"Actions\">Actions</p>"
				+ "<p><input name=\"game\" type=\"radio\" value=\"RPG\">RPG</p>"
				+ "<p><input name=\"game\" type=\"radio\" value=\"RTS\">RTS</p>"
				+ "<input name=\"game\" type=\"radio\" value=\"Simulators\">Simulators</p></li>"
				+ "<li><p><strong>Your favorite genre of literature:</strong></p>"
				+ "<p><input name=\"literature\" type=\"radio\" value=\"Classic\">Classic</p>"
				+ "<p><input name=\"literature\" type=\"radio\" value=\"Historical\">Historical</p>"
				+ "<p><input name=\"literature\" type=\"radio\" value=\"Fantastic\">Fantastic</p>"
				+ "<p><input name=\"literature\" type=\"radio\" value=\"Fantasy\">Fantasy</p></li>"
				+ "<li><p><strong>Your favorite Russian metal-band:</strong></p>"
				+ "<p><input name=\"band\" type=\"radio\" value=\"Aria\">Aria</p>"
				+ "<p><input name=\"band\" type=\"radio\" value=\"Arkona\">Arkona</p>"
				+ "<p><input name=\"band\" type=\"radio\" value=\"Kipelov\">Kipelov</p>"
				+ "<p><input name=\"band\" type=\"radio\" value=\"Master\">Master</p>"
				+ "<p><input name=\"band\" type=\"radio\" value=\"Epidemiya\">Epidemiya</p></li></ol>"
				+ "<input type=\"submit\" value=\"Confirm\"></form></body></html>"
		OutputStream os = response.getOutputStream();
		os.write(text.getBytes("UTF-8"));
		os.flush();
		os.close();
	}

}