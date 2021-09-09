package _m_j;

import _m_j.iit;
import _m_j.ikn;
import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Base64;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.ximalaya.ting.android.opensdk.httputil.XimalayaException;
import com.ximalaya.ting.android.opensdk.model.advertis.Advertis;
import com.ximalaya.ting.android.opensdk.model.advertis.AdvertisList;
import com.ximalaya.ting.android.opensdk.model.track.Track;
import com.ximalaya.ting.android.opensdk.player.advertis.OpenSdkAdsDataHandler$4$1;
import com.ximalaya.ting.android.opensdk.player.advertis.OpenSdkAdsDataHandler$4$2;
import com.ximalaya.ting.android.opensdk.player.advertis.OpenSdkAdsDataHandler$5$1;
import com.ximalaya.ting.android.opensdk.player.service.XmPlayerService;
import com.ximalaya.ting.android.opensdk.util.NetworkType;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class ikj implements ikg {

    /* renamed from: O000000o  reason: collision with root package name */
    public static boolean f1389O000000o = false;
    public static int O0000OoO = 600000;
    private static ikj O0000Ooo;
    private static String O0000o00;
    public O000000o O00000Oo;
    public boolean O00000o = true;
    public boolean O00000o0 = false;
    public long O00000oO;
    public O00000Oo O00000oo;
    public String O0000O0o;
    public boolean O0000OOo;
    public List<String> O0000Oo;
    public boolean O0000Oo0 = false;
    private long O0000o0 = 0;

    private ikj() {
    }

    class O00000Oo {

        /* renamed from: O000000o  reason: collision with root package name */
        long f1399O000000o;
        iiw<AdvertisList> O00000Oo;
        boolean O00000o0;

        private O00000Oo() {
            this.O00000o0 = true;
        }

        /* synthetic */ O00000Oo(ikj ikj, byte b) {
            this();
        }
    }

    public final String O000000o(Track track, Map<String, String> map, iiw<AdvertisList> iiw) {
        List<String> list;
        int i;
        this.O0000OOo = true;
        ilk.O000000o("OpenSdkAdsDataHandler  == 1");
        try {
            this.O00000oO = Long.parseLong(map.get("trackId"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (XmPlayerService.getPlayerSrvice() != null) {
            float f = XmPlayerService.getPlayerSrvice().getPlayControl().O0000oOo;
            if (Float.compare(f, 0.8f) <= 0) {
                i = 0;
            } else {
                i = Float.compare(f, 1.4f) >= 0 ? 2 : 1;
            }
            ilk.O000000o("OpenSdkAdsDataHandler  == 2");
            map.put("playSpeed", String.valueOf(i));
        }
        this.O00000oo = new O00000Oo(this, (byte) 0);
        O00000Oo o00000Oo = this.O00000oo;
        o00000Oo.f1399O000000o = this.O00000oO;
        o00000Oo.O00000Oo = iiw;
        final String str = map.get("playMethod");
        final long j = this.O00000oO;
        if (XmPlayerService.getPlayerSrvice() != null) {
            this.O0000O0o = XmPlayerService.getPlayerSrvice().getTrackUrl(track);
            String str2 = this.O0000O0o;
            if (str2 == null || !str2.startsWith("http")) {
                if (this.O00000oO > 0) {
                    this.O0000OOo = true;
                } else {
                    this.O0000OOo = false;
                }
            }
        }
        if (!this.O0000OOo) {
            iiw.O000000o(null);
            return null;
        }
        if (!this.O00000o0) {
            ilk.O000000o("OpenSdkAdsDataHandler  == 3");
            final String str3 = str;
            final iiw<AdvertisList> iiw2 = iiw;
            final Map<String, String> map2 = map;
            iit.O000000o("http://api.ximalaya.com/openapi-gateway-app/app/config", null, new iiw<O000000o>() {
                /* class _m_j.ikj.AnonymousClass1 */

                public final /* synthetic */ void O000000o(Object obj) {
                    O000000o o000000o = (O000000o) obj;
                    ikj ikj = ikj.this;
                    ikj.O00000Oo = o000000o;
                    if (ikj.O00000oO == j) {
                        if (o000000o != null) {
                            if (o000000o.O00000o0 != null) {
                                ikj.this.O0000Oo0 = o000000o.O00000o0.O00000Oo;
                                ikj.f1389O000000o = !o000000o.O00000o0.f1397O000000o && !o000000o.O00000o0.O00000Oo && !o000000o.O00000o0.O00000o0;
                            }
                            ikj.this.O00000o = o000000o.O00000Oo;
                            if (o000000o.O00000oo != null) {
                                ikj.this.O0000Oo = Arrays.asList(o000000o.O00000oo.split(","));
                            }
                            ikj.O0000OoO = o000000o.O00000oO * 1000;
                            if (!TextUtils.isEmpty(ikj.this.O0000O0o)) {
                                if (ikj.this.O0000Oo.contains(Uri.parse(ikj.this.O0000O0o).getHost())) {
                                    ikj.this.O0000OOo = true;
                                } else {
                                    ikj.this.O0000OOo = false;
                                }
                            }
                            try {
                                if (!ikj.this.O0000OOo) {
                                    iiw2.O000000o(null);
                                } else if (!o000000o.O00000Oo) {
                                    ilk.O000000o("OpenSdkAdsDataHandler  == 6   ");
                                    iiw2.O000000o(ikj.this.O000000o((AdvertisList) null, (String) map2.get("duringPlay"), str3));
                                } else if ("4".equals(str3)) {
                                    iiw2.O000000o(ikj.this.O000000o((AdvertisList) null, (String) map2.get("duringPlay"), str3));
                                    return;
                                } else {
                                    iit.O0000OoO(map2, new iiw<AdvertisList>() {
                                        /* class _m_j.ikj.AnonymousClass1.AnonymousClass1 */

                                        public final /* synthetic */ void O000000o(Object obj) {
                                            AdvertisList advertisList = (AdvertisList) obj;
                                            if (ikj.this.O00000oO == j) {
                                                if (!(advertisList == null || advertisList.f12169O000000o == null)) {
                                                    for (int i = 0; i < advertisList.f12169O000000o.size(); i++) {
                                                        advertisList.f12169O000000o.get(i).O0000o = ikj.this.O00000oO;
                                                    }
                                                }
                                                if (!(advertisList == null || advertisList.f12169O000000o == null)) {
                                                    ikj.this.O00000oo.O00000o0 = false;
                                                }
                                                iiw2.O000000o(ikj.this.O000000o(advertisList, (String) map2.get("duringPlay"), str3));
                                            }
                                        }

                                        public final void O000000o(int i, String str) {
                                            if (ikj.this.O00000oO == j) {
                                                iiw2.O000000o(i, str);
                                            }
                                        }
                                    });
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                                ilk.O000000o("OpenSdkAdsDataHandler  == 7   ");
                                iiw2.O000000o(ikj.this.O000000o((AdvertisList) null, (String) map2.get("duringPlay"), str3));
                            }
                        } else {
                            ilk.O000000o("OpenSdkAdsDataHandler  == 8   ");
                            iiw2.O000000o(ikj.this.O000000o((AdvertisList) null, (String) map2.get("duringPlay"), str3));
                        }
                        ikj.this.O00000o0 = true;
                    }
                }

                public final void O000000o(int i, String str) {
                    if (ikj.this.O00000oO == j) {
                        ikj.this.O00000o0 = true;
                        ilk.O000000o("OpenSdkAdsDataHandler  == 9   ");
                        iiw2.O000000o(ikj.this.O000000o((AdvertisList) null, (String) map2.get("duringPlay"), str3));
                    }
                }
            }, new iit.O000000o<O000000o>() {
                /* class _m_j.ikj.AnonymousClass2 */

                public final /* synthetic */ Object O000000o(String str) throws Exception {
                    return (O000000o) new Gson().fromJson(str, O000000o.class);
                }
            });
        } else {
            if (!TextUtils.isEmpty(this.O0000O0o) && (list = this.O0000Oo) != null) {
                if (list.contains(Uri.parse(this.O0000O0o).getHost())) {
                    this.O0000OOo = true;
                } else {
                    this.O0000OOo = false;
                }
            }
            if (!this.O0000OOo) {
                iiw.O000000o(null);
            } else if (!this.O00000o) {
                iiw.O000000o(O000000o((AdvertisList) null, map.get("duringPlay"), str));
            } else if ("4".equals(str)) {
                iiw.O000000o(O000000o((AdvertisList) null, map.get("duringPlay"), str));
                return null;
            } else {
                final iiw<AdvertisList> iiw3 = iiw;
                final Map<String, String> map3 = map;
                iit.O0000OoO(map, new iiw<AdvertisList>() {
                    /* class _m_j.ikj.AnonymousClass3 */

                    public final /* synthetic */ void O000000o(Object obj) {
                        AdvertisList advertisList = (AdvertisList) obj;
                        if (ikj.this.O00000oO == j) {
                            ilk.O000000o("OpenSdkAdsDataHandler  == 10   ");
                            if (!(advertisList == null || advertisList.f12169O000000o == null)) {
                                for (int i = 0; i < advertisList.f12169O000000o.size(); i++) {
                                    advertisList.f12169O000000o.get(i).O0000o = ikj.this.O00000oO;
                                }
                            }
                            if (!(advertisList == null || advertisList.f12169O000000o == null)) {
                                ikj.this.O00000oo.O00000o0 = false;
                            }
                            iiw3.O000000o(ikj.this.O000000o(advertisList, (String) map3.get("duringPlay"), str));
                        }
                    }

                    public final void O000000o(int i, String str) {
                        if (ikj.this.O00000oO == j) {
                            ilk.O000000o("OpenSdkAdsDataHandler  == 11   ");
                            iiw3.O000000o(i, str);
                        }
                    }
                });
            }
        }
        return null;
    }

    @SuppressLint({"StaticFieldLeak"})
    public final void O000000o(final ikn.O00000o0 o00000o0) {
        if (o00000o0 != null && o00000o0.O00000o0 != null && o00000o0.O00000o0.f12169O000000o != null && o00000o0.O00000o0.f12169O000000o.size() > 0 && o00000o0.O00000o0.f12169O000000o.get(0) != null) {
            if (o00000o0.O00000o0.f12169O000000o.get(0).O00000Oo > 0 && !TextUtils.isEmpty(o00000o0.O00000o0.f12169O000000o.get(0).O000000o()) && !"null".equals(o00000o0.O00000o0.f12169O000000o.get(0).O000000o())) {
                new iln<Void, Void, Void>() {
                    /* class _m_j.ikj.AnonymousClass4 */

                    /* access modifiers changed from: protected */
                    public final /* synthetic */ Object doInBackground(Object[] objArr) {
                        return O000000o();
                    }

                    /* access modifiers changed from: protected */
                    public final /* bridge */ /* synthetic */ void onPostExecute(Object obj) {
                        super.onPostExecute((Void) obj);
                    }

                    private Void O000000o() {
                        String str;
                        Advertis advertis = o00000o0.O00000o0.f12169O000000o.get(0);
                        if (XmPlayerService.getPlayerSrvice() != null) {
                            if (advertis.O000OOo0 != null) {
                                for (String O000000o2 : advertis.O000OOo0) {
                                    ikf.O000000o(XmPlayerService.getPlayerSrvice()).O000000o(O000000o2);
                                }
                            }
                            if (advertis.O000OOo != null) {
                                for (String O000000o3 : advertis.O000OOo) {
                                    ikf.O000000o(XmPlayerService.getPlayerSrvice()).O000000o(O000000o3);
                                }
                            }
                            ikf.O000000o(XmPlayerService.getPlayerSrvice()).O000000o(advertis.O0000Oo0);
                        }
                        iko iko = new iko();
                        iko.f1415O000000o = System.currentTimeMillis();
                        iko.O00000Oo = o00000o0.f1414O000000o.f12166O000000o;
                        iko.O00000o = (long) advertis.O00000Oo;
                        iko.O00000oO = o00000o0.O00000o0.O00000oO;
                        iit.O000000o();
                        iko.O0000Oo = iit.O00000oo();
                        iko.O00000o0 = ikj.O000000o(XmPlayerService.getPlayerSrvice());
                        iko.O00000oo = advertis.O0000oo;
                        iko.O0000Ooo = -2;
                        String str2 = "";
                        if (advertis.O000O0OO == null) {
                            str = str2;
                        } else {
                            str = advertis.O000O0OO;
                        }
                        iko.O0000OOo = str;
                        if (advertis.O000O0Oo != null) {
                            str2 = advertis.O000O0Oo;
                        }
                        iko.O0000Oo0 = str2;
                        try {
                            iko.O0000OoO = iit.O000000o().O00000Oo();
                        } catch (XimalayaException e) {
                            e.printStackTrace();
                        }
                        if (!TextUtils.isEmpty(advertis.O000O00o)) {
                            try {
                                iko.O0000O0o = new String(ikk.O000000o(advertis.O000O00o));
                            } catch (Exception e2) {
                                e2.printStackTrace();
                            }
                        }
                        ikl ikl = new ikl();
                        ikl.O00000o0 = iko;
                        ikl.f1402O000000o = System.currentTimeMillis();
                        new ikm().f1403O000000o = new OpenSdkAdsDataHandler$4$1(this, ikl);
                        iit.O000000o(new OpenSdkAdsDataHandler$4$2(this, iko));
                        return null;
                    }
                }.O000000o(new Void[0]);
            } else if (o00000o0.O00000o0.f12169O000000o.get(0).O00000Oo == -1) {
                new iln<Void, Void, Void>() {
                    /* class _m_j.ikj.AnonymousClass5 */

                    /* access modifiers changed from: protected */
                    public final /* synthetic */ Object doInBackground(Object[] objArr) {
                        return O000000o();
                    }

                    private Void O000000o() {
                        Advertis advertis = o00000o0.O00000o0.f12169O000000o.get(0);
                        if (advertis == null) {
                            return null;
                        }
                        ikr ikr = new ikr();
                        try {
                            ikr.f1418O000000o = iit.O000000o().O00000Oo();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        String str = "front";
                        if (advertis.O000OO != 1) {
                            if (advertis.O000OO == 2) {
                                str = "middle";
                            } else if (advertis.O000OO == 3) {
                                str = "end";
                            }
                        }
                        ikr.O00000Oo = str;
                        ikr.O0000Ooo = advertis.O000000o();
                        iit.O000000o();
                        ikr.O00000o0 = iit.O00000oo();
                        ikr.O00000o = System.currentTimeMillis();
                        int O00000o0 = NetworkType.O00000o0(iit.O000000o().f1325O000000o);
                        try {
                            ikr.O00000oO = URLEncoder.encode(O00000o0 == 0 ? "移动" : O00000o0 == 1 ? "联通" : O00000o0 == 2 ? "电信" : "其他", "UTF-8");
                        } catch (UnsupportedEncodingException e2) {
                            e2.printStackTrace();
                        }
                        try {
                            ikr.O00000oo = iit.O000000o().O00000o();
                        } catch (XimalayaException e3) {
                            e3.printStackTrace();
                        }
                        ikr.O0000O0o = "android";
                        try {
                            ikr.O0000OOo = URLEncoder.encode(Build.MODEL, "UTF-8");
                        } catch (UnsupportedEncodingException e4) {
                            e4.printStackTrace();
                        }
                        try {
                            ikr.O0000Oo0 = URLEncoder.encode(iit.O000000o().O00000o0(), "UTF-8");
                        } catch (UnsupportedEncodingException e5) {
                            e5.printStackTrace();
                        }
                        ikr.O0000Oo = NetworkType.O000000o(iit.O000000o().f1325O000000o).getName();
                        ikr.O0000OoO = "android";
                        ikp ikp = new ikp();
                        ikp.O00000Oo = ikr;
                        ikp.f1416O000000o = System.currentTimeMillis();
                        ikq ikq = new ikq();
                        ikq.f1417O000000o = new OpenSdkAdsDataHandler$5$1(this, ikp);
                        iit.O000000o(ikq);
                        return null;
                    }
                }.O000000o(new Void[0]);
            }
        }
    }

    public static String O000000o(Context context) {
        if (!TextUtils.isEmpty(O0000o00)) {
            return O0000o00;
        }
        if (context != null) {
            O0000o00 = Settings.Secure.getString(context.getContentResolver(), "android_id");
        }
        String str = O0000o00;
        if (str == null || str.equalsIgnoreCase("android_id") || O0000o00.equalsIgnoreCase("9774d56d682e549c")) {
            O0000o00 = "undefined";
        }
        return O0000o00;
    }

    static class O000000o extends iix {
        @SerializedName("app_name")

        /* renamed from: O000000o  reason: collision with root package name */
        public String f1396O000000o;
        @SerializedName("ea")
        public boolean O00000Oo;
        @SerializedName("brand_ad_url")
        public O00000Oo O00000o;
        @SerializedName("ad_location")
        public C0005O000000o O00000o0;
        @SerializedName("brand_ad_interval")
        public int O00000oO = 300;
        @SerializedName("audio_url_prefix")
        public String O00000oo;

        /* renamed from: _m_j.ikj$O000000o$O000000o  reason: collision with other inner class name */
        class C0005O000000o {

            /* renamed from: O000000o  reason: collision with root package name */
            public boolean f1397O000000o;
            public boolean O00000Oo;
            public boolean O00000o0;
        }

        class O00000Oo {

            /* renamed from: O000000o  reason: collision with root package name */
            public String f1398O000000o;
            public String O00000Oo;
            public String O00000o0;
        }

        O000000o() {
        }
    }

    public final void O000000o() {
        O0000Ooo.O00000o0 = false;
    }

    public final void O000000o(int i, int i2) {
        if ((i2 / 2) / 1000 == i / 1000) {
            O00000Oo o00000Oo = this.O00000oo;
            if (((o00000Oo != null && !o00000Oo.O00000o0) || this.O0000Oo0) && System.currentTimeMillis() - this.O0000o0 > ((long) O0000OoO) && !f1389O000000o && this.O0000OOo) {
                O00000Oo o00000Oo2 = this.O00000oo;
                if (o00000Oo2 != null) {
                    o00000Oo2.O00000o0 = true;
                }
                XmPlayerService.getPlayerSrvice().pausePlay();
                O00000Oo o00000Oo3 = this.O00000oo;
                if (o00000Oo3 != null) {
                    o00000Oo3.O00000Oo.O000000o(O000000o((AdvertisList) null, "false", 2));
                }
            }
        }
    }

    public final AdvertisList O000000o(AdvertisList advertisList, String str, String str2) {
        return O000000o(advertisList, str, "4".equals(str2) ? 3 : 1);
    }

    private AdvertisList O000000o(AdvertisList advertisList, String str, int i) {
        Advertis advertis;
        boolean equals = "true".equals(str);
        if ((System.currentTimeMillis() - this.O0000o0 > ((long) O0000OoO) && !f1389O000000o && this.O00000oO >= 0 && ((i == 1 || i == 3) && (advertisList == null || advertisList.f12169O000000o == null || advertisList.f12169O000000o.size() == 0))) || i == 2) {
            this.O0000o0 = System.currentTimeMillis();
            if (advertisList == null) {
                advertisList = new AdvertisList();
                advertisList.O00000Oo = 0;
            }
            Advertis advertis2 = new Advertis();
            advertis2.O00000Oo = -1;
            advertis2.O000OO = i;
            String str2 = new String(Base64.decode("aHR0cDovL2ZkZnMueG1jZG4uY29tL2dyb3VwMjYvTTA5L0RDLzMxL3dLZ0pXRmpjcVhIU0xUTF9BQUFfOVR3aEFVRTIxMy5tcDM=", 0));
            O000000o o000000o = this.O00000Oo;
            if (o000000o != null) {
                if (i == 1) {
                    str2 = (o000000o.O00000o == null || TextUtils.isEmpty(this.O00000Oo.O00000o.f1398O000000o)) ? new String(Base64.decode("aHR0cDovL2ZkZnMueG1jZG4uY29tL2dyb3VwNDEvTTA3LzVGLzBCL3dLZ0o4VnM1d3ptVHU1QUtBQVBkZk9jYjdMSTczOC5tcDM=", 0)) : this.O00000Oo.O00000o.f1398O000000o;
                } else if (i == 2) {
                    str2 = (o000000o.O00000o == null || TextUtils.isEmpty(this.O00000Oo.O00000o.O00000Oo)) ? new String(Base64.decode("aHR0cDovL2ZkZnMueG1jZG4uY29tL2dyb3VwMjYvTTA5L0RDLzMxL3dLZ0pXRmpjcVhIU0xUTF9BQUFfOVR3aEFVRTIxMy5tcDM=", 0)) : this.O00000Oo.O00000o.O00000Oo;
                } else if (i == 3) {
                    str2 = (o000000o.O00000o == null || TextUtils.isEmpty(this.O00000Oo.O00000o.O00000o0)) ? new String(Base64.decode("aHR0cDovL2ZkZnMueG1jZG4uY29tL2dyb3VwMjYvTTA5L0RDLzMxL3dLZ0pXRmpjcVhIU0xUTF9BQUFfOVR3aEFVRTIxMy5tcDM", 0)) : this.O00000Oo.O00000o.O00000o0;
                }
            }
            advertis2.O0000OOo = str2;
            if (advertisList.f12169O000000o == null) {
                advertisList.f12169O000000o = new ArrayList();
            }
            advertisList.f12169O000000o.add(advertis2);
        }
        if (advertisList == null) {
            advertisList = new AdvertisList();
        }
        advertisList.O00000oo = equals;
        if (!(advertisList.f12169O000000o == null || advertisList.f12169O000000o.size() <= 0 || (advertis = advertisList.f12169O000000o.get(0)) == null)) {
            List<String> list = advertis.O00oOooO;
            if (list != null && list.size() > 0) {
                advertis.O000O00o = list.remove(0);
            }
            advertis.O0000oo0 = equals;
        }
        return advertisList;
    }
}
