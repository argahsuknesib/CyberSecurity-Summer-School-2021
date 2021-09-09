package _m_j;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatEditText;
import com.google.android.exoplayer2.source.ExtractorMediaSource;
import com.xiaomi.smarthome.R;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.ConcurrentHashMap;

public final class OOOO0o0 {
    private static final RectF O00000oo = new RectF();
    private static ConcurrentHashMap<String, Method> O0000O0o = new ConcurrentHashMap<>();
    private static ConcurrentHashMap<String, Field> O0000OOo = new ConcurrentHashMap<>();

    /* renamed from: O000000o  reason: collision with root package name */
    public int f12330O000000o = 0;
    public float O00000Oo = -1.0f;
    public float O00000o = -1.0f;
    public float O00000o0 = -1.0f;
    public int[] O00000oO = new int[0];
    private boolean O0000Oo = false;
    private boolean O0000Oo0 = false;
    private TextPaint O0000OoO;
    private final TextView O0000Ooo;
    private final O000000o O0000o0;
    private final Context O0000o00;

    static class O000000o {
        /* access modifiers changed from: package-private */
        public void O000000o(StaticLayout.Builder builder, TextView textView) {
        }

        O000000o() {
        }

        /* access modifiers changed from: package-private */
        public boolean O000000o(TextView textView) {
            return ((Boolean) OOOO0o0.O000000o(textView, "getHorizontallyScrolling", Boolean.FALSE)).booleanValue();
        }
    }

    static class O00000Oo extends O000000o {
        O00000Oo() {
        }

        /* access modifiers changed from: package-private */
        public void O000000o(StaticLayout.Builder builder, TextView textView) {
            builder.setTextDirection((TextDirectionHeuristic) OOOO0o0.O000000o(textView, "getTextDirectionHeuristic", TextDirectionHeuristics.FIRSTSTRONG_LTR));
        }
    }

    static class O00000o0 extends O00000Oo {
        O00000o0() {
        }

        /* access modifiers changed from: package-private */
        public final boolean O000000o(TextView textView) {
            return textView.isHorizontallyScrollable();
        }

        /* access modifiers changed from: package-private */
        public final void O000000o(StaticLayout.Builder builder, TextView textView) {
            builder.setTextDirection(textView.getTextDirectionHeuristic());
        }
    }

    OOOO0o0(TextView textView) {
        this.O0000Ooo = textView;
        this.O0000o00 = this.O0000Ooo.getContext();
        if (Build.VERSION.SDK_INT >= 29) {
            this.O0000o0 = new O00000o0();
        } else if (Build.VERSION.SDK_INT >= 23) {
            this.O0000o0 = new O00000Oo();
        } else {
            this.O0000o0 = new O000000o();
        }
    }

    /* access modifiers changed from: package-private */
    public final void O000000o(AttributeSet attributeSet, int i) {
        int resourceId;
        TypedArray obtainStyledAttributes = this.O0000o00.obtainStyledAttributes(attributeSet, new int[]{16842804, R.attr.autoSizeMaxTextSize, R.attr.autoSizeMinTextSize, R.attr.autoSizePresetSizes, R.attr.autoSizeStepGranularity, R.attr.autoSizeTextType, R.attr.drawableBottomCompat, R.attr.drawableEndCompat, R.attr.drawableLeftCompat, R.attr.drawableRightCompat, R.attr.drawableStartCompat, R.attr.drawableTint, R.attr.drawableTintMode, R.attr.drawableTopCompat, R.attr.firstBaselineToTopHeight, R.attr.fontFamily, R.attr.fontVariationSettings, R.attr.lastBaselineToBottomHeight, R.attr.lineHeight, R.attr.textAllCaps, R.attr.textLocale}, i, 0);
        TextView textView = this.O0000Ooo;
        cb.O000000o(textView, textView.getContext(), new int[]{16842804, R.attr.autoSizeMaxTextSize, R.attr.autoSizeMinTextSize, R.attr.autoSizePresetSizes, R.attr.autoSizeStepGranularity, R.attr.autoSizeTextType, R.attr.drawableBottomCompat, R.attr.drawableEndCompat, R.attr.drawableLeftCompat, R.attr.drawableRightCompat, R.attr.drawableStartCompat, R.attr.drawableTint, R.attr.drawableTintMode, R.attr.drawableTopCompat, R.attr.firstBaselineToTopHeight, R.attr.fontFamily, R.attr.fontVariationSettings, R.attr.lastBaselineToBottomHeight, R.attr.lineHeight, R.attr.textAllCaps, R.attr.textLocale}, attributeSet, obtainStyledAttributes, i);
        if (obtainStyledAttributes.hasValue(5)) {
            this.f12330O000000o = obtainStyledAttributes.getInt(5, 0);
        }
        float dimension = obtainStyledAttributes.hasValue(4) ? obtainStyledAttributes.getDimension(4, -1.0f) : -1.0f;
        float dimension2 = obtainStyledAttributes.hasValue(2) ? obtainStyledAttributes.getDimension(2, -1.0f) : -1.0f;
        float dimension3 = obtainStyledAttributes.hasValue(1) ? obtainStyledAttributes.getDimension(1, -1.0f) : -1.0f;
        if (obtainStyledAttributes.hasValue(3) && (resourceId = obtainStyledAttributes.getResourceId(3, 0)) > 0) {
            TypedArray obtainTypedArray = obtainStyledAttributes.getResources().obtainTypedArray(resourceId);
            O000000o(obtainTypedArray);
            obtainTypedArray.recycle();
        }
        obtainStyledAttributes.recycle();
        if (!O00000oo()) {
            this.f12330O000000o = 0;
        } else if (this.f12330O000000o == 1) {
            if (!this.O0000Oo) {
                DisplayMetrics displayMetrics = this.O0000o00.getResources().getDisplayMetrics();
                if (dimension2 == -1.0f) {
                    dimension2 = TypedValue.applyDimension(2, 12.0f, displayMetrics);
                }
                if (dimension3 == -1.0f) {
                    dimension3 = TypedValue.applyDimension(2, 112.0f, displayMetrics);
                }
                if (dimension == -1.0f) {
                    dimension = 1.0f;
                }
                O000000o(dimension2, dimension3, dimension);
            }
            O00000o();
        }
    }

    /* access modifiers changed from: package-private */
    public final void O000000o(int i) {
        if (!O00000oo()) {
            return;
        }
        if (i == 0) {
            O00000oO();
        } else if (i == 1) {
            DisplayMetrics displayMetrics = this.O0000o00.getResources().getDisplayMetrics();
            O000000o(TypedValue.applyDimension(2, 12.0f, displayMetrics), TypedValue.applyDimension(2, 112.0f, displayMetrics), 1.0f);
            if (O00000o()) {
                O000000o();
            }
        } else {
            throw new IllegalArgumentException("Unknown auto-size text type: ".concat(String.valueOf(i)));
        }
    }

    /* access modifiers changed from: package-private */
    public final void O000000o(int i, int i2, int i3, int i4) throws IllegalArgumentException {
        if (O00000oo()) {
            DisplayMetrics displayMetrics = this.O0000o00.getResources().getDisplayMetrics();
            O000000o(TypedValue.applyDimension(i4, (float) i, displayMetrics), TypedValue.applyDimension(i4, (float) i2, displayMetrics), TypedValue.applyDimension(i4, (float) i3, displayMetrics));
            if (O00000o()) {
                O000000o();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void O000000o(int[] iArr, int i) throws IllegalArgumentException {
        if (O00000oo()) {
            int length = iArr.length;
            if (length > 0) {
                int[] iArr2 = new int[length];
                if (i == 0) {
                    iArr2 = Arrays.copyOf(iArr, length);
                } else {
                    DisplayMetrics displayMetrics = this.O0000o00.getResources().getDisplayMetrics();
                    for (int i2 = 0; i2 < length; i2++) {
                        iArr2[i2] = Math.round(TypedValue.applyDimension(i, (float) iArr[i2], displayMetrics));
                    }
                }
                this.O00000oO = O000000o(iArr2);
                if (!O00000o0()) {
                    throw new IllegalArgumentException("None of the preset sizes is valid: " + Arrays.toString(iArr));
                }
            } else {
                this.O0000Oo = false;
            }
            if (O00000o()) {
                O000000o();
            }
        }
    }

    private void O000000o(TypedArray typedArray) {
        int length = typedArray.length();
        int[] iArr = new int[length];
        if (length > 0) {
            for (int i = 0; i < length; i++) {
                iArr[i] = typedArray.getDimensionPixelSize(i, -1);
            }
            this.O00000oO = O000000o(iArr);
            O00000o0();
        }
    }

    private boolean O00000o0() {
        int length = this.O00000oO.length;
        this.O0000Oo = length > 0;
        if (this.O0000Oo) {
            this.f12330O000000o = 1;
            int[] iArr = this.O00000oO;
            this.O00000o0 = (float) iArr[0];
            this.O00000o = (float) iArr[length - 1];
            this.O00000Oo = -1.0f;
        }
        return this.O0000Oo;
    }

    private static int[] O000000o(int[] iArr) {
        if (r0 == 0) {
            return iArr;
        }
        Arrays.sort(iArr);
        ArrayList arrayList = new ArrayList();
        for (int i : iArr) {
            if (i > 0 && Collections.binarySearch(arrayList, Integer.valueOf(i)) < 0) {
                arrayList.add(Integer.valueOf(i));
            }
        }
        if (r0 == arrayList.size()) {
            return iArr;
        }
        int size = arrayList.size();
        int[] iArr2 = new int[size];
        for (int i2 = 0; i2 < size; i2++) {
            iArr2[i2] = ((Integer) arrayList.get(i2)).intValue();
        }
        return iArr2;
    }

    private void O000000o(float f, float f2, float f3) throws IllegalArgumentException {
        if (f <= 0.0f) {
            throw new IllegalArgumentException("Minimum auto-size text size (" + f + "px) is less or equal to (0px)");
        } else if (f2 <= f) {
            throw new IllegalArgumentException("Maximum auto-size text size (" + f2 + "px) is less or equal to minimum auto-size text size (" + f + "px)");
        } else if (f3 > 0.0f) {
            this.f12330O000000o = 1;
            this.O00000o0 = f;
            this.O00000o = f2;
            this.O00000Oo = f3;
            this.O0000Oo = false;
        } else {
            throw new IllegalArgumentException("The auto-size step granularity (" + f3 + "px) is less or equal to (0px)");
        }
    }

    private boolean O00000o() {
        if (!O00000oo() || this.f12330O000000o != 1) {
            this.O0000Oo0 = false;
        } else {
            if (!this.O0000Oo || this.O00000oO.length == 0) {
                int floor = ((int) Math.floor((double) ((this.O00000o - this.O00000o0) / this.O00000Oo))) + 1;
                int[] iArr = new int[floor];
                for (int i = 0; i < floor; i++) {
                    iArr[i] = Math.round(this.O00000o0 + (((float) i) * this.O00000Oo));
                }
                this.O00000oO = O000000o(iArr);
            }
            this.O0000Oo0 = true;
        }
        return this.O0000Oo0;
    }

    public final void O000000o() {
        int i;
        if (O00000Oo()) {
            if (this.O0000Oo0) {
                if (this.O0000Ooo.getMeasuredHeight() > 0 && this.O0000Ooo.getMeasuredWidth() > 0) {
                    if (this.O0000o0.O000000o(this.O0000Ooo)) {
                        i = ExtractorMediaSource.DEFAULT_LOADING_CHECK_INTERVAL_BYTES;
                    } else {
                        i = (this.O0000Ooo.getMeasuredWidth() - this.O0000Ooo.getTotalPaddingLeft()) - this.O0000Ooo.getTotalPaddingRight();
                    }
                    int height = (this.O0000Ooo.getHeight() - this.O0000Ooo.getCompoundPaddingBottom()) - this.O0000Ooo.getCompoundPaddingTop();
                    if (i > 0 && height > 0) {
                        synchronized (O00000oo) {
                            O00000oo.setEmpty();
                            O00000oo.right = (float) i;
                            O00000oo.bottom = (float) height;
                            float O000000o2 = (float) O000000o(O00000oo);
                            if (O000000o2 != this.O0000Ooo.getTextSize()) {
                                O000000o(0, O000000o2);
                            }
                        }
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            }
            this.O0000Oo0 = true;
        }
    }

    private void O00000oO() {
        this.f12330O000000o = 0;
        this.O00000o0 = -1.0f;
        this.O00000o = -1.0f;
        this.O00000Oo = -1.0f;
        this.O00000oO = new int[0];
        this.O0000Oo0 = false;
    }

    /* access modifiers changed from: package-private */
    public final void O000000o(int i, float f) {
        Resources resources;
        Context context = this.O0000o00;
        if (context == null) {
            resources = Resources.getSystem();
        } else {
            resources = context.getResources();
        }
        O000000o(TypedValue.applyDimension(i, f, resources.getDisplayMetrics()));
    }

    private void O000000o(float f) {
        if (f != this.O0000Ooo.getPaint().getTextSize()) {
            this.O0000Ooo.getPaint().setTextSize(f);
            boolean isInLayout = Build.VERSION.SDK_INT >= 18 ? this.O0000Ooo.isInLayout() : false;
            if (this.O0000Ooo.getLayout() != null) {
                this.O0000Oo0 = false;
                try {
                    Method O000000o2 = O000000o("nullLayouts");
                    if (O000000o2 != null) {
                        O000000o2.invoke(this.O0000Ooo, new Object[0]);
                    }
                } catch (Exception e) {
                    Log.w("ACTVAutoSizeHelper", "Failed to invoke TextView#nullLayouts() method", e);
                }
                if (!isInLayout) {
                    this.O0000Ooo.requestLayout();
                } else {
                    this.O0000Ooo.forceLayout();
                }
                this.O0000Ooo.invalidate();
            }
        }
    }

    private int O000000o(RectF rectF) {
        int length = this.O00000oO.length;
        if (length != 0) {
            int i = length - 1;
            int i2 = 1;
            int i3 = 0;
            while (i2 <= i) {
                int i4 = (i2 + i) / 2;
                if (O000000o(this.O00000oO[i4], rectF)) {
                    int i5 = i4 + 1;
                    i3 = i2;
                    i2 = i5;
                } else {
                    i3 = i4 - 1;
                    i = i3;
                }
            }
            return this.O00000oO[i3];
        }
        throw new IllegalStateException("No available text sizes to choose from.");
    }

    private void O00000Oo(int i) {
        TextPaint textPaint = this.O0000OoO;
        if (textPaint == null) {
            this.O0000OoO = new TextPaint();
        } else {
            textPaint.reset();
        }
        this.O0000OoO.set(this.O0000Ooo.getPaint());
        this.O0000OoO.setTextSize((float) i);
    }

    private StaticLayout O000000o(CharSequence charSequence, Layout.Alignment alignment, int i, int i2) {
        if (Build.VERSION.SDK_INT >= 23) {
            return O00000Oo(charSequence, alignment, i, i2);
        }
        if (Build.VERSION.SDK_INT >= 16) {
            return new StaticLayout(charSequence, this.O0000OoO, i, alignment, this.O0000Ooo.getLineSpacingMultiplier(), this.O0000Ooo.getLineSpacingExtra(), this.O0000Ooo.getIncludeFontPadding());
        }
        return new StaticLayout(charSequence, this.O0000OoO, i, alignment, ((Float) O00000Oo(this.O0000Ooo, "mSpacingMult", Float.valueOf(1.0f))).floatValue(), ((Float) O00000Oo(this.O0000Ooo, "mSpacingAdd", Float.valueOf(0.0f))).floatValue(), ((Boolean) O00000Oo(this.O0000Ooo, "mIncludePad", Boolean.TRUE)).booleanValue());
    }

    private boolean O000000o(int i, RectF rectF) {
        CharSequence transformation;
        CharSequence text = this.O0000Ooo.getText();
        TransformationMethod transformationMethod = this.O0000Ooo.getTransformationMethod();
        if (!(transformationMethod == null || (transformation = transformationMethod.getTransformation(text, this.O0000Ooo)) == null)) {
            text = transformation;
        }
        int maxLines = Build.VERSION.SDK_INT >= 16 ? this.O0000Ooo.getMaxLines() : -1;
        O00000Oo(i);
        StaticLayout O000000o2 = O000000o(text, (Layout.Alignment) O000000o(this.O0000Ooo, "getLayoutAlignment", Layout.Alignment.ALIGN_NORMAL), Math.round(rectF.right), maxLines);
        return (maxLines == -1 || (O000000o2.getLineCount() <= maxLines && O000000o2.getLineEnd(O000000o2.getLineCount() - 1) == text.length())) && ((float) O000000o2.getHeight()) <= rectF.bottom;
    }

    private StaticLayout O00000Oo(CharSequence charSequence, Layout.Alignment alignment, int i, int i2) {
        StaticLayout.Builder obtain = StaticLayout.Builder.obtain(charSequence, 0, charSequence.length(), this.O0000OoO, i);
        StaticLayout.Builder hyphenationFrequency = obtain.setAlignment(alignment).setLineSpacing(this.O0000Ooo.getLineSpacingExtra(), this.O0000Ooo.getLineSpacingMultiplier()).setIncludePad(this.O0000Ooo.getIncludeFontPadding()).setBreakStrategy(this.O0000Ooo.getBreakStrategy()).setHyphenationFrequency(this.O0000Ooo.getHyphenationFrequency());
        if (i2 == -1) {
            i2 = Integer.MAX_VALUE;
        }
        hyphenationFrequency.setMaxLines(i2);
        try {
            this.O0000o0.O000000o(obtain, this.O0000Ooo);
        } catch (ClassCastException unused) {
            Log.w("ACTVAutoSizeHelper", "Failed to obtain TextDirectionHeuristic, auto size may be incorrect");
        }
        return obtain.build();
    }

    static <T> T O000000o(Object obj, String str, T t) {
        try {
            return O000000o(str).invoke(obj, new Object[0]);
        } catch (Exception e) {
            Log.w("ACTVAutoSizeHelper", "Failed to invoke TextView#" + str + "() method", e);
            return t;
        }
    }

    private static <T> T O00000Oo(Object obj, String str, T t) {
        try {
            Field O00000Oo2 = O00000Oo(str);
            if (O00000Oo2 == null) {
                return t;
            }
            return O00000Oo2.get(obj);
        } catch (IllegalAccessException e) {
            Log.w("ACTVAutoSizeHelper", "Failed to access TextView#" + str + " member", e);
            return t;
        }
    }

    private static Method O000000o(String str) {
        try {
            Method method = O0000O0o.get(str);
            if (method == null && (method = TextView.class.getDeclaredMethod(str, new Class[0])) != null) {
                method.setAccessible(true);
                O0000O0o.put(str, method);
            }
            return method;
        } catch (Exception e) {
            Log.w("ACTVAutoSizeHelper", "Failed to retrieve TextView#" + str + "() method", e);
            return null;
        }
    }

    private static Field O00000Oo(String str) {
        try {
            Field field = O0000OOo.get(str);
            if (field == null && (field = TextView.class.getDeclaredField(str)) != null) {
                field.setAccessible(true);
                O0000OOo.put(str, field);
            }
            return field;
        } catch (NoSuchFieldException e) {
            Log.w("ACTVAutoSizeHelper", "Failed to access TextView#" + str + " member", e);
            return null;
        }
    }

    public final boolean O00000Oo() {
        return O00000oo() && this.f12330O000000o != 0;
    }

    private boolean O00000oo() {
        return !(this.O0000Ooo instanceof AppCompatEditText);
    }
}
