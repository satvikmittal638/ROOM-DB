package com.example.roomdb;

import android.app.Application;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.ArrayList;
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
}
