package com.example.azat.mediaplayer.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.azat.mediaplayer.R;
import com.example.azat.mediaplayer.models.MediaPlayerModel;
import com.example.azat.mediaplayer.services.MyMediaPlayer;

import java.util.List;


public class MediaAdapter extends RecyclerView.Adapter<MediaAdapter.MyViewHolder> {


    public static final String KEY = "tag";
    private final Context context;
    private final List<MediaPlayerModel> list;

    public MediaAdapter(final Context context, final List<MediaPlayerModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MediaAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final View v = LayoutInflater.from(context).inflate(R.layout.play_item, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MediaAdapter.MyViewHolder holder, int position) {
        holder.textName.setText(list.get(position).getName());
        holder.textMusicName.setText(list.get(position).getMusicName());
        holder.imageId.setImageResource(list.get(position).getImageid());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    class MyViewHolder extends RecyclerView.ViewHolder {
        private final ImageView imageId;
        private final TextView textName;
        private final TextView textMusicName;
        private final ImageButton playButton;

        MyViewHolder(View itemView) {
            super(itemView);
            textName = itemView.findViewById(R.id.name_item);
            textMusicName = itemView.findViewById(R.id.item_music_name);
            imageId = itemView.findViewById(R.id.image_item);
            playButton = itemView.findViewById(R.id.play_item_button);

            playButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (list.get(getAdapterPosition()).isPlayMedia()) {
                        list.get(getAdapterPosition()).setPlayMedia(false);
                        playButton.setImageResource(R.drawable.ic_play);
                        Intent intent = new Intent(context, MyMediaPlayer.class);
                        intent.putExtra("tag", list.get(getAdapterPosition()).getSongs());
                        context.startService(intent);
                    } else {
                        list.get(getAdapterPosition()).setPlayMedia(true);
                        playButton.setImageResource(R.drawable.ic_pause);
                        context.stopService(new Intent(context, MyMediaPlayer.class));
                    }
                }

            });

        }
    }
}