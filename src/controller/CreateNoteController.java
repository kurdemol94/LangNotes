package controller;

import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import model.Note;

public class CreateNoteController extends AnchorPane{

    @FXML private TextField tagsField;
    @FXML private Button createNoteButton;
    @FXML private TextField nameField;
    @FXML private TextArea contentField;
    
    MainController main;
    
    public CreateNoteController(){
    }
    
    public void injectInstance(MainController main){
    	this.main = main;
	}

    @FXML
    void handleCreateNodeButton(ActionEvent event) throws Exception {
    	Note note = new Note(nameField.getText(), contentField.getText());
    	note.print();
    	main.addNoteToSet(note);
		main.showListScene();

    }

}
