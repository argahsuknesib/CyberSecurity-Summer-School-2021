package _m_j;

import _m_j.imk;
import android.content.Context;
import android.text.TextUtils;
import com.ximalaya.ting.android.player.XMediaplayerJNI;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.IOException;

public final class imm implements imn {

    /* renamed from: O000000o  reason: collision with root package name */
    boolean f1477O000000o = false;
    public imn O00000Oo;
    public boolean O00000o;
    public Context O00000o0;
    String O00000oO;
    imk.O00000Oo O00000oo;
    imk.O00000o0 O0000O0o;
    public imk.O00000o O0000OOo;
    imk.O0000Oo O0000Oo;
    imk.O0000O0o O0000Oo0;
    imk.O0000o00 O0000OoO;
    imk.O0000Oo0 O0000Ooo;

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.imm.O000000o(android.content.Context, boolean):_m_j.imn
     arg types: [android.content.Context, int]
     candidates:
      _m_j.imm.O000000o(float, float):void
      _m_j.imm.O000000o(java.io.FileDescriptor, java.lang.String):void
      _m_j.imn.O000000o(float, float):void
      _m_j.imn.O000000o(java.io.FileDescriptor, java.lang.String):void
      _m_j.imm.O000000o(android.content.Context, boolean):_m_j.imn */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.imc.O000000o(java.lang.String, java.lang.Object):void
     arg types: [java.lang.String, java.lang.String]
     candidates:
      _m_j.imc.O000000o(java.lang.String, java.lang.String):void
      _m_j.imc.O000000o(java.lang.String, java.lang.Object):void */
    public imm(Context context, boolean z) {
        if (context != null) {
            this.O00000o0 = context.getApplicationContext();
            iml.O000000o(this.O00000o0);
            if (z) {
                this.f1477O000000o = true;
                this.O00000Oo = O000000o(this.O00000o0, true);
                return;
            }
            Context context2 = this.O00000o0;
            iml.O000000o(context2);
            this.f1477O000000o = false;
            String O00000o02 = imf.O00000o0();
            String property = System.getProperty("os.arch");
            if (TextUtils.isEmpty(O00000o02) || TextUtils.isEmpty(property)) {
                String str = XMediaplayerJNI.O0000o0;
                imc.O000000o(str, (Object) ("cpuinfo null:" + O00000o02 + "cpuArch:" + property));
            } else {
                if (O00000o02.contains("Marvell") && property.contains("armv5tel")) {
                    this.f1477O000000o = true;
                }
                String str2 = XMediaplayerJNI.O0000o0;
                imc.O000000o(str2, (Object) ("cpuinfo:" + O00000o02 + "cpuArch:" + property));
            }
            this.O00000Oo = O000000o(context2, true);
            return;
        }
        throw new RuntimeException("context cannot be null!!!!!!");
    }

    /* access modifiers changed from: package-private */
    public final imn O000000o(Context context, boolean z) {
        if (this.f1477O000000o) {
            this.O00000Oo = new imi();
        } else {
            imc.O000000o("jniHandler newXMediaplayer XMediaPlayer");
            this.O00000Oo = new imk(context, z);
        }
        return this.O00000Oo;
    }

    public final int O000000o() {
        return this.O00000Oo.O000000o();
    }

    public final XMediaplayerJNI.AudioType O00000Oo() {
        return this.O00000Oo.O00000Oo();
    }

    public final void O000000o(FileDescriptor fileDescriptor, String str) {
        this.O00000oO = str;
        this.O00000Oo.O000000o(fileDescriptor, str);
    }

    public final int O00000o0() {
        return this.O00000Oo.O00000o0();
    }

    public final int O00000o() {
        return this.O00000Oo.O00000o();
    }

    public final boolean O00000oO() {
        return this.O00000Oo.O00000oO();
    }

    public final void O00000oo() {
        this.O00000Oo.O00000oo();
    }

    public final void O0000O0o() {
        this.O00000Oo.O0000O0o();
    }

    public final void O0000Oo() {
        this.O00000Oo.O0000Oo();
    }

    public final void O0000OoO() {
        this.O00000Oo.O0000OoO();
    }

    public final void O000000o(int i) {
        this.O00000Oo.O000000o(i);
    }

    public final void O00000Oo(String str) {
        this.O00000oO = str;
        this.O00000Oo.O00000Oo(str);
    }

    public final void O000000o(imk.O00000Oo o00000Oo) {
        this.O00000oo = o00000Oo;
        this.O00000Oo.O000000o(this.O00000oo);
    }

    public final void O000000o(imk.O00000o0 o00000o0) {
        this.O0000O0o = o00000o0;
        this.O00000Oo.O000000o(this.O0000O0o);
    }

    public final void O000000o(imk.O00000o o00000o) {
        this.O0000OOo = o00000o;
        this.O00000Oo.O000000o(new imk.O00000o() {
            /* class _m_j.imm.AnonymousClass1 */

            /* JADX WARNING: Code restructure failed: missing block: B:23:0x00a5, code lost:
                if (r6 != null) goto L_0x0096;
             */
            /* JADX WARNING: Removed duplicated region for block: B:17:0x00a0 A[SYNTHETIC, Splitter:B:17:0x00a0] */
            public final boolean O000000o(int i, int i2) {
                FileInputStream fileInputStream;
                if (i2 == -1011) {
                    imm imm = imm.this;
                    Context context = imm.O00000o0;
                    boolean z = imm.this.O00000o;
                    imm.f1477O000000o = true;
                    imm.O00000Oo.O000000o((imk.O00000Oo) null);
                    imm.O00000Oo.O000000o((imk.O00000o0) null);
                    imm.O00000Oo.O000000o((imk.O00000o) null);
                    imm.O00000Oo.O000000o((imk.O0000O0o) null);
                    imm.O00000Oo.O000000o((imk.O0000Oo) null);
                    imm.O00000Oo.O000000o((imk.O0000o00) null);
                    imm.O00000Oo.O000000o((imk.O0000Oo0) null);
                    imm.O00000Oo = imm.O000000o(context, z);
                    imm.O00000Oo.O000000o(imm.O00000oo);
                    imm.O00000Oo.O000000o(imm.O0000O0o);
                    imm.O00000Oo.O000000o(imm.O0000OOo);
                    imm.O00000Oo.O000000o(imm.O0000Oo0);
                    imm.O00000Oo.O000000o(imm.O0000Oo);
                    imm.O00000Oo.O000000o(imm.O0000OoO);
                    imm.O00000Oo.O000000o(imm.O0000Ooo);
                    if (!TextUtils.isEmpty(imm.O00000oO)) {
                        if (imm.O00000oO.startsWith("http")) {
                            imm.O00000Oo.O00000Oo(imm.O00000oO);
                        } else {
                            try {
                                fileInputStream = new FileInputStream(imm.O00000oO);
                                try {
                                    imm.O00000Oo.O000000o(fileInputStream.getFD(), imm.O00000oO);
                                } catch (Exception unused) {
                                } catch (Throwable th) {
                                    th = th;
                                    if (fileInputStream != null) {
                                        try {
                                            fileInputStream.close();
                                        } catch (IOException unused2) {
                                        }
                                    }
                                    throw th;
                                }
                            } catch (Exception unused3) {
                                fileInputStream = null;
                            } catch (Throwable th2) {
                                th = th2;
                                fileInputStream = null;
                                if (fileInputStream != null) {
                                }
                                throw th;
                            }
                            try {
                                fileInputStream.close();
                            } catch (IOException unused4) {
                            }
                        }
                        imm.O00000Oo.O0000O0o();
                    }
                    return true;
                } else if (imm.this.O0000OOo != null) {
                    return imm.this.O0000OOo.O000000o(i, i2);
                } else {
                    return false;
                }
            }
        });
    }

    public final void O000000o(imk.O0000O0o o0000O0o) {
        this.O0000Oo0 = o0000O0o;
        this.O00000Oo.O000000o(this.O0000Oo0);
    }

    public final void O000000o(imk.O0000Oo o0000Oo) {
        this.O0000Oo = o0000Oo;
        this.O00000Oo.O000000o(this.O0000Oo);
    }

    public final void O000000o(imk.O0000o00 o0000o00) {
        this.O0000OoO = o0000o00;
        this.O00000Oo.O000000o(this.O0000OoO);
    }

    public final void O000000o(imk.O0000Oo0 o0000Oo0) {
        this.O0000Ooo = o0000Oo0;
        this.O00000Oo.O000000o(this.O0000Ooo);
    }

    public final void O000000o(float f, float f2) {
        this.O00000Oo.O000000o(f, f2);
    }

    public final void O0000OOo() {
        this.O00000Oo.O0000OOo();
    }

    public final void O0000Oo0() {
        this.O00000Oo.O0000Oo0();
    }

    public final void O000000o(imu imu) {
        imj.O000000o(imu);
    }

    public final void O000000o(float f, float f2, float f3) {
        imn imn = this.O00000Oo;
        if (imn != null) {
            imn.O000000o(f, f2, f3);
        }
    }

    public final void O00000o0(String str) {
        imn imn = this.O00000Oo;
        if (imn != null) {
            imn.O00000o0(str);
        }
    }

    public final void O000000o(imk.O0000OOo o0000OOo) {
        imn imn = this.O00000Oo;
        if (imn != null) {
            imn.O000000o(o0000OOo);
        }
    }
}
