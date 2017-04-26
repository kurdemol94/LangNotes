package application;
	
import controller.CreateNoteController;
import controller.ListNotesController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


public class Main extends Application {
	Stage primaryStage;
	Pane listPane;
	Pane createPane;
	FXMLLoader loader1;
	FXMLLoader loader2;
	Scene listScene;
	Scene createScene;
	
	
	
	@Override
    public void start(Stage primaryStage) throws Exception {
       primaryStage.setTitle("LangNotes");
       
       loader1 = new FXMLLoader(getClass().getResource("../fxml/ListNotes.fxml"));
       ListNotesController listController = new ListNotesController();
       loader1.setController(listController);
       listPane = loader1.load();
       listController.injectInstance(this);
       
       loader2 = new FXMLLoader(getClass().getResource("../fxml/CreateNote.fxml"));
       CreateNoteController createController = new CreateNoteController();
       loader2.setController(createController);
       createPane = loader2.load();
       createController.injectInstance(this);
       
       listScene = new Scene(listPane);
       createScene = new Scene(createPane);
       primaryStage.setScene(listScene);
       primaryStage.show();
       
    }
	
	public void showCreateScene() throws Exception{
		primaryStage.setScene(createScene);
	    primaryStage.show();
	}
	
	public void showListScene() throws Exception {
        primaryStage.setScene(listScene);
	    primaryStage.show();
	}
	
	
 
    public static void main(String[] args) {
        launch(args);
    }
}
