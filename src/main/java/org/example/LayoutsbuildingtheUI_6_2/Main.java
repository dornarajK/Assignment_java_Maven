package org.example.LayoutsbuildingtheUI_6_2;

import javafx.application.Application;
import javafx.stage.Stage;
import org.example.LayoutsbuildingtheUI_6_2.View.CurrencyView;

public class Main extends Application {

// mvn javafx:run
    @Override
    public void start(Stage stage) {
        CurrencyView view = new CurrencyView();
        view.init();
        view.start(stage);
    }
    public static void main(String[] args) {
        launch(args);
    }
}