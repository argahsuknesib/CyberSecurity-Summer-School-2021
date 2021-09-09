package com.xiaomi.smarthome.smartconfig.step;

import _m_j.fuf;
import _m_j.htr;
import _m_j.hul;
import android.content.Context;
import android.os.Message;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import butterknife.BindView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.exoplayer2.source.dash.DashMediaSource;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.DeviceFactory;
import com.xiaomi.smarthome.library.common.widget.PieProgressBar;
import com.xiaomi.smarthome.smartconfig.SmartConfigRouterFactory;
import com.xiaomi.smarthome.smartconfig.WifiInfo;
import com.xiaomi.smarthome.smartconfig.step.SmartConfigStep;
import java.util.Iterator;

public class RouterInfoStep extends SmartConfigStep {

    /* renamed from: O000000o  reason: collision with root package name */
    private long f11805O000000o;
    @BindView(6174)
    TextView mBarText;
    @BindView(7370)
    SimpleDraweeView mDeviceIcon;
    @BindView(6986)
    Button mNextBtn;
    @BindView(6173)
    PieProgressBar mProgressBar;
    @BindView(6172)
    View mProgressContainer;
    @BindView(7372)
    TextView mRouterInfo;
    @BindView(7371)
    TextView mRouterInfoSubTitle;
    @BindView(6175)
    TextView mRouterInfoTitle;
    @BindView(6171)
    View mRouterInfoView;
    @BindView(7246)
    TextView mSwitchRouterBtn;

    public final void H_() {
    }

    public final void I_() {
    }

    public final SmartConfigStep.Step A_() {
        return SmartConfigStep.Step.STEP_GET_ROUTER_INFO;
    }

    public final void O000000o(Message message) {
        int i = message.what;
        if (i == 116) {
            O000000o(SmartConfigStep.Step.STEP_CHOOSE_WIFI);
        } else if (i == 117) {
            float currentTimeMillis = (((float) (System.currentTimeMillis() - this.f11805O000000o)) * 100.0f) / 30000.0f;
            if (currentTimeMillis <= 101.0f) {
                this.mProgressBar.setPercent(currentTimeMillis);
                x_().sendEmptyMessageDelayed(117, 100);
            }
        }
    }

    public final void O000000o(Context context) {
        O000000o(context, (int) R.layout.smart_config_get_router_info_ui);
        this.mProgressContainer.setVisibility(0);
        this.mRouterInfoView.setVisibility(8);
        this.mProgressBar.setPercentView(this.mBarText);
        this.mProgressBar.setPercent(0.0f);
        this.mProgressBar.setDuration(30);
        this.f11805O000000o = System.currentTimeMillis();
        this.mNextBtn.setVisibility(8);
        this.mRouterInfoTitle.setText((int) R.string.router_test_testing);
        x_().sendEmptyMessageDelayed(116, DashMediaSource.DEFAULT_LIVE_PRESENTATION_DELAY_FIXED_MS);
        x_().sendEmptyMessageDelayed(117, 100);
        x_().post(new Runnable() {
            /* class com.xiaomi.smarthome.smartconfig.step.RouterInfoStep.AnonymousClass1 */

            public final void run() {
                SmartConfigRouterFactory.getSmartConfigManager().getLocalMiRouterDetail(new hul<fuf.O00000o0>() {
                    /* class com.xiaomi.smarthome.smartconfig.step.RouterInfoStep.AnonymousClass1.AnonymousClass1 */

                    public final void O00000Oo(int i) {
                    }

                    public final /* synthetic */ void O000000o(Object obj) {
                        WifiInfo wifiInfo;
                        fuf.O00000o0 o00000o0 = (fuf.O00000o0) obj;
                        String str = (String) htr.O000000o().O000000o("device_model");
                        boolean z = str != null && DeviceFactory.O000000o(str);
                        Iterator<WifiInfo> it = o00000o0.f17173O000000o.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                wifiInfo = null;
                                break;
                            }
                            wifiInfo = it.next();
                            if ((z && wifiInfo.f11472O000000o > 20 && wifiInfo.O00000Oo && !TextUtils.isEmpty(wifiInfo.O00000o0)) || (wifiInfo.f11472O000000o > 0 && wifiInfo.f11472O000000o < 20 && wifiInfo.O00000Oo && !TextUtils.isEmpty(wifiInfo.O00000o0))) {
                                break;
                            }
                        }
                        if (RouterInfoStep.this.x_() != null) {
                            RouterInfoStep.this.x_().removeMessages(116);
                            RouterInfoStep.this.x_().removeMessages(117);
                        }
                        if (RouterInfoStep.this.O000OO00) {
                            return;
                        }
                        if (wifiInfo == null) {
                            RouterInfoStep.this.O00000Oo();
                            return;
                        }
                        RouterInfoStep.this.mProgressContainer.setVisibility(8);
                        RouterInfoStep.this.mRouterInfoView.setVisibility(0);
                        RouterInfoStep.this.O000000o(wifiInfo);
                    }

                    public final void O000000o(int i) {
                        if (!RouterInfoStep.this.O000OO00) {
                            RouterInfoStep.this.O00000Oo();
                        }
                    }
                });
            }
        });
    }

    /* access modifiers changed from: package-private */
    public final void O000000o(final WifiInfo wifiInfo) {
        String str;
        this.mRouterInfoView.setVisibility(0);
        this.mProgressContainer.setVisibility(8);
        this.mNextBtn.setVisibility(0);
        String str2 = (String) htr.O000000o().O000000o("device_model");
        if (str2 != null) {
            String O0000o0 = DeviceFactory.O0000o0(str2);
            DeviceFactory.O000000o(O0000o0, this.mDeviceIcon, (int) R.drawable.device_list_phone_no);
            Device O0000o0O = DeviceFactory.O0000o0O(O0000o0);
            if (O0000o0O != null) {
                str = O0000o0O.name;
            } else {
                str = SmartConfigRouterFactory.getSmartConfigManager().getAppContext().getString(R.string.other_device);
            }
            this.mRouterInfo.setText(String.format(this.O000O0oo.getString(R.string.router_test_info), str));
            this.mRouterInfoSubTitle.setText(String.format(this.O000O0oo.getString(R.string.router_test_sub_info), wifiInfo.O00000o0));
            SpannableStringBuilder valueOf = SpannableStringBuilder.valueOf(this.O000O0oo.getString(R.string.router_test_switch));
            valueOf.setSpan(new ClickableSpan() {
                /* class com.xiaomi.smarthome.smartconfig.step.RouterInfoStep.AnonymousClass2 */

                public final void updateDrawState(TextPaint textPaint) {
                    super.updateDrawState(textPaint);
                    textPaint.setColor(RouterInfoStep.this.O000O0oo.getResources().getColor(R.color.mj_color_class_text_27));
                    textPaint.setUnderlineText(true);
                }

                public final void onClick(View view) {
                    RouterInfoStep routerInfoStep = RouterInfoStep.this;
                    routerInfoStep.mRouterInfo = null;
                    routerInfoStep.O000000o(SmartConfigStep.Step.STEP_CHOOSE_WIFI);
                }
            }, 0, valueOf.length(), 33);
            this.mSwitchRouterBtn.setHighlightColor(0);
            this.mSwitchRouterBtn.setText(valueOf);
            this.mSwitchRouterBtn.setMovementMethod(LinkMovementMethod.getInstance());
            this.mNextBtn.setText((int) R.string.next_button);
            this.mNextBtn.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.smartconfig.step.RouterInfoStep.AnonymousClass3 */

                public final void onClick(View view) {
                    htr.O000000o().O00000Oo("mi_router_info", wifiInfo);
                    htr.O000000o().O00000Oo("miui_class");
                    RouterInfoStep.this.O000O0o();
                }
            });
        }
    }

    /* access modifiers changed from: package-private */
    public final void O00000Oo() {
        O000000o(SmartConfigStep.Step.STEP_CHOOSE_WIFI);
    }

    public final void O0000O0o() {
        if (x_() != null) {
            x_().removeMessages(116);
            x_().removeMessages(117);
        }
    }
}
