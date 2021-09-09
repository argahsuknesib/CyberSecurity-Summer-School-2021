package com.facebook.share.widget;

import android.content.Context;
import android.util.AttributeSet;
import com.facebook.internal.CallbackManagerImpl;
import com.facebook.internal.FacebookDialogBase;
import com.facebook.share.Sharer;
import com.facebook.share.model.ShareContent;
import com.xiaomi.smarthome.R;

public final class SendButton extends ShareButtonBase {
    public final int getDefaultStyleResource() {
        return R.style.com_facebook_button_send;
    }

    public SendButton(Context context) {
        super(context, null, 0, "fb_send_button_create", "fb_send_button_did_tap");
    }

    public SendButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0, "fb_send_button_create", "fb_send_button_did_tap");
    }

    public SendButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i, "fb_send_button_create", "fb_send_button_did_tap");
    }

    public final int getDefaultRequestCode() {
        return CallbackManagerImpl.RequestCodeOffset.Message.toRequestCode();
    }

    /* access modifiers changed from: protected */
    public final FacebookDialogBase<ShareContent, Sharer.Result> getDialog() {
        if (getFragment() != null) {
            return new MessageDialog(getFragment(), getRequestCode());
        }
        if (getNativeFragment() != null) {
            return new MessageDialog(getNativeFragment(), getRequestCode());
        }
        return new MessageDialog(getActivity(), getRequestCode());
    }
}
