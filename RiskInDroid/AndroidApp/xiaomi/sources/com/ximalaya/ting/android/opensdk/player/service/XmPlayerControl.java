package com.ximalaya.ting.android.opensdk.player.service;

import _m_j.iit;
import _m_j.iiw;
import _m_j.ijk;
import _m_j.ikw;
import _m_j.iky;
import _m_j.ilk;
import _m_j.imk;
import _m_j.imn;
import android.content.Context;
import android.text.TextUtils;
import com.ximalaya.ting.android.opensdk.httputil.Config;
import com.ximalaya.ting.android.opensdk.model.PlayableModel;
import com.ximalaya.ting.android.opensdk.model.track.Track;
import com.ximalaya.ting.android.player.XMediaplayerJNI;
import java.util.HashMap;

public class XmPlayerControl {
    public static long O0000o0O;
    public static long O0000o0o;

    /* renamed from: O000000o  reason: collision with root package name */
    public imn f12199O000000o;
    imk.O00000o0 O00000Oo;
    public ikw O00000o;
    imk.O0000Oo0 O00000o0;
    public volatile int O00000oO;
    public boolean O00000oo = true;
    int O0000O0o;
    public int O0000OOo;
    public boolean O0000Oo = false;
    String O0000Oo0;
    Config O0000OoO;
    boolean O0000Ooo = false;
    public int O0000o;
    public O000000o O0000o0;
    public boolean O0000o00 = false;
    public PlayableModel O0000oO = null;
    public boolean O0000oO0 = false;
    public volatile boolean O0000oOO = true;
    public float O0000oOo = 1.0f;
    float O0000oo = 1.0f;
    float O0000oo0 = 0.0f;
    private imk.O0000Oo O0000ooO;
    private imk.O0000o00 O0000ooo;
    private imk.O00000Oo O000O00o;
    private imk.O0000OOo O000O0OO;
    private Context O000O0Oo;
    private imk.O00000o O00oOooO;
    private imk.O0000O0o O00oOooo;

    public interface O000000o {
    }

    public XmPlayerControl(Context context) {
        this.O000O0Oo = context.getApplicationContext();
    }

    public final void O000000o(float f, float f2) {
        imn imn = this.f12199O000000o;
        if (imn != null) {
            imn.O000000o(f, f2);
        }
    }

    public final int O000000o() {
        int i = this.O00000oO;
        if (i == 3 || i == 4 || i == 5 || i == 6) {
            return this.f12199O000000o.O00000o0();
        }
        return 0;
    }

    public final boolean O00000Oo() {
        return !TextUtils.isEmpty(this.O0000Oo0) && this.O0000Oo0.contains("http://");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0060, code lost:
        if (r5 != 8) goto L_0x007a;
     */
    public final boolean O000000o(String str, int i) {
        ilk.O000000o("PlayerControl init 17:" + System.currentTimeMillis());
        this.O0000o00 = false;
        if (TextUtils.isEmpty(str) || "null".equals(str)) {
            this.O0000Oo0 = null;
            imn imn = this.f12199O000000o;
            if (imn != null) {
                imn.O0000OoO();
                this.O00000oO = 0;
                this.O0000OOo = 0;
            }
            return false;
        }
        ilk.O000000o("PlayerControl init 18:" + System.currentTimeMillis());
        this.O0000O0o = i;
        if (TextUtils.isEmpty(this.O0000Oo0) || !str.equals(this.O0000Oo0)) {
            this.O0000Oo0 = str;
            O0000O0o();
        } else {
            int i2 = this.O00000oO;
            if (i2 != 0) {
                if (i2 == 1) {
                    this.f12199O000000o.O0000O0o();
                    this.O00000oO = 9;
                } else if (i2 != 4) {
                    if (i2 == 5) {
                        O000000o(false);
                    } else if (i2 != 7) {
                    }
                }
            }
            O0000O0o();
        }
        return true;
    }

    public final void O00000o0() {
        imn imn = this.f12199O000000o;
        if (imn != null) {
            imn.O0000OoO();
            this.O00000oO = 1;
            this.O0000Oo0 = null;
        }
    }

    private void O0000O0o() {
        imn imn = this.f12199O000000o;
        if (imn == null) {
            this.f12199O000000o = O0000Oo0();
        } else {
            imn.O0000OoO();
            O0000OOo();
        }
        this.f12199O000000o.O00000Oo(this.O0000Oo0);
        this.O00000oO = 1;
        this.f12199O000000o.O0000O0o();
        this.O00000oO = 9;
        ikw ikw = this.O00000o;
        if (ikw != null) {
            ikw.O00000oo();
        }
        this.O0000OOo = 0;
        if (XmPlayerService.getPlayerSrvice() != null && XmPlayerService.getPlayerSrvice().f12208O000000o != null) {
            this.O0000oO = XmPlayerService.getPlayerSrvice().f12208O000000o.O00000o;
        }
    }

    private void O0000OOo() {
        imn imn = this.f12199O000000o;
        if (imn != null) {
            imn.O000000o(this.O000O00o);
            this.f12199O000000o.O000000o(this.O00000Oo);
            this.f12199O000000o.O000000o(this.O0000ooO);
            this.f12199O000000o.O000000o(this.O0000ooo);
            this.f12199O000000o.O000000o(this.O00oOooO);
            this.f12199O000000o.O000000o(this.O00oOooo);
            this.f12199O000000o.O000000o(this.O00000o0);
            this.f12199O000000o.O000000o(this.O000O0OO);
        }
    }

    public final boolean O00000Oo(String str, int i) {
        this.O00000oo = true;
        return O000000o(str, i);
    }

    public final boolean O000000o(boolean z) {
        XmPlayerService playerSrvice = XmPlayerService.getPlayerSrvice();
        if (playerSrvice == null || this.f12199O000000o == null) {
            return false;
        }
        if (z) {
            playerSrvice.setLossAudioFocus(false);
        }
        int i = this.O00000oO;
        if (i == 9) {
            return true;
        }
        switch (i) {
            case 1:
                this.f12199O000000o.O0000O0o();
                this.O00000oO = 9;
                return true;
            case 2:
            case 5:
            case 6:
                if (playerSrvice.isLossAudioFocus()) {
                    playerSrvice.setLossAudioFocus(false);
                    return true;
                }
                playerSrvice.requestAudioFocusControl();
                if (!this.O0000Ooo) {
                    this.f12199O000000o.O0000OOo();
                }
                int i2 = this.O0000O0o;
                if (i2 > 0) {
                    this.f12199O000000o.O000000o(i2);
                    this.O0000O0o = 0;
                }
                this.O00000oO = 3;
                ikw ikw = this.O00000o;
                if (ikw == null) {
                    return true;
                }
                ikw.O000000o();
                return true;
            case 3:
                return true;
            case 4:
                this.f12199O000000o.O0000O0o();
                this.O00000oO = 9;
                ikw ikw2 = this.O00000o;
                if (ikw2 == null) {
                    return true;
                }
                ikw2.O000000o();
                return true;
            default:
                return false;
        }
    }

    public final boolean O00000Oo(boolean z) {
        if (this.O00000oO != 3) {
            return false;
        }
        this.f12199O000000o.O00000oo();
        this.O00000oO = 5;
        ikw ikw = this.O00000o;
        if (ikw != null) {
            if (z) {
                ikw.O00000Oo();
            }
            if (!this.f12199O000000o.O00000oO()) {
                this.O00000o.O0000O0o();
            }
        }
        return true;
    }

    public final boolean O00000o() {
        int i = this.O00000oO;
        if (i == 1) {
            return true;
        }
        if (i != 2 && i != 3 && i != 5 && i != 6) {
            return i == 9;
        }
        this.f12199O000000o.O0000Oo0();
        this.O00000oO = 4;
        ikw ikw = this.O00000o;
        if (ikw == null) {
            return true;
        }
        ikw.O00000o0();
        return true;
    }

    private imn O0000Oo0() {
        this.f12199O000000o = iky.O000000o(this.O000O0Oo);
        O0000Oo();
        O0000OOo();
        this.f12199O000000o.O000000o(ijk.O000000o(this.O0000OoO));
        this.f12199O000000o.O000000o(this.O0000oOo, this.O0000oo0, this.O0000oo);
        return this.f12199O000000o;
    }

    private void O0000Oo() {
        if (this.O00000Oo == null) {
            this.O00000Oo = new imk.O00000o0() {
                /* class com.ximalaya.ting.android.opensdk.player.service.XmPlayerControl.AnonymousClass1 */

                public final void O000000o() {
                    ilk.O000000o("XmPlayerControl onCompletion:" + System.currentTimeMillis());
                    if (XmPlayerControl.this.O0000oO != null) {
                        Track track = (Track) XmPlayerControl.this.O0000oO;
                        ilk.O000000o("XmPlayerControl onCompletion track:" + track.toString());
                        if (track.O00000Oo()) {
                            XmPlayerControl xmPlayerControl = XmPlayerControl.this;
                            xmPlayerControl.O00000oO = 0;
                            xmPlayerControl.O0000o00 = true;
                        } else {
                            XmPlayerControl.this.O00000oO = 6;
                        }
                    } else {
                        XmPlayerControl.this.O00000oO = 6;
                    }
                    if (XmPlayerControl.this.O00000o != null) {
                        XmPlayerControl.this.O00000o.O00000o();
                    }
                }
            };
        }
        if (this.O0000ooO == null) {
            this.O0000ooO = new imk.O0000Oo() {
                /* class com.ximalaya.ting.android.opensdk.player.service.XmPlayerControl.AnonymousClass2 */

                public final void O000000o(imn imn) {
                    ilk.O000000o("XmPlayerControl onPrepared:" + System.currentTimeMillis());
                    if (XmPlayerControl.this.O0000oO != null) {
                        ilk.O000000o("XmPlayerControl onPrepared track:" + ((Track) XmPlayerControl.this.O0000oO).toString());
                    }
                    XmPlayerControl xmPlayerControl = XmPlayerControl.this;
                    xmPlayerControl.O00000oO = 2;
                    xmPlayerControl.O0000OOo = imn.O00000o();
                    if (XmPlayerControl.this.O00000o != null) {
                        XmPlayerControl.this.O00000o.O00000oO();
                    }
                    if (XmPlayerControl.this.O00000oo) {
                        XmPlayerControl.this.O000000o(false);
                    } else {
                        XmPlayerControl.this.O00000oo = true;
                    }
                    XmPlayerControl.this.O00000oO();
                }
            };
        }
        if (this.O0000ooo == null) {
            this.O0000ooo = new imk.O0000o00() {
                /* class com.ximalaya.ting.android.opensdk.player.service.XmPlayerControl.AnonymousClass3 */

                public final void O000000o() {
                    int i = XmPlayerControl.this.O00000oO;
                    if (XmPlayerControl.this.O0000oO0) {
                        XmPlayerControl.O0000o0o = (long) XmPlayerControl.this.O0000o;
                        XmPlayerControl.this.O0000oO0 = false;
                    }
                }
            };
        }
        if (this.O00oOooO == null) {
            this.O00oOooO = new imk.O00000o() {
                /* class com.ximalaya.ting.android.opensdk.player.service.XmPlayerControl.AnonymousClass4 */

                public final boolean O000000o(int i, int i2) {
                    ilk.O000000o("XmPlayerControl onError what:" + i + " extra:" + i2 + " time:" + System.currentTimeMillis());
                    if (XmPlayerControl.this.O0000oO != null) {
                        ilk.O000000o("XmPlayerControl onError track:" + ((Track) XmPlayerControl.this.O0000oO).toString());
                    }
                    XmPlayerControl xmPlayerControl = XmPlayerControl.this;
                    xmPlayerControl.O00000oO = 7;
                    if (xmPlayerControl.O00000o == null) {
                        return true;
                    }
                    XmPlayerControl.this.O00000o.O000000o(new XmPlayerException(i, i2));
                    return true;
                }
            };
        }
        if (this.O00oOooo == null) {
            this.O00oOooo = new imk.O0000O0o() {
                /* class com.ximalaya.ting.android.opensdk.player.service.XmPlayerControl.AnonymousClass5 */

                public final boolean O000000o(int i) {
                    boolean z = true;
                    if (i == 701) {
                        XmPlayerControl.this.O0000Oo = true;
                    } else if (i == 702) {
                        XmPlayerControl.this.O0000Oo = false;
                    } else {
                        z = false;
                    }
                    if (XmPlayerControl.this.O00000o != null) {
                        if (XmPlayerControl.this.O0000Oo) {
                            XmPlayerControl.this.O00000o.O00000oo();
                        } else {
                            XmPlayerControl.this.O00000o.O0000O0o();
                        }
                    }
                    return z;
                }
            };
        }
        if (this.O000O00o == null) {
            this.O000O00o = new imk.O00000Oo() {
                /* class com.ximalaya.ting.android.opensdk.player.service.XmPlayerControl.AnonymousClass6 */

                public final void O000000o(int i) {
                    if (XmPlayerControl.this.O00000o != null) {
                        XmPlayerControl.this.O00000o.O000000o(i);
                    }
                }
            };
        }
        if (this.O00000o0 == null) {
            this.O00000o0 = new imk.O0000Oo0() {
                /* class com.ximalaya.ting.android.opensdk.player.service.XmPlayerControl.AnonymousClass7 */

                public final void O000000o(imn imn, int i) {
                    if (!imn.O00000Oo().equals(XMediaplayerJNI.AudioType.HLS_FILE)) {
                        int O00000o = imn.O00000o();
                        if (O00000o > 0 && XmPlayerControl.this.O00000o != null) {
                            int i2 = i - ((int) XmPlayerControl.O0000o0o);
                            if (i2 > 0 && i2 <= 2000) {
                                XmPlayerControl.O0000o0O = (XmPlayerControl.O0000o0O + ((long) i)) - ((long) ((int) XmPlayerControl.O0000o0o));
                            }
                            XmPlayerControl.O0000o0o = (long) i;
                            XmPlayerControl.this.O00000o.O000000o(i, O00000o);
                            return;
                        }
                        return;
                    }
                    long currentTimeMillis = System.currentTimeMillis() - XmPlayerControl.O0000o0o;
                    if (currentTimeMillis > 0) {
                        XmPlayerControl.O0000o0O += currentTimeMillis;
                        XmPlayerControl.O0000o0o = System.currentTimeMillis();
                    }
                    XmPlayerControl.this.O00000o.O000000o(0, 0);
                }
            };
        }
    }

    public final void O00000oO() {
        if (XmPlayerService.getPlayerSrvice() != null && XmPlayerService.getPlayerSrvice().f12208O000000o != null) {
            XmPlayListControl xmPlayListControl = XmPlayerService.getPlayerSrvice().f12208O000000o;
            Track track = (xmPlayListControl.O0000Oo < 0 || xmPlayListControl.O0000Oo + 1 >= xmPlayListControl.O00000o0.size()) ? null : xmPlayListControl.O00000o0.get(xmPlayListControl.O0000Oo + 1);
            if (track != null && TextUtils.isEmpty(XmPlayerService.getPlayerSrvice().O000000o(track))) {
                if (!track.O000O0o) {
                    this.f12199O000000o.O00000o0(XmPlayerService.getPlayerSrvice().getTrackUrl(track));
                } else if (this.O0000oOO) {
                    this.O0000oOO = false;
                    iit.O000000o(new HashMap(), new iiw<String>() {
                        /* class com.ximalaya.ting.android.opensdk.player.service.XmPlayerControl.AnonymousClass8 */

                        public final /* synthetic */ void O000000o(Object obj) {
                            XmPlayerControl xmPlayerControl = XmPlayerControl.this;
                            xmPlayerControl.O0000oOO = true;
                            xmPlayerControl.f12199O000000o.O00000o0((String) obj);
                        }

                        public final void O000000o(int i, String str) {
                            XmPlayerControl.this.O0000oOO = true;
                        }
                    }, track);
                }
            }
        }
    }

    public final void O000000o(imk.O0000OOo o0000OOo) {
        imn imn = this.f12199O000000o;
        if (imn != null) {
            imn.O000000o(o0000OOo);
        }
        this.O000O0OO = o0000OOo;
    }

    public final boolean O00000oo() {
        return this.f12199O000000o != null && XMediaplayerJNI.AudioType.HLS_FILE.equals(this.f12199O000000o.O00000Oo());
    }
}
