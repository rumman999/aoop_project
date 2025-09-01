package com.example.aoop_project;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.util.ArrayList;
import java.util.List;

public class LofiMusicController {

    @FXML
    private Label songLabel;

    @FXML
    private Button playPauseBtn;

    private MediaPlayer mediaPlayer;
    private boolean isPlaying = false;
    private int currentIndex = 0;

    private final List<String> playlist = new ArrayList<>();

    @FXML
    public void initialize() {
        // Load songs into playlist (ensure the path is correct relative to the classpath)
        playlist.add(getClass().getResource("/com/example/aoop_project/Music/lofi1.mp3").toExternalForm());
        playlist.add(getClass().getResource("/com/example/aoop_project/Music/lofi2.mp3").toExternalForm());
        playlist.add(getClass().getResource("/com/example/aoop_project/Music/lofi3.mp3").toExternalForm());
        playlist.add(getClass().getResource("/com/example/aoop_project/Music/lofi4.mp3").toExternalForm());

        // Start with first song loaded
        playSong(currentIndex);
    }

    @FXML
    private void handlePlayPause() {
        if (mediaPlayer == null) return;

        if (isPlaying) {
            mediaPlayer.pause();
            playPauseBtn.setText("Play");
        } else {
            mediaPlayer.play();
            playPauseBtn.setText("Pause");
        }
        isPlaying = !isPlaying;
    }

    @FXML
    private void handleNext() {
        currentIndex++;
        if (currentIndex >= playlist.size()) currentIndex = 0;
        playSong(currentIndex);
    }

    @FXML
    private void handlePrev() {
        currentIndex--;
        if (currentIndex < 0) currentIndex = playlist.size() - 1;
        playSong(currentIndex);
    }

    private void playSong(int index) {
        if (mediaPlayer != null) {
            mediaPlayer.stop();
        }

        Media sound = new Media(playlist.get(index));
        mediaPlayer = new MediaPlayer(sound);

        mediaPlayer.setOnEndOfMedia(this::handleNext);

        songLabel.setText("Now Playing: Lofi Track " + (index + 1));
        mediaPlayer.play();
        playPauseBtn.setText("Pause");
        isPlaying = true;
    }
}

