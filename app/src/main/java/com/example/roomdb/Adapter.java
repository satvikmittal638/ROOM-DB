package com.example.roomdb;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.roomdb.ROOM_Components.EntityNotes;

import java.util.ArrayList;
import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    private final Context context;
    private List<EntityNotes> notesList;
    AppCompatActivity activity;



    public Adapter(Context context) {
        this.context = context;
        notesList=new ArrayList<>();
//        this.notesList=notesList;//for pre-defined List
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view= LayoutInflater.from(context).inflate(R.layout.single_notes,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        EntityNotes notesObj=notesList.get(position);

        holder.tvNotes.setText(notesObj.getNotes());

        holder.cardV.setOnClickListener(v -> {
            Intent updateIntent=new Intent(context,AddNotes.class);
            updateIntent.putExtra("existing_notes",notesObj.getNotes());
            activity= (AppCompatActivity) context;
            activity.startActivityForResult(updateIntent,MainActivity.UPDATE_NOTES_REQUEST_CODE);
        });
    }

    @Override
    public int getItemCount() {
            return notesList.size();
    }

    //for updating the notesList by the LiveData's observer
    public void setNotesList(List<EntityNotes> notesList){
        this.notesList=notesList;
        notifyDataSetChanged();
    }







    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView tvNotes;
        public CardView cardV;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNotes=itemView.findViewById(R.id.tv);
            cardV=itemView.findViewById(R.id.cardV);


        }
    }
}
