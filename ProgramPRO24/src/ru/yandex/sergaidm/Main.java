package ru.yandex.sergaidm;

import java.io.File;

public class Main {

	public static void main(String[] args) {

		FlatsList flats = new FlatsList();
		Flat flatOne = new Flat(1, "Ivanov street, 1", 1, new Price(10000, "$"));
		Flat flatTwo = new Flat(2, "Petrov street, 2", 2, new Price(20000, "$"));
		Flat flatThree = new Flat(3, "Sidorov street, 3", 3, new Price(30000, "$"));
		Flat flatFour = new Flat(4, "Fedorov street, 4", 4, new Price(40000, "$"));
		Flat flatFive = new Flat(5, "Andreev street, 5", 5, new Price(50000, "$"));
		Flat flatSix = new Flat(2, "Petrov street, 6", 2, new Price(20000, "$"));

		flats.addFlat(flatOne);
		flats.addFlat(flatTwo);
		flats.addFlat(flatThree);
		flats.addFlat(flatFour);
		flats.addFlat(flatFive);
		flats.addFlat(flatSix);

		JAXBWorker.saveToXMLFile(flats, new File("List of flats.xml"));
		FlatsList list = JAXBWorker.loadFromXMLFile(new File("List of flats.xml"));
		System.out.println(System.lineSeparator() + list);

		flatOne.setPrice(new Price(260_000, "UAH"));
		flats.saleFlat(flatTwo);
		list = JAXBWorker.loadFromXMLFile(new File("List of flats.xml"));
		System.out.println(System.lineSeparator() + list);

		System.out.println("List of flats at the specified price range:");
		System.out.println(flats.flatsByPrice(30000, 50000));

		System.out.println("List of flats by the number of rooms:");
		System.out.println(flats.flatsByRoomsNumber(4));

	}

}
