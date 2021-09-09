package _m_j;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build;
import android.text.Editable;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextWatcher;
import android.text.method.SingleLineTransformationMethod;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.xiaomi.smarthome.R;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public final class gqx {

    /* renamed from: O000000o  reason: collision with root package name */
    public TextView f18163O000000o;
    public boolean O00000Oo;
    private float O00000o = -1.0f;
    private float O00000o0 = -1.0f;
    private boolean O00000oO = false;
    private final Context O00000oo;
    private TextPaint O0000O0o;
    private boolean O0000OOo = true;
    private float O0000Oo;
    private int[] O0000Oo0 = new int[0];
    private TextWatcher O0000OoO = new O00000Oo(this, (byte) 0);
    private View.OnLayoutChangeListener O0000Ooo = new O000000o(this, (byte) 0);

    public gqx(TextView textView) {
        this.f18163O000000o = textView;
        this.O00000oo = this.f18163O000000o.getContext();
        this.O0000O0o = new TextPaint();
        O000000o(this.f18163O000000o.getTextSize());
    }

    public final void O000000o(AttributeSet attributeSet, int i) {
        TypedArray obtainStyledAttributes = this.O00000oo.obtainStyledAttributes(attributeSet, new int[]{R.attr.autoSize, R.attr.maxTextSize, R.attr.minTextSize}, i, 0);
        if (obtainStyledAttributes.hasValue(0)) {
            this.O0000OOo = obtainStyledAttributes.getBoolean(0, true);
        }
        float dimension = obtainStyledAttributes.hasValue(2) ? obtainStyledAttributes.getDimension(2, -1.0f) : -1.0f;
        float dimension2 = obtainStyledAttributes.hasValue(1) ? obtainStyledAttributes.getDimension(1, -1.0f) : -1.0f;
        obtainStyledAttributes.recycle();
        if (!O00000o0()) {
            this.O0000OOo = false;
        } else if (this.O0000OOo) {
            this.f18163O000000o.addTextChangedListener(this.O0000OoO);
            this.f18163O000000o.addOnLayoutChangeListener(this.O0000Ooo);
            DisplayMetrics displayMetrics = this.O00000oo.getResources().getDisplayMetrics();
            if (dimension == -1.0f) {
                dimension = TypedValue.applyDimension(0, 24.0f, displayMetrics);
            }
            if (dimension2 == -1.0f) {
                dimension2 = TypedValue.applyDimension(0, 42.0f, displayMetrics);
            }
            if (dimension <= 0.0f) {
                throw new IllegalArgumentException("Minimum auto-size text size (" + dimension + "px) is less or equal to (0px)");
            } else if (dimension2 > dimension) {
                this.O0000OOo = true;
                this.O00000o0 = dimension;
                this.O00000o = dimension2;
                if (O00000Oo()) {
                    O000000o();
                }
            } else {
                throw new IllegalArgumentException("Maximum auto-size text size (" + dimension2 + "px) is less or equal to minimum auto-size text size (" + dimension + "px)");
            }
        } else {
            this.f18163O000000o.removeTextChangedListener(this.O0000OoO);
            this.f18163O000000o.removeOnLayoutChangeListener(this.O0000Ooo);
        }
    }

    private boolean O00000Oo() {
        if (!O00000o0() || !this.O0000OOo) {
            this.O00000oO = false;
        } else {
            float round = (float) Math.round(this.O00000o0);
            int i = 1;
            while (true) {
                round += 1.0f;
                if (Math.round(round) > Math.round(this.O00000o)) {
                    break;
                }
                i++;
            }
            int[] iArr = new int[i];
            float f = this.O00000o0;
            for (int i2 = 0; i2 < i; i2++) {
                iArr[i2] = Math.round(f);
                f += 1.0f;
            }
            if (r3 != 0) {
                Arrays.sort(iArr);
                ArrayList arrayList = new ArrayList();
                for (int i3 : iArr) {
                    if (i3 > 0 && Collections.binarySearch(arrayList, Integer.valueOf(i3)) < 0) {
                        arrayList.add(Integer.valueOf(i3));
                    }
                }
                if (r3 != arrayList.size()) {
                    int size = arrayList.size();
                    int[] iArr2 = new int[size];
                    for (int i4 = 0; i4 < size; i4++) {
                        iArr2[i4] = ((Integer) arrayList.get(i4)).intValue();
                    }
                    iArr = iArr2;
                }
            }
            this.O0000Oo0 = iArr;
            this.O00000oO = true;
        }
        return this.O00000oO;
    }

    private boolean O00000o0() {
        return !(this.f18163O000000o instanceof EditText);
    }

    public final void O000000o() {
        this.O00000Oo = true;
        O000000o(this.f18163O000000o, this.O0000O0o, this.O00000o0, this.O00000o, O00000o());
        this.O00000Oo = false;
    }

    private int O00000o() {
        if (Build.VERSION.SDK_INT >= 16) {
            return this.f18163O000000o.getMaxLines();
        }
        TransformationMethod transformationMethod = this.f18163O000000o.getTransformationMethod();
        return (transformationMethod == null || !(transformationMethod instanceof SingleLineTransformationMethod)) ? -1 : 1;
    }

    private void O000000o(TextView textView, TextPaint textPaint, float f, float f2, int i) {
        float f3;
        if (i > 0 && i != Integer.MAX_VALUE) {
            int width = (textView.getWidth() - textView.getPaddingLeft()) - textView.getPaddingRight();
            System.out.println("targetWidth:   ".concat(String.valueOf(width)));
            if (width > 0) {
                CharSequence text = textView.getText();
                TransformationMethod transformationMethod = textView.getTransformationMethod();
                if (transformationMethod != null) {
                    text = transformationMethod.getTransformation(text, textView);
                }
                Resources system = Resources.getSystem();
                Context context = this.O00000oo;
                if (context != null) {
                    system = context.getResources();
                }
                DisplayMetrics displayMetrics = system.getDisplayMetrics();
                textPaint.set(textView.getPaint());
                textPaint.setTextSize(f2);
                float f4 = (float) width;
                if (textPaint.measureText(text, 0, text.length()) > f4 || O000000o(text, textPaint, f2, f4, displayMetrics) > i) {
                    f3 = O000000o(text, textPaint, width, displayMetrics);
                } else {
                    f3 = f2;
                }
                if (f3 < f) {
                    f3 = f;
                }
                System.out.println("autofit size in px:   ".concat(String.valueOf(f3)));
                textView.setTextSize(0, f3);
            }
        }
    }

    private float O000000o(CharSequence charSequence, TextPaint textPaint, int i, DisplayMetrics displayMetrics) {
        int i2;
        int length = this.O0000Oo0.length - 1;
        while (true) {
            if (length < 0) {
                i2 = this.O0000Oo0[0];
                break;
            }
            textPaint.setTextSize(TypedValue.applyDimension(0, (float) this.O0000Oo0[length], displayMetrics));
            int lineCount = new StaticLayout(charSequence, textPaint, i, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true).getLineCount();
            System.out.println("尝试第" + length + "个字号: " + this.O0000Oo0[length] + " ,lineCount " + lineCount);
            if (lineCount <= 1) {
                i2 = this.O0000Oo0[length];
                break;
            }
            length--;
        }
        return (float) i2;
    }

    private static int O000000o(CharSequence charSequence, TextPaint textPaint, float f, float f2, DisplayMetrics displayMetrics) {
        textPaint.setTextSize(TypedValue.applyDimension(0, f, displayMetrics));
        return new StaticLayout(charSequence, textPaint, (int) f2, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true).getLineCount();
    }

    public final void O000000o(float f) {
        if (this.O0000Oo != f) {
            this.O0000Oo = f;
        }
    }

    class O00000Oo implements TextWatcher {
        public final void afterTextChanged(Editable editable) {
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        private O00000Oo() {
        }

        /* synthetic */ O00000Oo(gqx gqx, byte b) {
            this();
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            gqx.this.O000000o();
        }
    }

    class O000000o implements View.OnLayoutChangeListener {
        private O000000o() {
        }

        /* synthetic */ O000000o(gqx gqx, byte b) {
            this();
        }

        public final void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            gqx.this.O000000o();
        }
    }
}
