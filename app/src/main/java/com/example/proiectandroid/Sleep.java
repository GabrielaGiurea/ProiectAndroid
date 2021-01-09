package com.example.proiectandroid;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import java.io.Serializable;
import java.util.Date;

@Entity(tableName = "SLEEP")
public class Sleep implements Serializable {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "ID")
    private  int id;
    //Foreign key din tabela de legatura
    //@ForeignKey(entity = User.class, parentColumns = "ID", childColumns = "USERID")
    @ColumnInfo(name = "DateStart")
    private String start;
    @ColumnInfo(name = "DateStop")
    private String stop;


    public Sleep(String start, String stop) {
        this.start = start;
        this.stop = stop;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getStop() {
        return stop;
    }

    public void setStop(String stop) {
        this.stop = stop;
    }

    @Override
    public String toString() {
        return "Sleep{" +
                "start=" + start +
                ", stop=" + stop +
                '}';
    }
}
