package _m_j;

import _m_j.fpd;
import android.bluetooth.BluetoothAdapter;
import android.os.Handler;
import android.os.Looper;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.library.bluetooth.connect.response.BleResponse;
import no.nordicsemi.android.dfu.DfuSettingsConstants;

public final class fmd {

    /* renamed from: O000000o  reason: collision with root package name */
    public static fpd.O000000o f16598O000000o;

    public static void O000000o() {
        fpd.O00000Oo().O000000o(f16598O000000o);
    }

    public static void O00000Oo() {
        fpd.O00000Oo().O00000Oo(f16598O000000o);
        f16598O000000o = null;
    }

    public static String O000000o(int i) {
        switch (i) {
            case 10:
                return "state_off";
            case 11:
                return "state_turning_on";
            case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT:
                return "state_on";
            case 13:
                return "state_turning_off";
            default:
                return "unknown ".concat(String.valueOf(i));
        }
    }

    public static void O000000o(final BleResponse bleResponse, final int i) {
        glc.O000000o(new Runnable() {
            /* class _m_j.fmd.AnonymousClass1 */

            public final void run() {
                gnk.O00000o0(String.format("BluetoothState change response: %d", Integer.valueOf(i)));
                bleResponse.onResponse(i, null);
            }
        }, 0);
    }

    public static void O000000o(final BleResponse bleResponse) {
        if (bleResponse != null && f16598O000000o == null) {
            final Handler handler = new Handler(Looper.getMainLooper());
            CommonApplication.getGlobalWorkerHandler().post(new Runnable() {
                /* class _m_j.fmd.AnonymousClass2 */

                /* JADX WARNING: Code restructure failed: missing block: B:5:0x0029, code lost:
                    if (_m_j.gnl.O0000O0o() != false) goto L_0x002b;
                 */
                public final void run() {
                    int state = gnl.O00000o().getState();
                    gnk.O00000o0(String.format("openBluetooth: current status = %s", fmd.O000000o(state)));
                    switch (state) {
                        case 10:
                        case 13:
                            break;
                        case 11:
                            fmd.f16598O000000o = new fpd.O000000o() {
                                /* class _m_j.fmd.AnonymousClass2.AnonymousClass1 */

                                public final void O000000o(int i, int i2) {
                                    if (i != 12 && i2 == 12) {
                                        handler.removeCallbacksAndMessages(null);
                                        fmd.O00000Oo();
                                        fmd.O000000o(bleResponse, 0);
                                    }
                                }
                            };
                            handler.postDelayed(new Runnable() {
                                /* class _m_j.fmd.AnonymousClass2.AnonymousClass2 */

                                public final void run() {
                                    handler.removeCallbacksAndMessages(null);
                                    fmd.O00000Oo();
                                    fmd.O000000o(bleResponse, -7);
                                }
                            }, 10000);
                            fmd.O000000o();
                            return;
                        case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT:
                            fmd.O000000o(bleResponse, 0);
                            return;
                        default:
                            fmd.O000000o(bleResponse, -1);
                            return;
                    }
                }
            });
        }
    }

    public static void O00000Oo(final BleResponse bleResponse) {
        if (bleResponse != null && f16598O000000o == null) {
            final Handler handler = new Handler(Looper.getMainLooper());
            CommonApplication.getGlobalWorkerHandler().post(new Runnable() {
                /* class _m_j.fmd.AnonymousClass3 */

                /* JADX WARNING: Code restructure failed: missing block: B:7:0x002f, code lost:
                    if (r3 != false) goto L_0x0031;
                 */
                public final void run() {
                    BluetoothAdapter O00000o;
                    int state = gnl.O00000o().getState();
                    boolean z = false;
                    gnk.O00000o0(String.format("closeBluetooth: current status = %s", fmd.O000000o(state)));
                    switch (state) {
                        case 10:
                            fmd.O000000o(bleResponse, 0);
                            return;
                        case 11:
                        case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT:
                            if (gnl.O00000Oo() && (O00000o = gnl.O00000o()) != null) {
                                z = O00000o.disable();
                                break;
                            }
                        case 13:
                            fmd.f16598O000000o = new fpd.O000000o() {
                                /* class _m_j.fmd.AnonymousClass3.AnonymousClass1 */

                                public final void O000000o(int i, int i2) {
                                    if (i != 10 && i2 == 10) {
                                        handler.removeCallbacksAndMessages(null);
                                        fmd.O00000Oo();
                                        fmd.O000000o(bleResponse, 0);
                                    }
                                }
                            };
                            handler.postDelayed(new Runnable() {
                                /* class _m_j.fmd.AnonymousClass3.AnonymousClass2 */

                                public final void run() {
                                    handler.removeCallbacksAndMessages(null);
                                    fmd.O00000Oo();
                                    fmd.O000000o(bleResponse, -7);
                                }
                            }, 10000);
                            fmd.O000000o();
                            return;
                        default:
                            fmd.O000000o(bleResponse, -1);
                            return;
                    }
                }
            });
        }
    }
}
