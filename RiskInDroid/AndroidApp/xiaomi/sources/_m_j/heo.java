package _m_j;

import _m_j.hcu;
import android.text.TextUtils;
import android.util.Pair;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public final class heo extends hcu {
    public final List<O000000o> O00000Oo;

    public heo(List<O000000o> list) {
        super(1.0d);
        this.O00000Oo = Collections.unmodifiableList(list);
    }

    public final hdj O000000o(Number number, String str, hcu.O000000o o000000o) {
        int intValue = number.intValue();
        LinkedList linkedList = new LinkedList();
        int i = 0;
        while (true) {
            if (i >= this.O00000Oo.size()) {
                break;
            } else if (TextUtils.equals(this.O00000Oo.get(i).O00000Oo, str)) {
                int i2 = 1;
                while (true) {
                    if (i >= this.O00000Oo.size()) {
                        break;
                    }
                    O000000o o000000o2 = this.O00000Oo.get(i);
                    int i3 = intValue % o000000o2.O00000o0;
                    intValue /= o000000o2.O00000o0;
                    if (intValue != 0) {
                        if (!(o000000o2.f18847O000000o == 2 || (o000000o2.f18847O000000o == 1 && i3 == 0))) {
                            linkedList.addFirst(new Pair(String.valueOf(i3), o000000o2.O00000Oo));
                        }
                        i2 *= o000000o2.O00000o0;
                        i++;
                    } else if (linkedList.size() == 0) {
                        if (i2 > 1) {
                            double doubleValue = number.doubleValue();
                            double d = (double) i2;
                            Double.isNaN(d);
                            linkedList.addFirst(new Pair(o000000o.format(Double.valueOf(doubleValue / d)), o000000o2.O00000Oo));
                        } else {
                            linkedList.addFirst(new Pair(o000000o.format(number), o000000o2.O00000Oo));
                        }
                    } else if (i3 != 0) {
                        linkedList.addFirst(new Pair(String.valueOf(i3), o000000o2.O00000Oo));
                    }
                }
            } else {
                i++;
            }
        }
        return new hdj(linkedList);
    }

    public static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public final byte f18847O000000o;
        public final String O00000Oo;
        public final int O00000o0;

        public O000000o(byte b, int i, String str) {
            this.O00000o0 = i;
            this.f18847O000000o = b;
            this.O00000Oo = str;
        }
    }
}
