package _m_j;

import android.content.Context;
import android.net.wifi.ScanResult;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.device.DeviceFactory;
import com.xiaomi.smarthome.device.bluetooth.BleDeviceGroup;
import java.util.ArrayList;
import java.util.List;

public final class iac extends BaseAdapter {

    /* renamed from: O000000o  reason: collision with root package name */
    public O000000o f1070O000000o;
    public View.OnClickListener O00000Oo;
    private Context O00000o;
    public int O00000o0 = -1;
    private final List<Object> O00000oO = new ArrayList();
    private int O00000oo;

    public interface O000000o {
        void O000000o(Object obj);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public iac(Context context, O000000o o000000o) {
        this.O00000o = context;
        this.f1070O000000o = o000000o;
        this.O00000oo = R.layout.other_device_list_common_item;
    }

    public final void O000000o(List<Object> list) {
        this.O00000oO.clear();
        this.O00000oO.addAll(list);
        notifyDataSetChanged();
    }

    public final Object getItem(int i) {
        return this.O00000oO.get(i);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [int, android.view.ViewGroup, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public final View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(this.O00000o).inflate(this.O00000oo, viewGroup, false);
        }
        int i2 = this.O00000o0;
        if (i2 <= 0 || i != i2) {
            Object obj = this.O00000oO.get(i);
            if (obj instanceof ScanResult) {
                final ScanResult scanResult = (ScanResult) obj;
                DeviceFactory.O000000o(DeviceFactory.O0000Ooo(scanResult.SSID), (SimpleDraweeView) view.findViewById(R.id.image), (int) R.drawable.device_list_phone_no);
                ((TextView) view.findViewById(R.id.name)).setText(String.format("%s", DeviceFactory.O0000Ooo(scanResult)));
                view.setOnClickListener(new View.OnClickListener() {
                    /* class _m_j.iac.AnonymousClass2 */

                    public final void onClick(View view) {
                        if (iac.this.f1070O000000o != null) {
                            iac.this.f1070O000000o.O000000o(scanResult);
                        }
                    }
                });
            } else if (obj instanceof BleDeviceGroup) {
                final BleDeviceGroup bleDeviceGroup = (BleDeviceGroup) obj;
                DeviceFactory.O000000o(bleDeviceGroup.model, (SimpleDraweeView) view.findViewById(R.id.image), (int) R.drawable.device_list_phone_no);
                ((TextView) view.findViewById(R.id.name)).setText(String.format("%s", bleDeviceGroup.getName()));
                view.setOnClickListener(new View.OnClickListener() {
                    /* class _m_j.iac.AnonymousClass3 */

                    public final void onClick(View view) {
                        if (iac.this.f1070O000000o != null) {
                            iac.this.f1070O000000o.O000000o(bleDeviceGroup);
                        }
                    }
                });
            }
        } else {
            ((SimpleDraweeView) view.findViewById(R.id.image)).setVisibility(4);
            ((ImageView) view.findViewById(R.id.more_image)).setVisibility(0);
            view.setOnClickListener(new View.OnClickListener() {
                /* class _m_j.iac.AnonymousClass1 */

                public final void onClick(View view) {
                    if (iac.this.O00000Oo != null) {
                        iac.this.O00000Oo.onClick(view);
                    }
                }
            });
            ((TextView) view.findViewById(R.id.name)).setText(((Object) this.O00000o.getText(R.string.device_choose_expand_more)) + " (" + (this.O00000oO.size() - this.O00000o0) + ")");
        }
        return view;
    }

    public final int getCount() {
        int i;
        if (this.O00000o0 <= 0 || this.O00000oO.size() <= (i = this.O00000o0)) {
            return this.O00000oO.size();
        }
        return i + 1;
    }
}
