package ru.yandex.sergaidm;

import java.io.IOException;
import java.io.OutputStream;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "QuestionsServlet", urlPatterns = { "/questions" })
public class QuestionsServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String surname = request.getParameter("surname");
		String text = "<p><strong>Здравствуй, " + name + " " + surname + "! </strong></p>"
				+ "<!DOCTYPE html><html><head><meta charset=\"UTF-8\">" 
				+ "<title>Анкета</title></head><body><form method=\"post\" action=\"statistic\">" 
				+ "<ol><li><p><strong>Ваш любимый жанр компьютерных игр:</strong></p>"
				+ "<input name=\"game\" type=\"radio\" value=\"Simulators\">Симуляторы</p>"
				+ "<p><input name=\"game\" type=\"radio\" value=\"RTS\">Стратегии</p>"
				+ "<p><input name=\"game\" type=\"radio\" value=\"Actions\">Экшены</p>"
				+ "<p><input name=\"game\" type=\"radio\" value=\"RPG\">RPG</p></li>"
				+ "<li><p><strong>Ваш любимый жанр литературы:</strong></p>"
				+ "<p><input name=\"literature\" type=\"radio\" value=\"Historical\">Историческая</p>"
				+ "<p><input name=\"literature\" type=\"radio\" value=\"Classic\">Классическая</p>"				
				+ "<p><input name=\"literature\" type=\"radio\" value=\"Fantastic\">Фантастика</p>"
				+ "<p><input name=\"literature\" type=\"radio\" value=\"Fantasy\">Фэнтези</p></li>"
				+ "<li><p><strong>Ваша любимая российская металл-группа:</strong></p>"
				+ "<p><input name=\"band\" type=\"radio\" value=\"Aria\">Ария</p>"
				+ "<p><input name=\"band\" type=\"radio\" value=\"Arkona\">Аркона</p>"
				+ "<p><input name=\"band\" type=\"radio\" value=\"Kipelov\">Кипелов</p>"
				+ "<p><input name=\"band\" type=\"radio\" value=\"Master\">Мастер</p>"
				+ "<p><input name=\"band\" type=\"radio\" value=\"Epidemiya\">Эпидемия</p></li></ol>"
				+ "<input type=\"submit\" value=\"Завершить\"></form></body></html>";
		OutputStream os = response.getOutputStream();
		os.write(text.getBytes("UTF-8"));
		os.flush();
		os.close();
	}

}