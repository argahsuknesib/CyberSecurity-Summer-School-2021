package com.xiaomi.smarthome.device;

import _m_j.fmg;
import _m_j.hxi;
import _m_j.hxk;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.core.entity.plugin.PluginDeviceInfo;
import java.util.ArrayList;
import java.util.List;

public final class ChooseCategoryDeviceAdapter extends BaseAdapter {

    /* renamed from: O000000o  reason: collision with root package name */
    List<PluginDeviceInfo> f6898O000000o = new ArrayList();
    public fmg.O00000o O00000Oo;
    public int O00000o = 3;
    public O000000o O00000o0;
    private Context O00000oO;
    private int O00000oo;
    private float O0000O0o = -1.0f;

    public interface O000000o {
        void O000000o();
    }

    public final Object getItem(int i) {
        return null;
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public ChooseCategoryDeviceAdapter(Context context) {
        this.O00000oO = context;
        this.O00000oo = R.layout.choose_device_list_common_item;
    }

    public final void O000000o(List<PluginDeviceInfo> list) {
        this.f6898O000000o.clear();
        this.f6898O000000o.addAll(list);
        notifyDataSetChanged();
    }

    public final int getCount() {
        return this.f6898O000000o.size();
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [int, android.view.ViewGroup, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public final View getView(int i, View view, ViewGroup viewGroup) {
        O000000o o000000o;
        if (view == null) {
            view = LayoutInflater.from(this.O00000oO).inflate(this.O00000oo, viewGroup, false);
        }
        final PluginDeviceInfo pluginDeviceInfo = this.f6898O000000o.get(i);
        if (pluginDeviceInfo != null) {
            DeviceFactory.O00000Oo(pluginDeviceInfo.O00000Oo(), (SimpleDraweeView) view.findViewById(R.id.image));
            ((TextView) view.findViewById(R.id.name)).setText(pluginDeviceInfo.O0000Oo0());
            view.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.device.ChooseCategoryDeviceAdapter.AnonymousClass1 */

                public final void onClick(View view) {
                    if (ChooseCategoryDeviceAdapter.this.O00000Oo != null) {
                        ChooseCategoryDeviceAdapter.this.O00000Oo.chooseConnectDevice(pluginDeviceInfo);
                        hxk hxk = hxi.O00000o;
                        int O00000o0 = pluginDeviceInfo.O00000o0();
                        String O00000Oo2 = pluginDeviceInfo.O00000Oo();
                        hxk.f952O000000o.O000000o("add_device_all_device_ck", "pdid", Integer.valueOf(O00000o0), "model", O00000Oo2);
                    }
                }
            });
        }
        if (i == this.f6898O000000o.size() - 1 && (o000000o = this.O00000o0) != null) {
            o000000o.O000000o();
        }
        return view;
    }
}
