package com.example.proiectandroid;

import androidx.appcompat.app.AppCompatActivity;

import java.io.Serializable;
import java.util.Date;

enum Gen {MASCULIN, FEMININ}

public class Profile implements Serializable {
    private String email;
    private String fullName;
    private Date bDate;
    private Gen gen;
    private int Age;
    private float Weight;
    private float Height;
    private String uuid;

    public Profile() {}

    public Profile(String email, String fullName, Date bDate, Gen gen, int age, float weight, float height, String uuid) {
        this.email = email;
        this.fullName = fullName;
        this.bDate = bDate;
        this.gen = gen;
        Age = age;
        Weight = weight;
        Height = height;
        this.uuid = uuid;
    }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

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

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
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
                ", Uuid=" + uuid +
                ", Weight=" + Weight +
                ", Height=" + Height +
                '}';
    }
}
