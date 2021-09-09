package _m_j;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.library.common.widget.PieProgressBar;
import com.xiaomi.smarthome.miio.miband.data.PluginDeviceDownloadItem;
import java.lang.ref.WeakReference;
import java.util.List;

public final class gxd extends BaseAdapter {

    /* renamed from: O000000o  reason: collision with root package name */
    private List<Device> f18447O000000o;
    private WeakReference<Context> O00000Oo;

    public final long getItemId(int i) {
        return 0;
    }

    public gxd(Context context, List<Device> list) {
        this.f18447O000000o = list;
        this.O00000Oo = new WeakReference<>(context);
    }

    public final int getCount() {
        List<Device> list = this.f18447O000000o;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public final Object getItem(int i) {
        List<Device> list;
        if (i < 0 || (list = this.f18447O000000o) == null || i >= list.size()) {
            return null;
        }
        return this.f18447O000000o.get(i);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, android.view.ViewGroup, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public final View getView(int i, View view, ViewGroup viewGroup) {
        O000000o o000000o;
        WeakReference<Context> weakReference = this.O00000Oo;
        Context context = weakReference != null ? weakReference.get() : null;
        Device device = this.f18447O000000o.get(i);
        if (context == null || device == null || CoreApi.O000000o().O00000oO(device.model) == null) {
            return null;
        }
        if (view == null) {
            view = LayoutInflater.from(context).inflate((int) R.layout.miband_device_list_item, viewGroup, false);
            o000000o = new O000000o();
            o000000o.f18448O000000o = (ImageView) view.findViewById(R.id.iv_device_icon);
            o000000o.O00000Oo = (TextView) view.findViewById(R.id.tv_device_title);
            o000000o.O00000o0 = (TextView) view.findViewById(R.id.tv_device_detail);
            o000000o.O00000o = (PieProgressBar) view.findViewById(R.id.update_progress);
            o000000o.O00000oO = (TextView) view.findViewById(R.id.update_percent);
            view.setTag(o000000o);
        } else {
            o000000o = (O000000o) view.getTag();
        }
        o000000o.O00000Oo.setText(device.name);
        gxp.O000000o();
        PluginDeviceDownloadItem O000000o2 = gxp.O000000o(device.model);
        o000000o.O00000o.setVisibility(4);
        o000000o.O00000oO.setVisibility(4);
        if (O000000o2 != null) {
            if (O000000o2.O00000o0.equals(PluginDeviceDownloadItem.Status.DOWNLOADING)) {
                o000000o.O00000o.setVisibility(0);
                o000000o.O00000oO.setVisibility(0);
                o000000o.O00000o.setPercent(O000000o2.f9756O000000o * 100.0f);
                o000000o.O00000oO.setText(String.format("%d%%", Integer.valueOf(((int) O000000o2.f9756O000000o) * 100)));
            } else {
                o000000o.O00000o.setVisibility(4);
                o000000o.O00000oO.setVisibility(4);
            }
        }
        return view;
    }

    class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public ImageView f18448O000000o;
        public TextView O00000Oo;
        public PieProgressBar O00000o;
        public TextView O00000o0;
        public TextView O00000oO;

        O000000o() {
        }
    }
}
