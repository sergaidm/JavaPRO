package ru.yandex.sergaidm;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

public class Main {

	public static void main(String[] args) {

		Gson gson = new Gson();
		BusinessCard businessCard = null;
		try {
			businessCard = gson.fromJson(new FileReader(new File("JSON.json")), BusinessCard.class);
		} catch (JsonSyntaxException | JsonIOException | FileNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println(businessCard);

	}

}
