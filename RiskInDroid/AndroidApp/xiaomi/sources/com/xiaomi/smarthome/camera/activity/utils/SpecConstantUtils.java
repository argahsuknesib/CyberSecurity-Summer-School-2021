package com.xiaomi.smarthome.camera.activity.utils;

import android.util.Pair;
import java.util.ArrayList;
import java.util.List;

public class SpecConstantUtils {
    public static List<Pair<String, String>> NativeAISpecKV(String str) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new Pair("chuangmi-ai", "face-switch"));
        arrayList.add(new Pair("chuangmi-ai", "people-switch"));
        arrayList.add(new Pair("chuangmi-ai", "pet-switch"));
        arrayList.add(new Pair("chuangmi-ai", "algo-layer-switch"));
        arrayList.add(new Pair("ai-scene", "figureid"));
        return arrayList;
    }

    public static List<Pair<String, String>> MotionDetectionSpecKV(String str) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new Pair("motion-detection", "motion-detection"));
        arrayList.add(new Pair("motion-detection", "alarm-interval"));
        arrayList.add(new Pair("motion-detection", "detection-sensitivity"));
        arrayList.add(new Pair("motion-detection", "motion-detection-start-time"));
        arrayList.add(new Pair("motion-detection", "motion-detection-end-time"));
        return arrayList;
    }

    public static List<Pair<String, String>> CameraControlSpecKV(String str) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new Pair("camera-control", "on"));
        arrayList.add(new Pair("camera-control", "image-rollover"));
        arrayList.add(new Pair("camera-control", "night-shot"));
        arrayList.add(new Pair("camera-control", "wdr-mode"));
        arrayList.add(new Pair("camera-control", "glimmer-full-color"));
        arrayList.add(new Pair("camera-control", "recording-mode"));
        arrayList.add(new Pair("camera-control", "motion-tracking"));
        arrayList.add(new Pair("camera-control", "time-watermark"));
        arrayList.add(new Pair("indicator-light", "on"));
        return arrayList;
    }

    public static List<Pair<String, String>> IndicatorLightSpecKV(String str) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new Pair("indicator-light", "on"));
        return arrayList;
    }

    public static List<Pair<String, String>> DeviceInfoSpecKV(String str) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new Pair("device-information", "manufacturer"));
        arrayList.add(new Pair("device-information", "model"));
        arrayList.add(new Pair("device-information", "serial-number"));
        arrayList.add(new Pair("device-information", "firmware-revision"));
        return arrayList;
    }

    public static List<Pair<String, String>> MCMSpecKV(String str) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new Pair("memory-card-management", "status"));
        arrayList.add(new Pair("memory-card-management", "storage-total-space"));
        arrayList.add(new Pair("memory-card-management", "storage-free-space"));
        arrayList.add(new Pair("memory-card-management", "storage-used-space"));
        return arrayList;
    }

    public static List<Pair<String, String>> ChuangmiClocksSpecKV(String str) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new Pair("chuangmi-ai", "chuangmi-clocks"));
        return arrayList;
    }

    public static List<Pair<String, String>> ChuangmiBabySleepKV(String str) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new Pair("chuangmi-ai", "baby-wake-switch"));
        arrayList.add(new Pair("chuangmi-ai", "baby-sleep-area"));
        return arrayList;
    }
}
