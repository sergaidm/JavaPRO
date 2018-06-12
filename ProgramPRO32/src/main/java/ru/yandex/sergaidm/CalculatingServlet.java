package ru.yandex.sergaidm;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "CalculatingServlet", urlPatterns = { "/calculation" })
public class CalculatingServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String one = request.getParameter("firstNum");
		String two = request.getParameter("secondNum");
		String action = request.getParameter("action");
		String text = "";
		text = calculate(one, two, action);
		PrintWriter pw = response.getWriter();
		pw.println(text);
		pw.close();
	}

	private String calculate(String one, String two, String action) {
		double firstNumber = Double.parseDouble(one);
		double secondNumber = Double.parseDouble(two);
		double result = 0;
		String text = "";
		if ("Addition".equals(action)) {
			result = firstNumber + secondNumber;
			text = String.format("Result of calculation: %.2f", result);
		} else if ("Subtraction".equals(action)) {
			result = firstNumber - secondNumber;
			text = String.format("Result of calculation: %.2f", result);
		} else if ("Multiplication".equals(action)) {
			result = firstNumber * secondNumber;
			text = String.format("Result of calculation: %.2g", result);
		} else if ("Division".equals(action)) {
			result = firstNumber / secondNumber;
			text = String.format("Result of calculation: %.2g", result);
		}
		return text;
	}

}