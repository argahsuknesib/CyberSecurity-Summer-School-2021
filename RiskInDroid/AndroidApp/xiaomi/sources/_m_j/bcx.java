package _m_j;

import java.io.File;

public final class bcx {

    /* renamed from: O000000o  reason: collision with root package name */
    public final File f12875O000000o;
    public final File O00000Oo;
    public final int O00000o;
    public final int O00000o0;
    public final int O00000oO;
    public final int O00000oo;
    public final boolean O0000O0o;

    public bcx(File file, File file2, int i, int i2, int i3, int i4, boolean z) {
        this.f12875O000000o = file;
        this.O00000Oo = file2;
        this.O00000o0 = i;
        this.O00000o = i2;
        this.O00000oO = i3;
        this.O00000oo = i4;
        this.O0000O0o = z;
    }

    public final bcx O000000o(File file) {
        return new bcx(file, this.O00000Oo, this.O00000o0, this.O00000o, this.O00000oO, this.O00000oo, this.O0000O0o);
    }

    public final bcx O00000Oo(File file) {
        return new bcx(this.f12875O000000o, file, this.O00000o0, this.O00000o, this.O00000oO, this.O00000oo, this.O0000O0o);
    }

    public final File O000000o() {
        File file = this.O00000Oo;
        return file != null ? file : this.f12875O000000o;
    }
}
