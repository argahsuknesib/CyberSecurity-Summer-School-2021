package com.xiaomi.smarthome.miio.camera.face.model;

import com.google.gson.JsonElement;

public class CommonResult {
    public int code;
    public JsonElement data;
    public String description;
    public String result;

    public String toString() {
        return "CommonResult{result='" + this.result + '\'' + ", code=" + this.code + ", data=" + this.data + ", description='" + this.description + '\'' + '}';
    }
}
