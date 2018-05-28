package ru.yandex.sergaidm;

import java.io.File;

public class Main {

	public static void main(String[] args) {

		Dependencies dependencies = JAXBWorker.loadFromXMLFile(new File("pom.xml"));
		System.out.println(dependencies);

	}

}
