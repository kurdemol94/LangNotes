package controller;

import java.util.Iterator;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableSet;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.ValueAxis;
import javafx.scene.control.Accordion;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.VBox;
import model.Note;

public class ListNotesController {
	MainController main;
	ObservableSet<Note> set;
	ObservableList<TitledPane> paneList;

	@FXML private Button newNoteButton;
	@FXML private Accordion accordion;
	@FXML private Label infoLabel;
	@FXML private TextField searchField;
	@FXML private Button searchButton;

	public void setUp() throws Exception {
		set = main.getSet();
		paneList = FXCollections.observableArrayList();
		generateList();

	}

	@FXML
	private void handleNewNoteButton(ActionEvent event) throws Exception {
		main.showCreateScene();
	}
	
	@FXML
	private void handleSearchButton(ActionEvent event){
		if (searchField.getText().isEmpty()){
			infoLabel.setText("Enter a value");
		}
		else {
			accordion.getPanes().removeAll(paneList);
			infoLabel.setText("Searching...");
			int results = 0;
			String value = searchField.getText();
			for (Note n : set){
				if (n.getName().contains(value) || n.getContent().contains(value)){
					TitledPane pane = new TitledPane();
					pane.setText(n.getName());

					VBox box = new VBox();
					box.getChildren().add(new Label(n.getContent()));
					pane.setContent(box);

					paneList.add(pane);
					accordion.getPanes().add(pane);
					results++;
					infoLabel.setText("Results: " + results);
				}
			}
		}
		
	}

	public void injectInstance(MainController main) {
		this.main = main;
	}

	public void generateList() {
		if (set.isEmpty()) {
			System.out.println("No entries");
			infoLabel.setText("No entries. Press the button at the top to add notes.");
		} else {
			Iterator<Note> it = set.iterator();
			accordion.getPanes().removeAll(paneList);
			while (it.hasNext()) {
				Note n = it.next();
				TitledPane pane = new TitledPane();
				pane.setText(n.getName());

				VBox box = new VBox();
				box.getChildren().add(new Label(n.getContent()));
				pane.setContent(box);

				paneList.add(pane);
				accordion.getPanes().add(pane);
			}
			infoLabel.setText("Notes: " + set.size());
		}

	}
}
