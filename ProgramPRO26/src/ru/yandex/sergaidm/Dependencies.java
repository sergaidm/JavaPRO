package ru.yandex.sergaidm;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "dependencies")
public class Dependencies {

	@XmlElement(name = "dependency")
	private List<Dependency> dependencies = new ArrayList<>();

	public Dependencies() {
		super();
	}

	public void addDependency(Dependency dependency) {
		dependencies.add(dependency);
	}

	public List<Dependency> getListDependencies() {
		return new ArrayList<>(dependencies);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		dependencies.stream().forEachOrdered(n -> sb.append(n).append(System.lineSeparator()));
		return sb.toString();
	}

}
