package _m_j;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.core.entity.plugin.PluginDeviceInfo;
import com.xiaomi.smarthome.core.entity.plugin.PluginDownloadTask;
import com.xiaomi.smarthome.core.entity.plugin.PluginError;
import com.xiaomi.smarthome.device.BleDevice;
import com.xiaomi.smarthome.device.DeviceRouterFactory;
import com.xiaomi.smarthome.device.api.DeviceStat;
import com.xiaomi.smarthome.device.bluetooth.BleDeviceGroup;
import com.xiaomi.smarthome.device.bluetooth.connect.single.BleBindActivityV2;
import com.xiaomi.smarthome.device.bluetooth.ui.BleMatchActivity;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.frame.plugin.PluginApi;
import com.xiaomi.smarthome.frame.plugin.SendMessageCallback;
import com.xiaomi.smarthome.library.bluetooth.connect.BleGattProfile;
import com.xiaomi.smarthome.library.common.dialog.XQProgressHorizontalDialog;
import java.util.ArrayList;

public class fod extends glc {
    public static void O000000o(Context context, BleDevice bleDevice, Intent intent, ArrayList<String> arrayList) {
        if (bleDevice != null) {
            gsy.O000000o(4, "stopScan", "BleDispatcher stop");
            fpo.O00000Oo();
            if ("roidmi.btfm.v1".equalsIgnoreCase(bleDevice.model) || "roidmi.btfm.m1".equalsIgnoreCase(bleDevice.model)) {
                Intent intent2 = new Intent("android.settings.BLUETOOTH_SETTINGS");
                if (intent != null) {
                    intent2.putExtras(intent);
                }
                context.startActivity(intent2);
            } else if ("onemore.soundbox.sm001".equals(bleDevice.model)) {
                O00000Oo(context, bleDevice, intent, arrayList);
            } else {
                boolean z = true;
                if (ffs.O000000o(bleDevice.model) != 1) {
                    z = false;
                }
                if (z || !bleDevice.O0000O0o()) {
                    O000000o(context, bleDevice, intent);
                } else {
                    O00000Oo(context, bleDevice, intent, arrayList);
                }
            }
        }
    }

    public static void O00000Oo(Context context, BleDevice bleDevice, Intent intent, ArrayList<String> arrayList) {
        BleDeviceGroup O000000o2;
        if (bleDevice == null) {
            gnk.O00000oO("device null");
        } else if ((bleDevice instanceof BleDeviceGroup) && (O000000o2 = fob.O000000o(bleDevice.model)) != null) {
            if (O000000o(O000000o2)) {
                O000000o((Activity) context, O000000o2.O0000OoO().get(0), intent, 2101);
            } else {
                O000000o((Activity) context, bleDevice, intent, arrayList);
            }
        }
    }

    private static boolean O000000o(BleDevice bleDevice) {
        if (bleDevice == null || bleDevice.O00000Oo() == null || bleDevice.O00000Oo().f6871O000000o == null || ((!TextUtils.equals(bleDevice.model, "ninebot.scooter.v1") && !TextUtils.equals(bleDevice.model, "ninebot.scooter.v2")) || bleDevice.O00000Oo().f6871O000000o.O0000Oo0 != 5)) {
            return false;
        }
        return true;
    }

    private static void O000000o(Activity activity, BleDevice bleDevice, Intent intent, ArrayList<String> arrayList) {
        Intent intent2 = new Intent();
        if (intent != null) {
            intent2.putExtras(intent);
        }
        gpf.O000000o(activity.getIntent(), intent2);
        intent2.putExtra("model", bleDevice.model);
        intent2.putExtra("key_combine_model", arrayList);
        intent2.putExtra("extra_from", "from_plus");
        intent2.setClass(activity, BleMatchActivity.class);
        activity.startActivityForResult(intent2, 100);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.content.Intent.putExtra(java.lang.String, boolean):android.content.Intent}
     arg types: [java.lang.String, int]
     candidates:
      ClspMth{android.content.Intent.putExtra(java.lang.String, int):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.String[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, int[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, double):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, char):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, boolean[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, byte):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Bundle):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, float):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.CharSequence[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.CharSequence):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, long[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, long):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, short):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Parcelable[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.io.Serializable):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, double[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Parcelable):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, float[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, byte[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.String):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, short[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, char[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, boolean):android.content.Intent} */
    public static void O000000o(Activity activity, BleDevice bleDevice, Intent intent, int i) {
        PluginDeviceInfo O00000oO = CoreApi.O000000o().O00000oO(bleDevice.model);
        if (O00000oO != null && O00000oO.O0000ooo == 18) {
            BleMatchActivity.mMatchedDevice = bleDevice;
            foc.O0000o(bleDevice.mac);
            foc.O00000o0(bleDevice.mac, "");
            try {
                Intent intent2 = new Intent(activity, Class.forName("com.xiaomi.smarthome.smartconfig.SmartConfigMainActivity"));
                intent2.putExtra("strategy_id", 18);
                intent2.putExtra("key_lock_wifi_device_mac", bleDevice.mac);
                intent2.putExtra("key_lock_wifi_from_plugin", false);
                fqy.O000000o(intent2, intent);
                if (intent != null) {
                    if (intent.hasExtra("key_already_found")) {
                        intent2.putExtra("key_already_found", intent.getBooleanExtra("key_already_found", false));
                    }
                    if (intent.hasExtra("key_qrcode_oob")) {
                        intent2.putExtra("key_qrcode_oob", intent.getStringExtra("key_qrcode_oob"));
                    }
                }
                activity.startActivityForResult(intent2, i);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        } else if (bleDevice.O0000O0o()) {
            BleMatchActivity.mMatchedDevice = bleDevice;
            foc.O0000o(bleDevice.mac);
            Intent intent3 = new Intent();
            intent3.setClass(activity, BleBindActivityV2.class);
            intent3.putExtra("extra_from", "from_match");
            gpf.O000000o(activity.getIntent(), intent3);
            fqy.O000000o(intent3, intent);
            if (intent != null) {
                if (intent.hasExtra("key_qrcode_oob")) {
                    intent3.putExtra("key_qrcode_oob", intent.getStringExtra("key_qrcode_oob"));
                }
                if (intent.hasExtra("key_already_found")) {
                    intent3.putExtra("key_already_found", intent.getBooleanExtra("key_already_found", false));
                }
            }
            activity.startActivityForResult(intent3, i);
        } else {
            O000000o(activity, bleDevice, null);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0003, code lost:
        r0 = com.xiaomi.smarthome.frame.core.CoreApi.O000000o().O00000oO(r13.model);
     */
    private static void O000000o(final Context context, BleDevice bleDevice, Intent intent) {
        final PluginDeviceInfo O00000oO;
        if (bleDevice != null && O00000oO != null) {
            final XQProgressHorizontalDialog O000000o2 = XQProgressHorizontalDialog.O000000o(context, context.getString(R.string.plugin_downloading) + O00000oO.O0000Oo0() + context.getString(R.string.plugin));
            final PluginDownloadTask pluginDownloadTask = new PluginDownloadTask();
            Intent intent2 = new Intent();
            intent2.putExtra("null", "null");
            intent2.setExtrasClassLoader(fod.class.getClassLoader());
            ArrayList arrayList = new ArrayList();
            int i = 1;
            if (!(bleDevice instanceof BleDeviceGroup)) {
                arrayList.add(bleDevice.O000000o());
                intent2.putParcelableArrayListExtra("devices", arrayList);
            } else if (!"yeelink.light.ble1".equalsIgnoreCase(bleDevice.model)) {
                arrayList.addAll(((BleDeviceGroup) bleDevice).O0000Ooo());
                intent2.putParcelableArrayListExtra("devices", arrayList);
                i = 8;
            }
            if (intent != null) {
                intent2.putExtras(intent);
            }
            intent2.putExtra("extra_device_model", bleDevice.model);
            intent2.putExtra("extra_device_did", bleDevice.did);
            byte[] O00000oo = foc.O00000oo(bleDevice.mac);
            if (!got.O00000o(O00000oo)) {
                intent2.putExtra("extra.scanRecord", O00000oo);
            }
            byte[] O0000OoO = foc.O0000OoO(bleDevice.mac);
            if (!got.O00000o(O0000OoO)) {
                intent2.putExtra("token", O0000OoO);
            }
            BleGattProfile O0000O0o = foc.O0000O0o(bleDevice.mac);
            if (O0000O0o != null) {
                intent2.putExtra("key_gatt_profile", O0000O0o);
            }
            bleDevice.setLaunchParams(intent2);
            DeviceStat newDeviceStat = DeviceRouterFactory.getDeviceWrapper().newDeviceStat(bleDevice);
            newDeviceStat.userId = CoreApi.O000000o().O0000o0();
            bleDevice.userId = newDeviceStat.userId;
            fpo.O000000o(bleDevice.mac);
            PluginApi.getInstance().sendMessage(glc.O0000O0o, bleDevice.model, i, intent2, newDeviceStat, null, false, new SendMessageCallback() {
                /* class _m_j.fod.AnonymousClass1 */

                public final void onMessageFailure(int i, String str) {
                }

                public final void onMessageSuccess(Intent intent) {
                }

                public final void onSendSuccess(Bundle bundle) {
                }

                public final void onDownloadStart(String str, PluginDownloadTask pluginDownloadTask) {
                    XQProgressHorizontalDialog xQProgressHorizontalDialog;
                    pluginDownloadTask.O000000o(pluginDownloadTask);
                    if (fod.O000000o(context) && (xQProgressHorizontalDialog = O000000o2) != null) {
                        xQProgressHorizontalDialog.O000000o(100, 0);
                        XQProgressHorizontalDialog xQProgressHorizontalDialog2 = O000000o2;
                        xQProgressHorizontalDialog2.f9117O000000o = false;
                        xQProgressHorizontalDialog2.setCancelable(true);
                        O000000o2.show();
                        O000000o2.setOnCancelListener(new DialogInterface.OnCancelListener() {
                            /* class _m_j.fod.AnonymousClass1.AnonymousClass1 */

                            public final void onCancel(DialogInterface dialogInterface) {
                                CoreApi.O000000o().O000000o(O00000oO.O00000Oo(), pluginDownloadTask);
                            }
                        });
                    }
                }

                public final void onDownloadProgress(String str, float f) {
                    XQProgressHorizontalDialog xQProgressHorizontalDialog;
                    if (fod.O000000o(context) && (xQProgressHorizontalDialog = O000000o2) != null) {
                        xQProgressHorizontalDialog.O000000o(100, (int) (f * 100.0f));
                    }
                }

                public final void onDownloadSuccess(String str) {
                    XQProgressHorizontalDialog xQProgressHorizontalDialog = O000000o2;
                    if (xQProgressHorizontalDialog != null) {
                        xQProgressHorizontalDialog.dismiss();
                    }
                }

                public final void onDownloadFailure(PluginError pluginError) {
                    XQProgressHorizontalDialog xQProgressHorizontalDialog = O000000o2;
                    if (xQProgressHorizontalDialog != null) {
                        xQProgressHorizontalDialog.dismiss();
                    }
                    izb.O000000o(glc.O0000O0o, (int) R.string.plugin_download_failure, 1).show();
                }

                public final void onDownloadCancel() {
                    XQProgressHorizontalDialog xQProgressHorizontalDialog = O000000o2;
                    if (xQProgressHorizontalDialog != null) {
                        xQProgressHorizontalDialog.dismiss();
                    }
                }
            });
        }
    }

    public static boolean O000000o(Context context) {
        if (!(context instanceof Activity) || ((Activity) context).isFinishing()) {
            return false;
        }
        return true;
    }

    private static boolean O000000o(BleDeviceGroup bleDeviceGroup) {
        if (bleDeviceGroup.mDeviceCount != 1 || O000000o(bleDeviceGroup.O0000OoO().get(0))) {
            return false;
        }
        if (!bleDeviceGroup.O0000O0o()) {
            return true;
        }
        String O00000o = BleDevice.O00000o(bleDeviceGroup.model);
        int O0000Oo = bleDeviceGroup.O0000Oo();
        if (O0000Oo == 0 || O0000Oo == 1) {
            return TextUtils.isEmpty(O00000o);
        }
        return false;
    }
}
