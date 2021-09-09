package _m_j;

import com.facebook.react.bridge.ReadableMap;
import com.horcrux.svg.GroupView;
import java.util.ArrayList;

public final class bal {

    /* renamed from: O000000o  reason: collision with root package name */
    public final ArrayList<bak> f12746O000000o = new ArrayList<>();
    public final ArrayList<baq[]> O00000Oo = new ArrayList<>();
    public final ArrayList<baq[]> O00000o = new ArrayList<>();
    public final ArrayList<baq[]> O00000o0 = new ArrayList<>();
    public final ArrayList<baq[]> O00000oO = new ArrayList<>();
    public final ArrayList<double[]> O00000oo = new ArrayList<>();
    public final ArrayList<Integer> O0000O0o = new ArrayList<>();
    public final ArrayList<Integer> O0000OOo = new ArrayList<>();
    public final ArrayList<Integer> O0000Oo = new ArrayList<>();
    public final ArrayList<Integer> O0000Oo0 = new ArrayList<>();
    public final ArrayList<Integer> O0000OoO = new ArrayList<>();
    public final ArrayList<Integer> O0000Ooo = new ArrayList<>();
    public double O0000o = 12.0d;
    public final ArrayList<Integer> O0000o0 = new ArrayList<>();
    public final ArrayList<Integer> O0000o00 = new ArrayList<>();
    public final ArrayList<Integer> O0000o0O = new ArrayList<>();
    public final ArrayList<Integer> O0000o0o = new ArrayList<>();
    public double O0000oO;
    public bak O0000oO0 = bak.O0000o00;
    public double O0000oOO;
    public double O0000oOo;
    public baq[] O0000oo = new baq[0];
    public double O0000oo0;
    public baq[] O0000ooO = new baq[0];
    public baq[] O0000ooo = new baq[0];
    public int O000O00o;
    public int O000O0OO;
    public int O000O0Oo;
    public int O000O0o = -1;
    public int O000O0o0;
    public int O000O0oO = -1;
    public int O000O0oo = -1;
    public int O000OO;
    public int O000OO00 = -1;
    public int O000OO0o = -1;
    public final float O000OOOo;
    private final float O000OOo;
    public final float O000OOo0;
    public int O00oOoOo;
    public baq[] O00oOooO = new baq[0];
    public double[] O00oOooo = {0.0d};

    public final void O000000o() {
        this.O0000Ooo.add(Integer.valueOf(this.O000O00o));
        this.O0000o00.add(Integer.valueOf(this.O000O0OO));
        this.O0000o0.add(Integer.valueOf(this.O000O0Oo));
        this.O0000o0O.add(Integer.valueOf(this.O00oOoOo));
        this.O0000o0o.add(Integer.valueOf(this.O000O0o0));
    }

    public bal(float f, float f2, float f3) {
        this.O000OOo = f;
        this.O000OOOo = f2;
        this.O000OOo0 = f3;
        this.O00000Oo.add(this.O0000oo);
        this.O00000o0.add(this.O0000ooO);
        this.O00000o.add(this.O0000ooo);
        this.O00000oO.add(this.O00oOooO);
        this.O00000oo.add(this.O00oOooo);
        this.O0000O0o.add(Integer.valueOf(this.O000O0o));
        this.O0000OOo.add(Integer.valueOf(this.O000O0oO));
        this.O0000Oo0.add(Integer.valueOf(this.O000O0oo));
        this.O0000Oo.add(Integer.valueOf(this.O000OO00));
        this.O0000OoO.add(Integer.valueOf(this.O000OO0o));
        this.f12746O000000o.add(this.O0000oO0);
        O000000o();
    }

    public static baq[] O000000o(ArrayList<baq> arrayList) {
        int size = arrayList.size();
        baq[] baqArr = new baq[size];
        for (int i = 0; i < size; i++) {
            baqArr[i] = arrayList.get(i);
        }
        return baqArr;
    }

    private static void O000000o(ArrayList<Integer> arrayList, int i) {
        while (i >= 0) {
            arrayList.set(i, Integer.valueOf(arrayList.get(i).intValue() + 1));
            i--;
        }
    }

    public final double O000000o(double d) {
        O000000o(this.O0000O0o, this.O000O00o);
        int i = this.O000O0o + 1;
        baq[] baqArr = this.O0000oo;
        if (i < baqArr.length) {
            this.O0000oOo = 0.0d;
            this.O000O0o = i;
            this.O0000oO = bao.O000000o(baqArr[i], (double) this.O000OOOo, 0.0d, (double) this.O000OOo, this.O0000o);
        }
        this.O0000oO += d;
        return this.O0000oO;
    }

    public final double O00000Oo() {
        O000000o(this.O0000OOo, this.O000O0OO);
        int i = this.O000O0oO + 1;
        baq[] baqArr = this.O0000ooO;
        if (i < baqArr.length) {
            this.O0000oo0 = 0.0d;
            this.O000O0oO = i;
            this.O0000oOO = bao.O000000o(baqArr[i], (double) this.O000OOo0, 0.0d, (double) this.O000OOo, this.O0000o);
        }
        return this.O0000oOO;
    }

    public final double O00000o0() {
        O000000o(this.O0000Oo0, this.O000O0Oo);
        int i = this.O000O0oo + 1;
        baq[] baqArr = this.O0000ooo;
        if (i < baqArr.length) {
            this.O000O0oo = i;
            this.O0000oOo += bao.O000000o(baqArr[i], (double) this.O000OOOo, 0.0d, (double) this.O000OOo, this.O0000o);
        }
        return this.O0000oOo;
    }

    public final double O00000o() {
        O000000o(this.O0000Oo, this.O00oOoOo);
        int i = this.O000OO00 + 1;
        baq[] baqArr = this.O00oOooO;
        if (i < baqArr.length) {
            this.O000OO00 = i;
            this.O0000oo0 += bao.O000000o(baqArr[i], (double) this.O000OOo0, 0.0d, (double) this.O000OOo, this.O0000o);
        }
        return this.O0000oo0;
    }

    public final double O00000oO() {
        O000000o(this.O0000OoO, this.O000O0o0);
        this.O000OO0o = Math.min(this.O000OO0o + 1, this.O00oOooo.length - 1);
        return this.O00oOooo[this.O000OO0o];
    }

    public final void O000000o(GroupView groupView, ReadableMap readableMap) {
        bak bak;
        if (this.O000OO > 0) {
            bak = this.O0000oO0;
        } else {
            GroupView parentTextRoot = groupView.getParentTextRoot();
            while (true) {
                if (parentTextRoot == null) {
                    bak = bak.O0000o00;
                    break;
                }
                bak bak2 = parentTextRoot.getGlyphContext().O0000oO0;
                if (bak2 != bak.O0000o00) {
                    bak = bak2;
                    break;
                }
                parentTextRoot = parentTextRoot.getParentTextRoot();
            }
        }
        this.O000OO++;
        if (readableMap == null) {
            this.f12746O000000o.add(bak);
            return;
        }
        bak bak3 = new bak(readableMap, bak, (double) this.O000OOo);
        this.O0000o = bak3.f12745O000000o;
        this.f12746O000000o.add(bak3);
        this.O0000oO0 = bak3;
    }
}
