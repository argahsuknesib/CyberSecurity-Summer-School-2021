package _m_j;

import android.view.View;

public abstract class axz extends ayb implements axf {
    private int mDragStateFlags;

    public axz(View view) {
        super(view);
    }

    public void setDragStateFlags(int i) {
        this.mDragStateFlags = i;
    }

    public int getDragStateFlags() {
        return this.mDragStateFlags;
    }
}
