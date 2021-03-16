package com.example.roomdb;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface DAO {

    @Insert(onConflict = OnConflictStrategy.IGNORE)//allows duplicacy
    void InsertNotes(EntityNotes notes);

    //Observes any change in the data as it is wrapped with LiveData
    @Query("SELECT * FROM Notes_Table")
    LiveData<List<EntityNotes>> getNotes();

    @Query("DELETE FROM Notes_Table")//deletes everything
    void deleteAllNotes();
}
