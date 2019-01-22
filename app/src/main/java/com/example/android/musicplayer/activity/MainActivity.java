package com.example.android.musicplayer.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.example.android.musicplayer.adapter.Folder_recyclerview;
import com.example.android.musicplayer.R;
import com.example.android.musicplayer.dataType.FolderOfSong_Data_type;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    Folder_recyclerview adapter;
    @BindView(R.id.folder)
    RecyclerView recyclerView;
    ArrayList<FolderOfSong_Data_type> recentSongFolder;
    Button moreFolder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        recentSongFolder = new ArrayList<>();
        //add folder with image
        recentSongFolder.add(new FolderOfSong_Data_type("folder have image", 4, R.drawable.ic_menu_gallery));
        recentSongFolder.add(new FolderOfSong_Data_type("folder have image", 2, R.drawable.ic_menu_send));

        for (int i = 0; i < 10; i++) {

            recentSongFolder.add(new FolderOfSong_Data_type("folder " + i, 10 + i));

        }
        adapter = new Folder_recyclerview(this, recentSongFolder);
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(adapter);
        moreFolder = findViewById(R.id.more_folder);
        moreFolder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, All_file.class));
            }
        });

    }
}
