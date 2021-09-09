package _m_j;

import _m_j.ddt;
import _m_j.exo;
import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.xiaomi.smarthome.application.ServiceApplication;
import com.xiaomi.smarthome.uwb.lib.UwbSdk;
import com.xiaomi.smarthome.uwb.lib.data.UwbScanDevice;
import com.xiaomi.smarthome.uwb.lib.processor.engine.IEngineSpecificKeyRetriever;
import com.xiaomi.smarthome.uwb.lib.processor.engine.KeyRetrieverListener;
import com.xiaomi.smarthome.uwb.lib.utils.UwbDeviceUtil;
import com.xiaomi.smarthome.uwb.lib.utils.UwbLogUtil;

public final class hzw implements IEngineSpecificKeyRetriever {

    /* renamed from: O000000o  reason: collision with root package name */
    String f1042O000000o;
    IEngineSpecificKeyRetriever O00000Oo;

    @SuppressLint({"LongLogTag"})
    public hzw(String str) {
        this.f1042O000000o = TextUtils.isEmpty(str) ? "000000" : str;
    }

    public final void startRetrieveSpecificKey(final UwbScanDevice uwbScanDevice, final KeyRetrieverListener keyRetrieverListener, final boolean z) {
        UwbLogUtil.d("Mijia-UWB-MitvKeyRetriever", "startRetrieveSpecificKey: useCache=".concat(String.valueOf(z)));
        if (UwbDeviceUtil.isMitvPublicMode(uwbScanDevice)) {
            UwbLogUtil.d("Mijia-UWB-MitvKeyRetriever", "UwbLogUtilPlus mitv is MitvPublicMode, do nothing");
        } else if (!UwbDeviceUtil.isMitvLogin(uwbScanDevice)) {
            if (UwbDeviceUtil.isMitvAuthAll(uwbScanDevice)) {
                UwbLogUtil.d("Mijia-UWB-MitvKeyRetriever", "UwbLogUtilPlus mitv not login, start stranger specific key retrieving");
                O00000o0(uwbScanDevice, keyRetrieverListener);
                return;
            }
            UwbLogUtil.d("Mijia-UWB-MitvKeyRetriever", "UwbLogUtilPlus mitv not login, and is not auth all, do nothing");
        } else if (ServiceApplication.getStateNotifier().f15923O000000o == 4 || ServiceApplication.getStateNotifier().f15923O000000o == 2 || ServiceApplication.getStateNotifier().f15923O000000o == 1) {
            ServiceApplication.getStateNotifier().O000000o(new exo.O000000o() {
                /* class _m_j.hzw.AnonymousClass1 */

                public final void onLoginSuccess() {
                    UwbLogUtil.d("Mijia-UWB-MitvKeyRetriever", "smarthome account login success");
                    hzw hzw = hzw.this;
                    UwbScanDevice uwbScanDevice = uwbScanDevice;
                    KeyRetrieverListener keyRetrieverListener = keyRetrieverListener;
                    boolean z = z;
                    if (hzq.O00000o0(uwbScanDevice)) {
                        UwbLogUtil.d("Mijia-UWB-MitvKeyRetriever", "UwbLogUtilPlus mitv owner, start member specific key retrieving");
                        hzw.O000000o(uwbScanDevice, keyRetrieverListener);
                        return;
                    }
                    AnonymousClass3 r5 = new BroadcastReceiver(uwbScanDevice, keyRetrieverListener, z) {
                        /* class _m_j.hzw.AnonymousClass3 */

                        /* renamed from: O000000o  reason: collision with root package name */
                        final /* synthetic */ UwbScanDevice f1046O000000o;
                        final /* synthetic */ KeyRetrieverListener O00000Oo;
                        final /* synthetic */ boolean O00000o0;

                        {
                            this.f1046O000000o = r2;
                            this.O00000Oo = r3;
                            this.O00000o0 = r4;
                        }

                        public final void onReceive(Context context, Intent intent) {
                            UwbLogUtil.d("Mijia-UWB-MitvKeyRetriever", "UwbLogUtilPlus home update success, start member or stranger key retrieving");
                            ft.O000000o(UwbSdk.getApplication()).O000000o(this);
                            hzw.this.O00000Oo(this.f1046O000000o, this.O00000Oo);
                        }
                    };
                    ft.O000000o(UwbSdk.getApplication()).O000000o(r5, new IntentFilter("home_room_sync"));
                    if (ggb.O00000Oo().O0000OoO.O00000oo) {
                        UwbLogUtil.d("Mijia-UWB-MitvKeyRetriever", "UwbLogUtilPlus home ready, start member or stranger key retrieving");
                        ft.O000000o(UwbSdk.getApplication()).O000000o(r5);
                        hzw.O00000Oo(uwbScanDevice, keyRetrieverListener);
                        return;
                    }
                    UwbLogUtil.d("Mijia-UWB-MitvKeyRetriever", "UwbLogUtilPlus home not ready, start update home from server");
                    ggb.O00000Oo().O00000o0();
                }

                public final void onLoginFailed() {
                    UwbLogUtil.d("Mijia-UWB-MitvKeyRetriever", "smarthome account login fail");
                    keyRetrieverListener.onError(-10100, "MitvSpecificKeyRetrieverImpl not login");
                }
            });
        } else {
            UwbLogUtil.d("Mijia-UWB-MitvKeyRetriever", "MITV in mihome need login and currentState=" + ServiceApplication.getStateNotifier().f15923O000000o + ",so just ignore for retrieve key");
        }
    }

    public final void clearCacheKey(UwbScanDevice uwbScanDevice) {
        IEngineSpecificKeyRetriever iEngineSpecificKeyRetriever = this.O00000Oo;
        if (iEngineSpecificKeyRetriever != null) {
            iEngineSpecificKeyRetriever.clearCacheKey(uwbScanDevice);
        }
        ddt.O0000O0o.O000000o();
    }

    public final void destroy() {
        IEngineSpecificKeyRetriever iEngineSpecificKeyRetriever = this.O00000Oo;
        if (iEngineSpecificKeyRetriever != null) {
            iEngineSpecificKeyRetriever.destroy();
        }
    }

    private void O00000o0(UwbScanDevice uwbScanDevice, KeyRetrieverListener keyRetrieverListener) {
        UwbLogUtil.d("Mijia-UWB-MitvKeyRetriever", "UwbLogUtilPlus startStrangerSpecificKeyRetrieve");
        this.O00000Oo = new hzx(this.f1042O000000o);
        O000000o(uwbScanDevice, keyRetrieverListener, this.O00000Oo);
    }

    /* access modifiers changed from: package-private */
    public final void O000000o(UwbScanDevice uwbScanDevice, KeyRetrieverListener keyRetrieverListener) {
        UwbLogUtil.d("Mijia-UWB-MitvKeyRetriever", "UwbLogUtilPlus startMemberSpecificKeyRetrieve");
        this.O00000Oo = new hzv(this.f1042O000000o);
        O000000o(uwbScanDevice, keyRetrieverListener, this.O00000Oo);
    }

    private void O000000o(final UwbScanDevice uwbScanDevice, final KeyRetrieverListener keyRetrieverListener, final IEngineSpecificKeyRetriever iEngineSpecificKeyRetriever) {
        UwbLogUtil.d("Mijia-UWB-MitvKeyRetriever", "startSpecificKeyRetrieve ".concat(String.valueOf(iEngineSpecificKeyRetriever)));
        iEngineSpecificKeyRetriever.startRetrieveSpecificKey(uwbScanDevice, new KeyRetrieverListener() {
            /* class _m_j.hzw.AnonymousClass2 */

            public final void onSuccess(String str, int i, String str2) {
                UwbLogUtil.d("Mijia-UWB-MitvKeyRetriever", "startSpecificKeyRetrieve onSuccess useCache is true");
                keyRetrieverListener.onSuccess(str, i, str2);
            }

            public final void onError(int i, String str) {
                UwbLogUtil.d("Mijia-UWB-MitvKeyRetriever", "startSpecificKeyRetrieve onError " + i + ", will use non-cache to update key " + iEngineSpecificKeyRetriever);
                iEngineSpecificKeyRetriever.startRetrieveSpecificKey(uwbScanDevice, new KeyRetrieverListener() {
                    /* class _m_j.hzw.AnonymousClass2.AnonymousClass1 */

                    public final void onSuccess(String str, int i, String str2) {
                        UwbLogUtil.d("Mijia-UWB-MitvKeyRetriever", "startSpecificKeyRetrieve onSuccess useCache is false");
                        keyRetrieverListener.onSuccess(str, i, str2);
                    }

                    public final void onError(int i, String str) {
                        UwbLogUtil.d("Mijia-UWB-MitvKeyRetriever", "startSpecificKeyRetrieve onError useCache is false:" + i + "," + str);
                        keyRetrieverListener.onError(i, str);
                    }
                }, false);
            }
        }, true);
    }

    public final void O00000Oo(UwbScanDevice uwbScanDevice, KeyRetrieverListener keyRetrieverListener) {
        UwbLogUtil.d("Mijia-UWB-MitvKeyRetriever", "handleKeyRetrieveWithLoginAndHome");
        if (hzq.O00000Oo(uwbScanDevice)) {
            O000000o(uwbScanDevice, keyRetrieverListener);
        } else if (UwbDeviceUtil.isMitvAuthAll(uwbScanDevice)) {
            O00000o0(uwbScanDevice, keyRetrieverListener);
        }
    }
}
