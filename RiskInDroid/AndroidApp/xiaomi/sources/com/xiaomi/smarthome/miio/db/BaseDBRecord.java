package com.xiaomi.smarthome.miio.db;

import org.json.JSONObject;

public abstract class BaseDBRecord {
    public abstract JSONObject getSyncDownJson();
}
