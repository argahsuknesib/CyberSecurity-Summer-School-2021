package _m_j;

import com.ximalaya.ting.android.player.XMediaplayerJNI;
import java.util.concurrent.LinkedBlockingQueue;

public final class ims {

    /* renamed from: O000000o  reason: collision with root package name */
    private imt f1483O000000o;
    private XMediaplayerJNI O00000Oo;
    private LinkedBlockingQueue<ilu> O00000o;
    private int O00000o0 = 800;
    private volatile boolean O00000oO = false;
    private volatile boolean O00000oo = true;
    private int O0000O0o = 100;
    private Object O0000OOo = new Object();
    private boolean O0000Oo0 = false;

    public ims(XMediaplayerJNI xMediaplayerJNI) {
        this.O00000Oo = xMediaplayerJNI;
        this.O00000o = new LinkedBlockingQueue<>(1024);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.imc.O000000o(java.lang.String, java.lang.Object):void
     arg types: [java.lang.String, java.lang.String]
     candidates:
      _m_j.imc.O000000o(java.lang.String, java.lang.String):void
      _m_j.imc.O000000o(java.lang.String, java.lang.Object):void */
    public final void O000000o() {
        imc.O000000o(XMediaplayerJNI.O0000o0, (Object) "flv FlvLiveFile relase readDataT");
        this.O0000Oo0 = false;
        imt imt = this.f1483O000000o;
        if (imt != null) {
            imt.O000000o();
        }
        LinkedBlockingQueue<ilu> linkedBlockingQueue = this.O00000o;
        if (linkedBlockingQueue != null) {
            int size = linkedBlockingQueue.size();
            String str = XMediaplayerJNI.O0000o0;
            imc.O000000o(str, (Object) ("flv readDataT relase isPollData:" + this.O00000oO + " size:" + size));
            if (size != 0 || !this.O00000oO) {
                imc.O000000o(XMediaplayerJNI.O0000o0, (Object) "flv readDataT relase clear item start");
                this.O00000o.clear();
                imc.O000000o(XMediaplayerJNI.O0000o0, (Object) "flv readDataT relase clear item end");
                return;
            }
            imc.O000000o(XMediaplayerJNI.O0000o0, (Object) "flv readDataT relase put last buf item start");
            ilu ilu = new ilu();
            ilu.O00000oO = true;
            ilu.O00000oo = this.O00000o0;
            this.O00000o.add(ilu);
            imc.O000000o(XMediaplayerJNI.O0000o0, (Object) "flv readDataT relase put last buf item end");
        }
    }
}
