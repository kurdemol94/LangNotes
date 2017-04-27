package controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashSet;
import javafx.collections.ObservableSet;
import model.Note;

public class FileController {
	ObservableSet<Note> set;
	File file;

	FileController(ObservableSet<Note> set) {
		this.set = set;
		file = new File("notes.bin");
	}

	public void saveToFile() {
		FileOutputStream fos;
		ObjectOutputStream oos;
		try {
			fos = new FileOutputStream(file);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(new HashSet<Note>(set));
			oos.close();
			fos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void loadFromFile() {
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		FileInputStream fis;
		ObjectInputStream ois;
		try {
			fis = new FileInputStream(file);
			ois = new ObjectInputStream(fis);
			set.addAll(new HashSet((HashSet<Note>) ois.readObject()));
			ois.close();
			fis.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
