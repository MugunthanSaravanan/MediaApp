package com.example.audvid;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer;
    private VideoView videoView;
    private Button playAudioButton;
    private Button pauseAudioButton;
    private Button playVideoButton;
    private Button pauseVideoButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mediaPlayer = MediaPlayer.create(this, R.raw.audio);
        videoView = findViewById(R.id.videoView);
        playAudioButton = findViewById(R.id.playAudioButton);
        pauseAudioButton = findViewById(R.id.pauseAudioButton);
        playVideoButton = findViewById(R.id.playVideoButton);
        pauseVideoButton = findViewById(R.id.pauseVideoButton);

        playAudioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mediaPlayer.isPlaying()) {
                    mediaPlayer.start();
                    playAudioButton.setVisibility(View.GONE);
                    pauseAudioButton.setVisibility(View.VISIBLE);

                    // Pause video if it's playing
                    if (videoView.isPlaying()) {
                        videoView.pause();
                        pauseVideoButton.setVisibility(View.GONE);
                        playVideoButton.setVisibility(View.VISIBLE);
                    }
                }
            }
        });

        pauseAudioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mediaPlayer.isPlaying()) {
                    mediaPlayer.pause();
                    pauseAudioButton.setVisibility(View.GONE);
                    playAudioButton.setVisibility(View.VISIBLE);
                }
            }
        });

        playVideoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!videoView.isPlaying()) {
                    videoView.setVisibility(View.VISIBLE);
                    videoView.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.myvideo));
                    videoView.start();
                    playVideoButton.setVisibility(View.GONE);
                    pauseVideoButton.setVisibility(View.VISIBLE);

                    // Pause audio if it's playing
                    if (mediaPlayer.isPlaying()) {
                        mediaPlayer.pause();
                        pauseAudioButton.setVisibility(View.GONE);
                        playAudioButton.setVisibility(View.VISIBLE);
                    }
                }
            }
        });

        pauseVideoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (videoView.isPlaying()) {
                    videoView.pause();
                    pauseVideoButton.setVisibility(View.GONE);
                    playVideoButton.setVisibility(View.VISIBLE);
                }
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mediaPlayer != null) {
            mediaPlayer.release();
        }
    }
}
