package com.example.proiectandroid;

import android.content.Context;

import androidx.room.Room;
import androidx.room.RoomDatabase;

@androidx.room.Database(entities = {Sleep.class, Sport.class}, version = 1)
public abstract class Database extends RoomDatabase {

    private static volatile Database INSTANCE;

    public abstract ISleep sleepDao();
    public abstract ISport sportDao();

    public static Database getInstance(Context context) {
        if(INSTANCE == null) {
            synchronized (Database.class) {
                if(INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(
                            context.getApplicationContext(),
                            Database.class,
                            "livescores.db"
                    ).allowMainThreadQueries()
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
