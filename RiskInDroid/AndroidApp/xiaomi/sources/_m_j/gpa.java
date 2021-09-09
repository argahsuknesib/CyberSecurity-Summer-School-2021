package _m_j;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.device.BleDevice;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.MiTVDevice;
import com.xiaomi.smarthome.device.api.XmPluginHostApi;
import com.xiaomi.smarthome.library.common.dialog.XQProgressDialog;
import org.json.JSONArray;

public final class gpa {
    public static void O000000o(Context context, Device device, String str, XQProgressDialog xQProgressDialog, fsm fsm, boolean z) {
        if (device instanceof BleDevice) {
            if (!TextUtils.isEmpty(device.did)) {
                gwe.O000000o();
                final XQProgressDialog xQProgressDialog2 = xQProgressDialog;
                final Device device2 = device;
                final String str2 = str;
                final Context context2 = context;
                final fsm fsm2 = fsm;
                final boolean z2 = z;
                gwe.O000000o(device, str, new fsm<Void, fso>() {
                    /* class _m_j.gpa.AnonymousClass7 */

                    public final /* synthetic */ void onSuccess(Object obj) {
                        Void voidR = (Void) obj;
                        XQProgressDialog xQProgressDialog = xQProgressDialog2;
                        if (xQProgressDialog != null) {
                            xQProgressDialog.dismiss();
                        }
                        Device O000000o2 = fno.O000000o().O000000o(device2.did);
                        if (O000000o2 != null) {
                            O000000o2.name = str2;
                        }
                        Device device = device2;
                        device.name = str2;
                        foc.O000000o(device.mac, str2);
                        ft.O000000o(context2).O000000o(new Intent("com.smarthome.refresh_list_view"));
                        fno.O000000o().O0000Oo0();
                        ft.O000000o(context2).O000000o(new Intent("common_used_device_updated"));
                        fsm fsm = fsm2;
                        if (fsm != null) {
                            fsm.onSuccess(voidR);
                        }
                    }

                    public final void onFailure(fso fso) {
                        XQProgressDialog xQProgressDialog = xQProgressDialog2;
                        if (xQProgressDialog != null) {
                            xQProgressDialog.dismiss();
                        }
                        if (!z2) {
                            hte.O000000o(context2, (int) R.string.change_back_name_fail);
                        }
                        fsm fsm = fsm2;
                        if (fsm != null) {
                            fsm.onFailure(fso);
                        }
                    }
                });
                return;
            }
            if (xQProgressDialog != null) {
                xQProgressDialog.dismiss();
            }
            device.name = str;
            foc.O000000o(device.mac, str);
            ft.O000000o(context).O000000o(new Intent("com.smarthome.refresh_list_view"));
            fno.O000000o().O0000Oo0();
            ft.O000000o(context).O000000o(new Intent("common_used_device_updated"));
            if (fsm != null) {
                fsm.onSuccess(null);
            }
        } else if (!(device instanceof MiTVDevice) || ((MiTVDevice) device).O000000o()) {
            gwe.O000000o();
            final XQProgressDialog xQProgressDialog3 = xQProgressDialog;
            final Device device3 = device;
            final String str3 = str;
            final Context context3 = context;
            final fsm fsm3 = fsm;
            final boolean z3 = z;
            gwe.O000000o(device, str, new fsm<Void, fso>() {
                /* class _m_j.gpa.AnonymousClass8 */

                public final /* synthetic */ void onSuccess(Object obj) {
                    Void voidR = (Void) obj;
                    XQProgressDialog xQProgressDialog = xQProgressDialog3;
                    if (xQProgressDialog != null) {
                        xQProgressDialog.dismiss();
                    }
                    device3.name = str3;
                    ft.O000000o(context3).O000000o(new Intent("com.smarthome.refresh_list_view"));
                    fno.O000000o().O0000Oo0();
                    ft.O000000o(context3).O000000o(new Intent("common_used_device_updated"));
                    fsm fsm = fsm3;
                    if (fsm != null) {
                        fsm.onSuccess(voidR);
                    }
                    if (device3 instanceof MiTVDevice) {
                        JSONArray jSONArray = new JSONArray();
                        jSONArray.put(str3);
                        XmPluginHostApi.instance().callMethodFromCloud(device3.did, "modify_device_name", jSONArray, null, null);
                    }
                }

                public final void onFailure(fso fso) {
                    XQProgressDialog xQProgressDialog = xQProgressDialog3;
                    if (xQProgressDialog != null) {
                        xQProgressDialog.dismiss();
                    }
                    if (!z3) {
                        hte.O000000o(context3, (int) R.string.change_back_name_fail);
                    }
                    fsm fsm = fsm3;
                    if (fsm != null) {
                        fsm.onFailure(fso);
                    }
                }
            });
        } else {
            if (xQProgressDialog != null) {
                xQProgressDialog.dismiss();
            }
            hte.O000000o(context, (int) R.string.change_back_name_mitv_notsupport);
            if (fsm != null) {
                fsm.onFailure(null);
            }
        }
    }
}
