package _m_j;

import com.xiaomi.smarthome.core.server.internal.bluetooth.recognizer.beacon.MiotBleAdvPacket;

public final class fgc {
    public static MiotBleAdvPacket O000000o(fga fga) {
        if (fga.O00000Oo != 22) {
            return null;
        }
        fgd fgd = new fgd(fga);
        if (fgd.O000000o() != 65173) {
            return null;
        }
        try {
            return O00000Oo(fgd);
        } catch (Exception unused) {
            return O000000o(fgd);
        }
    }

    private static MiotBleAdvPacket O000000o(fgd fgd) {
        MiotBleAdvPacket miotBleAdvPacket = new MiotBleAdvPacket();
        try {
            fgd.O00000Oo.position(fgd.f16255O000000o.length - 2);
            miotBleAdvPacket.O00000Oo = fgd.O000000o();
            return miotBleAdvPacket;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static MiotBleAdvPacket O00000Oo(fgd fgd) {
        MiotBleAdvPacket miotBleAdvPacket = new MiotBleAdvPacket();
        miotBleAdvPacket.f6871O000000o = new MiotBleAdvPacket.FrameControl();
        int O00000Oo = fgd.O00000Oo();
        miotBleAdvPacket.f6871O000000o.f6874O000000o = fgd.O000000o(O00000Oo, 3);
        miotBleAdvPacket.f6871O000000o.O00000Oo = fgd.O000000o(O00000Oo, 4);
        miotBleAdvPacket.f6871O000000o.O00000o0 = fgd.O000000o(O00000Oo, 5);
        miotBleAdvPacket.f6871O000000o.O00000o = fgd.O000000o(O00000Oo, 6);
        miotBleAdvPacket.f6871O000000o.O00000oO = fgd.O000000o(O00000Oo, 7);
        int O00000Oo2 = fgd.O00000Oo();
        miotBleAdvPacket.f6871O000000o.O00000oo = fgd.O000000o(O00000Oo2, 0);
        miotBleAdvPacket.f6871O000000o.O0000O0o = fgd.O000000o(O00000Oo2, 1);
        miotBleAdvPacket.f6871O000000o.O0000OOo = fgd.O000000o(O00000Oo2, 2, 3);
        miotBleAdvPacket.f6871O000000o.O0000Oo0 = fgd.O000000o(O00000Oo2, 4, 7);
        miotBleAdvPacket.O00000Oo = fgd.O000000o();
        miotBleAdvPacket.O00000o0 = fgd.O00000Oo();
        if (miotBleAdvPacket.f6871O000000o.O00000Oo) {
            String[] strArr = new String[6];
            for (int i = 5; i >= 0; i--) {
                strArr[i] = String.format("%02x", Integer.valueOf(fgd.O00000Oo())).toUpperCase();
            }
            miotBleAdvPacket.O00000o = gqb.O000000o(strArr, ":");
        }
        if (miotBleAdvPacket.f6871O000000o.O00000o0) {
            int O00000Oo3 = fgd.O00000Oo();
            miotBleAdvPacket.O00000oO = new MiotBleAdvPacket.Capability();
            miotBleAdvPacket.O00000oO.f6872O000000o = fgd.O000000o(O00000Oo3, 0);
            miotBleAdvPacket.O00000oO.O00000Oo = fgd.O000000o(O00000Oo3, 1);
            miotBleAdvPacket.O00000oO.O00000o0 = fgd.O000000o(O00000Oo3, 2);
            miotBleAdvPacket.O00000oO.O00000o = fgd.O000000o(O00000Oo3, 3, 4);
            miotBleAdvPacket.O00000oO.O00000oO = fgd.O000000o(O00000Oo3, 5);
        }
        if (miotBleAdvPacket.O000000o()) {
            String[] strArr2 = new String[2];
            for (int i2 = 1; i2 >= 0; i2--) {
                strArr2[i2] = String.format("%02x", Integer.valueOf(fgd.O00000Oo())).toUpperCase();
            }
            miotBleAdvPacket.O00000oo = gqb.O000000o(strArr2, "");
        }
        if (miotBleAdvPacket.f6871O000000o.O00000o0 && miotBleAdvPacket.O00000oO.O00000oO) {
            int O00000Oo4 = fgd.O00000Oo();
            miotBleAdvPacket.O0000O0o = new MiotBleAdvPacket.IoCapability();
            miotBleAdvPacket.O0000O0o.f6875O000000o = fgd.O000000o(O00000Oo4, 0, 3);
            miotBleAdvPacket.O0000O0o.O00000Oo = fgd.O000000o(O00000Oo4, 4, 7);
            fgd.O00000Oo();
        }
        try {
            if (miotBleAdvPacket.f6871O000000o.O00000o) {
                miotBleAdvPacket.O0000OOo = new MiotBleAdvPacket.Event();
                if (miotBleAdvPacket.f6871O000000o.O0000Oo0 >= 5) {
                    miotBleAdvPacket.O0000OOo.O00000Oo = fgd.O00000Oo();
                    miotBleAdvPacket.O0000OOo.f6873O000000o = fgd.O00000Oo();
                } else {
                    miotBleAdvPacket.O0000OOo.f6873O000000o = fgd.O000000o();
                    miotBleAdvPacket.O0000OOo.O00000Oo = fgd.O00000Oo();
                }
                if (miotBleAdvPacket.O0000OOo.O00000Oo > 0) {
                    for (int i3 = 0; i3 < miotBleAdvPacket.O0000OOo.O00000Oo; i3++) {
                        fgd.O00000Oo();
                    }
                }
            }
            if (miotBleAdvPacket.f6871O000000o.f6874O000000o) {
                miotBleAdvPacket.O0000Oo0 = new int[3];
                miotBleAdvPacket.O0000Oo0[0] = fgd.O00000Oo();
                miotBleAdvPacket.O0000Oo0[1] = fgd.O00000Oo();
                miotBleAdvPacket.O0000Oo0[2] = fgd.O00000Oo();
                if (miotBleAdvPacket.f6871O000000o.O0000Oo0 >= 4) {
                    miotBleAdvPacket.O0000Oo = new int[4];
                    miotBleAdvPacket.O0000Oo[0] = fgd.O00000Oo();
                    miotBleAdvPacket.O0000Oo[1] = fgd.O00000Oo();
                    miotBleAdvPacket.O0000Oo[2] = fgd.O00000Oo();
                    miotBleAdvPacket.O0000Oo[3] = fgd.O00000Oo();
                } else {
                    miotBleAdvPacket.O0000Oo = new int[1];
                    miotBleAdvPacket.O0000Oo[0] = fgd.O00000Oo();
                }
            }
            if (miotBleAdvPacket.f6871O000000o.O00000oO) {
                miotBleAdvPacket.O0000OoO = new MiotBleAdvPacket.Mesh();
                int O00000Oo5 = fgd.O00000Oo();
                miotBleAdvPacket.O0000OoO.f6876O000000o = fgd.O000000o(O00000Oo5, 0, 1);
                miotBleAdvPacket.O0000OoO.O00000Oo = fgd.O000000o(O00000Oo5, 2, 3);
                miotBleAdvPacket.O0000OoO.O00000o0 = fgd.O000000o(O00000Oo5, 4, 7);
                fgd.O00000Oo();
            }
        } catch (Exception unused) {
        }
        return miotBleAdvPacket;
    }
}
