package _m_j;

import _m_j.gtx;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Parcelable;
import com.smarthome.uwb.ui.UwbTagCommonDialogActivity;
import com.smarthome.uwb.ui.UwbTranslucentTempActivity;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.application.ServiceApplication;
import com.xiaomi.smarthome.uwb.lib.UwbApi;
import com.xiaomi.smarthome.uwb.lib.UwbSdk;
import com.xiaomi.smarthome.uwb.lib.data.UwbScanDevice;
import com.xiaomi.smarthome.uwb.lib.processor.MijiaProcessor;
import com.xiaomi.smarthome.uwb.lib.processor.ProcessorCallback;
import com.xiaomi.smarthome.uwb.lib.processor.engine.UwbConEngine;
import com.xiaomi.smarthome.uwb.lib.utils.UwbDeviceUtil;
import com.xiaomi.smarthome.uwb.lib.utils.UwbLogUtil;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

public class hzm {
    private static volatile hzm O00000o;
    public static UwbScanDevice O00000o0;

    /* renamed from: O000000o  reason: collision with root package name */
    ProcessorCallback f1014O000000o;
    AtomicBoolean O00000Oo = new AtomicBoolean(false);

    private hzm() {
    }

    public static hzm O000000o() {
        if (O00000o == null) {
            synchronized (hzm.class) {
                if (O00000o == null) {
                    O00000o = new hzm();
                }
            }
        }
        return O00000o;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.fbt.O000000o(java.lang.String, android.os.Parcelable):_m_j.fbt
     arg types: [java.lang.String, com.xiaomi.smarthome.uwb.lib.data.UwbScanDevice]
     candidates:
      _m_j.fbt.O000000o(java.lang.String, java.lang.Object):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.Class, java.lang.String):T
      _m_j.fbt.O000000o(java.lang.String, int):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, android.os.Bundle):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, java.io.Serializable):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, java.lang.CharSequence):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, java.lang.String):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, java.util.ArrayList<? extends android.os.Parcelable>):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, boolean):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, java.lang.String[]):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, android.os.Parcelable):_m_j.fbt */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00b2 A[Catch:{ Exception -> 0x0181 }] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00f3 A[Catch:{ Exception -> 0x0181 }] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00f9 A[Catch:{ Exception -> 0x0181 }] */
    public final void O000000o(Context context, Intent intent, Uri uri) {
        boolean z;
        int i;
        if (intent == null || uri == null) {
            UwbLogUtil.w("Mijia-UWB-MijiaUwbEntry", "processUWBIntent intent and uri cannot be null");
            return;
        }
        try {
            String stringExtra = intent.getStringExtra("uwb_scan_result");
            UwbLogUtil.w("Mijia-UWB-timestamp", "processUWBIntent: ".concat(String.valueOf(stringExtra)));
            UwbScanDevice parse = UwbScanDevice.parse(new JSONObject(stringExtra));
            O00000o0 = parse;
            UwbLogUtil.d("Mijia-UWB-MijiaUwbEntry", "versoin: build_number=" + gfr.O00000o0);
            if (parse == null) {
                UwbLogUtil.w("Mijia-UWB-MijiaUwbEntry", "processUWBIntent: not set UwbScanResult return");
                return;
            }
            boolean z2 = false;
            if (!UwbDeviceUtil.isValidDeviceType(parse)) {
                UwbTagCommonDialogActivity.startShowNotSupportDevice();
            } else {
                if (!UwbDeviceUtil.isBuiltinDeviceType(parse.getDeviceType())) {
                    if (UwbDeviceUtil.isIotBindedTag(parse)) {
                        if (UwbDeviceUtil.isMitvDeviceTagType(parse)) {
                            i = 1;
                        } else if (UwbDeviceUtil.isUsbInserted(parse)) {
                            i = 2;
                        } else if (parse.getPid() == 5662) {
                            i = 5;
                        } else if (!UwbDeviceUtil.isLogin(parse)) {
                            i = 6;
                        }
                        UwbLogUtil.d("Mijia-UWB-OpenIotDevice", "handleDeviceValidation status=".concat(String.valueOf(i)));
                        if (i != 0) {
                            if (i == 2) {
                                UwbTagCommonDialogActivity.showResetTagThirdTv();
                            } else if (i == 5) {
                                fbt fbt = new fbt(UwbSdk.getApplication(), "BindUwbTagDeviceActivity");
                                fbt.O000000o("uwb_scan_device", (Parcelable) parse);
                                fbt.O00000Oo(268435456);
                                fbs.O000000o(fbt);
                            } else if (i == 3) {
                                UwbTagCommonDialogActivity.showResetTagMitvInsertThirdTvTag(parse);
                            } else if (i == 4) {
                                UwbTagCommonDialogActivity.show3rdTVTagIdle(parse);
                            } else if (i == 1) {
                                UwbTagCommonDialogActivity.showIotTagInsertInMiTV(parse);
                            } else if (i == 6) {
                                UwbTagCommonDialogActivity.showIotTagBindInvalid(parse);
                            }
                        }
                        z = false;
                        if (!z) {
                            UwbLogUtil.w("Mijia-UWB-MijiaUwbEntry", "processUWBIntent: OpenIotDeviceHelper.handleDeviceValidation return");
                            return;
                        }
                        if ((!UwbDeviceUtil.isMitvDeviceTagType(parse) && !UwbDeviceUtil.isBuiltinMitvDeviceType(parse)) || UwbDeviceUtil.isMitvLogin(parse)) {
                            int i2 = ServiceApplication.getStateNotifier().f15923O000000o;
                            UwbLogUtil.d("Mijia-UWB-MijiaUwbEntry", "checkIfNeedLogin state=".concat(String.valueOf(i2)));
                            if (!(i2 == 4 || i2 == 2)) {
                                gty.O000000o().startLogin(UwbSdk.getApplication(), 7, new gtx.O000000o() {
                                    /* class _m_j.hzm.AnonymousClass2 */

                                    public final void O000000o() {
                                        Intent intent = new Intent();
                                        intent.addFlags(268435456);
                                        intent.setData(Uri.parse("https://home.mi.com/main"));
                                        intent.setAction("android.intent.action.VIEW");
                                        intent.setPackage(CommonApplication.getAppContext().getPackageName());
                                        CommonApplication.getAppContext().startActivity(intent);
                                    }
                                });
                                z2 = true;
                            }
                        }
                        if (z2) {
                            UwbLogUtil.w("Mijia-UWB-MijiaUwbEntry", "processUWBIntent: checkIfNeedLogin login return");
                            return;
                        }
                        UwbTranslucentTempActivity.start();
                        if (UwbApi.getInstance().createNewEngine(parse, hzy.O000000o()) != -2) {
                            if (UwbSdk.getSdkConfig().getLogLevel() <= 3 && gfr.O0000OOo) {
                                UwbApi.getInstance().isEngineReady(new UwbConEngine.IEngineStateCallback() {
                                    /* class _m_j.hzm.AnonymousClass3 */

                                    public final void onRetryKeyRetrieve() {
                                    }

                                    public final void onSwitchCommunication(int i, String str) {
                                    }

                                    public final void onConnEstablished() {
                                        CommonApplication.getGlobalHandler().post($$Lambda$hzm$3$qCjdmpzliHbTRydysg3VPIddIsU.INSTANCE);
                                    }

                                    public final void onConnectionError(int i, String str) {
                                        CommonApplication.getGlobalHandler().post(new Runnable(i) {
                                            /* class _m_j.$$Lambda$hzm$3$T8HSvQCOu8TjaLTL1MYtWy_aOo */
                                            private final /* synthetic */ int f$0;

                                            {
                                                this.f$0 = r1;
                                            }

                                            public final void run() {
                                                hte.O000000o(UwbSdk.getApplication(), "onConnectionError ".concat(String.valueOf(this.f$0)));
                                            }
                                        });
                                    }

                                    public final void onEstablishSecurityError(int i, String str) {
                                        CommonApplication.getGlobalHandler().post(new Runnable(i) {
                                            /* class _m_j.$$Lambda$hzm$3$IfN1PyVPMNngN5l815tPbFX1iQs */
                                            private final /* synthetic */ int f$0;

                                            {
                                                this.f$0 = r1;
                                            }

                                            public final void run() {
                                                hte.O000000o(UwbSdk.getApplication(), "onEstablishSecurityError ".concat(String.valueOf(this.f$0)));
                                            }
                                        });
                                    }
                                });
                            }
                            MijiaProcessor.processUWBScanResult(context, parse);
                            fno.O000000o().O0000Oo0();
                            return;
                        } else if (gfr.O0000OOo) {
                            CommonApplication.getGlobalHandler().post($$Lambda$hzm$aVaswz2QZw9cnPlwppnm_1xx3PM.INSTANCE);
                            return;
                        } else {
                            return;
                        }
                    }
                    if (UwbDeviceUtil.isHid(parse)) {
                        if (UwbDeviceUtil.isMitvDeviceTagType(parse)) {
                            i = 3;
                        } else if (!UwbDeviceUtil.isUsbInserted(parse)) {
                            i = 4;
                        }
                        UwbLogUtil.d("Mijia-UWB-OpenIotDevice", "handleDeviceValidation status=".concat(String.valueOf(i)));
                        if (i != 0) {
                        }
                        z = false;
                        if (!z) {
                        }
                    }
                }
                i = 0;
                UwbLogUtil.d("Mijia-UWB-OpenIotDevice", "handleDeviceValidation status=".concat(String.valueOf(i)));
                if (i != 0) {
                }
                z = false;
                if (!z) {
                }
            }
            z = true;
            if (!z) {
            }
        } catch (Exception e) {
            e.printStackTrace();
            UwbLogUtil.e("Mijia-UWB-MijiaUwbEntry", "processUWBIntent exception " + e.getMessage());
        }
    }
}
