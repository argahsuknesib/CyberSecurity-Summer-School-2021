package _m_j;

import com.ximalaya.ting.android.player.XMediaplayerJNI;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

public final class ilx {

    /* renamed from: O000000o  reason: collision with root package name */
    private String f1455O000000o;
    private String O00000Oo;
    private ilz O00000o;
    private List<String> O00000o0 = new ArrayList();
    private XMediaplayerJNI O00000oO;
    private LinkedBlockingQueue<ilu> O00000oo;
    private volatile boolean O0000O0o = false;
    private boolean O0000OOo = false;
    private int O0000Oo0 = -1;

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.imc.O000000o(java.lang.String, java.lang.Object):void
     arg types: [java.lang.String, java.lang.String]
     candidates:
      _m_j.imc.O000000o(java.lang.String, java.lang.String):void
      _m_j.imc.O000000o(java.lang.String, java.lang.Object):void */
    public final int O000000o() {
        if (this.O00000o == null || O00000Oo() == 0) {
            return 0;
        }
        String str = XMediaplayerJNI.O0000o0;
        imc.O000000o(str, (Object) ("DownloadThread hls mHlsReadThread.getCacheIndex():" + this.O00000o.O000000o() + "getPlayUrlsLength():" + O00000Oo()));
        int O000000o2 = (int) ((((float) (this.O00000o.O000000o() + -1)) / ((float) O00000Oo())) * 100.0f);
        if (O000000o2 < 0) {
            return 0;
        }
        return O000000o2;
    }

    public ilx(String str, XMediaplayerJNI xMediaplayerJNI) {
        this.f1455O000000o = str;
        this.O00000oO = xMediaplayerJNI;
    }

    public final String O000000o(int i) {
        if (i < this.O00000o0.size()) {
            return this.O00000o0.get(i);
        }
        return null;
    }

    public final int O00000Oo() {
        return this.O00000o0.size();
    }

    public final int O00000o0() {
        String str = this.O00000Oo;
        if (str == null) {
            return -1;
        }
        return this.O00000o0.indexOf(str);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.imc.O000000o(java.lang.String, java.lang.Object):void
     arg types: [java.lang.String, java.lang.String]
     candidates:
      _m_j.imc.O000000o(java.lang.String, java.lang.String):void
      _m_j.imc.O000000o(java.lang.String, java.lang.Object):void */
    public final void O00000o() {
        ilz ilz = this.O00000o;
        if (ilz != null) {
            ilz.f1457O000000o = true;
            if (ilz.O00000o != null) {
                ilz.O00000o.clear();
            }
            imc.O000000o(XMediaplayerJNI.O0000o0, (Object) "HlsReadThread hls readData close");
        }
        LinkedBlockingQueue<ilu> linkedBlockingQueue = this.O00000oo;
        if (linkedBlockingQueue == null) {
            return;
        }
        if (linkedBlockingQueue.size() != 0 || !this.O0000O0o) {
            this.O00000oo.clear();
            return;
        }
        ilu ilu = new ilu();
        ilu.O00000oO = true;
        ilu.O00000oo = 500;
        this.O00000oo.add(ilu);
    }
}
