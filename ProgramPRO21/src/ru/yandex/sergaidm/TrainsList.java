package ru.yandex.sergaidm;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "trains")
public class TrainsList {

	@XmlElement(name = "train")
	private List<Train> trainsList = new ArrayList<>();

	public TrainsList() {
		super();
	}

	public void addTrain(Train train) {
		trainsList.add(train);
	}

	public List<Train> getListTrains() {
		return new ArrayList<>(trainsList);
	}

	public List<Train> selectionOfTrainsFromTrainList(LocalDateTime begin, LocalDateTime end) {
		List<Train> selectedTrains = new ArrayList<>();
		for (Train train : trainsList) {
			if (!(train.getDate().isBefore(begin.toLocalDate()) || train.getDate().isAfter(begin.toLocalDate())) &&
				!(train.getDeparture().isBefore(begin.toLocalTime()) || train.getDeparture().isAfter(end.toLocalTime()))) {
				selectedTrains.add(train);
			}
		}
		return selectedTrains;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		trainsList.stream().forEachOrdered(n -> sb.append(n).append(System.lineSeparator()));
		return sb.toString();
	}

}
