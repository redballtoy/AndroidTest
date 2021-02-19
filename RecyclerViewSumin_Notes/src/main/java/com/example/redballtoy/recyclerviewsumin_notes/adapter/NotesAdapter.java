package com.example.redballtoy.recyclerviewsumin_notes.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.redballtoy.recyclerviewsumin_notes.R;
import com.example.redballtoy.recyclerviewsumin_notes.model.Note;

import java.util.ArrayList;

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.NotesViewHolder> {

    //data array
    private final ArrayList<Note> notes;

    //add constructor
    public NotesAdapter(ArrayList<Note> notes) {
        this.notes = notes;
    }

    @NonNull
    @Override
    public NotesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //create ViewHolder with our item layout
        //get layout
        View itemlayout = LayoutInflater.from(parent.getContext()).inflate(R.layout.note_item, parent, false);
        return new NotesViewHolder(itemlayout);
    }

    //set to element NotesViewHolder by position number info from model
    @Override
    public void onBindViewHolder(@NonNull NotesViewHolder holder, int position) {
        //get data from model by index = position
        Note itemNote = notes.get(position);
        //get element from Holder
        holder.itemDayOfWeek.setText(itemNote.getDayWeekly());
        holder.itemTitle.setText(itemNote.getTitle());
        holder.itemDescription.setText(itemNote.getDescription());
        int color;
        switch (itemNote.getPriority()) {
            case 1:
                color = holder.itemView.getResources().getColor(android.R.color.holo_red_light);
                break;
            case 2:
                color = holder.itemView.getResources().getColor(android.R.color.holo_orange_light);
                break;
            case 3:
                color = holder.itemView.getResources().getColor(android.R.color.holo_green_light);
                break;
            default:
                color = R.color.white;
                break;
        }
        holder.itemDayOfWeek.setBackgroundColor(color);
    }

    //return count items
    @Override
    public int getItemCount() {
        return notes.size();
    }


    //this class handles all wisible items our notes
    class NotesViewHolder extends RecyclerView.ViewHolder {

        private final TextView itemTitle;
        private final TextView itemDescription;
        private final TextView itemDayOfWeek;

        public NotesViewHolder(@NonNull View itemView) {
            super(itemView);
            //initialize items in constructor
            itemTitle = itemView.findViewById(R.id.tv_title);
            itemDescription = itemView.findViewById(R.id.tv_description);
            itemDayOfWeek = itemView.findViewById(R.id.tv_day_week);


        }
    }

}
