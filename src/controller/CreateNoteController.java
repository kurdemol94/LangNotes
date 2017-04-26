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
    
    Main main;
    
    public CreateNoteController(){
    }
    
    public void injectInstance(Main main){
    	System.out.println("Attempting to inject main into listcontroller");
    	this.main = main;
    	System.out.println("listcontroller: done");
	}

    @FXML
    void handleCreateNodeButton(ActionEvent event) throws Exception {
    	String []tags = tagsField.getText().split(",");
    	Note note = new Note(nameField.getText(), contentField.getText(), tags);
    	note.print();
    	main.showListScene();

    }

}
