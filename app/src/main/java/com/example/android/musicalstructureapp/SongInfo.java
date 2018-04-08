package com.example.android.musicalstructureapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class SongInfo extends AppCompatActivity {

    public ArrayList<Song> songs;
    public int position;
    public int listSize;
    public int sorting;
    private TextView artist;
    private TextView title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song_info);

        songs =  getIntent().getParcelableArrayListExtra("songs");
        position = getIntent().getExtras().getInt("position");
        listSize = getIntent().getExtras().getInt("listLength");
        sorting = getIntent().getExtras().getInt("sorting");
        artist = findViewById(R.id.artist);
        title = findViewById(R.id.title);
        TextView previous = findViewById(R.id.previous);
        TextView next = findViewById(R.id.next);
        Button back = findViewById(R.id.back);
        display();

        // Set onClickListener for next and previous, change the position to display next or previous song from the list
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

        // Go back to the MainActivity
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SongInfo.this, MainActivity.class);
                // Keep the info how the list was sorted, before going to this activity
                intent.putExtra("sort", sorting);
                startActivity(intent);
            }
        });
    }

    // Display proper artist and title
    public void display() {
        Song currentSong = songs.get(position);
        artist.setText(currentSong.getArtist());
        title.setText(currentSong.getTitle());
    }
}
