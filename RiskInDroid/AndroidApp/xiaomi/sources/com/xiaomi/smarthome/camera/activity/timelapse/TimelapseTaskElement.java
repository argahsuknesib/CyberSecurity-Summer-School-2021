package com.xiaomi.smarthome.camera.activity.timelapse;

public class TimelapseTaskElement {
    private int endHour;
    private int endMinute;
    private int startHour;
    private int startMinute;

    public TimelapseTaskElement(int i, int i2, int i3, int i4) {
        this.startHour = i;
        this.startMinute = i2;
        this.endHour = i3;
        this.endMinute = i4;
    }

    public TimelapseTaskElement() {
        this.startHour = 0;
        this.startMinute = 0;
        this.endHour = 0;
        this.endMinute = 0;
    }

    public byte[] toByteArray() {
        return new byte[]{(byte) this.startHour, (byte) this.startMinute, (byte) this.endHour, (byte) this.endMinute};
    }

    public int getStartHour() {
        return this.startHour;
    }

    public void setStartHour(int i) {
        if (i < 0 || i > 23) {
            this.startHour = 0;
        } else {
            this.startHour = i;
        }
    }

    public int getStartMinute() {
        return this.startMinute;
    }

    public void setStartMinute(int i) {
        if (i < 0 || i > 59) {
            this.startMinute = 0;
        } else {
            this.startMinute = i;
        }
    }

    public int getEndHour() {
        return this.endHour;
    }

    public void setEndHour(int i) {
        if (i < 0 || i > 23) {
            this.endHour = 0;
        } else {
            this.endHour = i;
        }
    }

    public int getEndMinute() {
        return this.endMinute;
    }

    public void setEndMinute(int i) {
        if (i < 0 || i > 59) {
            this.endMinute = 0;
        } else {
            this.endMinute = i;
        }
    }
}
