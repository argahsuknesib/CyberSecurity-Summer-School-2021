package com.xiaomi.smarthome.miio.page.deviceophistory;

import _m_j.axj;
import _m_j.axq;
import _m_j.aya;
import _m_j.gxs;
import _m_j.gxt;
import _m_j.gxu;
import _m_j.gxv;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.xiaomi.smarthome.R;
import java.util.ArrayList;
import java.util.GregorianCalendar;

public class DeviceOpHistoryAdapter extends aya<gxv, gxt> implements axq<gxv, gxt> {

    /* renamed from: O000000o  reason: collision with root package name */
    private ArrayList<gxu> f9896O000000o;
    private Context O00000Oo;

    public final /* bridge */ /* synthetic */ axj O000000o(int i) {
        return null;
    }

    public final void O000000o(int i, int i2, int i3, int i4) {
    }

    public final boolean O000000o(int i, int i2) {
        return false;
    }

    public final /* bridge */ /* synthetic */ boolean O000000o(RecyclerView.O000OOo0 o000OOo0, int i, int i2) {
        return false;
    }

    public /* bridge */ /* synthetic */ boolean onCheckCanExpandOrCollapseGroup(RecyclerView.O000OOo0 o000OOo0, int i, int i2, int i3, boolean z) {
        return false;
    }

    public /* synthetic */ void onBindChildViewHolder(RecyclerView.O000OOo0 o000OOo0, int i, int i2, int i3) {
        gxt gxt = (gxt) o000OOo0;
        gxs gxs = this.f9896O000000o.get(i).O00000oO.get(i2);
        gxt.O00000Oo.setText(gxs.O00000Oo);
        gxt.O00000o0.setText(gxs.O00000o0);
        gxt.O00000o.setText(gxs.O00000o);
        gxt.O00000oO.setText(gxs.O00000oO);
    }

    public /* synthetic */ void onBindGroupViewHolder(RecyclerView.O000OOo0 o000OOo0, int i, int i2) {
        gxv gxv = (gxv) o000OOo0;
        gxu gxu = this.f9896O000000o.get(i);
        Context context = this.O00000Oo;
        TextView textView = gxv.O00000Oo;
        StringBuilder sb = new StringBuilder();
        sb.append(gxu.f18484O000000o);
        textView.setText(sb.toString());
        TextView textView2 = gxv.O00000o0;
        textView2.setText(gxu.O00000Oo + context.getString(R.string.month));
        gxv.O00000o.setText(gxu.O00000o0);
    }

    public DeviceOpHistoryAdapter(Context context) {
        ArrayList<gxu> arrayList = new ArrayList<>();
        gxu gxu = new gxu();
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        long j = 1479268104;
        gregorianCalendar.setTimeInMillis(1479268104);
        gxu.f18484O000000o = gregorianCalendar.get(5);
        gxu.O00000Oo = gregorianCalendar.get(2) + 1;
        gxu.O00000o0 = gxu.O000000o(gregorianCalendar.get(7));
        gxu.O00000o = 1479268104;
        for (int i = 0; i < 10; i++) {
            gxu.O00000oO.add(gxs.O000000o(j, "action".concat(String.valueOf(i)), "result 1", "source ".concat(String.valueOf(i))));
            j -= 1000;
        }
        arrayList.add(gxu);
        this.f9896O000000o = arrayList;
        this.O00000Oo = context;
        setHasStableIds(true);
    }

    public int getGroupCount() {
        ArrayList<gxu> arrayList = this.f9896O000000o;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    public int getChildCount(int i) {
        ArrayList<gxu> arrayList = this.f9896O000000o;
        if (arrayList != null && i >= 0 && i < arrayList.size()) {
            return this.f9896O000000o.get(i).O00000oO.size();
        }
        return 0;
    }

    public long getGroupId(int i) {
        return this.f9896O000000o.get(i).O00000o;
    }

    public long getChildId(int i, int i2) {
        return this.f9896O000000o.get(i).O00000oO.get(i2).f18483O000000o;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, android.view.ViewGroup, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public /* synthetic */ RecyclerView.O000OOo0 onCreateChildViewHolder(ViewGroup viewGroup, int i) {
        return new gxt(LayoutInflater.from(this.O00000Oo).inflate((int) R.layout.item_device_op_history_child, viewGroup, false));
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, android.view.ViewGroup, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public /* synthetic */ RecyclerView.O000OOo0 onCreateGroupViewHolder(ViewGroup viewGroup, int i) {
        return new gxv(LayoutInflater.from(this.O00000Oo).inflate((int) R.layout.item_device_op_history_group, viewGroup, false));
    }
}
