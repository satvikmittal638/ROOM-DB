package com.example.roomdb.ROOM_Components;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.roomdb.ROOM_Components.EntityNotes;

import java.util.List;

@Dao
public interface DAO {


   // Insert methods treat 0 as not-set while inserting the item.
    @Insert(onConflict = OnConflictStrategy.IGNORE)//allows duplicacy
    void InsertNotes(EntityNotes notes);

    //Observes any change in the data as it is wrapped with LiveData
    @Query("SELECT * FROM NOTES_TABLE")
    LiveData<List<EntityNotes>> getNotes();

    //ROOM can only take primitives as arguments
//    @Query("UPDATE NOTES_TABLE SET NOTES=:notes  WHERE ID=:id")

    @Update(entity = EntityNotes.class,onConflict = OnConflictStrategy.IGNORE)
    void updateNotes(EntityNotes notes);

    @Query("DELETE FROM NOTES_TABLE")//deletes everything
    void deleteAllNotes();
}
