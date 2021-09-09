package com.xiaomi.smarthome.camera.activity.utils;

import _m_j.chp;
import _m_j.cid;
import _m_j.cin;
import _m_j.cki;
import _m_j.goq;
import _m_j.gsy;
import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.TextView;
import com.mijia.model.sdcard.SDCardInfo;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.camera.activity.CameraBaseActivity;
import com.xiaomi.smarthome.camera.activity.GeneralCameraPlayerBaseActivity;
import com.xiaomi.smarthome.camera.activity.utils.CameraActivityUtils;
import com.xiaomi.smarthome.camera.view.widget.GuideView;
import com.xiaomi.smarthome.device.api.Callback;
import com.xiaomi.smarthome.device.api.Parser;
import com.xiaomi.smarthome.device.api.XmPluginHostApi;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

public class CameraActivityUtils {

    public static class SdcardDetectResult {
        public boolean sdcardGetSuccess = false;
        public int sdcardStatus = 0;
    }

    public static void isCloudVideoUser(final cid cid, final Activity activity) {
        if (cin.O00000oO() && !TextUtils.isEmpty(cid.getDid())) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("did", cid.getDid());
                jSONObject.put("region", Locale.getDefault().getCountry());
                XmPluginHostApi.instance().callSmartHomeApi(cid.getModel(), "business.smartcamera.", "/miot/camera/app/v1/vip/status", "GET", jSONObject.toString(), new Callback<JSONObject>() {
                    /* class com.xiaomi.smarthome.camera.activity.utils.CameraActivityUtils.AnonymousClass1 */

                    public final void onSuccess(JSONObject jSONObject) {
                        JSONObject optJSONObject;
                        if (!activity.isFinishing() && jSONObject != null && jSONObject.optInt("code", -1) == 0 && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
                            boolean optBoolean = optJSONObject.optBoolean("vip");
                            cid.O00000oO().O00000o(optJSONObject.optBoolean("closeWindow"));
                            cid.O00000oO().O00000o0(optBoolean);
                        }
                    }

                    public final void onFailure(int i, String str) {
                        if (activity.isFinishing()) {
                        }
                    }
                }, Parser.DEFAULT_PARSER);
            } catch (JSONException unused) {
            }
        }
    }

    public static GuideView initGuideCenter(Context context, cid cid, ViewGroup viewGroup) {
        GuideView guideView;
        try {
            TextView textView = new TextView(context);
            textView.setText((int) R.string.guide_center);
            textView.setTextSize(0, (float) ((int) (chp.O00000o0 * 15.0f)));
            textView.setTextColor(context.getResources().getColor(R.color.mj_color_white));
            textView.setCompoundDrawablesWithIntrinsicBounds((int) R.drawable.guide_center_bg, 0, 0, 0);
            textView.setGravity(16);
            textView.setCompoundDrawablePadding((int) (chp.O00000o0 * 5.0f));
            guideView = GuideView.Builder.newInstance(context).setContainerView(viewGroup).setCustomGuideView(textView).build();
            try {
                guideView.show();
            } catch (Exception unused) {
            }
        } catch (Exception unused2) {
            guideView = null;
            cid.O00000oO().O00000o();
            return guideView;
        }
        return guideView;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.cls.O000000o(com.xiaomi.smarthome.device.api.Callback<com.mijia.model.sdcard.SDCardInfo>, boolean):void
     arg types: [com.xiaomi.smarthome.camera.activity.utils.CameraActivityUtils$2, int]
     candidates:
      _m_j.cls.O000000o(java.util.List<com.mijia.model.sdcard.TimeItem>, com.xiaomi.smarthome.device.api.Callback<org.json.JSONObject>):void
      _m_j.ckx.O000000o(int, java.lang.String):void
      _m_j.cls.O000000o(com.xiaomi.smarthome.device.api.Callback<com.mijia.model.sdcard.SDCardInfo>, boolean):void */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.clr.O000000o(com.xiaomi.smarthome.device.api.Callback<com.mijia.model.sdcard.SDCardInfo>, boolean):void
     arg types: [com.xiaomi.smarthome.camera.activity.utils.CameraActivityUtils$2, int]
     candidates:
      _m_j.ckx.O000000o(int, java.lang.String):void
      _m_j.clr.O000000o(com.xiaomi.smarthome.device.api.Callback<com.mijia.model.sdcard.SDCardInfo>, boolean):void */
    public static void detectSDCard(final CameraBaseActivity cameraBaseActivity, final cid cid, final SdcardDetectResult sdcardDetectResult, final Callback<SDCardInfo> callback) {
        if (cid != null) {
            sdcardDetectResult.sdcardStatus = 0;
            if (cid.O00000oO() != null) {
                sdcardDetectResult.sdcardStatus = cid.O00000oO().O0000Oo;
            }
            AnonymousClass2 r0 = new Callback<SDCardInfo>() {
                /* class com.xiaomi.smarthome.camera.activity.utils.CameraActivityUtils.AnonymousClass2 */

                public final void onSuccess(SDCardInfo sDCardInfo) {
                    if (!cameraBaseActivity.isFinishing()) {
                        gsy.O00000Oo("CameraActivityUtils", "detectSDCard onSuccess:" + sDCardInfo.O00000oO);
                        SdcardDetectResult sdcardDetectResult = sdcardDetectResult;
                        sdcardDetectResult.sdcardGetSuccess = true;
                        sdcardDetectResult.sdcardStatus = sDCardInfo.O00000oO;
                        cid cid = cid;
                        if (!(cid == null || cid.O00000oO() == null)) {
                            if (cid.O00000oO().O0000Oo0 && (sDCardInfo.O00000oO == 1 || sDCardInfo.O00000oO == 3 || sDCardInfo.O00000oO == 5)) {
                                CameraBaseActivity cameraBaseActivity = cameraBaseActivity;
                                if (cameraBaseActivity instanceof GeneralCameraPlayerBaseActivity) {
                                    ((GeneralCameraPlayerBaseActivity) cameraBaseActivity).showSDCardHintDialog();
                                }
                            }
                            cid.O00000oO().O0000Oo = sdcardDetectResult.sdcardStatus;
                        }
                        Callback callback = callback;
                        if (callback != null) {
                            callback.onSuccess(sDCardInfo);
                        }
                    }
                }

                public final void onFailure(int i, String str) {
                    CameraBaseActivity cameraBaseActivity;
                    if (!cameraBaseActivity.isFinishing()) {
                        gsy.O000000o(6, "CameraActivityUtils", "detectSDCard onFailure:" + i + " s:" + str);
                        if (-97 == i) {
                            cid cid = cid;
                            if (cid != null && (cameraBaseActivity = cameraBaseActivity) != null) {
                                goq.O000000o(new Runnable(cid, sdcardDetectResult, callback) {
                                    /* class com.xiaomi.smarthome.camera.activity.utils.$$Lambda$CameraActivityUtils$2$6mnTJ2k40IFEAFFtLujm2dI6Cj0 */
                                    private final /* synthetic */ cid f$1;
                                    private final /* synthetic */ CameraActivityUtils.SdcardDetectResult f$2;
                                    private final /* synthetic */ Callback f$3;

                                    {
                                        this.f$1 = r2;
                                        this.f$2 = r3;
                                        this.f$3 = r4;
                                    }

                                    public final void run() {
                                        CameraActivityUtils.detectSDCard(CameraBaseActivity.this, this.f$1, this.f$2, this.f$3);
                                    }
                                }, 1000);
                                return;
                            }
                            return;
                        }
                        if (i == -2003 || i == -2002 || i == -2005 || i == -2000) {
                            sdcardDetectResult.sdcardGetSuccess = true;
                        } else {
                            sdcardDetectResult.sdcardGetSuccess = false;
                        }
                        if (i == -2003) {
                            sdcardDetectResult.sdcardStatus = 1;
                        } else if (i == -2000) {
                            sdcardDetectResult.sdcardStatus = 4;
                        } else if (i == -2005) {
                            sdcardDetectResult.sdcardStatus = 5;
                        } else if (i == -2002) {
                            sdcardDetectResult.sdcardStatus = 3;
                        }
                        cid cid2 = cid;
                        if (!(cid2 == null || cid2.O00000oO() == null)) {
                            cid.O00000oO().O0000Oo = sdcardDetectResult.sdcardStatus;
                        }
                        Callback callback = callback;
                        if (callback != null) {
                            callback.onFailure(i, str);
                        }
                    }
                }
            };
            if (cid.O00000o()) {
                cid.O0000Oo0().O000000o((Callback<SDCardInfo>) r0, true);
            } else {
                cid.O0000OOo().O000000o((Callback<SDCardInfo>) r0, true);
            }
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.cls.O000000o(com.xiaomi.smarthome.device.api.Callback<com.mijia.model.sdcard.SDCardInfo>, boolean):void
     arg types: [com.xiaomi.smarthome.camera.activity.utils.CameraActivityUtils$3, int]
     candidates:
      _m_j.cls.O000000o(java.util.List<com.mijia.model.sdcard.TimeItem>, com.xiaomi.smarthome.device.api.Callback<org.json.JSONObject>):void
      _m_j.ckx.O000000o(int, java.lang.String):void
      _m_j.cls.O000000o(com.xiaomi.smarthome.device.api.Callback<com.mijia.model.sdcard.SDCardInfo>, boolean):void */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.clr.O000000o(com.xiaomi.smarthome.device.api.Callback<com.mijia.model.sdcard.SDCardInfo>, boolean):void
     arg types: [com.xiaomi.smarthome.camera.activity.utils.CameraActivityUtils$3, int]
     candidates:
      _m_j.ckx.O000000o(int, java.lang.String):void
      _m_j.clr.O000000o(com.xiaomi.smarthome.device.api.Callback<com.mijia.model.sdcard.SDCardInfo>, boolean):void */
    public static void detectSDCard(final GeneralCameraPlayerBaseActivity generalCameraPlayerBaseActivity, final cid cid, final SdcardDetectResult sdcardDetectResult) {
        if (cid != null) {
            sdcardDetectResult.sdcardStatus = 0;
            if (cid.O00000oO() != null) {
                sdcardDetectResult.sdcardStatus = cid.O00000oO().O0000Oo;
            }
            cki.O00000o0("CameraActivityUtils", "start detectSDCard profile:" + cid.getDid());
            AnonymousClass3 r0 = new Callback<SDCardInfo>() {
                /* class com.xiaomi.smarthome.camera.activity.utils.CameraActivityUtils.AnonymousClass3 */

                public final void onSuccess(SDCardInfo sDCardInfo) {
                    if (!generalCameraPlayerBaseActivity.isFinishing()) {
                        cki.O00000o0("CameraActivityUtils", "detectSDCard onSuccess:" + sDCardInfo.O00000oO);
                        SdcardDetectResult sdcardDetectResult = sdcardDetectResult;
                        sdcardDetectResult.sdcardGetSuccess = true;
                        sdcardDetectResult.sdcardStatus = sDCardInfo.O00000oO;
                        cid cid = cid;
                        if (cid != null && cid.O00000oO() != null) {
                            if (cid.O00000oO().O0000Oo0 && (sDCardInfo.O00000oO == 1 || sDCardInfo.O00000oO == 3 || sDCardInfo.O00000oO == 5)) {
                                generalCameraPlayerBaseActivity.showSDCardHintDialog();
                            }
                            cid.O00000oO().O0000Oo = sdcardDetectResult.sdcardStatus;
                        }
                    }
                }

                public final void onFailure(int i, String str) {
                    GeneralCameraPlayerBaseActivity generalCameraPlayerBaseActivity;
                    if (!generalCameraPlayerBaseActivity.isFinishing()) {
                        cki.O00000o0("CameraActivityUtils", "detectSDCard onFailure:" + i + " s:" + str);
                        if (-97 == i) {
                            cid cid = cid;
                            if (cid != null && (generalCameraPlayerBaseActivity = generalCameraPlayerBaseActivity) != null) {
                                goq.O000000o(new Runnable(cid, sdcardDetectResult) {
                                    /* class com.xiaomi.smarthome.camera.activity.utils.$$Lambda$CameraActivityUtils$3$ymaHnfU3aB9bvBiPYEUOQfmtY */
                                    private final /* synthetic */ cid f$1;
                                    private final /* synthetic */ CameraActivityUtils.SdcardDetectResult f$2;

                                    {
                                        this.f$1 = r2;
                                        this.f$2 = r3;
                                    }

                                    public final void run() {
                                        CameraActivityUtils.detectSDCard(GeneralCameraPlayerBaseActivity.this, this.f$1, this.f$2);
                                    }
                                }, 1000);
                                return;
                            }
                            return;
                        }
                        if (i == -2003 || i == -2002 || i == -2005 || i == -2000) {
                            sdcardDetectResult.sdcardGetSuccess = true;
                        } else {
                            sdcardDetectResult.sdcardGetSuccess = false;
                        }
                        if (i == -2003) {
                            sdcardDetectResult.sdcardStatus = 1;
                        } else if (i == -2000) {
                            sdcardDetectResult.sdcardStatus = 4;
                        } else if (i == -2005) {
                            sdcardDetectResult.sdcardStatus = 5;
                        } else if (i == -2002) {
                            sdcardDetectResult.sdcardStatus = 3;
                        }
                        cid cid2 = cid;
                        if (cid2 != null && cid2.O00000oO() != null) {
                            cid.O00000oO().O0000Oo = sdcardDetectResult.sdcardStatus;
                        }
                    }
                }
            };
            if (cid.O00000o()) {
                cid.O0000Oo0().O000000o((Callback<SDCardInfo>) r0, true);
            } else {
                cid.O0000OOo().O000000o((Callback<SDCardInfo>) r0, true);
            }
        }
    }

    public static boolean isFirmWareSupportTimelineVersion(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            String substring = (str.lastIndexOf("_") == -1 || str.lastIndexOf("_") >= str.length() - 1) ? str : str.substring(str.lastIndexOf("_") + 1);
            if (str2.lastIndexOf(".") != -1 && str2.lastIndexOf("_") < str2.length() - 1) {
                str2 = str2.substring(str.lastIndexOf("_") + 1);
            }
            try {
                if (Integer.parseInt(substring) - Integer.parseInt(str2) > 0) {
                    return true;
                }
            } catch (Exception unused) {
            }
        }
        return false;
    }
}
