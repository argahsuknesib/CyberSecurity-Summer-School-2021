package com.xiaomi.smarthome.uwb.lib.securityCode;

import android.app.Activity;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;

public class SoftKeyBoardListener {
    public OnSoftKeyBoardChangeListener onSoftKeyBoardChangeListener;
    public View rootView;
    int rootViewVisibleHeight;

    public interface OnSoftKeyBoardChangeListener {
        void keyBoardHide(int i);

        void keyBoardShow(int i);
    }

    public SoftKeyBoardListener(Activity activity) {
        this.rootView = activity.getWindow().getDecorView();
        this.rootView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            /* class com.xiaomi.smarthome.uwb.lib.securityCode.SoftKeyBoardListener.AnonymousClass1 */

            public void onGlobalLayout() {
                Rect rect = new Rect();
                SoftKeyBoardListener.this.rootView.getWindowVisibleDisplayFrame(rect);
                int height = rect.height();
                System.out.println(String.valueOf(height));
                if (SoftKeyBoardListener.this.rootViewVisibleHeight == 0) {
                    SoftKeyBoardListener.this.rootViewVisibleHeight = height;
                } else if (SoftKeyBoardListener.this.rootViewVisibleHeight != height) {
                    if (SoftKeyBoardListener.this.rootViewVisibleHeight - height > 200) {
                        if (SoftKeyBoardListener.this.onSoftKeyBoardChangeListener != null) {
                            SoftKeyBoardListener.this.onSoftKeyBoardChangeListener.keyBoardShow(SoftKeyBoardListener.this.rootViewVisibleHeight - height);
                        }
                        SoftKeyBoardListener.this.rootViewVisibleHeight = height;
                    } else if (height - SoftKeyBoardListener.this.rootViewVisibleHeight > 200) {
                        if (SoftKeyBoardListener.this.onSoftKeyBoardChangeListener != null) {
                            SoftKeyBoardListener.this.onSoftKeyBoardChangeListener.keyBoardHide(height - SoftKeyBoardListener.this.rootViewVisibleHeight);
                        }
                        SoftKeyBoardListener.this.rootViewVisibleHeight = height;
                    }
                }
            }
        });
    }

    public void setOnSoftKeyBoardChangeListener(OnSoftKeyBoardChangeListener onSoftKeyBoardChangeListener2) {
        this.onSoftKeyBoardChangeListener = onSoftKeyBoardChangeListener2;
    }
}
