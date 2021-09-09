package _m_j;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.ColorStateList;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.icu.text.DecimalFormatSymbols;
import android.os.Build;
import android.text.Editable;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import androidx.core.text.PrecomputedTextCompat;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

public final class cy {

    /* renamed from: O000000o  reason: collision with root package name */
    private static Field f14387O000000o;
    private static boolean O00000Oo;
    private static boolean O00000o;
    private static Field O00000o0;

    private static Field O000000o(String str) {
        Field field;
        try {
            field = TextView.class.getDeclaredField(str);
            try {
                field.setAccessible(true);
            } catch (NoSuchFieldException unused) {
            }
        } catch (NoSuchFieldException unused2) {
            field = null;
            Log.e("TextViewCompat", "Could not retrieve " + str + " field.");
            return field;
        }
        return field;
    }

    private static int O000000o(Field field, TextView textView) {
        try {
            return field.getInt(textView);
        } catch (IllegalAccessException unused) {
            Log.d("TextViewCompat", "Could not retrieve value of " + field.getName() + " field.");
            return -1;
        }
    }

    public static void O000000o(TextView textView, Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (Build.VERSION.SDK_INT >= 18) {
            textView.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        } else if (Build.VERSION.SDK_INT >= 17) {
            boolean z = true;
            if (textView.getLayoutDirection() != 1) {
                z = false;
            }
            Drawable drawable5 = z ? drawable3 : drawable;
            if (!z) {
                drawable = drawable3;
            }
            textView.setCompoundDrawables(drawable5, drawable2, drawable, drawable4);
        } else {
            textView.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        }
    }

    public static int O000000o(TextView textView) {
        if (Build.VERSION.SDK_INT >= 16) {
            return textView.getMaxLines();
        }
        if (!O00000o) {
            O00000o0 = O000000o("mMaxMode");
            O00000o = true;
        }
        Field field = O00000o0;
        if (field == null || O000000o(field, textView) != 1) {
            return -1;
        }
        if (!O00000Oo) {
            f14387O000000o = O000000o("mMaximum");
            O00000Oo = true;
        }
        Field field2 = f14387O000000o;
        if (field2 != null) {
            return O000000o(field2, textView);
        }
        return -1;
    }

    public static void O000000o(TextView textView, int i) {
        if (Build.VERSION.SDK_INT >= 23) {
            textView.setTextAppearance(i);
        } else {
            textView.setTextAppearance(textView.getContext(), i);
        }
    }

    public static Drawable[] O00000Oo(TextView textView) {
        if (Build.VERSION.SDK_INT >= 18) {
            return textView.getCompoundDrawablesRelative();
        }
        if (Build.VERSION.SDK_INT < 17) {
            return textView.getCompoundDrawables();
        }
        boolean z = true;
        if (textView.getLayoutDirection() != 1) {
            z = false;
        }
        Drawable[] compoundDrawables = textView.getCompoundDrawables();
        if (z) {
            Drawable drawable = compoundDrawables[2];
            Drawable drawable2 = compoundDrawables[0];
            compoundDrawables[0] = drawable;
            compoundDrawables[2] = drawable2;
        }
        return compoundDrawables;
    }

    public static ActionMode.Callback O000000o(TextView textView, ActionMode.Callback callback) {
        return (Build.VERSION.SDK_INT < 26 || Build.VERSION.SDK_INT > 27 || (callback instanceof O000000o)) ? callback : new O000000o(callback, textView);
    }

    static class O000000o implements ActionMode.Callback {

        /* renamed from: O000000o  reason: collision with root package name */
        private final ActionMode.Callback f14388O000000o;
        private final TextView O00000Oo;
        private Method O00000o;
        private Class<?> O00000o0;
        private boolean O00000oO;
        private boolean O00000oo = false;

        O000000o(ActionMode.Callback callback, TextView textView) {
            this.f14388O000000o = callback;
            this.O00000Oo = textView;
        }

        public final boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
            return this.f14388O000000o.onCreateActionMode(actionMode, menu);
        }

        public final boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
            return this.f14388O000000o.onActionItemClicked(actionMode, menuItem);
        }

        public final void onDestroyActionMode(ActionMode actionMode) {
            this.f14388O000000o.onDestroyActionMode(actionMode);
        }

        private static Intent O000000o() {
            return new Intent().setAction("android.intent.action.PROCESS_TEXT").setType("text/plain");
        }

        public final boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
            Method method;
            boolean z;
            Context context = this.O00000Oo.getContext();
            PackageManager packageManager = context.getPackageManager();
            if (!this.O00000oo) {
                this.O00000oo = true;
                try {
                    this.O00000o0 = Class.forName("com.android.internal.view.menu.MenuBuilder");
                    this.O00000o = this.O00000o0.getDeclaredMethod("removeItemAt", Integer.TYPE);
                    this.O00000oO = true;
                } catch (ClassNotFoundException | NoSuchMethodException unused) {
                    this.O00000o0 = null;
                    this.O00000o = null;
                    this.O00000oO = false;
                }
            }
            try {
                if (!this.O00000oO || !this.O00000o0.isInstance(menu)) {
                    method = menu.getClass().getDeclaredMethod("removeItemAt", Integer.TYPE);
                } else {
                    method = this.O00000o;
                }
                for (int size = menu.size() - 1; size >= 0; size--) {
                    MenuItem item = menu.getItem(size);
                    if (item.getIntent() != null && "android.intent.action.PROCESS_TEXT".equals(item.getIntent().getAction())) {
                        method.invoke(menu, Integer.valueOf(size));
                    }
                }
                ArrayList arrayList = new ArrayList();
                if (context instanceof Activity) {
                    for (ResolveInfo next : packageManager.queryIntentActivities(O000000o(), 0)) {
                        if (!context.getPackageName().equals(next.activityInfo.packageName) && (!next.activityInfo.exported || !(next.activityInfo.permission == null || context.checkSelfPermission(next.activityInfo.permission) == 0))) {
                            z = false;
                        } else {
                            z = true;
                        }
                        if (z) {
                            arrayList.add(next);
                        }
                    }
                }
                for (int i = 0; i < arrayList.size(); i++) {
                    ResolveInfo resolveInfo = (ResolveInfo) arrayList.get(i);
                    MenuItem add = menu.add(0, 0, i + 100, resolveInfo.loadLabel(packageManager));
                    TextView textView = this.O00000Oo;
                    add.setIntent(O000000o().putExtra("android.intent.extra.PROCESS_TEXT_READONLY", !((textView instanceof Editable) && textView.onCheckIsTextEditor() && textView.isEnabled())).setClassName(resolveInfo.activityInfo.packageName, resolveInfo.activityInfo.name)).setShowAsAction(1);
                }
            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused2) {
            }
            return this.f14388O000000o.onPrepareActionMode(actionMode, menu);
        }
    }

    public static void O00000Oo(TextView textView, int i) {
        int i2;
        bf.O000000o(i);
        if (Build.VERSION.SDK_INT >= 28) {
            textView.setFirstBaselineToTopHeight(i);
            return;
        }
        Paint.FontMetricsInt fontMetricsInt = textView.getPaint().getFontMetricsInt();
        if (Build.VERSION.SDK_INT < 16 || textView.getIncludeFontPadding()) {
            i2 = fontMetricsInt.top;
        } else {
            i2 = fontMetricsInt.ascent;
        }
        if (i > Math.abs(i2)) {
            textView.setPadding(textView.getPaddingLeft(), i + i2, textView.getPaddingRight(), textView.getPaddingBottom());
        }
    }

    public static void O00000o0(TextView textView, int i) {
        int i2;
        bf.O000000o(i);
        Paint.FontMetricsInt fontMetricsInt = textView.getPaint().getFontMetricsInt();
        if (Build.VERSION.SDK_INT < 16 || textView.getIncludeFontPadding()) {
            i2 = fontMetricsInt.bottom;
        } else {
            i2 = fontMetricsInt.descent;
        }
        if (i > Math.abs(i2)) {
            textView.setPadding(textView.getPaddingLeft(), textView.getPaddingTop(), textView.getPaddingRight(), i - i2);
        }
    }

    public static void O00000o(TextView textView, int i) {
        bf.O000000o(i);
        int fontMetricsInt = textView.getPaint().getFontMetricsInt(null);
        if (i != fontMetricsInt) {
            textView.setLineSpacing((float) (i - fontMetricsInt), 1.0f);
        }
    }

    public static PrecomputedTextCompat.O000000o O00000o0(TextView textView) {
        if (Build.VERSION.SDK_INT >= 28) {
            return new PrecomputedTextCompat.O000000o(textView.getTextMetricsParams());
        }
        PrecomputedTextCompat.O000000o.C0012O000000o o000000o = new PrecomputedTextCompat.O000000o.C0012O000000o(new TextPaint(textView.getPaint()));
        if (Build.VERSION.SDK_INT >= 23) {
            o000000o.O00000Oo = textView.getBreakStrategy();
            o000000o.O00000o0 = textView.getHyphenationFrequency();
        }
        if (Build.VERSION.SDK_INT >= 18) {
            o000000o.f2839O000000o = O00000o(textView);
        }
        return o000000o.O000000o();
    }

    public static void O000000o(TextView textView, PrecomputedTextCompat precomputedTextCompat) {
        if (Build.VERSION.SDK_INT >= 29) {
            textView.setText(precomputedTextCompat.O000000o());
        } else if (O00000o0(textView).O000000o(precomputedTextCompat.f2837O000000o)) {
            textView.setText(precomputedTextCompat);
        } else {
            throw new IllegalArgumentException("Given text can not be applied to TextView.");
        }
    }

    private static TextDirectionHeuristic O00000o(TextView textView) {
        if (textView.getTransformationMethod() instanceof PasswordTransformationMethod) {
            return TextDirectionHeuristics.LTR;
        }
        boolean z = false;
        if (Build.VERSION.SDK_INT < 28 || (textView.getInputType() & 15) != 3) {
            if (textView.getLayoutDirection() == 1) {
                z = true;
            }
            switch (textView.getTextDirection()) {
                case 2:
                    return TextDirectionHeuristics.ANYRTL_LTR;
                case 3:
                    return TextDirectionHeuristics.LTR;
                case 4:
                    return TextDirectionHeuristics.RTL;
                case 5:
                    return TextDirectionHeuristics.LOCALE;
                case 6:
                    return TextDirectionHeuristics.FIRSTSTRONG_LTR;
                case 7:
                    return TextDirectionHeuristics.FIRSTSTRONG_RTL;
                default:
                    if (z) {
                        return TextDirectionHeuristics.FIRSTSTRONG_RTL;
                    }
                    return TextDirectionHeuristics.FIRSTSTRONG_LTR;
            }
        } else {
            byte directionality = Character.getDirectionality(DecimalFormatSymbols.getInstance(textView.getTextLocale()).getDigitStrings()[0].codePointAt(0));
            if (directionality == 1 || directionality == 2) {
                return TextDirectionHeuristics.RTL;
            }
            return TextDirectionHeuristics.LTR;
        }
    }

    public static void O000000o(TextView textView, ColorStateList colorStateList) {
        bf.O000000o(textView);
        if (Build.VERSION.SDK_INT >= 24) {
            textView.setCompoundDrawableTintList(colorStateList);
        } else if (textView instanceof da) {
            ((da) textView).setSupportCompoundDrawablesTintList(colorStateList);
        }
    }

    public static void O000000o(TextView textView, PorterDuff.Mode mode) {
        bf.O000000o(textView);
        if (Build.VERSION.SDK_INT >= 24) {
            textView.setCompoundDrawableTintMode(mode);
        } else if (textView instanceof da) {
            ((da) textView).setSupportCompoundDrawablesTintMode(mode);
        }
    }
}
