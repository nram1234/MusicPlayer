package com.example.android.musicplayer.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.musicplayer.R;
import com.example.android.musicplayer.activity.Contents_Of_Folder;
import com.example.android.musicplayer.dataType.Song_Data_type;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Song_recyclerview extends RecyclerView.Adapter<Song_recyclerview.SongViewHolder> {
    Context context;
    List<Song_Data_type> songDetails;

    public Song_recyclerview(Context context, List<Song_Data_type> songDetails) {
        this.context = context;
        this.songDetails = songDetails;
    }

    @NonNull
    @Override
    public SongViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.song_details, viewGroup, false);

        return new SongViewHolder(itemView);

    }

    @Override
    public void onBindViewHolder(@NonNull SongViewHolder songViewHolder, int i) {
        Song_Data_type data = songDetails.get(i);
        songViewHolder.songName.setText(data.songName);
        songViewHolder.artistName.setText(data.getArtistName());

    }

    @Override
    public int getItemCount() {
        return songDetails.size();
    }

    public class SongViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.textView_songName)
        TextView songName;
        @BindView(R.id.textView_artistName)
        TextView artistName;

        public SongViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //play song
                    Toast.makeText(context, "play " + songDetails.get(getLayoutPosition()).getSongName(), Toast.LENGTH_SHORT).show();

                    if (songDetails.get(getLayoutPosition()).hasImage()) {
                        //int image=songDetails.get(getLayoutPosition()).getSongImage();
                        Contents_Of_Folder.doo(context, songDetails.get(getLayoutPosition()).getSongImage());

                    } else {
                        // set the image when click in recyclerView item to
                        Contents_Of_Folder.doo(context, R.drawable.mu);

                    }
                }
            });
        }
    }
}
