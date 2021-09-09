package com.xiaomi.smarthome.camera.v4.activity.alarm;

import _m_j.clb;

public class AlarmDayBean {
    clb item = null;
    String title = "";

    AlarmDayBean(String str, clb clb) {
        this.item = clb;
        this.title = str;
    }
}
