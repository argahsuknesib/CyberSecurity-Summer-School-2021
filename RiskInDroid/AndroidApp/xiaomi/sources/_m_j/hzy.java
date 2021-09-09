package _m_j;

import android.content.Intent;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.uwb.lib.UwbSdk;
import com.xiaomi.smarthome.uwb.lib.data.UwbScanDevice;
import com.xiaomi.smarthome.uwb.lib.processor.engine.IEngineSpecificKeyRetriever;
import com.xiaomi.smarthome.uwb.lib.processor.engine.KeyRetrieverListener;
import com.xiaomi.smarthome.uwb.lib.utils.UwbDeviceUtil;
import com.xiaomi.smarthome.uwb.lib.utils.UwbLogUtil;

public class hzy implements IEngineSpecificKeyRetriever {
    private static volatile hzy O00000o;

    /* renamed from: O000000o  reason: collision with root package name */
    public UwbScanDevice f1047O000000o;
    public KeyRetrieverListener O00000Oo;
    IEngineSpecificKeyRetriever O00000o0;

    private hzy() {
    }

    public static hzy O000000o() {
        if (O00000o == null) {
            synchronized (hzy.class) {
                if (O00000o == null) {
                    O00000o = new hzy();
                }
            }
        }
        return O00000o;
    }

    public static void O000000o(int i) {
        Intent intent = new Intent("mihome_uwb_key_retrieve_action");
        intent.putExtra("mihome_uwb_key_retrieve_action", i);
        ft.O000000o(UwbSdk.getApplication()).O000000o(intent);
    }

    public void startRetrieveSpecificKey(UwbScanDevice uwbScanDevice, final KeyRetrieverListener keyRetrieverListener, boolean z) {
        UwbLogUtil.d("Mijia-UWB-SpecKeyRetriever", "startRetrieveSpecificKey");
        this.O00000Oo = keyRetrieverListener;
        this.f1047O000000o = uwbScanDevice;
        if (UwbDeviceUtil.isMitvDeviceType(this.f1047O000000o)) {
            if (UwbSdk.getSdkConfig().getLogLevel() <= 3) {
                UwbLogUtil.d("Mijia-UWB-SpecKeyRetriever", "retrieveMitvSpecificKey retrieve did for mUwbScanDevice:" + this.f1047O000000o.toString());
            }
            this.O00000o0 = new hzw(CoreApi.O000000o().O0000o0());
            this.O00000o0.startRetrieveSpecificKey(this.f1047O000000o, new KeyRetrieverListener() {
                /* class _m_j.hzy.AnonymousClass3 */

                public final void onSuccess(String str, int i, String str2) {
                    UwbLogUtil.d("Mijia-UWB-SpecKeyRetriever", "retrieveMitvSpecificKey success useCache=true");
                    keyRetrieverListener.onSuccess(str, i, str2);
                    hzy.O000000o(0);
                }

                public final void onError(int i, String str) {
                    UwbLogUtil.d("Mijia-UWB-SpecKeyRetriever", "retrieveMitvSpecificKey fail, will use useCache=false");
                    hzy.this.O00000o0.startRetrieveSpecificKey(hzy.this.f1047O000000o, new KeyRetrieverListener() {
                        /* class _m_j.hzy.AnonymousClass3.AnonymousClass1 */

                        public final void onSuccess(String str, int i, String str2) {
                            UwbLogUtil.d("Mijia-UWB-SpecKeyRetriever", "retrieveMitvSpecificKey success useCache=false");
                            keyRetrieverListener.onSuccess(str, i, str2);
                            hzy.O000000o(0);
                        }

                        public final void onError(int i, String str) {
                            UwbLogUtil.d("Mijia-UWB-SpecKeyRetriever", "retrieveMitvSpecificKey onError useCache=false:" + i + "," + str);
                            keyRetrieverListener.onError(i, str);
                            hzy.O000000o(-1010);
                        }
                    }, false);
                }
            }, false);
        } else if (UwbDeviceUtil.isThirdTagDevice(this.f1047O000000o)) {
            if (UwbDeviceUtil.isLogin(this.f1047O000000o)) {
                gsy.O000000o(3, "Mijia-UWB-SpecKeyRetriever", "retrieveThirdHidSpecificKey: ");
                this.O00000o0 = new hzz();
                this.O00000o0.startRetrieveSpecificKey(this.f1047O000000o, new KeyRetrieverListener() {
                    /* class _m_j.hzy.AnonymousClass2 */

                    public final void onSuccess(String str, int i, String str2) {
                        gsy.O000000o(3, "Mijia-UWB-SpecKeyRetriever", "retrieveThirdHidSpecificKey onSuccess: key: " + str + " ; type: " + i);
                        keyRetrieverListener.onSuccess(str, i, str2);
                        hzy.O000000o(0);
                    }

                    public final void onError(int i, String str) {
                        gsy.O000000o(3, "Mijia-UWB-SpecKeyRetriever", "retrieveThirdHidSpecificKey onError: code: " + i + " ; msg: " + str);
                        hzy.this.O00000o0.startRetrieveSpecificKey(hzy.this.f1047O000000o, new KeyRetrieverListener() {
                            /* class _m_j.hzy.AnonymousClass2.AnonymousClass1 */

                            public final void onSuccess(String str, int i, String str2) {
                                UwbLogUtil.d("Mijia-UWB-SpecKeyRetriever", "retrieveThirdHidSpecificKey success useCache=false");
                                keyRetrieverListener.onSuccess(str, i, str2);
                                hzy.O000000o(0);
                            }

                            public final void onError(int i, String str) {
                                UwbLogUtil.d("Mijia-UWB-SpecKeyRetriever", "retrieveThirdHidSpecificKey onError useCache=false:code: " + i + ", msg: " + str);
                                keyRetrieverListener.onError(i, str);
                                hzy.O000000o(-1010);
                            }
                        }, false);
                    }
                }, true);
            }
        } else if (UwbDeviceUtil.isLogin(this.f1047O000000o)) {
            UwbLogUtil.d("Mijia-UWB-SpecKeyRetriever", "retrieveIotDeviceSpecificKey useCache=true");
            this.O00000o0 = new hzu();
            this.O00000o0.startRetrieveSpecificKey(this.f1047O000000o, new KeyRetrieverListener() {
                /* class _m_j.hzy.AnonymousClass1 */

                public final void onSuccess(String str, int i, String str2) {
                    UwbLogUtil.d("Mijia-UWB-SpecKeyRetriever", "retrieveIotDeviceSpecificKey success useCache=true");
                    hzy.this.O00000Oo.onSuccess(str, i, str2);
                    hzy.O000000o(0);
                }

                public final void onError(int i, String str) {
                    UwbLogUtil.d("Mijia-UWB-SpecKeyRetriever", "retrieveIotDeviceSpecificKey fail, will use useCache=false");
                    hzy.this.O00000o0.startRetrieveSpecificKey(hzy.this.f1047O000000o, new KeyRetrieverListener() {
                        /* class _m_j.hzy.AnonymousClass1.AnonymousClass1 */

                        public final void onSuccess(String str, int i, String str2) {
                            UwbLogUtil.d("Mijia-UWB-SpecKeyRetriever", "retrieveIotDeviceSpecificKey success useCache=false");
                            hzy.this.O00000Oo.onSuccess(str, i, str2);
                            hzy.O000000o(0);
                        }

                        public final void onError(int i, String str) {
                            UwbLogUtil.d("Mijia-UWB-SpecKeyRetriever", "retrieveIotDeviceSpecificKey onError useCache=false:" + i + "," + str);
                            hzy.this.O00000Oo.onError(i, str);
                            hzy.O000000o(-1010);
                        }
                    }, false);
                }
            }, true);
        }
    }

    public void clearCacheKey(UwbScanDevice uwbScanDevice) {
        UwbLogUtil.d("Mijia-UWB-SpecKeyRetriever", "clearCacheKey");
        IEngineSpecificKeyRetriever iEngineSpecificKeyRetriever = this.O00000o0;
        if (iEngineSpecificKeyRetriever != null) {
            iEngineSpecificKeyRetriever.clearCacheKey(uwbScanDevice);
        }
    }

    public void destroy() {
        UwbLogUtil.d("Mijia-UWB-SpecKeyRetriever", "destroy");
        IEngineSpecificKeyRetriever iEngineSpecificKeyRetriever = this.O00000o0;
        if (iEngineSpecificKeyRetriever != null) {
            iEngineSpecificKeyRetriever.destroy();
        }
    }
}
