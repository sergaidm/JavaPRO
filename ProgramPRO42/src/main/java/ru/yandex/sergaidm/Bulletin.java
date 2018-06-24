package ru.yandex.sergaidm;

import java.io.Serializable;

public class Bulletin implements Serializable{

	private static final long serialVersionUID = 1L;
	private String creator;
	private String text;
	
	public Bulletin(String creator, String text) {
		super();
		this.creator = creator;
		this.text = text;
	}

	public Bulletin() {
		super();
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Override
	public String toString() {
		return creator + ": \"" + text + "\"";
	}
	
}
