module com.example.aoop_project {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires java.sql;
    requires java.desktop;
    requires java.net.http;
    requires org.json;
    requires google.genai;
    requires javafx.media;

    opens com.example.aoop_project to javafx.fxml;
    exports com.example.aoop_project;
}
