package ru.yandex.sergaidm;

public class SerializableClass {

	private int numberOne;
	@Save
	private String text;
	private char character;
	@Save
	private long numberTwo;

	public SerializableClass(int numberOne, String text, char character, long numberTwo) {
		super();
		this.numberOne = numberOne;
		this.text = text;
		this.character = character;
		this.numberTwo = numberTwo;
	}

	public SerializableClass() {
		super();
	}

	public int getNumberOne() {
		return numberOne;
	}

	public void setNumberOne(int numberOne) {
		this.numberOne = numberOne;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public char getCharacter() {
		return character;
	}

	public void setCharacter(char character) {
		this.character = character;
	}

	public long getNumberTwo() {
		return numberTwo;
	}

	public void setNumberTwo(long numberTwo) {
		this.numberTwo = numberTwo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + character;
		result = prime * result + numberOne;
		result = prime * result + (int) (numberTwo ^ (numberTwo >>> 32));
		result = prime * result + ((text == null) ? 0 : text.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SerializableClass other = (SerializableClass) obj;
		if (character != other.character)
			return false;
		if (numberOne != other.numberOne)
			return false;
		if (numberTwo != other.numberTwo)
			return false;
		if (text == null) {
			if (other.text != null)
				return false;
		} else if (!text.equals(other.text))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "SerializableClass [numberOne=" + numberOne + ", text=" + text + ", character=" + character
				+ ", numberTwo=" + numberTwo + "]";
	}

}
