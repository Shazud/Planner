package com.ddp.planner.note;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ddp.planner.R;

import java.util.ArrayList;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.NoteViewHolder> {
    private ArrayList<Note> mData;
    public static class NoteViewHolder extends RecyclerView.ViewHolder {
        public TextView textView;
        public NoteViewHolder(TextView textView) {
            super(textView);
            this.textView = textView;
        }
    }

    public NoteAdapter(ArrayList<Note> mData){
        this.mData = mData;
    }

    @NonNull
    @Override
    public NoteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        TextView v = (TextView) LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_main, parent ,false);

        NoteViewHolder vh = new NoteViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull NoteViewHolder holder, int position) {
        holder.textView.setText(mData.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }


}
