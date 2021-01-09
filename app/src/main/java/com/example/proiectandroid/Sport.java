package com.example.proiectandroid;

import java.io.Serializable;

public class Sport implements Serializable {
    private float km;
    private int steps;
    private int min;

    public Sport() {
    }

    public Sport(float km, int steps, int min) {
        this.km = km;
        this.steps = steps;
        this.min = min;
    }

    @Override
    public String toString() {
        return "SportActivity{" +
                "km=" + km +
                ", steps=" + steps +
                ", min=" + min +
                '}';
    }

    public float getKm() {
        return km;
    }

    public void setKm(float km) {
        this.km = km;
    }

    public int getSteps() {
        return steps;
    }

    public void setSteps(int steps) {
        this.steps = steps;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }
}
