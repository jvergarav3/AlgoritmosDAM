package com.operative_systems;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        FXMLLoader loader = new FXMLLoader(
                getClass().getResource("/fxml/layout/MainLayout.fxml")
        );

        Scene scene = new Scene(loader.load());

        scene.getStylesheets().add(
                getClass()
                        .getResource("/css/application.css")
                        .toExternalForm()
        );

        stage.setTitle("DAM Algorithms");
        stage.setScene(scene);
        stage.setWidth(1400);
        stage.setHeight(900);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
