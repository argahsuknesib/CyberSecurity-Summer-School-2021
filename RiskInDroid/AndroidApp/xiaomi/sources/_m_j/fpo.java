package _m_j;

import _m_j.fdz;
import _m_j.fed;
import _m_j.fem;
import _m_j.gnk;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.bluetooth.Response;
import com.xiaomi.smarthome.core.entity.bluetooth.SearchRequest;
import com.xiaomi.smarthome.core.entity.device.BtDevice;
import com.xiaomi.smarthome.core.entity.plugin.PluginDeviceInfo;
import com.xiaomi.smarthome.core.server.bluetooth.IBleResponse;
import com.xiaomi.smarthome.core.server.bluetooth.SearchResponse;
import com.xiaomi.smarthome.core.server.internal.bluetooth.BluetoothResponse;
import com.xiaomi.smarthome.core.server.internal.bluetooth.security.ISecureConnectHandler;
import com.xiaomi.smarthome.core.server.internal.bluetooth.security.SecureConnectOptions;
import com.xiaomi.smarthome.core.server.internal.bluetooth.security.combo.BleComboWifiConfig;
import com.xiaomi.smarthome.device.BleDevice;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.frame.plugin.PluginApi;
import com.xiaomi.smarthome.library.bluetooth.BleConnectOptions;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class fpo extends glc {

    /* renamed from: O000000o  reason: collision with root package name */
    public static ExecutorService f16833O000000o = Executors.newSingleThreadExecutor();

    public static boolean O000000o() {
        return false;
    }

    public static void O000000o(BleDevice bleDevice) {
        if (bleDevice != null && CoreApi.O000000o().O0000Oo(bleDevice.model) != null) {
            Intent intent = new Intent();
            intent.putExtra("mac", bleDevice.mac);
            PluginApi.getInstance().sendMessage(CommonApplication.getAppContext(), bleDevice.model, 9, intent, null, null, false, null);
        }
    }

    public static int O000000o(String str, String str2) {
        return fml.O000000o(str, str2);
    }

    public static boolean O000000o(int i, String str) {
        return flo.O000000o(i, str);
    }

    public static void O000000o(String str, BluetoothResponse bluetoothResponse) {
        Bundle bundle = new Bundle();
        bundle.putString("extra.submac", str);
        CoreApi.O000000o().O000000o((String) null, 37, bundle, bluetoothResponse);
    }

    public static void O00000Oo() {
        CoreApi.O000000o().O000O0o();
    }

    public static void O000000o(SearchRequest searchRequest, SearchResponse searchResponse) {
        CoreApi.O000000o().O000000o(searchRequest, searchResponse);
    }

    public static boolean O00000Oo(String str, String str2) {
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            return true;
        }
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            if (str.equalsIgnoreCase(str2)) {
                return true;
            }
            PluginDeviceInfo O00000oO = CoreApi.O000000o().O00000oO(str);
            PluginDeviceInfo O00000oO2 = CoreApi.O000000o().O00000oO(str2);
            if (!(O00000oO == null || O00000oO2 == null)) {
                int O00000o0 = O00000oO.O00000o0();
                int i = O00000oO.O000O0o0;
                int O00000o02 = O00000oO2.O00000o0();
                if (O00000o0 == O00000oO2.O000O0o0 || i == O00000o02) {
                    return true;
                }
                return false;
            }
        }
        return false;
    }

    public static void O000000o(String str) {
        CoreApi.O000000o().O000000o(str, 31, (Bundle) null, (IBleResponse) null);
    }

    public static void O00000o0() {
        CoreApi.O000000o().O000000o((String) null, 32, (Bundle) null, (IBleResponse) null);
    }

    public static void O000000o(final SearchRequest searchRequest, final fon fon) {
        if (searchRequest == null || fon == null) {
            fte.O00000Oo(String.format("searchMiioBluetoothDevice request or resposne null", new Object[0]));
        } else {
            CoreApi.O000000o().O000000o(CommonApplication.getAppContext(), new CoreApi.O0000o0() {
                /* class _m_j.fpo.AnonymousClass1 */

                public final void onCoreReady() {
                    CoreApi O000000o2 = CoreApi.O000000o();
                    SearchRequest searchRequest = searchRequest;
                    AnonymousClass1 r2 = new fem() {
                        /* class _m_j.fpo.AnonymousClass1.AnonymousClass1 */

                        public final /* synthetic */ void O000000o(Object obj) {
                            final BtDevice btDevice = (BtDevice) obj;
                            fpo.f16833O000000o.submit(new Runnable() {
                                /* class _m_j.fpo.AnonymousClass1.AnonymousClass1.AnonymousClass1 */

                                public final void run() {
                                    final BleDevice O000000o2 = BleDevice.O000000o(btDevice);
                                    CommonApplication.getGlobalHandler().post(new Runnable() {
                                        /* class _m_j.fpo.AnonymousClass1.AnonymousClass1.AnonymousClass1.AnonymousClass1 */

                                        public final void run() {
                                            fon.O000000o(O000000o2);
                                        }
                                    });
                                }
                            });
                        }

                        public final void O000000o() {
                            fon.O000000o();
                        }

                        public final void O00000Oo() {
                            fon.O00000Oo();
                        }

                        public final void O00000o0() {
                            fon.O00000o0();
                        }
                    };
                    if (searchRequest != null) {
                        try {
                            O000000o2.O00000Oo().searchMiioBluetoothDevice(searchRequest, new IBleResponse.Stub(r2) {
                                /* class com.xiaomi.smarthome.frame.core.CoreApi.AnonymousClass61 */
                                final /* synthetic */ fem val$response;

                                {
                                    this.val$response = r2;
                                }

                                public void onResponse(int i, Bundle bundle) {
                                    CoreApi.this.O00000o.post(new fdz(i, bundle) {
                                        /* class com.xiaomi.smarthome.frame.core.CoreApi.AnonymousClass61.AnonymousClass1 */

                                        public final void run() {
                                            if (this.f16144O000000o == fed.f16180O000000o) {
                                                AnonymousClass61.this.val$response.O000000o();
                                            } else if (this.f16144O000000o == fed.O00000o0) {
                                                AnonymousClass61.this.val$response.O00000Oo();
                                            } else if (this.f16144O000000o == fed.O00000Oo) {
                                                AnonymousClass61.this.val$response.O00000o0();
                                            } else if (this.f16144O000000o == fed.O00000o && this.O00000Oo != null) {
                                                this.O00000Oo.setClassLoader(getClass().getClassLoader());
                                                BtDevice btDevice = null;
                                                try {
                                                    btDevice = (BtDevice) this.O00000Oo.getParcelable("extra.device");
                                                } catch (Exception e) {
                                                    gnk.O00000Oo(gnk.O00000Oo(e));
                                                }
                                                if (btDevice != null) {
                                                    AnonymousClass61.this.val$response.O000000o(btDevice);
                                                }
                                            }
                                        }
                                    });
                                }
                            });
                        } catch (Throwable th) {
                            gnk.O00000Oo(gnk.O00000Oo(th));
                        }
                    } else {
                        gnk.O00000oo("searchMiioBluetoothDevice: request or response null");
                    }
                }
            });
        }
    }

    public static void O000000o(String str, Response.BleConnectResponse bleConnectResponse) {
        BleConnectOptions.O000000o o000000o = new BleConnectOptions.O000000o();
        o000000o.f9073O000000o = 1;
        o000000o.O00000o0 = 35000;
        o000000o.O00000Oo = 2;
        o000000o.O00000o = 20000;
        O000000o(str, o000000o.O000000o(), bleConnectResponse);
    }

    public static void O000000o(String str, BleConnectOptions bleConnectOptions, final Response.BleConnectResponse bleConnectResponse) {
        O000000o(str, bleConnectOptions, new gle() {
            /* class _m_j.fpo.AnonymousClass10 */

            public final void O000000o(int i, Bundle bundle) {
            }

            public final void O00000Oo(int i, Bundle bundle) {
            }

            public final void O00000o0(int i, Bundle bundle) {
            }

            public final void O00000o(int i, Bundle bundle) {
                Response.BleConnectResponse bleConnectResponse = bleConnectResponse;
                if (bleConnectResponse != null) {
                    bleConnectResponse.onResponse(i, bundle);
                }
            }
        });
    }

    public static void O000000o(String str, BleComboWifiConfig bleComboWifiConfig, BleConnectOptions bleConnectOptions, final Response.BleConnectResponse bleConnectResponse) {
        SecureConnectOptions.O000000o o000000o = new SecureConnectOptions.O000000o();
        o000000o.f6884O000000o = bleConnectOptions;
        CoreApi.O000000o().O000000o(str, bleComboWifiConfig, o000000o.O000000o(), new gle() {
            /* class _m_j.fpo.AnonymousClass11 */

            public final void O000000o(int i, Bundle bundle) {
            }

            public final void O00000Oo(int i, Bundle bundle) {
            }

            public final void O00000o0(int i, Bundle bundle) {
            }

            public final void O00000o(int i, Bundle bundle) {
                Response.BleConnectResponse bleConnectResponse = bleConnectResponse;
                if (bleConnectResponse != null) {
                    bleConnectResponse.onResponse(i, bundle);
                }
            }
        });
    }

    public static ISecureConnectHandler O000000o(final String str, BleConnectOptions bleConnectOptions, final gle gle) {
        SecureConnectOptions.O000000o o000000o = new SecureConnectOptions.O000000o();
        o000000o.f6884O000000o = bleConnectOptions;
        return CoreApi.O000000o().O000000o(str, o000000o.O000000o(), new gle() {
            /* class _m_j.fpo.AnonymousClass12 */

            public final void O000000o(int i, Bundle bundle) {
                gle gle = gle;
                if (gle != null) {
                    gle.O000000o(i, bundle);
                }
            }

            public final void O00000Oo(int i, Bundle bundle) {
                gle gle = gle;
                if (gle != null) {
                    gle.O00000Oo(i, bundle);
                }
            }

            public final void O00000o0(int i, Bundle bundle) {
                gle gle = gle;
                if (gle != null) {
                    gle.O00000o0(i, bundle);
                }
            }

            public final void O00000o(int i, Bundle bundle) {
                if (i == 0) {
                    Intent intent = new Intent("action.online.status.changed");
                    intent.putExtra("extra_mac", str);
                    intent.putExtra("extra_online_status", 80);
                    glc.O0000O0o.sendBroadcast(intent);
                }
                gle gle = gle;
                if (gle != null) {
                    gle.O00000o(i, bundle);
                }
            }
        });
    }

    public static void O00000Oo(String str, final Response.BleConnectResponse bleConnectResponse) {
        BleConnectOptions.O000000o o000000o = new BleConnectOptions.O000000o();
        o000000o.f9073O000000o = 1;
        o000000o.O00000o0 = 35000;
        o000000o.O00000Oo = 2;
        o000000o.O00000o = 20000;
        O00000Oo(str, o000000o.O000000o(), new gle() {
            /* class _m_j.fpo.AnonymousClass13 */

            public final void O000000o(int i, Bundle bundle) {
            }

            public final void O00000Oo(int i, Bundle bundle) {
            }

            public final void O00000o0(int i, Bundle bundle) {
            }

            public final void O00000o(int i, Bundle bundle) {
                Response.BleConnectResponse bleConnectResponse = bleConnectResponse;
                if (bleConnectResponse != null) {
                    bleConnectResponse.onResponse(i, bundle);
                }
            }
        });
    }

    public static ISecureConnectHandler O00000Oo(final String str, BleConnectOptions bleConnectOptions, final gle gle) {
        SecureConnectOptions.O000000o o000000o = new SecureConnectOptions.O000000o();
        o000000o.f6884O000000o = bleConnectOptions;
        return CoreApi.O000000o().O00000o0(str, o000000o.O000000o(), new gle() {
            /* class _m_j.fpo.AnonymousClass14 */

            public final void O000000o(int i, Bundle bundle) {
                gle gle = gle;
                if (gle != null) {
                    gle.O000000o(i, bundle);
                }
            }

            public final void O00000Oo(int i, Bundle bundle) {
                gle gle = gle;
                if (gle != null) {
                    gle.O00000Oo(i, bundle);
                }
            }

            public final void O00000o0(int i, Bundle bundle) {
                gle gle = gle;
                if (gle != null) {
                    gle.O00000o0(i, bundle);
                }
            }

            public final void O00000o(int i, Bundle bundle) {
                if (i == 0) {
                    Intent intent = new Intent("action.online.status.changed");
                    intent.putExtra("extra_mac", str);
                    intent.putExtra("extra_online_status", 80);
                    glc.O0000O0o.sendBroadcast(intent);
                }
                gle gle = gle;
                if (gle != null) {
                    gle.O00000o(i, bundle);
                }
            }
        });
    }

    public static void O00000o0(String str, final Response.BleConnectResponse bleConnectResponse) {
        BleConnectOptions.O000000o o000000o = new BleConnectOptions.O000000o();
        o000000o.f9073O000000o = 1;
        o000000o.O00000o0 = 35000;
        o000000o.O00000Oo = 2;
        o000000o.O00000o = 20000;
        O00000o0(str, o000000o.O000000o(), new gle() {
            /* class _m_j.fpo.AnonymousClass15 */

            public final void O000000o(int i, Bundle bundle) {
            }

            public final void O00000Oo(int i, Bundle bundle) {
            }

            public final void O00000o0(int i, Bundle bundle) {
            }

            public final void O00000o(int i, Bundle bundle) {
                Response.BleConnectResponse bleConnectResponse = bleConnectResponse;
                if (bleConnectResponse != null) {
                    bleConnectResponse.onResponse(i, bundle);
                }
            }
        });
    }

    public static ISecureConnectHandler O00000o0(final String str, BleConnectOptions bleConnectOptions, final gle gle) {
        SecureConnectOptions.O000000o o000000o = new SecureConnectOptions.O000000o();
        o000000o.f6884O000000o = bleConnectOptions;
        return CoreApi.O000000o().O00000Oo(str, o000000o.O000000o(), new gle() {
            /* class _m_j.fpo.AnonymousClass16 */

            public final void O000000o(int i, Bundle bundle) {
                gle gle = gle;
                if (gle != null) {
                    gle.O000000o(i, bundle);
                }
            }

            public final void O00000Oo(int i, Bundle bundle) {
                gle gle = gle;
                if (gle != null) {
                    gle.O00000Oo(i, bundle);
                }
            }

            public final void O00000o0(int i, Bundle bundle) {
                gle gle = gle;
                if (gle != null) {
                    gle.O00000o0(i, bundle);
                }
            }

            public final void O00000o(int i, Bundle bundle) {
                if (i == 0) {
                    Intent intent = new Intent("action.online.status.changed");
                    intent.putExtra("extra_mac", str);
                    intent.putExtra("extra_online_status", 80);
                    glc.O0000O0o.sendBroadcast(intent);
                }
                gle gle = gle;
                if (gle != null) {
                    gle.O00000o(i, bundle);
                }
            }
        });
    }

    public static ISecureConnectHandler O00000o(final String str, BleConnectOptions bleConnectOptions, final gle gle) {
        SecureConnectOptions.O000000o o000000o = new SecureConnectOptions.O000000o();
        o000000o.f6884O000000o = bleConnectOptions;
        return CoreApi.O000000o().O00000o(str, o000000o.O000000o(), new gle() {
            /* class _m_j.fpo.AnonymousClass17 */

            public final void O000000o(int i, Bundle bundle) {
                gle gle = gle;
                if (gle != null) {
                    gle.O000000o(i, bundle);
                }
            }

            public final void O00000Oo(int i, Bundle bundle) {
                gle gle = gle;
                if (gle != null) {
                    gle.O00000Oo(i, bundle);
                }
            }

            public final void O00000o0(int i, Bundle bundle) {
                gle gle = gle;
                if (gle != null) {
                    gle.O00000o0(i, bundle);
                }
            }

            public final void O00000o(int i, Bundle bundle) {
                if (i == 0) {
                    Intent intent = new Intent("action.online.status.changed");
                    intent.putExtra("extra_mac", str);
                    intent.putExtra("extra_online_status", 80);
                    glc.O0000O0o.sendBroadcast(intent);
                }
                gle gle = gle;
                if (gle != null) {
                    gle.O00000o(i, bundle);
                }
            }
        });
    }

    public static void O000000o(String str, String str2, String str3, final Response.BleConnectResponse bleConnectResponse) {
        BleConnectOptions.O000000o o000000o = new BleConnectOptions.O000000o();
        o000000o.f9073O000000o = 2;
        o000000o.O00000o0 = 35000;
        o000000o.O00000Oo = 2;
        o000000o.O00000o = 20000;
        O000000o(str, str2, str3, o000000o.O000000o(), new gle() {
            /* class _m_j.fpo.AnonymousClass2 */

            public final void O000000o(int i, Bundle bundle) {
            }

            public final void O00000Oo(int i, Bundle bundle) {
            }

            public final void O00000o0(int i, Bundle bundle) {
            }

            public final void O00000o(int i, Bundle bundle) {
                Response.BleConnectResponse bleConnectResponse = bleConnectResponse;
                if (bleConnectResponse != null) {
                    bleConnectResponse.onResponse(i, bundle);
                }
            }
        });
    }

    public static ISecureConnectHandler O000000o(final String str, String str2, String str3, BleConnectOptions bleConnectOptions, final gle gle) {
        SecureConnectOptions.O000000o o000000o = new SecureConnectOptions.O000000o();
        o000000o.f6884O000000o = bleConnectOptions;
        return CoreApi.O000000o().O000000o(str, str2, str3, o000000o.O000000o(), new gle() {
            /* class _m_j.fpo.AnonymousClass3 */

            public final void O000000o(int i, Bundle bundle) {
                gle gle = gle;
                if (gle != null) {
                    gle.O000000o(i, bundle);
                }
            }

            public final void O00000Oo(int i, Bundle bundle) {
                gle gle = gle;
                if (gle != null) {
                    gle.O00000Oo(i, bundle);
                }
            }

            public final void O00000o0(int i, Bundle bundle) {
                gle gle = gle;
                if (gle != null) {
                    gle.O00000o0(i, bundle);
                }
            }

            public final void O00000o(int i, Bundle bundle) {
                if (i == 0) {
                    Intent intent = new Intent("action.online.status.changed");
                    intent.putExtra("extra_mac", str);
                    intent.putExtra("extra_online_status", 80);
                    glc.O0000O0o.sendBroadcast(intent);
                }
                gle gle = gle;
                if (gle != null) {
                    gle.O00000o(i, bundle);
                }
            }
        });
    }

    public static ISecureConnectHandler O000000o(final String str, String str2, String str3, int i, final gle gle) {
        BleConnectOptions.O000000o o000000o = new BleConnectOptions.O000000o();
        o000000o.f9073O000000o = 1;
        o000000o.O00000o0 = 35000;
        o000000o.O00000Oo = 2;
        o000000o.O00000o = 20000;
        BleConnectOptions O000000o2 = o000000o.O000000o();
        SecureConnectOptions.O000000o o000000o2 = new SecureConnectOptions.O000000o();
        o000000o2.f6884O000000o = O000000o2;
        return CoreApi.O000000o().O000000o(str, str2, str3, i, o000000o2.O000000o(), new gle() {
            /* class _m_j.fpo.AnonymousClass4 */

            public final void O000000o(int i, Bundle bundle) {
                gle gle = gle;
                if (gle != null) {
                    gle.O000000o(i, bundle);
                }
            }

            public final void O00000Oo(int i, Bundle bundle) {
                gle gle = gle;
                if (gle != null) {
                    gle.O00000Oo(i, bundle);
                }
            }

            public final void O00000o0(int i, Bundle bundle) {
                gle gle = gle;
                if (gle != null) {
                    gle.O00000o0(i, bundle);
                }
            }

            public final void O00000o(int i, Bundle bundle) {
                if (i == 0) {
                    Intent intent = new Intent("action.online.status.changed");
                    intent.putExtra("extra_mac", str);
                    intent.putExtra("extra_online_status", 80);
                    glc.O0000O0o.sendBroadcast(intent);
                }
                gle gle = gle;
                if (gle != null) {
                    gle.O00000o(i, bundle);
                }
            }
        });
    }

    public static void O00000o(String str, final Response.BleConnectResponse bleConnectResponse) {
        BleConnectOptions.O000000o o000000o = new BleConnectOptions.O000000o();
        o000000o.f9073O000000o = 1;
        o000000o.O00000o0 = 35000;
        o000000o.O00000Oo = 2;
        o000000o.O00000o = 20000;
        O00000oO(str, o000000o.O000000o(), new gle() {
            /* class _m_j.fpo.AnonymousClass5 */

            public final void O000000o(int i, Bundle bundle) {
            }

            public final void O00000Oo(int i, Bundle bundle) {
            }

            public final void O00000o0(int i, Bundle bundle) {
            }

            public final void O00000o(int i, Bundle bundle) {
                Response.BleConnectResponse bleConnectResponse = bleConnectResponse;
                if (bleConnectResponse != null) {
                    bleConnectResponse.onResponse(i, bundle);
                }
            }
        });
    }

    public static ISecureConnectHandler O00000oO(final String str, BleConnectOptions bleConnectOptions, final gle gle) {
        SecureConnectOptions.O000000o o000000o = new SecureConnectOptions.O000000o();
        o000000o.f6884O000000o = bleConnectOptions;
        SecureConnectOptions O000000o2 = o000000o.O000000o();
        Object[] objArr = new Object[2];
        objArr[0] = foc.O00000o(str);
        objArr[1] = bleConnectOptions != null ? bleConnectOptions.toString() : null;
        fte.O00000Oo(String.format("BluetoothHelper bleStandardAuthConnect model = %s, connectionOptions %s", objArr));
        return CoreApi.O000000o().O00000oo(str, O000000o2, new gle() {
            /* class _m_j.fpo.AnonymousClass6 */

            public final void O000000o(int i, Bundle bundle) {
                Object[] objArr = new Object[2];
                objArr[0] = Integer.valueOf(i);
                objArr[1] = bundle != null ? bundle.toString() : null;
                fte.O00000Oo(String.format("BluetoothHelper bleStandardAuthConnect onConnectResponse code %d, bundle %s", objArr));
                gle gle = gle;
                if (gle != null) {
                    gle.O000000o(i, bundle);
                }
            }

            public final void O00000Oo(int i, Bundle bundle) {
                Object[] objArr = new Object[2];
                objArr[0] = Integer.valueOf(i);
                objArr[1] = bundle != null ? bundle.toString() : null;
                fte.O00000Oo(String.format("BluetoothHelper bleStandardAuthConnect onAuthResponse code %d, bundle %s", objArr));
                gle gle = gle;
                if (gle != null) {
                    gle.O00000Oo(i, bundle);
                }
            }

            public final void O00000o0(int i, Bundle bundle) {
                Object[] objArr = new Object[2];
                objArr[0] = Integer.valueOf(i);
                objArr[1] = bundle != null ? bundle.toString() : null;
                fte.O00000Oo(String.format("BluetoothHelper bleStandardAuthConnect onBindResponse code %d, bundle %s", objArr));
                gle gle = gle;
                if (gle != null) {
                    gle.O00000o0(i, bundle);
                }
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
            public final void O00000o(int i, Bundle bundle) {
                Object[] objArr = new Object[2];
                objArr[0] = Integer.valueOf(i);
                objArr[1] = bundle != null ? bundle.toString() : null;
                fte.O00000Oo(String.format("BluetoothHelper bleStandardAuthConnect onLastResponse ,code %d, bundle %s", objArr));
                if (i == 0) {
                    Intent intent = new Intent("action.online.status.changed");
                    intent.putExtra("extra_mac", str);
                    intent.putExtra("extra_online_status", 80);
                    intent.putExtra("IS_STANDARD_AUTH_DEVICE", true);
                    glc.O0000O0o.sendBroadcast(intent);
                }
                gle gle = gle;
                if (gle != null) {
                    gle.O00000o(i, bundle);
                }
            }
        });
    }

    public static ISecureConnectHandler O00000oo(final String str, BleConnectOptions bleConnectOptions, final gle gle) {
        SecureConnectOptions.O000000o o000000o = new SecureConnectOptions.O000000o();
        o000000o.f6884O000000o = bleConnectOptions;
        SecureConnectOptions O000000o2 = o000000o.O000000o();
        Object[] objArr = new Object[2];
        objArr[0] = foc.O00000o(str);
        objArr[1] = bleConnectOptions != null ? bleConnectOptions.toString() : null;
        fte.O00000Oo(String.format("BluetoothHelper bleStandardAuthBind model = %s, connectionOptions %s", objArr));
        return CoreApi.O000000o().O00000oO(str, O000000o2, new gle() {
            /* class _m_j.fpo.AnonymousClass7 */

            public final void O000000o(int i, Bundle bundle) {
                Object[] objArr = new Object[2];
                objArr[0] = Integer.valueOf(i);
                objArr[1] = bundle != null ? bundle.toString() : null;
                fte.O00000Oo(String.format("BluetoothHelper bleStandardAuthBind onConnectResponse code %d, bundle %s", objArr));
                gle gle = gle;
                if (gle != null) {
                    gle.O000000o(i, bundle);
                }
            }

            public final void O00000Oo(int i, Bundle bundle) {
                Object[] objArr = new Object[2];
                objArr[0] = Integer.valueOf(i);
                objArr[1] = bundle != null ? bundle.toString() : null;
                fte.O00000Oo(String.format("BluetoothHelper bleStandardAuthBind onAuthResponse code %d, bundle %s", objArr));
                gle gle = gle;
                if (gle != null) {
                    gle.O00000Oo(i, bundle);
                }
            }

            public final void O00000o0(int i, Bundle bundle) {
                Object[] objArr = new Object[2];
                objArr[0] = Integer.valueOf(i);
                objArr[1] = bundle != null ? bundle.toString() : null;
                fte.O00000Oo(String.format("BluetoothHelper bleStandardAuthBind onBindResponse code %d, bundle %s", objArr));
                gle gle = gle;
                if (gle != null) {
                    gle.O00000o0(i, bundle);
                }
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
            public final void O00000o(int i, Bundle bundle) {
                Object[] objArr = new Object[2];
                objArr[0] = Integer.valueOf(i);
                objArr[1] = bundle != null ? bundle.toString() : null;
                fte.O00000Oo(String.format("BluetoothHelper bleStandardAuthBind onLastResponse code %d, bundle %s", objArr));
                if (i == 0) {
                    Intent intent = new Intent("action.online.status.changed");
                    intent.putExtra("extra_mac", str);
                    intent.putExtra("extra_online_status", 80);
                    intent.putExtra("IS_STANDARD_AUTH_DEVICE", true);
                    glc.O0000O0o.sendBroadcast(intent);
                }
                gle gle = gle;
                if (gle != null) {
                    gle.O00000o(i, bundle);
                }
            }
        });
    }

    public static void O000000o(String str, int i) {
        if (i == 1) {
            foc.O0000o(str);
        } else if (i == 2) {
            fob.O000000o(fob.O00000o0(str));
        } else if (i == 3) {
            CoreApi.O000000o().O000000o(str, 40, (Bundle) null, (IBleResponse) null);
        }
    }

    public static void O00000o0(String str, final String str2) {
        gnk.O00000oO(String.format("renameBleDevice for %s, name = %s", str, str2));
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            final BleDevice O00000o0 = fob.O00000o0(str);
            if (O00000o0 != null && !TextUtils.isEmpty(O00000o0.did)) {
                gwe.O000000o();
                gwe.O000000o(O00000o0, str2, new fsm<Void, fso>() {
                    /* class _m_j.fpo.AnonymousClass8 */

                    public final void onFailure(fso fso) {
                        gnk.O00000o0(String.format("onFailure %s", fso));
                    }

                    public final /* synthetic */ void onSuccess(Object obj) {
                        gnk.O00000o0(String.format("onSuccess", new Object[0]));
                        O00000o0.name = str2;
                    }
                });
            }
            foc.O000000o(str, str2);
            fob.O000000o(true);
        }
    }

    public static void O00000o(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            gnk.O00000oO(String.format("setBleDeviceSubtitle for %s, subtitle = %s", str, str2));
            Bundle bundle = new Bundle();
            bundle.putString("extra.value", str2);
            CoreApi.O000000o().O00000Oo(str, 3, bundle);
            fob.O000000o(true);
        }
    }

    public static void O00000Oo(final String str) {
        if (!CommonApplication.isCurrentHotStart()) {
            CommonApplication.getGlobalHandler().postDelayed(new Runnable() {
                /* class _m_j.fpo.AnonymousClass9 */

                public final void run() {
                    Fresco.getImagePipeline().prefetchToDiskCache(ImageRequestBuilder.newBuilderWithSource(Uri.parse(str)).setResizeOptions(new ResizeOptions(540, 960)).build(), null);
                }
            }, 1000);
        }
    }

    public static void O00000oO(String str, String str2) {
        BleDevice O00000o0;
        gnk.O00000o0(String.format("notifyDeviceBinded: mac = %s, token = %s", gqb.O0000O0o(str), gqb.O0000O0o(str2)));
        if (!TextUtils.isEmpty(str) && (O00000o0 = fob.O00000o0(str)) != null) {
            if (!TextUtils.isEmpty(str2)) {
                foc.O00000oO(str, str2);
            }
            if (!O00000o0.O00000oO() && O00000o0.O00000o0()) {
                fno.O000000o().O0000Oo0(str);
                fob.O000000o(true);
            }
        }
    }
}
