package com.mibi.sdk.common.os;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.os.PowerManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;

public class Build extends android.os.Build {
    public static final boolean IS_ALPHA_BUILD = "1".equals(SystemProperties.get("ro.miuipub.secure"));
    public static final boolean IS_CDMA = (IS_MIONE_CDMA || IS_MITWO_CDMA || IS_MITHREE_CDMA || IS_MIFOUR_CDMA);
    public static final boolean IS_CM_CUSTOMIZATION = "cm".equals(SystemProperties.get("ro.carrier.name"));
    public static final boolean IS_CTA_BUILD = "1".equals(SystemProperties.get("ro.miui.cta"));
    public static final boolean IS_CTS_BUILD = "1".equals(SystemProperties.get("ro.miuipub.cts"));
    public static final boolean IS_CT_CUSTOMIZATION = "ct".equals(SystemProperties.get("ro.carrier.name"));
    public static final boolean IS_CU_CUSTOMIZATION = "cu".equals(SystemProperties.get("ro.carrier.name"));
    public static final boolean IS_DEVELOPMENT_VERSION = (!TextUtils.isEmpty(Build.VERSION.INCREMENTAL) && Build.VERSION.INCREMENTAL.matches("\\d+.\\d+.\\d+(-internal)?"));
    public static final boolean IS_HK_BUILD = REGION.endsWith("hk");
    public static final boolean IS_HONGMI = (IS_HONGMI_TWO || IS_HONGMI_THREE);
    public static final boolean IS_HONGMI2_TDSCDMA = "HM2013022".equals(DEVICE);
    public static final boolean IS_HONGMI_THREE = ("lcsh92_wet_jb9".equals(DEVICE) || "lcsh92_wet_tdd".equals(DEVICE));
    public static final boolean IS_HONGMI_TWO = ("HM2013022".equals(DEVICE) || "HM2013023".equals(DEVICE) || IS_HONGMI_TWO_A || IS_HONGMI_TWO_S);
    public static final boolean IS_HONGMI_TWO_A = "armani".equals(DEVICE);
    public static final boolean IS_HONGMI_TWO_S = ("HM2014011".equals(DEVICE) || "HM2014012".equals(DEVICE));
    public static final boolean IS_ID_BUILD = REGION.endsWith("id");
    public static final boolean IS_INTERNATIONAL_BUILD = SystemProperties.get("ro.product.mod_device", "").endsWith("_global");
    public static final boolean IS_IN_BUILD = REGION.endsWith("in");
    public static final boolean IS_MI1S = ("MI 1S".equals(MODEL) || "MI 1SC".equals(MODEL));
    public static final boolean IS_MI2A = ("MI 2A".equals(MODEL) || "MI 2A TD".equals(MODEL));
    public static final boolean IS_MIFIVE = "virgo".equals(DEVICE);
    public static final boolean IS_MIFOUR = ("cancro".equals(DEVICE) && MODEL.startsWith("MI 4"));
    public static final boolean IS_MIFOUR_CDMA = (IS_MIFOUR && "CDMA".equals(SystemProperties.get("persist.radio.modem")));
    public static final boolean IS_MIFOUR_LTE_CM = (IS_MIFOUR && "LTE-CMCC".equals(SystemProperties.get("persist.radio.modem")));
    public static final boolean IS_MIFOUR_LTE_CT = (IS_MIFOUR && "LTE-CT".equals(SystemProperties.get("persist.radio.modem")));
    public static final boolean IS_MIFOUR_LTE_CU = (IS_MIFOUR && "LTE-CU".equals(SystemProperties.get("persist.radio.modem")));
    public static final boolean IS_MIFOUR_LTE_INDIA = (IS_MIFOUR && "LTE-India".equals(SystemProperties.get("persist.radio.modem")));
    public static final boolean IS_MIFOUR_LTE_SEASA = (IS_MIFOUR && "LTE-SEAsa".equals(SystemProperties.get("persist.radio.modem")));
    public static final boolean IS_MIONE = ("mione".equals(DEVICE) || "mione_plus".equals(DEVICE));
    public static final boolean IS_MIONE_CDMA = (IS_MIONE && hasMsm8660Property());
    public static final boolean IS_MIPAD = "mocha".equals(DEVICE);
    public static final boolean IS_MITHREE = ("pisces".equals(DEVICE) || ("cancro".equals(DEVICE) && MODEL.startsWith("MI 3")));
    public static final boolean IS_MITHREE_CDMA = (IS_MITHREE && "MI 3C".equals(MODEL));
    public static final boolean IS_MITHREE_TDSCDMA = (IS_MITHREE && "TD".equals(SystemProperties.get("persist.radio.modem")));
    public static final boolean IS_MITWO = ("aries".equals(DEVICE) || "taurus".equals(DEVICE) || "taurus_td".equals(DEVICE));
    public static final boolean IS_MITWO_CDMA = (IS_MITWO && "CDMA".equals(SystemProperties.get("persist.radio.modem")));
    public static final boolean IS_MITWO_TDSCDMA = (IS_MITWO && "TD".equals(SystemProperties.get("persist.radio.modem")));
    public static final boolean IS_MY_BUILD = REGION.endsWith("my");
    public static final boolean IS_N7 = "flo".equals(DEVICE);
    public static final boolean IS_OFFICIAL_VERSION;
    public static final boolean IS_PH_BUILD = REGION.endsWith("ph");
    public static final boolean IS_SG_BUILD = REGION.endsWith("sg");
    public static final boolean IS_STABLE_VERSION = ("user".equals(TYPE) && !IS_DEVELOPMENT_VERSION);
    public static final boolean IS_TABLET = isTablet();
    public static final boolean IS_TDS_CDMA = (IS_MITHREE_TDSCDMA || IS_HONGMI2_TDSCDMA || IS_MITWO_TDSCDMA);
    public static final boolean IS_TH_BUILD = REGION.endsWith("th");
    public static final boolean IS_TW_BUILD;
    public static final boolean IS_XIAOMI = (IS_MIONE || IS_MITWO || IS_MITHREE || IS_MIFOUR || IS_MIFIVE);
    public static final String REGION;

    protected Build() throws InstantiationException {
        throw new InstantiationException("Cannot instantiate utility class");
    }

    static {
        boolean z = false;
        if (IS_DEVELOPMENT_VERSION || IS_STABLE_VERSION) {
            z = true;
        }
        IS_OFFICIAL_VERSION = z;
        String str = SystemProperties.get("ro.miuipub.region", "cn");
        REGION = str;
        IS_TW_BUILD = str.endsWith("tw");
    }

    private static boolean hasMsm8660Property() {
        String str = SystemProperties.get("ro.soc.name");
        return "msm8660".equals(str) || "unkown".equals(str);
    }

    private static boolean isTablet() {
        if (IS_N7 || IS_MIPAD) {
            return true;
        }
        DisplayMetrics displayMetrics = Resources.getSystem().getDisplayMetrics();
        if (((int) ((((float) Math.min(displayMetrics.widthPixels, displayMetrics.heightPixels)) / displayMetrics.density) + 0.5f)) >= 600) {
            return true;
        }
        return false;
    }

    public static boolean hasCameraFlash(Context context) {
        return !IS_N7 && !IS_MIPAD && context.getPackageManager().hasSystemFeature("android.hardware.camera.flash");
    }

    public static int getUserMode() {
        return SystemProperties.getInt("persist.sys.user_mode", 0);
    }

    public static void setUserMode(Context context, int i) {
        SystemProperties.set("persist.sys.user_mode", Integer.toString(i));
        ((PowerManager) context.getSystemService("power")).reboot(null);
    }

    public static String getCustVariant() {
        if (!IS_INTERNATIONAL_BUILD) {
            return SystemProperties.get("ro.miui.cust_variant", "cn");
        }
        return SystemProperties.get("ro.miui.cust_variant", "hk");
    }
}
