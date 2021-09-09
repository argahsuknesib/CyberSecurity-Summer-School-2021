package com.xiaomi.smarthome.scene.timer;

import _m_j.fag;
import _m_j.fno;
import _m_j.fso;
import _m_j.gpc;
import _m_j.hrf;
import android.content.Intent;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.ArcShape;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import com.xiaomi.smarthome.framework.redpoint.ServerTimerManager;
import com.xiaomi.smarthome.library.common.dialog.XQProgressDialog;
import com.xiaomi.smarthome.scene.model.CorntabUtils;
import java.lang.ref.WeakReference;
import java.util.Calendar;

public class CountDownTimerStartActivity extends BaseActivity implements hrf.O00000Oo {

    /* renamed from: O000000o  reason: collision with root package name */
    private View f11244O000000o;
    private TextView O00000Oo;
    private ImageView O00000o;
    private TextView O00000o0;
    private Device O00000oO;
    private String O00000oo;
    private PlugTimer O0000O0o = null;
    private boolean O0000OOo;
    private String O0000Oo;
    private String O0000Oo0;
    private String O0000OoO;
    private String O0000Ooo;
    private Drawable[] O0000o = new Drawable[3];
    private String O0000o0;
    private String O0000o00;
    private View.OnClickListener O0000o0O = new View.OnClickListener() {
        /* class com.xiaomi.smarthome.scene.timer.CountDownTimerStartActivity.AnonymousClass1 */

        public final void onClick(View view) {
            if (CountDownTimerStartActivity.this.isFromLog) {
                CountDownTimerStartActivity.this.finish();
                return;
            }
            CountDownTimerStartActivity.this.mXQProgressDialog.show();
            CountDownTimerStartActivity.this.mTimerManager.O000000o(CountDownTimerStartActivity.this.mTargetCountDownTimer, new hrf.O00000Oo() {
                /* class com.xiaomi.smarthome.scene.timer.CountDownTimerStartActivity.AnonymousClass1.AnonymousClass1 */

                public final void onGetSceneFailed(int i) {
                }

                public final void onGetSceneSuccess() {
                }

                public final void onSetSceneSuccess(CommonTimer commonTimer) {
                    CountDownTimerStartActivity.this.mHandler.removeMessages(1);
                    CountDownTimerStartActivity.this.finish();
                    CountDownTimerStartActivity.this.returnSetting();
                }

                public final void onSetSceneFailed(fso fso) {
                    CountDownTimerStartActivity.this.mXQProgressDialog.dismiss();
                    fag.O000000o(CountDownTimerStartActivity.this, (int) R.string.set_timer_fail_delete, 0);
                }
            });
        }
    };
    private int O0000o0o;
    public boolean isFromLog = false;
    public O000000o mHandler = null;
    public PlugTimer mTargetCountDownTimer = null;
    public hrf mTimerManager = null;
    public XQProgressDialog mXQProgressDialog;

    public void onGetSceneFailed(int i) {
    }

    public void onSetSceneFailed(fso fso) {
    }

    public void onSetSceneSuccess(CommonTimer commonTimer) {
    }

    public void refreshStatus() {
    }

    public void returnSetting() {
        Intent intent = new Intent(this, CountDownTimerActivity.class);
        intent.putExtra("common_timer_device_id", this.O00000oo);
        intent.putExtra("on_method", this.O0000Oo0);
        intent.putExtra("on_param", this.O0000Oo);
        intent.putExtra("off_method", this.O0000OoO);
        intent.putExtra("off_param", this.O0000Ooo);
        intent.putExtra("device_power_on", this.O0000OOo);
        intent.putExtra("timer_identify_rn", this.O0000o0);
        intent.putExtra("common_timer_display_name", this.O0000o00);
        startActivity(intent);
    }

    public void onCreate(Bundle bundle) {
        PlugTimer plugTimer;
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_count_down_start_v2);
        Intent intent = getIntent();
        if (intent == null) {
            finish();
            return;
        }
        this.isFromLog = intent.getBooleanExtra("is_from_log", false);
        String stringExtra = intent.getStringExtra("common_timer_device_id");
        if (!TextUtils.isEmpty(stringExtra)) {
            this.O00000oo = stringExtra;
            this.O00000oO = fno.O000000o().O000000o(stringExtra);
        }
        this.mTargetCountDownTimer = (PlugTimer) intent.getParcelableExtra("target_time");
        if (this.isFromLog || (this.O00000oO != null && !TextUtils.isEmpty(stringExtra) && (plugTimer = this.mTargetCountDownTimer) != null && plugTimer.O00000Oo)) {
            this.O0000OOo = intent.getBooleanExtra("device_power_on", false);
            this.O0000Oo0 = intent.getStringExtra("on_method");
            this.O0000OoO = intent.getStringExtra("off_method");
            this.O0000Oo = intent.getStringExtra("on_param");
            this.O0000Ooo = intent.getStringExtra("off_param");
            this.O0000o0 = intent.getStringExtra("timer_identify_rn");
            this.O0000o00 = intent.getStringExtra("common_timer_display_name");
            if (TextUtils.isEmpty(this.O0000o00)) {
                this.O0000o00 = "display_name";
            }
            this.O0000O0o = (PlugTimer) this.mTargetCountDownTimer.clone();
            View findViewById = findViewById(R.id.module_a_3_return_btn);
            if (findViewById != null) {
                findViewById.setOnClickListener(new View.OnClickListener() {
                    /* class com.xiaomi.smarthome.scene.timer.CountDownTimerStartActivity.AnonymousClass2 */

                    public final void onClick(View view) {
                        CountDownTimerStartActivity.this.finish();
                    }
                });
            }
            ((TextView) findViewById(R.id.module_a_3_return_title)).setText((int) R.string.plug_timer_set_countdown);
            this.f11244O000000o = findViewById(R.id.view_count_down);
            this.O00000o0 = (TextView) findViewById(R.id.count_down_tip);
            this.O00000o = (ImageView) findViewById(R.id.iv_count_down_start);
            this.O00000Oo = (TextView) findViewById(R.id.button_cancel);
            this.O00000Oo.setOnClickListener(this.O0000o0O);
            this.O0000o0o = O000000o();
            O000000o(this.f11244O000000o, 100, O000000o(this.O0000o0o));
            this.mHandler = new O000000o(this, getMainLooper());
            updateCountDownTimer();
            PlugTimer plugTimer2 = this.mTargetCountDownTimer;
            if (plugTimer2 == null || !plugTimer2.O00000Oo) {
                PlugTimer plugTimer3 = this.mTargetCountDownTimer;
                if (plugTimer3 != null) {
                    plugTimer3.O00000Oo = false;
                }
                this.mHandler.removeMessages(1);
            } else {
                this.mHandler.sendEmptyMessageDelayed(1, 20000);
            }
            this.mTimerManager = hrf.O0000O0o();
            Device device = this.O00000oO;
            if (device != null) {
                this.mTimerManager.O000000o(device, "timer_name", this.O0000o00);
            }
            this.mTimerManager.O000000o(this);
            this.mXQProgressDialog = new XQProgressDialog(this);
            this.mXQProgressDialog.setMessage(getString(R.string.gateway_magnet_location_updating));
            this.mXQProgressDialog.setCancelable(true);
        }
    }

    public void onGetSceneSuccess() {
        if (!isFinishing()) {
            this.mXQProgressDialog.dismiss();
        }
    }

    public void updateCountDownTimer() {
        if (this.isFromLog) {
            O000000o(this.f11244O000000o, 0, getResources().getString(R.string.count_down_end));
            this.O00000o.setImageResource(R.drawable.count_down_shape_end);
            this.mHandler.removeMessages(1);
            return;
        }
        PlugTimer plugTimer = this.mTargetCountDownTimer;
        if (plugTimer != null) {
            if (!plugTimer.O00000Oo) {
                this.mHandler.removeMessages(1);
            }
            int O000000o2 = O000000o();
            if (this.O0000o0o <= 0) {
                O000000o(this.f11244O000000o, 0, getResources().getString(R.string.count_down_end));
                this.O00000o.setImageResource(R.drawable.count_down_shape_end);
                this.O00000Oo.setVisibility(8);
            } else if (O000000o2 >= 0) {
                O000000o(this.f11244O000000o, (O000000o2 * 100) / 60, O000000o(O000000o2));
                if (O000000o2 == 0) {
                    O000000o(this.f11244O000000o, 0, getResources().getString(R.string.count_down_end));
                    this.O00000o.setImageResource(R.drawable.count_down_shape_end);
                    this.O00000Oo.setVisibility(8);
                    this.mHandler.removeMessages(1);
                    this.mHandler.postDelayed(new Runnable() {
                        /* class com.xiaomi.smarthome.scene.timer.CountDownTimerStartActivity.AnonymousClass3 */

                        public final void run() {
                            CountDownTimerStartActivity.this.finish();
                            CountDownTimerStartActivity.this.returnSetting();
                        }
                    }, 500);
                }
            } else {
                O000000o(this.f11244O000000o, 0, getResources().getString(R.string.count_down_end));
                this.O00000o.setImageResource(R.drawable.count_down_shape_end);
                this.mHandler.removeMessages(1);
            }
        }
    }

    private int O000000o() {
        Calendar instance = Calendar.getInstance();
        int i = instance.get(12) + (instance.get(11) * 60);
        CorntabUtils.CorntabParam O00000Oo2 = O00000Oo();
        return ((((O00000Oo2.O00000o0 * 60) + O00000Oo2.O00000Oo) - i) - (((int) ServerTimerManager.O000000o(CommonApplication.getAppContext()).O00000Oo()) / 60000)) + (instance.get(5) == O00000Oo2.O00000o ? 0 : 1440);
    }

    private CorntabUtils.CorntabParam O00000Oo() {
        return this.O0000OOo ? this.mTargetCountDownTimer.O0000OOo : this.mTargetCountDownTimer.O00000oO;
    }

    private String O000000o(int i) {
        int i2;
        if (i == 0) {
            return getString(R.string.count_down_end);
        }
        int i3 = i < 60 ? i : 0;
        if (i >= 60) {
            i3 = i % 60;
            i2 = i / 60;
        } else {
            i2 = 0;
        }
        String str = null;
        String quantityString = i2 > 0 ? getResources().getQuantityString(R.plurals.automation_hour, i2, Integer.valueOf(i2)) : null;
        if (i3 > 0) {
            str = getResources().getQuantityString(R.plurals.count_down_minute, i3, Integer.valueOf(i3));
        }
        if (this.O0000OOo) {
            Object[] objArr = new Object[2];
            if (TextUtils.isEmpty(quantityString)) {
                quantityString = "";
            }
            objArr[0] = quantityString;
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            objArr[1] = str;
            return getString(R.string.count_down_timer_hint_off, objArr);
        }
        Object[] objArr2 = new Object[2];
        if (TextUtils.isEmpty(quantityString)) {
            quantityString = "";
        }
        objArr2[0] = quantityString;
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        objArr2[1] = str;
        return getString(R.string.count_down_timer_hint_on, objArr2);
    }

    private void O000000o(View view, int i, String str) {
        if (i > 100) {
            i = 100;
        }
        ShapeDrawable shapeDrawable = new ShapeDrawable(new OvalShape());
        shapeDrawable.getPaint().setColor(getResources().getColor(R.color.mj_color_white));
        shapeDrawable.getPaint().setStyle(Paint.Style.FILL_AND_STROKE);
        this.O0000o[2] = shapeDrawable;
        float f = (i < 0 || i > 100) ? 0.0f : ((float) i) * 3.6f;
        int O000000o2 = gpc.O000000o(10.0f);
        ShapeDrawable shapeDrawable2 = new ShapeDrawable(new ArcShape(-90.0f, f));
        shapeDrawable2.getPaint().setStyle(Paint.Style.FILL_AND_STROKE);
        if (f == 0.0f) {
            shapeDrawable2.getPaint().setColor(0);
        } else {
            shapeDrawable2.getPaint().setColor(getResources().getColor(R.color.mj_color_text_hightlight));
        }
        this.O0000o[0] = shapeDrawable2;
        ShapeDrawable shapeDrawable3 = new ShapeDrawable(new ArcShape(f - 90.0f, 360.0f - f));
        if (f == 360.0f) {
            shapeDrawable3.getPaint().setColor(0);
        } else {
            shapeDrawable3.getPaint().setColor(getResources().getColor(R.color.mj_color_gray_lightest));
        }
        shapeDrawable3.getPaint().setStyle(Paint.Style.FILL_AND_STROKE);
        Drawable[] drawableArr = this.O0000o;
        drawableArr[1] = shapeDrawable3;
        LayerDrawable layerDrawable = new LayerDrawable(drawableArr);
        layerDrawable.setLayerInset(2, O000000o2, O000000o2, O000000o2, O000000o2);
        view.setBackground(layerDrawable);
        int indexOf = str.indexOf("\n");
        if (indexOf < 0 || indexOf > str.length()) {
            this.O00000o0.setText(str);
            this.O00000o0.setTextColor(getResources().getColor(R.color.mj_color_cc));
            return;
        }
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(new AbsoluteSizeSpan(15, true), indexOf, str.length(), 33);
        this.O00000o0.setText(spannableString);
        this.O00000o0.setTextColor(getResources().getColor(R.color.mj_color_text_hightlight));
    }

    static class O000000o extends Handler {

        /* renamed from: O000000o  reason: collision with root package name */
        private WeakReference<CountDownTimerStartActivity> f11249O000000o;

        public O000000o(CountDownTimerStartActivity countDownTimerStartActivity, Looper looper) {
            super(looper);
            this.f11249O000000o = new WeakReference<>(countDownTimerStartActivity);
        }

        public final void handleMessage(Message message) {
            CountDownTimerStartActivity countDownTimerStartActivity = this.f11249O000000o.get();
            boolean z = false;
            if (countDownTimerStartActivity != null && !countDownTimerStartActivity.isFinishing() && (Build.VERSION.SDK_INT < 17 || !countDownTimerStartActivity.isDestroyed())) {
                z = true;
            }
            if (z) {
                int i = message.what;
                if (i == 1) {
                    countDownTimerStartActivity.updateCountDownTimer();
                    countDownTimerStartActivity.mHandler.sendEmptyMessageDelayed(1, 20000);
                } else if (i == 2) {
                    countDownTimerStartActivity.refreshStatus();
                }
            }
        }
    }
}
