package com.example.roomdb;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.ArrayList;
import java.util.List;

//A Repository manages queries and allows you to use multiple backends
public class Repository {
    private DAO notesDao;
    private LiveData<List<EntityNotes>> mAllNotes;

    Repository(Application application) {

        ROOM_DB db=ROOM_DB.getDbInstance(application);
        notesDao=db.notesDao();//gets the DAO from the DB and not directly from DAO interface
        mAllNotes=notesDao.getNotes();//gets the notesList using the DAO initialized above
    }

    // Room executes all queries on a separate thread
    LiveData<List<EntityNotes>> getAllNotes(){
        return mAllNotes;
    }

    /*
    As insertion and deletion operations are heavy therefore
    Room ensures that you're not doing any long running operations
    on the main thread, blocking the UI.
     */
    void insert(EntityNotes notes){
        ROOM_DB.dbWriteExecutor.execute(()-> notesDao.InsertNotes(notes));//runs on a separate thread
    }

}
