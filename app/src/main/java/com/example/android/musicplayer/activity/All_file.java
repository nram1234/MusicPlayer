package com.example.android.musicplayer.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.android.musicplayer.adapter.Folder_recyclerview;
import com.example.android.musicplayer.R;
import com.example.android.musicplayer.dataType.FolderOfSong_Data_type;

import java.util.ArrayList;
import java.util.List;

public class All_file extends AppCompatActivity {
    // get link to recyclerView
    RecyclerView recyclerView;
    //the list will save data in
    List<FolderOfSong_Data_type> allSongFolder;
    //the adapter will link data to custom listview
    Folder_recyclerview adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_file);
        //get the recyclerView
        recyclerView = findViewById(R.id.allFolderInDevice);

        allSongFolder = new ArrayList<>();
        // make loop to add data to list
        for (int i = 0; i < 50; i++) {

            allSongFolder.add(new FolderOfSong_Data_type("folder " + i, 10 + i));

        }
        //make the adapter and send the context and list of data
        adapter = new Folder_recyclerview(this, allSongFolder);
        //make the list GridLayout
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(mLayoutManager);
        //set the Adapter
        recyclerView.setAdapter(adapter);
    }
}
