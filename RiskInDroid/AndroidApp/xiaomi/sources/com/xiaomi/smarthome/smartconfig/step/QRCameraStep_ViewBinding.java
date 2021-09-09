package com.xiaomi.smarthome.smartconfig.step;

import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.facebook.drawee.view.SimpleDraweeView;
import com.xiaomi.smarthome.R;

public class QRCameraStep_ViewBinding implements Unbinder {

    /* renamed from: O000000o  reason: collision with root package name */
    private QRCameraStep f11786O000000o;

    public QRCameraStep_ViewBinding(QRCameraStep qRCameraStep, View view) {
        this.f11786O000000o = qRCameraStep;
        qRCameraStep.mTitleBar = Utils.findRequiredView(view, R.id.title_bar, "field 'mTitleBar'");
        qRCameraStep.mIvReturn = (ImageView) Utils.findRequiredViewAsType(view, R.id.module_a_3_return_btn, "field 'mIvReturn'", ImageView.class);
        qRCameraStep.mNextButton = (Button) Utils.findRequiredViewAsType(view, R.id.heard_qr_scaned, "field 'mNextButton'", Button.class);
        qRCameraStep.mHelpView = (TextView) Utils.findRequiredViewAsType(view, R.id.nothing_heard, "field 'mHelpView'", TextView.class);
        qRCameraStep.mBarCodeImage = (ImageView) Utils.findRequiredViewAsType(view, R.id.barcode_for_camera, "field 'mBarCodeImage'", ImageView.class);
        qRCameraStep.mGifTips = (SimpleDraweeView) Utils.findRequiredViewAsType(view, R.id.tips_gif, "field 'mGifTips'", SimpleDraweeView.class);
        qRCameraStep.mOpTips = (TextView) Utils.findRequiredViewAsType(view, R.id.op_desc, "field 'mOpTips'", TextView.class);
        qRCameraStep.mCbxHeard = (CheckBox) Utils.findRequiredViewAsType(view, R.id.check_box_confirm, "field 'mCbxHeard'", CheckBox.class);
        qRCameraStep.mReload = (TextView) Utils.findRequiredViewAsType(view, R.id.txt_load_again, "field 'mReload'", TextView.class);
    }

    public void unbind() {
        QRCameraStep qRCameraStep = this.f11786O000000o;
        if (qRCameraStep != null) {
            this.f11786O000000o = null;
            qRCameraStep.mTitleBar = null;
            qRCameraStep.mIvReturn = null;
            qRCameraStep.mNextButton = null;
            qRCameraStep.mHelpView = null;
            qRCameraStep.mBarCodeImage = null;
            qRCameraStep.mGifTips = null;
            qRCameraStep.mOpTips = null;
            qRCameraStep.mCbxHeard = null;
            qRCameraStep.mReload = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
