package com.ximalaya.ting.android.opensdk.player.service;

import _m_j.iit;
import _m_j.iiw;
import _m_j.ijv;
import _m_j.iku;
import _m_j.ilg;
import _m_j.ilk;
import android.os.RemoteException;
import android.text.TextUtils;
import com.ximalaya.ting.android.opensdk.model.PlayableModel;
import com.ximalaya.ting.android.opensdk.model.live.radio.Radio;
import com.ximalaya.ting.android.opensdk.model.track.Track;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public final class XmPlayListControl {

    /* renamed from: O000000o  reason: collision with root package name */
    int f12189O000000o = 1;
    iit O00000Oo = iit.O000000o();
    public PlayableModel O00000o;
    public List<Track> O00000o0 = new ArrayList();
    Map<String, String> O00000oO;
    public int O00000oo;
    public int O0000O0o;
    int O0000OOo;
    public volatile int O0000Oo = -1;
    public int O0000Oo0;
    PlayMode O0000OoO = PlayMode.PLAY_MODEL_LIST;
    public int O0000Ooo;
    private PlayableModel O0000o;
    boolean O0000o0 = true;
    public boolean O0000o00 = false;
    public boolean O0000o0O = true;
    public IXmDataCallback O0000o0o;
    private int O0000oO0 = -1;

    public final void O000000o(Radio radio) {
        if (radio != null) {
            if (this.f12189O000000o != 3) {
                O00000Oo();
                this.f12189O000000o = 3;
            }
            if (!radio.equals(this.O00000o)) {
                this.O0000o = this.O00000o;
                this.O00000o = radio;
            }
        }
    }

    public final void O00000Oo() {
        synchronized (this.O00000o0) {
            this.O00000oO = null;
            this.O00000o0.clear();
            this.O00000oo = 0;
            this.O0000O0o = 0;
            this.O0000OOo = 0;
            this.O0000Oo0 = 0;
            this.O0000Oo = -1;
            this.O0000Ooo = 0;
            this.O0000oO0 = -1;
            this.O00000o = null;
            this.O0000o = null;
            this.O0000o0O = true;
        }
    }

    public final int O000000o(boolean z) {
        int i;
        int i2 = this.f12189O000000o;
        if (i2 == 3 || i2 != 2) {
            return -1;
        }
        PlayMode playMode = this.O0000OoO;
        if (z && playMode == PlayMode.PLAY_MODEL_SINGLE_LOOP) {
            playMode = PlayMode.PLAY_MODEL_LIST;
        }
        int i3 = AnonymousClass3.f12192O000000o[playMode.ordinal()];
        if (i3 == 1) {
            i = this.O0000Oo + 1;
            if (O00000o(i)) {
                O0000OOo();
            }
            if (i >= this.O0000Ooo) {
                return -1;
            }
        } else if (i3 == 2) {
            i = this.O0000Oo + 1;
            if (O00000o(i)) {
                O0000OOo();
            }
            if (i >= this.O0000Ooo) {
                return 0;
            }
        } else if (i3 == 3) {
            return this.O0000Oo;
        } else {
            if (i3 != 4) {
                return -1;
            }
            double random = Math.random();
            double d = (double) this.O0000Ooo;
            Double.isNaN(d);
            int i4 = (int) (random * d);
            int i5 = this.O0000Oo;
            return i4;
        }
        return i;
    }

    public final void O000000o(int i) {
        if (i != this.O0000Oo) {
            this.O0000oO0 = this.O0000Oo;
            this.O0000Oo = i;
            this.O0000o = this.O00000o;
        }
        this.O00000o = O00000Oo(this.O0000Oo);
        if (O00000o(i + 1)) {
            O0000OOo();
        }
        if (O00000o0(i - 1)) {
            O0000O0o();
        }
    }

    private boolean O00000o0(int i) {
        if (this.O00000oO == null || i - iku.f1425O000000o > 0 || !O00000oO()) {
            return false;
        }
        ilk.O00000Oo("XmPlayListControl", "needLoadNextPage currPage:" + this.O00000oo + ", currPageSize:" + this.O0000OOo + ", next:" + i);
        return true;
    }

    public final PlayableModel O00000Oo(int i) {
        List<Track> list = this.O00000o0;
        if (list == null || list.size() <= 0 || i < 0 || i >= this.O00000o0.size()) {
            return null;
        }
        return this.O00000o0.get(i);
    }

    public final synchronized boolean O00000o() {
        boolean z = false;
        this.O0000o0 = !this.O0000o0;
        if (!this.O0000o0O) {
            z = true;
        }
        this.O0000o0O = z;
        if (this.O00000o0 != null && this.O00000o0.size() > 0) {
            Collections.reverse(this.O00000o0);
            if (this.O00000o != null) {
                this.O0000Oo = this.O00000o0.indexOf(this.O00000o);
            }
            if (this.O0000o != null) {
                this.O0000oO0 = this.O00000o0.indexOf(this.O0000o);
            }
        }
        return true;
    }

    public final void O00000Oo(boolean z) {
        if (!this.O0000o0O && !z) {
            O00000o0(true);
        } else if (!O00000oo()) {
            IXmDataCallback iXmDataCallback = this.O0000o0o;
            if (iXmDataCallback != null) {
                try {
                    iXmDataCallback.onDataReady(null, false, this.O0000o0O);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        } else if (this.O00000oO == null || this.O0000o00) {
            O000000o(400, "加载失败", this.O0000o0O);
        } else {
            O0000OOo();
        }
    }

    public final void O00000o0(boolean z) {
        boolean z2 = true;
        if (!this.O0000o0O && !z) {
            O00000Oo(true);
        } else if (!O00000oO()) {
            IXmDataCallback iXmDataCallback = this.O0000o0o;
            if (iXmDataCallback != null) {
                try {
                    if (this.O0000o0O) {
                        z2 = false;
                    }
                    iXmDataCallback.onDataReady(null, false, z2);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        } else if (this.O00000oO == null || this.O0000o00) {
            O000000o(400, "加载失败", !this.O0000o0O);
        } else {
            O0000O0o();
        }
    }

    /* access modifiers changed from: protected */
    public final boolean O00000oO() {
        int i;
        int i2 = this.O0000Oo0;
        if (i2 > 0 && (i = this.O0000O0o) < i2 && i > 0) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public final boolean O00000oo() {
        int i = this.O0000Oo0;
        if (i > 0 && this.O00000oo < i) {
            return true;
        }
        return false;
    }

    private void O0000O0o() {
        Map<String, String> map;
        ilk.O00000Oo("XmPlayListControl", "loadPrePageSync");
        if (this.O0000o00 || (map = this.O00000oO) == null) {
            O000000o(400, "加载失败", true ^ this.O0000o0O);
            return;
        }
        this.O0000o00 = true;
        StringBuilder sb = new StringBuilder();
        sb.append(this.O0000O0o);
        map.put("page", sb.toString());
        if (!this.O00000oO.containsKey("count")) {
            Map<String, String> map2 = this.O00000oO;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(iit.O00000o0);
            map2.put("count", sb2.toString());
        }
        iit.O0000o0(this.O00000oO, new iiw<ijv>() {
            /* class com.ximalaya.ting.android.opensdk.player.service.XmPlayListControl.AnonymousClass1 */

            public final /* synthetic */ void O000000o(Object obj) {
                ijv ijv = (ijv) obj;
                ilk.O00000Oo("XmPlayListControl", "CommonRequest.getTrackList 获取播放器下一页数据");
                XmPlayListControl xmPlayListControl = XmPlayListControl.this;
                boolean z = false;
                xmPlayListControl.O0000o00 = false;
                if (ijv == null) {
                    xmPlayListControl.O000000o(400, "加载失败", !xmPlayListControl.O0000o0O);
                    return;
                }
                xmPlayListControl.O0000Oo0 = ijv.O00000o;
                List<T> list = ijv.f1378O000000o;
                if (list == null || list.size() == 0) {
                    XmPlayListControl xmPlayListControl2 = XmPlayListControl.this;
                    xmPlayListControl2.O000000o(400, "加载失败", !xmPlayListControl2.O0000o0O);
                    return;
                }
                XmPlayListControl.this.O0000O0o--;
                synchronized (XmPlayListControl.this.O00000o0) {
                    if (XmPlayListControl.this.O0000o0O) {
                        XmPlayListControl.this.O00000o0.addAll(0, list);
                        XmPlayListControl.this.O0000Oo += list.size();
                    } else {
                        Collections.reverse(list);
                        XmPlayListControl.this.O00000o0.addAll(list);
                    }
                }
                XmPlayListControl xmPlayListControl3 = XmPlayListControl.this;
                xmPlayListControl3.O0000Ooo = xmPlayListControl3.O00000o0.size();
                boolean O00000oO = XmPlayListControl.this.O00000oO();
                if (XmPlayListControl.this.O0000o0o != null) {
                    try {
                        IXmDataCallback iXmDataCallback = XmPlayListControl.this.O0000o0o;
                        if (!XmPlayListControl.this.O0000o0O) {
                            z = true;
                        }
                        iXmDataCallback.onDataReady(list, O00000oO, z);
                    } catch (RemoteException e) {
                        e.printStackTrace();
                        XmPlayListControl xmPlayListControl4 = XmPlayListControl.this;
                        xmPlayListControl4.O000000o(400, "加载失败", xmPlayListControl4.O0000o0O);
                    }
                }
            }

            public final void O000000o(int i, String str) {
                ilk.O00000Oo("XmPlayListControl", "CommonRequest.getTrackList 获取播放器下一页数据 onError " + i + ", " + str);
                XmPlayListControl xmPlayListControl = XmPlayListControl.this;
                xmPlayListControl.O0000o00 = false;
                xmPlayListControl.O000000o(i, str, xmPlayListControl.O0000o0O ^ true);
            }
        });
    }

    private void O0000OOo() {
        Map<String, String> map;
        ilk.O00000Oo("XmPlayListControl", "loadNextPageSync");
        if (this.O0000o00 || (map = this.O00000oO) == null) {
            O000000o(400, "加载失败", this.O0000o0O);
            return;
        }
        this.O0000o00 = true;
        StringBuilder sb = new StringBuilder();
        sb.append(this.O00000oo + 1);
        map.put("page", sb.toString());
        if (!this.O00000oO.containsKey("count")) {
            Map<String, String> map2 = this.O00000oO;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(iit.O00000o0);
            map2.put("count", sb2.toString());
        }
        iit.O0000o0(this.O00000oO, new iiw<ijv>() {
            /* class com.ximalaya.ting.android.opensdk.player.service.XmPlayListControl.AnonymousClass2 */

            public final /* synthetic */ void O000000o(Object obj) {
                ijv ijv = (ijv) obj;
                XmPlayListControl.this.O0000o00 = false;
                ilk.O00000Oo("XmPlayListControl", "CommonRequest.getTrackList 获取播放器下一页数据");
                if (ijv == null) {
                    XmPlayListControl xmPlayListControl = XmPlayListControl.this;
                    xmPlayListControl.O000000o(400, "加载失败", xmPlayListControl.O0000o0O);
                    return;
                }
                XmPlayListControl.this.O0000Oo0 = ijv.O00000o;
                List<T> list = ijv.f1378O000000o;
                if (list == null || list.size() == 0) {
                    XmPlayListControl xmPlayListControl2 = XmPlayListControl.this;
                    xmPlayListControl2.O000000o(400, "加载失败", xmPlayListControl2.O0000o0O);
                    return;
                }
                XmPlayListControl.this.O00000oo++;
                synchronized (XmPlayListControl.this.O00000o0) {
                    if (XmPlayListControl.this.O0000o0O) {
                        XmPlayListControl.this.O00000o0.addAll(list);
                    } else {
                        Collections.reverse(list);
                        XmPlayListControl.this.O00000o0.addAll(0, list);
                        XmPlayListControl.this.O0000Oo += list.size();
                    }
                    XmPlayListControl.this.O0000Ooo = XmPlayListControl.this.O00000o0.size();
                }
                boolean O00000oo = XmPlayListControl.this.O00000oo();
                if (XmPlayListControl.this.O0000o0o != null) {
                    try {
                        XmPlayListControl.this.O0000o0o.onDataReady(list, O00000oo, XmPlayListControl.this.O0000o0O);
                    } catch (RemoteException e) {
                        e.printStackTrace();
                        XmPlayListControl xmPlayListControl3 = XmPlayListControl.this;
                        xmPlayListControl3.O000000o(400, "加载失败", xmPlayListControl3.O0000o0O);
                    }
                }
            }

            public final void O000000o(int i, String str) {
                ilk.O00000Oo("XmPlayListControl", "CommonRequest.getTrackList 获取播放器下一页数据 onError " + i + ", " + str);
                XmPlayListControl xmPlayListControl = XmPlayListControl.this;
                xmPlayListControl.O0000o00 = false;
                xmPlayListControl.O000000o(i, str, xmPlayListControl.O0000o0O);
            }
        });
    }

    public final void O000000o(int i, String str, boolean z) {
        IXmDataCallback iXmDataCallback = this.O0000o0o;
        if (iXmDataCallback != null) {
            try {
                iXmDataCallback.onError(i, str, z);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    private boolean O00000o(int i) {
        if (this.O00000oO == null || iku.f1425O000000o + i < this.O0000Ooo || !O00000oo()) {
            return false;
        }
        ilk.O00000Oo("XmPlayListControl", "needLoadNextPage currPage:" + this.O00000oo + ", currPageSize:" + this.O0000OOo + ", next:" + i);
        return true;
    }

    /* renamed from: com.ximalaya.ting.android.opensdk.player.service.XmPlayListControl$3  reason: invalid class name */
    static /* synthetic */ class AnonymousClass3 {

        /* renamed from: O000000o  reason: collision with root package name */
        static final /* synthetic */ int[] f12192O000000o = new int[PlayMode.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0035 */
        static {
            f12192O000000o[PlayMode.PLAY_MODEL_LIST.ordinal()] = 1;
            f12192O000000o[PlayMode.PLAY_MODEL_LIST_LOOP.ordinal()] = 2;
            f12192O000000o[PlayMode.PLAY_MODEL_SINGLE_LOOP.ordinal()] = 3;
            f12192O000000o[PlayMode.PLAY_MODEL_RANDOM.ordinal()] = 4;
            f12192O000000o[PlayMode.PLAY_MODEL_SINGLE.ordinal()] = 5;
        }
    }

    public enum PlayMode {
        PLAY_MODEL_SINGLE,
        PLAY_MODEL_SINGLE_LOOP,
        PLAY_MODEL_LIST,
        PLAY_MODEL_LIST_LOOP,
        PLAY_MODEL_RANDOM;

        public static PlayMode getIndex(int i) {
            if (i == PLAY_MODEL_SINGLE.ordinal()) {
                return PLAY_MODEL_SINGLE;
            }
            if (i == PLAY_MODEL_SINGLE_LOOP.ordinal()) {
                return PLAY_MODEL_SINGLE_LOOP;
            }
            if (i == PLAY_MODEL_LIST.ordinal()) {
                return PLAY_MODEL_LIST;
            }
            if (i == PLAY_MODEL_LIST_LOOP.ordinal()) {
                return PLAY_MODEL_LIST_LOOP;
            }
            if (i == PLAY_MODEL_RANDOM.ordinal()) {
                return PLAY_MODEL_RANDOM;
            }
            return PLAY_MODEL_LIST;
        }
    }

    public final int O000000o() {
        PlayableModel playableModel = this.O00000o;
        if (playableModel == null) {
            return 1;
        }
        Track track = (Track) playableModel;
        if (TextUtils.isEmpty(track.O00000Oo)) {
            return 1;
        }
        if ("radio".endsWith(track.O00000Oo)) {
            this.f12189O000000o = 3;
        } else if ("track".endsWith(track.O00000Oo)) {
            this.f12189O000000o = 2;
        } else if ("schedule".endsWith(track.O00000Oo)) {
            String str = track.O00oOooO + "-" + track.O00oOooo;
            if (ilg.O000000o(str) == 0) {
                this.f12189O000000o = 3;
            } else if (ilg.O000000o(str) == -1) {
                this.f12189O000000o = 2;
            }
        }
        return this.f12189O000000o;
    }

    public final int O00000o0() {
        int i;
        PlayMode playMode = this.O0000OoO;
        if (playMode == PlayMode.PLAY_MODEL_SINGLE_LOOP) {
            playMode = PlayMode.PLAY_MODEL_LIST;
        }
        int i2 = AnonymousClass3.f12192O000000o[playMode.ordinal()];
        if (i2 == 1) {
            i = this.O0000Oo - 1;
            if (O00000o0(i)) {
                O0000O0o();
            }
            if (i < 0) {
                return -1;
            }
        } else if (i2 == 2) {
            i = this.O0000Oo - 1;
            if (O00000o0(i)) {
                O0000O0o();
            }
            if (i < 0) {
                i = this.O0000Ooo - 1;
            }
        } else if (i2 == 3) {
            return this.O0000Oo;
        } else {
            if (i2 != 4) {
                return -1;
            }
            double random = Math.random();
            double d = (double) this.O0000Ooo;
            Double.isNaN(d);
            int i3 = (int) (random * d);
            int i4 = this.O0000Oo;
            return i3;
        }
        return i;
    }
}
