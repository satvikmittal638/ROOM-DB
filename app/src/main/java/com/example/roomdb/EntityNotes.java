package com.example.roomdb;

import androidx.annotation.Nullable;
import androidx.room.ColumnInfo;
import androidx.room.PrimaryKey;
import androidx.room.Entity;


@Entity(tableName = "Notes_Table")
public class EntityNotes {

    @ColumnInfo(name = "Notes")
    @Nullable
    private String notes;

    @PrimaryKey(autoGenerate = true)
    private int id;

    public EntityNotes(String notes) {
        this.notes = notes;
    }

    public String getNotes() {
        return notes;
    }
    public void setNotes(String notes) {
        this.notes = notes;
    }

    //Needed by ROOM
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
}
