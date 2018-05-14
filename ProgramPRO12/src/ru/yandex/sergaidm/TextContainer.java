package ru.yandex.sergaidm;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

@SaveTo(path = "File.txt")
public class TextContainer {

	private String text;

	public TextContainer() {
		super();
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Saver
	public void saveTextToFile(String path) throws IOException{
		File file = new File(path);
		file.createNewFile();
		try(FileWriter fw = new FileWriter(file)){
			fw.write(text);
		}		
	}

}
