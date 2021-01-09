package com.example.proiectandroid;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;
@Dao
public interface ISport {
    @Query("SELECT * FROM SPORTS")
    public List<Sport> getAllSports();

    @Query("SELECT * FROM SPORTS WHERE ID = :value")
    public List<Sport> getSleepsByValue(int value);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    public void insertSports(Sport... sports);

    @Delete
    public void deleteSports(Sport... sports);

    @Update
    public void updateSports(Sport... sports);
}
