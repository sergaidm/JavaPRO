package ru.yandex.sergaidm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.Map.Entry;

public class Counter {

	private List<String> list;
	private List<Letter> letters;

	public List<String> textToLetters(String text) {
		list = new ArrayList<>(Arrays.asList(text.split("")));
		return list;
	}

	public String lettersCounter(List<String> list) {
		int[] repeatsArray = new int[26];
		Letter[] lettersArray = { new Letter("a"), new Letter("b"), new Letter("c"), new Letter("d"), new Letter("e"),
				new Letter("f"), new Letter("g"), new Letter("h"), new Letter("i"), new Letter("j"), new Letter("k"),
				new Letter("l"), new Letter("m"), new Letter("n"), new Letter("o"), new Letter("p"), new Letter("q"),
				new Letter("r"), new Letter("s"), new Letter("t"), new Letter("u"), new Letter("v"), new Letter("w"),
				new Letter("x"), new Letter("y"), new Letter("z") };
		letters = Arrays.asList(lettersArray);
		for (String string : list) {
			for (int i = 0; i < repeatsArray.length; i++) {
				if (string.equalsIgnoreCase(letters.get(i).getLetter())) {
					repeatsArray[i]++;
				}
			}
		}
		Map<Letter, Integer> map = new TreeMap<>();
		for (int i = 0; i < letters.size(); i++) {
			map.put(letters.get(i), repeatsArray[i]);
		}
		List<Entry<Letter, Integer>> mapList = new ArrayList<>(map.entrySet());
		Collections.sort(mapList, comparator);
		String text = "<!DOCTYPE html><html><head><meta charset=\"UTF-8\"><title>Letters statistic</title></head>"
				+ "<table border=\"1\"><tr><td><b>Letter</b></td><td><b>Repeats</b></td></tr>";
		for (Entry<Letter, Integer> entrySet : mapList) {
			if (entrySet.getValue() != 0) {
				text += "<td>" + entrySet.getKey() + "</td><td>" + entrySet.getValue() + "</td></tr>";
			}
		}
		text += "</table><p><form action=\"index.jsp\" method=\"get\"><input type=\"submit\" value=\"Enter another text\"></form></p></body></html>";
		return text;
	}

	private Comparator<Map.Entry<Letter, Integer>> comparator = new Comparator<Map.Entry<Letter, Integer>>() {
		@Override
		public int compare(Map.Entry<Letter, Integer> a, Map.Entry<Letter, Integer> b) {
			return b.getValue() - a.getValue();
		}
	};

}
