package _m_j;

import _m_j.caw;
import _m_j.cbm;
import _m_j.cej;
import android.app.Application;
import android.os.Build;
import android.text.TextUtils;
import com.mi.util.Device;
import com.xiaomi.accountsdk.account.data.ExtendedAuthToken;

public final class cae {
    public static String O000000o() {
        String str;
        ccn O0000o00 = ccn.O0000o00();
        String O00000Oo = O0000o00.O00000Oo();
        caw.O000000o.O00000oO();
        ExtendedAuthToken O000000o2 = O0000o00.O000000o(caw.O000000o.O00000o0());
        String str2 = O000000o2 != null ? O000000o2.authToken : null;
        String O00000Oo2 = cbm.O00000o0.O00000Oo(byl.O00000oO(), "xm_in_sid", (String) null);
        String O000000o3 = cbn.O000000o();
        String O00000Oo3 = cbm.O00000o0.O00000Oo(byl.O00000oO(), "pref_key_zip_code", "");
        String O00000Oo4 = cbm.O00000o0.O00000Oo(byl.O00000oO(), "pref_key_city_name", "");
        String O00000Oo5 = cbm.O00000o0.O00000Oo(byl.O00000oO(), "pref_key_state_id", "");
        String O00000Oo6 = cbm.O00000o0.O00000Oo(byl.O00000oO(), "pref_key_warehouse_id", "");
        if (TextUtils.isEmpty(cbe.O000000o(byl.O00000oO()))) {
            str = Device.O000O0OO;
        } else {
            str = cbe.O000000o(byl.O00000oO());
        }
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(str2)) {
            sb.append("serviceToken=");
            sb.append(str2);
        }
        O000000o(sb, O00000Oo);
        if (!TextUtils.isEmpty(O00000Oo2)) {
            sb.append("; xm_in_sid=");
            sb.append(O00000Oo2);
        }
        if (!TextUtils.isEmpty(O000000o3)) {
            sb.append("; xmuuid=");
            sb.append(O000000o3);
        }
        if (!TextUtils.isEmpty(O00000Oo3) && !TextUtils.isEmpty(O00000Oo4) && !TextUtils.isEmpty(O00000Oo5) && !TextUtils.isEmpty(O00000Oo6)) {
            sb.append("; XM_pincode_in=");
            sb.append(O00000Oo3);
            sb.append("; WH_cityName=");
            sb.append(O00000Oo4);
            sb.append("; WH_stateId=");
            sb.append(O00000Oo5);
            sb.append("; WH_warehouse=");
            sb.append(O00000Oo6);
        }
        if (byl.O0000O0o != null) {
            if (byl.O0000O0o.O00000oo.equals("community_sdk")) {
                sb.append(";request_from=community_sdk");
            } else if (byl.O0000O0o.O00000oo.equals("mihome_sdk")) {
                sb.append(";request_from=mihome_sdk");
            } else {
                sb.append(";request_from=community_sdk");
            }
        }
        sb.append("; sdk_version=");
        sb.append("30502");
        if (byl.O0000OoO()) {
            sb.append(";ot=5");
            if (Build.VERSION.SDK_INT > 15) {
                sb.append(";rnversion=0.39.1");
                sb.append(";rn=");
                String[] split = cbm.O00000o0.O00000Oo(byl.O00000oO(), "rn_bundle_name_list", "product").split(";");
                for (int i = 0; i < split.length; i++) {
                    Application O00000oO = byl.O00000oO();
                    int O000000o4 = cbm.O00000o0.O000000o(O00000oO, split[i] + "_current_version", 1);
                    if (i == 0) {
                        sb.append(split[i]);
                        sb.append(":");
                        sb.append(O000000o4);
                    } else {
                        sb.append(",");
                        sb.append(split[i]);
                        sb.append(":");
                        sb.append(O000000o4);
                    }
                }
            }
        }
        int O000000o5 = cej.O00000Oo.O000000o(byl.O00000oO(), "pref_hotfix_version", 0);
        if (O000000o5 > 0) {
            sb.append(";hotfixVersion=".concat(String.valueOf(O000000o5)));
        }
        sb.append(";ISAPP=1");
        if (!TextUtils.isEmpty(str)) {
            sb.append("; DEVICEID=");
            sb.append(str);
        }
        return sb.toString();
    }

    private static void O000000o(StringBuilder sb, String str) {
        if (!TextUtils.isEmpty(str)) {
            String O000000o2 = cei.O000000o(str);
            if (!TextUtils.isEmpty(O000000o2)) {
                sb.append("; mUserId=");
                sb.append(O000000o2);
            }
            String O00000Oo = cei.O00000Oo(str);
            if (!TextUtils.isEmpty(O00000Oo)) {
                sb.append("; cUserId=");
                sb.append(O00000Oo);
            }
        }
    }
}
