package com.facebook.share.internal;

import _m_j.OO0000o;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.facebook.FacebookButtonBase;
import com.xiaomi.smarthome.R;

@Deprecated
public class LikeButton extends FacebookButtonBase {
    public int getDefaultRequestCode() {
        return 0;
    }

    public int getDefaultStyleResource() {
        return R.style.com_facebook_button_like;
    }

    @Deprecated
    public LikeButton(Context context, boolean z) {
        super(context, null, 0, 0, "fb_like_button_create", "fb_like_button_did_tap");
        setSelected(z);
    }

    @Deprecated
    public void setSelected(boolean z) {
        super.setSelected(z);
        updateForLikeStatus();
    }

    public void configureButton(Context context, AttributeSet attributeSet, int i, int i2) {
        super.configureButton(context, attributeSet, i, i2);
        updateForLikeStatus();
    }

    private void updateForLikeStatus() {
        if (isSelected()) {
            setCompoundDrawablesWithIntrinsicBounds((int) R.drawable.com_facebook_button_like_icon_selected, 0, 0, 0);
            setText(getResources().getString(R.string.com_facebook_like_button_liked));
            return;
        }
        setCompoundDrawablesWithIntrinsicBounds(OO0000o.O00000Oo(getContext(), R.drawable.com_facebook_button_icon), (Drawable) null, (Drawable) null, (Drawable) null);
        setText(getResources().getString(R.string.com_facebook_like_button_not_liked));
    }
}
