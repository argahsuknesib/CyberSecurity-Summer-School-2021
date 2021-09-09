package com.xiaomi.smarthome.framework.page.verify;

import _m_j.fno;
import _m_j.foc;
import _m_j.fqx;
import _m_j.fsm;
import _m_j.fso;
import _m_j.fwb;
import _m_j.fwe;
import _m_j.fwf;
import _m_j.fwg;
import _m_j.fwh;
import _m_j.fwj;
import _m_j.fwk;
import _m_j.fwo;
import _m_j.gqg;
import _m_j.gsy;
import android.annotation.TargetApi;
import android.app.KeyguardManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.hardware.fingerprint.FingerprintManager;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.api.DeviceApi;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import com.xiaomi.smarthome.framework.page.verify.manager.VerifyGlobalManager;
import com.xiaomi.smarthome.library.log.LogType;
import javax.crypto.Cipher;
import org.json.JSONObject;

@TargetApi(23)
public class FingerPrintVerifyActivity extends BaseActivity implements fwe {

    /* renamed from: O000000o  reason: collision with root package name */
    String f7964O000000o;
    private String O00000Oo;
    private boolean O00000o;
    private String O00000o0;
    public Cipher mCipher;
    public Device mDevice;
    public String mDeviceId;
    public VerifyGlobalManager mVerifyGlobalManager;
    public fwk mVerifyManager;
    public fwo vVerifyDialog;
    public boolean verifyGlobalPin;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        O000000o(getIntent());
    }

    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        O000000o(intent);
    }

    private void O000000o(Intent intent) {
        getWindow().getDecorView().setBackgroundColor(intent.getBooleanExtra("style_dialog", false) ? getColor(R.color.mj_color_black_30_transparent) : Color.parseColor("#b1b5b9"));
        this.verifyGlobalPin = intent.getBooleanExtra("verify_for_global_pin", false);
        this.mDeviceId = intent.getStringExtra("extra_device_did");
        if (this.verifyGlobalPin) {
            this.f7964O000000o = CoreApi.O000000o().O0000o0();
            this.mVerifyGlobalManager = VerifyGlobalManager.O000000o(this);
            O000000o();
            return;
        }
        this.O00000Oo = intent.getStringExtra("xiaomi.smarthome.desc");
        this.mDevice = fno.O000000o().O000000o(this.mDeviceId);
        if (TextUtils.isEmpty(this.mDeviceId) || this.mDevice == null) {
            gqg.O00000Oo("设备id不能为空!");
            finish();
        }
        this.mVerifyManager = fwk.O000000o(this);
        O000000o();
    }

    private void O000000o() {
        if (this.verifyGlobalPin) {
            this.mVerifyGlobalManager.O00000Oo(this.f7964O000000o, this);
        } else {
            this.mVerifyManager.O00000Oo(this.mDeviceId, this);
        }
    }

    public void onResume() {
        super.onResume();
        this.O00000o = true;
        O000000o(this.O00000o0);
    }

    public void onPause() {
        fwo fwo = this.vVerifyDialog;
        if (fwo != null) {
            fwo.O000000o();
        }
        this.O00000o = false;
        super.onPause();
    }

    public void onGetCipherSuccess(Cipher cipher) {
        this.vVerifyDialog = new fwo(this, new FingerprintManager.CryptoObject(cipher), new fwf() {
            /* class com.xiaomi.smarthome.framework.page.verify.FingerPrintVerifyActivity.AnonymousClass1 */

            public final void O000000o(Cipher cipher) {
                final String O000000o2 = FingerPrintVerifyActivity.this.verifyGlobalPin ? FingerPrintVerifyActivity.this.mVerifyGlobalManager.O000000o(FingerPrintVerifyActivity.this.f7964O000000o, cipher) : FingerPrintVerifyActivity.this.mVerifyManager.O000000o(FingerPrintVerifyActivity.this.mDeviceId, cipher);
                if (FingerPrintVerifyActivity.this.verifyGlobalPin) {
                    VerifyGlobalManager verifyGlobalManager = FingerPrintVerifyActivity.this.mVerifyGlobalManager;
                    FingerPrintVerifyActivity fingerPrintVerifyActivity = FingerPrintVerifyActivity.this;
                    verifyGlobalManager.O000000o(fingerPrintVerifyActivity, O000000o2, fingerPrintVerifyActivity.mDeviceId, new fwg<Boolean>() {
                        /* class com.xiaomi.smarthome.framework.page.verify.FingerPrintVerifyActivity.AnonymousClass1.AnonymousClass1 */

                        public final /* synthetic */ void onSuccess(Object obj) {
                            if (((Boolean) obj).booleanValue()) {
                                Intent intent = new Intent();
                                intent.putExtra("pincode", O000000o2);
                                FingerPrintVerifyActivity.this.setResult(-1, intent);
                                FingerPrintVerifyActivity.this.finish();
                                return;
                            }
                            onFailure(new fso(-1, "incorrect password"));
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
                        public final void onFailure(fso fso) {
                            Intent intent = new Intent();
                            intent.putExtra("back_for_pincode_verify", true);
                            FingerPrintVerifyActivity.this.setResult(0, intent);
                            FingerPrintVerifyActivity.this.finish();
                        }
                    });
                } else if (fqx.O000000o(FingerPrintVerifyActivity.this.mDevice.model, FingerPrintVerifyActivity.this.mDevice.version)) {
                    FingerPrintVerifyActivity fingerPrintVerifyActivity2 = FingerPrintVerifyActivity.this;
                    DeviceApi.getEncryptLtmk(fingerPrintVerifyActivity2, fingerPrintVerifyActivity2.mDevice.did, new fsm<JSONObject, fso>() {
                        /* class com.xiaomi.smarthome.framework.page.verify.FingerPrintVerifyActivity.AnonymousClass1.AnonymousClass2 */

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
                        public final /* synthetic */ void onSuccess(Object obj) {
                            int i;
                            String str;
                            JSONObject jSONObject = (JSONObject) obj;
                            if (jSONObject != null) {
                                str = jSONObject.optString("key");
                                i = jSONObject.optInt("encrypt_type");
                            } else {
                                str = "";
                                i = 0;
                            }
                            if (TextUtils.isEmpty(str) || i == 0) {
                                gqg.O00000Oo(FingerPrintVerifyActivity.this.getString(R.string.device_more_verify_fail));
                                Intent intent = new Intent();
                                intent.putExtra("back_for_pincode_verify", true);
                                FingerPrintVerifyActivity.this.setResult(0, intent);
                                FingerPrintVerifyActivity.this.finish();
                                return;
                            }
                            String O0000Ooo = foc.O0000Ooo(FingerPrintVerifyActivity.this.mDevice.mac);
                            String O0000o00 = foc.O0000o00(FingerPrintVerifyActivity.this.mDevice.mac);
                            if (!TextUtils.equals(O0000Ooo, str) || TextUtils.isEmpty(O0000o00)) {
                                gqg.O00000Oo(FingerPrintVerifyActivity.this.getString(R.string.device_more_verify_fail));
                                Intent intent2 = new Intent();
                                intent2.putExtra("back_for_pincode_verify", true);
                                FingerPrintVerifyActivity.this.setResult(0, intent2);
                                FingerPrintVerifyActivity.this.finish();
                            } else if (TextUtils.equals(O000000o2, O0000o00)) {
                                Intent intent3 = new Intent();
                                intent3.putExtra("back_for_pincode_verify", false);
                                FingerPrintVerifyActivity.this.setResult(-1, intent3);
                                FingerPrintVerifyActivity.this.finish();
                            } else {
                                gqg.O00000Oo(FingerPrintVerifyActivity.this.getString(R.string.device_more_verify_fail));
                                Intent intent4 = new Intent();
                                intent4.putExtra("back_for_pincode_verify", true);
                                FingerPrintVerifyActivity.this.setResult(0, intent4);
                                FingerPrintVerifyActivity.this.finish();
                            }
                        }

                        public final void onFailure(fso fso) {
                            LogType logType = LogType.GENERAL;
                            gsy.O00000Oo(logType, "FingerPrintVerifyActivity", "onFailure error:" + fso + Log.getStackTraceString(new Exception()));
                            gqg.O00000Oo(FingerPrintVerifyActivity.this.getString(R.string.device_more_security_network_error));
                        }
                    });
                } else {
                    FingerPrintVerifyActivity.this.mVerifyManager.O000000o(FingerPrintVerifyActivity.this.mDevice.model, FingerPrintVerifyActivity.this.mDevice.version, FingerPrintVerifyActivity.this.mDeviceId, O000000o2, new fwh() {
                        /* class com.xiaomi.smarthome.framework.page.verify.FingerPrintVerifyActivity.AnonymousClass1.AnonymousClass3 */

                        public final void O000000o() {
                            FingerPrintVerifyActivity.this.setResult(-1);
                            FingerPrintVerifyActivity.this.finish();
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
                        public final void O00000Oo() {
                            gqg.O00000Oo(FingerPrintVerifyActivity.this.getString(R.string.device_more_verify_fail));
                            Intent intent = new Intent();
                            intent.putExtra("back_for_pincode_verify", true);
                            FingerPrintVerifyActivity.this.setResult(0, intent);
                            FingerPrintVerifyActivity.this.finish();
                        }

                        public final void O000000o(String str) {
                            LogType logType = LogType.GENERAL;
                            gsy.O00000Oo(logType, "FingerPrintVerifyActivity", "onPinOptError error:" + str + Log.getStackTraceString(new Exception()));
                            gqg.O00000Oo(FingerPrintVerifyActivity.this.getString(R.string.device_more_security_network_error));
                        }

                        public final void O00000o0() {
                            LogType logType = LogType.GENERAL;
                            gsy.O00000Oo(logType, "FingerPrintVerifyActivity", "onNetWorkUnavailable error:" + Log.getStackTraceString(new Exception()));
                            gqg.O00000Oo(FingerPrintVerifyActivity.this.getString(R.string.device_more_security_network_error));
                        }
                    });
                }
            }

            public final void O000000o() {
                FingerPrintVerifyActivity.this.setResult(0);
                FingerPrintVerifyActivity.this.finish();
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
            public final void O000000o(CharSequence charSequence) {
                gqg.O00000Oo(FingerPrintVerifyActivity.this.getString(R.string.device_more_verify_locked));
                Intent intent = new Intent();
                intent.putExtra("back_for_pincode_verify", true);
                FingerPrintVerifyActivity.this.setResult(0, intent);
                FingerPrintVerifyActivity.this.finish();
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
            public final void O00000Oo() {
                Intent intent = new Intent();
                intent.putExtra("back_for_pincode_verify", true);
                FingerPrintVerifyActivity.this.setResult(0, intent);
                FingerPrintVerifyActivity.this.finish();
            }
        }, true);
        this.vVerifyDialog.f17318O000000o = new DialogInterface.OnClickListener() {
            /* class com.xiaomi.smarthome.framework.page.verify.FingerPrintVerifyActivity.AnonymousClass2 */

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
            public final void onClick(DialogInterface dialogInterface, int i) {
                Intent intent = new Intent();
                intent.putExtra("back_for_pincode_verify", true);
                FingerPrintVerifyActivity.this.setResult(0, intent);
                FingerPrintVerifyActivity.this.finish();
            }
        };
        O000000o(getString(R.string.device_more_fingerprint_title));
    }

    public void onGetResetCipherSuccess(Cipher cipher) {
        this.vVerifyDialog = new fwo(this, new FingerprintManager.CryptoObject(cipher), new fwf() {
            /* class com.xiaomi.smarthome.framework.page.verify.FingerPrintVerifyActivity.AnonymousClass3 */

            public final void O000000o(Cipher cipher) {
                FingerPrintVerifyActivity fingerPrintVerifyActivity = FingerPrintVerifyActivity.this;
                fingerPrintVerifyActivity.mCipher = cipher;
                String str = fingerPrintVerifyActivity.mDeviceId;
                boolean z = FingerPrintVerifyActivity.this.verifyGlobalPin;
                Intent intent = new Intent(fingerPrintVerifyActivity, DevicePinVerifyFPReOpenActivity.class);
                fwb.O000000o(intent, str);
                fwb.O000000o(intent, z);
                fingerPrintVerifyActivity.startActivityForResult(intent, 7004);
                FingerPrintVerifyActivity.this.vVerifyDialog.O00000Oo();
            }

            public final void O000000o() {
                FingerPrintVerifyActivity.this.setResult(0);
                FingerPrintVerifyActivity.this.finish();
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
            public final void O000000o(CharSequence charSequence) {
                gqg.O00000Oo(FingerPrintVerifyActivity.this.getString(R.string.device_more_verify_locked));
                Intent intent = new Intent();
                intent.putExtra("back_for_pincode_verify", true);
                FingerPrintVerifyActivity.this.setResult(0, intent);
                FingerPrintVerifyActivity.this.finish();
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
            public final void O00000Oo() {
                Intent intent = new Intent();
                intent.putExtra("back_for_pincode_verify", true);
                FingerPrintVerifyActivity.this.setResult(0, intent);
                FingerPrintVerifyActivity.this.finish();
            }
        }, true);
        this.vVerifyDialog.f17318O000000o = new DialogInterface.OnClickListener() {
            /* class com.xiaomi.smarthome.framework.page.verify.FingerPrintVerifyActivity.AnonymousClass4 */

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
            public final void onClick(DialogInterface dialogInterface, int i) {
                Intent intent = new Intent();
                intent.putExtra("back_for_pincode_verify", true);
                FingerPrintVerifyActivity.this.setResult(0, intent);
                FingerPrintVerifyActivity.this.finish();
            }
        };
        O000000o(getString(R.string.device_more_verify_key_permanently_invalidated_title));
    }

    private void O000000o(String str) {
        this.O00000o0 = str;
        fwo fwo = this.vVerifyDialog;
        if (fwo != null && this.O00000o) {
            fwo.O000000o(this.O00000o0);
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
    public void onGetCipherError(int i, String str) {
        if (i == fwj.O00000o) {
            Intent createConfirmDeviceCredentialIntent = ((KeyguardManager) getSystemService("keyguard")).createConfirmDeviceCredentialIntent("Hey there!", "Please...");
            if (createConfirmDeviceCredentialIntent != null) {
                startActivityForResult(createConfirmDeviceCredentialIntent, 7005);
                return;
            }
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("back_for_pincode_verify", true);
        setResult(0, intent);
        finish();
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 7004) {
            if (i2 == -1 && this.mCipher != null) {
                String stringExtra = intent.getStringExtra("xiaomi.smarthome.pincode");
                if (this.verifyGlobalPin) {
                    this.mVerifyGlobalManager.O000000o(this.f7964O000000o, stringExtra, this.mCipher);
                } else {
                    this.mVerifyManager.O000000o(this.mDeviceId, stringExtra, this.mCipher);
                }
                setResult(-1);
                finish();
            }
        } else if (i == 7005) {
            O000000o();
        }
    }
}
