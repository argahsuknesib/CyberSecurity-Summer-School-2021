package _m_j;

import android.content.Context;
import android.graphics.RectF;
import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.method.TransformationMethod;
import android.util.Log;
import android.widget.TextView;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.ConcurrentHashMap;

public final class gqw {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final RectF f18162O000000o = new RectF();
    private static ConcurrentHashMap<String, Method> O0000o00 = new ConcurrentHashMap<>();
    public int O00000Oo = 0;
    public float O00000o = -1.0f;
    public boolean O00000o0 = false;
    public float O00000oO = -1.0f;
    public float O00000oo = -1.0f;
    public boolean O0000O0o = false;
    public final TextView O0000OOo;
    public float O0000Oo;
    public final Context O0000Oo0;
    public float O0000OoO;
    public float O0000Ooo;
    private int[] O0000o0 = new int[0];
    private TextPaint O0000o0O;
    private boolean O0000o0o;

    public gqw(TextView textView) {
        this.O0000OOo = textView;
        this.O0000Oo0 = this.O0000OOo.getContext();
    }

    public final boolean O000000o() {
        if (this.O00000Oo == 1) {
            if (!this.O0000O0o || this.O0000o0.length == 0) {
                float round = (float) Math.round(this.O00000oO);
                int i = 1;
                while (Math.round(this.O00000o + round) <= Math.round(this.O00000oo)) {
                    i++;
                    round += this.O00000o;
                }
                int[] iArr = new int[i];
                float f = this.O00000oO;
                for (int i2 = 0; i2 < i; i2++) {
                    iArr[i2] = Math.round(f);
                    f += this.O00000o;
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
                this.O0000o0 = iArr;
            }
            this.O00000o0 = true;
        } else {
            this.O00000o0 = false;
        }
        return this.O00000o0;
    }

    public void O000000o(float f) {
        if (f != this.O0000OOo.getPaint().getTextSize()) {
            this.O0000OOo.getPaint().setTextSize(f);
            boolean isInLayout = Build.VERSION.SDK_INT >= 18 ? this.O0000OOo.isInLayout() : false;
            if (this.O0000OOo.getLayout() != null) {
                this.O00000o0 = false;
                try {
                    Method O000000o2 = O000000o("nullLayouts");
                    if (O000000o2 != null) {
                        O000000o2.invoke(this.O0000OOo, new Object[0]);
                    }
                } catch (Exception e) {
                    Log.w("ACTVAutoSizeHelper", "Failed to invoke TextView#nullLayouts() method", e);
                }
                if (!isInLayout) {
                    this.O0000OOo.requestLayout();
                } else {
                    this.O0000OOo.forceLayout();
                }
                this.O0000OOo.invalidate();
            }
        }
    }

    public final int O000000o(float f, float f2) {
        f18162O000000o.setEmpty();
        RectF rectF = f18162O000000o;
        rectF.right = f;
        rectF.bottom = f2;
        int length = this.O0000o0.length;
        if (length == 0) {
            return 15;
        }
        int i = length - 1;
        int i2 = 1;
        int i3 = 0;
        while (i2 <= i) {
            int i4 = (i2 + i) / 2;
            if (O000000o(this.O0000o0[i4], f18162O000000o)) {
                int i5 = i4 + 1;
                i3 = i2;
                i2 = i5;
            } else {
                i3 = i4 - 1;
                i = i3;
            }
        }
        return this.O0000o0[i3];
    }

    private boolean O000000o(int i, RectF rectF) {
        CharSequence transformation;
        CharSequence text = this.O0000OOo.getText();
        TransformationMethod transformationMethod = this.O0000OOo.getTransformationMethod();
        if (!(transformationMethod == null || (transformation = transformationMethod.getTransformation(text, this.O0000OOo)) == null)) {
            text = transformation;
        }
        int maxLines = Build.VERSION.SDK_INT >= 16 ? this.O0000OOo.getMaxLines() : -1;
        TextPaint textPaint = this.O0000o0O;
        if (textPaint == null) {
            this.O0000o0O = new TextPaint();
        } else {
            textPaint.reset();
        }
        this.O0000o0O.set(this.O0000OOo.getPaint());
        this.O0000o0O.setTextSize((float) i);
        Layout.Alignment alignment = (Layout.Alignment) O000000o(this.O0000OOo, "getLayoutAlignment", Layout.Alignment.ALIGN_NORMAL);
        StaticLayout O000000o2 = Build.VERSION.SDK_INT >= 23 ? O000000o(text, alignment, Math.round(rectF.right), maxLines) : O000000o(text, alignment, Math.round(rectF.right));
        if (maxLines == -1 || (O000000o2.getLineCount() <= maxLines && O000000o2.getLineEnd(O000000o2.getLineCount() - 1) == text.length())) {
            return !this.O0000o0o || ((float) O000000o2.getHeight()) <= rectF.bottom;
        }
        return false;
    }

    private StaticLayout O000000o(CharSequence charSequence, Layout.Alignment alignment, int i, int i2) {
        TextDirectionHeuristic textDirectionHeuristic = (TextDirectionHeuristic) O000000o(this.O0000OOo, "getTextDirectionHeuristic", TextDirectionHeuristics.FIRSTSTRONG_LTR);
        StaticLayout.Builder hyphenationFrequency = StaticLayout.Builder.obtain(charSequence, 0, charSequence.length(), this.O0000o0O, i).setAlignment(alignment).setLineSpacing(this.O0000OOo.getLineSpacingExtra(), this.O0000OOo.getLineSpacingMultiplier()).setIncludePad(this.O0000OOo.getIncludeFontPadding()).setBreakStrategy(this.O0000OOo.getBreakStrategy()).setHyphenationFrequency(this.O0000OOo.getHyphenationFrequency());
        if (i2 == -1) {
            i2 = Integer.MAX_VALUE;
        }
        return hyphenationFrequency.setMaxLines(i2).setTextDirection(textDirectionHeuristic).build();
    }

    private StaticLayout O000000o(CharSequence charSequence, Layout.Alignment alignment, int i) {
        boolean z;
        float f;
        float f2;
        if (Build.VERSION.SDK_INT >= 16) {
            f2 = this.O0000OOo.getLineSpacingMultiplier();
            f = this.O0000OOo.getLineSpacingExtra();
            z = this.O0000OOo.getIncludeFontPadding();
        } else {
            f2 = ((Float) O000000o(this.O0000OOo, "getLineSpacingMultiplier", Float.valueOf(1.0f))).floatValue();
            f = ((Float) O000000o(this.O0000OOo, "getLineSpacingExtra", Float.valueOf(0.0f))).floatValue();
            z = ((Boolean) O000000o(this.O0000OOo, "getIncludeFontPadding", Boolean.TRUE)).booleanValue();
        }
        return new StaticLayout(charSequence, this.O0000o0O, i, alignment, f2, f, z);
    }

    public static <T> T O000000o(Object obj, String str, Object obj2) {
        try {
            return O000000o(str).invoke(obj, new Object[0]);
        } catch (Exception e) {
            Log.w("ACTVAutoSizeHelper", "Failed to invoke TextView#" + str + "() method", e);
            return obj2;
        }
    }

    private static Method O000000o(String str) {
        try {
            Method method = O0000o00.get(str);
            if (method == null && (method = TextView.class.getDeclaredMethod(str, new Class[0])) != null) {
                method.setAccessible(true);
                O0000o00.put(str, method);
            }
            return method;
        } catch (Exception e) {
            Log.w("ACTVAutoSizeHelper", "Failed to retrieve TextView#" + str + "() method", e);
            return null;
        }
    }
}
