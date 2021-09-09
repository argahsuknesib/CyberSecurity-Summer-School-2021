package _m_j;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.RemoteException;
import android.text.TextUtils;
import com.xiaomi.smarthome.bluetooth.Response;
import com.xiaomi.smarthome.bluetooth.XmBluetoothManager;
import com.xiaomi.smarthome.core.server.internal.bluetooth.security.ISecureConnectHandler;
import com.xiaomi.smarthome.device.api.DeviceStat;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.frame.plugin.runtime.activity.LockSecurePinUtil;
import com.xiaomi.smarthome.library.bluetooth.BleConnectOptions;
import com.xiaomi.smarthome.library.bluetooth.connect.response.BleConnectResponse;
import com.xiaomi.smarthome.library.log.LogType;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

public final class fpp {

    /* renamed from: O000000o  reason: collision with root package name */
    public static Handler f16854O000000o;
    public static Map<String, gle> O00000Oo = new ConcurrentHashMap();
    private static ISecureConnectHandler O00000o;
    private static HandlerThread O00000o0;

    private static void O000000o() {
        if (f16854O000000o == null) {
            HandlerThread handlerThread = new HandlerThread("BluetoothOptimizeHelper");
            O00000o0 = handlerThread;
            handlerThread.start();
            f16854O000000o = new Handler(O00000o0.getLooper());
        }
    }

    public static void O000000o(String str) {
        HandlerThread handlerThread;
        O00000Oo("BluetoothOptimizeHelper destroy!");
        if (CoreApi.O000000o().O0000o00(str)) {
            ISecureConnectHandler iSecureConnectHandler = O00000o;
            if (iSecureConnectHandler != null) {
                try {
                    iSecureConnectHandler.cancel();
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
            if (f16854O000000o != null && (handlerThread = O00000o0) != null) {
                handlerThread.quit();
                f16854O000000o = null;
                O00000o0 = null;
            }
        }
    }

    public static void O000000o(String str, String str2, BleConnectOptions bleConnectOptions, Response.BleConnectResponse bleConnectResponse) {
        O000000o(str, str2, bleConnectOptions, bleConnectResponse, CoreApi.O000000o().O000OO0o());
    }

    public static void O000000o(String str, String str2, BleConnectOptions bleConnectOptions, Response.BleConnectResponse bleConnectResponse, int i) {
        O000000o();
        O00000Oo("secureConnect  " + str + ", retry: " + i);
        final String str3 = str;
        final Response.BleConnectResponse bleConnectResponse2 = bleConnectResponse;
        final int i2 = i;
        final String str4 = str2;
        final BleConnectOptions bleConnectOptions2 = bleConnectOptions;
        O00000o = fpo.O000000o(str2, bleConnectOptions, new gle() {
            /* class _m_j.fpp.AnonymousClass1 */

            public final void O000000o(int i, Bundle bundle) {
            }

            public final void O00000Oo(int i, Bundle bundle) {
            }

            public final void O00000o0(int i, Bundle bundle) {
            }

            public final void O00000o(int i, Bundle bundle) {
                fpp.O00000Oo("secureConnect  code: " + i + ", optimize: " + CoreApi.O000000o().O0000o00(str3));
                if (fpp.f16854O000000o == null) {
                    bleConnectResponse2.onResponse(-2, null);
                } else if ((i == -6 || i == -27) && CoreApi.O000000o().O0000o00(str3) && i2 > 0) {
                    XmBluetoothManager.getInstance().disconnect(str4);
                    fpp.f16854O000000o.postDelayed(new Runnable() {
                        /* class _m_j.fpp.AnonymousClass1.AnonymousClass1 */

                        public final void run() {
                            fpp.O000000o(str3, str4, bleConnectOptions2, bleConnectResponse2, i2 - 1);
                        }
                    }, (long) CoreApi.O000000o().O0000o0(str3));
                } else if (i != -13 || !CoreApi.O000000o().O0000o0O(str3) || i2 <= 0) {
                    fpp.O00000Oo("secureConnect   response code: ".concat(String.valueOf(i)));
                    bleConnectResponse2.onResponse(i, bundle);
                } else {
                    fpp.f16854O000000o.postDelayed(new Runnable() {
                        /* class _m_j.fpp.AnonymousClass1.AnonymousClass2 */

                        public final void run() {
                            fpp.O000000o(str3, str4, bleConnectOptions2, bleConnectResponse2, i2 - 1);
                        }
                    }, (long) CoreApi.O000000o().O0000o0o(str3));
                }
            }
        });
    }

    public static void O000000o(DeviceStat deviceStat, Activity activity, String str, String str2, BleConnectOptions bleConnectOptions, gle gle) {
        final int O000OO0o = CoreApi.O000000o().O000OO0o();
        if (CoreApi.O000000o().O0000o(str)) {
            final DeviceStat deviceStat2 = deviceStat;
            final Activity activity2 = activity;
            final String str3 = str;
            final String str4 = str2;
            final BleConnectOptions bleConnectOptions2 = bleConnectOptions;
            final gle gle2 = gle;
            LockSecurePinUtil.checkLtmkChangedV2(activity, deviceStat2.did, str2, true, new ba<Void>() {
                /* class _m_j.fpp.AnonymousClass2 */

                public final /* synthetic */ void accept(Object obj) {
                    fpp.O000000o(deviceStat2, activity2, str3, str4, bleConnectOptions2, gle2, O000OO0o);
                }
            });
            return;
        }
        O000000o(str, str2, bleConnectOptions, gle, O000OO0o);
    }

    public static void O000000o(DeviceStat deviceStat, Activity activity, String str, String str2, BleConnectOptions bleConnectOptions, gle gle, int i) {
        O000000o();
        O00000Oo("securityChipConnectV2  " + str + ", retry: " + i);
        final String str3 = str;
        final gle gle2 = gle;
        final int i2 = i;
        final String str4 = str2;
        final DeviceStat deviceStat2 = deviceStat;
        final Activity activity2 = activity;
        final BleConnectOptions bleConnectOptions2 = bleConnectOptions;
        O00000o = fpo.O00000o0(str2, bleConnectOptions, new gle() {
            /* class _m_j.fpp.AnonymousClass3 */

            public final void O000000o(int i, Bundle bundle) {
            }

            public final void O00000Oo(int i, Bundle bundle) {
            }

            public final void O00000o0(int i, Bundle bundle) {
            }

            public final void O00000o(final int i, final Bundle bundle) {
                fpp.O00000Oo("securityChipConnectV2  code: " + i + ", optimize: " + CoreApi.O000000o().O0000o00(str3));
                if (fpp.f16854O000000o == null) {
                    gle2.O00000o(-2, null);
                } else if (i == -6 && CoreApi.O000000o().O0000o00(str3) && i2 > 0) {
                    XmBluetoothManager.getInstance().disconnect(str4);
                    fpp.f16854O000000o.postDelayed(new Runnable() {
                        /* class _m_j.fpp.AnonymousClass3.AnonymousClass1 */

                        public final void run() {
                            fpp.O000000o(deviceStat2, activity2, str3, str4, bleConnectOptions2, gle2, i2 - 1);
                        }
                    }, (long) CoreApi.O000000o().O0000o0(str3));
                } else if (i == -13 && CoreApi.O000000o().O0000o0O(str3) && i2 > 0) {
                    fpp.f16854O000000o.postDelayed(new Runnable() {
                        /* class _m_j.fpp.AnonymousClass3.AnonymousClass2 */

                        public final void run() {
                            fpp.O000000o(deviceStat2, activity2, str3, str4, bleConnectOptions2, gle2, i2 - 1);
                        }
                    }, (long) CoreApi.O000000o().O0000o0o(str3));
                } else if (i == -38 || -22 == i) {
                    glw.O000000o().connect(str4, null, new BleConnectResponse() {
                        /* class _m_j.fpp.AnonymousClass3.AnonymousClass3 */

                        public final /* synthetic */ void onResponse(int i, Object obj) {
                            fpp.O00000Oo("securityChipConnectV2  only connect ,code =".concat(String.valueOf(i)));
                            if (i == 0) {
                                fpp.O00000Oo("securityChipConnectV2  判定设备就在身边");
                                if (fqx.O000000o(deviceStat2.model, deviceStat2.version)) {
                                    glw.O000000o().disconnect(str4);
                                    fpp.O00000Oo("securityChipConnectV2  checkLtmkChanged");
                                    LockSecurePinUtil.checkLtmkChangedV2(activity2, deviceStat2.did, str4, false, null);
                                    fpp.O00000Oo.put(deviceStat2.did, gle2);
                                    return;
                                }
                                fgo.O000000o(deviceStat2.did, new feo<JSONObject, fes>() {
                                    /* class _m_j.fpp.AnonymousClass3.AnonymousClass3.AnonymousClass1 */

                                    public final /* synthetic */ void O000000o(Object obj) {
                                        JSONObject jSONObject = (JSONObject) obj;
                                        fpp.O00000Oo("securityChipConnectV2  getOwnLtmk onSuccess");
                                        String optString = jSONObject != null ? jSONObject.optString("key") : "";
                                        if (!TextUtils.isEmpty(optString)) {
                                            ffr.O0000Oo(str4, optString);
                                            fpp.O000000o(str3, str4, bleConnectOptions2, gle2, i2);
                                            return;
                                        }
                                        gle2.O00000o(i, bundle);
                                    }

                                    public final void O000000o(fes fes) {
                                        gle2.O00000o(i, bundle);
                                        fpp.O00000Oo("securityChipConnectV2  getOwnLtmk onFailure");
                                    }
                                });
                                return;
                            }
                            fpp.O00000Oo("securityChipConnectV2  判定设备不在身边");
                            gle2.O00000o(i, bundle);
                        }
                    });
                } else {
                    gle2.O00000o(i, bundle);
                }
            }
        });
    }

    public static void O000000o(String str, String str2, BleConnectOptions bleConnectOptions, gle gle, int i) {
        O000000o();
        O00000Oo("securityChipConnect  " + str + ", retry: " + i);
        final String str3 = str;
        final gle gle2 = gle;
        final int i2 = i;
        final String str4 = str2;
        final BleConnectOptions bleConnectOptions2 = bleConnectOptions;
        O00000o = fpo.O00000o0(str2, bleConnectOptions, new gle() {
            /* class _m_j.fpp.AnonymousClass4 */

            public final void O000000o(int i, Bundle bundle) {
            }

            public final void O00000Oo(int i, Bundle bundle) {
            }

            public final void O00000o0(int i, Bundle bundle) {
            }

            public final void O00000o(int i, Bundle bundle) {
                fpp.O00000Oo("securityChipConnect  code: " + i + ", optimize: " + CoreApi.O000000o().O0000o00(str3));
                if (fpp.f16854O000000o == null) {
                    gle2.O00000o(-2, null);
                } else if (i == -6 && CoreApi.O000000o().O0000o00(str3) && i2 > 0) {
                    XmBluetoothManager.getInstance().disconnect(str4);
                    fpp.f16854O000000o.postDelayed(new Runnable() {
                        /* class _m_j.fpp.AnonymousClass4.AnonymousClass1 */

                        public final void run() {
                            fpp.O000000o(str3, str4, bleConnectOptions2, gle2, i2 - 1);
                        }
                    }, (long) CoreApi.O000000o().O0000o0(str3));
                } else if (i != -13 || !CoreApi.O000000o().O0000o0O(str3) || i2 <= 0) {
                    fpp.O00000Oo("securityChipConnect   response code: ".concat(String.valueOf(i)));
                    gle2.O00000o(i, bundle);
                } else {
                    fpp.f16854O000000o.postDelayed(new Runnable() {
                        /* class _m_j.fpp.AnonymousClass4.AnonymousClass2 */

                        public final void run() {
                            fpp.O000000o(str3, str4, bleConnectOptions2, gle2, i2 - 1);
                        }
                    }, (long) CoreApi.O000000o().O0000o0o(str3));
                }
            }
        });
    }

    public static void O000000o(String str, String str2, BleConnectOptions bleConnectOptions, gle gle) {
        O00000Oo(str, str2, bleConnectOptions, gle, CoreApi.O000000o().O000OO0o());
    }

    public static void O00000Oo(String str, String str2, BleConnectOptions bleConnectOptions, gle gle, int i) {
        O000000o();
        O00000Oo("securityChipSharedDeviceConnect  " + str + ", retry: " + i);
        final String str3 = str;
        final gle gle2 = gle;
        final int i2 = i;
        final String str4 = str2;
        final BleConnectOptions bleConnectOptions2 = bleConnectOptions;
        O00000o = fpo.O00000Oo(str2, bleConnectOptions, new gle() {
            /* class _m_j.fpp.AnonymousClass5 */

            public final void O000000o(int i, Bundle bundle) {
            }

            public final void O00000Oo(int i, Bundle bundle) {
            }

            public final void O00000o0(int i, Bundle bundle) {
            }

            public final void O00000o(int i, Bundle bundle) {
                fpp.O00000Oo("securityChipSharedDeviceConnect  code: " + i + ", optimize: " + CoreApi.O000000o().O0000o00(str3));
                if (fpp.f16854O000000o == null) {
                    gle2.O00000o(-2, null);
                } else if (i == -6 && CoreApi.O000000o().O0000o00(str3) && i2 > 0) {
                    XmBluetoothManager.getInstance().disconnect(str4);
                    fpp.f16854O000000o.postDelayed(new Runnable() {
                        /* class _m_j.fpp.AnonymousClass5.AnonymousClass1 */

                        public final void run() {
                            fpp.O00000Oo(str3, str4, bleConnectOptions2, gle2, i2 - 1);
                        }
                    }, (long) CoreApi.O000000o().O0000o0(str3));
                } else if (i != -13 || !CoreApi.O000000o().O0000o0O(str3) || i2 <= 0) {
                    fpp.O00000Oo("securityChipSharedDeviceConnect   response code: ".concat(String.valueOf(i)));
                    gle2.O00000o(i, bundle);
                } else {
                    fpp.f16854O000000o.postDelayed(new Runnable() {
                        /* class _m_j.fpp.AnonymousClass5.AnonymousClass2 */

                        public final void run() {
                            fpp.O00000Oo(str3, str4, bleConnectOptions2, gle2, i2 - 1);
                        }
                    }, (long) CoreApi.O000000o().O0000o0o(str3));
                }
            }
        });
    }

    public static void O00000Oo(String str, String str2, BleConnectOptions bleConnectOptions, gle gle) {
        O00000o0(str, str2, bleConnectOptions, gle, CoreApi.O000000o().O000OO0o());
    }

    public static void O00000o0(String str, String str2, BleConnectOptions bleConnectOptions, gle gle, int i) {
        O000000o();
        O00000Oo("bleStandardAuthConnect  " + str + ", retry: " + i);
        final String str3 = str;
        final gle gle2 = gle;
        final int i2 = i;
        final String str4 = str2;
        final BleConnectOptions bleConnectOptions2 = bleConnectOptions;
        O00000o = fpo.O00000oO(str2, bleConnectOptions, new gle() {
            /* class _m_j.fpp.AnonymousClass6 */

            public final void O000000o(int i, Bundle bundle) {
            }

            public final void O00000Oo(int i, Bundle bundle) {
            }

            public final void O00000o0(int i, Bundle bundle) {
            }

            public final void O00000o(int i, Bundle bundle) {
                fpp.O00000Oo("bleStandardAuthConnect  code: " + i + ", optimize: " + CoreApi.O000000o().O0000o00(str3));
                if (fpp.f16854O000000o == null) {
                    gle2.O00000o(-2, null);
                } else if ((i == -6 || i == -27) && CoreApi.O000000o().O0000o00(str3) && i2 > 0) {
                    XmBluetoothManager.getInstance().disconnect(str4);
                    fpp.f16854O000000o.postDelayed(new Runnable() {
                        /* class _m_j.fpp.AnonymousClass6.AnonymousClass1 */

                        public final void run() {
                            fpp.O00000o0(str3, str4, bleConnectOptions2, gle2, i2 - 1);
                        }
                    }, (long) CoreApi.O000000o().O0000o0(str3));
                } else if (i != -13 || !CoreApi.O000000o().O0000o0O(str3) || i2 <= 0) {
                    fpp.O00000Oo("bleStandardAuthConnect   response code: ".concat(String.valueOf(i)));
                    gle2.O00000o(i, bundle);
                } else {
                    fpp.f16854O000000o.postDelayed(new Runnable() {
                        /* class _m_j.fpp.AnonymousClass6.AnonymousClass2 */

                        public final void run() {
                            fpp.O00000o0(str3, str4, bleConnectOptions2, gle2, i2 - 1);
                        }
                    }, (long) CoreApi.O000000o().O0000o0o(str3));
                }
            }
        });
    }

    public static void O000000o(String str, String str2, String str3, Response.BleConnectResponse bleConnectResponse) {
        O000000o(str, str2, str3, bleConnectResponse, CoreApi.O000000o().O000OO0o());
    }

    public static void O000000o(String str, String str2, String str3, Response.BleConnectResponse bleConnectResponse, int i) {
        O000000o();
        O00000Oo("bleMeshConnect  " + str + ", retry: " + i);
        final Response.BleConnectResponse bleConnectResponse2 = bleConnectResponse;
        final String str4 = str;
        final int i2 = i;
        final String str5 = str2;
        final String str6 = str3;
        XmBluetoothManager.getInstance().bleMeshConnect(str2, str3, new Response.BleConnectResponse() {
            /* class _m_j.fpp.AnonymousClass7 */

            public final /* synthetic */ void onResponse(int i, Object obj) {
                Bundle bundle = (Bundle) obj;
                if (fpp.f16854O000000o == null) {
                    bleConnectResponse2.onResponse(-2, null);
                    return;
                }
                fpp.O00000Oo("bleMeshConnect  code: " + i + ", optimize: " + CoreApi.O000000o().O0000o00(str4));
                if (i == -6 && CoreApi.O000000o().O0000o00(str4) && i2 > 0) {
                    XmBluetoothManager.getInstance().disconnect(str5);
                    fpp.f16854O000000o.postDelayed(new Runnable() {
                        /* class _m_j.fpp.AnonymousClass7.AnonymousClass1 */

                        public final void run() {
                            fpp.O000000o(str4, str5, str6, bleConnectResponse2, i2 - 1);
                        }
                    }, (long) CoreApi.O000000o().O0000o0(str4));
                } else if (i != -13 || !CoreApi.O000000o().O0000o0O(str4) || i2 <= 0) {
                    fpp.O00000Oo("bleMeshConnect   response code: ".concat(String.valueOf(i)));
                    bleConnectResponse2.onResponse(i, bundle);
                } else {
                    fpp.f16854O000000o.postDelayed(new Runnable() {
                        /* class _m_j.fpp.AnonymousClass7.AnonymousClass2 */

                        public final void run() {
                            fpp.O000000o(str4, str5, str6, bleConnectResponse2, i2 - 1);
                        }
                    }, (long) CoreApi.O000000o().O0000o0o(str4));
                }
            }
        });
    }

    public static void O00000Oo(String str) {
        if (!TextUtils.isEmpty(str)) {
            gsy.O000000o(LogType.PLUGIN, "rn-plugin-framework", 4, "core-bluetooth", str);
        }
    }
}
