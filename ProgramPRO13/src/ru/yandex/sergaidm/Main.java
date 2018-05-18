package ru.yandex.sergaidm;

import java.io.File;

public class Main {

	public static void main(String[] args) {

		File file = new File("File.txt");
		SerializableClass serializable = new SerializableClass();
		serializable.setNumberOne(100);
		serializable.setText("It's text must be serialized");
		serializable.setCharacter('s');
		serializable.setNumberTwo(123456L);

		SerializerClass serializer = new SerializerClass(serializable);
		serializer.serialization(serializable, file);
		System.out.println("Deserialized class:");
		try {
			serializable = serializer.deserialization(file, SerializableClass.class);
		} catch (IllegalArgumentException | IllegalAccessException | InstantiationException e) {
			e.printStackTrace();
		}
		System.out.println(serializable.getNumberOne() + ", " + serializable.getText() + ", "
				+ serializable.getCharacter() + ", " + serializable.getNumberTwo());

	}

}
