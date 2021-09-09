package com.xiaomi.smarthome.frame.plugin;

import android.text.TextUtils;

public enum RunningProcess {
    MAIN("main"),
    PLUGIN0("plugin0"),
    PLUGIN1("plugin1"),
    PLUGIN2("plugin2"),
    PLUGIN3("plugin3"),
    PLUGIN4("plugin4"),
    FRAME1("frame1"),
    FRAME2("frame2"),
    CAMERA("camera");
    
    private long mTimeStamp = System.currentTimeMillis();
    private String mValue;

    private RunningProcess(String str) {
        this.mValue = str;
    }

    public static RunningProcess getByProcessName(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.endsWith(":plugin0")) {
            return PLUGIN0;
        }
        if (str.endsWith(":plugin1")) {
            return PLUGIN1;
        }
        if (str.endsWith(":plugin2")) {
            return PLUGIN2;
        }
        if (str.endsWith(":plugin3")) {
            return PLUGIN3;
        }
        if (str.equalsIgnoreCase("com.xiaomi.smarthome")) {
            return MAIN;
        }
        if (str.equalsIgnoreCase(":frame1")) {
            return FRAME1;
        }
        if (str.equalsIgnoreCase(":frame2")) {
            return FRAME2;
        }
        if (str.equalsIgnoreCase(":camera")) {
            return CAMERA;
        }
        return null;
    }

    static RunningProcess[] getFrameProcesses() {
        return new RunningProcess[]{FRAME1, FRAME2};
    }

    static RunningProcess getCameraProcesses() {
        return CAMERA;
    }

    public final void setTimeStamp(Long l) {
        this.mTimeStamp = l.longValue();
    }

    public final long getTimeStamp() {
        return this.mTimeStamp;
    }

    public static RunningProcess getByProcessValue(String str) {
        if (TextUtils.isEmpty(str)) {
            return MAIN;
        }
        if (str.equals(PLUGIN0.getValue())) {
            return PLUGIN0;
        }
        if (str.equals(PLUGIN1.getValue())) {
            return PLUGIN1;
        }
        if (str.equals(PLUGIN2.getValue())) {
            return PLUGIN2;
        }
        if (str.equals(PLUGIN3.getValue())) {
            return PLUGIN3;
        }
        if (str.equals(FRAME1.getValue())) {
            return FRAME1;
        }
        if (str.equals(FRAME2.getValue())) {
            return FRAME2;
        }
        if (str.equals(MAIN.getValue())) {
            return MAIN;
        }
        if (str.equals(CAMERA.getValue())) {
            return CAMERA;
        }
        return MAIN;
    }

    public final String getValue() {
        return this.mValue;
    }
}
