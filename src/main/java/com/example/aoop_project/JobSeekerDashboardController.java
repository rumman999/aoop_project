package com.example.aoop_project;

import com.example.aoop_project.Session;
import com.example.aoop_project.getStartedApplication;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

public class JobSeekerDashboardController implements Initializable {

    @FXML private Label dashBoardName;
    @FXML private Label UserName;
    @FXML private Label accountDes;
    @FXML private Button logout_button;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loadUserDataFromDB(); // fetch logged-in user data automatically
    }

    private void loadUserDataFromDB() {
        String userEmail = Session.getLoggedInUserEmail();
        if(userEmail == null || userEmail.isEmpty()) return;

        String SUrl = "jdbc:mysql://localhost:4306/java_user_database";
        String SUser = "root";
        String SPass = "";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(SUrl, SUser, SPass);

            String query = "SELECT full_name, account_type FROM user WHERE email=?";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, userEmail);

            ResultSet rs = pst.executeQuery();
            if(rs.next()) {
                String fullName = rs.getString("full_name");
                String accountType = rs.getString("account_type");

                UserName.setText(fullName);
                dashBoardName.setText(fullName);
                accountDes.setText(accountType);
            }

            rs.close();
            pst.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleLogout(ActionEvent e) {
        Session.clear(); // clear logged-in user

        getStartedApplication.launchScene("login.fxml"); // use existing launcher
    }


    @FXML
    private void handleChatbot(ActionEvent e) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ChatBot.fxml"));
            Parent root = loader.load();

            Stage chatStage = new Stage();
            chatStage.setTitle("Skill Buddy");
            chatStage.setScene(new Scene(root));
            chatStage.getScene().setFill(javafx.scene.paint.Color.web("#2c3e50"));

            // Make it float above dashboard
            chatStage.initOwner(((Node) e.getSource()).getScene().getWindow());
            chatStage.initModality(Modality.NONE); // background remains interactive

            // Small popup size
            chatStage.setWidth(450);
            chatStage.setHeight(550);
            chatStage.setResizable(true);

            // Optional: remove taskbar icon and keep it utility style
            chatStage.initStyle(StageStyle.UTILITY);

            // Show popup
            chatStage.show();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

}


}
