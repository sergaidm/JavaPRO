package ru.yandex.sergaidm;

import java.time.LocalDateTime;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Main {

	public static void main(String[] args) {

		Message message = new Message("Ivanov", "Petrov", "Now messages are presented in JSON-format!", LocalDateTime.now());
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.registerTypeAdapter(Message.class, new JSONMessageWorker());
		gsonBuilder.setPrettyPrinting();
		Gson gson = gsonBuilder.create();
		String result = gson.toJson(message);
		System.out.println(result);
		Message newMessage = gson.fromJson(result, Message.class);
		System.out.println(System.lineSeparator() + newMessage);

	}

}
