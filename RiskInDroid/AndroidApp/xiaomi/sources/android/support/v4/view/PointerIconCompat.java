package android.support.v4.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.support.annotation.RestrictTo;
import android.support.v4.os.BuildCompat;

public final class PointerIconCompat {
    static final PointerIconCompatImpl IMPL;
    private Object mPointerIcon;

    interface PointerIconCompatImpl {
        Object create(Bitmap bitmap, float f, float f2);

        Object getSystemIcon(Context context, int i);

        Object load(Resources resources, int i);
    }

    private PointerIconCompat(Object obj) {
        this.mPointerIcon = obj;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final Object getPointerIcon() {
        return this.mPointerIcon;
    }

    static class BasePointerIconCompatImpl implements PointerIconCompatImpl {
        public Object create(Bitmap bitmap, float f, float f2) {
            return null;
        }

        public Object getSystemIcon(Context context, int i) {
            return null;
        }

        public Object load(Resources resources, int i) {
            return null;
        }

        BasePointerIconCompatImpl() {
        }
    }

    static class Api24PointerIconCompatImpl extends BasePointerIconCompatImpl {
        Api24PointerIconCompatImpl() {
        }

        public Object getSystemIcon(Context context, int i) {
            return PointerIconCompatApi24.getSystemIcon(context, i);
        }

        public Object create(Bitmap bitmap, float f, float f2) {
            return PointerIconCompatApi24.create(bitmap, f, f2);
        }

        public Object load(Resources resources, int i) {
            return PointerIconCompatApi24.load(resources, i);
        }
    }

    static {
        if (BuildCompat.isAtLeastN()) {
            IMPL = new Api24PointerIconCompatImpl();
        } else {
            IMPL = new BasePointerIconCompatImpl();
        }
    }

    public static PointerIconCompat getSystemIcon(Context context, int i) {
        return new PointerIconCompat(IMPL.getSystemIcon(context, i));
    }

    public static PointerIconCompat create(Bitmap bitmap, float f, float f2) {
        return new PointerIconCompat(IMPL.create(bitmap, f, f2));
    }

    public static PointerIconCompat load(Resources resources, int i) {
        return new PointerIconCompat(IMPL.load(resources, i));
    }
}
