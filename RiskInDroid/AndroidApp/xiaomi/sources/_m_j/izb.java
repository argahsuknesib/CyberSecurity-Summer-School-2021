package _m_j;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.view.View;
import android.widget.Toast;
import java.lang.reflect.Field;

public final class izb extends Toast {

    /* renamed from: O000000o  reason: collision with root package name */
    private final Toast f1659O000000o;

    private izb(Context context, Toast toast) {
        super(context);
        this.f1659O000000o = toast;
    }

    public static izb O000000o(Context context, CharSequence charSequence, int i) {
        Toast makeText = Toast.makeText(context, charSequence, i);
        O000000o(makeText.getView(), new iza(context, makeText));
        return new izb(context, makeText);
    }

    public static Toast O000000o(Context context, int i, int i2) throws Resources.NotFoundException {
        return O000000o(context, context.getResources().getText(i), i2);
    }

    public final void show() {
        this.f1659O000000o.show();
    }

    public final void setDuration(int i) {
        this.f1659O000000o.setDuration(i);
    }

    public final void setGravity(int i, int i2, int i3) {
        this.f1659O000000o.setGravity(i, i2, i3);
    }

    public final void setMargin(float f, float f2) {
        this.f1659O000000o.setMargin(f, f2);
    }

    public final void setText(int i) {
        this.f1659O000000o.setText(i);
    }

    public final void setText(CharSequence charSequence) {
        this.f1659O000000o.setText(charSequence);
    }

    public final void setView(View view) {
        this.f1659O000000o.setView(view);
        O000000o(view, new iza(view.getContext(), this));
    }

    public final float getHorizontalMargin() {
        return this.f1659O000000o.getHorizontalMargin();
    }

    public final float getVerticalMargin() {
        return this.f1659O000000o.getVerticalMargin();
    }

    public final int getDuration() {
        return this.f1659O000000o.getDuration();
    }

    public final int getGravity() {
        return this.f1659O000000o.getGravity();
    }

    public final int getXOffset() {
        return this.f1659O000000o.getXOffset();
    }

    public final int getYOffset() {
        return this.f1659O000000o.getYOffset();
    }

    public final View getView() {
        return this.f1659O000000o.getView();
    }

    private static void O000000o(View view, Context context) {
        if (Build.VERSION.SDK_INT == 25) {
            try {
                Field declaredField = View.class.getDeclaredField("mContext");
                declaredField.setAccessible(true);
                declaredField.set(view, context);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }
}
