package com.xiaomi.smarthome.camera.activity.setting;

import android.util.SparseBooleanArray;

public class ModeController {
    private static ModeController _INSTANCE_;
    private ModeChangedListener listener;
    public SparseBooleanArray mCheckedItems = new SparseBooleanArray();
    public int mCurrentMode = 1;

    private ModeController() {
    }

    public static ModeController getInstance() {
        if (_INSTANCE_ == null) {
            _INSTANCE_ = new ModeController();
        }
        return _INSTANCE_;
    }

    public void setModeChangedListener(ModeChangedListener modeChangedListener) {
        this.listener = modeChangedListener;
    }

    public void changeMode(int i) {
        this.mCurrentMode = i;
        ModeChangedListener modeChangedListener = this.listener;
        if (modeChangedListener != null) {
            if (i == 0) {
                modeChangedListener.onEditMode();
            } else if (i == 1) {
                this.mCheckedItems.clear();
                this.listener.onNormalMode();
            }
        }
    }

    public void clear() {
        this.mCheckedItems.clear();
        this.listener = null;
        if (_INSTANCE_ != null) {
            _INSTANCE_ = null;
        }
    }
}
