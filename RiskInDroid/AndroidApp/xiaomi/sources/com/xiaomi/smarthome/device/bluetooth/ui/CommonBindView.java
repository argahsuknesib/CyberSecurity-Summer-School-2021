package com.xiaomi.smarthome.device.bluetooth.ui;

import _m_j.gsy;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Handler;
import android.os.Message;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.OnCompositionLoadedListener;
import com.smarthome.connect.view.BaseBindView;
import com.xiaomi.smarthome.R;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class CommonBindView extends BaseBindView {

    /* renamed from: O000000o  reason: collision with root package name */
    public O000000o f7175O000000o;
    public LottieAnimationView O00000Oo;
    public View.OnClickListener O00000o;
    public View.OnClickListener O00000o0;
    public View.OnClickListener O00000oO;
    public View.OnClickListener O00000oo;
    public ValueAnimator O0000O0o;
    public Map<Integer, String> O0000OOo = new HashMap();
    private CommonBindProgressView O0000Oo;
    public Map<Integer, LottieComposition> O0000Oo0 = new ConcurrentHashMap();
    private View O0000OoO;
    private TextView O0000Ooo;
    private View O0000o;
    private TextView O0000o0;
    private Button O0000o00;
    private LinearLayout O0000o0O;
    private LinearLayout O0000o0o;
    private Button O0000oO;
    private Button O0000oO0;
    private ImageView O0000oOO;
    private LayoutInflater O0000oOo;
    private int O0000oo = -1;
    private Map<Integer, Integer> O0000oo0 = new HashMap();

    public CommonBindView(Context context) {
        super(context);
        O0000O0o();
    }

    public CommonBindView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        O0000O0o();
    }

    public CommonBindView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        O0000O0o();
    }

    private void O0000O0o() {
        this.f7175O000000o = new O000000o(this, (byte) 0);
        this.O0000oOo = LayoutInflater.from(getContext());
        this.O0000oOo.inflate((int) R.layout.sm_widget_common_bind_layout, this);
        this.O0000Oo = (CommonBindProgressView) findViewById(R.id.progress_view);
        this.O0000OoO = findViewById(R.id.progress_background);
        this.O00000Oo = (LottieAnimationView) findViewById(R.id.progress_lottie_view);
        this.O0000Ooo = (TextView) findViewById(R.id.progress_title);
        this.O0000o00 = (Button) findViewById(R.id.common_btn);
        this.O0000o0 = (TextView) findViewById(R.id.connect_failed_tips);
        this.O0000o0O = (LinearLayout) findViewById(R.id.step_container);
        if (((Activity) getContext()).getRequestedOrientation() == 0) {
            ViewGroup.LayoutParams layoutParams = this.O0000Ooo.getLayoutParams();
            ((ViewGroup.MarginLayoutParams) layoutParams).setMargins(14, 4, 14, 0);
            this.O0000Ooo.setLayoutParams(layoutParams);
            ViewGroup.LayoutParams layoutParams2 = this.O0000o0O.getLayoutParams();
            ((ViewGroup.MarginLayoutParams) layoutParams2).setMargins(26, 0, 26, 0);
            this.O0000o0O.setLayoutParams(layoutParams2);
        }
        this.O0000oOO = (ImageView) findViewById(R.id.final_icon);
        this.O0000o = findViewById(R.id.left_right_btn);
        this.O0000oO0 = (Button) findViewById(R.id.left_btn);
        this.O0000oO = (Button) findViewById(R.id.right_btn);
        this.O0000o00.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.device.bluetooth.ui.CommonBindView.AnonymousClass1 */

            public final void onClick(View view) {
                CommonBindView.this.f7175O000000o.removeMessages(16);
                if (CommonBindView.this.O00000o0 != null) {
                    CommonBindView.this.O00000o0.onClick(view);
                }
            }
        });
        this.O0000oO0.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.device.bluetooth.ui.CommonBindView.AnonymousClass6 */

            public final void onClick(View view) {
                if (CommonBindView.this.O00000o != null) {
                    CommonBindView.this.O00000o.onClick(view);
                }
            }
        });
        this.O0000oO.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.device.bluetooth.ui.CommonBindView.AnonymousClass7 */

            public final void onClick(View view) {
                if (CommonBindView.this.O00000oO != null) {
                    CommonBindView.this.O00000oO.onClick(view);
                }
            }
        });
        this.O0000o0.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.device.bluetooth.ui.CommonBindView.AnonymousClass8 */

            public final void onClick(View view) {
                if (CommonBindView.this.O00000oo != null) {
                    CommonBindView.this.O00000oo.onClick(view);
                }
            }
        });
        this.O0000OOo.put(1, "common_bind_lottie_animation/app_connect_device");
        this.O0000OOo.put(2, "common_bind_lottie_animation/app_transfer_device");
        this.O0000OOo.put(3, "common_bind_lottie_animation/device_connect_server");
        this.O0000OOo.put(4, "common_bind_lottie_animation/download_plugin");
        this.O0000oo0.put(1, 2000);
        this.O0000oo0.put(2, 1000);
        this.O0000oo0.put(3, 1000);
        this.O0000oo0.put(4, 1000);
        this.O0000O0o = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.O0000O0o.setRepeatCount(-1);
        this.O0000O0o.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            /* class com.xiaomi.smarthome.device.bluetooth.ui.CommonBindView.AnonymousClass9 */

            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (CommonBindView.this.O00000Oo != null && CommonBindView.this.O0000O0o.isRunning()) {
                    CommonBindView.this.O0000O0o.getAnimatedValue();
                    CommonBindView.this.O00000Oo.setProgress(((Float) CommonBindView.this.O0000O0o.getAnimatedValue()).floatValue());
                }
            }
        });
        gsy.O00000Oo("CommonBindView", "start fromAssetFileName");
        Context context = getContext();
        LottieComposition.Factory.fromAssetFileName(context, this.O0000OOo.get(1) + "/data.json", new OnCompositionLoadedListener() {
            /* class com.xiaomi.smarthome.device.bluetooth.ui.CommonBindView.AnonymousClass10 */

            public final void onCompositionLoaded(LottieComposition lottieComposition) {
                gsy.O00000Oo("CommonBindView", "1 onCompositionLoaded");
                CommonBindView.this.O0000Oo0.put(1, lottieComposition);
            }
        });
        this.f7175O000000o.postDelayed(new Runnable() {
            /* class com.xiaomi.smarthome.device.bluetooth.ui.CommonBindView.AnonymousClass11 */

            public final void run() {
                Context context = CommonBindView.this.getContext();
                LottieComposition.Factory.fromAssetFileName(context, CommonBindView.this.O0000OOo.get(2) + "/data.json", new OnCompositionLoadedListener() {
                    /* class com.xiaomi.smarthome.device.bluetooth.ui.CommonBindView.AnonymousClass11.AnonymousClass1 */

                    public final void onCompositionLoaded(LottieComposition lottieComposition) {
                        gsy.O00000Oo("CommonBindView", "2 onCompositionLoaded");
                        CommonBindView.this.O0000Oo0.put(2, lottieComposition);
                    }
                });
            }
        }, 800);
        this.f7175O000000o.postDelayed(new Runnable() {
            /* class com.xiaomi.smarthome.device.bluetooth.ui.CommonBindView.AnonymousClass12 */

            public final void run() {
                Context context = CommonBindView.this.getContext();
                LottieComposition.Factory.fromAssetFileName(context, CommonBindView.this.O0000OOo.get(3) + "/data.json", new OnCompositionLoadedListener() {
                    /* class com.xiaomi.smarthome.device.bluetooth.ui.CommonBindView.AnonymousClass12.AnonymousClass1 */

                    public final void onCompositionLoaded(LottieComposition lottieComposition) {
                        gsy.O00000Oo("CommonBindView", "3 onCompositionLoaded");
                        CommonBindView.this.O0000Oo0.put(3, lottieComposition);
                    }
                });
            }
        }, 1000);
        this.f7175O000000o.postDelayed(new Runnable() {
            /* class com.xiaomi.smarthome.device.bluetooth.ui.CommonBindView.AnonymousClass13 */

            public final void run() {
                Context context = CommonBindView.this.getContext();
                LottieComposition.Factory.fromAssetFileName(context, CommonBindView.this.O0000OOo.get(4) + "/data.json", new OnCompositionLoadedListener() {
                    /* class com.xiaomi.smarthome.device.bluetooth.ui.CommonBindView.AnonymousClass13.AnonymousClass1 */

                    public final void onCompositionLoaded(LottieComposition lottieComposition) {
                        gsy.O00000Oo("CommonBindView", "4 onCompositionLoaded");
                        CommonBindView.this.O0000Oo0.put(4, lottieComposition);
                    }
                });
            }
        }, 1200);
    }

    public void onConfigurationChanged(Configuration configuration) {
        TextView textView = this.O0000Ooo;
        if (textView != null && this.O0000o0O != null) {
            ViewGroup.LayoutParams layoutParams = textView.getLayoutParams();
            ViewGroup.LayoutParams layoutParams2 = this.O0000o0O.getLayoutParams();
            if (2 == configuration.orientation) {
                ((ViewGroup.MarginLayoutParams) layoutParams).setMargins(14, 4, 14, 0);
                ((ViewGroup.MarginLayoutParams) layoutParams2).setMargins(26, 4, 26, 0);
            } else {
                ((ViewGroup.MarginLayoutParams) layoutParams).setMargins(14, 14, 14, 0);
                ((ViewGroup.MarginLayoutParams) layoutParams2).setMargins(26, 30, 26, 0);
            }
            this.O0000Ooo.setLayoutParams(layoutParams);
            this.O0000o0O.setLayoutParams(layoutParams2);
        }
    }

    public void setCommonBtnVisibility(int i) {
        this.O0000o00.setVisibility(i);
    }

    public void setLeftRightBtnVisibility(int i) {
        this.O0000o.setVisibility(i);
    }

    public void setCommonBtnText(String str) {
        this.O0000o00.setText(str);
    }

    public void setCommonBtnListener(View.OnClickListener onClickListener) {
        this.O00000o0 = onClickListener;
    }

    public void setLeftBtnListener(View.OnClickListener onClickListener) {
        this.O00000o = onClickListener;
    }

    public void setRightBtnListener(View.OnClickListener onClickListener) {
        this.O00000oO = onClickListener;
    }

    public void setConnectFailedTipsVisibility(int i) {
        this.O0000o0.setVisibility(i);
    }

    public void setConnectFailedTipsText(String str) {
        this.O0000o0.setText(str);
    }

    public void setConnectFailedTipsListener(View.OnClickListener onClickListener) {
        this.O00000oo = onClickListener;
    }

    public void setProgress(int i) {
        this.O0000Oo.setProgress(i);
    }

    public final void O000000o(int i) {
        gsy.O00000Oo("CommonBindView", "startProgressAnimation step = ".concat(String.valueOf(i)));
        if (this.O0000Oo0.get(Integer.valueOf(i)) == null) {
            gsy.O00000Oo("CommonBindView", "startProgressAnimation step = " + i + ", lottieComposition is null");
            O00000Oo(i, 5);
            return;
        }
        O00000Oo(i);
    }

    public final void O00000Oo(final int i, final int i2) {
        gsy.O00000Oo("CommonBindView", "startRetry step = " + i + ", retryTime = " + i2);
        postDelayed(new Runnable() {
            /* class com.xiaomi.smarthome.device.bluetooth.ui.CommonBindView.AnonymousClass2 */

            public final void run() {
                if (CommonBindView.this.O0000Oo0.get(Integer.valueOf(i)) == null) {
                    int i = i2;
                    if (i > 0) {
                        CommonBindView.this.O00000Oo(i, i - 1);
                        return;
                    }
                    return;
                }
                CommonBindView.this.O00000Oo(i);
            }
        }, 500);
    }

    public final void O00000Oo(int i) {
        gsy.O00000Oo("CommonBindView", "startReady step = ".concat(String.valueOf(i)));
        if (i == 1) {
            O00000o0(i);
        } else {
            O00000o(i);
        }
    }

    public final void O00000o0(int i) {
        O00000oo();
        LottieComposition lottieComposition = this.O0000Oo0.get(Integer.valueOf(i));
        LottieAnimationView lottieAnimationView = this.O00000Oo;
        if (lottieAnimationView != null && lottieComposition != null) {
            lottieAnimationView.setComposition(lottieComposition);
            LottieAnimationView lottieAnimationView2 = this.O00000Oo;
            lottieAnimationView2.setImageAssetsFolder(this.O0000OOo.get(Integer.valueOf(i)) + "/images");
            this.O0000O0o.setDuration((long) this.O0000oo0.get(Integer.valueOf(i)).intValue());
            this.O0000O0o.start();
            Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.fade_in);
            loadAnimation.setDuration(300);
            this.O00000Oo.startAnimation(loadAnimation);
        }
    }

    private void O00000o(final int i) {
        if (this.O00000Oo != null) {
            Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.ftue_fade_out);
            loadAnimation.setDuration(300);
            loadAnimation.setAnimationListener(new Animation.AnimationListener() {
                /* class com.xiaomi.smarthome.device.bluetooth.ui.CommonBindView.AnonymousClass3 */

                public final void onAnimationRepeat(Animation animation) {
                }

                public final void onAnimationStart(Animation animation) {
                }

                public final void onAnimationEnd(Animation animation) {
                    CommonBindView.this.O00000o0(i);
                }
            });
            this.O00000Oo.cancelAnimation();
            this.O00000Oo.startAnimation(loadAnimation);
        }
    }

    public final void O00000oo() {
        LottieAnimationView lottieAnimationView = this.O00000Oo;
        if (lottieAnimationView != null) {
            lottieAnimationView.cancelAnimation();
        }
        ValueAnimator valueAnimator = this.O0000O0o;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.O00000o0 = null;
        this.O00000o = null;
        this.O00000oO = null;
        this.O00000oo = null;
        O00000oo();
        this.f7175O000000o.removeCallbacksAndMessages(null);
    }

    public final void O000000o(int i, int i2) {
        O000000o(getResources().getString(i), getResources().getString(i2));
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, android.widget.LinearLayout, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.smarthome.device.bluetooth.ui.CommonBindView.O000000o(java.lang.String, boolean):void
     arg types: [java.lang.String, int]
     candidates:
      com.xiaomi.smarthome.device.bluetooth.ui.CommonBindView.O000000o(com.smarthome.connect.view.BaseBindView$StepStatus, java.lang.CharSequence):void
      com.xiaomi.smarthome.device.bluetooth.ui.CommonBindView.O000000o(int, int):void
      com.xiaomi.smarthome.device.bluetooth.ui.CommonBindView.O000000o(java.lang.String, java.lang.String):void
      com.smarthome.connect.view.BaseBindView.O000000o(int, int):void
      com.smarthome.connect.view.BaseBindView.O000000o(java.lang.String, java.lang.String):void
      _m_j.ddg.O000000o(int, int):void
      _m_j.ddg.O000000o(java.lang.String, java.lang.String):void
      com.xiaomi.smarthome.device.bluetooth.ui.CommonBindView.O000000o(java.lang.String, boolean):void */
    public final void O000000o(String str, String str2) {
        this.O0000o0o = (LinearLayout) this.O0000oOo.inflate((int) R.layout.sm_widget_common_bind_step_item, (ViewGroup) this.O0000o0O, false);
        this.O0000o0O.addView(this.O0000o0o);
        O000000o(BaseBindView.StepStatus.LOADING, str);
        O000000o(str2, false);
    }

    public int getStepIndex() {
        return this.O0000o0O.getChildCount();
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, android.widget.LinearLayout, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public final void O000000o(final View.OnClickListener onClickListener) {
        LinearLayout linearLayout = (LinearLayout) this.O0000oOo.inflate((int) R.layout.miconnect_common_error_qr_refresh_text, (ViewGroup) this.O0000o0O, false);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        String string = getResources().getString(R.string.kuailian_connect_fail_qr_hint);
        String string2 = getResources().getString(R.string.kuailian_connect_fail_qr_enter_hint);
        SpannableString spannableString = new SpannableString(string + " " + string2);
        spannableString.setSpan(new ForegroundColorSpan(-16737793), string.length(), spannableString.length(), 17);
        spannableString.setSpan(new ClickableSpan() {
            /* class com.xiaomi.smarthome.device.bluetooth.ui.CommonBindView.AnonymousClass4 */

            public final void updateDrawState(TextPaint textPaint) {
                textPaint.setUnderlineText(false);
            }

            public final void onClick(View view) {
                View.OnClickListener onClickListener = onClickListener;
                if (onClickListener != null) {
                    onClickListener.onClick(view);
                }
            }
        }, string.length(), spannableString.length(), 17);
        TextView textView = (TextView) linearLayout.findViewById(R.id.mj_qr_refresh_hint);
        textView.setText(spannableString);
        ClickableSpan[] clickableSpanArr = (ClickableSpan[]) spannableString.getSpans(0, spannableString.length(), ClickableSpan.class);
        if (!(clickableSpanArr == null || clickableSpanArr.length == 0)) {
            textView.setMovementMethod(LinkMovementMethod.getInstance());
        }
        this.O0000o0O.addView(linearLayout);
    }

    public final void O000000o(BaseBindView.StepStatus stepStatus, int i, int i2) {
        O000000o(stepStatus, getResources().getString(i), i2, false);
    }

    public final void O000000o(BaseBindView.StepStatus stepStatus, String str, int i) {
        O000000o(stepStatus, str, i, false);
    }

    public final void O000000o(BaseBindView.StepStatus stepStatus, CharSequence charSequence, int i, boolean z) {
        O000000o(stepStatus, charSequence);
        O000000o(getResources().getString(i), z);
    }

    public void setCurrentIndex(int i) {
        this.O0000oo = i;
    }

    public int getCurrentIndex() {
        return this.O0000oo;
    }

    public final void O00000o0() {
        this.f7175O000000o.removeMessages(16);
        setCommonBtnText(((Object) getResources().getText(R.string.common_finish)) + " (3)");
        Message message = new Message();
        message.what = 16;
        message.arg1 = 2;
        this.f7175O000000o.sendMessageDelayed(message, 1000);
        this.O0000Oo.setVisibility(8);
        this.O0000OoO.setBackgroundResource(0);
        this.O0000Ooo.setText((int) R.string.ble_new_add_device_success_title);
        O00000oo();
        this.O00000Oo.setVisibility(8);
        this.O0000oOO.setVisibility(0);
        this.O0000oOO.setImageResource(R.drawable.common_bind_success);
    }

    public final void O00000o() {
        this.f7175O000000o.removeMessages(16);
        this.O0000Oo.setVisibility(8);
        this.O0000OoO.setBackgroundResource(0);
        this.O0000Ooo.setText((int) R.string.ble_new_add_device_success_title);
        O00000oo();
        this.O00000Oo.setVisibility(8);
        this.O0000oOO.setVisibility(0);
        this.O0000oOO.setImageResource(R.drawable.common_bind_success);
    }

    public final void O00000oO() {
        this.f7175O000000o.removeMessages(16);
        setCommonBtnText(((Object) getResources().getText(R.string.common_finish)) + " (3)");
        Message message = new Message();
        message.what = 16;
        message.arg1 = 2;
        this.f7175O000000o.sendMessageDelayed(message, 1000);
        this.O0000Oo.setVisibility(8);
        this.O0000OoO.setBackgroundResource(0);
        this.O0000Ooo.setText((int) R.string.ble_new_device_wifi_config_success_title);
        O00000oo();
        this.O00000Oo.setVisibility(8);
        this.O0000oOO.setVisibility(0);
        this.O0000oOO.setImageResource(R.drawable.common_bind_success);
    }

    public void setBindFailed(int i) {
        this.f7175O000000o.removeMessages(16);
        this.O0000Oo.setVisibility(8);
        this.O0000OoO.setBackgroundResource(0);
        O00000oo();
        this.O00000Oo.setVisibility(8);
        this.O0000oOO.setVisibility(0);
        this.O0000oOO.setImageResource(i);
    }

    public final void O000000o() {
        this.O0000o00.setVisibility(4);
        this.O0000o.setVisibility(4);
        this.O00000o = null;
        this.O00000oO = null;
        this.O0000o0.setVisibility(8);
        this.O00000oo = null;
        this.O0000Oo.setProgress(0);
        this.O0000Oo.setVisibility(0);
        this.O0000OoO.setBackgroundResource(R.drawable.common_bind_view_bg_shape);
        O00000oo();
        this.O0000oOO.setVisibility(8);
        this.O00000Oo.setVisibility(0);
        this.O0000o0O.removeAllViews();
        this.O0000o0o = null;
    }

    public final void O00000Oo() {
        this.O0000o00.setVisibility(4);
        this.O0000o.setVisibility(4);
        this.O0000o0.setVisibility(8);
        this.O0000Oo.setProgress(0);
        this.O0000Oo.setVisibility(0);
        this.O0000OoO.setBackgroundResource(R.drawable.common_bind_view_bg_shape);
        O00000oo();
        this.O0000oOO.setVisibility(8);
        this.O00000Oo.setVisibility(0);
    }

    private void O000000o(BaseBindView.StepStatus stepStatus, CharSequence charSequence) {
        ClickableSpan[] clickableSpanArr;
        LinearLayout linearLayout = this.O0000o0o;
        if (linearLayout != null) {
            ImageView imageView = (ImageView) linearLayout.findViewById(R.id.step_icon);
            TextView textView = (TextView) this.O0000o0o.findViewById(R.id.step_title);
            if (imageView != null && textView != null) {
                if (!(!(charSequence instanceof SpannableString) || (clickableSpanArr = (ClickableSpan[]) ((SpannableString) charSequence).getSpans(0, charSequence.length(), ClickableSpan.class)) == null || clickableSpanArr.length == 0)) {
                    textView.setMovementMethod(LinkMovementMethod.getInstance());
                }
                textView.setText(charSequence);
                int i = AnonymousClass5.f7187O000000o[stepStatus.ordinal()];
                if (i == 1) {
                    imageView.setImageResource(R.drawable.mj_webp_widget_loading);
                    Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.miconnect_rotate_infinite);
                    loadAnimation.setDuration(1000);
                    imageView.startAnimation(loadAnimation);
                    textView.setTextColor(getResources().getColor(R.color.mj_color_black));
                } else if (i == 2) {
                    imageView.clearAnimation();
                    imageView.setImageResource(R.drawable.miconnect_common_bind_success_icon);
                    textView.setTextColor(getResources().getColor(R.color.mj_color_gray_normal));
                } else if (i == 3) {
                    imageView.clearAnimation();
                    imageView.setImageResource(R.drawable.miconnect_common_bind_failed_icon);
                    textView.setTextColor(getResources().getColor(R.color.mj_color_gray_normal));
                }
            }
        }
    }

    /* renamed from: com.xiaomi.smarthome.device.bluetooth.ui.CommonBindView$5  reason: invalid class name */
    static /* synthetic */ class AnonymousClass5 {

        /* renamed from: O000000o  reason: collision with root package name */
        static final /* synthetic */ int[] f7187O000000o = new int[BaseBindView.StepStatus.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|8) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        static {
            f7187O000000o[BaseBindView.StepStatus.LOADING.ordinal()] = 1;
            f7187O000000o[BaseBindView.StepStatus.SUCCESS.ordinal()] = 2;
            try {
                f7187O000000o[BaseBindView.StepStatus.FAILED.ordinal()] = 3;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    private void O000000o(String str, boolean z) {
        this.O0000Ooo.setText(str);
        if (z) {
            this.O0000Ooo.setTextColor(getResources().getColor(R.color.mj_color_red_normal));
        } else {
            this.O0000Ooo.setTextColor(getResources().getColor(R.color.mj_color_gray_heavier));
        }
    }

    class O000000o extends Handler {
        private O000000o() {
        }

        /* synthetic */ O000000o(CommonBindView commonBindView, byte b) {
            this();
        }

        public final void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what == 16) {
                if (message.arg1 != 0) {
                    CommonBindView commonBindView = CommonBindView.this;
                    commonBindView.setCommonBtnText(((Object) CommonBindView.this.getResources().getText(R.string.common_finish)) + " (" + message.arg1 + ")");
                    Message message2 = new Message();
                    message2.arg1 = message.arg1 + -1;
                    message2.what = 16;
                    CommonBindView.this.f7175O000000o.sendMessageDelayed(message2, 1000);
                } else if (CommonBindView.this.O00000o0 != null) {
                    CommonBindView.this.O00000o0.onClick(null);
                }
            }
        }
    }
}
