package ru.yandex.sergaidm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {

		List<Student> students = new ArrayList<>();

		students.add(new Student("Ivanov", 22.5, "male", "DP-51s"));
		students.add(new Student("Petrov", 23, "male", "DP-51s"));
		students.add(new Student("Sidorov", 22.8, "male", "DP-51s"));
		students.add(new Student("Orlov", 23.2, "male", "DP-51s"));
		students.add(new Student("Arbuzov", 22.4, "male", "DP-51s"));
		students.add(new Student("Kaktusov", 23.1, "male", "DP-51s"));
		students.add(new Student("Andreeva", 23, "female", "DP-51s"));
		students.add(new Student("Sergeeva", 22.9, "female", "DP-51s"));
		System.out.println("Unsorted list of students:" + System.lineSeparator() + students);
		
		try {
			List<Class<?>> classes = getClasses("ru.yandex.sergaidm");
			System.out.println(classes);
			for (Class<?> cl : classes) {
				if (cl.isAnnotationPresent(Sorter.class)) {
//					Class<?> cls = Class.forName(cl.getName().substring(cl.getName().lastIndexOf('.')+1));
					students.sort(cl);
				}
			}
			System.out.println("Sorted list of students by annotated class:" + System.lineSeparator() + students);
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static List<Class<?>> getClasses(String pack) throws IOException, ClassNotFoundException {
		ClassLoader cl = Main.class.getClassLoader();
		String packageDir = pack.replaceAll("[.]", "/");
		List<Class<?>> classes = new ArrayList<Class<?>>();
		URL upackage = cl.getResource(packageDir);
		InputStream is = (InputStream) upackage.getContent();
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		String line = null;
		while ((line = br.readLine()) != null) {
			if (line.endsWith(".class"))
				classes.add(Class.forName(pack + "." + line.substring(0, line.lastIndexOf('.'))));
		}
		return classes;
	}

}
