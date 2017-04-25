package application;
	
import controller.CreateNoteController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {
	
	@Override
	public void start(Stage stage) {
        CreateNoteController controller = new CreateNoteController();
        
        stage.setScene(new Scene(controller));

        stage.show();
    }
	
	
	public static void main(String[] args) {
		launch(args);
	}
}
