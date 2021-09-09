package _m_j;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.idm.tap.dispatcher.ActionExecutor;
import com.xiaomi.idm.tap.dispatcher.impl.DefaultExecutorFactory;
import com.xiaomi.smarthome.nfctag.idmimpl.MijiaEmptyNfcTagExecutor;
import java.io.UnsupportedEncodingException;

public final class hiv extends DefaultExecutorFactory {

    /* renamed from: O000000o  reason: collision with root package name */
    public static String f18965O000000o = "doOpenDevicePlugin";
    public static String O00000Oo = "doOpenDevicePluginOrBinding";

    /* JADX WARNING: Removed duplicated region for block: B:45:0x0083  */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x0119  */
    public final ActionExecutor createExecutor(Context context, int i, dww dww) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        String str11;
        String str12;
        String str13;
        String str14;
        String str15;
        String str16;
        if (i == 1) {
            try {
                str = new String(dww.O000000o(13), "UTF-8");
            } catch (Exception unused) {
                str = null;
            }
            if (!TextUtils.isEmpty(str)) {
                if (TextUtils.equals(str, f18965O000000o)) {
                    try {
                        str5 = new String(dww.O000000o(6), "UTF-8");
                        try {
                            str7 = new String(dww.O000000o(7), "UTF-8");
                            try {
                                str6 = new String(dww.O000000o(8), "UTF-8");
                            } catch (Exception unused2) {
                            }
                        } catch (Exception unused3) {
                            str7 = null;
                            str6 = null;
                            return new hix(context, str5, str7, str6);
                        }
                    } catch (Exception unused4) {
                        str5 = null;
                        str7 = null;
                        str6 = null;
                        return new hix(context, str5, str7, str6);
                    }
                    if (!TextUtils.isEmpty(str5) && !TextUtils.isEmpty(str7)) {
                        return new hix(context, str5, str7, str6);
                    }
                } else if (TextUtils.equals(str, O00000Oo)) {
                    try {
                        str2 = new String(dww.O000000o(6), "UTF-8");
                        try {
                            str4 = new String(dww.O000000o(7), "UTF-8");
                            try {
                                str3 = new String(dww.O000000o(2), "UTF-8");
                            } catch (UnsupportedEncodingException unused5) {
                            }
                        } catch (UnsupportedEncodingException unused6) {
                            str4 = null;
                            str3 = null;
                            if (!TextUtils.isEmpty(str4)) {
                            }
                            return null;
                        }
                    } catch (UnsupportedEncodingException unused7) {
                        str2 = null;
                        str4 = null;
                        str3 = null;
                        if (!TextUtils.isEmpty(str4)) {
                        }
                        return null;
                    }
                    if (!TextUtils.isEmpty(str4)) {
                        return new hiu(context, str2, str4, str3);
                    }
                }
            }
        } else if (i == 9) {
            try {
                str12 = new String(dww.O000000o(1), "UTF-8");
                try {
                    str13 = new String(dww.O000000o(2), "UTF-8");
                    try {
                        str14 = new String(dww.O000000o(3), "UTF-8");
                    } catch (Exception unused8) {
                        str14 = null;
                        str11 = str12;
                        str9 = str14;
                        str10 = str13;
                        str8 = null;
                        if (!TextUtils.isEmpty(str11)) {
                        }
                        return null;
                    }
                } catch (Exception unused9) {
                    str14 = null;
                    str13 = str14;
                    str11 = str12;
                    str9 = str14;
                    str10 = str13;
                    str8 = null;
                    if (!TextUtils.isEmpty(str11)) {
                    }
                    return null;
                }
                try {
                    str11 = str12;
                    str9 = str14;
                    str10 = str13;
                    str8 = new String(dww.O000000o(4), "UTF-8");
                } catch (Exception unused10) {
                    str11 = str12;
                    str9 = str14;
                    str10 = str13;
                    str8 = null;
                    if (!TextUtils.isEmpty(str11)) {
                    }
                    return null;
                }
            } catch (Exception unused11) {
                str12 = null;
                str14 = null;
                str13 = str14;
                str11 = str12;
                str9 = str14;
                str10 = str13;
                str8 = null;
                if (!TextUtils.isEmpty(str11)) {
                }
                return null;
            }
            if (!TextUtils.isEmpty(str11) || TextUtils.isEmpty(str10) || TextUtils.isEmpty(str9)) {
                return null;
            }
            return new hiw(context, str11, str10, str9, str8);
        } else if (i == 11) {
            try {
                str15 = new String(dww.O000000o(15), "UTF-8");
                try {
                    str16 = new String(dww.O000000o(17), "UTF-8");
                } catch (Exception unused12) {
                }
            } catch (Exception unused13) {
                str15 = null;
                str16 = null;
                if (!TextUtils.isEmpty(str15)) {
                }
                return null;
            }
            if (!TextUtils.isEmpty(str15) || TextUtils.isEmpty(str16)) {
                return null;
            }
            return new hiy(context, str15, str16);
        } else if (i == 12) {
            return new MijiaEmptyNfcTagExecutor(context);
        }
        return null;
    }
}
