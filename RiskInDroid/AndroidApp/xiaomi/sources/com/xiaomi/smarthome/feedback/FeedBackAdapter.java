package com.xiaomi.smarthome.feedback;

import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.device.DeviceFactory;
import java.util.List;

class FeedBackAdapter extends BaseAdapter {

    /* renamed from: O000000o  reason: collision with root package name */
    private List<String> f7369O000000o;
    private Context O00000Oo;

    public long getItemId(int i) {
        return 0;
    }

    public FeedBackAdapter(Context context) {
        this.O00000Oo = context;
    }

    public final void O000000o(List<String> list) {
        this.f7369O000000o = list;
        notifyDataSetChanged();
    }

    public int getCount() {
        List<String> list = this.f7369O000000o;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public Object getItem(int i) {
        List<String> list;
        if (i < 0 || (list = this.f7369O000000o) == null || i >= list.size()) {
            return null;
        }
        return this.f7369O000000o.get(i);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, android.view.ViewGroup, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public View getView(int i, View view, ViewGroup viewGroup) {
        O000000o o000000o;
        if (view == null) {
            view = LayoutInflater.from(this.O00000Oo).inflate((int) R.layout.feed_back_item, viewGroup, false);
            o000000o = new O000000o();
            o000000o.f7370O000000o = (SimpleDraweeView) view.findViewById(R.id.iv_device_icon);
            o000000o.O00000Oo = (TextView) view.findViewById(R.id.tv_device_name);
            view.setTag(o000000o);
            if (Build.VERSION.SDK_INT > 21) {
                view.setBackgroundResource(R.drawable.ripple_item_selector);
            }
        } else {
            o000000o = (O000000o) view.getTag();
        }
        String str = this.f7369O000000o.get(i);
        if (str != null && !str.isEmpty()) {
            if (str.equalsIgnoreCase("exp")) {
                o000000o.f7370O000000o.setImageResource(R.drawable.std_help_icon_appexperience);
                o000000o.O00000Oo.setText((int) R.string.feedback_app_experience);
            } else if (str.equalsIgnoreCase("shop")) {
                o000000o.f7370O000000o.setImageResource(R.drawable.std_help_icon_mall);
                o000000o.O00000Oo.setText((int) R.string.feedback_eshop);
            } else if (str.equalsIgnoreCase("account")) {
                o000000o.O00000Oo.setText((int) R.string.feedback_account);
                o000000o.f7370O000000o.setImageResource(R.drawable.std_help_icon_account);
            } else if (str.equalsIgnoreCase("other")) {
                o000000o.f7370O000000o.setImageResource(R.drawable.std_help_icon_other);
                o000000o.O00000Oo.setText((int) R.string.feedback_other);
            } else if (str.equalsIgnoreCase("blegateway")) {
                o000000o.f7370O000000o.setImageResource(R.drawable.std_help_icon_bluetooth);
                o000000o.O00000Oo.setText((int) R.string.ble_gateway_switch_text);
            } else if (str.equalsIgnoreCase("automation")) {
                o000000o.O00000Oo.setText((int) R.string.feedback_auto_scene);
                o000000o.f7370O000000o.setImageResource(R.drawable.std_help_icon_autoscene);
            } else {
                DeviceFactory.O00000Oo(str, o000000o.f7370O000000o);
                o000000o.O00000Oo.setText(DeviceFactory.O0000OoO(str));
            }
        }
        return view;
    }

    class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        SimpleDraweeView f7370O000000o;
        TextView O00000Oo;

        O000000o() {
        }
    }
}
