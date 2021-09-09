package _m_j;

import _m_j.ccy;
import _m_j.cdd;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.google.android.exoplayer2.source.dash.DashMediaSource;
import com.mi.mistatistic.sdk.model.EventExtraData;
import com.mi.mistatistic.sdk.model.Stat;
import com.mi.mistatistic.sdk.model.Value;
import com.mi.mistatistic.sdk.model.Value_Event;
import com.mi.mistatistic.sdk.model.Value_Page;
import com.mi.mistatistic.sdk.model.Value_RN_Activity;
import com.mi.mistatistic.sdk.model.Value_RN_Download;
import com.mi.mistatistic.sdk.model.Value_RN_LoadBundle;
import com.mi.mistatistic.sdk.model.Value_Session;
import com.mi.mistatistic.sdk.model.Value_Startup;
import com.mi.mistatistic.sdk.model.Value_View_Click;
import com.mi.mistatistic.sdk.model.Value_View_Show;
import com.squareup.wire.internal.Internal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class cdf {

    /* renamed from: O000000o  reason: collision with root package name */
    public static AtomicBoolean f13655O000000o = new AtomicBoolean(false);
    public static String O00000Oo = (cct.f13639O000000o + "micra/crash");
    public static String O00000o0 = (cct.f13639O000000o + "app/stat");
    private final List<String> O00000o = Arrays.asList("es", "fr", "de", "gb", "it");
    private final boolean O00000oO = this.O00000o.contains(Locale.getDefault().getCountry().toLowerCase());

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.cde.O000000o(android.content.Context, java.lang.String, long):long
     arg types: [android.content.Context, java.lang.String, int]
     candidates:
      _m_j.cde.O000000o(android.content.Context, java.lang.String, java.lang.String):java.lang.String
      _m_j.cde.O000000o(android.content.Context, java.lang.String, int):void
      _m_j.cde.O000000o(android.content.Context, java.lang.String, boolean):void
      _m_j.cde.O000000o(android.content.Context, java.lang.String, long):long */
    public final void O000000o(boolean z) {
        Stat.O000000o o000000o;
        List<Value> O000000o2;
        if (ccu.O000000o()) {
            boolean z2 = true;
            if (f13655O000000o.compareAndSet(false, true)) {
                cdh.O000000o();
                long j = 0;
                if (cdh.O00000Oo() <= cde.O000000o(ccx.O000000o(), "next_upload_ts", 0L)) {
                    z2 = false;
                }
                if (z2) {
                    JSONArray jSONArray = new JSONArray();
                    new cda();
                    ArrayList<cdm> O00000Oo2 = cda.O00000Oo();
                    int i = 0;
                    while (i < O00000Oo2.size() && i < 100) {
                        cdm cdm = O00000Oo2.get(i);
                        long O00000Oo3 = cdm.O00000Oo();
                        if (O00000Oo3 > j) {
                            j = O00000Oo3;
                        }
                        jSONArray.put(cdm.O00000oO());
                        if (jSONArray.toString().getBytes().length / 1024 > 50) {
                            break;
                        }
                        i++;
                    }
                    O000000o o000000o2 = new O000000o(jSONArray, j);
                    try {
                        String jSONArray2 = o000000o2.f13657O000000o.toString();
                        long j2 = o000000o2.O00000Oo;
                        Context O000000o3 = ccx.O000000o();
                        String O00000Oo4 = ccx.O00000Oo();
                        String O00000oo = ccx.O00000oo();
                        String O0000O0o = ccx.O0000O0o();
                        String O00000oO2 = ccs.O00000oO();
                        String str = Build.VERSION.RELEASE;
                        String O00000o2 = ccx.O00000o();
                        String O00000o02 = ccx.O00000o0();
                        String O00000o03 = this.O00000oO ? ccz.O00000o0(O000000o3) : ccz.O000000o(O000000o3);
                        String str2 = Build.MODEL;
                        long j3 = j2;
                        String valueOf = String.valueOf(cdi.O000000o().O00000Oo);
                        String valueOf2 = String.valueOf(cdi.O000000o().f13662O000000o);
                        String locale = Locale.getDefault().toString();
                        Context context = O000000o3;
                        String O00000oO3 = ccx.O00000oO();
                        try {
                            String O0000OOo = ccx.O0000OOo();
                            cdh.O000000o();
                            long O00000Oo5 = cdh.O00000Oo();
                            String str3 = O00000oo;
                            o000000o = new Stat.O000000o();
                            o000000o.f5067O000000o = O00000Oo4;
                            o000000o.O00000Oo = O00000oO2;
                            o000000o.O00000o0 = str;
                            o000000o.O00000o = "20";
                            o000000o.O00000oO = O00000o2;
                            o000000o.O00000oo = O00000o02;
                            o000000o.O0000O0o = O00000o03;
                            o000000o.O0000OOo = str2;
                            o000000o.O0000OoO = valueOf;
                            o000000o.O0000Ooo = valueOf2;
                            o000000o.O0000o0 = locale;
                            o000000o.O0000oO0 = Long.valueOf(O00000Oo5);
                            o000000o.O0000oOo = O00000oO3;
                            o000000o.O0000oo0 = O0000OOo;
                            o000000o.O0000o00 = O0000O0o;
                            O000000o2 = O000000o(jSONArray2);
                            o000000o.O0000oO = cdt.O000000o(str3, "1431ed34249f13de", "4def5eca70e41551");
                            Internal.checkElementsNotNull(O000000o2);
                            o000000o.O0000o0o = O000000o2;
                        } catch (Exception unused) {
                            f13655O000000o.set(false);
                        }
                        try {
                            if (!this.O00000oO) {
                                o000000o.O0000Oo0 = cdd.O00000o0(context);
                                o000000o.O0000Oo = cdd.O000000o(ccz.O00000Oo(context));
                            }
                            int size = O000000o2.size();
                            o000000o.O0000o0O = Integer.valueOf(size);
                            if (size > 0) {
                                Stat O000000o4 = o000000o.build();
                                cdc.O000000o("mUploadContent MiStat stat : " + O000000o4.toString(), (Throwable) null);
                                final long j4 = j3;
                                cdd.O000000o(ccs.O000000o() ? "http://agent.com/app/stat" : O00000o0, O000000o4, new cdd.O00000Oo() {
                                    /* class _m_j.cdf.AnonymousClass1 */

                                    /* JADX WARNING: Removed duplicated region for block: B:14:0x006c A[Catch:{ Exception -> 0x0072 }] */
                                    /* JADX WARNING: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
                                    public final void O000000o(String str) {
                                        boolean z;
                                        try {
                                            cdc.O000000o("mUploadContent MiStat result : ".concat(String.valueOf(str)), (Throwable) null);
                                            if (!TextUtils.isEmpty(str)) {
                                                JSONObject jSONObject = new JSONObject(str);
                                                String string = jSONObject.getString("status");
                                                if (jSONObject.has("data")) {
                                                    JSONObject jSONObject2 = jSONObject.getJSONObject("data");
                                                    if (jSONObject2.has("delay")) {
                                                        long j = jSONObject2.getLong("delay");
                                                        Context O000000o2 = ccx.O000000o();
                                                        cdh.O000000o();
                                                        cde.O00000Oo(O000000o2, "next_upload_ts", cdh.O00000Oo() + j);
                                                        cde.O00000Oo(ccx.O000000o(), "upload_delay", j);
                                                        cdc.O00000o0("update upload delay to ".concat(String.valueOf(j)));
                                                    }
                                                }
                                                if ("ok".equals(string)) {
                                                    z = true;
                                                    if (!z) {
                                                        cdf.O000000o(j4);
                                                        return;
                                                    }
                                                    return;
                                                }
                                            }
                                            z = false;
                                            if (!z) {
                                            }
                                        } catch (Exception e) {
                                            cdf.f13655O000000o.set(false);
                                            e.printStackTrace();
                                        }
                                    }
                                });
                                return;
                            }
                            f13655O000000o.set(false);
                        } catch (Exception unused2) {
                            f13655O000000o.set(false);
                        }
                    } catch (Exception unused3) {
                        f13655O000000o.set(false);
                    }
                } else {
                    f13655O000000o.set(false);
                }
            } else if (z) {
                cdc.O000000o(String.format("trigger uploading job with delay %d", 10000L));
                ccy.O000000o().O000000o(new O00000Oo(), 10000);
            }
        }
    }

    public class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public JSONArray f13657O000000o;
        public long O00000Oo;

        public O000000o(JSONArray jSONArray, long j) {
            this.f13657O000000o = jSONArray;
            this.O00000Oo = j;
        }
    }

    public class O00000Oo implements ccy.O000000o {
        public O00000Oo() {
        }

        public final void O000000o() {
            cdf.this.O000000o(false);
        }
    }

    public static boolean O000000o() {
        return f13655O000000o.get();
    }

    /* JADX WARNING: Removed duplicated region for block: B:71:0x0332 A[Catch:{ Exception -> 0x0385 }] */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x0335 A[SYNTHETIC] */
    private static List<Value> O000000o(String str) {
        JSONArray jSONArray;
        Value O000000o2;
        Value O000000o3;
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONArray jSONArray2 = new JSONArray(str);
                if (jSONArray2.length() > 0) {
                    int i = 0;
                    boolean z = false;
                    while (i < jSONArray2.length()) {
                        JSONObject jSONObject = new JSONObject((String) jSONArray2.get(i));
                        String optString = jSONObject.optString("category");
                        String optString2 = jSONObject.optString("dataJson");
                        Value value = null;
                        if ("mistat_session".equals(optString)) {
                            if (!TextUtils.isEmpty(optString2)) {
                                JSONObject jSONObject2 = new JSONObject(optString2);
                                Value_Session.O000000o o000000o = new Value_Session.O000000o();
                                o000000o.O00000Oo = Long.valueOf(jSONObject2.optLong("startTime"));
                                o000000o.O00000o0 = Long.valueOf(jSONObject2.optLong("endTime"));
                                o000000o.f5081O000000o = jSONObject2.optString("sessionId");
                                o000000o.O00000o = jSONObject2.optString("netWork");
                                Value_Session O000000o4 = o000000o.build();
                                Value.O000000o o000000o2 = new Value.O000000o();
                                o000000o2.O000000o(O000000o4);
                                O000000o3 = o000000o2.build();
                            }
                            jSONArray = jSONArray2;
                            if (value == null) {
                                arrayList.add(value);
                            }
                            i++;
                            jSONArray2 = jSONArray;
                        } else if ("mistat_page_tv".equals(optString)) {
                            if (!TextUtils.isEmpty(optString2)) {
                                JSONObject jSONObject3 = new JSONObject(optString2);
                                Value_Page.O000000o o000000o3 = new Value_Page.O000000o();
                                o000000o3.O00000Oo = Long.valueOf(jSONObject3.optLong("startTime"));
                                o000000o3.O00000o0 = Long.valueOf(jSONObject3.optLong("endTime"));
                                o000000o3.f5073O000000o = jSONObject3.optString("sessionId");
                                o000000o3.O00000o = jSONObject3.optString("pageId");
                                o000000o3.O00000oO = jSONObject3.optString("pageRef");
                                Value_Page O000000o5 = o000000o3.build();
                                Value.O000000o o000000o4 = new Value.O000000o();
                                o000000o4.O000000o(O000000o5);
                                O000000o3 = o000000o4.build();
                            }
                            jSONArray = jSONArray2;
                            if (value == null) {
                            }
                            i++;
                            jSONArray2 = jSONArray;
                        } else if ("mistat_view_click".equals(optString)) {
                            if (!TextUtils.isEmpty(optString2)) {
                                JSONObject jSONObject4 = new JSONObject(optString2);
                                Value_View_Click.O000000o o000000o5 = new Value_View_Click.O000000o();
                                o000000o5.f5085O000000o = jSONObject4.optString("sessionId");
                                o000000o5.O00000Oo = Long.valueOf(jSONObject4.optLong("timestamp"));
                                o000000o5.O00000o0 = jSONObject4.optString("viewId");
                                o000000o5.O00000o = jSONObject4.optString("label");
                                o000000o5.O00000oO = jSONObject4.optString("pageId");
                                Value_View_Click O000000o6 = o000000o5.build();
                                Value.O000000o o000000o6 = new Value.O000000o();
                                o000000o6.O000000o(O000000o6);
                                O000000o3 = o000000o6.build();
                            }
                            jSONArray = jSONArray2;
                            if (value == null) {
                            }
                            i++;
                            jSONArray2 = jSONArray;
                        } else if ("mistat_view_show".equals(optString)) {
                            if (!TextUtils.isEmpty(optString2)) {
                                JSONObject jSONObject5 = new JSONObject(optString2);
                                Value_View_Show.O000000o o000000o7 = new Value_View_Show.O000000o();
                                o000000o7.O00000o0 = Long.valueOf(jSONObject5.optLong("viewShowTime"));
                                o000000o7.O00000Oo = Long.valueOf(jSONObject5.optLong("viewLeaveTime"));
                                o000000o7.O00000o = Long.valueOf(jSONObject5.optLong("pageShowTime"));
                                o000000o7.f5087O000000o = jSONObject5.optString("sessionId");
                                o000000o7.O0000O0o = jSONObject5.optString("pageId");
                                o000000o7.O00000oO = jSONObject5.optString("viewId");
                                Value_View_Show O000000o7 = o000000o7.build();
                                Value.O000000o o000000o8 = new Value.O000000o();
                                o000000o8.O000000o(O000000o7);
                                O000000o3 = o000000o8.build();
                            }
                            jSONArray = jSONArray2;
                            if (value == null) {
                            }
                            i++;
                            jSONArray2 = jSONArray;
                        } else {
                            if ("mistat_stat_event".equals(optString)) {
                                value = O00000Oo(optString2);
                            } else if (!"mistat_start_up".equals(optString)) {
                                if (!"mistat_rn_download".equals(optString)) {
                                    jSONArray = jSONArray2;
                                    if ("mistat_rn_load_bundle".equals(optString)) {
                                        if (!TextUtils.isEmpty(optString2)) {
                                            JSONObject jSONObject6 = new JSONObject(optString2);
                                            Value_RN_LoadBundle.O000000o o000000o9 = new Value_RN_LoadBundle.O000000o();
                                            o000000o9.O00000oo = jSONObject6.optString("sessionId");
                                            o000000o9.O0000O0o = Long.valueOf(jSONObject6.optLong("timestamp"));
                                            String optString3 = jSONObject6.optString("data");
                                            if (!TextUtils.isEmpty(optString3)) {
                                                JSONObject jSONObject7 = new JSONObject(optString3);
                                                String optString4 = jSONObject7.optString("bundle_name");
                                                String optString5 = jSONObject7.optString("bundle_using_version");
                                                String optString6 = jSONObject7.optString("rn_version");
                                                long optLong = jSONObject7.optLong("instance_time");
                                                long optLong2 = jSONObject7.optLong("view_time");
                                                o000000o9.f5079O000000o = optString4;
                                                o000000o9.O00000Oo = optString5;
                                                o000000o9.O00000o0 = optString6;
                                                o000000o9.O00000o = Long.valueOf(optLong);
                                                o000000o9.O00000oO = Long.valueOf(optLong2);
                                            }
                                            Value_RN_LoadBundle O000000o8 = o000000o9.build();
                                            Value.O000000o o000000o10 = new Value.O000000o();
                                            o000000o10.O000000o(O000000o8);
                                            O000000o2 = o000000o10.build();
                                        }
                                    } else if ("mistat_rn_activity".equals(optString)) {
                                        value = O00000o0(optString2);
                                    } else if ("is_new_user".equals(optString)) {
                                        value = O00000o(optString2);
                                        z = true;
                                    }
                                    if (value == null) {
                                    }
                                    i++;
                                    jSONArray2 = jSONArray;
                                } else if (!TextUtils.isEmpty(optString2)) {
                                    JSONObject jSONObject8 = new JSONObject(optString2);
                                    Value_RN_Download.O000000o o000000o11 = new Value_RN_Download.O000000o();
                                    o000000o11.O0000Oo0 = jSONObject8.optString("sessionId");
                                    o000000o11.O0000Oo = Long.valueOf(jSONObject8.optLong("timestamp"));
                                    String optString7 = jSONObject8.optString("data");
                                    if (!TextUtils.isEmpty(optString7)) {
                                        JSONObject jSONObject9 = new JSONObject(optString7);
                                        String optString8 = jSONObject9.optString("bundle_name");
                                        String optString9 = jSONObject9.optString("bundle_download_version");
                                        String optString10 = jSONObject9.optString("bundle_using_version");
                                        String optString11 = jSONObject9.optString("rn_version");
                                        long optLong3 = jSONObject9.optLong("download_time");
                                        long optLong4 = jSONObject9.optLong("unzip_time");
                                        long optLong5 = jSONObject9.optLong("patch_time");
                                        long optLong6 = jSONObject9.optLong("md5_time");
                                        int optInt = jSONObject9.optInt("code");
                                        jSONArray = jSONArray2;
                                        String optString12 = jSONObject9.optString("error_message");
                                        o000000o11.f5077O000000o = optString8;
                                        o000000o11.O00000Oo = optString9;
                                        o000000o11.O00000o0 = optString10;
                                        o000000o11.O00000o = optString11;
                                        o000000o11.O00000oO = Long.valueOf(optLong3);
                                        o000000o11.O00000oo = Long.valueOf(optLong4);
                                        o000000o11.O0000O0o = Long.valueOf(optLong5);
                                        o000000o11.O0000OOo = Long.valueOf(optLong6);
                                        o000000o11.O0000OoO = Integer.valueOf(optInt);
                                        o000000o11.O0000Ooo = optString12;
                                    } else {
                                        jSONArray = jSONArray2;
                                    }
                                    Value_RN_Download O000000o9 = o000000o11.build();
                                    Value.O000000o o000000o12 = new Value.O000000o();
                                    o000000o12.O000000o(O000000o9);
                                    O000000o2 = o000000o12.build();
                                }
                                value = O000000o2;
                                if (value == null) {
                                }
                                i++;
                                jSONArray2 = jSONArray;
                            } else if (!TextUtils.isEmpty(optString2)) {
                                JSONObject jSONObject10 = new JSONObject(optString2);
                                Value_Startup.O000000o o000000o13 = new Value_Startup.O000000o();
                                o000000o13.f5083O000000o = jSONObject10.optString("sessionId");
                                o000000o13.O00000o0 = jSONObject10.optString("resolution");
                                o000000o13.O00000o = Long.valueOf(jSONObject10.optLong("startTime"));
                                o000000o13.O00000Oo = jSONObject10.optString("network");
                                Value_Startup O000000o10 = o000000o13.build();
                                Value.O000000o o000000o14 = new Value.O000000o();
                                o000000o14.O000000o(O000000o10);
                                O000000o3 = o000000o14.build();
                            }
                            jSONArray = jSONArray2;
                            if (value == null) {
                            }
                            i++;
                            jSONArray2 = jSONArray;
                        }
                        value = O000000o3;
                        jSONArray = jSONArray2;
                        if (value == null) {
                        }
                        i++;
                        jSONArray2 = jSONArray;
                    }
                    if (!z) {
                        EventExtraData.O000000o o000000o15 = new EventExtraData.O000000o();
                        o000000o15.f5065O000000o = "";
                        o000000o15.O00000Oo = "";
                        o000000o15.O00000o0 = "string";
                        EventExtraData O000000o11 = o000000o15.build();
                        ArrayList arrayList2 = new ArrayList();
                        arrayList2.add(O000000o11);
                        Value_Event.O000000o o000000o16 = new Value_Event.O000000o();
                        o000000o16.O00000Oo = Long.valueOf(System.currentTimeMillis() / 1000);
                        o000000o16.O00000o0 = "extraContextEvent";
                        arrayList.add(new Value.O000000o().O000000o(o000000o16.O000000o(arrayList2).build()).build());
                    }
                }
            } catch (Exception e) {
                f13655O000000o.set(false);
                e.printStackTrace();
            }
        }
        return arrayList;
    }

    private static Value O00000Oo(String str) throws JSONException {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject(str);
        Value_Event.O000000o o000000o = new Value_Event.O000000o();
        o000000o.O00000Oo = Long.valueOf(jSONObject.optLong("timestamp"));
        o000000o.f5071O000000o = jSONObject.optString("sessionId");
        o000000o.O00000o0 = jSONObject.optString("eventId");
        o000000o.O00000oo = jSONObject.optString("pageId");
        o000000o.O00000o = jSONObject.optString("label");
        String optString = jSONObject.optString("data");
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(optString)) {
            JSONArray jSONArray = new JSONArray(optString);
            if (jSONArray.length() > 0) {
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject optJSONObject = jSONArray.optJSONObject(i);
                    EventExtraData.O000000o o000000o2 = new EventExtraData.O000000o();
                    o000000o2.f5065O000000o = optJSONObject.optString("key");
                    o000000o2.O00000o0 = optJSONObject.optString("type");
                    o000000o2.O00000Oo = optJSONObject.optString("value");
                    arrayList.add(o000000o2.build());
                }
            }
        }
        o000000o.O000000o(arrayList);
        Value_Event O000000o2 = o000000o.build();
        Value.O000000o o000000o3 = new Value.O000000o();
        o000000o3.O000000o(O000000o2);
        return o000000o3.build();
    }

    private static Value O00000o0(String str) throws JSONException {
        long j;
        long j2;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject(str);
        Value_RN_Activity.O000000o o000000o = new Value_RN_Activity.O000000o();
        o000000o.O0000OoO = jSONObject.optString("sessionId");
        o000000o.O0000Ooo = Long.valueOf(jSONObject.optLong("timestamp"));
        String optString = jSONObject.optString("data");
        if (!TextUtils.isEmpty(optString)) {
            JSONObject jSONObject2 = new JSONObject(optString);
            String optString2 = jSONObject2.optString("bundle_name");
            String optString3 = jSONObject2.optString("bundle_using_version");
            String optString4 = jSONObject2.optString("rn_version");
            String optString5 = jSONObject2.optString("rn_info");
            long optLong = jSONObject2.optLong("onCreate_time");
            long optLong2 = jSONObject2.optLong("onStart_time");
            long optLong3 = jSONObject2.optLong("onResume_time");
            long optLong4 = jSONObject2.optLong("constructor_time");
            long optLong5 = jSONObject2.optLong("componentWillMount_time");
            JSONArray optJSONArray = jSONObject2.optJSONArray("render_time");
            long j3 = optLong5;
            long optLong6 = jSONObject2.optLong("componentDidMount_time");
            long optLong7 = jSONObject2.optLong("init_time");
            long optLong8 = jSONObject2.optLong("total_load_time");
            ArrayList arrayList = new ArrayList();
            if (optJSONArray == null || optJSONArray.length() <= 0) {
                j = optLong4;
                j2 = optLong8;
            } else {
                j = optLong4;
                j2 = optLong8;
                for (int i = 0; i < optJSONArray.length(); i++) {
                    Long valueOf = Long.valueOf(optJSONArray.optLong(i));
                    arrayList.add(valueOf);
                    cdc.O000000o("Upload getRNActivityByContent  rederTimes   : ".concat(String.valueOf(valueOf)), (Throwable) null);
                }
            }
            o000000o.f5075O000000o = optString2;
            o000000o.O00000Oo = optString3;
            o000000o.O00000o0 = optString4;
            o000000o.O0000o0O = optString5;
            o000000o.O00000o = Long.valueOf(optLong);
            o000000o.O00000oO = Long.valueOf(optLong2);
            o000000o.O00000oo = Long.valueOf(optLong3);
            o000000o.O0000O0o = Long.valueOf(j);
            o000000o.O0000OOo = Long.valueOf(j3);
            Internal.checkElementsNotNull(arrayList);
            o000000o.O0000Oo0 = arrayList;
            o000000o.O0000Oo = Long.valueOf(optLong6);
            o000000o.O0000o00 = Long.valueOf(optLong7);
            o000000o.O0000o0 = Long.valueOf(j2);
        }
        Value_RN_Activity O000000o2 = o000000o.build();
        Value.O000000o o000000o2 = new Value.O000000o();
        o000000o2.O000000o(O000000o2);
        return o000000o2.build();
    }

    private static Value O00000o(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            String string = jSONObject.getString("eventId");
            JSONObject jSONObject2 = new JSONObject(jSONObject.optString("data"));
            EventExtraData.O000000o o000000o = new EventExtraData.O000000o();
            o000000o.f5065O000000o = jSONObject2.optString("key");
            o000000o.O00000Oo = jSONObject2.optString("value");
            o000000o.O00000o0 = jSONObject2.optString("type");
            EventExtraData O000000o2 = o000000o.build();
            ArrayList arrayList = new ArrayList();
            arrayList.add(O000000o2);
            Value_Event.O000000o o000000o2 = new Value_Event.O000000o();
            o000000o2.O00000Oo = Long.valueOf(System.currentTimeMillis() / 1000);
            o000000o2.O00000o0 = string;
            return new Value.O000000o().O000000o(o000000o2.O000000o(arrayList).build()).build();
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void O000000o(long j) {
        cdc.O000000o("Upload MiStat  doDeleting   :  endTS ".concat(String.valueOf(j)), (Throwable) null);
        new cda();
        cda.O000000o(j);
        f13655O000000o.set(false);
    }

    public static long O00000Oo() {
        return cde.O000000o(ccx.O000000o(), "upload_delay", (long) DashMediaSource.DEFAULT_LIVE_PRESENTATION_DELAY_FIXED_MS);
    }
}
