package controller;

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
    
    public CreateNoteController(){
    }

    @FXML
    void handleCreateNodeButton(ActionEvent event) {
    	String []tags = tagsField.getText().split(",");
    	Note note = new Note(nameField.getText(), contentField.getText(), tags);
    	note.print();

    }

}
