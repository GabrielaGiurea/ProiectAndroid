package com.example.proiectandroid;

import androidx.appcompat.app.AppCompatActivity;

import java.io.Serializable;
import java.util.Date;

enum Gen {MASCULIN, FEMININ}

public class Profile implements Serializable {
    private String fullName;
    private Date bDate;
    private Gen gen;
    private int Age;
    private float Weight;
    private float Height;

    public Profile(String fullName, Date bDate, Gen gen, int age, float weight, float height) {
        this.fullName = fullName;
        this.bDate = bDate;
        this.gen = gen;
        Age = age;
        Weight = weight;
        Height = height;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Date getbDate() {
        return bDate;
    }

    public void setbDate(Date bDate) {
        this.bDate = bDate;
    }

    public Gen getGen() {
        return gen;
    }

    public void setGen(Gen gen) {
        this.gen = gen;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }

    public float getWeight() {
        return Weight;
    }

    public void setWeight(float weight) {
        Weight = weight;
    }

    public float getHeight() {
        return Height;
    }

    public void setHeight(float height) {
        Height = height;
    }

    @Override
    public String toString() {
        return "Profile{" +
                "fullName='" + fullName + '\'' +
                ", bDate=" + bDate +
                ", gen='" + gen + '\'' +
                ", Age=" + Age +
                ", Weight=" + Weight +
                ", Height=" + Height +
                '}';
    }
}
