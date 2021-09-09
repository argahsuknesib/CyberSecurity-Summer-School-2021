package _m_j;

import _m_j.ddt;
import _m_j.exo;
import _m_j.ggb;
import android.os.Bundle;
import android.text.TextUtils;
import com.xiaomi.smarthome.application.ServiceApplication;
import com.xiaomi.smarthome.controls.AllReadyCallback;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.uwb.lib.auth.AuthResultCallback;
import com.xiaomi.smarthome.uwb.lib.auth.ByteUtils;
import com.xiaomi.smarthome.uwb.lib.auth.OobRequestCallback;
import com.xiaomi.smarthome.uwb.lib.auth.UwbStrangerRegister;
import com.xiaomi.smarthome.uwb.lib.data.UwbScanDevice;
import com.xiaomi.smarthome.uwb.lib.processor.engine.KeyRetrieverListener;
import com.xiaomi.smarthome.uwb.lib.utils.UwbDeviceUtil;
import com.xiaomi.smarthome.uwb.lib.utils.UwbLogUtil;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public final class hzz extends hzt {

    /* renamed from: O000000o  reason: collision with root package name */
    public UwbScanDevice f1054O000000o;
    public KeyRetrieverListener O00000Oo;
    public boolean O00000o0;

    public final void destroy() {
    }

    /* access modifiers changed from: protected */
    public final void O00000Oo(UwbScanDevice uwbScanDevice, final KeyRetrieverListener keyRetrieverListener, boolean z) {
        this.f1054O000000o = uwbScanDevice;
        this.O00000Oo = keyRetrieverListener;
        this.O00000o0 = z;
        if (ServiceApplication.getStateNotifier().f15923O000000o == 4 || ServiceApplication.getStateNotifier().f15923O000000o == 2 || ServiceApplication.getStateNotifier().f15923O000000o == 1) {
            ServiceApplication.getStateNotifier().O000000o(new exo.O000000o() {
                /* class _m_j.hzz.AnonymousClass1 */

                public final void onLoginSuccess() {
                    UwbLogUtil.d("Mijia-UWB-ThirdHidSpecificKeyRetr", "smarthome account login success");
                    new AllReadyCallback(6, new Runnable() {
                        /* class _m_j.hzz.AnonymousClass1.AnonymousClass1 */

                        public final void run() {
                            hzz hzz = hzz.this;
                            if (!hzz.O000000o(hzz.f1054O000000o)) {
                                KeyRetrieverListener keyRetrieverListener = hzz.O00000Oo;
                                String O00000o0 = hzq.O00000o0(hzz.f1054O000000o.getDidInfo().getDid());
                                if (TextUtils.isEmpty(O00000o0)) {
                                    ggb.O00000Oo().O000000o(new ggb.O0000OOo(keyRetrieverListener) {
                                        /* class _m_j.hzz.AnonymousClass4 */

                                        /* renamed from: O000000o  reason: collision with root package name */
                                        final /* synthetic */ KeyRetrieverListener f1059O000000o;

                                        {
                                            this.f1059O000000o = r2;
                                        }

                                        public final void O000000o() {
                                            String O00000o0 = hzq.O00000o0(hzz.this.f1054O000000o.getDidInfo().getDid());
                                            if (TextUtils.isEmpty(O00000o0)) {
                                                UwbLogUtil.e("Mijia-UWB-ThirdHidSpecificKeyRetr", "handleThirdTvMemberOrOwnerKeyRetrieve tag device IS still NULL!!");
                                                this.f1059O000000o.onError(-10101, "third tv: tag device not exist");
                                                return;
                                            }
                                            String O000000o2 = ddt.O0000O0o.O000000o(O00000o0, "");
                                            if (!hzz.this.O00000o0 || TextUtils.isEmpty(O000000o2)) {
                                                if (hzz.this.O00000o0 && TextUtils.isEmpty(O000000o2)) {
                                                    UwbLogUtil.w("Mijia-UWB-ThirdHidSpecificKeyRetr", "startKeyRetrieveInvoked use cache ,with empty key,try from remote. ");
                                                }
                                                hzz.this.O000000o();
                                            } else if (hzz.this.O00000Oo != null) {
                                                hzz.this.O00000Oo.onSuccess(O000000o2, 0, CoreApi.O000000o().O0000o0());
                                            }
                                        }
                                    });
                                    return;
                                }
                                String O000000o2 = ddt.O0000O0o.O000000o(O00000o0, "");
                                if (!hzz.O00000o0 || TextUtils.isEmpty(O000000o2)) {
                                    if (hzz.O00000o0 && TextUtils.isEmpty(O000000o2)) {
                                        UwbLogUtil.w("Mijia-UWB-ThirdHidSpecificKeyRetr", "startKeyRetrieveInvoked use cache ,with empty key,try from remote. ");
                                    }
                                    hzz.O000000o();
                                } else if (hzz.O00000Oo != null) {
                                    hzz.O00000Oo.onSuccess(O000000o2, 0, CoreApi.O000000o().O0000o0());
                                }
                            } else {
                                UwbScanDevice uwbScanDevice = hzz.f1054O000000o;
                                KeyRetrieverListener keyRetrieverListener2 = hzz.O00000Oo;
                                boolean z = hzz.O00000o0;
                                UwbLogUtil.d("Mijia-UWB-ThirdHidSpecificKeyRetr", "handleThirdTvStrangerKeyRetrieve useCache=".concat(String.valueOf(z)));
                                if (z) {
                                    String uwbDeviceKey = UwbDeviceUtil.getUwbDeviceKey(hzz.O00000Oo(uwbScanDevice));
                                    if (TextUtils.isEmpty(uwbDeviceKey)) {
                                        keyRetrieverListener2.onError(-1020, "no cache spec key for stranger");
                                        return;
                                    }
                                    int indexOf = uwbDeviceKey.indexOf("-");
                                    String substring = uwbDeviceKey.substring(0, indexOf);
                                    if (!TextUtils.equals(substring, CoreApi.O000000o().O0000o0())) {
                                        keyRetrieverListener2.onError(-10107, "no cache for current user: stored stranger key uid is different for current login uid");
                                        return;
                                    }
                                    String substring2 = uwbDeviceKey.substring(indexOf + 1);
                                    UwbLogUtil.d("Mijia-UWB-ThirdHidSpecificKeyRetr", "handleThirdTvStrangerKeyRetrieve useCache key success:uid=" + substring + ",key=" + substring2);
                                    keyRetrieverListener2.onSuccess(substring2, 1, substring);
                                    return;
                                }
                                String O00000Oo = hzq.O00000Oo();
                                new UwbStrangerRegister(O00000Oo, new OobRequestCallback() {
                                    /* class _m_j.hzz.AnonymousClass2 */

                                    public final void onRequestOob4DigitPin() {
                                        UwbLogUtil.d("Mijia-UWB-ThirdHidSpecificKeyRetr", "onRequestOob4DigitPin");
                                    }

                                    public final void onRequestOobRanging1M() {
                                        UwbLogUtil.d("Mijia-UWB-ThirdHidSpecificKeyRetr", "onRequestOobRanging1M");
                                    }

                                    public final void onRequestOobRanging2M() {
                                        UwbLogUtil.d("Mijia-UWB-ThirdHidSpecificKeyRetr", "onRequestOobRanging2M");
                                    }
                                }, new AuthResultCallback(keyRetrieverListener2, O00000Oo, uwbScanDevice) {
                                    /* class _m_j.hzz.AnonymousClass3 */

                                    /* renamed from: O000000o  reason: collision with root package name */
                                    final /* synthetic */ KeyRetrieverListener f1058O000000o;
                                    final /* synthetic */ String O00000Oo;
                                    final /* synthetic */ UwbScanDevice O00000o0;

                                    {
                                        this.f1058O000000o = r2;
                                        this.O00000Oo = r3;
                                        this.O00000o0 = r4;
                                    }

                                    public final void onSuccess(Bundle bundle) {
                                        String str;
                                        byte[] byteArray = bundle.getByteArray("stranger_specific_key");
                                        if (byteArray == null || byteArray.length <= 0) {
                                            KeyRetrieverListener keyRetrieverListener = this.f1058O000000o;
                                            if (byteArray == null) {
                                                str = "key is null";
                                            } else {
                                                str = "key length not valid:" + byteArray.length;
                                            }
                                            keyRetrieverListener.onError(-10201, str);
                                            return;
                                        }
                                        String hexString = ByteUtils.toHexString(byteArray);
                                        UwbLogUtil.d("Mijia-UWB-ThirdHidSpecificKeyRetr", "handleThirdTvStrangerKeyRetrieve onSuccess=".concat(String.valueOf(hexString)));
                                        UwbDeviceUtil.saveUwbDeviceKey(this.O00000Oo + "-" + hexString, hzt.O00000Oo(this.O00000o0));
                                        this.f1058O000000o.onSuccess(hexString, 1, this.O00000Oo);
                                    }

                                    public final void onFailed(int i) {
                                        this.f1058O000000o.onError(-10200, "handleThirdTvStrangerKeyRetrieve auth fail:".concat(String.valueOf(i)));
                                    }
                                }).startAuth();
                            }
                        }
                    });
                }

                public final void onLoginFailed() {
                    UwbLogUtil.d("Mijia-UWB-ThirdHidSpecificKeyRetr", "smarthome account login fail");
                    KeyRetrieverListener keyRetrieverListener = keyRetrieverListener;
                    if (keyRetrieverListener != null) {
                        keyRetrieverListener.onError(-10100, "MitvSpecificKeyRetrieverImpl not login");
                    }
                }
            });
            return;
        }
        UwbLogUtil.d("Mijia-UWB-ThirdHidSpecificKeyRetr", "mihome need login and currentState=" + ServiceApplication.getStateNotifier().f15923O000000o + ",so just ignore for retrieve key");
    }

    public final void clearCacheKey(UwbScanDevice uwbScanDevice) {
        ddt.O0000O0o.O000000o();
    }

    public final void O000000o() {
        String O00000oo = hzq.O00000oo(this.f1054O000000o);
        if (TextUtils.isEmpty(O00000oo)) {
            UwbLogUtil.w("Mijia-UWB-ThirdHidSpecificKeyRetr", "startRetrieveFromRemote with empty id: " + this.f1054O000000o);
            KeyRetrieverListener keyRetrieverListener = this.O00000Oo;
            if (keyRetrieverListener != null) {
                keyRetrieverListener.onError(-10101, "mitv: home member: no such device " + this.f1054O000000o);
                return;
            }
            return;
        }
        ddt.O0000O0o.O000000o(O00000oo).subscribe(new Observer<String>() {
            /* class _m_j.hzz.AnonymousClass5 */

            public final void onComplete() {
            }

            public final void onSubscribe(Disposable disposable) {
            }

            public final /* synthetic */ void onNext(Object obj) {
                String str = (String) obj;
                UwbLogUtil.d("Mijia-UWB-ThirdHidSpecificKeyRetr", "startRetrieveFromRemote onNext ".concat(String.valueOf(str)));
                if (TextUtils.isEmpty(str)) {
                    if (hzz.this.O00000Oo != null) {
                        hzz.this.O00000Oo.onError(-10103, "remote key is empty");
                    }
                } else if (hzz.this.O00000Oo != null) {
                    hzz.this.O00000Oo.onSuccess(str, 0, CoreApi.O000000o().O0000o0());
                }
            }

            public final void onError(Throwable th) {
                UwbLogUtil.e("Mijia-UWB-ThirdHidSpecificKeyRetr", "startRetrieveFromRemote onError ");
                if (hzz.this.O00000Oo != null) {
                    KeyRetrieverListener keyRetrieverListener = hzz.this.O00000Oo;
                    keyRetrieverListener.onError(-1, "exception happened: " + th.getMessage());
                }
            }
        });
    }
}
