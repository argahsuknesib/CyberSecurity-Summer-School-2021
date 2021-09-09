package _m_j;

import com.ximalaya.ting.android.player.XMediaplayerJNI;
import java.util.concurrent.LinkedBlockingQueue;

public final class ilz extends Thread {

    /* renamed from: O000000o  reason: collision with root package name */
    boolean f1457O000000o;
    public Object O00000Oo;
    volatile LinkedBlockingQueue<ilu> O00000o;
    public volatile boolean O00000o0;
    private ilx O00000oO;
    private volatile int O00000oo;
    private int O0000O0o;
    private volatile int O0000OOo;
    private XMediaplayerJNI O0000Oo;
    private String O0000Oo0;
    private volatile Object O0000OoO;
    private volatile boolean O0000Ooo;

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.imc.O000000o(java.lang.String, java.lang.Object):void
     arg types: [java.lang.String, java.lang.String]
     candidates:
      _m_j.imc.O000000o(java.lang.String, java.lang.String):void
      _m_j.imc.O000000o(java.lang.String, java.lang.Object):void */
    public final void run() {
        this.O0000OOo = this.O00000oO.O00000o0();
        this.O0000Ooo = true;
        while (true) {
            if (this.f1457O000000o || !imd.O00000Oo(this.O0000Oo.O0000Oo0).equals(imd.O00000Oo(this.O0000Oo0))) {
                break;
            }
            synchronized (this.O0000OoO) {
                if (this.O0000Ooo) {
                    imc.O000000o("dl_hls", (Object) ("resetIndex isResetIndex buffItemQueue.size():" + this.O00000o.size()));
                    this.O0000Ooo = false;
                    this.O00000oo = this.O0000OOo;
                    this.O0000O0o = this.O0000OOo;
                }
            }
            if (this.O00000oo >= this.O00000oO.O00000Oo() && !this.O0000Oo.O0000o00.equals(XMediaplayerJNI.AudioType.HLS_FILE) && !this.O0000Ooo) {
                break;
            }
            if (this.O0000O0o < this.O00000oo) {
                this.O0000O0o = this.O00000oo;
            }
            int i = iml.O00000Oo - 3;
            while (this.O0000O0o - this.O00000oo < i && this.O00000o.size() >= 3 && !this.f1457O000000o && this.O0000O0o < this.O00000oO.O00000Oo() && !this.O0000Ooo) {
                String O000000o2 = this.O00000oO.O000000o(this.O0000O0o);
                if (new ily(O000000o2, null).O000000o() > 0) {
                    imc.O000000o("dl_hls", (Object) ("url:" + O000000o2 + " downloadIndex:" + this.O0000O0o + "下载并且缓存成功1"));
                    this.O0000O0o = this.O0000O0o + 1;
                    this.O0000Oo.O00000o0(this.O00000oO.O000000o());
                } else {
                    imc.O000000o("dl_hls", (Object) ("url:" + O000000o2 + " downloadIndex:" + this.O0000O0o + "下载失败error1"));
                }
                imc.O000000o("dl_hls", (Object) ("getCachePercent percent mDownloadIndex:" + this.O0000O0o));
            }
            if (this.f1457O000000o) {
                break;
            } else if (!this.O0000Ooo) {
                String O000000o3 = this.O00000oO.O000000o(this.O00000oo);
                imc.O000000o("dl_hls", (Object) ("HlsReadThread downUrl0:" + O000000o3 + "    cacheIndex:" + this.O00000oo + "getPlayUrlsLength:" + this.O00000oO.O00000Oo()));
                if (O000000o3 == null) {
                    if (!this.O0000Oo.O0000o00.equals(XMediaplayerJNI.AudioType.HLS_FILE)) {
                        break;
                    }
                    synchronized (this.O00000Oo) {
                        this.O00000o0 = true;
                        try {
                            this.O00000Oo.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                } else {
                    ilu ilu = new ilu();
                    ilu.f1452O000000o = this.O00000oo;
                    if (new ily(O000000o3, ilu).O000000o() <= 0) {
                        imc.O000000o("dl_hls", (Object) ("url:" + O000000o3 + " curIndex:" + this.O00000oo + "下载并且缓存失败2"));
                        break;
                    }
                    if (!this.O0000Ooo) {
                        imc.O000000o("dl_hls", (Object) ("putItem url:" + this.O00000oO.O000000o(ilu.f1452O000000o) + " item Index:" + ilu.f1452O000000o));
                        StringBuilder sb = new StringBuilder("putItem buffItemQueue.size()0:");
                        sb.append(this.O00000o.size());
                        imc.O000000o("dl_hls", (Object) sb.toString());
                        try {
                            this.O00000o.put(ilu);
                        } catch (InterruptedException unused) {
                        }
                        imc.O000000o("dl_hls", (Object) ("putItem buffItemQueue.size()1:" + this.O00000o.size()));
                    } else {
                        imc.O000000o("dl_hls", (Object) ("putItem buffItemQueue.size()2:" + this.O00000o.size()));
                    }
                    imc.O000000o("dl_hls", (Object) ("url:" + O000000o3 + " curIndex:" + this.O00000oo + "下载并且缓存成功2"));
                    this.O00000oo = this.O00000oo + 1;
                    this.O0000Oo.O00000o0(this.O00000oO.O000000o());
                }
            }
        }
        this.f1457O000000o = true;
        String str = XMediaplayerJNI.O0000o0;
        imc.O000000o(str, (Object) ("HlsReadThread isStop:" + this.f1457O000000o + "cacheIndex:" + this.O00000oo));
    }

    public final int O000000o() {
        int i = this.O0000O0o;
        return i == 0 ? this.O00000oO.O00000o0() : i;
    }
}
