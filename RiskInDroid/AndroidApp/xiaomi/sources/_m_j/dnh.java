package _m_j;

import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.util.HashSet;
import java.util.Set;

public abstract class dnh extends dnp {

    /* renamed from: O000000o  reason: collision with root package name */
    protected int f14805O000000o;
    protected int O00000Oo;
    protected Set<Object> O00000o0;

    public void O000000o() {
        super.O000000o();
        this.O00000Oo = 256;
    }

    /* access modifiers changed from: protected */
    public final dmx O000000o(int i) {
        dmx dmx = new dmx();
        if (i != 0) {
            if (i == 1) {
                dmx.O000000o(this.O0000Oo.O00000Oo());
            } else if (i == 2) {
                dmx.O000000o(Float.intBitsToFloat(this.O0000Oo.O00000Oo()));
            } else if (i == 3) {
                dmx.O000000o(this.O0000OOo.O000000o(this.O0000Oo.O00000Oo()));
            } else if (i != 4) {
                Log.e("ArithExecutor_TMTEST", "can not read this type:".concat(String.valueOf(i)));
                return null;
            } else {
                boolean z = false;
                int O00000Oo2 = this.O0000Oo.O00000Oo();
                if (O00000Oo2 < this.O00000Oo) {
                    this.O00000Oo = O00000Oo2;
                }
                dmx O000000o2 = this.O0000OoO.O000000o(O00000Oo2);
                if (O000000o2 != null) {
                    dmx.O000000o(O000000o2);
                    z = true;
                }
                if (!z) {
                    return null;
                }
            }
        } else if (!O000000o(dmx)) {
            return null;
        }
        return dmx;
    }

    private boolean O000000o(dmx dmx) {
        Set<Object> O00000Oo2 = O00000Oo();
        if (O00000Oo2 == null) {
            return false;
        }
        int O00000Oo3 = this.O0000Oo.O00000Oo();
        for (Object next : O00000Oo2) {
            if (next == this.O0000Ooo) {
                Class[] clsArr = {String.class};
                try {
                    next = next.getClass().getMethod("getData", clsArr).invoke(next, this.O0000OOo.O000000o(O00000Oo3));
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                    Log.e("ArithExecutor_TMTEST", "getData NoSuchMethodException:");
                } catch (InvocationTargetException e2) {
                    e2.printStackTrace();
                    Log.e("ArithExecutor_TMTEST", "getData InvocationTargetException:");
                } catch (IllegalAccessException e3) {
                    e3.printStackTrace();
                    Log.e("ArithExecutor_TMTEST", "getData IllegalAccessException:");
                }
            } else {
                next = this.O0000Oo0.O000000o(next, O00000Oo3);
            }
            if (next == null) {
                Log.e("ArithExecutor_TMTEST", "getProperty failed");
            } else if (next instanceof Integer) {
                dmx.O000000o(((Integer) next).intValue());
                return true;
            } else if (next instanceof Float) {
                dmx.O000000o(((Float) next).floatValue());
                return true;
            } else if (next instanceof String) {
                dmx.O000000o((String) next);
                return true;
            } else {
                dmx.O00000Oo(next);
                return true;
            }
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public final Set<Object> O00000Oo() {
        dpf O0000oO0;
        if (this.O00000o0 == null) {
            this.O00000o0 = new HashSet(10);
        }
        HashSet<dpf> hashSet = new HashSet<>(10);
        this.O00000o0.clear();
        int O00000Oo2 = this.O0000Oo.O00000Oo();
        if (O00000Oo2 >= 0) {
            dmx O000000o2 = this.O0000OoO.O000000o(O00000Oo2);
            if (O000000o2 == null) {
                Log.e("ArithExecutor_TMTEST", "read obj from register failed  registerId:".concat(String.valueOf(O00000Oo2)));
            } else if (4 == O000000o2.O00000Oo) {
                hashSet.add(O000000o2.O00000o());
            } else {
                Log.e("ArithExecutor_TMTEST", "read obj from register failed obj:".concat(String.valueOf(O000000o2)));
            }
        }
        byte O000000o3 = this.O0000Oo.O000000o();
        this.f14805O000000o = O000000o3;
        boolean z = false;
        if (O000000o3 > 0) {
            if (hashSet.size() <= 0) {
                int O00000Oo3 = this.O0000Oo.O00000Oo();
                if (-1068784020 == O00000Oo3) {
                    if (3 == O000000o3) {
                        String O000000o4 = this.O0000OOo.O000000o(this.O0000Oo.O00000Oo());
                        Object obj = this.O0000Oo0.O00000Oo.get(O000000o4);
                        if (obj != null) {
                            hashSet.add(obj);
                        } else {
                            Log.e("ArithExecutor_TMTEST", "findObject can not find module:".concat(String.valueOf(O000000o4)));
                        }
                    } else {
                        Log.e("ArithExecutor_TMTEST", "findObject count invalidate:".concat(String.valueOf((int) O000000o3)));
                    }
                    return hashSet;
                } else if (3076010 == O00000Oo3) {
                    hashSet.add(this.O0000Ooo);
                    return hashSet;
                } else if (3559070 == O00000Oo3) {
                    hashSet.add(this.O00000oo);
                } else if (!this.O0000OOo.O00000Oo(O00000Oo3)) {
                    dpf O000000o5 = O00000Oo2 < 0 ? this.O0000Oo0.O000000o(O00000Oo3) : null;
                    if (O000000o5 == null) {
                        Log.e("ArithExecutor_TMTEST", "findObject can not find com id:".concat(String.valueOf(O00000Oo3)));
                    } else {
                        hashSet.add(O000000o5);
                    }
                } else {
                    Log.e("ArithExecutor_TMTEST", "findObject first token invalidate id:".concat(String.valueOf(O00000Oo3)));
                }
            }
            if (hashSet.size() > 0) {
                int i = 0;
                boolean z2 = true;
                while (i < O000000o3 - 2) {
                    int O00000Oo4 = this.O0000Oo.O00000Oo();
                    if (this.O0000OOo.O00000Oo(O00000Oo4)) {
                        switch (O00000Oo4) {
                            case -995424086:
                                this.O00000o0.clear();
                                for (Object next : hashSet) {
                                    if (next instanceof dpf) {
                                        dpf O0000oO02 = ((dpf) next).O0000oO0();
                                        if (O0000oO02 != null) {
                                            this.O00000o0.add(O0000oO02);
                                        }
                                    } else {
                                        Log.w("ArithExecutor_TMTEST", "warning");
                                    }
                                }
                                hashSet.clear();
                                hashSet.addAll(this.O00000o0);
                                break;
                            case -973829677:
                                this.O00000o0.clear();
                                for (Object next2 : hashSet) {
                                    if (next2 instanceof dpf) {
                                        for (dpf O0000oO03 = ((dpf) next2).O0000oO0(); O0000oO03 != null; O0000oO03 = O0000oO03.O0000oO0()) {
                                            this.O00000o0.add(O0000oO03);
                                        }
                                    }
                                }
                                hashSet.clear();
                                hashSet.addAll(this.O00000o0);
                                break;
                            case 3559070:
                            case 1659526655:
                                break;
                            case 166965745:
                                this.O00000o0.clear();
                                for (Object next3 : hashSet) {
                                    if ((next3 instanceof dpf) && (O0000oO0 = ((dpf) next3).O0000oO0()) != null && (O0000oO0 instanceof dpd)) {
                                        this.O00000o0.addAll(((dpd) O0000oO0).O00000Oo());
                                        this.O00000o0.remove(next3);
                                    }
                                }
                                hashSet.clear();
                                hashSet.addAll(this.O00000o0);
                                break;
                            default:
                                Log.e("ArithExecutor_TMTEST", "findObject invalidate system id:".concat(String.valueOf(O00000Oo4)));
                                z2 = false;
                                break;
                        }
                    } else {
                        this.O00000o0.clear();
                        for (dpf O000000o6 : hashSet) {
                            dpf O000000o7 = O000000o6.O000000o(this.O0000OOo.O000000o(O00000Oo4));
                            if (O000000o7 != null) {
                                this.O00000o0.add(O000000o7);
                            } else {
                                Log.e("ArithExecutor_TMTEST", "can not find obj:" + this.O0000OOo.O000000o(O00000Oo4));
                            }
                        }
                        hashSet.clear();
                        hashSet.addAll(this.O00000o0);
                    }
                    if (z2) {
                        i++;
                    } else {
                        z = z2;
                    }
                }
                z = z2;
            }
        } else {
            Log.e("ArithExecutor_TMTEST", "findObject count invalidate:".concat(String.valueOf((int) O000000o3)));
        }
        if (!z) {
            return null;
        }
        return hashSet;
    }
}
