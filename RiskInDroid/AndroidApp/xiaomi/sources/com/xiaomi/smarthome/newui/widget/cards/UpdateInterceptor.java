package com.xiaomi.smarthome.newui.widget.cards;

import android.view.View;

public interface UpdateInterceptor {
    void onUpdateViewAlpha(View view, int i, float f);

    void onUpdateViewBackgroud(View view, int i, int i2);

    void onUpdateViewScale(View view, int i, float f);

    void onUpdateViewTransitionY(View view, int i, float f);

    void onUpdateViewZ(View view, int i, float f);
}
