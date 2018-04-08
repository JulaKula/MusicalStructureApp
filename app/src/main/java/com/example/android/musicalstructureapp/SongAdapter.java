package com.example.android.musicalstructureapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class SongAdapter extends ArrayAdapter<Song>{

    private SongAdapter(Context context, ArrayList<Song> songs){
        super(context, 0, songs);
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        // Check if an existing view is being reused, otherwise inflate the view
        View songInfoView = convertView;
        if (songInfoView == null) {
            songInfoView = LayoutInflater.from(getContext()).inflate(
                    R.layout.songs_list, parent, false);
        }

        Song currentSong = getItem(position);
        TextView artist = songInfoView.findViewById(R.id.artist);
        artist.setText(currentSong.getArtist());
        TextView title = songInfoView.findViewById(R.id.title);
        title.setText(currentSong.getTitle());

        return songInfoView;
    }
}
