package com.xiaomi.smarthome.newui.adapter;

import _m_j.ft;
import _m_j.gzm;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.drawable.AnimationDrawable;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.application.ServiceApplication;
import com.xiaomi.smarthome.frame.core.CoreApi;
import java.lang.ref.WeakReference;

public class DeviceMainLoadingAdapter extends gzm {

    /* renamed from: O000000o  reason: collision with root package name */
    public int f10130O000000o = 1;
    private WeakReference<Context> O00000Oo;
    private BroadcastReceiver O00000o0;

    public int getItemCount() {
        return 1;
    }

    static class O00000Oo extends BroadcastReceiver {

        /* renamed from: O000000o  reason: collision with root package name */
        private final WeakReference<DeviceMainLoadingAdapter> f10133O000000o;

        public O00000Oo(DeviceMainLoadingAdapter deviceMainLoadingAdapter) {
            this.f10133O000000o = new WeakReference<>(deviceMainLoadingAdapter);
        }

        public final void onReceive(Context context, Intent intent) {
            DeviceMainLoadingAdapter deviceMainLoadingAdapter = this.f10133O000000o.get();
            if (deviceMainLoadingAdapter != null) {
                deviceMainLoadingAdapter.O00000Oo();
                deviceMainLoadingAdapter.notifyDataSetChanged();
            }
        }
    }

    public DeviceMainLoadingAdapter(Context context) {
        this.O00000Oo = new WeakReference<>(context);
        this.O00000o0 = new O00000Oo(this);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("action_on_login_success");
        ft.O000000o(CommonApplication.getAppContext()).O000000o(this.O00000o0, intentFilter);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, android.view.ViewGroup, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public RecyclerView.O000OOo0 onCreateViewHolder(ViewGroup viewGroup, int i) {
        Context context = this.O00000Oo.get();
        if (context != null) {
            return new O000000o((ViewGroup) LayoutInflater.from(context).inflate((int) R.layout.device_list_loading_layout, viewGroup, false));
        }
        return null;
    }

    public void onBindViewHolder(RecyclerView.O000OOo0 o000OOo0, int i) {
        if (o000OOo0 instanceof O000000o) {
            O000000o o000000o = (O000000o) o000OOo0;
            if (!o000000o.O00000o0) {
                ((AnimationDrawable) o000000o.O00000Oo.getDrawable()).start();
                o000000o.O00000o0 = true;
            }
            DeviceMainLoadingAdapter.this.O00000Oo();
            int i2 = DeviceMainLoadingAdapter.this.f10130O000000o;
            if (i2 == 1) {
                o000000o.f10132O000000o.setText((int) R.string.main_page_loading_state_initialing);
            } else if (i2 == 2) {
                o000000o.f10132O000000o.setText((int) R.string.main_page_loading_state_logging);
            } else if (i2 != 3) {
                o000000o.f10132O000000o.setText("");
            } else {
                o000000o.f10132O000000o.setText((int) R.string.main_page_loading_state_retrieving);
            }
        }
    }

    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
        if (this.O00000o0 != null) {
            ft.O000000o(CommonApplication.getAppContext()).O000000o(this.O00000o0);
            this.O00000o0 = null;
        }
    }

    class O000000o extends RecyclerView.O000OOo0 {

        /* renamed from: O000000o  reason: collision with root package name */
        TextView f10132O000000o;
        ImageView O00000Oo;
        boolean O00000o0 = false;

        public O000000o(ViewGroup viewGroup) {
            super(viewGroup);
            this.f10132O000000o = (TextView) viewGroup.findViewById(R.id.loading_tips);
            this.O00000Oo = (ImageView) viewGroup.findViewById(R.id.mj_loading);
            TextView textView = this.f10132O000000o;
            textView.setTextColor(textView.getContext().getResources().getColor(R.color.mj_color_black_100_transparent));
        }
    }

    public final void O00000Oo() {
        if (!CoreApi.O000000o().O0000O0o()) {
            this.f10130O000000o = 1;
            CoreApi.O000000o().O000000o(this.O00000Oo.get(), new CoreApi.O0000o0() {
                /* class com.xiaomi.smarthome.newui.adapter.DeviceMainLoadingAdapter.AnonymousClass1 */

                public final void onCoreReady() {
                    DeviceMainLoadingAdapter.this.f10130O000000o = 2;
                }
            });
            return;
        }
        int i = ServiceApplication.getStateNotifier().f15923O000000o;
        if (i == 2 || i == 1) {
            this.f10130O000000o = 2;
        } else if (i == 3) {
            this.f10130O000000o = 0;
        } else if (i == 4) {
            this.f10130O000000o = 3;
        }
    }
}
