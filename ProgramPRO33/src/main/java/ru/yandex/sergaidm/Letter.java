package ru.yandex.sergaidm;

public class Letter implements Comparable<Letter> {

	private String letter;

	public Letter(String letter) {
		super();
		this.letter = letter;
	}

	public Letter() {
		super();
	}

	public String getLetter() {
		return letter;
	}

	public void setLetter(String letter) {
		this.letter = letter;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((letter == null) ? 0 : letter.hashCode());
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
		Letter other = (Letter) obj;
		if (letter == null) {
			if (other.letter != null)
				return false;
		} else if (!letter.equals(other.letter))
			return false;
		return true;
	}

	@Override
	public int compareTo(Letter letter) {
			return this.letter.compareTo(letter.letter);
	}

	@Override
	public String toString() {
		return letter;
	}

}
