package com.xiaomi.smarthome.framework.page.verify.filter;

import _m_j.fnn;
import _m_j.fwi;
import _m_j.fwl;
import _m_j.ggb;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.device.utils.DeviceTagInterface;
import com.xiaomi.smarthome.homeroom.model.Home;
import com.xiaomi.smarthome.homeroom.model.Room;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public abstract class SettingsDeviceFilter {

    /* renamed from: O000000o  reason: collision with root package name */
    private Dialog f8013O000000o;
    private Context O00000Oo;
    private List<fwi> O00000o = new ArrayList();
    private List<fwi> O00000o0 = new ArrayList();
    private List<fwi> O00000oO = new ArrayList();
    private ArrayList<DeviceTagInterface.Category> O00000oo = new ArrayList<>();
    private SettingsFilterLayout O0000O0o;
    private SettingsFilterLayout O0000OOo;
    private List<Home> O0000Oo = new ArrayList();
    private SettingsFilterLayout O0000Oo0;
    private boolean O0000OoO = false;
    private List<fwl> O0000Ooo;
    private StringBuilder O0000o0 = new StringBuilder();
    private View O0000o00;

    public abstract void O000000o();

    public abstract void O000000o(int i);

    public abstract void O000000o(List<fwi> list, List<fwi> list2, List<fwi> list3);

    public abstract void O00000Oo();

    public SettingsDeviceFilter(Context context) {
        this.O00000Oo = context;
        O00000o();
        O00000oO();
        O0000OoO();
    }

    public SettingsDeviceFilter(Context context, List<fwl> list) {
        this.O00000Oo = context;
        this.O0000Ooo = list;
        O00000o();
        O00000oO();
        O00000Oo(list);
    }

    private void O00000o() {
        this.O0000o00 = LayoutInflater.from(this.O00000Oo).inflate((int) R.layout.security_setting_product_filter_dialog, (ViewGroup) null);
        this.O0000O0o = (SettingsFilterLayout) this.O0000o00.findViewById(R.id.product_label);
        this.O0000OOo = (SettingsFilterLayout) this.O0000o00.findViewById(R.id.home_label);
        this.O0000Oo0 = (SettingsFilterLayout) this.O0000o00.findViewById(R.id.room_label);
        O00000oo();
    }

    private void O00000oO() {
        O0000OOo();
        O0000Oo();
    }

    /* JADX WARN: Type inference failed for: r0v10, types: [android.view.View] */
    /* JADX WARNING: Multi-variable type inference failed */
    private Dialog O00000oo() {
        TextView textView;
        TextView textView2 = null;
        if (this.f8013O000000o == null) {
            this.f8013O000000o = new Dialog(this.O00000Oo, 2132739282);
            this.f8013O000000o.setContentView(this.O0000o00);
            textView2 = this.O0000o00.findViewById(R.id.btn_security_setting_reset);
            textView = (TextView) this.O0000o00.findViewById(R.id.btn_security_setting_confirm);
        } else {
            textView = null;
        }
        textView2.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.framework.page.verify.filter.$$Lambda$SettingsDeviceFilter$w1NkXfXeTJq1Gjy5YKJwlKazFA */

            public final void onClick(View view) {
                SettingsDeviceFilter.this.O00000Oo(view);
            }
        });
        textView.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.framework.page.verify.filter.$$Lambda$SettingsDeviceFilter$6vIBf5aM8W8mDd_XtpX2SsVIsQ */

            public final void onClick(View view) {
                SettingsDeviceFilter.this.O000000o(view);
            }
        });
        this.f8013O000000o.setOnShowListener(new DialogInterface.OnShowListener() {
            /* class com.xiaomi.smarthome.framework.page.verify.filter.$$Lambda$SettingsDeviceFilter$8eNG170So2zPxVNsWzwo2wJ07k */

            public final void onShow(DialogInterface dialogInterface) {
                SettingsDeviceFilter.this.O000000o(dialogInterface);
            }
        });
        Window window = this.f8013O000000o.getWindow();
        window.setGravity(80);
        this.O0000o00.addOnLayoutChangeListener(new View.OnLayoutChangeListener(window.getAttributes(), window) {
            /* class com.xiaomi.smarthome.framework.page.verify.filter.$$Lambda$SettingsDeviceFilter$uon6zdEchSfXl97PDlDps6DB7dI */
            private final /* synthetic */ WindowManager.LayoutParams f$1;
            private final /* synthetic */ Window f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                SettingsDeviceFilter.this.O000000o(this.f$1, this.f$2, view, i, i2, i3, i4, i5, i6, i7, i8);
            }
        });
        return this.f8013O000000o;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O000000o(View view) {
        List<fwi> selectedLabelData = this.O0000OOo.getSelectedLabelData();
        List<fwi> selectedLabelData2 = this.O0000Oo0.getSelectedLabelData();
        List<fwi> selectedLabelData3 = this.O0000O0o.getSelectedLabelData();
        O000000o(selectedLabelData, selectedLabelData2, selectedLabelData3);
        int size = selectedLabelData.size();
        int size2 = selectedLabelData2.size();
        int size3 = selectedLabelData3.size();
        int i = 0;
        int i2 = size > 0 ? 1 : 0;
        int i3 = size2 > 0 ? 2 : 0;
        if (size3 > 0) {
            i = 4;
        }
        O000000o((i2 ^ i3) ^ i);
        this.f8013O000000o.dismiss();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O000000o(DialogInterface dialogInterface) {
        O00000Oo();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O000000o(WindowManager.LayoutParams layoutParams, Window window, View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        int i9 = this.O00000Oo.getApplicationContext().getResources().getDisplayMetrics().heightPixels;
        int i10 = this.O00000Oo.getApplicationContext().getResources().getDisplayMetrics().widthPixels;
        int height = view.getHeight();
        double d = (double) i9;
        Double.isNaN(d);
        double d2 = d * 0.8d;
        if (((double) height) > d2) {
            height = (int) d2;
        }
        layoutParams.height = height;
        layoutParams.width = i10;
        window.setAttributes(layoutParams);
    }

    public final void O00000o0() {
        if (!this.O0000OoO) {
            O0000O0o();
        }
        this.O0000OOo.O000000o();
        this.O0000Oo0.O000000o();
        this.O0000O0o.O000000o();
        this.O0000OoO = true;
        this.f8013O000000o.show();
    }

    private void O0000O0o() {
        this.O0000OOo.setFlowViewData(this.O00000o0);
        this.O0000Oo0.setFlowViewData(this.O00000o);
        this.O0000O0o.setFlowViewData(this.O00000oO);
    }

    private void O0000OOo() {
        this.O0000Oo = O0000Oo0();
        if (!this.O0000Oo.isEmpty()) {
            for (int i = 0; i < this.O0000Oo.size(); i++) {
                Home home = this.O0000Oo.get(i);
                this.O00000o0.add(new fwi(home.getId(), home.getRawName(), 3));
            }
        }
    }

    private List<Home> O0000Oo0() {
        List<Home> list = ggb.O00000Oo().O0000OoO.O00000Oo;
        if (!list.isEmpty()) {
            this.O0000Oo.addAll(list);
            for (int size = this.O0000Oo.size() - 1; size >= 0; size--) {
                if (!this.O0000Oo.get(size).isOwner()) {
                    this.O0000Oo.remove(size);
                }
            }
        }
        return this.O0000Oo;
    }

    private void O0000Oo() {
        if (!this.O0000Oo.isEmpty()) {
            this.O00000o.clear();
            for (int i = 0; i < this.O0000Oo.size(); i++) {
                this.O00000o.addAll(O000000o(this.O0000Oo.get(i).getId(), this.O0000Oo.get(i).getRawName()));
            }
            O000000o(this.O00000o);
        }
    }

    private static List<fwi> O000000o(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        List<Room> O000000o2 = ggb.O00000Oo().O000000o(str);
        for (int i = 0; i < O000000o2.size(); i++) {
            Room room = O000000o2.get(i);
            arrayList.add(new fwi(room.getId(), room.getName(), str2));
        }
        return arrayList;
    }

    private void O000000o(List<fwi> list) {
        int size = list.size();
        int i = 0;
        boolean z = false;
        while (true) {
            int i2 = size - 1;
            if (i < i2) {
                String str = list.get(i).f17309O000000o;
                int i3 = i + 1;
                boolean z2 = z;
                for (int i4 = i3; i4 < size; i4++) {
                    String str2 = list.get(i4).f17309O000000o;
                    if (str.equals(str2) && !str.contains(" | ")) {
                        list.get(i4).f17309O000000o = O00000Oo(str2, list.get(i4).O00000o0);
                        z2 = true;
                    }
                    if (i4 == i2 && z2) {
                        list.get(i).f17309O000000o = O00000Oo(str, list.get(i).O00000o0);
                        z2 = false;
                    }
                }
                i = i3;
                z = z2;
            } else {
                return;
            }
        }
    }

    private String O00000Oo(String str, String str2) {
        StringBuilder sb = this.O0000o0;
        sb.append(str);
        sb.append(" | ");
        sb.append(str2);
        String sb2 = this.O0000o0.toString();
        this.O0000o0.setLength(0);
        return sb2;
    }

    private void O0000OoO() {
        if (!this.O0000Oo.isEmpty()) {
            for (int i = 0; i < this.O0000Oo.size(); i++) {
                Map<String, List<String>> O0000Oo2 = fnn.O000000o().O00000Oo().O0000Oo(this.O0000Oo.get(i).getId());
                if (!O0000Oo2.isEmpty()) {
                    for (Map.Entry next : O0000Oo2.entrySet()) {
                        DeviceTagInterface.Category O00000o2 = fnn.O000000o().O00000Oo().O00000o((String) next.getKey());
                        if (O00000o2 != null && next.getValue() != null && ((List) next.getValue()).size() > 0 && !this.O00000oo.contains(O00000o2)) {
                            this.O00000oo.add(O00000o2);
                        }
                    }
                    this.O00000oO = O000000o(this.O00000oo);
                }
            }
        }
    }

    private void O00000Oo(List<fwl> list) {
        for (fwl fwl : list) {
            DeviceTagInterface.Category O00000o02 = fnn.O000000o().O00000Oo().O00000o0(fwl.O0000O0o);
            if (O00000o02 != null && !this.O00000oo.contains(O00000o02)) {
                this.O00000oo.add(O00000o02);
            }
        }
        this.O00000oO = O000000o(this.O00000oo);
    }

    private static List<fwi> O000000o(ArrayList<DeviceTagInterface.Category> arrayList) {
        ArrayList arrayList2 = new ArrayList();
        if (!arrayList.isEmpty()) {
            Iterator<DeviceTagInterface.Category> it = arrayList.iterator();
            while (it.hasNext()) {
                DeviceTagInterface.Category next = it.next();
                if (next != null && !TextUtils.isEmpty(next.id) && !TextUtils.isEmpty(next.name)) {
                    arrayList2.add(new fwi(next.id, next.name, 1));
                }
            }
        }
        return arrayList2;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O00000Oo(View view) {
        this.O0000OOo.O000000o(true);
        this.O0000Oo0.O000000o(true);
        this.O0000O0o.O000000o(true);
        O000000o();
    }
}
