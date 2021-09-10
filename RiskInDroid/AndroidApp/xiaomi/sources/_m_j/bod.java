package _m_j;

import _m_j.boe;
import _m_j.bof;
import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public final class bod implements boe.O000000o, bof.O000000o {

    /* renamed from: O000000o  reason: collision with root package name */
    public bof f13155O000000o;
    private boe O00000Oo;
    private String O00000o = Environment.getExternalStorageDirectory().getPath();
    private Context O00000o0;
    private O000000o O00000oO;

    public interface O000000o {
        void O000000o();
    }

    static {
        System.loadLibrary("sinvoice");
    }

    public bod(Context context, O000000o o000000o) {
        this.O00000o0 = context;
        this.O00000oO = o000000o;
        this.f13155O000000o = new bof(context, this);
        this.O00000Oo = new boe(context, this);
    }

    public final boolean O000000o() {
        return 1 == this.f13155O000000o.O00000o0;
    }

    public final void O00000o0() {
        bof bof = this.f13155O000000o;
        bof.f13160O000000o.O00000o.destroy();
        boa boa = bof.O00000Oo;
        if (boa.O00000oO != null) {
            boa.O00000oO.stop();
            boa.O00000oO.release();
        }
        this.O00000Oo.O00000o0.O00000oO.destroy();
    }

    public final void O00000o() {
        O000000o o000000o = this.O00000oO;
        if (o000000o != null) {
            o000000o.O000000o();
        }
    }

    public final void O000000o(String str) {
        if (this.O00000oO != null) {
            TextUtils.isEmpty(str);
        }
    }

    public final void O00000Oo() {
        this.f13155O000000o.O00000o();
        bnx bnx = this.f13155O000000o.f13160O000000o;
        bnx.O00000oo = 1;
        bnx.O00000o.setEffect(1);
        boe boe = this.O00000Oo;
        if (1 == boe.O00000oo) {
            boe.O00000oo = 2;
            bob bob = boe.O00000Oo;
            if (1 == bob.f13153O000000o) {
                bob.f13153O000000o = 2;
            }
            bog bog = boe.O00000o0;
            if (1 == bog.f13164O000000o) {
                bog.f13164O000000o = 2;
            }
            boe.f13156O000000o.O00000Oo();
            if (boe.O00000o != null) {
                try {
                    boe.O00000o.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (Throwable th) {
                    boe.O00000o = null;
                    throw th;
                }
                boe.O00000o = null;
            }
            if (boe.O00000oO != null) {
                try {
                    boe.O00000oO.join();
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                } catch (Throwable th2) {
                    boe.O00000oO = null;
                    throw th2;
                }
                boe.O00000oO = null;
            }
        }
        this.O00000Oo.O00000o0.O00000oO.setEffect(1);
        boe boe2 = this.O00000Oo;
        if (2 == boe2.O00000oo) {
            boe2.O00000oo = 1;
            boe2.f13156O000000o.O000000o();
            boe2.O00000oO = new Thread() {
                /* class _m_j.boe.AnonymousClass2 */

                public final void run() {
                    bnv O00000Oo;
                    bog bog = boe.this.O00000o0;
                    if (2 == bog.f13164O000000o && bog.O00000o0 != null) {
                        bog.f13164O000000o = 1;
                        if (bog.O00000Oo != null) {
                            bog.O00000Oo.O00000o0();
                        }
                        if (bog.O0000O0o) {
                            try {
                                String path = Environment.getExternalStorageDirectory().getPath();
                                if (!TextUtils.isEmpty(path)) {
                                    bog.O00000o = new FileOutputStream(String.format("%s/record.pcm", path));
                                }
                            } catch (FileNotFoundException e) {
                                e.printStackTrace();
                            }
                        }
                        bog.O00000oO.start();
                        while (1 == bog.f13164O000000o && (O00000Oo = bog.O00000o0.O00000Oo()) != null && O00000Oo.f13149O000000o != null) {
                            bog.O00000oO.putData(O00000Oo.f13149O000000o, O00000Oo.O00000Oo);
                            bog.O00000o0.O00000Oo(O00000Oo);
                            if (bog.O0000O0o && bog.O00000o != null) {
                                try {
                                    bog.O00000o.write(O00000Oo.f13149O000000o);
                                } catch (IOException e2) {
                                    e2.printStackTrace();
                                }
                            }
                        }
                        bog.O00000oO.stop();
                        if (bog.O0000O0o && bog.O00000o != null) {
                            try {
                                bog.O00000o.close();
                                bog.O00000o = null;
                            } catch (IOException e3) {
                                e3.printStackTrace();
                            }
                        }
                        bog.f13164O000000o = 2;
                        if (bog.O00000Oo != null) {
                            bog.O00000Oo.O00000o();
                        }
                    }
                }
            };
            if (boe2.O00000oO != null) {
                boe2.O00000oO.start();
            }
            boe2.O00000o = new Thread(false) {
                /* class _m_j.boe.AnonymousClass3 */

                /* renamed from: O000000o  reason: collision with root package name */
                final /* synthetic */ boolean f13159O000000o = false;

                public final void run() {
                    bnv O000000o2;
                    int read;
                    bob bob = boe.this.O00000Oo;
                    boolean z = this.f13159O000000o;
                    if (2 != bob.f13153O000000o) {
                        return;
                    }
                    if (z) {
                        bob.f13153O000000o = 1;
                        if (bob.O00000o0 != null) {
                            try {
                                FileInputStream fileInputStream = new FileInputStream(new File("/sdcard/sinvoice.pcm"));
                                while (1 == bob.f13153O000000o && (O000000o2 = bob.O00000o0.O000000o()) != null && O000000o2.f13149O000000o != null && (read = fileInputStream.read(O000000o2.f13149O000000o)) >= 0) {
                                    O000000o2.O00000Oo = read;
                                    bob.O00000o0.O000000o(O000000o2);
                                }
                                fileInputStream.close();
                            } catch (FileNotFoundException e) {
                                e.printStackTrace();
                            } catch (IOException e2) {
                                e2.printStackTrace();
                            }
                        }
                    } else {
                        bob.O000000o();
                    }
                }
            };
            if (boe2.O00000o != null) {
                boe2.O00000o.start();
            }
        }
    }
}
