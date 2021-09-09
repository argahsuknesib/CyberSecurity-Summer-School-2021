package com.xiaomi.smarthome.uwb;

import _m_j.ddb;
import _m_j.goq;
import _m_j.gsc;
import _m_j.ixe;
import android.text.TextUtils;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.device.api.ProgressCallback;
import com.xiaomi.smarthome.uwb.lib.utils.UwbLogUtil;
import java.io.File;
import kotlin.Metadata;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0002H\u0016¨\u0006\u000f"}, d2 = {"com/xiaomi/smarthome/uwb/UwbCardActivity$downSpecUrns$1", "Lcom/xiaomi/smarthome/device/api/ProgressCallback;", "Ljava/io/File;", "onFailure", "", "error", "", "errorInfo", "", "onProgress", "bytesWritten", "", "totalSize", "onSuccess", "result", "uwb-card_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class UwbCardActivity$downSpecUrns$1 implements ProgressCallback<File> {
    final /* synthetic */ String $model;
    final /* synthetic */ UwbDevice $uwbDevice;
    final /* synthetic */ UwbCardActivity<C, E, T> this$0;

    public final void onProgress(long j, long j2) {
    }

    UwbCardActivity$downSpecUrns$1(UwbCardActivity<C, E, T> uwbCardActivity, String str, UwbDevice uwbDevice) {
        this.this$0 = uwbCardActivity;
        this.$model = str;
        this.$uwbDevice = uwbDevice;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
     arg types: [java.lang.String, java.lang.String]
     candidates:
      _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
      _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
      _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
      _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String */
    public final void onFailure(int i, String str) {
        ixe.O00000o(str, "errorInfo");
        UwbLogUtil.e("Mijia-UWB-UwbCardActivityTag", ixe.O000000o("downWithCache onFailure ", (Object) str));
        UwbCardActivity<C, E, T> uwbCardActivity = this.this$0;
        uwbCardActivity.runOnUiThread(new Runnable() {
            /* class com.xiaomi.smarthome.uwb.$$Lambda$UwbCardActivity$downSpecUrns$1$2Y0576Kxd8OZPZFDPzbAKR1GceA */

            public final void run() {
                UwbCardActivity$downSpecUrns$1.m498onFailure$lambda0(UwbCardActivity.this);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: onFailure$lambda-0  reason: not valid java name */
    public static final void m498onFailure$lambda0(UwbCardActivity uwbCardActivity) {
        ixe.O00000o(uwbCardActivity, "this$0");
        uwbCardActivity.showToast("uwb", null, uwbCardActivity.getString(R.string.code_infonull_error));
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
     arg types: [java.lang.String, java.io.File]
     candidates:
      _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
      _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
      _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
      _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String */
    public final void onSuccess(File file) {
        ixe.O00000o(file, "result");
        UwbLogUtil.e("Mijia-UWB-UwbCardActivityTag", ixe.O000000o("downWithCache onSuccess ", (Object) file));
        goq.O00000o(new Runnable(file, this.$model, this.$uwbDevice, this.this$0) {
            /* class com.xiaomi.smarthome.uwb.$$Lambda$UwbCardActivity$downSpecUrns$1$mzf0mMaIh2wvqFWUVdY3BnMdxDw */
            private final /* synthetic */ File f$0;
            private final /* synthetic */ String f$1;
            private final /* synthetic */ UwbDevice f$2;
            private final /* synthetic */ UwbCardActivity f$3;

            {
                this.f$0 = r1;
                this.f$1 = r2;
                this.f$2 = r3;
                this.f$3 = r4;
            }

            public final void run() {
                UwbCardActivity$downSpecUrns$1.m499onSuccess$lambda2(this.f$0, this.f$1, this.f$2, this.f$3);
            }
        });
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
     arg types: [java.lang.String, java.lang.Integer]
     candidates:
      _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
      _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
      _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
      _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
     arg types: [java.lang.String, java.lang.Throwable]
     candidates:
      _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
      _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
      _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
      _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String */
    /* access modifiers changed from: private */
    /* renamed from: onSuccess$lambda-2  reason: not valid java name */
    public static final void m499onSuccess$lambda2(File file, String str, UwbDevice uwbDevice, UwbCardActivity uwbCardActivity) {
        Integer num;
        ixe.O00000o(file, "$result");
        ixe.O00000o(uwbCardActivity, "this$0");
        try {
            JSONArray optJSONArray = new JSONObject(gsc.O0000O0o(file.getAbsolutePath())).optJSONArray("instances");
            int i = 0;
            int length = optJSONArray.length();
            if (length > 0) {
                while (true) {
                    int i2 = i + 1;
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    if (TextUtils.equals(optJSONObject.optString("model"), str)) {
                        if (uwbDevice != null) {
                            uwbDevice.model = str;
                        }
                        if (uwbDevice != null) {
                            uwbDevice.isOnline = true;
                        }
                        if (uwbDevice != null) {
                            uwbDevice.setSpecUrn(optJSONObject.optString("type"));
                        }
                        uwbCardActivity.matchCardCheckSpec(uwbDevice);
                        return;
                    } else if (i2 >= length) {
                        break;
                    } else {
                        i = i2;
                    }
                }
            }
            if (optJSONArray == null) {
                num = null;
            } else {
                num = Integer.valueOf(optJSONArray.length());
            }
            UwbLogUtil.e("Mijia-UWB-UwbCardActivityTag", ixe.O000000o("downWithCache ", (Object) num));
        } catch (Throwable th) {
            UwbLogUtil.e("Mijia-UWB-UwbCardActivityTag", ixe.O000000o("downWithCache ", (Object) th));
        }
        uwbCardActivity.runOnUiThread(new Runnable() {
            /* class com.xiaomi.smarthome.uwb.$$Lambda$UwbCardActivity$downSpecUrns$1$F1j4n14wGxkusRzER_fu_96vAm4 */

            public final void run() {
                UwbCardActivity$downSpecUrns$1.m500onSuccess$lambda2$lambda1(UwbCardActivity.this);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: onSuccess$lambda-2$lambda-1  reason: not valid java name */
    public static final void m500onSuccess$lambda2$lambda1(UwbCardActivity uwbCardActivity) {
        ixe.O00000o(uwbCardActivity, "this$0");
        ddb.O000000o((int) R.string.code_infonull_error);
    }
}
