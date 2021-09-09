package com.xiaomi.mico.api.model;

import android.content.Context;

public interface AudioSourceInterface {
    String getCover();

    CharSequence getDescription();

    String getID();

    String getTitle();

    void handleItemClick(Context context);

    boolean isLegal();
}
