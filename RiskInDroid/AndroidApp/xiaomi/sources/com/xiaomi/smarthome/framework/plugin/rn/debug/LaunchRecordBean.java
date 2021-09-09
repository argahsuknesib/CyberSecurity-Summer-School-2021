package com.xiaomi.smarthome.framework.plugin.rn.debug;

import com.google.gson.JsonArray;
import java.util.HashMap;
import java.util.Map;

public class LaunchRecordBean {
    long _00_cold_launch_times;
    String _00_device_model;
    float _00_hotCold_ratio;
    long _00_hot_launch_times;
    float _00_init_time;
    float _00_plugin_open_time;
    Map<String, JsonArray> details = null;

    public float get_00_init_time() {
        return this._00_init_time;
    }

    public void set_00_init_time(float f) {
        this._00_init_time = f;
    }

    public long get_00_hot_launch_times() {
        return this._00_hot_launch_times;
    }

    public void set_00_hot_launch_times(long j) {
        this._00_hot_launch_times = j;
    }

    public void set_00_cold_launch_times(long j) {
        this._00_cold_launch_times = j;
    }

    public long get_00_cold_launch_times() {
        return this._00_cold_launch_times;
    }

    public void set_00_hotCold_ratio(float f) {
        this._00_hotCold_ratio = f;
    }

    public float get_00_hotCold_ratio() {
        return this._00_hotCold_ratio;
    }

    public String get_00_device_model() {
        return this._00_device_model;
    }

    public void set_00_device_model(String str) {
        this._00_device_model = str;
    }

    public Map<String, JsonArray> getDetails() {
        return this.details;
    }

    public void setDetails(Map<String, JsonArray> map) {
        this.details = map;
    }

    public void addDetails(String str, JsonArray jsonArray) {
        if (this.details == null) {
            this.details = new HashMap();
        }
        this.details.put(str, jsonArray);
    }

    public float get_00_plugin_open_time() {
        return this._00_plugin_open_time;
    }

    public void set_00_plugin_open_time(float f) {
        this._00_plugin_open_time = f;
    }
}
