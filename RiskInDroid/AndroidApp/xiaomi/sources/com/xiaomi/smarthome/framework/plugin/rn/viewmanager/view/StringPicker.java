package com.xiaomi.smarthome.framework.plugin.rn.viewmanager.view;

import _m_j.hyy;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.media.SoundPool;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.method.NumberKeyListener;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.DecelerateInterpolator;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Scroller;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatEditText;
import com.xiaomi.smarthome.R;
import java.util.Formatter;
import java.util.Locale;

public class StringPicker extends LinearLayout {
    public static final O00000o0 O0000Oo0 = new O00000o0() {
        /* class com.xiaomi.smarthome.framework.plugin.rn.viewmanager.view.StringPicker.AnonymousClass1 */

        /* renamed from: O000000o  reason: collision with root package name */
        final StringBuilder f8623O000000o = new StringBuilder();
        final Formatter O00000Oo = new Formatter(this.f8623O000000o, Locale.US);
        final Object[] O00000o0 = new Object[1];

        public final String O000000o(int i) {
            this.O00000o0[0] = Integer.valueOf(i);
            StringBuilder sb = this.f8623O000000o;
            sb.delete(0, sb.length());
            this.O00000Oo.format("%02d", this.O00000o0);
            return this.O00000Oo.toString();
        }
    };
    public static final char[] O000OO00 = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    private static final int[] O000o0O = {16842919};

    /* renamed from: O000000o  reason: collision with root package name */
    private final int f8622O000000o;
    private final int O00000Oo;
    private final int O00000o;
    private final int O00000o0;
    private int O00000oO;
    private final boolean O00000oo;
    private final int O0000O0o;
    private int O0000OOo;
    public final EditText O0000Oo;
    public String[] O0000OoO;
    public int O0000Ooo;
    public long O0000o;
    public int O0000o0;
    public int O0000o00;
    public int O0000o0O;
    public O0000OOo O0000o0o;
    protected int O0000oO;
    protected int O0000oO0;
    protected int O0000oOO;
    O0000Oo O0000oOo;
    public final int O0000oo;
    protected boolean O0000oo0;
    public boolean O0000ooO;
    public int O0000ooo;
    public boolean O000O00o;
    protected Paint O000O0OO;
    protected String O000O0Oo;
    protected int O000O0o;
    protected int O000O0o0;
    public int O000O0oO;
    public Handler O000O0oo;
    private O00000o0 O000OO;
    private O0000O0o O000OO0o;
    private final SparseArray<String> O000OOOo;
    private final Paint O000OOo;
    private final int[] O000OOo0;
    private final Drawable O000OOoO;
    private int O000OOoo;
    private int O000Oo0;
    private int O000Oo00;
    private final Scroller O000Oo0O;
    private final Scroller O000Oo0o;
    private O000000o O000OoO;
    private int O000OoO0;
    private float O000OoOO;
    private long O000OoOo;
    private VelocityTracker O000Ooo;
    private float O000Ooo0;
    private int O000OooO;
    private int O000Oooo;
    private float O000o;
    private final O0000Oo0 O000o0;
    private final boolean O000o00;
    private int O000o000;
    private int O000o00O;
    private boolean O000o00o;
    private int O000o0O0;
    private Paint O000o0OO;
    private float O000o0Oo;
    private int O000o0o;
    private int O000o0o0;
    private int O000o0oo;
    private final int[] O000oO;
    private int O000oO0;
    private float O000oO00;
    private CharSequence O000oO0O;
    private short O000oO0o;
    private final int O000oOO;
    private final int O000oOO0;
    private SoundPool O000oOOO;
    private int O000oOOo;
    private long O000oOo0;
    private O00000Oo O00O0Oo;
    protected float O00oOoOo;
    public int O00oOooO;
    public boolean O00oOooo;

    public interface O00000o0 {
        String O000000o(int i);
    }

    public interface O0000O0o {
    }

    public interface O0000OOo {
        void O000000o(StringPicker stringPicker, int i, int i2);

        void O00000Oo(StringPicker stringPicker, int i, int i2);

        void O00000o0(StringPicker stringPicker, int i, int i2);
    }

    private static float O000000o(float f, int i, int i2) {
        return f >= 1.0f ? (float) i2 : (f * ((float) (i2 - i))) + ((float) i);
    }

    /* access modifiers changed from: protected */
    public float getBottomFadingEdgeStrength() {
        return 0.9f;
    }

    /* access modifiers changed from: protected */
    public float getTopFadingEdgeStrength() {
        return 0.9f;
    }

    public StringPicker(Context context) {
        this(context, null);
    }

    public StringPicker(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.numberPickerStyle);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, com.xiaomi.smarthome.framework.plugin.rn.viewmanager.view.StringPicker, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public StringPicker(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        int i2;
        int i3;
        this.O0000o = 300;
        this.O000OOOo = new SparseArray<>();
        this.O000OOo0 = new int[5];
        this.O0000oO0 = getResources().getColor(R.color.mj_color_text_hightlight);
        this.O0000oO = getResources().getColor(R.color.mj_color_gray_normal) & Integer.MAX_VALUE;
        this.O0000oOO = 0;
        this.O000Oo00 = Integer.MIN_VALUE;
        this.O000o00O = 0;
        this.O000o0O0 = -1;
        this.O000O0OO = null;
        this.O000o0o0 = 25;
        this.O000o0o = 14;
        this.O000o0oo = 10;
        this.O000oO00 = 56.0f;
        this.O000oO0 = 260;
        this.O000O0Oo = null;
        this.O00oOoOo = 0.0f;
        this.O000O0o0 = 0;
        this.O000O0o = Color.parseColor("#1dc58a");
        this.O000oO0o = 1;
        this.O000oO = new int[]{16842901, 16843087};
        this.O000oOO0 = 0;
        this.O000oOO = 1;
        this.O000O0oO = 0;
        this.O000O0oo = new Handler() {
            /* class com.xiaomi.smarthome.framework.plugin.rn.viewmanager.view.StringPicker.AnonymousClass2 */

            /* renamed from: O000000o  reason: collision with root package name */
            int f8624O000000o = StringPicker.this.O000O0oO;

            public final void handleMessage(Message message) {
                super.handleMessage(message);
                if (message.what == 100001) {
                    if (this.f8624O000000o == StringPicker.this.O000O0oO) {
                        StringPicker stringPicker = StringPicker.this;
                        stringPicker.O000O0oO = 0;
                        this.f8624O000000o = -1;
                        if (stringPicker.O0000o0o != null) {
                            O0000OOo o0000OOo = StringPicker.this.O0000o0o;
                            StringPicker stringPicker2 = StringPicker.this;
                            o0000OOo.O00000Oo(stringPicker2, stringPicker2.O0000o0O, StringPicker.this.O0000o0);
                        }
                    } else {
                        StringPicker.this.O000O0oo.sendMessageDelayed(StringPicker.this.O000O0oo.obtainMessage(100001), 300);
                        this.f8624O000000o = StringPicker.this.O000O0oO;
                    }
                    if (StringPicker.this.O000O0oO >= 100001) {
                        StringPicker.this.O000O0oO = 0;
                    }
                }
            }
        };
        this.O000oOo0 = 0;
        float f = getResources().getDisplayMetrics().density;
        if (f != 1.0f) {
            this.O000o0o = (int) (((float) this.O000o0o) * f);
            this.O000o0o0 = (int) (((float) this.O000o0o0) * f);
            this.O000o0oo = (int) (((float) this.O000o0oo) * f);
            this.O000oO00 *= f;
            this.O000oO0 = (int) (((float) this.O000oO0) * f);
        }
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, this.O000oO, 0, 0);
        this.O000oO0O = obtainStyledAttributes.getText(1);
        this.O000o0o0 = obtainStyledAttributes.getDimensionPixelSize(0, this.O000o0o0);
        obtainStyledAttributes.recycle();
        this.O000oOOO = new SoundPool(1, 1, 0);
        try {
            this.O000oOOo = this.O000oOOO.load(getContext(), R.raw.numberpicker_value_change, 1);
        } catch (Exception unused) {
            this.O000oOOo = -1;
        }
        this.O000o00 = true;
        this.O0000oo = (int) TypedValue.applyDimension(1, 2.0f, getResources().getDisplayMetrics());
        this.f8622O000000o = (int) this.O000oO00;
        this.O00000Oo = -1;
        this.O00000o0 = this.O000oO0;
        int i4 = this.O00000Oo;
        if (i4 == -1 || (i3 = this.O00000o0) == -1 || i4 <= i3) {
            this.O00000o = -1;
            this.O00000oO = -1;
            int i5 = this.O00000o;
            if (i5 == -1 || (i2 = this.O00000oO) == -1 || i5 <= i2) {
                this.O00000oo = this.O00000oO == -1;
                this.O000OOoO = getResources().getDrawable(R.drawable.rn_string_picker_virtual_button);
                this.O000o0 = new O0000Oo0();
                setWillNotDraw(!this.O000o00);
                ((LayoutInflater) getContext().getSystemService("layout_inflater")).inflate((int) R.layout.mj_numberpicker_layout, (ViewGroup) this, true);
                this.O0000Oo = (EditText) findViewById(R.id.numberpicker_input);
                this.O0000Oo.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                    /* class com.xiaomi.smarthome.framework.plugin.rn.viewmanager.view.StringPicker.AnonymousClass3 */

                    public final void onFocusChange(View view, boolean z) {
                        if (z) {
                            StringPicker.this.O0000Oo.selectAll();
                            return;
                        }
                        StringPicker.this.O0000Oo.setSelection(0, 0);
                        StringPicker.this.O000000o(view);
                    }
                });
                this.O0000Oo.setFilters(new InputFilter[]{new O00000o()});
                this.O0000Oo.setRawInputType(2);
                this.O0000Oo.setImeOptions(6);
                this.O0000Oo.setVisibility(4);
                this.O0000Oo.setGravity(3);
                if (Build.VERSION.SDK_INT >= 14) {
                    this.O0000Oo.setScaleX(0.0f);
                }
                this.O0000Oo.setSaveEnabled(false);
                EditText editText = this.O0000Oo;
                editText.setPadding(30, editText.getPaddingTop(), 30, this.O0000Oo.getPaddingRight());
                ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
                this.O000OooO = viewConfiguration.getScaledTouchSlop();
                this.O000Oooo = viewConfiguration.getScaledMinimumFlingVelocity();
                this.O000o000 = viewConfiguration.getScaledMaximumFlingVelocity() / 8;
                this.O0000O0o = (int) this.O0000Oo.getTextSize();
                Paint paint = new Paint();
                paint.setAntiAlias(true);
                paint.setTextAlign(Paint.Align.CENTER);
                paint.setTextSize((float) this.O000o0o0);
                paint.setTypeface(this.O0000Oo.getTypeface());
                paint.setColor(this.O0000Oo.getTextColors().getColorForState(ENABLED_STATE_SET, -1));
                this.O000OOo = paint;
                this.O000o = paint.ascent();
                this.O000o0OO = new Paint();
                this.O000o0OO.setAntiAlias(true);
                this.O000o0OO.setFakeBoldText(true);
                this.O000o0OO.setColor(getResources().getColor(R.color.class_text_17));
                this.O000o0OO.setTextSize((float) this.O000o0oo);
                if (Build.VERSION.SDK_INT >= 14) {
                    this.O000Oo0O = new Scroller(getContext(), null, true);
                } else {
                    this.O000Oo0O = new Scroller(getContext(), null);
                }
                this.O000Oo0o = new Scroller(getContext(), new DecelerateInterpolator(2.5f));
                O00000o0();
                if (Build.VERSION.SDK_INT >= 16 && getImportantForAccessibility() == 0) {
                    setImportantForAccessibility(1);
                    return;
                }
                return;
            }
            throw new IllegalArgumentException("minWidth > maxWidth");
        }
        throw new IllegalArgumentException("minHeight > maxHeight");
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (!this.O000o00) {
            super.onLayout(z, i, i2, i3, i4);
            return;
        }
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        int measuredWidth2 = this.O0000Oo.getMeasuredWidth();
        int measuredHeight2 = this.O0000Oo.getMeasuredHeight();
        int i5 = (measuredWidth - measuredWidth2) / 2;
        int i6 = (measuredHeight - measuredHeight2) / 2;
        this.O0000Oo.layout(i5, i6, measuredWidth2 + i5, measuredHeight2 + i6);
        if (z) {
            O00000Oo();
            int[] iArr = this.O000OOo0;
            this.O0000OOo = (int) ((((float) ((getBottom() - getTop()) - (iArr.length * this.O0000O0o))) / ((float) iArr.length)) + 0.5f);
            this.O000OOoo = this.O0000O0o + this.O0000OOo;
            this.O000Oo00 = (this.O0000Oo.getBaseline() + this.O0000Oo.getTop()) - (this.O000OOoo * 2);
            this.O000Oo0 = this.O000Oo00;
            O00000o0();
            setVerticalFadingEdgeEnabled(true);
            setFadingEdgeLength(((getBottom() - getTop()) - this.O0000O0o) / 2);
            int height = getHeight();
            int i7 = this.f8622O000000o;
            int i8 = this.O0000oo;
            this.O0000ooo = ((height - i7) / 2) - i8;
            this.O00oOooO = this.O0000ooo + (i8 * 2) + i7;
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        ViewGroup viewGroup = (ViewGroup) getParent();
        if (viewGroup != null) {
            viewGroup.setClipChildren(true);
        }
        if (!this.O000o00) {
            super.onMeasure(i, i2);
            return;
        }
        super.onMeasure(O000000o(i, this.O00000oO), O000000o(i2, this.O00000o0));
        setMeasuredDimension(O000000o(this.O00000o, getMeasuredWidth(), i), O000000o(this.O00000Oo, getMeasuredHeight(), i2));
    }

    private boolean O000000o(Scroller scroller) {
        scroller.forceFinished(true);
        int finalY = scroller.getFinalY() - scroller.getCurrY();
        int i = this.O000Oo00 - ((this.O000Oo0 + finalY) % this.O000OOoo);
        if (i == 0) {
            return false;
        }
        int abs = Math.abs(i);
        int i2 = this.O000OOoo;
        if (abs > i2 / 2) {
            i = i > 0 ? i - i2 : i + i2;
        }
        scrollBy(0, finalY + i);
        return true;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.smarthome.framework.plugin.rn.viewmanager.view.StringPicker.O000000o(boolean, long):void
     arg types: [int, long]
     candidates:
      com.xiaomi.smarthome.framework.plugin.rn.viewmanager.view.StringPicker.O000000o(int, int):int
      com.xiaomi.smarthome.framework.plugin.rn.viewmanager.view.StringPicker.O000000o(int, boolean):void
      com.xiaomi.smarthome.framework.plugin.rn.viewmanager.view.StringPicker.O000000o(boolean, long):void */
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (!this.O000o00 || !isEnabled()) {
            return false;
        }
        if (motionEvent.getActionMasked() != 0) {
            getParent().requestDisallowInterceptTouchEvent(true);
            return super.onInterceptTouchEvent(motionEvent);
        }
        O00000o();
        this.O0000Oo.setVisibility(4);
        float y = motionEvent.getY();
        this.O000OoOO = y;
        this.O000Ooo0 = y;
        this.O000OoOo = motionEvent.getEventTime();
        this.O0000ooO = false;
        this.O000o00o = false;
        float f = this.O000OoOO;
        if (f < ((float) this.O0000ooo)) {
            if (this.O000o00O == 0) {
                this.O000o0.O000000o(2);
            }
        } else if (f > ((float) this.O00oOooO) && this.O000o00O == 0) {
            this.O000o0.O000000o(1);
        }
        if (!this.O000Oo0O.isFinished()) {
            this.O000Oo0O.forceFinished(true);
            this.O000Oo0o.forceFinished(true);
            O000000o(0);
        } else if (!this.O000Oo0o.isFinished()) {
            this.O000Oo0O.forceFinished(true);
            this.O000Oo0o.forceFinished(true);
        } else {
            float f2 = this.O000OoOO;
            if (f2 < ((float) this.O0000ooo)) {
                O000000o(false, (long) ViewConfiguration.getLongPressTimeout());
            } else if (f2 > ((float) this.O00oOooO)) {
                O000000o(true, (long) ViewConfiguration.getLongPressTimeout());
            } else {
                this.O000o00o = true;
                O000000o o000000o = this.O000OoO;
                if (o000000o == null) {
                    this.O000OoO = new O000000o();
                } else {
                    removeCallbacks(o000000o);
                }
                postDelayed(this.O000OoO, (long) ViewConfiguration.getLongPressTimeout());
            }
        }
        getParent().requestDisallowInterceptTouchEvent(true);
        return true;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!isEnabled() || !this.O000o00) {
            return false;
        }
        if (this.O000Ooo == null) {
            this.O000Ooo = VelocityTracker.obtain();
        }
        this.O000Ooo.addMovement(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            O0000OOo o0000OOo = this.O0000o0o;
            if (o0000OOo != null) {
                o0000OOo.O00000o0(this, this.O0000o0O, this.O0000o0);
            }
        } else if (actionMasked == 1) {
            O000000o o000000o = this.O000OoO;
            if (o000000o != null) {
                removeCallbacks(o000000o);
            }
            O00000Oo o00000Oo = this.O00O0Oo;
            if (o00000Oo != null) {
                removeCallbacks(o00000Oo);
            }
            this.O000o0.O000000o();
            VelocityTracker velocityTracker = this.O000Ooo;
            velocityTracker.computeCurrentVelocity(1000, (float) this.O000o000);
            int yVelocity = (int) velocityTracker.getYVelocity();
            if (Math.abs(yVelocity) > this.O000Oooo) {
                this.O000OoO0 = 0;
                if (yVelocity > 0) {
                    this.O000Oo0O.fling(0, 0, 0, yVelocity, 0, 0, 0, Integer.MAX_VALUE);
                } else {
                    this.O000Oo0O.fling(0, Integer.MAX_VALUE, 0, yVelocity, 0, 0, 0, Integer.MAX_VALUE);
                }
                invalidate();
                O000000o(2);
                Handler handler = this.O000O0oo;
                handler.sendMessageDelayed(handler.obtainMessage(100001), 400);
            } else {
                Handler handler2 = this.O000O0oo;
                handler2.sendMessageDelayed(handler2.obtainMessage(100001), 100);
                int y = (int) motionEvent.getY();
                int abs = (int) Math.abs(((float) y) - this.O000OoOO);
                long eventTime = motionEvent.getEventTime() - this.O000OoOo;
                if (abs > this.O000OooO || eventTime >= ((long) ViewConfiguration.getTapTimeout())) {
                    O00000oO();
                } else if (this.O000o00o) {
                    this.O000o00o = false;
                } else {
                    int i = (y / this.O000OOoo) - 2;
                    if (i > 0) {
                        O000000o(true);
                        this.O000o0.O00000Oo(1);
                    } else if (i < 0) {
                        O000000o(false);
                        this.O000o0.O00000Oo(2);
                    }
                }
                O000000o(0);
            }
            this.O000Ooo.recycle();
            this.O000Ooo = null;
        } else if (actionMasked == 2 && !this.O0000ooO) {
            float y2 = motionEvent.getY();
            if (this.O000o00O == 1) {
                scrollBy(0, (int) (y2 - this.O000Ooo0));
                invalidate();
            } else if (((int) Math.abs(y2 - this.O000OoOO)) > this.O000OooO) {
                O00000o();
                O000000o(1);
            }
            this.O000Ooo0 = y2;
        }
        return true;
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 1 || actionMasked == 3) {
            O00000o();
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x004b, code lost:
        requestFocus();
        r5.O000o0O0 = r0;
        O00000o();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0059, code lost:
        if (r5.O000Oo0O.isFinished() == false) goto L_0x0063;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x005b, code lost:
        if (r0 != 20) goto L_0x005f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x005d, code lost:
        r6 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x005f, code lost:
        r6 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0060, code lost:
        O000000o(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0063, code lost:
        return true;
     */
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        if (keyCode == 19 || keyCode == 20) {
            if (this.O000o00) {
                int action = keyEvent.getAction();
                if (action != 0) {
                    if (action == 1 && this.O000o0O0 == keyCode) {
                        this.O000o0O0 = -1;
                        return true;
                    }
                } else if (!this.O0000oo0) {
                }
            }
        } else if (keyCode == 23 || keyCode == 66) {
            O00000o();
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    public boolean dispatchTrackballEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 1 || actionMasked == 3) {
            O00000o();
        }
        return super.dispatchTrackballEvent(motionEvent);
    }

    public void computeScroll() {
        Scroller scroller = this.O000Oo0O;
        if (scroller.isFinished()) {
            scroller = this.O000Oo0o;
            if (scroller.isFinished()) {
                return;
            }
        }
        scroller.computeScrollOffset();
        int currY = scroller.getCurrY();
        if (this.O000OoO0 == 0) {
            this.O000OoO0 = scroller.getStartY();
        }
        scrollBy(0, currY - this.O000OoO0);
        this.O000OoO0 = currY;
        if (!scroller.isFinished()) {
            invalidate();
        } else if (scroller == this.O000Oo0O) {
            if (!O00000oO()) {
                O00000o0();
            }
            O000000o(0);
        } else if (this.O000o00O != 1) {
            O00000o0();
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.smarthome.framework.plugin.rn.viewmanager.view.StringPicker.O000000o(int, boolean):void
     arg types: [int, int]
     candidates:
      com.xiaomi.smarthome.framework.plugin.rn.viewmanager.view.StringPicker.O000000o(int, int):int
      com.xiaomi.smarthome.framework.plugin.rn.viewmanager.view.StringPicker.O000000o(boolean, long):void
      com.xiaomi.smarthome.framework.plugin.rn.viewmanager.view.StringPicker.O000000o(int, boolean):void */
    public void scrollBy(int i, int i2) {
        int[] iArr = this.O000OOo0;
        if (!this.O0000oo0 && i2 > 0 && iArr[2] <= this.O0000Ooo) {
            this.O000Oo0 = this.O000Oo00;
        } else if (this.O0000oo0 || i2 >= 0 || iArr[2] < this.O0000o00) {
            this.O000Oo0 += i2;
            while (((float) (this.O000Oo0 - this.O000Oo00)) > ((float) this.O0000OOo) / hyy.O00000Oo) {
                this.O000Oo0 -= this.O000OOoo;
                System.arraycopy(iArr, 0, iArr, 1, iArr.length - 1);
                int i3 = iArr[1] - 1;
                if (this.O0000oo0 && i3 < this.O0000Ooo) {
                    i3 = this.O0000o00;
                }
                iArr[0] = i3;
                O00000o0(i3);
                O000000o(iArr[2], true);
                if (!this.O0000oo0 && iArr[2] <= this.O0000Ooo) {
                    this.O000Oo0 = this.O000Oo00;
                }
            }
            while (((float) (this.O000Oo0 - this.O000Oo00)) < ((float) (-this.O0000OOo)) / hyy.O00000Oo) {
                this.O000Oo0 += this.O000OOoo;
                System.arraycopy(iArr, 1, iArr, 0, iArr.length - 1);
                int i4 = iArr[iArr.length - 2] + 1;
                if (this.O0000oo0 && i4 > this.O0000o00) {
                    i4 = this.O0000Ooo;
                }
                iArr[iArr.length - 1] = i4;
                O00000o0(i4);
                O000000o(iArr[2], true);
                if (!this.O0000oo0 && iArr[2] >= this.O0000o00) {
                    this.O000Oo0 = this.O000Oo00;
                }
            }
        } else {
            this.O000Oo0 = this.O000Oo00;
        }
    }

    public void setLabel(String str) {
        CharSequence charSequence;
        if ((this.O000oO0O == null && str != null) || ((charSequence = this.O000oO0O) != null && !charSequence.equals(str))) {
            this.O000oO0O = str;
            invalidate();
        }
    }

    public void setOnValueChangedListener(O0000OOo o0000OOo) {
        this.O0000o0o = o0000OOo;
    }

    public void setOnScrollListener(O0000O0o o0000O0o) {
        this.O000OO0o = o0000O0o;
    }

    public void setFormatter(O00000o0 o00000o0) {
        if (o00000o0 != this.O000OO) {
            this.O000OO = o00000o0;
            O00000Oo();
            O00000o0();
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.smarthome.framework.plugin.rn.viewmanager.view.StringPicker.O000000o(int, boolean):void
     arg types: [int, int]
     candidates:
      com.xiaomi.smarthome.framework.plugin.rn.viewmanager.view.StringPicker.O000000o(int, int):int
      com.xiaomi.smarthome.framework.plugin.rn.viewmanager.view.StringPicker.O000000o(boolean, long):void
      com.xiaomi.smarthome.framework.plugin.rn.viewmanager.view.StringPicker.O000000o(int, boolean):void */
    public void setValue(int i) {
        O000000o(i, false);
    }

    /* access modifiers changed from: protected */
    public final float O00000Oo(String str) {
        return this.O000OOo.measureText(str);
    }

    private void O000000o() {
        if (this.O00000oo) {
            float f = -1.0f;
            this.O000OOo.setTextSize((float) this.O000o0o0);
            String[] strArr = this.O0000OoO;
            int i = 0;
            if (strArr == null) {
                float f2 = 0.0f;
                while (i < 9) {
                    float measureText = this.O000OOo.measureText(String.valueOf(i));
                    if (measureText > f2) {
                        f2 = measureText;
                    }
                    i++;
                }
                f = (float) ((int) (((float) O00000o(this.O0000o00).length()) * f2));
            } else {
                int length = strArr.length;
                while (i < length) {
                    float measureText2 = this.O000OOo.measureText(strArr[i]);
                    if (measureText2 > f) {
                        f = measureText2;
                    }
                    i++;
                }
            }
            this.O000o0Oo = f;
            float paddingLeft = f + ((float) (this.O0000Oo.getPaddingLeft() + this.O0000Oo.getPaddingRight())) + ((float) getPaddingLeft()) + ((float) getPaddingRight());
            if (((float) this.O00000oO) != paddingLeft) {
                int i2 = this.O00000o;
                if (paddingLeft > ((float) i2)) {
                    this.O00000oO = (int) paddingLeft;
                } else {
                    this.O00000oO = i2;
                }
            }
        }
    }

    public boolean getWrapSelectorWheel() {
        return this.O0000oo0;
    }

    public void setWrapSelectorWheel(boolean z) {
        boolean z2 = this.O0000o00 - this.O0000Ooo >= this.O000OOo0.length;
        if ((!z || z2) && z != this.O0000oo0) {
            this.O0000oo0 = z;
        }
        O00000Oo();
        invalidate();
    }

    public void setOnLongPressUpdateInterval(long j) {
        this.O0000o = j;
    }

    public int getValue() {
        return this.O0000o0;
    }

    public int getMinValue() {
        return this.O0000Ooo;
    }

    public void setMinValue(int i) {
        if (this.O0000Ooo != i) {
            if (i >= 0) {
                this.O0000Ooo = i;
                int i2 = this.O0000Ooo;
                if (i2 > this.O0000o0) {
                    this.O0000o0 = i2;
                }
                setWrapSelectorWheel(this.O0000o00 - this.O0000Ooo > this.O000OOo0.length);
                O00000Oo();
                O00000o0();
                O000000o();
                invalidate();
                return;
            }
            throw new IllegalArgumentException("minValue must be >= 0");
        }
    }

    public int getMaxValue() {
        return this.O0000o00;
    }

    public void setMaxValue(int i) {
        if (this.O0000o00 != i) {
            if (i >= 0) {
                this.O0000o00 = i;
                int i2 = this.O0000o00;
                if (i2 < this.O0000o0) {
                    this.O0000o0 = i2;
                }
                setWrapSelectorWheel(this.O0000o00 - this.O0000Ooo > this.O000OOo0.length);
                O00000Oo();
                O00000o0();
                O000000o();
                invalidate();
                return;
            }
            throw new IllegalArgumentException("maxValue must be >= 0");
        }
    }

    public String[] getDisplayedValues() {
        return this.O0000OoO;
    }

    public void setDisplayedValues(String[] strArr) {
        if (this.O0000OoO != strArr) {
            this.O0000OoO = strArr;
            if (this.O0000OoO != null) {
                this.O0000Oo.setRawInputType(524289);
            } else {
                this.O0000Oo.setRawInputType(2);
            }
            int i = 0;
            while (true) {
                int[] iArr = this.O000OOo0;
                if (i < iArr.length) {
                    iArr[i] = 0;
                    i++;
                } else {
                    O00000o0();
                    O00000Oo();
                    O000000o();
                    return;
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        O00000o();
        this.O000oOOO.release();
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.smarthome.framework.plugin.rn.viewmanager.view.StringPicker.O000000o(float, int, boolean):int
     arg types: [float, int, int]
     candidates:
      com.xiaomi.smarthome.framework.plugin.rn.viewmanager.view.StringPicker.O000000o(float, int, int):float
      com.xiaomi.smarthome.framework.plugin.rn.viewmanager.view.StringPicker.O000000o(int, int, int):int
      com.xiaomi.smarthome.framework.plugin.rn.viewmanager.view.StringPicker.O000000o(float, int, boolean):int */
    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        Canvas canvas2 = canvas;
        if (!this.O000o00) {
            super.onDraw(canvas);
            return;
        }
        int width = getWidth();
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        float right = (float) ((((getRight() - getLeft()) + paddingLeft) - paddingRight) / 2);
        float f = (float) this.O000Oo0;
        Drawable drawable = this.O000OOoO;
        boolean z = false;
        if (drawable != null && this.O000o00O == 0) {
            if (this.O000O00o) {
                drawable.setState(O000o0O);
                this.O000OOoO.setBounds(paddingLeft, 0, width - paddingRight, this.O0000ooo);
                this.O000OOoO.draw(canvas2);
            }
            if (this.O00oOooo) {
                this.O000OOoO.setState(O000o0O);
                this.O000OOoO.setBounds(paddingLeft, this.O00oOooO, width - paddingRight, getBottom());
                this.O000OOoO.draw(canvas2);
            }
        }
        float f2 = (float) (this.O000Oo00 + (this.O000OOoo * 2));
        SparseArray<String> sparseArray = this.O000OOOo;
        int[] iArr = this.O000OOo0;
        int i = this.O000OOoo;
        float height = ((float) (getHeight() / 2)) - (((float) i) * 0.44f);
        float f3 = height + ((float) i);
        this.O000OOo.setColor(this.O0000oOO);
        canvas.drawRect(0.0f, height, (float) getWidth(), f3, this.O000OOo);
        Paint paint = this.O000O0OO;
        if (paint != null) {
            Canvas canvas3 = canvas;
            float f4 = (float) width;
            canvas3.drawLine(0.0f, height, f4, height, paint);
            canvas3.drawLine(0.0f, f3, f4, f3, paint);
        }
        int length = iArr.length;
        int i2 = 0;
        while (i2 < length) {
            String str = sparseArray.get(iArr[i2]);
            float abs = Math.abs(f2 - f) / ((float) this.O000OOoo);
            float O000000o2 = O000000o(abs, this.O000o0o0, this.O000o0o);
            this.O000OOo.setTextSize(O000000o2);
            this.O000OOo.setColor(O000000o(abs, this.O0000oO, z));
            canvas2.drawText(str, right, ((O000000o2 - ((float) this.O000o0o)) / 2.0f) + f, this.O000OOo);
            if (abs < 1.0f) {
                float O000000o3 = O000000o(abs, this.O000o0o0, this.O000o0o);
                this.O000OOo.setTextSize(O000000o3);
                this.O000OOo.setColor(O000000o(abs, this.O0000oO0, true));
                canvas2.drawText(str, right, ((O000000o3 - ((float) this.O000o0o)) / 2.0f) + f, this.O000OOo);
                if (this.O00oOoOo < O000000o3) {
                    this.O00oOoOo = O000000o3;
                }
            }
            f += (float) this.O000OOoo;
            i2++;
            z = false;
        }
        if (!TextUtils.isEmpty(this.O000oO0O)) {
            canvas2.drawText(this.O000oO0O.toString(), (this.O000o0Oo / 2.0f) + right, ((float) ((this.O000o0o0 - this.O000o0o) / 2)) + f2 + this.O000o + ((float) this.O000o0oo), this.O000o0OO);
        }
        if (!TextUtils.isEmpty(this.O000O0Oo)) {
            float f5 = (f2 - ((float) (this.O000OOoo / 4))) + 2.0f;
            float f6 = this.O00oOoOo;
            float f7 = this.O000o0Oo;
            if (f6 < f7) {
                this.O00oOoOo = f7;
            }
            int i3 = this.O000O0o0;
            if (i3 > 0) {
                this.O000o0OO.setTextSize((float) i3);
            }
            this.O000o0OO.setColor(this.O000O0o);
            canvas2.drawText(this.O000O0Oo, right + (this.O00oOoOo / 2.0f), f5, this.O000o0OO);
        }
    }

    private static int O000000o(float f, int i, boolean z) {
        float f2;
        if (f >= 1.0f) {
            return i;
        }
        if (z) {
            f2 = ((-f) * ((float) Color.alpha(i))) + ((float) Color.alpha(i));
        } else {
            f2 = f * ((float) Color.alpha(i));
        }
        return (((int) f2) << 24) | (i & 16777215);
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(StringPicker.class.getName());
        accessibilityEvent.setScrollable(true);
        accessibilityEvent.setScrollY((this.O0000Ooo + this.O0000o0) * this.O000OOoo);
        accessibilityEvent.setMaxScrollY((this.O0000o00 - this.O0000Ooo) * this.O000OOoo);
    }

    private static int O000000o(int i, int i2) {
        if (i2 == -1) {
            return i;
        }
        int size = View.MeasureSpec.getSize(i);
        int mode = View.MeasureSpec.getMode(i);
        if (mode == Integer.MIN_VALUE) {
            return View.MeasureSpec.makeMeasureSpec(Math.min(size, i2), 1073741824);
        }
        if (mode == 0) {
            return View.MeasureSpec.makeMeasureSpec(i2, 1073741824);
        }
        if (mode == 1073741824) {
            return i;
        }
        throw new IllegalArgumentException("Unknown measure mode: ".concat(String.valueOf(mode)));
    }

    private static int O000000o(int i, int i2, int i3) {
        return i != -1 ? resolveSizeAndState(Math.max(i, i2), i3, 0) : i2;
    }

    private void O00000Oo() {
        this.O000OOOo.clear();
        int[] iArr = this.O000OOo0;
        int value = getValue();
        for (int i = 0; i < this.O000OOo0.length; i++) {
            int i2 = (i - 2) + value;
            if (this.O0000oo0) {
                i2 = O00000Oo(i2);
            }
            iArr[i] = i2;
            O00000o0(iArr[i]);
        }
    }

    private void O000000o(int i, boolean z) {
        int i2;
        if (this.O0000o0 != i) {
            if (this.O0000oo0) {
                i2 = O00000Oo(i);
            } else {
                i2 = Math.min(Math.max(i, this.O0000Ooo), this.O0000o00);
            }
            int i3 = this.O0000o0;
            this.O0000o0 = i2;
            O00000o0();
            if (z) {
                O00000oO(i3);
            }
            O00000Oo();
            invalidate();
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.smarthome.framework.plugin.rn.viewmanager.view.StringPicker.O000000o(int, boolean):void
     arg types: [int, int]
     candidates:
      com.xiaomi.smarthome.framework.plugin.rn.viewmanager.view.StringPicker.O000000o(int, int):int
      com.xiaomi.smarthome.framework.plugin.rn.viewmanager.view.StringPicker.O000000o(boolean, long):void
      com.xiaomi.smarthome.framework.plugin.rn.viewmanager.view.StringPicker.O000000o(int, boolean):void */
    public final void O000000o(boolean z) {
        if (this.O000o00) {
            this.O0000Oo.setVisibility(4);
            if (!O000000o(this.O000Oo0O)) {
                O000000o(this.O000Oo0o);
            }
            this.O000OoO0 = 0;
            if (z) {
                this.O000Oo0O.startScroll(0, 0, 0, -this.O000OOoo, 300);
            } else {
                this.O000Oo0O.startScroll(0, 0, 0, this.O000OOoo, 300);
            }
            invalidate();
        } else if (z) {
            O000000o(this.O0000o0 + 1, true);
        } else {
            O000000o(this.O0000o0 - 1, true);
        }
    }

    private void O000000o(int i) {
        if (this.O000o00O != i) {
            this.O000o00O = i;
        }
    }

    private int O00000Oo(int i) {
        int i2 = this.O0000o00;
        if (i > i2) {
            int i3 = this.O0000Ooo;
            return (i3 + ((i - i2) % (i2 - i3))) - 1;
        }
        int i4 = this.O0000Ooo;
        return i < i4 ? (i2 - ((i4 - i) % (i2 - i4))) + 1 : i;
    }

    private void O00000o0(int i) {
        String str;
        SparseArray<String> sparseArray = this.O000OOOo;
        if (sparseArray.get(i) == null) {
            int i2 = this.O0000Ooo;
            if (i < i2 || i > this.O0000o00) {
                str = "";
            } else {
                String[] strArr = this.O0000OoO;
                str = strArr != null ? strArr[i - i2] : O00000o(i);
            }
            sparseArray.put(i, str);
        }
    }

    private String O00000o(int i) {
        O00000o0 o00000o0 = this.O000OO;
        return o00000o0 != null ? o00000o0.O000000o(i) : String.valueOf(i);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.smarthome.framework.plugin.rn.viewmanager.view.StringPicker.O000000o(int, boolean):void
     arg types: [int, int]
     candidates:
      com.xiaomi.smarthome.framework.plugin.rn.viewmanager.view.StringPicker.O000000o(int, int):int
      com.xiaomi.smarthome.framework.plugin.rn.viewmanager.view.StringPicker.O000000o(boolean, long):void
      com.xiaomi.smarthome.framework.plugin.rn.viewmanager.view.StringPicker.O000000o(int, boolean):void */
    public final void O000000o(View view) {
        String valueOf = String.valueOf(((TextView) view).getText());
        if (TextUtils.isEmpty(valueOf)) {
            O00000o0();
        } else {
            O000000o(O00000o0(valueOf.toString()), true);
        }
    }

    private boolean O00000o0() {
        String[] strArr = this.O0000OoO;
        String O00000o2 = strArr == null ? O00000o(this.O0000o0) : strArr[this.O0000o0 - this.O0000Ooo];
        if (TextUtils.isEmpty(O00000o2) || O00000o2.equals(this.O0000Oo.getText().toString())) {
            return false;
        }
        this.O0000Oo.setText(O00000o2);
        return true;
    }

    private void O00000oO(int i) {
        long currentTimeMillis = System.currentTimeMillis();
        this.O000O0oO++;
        this.O0000o0O = i;
        int i2 = this.O000oOOo;
        if (i2 != -1 && currentTimeMillis - this.O000oOo0 >= 100) {
            this.O000oOOO.play(i2, 1.0f, 1.0f, 0, 0, 1.0f);
            this.O000oOo0 = currentTimeMillis;
        }
        O0000OOo o0000OOo = this.O0000o0o;
        if (o0000OOo != null) {
            o0000OOo.O000000o(this, i, this.O0000o0);
        }
    }

    private void O000000o(boolean z, long j) {
        O00000Oo o00000Oo = this.O00O0Oo;
        if (o00000Oo == null) {
            this.O00O0Oo = new O00000Oo();
        } else {
            removeCallbacks(o00000Oo);
        }
        O00000Oo o00000Oo2 = this.O00O0Oo;
        o00000Oo2.f8627O000000o = z;
        postDelayed(o00000Oo2, j);
    }

    private void O00000o() {
        O00000Oo o00000Oo = this.O00O0Oo;
        if (o00000Oo != null) {
            removeCallbacks(o00000Oo);
        }
        O0000Oo o0000Oo = this.O0000oOo;
        if (o0000Oo != null) {
            removeCallbacks(o0000Oo);
        }
        O000000o o000000o = this.O000OoO;
        if (o000000o != null) {
            removeCallbacks(o000000o);
        }
        this.O000o0.O000000o();
    }

    public final int O00000o0(String str) {
        if (this.O0000OoO == null) {
            try {
                return Integer.parseInt(str);
            } catch (NumberFormatException unused) {
                return this.O0000Ooo;
            }
        } else {
            for (int i = 0; i < this.O0000OoO.length; i++) {
                str = str.toLowerCase();
                if (this.O0000OoO[i].toLowerCase().startsWith(str)) {
                    return this.O0000Ooo + i;
                }
            }
            return Integer.parseInt(str);
        }
    }

    class O00000o extends NumberKeyListener {
        public final int getInputType() {
            return 1;
        }

        O00000o() {
        }

        /* access modifiers changed from: protected */
        public final char[] getAcceptedChars() {
            return StringPicker.O000OO00;
        }

        public final CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
            if (StringPicker.this.O0000OoO == null) {
                CharSequence filter = super.filter(charSequence, i, i2, spanned, i3, i4);
                if (filter == null) {
                    filter = charSequence.subSequence(i, i2);
                }
                String str = String.valueOf(spanned.subSequence(0, i3)) + ((Object) filter) + ((Object) spanned.subSequence(i4, spanned.length()));
                if ("".equals(str)) {
                    return str;
                }
                if (StringPicker.this.O00000o0(str) > StringPicker.this.O0000o00 || str.length() > String.valueOf(StringPicker.this.O0000o00).length()) {
                    return "";
                }
                return filter;
            }
            String valueOf = String.valueOf(charSequence.subSequence(i, i2));
            if (TextUtils.isEmpty(valueOf)) {
                return "";
            }
            String str2 = String.valueOf(spanned.subSequence(0, i3)) + ((Object) valueOf) + ((Object) spanned.subSequence(i4, spanned.length()));
            String lowerCase = String.valueOf(str2).toLowerCase();
            for (String str3 : StringPicker.this.O0000OoO) {
                if (str3.toLowerCase().startsWith(lowerCase)) {
                    StringPicker stringPicker = StringPicker.this;
                    int length = str2.length();
                    int length2 = str3.length();
                    if (stringPicker.O0000oOo == null) {
                        stringPicker.O0000oOo = new O0000Oo();
                    } else {
                        stringPicker.removeCallbacks(stringPicker.O0000oOo);
                    }
                    stringPicker.O0000oOo.f8629O000000o = length;
                    stringPicker.O0000oOo.O00000Oo = length2;
                    stringPicker.post(stringPicker.O0000oOo);
                    return str3.subSequence(i3, str3.length());
                }
            }
            return "";
        }
    }

    private boolean O00000oO() {
        int i = this.O000Oo00 - this.O000Oo0;
        if (i == 0) {
            return false;
        }
        this.O000OoO0 = 0;
        int abs = Math.abs(i);
        int i2 = this.O000OOoo;
        if (abs > i2 / 2) {
            if (i > 0) {
                i2 = -i2;
            }
            i += i2;
        }
        this.O000Oo0o.startScroll(0, 0, 0, i, 800);
        invalidate();
        return true;
    }

    class O0000Oo0 implements Runnable {
        private final int O00000Oo = 1;
        private int O00000o;
        private final int O00000o0 = 2;
        private int O00000oO;

        O0000Oo0() {
        }

        public final void O000000o() {
            this.O00000oO = 0;
            this.O00000o = 0;
            StringPicker.this.removeCallbacks(this);
            if (StringPicker.this.O00oOooo) {
                StringPicker stringPicker = StringPicker.this;
                stringPicker.O00oOooo = false;
                stringPicker.invalidate(0, stringPicker.O00oOooO, StringPicker.this.getRight(), StringPicker.this.getBottom());
            }
            if (StringPicker.this.O000O00o) {
                StringPicker stringPicker2 = StringPicker.this;
                stringPicker2.O000O00o = false;
                stringPicker2.invalidate(0, 0, stringPicker2.getRight(), StringPicker.this.O0000ooo);
            }
        }

        public final void O000000o(int i) {
            O000000o();
            this.O00000oO = 1;
            this.O00000o = i;
            StringPicker.this.postDelayed(this, (long) ViewConfiguration.getTapTimeout());
        }

        public final void O00000Oo(int i) {
            O000000o();
            this.O00000oO = 2;
            this.O00000o = i;
            StringPicker.this.post(this);
        }

        public final void run() {
            int i = this.O00000oO;
            if (i == 1) {
                int i2 = this.O00000o;
                if (i2 == 1) {
                    StringPicker stringPicker = StringPicker.this;
                    stringPicker.O00oOooo = true;
                    stringPicker.invalidate(0, stringPicker.O00oOooO, StringPicker.this.getRight(), StringPicker.this.getBottom());
                } else if (i2 == 2) {
                    StringPicker stringPicker2 = StringPicker.this;
                    stringPicker2.O000O00o = true;
                    stringPicker2.invalidate(0, 0, stringPicker2.getRight(), StringPicker.this.O0000ooo);
                }
            } else if (i == 2) {
                int i3 = this.O00000o;
                if (i3 == 1) {
                    if (!StringPicker.this.O00oOooo) {
                        StringPicker.this.postDelayed(this, (long) ViewConfiguration.getPressedStateDuration());
                    }
                    StringPicker stringPicker3 = StringPicker.this;
                    stringPicker3.O00oOooo = !stringPicker3.O00oOooo;
                    StringPicker stringPicker4 = StringPicker.this;
                    stringPicker4.invalidate(0, stringPicker4.O00oOooO, StringPicker.this.getRight(), StringPicker.this.getBottom());
                } else if (i3 == 2) {
                    if (!StringPicker.this.O000O00o) {
                        StringPicker.this.postDelayed(this, (long) ViewConfiguration.getPressedStateDuration());
                    }
                    StringPicker stringPicker5 = StringPicker.this;
                    stringPicker5.O000O00o = !stringPicker5.O000O00o;
                    StringPicker stringPicker6 = StringPicker.this;
                    stringPicker6.invalidate(0, 0, stringPicker6.getRight(), StringPicker.this.O0000ooo);
                }
            }
        }
    }

    class O0000Oo implements Runnable {

        /* renamed from: O000000o  reason: collision with root package name */
        public int f8629O000000o;
        public int O00000Oo;

        O0000Oo() {
        }

        public final void run() {
            StringPicker.this.O0000Oo.setSelection(this.f8629O000000o, this.O00000Oo);
        }
    }

    class O00000Oo implements Runnable {

        /* renamed from: O000000o  reason: collision with root package name */
        boolean f8627O000000o;

        O00000Oo() {
        }

        public final void run() {
            StringPicker.this.O000000o(this.f8627O000000o);
            StringPicker stringPicker = StringPicker.this;
            stringPicker.postDelayed(this, stringPicker.O0000o);
        }
    }

    public static class CustomEditText extends AppCompatEditText {
        public CustomEditText(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public void onEditorAction(int i) {
            super.onEditorAction(i);
            if (i == 6) {
                clearFocus();
            }
        }
    }

    class O000000o implements Runnable {
        O000000o() {
        }

        public final void run() {
            StringPicker.this.O0000ooO = true;
        }
    }

    public void setSelectTextColor(int i) {
        this.O0000oO0 = i;
    }

    public void setUnSelectTextColor(int i) {
        this.O0000oO = i;
    }

    public void setSelectItemBgColor(int i) {
        this.O0000oOO = i;
    }

    public void setSelectTextSize(int i) {
        if (i > 0) {
            this.O000o0o0 = i;
        }
    }

    public void setUnSelectTextSize(int i) {
        if (i > 0) {
            this.O000o0o = i;
        }
    }

    public void setUnit(String str) {
        if (TextUtils.isEmpty(str)) {
            this.O000O0Oo = null;
        } else {
            this.O000O0Oo = str;
        }
    }

    public String getUnit() {
        if (TextUtils.isEmpty(this.O000O0Oo)) {
            return "";
        }
        return this.O000O0Oo;
    }

    public void setUnitFontSize(int i) {
        if (i <= 0) {
            this.O000O0o0 = this.O000o0oo;
        } else {
            this.O000O0o0 = i;
        }
    }

    public void setUnitTextColor(int i) {
        this.O000O0o = i;
    }

    public void setPickerType(short s) {
        this.O000oO0o = s;
    }
}
