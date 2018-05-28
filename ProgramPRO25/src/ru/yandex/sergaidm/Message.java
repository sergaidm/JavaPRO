package ru.yandex.sergaidm;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Message {

	private String from;
	private String to;
	private String text;
	private LocalDateTime sendingDate;
	private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm dd.MM.yyyy");

	public Message(String from, String to, String text, LocalDateTime sendingDate) {
		super();
		this.from = from;
		this.to = to;
		this.text = text;
		this.sendingDate = sendingDate;
	}

	public Message() {
		super();
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public LocalDateTime getSendingDate() {
		return sendingDate;
	}

	public void setSendingDate(LocalDateTime sendingDate) {
		this.sendingDate = sendingDate;
	}

	@Override
	public String toString() {
		return "Message from " + from + " to " + to + ": \"" + text + "\" (" + dtf.format(sendingDate) + ")";
	}

}
