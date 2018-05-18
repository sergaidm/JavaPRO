package ru.yandex.sergaidm;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Field;

public class SerializerClass {

	private SerializableClass serializable;

	public SerializerClass(SerializableClass serializable) {
		super();
		this.serializable = serializable;
	}

	public SerializerClass() {
		super();
	}

	public SerializableClass getSerializable() {
		return serializable;
	}

	public void setSerializable(SerializableClass serializable) {
		this.serializable = serializable;
	}

	private void save(Field field, File file) {
		try (PrintWriter pw = new PrintWriter(new FileWriter(file, true))) {
			field.setAccessible(true);
			try {
				if (field.getType() == int.class) {
					pw.println(field.getName() + " -> " + field.getInt(serializable));
				}
				if (field.getType() == String.class) {
					pw.println(field.getName() + " -> " + (String) field.get(serializable));
				}
				if (field.getType() == char.class) {
					pw.println(field.getName() + " -> " + field.getChar(serializable));
				}
				if (field.getType() == long.class) {
					pw.println(field.getName() + " -> " + field.getLong(serializable));
				}
			} catch (IllegalArgumentException | IllegalAccessException e) {
				e.printStackTrace();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void serialization(SerializableClass sc, File file) {
		Class<?> cl = sc.getClass();
		Field[] fieldsArray = cl.getDeclaredFields();
		for (Field field : fieldsArray) {
			if (field.isAnnotationPresent(Save.class)) {
				save(field, file);
			}
		}
		System.out.println("Class is serialized to \"File.txt\"");
	}

	private String load(File file) {
		StringBuilder sb = new StringBuilder();
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			String text = "";
			for (; (text = br.readLine()) != null;) {
				sb.append(text);
				sb.append(System.lineSeparator());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sb.toString();
	}

	public <T> T deserialization(File file, Class<T> cl)
			throws NumberFormatException, IllegalArgumentException, IllegalAccessException, InstantiationException {
		T result = (T) cl.newInstance();
		String text = load(file);
		String[] fields = text.split(System.lineSeparator());
		for (String ff : fields) {
			String[] arr = ff.split(" -> ");
			String name = arr[0];
			String value = arr[1];
			try {
				Field f = cl.getDeclaredField(name);
				f.setAccessible(true);
				if (f.isAnnotationPresent(Save.class)) {
					if (f.getType() == int.class) {
						f.setInt(result, Integer.parseInt(value));
					} else if (f.getType() == String.class) {
						f.set(result, value);
					} else if (f.getType() == char.class) {
						f.setChar(result, value.charAt(0));
					} else if (f.getType() == long.class) {
						f.setLong(result, Long.parseLong(value));
					}
				}
			} catch (NoSuchFieldException | SecurityException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	@Override
	public String toString() {
		return "SerializerClass [serializable=" + serializable + "]";
	}

}
