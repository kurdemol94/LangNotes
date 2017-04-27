package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import model.Note;

public class CreateNoteController extends AnchorPane{

    @FXML private Button createNoteButton;
    @FXML private TextField nameField;
    @FXML private TextArea contentField;
    @FXML private Label msgLabel;
    
    MainController main;
    
    public void injectInstance(MainController main){
    	this.main = main;
	}

    @FXML
    private void handleCreateNodeButton(ActionEvent event) throws Exception {
    	if (!main.addNoteToSet(new Note(nameField.getText(), contentField.getText()))){
    		msgLabel.setTextFill(Color.RED);
    		msgLabel.setText("A note with this name already exists!");
    	}
    	else {
    		nameField.clear();
    		contentField.clear();
    		main.showListScene();
    	}
    }

}
