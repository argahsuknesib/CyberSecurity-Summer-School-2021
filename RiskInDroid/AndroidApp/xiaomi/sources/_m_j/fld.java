package _m_j;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.xiaomi.smarthome.application.CommonApplication;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class fld {
    private static volatile fld O0000O0o;
    private static Object O0000OOo = new Object();

    /* renamed from: O000000o  reason: collision with root package name */
    gpq f16566O000000o;
    public O00000Oo O00000Oo;
    public long O00000o = 600000;
    public Context O00000o0 = CommonApplication.getAppContext();
    public int O00000oO = 1000;
    public volatile hye O00000oo = null;
    private ConcurrentLinkedQueue<O000000o> O0000Oo = new ConcurrentLinkedQueue<>();
    private boolean O0000Oo0 = false;

    private fld() {
        O00000oO();
    }

    public static boolean O000000o() {
        boolean z = false;
        if (O0000O0o == null) {
            return false;
        }
        if (O0000O0o.O00000oo != null) {
            return true;
        }
        if (O0000O0o.O00000oo == null) {
            synchronized (O0000O0o) {
                if (O0000O0o.O00000oo != null) {
                    z = true;
                }
            }
            return z;
        } else if (O0000O0o.O00000oo != null) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean O00000Oo() {
        if (O0000O0o == null) {
            return false;
        }
        if (O0000O0o.O00000oo != null) {
            return true;
        }
        synchronized (O0000O0o) {
            if (O0000O0o.O00000oo == null) {
                O0000O0o.O00000oo = new hye() {
                    /* class _m_j.fld.AnonymousClass1 */
                };
            }
        }
        return true;
    }

    public static fld O00000o0() {
        if (O0000O0o == null) {
            synchronized (O0000OOo) {
                if (O0000O0o == null) {
                    O0000O0o = new fld();
                }
            }
        }
        return O0000O0o;
    }

    private void O00000oO() {
        boolean z;
        synchronized (O0000OOo) {
            z = this.O0000Oo0;
            if (!this.O0000Oo0) {
                this.O0000Oo0 = true;
            }
        }
        if (!z) {
            this.f16566O000000o = new gpq("StatWorker");
            this.f16566O000000o.start();
            this.O00000Oo = new O00000Oo(this.f16566O000000o.getLooper());
            while (!this.O0000Oo.isEmpty()) {
                this.O00000Oo.obtainMessage(2, this.O0000Oo.poll()).sendToTarget();
            }
            new Handler().postDelayed(new Runnable() {
                /* class _m_j.fld.AnonymousClass2 */

                public final void run() {
                    fld.this.O00000o();
                }
            }, 600000);
        }
    }

    public final void O00000o() {
        this.O00000Oo.sendEmptyMessage(1);
    }

    public final void O000000o(String str, String str2, String str3, String str4, String str5, boolean z) {
        O000000o o000000o = new O000000o();
        o000000o.f16570O000000o = str;
        o000000o.O00000Oo = str2;
        o000000o.O00000o0 = str3;
        o000000o.O00000o = str4;
        o000000o.O00000oO = str5;
        o000000o.O00000oo = z;
        O00000Oo o00000Oo = this.O00000Oo;
        if (o00000Oo == null) {
            this.O0000Oo.add(o000000o);
        } else {
            o00000Oo.obtainMessage(2, o000000o).sendToTarget();
        }
    }

    class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        String f16570O000000o;
        String O00000Oo;
        String O00000o;
        String O00000o0;
        String O00000oO;
        boolean O00000oo;

        O000000o() {
        }
    }

    public class O00000Oo extends Handler {
        O00000Oo(Looper looper) {
            super(looper);
        }

        /* JADX WARNING: Removed duplicated region for block: B:130:0x02f2  */
        /* JADX WARNING: Removed duplicated region for block: B:137:0x0313  */
        /* JADX WARNING: Removed duplicated region for block: B:140:0x032d  */
        public final void handleMessage(Message message) {
            fld fld;
            SharedPreferences sharedPreferences;
            Pattern pattern;
            ArrayList arrayList;
            SharedPreferences sharedPreferences2;
            JSONArray jSONArray;
            fld fld2;
            ArrayList arrayList2;
            String str;
            String str2;
            String str3;
            String str4;
            fld fld3;
            ArrayList arrayList3;
            long j;
            String str5;
            String str6;
            String str7;
            String str8;
            String str9;
            String str10;
            String str11;
            Message message2 = message;
            int i = message2.what;
            if (i == 1) {
                fld.this.O00000Oo.removeMessages(1);
                fld fld4 = fld.this;
                Context context = fld4.O00000o0;
                SharedPreferences sharedPreferences3 = context.getSharedPreferences("sh_stat_logs_public", 0);
                SharedPreferences sharedPreferences4 = context.getSharedPreferences("sh_stat_logs_private", 0);
                Pattern compile = Pattern.compile(" ");
                JSONArray jSONArray2 = new JSONArray();
                ArrayList arrayList4 = new ArrayList();
                ArrayList<String> arrayList5 = new ArrayList<>();
                Map<String, ?> all = sharedPreferences3.getAll();
                if (all != null && all.size() > 0) {
                    Iterator<Map.Entry<String, ?>> it = all.entrySet().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        Map.Entry next = it.next();
                        String str12 = (String) next.getKey();
                        if (!TextUtils.isEmpty(str12)) {
                            Iterator<Map.Entry<String, ?>> it2 = it;
                            String[] split = compile.split(str12);
                            pattern = compile;
                            if (split.length >= 3) {
                                String str13 = split[0];
                                if (ftn.O0000O0o(CommonApplication.getAppContext())) {
                                    str13 = "";
                                }
                                try {
                                    j = Long.parseLong(split[1]);
                                } catch (Exception unused) {
                                    j = 0;
                                }
                                if (System.currentTimeMillis() - j <= 259200000) {
                                    sharedPreferences = sharedPreferences4;
                                    if (jSONArray2.length() > fld4.O00000oO) {
                                        fld = fld4;
                                        break;
                                    }
                                    arrayList4.add(str12);
                                    String str14 = split[2];
                                    if (split.length > 3) {
                                        str5 = split[3];
                                    } else {
                                        str5 = "";
                                    }
                                    try {
                                        JSONObject jSONObject = new JSONObject((String) next.getValue());
                                        str8 = jSONObject.optString("key");
                                        try {
                                            str9 = jSONObject.optString("value");
                                            try {
                                                fld3 = fld4;
                                                String str15 = str9;
                                                arrayList3 = arrayList4;
                                                str7 = jSONObject.optString("extra");
                                                str6 = str15;
                                            } catch (JSONException unused2) {
                                                fld3 = fld4;
                                                str6 = str9;
                                                arrayList3 = arrayList4;
                                                str7 = "";
                                                JSONObject jSONObject2 = new JSONObject();
                                                jSONObject2.put("type", str14);
                                                jSONObject2.put("am", str5);
                                                jSONObject2.put("uid", str13);
                                                jSONObject2.put("time", j / 1000);
                                                jSONObject2.put("key", str8);
                                                jSONObject2.put("value", str6);
                                                jSONObject2.put("extra", str7);
                                                jSONArray2.put(jSONObject2);
                                                it = it2;
                                                arrayList4 = arrayList3;
                                                compile = pattern;
                                                sharedPreferences4 = sharedPreferences;
                                                fld4 = fld3;
                                            }
                                        } catch (JSONException unused3) {
                                            str9 = "";
                                            fld3 = fld4;
                                            str6 = str9;
                                            arrayList3 = arrayList4;
                                            str7 = "";
                                            JSONObject jSONObject22 = new JSONObject();
                                            jSONObject22.put("type", str14);
                                            jSONObject22.put("am", str5);
                                            jSONObject22.put("uid", str13);
                                            jSONObject22.put("time", j / 1000);
                                            jSONObject22.put("key", str8);
                                            jSONObject22.put("value", str6);
                                            jSONObject22.put("extra", str7);
                                            jSONArray2.put(jSONObject22);
                                            it = it2;
                                            arrayList4 = arrayList3;
                                            compile = pattern;
                                            sharedPreferences4 = sharedPreferences;
                                            fld4 = fld3;
                                        }
                                    } catch (JSONException unused4) {
                                        str8 = "";
                                        str9 = str8;
                                        fld3 = fld4;
                                        str6 = str9;
                                        arrayList3 = arrayList4;
                                        str7 = "";
                                        JSONObject jSONObject222 = new JSONObject();
                                        jSONObject222.put("type", str14);
                                        jSONObject222.put("am", str5);
                                        jSONObject222.put("uid", str13);
                                        jSONObject222.put("time", j / 1000);
                                        jSONObject222.put("key", str8);
                                        jSONObject222.put("value", str6);
                                        jSONObject222.put("extra", str7);
                                        jSONArray2.put(jSONObject222);
                                        it = it2;
                                        arrayList4 = arrayList3;
                                        compile = pattern;
                                        sharedPreferences4 = sharedPreferences;
                                        fld4 = fld3;
                                    }
                                    JSONObject jSONObject2222 = new JSONObject();
                                    try {
                                        jSONObject2222.put("type", str14);
                                        jSONObject2222.put("am", str5);
                                        jSONObject2222.put("uid", str13);
                                        jSONObject2222.put("time", j / 1000);
                                        jSONObject2222.put("key", str8);
                                        jSONObject2222.put("value", str6);
                                        jSONObject2222.put("extra", str7);
                                        jSONArray2.put(jSONObject2222);
                                    } catch (JSONException unused5) {
                                    }
                                } else {
                                    arrayList5.add(str12);
                                    it = it2;
                                    compile = pattern;
                                }
                            } else {
                                fld3 = fld4;
                                sharedPreferences = sharedPreferences4;
                                arrayList3 = arrayList4;
                            }
                            it = it2;
                            arrayList4 = arrayList3;
                            compile = pattern;
                            sharedPreferences4 = sharedPreferences;
                            fld4 = fld3;
                        }
                    }
                }
                fld = fld4;
                sharedPreferences = sharedPreferences4;
                pattern = compile;
                ArrayList arrayList6 = arrayList4;
                if (arrayList5.size() > 0) {
                    SharedPreferences.Editor edit = sharedPreferences3.edit();
                    for (String remove : arrayList5) {
                        edit.remove(remove);
                    }
                    edit.commit();
                }
                JSONArray jSONArray3 = new JSONArray();
                ArrayList arrayList7 = new ArrayList();
                ArrayList<String> arrayList8 = new ArrayList<>();
                Map<String, ?> all2 = sharedPreferences.getAll();
                if (all2 != null && all2.size() > 0) {
                    Iterator<Map.Entry<String, ?>> it3 = all2.entrySet().iterator();
                    while (true) {
                        if (!it3.hasNext()) {
                            break;
                        }
                        Map.Entry next2 = it3.next();
                        String str16 = (String) next2.getKey();
                        String[] split2 = pattern.split(str16);
                        Iterator<Map.Entry<String, ?>> it4 = it3;
                        if (split2.length >= 3) {
                            String str17 = split2[0];
                            if (ftn.O0000O0o(CommonApplication.getAppContext())) {
                                str17 = "";
                            }
                            long parseLong = Long.parseLong(split2[1]);
                            if (System.currentTimeMillis() - parseLong <= 259200000) {
                                sharedPreferences2 = sharedPreferences3;
                                fld2 = fld;
                                jSONArray = jSONArray2;
                                if (jSONArray3.length() > fld2.O00000oO) {
                                    arrayList = arrayList7;
                                    break;
                                }
                                arrayList7.add(str16);
                                String str18 = split2[2];
                                if (split2.length > 3) {
                                    str = split2[3];
                                } else {
                                    str = "";
                                }
                                try {
                                    JSONObject jSONObject3 = new JSONObject((String) next2.getValue());
                                    str3 = jSONObject3.optString("key");
                                    try {
                                        str2 = jSONObject3.optString("value");
                                        try {
                                            arrayList2 = arrayList7;
                                            str4 = jSONObject3.optString("extra");
                                        } catch (JSONException unused6) {
                                            arrayList2 = arrayList7;
                                            str4 = "";
                                            String str19 = str2;
                                            JSONObject jSONObject4 = new JSONObject();
                                            jSONObject4.put("type", str18);
                                            jSONObject4.put("am", str);
                                            jSONObject4.put("uid", str17);
                                            jSONObject4.put("time", parseLong / 1000);
                                            jSONObject4.put("key", str3);
                                            jSONObject4.put("value", str19);
                                            jSONObject4.put("extra", str4);
                                            jSONArray3.put(jSONObject4);
                                            it3 = it4;
                                            jSONArray2 = jSONArray;
                                            arrayList7 = arrayList2;
                                            fld = fld2;
                                            sharedPreferences3 = sharedPreferences2;
                                        }
                                    } catch (JSONException unused7) {
                                        str2 = "";
                                        arrayList2 = arrayList7;
                                        str4 = "";
                                        String str192 = str2;
                                        JSONObject jSONObject42 = new JSONObject();
                                        jSONObject42.put("type", str18);
                                        jSONObject42.put("am", str);
                                        jSONObject42.put("uid", str17);
                                        jSONObject42.put("time", parseLong / 1000);
                                        jSONObject42.put("key", str3);
                                        jSONObject42.put("value", str192);
                                        jSONObject42.put("extra", str4);
                                        jSONArray3.put(jSONObject42);
                                        it3 = it4;
                                        jSONArray2 = jSONArray;
                                        arrayList7 = arrayList2;
                                        fld = fld2;
                                        sharedPreferences3 = sharedPreferences2;
                                    }
                                } catch (JSONException unused8) {
                                    str3 = "";
                                    str2 = str3;
                                    arrayList2 = arrayList7;
                                    str4 = "";
                                    String str1922 = str2;
                                    JSONObject jSONObject422 = new JSONObject();
                                    jSONObject422.put("type", str18);
                                    jSONObject422.put("am", str);
                                    jSONObject422.put("uid", str17);
                                    jSONObject422.put("time", parseLong / 1000);
                                    jSONObject422.put("key", str3);
                                    jSONObject422.put("value", str1922);
                                    jSONObject422.put("extra", str4);
                                    jSONArray3.put(jSONObject422);
                                    it3 = it4;
                                    jSONArray2 = jSONArray;
                                    arrayList7 = arrayList2;
                                    fld = fld2;
                                    sharedPreferences3 = sharedPreferences2;
                                }
                                String str19222 = str2;
                                JSONObject jSONObject4222 = new JSONObject();
                                try {
                                    jSONObject4222.put("type", str18);
                                    jSONObject4222.put("am", str);
                                    jSONObject4222.put("uid", str17);
                                    jSONObject4222.put("time", parseLong / 1000);
                                    jSONObject4222.put("key", str3);
                                    jSONObject4222.put("value", str19222);
                                    jSONObject4222.put("extra", str4);
                                } catch (JSONException unused9) {
                                }
                                jSONArray3.put(jSONObject4222);
                            } else {
                                arrayList8.add(str16);
                                it3 = it4;
                            }
                        } else {
                            arrayList2 = arrayList7;
                            sharedPreferences2 = sharedPreferences3;
                            fld2 = fld;
                            jSONArray = jSONArray2;
                        }
                        it3 = it4;
                        jSONArray2 = jSONArray;
                        arrayList7 = arrayList2;
                        fld = fld2;
                        sharedPreferences3 = sharedPreferences2;
                    }
                    if (arrayList8.size() > 0) {
                        SharedPreferences.Editor edit2 = sharedPreferences.edit();
                        for (String remove2 : arrayList8) {
                            edit2.remove(remove2);
                        }
                        edit2.commit();
                    }
                    if (jSONArray.length() != 0) {
                        fle.O000000o().O00000Oo(fld2.O00000o0, jSONArray, new fde<flf, fdg>(sharedPreferences2, arrayList6) {
                            /* class _m_j.fld.AnonymousClass3 */

                            /* renamed from: O000000o  reason: collision with root package name */
                            final /* synthetic */ SharedPreferences f16568O000000o;
                            final /* synthetic */ List O00000Oo;

                            public final void onFailure(fdg fdg) {
                            }

                            {
                                this.f16568O000000o = r2;
                                this.O00000Oo = r3;
                            }

                            public final /* synthetic */ void onSuccess(Object obj) {
                                flf flf = (flf) obj;
                                SharedPreferences.Editor edit = this.f16568O000000o.edit();
                                for (String remove : this.O00000Oo) {
                                    edit.remove(remove);
                                }
                                edit.commit();
                                if (flf != null) {
                                    if (((long) flf.f16579O000000o) * 60000 < 600000) {
                                        fld.this.O00000o = 600000;
                                    } else {
                                        fld.this.O00000o = ((long) flf.f16579O000000o) * 60000;
                                    }
                                    if (flf.O00000Oo > 3000) {
                                        fld.this.O00000oO = 3000;
                                        return;
                                    }
                                    fld.this.O00000oO = flf.O00000Oo;
                                }
                            }
                        });
                    }
                    if (jSONArray3.length() != 0) {
                        fle.O000000o().O000000o(fld2.O00000o0, jSONArray3, new fde<flf, fdg>(sharedPreferences, arrayList) {
                            /* class _m_j.fld.AnonymousClass4 */

                            /* renamed from: O000000o  reason: collision with root package name */
                            final /* synthetic */ SharedPreferences f16569O000000o;
                            final /* synthetic */ List O00000Oo;

                            public final void onFailure(fdg fdg) {
                            }

                            {
                                this.f16569O000000o = r2;
                                this.O00000Oo = r3;
                            }

                            public final /* synthetic */ void onSuccess(Object obj) {
                                SharedPreferences.Editor edit = this.f16569O000000o.edit();
                                for (String remove : this.O00000Oo) {
                                    edit.remove(remove);
                                }
                                edit.commit();
                            }
                        });
                    }
                    fld.this.O00000Oo.sendEmptyMessageDelayed(1, fld.this.O00000o);
                }
                arrayList = arrayList7;
                sharedPreferences2 = sharedPreferences3;
                fld2 = fld;
                jSONArray = jSONArray2;
                if (arrayList8.size() > 0) {
                }
                if (jSONArray.length() != 0) {
                }
                if (jSONArray3.length() != 0) {
                }
                fld.this.O00000Oo.sendEmptyMessageDelayed(1, fld.this.O00000o);
            } else if (i != 2) {
                if (i == 3 && fld.this.O00000oo != null) {
                    fld.this.O00000oo.O000000o((String) message2.obj);
                }
            } else if (message2.obj instanceof O000000o) {
                O000000o o000000o = (O000000o) message2.obj;
                fld fld5 = fld.this;
                if (TextUtils.isEmpty(o000000o.f16570O000000o) || TextUtils.isEmpty(o000000o.O00000Oo)) {
                    str11 = o000000o.O00000o0;
                    str10 = o000000o.O00000o;
                } else {
                    String str20 = o000000o.f16570O000000o;
                    String str21 = o000000o.O00000Oo;
                    str11 = fcn.O000000o().O00000Oo() + " " + System.currentTimeMillis() + " " + str20 + " " + str21;
                    JSONObject jSONObject5 = new JSONObject();
                    try {
                        jSONObject5.put("key", o000000o.O00000o0);
                        jSONObject5.put("value", o000000o.O00000o);
                        jSONObject5.put("extra", o000000o.O00000oO);
                    } catch (JSONException unused10) {
                    }
                    str10 = jSONObject5.toString();
                }
                if (o000000o.O00000oo) {
                    fkz.O000000o(fld5.O00000o0.getSharedPreferences("sh_stat_logs_private", 0), str11, str10);
                } else {
                    fkz.O000000o(fld5.O00000o0.getSharedPreferences("sh_stat_logs_public", 0), str11, str10);
                }
            }
        }
    }
}
