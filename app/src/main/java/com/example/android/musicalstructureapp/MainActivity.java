package com.example.android.musicalstructureapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MainActivity extends AppCompatActivity {

    public int sorting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Create sample ArrayList of Song objects
        final ArrayList<Song> songs = new ArrayList<>();
        songs.add(new Song("Elton John", "Rocket Man"));
        songs.add(new Song("Elton John", "Madman Across the Water"));
        songs.add(new Song("Elton John", "Goodbye Yellow Brick Road"));
        songs.add(new Song("Elton John", "Someone Saved My Life Tonight"));
        songs.add(new Song("Elton John", "Your Song"));
        songs.add(new Song("Elton John", "Don't Go Breaking My Heart"));
        songs.add(new Song("Elton John", "Sorry Seems To Be The Hardest Word"));
        songs.add(new Song("Elton John", "Tiny Dancer"));
        songs.add(new Song("Elton John", "Levon"));
        songs.add(new Song("Elton John", "Bennie And The Jets"));
        songs.add(new Song("Elton John", "Philadelphia Freedom"));
        songs.add(new Song("Elton John", "I'm Still Standing"));
        songs.add(new Song("Kasabian", "Fire"));
        songs.add(new Song("Kasabian", "Club Foot"));
        songs.add(new Song("Bruno Mars", "Runaway Baby"));
        songs.add(new Song("Led Zeppelin", "Kashmir"));
        songs.add(new Song("Led Zeppelin", "Stairway to Heaven"));
        songs.add(new Song("Led Zeppelin", "Immigrant Song"));
        songs.add(new Song("Led Zeppelin", "Rock & Roll"));
        songs.add(new Song("Led Zeppelin", "Whole Lotta Love"));
        songs.add(new Song("Led Zeppelin", "Babe I'm Gonna Leave You"));
        songs.add(new Song("Led Zeppelin", "The Rain Song"));
        songs.add(new Song("Led Zeppelin", "All My Love"));
        songs.add(new Song("Led Zeppelin", "Ten Years Gone"));
        songs.add(new Song("Led Zeppelin", "Over the Hills and Far Away"));
        songs.add(new Song("Led Zeppelin", "Good Times Bad Times"));
        songs.add(new Song("Led Zeppelin", "Black Dog"));
        songs.add(new Song("Janis Joplin", "Move Over"));
        songs.add(new Song("Goo Goo Dolls", "Iris"));
        songs.add(new Song("Norah Jones", "Come Away With Me"));
        songs.add(new Song("Norah Jones", "Don't Know Why"));
        songs.add(new Song("Norah Jones", "Happy Pills"));
        songs.add(new Song("Norah Jones", "Sunrise"));
        songs.add(new Song("The Beatles", "Let It Be"));
        songs.add(new Song("The Beatles", "Hey Jude"));
        songs.add(new Song("The Beatles", "Strawberry Fields Forever"));
        songs.add(new Song("The Beatles", "Come Together"));
        songs.add(new Song("The Beatles", "Dear Prudence"));
        songs.add(new Song("The Beatles", "Help!"));
        songs.add(new Song("The Beatles", "Yesterday"));
        songs.add(new Song("The Beatles", "Helter Skelter"));
        songs.add(new Song("The Beatles", "I Want to Hold Your Hand"));
        songs.add(new Song("The Beatles", "Rain"));
        songs.add(new Song("The Beatles", "Love Me Do"));
        songs.add(new Song("The Beatles", "Twist And Shout"));
        songs.add(new Song("The Beatles", "A Hard Day's Night"));
        songs.add(new Song("The Beatles", "She Loves You"));
        songs.add(new Song("The Beatles", "Back In The U.S.S.R."));
        songs.add(new Song("The Beatles", "In My Life"));
        songs.add(new Song("The Beatles", "Day Tripper"));
        songs.add(new Song("The Beatles", "Paperback Writer"));
        songs.add(new Song("The Beatles", "Magical Mystery Tour"));
        songs.add(new Song("The Beatles", "Ticket To Ride"));
        songs.add(new Song("The Beatles", "I Saw Her Standing There"));
        songs.add(new Song("The Beatles", "Here Comes The Sun"));
        songs.add(new Song("The Beatles", "Think For Yourself"));
        songs.add(new Song("Aretha Franklin", "Respect"));
        songs.add(new Song("Kings of Leon", "Sex On Fire"));
        songs.add(new Song("Kings of Leon", "Red Morning Light"));
        songs.add(new Song("Kings of Leon", "Closer"));
        songs.add(new Song("Kings of Leon", "Wait For Me"));
        songs.add(new Song("Kings of Leon", "The Bucket"));
        songs.add(new Song("Kings of Leon", "The End"));
        songs.add(new Song("Kings of Leon", "Manhattan"));
        songs.add(new Song("Kings of Leon", "Revelry"));
        songs.add(new Song("Kings of Leon", "Fans"));
        songs.add(new Song("Kings of Leon", "Pyro"));
        songs.add(new Song("Kings of Leon", "Temple"));
        songs.add(new Song("Kings of Leon", "Radioactive"));
        songs.add(new Song("Kings of Leon", "Taper Jean Gril"));
        songs.add(new Song("Kings of Leon", "Use Somebody"));
        songs.add(new Song("Ingrid Michaelson", "Keep Breathing"));
        songs.add(new Song("Ingrid Michaelson", "The Way I Am"));
        songs.add(new Song("Ingrid Michaelson", "Be OK"));
        songs.add(new Song("Ingrid Michaelson", "Breakable"));
        songs.add(new Song("Ingrid Michaelson", "Maybe"));
        songs.add(new Song("Ingrid Michaelson", "You and I"));
        songs.add(new Song("Oasis", "Wonderwall"));
        songs.add(new Song("Oasis", "Champagne"));
        songs.add(new Song("Oasis", "Don't Look Back in Anger"));
        songs.add(new Song("Oasis", "All Around The World"));
        songs.add(new Song("Oasis", "Supersonic"));
        songs.add(new Song("ABBA", "Mamma Mia"));
        songs.add(new Song("ABBA", "S.O.S."));
        songs.add(new Song("ABBA", "Waterloo"));
        songs.add(new Song("ABBA", "Dancing Queen"));
        songs.add(new Song("ABBA", "I Do, I Do, I Do, I Do, I Do"));

        TextView title_normal = findViewById(R.id.title_normal);
        TextView title_reverse = findViewById(R.id.title_reverse);
        TextView artist_normal = findViewById(R.id.artist_normal);
        TextView artist_reverse = findViewById(R.id.artist_reverse);

        // Set onClickListeners to enable sorting the list, keep track of which kind of sorting was chosen
        title_normal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sorting = 0;
                Collections.sort(songs, new Comparator<Song>() {
                    @Override
                    public int compare(Song o1, Song o2) {
                        int comp = o1.getTitle().compareTo(o2.getTitle());
                        if (o1.getTitle().equals(o2.getTitle())) {
                            comp = o1.getArtist().compareTo(o2.getArtist());
                        }
                        return comp;
                    }
                });
                settingAdapter(songs);
            }
        });

        title_reverse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sorting = 1;
                Collections.sort(songs, new Comparator<Song>() {
                    @Override
                    public int compare(Song o1, Song o2) {
                        int comp = o2.getTitle().compareTo(o1.getTitle());
                        if (o2.getTitle().equals(o1.getTitle())) {
                            comp = o1.getArtist().compareTo(o2.getArtist());
                        }
                        return comp;
                    }
                });
                settingAdapter(songs);
            }
        });

        artist_normal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sorting = 2;
                Collections.sort(songs, new Comparator<Song>() {
                    @Override
                    public int compare(Song o1, Song o2) {
                        int comp = o1.getArtist().compareTo(o2.getArtist());
                        if (o2.getArtist().equals(o1.getArtist())) {
                            comp = o1.getTitle().compareTo(o2.getTitle());
                        }
                        return comp;
                    }
                });
                settingAdapter(songs);
            }
        });

        artist_reverse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sorting = 3;
                Collections.sort(songs, new Comparator<Song>() {
                    @Override
                    public int compare(Song o1, Song o2) {
                        int comp = o2.getArtist().compareTo(o1.getArtist());
                        if (o2.getArtist().equals(o1.getArtist())) {
                            comp = o1.getTitle().compareTo(o2.getTitle());
                        }
                        return comp;
                    }
                });
                settingAdapter(songs);
            }
        });

        // Get the intent if there is any, to sort the list the way it was sorted before
        Intent intent = getIntent();
        if (intent != null) {
            Bundle extras = intent.getExtras();
            if (extras != null) {
                if (extras.containsKey("sort")) {
                    sorting = intent.getExtras().getInt("sort");
                }
            }
        }

        if (sorting == 0) {
            title_normal.performClick();
        } else if (sorting == 1) {
            title_reverse.performClick();
        } else if (sorting == 2) {
            artist_normal.performClick();
        } else if (sorting == 3) {
            artist_reverse.performClick();
        }
    }

    public void settingAdapter(final ArrayList<Song> songs) {
        SongAdapter adapter = new SongAdapter(this, songs);
        ListView listView = findViewById(R.id.list);
        listView.setAdapter(adapter);

        // Set onItemClickListener to enable starting new activity, add extras to the intent
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                int listLength = songs.size();
                Intent intent = new Intent(MainActivity.this, SongInfo.class);
                intent.putExtra("position", position);
                intent.putExtra("sorting", sorting);
                intent.putExtra("listLength", listLength);
                intent.putParcelableArrayListExtra("songs", songs);
                startActivity(intent);
            }
        });
    }

}
