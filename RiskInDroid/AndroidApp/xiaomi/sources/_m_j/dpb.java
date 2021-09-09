package _m_j;

import android.view.View;

public interface dpb {
    void attachViews();

    View getHolderView();

    int getType();

    dpf getVirtualView();

    void setVirtualView(dpf dpf);
}
