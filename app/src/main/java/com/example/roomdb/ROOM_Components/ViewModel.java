package com.example.roomdb.ROOM_Components;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.roomdb.ROOM_Components.EntityNotes;
import com.example.roomdb.ROOM_Components.Repository;

import java.util.List;

public class ViewModel extends AndroidViewModel {

    private final Repository notesRepo;
    private final LiveData<List<EntityNotes>> allNotes;


    public ViewModel(@NonNull Application application) {
        super(application);
        notesRepo=new Repository(application);
        allNotes=notesRepo.getAllNotes();/*gets the notes from the repo which in turn gets it by
                                         using the DAO which is initialized from the db*/
    }

//a wrapper insert() method that calls the Repository's insert() method
    public void insert(EntityNotes notes){
        notesRepo.insert(notes);
    }

    public LiveData<List<EntityNotes>> getNotes(){
        return allNotes;
    }

    //wrapper
    public void updateNotes(EntityNotes notes){
        notesRepo.updateNotes(notes);
        Log.d("kamra", "updateNotes: updating");
    }

    //wrapper
    public void deleteAllNotes(){
        notesRepo.deleteAllNotes();
    }
}
