package _m_j;

import com.ximalaya.ting.android.player.XMediaplayerJNI;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.concurrent.LinkedBlockingQueue;

public final class imh extends Thread {

    /* renamed from: O000000o  reason: collision with root package name */
    volatile LinkedBlockingQueue<ilu> f1464O000000o;
    public volatile boolean O00000Oo;
    XMediaplayerJNI O00000o;
    ilv O00000o0;
    public String O00000oO;
    private ilr O00000oo;
    private volatile int O0000O0o;
    private volatile int O0000OOo;
    private volatile Object O0000Oo;
    private int O0000Oo0;
    private ilr O0000OoO;
    private volatile boolean O0000Ooo;

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.imc.O000000o(java.lang.String, java.lang.Object):void
     arg types: [java.lang.String, java.lang.String]
     candidates:
      _m_j.imc.O000000o(java.lang.String, java.lang.String):void
      _m_j.imc.O000000o(java.lang.String, java.lang.Object):void */
    private int O000000o() {
        int i = this.O00000o.O0000oOO / 65536;
        if (i == 0) {
            i = this.O00000oo.O000000o().O00000o0;
        }
        int i2 = (int) ((((float) (this.O0000Oo0 - 1)) / ((float) i)) * 100.0f);
        imc.O000000o("dl_mp3", (Object) ("getCachePercent percent:" + i2 + " mDownloadIndex:" + this.O0000Oo0 + "getComChunkNum:" + this.O00000oo.O000000o().O00000o0));
        if (i2 < 0) {
            return 0;
        }
        return i2;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.imc.O000000o(java.lang.String, java.lang.Object):void
     arg types: [java.lang.String, java.lang.String]
     candidates:
      _m_j.imc.O000000o(java.lang.String, java.lang.String):void
      _m_j.imc.O000000o(java.lang.String, java.lang.Object):void */
    /* JADX WARNING: Code restructure failed: missing block: B:11:?, code lost:
        r10.f1464O000000o.put(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x009b, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:?, code lost:
        r1.printStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0162, code lost:
        r3 = new _m_j.ilu();
        r3.O000000o(java.nio.ByteBuffer.allocate(65536));
        r3.f1452O000000o = r10.O0000OOo;
        r3.O00000o0 = true;
        _m_j.imc.O000000o("dl_mp3", (java.lang.Object) ("putLastChunk stopFlag:" + r10.O00000Oo + " curIndex:" + r10.O0000OOo + " getComChunkNum" + r1.O00000o0));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:?, code lost:
        O000000o(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x01a3, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:?, code lost:
        r1.printStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x006b, code lost:
        r1 = new _m_j.ilu();
        r1.O00000oO = true;
        r1.O00000oo = r10.O00000oo.O000000o().O00000oO;
        _m_j.imc.O000000o("dl_mp3", (java.lang.Object) ("resetIndex count5-1 put:" + r10.f1464O000000o.size()));
     */
    public final void run() {
        imc.O000000o("dl_mp3", (Object) "======================ReadThread run() start");
        while (true) {
            try {
                if (this.O00000Oo || !imd.O00000Oo(this.O00000o.O0000Oo0).equals(imd.O00000Oo(this.O00000oo.O000000o().f1454O000000o))) {
                    break;
                }
                imc.O000000o("dl_mp3", (Object) ("======================ReadThread start while(" + this.O0000OOo + ":" + this.O00000oo.O000000o().O00000o0 + ") stopFlag:" + this.O00000Oo + " curIndex:" + this.O0000OOo));
                ilw O000000o2 = this.O00000oo.O000000o();
                if (!O000000o2.O000000o()) {
                    break;
                }
                synchronized (this.O0000Oo) {
                    imc.O000000o("dl_mp3", (Object) ("resetIndex count6:" + this.f1464O000000o.size() + " stopFlag:" + this.O00000Oo + " curIndex:" + this.O0000OOo));
                    if (this.O0000Ooo) {
                        this.O0000Ooo = false;
                        this.O0000OOo = this.O0000O0o;
                        this.O0000Oo0 = this.O0000O0o;
                    }
                    imc.O000000o("dl_mp3", (Object) ("resetIndex count7:" + this.f1464O000000o.size() + " stopFlag:" + this.O00000Oo + " curIndex:" + this.O0000OOo));
                    StringBuilder sb = new StringBuilder("before put last item isResetIndex:");
                    sb.append(this.O0000Ooo);
                    imc.O000000o("dl_mp3", (Object) sb.toString());
                    if (this.O0000OOo >= O000000o2.O00000o0) {
                        break;
                    }
                    if (this.O0000Oo0 < this.O0000OOo) {
                        this.O0000Oo0 = this.O0000OOo;
                    }
                    int i = iml.O00000Oo - 3;
                    while (true) {
                        if (this.O0000Oo0 - this.O0000OOo >= i || this.f1464O000000o.size() < 3 || this.O00000Oo || this.O0000Oo0 >= O000000o2.O00000o0 || this.O0000Ooo) {
                            break;
                        }
                        if (this.O00000oO != null && this.O0000OoO == null && !this.O00000oO.equals(this.O00000oo.f1449O000000o)) {
                            try {
                                this.O0000OoO = new ilr(iml.O00000oO, this.O00000oO);
                            } catch (Exception e) {
                                e.printStackTrace();
                                this.O0000OoO.O000000o().O00000o = false;
                            }
                            if (this.O0000OoO.O000000o().O000000o() && !this.O0000OoO.O000000o().O000000o(0)) {
                                new ilv(this.O0000OoO, 0).O000000o();
                                if (this.O0000OoO.O00000Oo != null) {
                                    this.O0000OoO.O000000o(0, this.O0000OoO.O00000Oo.array(), this.O0000OoO.O00000Oo.array().length);
                                    this.O0000OoO.O00000Oo = null;
                                    imc.O000000o("dl_mp3", (Object) ("预缓冲 url_0:" + this.O0000OoO.f1449O000000o + " downloadIndex:0下载并且缓存成功"));
                                } else {
                                    imc.O000000o("dl_mp3", (Object) ("预缓冲 url_0:" + this.O0000OoO.f1449O000000o + " downloadIndex:0失败"));
                                }
                            }
                        }
                        boolean O000000o3 = this.O00000oo.O000000o().O000000o(this.O0000Oo0);
                        this.O00000o.O00000o0(O000000o());
                        if (!O000000o3) {
                            if (new ilv(this.O00000oo, this.O0000Oo0).O000000o() != 200) {
                                if (this.O00000oo.O00000Oo == null) {
                                    imc.O000000o("dl_mp3", (Object) ("url:" + this.O00000oo.f1449O000000o + " downloadIndex:" + this.O0000Oo0 + "下载失败error"));
                                    break;
                                }
                                this.O00000oo.O000000o(this.O0000Oo0, this.O00000oo.O00000Oo.array(), this.O00000oo.O00000Oo.array().length);
                                this.O00000oo.O00000Oo = null;
                                imc.O000000o("dl_mp3", (Object) ("url:" + this.O00000oo.f1449O000000o + " downloadIndex:" + this.O0000Oo0 + "下载并且缓存成功"));
                            } else {
                                throw new IOException();
                            }
                        }
                        this.O0000Oo0++;
                        imc.O000000o("dl_mp3", (Object) ("getCachePercent percent mDownloadIndex0:" + this.O0000Oo0));
                    }
                    if (this.O00000Oo) {
                        imc.O000000o("dl_mp3", (Object) ("fileDesc not Valid stopFlag:" + this.O00000Oo + " curIndex:" + this.O0000OOo));
                        break;
                    } else if (this.O0000Ooo) {
                        imc.O000000o("dl_mp3", (Object) ("fileDesc not Valid stopFlag:" + this.O00000Oo + " curIndex:" + this.O0000OOo + " isResetIndex:" + this.O0000Ooo));
                    } else {
                        this.O00000o.O00000o0(O000000o());
                        imc.O000000o("dl_mp3", (Object) ("开始获取分段数据：url:" + this.O00000oo.f1449O000000o + " curIndex:" + this.O0000OOo));
                        if (!this.O00000oo.O000000o().O000000o(this.O0000OOo)) {
                            imc.O000000o("dl_mp3", (Object) ("url:" + this.O00000oo.f1449O000000o + " curIndex:" + this.O0000OOo + "缓存命中失败"));
                            ilv ilv = new ilv(this.O00000oo, this.O0000OOo);
                            this.O00000o0 = ilv;
                            if (ilv.O000000o() != 200) {
                                if (this.O00000oo.O00000Oo == null) {
                                    imc.O000000o("dl_mp3", (Object) ("url:" + this.O00000oo.f1449O000000o + " curIndex:" + this.O0000OOo + "下载失败error"));
                                    break;
                                }
                                ilu ilu = new ilu();
                                ilu.O000000o(this.O00000oo.O00000Oo);
                                ilu.f1452O000000o = this.O0000OOo;
                                O000000o(ilu);
                                this.O00000oo.O000000o(this.O0000OOo, this.O00000oo.O00000Oo.array(), this.O00000oo.O00000Oo.array().length);
                                this.O00000oo.O00000Oo = null;
                                imc.O000000o("dl_mp3", (Object) ("url:" + this.O00000oo.f1449O000000o + " curIndex:" + this.O0000OOo + "下载并且缓存成功"));
                                this.O0000OOo = this.O0000OOo + 1;
                            } else {
                                throw new IOException();
                            }
                        } else {
                            imc.O000000o("dl_mp3", (Object) ("url:" + this.O00000oo.f1449O000000o + " curIndex:" + this.O0000OOo + "缓存命中成功"));
                            ilu O000000o4 = O000000o(this.O0000OOo);
                            if (O000000o4 != null) {
                                imc.O000000o("dl_mp3", (Object) ("url:" + this.O00000oo.f1449O000000o + " curIndex:" + this.O0000OOo + "缓存获取成功"));
                                O000000o(O000000o4);
                                this.O0000OOo = this.O0000OOo + 1;
                            } else {
                                imc.O000000o("dl_mp3", (Object) ("url:" + this.O00000oo.f1449O000000o + " curIndex:" + this.O0000OOo + "缓存获取失败error"));
                                ilv ilv2 = new ilv(this.O00000oo, this.O0000OOo);
                                this.O00000o0 = ilv2;
                                ilv2.O000000o();
                                if (this.O00000oo.O00000Oo != null) {
                                    ilu ilu2 = new ilu();
                                    ilu2.O000000o(this.O00000oo.O00000Oo);
                                    ilu2.f1452O000000o = this.O0000OOo;
                                    O000000o(ilu2);
                                    this.O00000oo.O00000Oo = null;
                                    this.O0000OOo++;
                                }
                            }
                        }
                        imc.O000000o("dl_mp3", (Object) ("结束获取分段数据：url:" + this.O00000oo.f1449O000000o + " curIndex:" + this.O0000OOo));
                        imc.O000000o("dl_mp3", (Object) ("======================ReadThread end while(" + this.O0000OOo + ":" + this.O00000oo.O000000o().O00000o0 + ") stopFlag:" + this.O00000Oo + " curIndex:" + this.O0000OOo));
                    }
                }
            } catch (Exception e2) {
                imc.O000000o("dl_mp3", (Object) ("ReadThread Exception:" + e2.getMessage()));
            }
        }
        this.O00000Oo = true;
        imc.O000000o("dl_mp3", (Object) "======================ReadThread run() end");
        this.O00000Oo = true;
        imc.O000000o("dl_mp3", (Object) "put LastChunk and close read thread");
        this.O00000Oo = true;
        imc.O000000o("dl_mp3", (Object) "======================ReadThread run() end");
        imc.O000000o("dl_mp3", (Object) ("resetIndex count5-2 put:" + this.f1464O000000o.size()));
        imc.O000000o("dl_mp3", (Object) ("fileDesc not Valid stopFlag:" + this.O00000Oo + " curIndex:" + this.O0000OOo));
        this.O00000Oo = true;
        this.O00000Oo = true;
        imc.O000000o("dl_mp3", (Object) "======================ReadThread run() end");
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.imc.O000000o(java.lang.String, java.lang.Object):void
     arg types: [java.lang.String, java.lang.String]
     candidates:
      _m_j.imc.O000000o(java.lang.String, java.lang.String):void
      _m_j.imc.O000000o(java.lang.String, java.lang.Object):void */
    private void O000000o(ilu ilu) throws InterruptedException {
        if (!this.O0000Ooo) {
            imc.O000000o("dl_mp3", (Object) ("putItem url:" + this.O00000oo.f1449O000000o + " item Index:" + ilu.f1452O000000o));
            StringBuilder sb = new StringBuilder("resetIndex count3 putItem:");
            sb.append(this.f1464O000000o.size());
            imc.O000000o("dl_mp3", (Object) sb.toString());
            this.f1464O000000o.put(ilu);
            imc.O000000o("dl_mp3", (Object) ("resetIndex count4 putItem:" + this.f1464O000000o.size()));
            return;
        }
        imc.O000000o("dl_mp3", (Object) ("resetIndex count5:" + this.f1464O000000o.size()));
    }

    private ilu O000000o(int i) {
        ByteBuffer allocate = ByteBuffer.allocate(65536);
        try {
            if (this.O00000oo.O000000o(i, allocate.array()) != 65536) {
                return null;
            }
            ilu ilu = new ilu();
            ilu.O000000o(allocate);
            ilu.f1452O000000o = i;
            return ilu;
        } catch (IOException unused) {
            return null;
        }
    }
}
