package com.xiaomi.smarthome.camera.view;

import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

public class AdapterViewHolder {
    private Object mData;
    private View mView;
    private SparseArray<View> mViewCaches = new SparseArray<>();

    public static AdapterViewHolder create(View view, LayoutInflater layoutInflater, int i) {
        if (view == null) {
            return new AdapterViewHolder(view, layoutInflater, i);
        }
        return (AdapterViewHolder) view.getTag();
    }

    private AdapterViewHolder(View view, LayoutInflater layoutInflater, int i) {
        if (view == null) {
            this.mView = layoutInflater.inflate(i, (ViewGroup) null);
            this.mView.setTag(this);
            return;
        }
        this.mView = view;
    }

    public void setData(Object obj) {
        this.mData = obj;
    }

    public Object getData() {
        return this.mData;
    }

    public View view() {
        return this.mView;
    }

    public View view(int i) {
        View view = this.mViewCaches.get(i);
        if (view != null) {
            return view;
        }
        View findViewById = this.mView.findViewById(i);
        this.mViewCaches.append(i, findViewById);
        return findViewById;
    }

    public ImageView imageView(int i) {
        View view = view(i);
        if (view != null) {
            return (ImageView) view;
        }
        return null;
    }

    public TextView textView(int i) {
        View view = view(i);
        if (view != null) {
            return (TextView) view;
        }
        return null;
    }

    public Button button(int i) {
        View view = view(i);
        if (view != null) {
            return (Button) view;
        }
        return null;
    }

    public CheckBox checkBox(int i) {
        View view = view(i);
        if (view != null) {
            return (CheckBox) view;
        }
        return null;
    }

    public View line(int i) {
        View view = view(i);
        if (view != null) {
            return view;
        }
        return null;
    }
}
