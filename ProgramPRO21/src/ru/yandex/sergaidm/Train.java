package ru.yandex.sergaidm;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlRootElement(name = "train")
public class Train {

	private int trainID;
	private String from;
	private String to;
	private LocalDate date;
	private LocalTime departure;

	public Train(int trainID, String from, String to, LocalDate date, LocalTime departure) {
		super();
		this.trainID = trainID;
		this.from = from;
		this.to = to;
		this.date = date;
		this.departure = departure;
	}

	public Train() {
		super();
	}

	@XmlAttribute(name = "id")
	public int getTrainID() {
		return trainID;
	}

	public void setTrainID(int trainID) {
		this.trainID = trainID;
	}

	@XmlElement
	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	@XmlElement
	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	@XmlElement
	@XmlJavaTypeAdapter(TrainsDateFormatter.class)
	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	@XmlElement
	@XmlJavaTypeAdapter(TrainsDepartureFormatter.class)
	public LocalTime getDeparture() {
		return departure;
	}

	public void setDeparture(LocalTime departure) {
		this.departure = departure;
	}

	@Override
	public String toString() {
		DateTimeFormatter dtfOne = DateTimeFormatter.ofPattern("dd.MM.yyyy");
		DateTimeFormatter dtfTwo = DateTimeFormatter.ofPattern("HH:mm");
		return from + " - " + to + ": train departs " + dtfOne.format(date) + " in " + dtfTwo.format(departure);
	}

}
