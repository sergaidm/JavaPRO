package ru.yandex.sergaidm;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class HTMLReader {
	
	public static String textFromFile(File file) {
		StringBuilder sb = new StringBuilder();
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			String text = "";
			for (; (text = br.readLine()) != null;) {
				sb.append(text);
				sb.append(System.lineSeparator());
			}
		} catch (IOException e) {
			System.out.println(e);
		}
		return sb.toString();
	}

}
