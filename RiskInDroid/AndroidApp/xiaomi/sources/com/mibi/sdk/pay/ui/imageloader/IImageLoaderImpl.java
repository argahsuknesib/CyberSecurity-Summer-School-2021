package com.mibi.sdk.pay.ui.imageloader;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.mibi.sdk.common.utils.MibiLog;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class IImageLoaderImpl implements IImageLoader {
    private Method mAntiShakeDurationMethod;
    private Method mFadeDurationMethod;
    private Method mGetMethod;
    private Object mImage;
    private Class<?> mImageClass;
    private Method mIntoMethod;
    private Method mLoadMethod;
    private Method mPlaceholderMethodDrawable;
    private Method mPlaceholderMethodInt;

    public IImageLoader get(Context context) {
        try {
            this.mImage = getImage(context);
        } catch (Exception e) {
            MibiLog.d("IImageLoaderImpl", e.getMessage());
        }
        return this;
    }

    public IImageLoader load(String str) {
        try {
            getLoadMethod().invoke(this.mImage, str);
        } catch (Exception e) {
            MibiLog.d("IImageLoaderImpl", e.getMessage());
        }
        return this;
    }

    public IImageLoader placeholder(int i) {
        try {
            getPlaceholderMethodInt().invoke(this.mImage, Integer.valueOf(i));
        } catch (Exception e) {
            MibiLog.d("IImageLoaderImpl", e.getMessage());
        }
        return this;
    }

    public IImageLoader placeholder(Drawable drawable) {
        try {
            getPlaceholderMethodDrawable().invoke(drawable, new Object[0]);
        } catch (Exception e) {
            MibiLog.d("IImageLoaderImpl", e.getMessage());
        }
        return this;
    }

    public void into(ImageView imageView) {
        try {
            getFadeDurationMethod().invoke(this.mImage, 200);
            getAntiShakeDurationMethod().invoke(this.mImage, 0);
            getIntoMethod().invoke(this.mImage, imageView);
        } catch (Exception e) {
            MibiLog.d("IImageLoaderImpl", e.getMessage());
        }
    }

    private Object getImage(Context context) throws NoSuchMethodException, ClassNotFoundException, InvocationTargetException, IllegalAccessException {
        this.mImage = getGetMethod().invoke(getImageClass(), context);
        return this.mImage;
    }

    private Method getGetMethod() throws NoSuchMethodException, ClassNotFoundException {
        if (this.mGetMethod == null) {
            this.mGetMethod = getImageClass().getMethod("get", Context.class);
        }
        return this.mGetMethod;
    }

    private Method getLoadMethod() throws ClassNotFoundException, NoSuchMethodException {
        if (this.mLoadMethod == null) {
            this.mLoadMethod = getImageClass().getMethod("load", String.class);
        }
        return this.mLoadMethod;
    }

    private Method getPlaceholderMethodInt() throws ClassNotFoundException, NoSuchMethodException {
        if (this.mPlaceholderMethodInt == null) {
            this.mPlaceholderMethodInt = getImageClass().getMethod("placeholder", Integer.TYPE);
        }
        return this.mPlaceholderMethodInt;
    }

    private Method getPlaceholderMethodDrawable() throws ClassNotFoundException, NoSuchMethodException {
        if (this.mPlaceholderMethodDrawable == null) {
            this.mPlaceholderMethodDrawable = getImageClass().getMethod("placeholder", Drawable.class);
        }
        return this.mPlaceholderMethodDrawable;
    }

    private Method getFadeDurationMethod() throws ClassNotFoundException, NoSuchMethodException {
        if (this.mFadeDurationMethod == null) {
            this.mFadeDurationMethod = getImageClass().getMethod("fadeDuration", Long.TYPE);
        }
        return this.mFadeDurationMethod;
    }

    private Method getAntiShakeDurationMethod() throws ClassNotFoundException, NoSuchMethodException {
        if (this.mAntiShakeDurationMethod == null) {
            this.mAntiShakeDurationMethod = getImageClass().getMethod("antiShakeDuration", Integer.TYPE);
        }
        return this.mAntiShakeDurationMethod;
    }

    private Method getIntoMethod() throws ClassNotFoundException, NoSuchMethodException {
        if (this.mIntoMethod == null) {
            this.mIntoMethod = getImageClass().getMethod("into", ImageView.class);
        }
        return this.mIntoMethod;
    }

    private Class<?> getImageClass() throws ClassNotFoundException {
        if (this.mImageClass == null) {
            this.mImageClass = Class.forName("_m_j.cnf");
        }
        return this.mImageClass;
    }
}
