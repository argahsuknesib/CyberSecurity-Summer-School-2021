package _m_j;

import android.app.PendingIntent;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.RemoteViews;
import com.xiaomi.push.service.af;

public final class epl extends epm {

    /* renamed from: O000000o  reason: collision with root package name */
    public Bitmap f15703O000000o;
    private int O00000Oo = 16777216;
    private CharSequence O0000Oo;
    private PendingIntent O0000OoO;
    private int O0000Ooo = 16777216;
    private int O0000o00 = 16777216;

    public epl(Context context, int i, String str) {
        super(context, i, str);
    }

    private static Drawable O000000o(int i, int i2, int i3, float f) {
        ShapeDrawable shapeDrawable = new ShapeDrawable();
        shapeDrawable.setShape(new RoundRectShape(new float[]{f, f, f, f, f, f, f, f}, null, null));
        shapeDrawable.getPaint().setColor(i);
        shapeDrawable.getPaint().setStyle(Paint.Style.FILL);
        shapeDrawable.setIntrinsicWidth(i2);
        shapeDrawable.setIntrinsicHeight(i3);
        return shapeDrawable;
    }

    private void O000000o(RemoteViews remoteViews, int i, int i2, int i3, boolean z) {
        if (Build.VERSION.SDK_INT >= 16) {
            int O000000o2 = O000000o(6.0f);
            remoteViews.setViewPadding(i, O000000o2, 0, O000000o2, 0);
        }
        int i4 = z ? -1 : -16777216;
        remoteViews.setTextColor(i2, i4);
        remoteViews.setTextColor(i3, i4);
    }

    /* access modifiers changed from: protected */
    public final String O000000o() {
        return "notification_colorful";
    }

    /* access modifiers changed from: protected */
    public final String O00000Oo() {
        return "notification_colorful_copy";
    }

    /* access modifiers changed from: protected */
    public final boolean O00000o0() {
        if (!esl.O000000o()) {
            return false;
        }
        Resources resources = this.O00000o0.getResources();
        String packageName = this.O00000o0.getPackageName();
        int O000000o2 = O000000o(resources, "icon", "id", packageName);
        int O000000o3 = O000000o(resources, "title", "id", packageName);
        int O000000o4 = O000000o(resources, "content", "id", packageName);
        if (O000000o2 == 0 || O000000o3 == 0 || O000000o4 == 0) {
            return false;
        }
        return true;
    }

    public final epl O000000o(CharSequence charSequence, PendingIntent pendingIntent) {
        if (this.O00000oO) {
            super.addAction(0, charSequence, pendingIntent);
            this.O0000Oo = charSequence;
            this.O0000OoO = pendingIntent;
        }
        return this;
    }

    public final epl O00000Oo(String str) {
        if (this.O00000oO && !TextUtils.isEmpty(str)) {
            try {
                this.O0000Ooo = Color.parseColor(str);
            } catch (Exception unused) {
                duv.O000000o("parse colorful notification button bg color error");
            }
        }
        return this;
    }

    public final epl O00000o0(String str) {
        if (this.O00000oO && !TextUtils.isEmpty(str)) {
            try {
                this.O00000Oo = Color.parseColor(str);
            } catch (Exception unused) {
                duv.O000000o("parse colorful notification bg color error");
            }
        }
        return this;
    }

    private epl O00000o(String str) {
        if (this.O00000oO && !TextUtils.isEmpty(str)) {
            try {
                this.O0000o00 = Color.parseColor(str);
            } catch (Exception unused) {
                duv.O000000o("parse colorful notification image text color error");
            }
        }
        return this;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.emg.O000000o(java.lang.Object, java.lang.String, java.lang.Object[]):T
     arg types: [_m_j.epl, java.lang.String, java.lang.Object[]]
     candidates:
      _m_j.emg.O000000o(java.lang.Class<? extends java.lang.Object>, java.lang.Object, java.lang.String):T
      _m_j.emg.O000000o(java.lang.String, java.lang.String, java.lang.Object[]):T
      _m_j.emg.O000000o(java.lang.Class<?>, java.lang.String, java.lang.Class<?>[]):java.lang.reflect.Method
      _m_j.emg.O000000o(java.lang.reflect.Method[], java.lang.String, java.lang.Class<?>[]):java.lang.reflect.Method
      _m_j.emg.O000000o(java.lang.Object, java.lang.String, java.lang.Object):void
      _m_j.emg.O000000o(java.lang.Object, java.lang.String, java.lang.Object[]):T */
    public final void O00000o() {
        if (this.O00000oO) {
            super.O00000o();
            Resources resources = this.O00000o0.getResources();
            String packageName = this.O00000o0.getPackageName();
            int O000000o2 = O000000o(resources, "icon", "id", packageName);
            if (this.O00000oo == null) {
                O000000o(O000000o2);
            } else {
                this.O00000o.setImageViewBitmap(O000000o2, this.O00000oo);
            }
            int O000000o3 = O000000o(resources, "title", "id", packageName);
            int O000000o4 = O000000o(resources, "content", "id", packageName);
            this.O00000o.setTextViewText(O000000o3, this.O0000O0o);
            this.O00000o.setTextViewText(O000000o4, this.O0000OOo);
            if (!TextUtils.isEmpty(this.O0000Oo)) {
                int O000000o5 = O000000o(resources, "buttonContainer", "id", packageName);
                int O000000o6 = O000000o(resources, "button", "id", packageName);
                int O000000o7 = O000000o(resources, "buttonBg", "id", packageName);
                this.O00000o.setViewVisibility(O000000o5, 0);
                this.O00000o.setTextViewText(O000000o6, this.O0000Oo);
                this.O00000o.setOnClickPendingIntent(O000000o5, this.O0000OoO);
                if (this.O0000Ooo != 16777216) {
                    int O000000o8 = O000000o(70.0f);
                    int O000000o9 = O000000o(29.0f);
                    this.O00000o.setImageViewBitmap(O000000o7, af.a(O000000o(this.O0000Ooo, O000000o8, O000000o9, ((float) O000000o9) / 2.0f)));
                    this.O00000o.setTextColor(O000000o6, O00000Oo(this.O0000Ooo) ? -1 : -16777216);
                }
            }
            int O000000o10 = O000000o(resources, "bg", "id", packageName);
            int O000000o11 = O000000o(resources, "container", "id", packageName);
            if (this.O00000Oo != 16777216) {
                if (esl.O0000O0o() >= 10) {
                    this.O00000o.setImageViewBitmap(O000000o10, af.a(O000000o(this.O00000Oo, 984, 192, 30.0f)));
                } else {
                    this.O00000o.setImageViewBitmap(O000000o10, af.a(O000000o(this.O00000Oo, 984, 192, 0.0f)));
                }
                O000000o(this.O00000o, O000000o11, O000000o3, O000000o4, O00000Oo(this.O00000Oo));
            } else if (this.f15703O000000o != null) {
                if (esl.O0000O0o() >= 10) {
                    this.O00000o.setImageViewBitmap(O000000o10, O00000Oo(this.f15703O000000o));
                } else {
                    this.O00000o.setImageViewBitmap(O000000o10, this.f15703O000000o);
                }
                if (this.O0000Oo0 != null && this.O0000o00 == 16777216) {
                    O00000o((String) this.O0000Oo0.get("notification_image_text_color"));
                }
                int i = this.O0000o00;
                O000000o(this.O00000o, O000000o11, O000000o3, O000000o4, i == 16777216 || !O00000Oo(i));
            } else if (Build.VERSION.SDK_INT >= 24) {
                this.O00000o.setViewVisibility(O000000o2, 8);
                this.O00000o.setViewVisibility(O000000o10, 8);
                try {
                    emg.O000000o((Object) this, "setStyle", esu.O000000o(this.O00000o0, "android.app.Notification$DecoratedCustomViewStyle").getConstructor(new Class[0]).newInstance(new Object[0]));
                } catch (Exception unused) {
                    duv.O000000o("load class DecoratedCustomViewStyle failed");
                }
            }
            Bundle bundle = new Bundle();
            bundle.putBoolean("miui.customHeight", true);
            addExtras(bundle);
            setCustomContentView(this.O00000o);
            return;
        }
        O00000oO();
    }
}
