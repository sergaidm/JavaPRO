package ru.yandex.sergaidm;

import java.util.Comparator;

@Sorter
public class SorterBySurname implements Comparator<Student> {

	@Override
	public int compare(Student one, Student two) {
		int result = 0;
		if (one.getSurname().compareToIgnoreCase(two.getSurname()) > 0) {
			result = 1;
		}
		if (one.getSurname().compareToIgnoreCase(two.getSurname()) < 0) {
			result = -1;
		}
		if (one.getSurname().compareToIgnoreCase(two.getSurname()) == 0) {
			result = 0;
		}
		return result;
	}

}
