package com.example.proiectandroid;

import java.io.Serializable;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;


@Entity(tableName = "SPORTS")
public class Sport implements Serializable {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "ID")
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @ColumnInfo(name = "KM")
    private float km;

    @ColumnInfo(name = "Min")
    private int min;


    public Sport(float km, int min) {
        this.km = km;
        this.min = min;
    }

    @Override
    public String toString() {
        return "SportActivity{" +
                "km=" + km +
                ", min=" + min +
                '}';
    }

    public float getKm() {
        return km;
    }

    public void setKm(float km) {
        this.km = km;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }
}
