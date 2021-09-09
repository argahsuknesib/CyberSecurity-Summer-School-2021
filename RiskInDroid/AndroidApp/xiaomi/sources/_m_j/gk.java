package _m_j;

import _m_j.gy;
import androidx.core.util.Pools;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public final class gk implements gy.O000000o {

    /* renamed from: O000000o  reason: collision with root package name */
    public final ArrayList<O00000Oo> f17923O000000o;
    public final ArrayList<O00000Oo> O00000Oo;
    Runnable O00000o;
    final O000000o O00000o0;
    final boolean O00000oO;
    final gy O00000oo;
    public int O0000O0o;
    private Pools.O000000o<O00000Oo> O0000OOo;

    public interface O000000o {
        RecyclerView.O000OOo0 O000000o(int i);

        void O000000o(int i, int i2);

        void O000000o(int i, int i2, Object obj);

        void O000000o(O00000Oo o00000Oo);

        void O00000Oo(int i, int i2);

        void O00000Oo(O00000Oo o00000Oo);

        void O00000o(int i, int i2);

        void O00000o0(int i, int i2);
    }

    public gk(O000000o o000000o) {
        this(o000000o, (byte) 0);
    }

    private gk(O000000o o000000o, byte b) {
        this.O0000OOo = new Pools.SimplePool(30);
        this.f17923O000000o = new ArrayList<>();
        this.O00000Oo = new ArrayList<>();
        this.O0000O0o = 0;
        this.O00000o0 = o000000o;
        this.O00000oO = false;
        this.O00000oo = new gy(this);
    }

    public final void O000000o() {
        O000000o(this.f17923O000000o);
        O000000o(this.O00000Oo);
        this.O0000O0o = 0;
    }

    /* JADX WARNING: Removed duplicated region for block: B:178:0x0006 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0072  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x009c  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00a0  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00aa  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00af  */
    public final void O00000Oo() {
        char c;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        O00000Oo o00000Oo;
        O00000Oo o00000Oo2;
        gy gyVar = this.O00000oo;
        ArrayList<O00000Oo> arrayList = this.f17923O000000o;
        while (true) {
            int size = arrayList.size() - 1;
            boolean z5 = false;
            while (true) {
                if (size < 0) {
                    size = -1;
                    break;
                }
                if (arrayList.get(size).f17924O000000o != 8) {
                    z5 = true;
                } else if (z5) {
                    break;
                }
                size--;
            }
            O00000Oo o00000Oo3 = null;
            if (size == -1) {
                break;
            }
            int i = size + 1;
            O00000Oo o00000Oo4 = arrayList.get(size);
            O00000Oo o00000Oo5 = arrayList.get(i);
            int i2 = o00000Oo5.f17924O000000o;
            if (i2 == 1) {
                int i3 = o00000Oo4.O00000o < o00000Oo5.O00000Oo ? -1 : 0;
                if (o00000Oo4.O00000Oo < o00000Oo5.O00000Oo) {
                    i3++;
                }
                if (o00000Oo5.O00000Oo <= o00000Oo4.O00000Oo) {
                    o00000Oo4.O00000Oo += o00000Oo5.O00000o;
                }
                if (o00000Oo5.O00000Oo <= o00000Oo4.O00000o) {
                    o00000Oo4.O00000o += o00000Oo5.O00000o;
                }
                o00000Oo5.O00000Oo += i3;
                arrayList.set(size, o00000Oo5);
                arrayList.set(i, o00000Oo4);
            } else if (i2 == 2) {
                if (o00000Oo4.O00000Oo < o00000Oo4.O00000o) {
                    z4 = o00000Oo5.O00000Oo == o00000Oo4.O00000Oo && o00000Oo5.O00000o == o00000Oo4.O00000o - o00000Oo4.O00000Oo;
                    z3 = false;
                } else {
                    z4 = o00000Oo5.O00000Oo == o00000Oo4.O00000o + 1 && o00000Oo5.O00000o == o00000Oo4.O00000Oo - o00000Oo4.O00000o;
                    z3 = true;
                }
                if (o00000Oo4.O00000o < o00000Oo5.O00000Oo) {
                    o00000Oo5.O00000Oo--;
                } else if (o00000Oo4.O00000o < o00000Oo5.O00000Oo + o00000Oo5.O00000o) {
                    o00000Oo5.O00000o--;
                    o00000Oo4.f17924O000000o = 2;
                    o00000Oo4.O00000o = 1;
                    if (o00000Oo5.O00000o == 0) {
                        arrayList.remove(i);
                        gyVar.f18518O000000o.O000000o(o00000Oo5);
                    }
                }
                if (o00000Oo4.O00000Oo <= o00000Oo5.O00000Oo) {
                    o00000Oo5.O00000Oo++;
                } else if (o00000Oo4.O00000Oo < o00000Oo5.O00000Oo + o00000Oo5.O00000o) {
                    o00000Oo3 = gyVar.f18518O000000o.O000000o(2, o00000Oo4.O00000Oo + 1, (o00000Oo5.O00000Oo + o00000Oo5.O00000o) - o00000Oo4.O00000Oo, null);
                    o00000Oo5.O00000o = o00000Oo4.O00000Oo - o00000Oo5.O00000Oo;
                }
                if (z4) {
                    arrayList.set(size, o00000Oo5);
                    arrayList.remove(i);
                    gyVar.f18518O000000o.O000000o(o00000Oo4);
                } else {
                    if (z3) {
                        if (o00000Oo3 != null) {
                            if (o00000Oo4.O00000Oo > o00000Oo3.O00000Oo) {
                                o00000Oo4.O00000Oo -= o00000Oo3.O00000o;
                            }
                            if (o00000Oo4.O00000o > o00000Oo3.O00000Oo) {
                                o00000Oo4.O00000o -= o00000Oo3.O00000o;
                            }
                        }
                        if (o00000Oo4.O00000Oo > o00000Oo5.O00000Oo) {
                            o00000Oo4.O00000Oo -= o00000Oo5.O00000o;
                        }
                        if (o00000Oo4.O00000o > o00000Oo5.O00000Oo) {
                            o00000Oo4.O00000o -= o00000Oo5.O00000o;
                        }
                    } else {
                        if (o00000Oo3 != null) {
                            if (o00000Oo4.O00000Oo >= o00000Oo3.O00000Oo) {
                                o00000Oo4.O00000Oo -= o00000Oo3.O00000o;
                            }
                            if (o00000Oo4.O00000o >= o00000Oo3.O00000Oo) {
                                o00000Oo4.O00000o -= o00000Oo3.O00000o;
                            }
                        }
                        if (o00000Oo4.O00000Oo >= o00000Oo5.O00000Oo) {
                            o00000Oo4.O00000Oo -= o00000Oo5.O00000o;
                        }
                        if (o00000Oo4.O00000o >= o00000Oo5.O00000Oo) {
                            o00000Oo4.O00000o -= o00000Oo5.O00000o;
                        }
                    }
                    arrayList.set(size, o00000Oo5);
                    if (o00000Oo4.O00000Oo != o00000Oo4.O00000o) {
                        arrayList.set(i, o00000Oo4);
                    } else {
                        arrayList.remove(i);
                    }
                    if (o00000Oo3 != null) {
                        arrayList.add(size, o00000Oo3);
                    }
                }
            } else if (i2 == 4) {
                if (o00000Oo4.O00000o < o00000Oo5.O00000Oo) {
                    o00000Oo5.O00000Oo--;
                } else if (o00000Oo4.O00000o < o00000Oo5.O00000Oo + o00000Oo5.O00000o) {
                    o00000Oo5.O00000o--;
                    o00000Oo = gyVar.f18518O000000o.O000000o(4, o00000Oo4.O00000Oo, 1, o00000Oo5.O00000o0);
                    if (o00000Oo4.O00000Oo > o00000Oo5.O00000Oo) {
                        o00000Oo5.O00000Oo++;
                    } else if (o00000Oo4.O00000Oo < o00000Oo5.O00000Oo + o00000Oo5.O00000o) {
                        int i4 = (o00000Oo5.O00000Oo + o00000Oo5.O00000o) - o00000Oo4.O00000Oo;
                        o00000Oo2 = gyVar.f18518O000000o.O000000o(4, o00000Oo4.O00000Oo + 1, i4, o00000Oo5.O00000o0);
                        o00000Oo5.O00000o -= i4;
                        arrayList.set(i, o00000Oo4);
                        if (o00000Oo5.O00000o > 0) {
                            arrayList.set(size, o00000Oo5);
                        } else {
                            arrayList.remove(size);
                            gyVar.f18518O000000o.O000000o(o00000Oo5);
                        }
                        if (o00000Oo != null) {
                            arrayList.add(size, o00000Oo);
                        }
                        if (o00000Oo2 != null) {
                            arrayList.add(size, o00000Oo2);
                        }
                    }
                    o00000Oo2 = null;
                    arrayList.set(i, o00000Oo4);
                    if (o00000Oo5.O00000o > 0) {
                    }
                    if (o00000Oo != null) {
                    }
                    if (o00000Oo2 != null) {
                    }
                }
                o00000Oo = null;
                if (o00000Oo4.O00000Oo > o00000Oo5.O00000Oo) {
                }
                o00000Oo2 = null;
                arrayList.set(i, o00000Oo4);
                if (o00000Oo5.O00000o > 0) {
                }
                if (o00000Oo != null) {
                }
                if (o00000Oo2 != null) {
                }
            }
        }
        int size2 = this.f17923O000000o.size();
        for (int i5 = 0; i5 < size2; i5++) {
            O00000Oo o00000Oo6 = this.f17923O000000o.get(i5);
            int i6 = o00000Oo6.f17924O000000o;
            if (i6 == 1) {
                O00000o0(o00000Oo6);
            } else if (i6 == 2) {
                int i7 = o00000Oo6.O00000Oo;
                int i8 = o00000Oo6.O00000Oo + o00000Oo6.O00000o;
                int i9 = o00000Oo6.O00000Oo;
                int i10 = 0;
                char c2 = 65535;
                while (i9 < i8) {
                    if (this.O00000o0.O000000o(i9) != null || O00000o0(i9)) {
                        if (c2 == 0) {
                            O00000Oo(O000000o(2, i7, i10, null));
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        c = 1;
                    } else {
                        if (c2 == 1) {
                            O00000o0(O000000o(2, i7, i10, null));
                            z = true;
                        } else {
                            z = false;
                        }
                        c = 0;
                    }
                    if (z) {
                        i9 -= i10;
                        i8 -= i10;
                        i10 = 1;
                    } else {
                        i10++;
                    }
                    i9++;
                    c2 = c;
                }
                if (i10 != o00000Oo6.O00000o) {
                    O000000o(o00000Oo6);
                    o00000Oo6 = O000000o(2, i7, i10, null);
                }
                if (c2 == 0) {
                    O00000Oo(o00000Oo6);
                } else {
                    O00000o0(o00000Oo6);
                }
            } else if (i6 == 4) {
                int i11 = o00000Oo6.O00000Oo;
                int i12 = o00000Oo6.O00000Oo + o00000Oo6.O00000o;
                int i13 = i11;
                int i14 = 0;
                char c3 = 65535;
                for (int i15 = o00000Oo6.O00000Oo; i15 < i12; i15++) {
                    if (this.O00000o0.O000000o(i15) != null || O00000o0(i15)) {
                        if (c3 == 0) {
                            O00000Oo(O000000o(4, i13, i14, o00000Oo6.O00000o0));
                            i13 = i15;
                            i14 = 0;
                        }
                        c3 = 1;
                    } else {
                        if (c3 == 1) {
                            O00000o0(O000000o(4, i13, i14, o00000Oo6.O00000o0));
                            i13 = i15;
                            i14 = 0;
                        }
                        c3 = 0;
                    }
                    i14++;
                }
                if (i14 != o00000Oo6.O00000o) {
                    Object obj = o00000Oo6.O00000o0;
                    O000000o(o00000Oo6);
                    o00000Oo6 = O000000o(4, i13, i14, obj);
                }
                if (c3 == 0) {
                    O00000Oo(o00000Oo6);
                } else {
                    O00000o0(o00000Oo6);
                }
            } else if (i6 == 8) {
                O00000o0(o00000Oo6);
            }
            Runnable runnable = this.O00000o;
            if (runnable != null) {
                runnable.run();
            }
        }
        this.f17923O000000o.clear();
    }

    public final void O00000o0() {
        int size = this.O00000Oo.size();
        for (int i = 0; i < size; i++) {
            this.O00000o0.O00000Oo(this.O00000Oo.get(i));
        }
        O000000o(this.O00000Oo);
        this.O0000O0o = 0;
    }

    private void O00000Oo(O00000Oo o00000Oo) {
        int i;
        if (o00000Oo.f17924O000000o == 1 || o00000Oo.f17924O000000o == 8) {
            throw new IllegalArgumentException("should not dispatch add or move for pre layout");
        }
        int O00000Oo2 = O00000Oo(o00000Oo.O00000Oo, o00000Oo.f17924O000000o);
        int i2 = o00000Oo.O00000Oo;
        int i3 = o00000Oo.f17924O000000o;
        if (i3 == 2) {
            i = 0;
        } else if (i3 == 4) {
            i = 1;
        } else {
            throw new IllegalArgumentException("op should be remove or update.".concat(String.valueOf(o00000Oo)));
        }
        int i4 = O00000Oo2;
        int i5 = i2;
        int i6 = 1;
        for (int i7 = 1; i7 < o00000Oo.O00000o; i7++) {
            int O00000Oo3 = O00000Oo(o00000Oo.O00000Oo + (i * i7), o00000Oo.f17924O000000o);
            int i8 = o00000Oo.f17924O000000o;
            if (i8 == 2 ? O00000Oo3 == i4 : i8 == 4 && O00000Oo3 == i4 + 1) {
                i6++;
            } else {
                O00000Oo O000000o2 = O000000o(o00000Oo.f17924O000000o, i4, i6, o00000Oo.O00000o0);
                O000000o(O000000o2, i5);
                O000000o(O000000o2);
                if (o00000Oo.f17924O000000o == 4) {
                    i5 += i6;
                }
                i4 = O00000Oo3;
                i6 = 1;
            }
        }
        Object obj = o00000Oo.O00000o0;
        O000000o(o00000Oo);
        if (i6 > 0) {
            O00000Oo O000000o3 = O000000o(o00000Oo.f17924O000000o, i4, i6, obj);
            O000000o(O000000o3, i5);
            O000000o(O000000o3);
        }
    }

    private void O000000o(O00000Oo o00000Oo, int i) {
        this.O00000o0.O000000o(o00000Oo);
        int i2 = o00000Oo.f17924O000000o;
        if (i2 == 2) {
            this.O00000o0.O000000o(i, o00000Oo.O00000o);
        } else if (i2 == 4) {
            this.O00000o0.O000000o(i, o00000Oo.O00000o, o00000Oo.O00000o0);
        } else {
            throw new IllegalArgumentException("only remove and update ops can be dispatched in first pass");
        }
    }

    private int O00000Oo(int i, int i2) {
        int i3;
        int i4;
        for (int size = this.O00000Oo.size() - 1; size >= 0; size--) {
            O00000Oo o00000Oo = this.O00000Oo.get(size);
            if (o00000Oo.f17924O000000o == 8) {
                if (o00000Oo.O00000Oo < o00000Oo.O00000o) {
                    i4 = o00000Oo.O00000Oo;
                    i3 = o00000Oo.O00000o;
                } else {
                    i4 = o00000Oo.O00000o;
                    i3 = o00000Oo.O00000Oo;
                }
                if (i < i4 || i > i3) {
                    if (i < o00000Oo.O00000Oo) {
                        if (i2 == 1) {
                            o00000Oo.O00000Oo++;
                            o00000Oo.O00000o++;
                        } else if (i2 == 2) {
                            o00000Oo.O00000Oo--;
                            o00000Oo.O00000o--;
                        }
                    }
                } else if (i4 == o00000Oo.O00000Oo) {
                    if (i2 == 1) {
                        o00000Oo.O00000o++;
                    } else if (i2 == 2) {
                        o00000Oo.O00000o--;
                    }
                    i++;
                } else {
                    if (i2 == 1) {
                        o00000Oo.O00000Oo++;
                    } else if (i2 == 2) {
                        o00000Oo.O00000Oo--;
                    }
                    i--;
                }
            } else if (o00000Oo.O00000Oo <= i) {
                if (o00000Oo.f17924O000000o == 1) {
                    i -= o00000Oo.O00000o;
                } else if (o00000Oo.f17924O000000o == 2) {
                    i += o00000Oo.O00000o;
                }
            } else if (i2 == 1) {
                o00000Oo.O00000Oo++;
            } else if (i2 == 2) {
                o00000Oo.O00000Oo--;
            }
        }
        for (int size2 = this.O00000Oo.size() - 1; size2 >= 0; size2--) {
            O00000Oo o00000Oo2 = this.O00000Oo.get(size2);
            if (o00000Oo2.f17924O000000o == 8) {
                if (o00000Oo2.O00000o == o00000Oo2.O00000Oo || o00000Oo2.O00000o < 0) {
                    this.O00000Oo.remove(size2);
                    O000000o(o00000Oo2);
                }
            } else if (o00000Oo2.O00000o <= 0) {
                this.O00000Oo.remove(size2);
                O000000o(o00000Oo2);
            }
        }
        return i;
    }

    private boolean O00000o0(int i) {
        int size = this.O00000Oo.size();
        for (int i2 = 0; i2 < size; i2++) {
            O00000Oo o00000Oo = this.O00000Oo.get(i2);
            if (o00000Oo.f17924O000000o == 8) {
                if (O000000o(o00000Oo.O00000o, i2 + 1) == i) {
                    return true;
                }
            } else if (o00000Oo.f17924O000000o == 1) {
                int i3 = o00000Oo.O00000Oo + o00000Oo.O00000o;
                for (int i4 = o00000Oo.O00000Oo; i4 < i3; i4++) {
                    if (O000000o(i4, i2 + 1) == i) {
                        return true;
                    }
                }
                continue;
            } else {
                continue;
            }
        }
        return false;
    }

    private void O00000o0(O00000Oo o00000Oo) {
        this.O00000Oo.add(o00000Oo);
        int i = o00000Oo.f17924O000000o;
        if (i == 1) {
            this.O00000o0.O00000o0(o00000Oo.O00000Oo, o00000Oo.O00000o);
        } else if (i == 2) {
            this.O00000o0.O00000Oo(o00000Oo.O00000Oo, o00000Oo.O00000o);
        } else if (i == 4) {
            this.O00000o0.O000000o(o00000Oo.O00000Oo, o00000Oo.O00000o, o00000Oo.O00000o0);
        } else if (i == 8) {
            this.O00000o0.O00000o(o00000Oo.O00000Oo, o00000Oo.O00000o);
        } else {
            throw new IllegalArgumentException("Unknown update op type for ".concat(String.valueOf(o00000Oo)));
        }
    }

    public final boolean O00000o() {
        return this.f17923O000000o.size() > 0;
    }

    public final boolean O000000o(int i) {
        return (i & this.O0000O0o) != 0;
    }

    public final int O00000Oo(int i) {
        return O000000o(i, 0);
    }

    public final int O000000o(int i, int i2) {
        int size = this.O00000Oo.size();
        while (i2 < size) {
            O00000Oo o00000Oo = this.O00000Oo.get(i2);
            if (o00000Oo.f17924O000000o == 8) {
                if (o00000Oo.O00000Oo == i) {
                    i = o00000Oo.O00000o;
                } else {
                    if (o00000Oo.O00000Oo < i) {
                        i--;
                    }
                    if (o00000Oo.O00000o <= i) {
                        i++;
                    }
                }
            } else if (o00000Oo.O00000Oo > i) {
                continue;
            } else if (o00000Oo.f17924O000000o == 2) {
                if (i < o00000Oo.O00000Oo + o00000Oo.O00000o) {
                    return -1;
                }
                i -= o00000Oo.O00000o;
            } else if (o00000Oo.f17924O000000o == 1) {
                i += o00000Oo.O00000o;
            }
            i2++;
        }
        return i;
    }

    public final void O00000oO() {
        O00000o0();
        int size = this.f17923O000000o.size();
        for (int i = 0; i < size; i++) {
            O00000Oo o00000Oo = this.f17923O000000o.get(i);
            int i2 = o00000Oo.f17924O000000o;
            if (i2 == 1) {
                this.O00000o0.O00000Oo(o00000Oo);
                this.O00000o0.O00000o0(o00000Oo.O00000Oo, o00000Oo.O00000o);
            } else if (i2 == 2) {
                this.O00000o0.O00000Oo(o00000Oo);
                this.O00000o0.O000000o(o00000Oo.O00000Oo, o00000Oo.O00000o);
            } else if (i2 == 4) {
                this.O00000o0.O00000Oo(o00000Oo);
                this.O00000o0.O000000o(o00000Oo.O00000Oo, o00000Oo.O00000o, o00000Oo.O00000o0);
            } else if (i2 == 8) {
                this.O00000o0.O00000Oo(o00000Oo);
                this.O00000o0.O00000o(o00000Oo.O00000Oo, o00000Oo.O00000o);
            }
            Runnable runnable = this.O00000o;
            if (runnable != null) {
                runnable.run();
            }
        }
        O000000o(this.f17923O000000o);
        this.O0000O0o = 0;
    }

    public static class O00000Oo {

        /* renamed from: O000000o  reason: collision with root package name */
        public int f17924O000000o;
        public int O00000Oo;
        public int O00000o;
        public Object O00000o0;

        O00000Oo(int i, int i2, int i3, Object obj) {
            this.f17924O000000o = i;
            this.O00000Oo = i2;
            this.O00000o = i3;
            this.O00000o0 = obj;
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(Integer.toHexString(System.identityHashCode(this)));
            sb.append("[");
            int i = this.f17924O000000o;
            sb.append(i != 1 ? i != 2 ? i != 4 ? i != 8 ? "??" : "mv" : "up" : "rm" : "add");
            sb.append(",s:");
            sb.append(this.O00000Oo);
            sb.append("c:");
            sb.append(this.O00000o);
            sb.append(",p:");
            sb.append(this.O00000o0);
            sb.append("]");
            return sb.toString();
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            O00000Oo o00000Oo = (O00000Oo) obj;
            int i = this.f17924O000000o;
            if (i != o00000Oo.f17924O000000o) {
                return false;
            }
            if (i == 8 && Math.abs(this.O00000o - this.O00000Oo) == 1 && this.O00000o == o00000Oo.O00000Oo && this.O00000Oo == o00000Oo.O00000o) {
                return true;
            }
            if (this.O00000o != o00000Oo.O00000o || this.O00000Oo != o00000Oo.O00000Oo) {
                return false;
            }
            Object obj2 = this.O00000o0;
            if (obj2 != null) {
                if (!obj2.equals(o00000Oo.O00000o0)) {
                    return false;
                }
            } else if (o00000Oo.O00000o0 != null) {
                return false;
            }
            return true;
        }

        public final int hashCode() {
            return (((this.f17924O000000o * 31) + this.O00000Oo) * 31) + this.O00000o;
        }
    }

    public final O00000Oo O000000o(int i, int i2, int i3, Object obj) {
        O00000Oo acquire = this.O0000OOo.acquire();
        if (acquire == null) {
            return new O00000Oo(i, i2, i3, obj);
        }
        acquire.f17924O000000o = i;
        acquire.O00000Oo = i2;
        acquire.O00000o = i3;
        acquire.O00000o0 = obj;
        return acquire;
    }

    public final void O000000o(O00000Oo o00000Oo) {
        if (!this.O00000oO) {
            o00000Oo.O00000o0 = null;
            this.O0000OOo.release(o00000Oo);
        }
    }

    private void O000000o(List<O00000Oo> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            O000000o(list.get(i));
        }
        list.clear();
    }
}
