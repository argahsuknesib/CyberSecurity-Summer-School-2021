package com.xiaomi.mico.common.editorbar;

public interface Selector extends ActionCallback {
    int getSelectedCount();

    int getTotalCount();

    void selectAll();

    void selectNone();
}
