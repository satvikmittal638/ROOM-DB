package com.example.roomdb.ROOM_Components;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//Only one instance of ROOM is required during whole App lifecycle(singleTon)

//entities is an array and can have multiple tableNames
@Database(entities = {EntityNotes.class},version = 1,exportSchema = false)
public abstract class ROOM_DB extends RoomDatabase {

    public abstract DAO notesDao();
    private static volatile ROOM_DB INSTANCE;
    public static final int NO_OF_THREADS=4;
    /*
    We've created an ExecutorService
    with a fixed thread pool
    to run database operations
    asynchronously on a background thread
    in order to observe changes
    and make the app UI lag free
     */
    static final ExecutorService dbWriteExecutor=
            Executors.newFixedThreadPool(NO_OF_THREADS);

    static ROOM_DB getDbInstance(final Context context)
    {
        if(INSTANCE==null) {
            synchronized (ROOM_DB.class) {//What is synchronized ?
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            ROOM_DB.class,
                            "Notes_DB")
                            .build();
                }
            }
        }
    return INSTANCE;
    }
}
