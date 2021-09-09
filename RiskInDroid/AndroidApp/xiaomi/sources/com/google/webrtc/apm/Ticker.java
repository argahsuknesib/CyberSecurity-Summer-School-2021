package com.google.webrtc.apm;

public class Ticker {
    private static Ticker instance;
    private long mStartTime;

    public void resetTime() {
        this.mStartTime = System.currentTimeMillis();
    }

    public long elapsedTime() {
        return System.currentTimeMillis() - this.mStartTime;
    }

    public static synchronized Ticker Instance() {
        Ticker ticker;
        synchronized (Ticker.class) {
            if (instance == null) {
                instance = new Ticker();
            }
            ticker = instance;
        }
        return ticker;
    }

    public Ticker() {
        resetTime();
    }
}
