package com.example.aoop_project;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class getStartedApplication extends Application {

    private static Stage primaryStage; // Keep a reference to the main stage

    @Override
    public void start(Stage stage) throws IOException {
        primaryStage = stage;
        launchScene("login.fxml");
        primaryStage.setTitle("Hello!");
        primaryStage.setFullScreen(true);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }

    public static void launchScene(String fxmlFile) {
        try {
            FXMLLoader loader = new FXMLLoader(getStartedApplication.class.getResource(fxmlFile));
            Scene scene = new Scene(loader.load());

            Stage newStage = new Stage();   // create new window
            newStage.setScene(scene);
            newStage.setFullScreen(true);
            newStage.setFullScreenExitHint("");
            newStage.show();

            // Close the old stage
            if (primaryStage != null) {
                primaryStage.close();
            }

            // Replace reference so next scenes know about new window
            primaryStage = newStage;

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}