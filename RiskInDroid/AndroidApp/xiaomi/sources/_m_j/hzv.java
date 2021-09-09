package _m_j;

import _m_j.ddt;
import _m_j.ggb;
import _m_j.hzv;
import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.xiaomi.idm.uwb.constant.UwbConst;
import com.xiaomi.smarthome.controls.AllReadyCallback;
import com.xiaomi.smarthome.uwb.lib.UwbSdk;
import com.xiaomi.smarthome.uwb.lib.data.DidInfo;
import com.xiaomi.smarthome.uwb.lib.data.UwbScanDevice;
import com.xiaomi.smarthome.uwb.lib.idm.UwbDataListener;
import com.xiaomi.smarthome.uwb.lib.idm.UwbIdmManager;
import com.xiaomi.smarthome.uwb.lib.keyretriever.BaseMitvSpecificKeyRetriever;
import com.xiaomi.smarthome.uwb.lib.processor.engine.KeyRetrieverListener;
import com.xiaomi.smarthome.uwb.lib.protocol.UwbDataGenerator;
import com.xiaomi.smarthome.uwb.lib.protocol.format.Payload;
import com.xiaomi.smarthome.uwb.lib.utils.UwbDeviceUtil;
import com.xiaomi.smarthome.uwb.lib.utils.UwbLogUtil;
import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

public final class hzv extends BaseMitvSpecificKeyRetriever {

    /* renamed from: O000000o  reason: collision with root package name */
    String f1036O000000o;
    UwbScanDevice O00000Oo;
    String O00000o;
    String O00000o0;
    KeyRetrieverListener O00000oO;
    boolean O00000oo;
    UwbDataListener O0000O0o = new UwbDataListener() {
        /* class _m_j.hzv.AnonymousClass1 */

        public final void onConnectionState(String str, int i) {
        }

        public final void onSendPayload(int i) {
        }

        public final void onPayloadReceived(Payload payload) {
            if (TextUtils.isEmpty(hzv.this.O00000o0) && payload != null) {
                hzv hzv = hzv.this;
                if (TextUtils.isEmpty(hzv.O00000o0)) {
                    UwbLogUtil.e("Mijia-UWB-timestamp", "onMitvDidRetrieved start");
                    if (payload != null) {
                        bxe.O000000o(new String(payload.getData()), new bxa() {
                            /* class _m_j.hzv.AnonymousClass2 */

                            public final void onSuccess(bxc bxc) {
                                UwbLogUtil.d("Mijia-UWB-MitvMemKeyRetriever", "UwbLogUtilPlus onMitvDidRetrieved onSuccess");
                                bxl bxl = bxc.O00000Oo;
                                String O000000o2 = bxl.O000000o("tvKey");
                                String O000000o3 = bxl.O000000o("partnerId");
                                UwbLogUtil.d("member", "UwbLogUtilPlus onMitvDidRetrieved tvKey: " + O000000o2 + " partnerIdHash: " + O000000o3);
                                if (!TextUtils.isEmpty(O000000o2)) {
                                    hzv.this.mHandler.removeMessages(4096);
                                    hzv hzv = hzv.this;
                                    DidInfo didInfo = hzv.O00000Oo.getDidInfo();
                                    if (didInfo == null) {
                                        didInfo = new DidInfo();
                                        hzv.O00000Oo.setDidInfo(didInfo);
                                    }
                                    didInfo.setPlainDid(O000000o3);
                                    hzv.O00000o0 = O000000o2;
                                    hzv.O00000o = O000000o3;
                                    hzv.this.O000000o();
                                }
                            }

                            public final void onFailed(int i, String str) {
                                UwbLogUtil.d("Mijia-UWB-MitvMemKeyRetriever", "UwbLogUtilPlus onMitvDidRetrieved onFailed " + i + "," + str);
                                if (i != -702) {
                                    hzv.this.O00000oO.onError(i, str);
                                    hzv.this.O00000Oo();
                                }
                            }
                        });
                    }
                }
            }
        }
    };

    public hzv(String str) {
        this.f1036O000000o = str;
    }

    public final void startRetrieveSpecificKey(UwbScanDevice uwbScanDevice, KeyRetrieverListener keyRetrieverListener, boolean z) {
        UwbIdmManager.getInstance().addUWBDataListener(this.O0000O0o);
        this.O00000Oo = uwbScanDevice;
        this.O00000oO = keyRetrieverListener;
        this.O00000oo = z;
        if (TextUtils.isEmpty(this.O00000o0)) {
            UwbLogUtil.e("Mijia-UWB-timestamp", "retrieveMitvDid start");
            UwbLogUtil.d("Mijia-UWB-MitvMemKeyRetriever", "retrieveMitvDid");
            Payload generateMitvDidCmdPlayload = UwbDataGenerator.generateMitvDidCmdPlayload();
            if (UwbSdk.getSdkConfig().getLogLevel() <= 3) {
                StringBuilder sb = new StringBuilder("UwbLogUtilPlus retrieveMitvDid ");
                sb.append(generateMitvDidCmdPlayload == null ? null : generateMitvDidCmdPlayload.toString());
                UwbLogUtil.w("Mijia-UWB-MitvMemKeyRetriever", sb.toString());
            }
            this.mHandler.sendEmptyMessageDelayed(4096, (long) MITV_DEFAULT_TIMEOUT);
            UwbIdmManager.getInstance().sendPayload(this.O00000Oo.getUwbAddress(), generateMitvDidCmdPlayload, UwbConst.Flag.NOT_ENCRYPT);
            return;
        }
        O000000o();
    }

    public final void clearCacheKey(UwbScanDevice uwbScanDevice) {
        UwbLogUtil.d("Mijia-UWB-MitvMemKeyRetriever", "member clearCacheKey");
        UwbDeviceUtil.saveUwbDeviceKey("", O000000o(this.O00000o0));
        ddt.O0000O0o.O000000o();
    }

    public final void destroy() {
        O00000Oo();
    }

    public final void O000000o() {
        if (this.O00000oo) {
            UwbLogUtil.d("member", "UwbLogUtilPlus startKeyRetrieve useCache");
            String uwbDeviceKey = UwbDeviceUtil.getUwbDeviceKey(O000000o(this.O00000o0));
            if (TextUtils.isEmpty(uwbDeviceKey)) {
                this.O00000oO.onError(-1020, "there is no cached member spec key");
            } else {
                this.O00000oO.onSuccess(uwbDeviceKey, 0, this.f1036O000000o);
            }
            O00000Oo();
            return;
        }
        if (hzq.O00000o0(this.O00000Oo) || hzq.O00000Oo(this.O00000Oo)) {
            UwbLogUtil.d("member", "UwbLogUtilPlus startKeyRetrieveForOwner");
            UwbDeviceUtil.saveUwbDeviceKey("", O000000o(this.O00000o0));
            O00000o0();
        }
        O00000Oo();
    }

    @SuppressLint({"LongLogTag"})
    private void O00000o0() {
        if (TextUtils.isEmpty(this.O00000o)) {
            this.O00000oO.onError(-10101, "mitv: startKeyRetrieveForOwner mitvDid is empty");
        } else {
            new AllReadyCallback(4, new Runnable() {
                /* class _m_j.$$Lambda$hzv$WSLfkf2sA3w8lB6NBB2nDePUHI */

                public final void run() {
                    hzv.this.O00000o();
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O00000o() {
        final String str = this.O00000o;
        if (str != null && str.length() > 6) {
            str = this.O00000o.substring(0, 6);
        }
        String O00000o02 = hzq.O00000o0(str);
        if (!TextUtils.isEmpty(O00000o02)) {
            UwbLogUtil.d("Mijia-UWB-MitvMemKeyRetriever", "UwbLogUtilPlus3 realDid1:".concat(String.valueOf(O00000o02)));
            new Handler(Looper.getMainLooper()).post(new Runnable(O00000o02) {
                /* class _m_j.$$Lambda$hzv$wyBbivj4vSBpmLksXVL9LWfntsg */
                private final /* synthetic */ String f$1;

                {
                    this.f$1 = r2;
                }

                public final void run() {
                    hzv.this.O00000Oo(this.f$1);
                }
            });
            return;
        }
        UwbLogUtil.d("Mijia-UWB-MitvMemKeyRetriever", "realDid is empty, so start update HomeManager");
        ggb.O00000Oo().O000000o(new ggb.O0000OOo() {
            /* class _m_j.hzv.AnonymousClass4 */

            public final void O000000o() {
                String O00000o0 = hzq.O00000o0(str);
                if (!TextUtils.isEmpty(O00000o0)) {
                    UwbLogUtil.d("UwbLogUtilPlus", "UwbLogUtilPlus3 realDid2:".concat(String.valueOf(O00000o0)));
                    new Handler(Looper.getMainLooper()).post(new Runnable(O00000o0) {
                        /* class _m_j.$$Lambda$hzv$4$pX3FW6OcQQPLNWl0g0I91LERnA */
                        private final /* synthetic */ String f$1;

                        {
                            this.f$1 = r2;
                        }

                        public final void run() {
                            hzv.AnonymousClass4.this.O000000o(this.f$1);
                        }
                    });
                    return;
                }
                UwbLogUtil.d("Mijia-UWB-MitvMemKeyRetriever", "realDid is still empty after HomeManager updated");
            }

            /* access modifiers changed from: private */
            public /* synthetic */ void O000000o(String str) {
                ddt.O0000O0o.O000000o(str).subscribe(new Observer<String>() {
                    /* class _m_j.hzv.AnonymousClass4.AnonymousClass1 */

                    public final void onComplete() {
                    }

                    public final void onSubscribe(@NonNull Disposable disposable) {
                    }

                    public final /* synthetic */ void onNext(@NonNull Object obj) {
                        String str = (String) obj;
                        UwbLogUtil.d("Mijia-UWB-MitvMemKeyRetriever", "handleIotMemberKeyRetrieve onNext ".concat(String.valueOf(str)));
                        if (TextUtils.isEmpty(str)) {
                            hzv.this.O00000oO.onError(-10103, "remote key is empty");
                            return;
                        }
                        UwbDeviceUtil.saveUwbDeviceKey(str, hzv.O000000o(hzv.this.O00000o0));
                        hzv.this.O00000oO.onSuccess(str, 0, hzv.this.f1036O000000o);
                    }

                    public final void onError(@NonNull Throwable th) {
                        UwbLogUtil.d("Mijia-UWB-MitvMemKeyRetriever", "handleIotMemberKeyRetrieve onError " + th.getMessage());
                        KeyRetrieverListener keyRetrieverListener = hzv.this.O00000oO;
                        keyRetrieverListener.onError(-10104, "exception hanppened:" + th.getMessage());
                    }
                });
            }
        });
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O00000Oo(String str) {
        ddt.O0000O0o.O000000o(str).subscribe(new Observer<String>() {
            /* class _m_j.hzv.AnonymousClass3 */

            public final void onComplete() {
            }

            public final void onSubscribe(@NonNull Disposable disposable) {
            }

            public final /* synthetic */ void onNext(@NonNull Object obj) {
                String str = (String) obj;
                UwbLogUtil.d("Mijia-UWB-MitvMemKeyRetriever", "handleIotMemberKeyRetrieve onNext ".concat(String.valueOf(str)));
                if (TextUtils.isEmpty(str)) {
                    hzv.this.O00000oO.onError(-10103, "remote key is empty");
                    return;
                }
                UwbDeviceUtil.saveUwbDeviceKey(str, hzv.O000000o(hzv.this.O00000o0));
                hzv.this.O00000oO.onSuccess(str, 0, hzv.this.f1036O000000o);
            }

            public final void onError(@NonNull Throwable th) {
                UwbLogUtil.d("Mijia-UWB-MitvMemKeyRetriever", "handleIotMemberKeyRetrieve onError " + th.getMessage());
                KeyRetrieverListener keyRetrieverListener = hzv.this.O00000oO;
                keyRetrieverListener.onError(-10104, "exception hanppened:" + th.getMessage());
            }
        });
    }

    public final void O00000Oo() {
        this.mHandler.removeMessages(4096);
        UwbIdmManager.getInstance().removeUWBDataListener(this.O0000O0o);
    }

    public static String O000000o(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return "0-".concat(String.valueOf(str));
    }
}
