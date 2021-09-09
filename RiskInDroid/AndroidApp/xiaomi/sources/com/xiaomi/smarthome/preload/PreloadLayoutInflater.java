package com.xiaomi.smarthome.preload;

import _m_j.fdb;
import _m_j.hly;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class PreloadLayoutInflater extends LayoutInflater {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final String[] f10538O000000o = {"android.widget.", "android.webkit.", "android.app."};

    public PreloadLayoutInflater(Context context) {
        super(context);
    }

    private PreloadLayoutInflater(LayoutInflater layoutInflater, Context context) {
        super(layoutInflater, context);
    }

    public LayoutInflater cloneInContext(Context context) {
        return new PreloadLayoutInflater(this, context);
    }

    public View inflate(int i, ViewGroup viewGroup, boolean z) {
        if (viewGroup != null || z) {
            return super.inflate(i, viewGroup, z);
        }
        View O000000o2 = hly.O000000o(i);
        if (O000000o2 == null) {
            return super.inflate(i, viewGroup, z);
        }
        O000000o(O000000o2);
        return O000000o2;
    }

    /* access modifiers changed from: protected */
    public View onCreateView(String str, AttributeSet attributeSet) throws ClassNotFoundException {
        View onCreateView;
        LayoutInflater.Factory factory = LayoutInflater.from(getContext()).getFactory();
        if (factory != null && (onCreateView = factory.onCreateView(str, getContext(), attributeSet)) != null) {
            return onCreateView;
        }
        String[] strArr = f10538O000000o;
        int length = strArr.length;
        int i = 0;
        while (i < length) {
            try {
                View createView = createView(str, strArr[i], attributeSet);
                if (createView != null) {
                    return createView;
                }
                i++;
            } catch (ClassNotFoundException unused) {
            }
        }
        return super.onCreateView(str, attributeSet);
    }

    private void O000000o(View view) {
        Context context = getContext();
        if (context != null) {
            fdb.O000000o(view, "mContext", context);
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                for (int i = 0; i < viewGroup.getChildCount(); i++) {
                    O000000o(viewGroup.getChildAt(i));
                }
            }
        }
    }
}
