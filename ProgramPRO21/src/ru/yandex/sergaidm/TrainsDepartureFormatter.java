package ru.yandex.sergaidm;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class TrainsDepartureFormatter extends XmlAdapter<String, LocalTime> {

	private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm");

	@Override
	public LocalTime unmarshal(String text) throws Exception {
		TemporalAccessor ta = LocalTime.parse(text, dtf);
		LocalTime departure = LocalTime.from(ta);
		return departure;
	}

	@Override
	public String marshal(LocalTime departure) throws Exception {
		return dtf.format(departure);
	}

}
