package _m_j;

import android.graphics.Rect;
import java.util.Comparator;

final class dg {

    public interface O000000o<T> {
        void O000000o(T t, Rect rect);
    }

    public interface O00000Oo<T, V> {
        int O000000o(T t);

        V O000000o(T t, int i);
    }

    private static int O000000o(int i, int i2) {
        return (i * 13 * i) + (i2 * i2);
    }

    static class O00000o0<T> implements Comparator<T> {

        /* renamed from: O000000o  reason: collision with root package name */
        private final Rect f14593O000000o = new Rect();
        private final Rect O00000Oo = new Rect();
        private final O000000o<T> O00000o;
        private final boolean O00000o0;

        O00000o0(boolean z, O000000o<T> o000000o) {
            this.O00000o0 = z;
            this.O00000o = o000000o;
        }

        public final int compare(T t, T t2) {
            Rect rect = this.f14593O000000o;
            Rect rect2 = this.O00000Oo;
            this.O00000o.O000000o(t, rect);
            this.O00000o.O000000o(t2, rect2);
            if (rect.top < rect2.top) {
                return -1;
            }
            if (rect.top > rect2.top) {
                return 1;
            }
            if (rect.left < rect2.left) {
                if (this.O00000o0) {
                    return 1;
                }
                return -1;
            } else if (rect.left > rect2.left) {
                if (this.O00000o0) {
                    return -1;
                }
                return 1;
            } else if (rect.bottom < rect2.bottom) {
                return -1;
            } else {
                if (rect.bottom > rect2.bottom) {
                    return 1;
                }
                if (rect.right < rect2.right) {
                    if (this.O00000o0) {
                        return 1;
                    }
                    return -1;
                } else if (rect.right <= rect2.right) {
                    return 0;
                } else {
                    if (this.O00000o0) {
                        return -1;
                    }
                    return 1;
                }
            }
        }
    }

    public static <L, T> T O000000o(L l, O00000Oo<L, T> o00000Oo, O000000o<T> o000000o, T t, Rect rect, int i) {
        boolean z;
        L l2 = l;
        O00000Oo<L, T> o00000Oo2 = o00000Oo;
        Rect rect2 = rect;
        int i2 = i;
        Rect rect3 = new Rect(rect2);
        if (i2 == 17) {
            rect3.offset(rect.width() + 1, 0);
        } else if (i2 == 33) {
            rect3.offset(0, rect.height() + 1);
        } else if (i2 == 66) {
            rect3.offset(-(rect.width() + 1), 0);
        } else if (i2 == 130) {
            rect3.offset(0, -(rect.height() + 1));
        } else {
            throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
        }
        int O000000o2 = o00000Oo2.O000000o(l2);
        Rect rect4 = new Rect();
        T t2 = null;
        for (int i3 = 0; i3 < O000000o2; i3++) {
            T O000000o3 = o00000Oo2.O000000o(l2, i3);
            if (O000000o3 != t) {
                o000000o.O000000o(O000000o3, rect4);
                if (!O000000o(rect2, rect4, i2) || (O000000o(rect2, rect3, i2) && !O000000o(i2, rect2, rect4, rect3) && (O000000o(i2, rect2, rect3, rect4) || O000000o(O00000o0(i2, rect2, rect4), O0000O0o(i2, rect2, rect4)) >= O000000o(O00000o0(i2, rect2, rect3), O0000O0o(i2, rect2, rect3))))) {
                    z = false;
                } else {
                    z = true;
                }
                if (z) {
                    rect3.set(rect4);
                    t2 = O000000o3;
                }
            }
        }
        return t2;
    }

    private static boolean O000000o(int i, Rect rect, Rect rect2, Rect rect3) {
        boolean O000000o2 = O000000o(i, rect, rect2);
        if (O000000o(i, rect, rect3) || !O000000o2) {
            return false;
        }
        if (O00000Oo(i, rect, rect3) && i != 17 && i != 66 && O00000o0(i, rect, rect2) >= O00000oO(i, rect, rect3)) {
            return false;
        }
        return true;
    }

    private static boolean O000000o(Rect rect, Rect rect2, int i) {
        if (i == 17) {
            return (rect.right > rect2.right || rect.left >= rect2.right) && rect.left > rect2.left;
        }
        if (i == 33) {
            return (rect.bottom > rect2.bottom || rect.top >= rect2.bottom) && rect.top > rect2.top;
        }
        if (i == 66) {
            return (rect.left < rect2.left || rect.right <= rect2.left) && rect.right < rect2.right;
        }
        if (i == 130) {
            return (rect.top < rect2.top || rect.bottom <= rect2.top) && rect.bottom < rect2.bottom;
        }
        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
    }

    private static boolean O000000o(int i, Rect rect, Rect rect2) {
        if (i != 17) {
            if (i != 33) {
                if (i != 66) {
                    if (i != 130) {
                        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                    }
                }
            }
            return rect2.right >= rect.left && rect2.left <= rect.right;
        }
        return rect2.bottom >= rect.top && rect2.top <= rect.bottom;
    }

    private static boolean O00000Oo(int i, Rect rect, Rect rect2) {
        if (i == 17) {
            return rect.left >= rect2.right;
        }
        if (i == 33) {
            return rect.top >= rect2.bottom;
        }
        if (i == 66) {
            return rect.right <= rect2.left;
        }
        if (i == 130) {
            return rect.bottom <= rect2.top;
        }
        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
    }

    private static int O00000o0(int i, Rect rect, Rect rect2) {
        return Math.max(0, O00000o(i, rect, rect2));
    }

    private static int O00000o(int i, Rect rect, Rect rect2) {
        int i2;
        int i3;
        if (i == 17) {
            i2 = rect.left;
            i3 = rect2.right;
        } else if (i == 33) {
            i2 = rect.top;
            i3 = rect2.bottom;
        } else if (i == 66) {
            i2 = rect2.left;
            i3 = rect.right;
        } else if (i == 130) {
            i2 = rect2.top;
            i3 = rect.bottom;
        } else {
            throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
        }
        return i2 - i3;
    }

    private static int O00000oO(int i, Rect rect, Rect rect2) {
        return Math.max(1, O00000oo(i, rect, rect2));
    }

    private static int O00000oo(int i, Rect rect, Rect rect2) {
        int i2;
        int i3;
        if (i == 17) {
            i2 = rect.left;
            i3 = rect2.left;
        } else if (i == 33) {
            i2 = rect.top;
            i3 = rect2.top;
        } else if (i == 66) {
            i2 = rect2.right;
            i3 = rect.right;
        } else if (i == 130) {
            i2 = rect2.bottom;
            i3 = rect.bottom;
        } else {
            throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
        }
        return i2 - i3;
    }

    private static int O0000O0o(int i, Rect rect, Rect rect2) {
        if (i != 17) {
            if (i != 33) {
                if (i != 66) {
                    if (i != 130) {
                        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                    }
                }
            }
            return Math.abs((rect.left + (rect.width() / 2)) - (rect2.left + (rect2.width() / 2)));
        }
        return Math.abs((rect.top + (rect.height() / 2)) - (rect2.top + (rect2.height() / 2)));
    }
}
