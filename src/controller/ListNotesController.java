package controller;

import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class ListNotesController {
	Main main;

    @FXML
    private Button newNoteButton;

    @FXML
    void handleNewNoteButton(ActionEvent event) throws Exception {
    	System.out.println("Attempting to chance the scene");
    	main.showCreateScene();
    	System.out.println("scene changed");
    }

    @FXML
    private void initialize(){
    	
    }
    
    public void injectInstance(Main main){
    	System.out.println("Attempting to inject main into listcontroller");
    	this.main = main;
    	System.out.println("listcontroller: done");
	}
}
