package _m_j;

import android.os.Bundle;
import android.text.TextUtils;
import com.xiaomi.smarthome.library.bluetooth.BleConnectOptions;
import com.xiaomi.smarthome.library.bluetooth.connect.response.BleConnectResponse;

public abstract class fgn {

    /* renamed from: O000000o  reason: collision with root package name */
    protected int f16274O000000o;
    public String O00000Oo;
    public BleConnectOptions O00000o;
    protected byte[] O00000o0;
    public gle O00000oO;
    protected Bundle O00000oo;
    protected volatile boolean O0000O0o;
    protected fgp O0000OOo;

    /* access modifiers changed from: protected */
    public void O000000o(int i) {
    }

    /* access modifiers changed from: protected */
    public abstract void O000000o(int i, Bundle bundle);

    /* access modifiers changed from: protected */
    public void O00000Oo() {
    }

    /* access modifiers changed from: protected */
    public abstract fgm O00000o0();

    public fgn(String str, int i, BleConnectOptions bleConnectOptions) {
        this(str, i, null, bleConnectOptions);
    }

    public fgn(String str, int i, byte[] bArr, BleConnectOptions bleConnectOptions) {
        this.O0000OOo = new fgp() {
            /* class _m_j.fgn.AnonymousClass2 */

            public final String O000000o() {
                return fgn.this.O00000Oo;
            }

            public final int O00000Oo() {
                return fgn.this.f16274O000000o;
            }

            public final byte[] O00000o0() {
                return fgn.this.O00000o0;
            }

            public final void O000000o(int i, Bundle bundle) {
                fgn.this.O000000o("action.ble.connect", i, bundle);
            }

            public final void O000000o(Bundle bundle) {
                fgn.this.O000000o("action.ble.auth", -33, bundle);
            }
        };
        this.O00000Oo = str;
        this.f16274O000000o = i;
        this.O00000o0 = bArr;
        this.O00000o = bleConnectOptions;
        this.O00000oo = new Bundle();
        this.O00000oo.setClassLoader(getClass().getClassLoader());
        this.O00000oo.putString("launcher_type_statis", ((this instanceof fgx) || (this instanceof fgz) || (this instanceof fhf) || (this instanceof fhk)) ? "login" : "register");
    }

    public void O000000o(gle gle) {
        fte.O00000Oo(String.format("%s for %s", getClass().getSimpleName(), fte.O000000o(this.O00000Oo)));
        this.O00000oO = gle;
        fgm O00000o02 = O00000o0();
        if (O00000o02 != null) {
            O00000o02.O000000o(this.O00000o, new BleConnectResponse() {
                /* class _m_j.fgn.AnonymousClass1 */

                public final /* synthetic */ void onResponse(int i, Object obj) {
                    Bundle bundle = (Bundle) obj;
                    if (i == 0) {
                        fgn.this.O000000o("action.ble.auth", i, bundle);
                        if (bundle != null) {
                            fgn.this.O00000oo.putAll(bundle);
                        }
                        fgn.this.O000000o(i, bundle);
                        return;
                    }
                    boolean z = false;
                    if (bundle != null) {
                        z = bundle.getBoolean("key_is_connect_failed", false);
                    }
                    if (!z) {
                        fgn.this.O000000o("action.ble.auth", i, bundle);
                    }
                    fgn.this.O000000o(i);
                    fgn.this.O00000Oo(i);
                }
            });
            return;
        }
        throw new IllegalArgumentException("Ble security connector should not be null");
    }

    public final void O000000o() {
        this.O0000O0o = true;
        fgm O00000o02 = O00000o0();
        if (O00000o02 != null) {
            O00000o02.O00000Oo = true;
        }
        O00000Oo();
    }

    public final void O000000o(String str, int i) {
        O000000o(str, i, this.O00000oo);
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0038  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0060  */
    public final void O000000o(String str, int i, Bundle bundle) {
        char c;
        int hashCode = str.hashCode();
        if (hashCode != -1886663917) {
            if (hashCode != -1886645848) {
                if (hashCode == -64745569 && str.equals("action.ble.connect")) {
                    c = 0;
                    if (c != 0) {
                        gle gle = this.O00000oO;
                        if (gle != null) {
                            gle.O000000o(i, bundle);
                            return;
                        }
                        return;
                    } else if (c == 1) {
                        gle gle2 = this.O00000oO;
                        if (gle2 != null) {
                            gle2.O00000Oo(i, bundle);
                            return;
                        }
                        return;
                    } else if (c != 2) {
                        fte.O00000Oo(String.format("notifyBindProcess: unknown action = %s, code = %d", str, Integer.valueOf(i)));
                        return;
                    } else {
                        gle gle3 = this.O00000oO;
                        if (gle3 != null) {
                            gle3.O00000o0(i, bundle);
                            return;
                        }
                        return;
                    }
                }
            } else if (str.equals("action.ble.bind")) {
                c = 2;
                if (c != 0) {
                }
            }
        } else if (str.equals("action.ble.auth")) {
            c = 1;
            if (c != 0) {
            }
        }
        c = 65535;
        if (c != 0) {
        }
    }

    public final void O00000Oo(int i) {
        if (this.O0000O0o) {
            i = -2;
        }
        boolean z = false;
        fte.O00000Oo(String.format("SecureConnect onResponse: code = %s", gmc.O000000o(i)));
        byte[] O0000o0o = ffr.O0000o0o(this.O00000Oo);
        if (!got.O00000o(O0000o0o)) {
            this.O00000oo.putByteArray("token", O0000o0o);
        }
        if (this.O00000oO != null) {
            try {
                this.O00000oo.putString("key_version", ffr.O00oOooo(this.O00000Oo));
                this.O00000oO.O00000o(i, this.O00000oo);
            } catch (Exception e) {
                gnk.O00000oO(gnk.O00000Oo(e));
            }
        }
        this.O00000oO = null;
        if (i != 0) {
            String str = this.O00000Oo;
            if (!TextUtils.isEmpty(str) && gnl.O000000o()) {
                if (gnl.O00000o0().getConnectionState(gnl.O00000Oo(str), 7) == 0) {
                    z = true;
                }
            }
            if (!z) {
                glw.O000000o().disconnect(this.O00000Oo);
            }
        }
    }
}
