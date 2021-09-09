package com.xiaomi.smarthome.camera.activity.utils;

import _m_j.chr;
import _m_j.cid;
import _m_j.fbs;
import _m_j.fbt;
import _m_j.ftn;
import _m_j.gqg;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.camera.LocalLicenseUtil;
import com.xiaomi.smarthome.camera.activity.alarm.AlarmAISwitchActivity;
import com.xiaomi.smarthome.camera.activity.alarm.AlarmSettingV2Activity;
import com.xiaomi.smarthome.camera.activity.local.AlbumActivity;
import com.xiaomi.smarthome.camera.activity.setting.FileManagerSettingActivity;
import com.xiaomi.smarthome.camera.activity.setting.MoreCameraSettingActivity;
import com.xiaomi.smarthome.camera.activity.setting.VoiceBroadCastActivity;
import com.xiaomi.smarthome.device.api.IXmPluginHostActivity;
import com.xiaomi.smarthome.device.api.XmPluginHostApi;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.framework.page.PictureShareActivity;
import java.io.Serializable;
import java.util.ArrayList;

public class CameraJumpUtils {
    public static void openPluginLicenseActivity(Context context, String str, int i) {
        fbt fbt = new fbt(context, "PluginLicenseActivity");
        fbt.O000000o("title", str);
        fbt.O000000o("license_html_content_res", i);
        fbs.O000000o(fbt);
    }

    public static void openShareActivity(Context context, String str, String str2, String str3) {
        fbt fbt = new fbt(context, PictureShareActivity.TAG);
        fbt.O000000o("ShareTitle", str);
        fbt.O000000o("ShareContent", str2);
        fbt.O000000o("SharePicFile", str3);
        fbs.O000000o(fbt);
    }

    public static void openShareActivity(Context context, String str, String str2, String str3, int i) {
        fbt fbt = new fbt(context, PictureShareActivity.TAG);
        fbt.O000000o("ShareTitle", str);
        fbt.O000000o("ShareContent", str2);
        fbt.O000000o("SharePicFile", str3);
        fbt.O000000o(i);
        fbs.O000000o(fbt);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.fbt.O000000o(java.lang.String, java.io.Serializable):_m_j.fbt
     arg types: [java.lang.String, java.util.ArrayList<com.xiaomi.smarthome.device.api.IXmPluginHostActivity$MenuItemBase>]
     candidates:
      _m_j.fbt.O000000o(java.lang.String, java.lang.Object):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.Class, java.lang.String):T
      _m_j.fbt.O000000o(java.lang.String, int):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, android.os.Bundle):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, android.os.Parcelable):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, java.lang.CharSequence):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, java.lang.String):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, java.util.ArrayList<? extends android.os.Parcelable>):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, boolean):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, java.lang.String[]):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, java.io.Serializable):_m_j.fbt */
    public static void openMoreMenu(Activity activity, String str, ArrayList<IXmPluginHostActivity.MenuItemBase> arrayList, boolean z, int i, Intent intent) {
        fbt fbt = new fbt(activity, "DeviceMoreActivity");
        fbt.O000000o("did", str);
        fbt.O000000o("menusItems", (Serializable) arrayList);
        fbt.O000000o("useDefaultMenus", z);
        fbt.O000000o(i);
        fbs.O000000o(fbt);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.fbt.O000000o(java.lang.String, java.io.Serializable):_m_j.fbt
     arg types: [java.lang.String, java.util.ArrayList<com.xiaomi.smarthome.device.api.IXmPluginHostActivity$MenuItemBase>]
     candidates:
      _m_j.fbt.O000000o(java.lang.String, java.lang.Object):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.Class, java.lang.String):T
      _m_j.fbt.O000000o(java.lang.String, int):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, android.os.Bundle):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, android.os.Parcelable):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, java.lang.CharSequence):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, java.lang.String):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, java.util.ArrayList<? extends android.os.Parcelable>):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, boolean):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, java.lang.String[]):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, java.io.Serializable):_m_j.fbt */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.fbt.O000000o(java.lang.String, android.os.Parcelable):_m_j.fbt
     arg types: [java.lang.String, android.content.Intent]
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
    public static void openMoreMenu2(Activity activity, String str, ArrayList<IXmPluginHostActivity.MenuItemBase> arrayList, boolean z, int i, Intent intent, Intent intent2) {
        fbt fbt = new fbt(activity, "DeviceMoreNewActivity");
        fbt.O000000o("did", str);
        fbt.O000000o("menusItems", (Serializable) arrayList);
        fbt.O000000o("useDefaultMenus", z);
        fbt.O000000o(intent.getExtras());
        if (intent2 != null) {
            fbt.O000000o("commonSettingParams", (Parcelable) intent2);
        }
        fbt.O000000o(i);
        fbs.O000000o(fbt);
        chr.O000000o(chr.O000ooOo);
    }

    public static void globalPinCodeSettingActivity(Context context, int i) {
        fbt fbt = new fbt(context, "SecuritySettingActivityV2");
        fbt.O000000o(i);
        fbs.O000000o(fbt);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.fbt.O000000o(java.lang.String, boolean):_m_j.fbt
     arg types: [java.lang.String, int]
     candidates:
      _m_j.fbt.O000000o(java.lang.String, java.lang.Object):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.Class, java.lang.String):T
      _m_j.fbt.O000000o(java.lang.String, int):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, android.os.Bundle):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, android.os.Parcelable):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, java.io.Serializable):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, java.lang.CharSequence):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, java.lang.String):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, java.util.ArrayList<? extends android.os.Parcelable>):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, java.lang.String[]):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, boolean):_m_j.fbt */
    public static void globalPinCodeVerifyActivity(Context context, String str, int i) {
        fbt fbt = new fbt(context, "DevicePinVerifyEnterActivity");
        fbt.O000000o("extra_device_did", str);
        fbt.O000000o("verfy_pincode_first", true);
        fbt.O000000o(i);
        fbs.O000000o(fbt);
    }

    public static void globalPinCodeOnOffActivity(Context context, String str, String str2, int i) {
        if (context != null) {
            fbt fbt = new fbt(context, "RNSecuritySettingActivity");
            fbt.O000000o("extra_device_did", str);
            fbt.O000000o("xiaomi.smarthome.custom_hint", str2);
            fbt.O000000o(i);
            fbs.O000000o(fbt);
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.fbt.O000000o(java.lang.String, boolean):_m_j.fbt
     arg types: [java.lang.String, int]
     candidates:
      _m_j.fbt.O000000o(java.lang.String, java.lang.Object):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.Class, java.lang.String):T
      _m_j.fbt.O000000o(java.lang.String, int):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, android.os.Bundle):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, android.os.Parcelable):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, java.io.Serializable):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, java.lang.CharSequence):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, java.lang.String):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, java.util.ArrayList<? extends android.os.Parcelable>):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, java.lang.String[]):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, boolean):_m_j.fbt */
    public static void openDevicePinVerifyDialog(Fragment fragment, Context context, String str, int i) {
        fbt fbt = new fbt(context, "DevicePinVerifyEnterActivity");
        fbt.O000000o("extra_device_did", str);
        fbt.O000000o("style_dialog", true);
        fbt.O000000o("verfy_pincode_first", true);
        fbt.O000000o(i);
        fbs.O000000o(fragment, fbt);
    }

    public static void openShareMediaActivity(Context context, String str, String str2, String str3) {
        fbt fbt = new fbt(context, "CommonShareActivity");
        if (!TextUtils.isEmpty(str)) {
            fbt.O000000o("ShareTitle", str);
        }
        if (!TextUtils.isEmpty(str2)) {
            fbt.O000000o("ShareContent", str2);
        }
        if (!TextUtils.isEmpty(str3)) {
            fbt.O000000o("SHARE_IMAGE_FILE_ZIP_URL", str3);
        }
        fbs.O000000o(fbt);
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
    public static boolean openMoreSetting(Activity activity, cid cid) {
        if (cid.isReadOnlyShared()) {
            gqg.O000000o((int) R.string.auth_fail_read_only);
            return true;
        }
        chr.O000000o(chr.O0000Oo);
        ArrayList arrayList = new ArrayList();
        IXmPluginHostActivity.IntentMenuItem intentMenuItem = new IXmPluginHostActivity.IntentMenuItem();
        intentMenuItem.name = activity.getString(R.string.more_camera_setting);
        intentMenuItem.intent = new Intent(activity, MoreCameraSettingActivity.class);
        intentMenuItem.intent.putExtra("extra_device_did", cid.getDid());
        arrayList.add(intentMenuItem);
        if (cid.isReadOnlyShared()) {
            IXmPluginHostActivity.StringMenuItem stringMenuItem = new IXmPluginHostActivity.StringMenuItem();
            stringMenuItem.name = activity.getString(R.string.more_alarm_setting);
            arrayList.add(stringMenuItem);
        } else {
            IXmPluginHostActivity.IntentMenuItem intentMenuItem2 = new IXmPluginHostActivity.IntentMenuItem();
            intentMenuItem2.name = activity.getString(R.string.more_alarm_setting);
            intentMenuItem2.intent = new Intent(activity, AlarmSettingV2Activity.class);
            intentMenuItem2.intent.putExtra("extra_device_did", cid.getDid());
            arrayList.add(intentMenuItem2);
        }
        IXmPluginHostActivity.IntentMenuItem intentMenuItem3 = new IXmPluginHostActivity.IntentMenuItem();
        intentMenuItem3.name = activity.getString(R.string.setting_voice_broadcast);
        intentMenuItem3.intent = new Intent(activity, VoiceBroadCastActivity.class);
        intentMenuItem3.intent.putExtra("extra_device_did", cid.getDid());
        arrayList.add(intentMenuItem3);
        IXmPluginHostActivity.IntentMenuItem intentMenuItem4 = new IXmPluginHostActivity.IntentMenuItem();
        intentMenuItem4.name = activity.getString(R.string.more_store_setting);
        intentMenuItem4.intent = new Intent(activity, FileManagerSettingActivity.class);
        intentMenuItem4.intent.putExtra("extra_device_did", cid.getDid());
        arrayList.add(intentMenuItem4);
        if (cid.O00000oO().O00000Oo() && !cid.isReadOnlyShared()) {
            IXmPluginHostActivity.IntentMenuItem intentMenuItem5 = new IXmPluginHostActivity.IntentMenuItem();
            intentMenuItem5.name = activity.getString(R.string.face_ai_setting);
            intentMenuItem5.intent = new Intent(activity, AlarmAISwitchActivity.class);
            intentMenuItem5.intent.putExtra("extra_device_did", cid.getDid());
            arrayList.add(intentMenuItem5);
        }
        IXmPluginHostActivity.IntentMenuItem intentMenuItem6 = new IXmPluginHostActivity.IntentMenuItem();
        intentMenuItem6.name = activity.getString(R.string.album);
        intentMenuItem6.intent = new Intent(activity, AlbumActivity.class);
        intentMenuItem6.intent.putExtra("extra_device_did", cid.getDid());
        arrayList.add(intentMenuItem6);
        Intent intent = new Intent();
        intent.putExtra("security_setting_enable", true);
        intent.putExtra("auto_dissmiss", false);
        if (!cid.isShared()) {
            intent.putExtra("cloud_storage", true);
            intent.putExtra("title", cid.getName());
        }
        if (XmPluginHostApi.instance().getApiLevel() > 52) {
            LocalLicenseUtil.LocalLicense v3UpgradeLicense = LocalLicenseUtil.getV3UpgradeLicense(activity.getResources());
            int i = v3UpgradeLicense.mLicense;
            int i2 = v3UpgradeLicense.mPrivacy;
            Intent intent2 = new Intent();
            if (i != 0 && i2 != 0) {
                intent2.putExtra("enableRemoveLicense", true);
                intent2.putExtra("licenseContentHtmlRes", i);
                intent2.putExtra("privacyContentHtmlRes", i2);
                intent2.putExtra("enable_privacy_setting", true ^ ftn.O00000Oo(CoreApi.O000000o().O0000ooO()));
                intent2.putExtra("usrExpPlanContentUri", v3UpgradeLicense.mPlan);
            } else if (!(v3UpgradeLicense.mLicenseSpanned == null || v3UpgradeLicense.mPrivacySpanned == null)) {
                intent2.putExtra("enableRemoveLicense", true);
                intent2.putExtra("licenseContent", v3UpgradeLicense.mLicenseSpanned);
                intent2.putExtra("privacyContent", v3UpgradeLicense.mPrivacySpanned);
                intent2.putExtra("enable_privacy_setting", true ^ ftn.O00000Oo(CoreApi.O000000o().O0000ooO()));
                intent2.putExtra("usrExpPlanContentUri", v3UpgradeLicense.mPlan);
            }
            openMoreMenu2(activity, cid.getDid(), arrayList, true, 1220, intent, intent2);
        }
        return false;
    }
}
