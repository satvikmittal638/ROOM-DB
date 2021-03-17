package com.example.roomdb;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    private final Context context;
    private List<EntityNotes> notesList;

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

//        holder.btnEdit.setOnClickListener(v ->
//                Toast.makeText(context, notesObj.getNotes(), Toast.LENGTH_SHORT).show());
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
        TextView tvNotes;
//        ImageView btnEdit;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNotes=itemView.findViewById(R.id.tv);
//            btnEdit=itemView.findViewById(R.id.btn_Edit);
        }
    }
}
