package com.xiaomi.smarthome.miio.camera.face.model;

public class FaceEventItem {
    public FaceEvent item = null;
    public String time = "";

    public FaceEventItem(String str, FaceEvent faceEvent) {
        this.time = str;
        this.item = faceEvent;
    }

    public String toString() {
        return "FaceEventItem{time='" + this.time + '\'' + ", item=" + this.item + '}';
    }
}
