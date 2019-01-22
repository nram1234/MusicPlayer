package com.example.android.musicplayer.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.android.musicplayer.R;
import com.example.android.musicplayer.adapter.Song_recyclerview;
import com.example.android.musicplayer.dataType.FolderOfSong_Data_type;
import com.example.android.musicplayer.dataType.Song_Data_type;

import java.util.ArrayList;

public class Contents_Of_Folder extends AppCompatActivity implements View.OnClickListener {
    ArrayList<Song_Data_type> songInFolder = new ArrayList<>();
    RecyclerView recyclerView;
    Song_recyclerview adapter;
    static ImageView imageOfSong;
    Button play, next, back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contents__of__folder);
        //get intent
        Intent intent = getIntent();
        //get name of Folder from intent from start activity
        FolderOfSong_Data_type data = intent.getParcelableExtra("data");
        // make the titel of bar have name of Folder
        getSupportActionBar().setTitle(data.getNameOfFolder());

        //get link between xml and java
        recyclerView = findViewById(R.id.allSongInFolder);
        //get number of song in folder
        int numberOfSong = data.numberOfSong;
        //get id of image
        int imageId = data.imageArtist;
        //get link between xml and java
        imageOfSong = findViewById(R.id.imageViewOf_folder);
        //get link between xml and java
        back = (Button) findViewById(R.id.back);
        back.setOnClickListener(this);
        //get link between xml and java
        play = (Button) findViewById(R.id.play);
        play.setOnClickListener(this);
        //get link between xml and java
        next = (Button) findViewById(R.id.next);
        next.setOnClickListener(this);
        //get image of folder and set it
        if (imageId != FolderOfSong_Data_type.NO_IMAG) {
            imageOfSong.setImageResource(imageId);
        } else {
            //set default image if folder not have
            imageOfSong.setImageResource(R.drawable.mu);
        }
        //add folder with image
        songInFolder.add(new Song_Data_type("songName 1", "artistName 1", R.drawable.ic_menu_camera));
        songInFolder.add(new Song_Data_type("songName 40", "artistName 40", R.drawable.ic_library_music_black_24dp));
        songInFolder.add(new Song_Data_type("songName 55", "artistName 55", R.drawable.ic_menu_gallery));
// loop to add folder file
        for (int i = 0; i < numberOfSong; i++) {
            songInFolder.add(new Song_Data_type("songName " + i, "artistName " + i));
        }
        //send data to adapter
        adapter = new Song_recyclerview(this, songInFolder);
        //set data view LinearLayout
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(adapter);
    }

    //set the image when click in recyclerView item
    public static void doo(Context context, int image) {

        imageOfSong.setImageResource(image);

    }

    //handle multiple view click events
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back:
                Toast.makeText(this, "back", Toast.LENGTH_SHORT).show();
                break;


            case R.id.play:
                Toast.makeText(this, "play", Toast.LENGTH_SHORT).show();

                break;
            case R.id.next:
                Toast.makeText(this, "next", Toast.LENGTH_SHORT).show();

                break;
        }
    }
}
