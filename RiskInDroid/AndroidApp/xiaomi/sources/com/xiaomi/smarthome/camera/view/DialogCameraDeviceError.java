package com.xiaomi.smarthome.camera.view;

import _m_j.fbs;
import _m_j.fbt;
import _m_j.gkv;
import _m_j.gpc;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import com.xiaomi.smarthome.R;

public class DialogCameraDeviceError extends Dialog {
    private Activity activity;
    private String did;
    private boolean isOffline;
    private String model;
    private int screenHeight;
    private int screenWidth;

    public DialogCameraDeviceError(Activity activity2, String str, String str2, boolean z) {
        this(activity2, R.style.camera_error_help_dialog);
        this.activity = activity2;
        this.model = str;
        this.did = str2;
        this.isOffline = z;
        this.screenHeight = gpc.O000000o();
        this.screenWidth = gpc.O00000Oo(gkv.f17949O000000o);
        init();
    }

    protected DialogCameraDeviceError(Context context, int i) {
        super(context, i);
    }

    /* access modifiers changed from: protected */
    public void init() {
        setContentView((int) R.layout.dialog_camera_device_error);
        findViewById(R.id.root);
        TextView textView = (TextView) findViewById(R.id.title_tv);
        TextView textView2 = (TextView) findViewById(R.id.help_tip_content);
        findViewById(R.id.close_img).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.camera.view.DialogCameraDeviceError.AnonymousClass1 */

            public void onClick(View view) {
                DialogCameraDeviceError.this.dismiss();
            }
        });
        findViewById(R.id.offline_ok).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.camera.view.DialogCameraDeviceError.AnonymousClass2 */

            public void onClick(View view) {
                DialogCameraDeviceError.this.dismiss();
            }
        });
        if (this.isOffline) {
            String string = this.activity.getString(R.string.offline_help_tip);
            textView.setText((int) R.string.dialog_title_offline);
            textView2.setText(match(string));
        } else {
            String string2 = this.activity.getString(R.string.connect_error_help_tip);
            textView.setText((int) R.string.dialog_title_connect_error);
            textView2.setText(match(string2));
        }
        textView2.setMovementMethod(LinkMovementMethod.getInstance());
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        double d = (double) this.screenWidth;
        Double.isNaN(d);
        attributes.width = (int) (d * 0.85d);
        window.setAttributes(attributes);
    }

    private SpannableString match(String str) {
        String string = this.activity.getString(R.string.offline_connect_again);
        String string2 = this.activity.getString(R.string.offline_retry_bind);
        String string3 = this.activity.getString(R.string.offline_feedback_problem);
        String string4 = this.activity.getString(R.string.offline_feedback_rssi);
        SpannableString spannableString = new SpannableString(str);
        int indexOf = str.indexOf(string);
        int indexOf2 = str.indexOf(string2);
        int indexOf3 = str.indexOf(string3);
        int indexOf4 = str.indexOf(string4);
        if (indexOf >= 0) {
            spannableString.setSpan(new MyClickSpan() {
                /* class com.xiaomi.smarthome.camera.view.DialogCameraDeviceError.AnonymousClass3 */

                public void onClick(View view) {
                    DialogCameraDeviceError.this.gotoRetryConnect();
                }
            }, indexOf, string.length() + indexOf, 33);
        }
        if (indexOf2 >= 0) {
            spannableString.setSpan(new MyClickSpan() {
                /* class com.xiaomi.smarthome.camera.view.DialogCameraDeviceError.AnonymousClass4 */

                public void onClick(View view) {
                    DialogCameraDeviceError.this.gotoRetryConnect();
                }
            }, indexOf2, string2.length() + indexOf2, 33);
        }
        if (indexOf3 >= 0) {
            spannableString.setSpan(new MyClickSpan() {
                /* class com.xiaomi.smarthome.camera.view.DialogCameraDeviceError.AnonymousClass5 */

                public void onClick(View view) {
                    DialogCameraDeviceError.this.gotoFeedBackProblem();
                }
            }, indexOf3, string3.length() + indexOf3, 33);
        }
        if (indexOf4 >= 0) {
            spannableString.setSpan(new MyClickSpan() {
                /* class com.xiaomi.smarthome.camera.view.DialogCameraDeviceError.AnonymousClass6 */

                public void onClick(View view) {
                    DialogCameraDeviceError.this.gotoRssiProblem();
                }
            }, indexOf4, string4.length() + indexOf4, 33);
        }
        return spannableString;
    }

    public void gotoRetryConnect() {
        fbt fbt = new fbt(this.activity, "ResetPageRoute");
        fbt.O000000o("extra_model", this.model);
        fbt.O00000Oo(268435456);
        fbs.O000000o(fbt);
    }

    public void gotoFeedBackProblem() {
        fbt fbt = new fbt(getContext(), "/userCenter/FeedbackActivity");
        fbt.O000000o("extra_device_model", this.model);
        fbt.O000000o("extra_source", 0);
        if (!TextUtils.isEmpty(this.did)) {
            fbt.O000000o("extra_device_did", this.did);
        }
        fbs.O000000o(fbt);
    }

    public void gotoRssiProblem() {
        fbt fbt = new fbt(getContext(), "/userCenter/DeviceNetworkInfoActivity");
        fbt.O000000o("extra_device_model", this.model);
        if (!TextUtils.isEmpty(this.did)) {
            fbt.O000000o("did", this.did);
        }
        fbs.O000000o(fbt);
    }

    public static class MyClickSpan extends ClickableSpan {
        public void onClick(View view) {
        }

        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(Color.parseColor("#32BAC0"));
            textPaint.setUnderlineText(true);
        }
    }
}
