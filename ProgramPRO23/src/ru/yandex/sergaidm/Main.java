package ru.yandex.sergaidm;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class Main {

	public static void main(String[] args) {

		String url = "https://query.yahooapis.com/v1/public/yql?q=select%20item.condition%20from%20weather.forecast%20where%20woeid%20%3D%202487889&format=xml&env=store%3A%2F%2Fdatatables.org%2Falltableswithkeys";
		System.out.println("Result of site parsing:");
		Query query = getRequestResult(url);
		System.out.println(query);

	}

	public static Query getRequestResult(String urlString) {
		Query result = null;
		try {
			URL url = new URL(urlString);
			JAXBContext jaxbContext = JAXBContext.newInstance(Query.class);
			Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
			result = (Query) unmarshaller.unmarshal(url);
		} catch (JAXBException | MalformedURLException e) {
			e.printStackTrace();
		}
		return result;
	}

}