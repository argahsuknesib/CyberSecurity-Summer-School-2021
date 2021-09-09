package com.xiaomi.smarthome.smartconfig.step;

import _m_j.fbs;
import _m_j.fbt;
import _m_j.htr;
import android.content.Context;
import android.os.Message;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.smartconfig.step.SmartConfigStep;

public class QRScanFindFailedStep extends SmartConfigStep {
    @BindView(6615)
    TextView mHelpTitle;
    @BindView(7370)
    ImageView mIcon;
    @BindView(6779)
    TextView mLeftBtn;
    @BindView(7372)
    TextView mMainTitle;
    @BindView(7210)
    TextView mRightBtn;
    @BindView(7371)
    TextView mSubMainTitle;

    public final SmartConfigStep.Step A_() {
        return null;
    }

    public final void H_() {
    }

    public final void I_() {
    }

    public final void O000000o(Message message) {
    }

    public final void O0000O0o() {
    }

    public final void O000000o(final Context context) {
        O000000o(context, (int) R.layout.smart_config_scan_qr_find_failed_ui);
        this.mIcon.setImageResource(R.drawable.config_failed_timeout);
        this.mMainTitle.setText((int) R.string.smart_config_faile_qr_find);
        this.mSubMainTitle.setText((int) R.string.smart_config_find_new_device_error);
        this.mLeftBtn.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.smartconfig.step.QRScanFindFailedStep.AnonymousClass1 */

            public final void onClick(View view) {
                QRScanFindFailedStep.this.b_(false);
            }
        });
        this.mRightBtn.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.smartconfig.step.QRScanFindFailedStep.AnonymousClass2 */

            public final void onClick(View view) {
                QRScanFindFailedStep.this.O000O0o();
            }
        });
        SpannableStringBuilder valueOf = SpannableStringBuilder.valueOf(this.O000O0oo.getString(R.string.smart_config_scan_qr_help));
        valueOf.setSpan(new ClickableSpan() {
            /* class com.xiaomi.smarthome.smartconfig.step.QRScanFindFailedStep.AnonymousClass3 */

            public final void updateDrawState(TextPaint textPaint) {
                super.updateDrawState(textPaint);
                textPaint.setColor(QRScanFindFailedStep.this.O000O0oo.getResources().getColor(R.color.mj_color_black_30_transparent));
                textPaint.setUnderlineText(true);
            }

            public final void onClick(View view) {
                fbt fbt = new fbt(context, "ResetDevicePageScan");
                fbt.O000000o("model", (String) htr.O000000o().O000000o("device_model"));
                fbs.O000000o(fbt);
                QRScanFindFailedStep.this.b_(true);
            }
        }, 0, valueOf.length(), 33);
        this.mHelpTitle.setHighlightColor(0);
        this.mHelpTitle.setText(valueOf);
        this.mHelpTitle.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.smartconfig.step.QRScanFindFailedStep.AnonymousClass4 */

            public final void onClick(View view) {
            }
        });
        this.mHelpTitle.setMovementMethod(LinkMovementMethod.getInstance());
    }
}
