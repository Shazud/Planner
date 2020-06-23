package com.ddp.planner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.ddp.planner.note.Note;
import com.ddp.planner.note.NoteAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.com_ddp_planner_activity_main_recyclerView);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        ArrayList<Note> mData = getNotes();
        mAdapter = new NoteAdapter(mData);
        recyclerView.setAdapter(mAdapter);
    }

    private ArrayList<Note> getNotes(){
        ArrayList<Note> notes = new ArrayList<Note>();
        notes.add(new Note("banana"));
        notes.add(new Note("potata"));
        notes.add(new Note("apple"));
        notes.add(new Note("kiwi"));
        notes.add(new Note("pear"));
        for(int i=1000 ; i>0 ; i--){
            notes.add(new Note(i + ""));
        }
        return notes;
    }
}
