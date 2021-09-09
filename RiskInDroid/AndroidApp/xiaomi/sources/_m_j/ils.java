package _m_j;

import com.ximalaya.ting.android.player.XMediaplayerJNI;
import java.util.concurrent.LinkedBlockingQueue;

public final class ils {
    public static int O00000o = -1;
    public static int O00000o0 = -2;

    /* renamed from: O000000o  reason: collision with root package name */
    public imh f1450O000000o;
    public String O00000Oo = null;
    public volatile int O00000oO = 0;
    private XMediaplayerJNI O00000oo;
    private LinkedBlockingQueue<ilu> O0000O0o;
    private volatile boolean O0000OOo = false;
    private int O0000Oo0 = 1000;

    public ils(XMediaplayerJNI xMediaplayerJNI) {
        this.O00000oo = xMediaplayerJNI;
        this.O00000oO = 0;
    }

    public final boolean O000000o() {
        return this.O00000oO < 0;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.imc.O000000o(java.lang.String, java.lang.Object):void
     arg types: [java.lang.String, java.lang.String]
     candidates:
      _m_j.imc.O000000o(java.lang.String, java.lang.String):void
      _m_j.imc.O000000o(java.lang.String, java.lang.Object):void */
    public final void O000000o(int i) {
        if (i == 0) {
            i = O00000o;
        }
        this.O00000oO = i;
        String str = XMediaplayerJNI.O0000o0;
        imc.O000000o(str, (Object) ("AudioFileRequestHandler release mReadThread.close" + toString()));
        imh imh = this.f1450O000000o;
        if (imh != null) {
            String str2 = XMediaplayerJNI.O0000o0;
            imc.O000000o(str2, (Object) ("mReadThread close" + imh.toString()));
            imh.O00000Oo = true;
            imh.f1464O000000o.clear();
            if (imh.O00000o0 != null) {
                imh.O00000o0.f1453O000000o = true;
            }
            imh.O00000o = null;
            String str3 = XMediaplayerJNI.O0000o0;
            imc.O000000o(str3, (Object) ("AudioFileRequestHandler release mReadThread.close" + this.f1450O000000o.toString()));
        }
        if (this.O0000O0o != null) {
            String str4 = XMediaplayerJNI.O0000o0;
            imc.O000000o(str4, (Object) ("AudioFileRequestHandler release buffItemQueue.size():" + this.O0000O0o.size() + " isPollData:" + this.O0000OOo));
            if (this.O0000O0o.size() != 0 || !this.O0000OOo) {
                this.O0000O0o.clear();
                imc.O000000o(XMediaplayerJNI.O0000o0, (Object) "AudioFileRequestHandler release buffItemQueue.clear");
                return;
            }
            ilu ilu = new ilu();
            ilu.O00000oO = true;
            ilu.O00000oo = this.O0000Oo0;
            this.O0000O0o.add(ilu);
            String str5 = XMediaplayerJNI.O0000o0;
            imc.O000000o(str5, (Object) ("AudioFileRequestHandler release normalReleaseCode:" + this.O0000Oo0));
        }
    }
}
