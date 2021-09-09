package _m_j;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.core.entity.plugin.PluginDeviceInfo;
import com.xiaomi.smarthome.device.BleDevice;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.DeviceFactory;
import com.xiaomi.smarthome.device.bluetooth.BleDeviceGroup;
import com.xiaomi.smarthome.device.bluetooth.ui.BleMatchActivity;
import com.xiaomi.smarthome.device.bluetooth.ui.BleMatchListChoiceActivity;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.framework.statistic.BindStep;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public final class fpk extends fpi {
    private static final int O0000OOo = 2132345203;
    public List<BleDevice> O0000O0o;
    private O000000o O0000Oo;
    private ListView O0000Oo0;
    private TextView O0000OoO;

    public static fpk O00000o() {
        return new fpk();
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(O0000OOo, (ViewGroup) null);
        this.O0000Oo0 = (ListView) inflate.findViewById(R.id.listview);
        this.O0000Oo0.setSelector(new ColorDrawable(0));
        this.O0000Oo = new O000000o(this, (byte) 0);
        this.O0000Oo0.setAdapter((ListAdapter) this.O0000Oo);
        this.O0000OoO = (TextView) inflate.findViewById(R.id.add_batch);
        if (this.O00000o != null) {
            PluginDeviceInfo O00000oO = CoreApi.O000000o().O00000oO(this.O00000o.model);
            if (O00000oO != null && O00000oO.O0000o() == Device.PID_BLE_MESH) {
                this.O0000OoO.setVisibility(0);
                this.O0000OoO.setOnClickListener(new View.OnClickListener() {
                    /* class _m_j.fpk.AnonymousClass1 */

                    public final void onClick(View view) {
                        Intent intent = new Intent(fpk.this.getContext(), BleMatchListChoiceActivity.class);
                        intent.putExtra("key_model", fpk.this.O00000Oo());
                        fpk.this.startActivity(intent);
                    }
                });
            }
            int i = dco.O000000o().O00000o0() ? 1 : 2;
            hxi.O00000o0.f957O000000o.O000000o("adddevice_BLE_appconfirm_show", "model", this.O00000o.model, "from", Integer.valueOf(i));
            hxc.O000000o().O000000o(this.O00000o.model, BindStep.STEP_RESET_DEVICE);
        }
        return inflate;
    }

    public final void O000000o(BleDevice bleDevice, List<String> list) {
        super.O000000o(bleDevice, list);
        List<BleDevice> list2 = this.O0000O0o;
        if (list2 == null) {
            this.O0000O0o = new ArrayList();
        } else {
            list2.clear();
        }
        this.O0000O0o.addAll(this.O00000oO.values());
        Collections.sort(this.O0000O0o, new Comparator<BleDevice>() {
            /* class _m_j.fpk.AnonymousClass2 */

            public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
                return ((BleDevice) obj2).rssi - ((BleDevice) obj).rssi;
            }
        });
    }

    class O000000o extends BaseAdapter {
        public final long getItemId(int i) {
            return (long) i;
        }

        private O000000o() {
        }

        /* synthetic */ O000000o(fpk fpk, byte b) {
            this();
        }

        public final int getCount() {
            if (fpk.this.O0000O0o != null) {
                return fpk.this.O0000O0o.size();
            }
            return 0;
        }

        /* access modifiers changed from: private */
        /* renamed from: O000000o */
        public BleDevice getItem(int i) {
            if (i < 0 || i >= getCount()) {
                return null;
            }
            return fpk.this.O0000O0o.get(i);
        }

        /* renamed from: _m_j.fpk$O000000o$O000000o  reason: collision with other inner class name */
        class C0107O000000o {

            /* renamed from: O000000o  reason: collision with root package name */
            SimpleDraweeView f16812O000000o;
            TextView O00000Oo;
            View O00000o;
            TextView O00000o0;
            ImageView O00000oO;
            ImageView O00000oo;

            private C0107O000000o() {
            }

            /* synthetic */ C0107O000000o(O000000o o000000o, byte b) {
                this();
            }
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            C0107O000000o o000000o;
            int i2 = 0;
            if (view == null) {
                view = LayoutInflater.from(fpk.this.f14469O000000o).inflate((int) R.layout.ble_bind_item, (ViewGroup) null);
                o000000o = new C0107O000000o(this, (byte) 0);
                o000000o.f16812O000000o = (SimpleDraweeView) view.findViewById(R.id.icon);
                o000000o.O00000Oo = (TextView) view.findViewById(R.id.name);
                o000000o.O00000o0 = (TextView) view.findViewById(R.id.mac);
                o000000o.O00000o = view.findViewById(R.id.content);
                o000000o.O00000oO = (ImageView) view.findViewById(R.id.signal);
                o000000o.O00000oo = (ImageView) view.findViewById(R.id.arrow);
                view.setTag(o000000o);
            } else {
                o000000o = (C0107O000000o) view.getTag();
            }
            final BleDevice O000000o2 = getItem(i);
            o000000o.O00000Oo.setText(fpk.O000000o(O000000o2));
            o000000o.O00000o0.setText(O000000o2.mac);
            TextView textView = o000000o.O00000o0;
            if (TextUtils.isEmpty(O000000o2.mac)) {
                i2 = 8;
            }
            textView.setVisibility(i2);
            DeviceFactory.O00000Oo(O000000o2.model, o000000o.f16812O000000o);
            o000000o.O00000o.setOnClickListener(new View.OnClickListener() {
                /* class _m_j.fpk.O000000o.AnonymousClass1 */

                public final void onClick(View view) {
                    hxk hxk = hxi.O00000o;
                    String str = O000000o2.model;
                    hxk.f952O000000o.O000000o("adddevice_BLE_appconfirm_select", "model", str);
                    hxc.O000000o().O000000o(fpk.this.O00000o.model, BindStep.STEP_RESET_DEVICE, "click");
                    if (!dda.O000000o(O000000o2) || !((BleMatchActivity) fpk.this.f14469O000000o).hasMatchImageFragment()) {
                        ((BleMatchActivity) fpk.this.f14469O000000o).onDeviceMatched(O000000o2);
                    } else {
                        ((BleMatchActivity) fpk.this.f14469O000000o).switchToMatchImageFragment();
                    }
                }
            });
            o000000o.O00000oo.setOnClickListener(new View.OnClickListener() {
                /* class _m_j.fpk.O000000o.AnonymousClass2 */

                public final void onClick(View view) {
                    hxc.O000000o().O000000o(fpk.this.O00000o.model, BindStep.STEP_RESET_DEVICE, "click");
                    if (!dda.O000000o(O000000o2) || !((BleMatchActivity) fpk.this.f14469O000000o).hasMatchImageFragment()) {
                        ((BleMatchActivity) fpk.this.f14469O000000o).onDeviceMatched(O000000o2);
                    } else {
                        ((BleMatchActivity) fpk.this.f14469O000000o).switchToMatchImageFragment();
                    }
                }
            });
            if (O000000o2.rssi >= -30) {
                o000000o.O00000oO.setImageResource(R.drawable.tag_ble_04);
            } else if (O000000o2.rssi >= -50) {
                o000000o.O00000oO.setImageResource(R.drawable.tag_ble_03);
            } else if (O000000o2.rssi >= -70) {
                o000000o.O00000oO.setImageResource(R.drawable.tag_ble_02);
            } else {
                o000000o.O00000oO.setImageResource(R.drawable.tag_ble_01);
            }
            return view;
        }
    }

    public static String O000000o(BleDevice bleDevice) {
        return BleDeviceGroup.O00000Oo(bleDevice.model);
    }
}
