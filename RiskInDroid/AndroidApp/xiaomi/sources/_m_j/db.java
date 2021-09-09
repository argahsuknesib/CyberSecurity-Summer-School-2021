package _m_j;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;

public interface db {
    ColorStateList getSupportImageTintList();

    PorterDuff.Mode getSupportImageTintMode();

    void setSupportImageTintList(ColorStateList colorStateList);

    void setSupportImageTintMode(PorterDuff.Mode mode);
}
