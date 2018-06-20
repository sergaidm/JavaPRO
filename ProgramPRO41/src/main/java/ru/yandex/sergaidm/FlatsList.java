package ru.yandex.sergaidm;

import java.io.File;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "flats")
public class FlatsList implements Iterable<Flat> {

	@XmlElement(name = "flat")
	private List<Flat> flatsList = new ArrayList<>();

	public FlatsList() {
		super();
	}

	public void addFlat(Flat flat) {
		flatsList.add(flat);
	}

	private void add(Flat flat) {
		flatsList.add(flat);
	}

	public List<Flat> getFlatsList() {
		return new ArrayList<>(flatsList);
	}

	public List<Flat> saleFlat(int flat) {
		flatsList.remove(flat);
		return flatsList;
	}

	public int getLastFlat() {
		return flatsList.lastIndexOf(flatsList.get(flatsList.size() - 1));
	}

	public Flat getFlatByNumber(int number) {
		return flatsList.get(number);
	}

	public FlatsList flatsByPrice(double begin, double end) {
		FlatsList flatsByPrice = new FlatsList();
		for (Flat flat : flatsList) {
			if (flat.getPrice().getCost() >= begin && flat.getPrice().getCost() <= end) {
				flatsByPrice.add(flat);
			}
		}
		return flatsByPrice;
	}

	public FlatsList flatsByRoomsNumber(int roomsNumber) {
		FlatsList flatsByPrice = new FlatsList();
		for (Flat flat : flatsList) {
			if (flat.getRoomsNumber() == roomsNumber) {
				flatsByPrice.add(flat);
			}
		}
		return flatsByPrice;
	}

	public void saveToXMLFile(File file) {
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(FlatsList.class);
			Marshaller marshaller = jaxbContext.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshaller.marshal(this, file);
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}

	public static FlatsList loadFromXMLFile(String text) {
		JAXBContext jaxbContext = null;
		try {
			jaxbContext = JAXBContext.newInstance(FlatsList.class);
			Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
			FlatsList flats = (FlatsList) unmarshaller.unmarshal(new StringReader(text));
			return flats;
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Iterator<Flat> iterator() {
		return flatsList.iterator();
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		flatsList.stream().forEachOrdered(n -> sb.append(n).append(System.lineSeparator()));
		return sb.toString();
	}

}
