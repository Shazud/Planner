package com.ddp.planner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.core.view.MenuItemCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.Toolbar;

import com.ddp.planner.note.Note;
import com.ddp.planner.note.NoteAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;


import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<Note> mData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.com_ddp_planner_activity_main_recyclerView);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        mData = getNotes();
        mAdapter = new NoteAdapter(mData);
        recyclerView.setAdapter(mAdapter);


        FloatingActionButton addButton = findViewById(R.id.com_ddp_planner_activity_main_addButton);
        addButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_item, menu);
        MenuItem menuItem = menu.findItem(R.id.menu_actionSearch);
        androidx.appcompat.widget.SearchView searchView = (androidx.appcompat.widget.SearchView) menuItem.getActionView();
        searchView.setImeOptions(EditorInfo.IME_ACTION_DONE);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                ((NoteAdapter)mAdapter).getFilter().filter(newText);
                return false;
            }
        });
        return true;
    }

    private ArrayList<Note> getNotes(){
        ArrayList<Note> notes = new ArrayList<Note>();
        notes.add(new Note("banana", "banana content banana milkshak"));
        notes.add(new Note("potata", "french fries"));
        notes.add(new Note("apple", "apple juice"));
        notes.add(new Note("kiwi", "salad"));
        notes.add(new Note("pear","nectar"));
        for(int i=0 ; i>0 ; i--){
            notes.add(new Note(i + "", "lmao" + i));
        }
        return notes;
    }
}
