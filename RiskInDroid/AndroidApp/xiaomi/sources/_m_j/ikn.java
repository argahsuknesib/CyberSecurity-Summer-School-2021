package _m_j;

import _m_j.ijk;
import _m_j.iki;
import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.ximalaya.ting.android.opensdk.model.advertis.Advertis;
import com.ximalaya.ting.android.opensdk.model.advertis.AdvertisList;
import com.ximalaya.ting.android.opensdk.model.track.Track;
import com.ximalaya.ting.android.opensdk.player.service.XmPlayerService;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public final class ikn {
    public static boolean O0000OOo = false;
    private static byte[] O0000Oo = new byte[0];
    private static volatile ikn O0000Oo0;

    /* renamed from: O000000o  reason: collision with root package name */
    public ikh f1404O000000o;
    public List<String> O00000Oo = new CopyOnWriteArrayList();
    public boolean O00000o = false;
    public iki O00000o0;
    public O00000o0 O00000oO;
    public ikg O00000oo;
    public boolean O0000O0o = false;
    private Context O0000OoO;
    private String O0000Ooo;
    private AdvertisList O0000o0;
    private long O0000o00 = -1;
    private long O0000o0O;
    private Map<String, List<iiw<String>>> O0000o0o = new ConcurrentHashMap();

    public interface O000000o {
        boolean O000000o();
    }

    public interface O00000Oo {
        void O000000o(boolean z);
    }

    public static ikn O000000o(Context context) {
        String str;
        if (O0000Oo0 == null) {
            synchronized (O0000Oo) {
                if (O0000Oo0 == null) {
                    O0000Oo0 = new ikn(context);
                    if (context != null) {
                        if ("mounted".equals(Environment.getExternalStorageState())) {
                            str = Environment.getExternalStorageDirectory().getPath() + "/Android/data/" + context.getPackageName() + "/files/ads";
                        } else {
                            str = context.getFilesDir().getPath() + "/ads";
                        }
                        try {
                            ilj.O000000o(new File(str));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
        return O0000Oo0;
    }

    public final boolean O000000o() {
        iki iki = this.O00000o0;
        if (iki != null) {
            if (iki.O00000o == 2) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x00c4  */
    /* JADX WARNING: Removed duplicated region for block: B:38:? A[RETURN, SYNTHETIC] */
    public final void O00000Oo() {
        Advertis advertis;
        int i;
        if (this.O00000o0 != null) {
            ilk.O000000o("playAd 0:" + System.currentTimeMillis());
            iki iki = this.O00000o0;
            try {
                if (iki.O00000oO == null || iki.O00000oO.O0000Oo == 0) {
                    iki.O000000o(1.0f, 1.0f);
                } else {
                    float f = ((float) iki.O00000oO.O0000Oo) / 100.0f;
                    iki.O000000o(f, f);
                }
                ilk.O000000o("playAd 1:" + System.currentTimeMillis());
                if (!(iki.O00000o == 1 || iki.O00000o == 3)) {
                    if (iki.O00000o != 5) {
                        if (iki.O00000o == 4) {
                            ilk.O000000o("playAd 3:" + System.currentTimeMillis());
                            iki.f1386O000000o.prepare();
                            iki.f1386O000000o.start();
                            iki.O00000o = 2;
                        }
                        advertis = this.O00000o0.O00000oO;
                        if (advertis == null) {
                            iki iki2 = this.O00000o0;
                            int i2 = iki2.O00000o;
                            if (i2 == 1 || i2 == 2 || i2 == 3 || i2 == 4 || i2 == 5) {
                                i = iki2.f1386O000000o.getDuration();
                            } else {
                                i = 0;
                            }
                            advertis.O000O0o = (long) i;
                            ikh ikh = this.f1404O000000o;
                            if (ikh != null) {
                                ikh.O000000o(advertis, 0);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                }
                ilk.O000000o("playAd 2:" + System.currentTimeMillis());
                iki.f1386O000000o.start();
                iki.O00000o = 2;
                iki.O000000o o000000o = iki.O00000o0;
            } catch (Exception e) {
                ilk.O000000o("playAd 4:" + System.currentTimeMillis());
                e.printStackTrace();
                iki.O00000o = -1;
            }
            advertis = this.O00000o0.O00000oO;
            if (advertis == null) {
            }
        }
    }

    public class O00000o0 {

        /* renamed from: O000000o  reason: collision with root package name */
        public Track f1414O000000o;
        public boolean O00000Oo;
        public O00000Oo O00000o;
        public AdvertisList O00000o0;
        public O00000Oo O00000oO;
        public O000000o O00000oo;
        public int O0000O0o = 0;

        public O00000o0() {
        }
    }

    public final void O000000o(Track track, int i, O00000Oo o00000Oo, boolean z) {
        if (!z) {
            O00000o0();
            this.O00000o = true;
        }
        O00000o0 o00000o0 = new O00000o0();
        o00000o0.f1414O000000o = track;
        o00000o0.O00000o = o00000Oo;
        this.O00000oO = o00000o0;
        this.O0000O0o = z;
        O000000o(this.O00000oO, i, z);
    }

    public final synchronized void O00000o0() {
        if (this.O00000oO != null) {
            this.O00000oO.O00000Oo = true;
            this.O00000oO.O00000o = null;
            this.O00000oO.O00000oO = null;
            this.O00000oO.O00000oo = null;
            this.O00000oO.O0000O0o = 0;
            if (XmPlayerService.getPlayerSrvice() != null) {
                XmPlayerService.getPlayerSrvice().setPlayStartCallback(null);
            }
        }
        if (this.O00000o0 != null) {
            this.O00000o0.O00000Oo();
        }
        this.O00000o = false;
    }

    private ikn(Context context) {
        this.O0000OoO = context.getApplicationContext();
        File file = new File(ilj.O000000o(this.O0000OoO, ""));
        if (!file.exists()) {
            file.mkdirs();
        }
        String[] list = file.list();
        if (list != null && list.length != 0) {
            this.O00000Oo.clear();
            this.O00000Oo.addAll(Arrays.asList(list));
        }
    }

    public final boolean O000000o(String str) {
        File file = new File(ilj.O000000o(this.O0000OoO, str));
        if (file.exists()) {
            return file.delete();
        }
        return false;
    }

    public final String O00000Oo(String str) {
        Context context = this.O0000OoO;
        return ilj.O000000o(context, ili.O000000o(str) + O00000o0(str));
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ikn.O000000o(boolean, _m_j.ikn$O00000o0, boolean):boolean
     arg types: [int, _m_j.ikn$O00000o0, int]
     candidates:
      _m_j.ikn.O000000o(_m_j.ikn$O00000o0, int, boolean):void
      _m_j.ikn.O000000o(_m_j.ikn$O00000o0, boolean, int):void
      _m_j.ikn.O000000o(boolean, _m_j.ikn$O00000o0, boolean):boolean */
    private synchronized void O000000o(final O00000o0 o00000o0, int i, boolean z) {
        if (this.f1404O000000o != null && !z) {
            this.f1404O000000o.O000000o();
        }
        ilk.O000000o("getAdsInfoAndPlay 0:" + System.currentTimeMillis());
        if (this.O00000oo == null) {
            this.O00000o = false;
            O000000o(true, o00000o0, true);
            ilk.O000000o("getAdsInfoAndPlay 1:" + System.currentTimeMillis());
            return;
        }
        ilk.O000000o("getAdsInfoAndPlay 2:" + System.currentTimeMillis());
        if (o00000o0.f1414O000000o.f12166O000000o != this.O0000o00 || this.O0000o0 == null || System.currentTimeMillis() - this.O0000o0O >= 40000) {
            HashMap hashMap = new HashMap();
            if ("track".equals(o00000o0.f1414O000000o.O00000Oo)) {
                StringBuilder sb = new StringBuilder();
                sb.append(o00000o0.f1414O000000o.f12166O000000o);
                hashMap.put("trackId", sb.toString());
            } else {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(o00000o0.f1414O000000o.O000O0Oo);
                hashMap.put("radioId", sb2.toString());
                StringBuilder sb3 = new StringBuilder();
                sb3.append(o00000o0.f1414O000000o.f12166O000000o);
                hashMap.put("scheduleId", sb3.toString());
            }
            if (XmPlayerService.getPlayerSrvice() != null) {
                hashMap.put("mode", XmPlayerService.getPlayerSrvice().isOnlineResource() ? "0" : "1");
            } else {
                hashMap.put("mode", "0");
            }
            hashMap.put("playMethod", String.valueOf(i));
            hashMap.put("duringPlay", String.valueOf(z));
            ilk.O000000o("getAdsInfoAndPlay 4:" + System.currentTimeMillis());
            this.O0000Ooo = this.O00000oo.O000000o(o00000o0.f1414O000000o, hashMap, new iiw<AdvertisList>() {
                /* class _m_j.ikn.AnonymousClass1 */

                public final /* synthetic */ void O000000o(Object obj) {
                    ilk.O000000o("getAdsInfoAndPlay 5:" + System.currentTimeMillis());
                    ikn.this.O000000o((AdvertisList) obj, o00000o0);
                }

                /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
                 method: _m_j.ikn.O000000o(boolean, _m_j.ikn$O00000o0, boolean):boolean
                 arg types: [int, _m_j.ikn$O00000o0, int]
                 candidates:
                  _m_j.ikn.O000000o(_m_j.ikn$O00000o0, int, boolean):void
                  _m_j.ikn.O000000o(_m_j.ikn$O00000o0, boolean, int):void
                  _m_j.ikn.O000000o(boolean, _m_j.ikn$O00000o0, boolean):boolean */
                public final void O000000o(int i, String str) {
                    ilk.O000000o("getAdsInfoAndPlay 6:" + System.currentTimeMillis());
                    if (o00000o0 == ikn.this.O00000oO) {
                        ikn.this.O00000o = false;
                    }
                    ikn.this.O000000o(true, o00000o0, true);
                }
            });
            return;
        }
        O000000o(this.O0000o0, o00000o0);
        this.O0000o0 = null;
        this.O0000o00 = -1;
        ilk.O000000o("getAdsInfoAndPlay 3:" + System.currentTimeMillis());
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ikn.O000000o(boolean, _m_j.ikn$O00000o0, boolean):boolean
     arg types: [boolean, _m_j.ikn$O00000o0, int]
     candidates:
      _m_j.ikn.O000000o(_m_j.ikn$O00000o0, int, boolean):void
      _m_j.ikn.O000000o(_m_j.ikn$O00000o0, boolean, int):void
      _m_j.ikn.O000000o(boolean, _m_j.ikn$O00000o0, boolean):boolean */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ikn.O000000o(boolean, _m_j.ikn$O00000o0, boolean):boolean
     arg types: [int, _m_j.ikn$O00000o0, int]
     candidates:
      _m_j.ikn.O000000o(_m_j.ikn$O00000o0, int, boolean):void
      _m_j.ikn.O000000o(_m_j.ikn$O00000o0, boolean, int):void
      _m_j.ikn.O000000o(boolean, _m_j.ikn$O00000o0, boolean):boolean */
    public final void O000000o(AdvertisList advertisList, O00000o0 o00000o0) {
        boolean O000000o2 = O000000o(o00000o0.O00000Oo, o00000o0, false);
        ilk.O000000o("dataReceiver 1:" + System.currentTimeMillis());
        if (O000000o2) {
            ilk.O000000o("dataReceiver 2:" + System.currentTimeMillis());
            return;
        }
        ilk.O000000o("dataReceiver 3:" + System.currentTimeMillis());
        ikh ikh = this.f1404O000000o;
        if (ikh != null) {
            ikh.O000000o(advertisList);
        }
        if (advertisList == null || advertisList.O00000Oo != 0 || advertisList.f12169O000000o == null || advertisList.f12169O000000o.size() == 0 || advertisList.f12169O000000o.get(0) == null) {
            this.O00000o = false;
            O000000o(true, o00000o0, true);
            ilk.O000000o("dataReceiver 4:" + System.currentTimeMillis());
            return;
        }
        o00000o0.O00000o0 = advertisList;
        if (!advertisList.f12169O000000o.get(0).O0000oo0) {
            O000000o(o00000o0);
            if (!O0000OOo && advertisList.f12169O000000o.get(0).O0000o0 == 11) {
                O00000oO();
            }
        } else {
            ikh ikh2 = this.f1404O000000o;
            if (ikh2 != null) {
                ikh2.O00000o();
            }
            this.O00000o = false;
        }
        ilk.O000000o("dataReceiver 5:" + System.currentTimeMillis());
        this.O00000oo.O000000o(o00000o0);
    }

    private void O00000oO() {
        O00000o0 o00000o0 = this.O00000oO;
        if (o00000o0 != null) {
            if (o00000o0.O00000oO != null) {
                this.O00000oO.O00000oO.O000000o(true);
            }
            this.O00000o = false;
            if (O00000Oo(this.O00000oO) < 0) {
                O00000o0();
            } else {
                O00000o0 o00000o02 = this.O00000oO;
                o00000o02.O00000o = o00000o02.O00000oO;
                this.O00000oO.O00000oO = null;
            }
            ikh ikh = this.f1404O000000o;
            if (ikh != null) {
                ikh.O00000o();
            }
        }
    }

    public final synchronized boolean O000000o(boolean z, O00000o0 o00000o0, boolean z2) {
        ilk.O000000o("exitPlayAds cancel:" + z + " task:" + o00000o0.f1414O000000o.toString() + " result:" + z2 + "  time:" + System.currentTimeMillis());
        if (!z) {
            return false;
        }
        if (o00000o0 != null && o00000o0 == this.O00000oO) {
            if (this.f1404O000000o != null) {
                ilk.O000000o("exitPlayAds 0");
                this.f1404O000000o.O00000o();
            }
            if (o00000o0.O00000o != null) {
                ilk.O000000o("exitPlayAds 1");
                o00000o0.O00000o.O000000o(z2);
            }
        }
        return true;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ikn.O000000o(boolean, _m_j.ikn$O00000o0, boolean):boolean
     arg types: [boolean, _m_j.ikn$O00000o0, int]
     candidates:
      _m_j.ikn.O000000o(_m_j.ikn$O00000o0, int, boolean):void
      _m_j.ikn.O000000o(_m_j.ikn$O00000o0, boolean, int):void
      _m_j.ikn.O000000o(boolean, _m_j.ikn$O00000o0, boolean):boolean */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ikn.O000000o(boolean, _m_j.ikn$O00000o0, boolean):boolean
     arg types: [int, _m_j.ikn$O00000o0, int]
     candidates:
      _m_j.ikn.O000000o(_m_j.ikn$O00000o0, int, boolean):void
      _m_j.ikn.O000000o(_m_j.ikn$O00000o0, boolean, int):void
      _m_j.ikn.O000000o(boolean, _m_j.ikn$O00000o0, boolean):boolean */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0091 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x00ac  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00c8  */
    /* JADX WARNING: Removed duplicated region for block: B:56:? A[RETURN, SYNTHETIC] */
    private void O000000o(final O00000o0 o00000o0) {
        boolean z;
        boolean z2;
        Advertis advertis;
        final String O00000Oo2;
        ilk.O000000o("downloadAndPlayAds 0:" + System.currentTimeMillis());
        if (O000000o(o00000o0.O00000Oo, o00000o0, false)) {
            ilk.O000000o("downloadAndPlayAds 1:" + System.currentTimeMillis());
            return;
        }
        final int O00000Oo3 = O00000Oo(o00000o0);
        boolean z3 = !TextUtils.isEmpty(o00000o0.O00000o0.f12169O000000o.get(0).O000000o());
        if (O00000Oo3 > 0) {
            z3 = !TextUtils.isEmpty(o00000o0.O00000o0.f12169O000000o.get(0).O000000o());
        } else if (O00000Oo3 == 0) {
            z2 = false;
            z = false;
            if (O00000Oo3 >= 0 && (advertis = o00000o0.O00000o0.f12169O000000o.get(O00000Oo3)) != null) {
                final String O000000o2 = advertis.O000000o();
                O00000Oo2 = O00000Oo(O000000o2);
                o00000o0.O00000oo = new O000000o() {
                    /* class _m_j.ikn.AnonymousClass2 */

                    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
                     method: _m_j.ikn.O000000o(_m_j.ikn$O00000o0, java.lang.String, boolean, int):void
                     arg types: [_m_j.ikn$O00000o0, java.lang.String, int, int]
                     candidates:
                      _m_j.ikn.O000000o(com.ximalaya.ting.android.opensdk.model.track.Track, int, _m_j.ikn$O00000Oo, boolean):void
                      _m_j.ikn.O000000o(_m_j.ikn$O00000o0, java.lang.String, boolean, int):void */
                    public final boolean O000000o() {
                        ilk.O000000o("口播冠名广告 回调  ==  onPlayStart" + o00000o0.O00000Oo + "   " + new File(O00000Oo2).exists());
                        if (!new File(O00000Oo2).exists() || o00000o0.O00000Oo) {
                            return false;
                        }
                        if (XmPlayerService.getPlayerSrvice() != null) {
                            XmPlayerService.getPlayerSrvice().playPauseNoNotif();
                            XmPlayerService.getPlayerSrvice().setPlayStartCallback(null);
                        }
                        ikn ikn = ikn.this;
                        ikn.O00000o = true;
                        ikn.O000000o(o00000o0, O00000Oo2, true, O00000Oo3);
                        if (ikn.this.O00000oo != null) {
                            o00000o0.O0000O0o = O00000Oo3;
                            ikn.this.O00000oo.O000000o(o00000o0);
                        }
                        return true;
                    }
                };
                if (new File(O00000Oo2).exists()) {
                    final int i = O00000Oo3;
                    final boolean z4 = z2;
                    final boolean z5 = z;
                    final O00000o0 o00000o02 = o00000o0;
                    final AnonymousClass3 r2 = new iiw<String>() {
                        /* class _m_j.ikn.AnonymousClass3 */

                        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
                         method: _m_j.ikn.O000000o(boolean, _m_j.ikn$O00000o0, boolean):boolean
                         arg types: [int, _m_j.ikn$O00000o0, int]
                         candidates:
                          _m_j.ikn.O000000o(_m_j.ikn$O00000o0, int, boolean):void
                          _m_j.ikn.O000000o(_m_j.ikn$O00000o0, boolean, int):void
                          _m_j.ikn.O000000o(boolean, _m_j.ikn$O00000o0, boolean):boolean */
                        public final /* synthetic */ void O000000o(Object obj) {
                            String str = (String) obj;
                            if (ikn.this.O00000Oo.size() > 20) {
                                ikn ikn = ikn.this;
                                ikn.O000000o(ikn.O00000Oo.remove(0));
                            }
                            ikn.this.O00000Oo.add(str);
                            if ((i == 0 || (z4 && !z5)) && !o00000o02.O00000Oo) {
                                if (XmPlayerService.getPlayerSrvice() != null) {
                                    XmPlayerService.getPlayerSrvice().setPlayStartCallback(o00000o02.O00000oo);
                                }
                                ikn ikn2 = ikn.this;
                                ikn2.O00000o = false;
                                ikn2.O000000o(true, o00000o02, true);
                            }
                        }

                        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
                         method: _m_j.ikn.O000000o(boolean, _m_j.ikn$O00000o0, boolean):boolean
                         arg types: [int, _m_j.ikn$O00000o0, int]
                         candidates:
                          _m_j.ikn.O000000o(_m_j.ikn$O00000o0, int, boolean):void
                          _m_j.ikn.O000000o(_m_j.ikn$O00000o0, boolean, int):void
                          _m_j.ikn.O000000o(boolean, _m_j.ikn$O00000o0, boolean):boolean */
                        public final void O000000o(int i, String str) {
                            if (i == 0 || (z4 && !z5)) {
                                ikn ikn = ikn.this;
                                ikn.O00000o = false;
                                ikn.O000000o(true, o00000o02, true);
                            }
                        }
                    };
                    iln.O000000o(new Runnable() {
                        /* class _m_j.ikn.AnonymousClass4 */

                        public final void run() {
                            ikn.this.O000000o(O000000o2, r2);
                        }
                    });
                    if (O00000Oo3 == 0) {
                        return;
                    }
                    if (z2 && !z) {
                        return;
                    }
                } else if (O00000Oo3 == 0 || (z2 && !z)) {
                    if (XmPlayerService.getPlayerSrvice() != null) {
                        XmPlayerService.getPlayerSrvice().setPlayStartCallback(o00000o0.O00000oo);
                    }
                    this.O00000o = false;
                    O000000o(true, o00000o0, true);
                    return;
                }
            }
            if (!z2) {
                Advertis advertis2 = o00000o0.O00000o0.f12169O000000o.get(0);
                boolean z6 = advertis2.O0000o0 == 11 && !TextUtils.isEmpty(advertis2.O000Oo0O);
                if (z6) {
                    o00000o0.O00000oO = o00000o0.O00000o;
                    o00000o0.O00000o = null;
                }
                if (z || z6) {
                    if (z && !z6) {
                        O000000o(o00000o0, O00000Oo3);
                    }
                    if (z6 && O00000Oo3 >= 0 && XmPlayerService.getPlayerSrvice() != null) {
                        XmPlayerService.getPlayerSrvice().setPlayStartCallback(o00000o0.O00000oo);
                        return;
                    }
                    return;
                }
                this.O00000o = false;
                if (O00000Oo3 >= 0 && XmPlayerService.getPlayerSrvice() != null) {
                    XmPlayerService.getPlayerSrvice().setPlayStartCallback(o00000o0.O00000oo);
                }
                O000000o(true, o00000o0, true);
                ilk.O000000o("downloadAndPlayAds 2:" + System.currentTimeMillis());
                return;
            }
            return;
        }
        z = z3;
        z2 = true;
        final String O000000o22 = advertis.O000000o();
        O00000Oo2 = O00000Oo(O000000o22);
        o00000o0.O00000oo = new O000000o() {
            /* class _m_j.ikn.AnonymousClass2 */

            /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
             method: _m_j.ikn.O000000o(_m_j.ikn$O00000o0, java.lang.String, boolean, int):void
             arg types: [_m_j.ikn$O00000o0, java.lang.String, int, int]
             candidates:
              _m_j.ikn.O000000o(com.ximalaya.ting.android.opensdk.model.track.Track, int, _m_j.ikn$O00000Oo, boolean):void
              _m_j.ikn.O000000o(_m_j.ikn$O00000o0, java.lang.String, boolean, int):void */
            public final boolean O000000o() {
                ilk.O000000o("口播冠名广告 回调  ==  onPlayStart" + o00000o0.O00000Oo + "   " + new File(O00000Oo2).exists());
                if (!new File(O00000Oo2).exists() || o00000o0.O00000Oo) {
                    return false;
                }
                if (XmPlayerService.getPlayerSrvice() != null) {
                    XmPlayerService.getPlayerSrvice().playPauseNoNotif();
                    XmPlayerService.getPlayerSrvice().setPlayStartCallback(null);
                }
                ikn ikn = ikn.this;
                ikn.O00000o = true;
                ikn.O000000o(o00000o0, O00000Oo2, true, O00000Oo3);
                if (ikn.this.O00000oo != null) {
                    o00000o0.O0000O0o = O00000Oo3;
                    ikn.this.O00000oo.O000000o(o00000o0);
                }
                return true;
            }
        };
        if (new File(O00000Oo2).exists()) {
        }
        if (!z2) {
        }
    }

    private static int O00000Oo(O00000o0 o00000o0) {
        if (!(o00000o0 == null || o00000o0.O00000o0 == null || o00000o0.O00000o0.f12169O000000o == null || o00000o0.O00000o0.f12169O000000o.size() == 0)) {
            List<Advertis> list = o00000o0.O00000o0.f12169O000000o;
            for (int i = 0; i < list.size(); i++) {
                Advertis advertis = list.get(i);
                if (advertis != null && advertis.O000Oo0o && !TextUtils.isEmpty(advertis.O000000o())) {
                    return i;
                }
            }
        }
        return -1;
    }

    private static String O00000o0(String str) {
        if (TextUtils.isEmpty(str) || !str.contains(".")) {
            return null;
        }
        return str.substring(str.lastIndexOf("."), str.length());
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ikn.O000000o(boolean, _m_j.ikn$O00000o0, boolean):boolean
     arg types: [boolean, _m_j.ikn$O00000o0, int]
     candidates:
      _m_j.ikn.O000000o(_m_j.ikn$O00000o0, int, boolean):void
      _m_j.ikn.O000000o(_m_j.ikn$O00000o0, boolean, int):void
      _m_j.ikn.O000000o(boolean, _m_j.ikn$O00000o0, boolean):boolean */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ikn.O000000o(boolean, _m_j.ikn$O00000o0, boolean):boolean
     arg types: [int, _m_j.ikn$O00000o0, int]
     candidates:
      _m_j.ikn.O000000o(_m_j.ikn$O00000o0, int, boolean):void
      _m_j.ikn.O000000o(_m_j.ikn$O00000o0, boolean, int):void
      _m_j.ikn.O000000o(boolean, _m_j.ikn$O00000o0, boolean):boolean */
    private void O000000o(final O00000o0 o00000o0, final boolean z, final int i) {
        ilk.O000000o("playAdsInternal 0:" + System.currentTimeMillis());
        if (O000000o(o00000o0.O00000Oo, o00000o0, false)) {
            ikh ikh = this.f1404O000000o;
            if (ikh != null) {
                ikh.O00000o0();
            }
            ilk.O000000o("playAdsInternal 1:" + System.currentTimeMillis());
            return;
        }
        iki iki = this.O00000o0;
        if (iki != null) {
            iki.O00000Oo();
        } else {
            this.O00000o0 = new iki();
        }
        this.O00000o0.O00000Oo = new MediaPlayer.OnCompletionListener() {
            /* class _m_j.ikn.AnonymousClass5 */

            /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
             method: _m_j.ikn.O000000o(boolean, _m_j.ikn$O00000o0, boolean):boolean
             arg types: [int, _m_j.ikn$O00000o0, int]
             candidates:
              _m_j.ikn.O000000o(_m_j.ikn$O00000o0, int, boolean):void
              _m_j.ikn.O000000o(_m_j.ikn$O00000o0, boolean, int):void
              _m_j.ikn.O000000o(boolean, _m_j.ikn$O00000o0, boolean):boolean */
            public final void onCompletion(MediaPlayer mediaPlayer) {
                ilk.O000000o("playAd CompletionListener:" + System.currentTimeMillis());
                if (o00000o0 == ikn.this.O00000oO) {
                    ikn.this.O00000o0.O00000Oo = null;
                }
                if (!z && i >= 0 && XmPlayerService.getPlayerSrvice() != null) {
                    XmPlayerService.getPlayerSrvice().setPlayStartCallback(o00000o0.O00000oo);
                }
                ikn ikn = ikn.this;
                ikn.O00000o = false;
                ikn.O000000o(true, o00000o0, true);
            }
        };
        Advertis advertis = o00000o0.O00000o0.f12169O000000o.get(0);
        if (z && o00000o0.O00000o0.f12169O000000o.size() > i) {
            advertis.O0000OOo = o00000o0.O00000o0.f12169O000000o.get(i).O000000o();
            advertis.O000Oo0o = true;
        }
        String O000000o2 = ilj.O000000o(this.O0000OoO, ili.O000000o(advertis.O000000o()) + O00000o0(advertis.O000000o()));
        if (new File(O000000o2).exists()) {
            XmPlayerService playerSrvice = XmPlayerService.getPlayerSrvice();
            if (playerSrvice == null || !playerSrvice.isLossAudioFocus()) {
                try {
                    iki iki2 = this.O00000o0;
                    iki2.O000000o();
                    iki2.f1386O000000o.setDataSource(O000000o2);
                    iki2.f1386O000000o.prepare();
                    iki2.O00000o = 1;
                    iki2.O00000oO = advertis;
                    if (XmPlayerService.getPlayerSrvice() != null) {
                        try {
                            iki2.O00000oo = (AudioManager) XmPlayerService.getPlayerSrvice().getSystemService("audio");
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    ilk.O000000o("playAdsInternal 3:" + System.currentTimeMillis());
                    O00000Oo();
                } catch (Exception e2) {
                    ilk.O000000o("playAdsInternal 4:" + System.currentTimeMillis());
                    e2.printStackTrace();
                    ikh ikh2 = this.f1404O000000o;
                    if (ikh2 != null) {
                        ikh2.O000000o(0, 0);
                    }
                    this.O00000o = false;
                    O000000o(true, o00000o0, true);
                }
            } else {
                playerSrvice.setLossAudioFocus(false);
                this.O00000o = false;
                O000000o(true, o00000o0, true);
                ilk.O000000o("playAdsInternal 2:" + System.currentTimeMillis());
            }
        } else {
            this.O00000o = false;
            O000000o(true, o00000o0, true);
            ilk.O000000o("playAdsInternal 5:" + System.currentTimeMillis());
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ikn.O000000o(boolean, _m_j.ikn$O00000o0, boolean):boolean
     arg types: [boolean, _m_j.ikn$O00000o0, int]
     candidates:
      _m_j.ikn.O000000o(_m_j.ikn$O00000o0, int, boolean):void
      _m_j.ikn.O000000o(_m_j.ikn$O00000o0, boolean, int):void
      _m_j.ikn.O000000o(boolean, _m_j.ikn$O00000o0, boolean):boolean */
    private void O000000o(final O00000o0 o00000o0, final int i) {
        if (O000000o(o00000o0.O00000Oo, o00000o0, false)) {
            ilk.O000000o("downloadAdsFile 0:" + System.currentTimeMillis());
            return;
        }
        ikh ikh = this.f1404O000000o;
        if (ikh != null) {
            ikh.O00000Oo();
        }
        iln.O000000o(new Runnable() {
            /* class _m_j.ikn.AnonymousClass6 */

            /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
             method: _m_j.ikn.O000000o(_m_j.ikn$O00000o0, java.lang.String, boolean, int):void
             arg types: [_m_j.ikn$O00000o0, java.lang.String, int, int]
             candidates:
              _m_j.ikn.O000000o(com.ximalaya.ting.android.opensdk.model.track.Track, int, _m_j.ikn$O00000Oo, boolean):void
              _m_j.ikn.O000000o(_m_j.ikn$O00000o0, java.lang.String, boolean, int):void */
            public final void run() {
                ilk.O000000o("downloadAdsFile doInBackground 1:" + System.currentTimeMillis());
                if (!o00000o0.O00000Oo) {
                    String O000000o2 = o00000o0.O00000o0.f12169O000000o.get(0).O000000o();
                    String O00000Oo2 = ikn.this.O00000Oo(O000000o2);
                    if (new File(O00000Oo2).exists()) {
                        ikn.this.O000000o(o00000o0, O00000Oo2, false, i);
                        return;
                    }
                    ikn.this.O000000o(O000000o2, new iiw<String>() {
                        /* class _m_j.ikn.AnonymousClass6.AnonymousClass1 */

                        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
                         method: _m_j.ikn.O000000o(_m_j.ikn$O00000o0, java.lang.String, boolean, int):void
                         arg types: [_m_j.ikn$O00000o0, java.lang.String, int, int]
                         candidates:
                          _m_j.ikn.O000000o(com.ximalaya.ting.android.opensdk.model.track.Track, int, _m_j.ikn$O00000Oo, boolean):void
                          _m_j.ikn.O000000o(_m_j.ikn$O00000o0, java.lang.String, boolean, int):void */
                        public final /* bridge */ /* synthetic */ void O000000o(Object obj) {
                            ikn.this.O000000o(o00000o0, (String) obj, false, i);
                        }

                        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
                         method: _m_j.ikn.O000000o(_m_j.ikn$O00000o0, java.lang.String, boolean, int):void
                         arg types: [_m_j.ikn$O00000o0, ?[OBJECT, ARRAY], int, int]
                         candidates:
                          _m_j.ikn.O000000o(com.ximalaya.ting.android.opensdk.model.track.Track, int, _m_j.ikn$O00000Oo, boolean):void
                          _m_j.ikn.O000000o(_m_j.ikn$O00000o0, java.lang.String, boolean, int):void */
                        public final void O000000o(int i, String str) {
                            ikn.this.O000000o(o00000o0, (String) null, false, i);
                        }
                    });
                }
            }
        });
    }

    public final void O000000o(String str, iiw<String> iiw) {
        List list = this.O0000o0o.get(str);
        if (list == null || list.size() <= 0) {
            CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
            copyOnWriteArrayList.add(iiw);
            this.O0000o0o.put(str, copyOnWriteArrayList);
            O000000o(str, O00000Oo(str));
            return;
        }
        list.add(iiw);
    }

    public final void O000000o(O00000o0 o00000o0, String str, boolean z, int i) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            O00000Oo(o00000o0, str, z, i);
            return;
        }
        final O00000o0 o00000o02 = o00000o0;
        final String str2 = str;
        final boolean z2 = z;
        final int i2 = i;
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            /* class _m_j.ikn.AnonymousClass7 */

            public final void run() {
                ikn.this.O00000Oo(o00000o02, str2, z2, i2);
            }
        });
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ikn.O000000o(boolean, _m_j.ikn$O00000o0, boolean):boolean
     arg types: [boolean, _m_j.ikn$O00000o0, int]
     candidates:
      _m_j.ikn.O000000o(_m_j.ikn$O00000o0, int, boolean):void
      _m_j.ikn.O000000o(_m_j.ikn$O00000o0, boolean, int):void
      _m_j.ikn.O000000o(boolean, _m_j.ikn$O00000o0, boolean):boolean */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ikn.O000000o(boolean, _m_j.ikn$O00000o0, boolean):boolean
     arg types: [int, _m_j.ikn$O00000o0, int]
     candidates:
      _m_j.ikn.O000000o(_m_j.ikn$O00000o0, int, boolean):void
      _m_j.ikn.O000000o(_m_j.ikn$O00000o0, boolean, int):void
      _m_j.ikn.O000000o(boolean, _m_j.ikn$O00000o0, boolean):boolean */
    public final void O00000Oo(O00000o0 o00000o0, String str, boolean z, int i) {
        ilk.O000000o("downloadAdsFile onPostExecute 0:" + System.currentTimeMillis());
        if (O000000o(o00000o0.O00000Oo, o00000o0, false)) {
            ilk.O000000o("downloadAdsFile onPostExecute 1:" + System.currentTimeMillis());
            ikh ikh = this.f1404O000000o;
            if (ikh != null) {
                ikh.O00000o0();
            }
        } else if (TextUtils.isEmpty(str)) {
            this.O00000o = false;
            ilk.O000000o("downloadAdsFile onPostExecute 2:" + System.currentTimeMillis());
            O000000o(true, o00000o0, true);
            ikh ikh2 = this.f1404O000000o;
            if (ikh2 != null) {
                ikh2.O00000o0();
            }
        } else {
            if (this.O00000Oo.size() > 20) {
                O000000o(this.O00000Oo.remove(0));
            }
            this.O00000Oo.add(str);
            ilk.O000000o("downloadAdsFile onPostExecute 3:" + System.currentTimeMillis());
            O000000o(o00000o0, z, i);
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.io.FileOutputStream.<init>(java.io.File, boolean):void throws java.io.FileNotFoundException}
     arg types: [java.io.File, int]
     candidates:
      ClspMth{java.io.FileOutputStream.<init>(java.lang.String, boolean):void throws java.io.FileNotFoundException}
      ClspMth{java.io.FileOutputStream.<init>(java.io.File, boolean):void throws java.io.FileNotFoundException} */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00c9 A[Catch:{ all -> 0x00a9 }, LOOP:3: B:46:0x00c3->B:48:0x00c9, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00ec A[SYNTHETIC, Splitter:B:51:0x00ec] */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00f7 A[SYNTHETIC, Splitter:B:57:0x00f7] */
    /* JADX WARNING: Removed duplicated region for block: B:67:? A[RETURN, SYNTHETIC] */
    private void O000000o(String str, String str2) {
        List<iiw> list;
        FileOutputStream fileOutputStream = null;
        try {
            HttpURLConnection O000000o2 = ijk.O000000o(ijd.f1359O000000o, ilj.O000000o(str), "GET", new ijk.O000000o() {
                /* class _m_j.ikn.AnonymousClass8 */

                public final void O000000o(HttpURLConnection httpURLConnection) {
                    httpURLConnection.setConnectTimeout(2000);
                    httpURLConnection.setReadTimeout(1000);
                }
            });
            O000000o2.connect();
            int responseCode = O000000o2.getResponseCode();
            if (responseCode != 200) {
                List<iiw> list2 = this.O0000o0o.get(str);
                if (list2 != null && list2.size() > 0) {
                    for (iiw O000000o3 : list2) {
                        O000000o3.O000000o(0, "resCode == ".concat(String.valueOf(responseCode)));
                    }
                }
                this.O0000o0o.remove(str);
                return;
            }
            InputStream inputStream = O000000o2.getInputStream();
            byte[] bArr = new byte[8192];
            FileOutputStream fileOutputStream2 = new FileOutputStream(new File(str2), false);
            while (true) {
                try {
                    int read = inputStream.read(bArr);
                    if (read <= 0) {
                        break;
                    }
                    fileOutputStream2.write(bArr, 0, read);
                } catch (Exception e) {
                    e = e;
                    fileOutputStream = fileOutputStream2;
                    try {
                        e.printStackTrace();
                        list = this.O0000o0o.get(str);
                        while (r2.hasNext()) {
                        }
                        this.O0000o0o.remove(str);
                        if (fileOutputStream == null) {
                        }
                    } catch (Throwable th) {
                        th = th;
                        if (fileOutputStream != null) {
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    fileOutputStream = fileOutputStream2;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e2) {
                            e2.printStackTrace();
                        }
                    }
                    throw th;
                }
            }
            fileOutputStream2.flush();
            List<iiw> list3 = this.O0000o0o.get(str);
            if (list3 != null && list3.size() > 0) {
                for (iiw O000000o4 : list3) {
                    O000000o4.O000000o(str2);
                }
            }
            this.O0000o0o.remove(str);
            try {
                fileOutputStream2.close();
            } catch (IOException e3) {
                e3.printStackTrace();
            }
        } catch (Exception e4) {
            e = e4;
            e.printStackTrace();
            list = this.O0000o0o.get(str);
            if (list != null && list.size() > 0) {
                for (iiw O000000o5 : list) {
                    O000000o5.O000000o(0, "错误了==" + e.getMessage());
                }
            }
            this.O0000o0o.remove(str);
            if (fileOutputStream == null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e5) {
                    e5.printStackTrace();
                }
            }
        }
    }

    public final int O00000o() {
        iki iki = this.O00000o0;
        if (iki != null) {
            return iki.O00000o;
        }
        return 0;
    }
}
