package com.facebook.share.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.facebook.CallbackManager;
import com.facebook.FacebookButtonBase;
import com.facebook.FacebookCallback;
import com.facebook.FacebookSdk;
import com.facebook.internal.CallbackManagerImpl;
import com.facebook.share.DeviceShareDialog;
import com.facebook.share.model.ShareContent;
import com.xiaomi.smarthome.R;

public final class DeviceShareButton extends FacebookButtonBase {
    private DeviceShareDialog dialog;
    private boolean enabledExplicitlySet;
    private int requestCode;
    private ShareContent shareContent;

    public final int getDefaultStyleResource() {
        return R.style.com_facebook_button_share;
    }

    public DeviceShareButton(Context context) {
        this(context, null, 0);
    }

    public DeviceShareButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private DeviceShareButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i, 0, "fb_device_share_button_create", "fb_device_share_button_did_tap");
        this.requestCode = 0;
        this.enabledExplicitlySet = false;
        this.dialog = null;
        this.requestCode = isInEditMode() ? 0 : getDefaultRequestCode();
        internalSetEnabled(false);
    }

    public final ShareContent getShareContent() {
        return this.shareContent;
    }

    public final void setShareContent(ShareContent shareContent2) {
        this.shareContent = shareContent2;
        if (!this.enabledExplicitlySet) {
            internalSetEnabled(canShare());
        }
    }

    public final void setEnabled(boolean z) {
        super.setEnabled(z);
        this.enabledExplicitlySet = true;
    }

    public final int getRequestCode() {
        return this.requestCode;
    }

    public final void registerCallback(CallbackManager callbackManager, FacebookCallback<DeviceShareDialog.Result> facebookCallback) {
        getDialog().registerCallback(callbackManager, facebookCallback);
    }

    public final void registerCallback(CallbackManager callbackManager, FacebookCallback<DeviceShareDialog.Result> facebookCallback, int i) {
        setRequestCode(i);
        getDialog().registerCallback(callbackManager, facebookCallback, i);
    }

    public final void configureButton(Context context, AttributeSet attributeSet, int i, int i2) {
        super.configureButton(context, attributeSet, i, i2);
        setInternalOnClickListener(getShareOnClickListener());
    }

    public final int getDefaultRequestCode() {
        return CallbackManagerImpl.RequestCodeOffset.Share.toRequestCode();
    }

    /* access modifiers changed from: protected */
    public final View.OnClickListener getShareOnClickListener() {
        return new View.OnClickListener() {
            /* class com.facebook.share.widget.DeviceShareButton.AnonymousClass1 */

            public void onClick(View view) {
                DeviceShareButton.this.callExternalOnClickListener(view);
                DeviceShareButton.this.getDialog().show(DeviceShareButton.this.getShareContent());
            }
        };
    }

    private void internalSetEnabled(boolean z) {
        setEnabled(z);
        this.enabledExplicitlySet = false;
    }

    private void setRequestCode(int i) {
        if (!FacebookSdk.isFacebookRequestCode(i)) {
            this.requestCode = i;
            return;
        }
        throw new IllegalArgumentException("Request code " + i + " cannot be within the range reserved by the Facebook SDK.");
    }

    private boolean canShare() {
        return new DeviceShareDialog(getActivity()).canShow(getShareContent());
    }

    public final DeviceShareDialog getDialog() {
        DeviceShareDialog deviceShareDialog = this.dialog;
        if (deviceShareDialog != null) {
            return deviceShareDialog;
        }
        if (getFragment() != null) {
            this.dialog = new DeviceShareDialog(getFragment());
        } else if (getNativeFragment() != null) {
            this.dialog = new DeviceShareDialog(getNativeFragment());
        } else {
            this.dialog = new DeviceShareDialog(getActivity());
        }
        return this.dialog;
    }
}
