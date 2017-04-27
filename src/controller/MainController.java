package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableSet;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import model.Note;

public class MainController {
	Stage stage;
	Scene listScene;
	Scene createScene;
	ListNotesController listController;
	CreateNoteController createController;
	FileController fileController;
	ObservableSet<Note> set;

	public MainController(Stage stage) throws Exception {
		this.stage = stage;
		set = FXCollections.observableSet();
		
		fileController = new FileController(set);
		fileController.loadFromFile();
		
		stage.setTitle("LangNotes");
		stage.setResizable(false);
		stage.setOnCloseRequest(e -> {
			fileController.saveToFile();
		});

		FXMLLoader loader1 = new FXMLLoader(getClass().getResource("/fxml/ListNotes.fxml"));
		listController = new ListNotesController();
		loader1.setController(listController);
		Pane listPane = loader1.load();
		listController.injectInstance(this);
		listController.setUp();

		FXMLLoader loader2 = new FXMLLoader(getClass().getResource("/fxml/CreateNote.fxml"));
		createController = new CreateNoteController();
		loader2.setController(createController);
		Pane createPane = loader2.load();
		createController.injectInstance(this);

		listScene = new Scene(listPane);
		createScene = new Scene(createPane);
		stage.setScene(listScene);
		stage.show();
	}
	
	public void showCreateScene() throws Exception{
		stage.setScene(createScene);
		stage.show();
	}
	
	public void showListScene() throws Exception {
		listController.generateList();
		stage.setScene(listScene);
		stage.show();
	}
	
	public boolean addNoteToSet(Note note){
		return set.add(note);
	}
	
	public ObservableSet<Note> getSet(){
		return set;
	}
	
//	private void insertTestNotes(){
//		for (int i = 0; i < 40; i++){
//			Note note = new Note("note"+i, "asdfkhaskdfaskd,mcvx");
//			set.add(note);
//		}
//	}

}
