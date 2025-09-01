package com.example.aoop_project;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class ChatBotApp extends Application {

    private static final String API_URL = "https://openrouter.ai/api/v1/chat/completions";
    private static final String API_KEY = System.getenv("OPENROUTER_API_KEY");
    // 🔑 Load from environment instead of hardcoding for safety
    //private static final String API_KEY = System.getenv("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");

    private VBox chatBox;
    private TextField inputField;

    @Override
    public void start(Stage stage) {
        chatBox = new VBox(10);
        chatBox.setPadding(new Insets(10));
        ScrollPane scrollPane = new ScrollPane(chatBox);
        scrollPane.setFitToWidth(true);

        inputField = new TextField();
        inputField.setPromptText("Type your message...");
        inputField.setOnAction(e -> sendMessage());

        Button sendButton = new Button("Send");
        sendButton.setOnAction(e -> sendMessage());

        HBox inputArea = new HBox(10, inputField, sendButton);
        inputArea.setPadding(new Insets(10));

        BorderPane root = new BorderPane();
        root.setCenter(scrollPane);
        root.setBottom(inputArea);

        Scene scene = new Scene(root, 500, 600);
        stage.setTitle("ChatBot - LLaMA 4 Maverick");
        stage.setScene(scene);
        stage.show();
    }

    private void sendMessage() {
        String userMessage = inputField.getText().trim();
        if (userMessage.isEmpty()) return;

        addMessage("You: " + userMessage);
        inputField.clear();

        new Thread(() -> {
            try {
                String botReply = callLlamaAPI(userMessage);
                javafx.application.Platform.runLater(() -> addMessage("Bot: " + botReply));
            } catch (Exception e) {
                e.printStackTrace();
                javafx.application.Platform.runLater(() -> addMessage("Bot: [Error] " + e.getMessage()));
            }
        }).start();
    }

    private void addMessage(String message) {
        Label label = new Label(message);
        label.setWrapText(true);
        label.setStyle("-fx-background-color: #e1f5fe; -fx-padding: 8px; -fx-background-radius: 8px;");
        chatBox.getChildren().add(label);
    }

    private String callLlamaAPI(String userMessage) throws Exception {
        if (API_KEY == null) {
            throw new IllegalArgumentException("API key not set. Use OPENROUTER_API_KEY env var.");
        }

        URL url = new URL(API_URL);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Authorization", "Bearer " + API_KEY);
        conn.setRequestProperty("Content-Type", "application/json");
        conn.setDoOutput(true);

        JSONObject body = new JSONObject();
        body.put("model", "meta-llama/llama-4-maverick");
        JSONArray messages = new JSONArray();
        messages.put(new JSONObject().put("role", "user").put("content", userMessage));
        body.put("messages", messages);

        try (OutputStream os = conn.getOutputStream()) {
            byte[] input = body.toString().getBytes("utf-8");
            os.write(input, 0, input.length);
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));
        StringBuilder response = new StringBuilder();
        String line;
        while ((line = br.readLine()) != null) {
            response.append(line.trim());
        }

        JSONObject jsonResponse = new JSONObject(response.toString());
        return jsonResponse
                .getJSONArray("choices")
                .getJSONObject(0)
                .getJSONObject("message")
                .getString("content")
                .trim();
    }

    public static void main(String[] args) {
        launch();
    }
}
