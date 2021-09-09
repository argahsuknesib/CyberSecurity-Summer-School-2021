package com.xiaomi.smarthome.uwb.lib.mitv.data;

import java.util.HashMap;
import java.util.Map;

public class MitvNotif {
    String mNotif;
    Map<String, String> mParam = new HashMap();

    public String getmNotif() {
        return this.mNotif;
    }

    public void setmNotif(String str) {
        this.mNotif = str;
    }

    public Map<String, String> getmParam() {
        return this.mParam;
    }

    public void setmParam(String str, String str2) {
        this.mParam.put(str, str2);
    }
}
