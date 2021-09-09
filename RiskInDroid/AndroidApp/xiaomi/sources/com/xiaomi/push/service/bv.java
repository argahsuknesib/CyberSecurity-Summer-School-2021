package com.xiaomi.push.service;

import _m_j.eru;
import android.content.Context;
import com.google.android.exoplayer2.C;
import com.xiaomi.push.Cif;
import com.xiaomi.push.hp;
import com.xiaomi.push.ig;
import com.xiaomi.push.ik;
import com.xiaomi.push.il;
import com.xiaomi.push.io;
import com.xiaomi.push.iq;
import com.xiaomi.push.ir;
import com.xiaomi.push.is;
import com.xiaomi.push.iu;
import com.xiaomi.push.iw;
import com.xiaomi.push.iy;
import com.xiaomi.push.ja;

public class bv {
    private static ja a(hp hpVar, boolean z) {
        switch (bw.f6538a[hpVar.ordinal()]) {
            case 1:
                return new iq();
            case 2:
                return new iw();
            case 3:
                return new iu();
            case 4:
                return new iy();
            case 5:
                return new is();
            case 6:
                return new Cif();
            case 7:
                return new ik();
            case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                return new ir();
            case 9:
                if (z) {
                    return new io();
                }
                ig igVar = new ig();
                igVar.O00000Oo();
                return igVar;
            case 10:
                return new ik();
            default:
                return null;
        }
    }

    public static ja a(Context context, il ilVar) {
        if (ilVar.f127a) {
            return null;
        }
        byte[] O000000o2 = ilVar.O000000o();
        ja a2 = a(ilVar.f6426a, ilVar.f128b);
        if (a2 != null) {
            eru.O000000o(a2, O000000o2);
        }
        return a2;
    }
}
