package com.example.proiectandroid;

import java.io.Serializable;

public class Meals implements Serializable {
    private float breakfast;
    private float lunch;
    private float snack;
    private float dinner;

    public Meals() {
    }

    public Meals(float breakfast, float lunch, float snack, float dinner) {
        this.breakfast = breakfast;
        this.lunch = lunch;
        this.snack = snack;
        this.dinner = dinner;
    }

    @Override
    public String toString() {
        return "com.example.proiectandroid.Meals{" +
                "breakfast=" + breakfast +
                ", lunch=" + lunch +
                ", snack=" + snack +
                ", dinner=" + dinner +
                '}';
    }

    public float getBreakfast() {
        return breakfast;
    }

    public void setBreakfast(float breakfast) {
        this.breakfast = breakfast;
    }

    public float getLunch() {
        return lunch;
    }

    public void setLunch(float lunch) {
        this.lunch = lunch;
    }

    public float getSnack() {
        return snack;
    }

    public void setSnack(float snack) {
        this.snack = snack;
    }

    public float getDinner() {
        return dinner;
    }

    public void setDinner(float dinner) {
        this.dinner = dinner;
    }
}
