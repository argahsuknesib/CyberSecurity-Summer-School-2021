package com.xiaomi.smarthome.miio.ir;

import _m_j.goq;
import _m_j.grs;
import android.content.Context;
import android.content.SharedPreferences;
import android.gesture.GestureOverlayView;
import android.graphics.PointF;
import android.hardware.ConsumerIrManager;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;

public class IRV2ControllerMiActivity extends BaseActivity implements GestureOverlayView.OnGestureListener, View.OnClickListener, View.OnLongClickListener {
    public static final String[] IRV2_MI_CONTROLLER_KEYPAD = {"power", "home", "menu", "back", "up", "down", "left", "right", "ok", "vol+", "vol-", "power", "home", "menu", "back"};
    public static final int[] IRV2_MI_CONTROLLER_KEYPAD_VIEW = {R.id.irv2_controller_power, R.id.irv2_controller_home, R.id.irv2_controller_menu, R.id.irv2_controller_back, R.id.irv2_round_button_up, R.id.irv2_round_button_down, R.id.irv2_round_button_left, R.id.irv2_round_button_right, R.id.irv2_round_button_ok, R.id.irv2_controller_vol_add, R.id.irv2_controller_vol_minus, R.id.irv2_box_controller_power_adv, R.id.irv2_box_controller_home_adv, R.id.irv2_box_controller_menu_adv, R.id.irv2_box_controller_back_adv};
    private static float O0000oOo = ((float) (Math.log(0.78d) / Math.log(0.9d)));

    /* renamed from: O000000o  reason: collision with root package name */
    private ArrayList<View> f9720O000000o = new ArrayList<>();
    private ArrayList<String> O00000Oo = new ArrayList<>();
    private RadioButton O00000o;
    private RadioButton O00000o0;
    private View O00000oO;
    private View O00000oo;
    private int O0000O0o = 0;
    private boolean O0000OOo = false;
    private PointF O0000Oo;
    private boolean O0000Oo0 = false;
    private PointF O0000OoO;
    private View O0000Ooo;
    private int O0000o = 0;
    private ImageView O0000o0;
    private GestureOverlayView O0000o00;
    private GestureOverlayView O0000o0O;
    private ImageView O0000o0o;
    private Handler O0000oO = new Handler();
    private PointF O0000oO0;
    private Runnable O0000oOO;
    private int O0000oo = -1;
    private VelocityTracker O0000oo0;
    private View O0000ooO;
    private boolean O0000ooo = false;
    public int mUseMode = 0;
    public View mViewToHide;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_irv2_mi_controller);
        ((TextView) findViewById(R.id.module_a_3_return_title)).setText((int) R.string.irv2_controller_mi_title);
        this.O0000ooO = findViewById(R.id.module_a_3_return_btn);
        this.O0000ooO.setOnClickListener(this);
        this.O0000o00 = (GestureOverlayView) findViewById(R.id.irv2_touch_direction_view);
        this.O0000o00.setOnClickListener(this);
        this.O0000o00.setOnLongClickListener(this);
        this.O0000o00.setOrientation(0);
        this.O0000o00.addOnGestureListener(this);
        this.O0000o0 = (ImageView) findViewById(R.id.irv2_touch_direction_hint_view);
        this.O0000o0O = (GestureOverlayView) findViewById(R.id.irv2_touch_vol_view);
        this.O0000o0O.setOrientation(0);
        this.O0000o0O.addOnGestureListener(this);
        this.O0000o0o = (ImageView) findViewById(R.id.irv2_touch_vol_hint_view);
        this.O00000o0 = (RadioButton) findViewById(R.id.irv2_controller_switch_traditional);
        this.O00000o0.setOnClickListener(this);
        this.O00000o = (RadioButton) findViewById(R.id.irv2_controller_switch_advance);
        this.O00000o.setOnClickListener(this);
        this.O00000oO = findViewById(R.id.irv2_controller_traditional);
        this.O00000oo = findViewById(R.id.irv2_controller_advance);
        int[] iArr = IRV2_MI_CONTROLLER_KEYPAD_VIEW;
        for (int i = 0; i < iArr.length; i++) {
            View findViewById = findViewById(iArr[i]);
            if (findViewById != null) {
                findViewById.setOnClickListener(this);
                this.f9720O000000o.add(findViewById);
                this.O00000Oo.add(IRV2_MI_CONTROLLER_KEYPAD[i]);
            }
        }
        new AsyncTask<Void, Void, Integer>() {
            /* class com.xiaomi.smarthome.miio.ir.IRV2ControllerMiActivity.AnonymousClass3 */

            /* access modifiers changed from: protected */
            public final /* synthetic */ void onPostExecute(Object obj) {
                IRV2ControllerMiActivity.this.setUseMode(((Integer) obj).intValue());
            }

            /* access modifiers changed from: protected */
            public final /* synthetic */ Object doInBackground(Object[] objArr) {
                return Integer.valueOf(CommonApplication.getAppContext().getSharedPreferences("use_mode_shared_pref", 0).getInt("use_mode_shared_pref_value", 0));
            }
        }.execute(new Void[0]);
    }

    public void onPause() {
        super.onPause();
        if (this.O0000ooo) {
            goq.O000000o(new Runnable() {
                /* class com.xiaomi.smarthome.miio.ir.IRV2ControllerMiActivity.AnonymousClass2 */

                public final void run() {
                    SharedPreferences.Editor edit = CommonApplication.getAppContext().getSharedPreferences("use_mode_shared_pref", 0).edit();
                    edit.putInt("use_mode_shared_pref_value", IRV2ControllerMiActivity.this.mUseMode);
                    edit.apply();
                }
            });
        }
    }

    public void onGestureStarted(GestureOverlayView gestureOverlayView, MotionEvent motionEvent) {
        this.O0000Oo0 = false;
        this.O0000OOo = true;
        this.O0000Oo = new PointF(motionEvent.getX(), motionEvent.getY());
        PointF pointF = this.O0000Oo;
        this.O0000OoO = pointF;
        this.O0000oO0 = pointF;
        this.O0000O0o = 0;
        this.O0000Ooo = gestureOverlayView;
        float x = motionEvent.getX() - ((float) (getResources().getDimensionPixelSize(gestureOverlayView == this.O0000o0O ? R.dimen.irv2_touch_hint_width : R.dimen.irv2_touch_hint_height) / 2));
        float y = motionEvent.getY() - ((float) (getResources().getDimensionPixelSize(R.dimen.irv2_touch_hint_height) / 2));
        ImageView imageView = gestureOverlayView == this.O0000o0O ? this.O0000o0o : this.O0000o0;
        if (Build.VERSION.SDK_INT >= 11) {
            imageView.setX(x);
            imageView.setY(y);
        }
        imageView.setImageResource(gestureOverlayView == this.O0000o0O ? R.drawable.irv2_touch_vol_hint : R.drawable.irv2_touch_direction_hint);
        if (imageView.getVisibility() != 0) {
            imageView.setVisibility(0);
        }
        if (imageView == this.mViewToHide) {
            this.O0000oO.removeCallbacks(this.O0000oOO);
        }
        VelocityTracker velocityTracker = this.O0000oo0;
        if (velocityTracker == null) {
            this.O0000oo0 = VelocityTracker.obtain();
        } else {
            velocityTracker.clear();
        }
        VelocityTracker velocityTracker2 = this.O0000oo0;
        if (velocityTracker2 != null) {
            velocityTracker2.addMovement(motionEvent);
            this.O0000oo = motionEvent.getPointerId(0);
        }
    }

    public void onGesture(GestureOverlayView gestureOverlayView, MotionEvent motionEvent) {
        if (this.O0000OOo) {
            O000000o(motionEvent);
            if (gestureOverlayView == this.O0000o0O) {
                O00000Oo(motionEvent);
            } else if (gestureOverlayView == this.O0000o00) {
                O000000o(true);
            }
            VelocityTracker velocityTracker = this.O0000oo0;
            if (velocityTracker != null) {
                velocityTracker.addMovement(motionEvent);
            }
        }
    }

    public void onGestureEnded(GestureOverlayView gestureOverlayView, MotionEvent motionEvent) {
        VelocityTracker velocityTracker = this.O0000oo0;
        if (velocityTracker != null) {
            velocityTracker.addMovement(motionEvent);
            this.O0000oo0.computeCurrentVelocity(1000, (float) ViewConfiguration.get(this).getScaledMaximumFlingVelocity());
        }
        if (this.O0000OOo) {
            O000000o(motionEvent);
            this.O0000OOo = false;
            if (this.O0000O0o != 0) {
                this.O0000Oo0 = true;
            }
            if (gestureOverlayView == this.O0000o00) {
                O000000o(false);
                O000000o(this.O0000o0);
            } else if (gestureOverlayView == this.O0000o0O) {
                O00000Oo(motionEvent);
                O000000o(this.O0000o0o);
            }
        }
        VelocityTracker velocityTracker2 = this.O0000oo0;
        if (velocityTracker2 != null) {
            velocityTracker2.clear();
            this.O0000oo0.recycle();
            this.O0000oo0 = null;
        }
    }

    public void onGestureCancelled(GestureOverlayView gestureOverlayView, MotionEvent motionEvent) {
        this.O0000OOo = false;
    }

    private boolean O000000o(MotionEvent motionEvent) {
        PointF pointF = new PointF(motionEvent.getX(), motionEvent.getY());
        float f = pointF.x - this.O0000OoO.x;
        float f2 = pointF.y - this.O0000OoO.y;
        if (Math.sqrt((double) ((f * f) + (f2 * f2))) < 10.0d) {
            return true;
        }
        int i = Math.abs(f) > Math.abs(f2) ? f > 0.0f ? 4 : 3 : f2 > 0.0f ? 2 : 1;
        if (this.O0000O0o == 0) {
            this.O0000O0o = i;
        }
        if (this.O0000O0o != i) {
            this.O0000O0o = i;
        }
        this.O0000OoO = pointF;
        return true;
    }

    public void onClick(View view) {
        RadioButton radioButton = this.O00000o;
        int i = 0;
        if (view != radioButton) {
            RadioButton radioButton2 = this.O00000o0;
            if (view == radioButton2) {
                if (this.mUseMode != 1) {
                    O000000o(radioButton, R.string.irv2_controller_switch_advance, radioButton2, R.string.irv2_controller_switch_traditional_u, this.O00000oo, this.O00000oO);
                    this.mUseMode = 1;
                    this.O0000ooo = true;
                }
            } else if (view == this.O0000o00) {
                if (!this.O0000Oo0) {
                    sendKey(this, "ok");
                }
            } else if (view == this.O0000ooO) {
                finish();
            } else {
                while (i < this.f9720O000000o.size() && view != this.f9720O000000o.get(i)) {
                    i++;
                }
                if (i < this.f9720O000000o.size()) {
                    sendKey(this, this.O00000Oo.get(i));
                }
            }
        } else if (this.mUseMode != 0) {
            O000000o(this.O00000o0, R.string.irv2_controller_switch_traditional, radioButton, R.string.irv2_controller_switch_advance_u, this.O00000oO, this.O00000oo);
            this.mUseMode = 0;
            this.O0000ooo = true;
        }
    }

    private void O000000o(boolean z) {
        String str;
        int i = this.O0000O0o;
        if (i == 1) {
            this.O0000o0.setImageResource(R.drawable.irv2_touch_direction_up);
            str = "up";
        } else if (i == 2) {
            this.O0000o0.setImageResource(R.drawable.irv2_touch_direction_down);
            str = "down";
        } else if (i == 3) {
            this.O0000o0.setImageResource(R.drawable.irv2_touch_direction_left);
            str = "left";
        } else if (i != 4) {
            str = "";
        } else {
            this.O0000o0.setImageResource(R.drawable.irv2_touch_direction_right);
            str = "right";
        }
        if (!z && !str.isEmpty()) {
            sendKey(this, str);
        }
    }

    private void O00000Oo(MotionEvent motionEvent) {
        String str;
        if (this.O0000o == 0) {
            this.O0000o = this.O0000o0O.getHeight() / 100;
        }
        int abs = (int) Math.abs(motionEvent.getY() - this.O0000oO0.y);
        if (abs >= this.O0000o) {
            this.O0000oO0 = new PointF(motionEvent.getX(), motionEvent.getY());
        }
        int i = this.O0000O0o;
        if (i == 1) {
            this.O0000o0o.setImageResource(R.drawable.irv2_touch_vol_up);
            str = "vol+";
        } else if (i != 2) {
            str = "";
        } else {
            this.O0000o0o.setImageResource(R.drawable.irv2_touch_vol_down);
            str = "vol-";
        }
        if (!str.isEmpty() && abs >= this.O0000o) {
            sendKey(this, str);
            VelocityTracker velocityTracker = this.O0000oo0;
            if (velocityTracker != null) {
                int O000000o2 = (((int) O000000o((int) velocityTracker.getYVelocity(this.O0000oo))) * 3) / getWindowManager().getDefaultDisplay().getHeight();
                for (int i2 = 0; i2 < O000000o2; i2++) {
                    sendKey(this, str);
                }
            }
        }
    }

    private void O000000o(final View view) {
        this.mViewToHide = view;
        this.O0000oOO = new Runnable() {
            /* class com.xiaomi.smarthome.miio.ir.IRV2ControllerMiActivity.AnonymousClass1 */

            public final void run() {
                if (view.getVisibility() != 4) {
                    view.setVisibility(4);
                    IRV2ControllerMiActivity.this.mViewToHide = null;
                }
            }
        };
        this.O0000oO.postDelayed(this.O0000oOO, 300);
    }

    public boolean onLongClick(View view) {
        if (view != this.O0000o00) {
            return false;
        }
        this.O0000OOo = false;
        O000000o(this.O0000o0);
        sendKey(this, "back");
        return true;
    }

    private double O000000o(int i) {
        float scrollFriction = ViewConfiguration.getScrollFriction() * getResources().getDisplayMetrics().density * 160.0f * 386.0878f * 0.84f;
        double log = Math.log((double) ((((float) Math.abs(i)) * 0.35f) / scrollFriction));
        float f = O0000oOo;
        double d = (double) f;
        Double.isNaN(d);
        double d2 = (double) scrollFriction;
        double d3 = (double) f;
        Double.isNaN(d3);
        double exp = Math.exp((d3 / (d - 1.0d)) * log);
        Double.isNaN(d2);
        return d2 * exp;
    }

    private static void O000000o(RadioButton radioButton, int i, RadioButton radioButton2, int i2, View view, View view2) {
        radioButton.setChecked(false);
        radioButton.setText(i);
        radioButton2.setChecked(true);
        radioButton2.setText(i2);
        if (view.getVisibility() != 8) {
            view.setVisibility(8);
        }
        if (view2.getVisibility() != 0) {
            view2.setVisibility(0);
        }
    }

    public static String getCode(String str) {
        if (str.equals("power")) {
            return "Z6VIAEwCAADxAwAAvgUAAAsqAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAABACAgACAAIAAgIDABACAgACAAIAAgIDABACAgACAAIAAgIDA=";
        }
        if (str.equals("left")) {
            return "Z6VIAEwCAAByAwAA8QMAAJgEAAC+BQAA7zAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAACMAAQMAAAMEAQEFACMAAQMAAAMEAQEFACMAAQMAAAMEAQEFA=";
        }
        if (str.equals("right")) {
            return "Z6VIAEwCAAByAwAA8QMAAJgEAAC+BQAAOzMAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAACMAAQMAAAQAAAMFACMAAQMAAAQAAAMFACMAAQMAAAQAAAMFA=";
        }
        if (str.equals("up")) {
            return "Z6VIAEwCAAByAwAA8QMAAJgEAAC+BQAArTYAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAACMAAQMAAAEBAwQFACMAAQMAAAEBAwQFACMAAQMAAAEBAwQFA=";
        }
        if (str.equals("down")) {
            return "Z6VIAEwCAAByAwAA8QMAAJgEAAA7MwAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAACMAAQMAAAEDAwAEACMAAQMAAAEDAwAEACMAAQMAAAEDAwAEA=";
        }
        if (str.equals("ok")) {
            return "Z6VIAEwCAAByAwAA8QMAAJgEAAC+BQAA7zAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAACMAAQMAAAQBAAQFACMAAQMAAAQBAAQFACMAAQMAAAQBAAQFA=";
        }
        if (str.equals("menu")) {
            return "Z6VIAEwCAAByAwAA8QMAAJgEAAA7MwAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAACMAAQMAAAEAAwMEACMAAQMAAAEAAwMEACMAAQMAAAEAAwMEA= ";
        }
        if (str.equals("home")) {
            return "Z6VIAEwCAAByAwAA8QMAAJgEAAA7MwAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAACMAAQMAAAMAAQMEACMAAQMAAAMAAQMEACMAAQMAAAMAAQMEA=";
        }
        if (str.equals("back")) {
            return "Z6VIAEwCAAByAwAA8QMAAJgEAAC+BQAA7zAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAACMAAQMAAAEEAwEFACMAAQMAAAEEAwEFACMAAQMAAAEEAwEFA=";
        }
        if (str.equals("vol+")) {
            return "Z6VIAEwCAAByAwAA8QMAAJgEAAC+BQAAOzMAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAACMAAQMAAAQDAAAFACMAAQMAAAQDAAAFACMAAQMAAAQDAAAFA=";
        }
        return str.equals("vol-") ? "Z6VIAEwCAAByAwAA8QMAAJgEAAC+BQAA7zAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAACMAAQMAAAQEAAEFACMAAQMAAAQEAAEFACMAAQMAAAQEAAEFA=" : "";
    }

    public static void sendKey(Context context, String str) {
        ((ConsumerIrManager) context.getSystemService("consumer_ir")).transmit(37920, ByteBuffer.wrap(grs.O000000o(getCode(str))).order(ByteOrder.LITTLE_ENDIAN).asIntBuffer().array());
    }

    public void setUseMode(int i) {
        int i2;
        if (!isFinishing() && (i2 = this.mUseMode) != i) {
            if (i2 == 0) {
                O000000o(this.O00000o, R.string.irv2_controller_switch_advance, this.O00000o0, R.string.irv2_controller_switch_traditional_u, this.O00000oo, this.O00000oO);
            } else {
                O000000o(this.O00000o0, R.string.irv2_controller_switch_traditional, this.O00000o, R.string.irv2_controller_switch_advance_u, this.O00000oO, this.O00000oo);
            }
            this.mUseMode = i;
        }
    }
}
