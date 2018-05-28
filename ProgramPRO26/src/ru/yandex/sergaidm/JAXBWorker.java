package ru.yandex.sergaidm;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class JAXBWorker {

	public static void saveToXMLFile(Dependencies dependencies, File file) {
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(Dependencies.class);
			Marshaller marshaller = jaxbContext.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshaller.marshal(dependencies, file);
			marshaller.marshal(dependencies, System.out);
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}

	public static Dependencies loadFromXMLFile(File file) {
		JAXBContext jaxbContext = null;
		try {
			jaxbContext = JAXBContext.newInstance(Dependencies.class);
			Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
			Dependencies dependencies = (Dependencies) unmarshaller.unmarshal(file);
			return dependencies;
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		return null;
	}

}
