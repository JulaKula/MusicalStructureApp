package com.example.android.musicalstructureapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class SongInfo extends AppCompatActivity {

    private ArrayList<Song> songs;
    private int position;
    private int listSize;
    private TextView artist;
    private TextView title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song_info);

        songs =  getIntent().getParcelableArrayListExtra("songs");
        position = getIntent().getExtras().getInt("position");
        listSize = getIntent().getExtras().getInt("listLength");
        artist = findViewById(R.id.artist);
        title = findViewById(R.id.title);
        TextView previous = findViewById(R.id.previous);
        TextView next = findViewById(R.id.next);
        Button back = findViewById(R.id.back);
        display();

        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                position -= 1;
                if (position < 0) {
                    position = listSize - 1;
                }
                display();
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                position += 1;
                if (position >= listSize) {
                    position = 0;
                }
                display();
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SongInfo.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    public void display() {
        Song currentSong = songs.get(position);
        artist.setText(currentSong.getArtist());
        title.setText(currentSong.getTitle());
    }
}
