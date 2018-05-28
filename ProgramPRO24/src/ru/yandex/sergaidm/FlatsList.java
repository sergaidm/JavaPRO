package ru.yandex.sergaidm;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "flats")
public class FlatsList {

	@XmlElement(name = "flat")
	private List<Flat> flatsList = new ArrayList<>();

	public FlatsList() {
		super();
	}

	public void addFlat(Flat flat) {
		flatsList.add(flat);
	}

	public List<Flat> getFlatsList() {
		return new ArrayList<>(flatsList);
	}

	public List<Flat> saleFlat(Flat flat) {
		flatsList.remove(flat);
		JAXBWorker.saveToXMLFile(this, new File("List of flats.xml"));
		return flatsList;
	}

	public List<Flat> flatsByPrice(double begin, double end) {
		List<Flat> flatsByPrice = new ArrayList<>();
		for (Flat flat : flatsList) {
			if (flat.getPrice().getCost() >= begin && flat.getPrice().getCost() <= end) {
				flatsByPrice.add(flat);
			}
		}
		return flatsByPrice;
	}

	public List<Flat> flatsByRoomsNumber(int roomsNumber) {
		List<Flat> flatsByPrice = new ArrayList<>();
		for (Flat flat : flatsList) {
			if (flat.getRoomsNumber() == roomsNumber) {
				flatsByPrice.add(flat);
			}
		}
		return flatsByPrice;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		flatsList.stream().forEachOrdered(n -> sb.append(n).append(System.lineSeparator()));
		return sb.toString();
	}

}
