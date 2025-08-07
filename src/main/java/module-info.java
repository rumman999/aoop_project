module com.example.aoop_project {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.aoop_project to javafx.fxml;
    exports com.example.aoop_project;
}