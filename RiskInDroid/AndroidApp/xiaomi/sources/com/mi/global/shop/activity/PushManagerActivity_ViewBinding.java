package com.mi.global.shop.activity;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.xiaomi.smarthome.R;

public class PushManagerActivity_ViewBinding implements Unbinder {

    /* renamed from: O000000o  reason: collision with root package name */
    private PushManagerActivity f4671O000000o;

    public PushManagerActivity_ViewBinding(PushManagerActivity pushManagerActivity, View view) {
        this.f4671O000000o = pushManagerActivity;
        pushManagerActivity.pushRecycleView = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.push_recycleView, "field 'pushRecycleView'", RecyclerView.class);
    }

    public void unbind() {
        PushManagerActivity pushManagerActivity = this.f4671O000000o;
        if (pushManagerActivity != null) {
            this.f4671O000000o = null;
            pushManagerActivity.pushRecycleView = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
