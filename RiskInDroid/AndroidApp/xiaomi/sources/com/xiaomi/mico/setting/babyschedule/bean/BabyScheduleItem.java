package com.xiaomi.mico.setting.babyschedule.bean;

import android.content.Context;

public interface BabyScheduleItem {
    int getItemType();

    void handleItemClick(Context context, int i);
}
