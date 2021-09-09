package _m_j;

import android.util.Pair;
import androidx.constraintlayout.motion.widget.MotionLayout;
import java.util.HashMap;

public final class oO0000Oo {

    /* renamed from: O000000o  reason: collision with root package name */
    static final HashMap<Pair<Integer, Integer>, String> f2263O000000o = new HashMap<>();
    static final HashMap<String, String> O00000Oo = new HashMap<>();
    private String O00000o = null;
    private final MotionLayout O00000o0;
    private String O00000oO = null;
    private int O00000oo = -1;
    private int O0000O0o = -1;

    public oO0000Oo(MotionLayout motionLayout) {
        this.O00000o0 = motionLayout;
    }

    static {
        f2263O000000o.put(Pair.create(4, 4), "layout_constraintBottom_toBottomOf");
        f2263O000000o.put(Pair.create(4, 3), "layout_constraintBottom_toTopOf");
        f2263O000000o.put(Pair.create(3, 4), "layout_constraintTop_toBottomOf");
        f2263O000000o.put(Pair.create(3, 3), "layout_constraintTop_toTopOf");
        f2263O000000o.put(Pair.create(6, 6), "layout_constraintStart_toStartOf");
        f2263O000000o.put(Pair.create(6, 7), "layout_constraintStart_toEndOf");
        f2263O000000o.put(Pair.create(7, 6), "layout_constraintEnd_toStartOf");
        f2263O000000o.put(Pair.create(7, 7), "layout_constraintEnd_toEndOf");
        f2263O000000o.put(Pair.create(1, 1), "layout_constraintLeft_toLeftOf");
        f2263O000000o.put(Pair.create(1, 2), "layout_constraintLeft_toRightOf");
        f2263O000000o.put(Pair.create(2, 2), "layout_constraintRight_toRightOf");
        f2263O000000o.put(Pair.create(2, 1), "layout_constraintRight_toLeftOf");
        f2263O000000o.put(Pair.create(5, 5), "layout_constraintBaseline_toBaselineOf");
        O00000Oo.put("layout_constraintBottom_toBottomOf", "layout_marginBottom");
        O00000Oo.put("layout_constraintBottom_toTopOf", "layout_marginBottom");
        O00000Oo.put("layout_constraintTop_toBottomOf", "layout_marginTop");
        O00000Oo.put("layout_constraintTop_toTopOf", "layout_marginTop");
        O00000Oo.put("layout_constraintStart_toStartOf", "layout_marginStart");
        O00000Oo.put("layout_constraintStart_toEndOf", "layout_marginStart");
        O00000Oo.put("layout_constraintEnd_toStartOf", "layout_marginEnd");
        O00000Oo.put("layout_constraintEnd_toEndOf", "layout_marginEnd");
        O00000Oo.put("layout_constraintLeft_toLeftOf", "layout_marginLeft");
        O00000Oo.put("layout_constraintLeft_toRightOf", "layout_marginLeft");
        O00000Oo.put("layout_constraintRight_toRightOf", "layout_marginRight");
        O00000Oo.put("layout_constraintRight_toLeftOf", "layout_marginRight");
    }
}
