package com.example.aoop_project;

import javafx.fxml.FXML;
import javafx.scene.control.*;

import javafx.fxml.FXML;
import javafx.scene.layout.VBox;

public class loginController {

    @FXML private VBox loginForm;
    @FXML private VBox signupForm;

    @FXML
    private void showSignupForm() {
        loginForm.setVisible(false);
        loginForm.setManaged(false);
        signupForm.setVisible(true);
        signupForm.setManaged(true);
    }

    @FXML
    private void showLoginForm() {
        signupForm.setVisible(false);
        signupForm.setManaged(false);
        loginForm.setVisible(true);
        loginForm.setManaged(true);
    }

    @FXML
    private void handleLogin() {
        // Your existing login logic here
    }

    @FXML
    private void handleSignup() {
        // Your existing signup logic here
    }
}

