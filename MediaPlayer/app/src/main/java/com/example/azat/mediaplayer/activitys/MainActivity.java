package com.example.azat.mediaplayer.activitys;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import com.example.azat.mediaplayer.R;
import com.example.azat.mediaplayer.adapters.MediaAdapter;
import com.example.azat.mediaplayer.models.MediaPlayerModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private final List<MediaPlayerModel> list = new ArrayList<>();
    private MediaAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRecyclerViewView();
        addList();
    }


    private void setRecyclerViewView() {
        final RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        adapter = new MediaAdapter(this, list);
        recyclerView.setAdapter(adapter);
        swipeToDeleteRight(recyclerView);
    }

    private void addList() {
        list.add(new MediaPlayerModel(R.drawable.scorpion, "Send me an angel", "Scorpions ", R.raw.scorpionssendmeanangel, true));
        list.add(new MediaPlayerModel(R.drawable.hamma, "Цветок", "HammAli & Navai ", R.raw.hammalinavai, true));
        list.add(new MediaPlayerModel(R.drawable.moreza, "Miss Guitar", "Moreza", R.raw.morezamissguitar, true));
        list.add(new MediaPlayerModel(R.drawable.bitlsi, "Yesterday", " Beatles ", R.raw.beatlesyesterday, true));
        list.add(new MediaPlayerModel(R.drawable.hragduxov, "Duxov", " ", R.raw.hragduxov, true));
        list.add(new MediaPlayerModel(R.drawable.aramasatryan, "Asem te Chasem", "Aram Asatryan ", R.raw.aramasatryan, true));
        list.add(new MediaPlayerModel(R.drawable.meduza, " Meduza", "Matrang ", R.raw.matrangmeduza, true));
        list.add(new MediaPlayerModel(R.drawable.tatasimonyan, "Hayastan barev", " Tata Simonyan", R.raw.tata, true));
        list.add(new MediaPlayerModel(R.drawable.yannipreludeandnostalgia, "Nostalgia", "Yanni & Samvel  ", R.raw.yannirisomallissamvelervinyan, true));
        list.add(new MediaPlayerModel(R.drawable.raim, " Лава", "Райм Артур ", R.raw.artur, true));
    }

    private void swipeToDeleteRight(final RecyclerView recyclerView) {
        final ItemTouchHelper.SimpleCallback simpleCallback = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
                final int position = viewHolder.getAdapterPosition();
                list.remove(position);
                adapter.notifyDataSetChanged();
            }
        };

        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(simpleCallback);
        itemTouchHelper.attachToRecyclerView(recyclerView);
    }

}

