package _m_j;

import _m_j.dpd;
import _m_j.dpf;
import android.util.SparseIntArray;
import android.view.View;
import com.tmall.wireless.vaf.framework.VafContext;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

@Deprecated
public final class dpm extends dpd {
    private SparseIntArray O000o;
    private int O000o0 = 0;
    private int O000o00O = 0;
    private int O000o00o = 0;
    private int O000o0O = 0;
    private int O000o0O0 = 0;
    private int O000o0OO;
    private int O000o0Oo;
    private int O000o0o;
    private int O000o0o0;
    private int[] O000o0oo;
    private boolean[] O000oO0;
    private List<dpn> O000oO00 = new ArrayList();

    private static boolean O0000Oo0(int i) {
        return i == 0 || i == 1;
    }

    public dpm(VafContext vafContext, dpg dpg) {
        super(vafContext, dpg);
    }

    private void O0000OOo(int i, int i2) {
        int i3;
        int i4;
        O00000o0 o00000o0;
        int i5;
        int i6;
        int i7 = i;
        int i8 = i2;
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        this.O000oO00.clear();
        int size2 = this.f14825O000000o.size();
        int O000O0o0 = O000O0o0();
        int O000O0oO = O000O0oO();
        dpn dpn = new dpn();
        int i9 = O000O0o0 + O000O0oO;
        dpn.O00000oO = i9;
        dpn dpn2 = dpn;
        int i10 = 0;
        int i11 = Integer.MIN_VALUE;
        int i12 = 0;
        int i13 = 0;
        while (i12 < size2) {
            dpf O0000Oo = O0000Oo(i12);
            if (O0000Oo != null) {
                if (O0000Oo.O0000ooO() == 2) {
                    dpn2.O0000OOo++;
                } else {
                    O00000o0 o00000o02 = (O00000o0) O0000Oo.O000O0oo();
                    if (o00000o02.O0000o0O == 4) {
                        dpn2.O0000Ooo.add(Integer.valueOf(i12));
                    }
                    int i14 = o00000o02.O00000Oo;
                    if (o00000o02.O0000o0o != -1.0f && mode == 1073741824) {
                        i14 = Math.round(((float) size) * o00000o02.O0000o0o);
                    }
                    O0000Oo.measureComponent(O000000o(i7, O00oOoOo() + O000O0o() + o00000o02.O00000o + o00000o02.O00000oo, o00000o02.f14826O000000o), O000000o(i8, O000O0o0() + O000O0oO() + o00000o02.O0000OOo + o00000o02.O0000Oo, i14));
                    O00000Oo(O0000Oo);
                    int O000000o2 = cb.O000000o(i10, 0);
                    int max = Math.max(i11, O0000Oo.getComMeasuredWidth() + o00000o02.O00000o + o00000o02.O00000oo);
                    O00000o0 o00000o03 = o00000o02;
                    dpf dpf = O0000Oo;
                    dpn dpn3 = dpn2;
                    i3 = mode;
                    i4 = i12;
                    if (O000000o(mode, size, dpn2.O00000oO, O0000Oo.getComMeasuredHeight() + o00000o02.O0000OOo + o00000o02.O0000Oo, o00000o03, i12, i13)) {
                        if (dpn3.O0000OOo > 0) {
                            O000000o(dpn3);
                        }
                        dpn2 = new dpn();
                        dpn2.O0000OOo = 1;
                        dpn2.O00000oO = i9;
                        o00000o0 = o00000o03;
                        i6 = dpf.getComMeasuredWidth() + o00000o0.O00000o + o00000o0.O00000oo;
                        i5 = 0;
                    } else {
                        o00000o0 = o00000o03;
                        dpn3.O0000OOo++;
                        i5 = i13 + 1;
                        dpn2 = dpn3;
                        i6 = max;
                    }
                    dpn2.O00000oO += dpf.getComMeasuredHeight() + o00000o0.O0000OOo + o00000o0.O0000Oo;
                    dpn2.O0000Oo0 += o00000o0.O0000o00;
                    dpn2.O0000Oo += o00000o0.O0000o0;
                    dpn2.O0000O0o = Math.max(dpn2.O0000O0o, i6);
                    if (O0000OoO(i4, i5)) {
                        dpn2.O00000oO += this.O000o0o0;
                    }
                    i13 = i5;
                    i11 = i6;
                    i10 = O000000o2;
                    O000000o(i4, size2, dpn2);
                    i12 = i4 + 1;
                    i7 = i;
                    mode = i3;
                }
            }
            i3 = mode;
            i4 = i12;
            dpn2 = dpn2;
            O000000o(i4, size2, dpn2);
            i12 = i4 + 1;
            i7 = i;
            mode = i3;
        }
        int i15 = i;
        O00000o0(this.O000o00O, i15, i8);
        O00000Oo(this.O000o00O, i15, i8, O00oOoOo() + O000O0o());
        O0000Oo(this.O000o00O, this.O000o0O0);
        O000000o(this.O000o00O, i15, i8, i10);
    }

    private void O0000Oo0(int i, int i2) {
        int i3;
        int i4;
        int i5;
        O00000o0 o00000o0;
        int i6;
        int i7 = i;
        int i8 = i2;
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        this.O000oO00.clear();
        int size2 = this.f14825O000000o.size();
        int i9 = this.O000O0oo;
        int i10 = this.O000OO00;
        dpn dpn = new dpn();
        int i11 = i9 + i10;
        dpn.O00000oO = i11;
        dpn dpn2 = dpn;
        int i12 = 0;
        int i13 = Integer.MIN_VALUE;
        int i14 = 0;
        int i15 = 0;
        while (i14 < size2) {
            dpf O0000Oo = O0000Oo(i14);
            if (O0000Oo != null) {
                if (O0000Oo.O0000ooO() == 2) {
                    dpn2.O0000OOo++;
                } else {
                    O00000o0 o00000o02 = (O00000o0) O0000Oo.O000O0oo();
                    if (o00000o02.O0000o0O == 4) {
                        dpn2.O0000Ooo.add(Integer.valueOf(i14));
                    }
                    int i16 = o00000o02.f14826O000000o;
                    if (o00000o02.O0000o0o != -1.0f && mode == 1073741824) {
                        i16 = Math.round(((float) size) * o00000o02.O0000o0o);
                    }
                    O0000Oo.measureComponent(O000000o(i7, O00oOoOo() + O000O0o() + o00000o02.O00000o + o00000o02.O00000oo, i16), O000000o(i8, O000O0o0() + O000O0oO() + o00000o02.O0000OOo + o00000o02.O0000Oo, o00000o02.O00000Oo));
                    O00000Oo(O0000Oo);
                    int O000000o2 = cb.O000000o(i12, 0);
                    int max = Math.max(i13, O0000Oo.getComMeasuredHeight() + o00000o02.O0000OOo + o00000o02.O0000Oo);
                    O00000o0 o00000o03 = o00000o02;
                    dpf dpf = O0000Oo;
                    i3 = mode;
                    dpn dpn3 = dpn2;
                    int i17 = i14;
                    if (O000000o(mode, size, dpn2.O00000oO, O0000Oo.getComMeasuredWidth() + o00000o02.O00000o + o00000o02.O00000oo, o00000o03, i14, i15)) {
                        if (dpn3.O0000OOo > 0) {
                            O000000o(dpn3);
                        }
                        dpn2 = new dpn();
                        dpn2.O0000OOo = 1;
                        dpn2.O00000oO = i11;
                        o00000o0 = o00000o03;
                        i6 = dpf.getComMeasuredHeight() + o00000o0.O0000OOo + o00000o0.O0000Oo;
                        i5 = 0;
                    } else {
                        o00000o0 = o00000o03;
                        dpn3.O0000OOo++;
                        i5 = i15 + 1;
                        dpn2 = dpn3;
                        i6 = max;
                    }
                    dpn2.O00000oO += dpf.getComMeasuredWidth() + o00000o0.O00000o + o00000o0.O00000oo;
                    dpn2.O0000Oo0 += o00000o0.O0000o00;
                    dpn2.O0000Oo += o00000o0.O0000o0;
                    dpn2.O0000O0o = Math.max(dpn2.O0000O0o, i6);
                    i4 = i17;
                    if (O0000OoO(i4, i5)) {
                        dpn2.O00000oO += this.O000o0o;
                        dpn2.O00000oo += this.O000o0o;
                    }
                    if (this.O000o00o != 2) {
                        dpn2.O0000OoO = Math.max(dpn2.O0000OoO, o00000o0.O0000OOo + 0);
                    } else {
                        dpn2.O0000OoO = Math.max(dpn2.O0000OoO, dpf.getComMeasuredHeight() + 0 + o00000o0.O0000Oo);
                    }
                    i13 = i6;
                    i15 = i5;
                    i12 = O000000o2;
                    O000000o(i4, size2, dpn2);
                    i14 = i4 + 1;
                    mode = i3;
                }
            }
            i4 = i14;
            i3 = mode;
            dpn2 = dpn2;
            O000000o(i4, size2, dpn2);
            i14 = i4 + 1;
            mode = i3;
        }
        O00000o0(this.O000o00O, i7, i8);
        if (this.O000o0O0 == 3) {
            int i18 = 0;
            for (dpn next : this.O000oO00) {
                int i19 = Integer.MIN_VALUE;
                for (int i20 = i18; i20 < next.O0000OOo + i18; i20++) {
                    dpf O0000Oo2 = O0000Oo(i20);
                    O00000o0 o00000o04 = (O00000o0) O0000Oo2.O000O0oo();
                    if (this.O000o00o != 2) {
                        i19 = Math.max(i19, O0000Oo2.getComMeasuredHeight() + Math.max(next.O0000OoO + 0, o00000o04.O0000OOo) + o00000o04.O0000Oo);
                    } else {
                        i19 = Math.max(i19, O0000Oo2.getComMeasuredHeight() + o00000o04.O0000OOo + Math.max((next.O0000OoO - O0000Oo2.getComMeasuredHeight()) + 0, o00000o04.O0000Oo));
                    }
                }
                next.O0000O0o = i19;
                i18 += next.O0000OOo;
            }
        }
        O00000Oo(this.O000o00O, i7, i8, O000O0o0() + O000O0oO());
        O0000Oo(this.O000o00O, this.O000o0O0);
        O000000o(this.O000o00O, i7, i8, i12);
    }

    private void O000000o(int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int i7;
        int i8;
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        int mode2 = View.MeasureSpec.getMode(i3);
        int size2 = View.MeasureSpec.getSize(i3);
        if (i == 0 || i == 1) {
            i5 = O000OOo() + O000O0o0() + O000O0oO();
            i6 = O000OOoO();
        } else if (i == 2 || i == 3) {
            i5 = O000OOoO();
            i6 = O000OOo() + O00oOoOo() + O000O0o();
        } else {
            throw new IllegalArgumentException("Invalid flex direction: ".concat(String.valueOf(i)));
        }
        if (mode == Integer.MIN_VALUE) {
            if (size < i6) {
                i4 = cb.O000000o(i4, 16777216);
            } else {
                size = i6;
            }
            i7 = cb.O000000o(size, i2, i4);
        } else if (mode == 0) {
            i7 = cb.O000000o(i6, i2, i4);
        } else if (mode == 1073741824) {
            if (size < i6) {
                i4 = cb.O000000o(i4, 16777216);
            }
            i7 = cb.O000000o(size, i2, i4);
        } else {
            throw new IllegalStateException("Unknown width mode is set: ".concat(String.valueOf(mode)));
        }
        if (mode2 == Integer.MIN_VALUE) {
            if (size2 < i5) {
                i4 = cb.O000000o(i4, 256);
                i5 = size2;
            }
            i8 = cb.O000000o(i5, i3, i4);
        } else if (mode2 == 0) {
            i8 = cb.O000000o(i5, i3, i4);
        } else if (mode2 == 1073741824) {
            if (size2 < i5) {
                i4 = cb.O000000o(i4, 256);
            }
            i8 = cb.O000000o(size2, i3, i4);
        } else {
            throw new IllegalStateException("Unknown height mode is set: ".concat(String.valueOf(mode2)));
        }
        O00000o(i7, i8);
    }

    private void O0000Oo(int i, int i2) {
        if (i2 == 4) {
            int i3 = 0;
            for (dpn next : this.O000oO00) {
                int i4 = i3;
                int i5 = 0;
                while (i5 < next.O0000OOo) {
                    dpf O0000Oo = O0000Oo(i4);
                    O00000o0 o00000o0 = (O00000o0) O0000Oo.O000O0oo();
                    if (o00000o0.O0000o0O == -1 || o00000o0.O0000o0O == 4) {
                        if (i == 0 || i == 1) {
                            O00000Oo(O0000Oo, next.O0000O0o);
                        } else if (i == 2 || i == 3) {
                            O000000o(O0000Oo, next.O0000O0o);
                        } else {
                            throw new IllegalArgumentException("Invalid flex direction: ".concat(String.valueOf(i)));
                        }
                    }
                    i5++;
                    i4++;
                }
                i3 = i4;
            }
            return;
        }
        for (dpn next2 : this.O000oO00) {
            Iterator<Integer> it = next2.O0000Ooo.iterator();
            while (true) {
                if (it.hasNext()) {
                    dpf O0000Oo2 = O0000Oo(it.next().intValue());
                    if (i == 0 || i == 1) {
                        O00000Oo(O0000Oo2, next2.O0000O0o);
                    } else if (i == 2 || i == 3) {
                        O000000o(O0000Oo2, next2.O0000O0o);
                    } else {
                        throw new IllegalArgumentException("Invalid flex direction: ".concat(String.valueOf(i)));
                    }
                }
            }
        }
    }

    private static void O000000o(dpf dpf, int i) {
        O00000o0 o00000o0 = (O00000o0) dpf.O000O0oo();
        dpf.measureComponent(View.MeasureSpec.makeMeasureSpec(Math.max((i - o00000o0.O00000o) - o00000o0.O00000oo, 0), 1073741824), View.MeasureSpec.makeMeasureSpec(dpf.getComMeasuredHeight(), 1073741824));
    }

    private static void O00000Oo(dpf dpf, int i) {
        O00000o0 o00000o0 = (O00000o0) dpf.O000O0oo();
        dpf.measureComponent(View.MeasureSpec.makeMeasureSpec(dpf.getComMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(Math.max((i - o00000o0.O0000OOo) - o00000o0.O0000Oo, 0), 1073741824));
    }

    private void O00000Oo(int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        if (i == 0 || i == 1) {
            i6 = View.MeasureSpec.getMode(i3);
            i5 = View.MeasureSpec.getSize(i3);
        } else if (i == 2 || i == 3) {
            i6 = View.MeasureSpec.getMode(i2);
            i5 = View.MeasureSpec.getSize(i2);
        } else {
            throw new IllegalArgumentException("Invalid flex direction: ".concat(String.valueOf(i)));
        }
        if (i6 == 1073741824) {
            int O000OOo = O000OOo() + i4;
            int i7 = 0;
            if (this.O000oO00.size() == 1) {
                this.O000oO00.get(0).O0000O0o = i5 - i4;
            } else if (this.O000oO00.size() >= 2 && O000OOo < i5) {
                int i8 = this.O000o0O;
                if (i8 == 1) {
                    int i9 = i5 - O000OOo;
                    dpn dpn = new dpn();
                    dpn.O0000O0o = i9;
                    this.O000oO00.add(0, dpn);
                } else if (i8 == 2) {
                    ArrayList arrayList = new ArrayList();
                    dpn dpn2 = new dpn();
                    dpn2.O0000O0o = (i5 - O000OOo) / 2;
                    int size = this.O000oO00.size();
                    while (i7 < size) {
                        if (i7 == 0) {
                            arrayList.add(dpn2);
                        }
                        arrayList.add(this.O000oO00.get(i7));
                        if (i7 == this.O000oO00.size() - 1) {
                            arrayList.add(dpn2);
                        }
                        i7++;
                    }
                    this.O000oO00 = arrayList;
                } else if (i8 == 3) {
                    float size2 = ((float) (i5 - O000OOo)) / ((float) (this.O000oO00.size() - 1));
                    ArrayList arrayList2 = new ArrayList();
                    int size3 = this.O000oO00.size();
                    float f = 0.0f;
                    while (i7 < size3) {
                        arrayList2.add(this.O000oO00.get(i7));
                        if (i7 != this.O000oO00.size() - 1) {
                            dpn dpn3 = new dpn();
                            if (i7 == this.O000oO00.size() - 2) {
                                dpn3.O0000O0o = Math.round(f + size2);
                                f = 0.0f;
                            } else {
                                dpn3.O0000O0o = Math.round(size2);
                            }
                            f += size2 - ((float) dpn3.O0000O0o);
                            if (f > 1.0f) {
                                dpn3.O0000O0o++;
                                f -= 1.0f;
                            } else if (f < -1.0f) {
                                dpn3.O0000O0o--;
                                f += 1.0f;
                            }
                            arrayList2.add(dpn3);
                        }
                        i7++;
                    }
                    this.O000oO00 = arrayList2;
                } else if (i8 == 4) {
                    int size4 = (i5 - O000OOo) / (this.O000oO00.size() * 2);
                    ArrayList arrayList3 = new ArrayList();
                    dpn dpn4 = new dpn();
                    dpn4.O0000O0o = size4;
                    for (dpn add : this.O000oO00) {
                        arrayList3.add(dpn4);
                        arrayList3.add(add);
                        arrayList3.add(dpn4);
                    }
                    this.O000oO00 = arrayList3;
                } else if (i8 == 5) {
                    float size5 = ((float) (i5 - O000OOo)) / ((float) this.O000oO00.size());
                    int size6 = this.O000oO00.size();
                    float f2 = 0.0f;
                    while (i7 < size6) {
                        dpn dpn5 = this.O000oO00.get(i7);
                        float f3 = ((float) dpn5.O0000O0o) + size5;
                        if (i7 == this.O000oO00.size() - 1) {
                            f3 += f2;
                            f2 = 0.0f;
                        }
                        int round = Math.round(f3);
                        f2 += f3 - ((float) round);
                        if (f2 > 1.0f) {
                            round++;
                            f2 -= 1.0f;
                        } else if (f2 < -1.0f) {
                            round--;
                            f2 += 1.0f;
                        }
                        dpn5.O0000O0o = round;
                        i7++;
                    }
                }
            }
        }
    }

    private int O000OOo() {
        int i;
        int i2;
        int size = this.O000oO00.size();
        int i3 = 0;
        for (int i4 = 0; i4 < size; i4++) {
            dpn dpn = this.O000oO00.get(i4);
            if (O0000O0o(i4)) {
                if (O0000Oo0(this.O000o00O)) {
                    i2 = this.O000o0o0;
                } else {
                    i2 = this.O000o0o;
                }
                i3 += i2;
            }
            if (O00000oo(i4)) {
                if (O0000Oo0(this.O000o00O)) {
                    i = this.O000o0o0;
                } else {
                    i = this.O000o0o;
                }
                i3 += i;
            }
            i3 += dpn.O0000O0o;
        }
        return i3;
    }

    private boolean O00000oo(int i) {
        if (i >= 0 && i < this.O000oO00.size()) {
            for (int i2 = i + 1; i2 < this.O000oO00.size(); i2++) {
                if (this.O000oO00.get(i2).O0000OOo > 0) {
                    return false;
                }
            }
            if (O0000Oo0(this.O000o00O)) {
                return (this.O000o0OO & 4) != 0;
            }
            if ((this.O000o0Oo & 4) != 0) {
                return true;
            }
        }
        return false;
    }

    private boolean O0000O0o(int i) {
        if (i >= 0 && i < this.O000oO00.size()) {
            if (O0000OOo(i)) {
                if (O0000Oo0(this.O000o00O)) {
                    if ((this.O000o0OO & 1) != 0) {
                        return true;
                    }
                    return false;
                } else if ((this.O000o0Oo & 1) != 0) {
                    return true;
                } else {
                    return false;
                }
            } else if (O0000Oo0(this.O000o00O)) {
                if ((this.O000o0OO & 2) != 0) {
                    return true;
                }
                return false;
            } else if ((this.O000o0Oo & 2) != 0) {
                return true;
            }
        }
        return false;
    }

    private boolean O0000OOo(int i) {
        for (int i2 = 0; i2 < i; i2++) {
            if (this.O000oO00.get(i2).O0000OOo > 0) {
                return false;
            }
        }
        return true;
    }

    private void O00000o0(int i, int i2, int i3) {
        int i4;
        int i5;
        int i6;
        if (i == 0 || i == 1) {
            int mode = View.MeasureSpec.getMode(i2);
            int size = View.MeasureSpec.getSize(i2);
            if (mode != 1073741824) {
                size = O000OOoO();
            }
            i4 = size;
            i5 = O00oOoOo();
            i6 = O000O0o();
        } else if (i == 2 || i == 3) {
            int mode2 = View.MeasureSpec.getMode(i3);
            i4 = View.MeasureSpec.getSize(i3);
            if (mode2 != 1073741824) {
                i4 = O000OOoO();
            }
            i5 = O000O0o0();
            i6 = O000O0oO();
        } else {
            throw new IllegalArgumentException("Invalid flex direction: ".concat(String.valueOf(i)));
        }
        int i7 = i5 + i6;
        int i8 = 0;
        for (dpn next : this.O000oO00) {
            if (next.O00000oO < i4) {
                i8 = O00000Oo(next, i, i4, i7, i8);
            } else {
                i8 = O000000o(next, i, i4, i7, i8);
            }
        }
    }

    private int O000000o(dpn dpn, int i, int i2, int i3, int i4) {
        dpn dpn2 = dpn;
        int i5 = i2;
        int i6 = dpn2.O00000oO;
        if (dpn2.O0000Oo <= 0.0f || i5 > dpn2.O00000oO) {
            return i4 + dpn2.O0000OOo;
        }
        float f = ((float) (dpn2.O00000oO - i5)) / dpn2.O0000Oo;
        dpn2.O00000oO = i3 + dpn2.O00000oo;
        int i7 = i4;
        boolean z = false;
        float f2 = 0.0f;
        for (int i8 = 0; i8 < dpn2.O0000OOo; i8++) {
            dpf O0000Oo = O0000Oo(i7);
            if (O0000Oo != null) {
                if (O0000Oo.O0000ooO() != 2) {
                    O00000o0 o00000o0 = (O00000o0) O0000Oo.O000O0oo();
                    if (O0000Oo0(i)) {
                        if (!this.O000oO0[i7]) {
                            float comMeasuredWidth = ((float) O0000Oo.getComMeasuredWidth()) - (o00000o0.O0000o0 * f);
                            if (i8 == dpn2.O0000OOo - 1) {
                                comMeasuredWidth += f2;
                                f2 = 0.0f;
                            }
                            int round = Math.round(comMeasuredWidth);
                            if (round < o00000o0.O0000o) {
                                round = o00000o0.O0000o;
                                this.O000oO0[i7] = true;
                                dpn2.O0000Oo -= o00000o0.O0000o0;
                                z = true;
                            } else {
                                f2 += comMeasuredWidth - ((float) round);
                                double d = (double) f2;
                                if (d > 1.0d) {
                                    round++;
                                    f2 -= 1.0f;
                                } else if (d < -1.0d) {
                                    round--;
                                    f2 += 1.0f;
                                }
                            }
                            O0000Oo.measureComponent(View.MeasureSpec.makeMeasureSpec(round, 1073741824), View.MeasureSpec.makeMeasureSpec(O0000Oo.getComMeasuredHeight(), 1073741824));
                        }
                        dpn2.O00000oO += O0000Oo.getComMeasuredWidth() + o00000o0.O00000o + o00000o0.O00000oo;
                    } else {
                        if (!this.O000oO0[i7]) {
                            float comMeasuredHeight = ((float) O0000Oo.getComMeasuredHeight()) - (o00000o0.O0000o0 * f);
                            if (i8 == dpn2.O0000OOo - 1) {
                                comMeasuredHeight += f2;
                                f2 = 0.0f;
                            }
                            int round2 = Math.round(comMeasuredHeight);
                            if (round2 < o00000o0.O0000oO0) {
                                round2 = o00000o0.O0000oO0;
                                this.O000oO0[i7] = true;
                                dpn2.O0000Oo -= o00000o0.O0000o0;
                                z = true;
                            } else {
                                f2 += comMeasuredHeight - ((float) round2);
                                double d2 = (double) f2;
                                if (d2 > 1.0d) {
                                    round2++;
                                    f2 -= 1.0f;
                                } else if (d2 < -1.0d) {
                                    round2--;
                                    f2 += 1.0f;
                                }
                            }
                            O0000Oo.measureComponent(View.MeasureSpec.makeMeasureSpec(O0000Oo.getComMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(round2, 1073741824));
                        }
                        dpn2.O00000oO += O0000Oo.getComMeasuredHeight() + o00000o0.O0000OOo + o00000o0.O0000Oo;
                    }
                }
                i7++;
            }
        }
        if (z && i6 != dpn2.O00000oO) {
            O000000o(dpn, i, i2, i3, i4);
        }
        return i7;
    }

    private int O00000Oo(dpn dpn, int i, int i2, int i3, int i4) {
        double d;
        double d2;
        dpn dpn2 = dpn;
        int i5 = i2;
        if (dpn2.O0000Oo0 <= 0.0f || i5 < dpn2.O00000oO) {
            return i4 + dpn2.O0000OOo;
        }
        int i6 = dpn2.O00000oO;
        float f = ((float) (i5 - dpn2.O00000oO)) / dpn2.O0000Oo0;
        dpn2.O00000oO = i3 + dpn2.O00000oo;
        int i7 = i4;
        boolean z = false;
        float f2 = 0.0f;
        for (int i8 = 0; i8 < dpn2.O0000OOo; i8++) {
            dpf O0000Oo = O0000Oo(i7);
            if (O0000Oo != null) {
                if (O0000Oo.O0000ooO() != 2) {
                    O00000o0 o00000o0 = (O00000o0) O0000Oo.O000O0oo();
                    if (O0000Oo0(i)) {
                        if (!this.O000oO0[i7]) {
                            float comMeasuredWidth = ((float) O0000Oo.getComMeasuredWidth()) + (o00000o0.O0000o00 * f);
                            if (i8 == dpn2.O0000OOo - 1) {
                                comMeasuredWidth += f2;
                                f2 = 0.0f;
                            }
                            int round = Math.round(comMeasuredWidth);
                            if (round > o00000o0.O0000oO) {
                                round = o00000o0.O0000oO;
                                this.O000oO0[i7] = true;
                                dpn2.O0000Oo0 -= o00000o0.O0000o00;
                                z = true;
                            } else {
                                f2 += comMeasuredWidth - ((float) round);
                                double d3 = (double) f2;
                                if (d3 > 1.0d) {
                                    round++;
                                    Double.isNaN(d3);
                                    d2 = d3 - 1.0d;
                                } else if (d3 < -1.0d) {
                                    round--;
                                    Double.isNaN(d3);
                                    d2 = d3 + 1.0d;
                                }
                                f2 = (float) d2;
                            }
                            O0000Oo.measureComponent(View.MeasureSpec.makeMeasureSpec(round, 1073741824), View.MeasureSpec.makeMeasureSpec(O0000Oo.getComMeasuredHeight(), 1073741824));
                        }
                        dpn2.O00000oO += O0000Oo.getComMeasuredWidth() + o00000o0.O00000o + o00000o0.O00000oo;
                    } else {
                        if (!this.O000oO0[i7]) {
                            float comMeasuredHeight = ((float) O0000Oo.getComMeasuredHeight()) + (o00000o0.O0000o00 * f);
                            if (i8 == dpn2.O0000OOo - 1) {
                                comMeasuredHeight += f2;
                                f2 = 0.0f;
                            }
                            int round2 = Math.round(comMeasuredHeight);
                            if (round2 > o00000o0.O0000oOO) {
                                round2 = o00000o0.O0000oOO;
                                this.O000oO0[i7] = true;
                                dpn2.O0000Oo0 -= o00000o0.O0000o00;
                                z = true;
                            } else {
                                f2 += comMeasuredHeight - ((float) round2);
                                double d4 = (double) f2;
                                if (d4 > 1.0d) {
                                    round2++;
                                    Double.isNaN(d4);
                                    d = d4 - 1.0d;
                                } else if (d4 < -1.0d) {
                                    round2--;
                                    Double.isNaN(d4);
                                    d = d4 + 1.0d;
                                }
                                f2 = (float) d;
                            }
                            O0000Oo.measureComponent(View.MeasureSpec.makeMeasureSpec(O0000Oo.getComMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(round2, 1073741824));
                        }
                        dpn2.O00000oO += O0000Oo.getComMeasuredHeight() + o00000o0.O0000OOo + o00000o0.O0000Oo;
                    }
                }
                i7++;
            }
        }
        if (z && i6 != dpn2.O00000oO) {
            O00000Oo(dpn, i, i2, i3, i4);
        }
        return i7;
    }

    private int O000OOoO() {
        int i = Integer.MIN_VALUE;
        for (dpn dpn : this.O000oO00) {
            i = Math.max(i, dpn.O00000oO);
        }
        return i;
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x003e A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x003f A[RETURN] */
    private boolean O000000o(int i, int i2, int i3, int i4, O00000o0 o00000o0, int i5, int i6) {
        int i7;
        if (this.O000o00o == 0) {
            return false;
        }
        if (o00000o0.O0000oOo) {
            return true;
        }
        if (i == 0) {
            return false;
        }
        if (O0000Oo0(this.O000o00O)) {
            if (O0000OoO(i5, i6)) {
                i4 += this.O000o0o;
            }
            if ((this.O000o0Oo & 4) > 0) {
                i7 = this.O000o0o;
            }
            if (i2 < i3 + i4) {
                return true;
            }
            return false;
        }
        if (O0000OoO(i5, i6)) {
            i4 += this.O000o0o0;
        }
        if ((this.O000o0OO & 4) > 0) {
            i7 = this.O000o0o0;
        }
        if (i2 < i3 + i4) {
        }
        i4 += i7;
        if (i2 < i3 + i4) {
        }
    }

    private boolean O0000OoO(int i, int i2) {
        return O0000Ooo(i, i2) ? O0000Oo0(this.O000o00O) ? (this.O000o0Oo & 1) != 0 : (this.O000o0OO & 1) != 0 : O0000Oo0(this.O000o00O) ? (this.O000o0Oo & 2) != 0 : (this.O000o0OO & 2) != 0;
    }

    private boolean O0000Ooo(int i, int i2) {
        for (int i3 = 1; i3 <= i2; i3++) {
            dpf O0000Oo = O0000Oo(i - i3);
            if (O0000Oo != null && O0000Oo.O0000ooO() != 2) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x002b  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x002e  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0038  */
    /* JADX WARNING: Removed duplicated region for block: B:18:? A[RETURN, SYNTHETIC] */
    private static void O00000Oo(dpf dpf) {
        boolean z;
        O00000o0 o00000o0 = (O00000o0) dpf.O000O0oo();
        int comMeasuredWidth = dpf.getComMeasuredWidth();
        int comMeasuredHeight = dpf.getComMeasuredHeight();
        boolean z2 = true;
        if (dpf.getComMeasuredWidth() < o00000o0.O0000o) {
            comMeasuredWidth = o00000o0.O0000o;
        } else if (dpf.getComMeasuredWidth() > o00000o0.O0000oO) {
            comMeasuredWidth = o00000o0.O0000oO;
        } else {
            z = false;
            if (comMeasuredHeight >= o00000o0.O0000oO0) {
                comMeasuredHeight = o00000o0.O0000oO0;
            } else if (comMeasuredHeight > o00000o0.O0000oOO) {
                comMeasuredHeight = o00000o0.O0000oOO;
            } else {
                z2 = z;
            }
            if (!z2) {
                dpf.measureComponent(View.MeasureSpec.makeMeasureSpec(comMeasuredWidth, 1073741824), View.MeasureSpec.makeMeasureSpec(comMeasuredHeight, 1073741824));
                return;
            }
            return;
        }
        z = true;
        if (comMeasuredHeight >= o00000o0.O0000oO0) {
        }
        if (!z2) {
        }
    }

    private void O000000o(int i, int i2, dpn dpn) {
        if (i == i2 - 1 && dpn.O0000OOo != 0) {
            O000000o(dpn);
        }
    }

    private void O000000o(dpn dpn) {
        if (O0000Oo0(this.O000o00O)) {
            if ((this.O000o0Oo & 4) > 0) {
                dpn.O00000oO += this.O000o0o;
                dpn.O00000oo += this.O000o0o;
            }
        } else if ((this.O000o0OO & 4) > 0) {
            dpn.O00000oO += this.O000o0o0;
            dpn.O00000oo += this.O000o0o0;
        }
        this.O000oO00.add(dpn);
    }

    private dpf O0000Oo(int i) {
        if (i < 0 || i >= this.O000o0oo.length) {
            return null;
        }
        return (dpf) this.f14825O000000o.get(this.O000o0oo[i]);
    }

    private int[] O000000o(int i, List<O00000Oo> list) {
        Collections.sort(list);
        if (this.O000o == null) {
            this.O000o = new SparseIntArray(i);
        }
        this.O000o.clear();
        int[] iArr = new int[i];
        int i2 = 0;
        for (O00000Oo next : list) {
            iArr[i2] = next.f14840O000000o;
            this.O000o.append(i2, next.O00000Oo);
            i2++;
        }
        return iArr;
    }

    private List<O00000Oo> O0000OoO(int i) {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < i; i2++) {
            O00000Oo o00000Oo = new O00000Oo((byte) 0);
            o00000Oo.O00000Oo = ((O00000o0) ((dpf) this.f14825O000000o.get(i2)).O000O0oo()).O0000Ooo;
            o00000Oo.f14840O000000o = i2;
            arrayList.add(o00000Oo);
        }
        return arrayList;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.dpm.O000000o(boolean, int, int, int, int):void
     arg types: [int, int, int, int, int]
     candidates:
      _m_j.dpm.O000000o(_m_j.dpn, int, int, int, int):int
      _m_j.dpm.O000000o(boolean, int, int, int, int):void */
    public final void onComLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5 = this.O000o00O;
        if (i5 != 0) {
            boolean z2 = true;
            if (i5 == 1) {
                O000000o(true, i, i2, i3, i4);
            } else if (i5 == 2) {
                if (this.O000o00o != 2) {
                    z2 = false;
                }
                O000000o(z2, false, i, i2, i3, i4);
            } else if (i5 == 3) {
                if (this.O000o00o != 2) {
                    z2 = false;
                }
                O000000o(z2, true, i, i2, i3, i4);
            } else {
                throw new IllegalStateException("Invalid flex direction is set: " + this.O000o00O);
            }
        } else {
            O000000o(false, i, i2, i3, i4);
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.lang.Math.max(float, float):float}
     arg types: [float, int]
     candidates:
      ClspMth{java.lang.Math.max(double, double):double}
      ClspMth{java.lang.Math.max(int, int):int}
      ClspMth{java.lang.Math.max(long, long):long}
      ClspMth{java.lang.Math.max(float, float):float} */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.dpm.O000000o(_m_j.dpf, _m_j.dpn, boolean, int, int, int, int, int):void
     arg types: [_m_j.dpf, _m_j.dpn, int, int, int, int, int, int]
     candidates:
      _m_j.dpm.O000000o(_m_j.dpf, _m_j.dpn, int, int, int, int, int, int):void
      _m_j.dpm.O000000o(_m_j.dpf, _m_j.dpn, boolean, int, int, int, int, int):void */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00ce  */
    private void O000000o(boolean z, boolean z2, int i, int i2, int i3, int i4) {
        float f;
        float f2;
        float f3;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        O00000o0 o00000o0;
        int i11;
        int O000O0o0 = O000O0o0();
        int O000O0oO = O000O0oO();
        int i12 = i4 - i2;
        int O000O0o = (i + (i3 - i)) - O000O0o();
        int size = this.O000oO00.size();
        int i13 = O000O0o;
        int i14 = 0;
        int O00oOoOo = i + O00oOoOo();
        int i15 = 0;
        while (i15 < size) {
            dpn dpn = this.O000oO00.get(i15);
            if (O0000O0o(i15)) {
                int i16 = this.O000o0o;
                O00oOoOo += i16;
                i13 -= i16;
            }
            int i17 = this.O000o0;
            int i18 = 2;
            if (i17 == 0) {
                f2 = (float) (i2 + O000O0o0);
                i11 = (i2 + i12) - O000O0oO;
            } else if (i17 == 1) {
                f2 = (float) (((i2 + i12) - dpn.O00000oO) + O000O0oO);
                i11 = (i2 + dpn.O00000oO) - O000O0o0;
            } else if (i17 != 2) {
                if (i17 == 3) {
                    f2 = (float) (i2 + O000O0o0);
                    f3 = ((float) (i12 - dpn.O00000oO)) / (dpn.O0000OOo != 1 ? (float) (dpn.O0000OOo - 1) : 1.0f);
                    f = (float) ((i2 + i12) - O000O0oO);
                } else if (i17 == 4) {
                    f3 = dpn.O0000OOo != 0 ? ((float) (i12 - dpn.O00000oO)) / ((float) dpn.O0000OOo) : 0.0f;
                    float f4 = f3 / 2.0f;
                    f2 = ((float) (i2 + O000O0o0)) + f4;
                    f = ((float) ((i2 + i12) - O000O0oO)) - f4;
                } else {
                    throw new IllegalStateException("Invalid justifyContent is set: " + this.O000o0);
                }
                float max = Math.max(f3, 0.0f);
                float f5 = f;
                int i19 = i14;
                i5 = 0;
                while (i5 < dpn.O0000OOo) {
                    dpf O0000Oo = O0000Oo(i19);
                    if (O0000Oo == null) {
                        i8 = O000O0o0;
                        i9 = O000O0oO;
                    } else if (O0000Oo.O0000ooO() == i18) {
                        i19++;
                        i8 = O000O0o0;
                        i9 = O000O0oO;
                    } else {
                        O00000o0 o00000o02 = (O00000o0) O0000Oo.O000O0oo();
                        float f6 = f2 + ((float) o00000o02.O0000OOo);
                        float f7 = f5 - ((float) o00000o02.O0000Oo);
                        if (O0000OoO(i19, i5)) {
                            int i20 = this.O000o0o0;
                            i7 = O000O0o0;
                            f6 += (float) i20;
                            f7 -= (float) i20;
                        } else {
                            i7 = O000O0o0;
                        }
                        float f8 = f6;
                        float f9 = f7;
                        if (!z) {
                            i6 = O000O0oO;
                            o00000o0 = o00000o02;
                            i10 = i19;
                            if (z2) {
                                O000000o(O0000Oo, dpn, false, this.O000o0O0, O00oOoOo, Math.round(f9) - O0000Oo.getComMeasuredHeight(), O00oOoOo + O0000Oo.getComMeasuredWidth(), Math.round(f9));
                            } else {
                                O000000o(O0000Oo, dpn, false, this.O000o0O0, O00oOoOo, Math.round(f8), O00oOoOo + O0000Oo.getComMeasuredWidth(), Math.round(f8) + O0000Oo.getComMeasuredHeight());
                            }
                        } else if (z2) {
                            i6 = O000O0oO;
                            o00000o0 = o00000o02;
                            i10 = i19;
                            O000000o(O0000Oo, dpn, true, this.O000o0O0, i13 - O0000Oo.getComMeasuredWidth(), Math.round(f9) - O0000Oo.getComMeasuredHeight(), i13, Math.round(f9));
                        } else {
                            i6 = O000O0oO;
                            o00000o0 = o00000o02;
                            i10 = i19;
                            O000000o(O0000Oo, dpn, true, this.O000o0O0, i13 - O0000Oo.getComMeasuredWidth(), Math.round(f8), i13, Math.round(f8) + O0000Oo.getComMeasuredHeight());
                        }
                        i19 = i10 + 1;
                        f2 = f8 + ((float) O0000Oo.getComMeasuredHeight()) + max + ((float) o00000o0.O0000Oo);
                        f5 = f9 - ((((float) O0000Oo.getComMeasuredHeight()) + max) + ((float) o00000o0.O0000OOo));
                        i5++;
                        O000O0o0 = i7;
                        O000O0oO = i6;
                        i18 = 2;
                    }
                    i5++;
                    O000O0o0 = i7;
                    O000O0oO = i6;
                    i18 = 2;
                }
                O00oOoOo += dpn.O0000O0o;
                i13 -= dpn.O0000O0o;
                i15++;
                O000O0o0 = O000O0o0;
                i14 = i19;
            } else {
                f2 = (((float) (i12 - dpn.O00000oO)) / 2.0f) + ((float) (i2 + O000O0o0));
                f = ((float) ((i2 + i12) - O000O0oO)) - (((float) (i12 - dpn.O00000oO)) / 2.0f);
                f3 = 0.0f;
                float max2 = Math.max(f3, 0.0f);
                float f52 = f;
                int i192 = i14;
                i5 = 0;
                while (i5 < dpn.O0000OOo) {
                }
                O00oOoOo += dpn.O0000O0o;
                i13 -= dpn.O0000O0o;
                i15++;
                O000O0o0 = O000O0o0;
                i14 = i192;
            }
            f = (float) i11;
            f3 = 0.0f;
            float max22 = Math.max(f3, 0.0f);
            float f522 = f;
            int i1922 = i14;
            i5 = 0;
            while (i5 < dpn.O0000OOo) {
            }
            O00oOoOo += dpn.O0000O0o;
            i13 -= dpn.O0000O0o;
            i15++;
            O000O0o0 = O000O0o0;
            i14 = i1922;
        }
    }

    private static void O000000o(dpf dpf, dpn dpn, boolean z, int i, int i2, int i3, int i4, int i5) {
        O00000o0 o00000o0 = (O00000o0) dpf.O000O0oo();
        if (o00000o0.O0000o0O != -1) {
            i = o00000o0.O0000o0O;
        }
        int i6 = dpn.O0000O0o;
        if (i != 0) {
            if (i != 1) {
                if (i == 2) {
                    int comMeasuredWidth = (i6 - dpf.getComMeasuredWidth()) / 2;
                    if (!z) {
                        dpf.comLayout(((i2 + comMeasuredWidth) + o00000o0.O00000o) - o00000o0.O00000oo, i3, ((i4 + comMeasuredWidth) + o00000o0.O00000o) - o00000o0.O00000oo, i5);
                        return;
                    } else {
                        dpf.comLayout(((i2 - comMeasuredWidth) + o00000o0.O00000o) - o00000o0.O00000oo, i3, ((i4 - comMeasuredWidth) + o00000o0.O00000o) - o00000o0.O00000oo, i5);
                        return;
                    }
                } else if (!(i == 3 || i == 4)) {
                    return;
                }
            } else if (!z) {
                dpf.comLayout(((i2 + i6) - dpf.getComMeasuredWidth()) - o00000o0.O00000oo, i3, ((i4 + i6) - dpf.getComMeasuredWidth()) - o00000o0.O00000oo, i5);
                return;
            } else {
                dpf.comLayout((i2 - i6) + dpf.getComMeasuredWidth() + o00000o0.O00000o, i3, (i4 - i6) + dpf.getComMeasuredWidth() + o00000o0.O00000o, i5);
                return;
            }
        }
        if (!z) {
            dpf.comLayout(i2 + o00000o0.O00000o, i3, i4 + o00000o0.O00000o, i5);
        } else {
            dpf.comLayout(i2 - o00000o0.O00000oo, i3, i4 - o00000o0.O00000oo, i5);
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.lang.Math.max(float, float):float}
     arg types: [float, int]
     candidates:
      ClspMth{java.lang.Math.max(double, double):double}
      ClspMth{java.lang.Math.max(int, int):int}
      ClspMth{java.lang.Math.max(long, long):long}
      ClspMth{java.lang.Math.max(float, float):float} */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00ca  */
    private void O000000o(boolean z, int i, int i2, int i3, int i4) {
        float f;
        float f2;
        float f3;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        O00000o0 o00000o0;
        int i11;
        int O00oOoOo = O00oOoOo();
        int O000O0o = O000O0o();
        int i12 = i3 - i;
        int size = this.O000oO00.size();
        int O000O0o0 = i2 + O000O0o0();
        int i13 = 0;
        int O000O0oO = i4 - O000O0oO();
        int i14 = 0;
        while (i14 < size) {
            dpn dpn = this.O000oO00.get(i14);
            if (O0000O0o(i14)) {
                int i15 = this.O000o0o0;
                O000O0oO -= i15;
                O000O0o0 += i15;
            }
            int i16 = this.O000o0;
            int i17 = 2;
            if (i16 == 0) {
                f2 = (float) (i + O00oOoOo);
                i11 = i3 - O000O0o;
            } else if (i16 == 1) {
                f2 = (float) (((i + i12) - dpn.O00000oO) + O000O0o);
                i11 = (i + dpn.O00000oO) - O00oOoOo;
            } else if (i16 != 2) {
                if (i16 == 3) {
                    f2 = (float) (i + O00oOoOo);
                    f3 = ((float) (i12 - dpn.O00000oO)) / (dpn.O0000OOo != 1 ? (float) (dpn.O0000OOo - 1) : 1.0f);
                    f = (float) ((i + i12) - O000O0o);
                } else if (i16 == 4) {
                    f3 = dpn.O0000OOo != 0 ? ((float) (i12 - dpn.O00000oO)) / ((float) dpn.O0000OOo) : 0.0f;
                    float f4 = f3 / 2.0f;
                    f2 = ((float) (i + O00oOoOo)) + f4;
                    f = ((float) ((i + i12) - O000O0o)) - f4;
                } else {
                    throw new IllegalStateException("Invalid justifyContent is set: " + this.O000o0);
                }
                float max = Math.max(f3, 0.0f);
                float f5 = f;
                int i18 = i13;
                i5 = 0;
                while (i5 < dpn.O0000OOo) {
                    dpf O0000Oo = O0000Oo(i18);
                    if (O0000Oo == null) {
                        i8 = O00oOoOo;
                        i9 = O000O0o;
                    } else if (O0000Oo.O0000ooO() == i17) {
                        i18++;
                        i8 = O00oOoOo;
                        i9 = O000O0o;
                    } else {
                        O00000o0 o00000o02 = (O00000o0) O0000Oo.O000O0oo();
                        float f6 = f2 + ((float) o00000o02.O00000o);
                        float f7 = f5 - ((float) o00000o02.O00000oo);
                        if (O0000OoO(i18, i5)) {
                            int i19 = this.O000o0o;
                            i7 = O00oOoOo;
                            f6 += (float) i19;
                            f7 -= (float) i19;
                        } else {
                            i7 = O00oOoOo;
                        }
                        float f8 = f6;
                        float f9 = f7;
                        int i20 = this.O000o00o;
                        if (i20 != 2) {
                            i6 = O000O0o;
                            o00000o0 = o00000o02;
                            i10 = i18;
                            if (z) {
                                O000000o(O0000Oo, dpn, i20, this.O000o0O0, Math.round(f9) - O0000Oo.getComMeasuredWidth(), O000O0o0, Math.round(f9), O000O0o0 + O0000Oo.getComMeasuredHeight());
                            } else {
                                O000000o(O0000Oo, dpn, i20, this.O000o0O0, Math.round(f8), O000O0o0, Math.round(f8) + O0000Oo.getComMeasuredWidth(), O000O0o0 + O0000Oo.getComMeasuredHeight());
                            }
                        } else if (z) {
                            i6 = O000O0o;
                            o00000o0 = o00000o02;
                            i10 = i18;
                            O000000o(O0000Oo, dpn, i20, this.O000o0O0, Math.round(f9) - O0000Oo.getComMeasuredWidth(), O000O0oO - O0000Oo.getComMeasuredHeight(), Math.round(f9), O000O0oO);
                        } else {
                            i6 = O000O0o;
                            o00000o0 = o00000o02;
                            i10 = i18;
                            O000000o(O0000Oo, dpn, i20, this.O000o0O0, Math.round(f8), O000O0oO - O0000Oo.getComMeasuredHeight(), Math.round(f8) + O0000Oo.getComMeasuredWidth(), O000O0oO);
                        }
                        i18 = i10 + 1;
                        f2 = f8 + ((float) O0000Oo.getComMeasuredWidth()) + max + ((float) o00000o0.O00000oo);
                        f5 = f9 - ((((float) O0000Oo.getComMeasuredWidth()) + max) + ((float) o00000o0.O00000o));
                        i5++;
                        O00oOoOo = i7;
                        O000O0o = i6;
                        i17 = 2;
                    }
                    i5++;
                    O00oOoOo = i7;
                    O000O0o = i6;
                    i17 = 2;
                }
                O000O0o0 += dpn.O0000O0o;
                O000O0oO -= dpn.O0000O0o;
                i14++;
                O00oOoOo = O00oOoOo;
                i13 = i18;
            } else {
                f2 = (((float) (i12 - dpn.O00000oO)) / 2.0f) + ((float) (i + O00oOoOo));
                f = ((float) ((i + i12) - O000O0o)) - (((float) (i12 - dpn.O00000oO)) / 2.0f);
                f3 = 0.0f;
                float max2 = Math.max(f3, 0.0f);
                float f52 = f;
                int i182 = i13;
                i5 = 0;
                while (i5 < dpn.O0000OOo) {
                }
                O000O0o0 += dpn.O0000O0o;
                O000O0oO -= dpn.O0000O0o;
                i14++;
                O00oOoOo = O00oOoOo;
                i13 = i182;
            }
            f = (float) i11;
            f3 = 0.0f;
            float max22 = Math.max(f3, 0.0f);
            float f522 = f;
            int i1822 = i13;
            i5 = 0;
            while (i5 < dpn.O0000OOo) {
            }
            O000O0o0 += dpn.O0000O0o;
            O000O0oO -= dpn.O0000O0o;
            i14++;
            O00oOoOo = O00oOoOo;
            i13 = i1822;
        }
    }

    private static void O000000o(dpf dpf, dpn dpn, int i, int i2, int i3, int i4, int i5, int i6) {
        O00000o0 o00000o0 = (O00000o0) dpf.O000O0oo();
        if (o00000o0.O0000o0O != -1) {
            i2 = o00000o0.O0000o0O;
        }
        int i7 = dpn.O0000O0o;
        if (i2 != 0) {
            if (i2 != 1) {
                if (i2 == 2) {
                    int comMeasuredHeight = (i7 - dpf.getComMeasuredHeight()) / 2;
                    if (i != 2) {
                        int i8 = i4 + comMeasuredHeight;
                        dpf.comLayout(i3, (o00000o0.O0000OOo + i8) - o00000o0.O0000Oo, i5, ((i8 + dpf.getComMeasuredHeight()) + o00000o0.O0000OOo) - o00000o0.O0000Oo);
                        return;
                    }
                    int i9 = i4 - comMeasuredHeight;
                    dpf.comLayout(i3, (o00000o0.O0000OOo + i9) - o00000o0.O0000Oo, i5, ((i9 + dpf.getComMeasuredHeight()) + o00000o0.O0000OOo) - o00000o0.O0000Oo);
                    return;
                } else if (i2 != 3) {
                    if (i2 != 4) {
                        return;
                    }
                } else if (i != 2) {
                    int max = Math.max(dpn.O0000OoO + 0, o00000o0.O0000OOo);
                    dpf.comLayout(i3, i4 + max, i5, i6 + max);
                    return;
                } else {
                    int max2 = Math.max((dpn.O0000OoO - dpf.getComMeasuredHeight()) + 0, o00000o0.O0000Oo);
                    dpf.comLayout(i3, i4 - max2, i5, i6 - max2);
                    return;
                }
            } else if (i != 2) {
                int i10 = i4 + i7;
                dpf.comLayout(i3, (i10 - dpf.getComMeasuredHeight()) - o00000o0.O0000Oo, i5, i10 - o00000o0.O0000Oo);
                return;
            } else {
                dpf.comLayout(i3, (i4 - i7) + dpf.getComMeasuredHeight() + o00000o0.O0000OOo, i5, (i6 - i7) + dpf.getComMeasuredHeight() + o00000o0.O0000OOo);
                return;
            }
        }
        if (i != 2) {
            dpf.comLayout(i3, i4 + o00000o0.O0000OOo, i5, i6 + o00000o0.O0000OOo);
        } else {
            dpf.comLayout(i3, i4 - o00000o0.O0000Oo, i5, i6 - o00000o0.O0000Oo);
        }
    }

    public final boolean O00000o0(int i, int i2) {
        boolean O00000o02 = super.O00000o0(i, i2);
        if (O00000o02) {
            return O00000o02;
        }
        switch (i) {
            case -1063257157:
                this.O000o0O0 = i2;
                return true;
            case -975171706:
                this.O000o00O = i2;
                return true;
            case -752601676:
                this.O000o0O = i2;
                return true;
            case 1744216035:
                this.O000o00o = i2;
                return true;
            case 1860657097:
                this.O000o0 = i2;
                return true;
            default:
                return false;
        }
    }

    public static class O00000o0 extends dpd.O000000o {
        public int O0000Ooo;
        public int O0000o;
        public float O0000o0;
        public float O0000o00;
        public int O0000o0O;
        public float O0000o0o;
        public int O0000oO;
        public int O0000oO0;
        public int O0000oOO;
        public boolean O0000oOo;

        public O00000o0() {
            this.O0000Ooo = 1;
            this.O0000o00 = 0.0f;
            this.O0000o0 = 1.0f;
            this.O0000o0O = -1;
            this.O0000o0o = -1.0f;
            this.O0000oO = 16777215;
            this.O0000oOO = 16777215;
            this.O0000Ooo = 1;
            this.O0000o00 = 0.0f;
            this.O0000o0 = 1.0f;
            this.O0000o0O = -1;
            this.O0000o0o = -1.0f;
            this.O0000o = 0;
            this.O0000oO0 = 0;
            this.O0000oO = 16777215;
            this.O0000oOO = 16777215;
            this.O0000oOo = false;
        }

        public final boolean O00000Oo(int i, int i2) {
            boolean O00000Oo = super.O00000Oo(i, i2);
            if (O00000Oo) {
                return O00000Oo;
            }
            if (i != 1743739820) {
                return false;
            }
            this.O0000o00 = (float) i2;
            return true;
        }
    }

    public static class O000000o implements dpf.O000000o {
        public final dpf O000000o(VafContext vafContext, dpg dpg) {
            return new dpm(vafContext, dpg);
        }
    }

    static class O00000Oo implements Comparable<O00000Oo> {

        /* renamed from: O000000o  reason: collision with root package name */
        int f14840O000000o;
        int O00000Oo;

        private O00000Oo() {
        }

        /* synthetic */ O00000Oo(byte b) {
            this();
        }

        public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
            O00000Oo o00000Oo = (O00000Oo) obj;
            int i = this.O00000Oo;
            int i2 = o00000Oo.O00000Oo;
            if (i != i2) {
                return i - i2;
            }
            return this.f14840O000000o - o00000Oo.f14840O000000o;
        }

        public final String toString() {
            return "Order{order=" + this.O00000Oo + ", index=" + this.f14840O000000o + '}';
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.util.Arrays.fill(boolean[], boolean):void}
     arg types: [boolean[], int]
     candidates:
      ClspMth{java.util.Arrays.fill(double[], double):void}
      ClspMth{java.util.Arrays.fill(byte[], byte):void}
      ClspMth{java.util.Arrays.fill(long[], long):void}
      ClspMth{java.util.Arrays.fill(char[], char):void}
      ClspMth{java.util.Arrays.fill(short[], short):void}
      ClspMth{java.util.Arrays.fill(java.lang.Object[], java.lang.Object):void}
      ClspMth{java.util.Arrays.fill(int[], int):void}
      ClspMth{java.util.Arrays.fill(float[], float):void}
      ClspMth{java.util.Arrays.fill(boolean[], boolean):void} */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0041  */
    public final void onComMeasure(int i, int i2) {
        boolean z;
        int i3;
        int size = this.f14825O000000o.size();
        if (this.O000o == null) {
            this.O000o = new SparseIntArray(size);
        }
        if (this.O000o.size() == size) {
            int i4 = 0;
            while (true) {
                if (i4 < size) {
                    dpf dpf = (dpf) this.f14825O000000o.get(i4);
                    if (dpf != null && ((O00000o0) dpf.O000O0oo()).O0000Ooo != this.O000o.get(i4)) {
                        break;
                    }
                    i4++;
                } else {
                    z = false;
                    break;
                }
            }
            if (z) {
                int size2 = this.f14825O000000o.size();
                this.O000o0oo = O000000o(size2, O0000OoO(size2));
            }
            boolean[] zArr = this.O000oO0;
            if (zArr == null || zArr.length < this.f14825O000000o.size()) {
                this.O000oO0 = new boolean[this.f14825O000000o.size()];
            }
            i3 = this.O000o00O;
            if (i3 != 0 || i3 == 1) {
                O0000Oo0(i, i2);
            } else if (i3 == 2 || i3 == 3) {
                O0000OOo(i, i2);
            } else {
                throw new IllegalStateException("Invalid value for the flex direction is set: " + this.O000o00O);
            }
            Arrays.fill(this.O000oO0, false);
        }
        z = true;
        if (z) {
        }
        boolean[] zArr2 = this.O000oO0;
        this.O000oO0 = new boolean[this.f14825O000000o.size()];
        i3 = this.O000o00O;
        if (i3 != 0) {
        }
        O0000Oo0(i, i2);
        Arrays.fill(this.O000oO0, false);
    }

    public final /* synthetic */ dpd.O000000o O000000o() {
        return new O00000o0();
    }
}
