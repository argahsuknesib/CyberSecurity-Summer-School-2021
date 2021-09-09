package com.miui.tsmclient.common.mvp;

import android.content.Context;

public interface IModel {
    void init(Context context, OnModelChangedListener onModelChangedListener);

    void release();
}
