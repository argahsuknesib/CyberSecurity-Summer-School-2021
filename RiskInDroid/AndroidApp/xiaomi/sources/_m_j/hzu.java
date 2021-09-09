package _m_j;

import _m_j.ddt;
import _m_j.fno;
import android.os.Bundle;
import android.text.TextUtils;
import com.xiaomi.smarthome.application.ServiceApplication;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.uwb.lib.UwbSdk;
import com.xiaomi.smarthome.uwb.lib.auth.AuthResultCallback;
import com.xiaomi.smarthome.uwb.lib.auth.ByteUtils;
import com.xiaomi.smarthome.uwb.lib.auth.OobRequestCallback;
import com.xiaomi.smarthome.uwb.lib.auth.UwbStrangerRegister;
import com.xiaomi.smarthome.uwb.lib.data.UwbScanDevice;
import com.xiaomi.smarthome.uwb.lib.processor.engine.KeyRetrieverListener;
import com.xiaomi.smarthome.uwb.lib.utils.UwbDeviceUtil;
import com.xiaomi.smarthome.uwb.lib.utils.UwbLogUtil;
import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

public final class hzu extends hzt {
    public final void clearCacheKey(UwbScanDevice uwbScanDevice) {
        UwbLogUtil.d("Mijia-UWB-IotSpecKeyRetriever", "clearCacheKey");
        UwbDeviceUtil.saveUwbDeviceKey("", O00000o(uwbScanDevice));
        ddt.O0000O0o.O000000o();
    }

    public final void destroy() {
        UwbLogUtil.d("Mijia-UWB-IotSpecKeyRetriever", "destroy");
    }

    public static boolean O00000o0(UwbScanDevice uwbScanDevice) {
        return hzt.O000000o(uwbScanDevice);
    }

    /* access modifiers changed from: protected */
    public final void O00000Oo(final UwbScanDevice uwbScanDevice, final KeyRetrieverListener keyRetrieverListener, final boolean z) {
        UwbLogUtil.d("Mijia-UWB-IotSpecKeyRetriever", "handleIotKeyRetrieveOnDeviceReady: useCache=".concat(String.valueOf(z)));
        if (!hzt.O000000o(uwbScanDevice)) {
            UwbLogUtil.d("Mijia-UWB-IotSpecKeyRetriever", "handleIotMemberOrOwnerKeyRetrieve useCache=".concat(String.valueOf(z)));
            if (hzq.O00000Oo(uwbScanDevice)) {
                UwbLogUtil.d("Mijia-UWB-IotSpecKeyRetriever", "handleIotMemberKeyRetrieve useCache=".concat(String.valueOf(z)));
                final String O0000O0o = hzq.O0000O0o(uwbScanDevice);
                if (TextUtils.isEmpty(O0000O0o)) {
                    UwbLogUtil.e("Mijia-UWB-IotSpecKeyRetriever", "handleIotMemberKeyRetrieve：there is no home for " + UwbDeviceUtil.getDeviceAccountId(uwbScanDevice));
                    keyRetrieverListener.onError(-10105, "handleIotMemberKeyRetrieve：there is no home for " + UwbDeviceUtil.getDeviceAccountId(uwbScanDevice));
                } else if (ggb.O00000Oo().O0000Oo(O0000O0o).isEmpty()) {
                    UwbLogUtil.d("Mijia-UWB-IotSpecKeyRetriever", "handleIotMemberKeyRetrieve home device is emtpy, start change home");
                    ggb.O00000Oo().O000000o(O0000O0o, new fsm() {
                        /* class _m_j.hzu.AnonymousClass4 */

                        public final void onSuccess(Object obj) {
                            UwbLogUtil.d("Mijia-UWB-IotSpecKeyRetriever", "handleIotMemberKeyRetrieve changeHome onSuccess");
                            if (!ggb.O00000Oo().O0000Oo(O0000O0o).isEmpty()) {
                                UwbLogUtil.e("Mijia-UWB-IotSpecKeyRetriever", "handleIotMemberKeyRetrieve：changeHome onSuccess and got devices");
                                hzu.O00000o0(uwbScanDevice, keyRetrieverListener, z);
                                return;
                            }
                            ServiceApplication.getGlobalHandler().postDelayed(new Runnable() {
                                /* class _m_j.hzu.AnonymousClass4.AnonymousClass1 */

                                public final void run() {
                                    UwbLogUtil.d("Mijia-UWB-IotSpecKeyRetriever", "handleIotMemberKeyRetrieve start updateDeviceRemote after 2s delay");
                                    fno.O000000o().O000000o(new fno.O000000o() {
                                        /* class _m_j.hzu.AnonymousClass4.AnonymousClass1.AnonymousClass1 */

                                        public final void onRefreshClientDeviceChanged(int i, Device device) {
                                        }

                                        public final void onRefreshClientDeviceSuccess(int i) {
                                            fno.O000000o().O00000Oo(this);
                                            if (UwbSdk.getSdkConfig().getLogLevel() <= 3) {
                                                UwbLogUtil.e("Mijia-UWB-IotSpecKeyRetriever", "handleIotMemberKeyRetrieve：onRefreshClientDeviceSuccess onSuccess: home device size=" + ggb.O00000Oo().O0000Oo(O0000O0o).size());
                                            } else {
                                                UwbLogUtil.e("Mijia-UWB-IotSpecKeyRetriever", "handleIotMemberKeyRetrieve：onRefreshClientDeviceSuccess onSuccess");
                                            }
                                            hzu.O00000o0(uwbScanDevice, keyRetrieverListener, z);
                                        }
                                    });
                                    fno.O000000o().O0000Oo0();
                                }
                            }, 2000);
                        }

                        public final void onFailure(fso fso) {
                            UwbLogUtil.e("Mijia-UWB-IotSpecKeyRetriever", "handleIotMemberKeyRetrieve：change home error ".concat(String.valueOf(fso)));
                            keyRetrieverListener.onError(-10108, "handleIotMemberKeyRetrieve：change home error ".concat(String.valueOf(fso)));
                        }
                    });
                } else {
                    O00000o0(uwbScanDevice, keyRetrieverListener, z);
                }
            } else {
                String O00000oo = hzq.O00000oo(uwbScanDevice);
                String O00000oO = hzq.O00000oO(uwbScanDevice);
                if (UwbDeviceUtil.isTagDeviceType(uwbScanDevice.getDeviceType()) && TextUtils.isEmpty(O00000oO)) {
                    keyRetrieverListener.onError(-10101, "tag binded device not exist");
                } else if (TextUtils.isEmpty(O00000oo)) {
                    ggb.O00000Oo().O000000o(false);
                    ddt ddt = ddt.f14518O000000o;
                    ddt.O000000o(new Runnable(keyRetrieverListener, O00000oO, z) {
                        /* class _m_j.$$Lambda$hzu$kNHawbQ6MrA4_pK1WLA63comQBs */
                        private final /* synthetic */ KeyRetrieverListener f$1;
                        private final /* synthetic */ String f$2;
                        private final /* synthetic */ boolean f$3;

                        {
                            this.f$1 = r2;
                            this.f$2 = r3;
                            this.f$3 = r4;
                        }

                        public final void run() {
                            hzu.O000000o(UwbScanDevice.this, this.f$1, this.f$2, this.f$3);
                        }
                    });
                } else {
                    O000000o(uwbScanDevice, O00000oo, O00000oO, keyRetrieverListener, z);
                }
            }
        } else {
            UwbLogUtil.d("Mijia-UWB-IotSpecKeyRetriever", "handleIotStrangerKeyRetrieve useCache=".concat(String.valueOf(z)));
            if (z) {
                String uwbDeviceKey = UwbDeviceUtil.getUwbDeviceKey(O00000o(uwbScanDevice));
                if (TextUtils.isEmpty(uwbDeviceKey)) {
                    keyRetrieverListener.onError(-1020, "no cache spec key for stranger");
                    return;
                }
                int indexOf = uwbDeviceKey.indexOf("-");
                String substring = uwbDeviceKey.substring(0, indexOf);
                if (!TextUtils.equals(substring, CoreApi.O000000o().O0000o0())) {
                    keyRetrieverListener.onError(-10107, "no cache for current user: stored stranger key uid is different for current login uid");
                    return;
                }
                String substring2 = uwbDeviceKey.substring(indexOf + 1);
                UwbLogUtil.d("Mijia-UWB-IotSpecKeyRetriever", "handleIotStrangerKeyRetrieve useCache key success:uid=" + substring + ",key=" + substring2);
                keyRetrieverListener.onSuccess(substring2, 1, substring);
                return;
            }
            final String O00000Oo = hzq.O00000Oo();
            new UwbStrangerRegister(O00000Oo, new OobRequestCallback() {
                /* class _m_j.hzu.AnonymousClass1 */

                public final void onRequestOob4DigitPin() {
                    UwbLogUtil.d("Mijia-UWB-IotSpecKeyRetriever", "onRequestOob4DigitPin");
                }

                public final void onRequestOobRanging1M() {
                    UwbLogUtil.d("Mijia-UWB-IotSpecKeyRetriever", "onRequestOobRanging1M");
                }

                public final void onRequestOobRanging2M() {
                    UwbLogUtil.d("Mijia-UWB-IotSpecKeyRetriever", "onRequestOobRanging2M");
                }
            }, new AuthResultCallback() {
                /* class _m_j.hzu.AnonymousClass2 */

                public final void onSuccess(Bundle bundle) {
                    String str;
                    byte[] byteArray = bundle.getByteArray("stranger_specific_key");
                    if (byteArray == null || byteArray.length <= 0) {
                        KeyRetrieverListener keyRetrieverListener = keyRetrieverListener;
                        if (byteArray == null) {
                            str = "key is null";
                        } else {
                            str = "key length not valid:" + byteArray.length;
                        }
                        keyRetrieverListener.onError(-10201, str);
                        return;
                    }
                    String hexString = ByteUtils.toHexString(byteArray);
                    UwbLogUtil.d("Mijia-UWB-IotSpecKeyRetriever", "handleIotStrangerKeyRetrieve onSuccess=".concat(String.valueOf(hexString)));
                    UwbDeviceUtil.saveUwbDeviceKey(O00000Oo + "-" + hexString, hzu.O00000o(uwbScanDevice));
                    keyRetrieverListener.onSuccess(hexString, 1, O00000Oo);
                }

                public final void onFailed(int i) {
                    keyRetrieverListener.onError(-10200, "handleIotStrangerKeyRetrieve auth fail:".concat(String.valueOf(i)));
                }
            }).startAuth();
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void O000000o(UwbScanDevice uwbScanDevice, KeyRetrieverListener keyRetrieverListener, String str, boolean z) {
        String O00000oo = hzq.O00000oo(uwbScanDevice);
        if (TextUtils.isEmpty(O00000oo)) {
            UwbLogUtil.e("Mijia-UWB-IotSpecKeyRetriever", "handleIotMemberOrOwnerKeyRetrieve tag device IS still NULL though UwbBindHelper updated!! pid=" + uwbScanDevice.getPid() + "," + uwbScanDevice.getDidInfo());
            keyRetrieverListener.onError(-10102, "tag device or builtin device not exist");
            return;
        }
        O000000o(uwbScanDevice, O00000oo, str, keyRetrieverListener, z);
    }

    private static void O000000o(final UwbScanDevice uwbScanDevice, String str, String str2, final KeyRetrieverListener keyRetrieverListener, boolean z) {
        UwbLogUtil.d("Mijia-UWB-IotSpecKeyRetriever", "handleIotMemberOrOwnerKeyRetrieveWithTagDid useCache=".concat(String.valueOf(z)));
        String O000000o2 = ddt.O0000O0o.O000000o(str, str2);
        if (!z || TextUtils.isEmpty(O000000o2)) {
            if (z) {
                UwbLogUtil.d("Mijia-UWB-IotSpecKeyRetriever", "handleIotMemberOrOwnerKeyRetrieveWithTagDidNotEmpty useCache is true but no cache data, start retrieving from remote");
            }
            ddt.O0000O0o.O000000o(str).subscribe(new Observer<String>() {
                /* class _m_j.hzu.AnonymousClass3 */

                public final void onComplete() {
                }

                public final void onSubscribe(@NonNull Disposable disposable) {
                }

                public final /* synthetic */ void onNext(@NonNull Object obj) {
                    String str = (String) obj;
                    UwbLogUtil.d("Mijia-UWB-IotSpecKeyRetriever", "handleIotMemberOrOwnerKeyRetrieveWithTagDidNotEmpty onNext ".concat(String.valueOf(str)));
                    if (TextUtils.isEmpty(str)) {
                        keyRetrieverListener.onError(-1, "remote key is empty");
                        return;
                    }
                    keyRetrieverListener.onSuccess(str, 0, CoreApi.O000000o().O0000o0());
                    UwbDeviceUtil.saveUwbDeviceKey(str, hzu.O00000o(uwbScanDevice));
                }

                public final void onError(@NonNull Throwable th) {
                    UwbLogUtil.d("Mijia-UWB-IotSpecKeyRetriever", "handleIotMemberOrOwnerKeyRetrieveWithTagDidNotEmpty onError " + th.getMessage());
                    KeyRetrieverListener keyRetrieverListener = keyRetrieverListener;
                    keyRetrieverListener.onError(-1, "exception hanppened:" + th.getMessage());
                }
            });
            return;
        }
        UwbLogUtil.d("Mijia-UWB-IotSpecKeyRetriever", "handleIotMemberOrOwnerKeyRetrieveWithTagDidNotEmpty cache success:" + O000000o2 + ",for tag=" + str + " and device=" + str2);
        if (TextUtils.isEmpty(O000000o2)) {
            keyRetrieverListener.onError(-1020, "use cache but no cache data, need issue a request a non-cache request tagid=" + str + ",binddid=" + str2);
            return;
        }
        keyRetrieverListener.onSuccess(O000000o2, 0, CoreApi.O000000o().O0000o0());
        UwbDeviceUtil.saveUwbDeviceKey(O000000o2, O00000o(uwbScanDevice));
    }

    public static void O00000o0(UwbScanDevice uwbScanDevice, KeyRetrieverListener keyRetrieverListener, boolean z) {
        UwbLogUtil.d("Mijia-UWB-IotSpecKeyRetriever", "handleIotMemberKeyRetrieveAfterHomeDeviceRetrieved useCache=".concat(String.valueOf(z)));
        if (TextUtils.isEmpty(hzq.O00000o(uwbScanDevice))) {
            ddt ddt = ddt.f14518O000000o;
            ddt.O000000o(new Runnable(keyRetrieverListener, z) {
                /* class _m_j.$$Lambda$hzu$bTXxk6ExCnXJiNVlYJcEio6Jpc */
                private final /* synthetic */ KeyRetrieverListener f$1;
                private final /* synthetic */ boolean f$2;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                }

                public final void run() {
                    hzu.O00000o(UwbScanDevice.this, this.f$1, this.f$2);
                }
            });
            return;
        }
        O00000o(uwbScanDevice, keyRetrieverListener, z);
    }

    /* access modifiers changed from: private */
    public static void O00000o(final UwbScanDevice uwbScanDevice, final KeyRetrieverListener keyRetrieverListener, boolean z) {
        UwbLogUtil.d("Mijia-UWB-IotSpecKeyRetriever", "handleIotMemberKeyRetrieveAfterHomeDeviceAndTagRetrieved useCache=".concat(String.valueOf(z)));
        String O00000o = hzq.O00000o(uwbScanDevice);
        String O00000oO = hzq.O00000oO(uwbScanDevice);
        if (UwbDeviceUtil.isTagDeviceType(uwbScanDevice.getDeviceType()) && TextUtils.isEmpty(O00000oO)) {
            keyRetrieverListener.onError(-10101, "tag binded device not exist");
        } else if (TextUtils.isEmpty(O00000o)) {
            UwbLogUtil.e("Mijia-UWB-IotSpecKeyRetriever", "handleIotMemberKeyRetrieveAfterHomeDeviceAndTagRetrieved tag or builtin device IS NULL!!");
            keyRetrieverListener.onError(-10102, "tag device or the builtin device does not exist");
        } else {
            String O000000o2 = ddt.O0000O0o.O000000o(O00000o, O00000oO);
            if (!z || TextUtils.isEmpty(O000000o2)) {
                if (z) {
                    UwbLogUtil.d("Mijia-UWB-IotSpecKeyRetriever", "handleIotMemberKeyRetrieveAfterHomeDeviceAndTagRetrieved useCache is true but no cache data, start retrieving from remote");
                }
                ddt.O0000O0o.O000000o(O00000o).subscribe(new Observer<String>() {
                    /* class _m_j.hzu.AnonymousClass5 */

                    public final void onComplete() {
                    }

                    public final void onSubscribe(@NonNull Disposable disposable) {
                    }

                    public final /* synthetic */ void onNext(@NonNull Object obj) {
                        String str = (String) obj;
                        UwbLogUtil.d("Mijia-UWB-IotSpecKeyRetriever", "handleIotMemberKeyRetrieveAfterHomeDeviceAndTagRetrieved onNext ".concat(String.valueOf(str)));
                        if (TextUtils.isEmpty(str)) {
                            keyRetrieverListener.onError(-1, "remote key is empty");
                            return;
                        }
                        keyRetrieverListener.onSuccess(str, 0, CoreApi.O000000o().O0000o0());
                        UwbDeviceUtil.saveUwbDeviceKey(str, hzu.O00000o(uwbScanDevice));
                    }

                    public final void onError(@NonNull Throwable th) {
                        UwbLogUtil.d("Mijia-UWB-IotSpecKeyRetriever", "handleIotMemberKeyRetrieveAfterHomeDeviceAndTagRetrieved onError " + th.getMessage());
                        KeyRetrieverListener keyRetrieverListener = keyRetrieverListener;
                        keyRetrieverListener.onError(-1, "exception hanppened:" + th.getMessage());
                    }
                });
                return;
            }
            UwbLogUtil.d("Mijia-UWB-IotSpecKeyRetriever", "handleIotMemberKeyRetrieveAfterHomeDeviceAndTagRetrieved cache success:" + O000000o2 + ",for tag=" + O00000o + " and device=" + O00000oO);
            if (TextUtils.isEmpty(O000000o2)) {
                keyRetrieverListener.onError(-1020, "use cache but no cache data, need issue a request a non-cache request, tagdid=" + O00000o + ",binddid=" + O00000oO);
                return;
            }
            keyRetrieverListener.onSuccess(O000000o2, 0, CoreApi.O000000o().O0000o0());
            UwbDeviceUtil.saveUwbDeviceKey(O000000o2, O00000o(uwbScanDevice));
        }
    }

    public static String O00000o(UwbScanDevice uwbScanDevice) {
        if (hzt.O000000o(uwbScanDevice)) {
            return "1-" + UwbDeviceUtil.getUwbDeviceID(uwbScanDevice) + "-" + CoreApi.O000000o().O0000o0();
        }
        return "0-" + UwbDeviceUtil.getUwbDeviceID(uwbScanDevice);
    }
}
