package com.example.android.musicplayer.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.musicplayer.R;
import com.example.android.musicplayer.activity.Contents_Of_Folder;
import com.example.android.musicplayer.dataType.FolderOfSong_Data_type;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Folder_recyclerview extends RecyclerView.Adapter<Folder_recyclerview.FolderViewHolder> {
    //get the context
    Context context;
    //get list of data
    List<FolderOfSong_Data_type> folderData;

    //make the constructor
    public Folder_recyclerview(Context context, List<FolderOfSong_Data_type> folderData) {
        this.context = context;
        this.folderData = folderData;
    }

    //Inflat the view
    @NonNull
    @Override
    public FolderViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.folder_song, viewGroup, false);

        return new FolderViewHolder(itemView);
    }

    //set the data to the view
    @Override
    public void onBindViewHolder(@NonNull FolderViewHolder folderViewHolder, int i) {
        //get the item in list
        FolderOfSong_Data_type data = folderData.get(i);
        folderViewHolder.folderName.setText(data.nameOfFolder);
        folderViewHolder.numberOfSong.setText("song " + data.numberOfSong);
        //get the image if it have
        if (data.hasImage()) {
            folderViewHolder.imageView.setImageResource(data.getImageArtist());
        }
    }

    //get the Count of item in data list
    @Override
    public int getItemCount() {
        return folderData.size();
    }

    //get link ViewHolder to xml
    public class FolderViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.folder_name)
        TextView folderName;
        @BindView(R.id.number_of_song)
        TextView numberOfSong;
        @BindView(R.id.imageViewOfFolder)
        ImageView imageView;

        public FolderViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //get the data by Position to send it the play Activity
                    FolderOfSong_Data_type data = folderData.get(getAdapterPosition());
                    Intent i = new Intent(context, Contents_Of_Folder.class);
                    i.putExtra("data", data);
                    context.startActivity(i);
                }
            });
        }
    }
}
