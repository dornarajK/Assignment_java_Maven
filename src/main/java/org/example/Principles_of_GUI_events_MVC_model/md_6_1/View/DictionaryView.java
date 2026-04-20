package org.example.task1.View;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import org.example.task1.Controller.DictionaryController;

public class DictionaryView extends Application {

    private DictionaryController controller;
    private Label resultLabel = new Label("");

    @Override
    public void init() {
        controller = new DictionaryController();
    }

    @Override
    public void start(Stage stage) {
        TextField wordField = new TextField();
        wordField.setPromptText("Enter word");

        Button searchButton = new Button("Search");

        FlowPane pane = new FlowPane();
        pane.setHgap(10);
        pane.setVgap(10);
        pane.setPadding(new Insets(10));

        pane.getChildren().addAll(wordField, searchButton, resultLabel);

        searchButton.setOnAction(e -> {
            String word = wordField.getText();
            String result = controller.searchWord(word);
            resultLabel.setText(result != null ? result : "Not found");
        });

        Scene scene = new Scene(pane, 400, 150);

        stage.setTitle("Virtual Dictionary");
        stage.setScene(scene);
        stage.show();
    }
}