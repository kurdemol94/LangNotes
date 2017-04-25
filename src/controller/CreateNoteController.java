package controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class CreateNoteController extends GridPane{

    @FXML private TextField TagsField;
    @FXML private Button CreateNoteButton;
    @FXML private TextField NameField;
    @FXML private TextArea ContentField;
    
    public CreateNoteController(){
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/CreateNote.fxml"));
    	loader.setRoot(this);
    	loader.setController(this);
    	try{
			loader.load();
		} catch (IOException e) {
		}
    	
    }

    @FXML
    void handleCreateNodeButton(ActionEvent event) {

    }

}
