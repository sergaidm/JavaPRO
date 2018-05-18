package ru.yandex.sergaidm;

import java.util.Comparator;

public class SorterByAge implements Comparator<Student> {

	@Override
	public int compare(Student one, Student two) {
		int result = 0;
		if (one.getAge() > two.getAge()) {
			result = 1;
		}
		if (one.getAge() < two.getAge()) {
			result = -1;
		}
		if (one.getAge() == two.getAge()) {
			result = 0;
		}
		return result;
	}

}
