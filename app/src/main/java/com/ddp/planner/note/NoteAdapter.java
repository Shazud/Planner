package com.ddp.planner.note;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ddp.planner.R;

import java.util.ArrayList;
import java.util.List;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.NoteViewHolder> implements Filterable {
    private List<Note> mData;
    private List<Note> mDataAll;
    

    public static class NoteViewHolder extends RecyclerView.ViewHolder {
        TextView titleView;
        TextView contentView;
        RelativeLayout parentLayout;

        public NoteViewHolder(View v) {
            super(v);
            this.titleView = v.findViewById(R.id.com_ddp_planner_layout_note_title);
            this.contentView = v.findViewById(R.id.com_dpp_planner_layout_note_content);
            this.parentLayout = v.findViewById(R.id.parent_layout);
        }
    }

    public NoteAdapter(ArrayList<Note> mData){
        this.mData = mData;
        this.mDataAll = new ArrayList<Note>();
        this.mDataAll.addAll(mData);
    }

    @NonNull
    @Override
    public NoteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_note, parent ,false);
        NoteViewHolder vh = new NoteViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull NoteViewHolder holder, int position) {
        holder.titleView.setText(mData.get(position).getTitle());
        holder.contentView.setText(mData.get(position).getContent());
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    @Override
    public Filter getFilter() {
        return filter2;
    }

    private Filter filter2 = new Filter(){

        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<Note> filteredList = new ArrayList<>();
            if (constraint == null || constraint.length() == 0){
                filteredList.addAll(mDataAll);
            }
            else{
                String filterPattern = constraint.toString().toLowerCase().trim();
                for(Note entry:mDataAll){
                    if(entry.getTitle().toLowerCase().contains(filterPattern)){
                        filteredList.add(entry);
                    }
                    else {
                        if (entry.getContent().toLowerCase().contains(filterPattern)) {
                            filteredList.add(entry);
                        }
                    }
                }
            }
            FilterResults results = new FilterResults();
            results.values = filteredList;
            return  results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            mData.clear();
            if(results.values!=null)
            mData.addAll((List) results.values);
            notifyDataSetChanged();
        }
    };



}
