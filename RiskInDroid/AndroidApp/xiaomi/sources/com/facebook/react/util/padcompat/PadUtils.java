package com.facebook.react.util.padcompat;

import android.app.Activity;
import android.graphics.Point;
import android.view.View;
import com.facebook.react.views.view.ReactViewGroup;

public interface PadUtils {
    int getKeyBoardEventHeightDiff(View view, int i);

    Point getModalHostSize();

    float getScaleFactor();

    View handleModalContentViewWhenPad(ReactViewGroup reactViewGroup, Activity activity);

    boolean interceptDimensionSize();

    boolean isDialogThemePlugin();
}
