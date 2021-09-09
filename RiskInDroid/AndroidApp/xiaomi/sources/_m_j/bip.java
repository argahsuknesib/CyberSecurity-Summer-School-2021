package _m_j;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.inuker.bluetooth.library.connect.options.BleConnectOptions;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.UUID;

public final class bip implements bis, bld, Handler.Callback {

    /* renamed from: O000000o  reason: collision with root package name */
    private Handler f13005O000000o;
    private String O00000Oo;
    private bin O00000o0;

    private bip(String str, Looper looper) {
        this.O00000Oo = str;
        this.f13005O000000o = new Handler(looper, this);
    }

    private bin O00000o0() {
        if (this.O00000o0 == null) {
            this.O00000o0 = new bin(this.O00000Oo);
        }
        return this.O00000o0;
    }

    static bis O000000o(String str, Looper looper) {
        bip bip = new bip(str, looper);
        return (bis) blf.O000000o(bip, bis.class, bip);
    }

    public final void O000000o(BleConnectOptions bleConnectOptions, bjr bjr) {
        O00000o0().O000000o(new bje(bleConnectOptions, bjr));
    }

    public final void O000000o() {
        bin O00000o02 = O00000o0();
        O00000o02.O000000o();
        bky.O00000o0(String.format("Process disconnect", new Object[0]));
        if (O00000o02.O00000Oo != null) {
            O00000o02.O00000Oo.O0000OoO();
            O00000o02.O00000Oo = null;
        }
        for (bjl O0000OoO : O00000o02.f13003O000000o) {
            O0000OoO.O0000OoO();
        }
        O00000o02.f13003O000000o.clear();
        O00000o02.O00000o0.O00000o0();
    }

    public final void O000000o(UUID uuid, UUID uuid2, bjr bjr) {
        O00000o0().O000000o(new bji(uuid, uuid2, bjr));
    }

    public final void O000000o(UUID uuid, UUID uuid2, byte[] bArr, bjr bjr) {
        O00000o0().O000000o(new bjp(uuid, uuid2, bArr, bjr));
    }

    public final void O00000Oo(UUID uuid, UUID uuid2, byte[] bArr, bjr bjr) {
        O00000o0().O000000o(new bjo(uuid, uuid2, bArr, bjr));
    }

    public final void O000000o(UUID uuid, UUID uuid2, UUID uuid3, bjr bjr) {
        O00000o0().O000000o(new bjh(uuid, uuid2, uuid3, bjr));
    }

    public final void O000000o(UUID uuid, UUID uuid2, UUID uuid3, byte[] bArr, bjr bjr) {
        O00000o0().O000000o(new bjn(uuid, uuid2, uuid3, bArr, bjr));
    }

    public final void O00000Oo(UUID uuid, UUID uuid2, bjr bjr) {
        O00000o0().O000000o(new bjg(uuid, uuid2, bjr));
    }

    public final void O00000o0(UUID uuid, UUID uuid2, bjr bjr) {
        O00000o0().O000000o(new bjm(uuid, uuid2, bjr));
    }

    public final void O000000o(bjr bjr) {
        O00000o0().O000000o(new bjj(bjr));
    }

    public final void O00000o(UUID uuid, UUID uuid2, bjr bjr) {
        O00000o0().O000000o(new bjf(uuid, uuid2, bjr));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x004a, code lost:
        if ((r5 instanceof _m_j.bjo) == false) goto L_0x0066;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x005c, code lost:
        if ((r5 instanceof _m_j.bjf) == false) goto L_0x0066;
     */
    public final void O000000o(int i) {
        boolean z;
        bin O00000o02 = O00000o0();
        O00000o02.O000000o();
        bky.O00000o0(String.format("clearRequest %d", Integer.valueOf(i)));
        LinkedList<bjl> linkedList = new LinkedList<>();
        if (i == 0) {
            linkedList.addAll(O00000o02.f13003O000000o);
        } else {
            Iterator<bjl> it = O00000o02.f13003O000000o.iterator();
            while (it.hasNext()) {
                bjl next = it.next();
                if ((i & 1) != 0) {
                    z = next instanceof bji;
                } else {
                    if ((i & 2) == 0) {
                        if ((i & 4) != 0) {
                            if (!(next instanceof bjg)) {
                                if (!(next instanceof bjm)) {
                                }
                            }
                        } else if ((i & 8) != 0) {
                            z = next instanceof bjj;
                        }
                        z = false;
                    } else if (!(next instanceof bjp)) {
                    }
                    z = true;
                }
                if (z) {
                    linkedList.add(next);
                }
            }
        }
        for (bjl O0000OoO : linkedList) {
            O0000OoO.O0000OoO();
        }
        O00000o02.f13003O000000o.removeAll(linkedList);
    }

    public final void O00000Oo() {
        O00000o0().O000000o(new bjk());
    }

    public final boolean O000000o(Object obj, Method method, Object[] objArr) {
        this.f13005O000000o.obtainMessage(0, new blc(obj, method, objArr)).sendToTarget();
        return true;
    }

    public final boolean handleMessage(Message message) {
        ((blc) message.obj).O000000o();
        return true;
    }
}
