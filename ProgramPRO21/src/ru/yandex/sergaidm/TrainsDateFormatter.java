package ru.yandex.sergaidm;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class TrainsDateFormatter extends XmlAdapter<String, LocalDate> {

	private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy");

	@Override
	public LocalDate unmarshal(String text) throws Exception {
		TemporalAccessor ta = LocalDate.parse(text, dtf);	
		LocalDate date = LocalDate.from(ta);
		return date;
	}

	@Override
	public String marshal(LocalDate date) throws Exception {
		return dtf.format(date);
	}

}