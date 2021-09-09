package _m_j;

import com.adobe.xmp.XMPException;
import java.util.SimpleTimeZone;

public final class mr {
    /* JADX WARNING: Removed duplicated region for block: B:125:0x021d  */
    public static mm O000000o(String str) throws XMPException {
        int i;
        int i2;
        if (str == null || str.length() == 0) {
            throw new XMPException("Empty convert-string", 5);
        }
        nb nbVar = new nb();
        if (str != null) {
            if (str.length() != 0) {
                mz mzVar = new mz(str);
                int i3 = 0;
                if (mzVar.O000000o(0) == '-') {
                    mzVar.O00000o0();
                }
                int O000000o2 = mzVar.O000000o("Invalid year in date string", 9999);
                if (!mzVar.O000000o() || mzVar.O00000Oo() == '-') {
                    if (mzVar.O000000o(0) == '-') {
                        O000000o2 = -O000000o2;
                    }
                    nbVar.O000000o(O000000o2);
                    if (mzVar.O000000o()) {
                        mzVar.O00000o0();
                        int O000000o3 = mzVar.O000000o("Invalid month in date string", 12);
                        if (!mzVar.O000000o() || mzVar.O00000Oo() == '-') {
                            nbVar.O00000Oo(O000000o3);
                            if (mzVar.O000000o()) {
                                mzVar.O00000o0();
                                int O000000o4 = mzVar.O000000o("Invalid day in date string", 31);
                                if (!mzVar.O000000o() || mzVar.O00000Oo() == 'T') {
                                    nbVar.O00000o0(O000000o4);
                                    if (mzVar.O000000o()) {
                                        mzVar.O00000o0();
                                        nbVar.O00000o(mzVar.O000000o("Invalid hour in date string", 23));
                                        if (mzVar.O000000o()) {
                                            if (mzVar.O00000Oo() == ':') {
                                                mzVar.O00000o0();
                                                int O000000o5 = mzVar.O000000o("Invalid minute in date string", 59);
                                                if (!mzVar.O000000o() || mzVar.O00000Oo() == ':' || mzVar.O00000Oo() == 'Z' || mzVar.O00000Oo() == '+' || mzVar.O00000Oo() == '-') {
                                                    nbVar.O00000oO(O000000o5);
                                                } else {
                                                    throw new XMPException("Invalid date string, after minute", 5);
                                                }
                                            }
                                            if (mzVar.O000000o()) {
                                                if (mzVar.O000000o() && mzVar.O00000Oo() == ':') {
                                                    mzVar.O00000o0();
                                                    int O000000o6 = mzVar.O000000o("Invalid whole seconds in date string", 59);
                                                    if (!mzVar.O000000o() || mzVar.O00000Oo() == '.' || mzVar.O00000Oo() == 'Z' || mzVar.O00000Oo() == '+' || mzVar.O00000Oo() == '-') {
                                                        nbVar.O00000oo(O000000o6);
                                                        if (mzVar.O00000Oo() == '.') {
                                                            mzVar.O00000o0();
                                                            int i4 = mzVar.f2190O000000o;
                                                            int O000000o7 = mzVar.O000000o("Invalid fractional seconds in date string", 999999999);
                                                            if (!mzVar.O000000o() || mzVar.O00000Oo() == 'Z' || mzVar.O00000Oo() == '+' || mzVar.O00000Oo() == '-') {
                                                                int i5 = mzVar.f2190O000000o - i4;
                                                                while (i5 > 9) {
                                                                    O000000o7 /= 10;
                                                                    i5--;
                                                                }
                                                                while (i5 < 9) {
                                                                    O000000o7 *= 10;
                                                                    i5++;
                                                                }
                                                                nbVar.O0000O0o(O000000o7);
                                                            } else {
                                                                throw new XMPException("Invalid date string, after fractional second", 5);
                                                            }
                                                        }
                                                    } else {
                                                        throw new XMPException("Invalid date string, after whole seconds", 5);
                                                    }
                                                } else if (!(mzVar.O00000Oo() == 'Z' || mzVar.O00000Oo() == '+' || mzVar.O00000Oo() == '-')) {
                                                    throw new XMPException("Invalid date string, after time", 5);
                                                }
                                                if (mzVar.O000000o()) {
                                                    if (mzVar.O00000Oo() == 'Z') {
                                                        mzVar.O00000o0();
                                                    } else if (mzVar.O000000o()) {
                                                        if (mzVar.O00000Oo() == '+') {
                                                            i = 1;
                                                        } else if (mzVar.O00000Oo() == '-') {
                                                            i = -1;
                                                        } else {
                                                            throw new XMPException("Time zone must begin with 'Z', '+', or '-'", 5);
                                                        }
                                                        mzVar.O00000o0();
                                                        i2 = mzVar.O000000o("Invalid time zone hour in date string", 23);
                                                        if (mzVar.O000000o()) {
                                                            if (mzVar.O00000Oo() == ':') {
                                                                mzVar.O00000o0();
                                                                i3 = mzVar.O000000o("Invalid time zone minute in date string", 59);
                                                            } else {
                                                                throw new XMPException("Invalid date string, after time zone hour", 5);
                                                            }
                                                        }
                                                        nbVar.O000000o(new SimpleTimeZone(((i2 * 3600 * 1000) + (i3 * 60 * 1000)) * i, ""));
                                                        if (mzVar.O000000o()) {
                                                            throw new XMPException("Invalid date string, extra chars at end", 5);
                                                        }
                                                    }
                                                    i2 = 0;
                                                    i = 0;
                                                    nbVar.O000000o(new SimpleTimeZone(((i2 * 3600 * 1000) + (i3 * 60 * 1000)) * i, ""));
                                                    if (mzVar.O000000o()) {
                                                    }
                                                }
                                            }
                                        }
                                    }
                                } else {
                                    throw new XMPException("Invalid date string, after day", 5);
                                }
                            }
                        } else {
                            throw new XMPException("Invalid date string, after month", 5);
                        }
                    }
                } else {
                    throw new XMPException("Invalid date string, after year", 5);
                }
            }
            return nbVar;
        }
        throw new XMPException("Parameter must not be null", 4);
    }
}
