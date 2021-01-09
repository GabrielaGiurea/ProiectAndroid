package com.example.proiectandroid;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface ISleep {
    @Query("SELECT * FROM SLEEP")
    public List<Sleep> getAllSleeps();

    @Query("SELECT * FROM SLEEP WHERE ID = :value")
    public List<Sleep> getSleepsByValue(int value);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    public void insertSleeps(Sleep... sleeps);

    @Delete
    public void deleteSleeps(Sleep... sleeps);

    @Update
    public void updateSleeps(Sleep... sleeps);
}
