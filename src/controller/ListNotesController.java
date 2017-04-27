package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableSet;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Accordion;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import model.Note;

public class ListNotesController {
	MainController main;
	ObservableSet<Note> set;
	ObservableList<TitledPane> paneList;

	@FXML
	private Button newNoteButton;
	@FXML
	private Accordion accordion;
	@FXML
	private Label infoLabel;
	@FXML
	private TextField searchField;
	@FXML
	private Button searchButton;

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
	private void handleSearchButton(ActionEvent event) {
		if (searchField.getText().isEmpty()) {
			infoLabel.setText("Enter a value");
			generateList();
			infoLabel.setText("Notes: " + set.size());
		} else {
			accordion.getPanes().removeAll(paneList);
			infoLabel.setText("Searching...");
			int results = 0;
			String value = searchField.getText();
			for (Note n : set) {
				if (n.getName().contains(value) || n.getContent().contains(value)) {
					HBox box = new HBox();
					box.getChildren().addAll(new Button("Edit"), new Button("Delete"));

					GridPane grid = new GridPane();
					grid.addRow(0, new Label(n.getContent()));
					grid.addRow(1, box);

					TitledPane pane = new TitledPane(n.getName(), grid);
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
			accordion.getPanes().removeAll(paneList);
			for (Note n : set) {
				
				Button edit = new Button("Edit");
				edit.setOnAction(e ->{
					System.out.println("trynna edit note named " + n.getName());
				});
				HBox box = new HBox(edit);
				GridPane grid = new GridPane();
				grid.addRow(0, new Label(n.getContent()));
				grid.addRow(1, box);

				TitledPane pane = new TitledPane(n.getName(), grid);
				pane.setLineSpacing(10);
				paneList.add(pane);
				accordion.getPanes().add(pane);
			}
			infoLabel.setText("Notes: " + set.size());
		}

	}
	
	public void editSelected(){
		
	}
}
