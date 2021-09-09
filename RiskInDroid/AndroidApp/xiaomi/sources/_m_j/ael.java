package _m_j;

import _m_j.adt;
import android.support.v4.app.NotificationCompat;
import java.io.IOException;
import java.util.ArrayList;

public final class ael extends adf<aek> {
    public final String O00000Oo() {
        return "gmhd";
    }

    public final void O00000Oo(xm xmVar, adh adh) throws IOException {
    }

    public final void O00000o0(xm xmVar, adh adh) throws IOException {
    }

    public ael(xu xuVar) {
        super(xuVar);
    }

    public final void O000000o(xm xmVar, adh adh) throws IOException {
        adt adt = new adt(xmVar, adh);
        aek aek = (aek) this.O00000Oo;
        ArrayList arrayList = adt.O00000oo;
        boolean z = false;
        adt.O000000o o000000o = (adt.O000000o) arrayList.get(0);
        aek.O000000o(1, (o000000o.f12361O000000o & 2) == 2);
        aek.O000000o(2, (o000000o.f12361O000000o & 8) == 8);
        aek.O000000o(3, (o000000o.f12361O000000o & 32) == 32);
        aek.O000000o(4, (o000000o.f12361O000000o & 64) == 64);
        aek.O000000o(5, (o000000o.f12361O000000o & NotificationCompat.FLAG_HIGH_PRIORITY) == 128 ? "Horizontal" : "Vertical");
        aek.O000000o(6, (o000000o.f12361O000000o & 256) == 256 ? "Reverse" : "Normal");
        aek.O000000o(7, (o000000o.f12361O000000o & 512) == 512);
        aek.O000000o(8, (o000000o.f12361O000000o & 4096) == 4096);
        aek.O000000o(9, (o000000o.f12361O000000o & 8192) == 8192);
        if ((o000000o.f12361O000000o & 16384) == 16384) {
            z = true;
        }
        aek.O000000o(10, z);
        int i = o000000o.O00000Oo;
        if (i == -1) {
            aek.O000000o(11, "Right");
        } else if (i == 0) {
            aek.O000000o(11, "Left");
        } else if (i == 1) {
            aek.O000000o(11, "Center");
        }
        aek.O00000Oo(12, o000000o.O00000oo);
        aek.O000000o(13, o000000o.O0000O0o);
        aek.O000000o(14, o000000o.O0000OOo);
        int i2 = o000000o.O0000Oo0;
        if (i2 == 1) {
            aek.O000000o(15, "Bold");
        } else if (i2 == 2) {
            aek.O000000o(15, "Italic");
        } else if (i2 == 4) {
            aek.O000000o(15, "Underline");
        } else if (i2 == 8) {
            aek.O000000o(15, "Outline");
        } else if (i2 == 16) {
            aek.O000000o(15, "Shadow");
        } else if (i2 == 32) {
            aek.O000000o(15, "Condense");
        } else if (i2 == 64) {
            aek.O000000o(15, "Extend");
        }
        aek.O00000Oo(16, o000000o.O0000Oo);
        aek.O000000o(17, o000000o.O0000OoO);
    }

    public final /* synthetic */ add O000000o() {
        return new aek();
    }
}
