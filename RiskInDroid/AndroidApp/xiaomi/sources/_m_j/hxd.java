package _m_j;

import _m_j.wc;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.xiaomi.plugin.core.XmPluginPackage;
import com.xiaomi.smarthome.application.CommonApplication;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;

public final class hxd {

    /* renamed from: O000000o  reason: collision with root package name */
    public Bundle f944O000000o;
    public Context O00000Oo;
    hya O00000o = new hya() {
        /* class _m_j.hxd.AnonymousClass1 */

        public final boolean O000000o() {
            return true;
        }

        public final void O000000o(String str, JSONObject jSONObject, String str2) {
            O000000o(str, jSONObject, str2, "");
        }

        /* JADX WARNING: Removed duplicated region for block: B:33:0x0083  */
        /* JADX WARNING: Removed duplicated region for block: B:34:0x0086 A[SYNTHETIC, Splitter:B:34:0x0086] */
        /* JADX WARNING: Removed duplicated region for block: B:41:0x009b A[Catch:{ Exception -> 0x018c }] */
        /* JADX WARNING: Removed duplicated region for block: B:42:0x00a1 A[Catch:{ Exception -> 0x018c }] */
        /* JADX WARNING: Removed duplicated region for block: B:45:0x00a6 A[Catch:{ Exception -> 0x018c }] */
        /* JADX WARNING: Removed duplicated region for block: B:46:0x00a9 A[Catch:{ Exception -> 0x018c }] */
        /* JADX WARNING: Removed duplicated region for block: B:49:0x00b4 A[Catch:{ Exception -> 0x018c }] */
        /* JADX WARNING: Removed duplicated region for block: B:50:0x00b7 A[Catch:{ Exception -> 0x018c }] */
        /* JADX WARNING: Removed duplicated region for block: B:53:0x00ce A[Catch:{ Exception -> 0x018c }] */
        /* JADX WARNING: Removed duplicated region for block: B:57:0x00ed  */
        /* JADX WARNING: Removed duplicated region for block: B:58:0x00ef A[SYNTHETIC, Splitter:B:58:0x00ef] */
        /* JADX WARNING: Removed duplicated region for block: B:62:0x00f7 A[SYNTHETIC, Splitter:B:62:0x00f7] */
        /* JADX WARNING: Removed duplicated region for block: B:81:0x013a A[Catch:{ Exception -> 0x018c }] */
        /* JADX WARNING: Removed duplicated region for block: B:85:0x0142 A[Catch:{ Exception -> 0x018c }] */
        /* JADX WARNING: Removed duplicated region for block: B:86:0x0143 A[Catch:{ Exception -> 0x018c }] */
        /* JADX WARNING: Removed duplicated region for block: B:89:0x0172 A[Catch:{ Exception -> 0x018c }] */
        public final void O000000o(String str, JSONObject jSONObject, String str2, String str3) {
            Long l;
            JSONObject jSONObject2;
            long j;
            long j2;
            String str4;
            long j3;
            String str5 = str;
            JSONObject jSONObject3 = jSONObject;
            String str6 = str2;
            try {
                if (hxd.this.O00000o0 != null && hxd.this.O00000Oo != null) {
                    if (gfr.O0000oO0) {
                        String O000000o2 = O000000o(str5, str6);
                        if (hxd.this.O000000o(O000000o2)) {
                            long currentTimeMillis = System.currentTimeMillis();
                            String O00000Oo = fcn.O000000o().O00000Oo();
                            String O000000o3 = hyi.O000000o(flu.O00000oO());
                            int i = 0;
                            Long l2 = null;
                            if (O000000o3 != null && O000000o3.startsWith("\\\"session\\\":")) {
                                String substring = O000000o3.substring(12);
                                int indexOf = substring.indexOf(",\\\"order\\\":");
                                try {
                                    l = Long.valueOf(Long.parseLong(substring.substring(0, indexOf)));
                                    try {
                                        l2 = Long.valueOf(Long.parseLong(substring.substring(indexOf + 11)));
                                    } catch (Exception unused) {
                                    }
                                } catch (Exception unused2) {
                                }
                                if ("app".equals(str5) && "switch_to_backstage".equals(str6)) {
                                    if (l != null) {
                                        j3 = -1;
                                    } else {
                                        try {
                                            j3 = (currentTimeMillis - l.longValue()) / 100;
                                        } catch (Exception e) {
                                            e.printStackTrace();
                                        }
                                    }
                                    jSONObject3.put("stay_time", j3);
                                }
                                jSONObject2 = jSONObject3 != null ? new JSONObject() : jSONObject3;
                                if (l != null) {
                                    j = -1;
                                } else {
                                    j = l.longValue();
                                }
                                jSONObject2.put("session", j);
                                if (l2 != null) {
                                    j2 = -1;
                                } else {
                                    j2 = l2.longValue();
                                }
                                jSONObject2.put("order", j2);
                                jSONObject2.put("key_name", str6);
                                Bundle bundle = new Bundle();
                                if (hxd.this.f944O000000o == null) {
                                    hxd.this.O000000o();
                                }
                                bundle.putAll(hxd.this.f944O000000o);
                                Bundle bundle2 = new Bundle();
                                bundle2.putString("type", str5);
                                bundle2.putString("key", O000000o2);
                                String str7 = "";
                                if (jSONObject2 != null) {
                                    str4 = str7;
                                } else {
                                    str4 = jSONObject2.toString();
                                }
                                if (str4 != null) {
                                    if (str4.length() > 100) {
                                        int length = str4.length();
                                        double d = (double) length;
                                        Double.isNaN(d);
                                        int ceil = (int) Math.ceil(d / 100.0d);
                                        while (i < ceil) {
                                            StringBuilder sb = new StringBuilder("value");
                                            sb.append(i > 0 ? Integer.valueOf(i) : str7);
                                            String sb2 = sb.toString();
                                            int i2 = i * 100;
                                            i++;
                                            int i3 = i * 100;
                                            if (i3 >= length) {
                                                i3 = length;
                                            }
                                            bundle2.putString(sb2, str4.substring(i2, i3));
                                        }
                                        if (str3 != null) {
                                            str7 = str3;
                                        }
                                        bundle2.putString("extra", str7);
                                        bundle2.putString("am", "mihome");
                                        bundle2.putString("uid", O00000Oo);
                                        bundle2.putBoolean("isForeground", CommonApplication.getApplication().isAppForeground());
                                        bundle2.putLong("time", currentTimeMillis / 1000);
                                        bundle.putAll(bundle2);
                                        if (hxd.O00000Oo(O000000o2)) {
                                            O000000o2 = "mi_".concat(String.valueOf(O000000o2));
                                        }
                                        hxd.this.O00000o0.report(O000000o2.replace(".", "_"), bundle);
                                    }
                                }
                                if (str4 == null) {
                                    str4 = str7;
                                }
                                bundle2.putString("value", str4);
                                if (str3 != null) {
                                }
                                bundle2.putString("extra", str7);
                                bundle2.putString("am", "mihome");
                                bundle2.putString("uid", O00000Oo);
                                bundle2.putBoolean("isForeground", CommonApplication.getApplication().isAppForeground());
                                bundle2.putLong("time", currentTimeMillis / 1000);
                                bundle.putAll(bundle2);
                                if (hxd.O00000Oo(O000000o2)) {
                                }
                                hxd.this.O00000o0.report(O000000o2.replace(".", "_"), bundle);
                            }
                            l = null;
                            if (l != null) {
                            }
                            jSONObject3.put("stay_time", j3);
                            if (jSONObject3 != null) {
                            }
                            if (l != null) {
                            }
                            jSONObject2.put("session", j);
                            if (l2 != null) {
                            }
                            jSONObject2.put("order", j2);
                            jSONObject2.put("key_name", str6);
                            Bundle bundle3 = new Bundle();
                            if (hxd.this.f944O000000o == null) {
                            }
                            bundle3.putAll(hxd.this.f944O000000o);
                            Bundle bundle22 = new Bundle();
                            bundle22.putString("type", str5);
                            bundle22.putString("key", O000000o2);
                            String str72 = "";
                            if (jSONObject2 != null) {
                            }
                            if (str4 != null) {
                            }
                            if (str4 == null) {
                            }
                            bundle22.putString("value", str4);
                            if (str3 != null) {
                            }
                            bundle22.putString("extra", str72);
                            bundle22.putString("am", "mihome");
                            bundle22.putString("uid", O00000Oo);
                            bundle22.putBoolean("isForeground", CommonApplication.getApplication().isAppForeground());
                            bundle22.putLong("time", currentTimeMillis / 1000);
                            bundle3.putAll(bundle22);
                            if (hxd.O00000Oo(O000000o2)) {
                            }
                            hxd.this.O00000o0.report(O000000o2.replace(".", "_"), bundle3);
                        }
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        private static String O000000o(String str, String str2) {
            return hyb.O000000o().O000000o(str, str2);
        }
    };
    public hxx O00000o0;
    private ArrayList<String> O00000oO = new ArrayList<>();

    public static final class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public static final hxd f946O000000o = new hxd();
    }

    public final void O000000o() {
        Integer num;
        this.f944O000000o = new Bundle();
        String O000000o2 = wb.O000000o(this.O00000Oo);
        if (O000000o2 == null || O000000o2.length() <= 100) {
            Bundle bundle = this.f944O000000o;
            if (O000000o2 == null) {
                O000000o2 = "";
            }
            bundle.putString("cid", O000000o2);
        } else {
            int length = O000000o2.length();
            double d = (double) length;
            Double.isNaN(d);
            int ceil = (int) Math.ceil(d / 100.0d);
            int i = 0;
            while (i < ceil) {
                Bundle bundle2 = this.f944O000000o;
                StringBuilder sb = new StringBuilder("cid");
                if (i > 0) {
                    num = Integer.valueOf(i);
                } else {
                    num = "";
                }
                sb.append(num);
                String sb2 = sb.toString();
                int i2 = i * 100;
                i++;
                int i3 = i * 100;
                if (i3 >= length) {
                    i3 = length;
                }
                bundle2.putString(sb2, O000000o2.substring(i2, i3));
            }
        }
        this.f944O000000o.putString("msid", wc.O000000o.O000000o());
        Bundle bundle3 = this.f944O000000o;
        grr.O000000o();
        bundle3.putString("mc", grr.O00000oO(this.O00000Oo));
        Bundle bundle4 = this.f944O000000o;
        grr.O000000o();
        bundle4.putString("av", grr.O00000Oo(this.O00000Oo));
        Bundle bundle5 = this.f944O000000o;
        StringBuilder sb3 = new StringBuilder();
        grr.O000000o();
        sb3.append(grr.O0000O0o());
        sb3.append("-");
        grr.O000000o();
        sb3.append(grr.O0000Oo0());
        sb3.append("-");
        grr.O000000o();
        sb3.append(grr.O0000o00());
        bundle5.putString("ov", sb3.toString());
        Bundle bundle6 = this.f944O000000o;
        grr.O000000o();
        bundle6.putString("md", grr.O0000Ooo());
        Bundle bundle7 = this.f944O000000o;
        grr.O000000o();
        bundle7.putString("am", grr.O0000o0());
        this.f944O000000o.putString("ch", gfr.O0000o0O);
    }

    public final boolean O000000o(String str) {
        ArrayList<String> arrayList = this.O00000oO;
        if (arrayList != null && arrayList.size() > 0) {
            return this.O00000oO.contains(str);
        }
        Context appContext = CommonApplication.getAppContext();
        if (appContext == null) {
            return false;
        }
        InputStream inputStream = null;
        try {
            inputStream = appContext.getResources().getAssets().open("stat_config_firebase.json");
            JSONArray jSONArray = new JSONArray(new String(hxw.O000000o(inputStream)));
            if (jSONArray.length() > 0) {
                for (int i = 0; i < jSONArray.length(); i++) {
                    String str2 = (String) jSONArray.get(i);
                    if (!TextUtils.isEmpty(str2)) {
                        this.O00000oO.add(str2);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } catch (Throwable th) {
            gpg.O000000o((InputStream) null);
            throw th;
        }
        gpg.O000000o(inputStream);
        return this.O00000oO.contains(str);
    }

    public final void O000000o(Activity activity, String str, XmPluginPackage xmPluginPackage) {
        try {
            if (!gfr.O0000oO0) {
                return;
            }
            if (this.O00000o0 != null) {
                HashMap hashMap = new HashMap();
                if (xmPluginPackage != null) {
                    hashMap.put("plugin", hxw.O000000o(xmPluginPackage.getPluginId(), xmPluginPackage.getPackageId()));
                } else {
                    hashMap.put("page", hyg.O000000o(activity));
                }
                O000000o.f946O000000o.O00000o.O000000o("app", new JSONObject(new Gson().toJson(hashMap)), str);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean O00000Oo(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        Pattern compile = Pattern.compile("[0-9]*");
        StringBuilder sb = new StringBuilder();
        sb.append(str.charAt(0));
        if (!compile.matcher(sb.toString()).matches()) {
            return false;
        }
        return true;
    }
}
