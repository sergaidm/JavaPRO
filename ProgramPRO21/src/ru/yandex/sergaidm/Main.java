package ru.yandex.sergaidm;

import java.io.File;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;

public class Main {

	public static void main(String[] args) {

		TrainsList trains = JAXBWorker.loadFromXMLFile(new File("Trains.xml"));
		System.out.println(trains);

		trains.addTrain(new Train(3, "Kiev", "Har'kov", LocalDate.of(2018, Month.MAY, 26), LocalTime.of(12, 30)));
		trains.addTrain(new Train(4, "Kiev", "Lugansk", LocalDate.of(2018, Month.MAY, 27), LocalTime.of(13, 00)));
		trains.addTrain(new Train(5, "Kiev", "Moscow", LocalDate.of(2018, Month.MAY, 27), LocalTime.of(15, 30)));
		trains.addTrain(new Train(6, "Kiev", "Dnepropetrovsk", LocalDate.of(2018, Month.MAY, 27), LocalTime.of(18, 30)));

		JAXBWorker.saveToXMLFile(trains, new File("Train list.xml"));

		LocalDateTime begin = LocalDateTime.of(2018, Month.MAY, 27, 15, 00);
		LocalDateTime end = LocalDateTime.of(2018, Month.MAY, 27, 19, 00);
		System.out.println(System.lineSeparator() + "Trains that depart on May 27 from 15:00 to 19:00: ");
		System.out.println(trains.selectionOfTrainsFromTrainList(begin, end));

	}

}
