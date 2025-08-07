package com.example.aoop_project;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class getStartedController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}