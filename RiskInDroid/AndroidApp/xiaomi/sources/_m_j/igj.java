package _m_j;

import com.xiaomi.zxing.NotFoundException;

final class igj {

    /* renamed from: O000000o  reason: collision with root package name */
    idm f1272O000000o;
    idg O00000Oo;
    idg O00000o;
    idg O00000o0;
    idg O00000oO;
    int O00000oo;
    int O0000O0o;
    int O0000OOo;
    int O0000Oo0;

    igj(idm idm, idg idg, idg idg2, idg idg3, idg idg4) throws NotFoundException {
        if (!(idg == null && idg3 == null) && (!(idg2 == null && idg4 == null) && ((idg == null || idg2 != null) && (idg3 == null || idg4 != null)))) {
            O000000o(idm, idg, idg2, idg3, idg4);
            return;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    igj(igj igj) {
        O000000o(igj.f1272O000000o, igj.O00000Oo, igj.O00000o0, igj.O00000o, igj.O00000oO);
    }

    private void O000000o(idm idm, idg idg, idg idg2, idg idg3, idg idg4) {
        this.f1272O000000o = idm;
        this.O00000Oo = idg;
        this.O00000o0 = idg2;
        this.O00000o = idg3;
        this.O00000oO = idg4;
        O000000o();
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0029  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x004f  */
    public final igj O000000o(int i, int i2, boolean z) throws NotFoundException {
        idg idg;
        idg idg2;
        idg idg3;
        idg idg4;
        idg idg5;
        idg idg6 = this.O00000Oo;
        idg idg7 = this.O00000o0;
        idg idg8 = this.O00000o;
        idg idg9 = this.O00000oO;
        if (i > 0) {
            idg idg10 = z ? idg6 : idg8;
            int i3 = ((int) idg10.O00000Oo) - i;
            if (i3 < 0) {
                i3 = 0;
            }
            idg idg11 = new idg(idg10.f1209O000000o, (float) i3);
            if (z) {
                idg2 = idg11;
            } else {
                idg = idg11;
                idg2 = idg6;
                if (i2 <= 0) {
                    if (z) {
                        idg5 = this.O00000o0;
                    } else {
                        idg5 = this.O00000oO;
                    }
                    int i4 = ((int) idg5.O00000Oo) + i2;
                    if (i4 >= this.f1272O000000o.O00000Oo) {
                        i4 = this.f1272O000000o.O00000Oo - 1;
                    }
                    idg idg12 = new idg(idg5.f1209O000000o, (float) i4);
                    if (z) {
                        idg4 = idg12;
                    } else {
                        idg3 = idg12;
                        idg4 = idg7;
                        O000000o();
                        return new igj(this.f1272O000000o, idg2, idg4, idg, idg3);
                    }
                } else {
                    idg4 = idg7;
                }
                idg3 = idg9;
                O000000o();
                return new igj(this.f1272O000000o, idg2, idg4, idg, idg3);
            }
        } else {
            idg2 = idg6;
        }
        idg = idg8;
        if (i2 <= 0) {
        }
        idg3 = idg9;
        O000000o();
        return new igj(this.f1272O000000o, idg2, idg4, idg, idg3);
    }

    private void O000000o() {
        if (this.O00000Oo == null) {
            this.O00000Oo = new idg(0.0f, this.O00000o.O00000Oo);
            this.O00000o0 = new idg(0.0f, this.O00000oO.O00000Oo);
        } else if (this.O00000o == null) {
            this.O00000o = new idg((float) (this.f1272O000000o.f1214O000000o - 1), this.O00000Oo.O00000Oo);
            this.O00000oO = new idg((float) (this.f1272O000000o.f1214O000000o - 1), this.O00000o0.O00000Oo);
        }
        this.O00000oo = (int) Math.min(this.O00000Oo.f1209O000000o, this.O00000o0.f1209O000000o);
        this.O0000O0o = (int) Math.max(this.O00000o.f1209O000000o, this.O00000oO.f1209O000000o);
        this.O0000OOo = (int) Math.min(this.O00000Oo.O00000Oo, this.O00000o.O00000Oo);
        this.O0000Oo0 = (int) Math.max(this.O00000o0.O00000Oo, this.O00000oO.O00000Oo);
    }
}
