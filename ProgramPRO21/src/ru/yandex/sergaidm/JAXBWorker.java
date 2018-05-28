package ru.yandex.sergaidm;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class JAXBWorker {

	public static void saveToXMLFile(TrainsList trains, File file) {
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(TrainsList.class);
			Marshaller marshaller = jaxbContext.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshaller.marshal(trains, file);
			marshaller.marshal(trains, System.out);
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}

	public static TrainsList loadFromXMLFile(File file) {
		JAXBContext jaxbContext = null;
		try {
			jaxbContext = JAXBContext.newInstance(TrainsList.class);
			Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
			TrainsList trains = (TrainsList) unmarshaller.unmarshal(file);
			return trains;
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		return null;
	}

}
