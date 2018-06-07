package ru.yandex.sergaidm;

import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "StatisticServlet", urlPatterns = "/statistic")
public class StatisticServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private int answerOne=0;
	private int answerTwo=0;
	private int answerThree=0;
	private int answerFour=0;
	private int answerFive=0;	
	private int answerSix=0;
	private int answerSeven=0;
	private int answerEight=0;
	private int answerNine=0;
	private int answerTen=0;
	private int answerEleven=0;
	private int answerTwelve=0;
	private int answerThirteen=0;
	private static final String TEMPLATE = "<!DOCTYPE html><html>"
			+ "<head><meta charset=\"UTF-8\"><title>Анкета</title></head>"
			+ "<body><form method=\"get\" action=\"/ProgramPRO31\"><p>%s</p>"
			+ "<input type=\"submit\" value=\"Повторить прохождение\"></form></body></html>";

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		final String itemOne = request.getParameter("game");
		final String itemTwo = request.getParameter("literature");
		final String itemThree = request.getParameter("band");		
		comparator(itemOne, itemTwo, itemThree);		
		String result = result();
		OutputStream os = response.getOutputStream();		
		os.write(String.format(TEMPLATE, result).getBytes("UTF-8"));
		os.flush();
		os.close();
	}
	
	private void comparator(String itemOne, String itemTwo, String itemThree){
		if ("Simulators".equals(itemOne)) {
			answerOne++;
		} else if ("RTS".equals(itemOne)) {
			answerTwo++;
		} else if ("Actions".equals(itemOne)) {
			answerThree++;
		} else if ("RPG".equals(itemOne)) {
			answerFour++;
		}		
		if ("Historical".equals(itemTwo)) {
			answerFive++;
		} else if ("Classic".equals(itemTwo)) {
			answerSix++;
		} else if ("Fantastic".equals(itemTwo)) {
			answerSeven++;
		} else if ("Fantasy".equals(itemTwo)) {
			answerEight++;
		}		
		if ("Aria".equals(itemThree)) {
			answerNine++;
		} else if ("Arkona".equals(itemThree)) {
			answerTen++;
		} else if ("Kipelov".equals(itemThree)) {
			answerEleven++;
		} else if ("Master".equals(itemThree)) {
			answerTwelve++;
		} else if ("Epidemiya".equals(itemThree)) {
			answerThirteen++;
		}
	}
	
	private String result() {
		return "<ol><li><p><strong>Наиболее популярные жанры игр:</strong></p>"
				+ "<ul type=\"disc\"><li><p>Симуляторы - " + answerOne + "</p></li>" 
				+ "<li><p>Стратегии - " + answerTwo + "</p></li>" 
				+ "<li><p>Экшены - " + answerThree + "</p></li>"
				+ "<li><p>RPG - " + answerFour + "</p></li>"
				+ "</ul></li>"
				+ "<li><p><strong>Наиболее популярные жанры литературы:</strong></p>"
				+ "<ul type=\"disc\"><li><p>Историческая - " + answerFive + "</p></li>" 
				+ "<li><p>Классическая - " + answerSix + "</p></li>" 
				+ "<li><p>Фантастика - " + answerSeven + "</p></li>"
				+ "<li><p>Фэнтези - " + answerEight + "</p></li>"
				+ "</ul></li>"
				+"<li><p><strong>Наиболее популярные российские металл-группы:</strong></p>"
				+ "<ul type=\"disc\"><li><p>Ария - " + answerNine + "</p></li>"
				+ "<li><p>Аркона - " + answerTen + "</p></li>"
				+ "<li><p>Кипелов - " + answerEleven + "</p></li>"
				+ "<li><p>Мастер - " + answerTwelve + "</p></li>"
				+ "<li><p>Эпидемия - " + answerThirteen + "</p></li>"
				+ "</ul></li>"
				+ "</ol>";
	}
	
}
