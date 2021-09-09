package com.xiaomi.smarthome.newui.card.profile;

import _m_j.gpc;
import _m_j.hbx;
import _m_j.hcx;
import _m_j.hdv;
import _m_j.hem;
import _m_j.hfj;
import _m_j.hfl;
import _m_j.hfn;
import _m_j.hfo;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.newui.card.BrightIndicateView;
import com.xiaomi.smarthome.newui.card.FlowItemMode;
import com.xiaomi.smarthome.newui.card.ProductModel;
import com.xiaomi.smarthome.newui.card.profile.TouchView;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class YeelightControlView extends RelativeLayout {
    private static final String O000OO = "YeelightControlView";

    /* renamed from: O000000o  reason: collision with root package name */
    public ImageView f10230O000000o;
    public ProductModel O00000Oo;
    public TouchView O00000o;
    public RelativeLayout O00000o0;
    public ImageView O00000oO;
    public int O00000oo = 2000;
    hfj O0000O0o;
    public View O0000OOo;
    public Bitmap O0000Oo;
    public View O0000Oo0;
    protected int O0000OoO;
    protected int O0000Ooo;
    public float O0000o = 0.0f;
    public TouchDirection O0000o0;
    public boolean O0000o00 = false;
    public GestureDetector O0000o0O;
    public float O0000o0o = 0.0f;
    public int O0000oO;
    public boolean O0000oO0 = false;
    public int O0000oOO;
    public int O0000oOo;
    public int O0000oo;
    public int O0000oo0;
    public int O0000ooO;
    public int[] O0000ooo;
    Animation O000O00o = AnimationUtils.loadAnimation(getContext(), R.anim.control_view_alpha_out);
    Animation O000O0OO = AnimationUtils.loadAnimation(getContext(), R.anim.control_view_out_from_top);
    Animation O000O0Oo = AnimationUtils.loadAnimation(getContext(), R.anim.control_view_out_from_bottom);
    public O000000o O000O0o;
    Animation O000O0o0 = AnimationUtils.loadAnimation(getContext(), R.anim.control_view_in_from_bottom);
    public Handler O000O0oO = new Handler(Looper.getMainLooper()) {
        /* class com.xiaomi.smarthome.newui.card.profile.YeelightControlView.AnonymousClass4 */
    };
    public Timer O000O0oo;
    public O00000o O000OO00;
    public Runnable O000OO0o = new Runnable() {
        /* class com.xiaomi.smarthome.newui.card.profile.YeelightControlView.AnonymousClass5 */

        public final void run() {
            YeelightControlView.this.O00000oO();
            YeelightControlView.this.O0000o0 = TouchDirection.NAN;
        }
    };
    private int O000OOOo;
    private int O000OOo = 0;
    private int O000OOo0;
    private FrameLayout O000OOoO;
    private Button O000OOoo;
    private LinearLayout O000Oo0;
    private FrameLayout O000Oo00;
    private LinearLayout O000Oo0O;
    private ImageView O000Oo0o;
    private BrightIndicateView O000OoO;
    private SeekBar O000OoO0;
    private boolean O000OoOO = false;
    private AnimationDrawable O000OoOo;
    private TimerTask O000Ooo;
    private Timer O000Ooo0;
    private TimerTask O000OooO;
    private hfj O000Oooo;
    private Uri O000o;
    private float O000o0 = 0.0f;
    private hfj O000o00;
    private hfj O000o000;
    private float O000o00O = 0.0f;
    private float O000o00o = 0.0f;
    private float[] O000o0O = new float[3];
    private float O000o0O0 = 0.0f;
    private boolean O000o0OO;
    private int O000o0Oo;
    private boolean O000o0o = false;
    private boolean O000o0o0 = false;
    private boolean O000o0oo = false;
    private Activity O000oO00;
    private ImageView O00O0Oo;
    Animation O00oOoOo = AnimationUtils.loadAnimation(getContext(), R.anim.control_view_in_from_top);
    public boolean O00oOooO = false;
    Animation O00oOooo = AnimationUtils.loadAnimation(getContext(), R.anim.control_view_alpha_in);

    public interface O000000o {
        void O000000o(int i);

        void O00000Oo(int i);
    }

    public enum TouchDirection {
        NAN,
        HORIZONTAL,
        VERTICAL
    }

    public YeelightControlView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        O000000o(context);
    }

    public YeelightControlView(Context context) {
        super(context);
        O000000o(context);
    }

    public void setProductModel(ProductModel productModel) {
        int O00000o02 = productModel.O00000o0();
        int O00000o2 = productModel.O00000o();
        this.O00000Oo = productModel;
        this.O000OOOo = O00000o02;
        this.O000OOo0 = O00000o2;
        if (productModel.O00000Oo() && !this.O000o0oo) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.O000Oo0O.getLayoutParams();
            layoutParams.topMargin = gpc.O000000o(80.0f);
            layoutParams.leftMargin = gpc.O000000o(47.0f);
            layoutParams.rightMargin = gpc.O000000o(47.0f);
            this.O000Oo0O.setLayoutParams(layoutParams);
        }
        this.O000OoO.O00000Oo();
    }

    public synchronized hdv getLightState() {
        hdv hdv;
        hdv = null;
        if (this.O0000oO != 0) {
            hdv = new hdv(this.O0000oO == 1 ? "off" : "on", this.O000o0Oo, getBright(), this.O0000oo, this.O0000ooO, this.O000o0OO, (byte) 0);
            if (this.O0000oO == 6) {
                hdv.O00000oO = true;
                hdv.O00000o0 = 2700;
            }
        }
        return hdv;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0018, code lost:
        if (r12.equals(r0) == false) goto L_0x001a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x018c, code lost:
        return;
     */
    public final synchronized void O000000o(hdv hdv) {
        int i;
        int[] iArr;
        int i2;
        hdv lightState = getLightState();
        if (this.O0000oO != 1 || !hdv.O000000o()) {
            if (lightState != null) {
            }
            this.O000o0Oo = hdv.O00000Oo();
            this.O000o0OO = hdv.O00000o;
            this.O0000oOO = hdv.f18823O000000o;
            if (hdv.O00000Oo == 0) {
                i = this.O0000oo0;
            } else {
                i = hdv.O00000Oo;
            }
            this.O0000oo0 = i;
            this.O0000oOo = this.O0000oOO;
            this.O0000oo = hdv.O00000o0;
            this.O0000ooO = hdv.O00000o0();
            if (!this.O00000Oo.O000000o(ProductModel.CapabilityType.CONTROL_CT_H)) {
                this.O0000oo = 4000;
            }
            if (!this.O00000Oo.O000000o(ProductModel.CapabilityType.BTN_COLOR)) {
                this.O000o0Oo = 2;
            }
            if (!this.O00000Oo.O000000o(ProductModel.CapabilityType.BTN_FLOW)) {
                this.O000o0OO = false;
            }
            if (hdv.O00000oo != null) {
                hbx hbx = hdv.O00000oo;
                ArrayList arrayList = new ArrayList();
                for (hcx next : hbx.f18765O000000o) {
                    if (next.O00000Oo == FlowItemMode.FLOW_MODE_COLOR) {
                        arrayList.add(Integer.valueOf(next.O00000o0));
                    }
                }
                if (arrayList.isEmpty()) {
                    iArr = null;
                } else {
                    iArr = new int[arrayList.size()];
                    for (int i3 = 0; i3 < arrayList.size(); i3++) {
                        iArr[i3] = ((Integer) arrayList.get(i3)).intValue();
                    }
                }
                this.O0000ooo = iArr;
                if (hdv.O00000oo.f18765O000000o != null) {
                    if (!hdv.O00000oo.f18765O000000o.isEmpty()) {
                        i2 = hdv.O00000oo.f18765O000000o.get(0).O00000o;
                        this.O0000oOo = i2;
                        if (hdv.O00000oo.f18765O000000o != null && !hdv.O00000oo.f18765O000000o.isEmpty()) {
                            this.O00000oo = hdv.O00000oo.f18765O000000o.get(0).f18795O000000o;
                        }
                    }
                }
                i2 = this.O0000oOO;
                this.O0000oOo = i2;
                this.O00000oo = hdv.O00000oo.f18765O000000o.get(0).f18795O000000o;
            }
            if (this.O0000ooo == null) {
                this.O0000ooo = new int[4];
                float O000000o2 = hem.O000000o(this.O0000oOO);
                float[] fArr = {10.0f, 1.0f, O000000o2};
                this.O0000ooo[0] = Color.HSVToColor(new float[]{10.0f, 1.0f, O000000o2});
                fArr[0] = 70.0f;
                this.O0000ooo[1] = Color.HSVToColor(fArr);
                fArr[0] = 160.0f;
                this.O0000ooo[2] = Color.HSVToColor(fArr);
                fArr[0] = 270.0f;
                this.O0000ooo[3] = Color.HSVToColor(fArr);
            }
            if (hdv.O000000o()) {
                this.O0000oO = 1;
            } else if (hdv.O00000oO) {
                this.O0000oO = 6;
                this.O000OoO.setValue(this.O0000oo0);
            } else if (this.O000o0OO) {
                this.O0000oO = 4;
                this.O000OoO.setValue(this.O0000oOo);
            } else {
                if (this.O000o0Oo == 1) {
                    this.O0000oO = 3;
                } else if (this.O000o0Oo == 2) {
                    this.O0000oO = 2;
                }
                this.O000OoO.setValue(this.O0000oOO);
            }
            setModel(this.O0000oO);
        }
    }

    public void setColorsFlow(int[] iArr) {
        if (iArr != null) {
            int i = this.O0000oO;
            if (i == 4 || i == 0) {
                this.O0000oO = 4;
                O000000o(iArr);
            }
        }
    }

    public void setTitleLayout(FrameLayout frameLayout) {
        this.O000OOoO = frameLayout;
    }

    public void setTopButtonHeight(int i) {
        int i2;
        if (i == 0) {
            i2 = gpc.O000000o(70.0f);
        } else {
            i2 = i + gpc.O000000o(90.0f);
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.O000Oo0.getLayoutParams();
        marginLayoutParams.topMargin = i2;
        this.O000Oo0.setLayoutParams(marginLayoutParams);
        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.O000Oo0O.getLayoutParams();
        marginLayoutParams2.topMargin = i2;
        this.O000Oo0O.setLayoutParams(marginLayoutParams2);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        this.O0000OoO = View.MeasureSpec.getSize(i);
        this.O0000Ooo = View.MeasureSpec.getSize(i2);
        int i3 = this.O0000OoO;
        this.O000o00O = 360.0f / ((float) i3);
        this.O000o00o = (0.4f / ((float) i3)) * 2.0f;
        this.O000o0 = 0.45f / ((float) this.O0000Ooo);
        this.O000o0O0 = (float) (11000 / (this.O000OoO0.getWidth() == 0 ? 1080 : this.O000OoO0.getWidth()));
        super.onMeasure(i, i2);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, com.xiaomi.smarthome.newui.card.profile.YeelightControlView, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    private void O000000o(Context context) {
        LayoutInflater.from(context).inflate((int) R.layout.widget_control_view, (ViewGroup) this, true);
        this.O0000oO = 0;
        this.O00000o0 = (RelativeLayout) findViewById(R.id.control_root);
        this.O000OOoo = (Button) findViewById(R.id.control_button_top);
        this.O000Oo00 = (FrameLayout) findViewById(R.id.control_button_container);
        this.O00000o = (TouchView) findViewById(R.id.control_view);
        this.O000Oo0 = (LinearLayout) findViewById(R.id.control_top_flow);
        this.O000Oo0O = (LinearLayout) findViewById(R.id.control_top_colorsunshine);
        this.O00000oO = (ImageView) findViewById(R.id.control_colorpicker);
        this.O000Oo0o = (ImageView) findViewById(R.id.control_colorpointer);
        this.O000OoO0 = (SeekBar) findViewById(R.id.control_top_flow_seekbar);
        this.O00O0Oo = (ImageView) findViewById(R.id.control_top_flow_pointer);
        this.O000OoO = (BrightIndicateView) findViewById(R.id.control_bright_indicate);
        this.O0000OOo = new View(context);
        this.O0000Oo0 = new View(context);
        this.O000OOoo.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.newui.card.profile.YeelightControlView.AnonymousClass1 */

            public final void onClick(View view) {
            }
        });
        this.O0000o0 = TouchDirection.NAN;
        this.O0000o0O = new GestureDetector(context, new O00000Oo(this, (byte) 0));
        this.O0000o0O.setIsLongpressEnabled(false);
        this.O00000o.setOnTouchListener(new O00000o0(this, (byte) 0));
    }

    private void setModel(int i) {
        switch (i) {
            case 1:
                if (this.O000O0o != null) {
                    this.O000OoO.O00000Oo();
                }
                O000000o();
                O000000o(false);
                this.O00000o.setCurrentMode(TouchView.ControlMode.SWITCH);
                Drawable offMask = getOffMask();
                if (offMask == null) {
                    this.O00000o0.setBackgroundDrawable(new ColorDrawable(-16777216));
                    this.O00000o.setCurrentMode(TouchView.ControlMode.SUNSHINE);
                } else {
                    O00000Oo();
                    this.O00000o0.addView(this.O0000OOo);
                    this.O00000o0.addView(this.O0000Oo0);
                    this.O000Ooo0 = new Timer();
                    this.O000OooO = new TimerTask() {
                        /* class com.xiaomi.smarthome.newui.card.profile.YeelightControlView.AnonymousClass2 */

                        public final void run() {
                            ((Activity) YeelightControlView.this.getContext()).runOnUiThread(new Runnable() {
                                /* class com.xiaomi.smarthome.newui.card.profile.YeelightControlView.AnonymousClass2.AnonymousClass1 */

                                /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
                                 method: _m_j.hfj.O000000o(float, float):_m_j.hfj
                                 arg types: [int, int]
                                 candidates:
                                  _m_j.hfj.O000000o(int, int):void
                                  _m_j.hfj.O000000o(float, float):_m_j.hfj */
                                public final void run() {
                                    Random random = new Random();
                                    float nextFloat = ((float) (YeelightControlView.this.O0000OoO / 8)) + (((float) ((YeelightControlView.this.O0000OoO * 6) / 8)) * random.nextFloat());
                                    float nextFloat2 = ((float) (YeelightControlView.this.O0000Ooo / 5)) + (((float) ((YeelightControlView.this.O0000Ooo * 3) / 5)) * random.nextFloat());
                                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(YeelightControlView.this.O0000OoO / 80, YeelightControlView.this.O0000Ooo / 80);
                                    layoutParams.setMargins((int) nextFloat, (int) nextFloat2, 0, 0);
                                    YeelightControlView.this.O0000OOo.setLayoutParams(layoutParams);
                                    YeelightControlView yeelightControlView = YeelightControlView.this;
                                    View view = YeelightControlView.this.O0000OOo;
                                    if (yeelightControlView.O0000O0o != null) {
                                        yeelightControlView.O0000O0o.O00000o0();
                                        yeelightControlView.O0000O0o = null;
                                    }
                                    yeelightControlView.O0000O0o = new hfj((Activity) yeelightControlView.getContext());
                                    yeelightControlView.O0000O0o.O000000o(1.2f, 1.2f);
                                    hfj hfj = yeelightControlView.O0000O0o;
                                    hfj.O0000Oo.add(new hfn(hfj.O0000OoO * 0.0f, hfj.O0000OoO * 0.0f));
                                    yeelightControlView.O0000O0o.O0000Oo.add(new hfl(0.0f, 0.0f));
                                    hfj hfj2 = yeelightControlView.O0000O0o;
                                    hfj2.O0000Oo0.add(new hfo(hfj2.O00000o - 300, hfj2.O00000o, new AccelerateDecelerateInterpolator()));
                                    yeelightControlView.O0000O0o.O000000o(view, 1, new LinearInterpolator());
                                }
                            });
                        }
                    };
                    this.O000Ooo0.schedule(this.O000OooO, 0, 2000);
                    this.O000Ooo = new TimerTask() {
                        /* class com.xiaomi.smarthome.newui.card.profile.YeelightControlView.AnonymousClass3 */

                        public final void run() {
                            ((Activity) YeelightControlView.this.getContext()).runOnUiThread(new Runnable() {
                                /* class com.xiaomi.smarthome.newui.card.profile.YeelightControlView.AnonymousClass3.AnonymousClass1 */

                                public final void run() {
                                    Random random = new Random();
                                    float nextFloat = ((float) (YeelightControlView.this.O0000OoO / 2)) + (((float) ((YeelightControlView.this.O0000OoO * 1) / 3)) * random.nextFloat());
                                    float nextFloat2 = ((float) (YeelightControlView.this.O0000Ooo / 6)) + (((float) ((YeelightControlView.this.O0000Ooo * 1) / 2)) * random.nextFloat());
                                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(YeelightControlView.this.O0000OoO / 80, YeelightControlView.this.O0000Ooo / 80);
                                    layoutParams.setMargins((int) nextFloat, (int) nextFloat2, 0, 0);
                                    YeelightControlView.this.O0000Oo0.setLayoutParams(layoutParams);
                                }
                            });
                        }
                    };
                    this.O000Ooo0.schedule(this.O000Ooo, 2000, 6000);
                    this.O00000o0.setBackgroundDrawable(offMask);
                }
                this.O0000oO = 1;
                if (this.O0000o00) {
                    this.O0000o00 = false;
                    O00000oO();
                    O00000o0();
                    O00000o();
                    return;
                }
                return;
            case 2:
                if (this.O000O0o != null) {
                    if (!this.O00000Oo.O000000o().equals("yeelink.light.ceiling5") || !this.O00000Oo.O000000o().equals("yeelink.light.color3")) {
                        this.O000OoO.O000000o();
                    } else {
                        this.O000OoO.O00000Oo();
                    }
                }
                setSunshineMode(false);
                return;
            case 3:
                if (this.O000O0o != null) {
                    this.O000OoO.O00000Oo();
                }
                O00000Oo();
                O000000o();
                O000000o(false);
                this.O00000o.setCurrentMode(TouchView.ControlMode.COLOR);
                this.O00000o0.setBackgroundDrawable(null);
                Color.colorToHSV(this.O0000ooO, this.O000o0O);
                this.O000o0O[2] = hem.O000000o(this.O0000oOO);
                this.O00000o0.setBackgroundColor(Color.HSVToColor(this.O000o0O));
                this.O00000o.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.bg_fade_in));
                this.O0000oO = 3;
                this.O000o0Oo = 1;
                this.O000o0OO = false;
                this.O000OoO.setValue(this.O0000oOO);
                return;
            case 4:
                if (this.O000O0o != null) {
                    this.O000OoO.O00000Oo();
                }
                O00000Oo();
                O000000o(true);
                this.O00000o.setCurrentMode(TouchView.ControlMode.COLORFLOW);
                this.O00000o0.setBackgroundDrawable(null);
                this.O00000o.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.bg_fade_in));
                this.O0000oO = 4;
                this.O000o0O[2] = hem.O000000o(this.O0000oOo);
                this.O000o0OO = true;
                O000000o(this.O0000ooo);
                this.O000OoO.setValue(this.O0000oOo);
                O000000o(this.O00000oo);
                return;
            case 5:
                if (this.O000O0o != null) {
                    this.O000OoO.O000000o();
                }
                setSunshineMode(true);
                return;
            case 6:
                if (this.O000O0o != null) {
                    if (!this.O00000Oo.O000000o().equals("yeelink.light.ceiling5")) {
                        this.O000OoO.O000000o();
                    } else {
                        this.O000OoO.O00000Oo();
                    }
                }
                O00000Oo();
                O000000o();
                O000000o(false);
                this.O00000o.setCurrentMode(TouchView.ControlMode.NIGHTLIGHT);
                this.O00000o0.setBackgroundDrawable(null);
                float[] fArr = this.O000o0O;
                fArr[0] = 35.0f;
                fArr[1] = hem.O000000o(2700, this.O000OOOo, this.O000OOo0);
                this.O000o0O[2] = hem.O000000o(this.O0000oo0);
                this.O00000o0.setBackgroundColor(Color.HSVToColor(this.O000o0O));
                this.O0000oO = 6;
                this.O000o0OO = false;
                this.O000OoO.setValue(this.O0000oo0);
                if (this.O00oOooO) {
                    this.f10230O000000o.setVisibility(0);
                    return;
                } else {
                    this.f10230O000000o.setVisibility(8);
                    return;
                }
            default:
                return;
        }
    }

    private void setSunshineMode(boolean z) {
        O00000Oo();
        O000000o();
        O000000o(false);
        this.O00000o.setCurrentMode(TouchView.ControlMode.SUNSHINE);
        this.O00000o0.setBackgroundDrawable(null);
        float[] fArr = this.O000o0O;
        fArr[0] = 35.0f;
        fArr[1] = hem.O000000o(this.O0000oo, this.O000OOOo, this.O000OOo0);
        this.O000o0O[2] = hem.O000000o(this.O0000oOO);
        this.O00000o0.setBackgroundColor(Color.HSVToColor(this.O000o0O));
        this.O0000oO = z ? 5 : 2;
        this.O000o0Oo = 2;
        this.O000o0OO = false;
        this.O000OoO.setValue(this.O0000oOO);
    }

    public final void O000000o(int[] iArr) {
        if (iArr != null) {
            int[] iArr2 = new int[iArr.length];
            for (int i = 0; i < iArr.length; i++) {
                float[] fArr = new float[3];
                Color.colorToHSV(iArr[i], fArr);
                fArr[2] = hem.O000000o(this.O0000oOo);
                iArr2[i] = Color.HSVToColor(fArr);
            }
            AnimationDrawable animationDrawable = this.O000OoOo;
            if (animationDrawable != null) {
                animationDrawable.stop();
            }
            this.O000OoOo = new AnimationDrawable();
            for (int i2 = 0; i2 < iArr.length; i2++) {
                this.O000OoOo.addFrame(new ColorDrawable(iArr2[i2]), this.O00000oo);
            }
            this.O00000o0.setBackgroundDrawable(this.O000OoOo);
            this.O000OoOo.setEnterFadeDuration(this.O00000oo / 2);
            this.O000OoOo.setExitFadeDuration(this.O00000oo / 2);
            this.O000OoOo.setOneShot(false);
            this.O000OoOo.start();
            this.O0000ooo = iArr;
        }
    }

    public final void O000000o() {
        AnimationDrawable animationDrawable = this.O000OoOo;
        if (animationDrawable != null) {
            animationDrawable.stop();
            this.O00000o0.setBackgroundDrawable(null);
            this.O000OoOo = null;
        }
    }

    public final void O00000Oo() {
        TimerTask timerTask = this.O000Ooo;
        if (timerTask != null) {
            timerTask.cancel();
            this.O000Ooo = null;
        }
        TimerTask timerTask2 = this.O000OooO;
        if (timerTask2 != null) {
            timerTask2.cancel();
            this.O000OooO = null;
        }
        Timer timer = this.O000Ooo0;
        if (timer != null) {
            timer.cancel();
            this.O000Ooo0 = null;
        }
        O00000oo();
        O0000O0o();
        this.O00000o0.removeView(this.O0000OOo);
        this.O00000o0.removeView(this.O0000Oo0);
    }

    private void O00000oo() {
        hfj hfj = this.O0000O0o;
        if (hfj != null) {
            hfj.O00000o0();
            this.O0000O0o = null;
        }
    }

    private void O0000O0o() {
        hfj hfj = this.O000Oooo;
        if (hfj != null) {
            hfj.O00000o0();
            this.O000Oooo = null;
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.hfj.O000000o(float, float):_m_j.hfj
     arg types: [int, int]
     candidates:
      _m_j.hfj.O000000o(int, int):void
      _m_j.hfj.O000000o(float, float):_m_j.hfj */
    public final void O000000o(MotionEvent motionEvent) {
        if (this.O000o000 != null) {
            float y = motionEvent.getY() / ((float) this.O0000Ooo);
            float f = 0.3f - ((y * y) * 7.0f);
            this.O000o000.O000000o(f, 0.8f);
            Random random = new Random();
            float y2 = motionEvent.getY();
            float f2 = (float) this.O0000Ooo;
            if (random.nextFloat() > (((y2 - f2) * 0.9f) / (300.0f - f2)) + 0.1f) {
                this.O000o000.O000000o(f, 0.8f);
            } else {
                this.O000o000.O000000o(0.0f, 0.0f);
            }
            this.O000o000.O000000o((int) motionEvent.getRawX(), (int) motionEvent.getRawY());
        }
    }

    public final void O00000Oo(MotionEvent motionEvent) {
        if (this.O000o00 != null) {
            float y = motionEvent.getY() / ((float) this.O0000Ooo);
            this.O000o00.O000000o(1.4f - ((y * y) * 7.0f), 1.7f);
            this.O000o00.O000000o((int) motionEvent.getRawX(), (int) motionEvent.getRawY());
        }
    }

    public final void O00000o0() {
        hfj hfj = this.O000o000;
        if (hfj != null) {
            hfj.O00000Oo();
            this.O000o000.O00000o0();
            this.O000o000 = null;
        }
    }

    public final void O00000o() {
        hfj hfj = this.O000o00;
        if (hfj != null) {
            hfj.O00000Oo();
            this.O000o00.O00000o0();
            this.O000o00 = null;
        }
    }

    public final void O000000o(TouchDirection touchDirection) {
        if (!this.O0000o00) {
            if (touchDirection != TouchDirection.NAN && this.O000OoOO) {
                TouchDirection touchDirection2 = this.O0000o0;
                if (touchDirection2 != touchDirection) {
                    if (touchDirection2 == TouchDirection.HORIZONTAL) {
                        this.O000OoO.startAnimation(this.O000O00o);
                        if (this.O0000oO == 4) {
                            this.O000OOoo.clearAnimation();
                            this.O000OOoo.setVisibility(4);
                            this.O000Oo0.startAnimation(this.O00oOooo);
                        } else {
                            this.O000Oo0O.startAnimation(this.O00oOooo);
                        }
                    } else {
                        this.O000OoO.startAnimation(this.O00oOooo);
                        if (this.O0000oO == 4) {
                            this.O000OOoo.clearAnimation();
                            this.O000OOoo.setVisibility(4);
                            this.O000Oo0.startAnimation(this.O000O00o);
                        } else {
                            this.O000Oo0O.startAnimation(this.O000O00o);
                        }
                    }
                }
            } else if (this.O0000o0 != TouchDirection.HORIZONTAL) {
                if (this.O0000oO == 4) {
                    this.O000Oo0.clearAnimation();
                    this.O000Oo0.setVisibility(4);
                    this.O000OOoo.startAnimation(this.O000O00o);
                }
                this.O000OoO.startAnimation(this.O00oOooo);
            } else if (this.O0000oO == 4) {
                this.O000OoO.clearAnimation();
                this.O000OoO.setVisibility(4);
                this.O000OOoo.startAnimation(this.O000O00o);
                this.O000Oo0.startAnimation(this.O00oOooo);
            } else {
                this.O000Oo0O.startAnimation(this.O00oOooo);
            }
            this.O000OoOO = true;
        }
    }

    public final void O00000oO() {
        if (!this.O0000o00 || this.O000OoOO) {
            if (this.O0000oO == 4) {
                this.O000OOoo.startAnimation(this.O00oOooo);
            }
            if (this.O0000o0 == TouchDirection.HORIZONTAL) {
                if (this.O0000oO == 4) {
                    this.O000Oo0.startAnimation(this.O000O00o);
                } else {
                    this.O000Oo0O.startAnimation(this.O000O00o);
                }
                this.O000OoO.clearAnimation();
            } else {
                if (this.O0000oO == 4) {
                    this.O000Oo0.clearAnimation();
                } else {
                    this.O000Oo0O.clearAnimation();
                }
                this.O000OoO.startAnimation(this.O000O00o);
            }
            this.O0000o0 = TouchDirection.NAN;
            this.O000OoOO = false;
            this.O00000o.O000000o();
        }
    }

    private void O000000o(boolean z) {
        if (!this.O0000o00) {
            this.O000OOoo.clearAnimation();
            this.O000Oo0.clearAnimation();
            this.O000Oo0O.clearAnimation();
            this.O000OoO.clearAnimation();
            this.O000Oo0.setVisibility(4);
            this.O000Oo0O.setVisibility(4);
            this.O000OoO.setVisibility(4);
            if (z) {
                this.O000OOoo.setVisibility(0);
            } else {
                this.O000OOoo.setVisibility(4);
            }
        }
    }

    public final void O000000o(float f) {
        float f2 = 0.0f - f;
        float[] fArr = this.O000o0O;
        fArr[2] = fArr[2] + (this.O000o0 * f2);
        if (fArr[2] > 0.95f) {
            fArr[2] = 0.95f;
        }
        float[] fArr2 = this.O000o0O;
        if (fArr2[2] < 0.5f) {
            fArr2[2] = 0.5f;
        }
        int i = this.O0000oO;
        if (i == 2) {
            float[] fArr3 = this.O000o0O;
            O000000o(35.0f, fArr3[1], fArr3[2]);
        } else if (i == 3) {
            float[] fArr4 = this.O000o0O;
            O000000o(fArr4[0], 0.8f, fArr4[2]);
        } else if (i == 6) {
            float[] fArr5 = this.O000o0O;
            O000000o(35.0f, fArr5[1], fArr5[2]);
        }
        int i2 = (int) (((this.O000o0O[2] - 0.5f) / 0.45f) * 100.0f);
        if (i2 <= 0) {
            i2 = 1;
        }
        if (i2 > 100) {
            i2 = 100;
        }
        int i3 = this.O0000oO;
        if (i3 == 4) {
            this.O0000oOo = i2;
        } else if (i3 == 6) {
            this.O0000oo0 = i2;
        } else {
            this.O0000oOO = i2;
        }
        this.O000OoO.setValue(i2);
    }

    public final boolean O000000o(float f, boolean z) {
        int i;
        if (z) {
            float[] fArr = this.O000o0O;
            fArr[1] = fArr[1] - (this.O000o00o * f);
        } else {
            float[] fArr2 = this.O000o0O;
            fArr2[1] = fArr2[1] + (this.O000o00o * f);
        }
        float[] fArr3 = this.O000o0O;
        if (fArr3[1] > 0.8f) {
            fArr3[1] = 0.8f - (fArr3[1] - 0.8f);
            z = !z;
        }
        float[] fArr4 = this.O000o0O;
        if (fArr4[1] < 0.4f) {
            fArr4[1] = (0.4f - fArr4[1]) + 0.4f;
            z = !z;
        }
        float[] fArr5 = this.O000o0O;
        O000000o(35.0f, fArr5[1], fArr5[2]);
        this.O00000o.setCircleRadio(TouchDirection.HORIZONTAL);
        float f2 = this.O000o0O[1];
        int i2 = this.O000OOOo;
        int i3 = this.O000OOo0;
        if (f2 < 0.4f) {
            f2 = 0.4f;
        }
        if (f2 > 0.8f) {
            f2 = 0.8f;
        }
        this.O0000oo = (int) (((float) i2) + ((0.8f - f2) * (((float) (i3 - i2)) / 0.4f)));
        if (!this.O000o0o || this.O0000oo <= 4000) {
            float f3 = this.O000o0O[1];
            int width = this.O00000oO.getWidth();
            int x = (int) this.O00000oO.getX();
            if (!this.O00000oO.isShown()) {
                width = ((this.O000Oo0O.getWidth() - this.O000Oo0O.getPaddingLeft()) - this.O000Oo0O.getPaddingRight()) - (O0000OOo() * 2);
                x = O0000OOo();
            }
            int i4 = (int) (((((float) width) / 2.0f) / 0.4f) * (0.8f - f3));
            if (z) {
                i = (width / 2) + i4;
            } else {
                i = (width / 2) - i4;
            }
            double d = (double) this.O0000OoO;
            Double.isNaN(d);
            int i5 = (int) (d * 0.04d);
            int i6 = (x + i) - (i5 / 2);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i5, i5);
            layoutParams.setMargins(i6, 0, 0, 0);
            this.O000Oo0o.setLayoutParams(layoutParams);
            return z;
        }
        this.O0000oo = 4000;
        if (z) {
            float[] fArr6 = this.O000o0O;
            fArr6[1] = fArr6[1] + (this.O000o00o * f);
        } else {
            float[] fArr7 = this.O000o0O;
            fArr7[1] = fArr7[1] - (this.O000o00o * f);
        }
        return z;
    }

    public final void O00000Oo(float f) {
        float[] fArr = this.O000o0O;
        fArr[0] = fArr[0] + (this.O000o00O * f);
        if (fArr[0] > 360.0f || fArr[0] == 360.0f) {
            this.O000o0O[0] = 0.0f;
        }
        float[] fArr2 = this.O000o0O;
        if (fArr2[0] < 0.0f) {
            fArr2[0] = 360.0f;
        }
        float[] fArr3 = this.O000o0O;
        O000000o(fArr3[0], 0.8f, fArr3[2]);
        this.O00000o.setCircleRadio(TouchDirection.HORIZONTAL);
        float f2 = this.O000o0O[0];
        int width = this.O00000oO.getWidth();
        int x = (int) this.O00000oO.getX();
        if (!this.O00000oO.isShown()) {
            width = ((this.O000Oo0O.getWidth() - this.O000Oo0O.getPaddingLeft()) - this.O000Oo0O.getPaddingRight()) - (O0000OOo() * 2);
            x = O0000OOo();
        }
        double d = (double) this.O0000OoO;
        Double.isNaN(d);
        int i = (int) (d * 0.04d);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i, i);
        layoutParams.setMargins((x + ((int) ((f2 / 360.0f) * ((float) width)))) - (i / 2), 0, 0, 0);
        this.O000Oo0o.setLayoutParams(layoutParams);
        this.O0000ooO = Color.HSVToColor(this.O000o0O);
    }

    private void O000000o(float f, float f2, float f3) {
        float[] fArr = this.O000o0O;
        fArr[0] = f;
        fArr[1] = f2;
        fArr[2] = f3;
        this.O00000o0.setBackgroundColor(Color.HSVToColor(fArr));
    }

    public final void O00000o0(float f) {
        this.O00000oo = (int) (((float) this.O00000oo) - (this.O000o0O0 * f));
        if (this.O00000oo > 12000) {
            this.O00000oo = 12000;
        }
        if (this.O00000oo < 1000) {
            this.O00000oo = 1000;
        }
        AnimationDrawable animationDrawable = this.O000OoOo;
        if (animationDrawable != null) {
            animationDrawable.setEnterFadeDuration(this.O00000oo / 2);
            this.O000OoOo.setExitFadeDuration(this.O00000oo / 2);
        }
        O000000o(this.O00000oo);
    }

    private void O000000o(int i) {
        double d = (double) this.O0000OoO;
        Double.isNaN(d);
        int i2 = (int) (d * 0.04d);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i2, i2);
        Rect bounds = this.O000OoO0.getProgressDrawable().getBounds();
        int i3 = (int) ((((float) (12000 - i)) / 11000.0f) * ((float) (bounds.right - bounds.left)));
        this.O000OoO0.setMax(bounds.right - bounds.left);
        this.O000OoO0.setProgress(i3);
        layoutParams.setMargins(((i3 + ((this.O000OoO0.getWidth() - (bounds.right - bounds.left)) / 2)) - (i2 / 2)) + ((int) this.O000OoO0.getX()), 0, 0, 0);
        this.O00O0Oo.setLayoutParams(layoutParams);
    }

    class O00000o0 implements View.OnTouchListener {
        private O00000o0() {
        }

        /* synthetic */ O00000o0(YeelightControlView yeelightControlView, byte b) {
            this();
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            YeelightControlView.this.O000O0oO.removeCallbacks(YeelightControlView.this.O000OO0o);
            if (YeelightControlView.this.O0000oO == 1) {
                return true;
            }
            int action = motionEvent.getAction();
            if (action == 0) {
                int i = AnonymousClass6.f10238O000000o[YeelightControlView.this.O00000o.getCurrentMode().ordinal()];
                if (i != 1 && (i == 2 || i == 3 || i == 4 || i == 5)) {
                    YeelightControlView.this.O0000o0o = motionEvent.getX();
                    YeelightControlView.this.O0000o = motionEvent.getY();
                    YeelightControlView.this.O00000o.O000000o(motionEvent.getX(), motionEvent.getY());
                    TouchView touchView = YeelightControlView.this.O00000o;
                    touchView.O00000o = 0.3f;
                    if (touchView.O00000oo != null) {
                        touchView.O00000oo.cancel();
                        touchView.O00000oo = null;
                    }
                    touchView.O00000oO = ValueAnimator.ofFloat(0.0f, touchView.O00000o);
                    touchView.O00000oO.setDuration(300L);
                    touchView.O00000oO.setInterpolator(new DecelerateInterpolator());
                    touchView.O00000oO.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                        /* class com.xiaomi.smarthome.newui.card.profile.TouchView.AnonymousClass1 */

                        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                            TouchView.this.O00000o = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        }
                    });
                    touchView.O00000oO.start();
                    YeelightControlView.this.O000O0oo = new Timer();
                    YeelightControlView yeelightControlView = YeelightControlView.this;
                    yeelightControlView.O000OO00 = new O00000o(yeelightControlView, (byte) 0);
                    YeelightControlView.this.O000O0oo.schedule(YeelightControlView.this.O000OO00, 0, 1000);
                }
            } else if (action == 1 || action == 3) {
                if (YeelightControlView.this.O000O0oo != null) {
                    YeelightControlView.this.O000O0oo.cancel();
                    YeelightControlView.this.O000O0oo = null;
                }
                if (YeelightControlView.this.O000OO00 != null) {
                    YeelightControlView.this.O000O0oO.postDelayed(new O00000o(YeelightControlView.this, (byte) 0), 800);
                    YeelightControlView.this.O000OO00.cancel();
                    YeelightControlView.this.O000OO00 = null;
                }
                if (YeelightControlView.this.O0000o0 == TouchDirection.NAN) {
                    YeelightControlView.this.O00000o.O000000o();
                    return true;
                }
                if (YeelightControlView.this.O00oOooO) {
                    YeelightControlView.this.getContext().getSharedPreferences("yeelight", 0).edit().putInt(YeelightControlView.this.O00000Oo.O000000o(), 1).commit();
                    YeelightControlView yeelightControlView2 = YeelightControlView.this;
                    yeelightControlView2.O00oOooO = false;
                    yeelightControlView2.f10230O000000o.setVisibility(8);
                }
                int i2 = AnonymousClass6.f10238O000000o[YeelightControlView.this.O00000o.getCurrentMode().ordinal()];
                if (i2 != 1) {
                    if (i2 == 2) {
                        YeelightControlView yeelightControlView3 = YeelightControlView.this;
                        yeelightControlView3.O000000o(yeelightControlView3.O0000ooo);
                    } else if (i2 == 3) {
                        if (YeelightControlView.this.O0000o0 == TouchDirection.HORIZONTAL) {
                            if (YeelightControlView.this.O000O0o != null && YeelightControlView.this.O00000Oo.O000000o(ProductModel.CapabilityType.CONTROL_CT_H)) {
                                YeelightControlView.this.O000O0o.O00000Oo(YeelightControlView.this.O0000oo);
                            }
                        } else if (YeelightControlView.this.O000O0o != null) {
                            YeelightControlView.this.O000O0o.O000000o(YeelightControlView.this.O0000oOO);
                        }
                        YeelightControlView.this.O00000o.O000000o();
                    } else if (i2 == 4) {
                        if (YeelightControlView.this.O0000o0 == TouchDirection.VERTICAL && YeelightControlView.this.O000O0o != null) {
                            YeelightControlView.this.O000O0o.O000000o(YeelightControlView.this.O0000oo0);
                        }
                        if (YeelightControlView.this.O0000o0 == TouchDirection.HORIZONTAL && !"yeelink.light.bslamp1".equals(YeelightControlView.this.O00000Oo.O000000o())) {
                            "yeelink.light.bslamp2".equals(YeelightControlView.this.O00000Oo.O000000o());
                        }
                        YeelightControlView.this.O00000o.O000000o();
                    } else if (i2 == 5) {
                        if (YeelightControlView.this.O0000o0 == TouchDirection.HORIZONTAL) {
                            O000000o o000000o = YeelightControlView.this.O000O0o;
                        } else if (YeelightControlView.this.O000O0o != null) {
                            YeelightControlView.this.O000O0o.O000000o(YeelightControlView.this.O0000oOO);
                        }
                    }
                    YeelightControlView.this.O00000o.O000000o();
                }
                YeelightControlView yeelightControlView4 = YeelightControlView.this;
                yeelightControlView4.O0000o00 = false;
                if (yeelightControlView4.O0000o0 != TouchDirection.HORIZONTAL) {
                    YeelightControlView.this.O000O0oO.postDelayed(YeelightControlView.this.O000OO0o, 600);
                } else if (YeelightControlView.this.O0000oO == 3 && YeelightControlView.this.O00000Oo.O000000o(ProductModel.CapabilityType.CONTROL_COLOR_H)) {
                    YeelightControlView.this.O000O0oO.postDelayed(YeelightControlView.this.O000OO0o, 600);
                } else if ((YeelightControlView.this.O0000oO == 2 || YeelightControlView.this.O0000oO == 5) && YeelightControlView.this.O00000Oo.O000000o(ProductModel.CapabilityType.CONTROL_CT_H)) {
                    YeelightControlView.this.O000O0oO.postDelayed(YeelightControlView.this.O000OO0o, 600);
                } else if (YeelightControlView.this.O0000oO == 4 && YeelightControlView.this.O00000Oo.O000000o(ProductModel.CapabilityType.CONTROL_FLOW_H)) {
                    YeelightControlView.this.O000O0oO.postDelayed(YeelightControlView.this.O000OO0o, 600);
                } else if (YeelightControlView.this.O0000oO != 6 || !"yeelink.light.bslamp1".equals(YeelightControlView.this.O00000Oo.O000000o())) {
                    YeelightControlView.this.O0000o0 = TouchDirection.NAN;
                } else {
                    YeelightControlView.this.O000O0oO.postDelayed(YeelightControlView.this.O000OO0o, 600);
                }
                YeelightControlView.this.O00000o0();
                YeelightControlView.this.O00000o();
            }
            YeelightControlView.this.O0000o0O.onTouchEvent(motionEvent);
            return true;
        }
    }

    class O00000Oo extends GestureDetector.SimpleOnGestureListener {
        private O00000Oo() {
        }

        /* synthetic */ O00000Oo(YeelightControlView yeelightControlView, byte b) {
            this();
        }

        /* JADX WARNING: Removed duplicated region for block: B:38:0x00db  */
        public final boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            if (motionEvent == null || motionEvent2 == null) {
                return super.onScroll(motionEvent, motionEvent2, f, f2);
            }
            int i = AnonymousClass6.f10238O000000o[YeelightControlView.this.O00000o.getCurrentMode().ordinal()];
            if (i != 1 && (i == 2 || i == 3 || i == 4 || i == 5)) {
                if (!YeelightControlView.this.O0000o00) {
                    TouchDirection touchDirection = YeelightControlView.this.O0000o0;
                    if (Math.abs(motionEvent2.getX() - YeelightControlView.this.O0000o0o) > Math.abs(motionEvent2.getY() - YeelightControlView.this.O0000o)) {
                        YeelightControlView.this.O0000o0 = TouchDirection.HORIZONTAL;
                    } else {
                        YeelightControlView.this.O0000o0 = TouchDirection.VERTICAL;
                    }
                    if (YeelightControlView.this.O0000o0 != TouchDirection.HORIZONTAL) {
                        YeelightControlView.this.O000000o(touchDirection);
                    } else {
                        int i2 = YeelightControlView.this.O0000oO;
                        if (i2 != 2) {
                            if (i2 != 3) {
                                if (i2 != 4) {
                                    if (i2 != 5) {
                                        if (i2 == 6 && ("yeelink.light.bslamp1".equals(YeelightControlView.this.O00000Oo.O000000o()) || "yeelink.light.bslamp2".equals(YeelightControlView.this.O00000Oo.O000000o()))) {
                                            YeelightControlView.this.O000000o(touchDirection);
                                            YeelightControlView yeelightControlView = YeelightControlView.this;
                                            yeelightControlView.O0000oO = 3;
                                            yeelightControlView.O00000o.setCurrentMode(TouchView.ControlMode.COLOR);
                                        }
                                    }
                                }
                                if (YeelightControlView.this.O00000Oo.O000000o(ProductModel.CapabilityType.CONTROL_FLOW_H)) {
                                    YeelightControlView.this.O000000o(touchDirection);
                                }
                            } else if (YeelightControlView.this.O00000Oo.O000000o(ProductModel.CapabilityType.CONTROL_COLOR_H)) {
                                YeelightControlView.this.O000000o(touchDirection);
                            }
                        }
                        if (YeelightControlView.this.O00000Oo.O000000o(ProductModel.CapabilityType.CONTROL_CT_H)) {
                            YeelightControlView.this.O000000o(touchDirection);
                        }
                        if (YeelightControlView.this.O00000Oo.O000000o(ProductModel.CapabilityType.CONTROL_FLOW_H)) {
                        }
                    }
                    YeelightControlView.this.O0000o00 = true;
                }
                int i3 = AnonymousClass6.O00000Oo[YeelightControlView.this.O0000o0.ordinal()];
                if (i3 == 1) {
                    if (YeelightControlView.this.O00000o.getCurrentMode() == TouchView.ControlMode.COLOR && YeelightControlView.this.O00000Oo.O000000o(ProductModel.CapabilityType.CONTROL_COLOR_H)) {
                        YeelightControlView.this.O00000oO.setImageResource(R.drawable.color_picker);
                        YeelightControlView.this.O00000Oo(motionEvent2.getX() - YeelightControlView.this.O0000o0o);
                    } else if (YeelightControlView.this.O00000o.getCurrentMode() == TouchView.ControlMode.SUNSHINE && YeelightControlView.this.O00000Oo.O000000o(ProductModel.CapabilityType.CONTROL_CT_H)) {
                        YeelightControlView.this.O00000oO.setImageResource(R.drawable.sunshine_picker);
                        YeelightControlView yeelightControlView2 = YeelightControlView.this;
                        yeelightControlView2.O0000oO0 = yeelightControlView2.O000000o(motionEvent2.getX() - YeelightControlView.this.O0000o0o, YeelightControlView.this.O0000oO0);
                    } else if (YeelightControlView.this.O00000o.getCurrentMode() == TouchView.ControlMode.COLORFLOW && YeelightControlView.this.O00000Oo.O000000o(ProductModel.CapabilityType.CONTROL_FLOW_H)) {
                        YeelightControlView.this.O00000o0(motionEvent2.getX() - YeelightControlView.this.O0000o0o);
                    } else if (YeelightControlView.this.O00000o.getCurrentMode() == TouchView.ControlMode.NIGHTLIGHT && "yeelink.light.bslamp1".equals(YeelightControlView.this.O00000Oo.O000000o())) {
                        YeelightControlView.this.O00000Oo(motionEvent2.getX() - YeelightControlView.this.O0000o0o);
                    }
                    YeelightControlView.this.O00000o.O000000o(motionEvent2.getX(), motionEvent2.getY());
                } else if (i3 == 2) {
                    if (YeelightControlView.this.O00000o.getCurrentMode() == TouchView.ControlMode.COLOR) {
                        YeelightControlView.this.O000000o(motionEvent2.getY() - YeelightControlView.this.O0000o);
                    } else if (YeelightControlView.this.O00000o.getCurrentMode() == TouchView.ControlMode.SUNSHINE || YeelightControlView.this.O00000o.getCurrentMode() == TouchView.ControlMode.NIGHTLIGHT) {
                        YeelightControlView.this.O000000o(motionEvent2.getY() - YeelightControlView.this.O0000o);
                    } else if (YeelightControlView.this.O00000o.getCurrentMode() == TouchView.ControlMode.COLORFLOW) {
                        YeelightControlView.this.O000000o(motionEvent2.getY() - YeelightControlView.this.O0000o);
                    }
                    YeelightControlView.this.O00000o.O000000o(motionEvent2.getX(), motionEvent2.getY());
                    YeelightControlView.this.O000000o(motionEvent2);
                    YeelightControlView.this.O00000Oo(motionEvent2);
                }
                YeelightControlView.this.O0000o0o = motionEvent2.getX();
                YeelightControlView.this.O0000o = motionEvent2.getY();
            }
            return true;
        }
    }

    /* renamed from: com.xiaomi.smarthome.newui.card.profile.YeelightControlView$6  reason: invalid class name */
    static /* synthetic */ class AnonymousClass6 {

        /* renamed from: O000000o  reason: collision with root package name */
        static final /* synthetic */ int[] f10238O000000o = new int[TouchView.ControlMode.values().length];
        static final /* synthetic */ int[] O00000Oo = new int[TouchDirection.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(16:0|(2:1|2)|3|(2:5|6)|7|9|10|11|12|13|14|15|16|17|18|20) */
        /* JADX WARNING: Can't wrap try/catch for region: R(17:0|(2:1|2)|3|5|6|7|9|10|11|12|13|14|15|16|17|18|20) */
        /* JADX WARNING: Can't wrap try/catch for region: R(18:0|1|2|3|5|6|7|9|10|11|12|13|14|15|16|17|18|20) */
        /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0032 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x003c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0047 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0052 */
        static {
            try {
                O00000Oo[TouchDirection.HORIZONTAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                O00000Oo[TouchDirection.VERTICAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f10238O000000o[TouchView.ControlMode.SWITCH.ordinal()] = 1;
            f10238O000000o[TouchView.ControlMode.COLORFLOW.ordinal()] = 2;
            f10238O000000o[TouchView.ControlMode.SUNSHINE.ordinal()] = 3;
            f10238O000000o[TouchView.ControlMode.NIGHTLIGHT.ordinal()] = 4;
            f10238O000000o[TouchView.ControlMode.COLOR.ordinal()] = 5;
        }
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent == null || motionEvent.getPointerCount() <= 1 || motionEvent.getActionIndex() == 0) {
            return super.dispatchTouchEvent(motionEvent);
        }
        return true;
    }

    private int O0000OOo() {
        return (int) ((getContext().getResources().getDisplayMetrics().density * 6.0f) + 0.5f);
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0040 A[SYNTHETIC, Splitter:B:20:0x0040] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0047 A[SYNTHETIC, Splitter:B:28:0x0047] */
    private Drawable getOffMask() {
        InputStream inputStream;
        InputStream inputStream2 = null;
        try {
            if (this.O0000Oo == null || this.O0000Oo.isRecycled()) {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inPreferredConfig = Bitmap.Config.ARGB_8888;
                options.inPurgeable = true;
                options.inInputShareable = true;
                inputStream = getResources().openRawResource(R.drawable.switch_off_mask);
                try {
                    this.O0000Oo = BitmapFactory.decodeStream(inputStream, null, options);
                    inputStream2 = inputStream;
                } catch (Exception unused) {
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Exception unused2) {
                        }
                    }
                    return null;
                } catch (Throwable th) {
                    th = th;
                    inputStream2 = inputStream;
                    if (inputStream2 != null) {
                        try {
                            inputStream2.close();
                        } catch (Exception unused3) {
                        }
                    }
                    throw th;
                }
            }
            if (inputStream2 != null) {
                try {
                    inputStream2.close();
                } catch (Exception unused4) {
                }
            }
            return new BitmapDrawable(this.O0000Oo);
        } catch (Exception unused5) {
            inputStream = null;
            if (inputStream != null) {
            }
            return null;
        } catch (Throwable th2) {
            th = th2;
            if (inputStream2 != null) {
            }
            throw th;
        }
    }

    public void setIsGroup(boolean z) {
        this.O000o0oo = z;
    }

    class O00000o extends TimerTask {
        private O00000o() {
        }

        /* synthetic */ O00000o(YeelightControlView yeelightControlView, byte b) {
            this();
        }

        /* JADX WARNING: Code restructure failed: missing block: B:61:0x00d6, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:63:0x00d8, code lost:
            return;
         */
        public final synchronized void run() {
            if (!YeelightControlView.this.isShown()) {
                cancel();
                return;
            }
            int i = AnonymousClass6.f10238O000000o[YeelightControlView.this.O00000o.getCurrentMode().ordinal()];
            if (i != 1 && i != 2) {
                if (i != 3) {
                    if (i == 4) {
                        if (YeelightControlView.this.O0000o0 == TouchDirection.VERTICAL && YeelightControlView.this.O000O0o != null) {
                            YeelightControlView.this.O000O0o.O000000o(YeelightControlView.this.O0000oo0);
                        }
                        if (YeelightControlView.this.O0000o0 == TouchDirection.HORIZONTAL && (("yeelink.light.bslamp1".equals(YeelightControlView.this.O00000Oo.O000000o()) || "yeelink.light.bslamp2".equals(YeelightControlView.this.O00000Oo.O000000o())) && YeelightControlView.this.O000O0o != null)) {
                        }
                    } else if (i == 5) {
                        if (YeelightControlView.this.O0000o0 == TouchDirection.HORIZONTAL) {
                            if (YeelightControlView.this.O000O0o != null) {
                            }
                        } else if (YeelightControlView.this.O000O0o != null) {
                            YeelightControlView.this.O000O0o.O000000o(YeelightControlView.this.O0000oOO);
                        }
                    }
                } else if (YeelightControlView.this.O0000o0 == TouchDirection.HORIZONTAL) {
                    if (YeelightControlView.this.O000O0o != null && YeelightControlView.this.O00000Oo.O000000o(ProductModel.CapabilityType.CONTROL_CT_H)) {
                        YeelightControlView.this.O000O0o.O00000Oo(YeelightControlView.this.O0000oo);
                    }
                } else if (YeelightControlView.this.O000O0o != null) {
                    YeelightControlView.this.O000O0o.O000000o(YeelightControlView.this.O0000oOO);
                }
            }
        }
    }

    public void setActivity(Activity activity) {
        this.O000oO00 = activity;
    }

    public Activity getActivity() {
        return this.O000oO00;
    }

    private int getBright() {
        int i = this.O0000oO;
        if (i == 4) {
            return this.O0000oOo;
        }
        if (i != 6) {
            return this.O0000oOO;
        }
        return this.O0000oo0;
    }

    public void setGuideImage(int i) {
        if (i == -1) {
            this.f10230O000000o.setImageDrawable(null);
        } else {
            this.f10230O000000o.setImageResource(i);
        }
    }

    public ProductModel getProductModel() {
        return this.O00000Oo;
    }

    public void setBgUri(Uri uri) {
        this.O000o = uri;
    }
}
