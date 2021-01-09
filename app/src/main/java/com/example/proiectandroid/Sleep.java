package com.example.proiectandroid;

import java.io.Serializable;

public class Sleep implements Serializable {
    private int awake;
    private int REM;
    private int light;
    private int deep;

    public Sleep() {
    }

    public Sleep(int awake, int REM, int light, int deep) {
        this.awake = awake;
        this.REM = REM;
        this.light = light;
        this.deep = deep;
    }

    @Override
    public String toString() {
        return "com.example.proiectandroid.Sleep{" +
                "awake=" + awake +
                ", REM=" + REM +
                ", light=" + light +
                ", deep=" + deep +
                '}';
    }

    public int getAwake() {
        return awake;
    }

    public void setAwake(int awake) {
        this.awake = awake;
    }

    public int getREM() {
        return REM;
    }

    public void setREM(int REM) {
        this.REM = REM;
    }

    public int getLight() {
        return light;
    }

    public void setLight(int light) {
        this.light = light;
    }

    public int getDeep() {
        return deep;
    }

    public void setDeep(int deep) {
        this.deep = deep;
    }
}
