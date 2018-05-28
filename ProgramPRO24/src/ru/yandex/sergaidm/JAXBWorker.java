package ru.yandex.sergaidm;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class JAXBWorker {

	public static void saveToXMLFile(FlatsList flats, File file) {
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(FlatsList.class);
			Marshaller marshaller = jaxbContext.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshaller.marshal(flats, file);
			marshaller.marshal(flats, System.out);
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}

	public static FlatsList loadFromXMLFile(File file) {
		JAXBContext jaxbContext = null;
		try {
			jaxbContext = JAXBContext.newInstance(FlatsList.class);
			Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
			FlatsList flats = (FlatsList) unmarshaller.unmarshal(file);
			return flats;
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		return null;
	}

}
