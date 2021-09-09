package com.facebook.share.widget;

import _m_j.OO0000o;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.facebook.internal.CallbackManagerImpl;
import com.facebook.internal.FacebookDialogBase;
import com.facebook.share.Sharer;
import com.facebook.share.model.ShareContent;
import com.xiaomi.smarthome.R;

public final class ShareButton extends ShareButtonBase {
    public final int getDefaultStyleResource() {
        return R.style.com_facebook_button_share;
    }

    public ShareButton(Context context) {
        super(context, null, 0, "fb_share_button_create", "fb_share_button_did_tap");
    }

    public ShareButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0, "fb_share_button_create", "fb_share_button_did_tap");
    }

    public ShareButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i, "fb_share_button_create", "fb_share_button_did_tap");
    }

    public final int getDefaultRequestCode() {
        return CallbackManagerImpl.RequestCodeOffset.Share.toRequestCode();
    }

    /* access modifiers changed from: protected */
    public final FacebookDialogBase<ShareContent, Sharer.Result> getDialog() {
        if (getFragment() != null) {
            return new ShareDialog(getFragment(), getRequestCode());
        }
        if (getNativeFragment() != null) {
            return new ShareDialog(getNativeFragment(), getRequestCode());
        }
        return new ShareDialog(getActivity(), getRequestCode());
    }

    public final void configureButton(Context context, AttributeSet attributeSet, int i, int i2) {
        super.configureButton(context, attributeSet, i, i2);
        setCompoundDrawablesWithIntrinsicBounds(OO0000o.O00000Oo(getContext(), R.drawable.com_facebook_button_icon), (Drawable) null, (Drawable) null, (Drawable) null);
    }
}
