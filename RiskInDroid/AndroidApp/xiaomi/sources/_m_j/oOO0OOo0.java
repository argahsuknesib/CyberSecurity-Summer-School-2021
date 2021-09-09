package _m_j;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.util.Xml;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.constraintlayout.widget.ConstraintHelper;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Constraints;
import androidx.constraintlayout.widget.Guideline;
import androidx.constraintlayout.widget.R$id;
import com.google.android.exoplayer2.C;
import com.google.android.gms.common.internal.GmsLogger;
import com.xiaomi.account.openauth.XiaomiOAuthConstants;
import com.xiaomi.smarthome.R;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import no.nordicsemi.android.dfu.DfuSettingsConstants;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public final class oOO0OOo0 {
    public static final int[] O00000o0 = {0, 4, 8};
    private static SparseIntArray O00000oo;

    /* renamed from: O000000o  reason: collision with root package name */
    public boolean f2303O000000o;
    public boolean O00000Oo = true;
    public HashMap<Integer, O000000o> O00000o = new HashMap<>();
    private HashMap<String, ConstraintAttribute> O00000oO = new HashMap<>();

    private static String O0000O0o(int i) {
        switch (i) {
            case 1:
                return "left";
            case 2:
                return "right";
            case 3:
                return "top";
            case 4:
                return "bottom";
            case 5:
                return "baseline";
            case 6:
                return "start";
            case 7:
                return "end";
            default:
                return "undefined";
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        O00000oo = sparseIntArray;
        sparseIntArray.append(76, 25);
        O00000oo.append(77, 26);
        O00000oo.append(79, 29);
        O00000oo.append(80, 30);
        O00000oo.append(86, 36);
        O00000oo.append(85, 35);
        O00000oo.append(58, 4);
        O00000oo.append(57, 3);
        O00000oo.append(55, 1);
        O00000oo.append(94, 6);
        O00000oo.append(95, 7);
        O00000oo.append(65, 17);
        O00000oo.append(66, 18);
        O00000oo.append(67, 19);
        O00000oo.append(0, 27);
        O00000oo.append(81, 32);
        O00000oo.append(82, 33);
        O00000oo.append(64, 10);
        O00000oo.append(63, 9);
        O00000oo.append(98, 13);
        O00000oo.append(101, 16);
        O00000oo.append(99, 14);
        O00000oo.append(96, 11);
        O00000oo.append(100, 15);
        O00000oo.append(97, 12);
        O00000oo.append(89, 40);
        O00000oo.append(74, 39);
        O00000oo.append(73, 41);
        O00000oo.append(88, 42);
        O00000oo.append(72, 20);
        O00000oo.append(87, 37);
        O00000oo.append(62, 5);
        O00000oo.append(75, 82);
        O00000oo.append(84, 82);
        O00000oo.append(78, 82);
        O00000oo.append(56, 82);
        O00000oo.append(54, 82);
        O00000oo.append(5, 24);
        O00000oo.append(7, 28);
        O00000oo.append(23, 31);
        O00000oo.append(24, 8);
        O00000oo.append(6, 34);
        O00000oo.append(8, 2);
        O00000oo.append(3, 23);
        O00000oo.append(4, 21);
        O00000oo.append(2, 22);
        O00000oo.append(13, 43);
        O00000oo.append(26, 44);
        O00000oo.append(21, 45);
        O00000oo.append(22, 46);
        O00000oo.append(20, 60);
        O00000oo.append(18, 47);
        O00000oo.append(19, 48);
        O00000oo.append(14, 49);
        O00000oo.append(15, 50);
        O00000oo.append(16, 51);
        O00000oo.append(17, 52);
        O00000oo.append(25, 53);
        O00000oo.append(90, 54);
        O00000oo.append(68, 55);
        O00000oo.append(91, 56);
        O00000oo.append(69, 57);
        O00000oo.append(92, 58);
        O00000oo.append(70, 59);
        O00000oo.append(59, 61);
        O00000oo.append(61, 62);
        O00000oo.append(60, 63);
        O00000oo.append(27, 64);
        O00000oo.append(106, 65);
        O00000oo.append(33, 66);
        O00000oo.append(107, 67);
        O00000oo.append(103, 79);
        O00000oo.append(1, 38);
        O00000oo.append(102, 68);
        O00000oo.append(93, 69);
        O00000oo.append(71, 70);
        O00000oo.append(31, 71);
        O00000oo.append(29, 72);
        O00000oo.append(30, 73);
        O00000oo.append(32, 74);
        O00000oo.append(28, 75);
        O00000oo.append(104, 76);
        O00000oo.append(83, 77);
        O00000oo.append(108, 78);
        O00000oo.append(53, 80);
        O00000oo.append(52, 81);
    }

    public final void O000000o(oOO0OOo0 ooo0ooo0) {
        for (Integer next : ooo0ooo0.O00000o.keySet()) {
            int intValue = next.intValue();
            O000000o o000000o = ooo0ooo0.O00000o.get(next);
            if (!this.O00000o.containsKey(Integer.valueOf(intValue))) {
                this.O00000o.put(Integer.valueOf(intValue), new O000000o());
            }
            O000000o o000000o2 = this.O00000o.get(Integer.valueOf(intValue));
            if (!o000000o2.O00000o.O00000Oo) {
                o000000o2.O00000o.O000000o(o000000o.O00000o);
            }
            if (!o000000o2.O00000Oo.f2306O000000o) {
                o000000o2.O00000Oo.O000000o(o000000o.O00000Oo);
            }
            if (!o000000o2.O00000oO.f2308O000000o) {
                o000000o2.O00000oO.O000000o(o000000o.O00000oO);
            }
            if (!o000000o2.O00000o0.f2307O000000o) {
                o000000o2.O00000o0.O000000o(o000000o.O00000o0);
            }
            for (String next2 : o000000o.O00000oo.keySet()) {
                if (!o000000o2.O00000oo.containsKey(next2)) {
                    o000000o2.O00000oo.put(next2, o000000o.O00000oo.get(next2));
                }
            }
        }
    }

    public final void O000000o(ConstraintLayout constraintLayout) {
        int childCount = constraintLayout.getChildCount();
        int i = 0;
        while (i < childCount) {
            View childAt = constraintLayout.getChildAt(i);
            ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) childAt.getLayoutParams();
            int id = childAt.getId();
            if (!this.O00000Oo || id != -1) {
                if (!this.O00000o.containsKey(Integer.valueOf(id))) {
                    this.O00000o.put(Integer.valueOf(id), new O000000o());
                }
                O000000o o000000o = this.O00000o.get(Integer.valueOf(id));
                if (!o000000o.O00000o.O00000Oo) {
                    o000000o.O000000o(id, layoutParams);
                    if (childAt instanceof ConstraintHelper) {
                        o000000o.O00000o.O000o000 = ((ConstraintHelper) childAt).getReferencedIds();
                        if (childAt instanceof Barrier) {
                            Barrier barrier = (Barrier) childAt;
                            o000000o.O00000o.O000o0O0 = barrier.f2799O000000o.O00000Oo;
                            o000000o.O00000o.O000Ooo = barrier.getType();
                            o000000o.O00000o.O000OooO = barrier.getMargin();
                        }
                    }
                    o000000o.O00000o.O00000Oo = true;
                }
                if (!o000000o.O00000Oo.f2306O000000o) {
                    o000000o.O00000Oo.O00000Oo = childAt.getVisibility();
                    o000000o.O00000Oo.O00000o = childAt.getAlpha();
                    o000000o.O00000Oo.f2306O000000o = true;
                }
                if (Build.VERSION.SDK_INT >= 17 && !o000000o.O00000oO.f2308O000000o) {
                    o000000o.O00000oO.f2308O000000o = true;
                    o000000o.O00000oO.O00000Oo = childAt.getRotation();
                    o000000o.O00000oO.O00000o0 = childAt.getRotationX();
                    o000000o.O00000oO.O00000o = childAt.getRotationY();
                    o000000o.O00000oO.O00000oO = childAt.getScaleX();
                    o000000o.O00000oO.O00000oo = childAt.getScaleY();
                    float pivotX = childAt.getPivotX();
                    float pivotY = childAt.getPivotY();
                    if (!(((double) pivotX) == 0.0d && ((double) pivotY) == 0.0d)) {
                        o000000o.O00000oO.O0000O0o = pivotX;
                        o000000o.O00000oO.O0000OOo = pivotY;
                    }
                    o000000o.O00000oO.O0000Oo0 = childAt.getTranslationX();
                    o000000o.O00000oO.O0000Oo = childAt.getTranslationY();
                    if (Build.VERSION.SDK_INT >= 21) {
                        o000000o.O00000oO.O0000OoO = childAt.getTranslationZ();
                        if (o000000o.O00000oO.O0000Ooo) {
                            o000000o.O00000oO.O0000o00 = childAt.getElevation();
                        }
                    }
                }
                i++;
            } else {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            }
        }
    }

    public static class O00000Oo {
        private static SparseIntArray O000o0O;

        /* renamed from: O000000o  reason: collision with root package name */
        public boolean f2305O000000o = false;
        public boolean O00000Oo = false;
        public int O00000o;
        public int O00000o0;
        public int O00000oO = -1;
        public int O00000oo = -1;
        public float O0000O0o = -1.0f;
        public int O0000OOo = -1;
        public int O0000Oo = -1;
        public int O0000Oo0 = -1;
        public int O0000OoO = -1;
        public int O0000Ooo = -1;
        public int O0000o = -1;
        public int O0000o0 = -1;
        public int O0000o00 = -1;
        public int O0000o0O = -1;
        public int O0000o0o = -1;
        public int O0000oO = -1;
        public int O0000oO0 = -1;
        public int O0000oOO = -1;
        public float O0000oOo = 0.5f;
        public String O0000oo = null;
        public float O0000oo0 = 0.5f;
        public int O0000ooO = -1;
        public int O0000ooo = 0;
        public int O000O00o = -1;
        public int O000O0OO = -1;
        public int O000O0Oo = -1;
        public int O000O0o = -1;
        public int O000O0o0 = -1;
        public int O000O0oO = -1;
        public int O000O0oo = -1;
        public int O000OO = -1;
        public int O000OO00 = -1;
        public int O000OO0o = -1;
        public int O000OOOo = -1;
        public int O000OOo = -1;
        public int O000OOo0 = -1;
        public float O000OOoO = -1.0f;
        public float O000OOoo = -1.0f;
        public int O000Oo0 = 0;
        public int O000Oo00 = 0;
        public int O000Oo0O = 0;
        public int O000Oo0o = 0;
        public int O000OoO = -1;
        public int O000OoO0 = -1;
        public int O000OoOO = -1;
        public float O000OoOo = 1.0f;
        public int O000Ooo = -1;
        public float O000Ooo0 = 1.0f;
        public int O000OooO = 0;
        public int O000Oooo = -1;
        public boolean O000o0 = false;
        public String O000o00;
        public int[] O000o000;
        public String O000o00O;
        public boolean O000o00o = false;
        public boolean O000o0O0 = true;
        public int O00O0Oo = -1;
        public int O00oOoOo = -1;
        public float O00oOooO = 0.0f;
        public int O00oOooo = -1;

        public final void O000000o(O00000Oo o00000Oo) {
            this.f2305O000000o = o00000Oo.f2305O000000o;
            this.O00000o0 = o00000Oo.O00000o0;
            this.O00000Oo = o00000Oo.O00000Oo;
            this.O00000o = o00000Oo.O00000o;
            this.O00000oO = o00000Oo.O00000oO;
            this.O00000oo = o00000Oo.O00000oo;
            this.O0000O0o = o00000Oo.O0000O0o;
            this.O0000OOo = o00000Oo.O0000OOo;
            this.O0000Oo0 = o00000Oo.O0000Oo0;
            this.O0000Oo = o00000Oo.O0000Oo;
            this.O0000OoO = o00000Oo.O0000OoO;
            this.O0000Ooo = o00000Oo.O0000Ooo;
            this.O0000o00 = o00000Oo.O0000o00;
            this.O0000o0 = o00000Oo.O0000o0;
            this.O0000o0O = o00000Oo.O0000o0O;
            this.O0000o0o = o00000Oo.O0000o0o;
            this.O0000o = o00000Oo.O0000o;
            this.O0000oO0 = o00000Oo.O0000oO0;
            this.O0000oO = o00000Oo.O0000oO;
            this.O0000oOO = o00000Oo.O0000oOO;
            this.O0000oOo = o00000Oo.O0000oOo;
            this.O0000oo0 = o00000Oo.O0000oo0;
            this.O0000oo = o00000Oo.O0000oo;
            this.O0000ooO = o00000Oo.O0000ooO;
            this.O0000ooo = o00000Oo.O0000ooo;
            this.O00oOooO = o00000Oo.O00oOooO;
            this.O00oOooo = o00000Oo.O00oOooo;
            this.O000O00o = o00000Oo.O000O00o;
            this.O000O0OO = o00000Oo.O000O0OO;
            this.O000O0Oo = o00000Oo.O000O0Oo;
            this.O00oOoOo = o00000Oo.O00oOoOo;
            this.O000O0o0 = o00000Oo.O000O0o0;
            this.O000O0o = o00000Oo.O000O0o;
            this.O000O0oO = o00000Oo.O000O0oO;
            this.O000O0oo = o00000Oo.O000O0oo;
            this.O000OO00 = o00000Oo.O000OO00;
            this.O000OO0o = o00000Oo.O000OO0o;
            this.O000OO = o00000Oo.O000OO;
            this.O000OOOo = o00000Oo.O000OOOo;
            this.O000OOo0 = o00000Oo.O000OOo0;
            this.O000OOo = o00000Oo.O000OOo;
            this.O000OOoO = o00000Oo.O000OOoO;
            this.O000OOoo = o00000Oo.O000OOoo;
            this.O000Oo00 = o00000Oo.O000Oo00;
            this.O000Oo0 = o00000Oo.O000Oo0;
            this.O000Oo0O = o00000Oo.O000Oo0O;
            this.O000Oo0o = o00000Oo.O000Oo0o;
            this.O000OoO0 = o00000Oo.O000OoO0;
            this.O00O0Oo = o00000Oo.O00O0Oo;
            this.O000OoO = o00000Oo.O000OoO;
            this.O000OoOO = o00000Oo.O000OoOO;
            this.O000OoOo = o00000Oo.O000OoOo;
            this.O000Ooo0 = o00000Oo.O000Ooo0;
            this.O000Ooo = o00000Oo.O000Ooo;
            this.O000OooO = o00000Oo.O000OooO;
            this.O000Oooo = o00000Oo.O000Oooo;
            this.O000o00O = o00000Oo.O000o00O;
            int[] iArr = o00000Oo.O000o000;
            if (iArr != null) {
                this.O000o000 = Arrays.copyOf(iArr, iArr.length);
            } else {
                this.O000o000 = null;
            }
            this.O000o00 = o00000Oo.O000o00;
            this.O000o00o = o00000Oo.O000o00o;
            this.O000o0 = o00000Oo.O000o0;
            this.O000o0O0 = o00000Oo.O000o0O0;
        }

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            O000o0O = sparseIntArray;
            sparseIntArray.append(38, 24);
            O000o0O.append(39, 25);
            O000o0O.append(41, 28);
            O000o0O.append(42, 29);
            O000o0O.append(47, 35);
            O000o0O.append(46, 34);
            O000o0O.append(20, 4);
            O000o0O.append(19, 3);
            O000o0O.append(17, 1);
            O000o0O.append(55, 6);
            O000o0O.append(56, 7);
            O000o0O.append(27, 17);
            O000o0O.append(28, 18);
            O000o0O.append(29, 19);
            O000o0O.append(0, 26);
            O000o0O.append(43, 31);
            O000o0O.append(44, 32);
            O000o0O.append(26, 10);
            O000o0O.append(25, 9);
            O000o0O.append(59, 13);
            O000o0O.append(62, 16);
            O000o0O.append(60, 14);
            O000o0O.append(57, 11);
            O000o0O.append(61, 15);
            O000o0O.append(58, 12);
            O000o0O.append(50, 38);
            O000o0O.append(36, 37);
            O000o0O.append(35, 39);
            O000o0O.append(49, 40);
            O000o0O.append(34, 20);
            O000o0O.append(48, 36);
            O000o0O.append(24, 5);
            O000o0O.append(37, 76);
            O000o0O.append(45, 76);
            O000o0O.append(40, 76);
            O000o0O.append(18, 76);
            O000o0O.append(16, 76);
            O000o0O.append(3, 23);
            O000o0O.append(5, 27);
            O000o0O.append(7, 30);
            O000o0O.append(8, 8);
            O000o0O.append(4, 33);
            O000o0O.append(6, 2);
            O000o0O.append(1, 22);
            O000o0O.append(2, 21);
            O000o0O.append(21, 61);
            O000o0O.append(23, 62);
            O000o0O.append(22, 63);
            O000o0O.append(54, 69);
            O000o0O.append(33, 70);
            O000o0O.append(12, 71);
            O000o0O.append(10, 72);
            O000o0O.append(11, 73);
            O000o0O.append(13, 74);
            O000o0O.append(9, 75);
        }

        /* access modifiers changed from: package-private */
        public final void O000000o(Context context, AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{16842948, 16842996, 16842997, 16842999, 16843000, 16843001, 16843002, 16843701, 16843702, R.attr.barrierAllowsGoneWidgets, R.attr.barrierDirection, R.attr.barrierMargin, R.attr.chainUseRtl, R.attr.constraint_referenced_ids, R.attr.layout_constrainedHeight, R.attr.layout_constrainedWidth, R.attr.layout_constraintBaseline_creator, R.attr.layout_constraintBaseline_toBaselineOf, R.attr.layout_constraintBottom_creator, R.attr.layout_constraintBottom_toBottomOf, R.attr.layout_constraintBottom_toTopOf, R.attr.layout_constraintCircle, R.attr.layout_constraintCircleAngle, R.attr.layout_constraintCircleRadius, R.attr.layout_constraintDimensionRatio, R.attr.layout_constraintEnd_toEndOf, R.attr.layout_constraintEnd_toStartOf, R.attr.layout_constraintGuide_begin, R.attr.layout_constraintGuide_end, R.attr.layout_constraintGuide_percent, R.attr.layout_constraintHeight_default, R.attr.layout_constraintHeight_max, R.attr.layout_constraintHeight_min, R.attr.layout_constraintHeight_percent, R.attr.layout_constraintHorizontal_bias, R.attr.layout_constraintHorizontal_chainStyle, R.attr.layout_constraintHorizontal_weight, R.attr.layout_constraintLeft_creator, R.attr.layout_constraintLeft_toLeftOf, R.attr.layout_constraintLeft_toRightOf, R.attr.layout_constraintRight_creator, R.attr.layout_constraintRight_toLeftOf, R.attr.layout_constraintRight_toRightOf, R.attr.layout_constraintStart_toEndOf, R.attr.layout_constraintStart_toStartOf, R.attr.layout_constraintTop_creator, R.attr.layout_constraintTop_toBottomOf, R.attr.layout_constraintTop_toTopOf, R.attr.layout_constraintVertical_bias, R.attr.layout_constraintVertical_chainStyle, R.attr.layout_constraintVertical_weight, R.attr.layout_constraintWidth_default, R.attr.layout_constraintWidth_max, R.attr.layout_constraintWidth_min, R.attr.layout_constraintWidth_percent, R.attr.layout_editor_absoluteX, R.attr.layout_editor_absoluteY, R.attr.layout_goneMarginBottom, R.attr.layout_goneMarginEnd, R.attr.layout_goneMarginLeft, R.attr.layout_goneMarginRight, R.attr.layout_goneMarginStart, R.attr.layout_goneMarginTop, R.attr.maxHeight, R.attr.maxWidth, R.attr.minHeight, R.attr.minWidth});
            this.O00000Oo = true;
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                int i2 = O000o0O.get(index);
                if (i2 == 80) {
                    this.O000o00o = obtainStyledAttributes.getBoolean(index, this.O000o00o);
                } else if (i2 != 81) {
                    switch (i2) {
                        case 1:
                            this.O0000o0o = oOO0OOo0.O000000o(obtainStyledAttributes, index, this.O0000o0o);
                            continue;
                        case 2:
                            this.O000O0o = obtainStyledAttributes.getDimensionPixelSize(index, this.O000O0o);
                            continue;
                        case 3:
                            this.O0000o0O = oOO0OOo0.O000000o(obtainStyledAttributes, index, this.O0000o0O);
                            continue;
                        case 4:
                            this.O0000o0 = oOO0OOo0.O000000o(obtainStyledAttributes, index, this.O0000o0);
                            continue;
                        case 5:
                            this.O0000oo = obtainStyledAttributes.getString(index);
                            continue;
                        case 6:
                            this.O00oOooo = obtainStyledAttributes.getDimensionPixelOffset(index, this.O00oOooo);
                            continue;
                        case 7:
                            this.O000O00o = obtainStyledAttributes.getDimensionPixelOffset(index, this.O000O00o);
                            continue;
                        case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER /*8*/:
                            if (Build.VERSION.SDK_INT >= 17) {
                                this.O000O0oO = obtainStyledAttributes.getDimensionPixelSize(index, this.O000O0oO);
                                break;
                            } else {
                                continue;
                            }
                        case 9:
                            this.O0000oOO = oOO0OOo0.O000000o(obtainStyledAttributes, index, this.O0000oOO);
                            continue;
                        case 10:
                            this.O0000oO = oOO0OOo0.O000000o(obtainStyledAttributes, index, this.O0000oO);
                            continue;
                        case 11:
                            this.O000OOOo = obtainStyledAttributes.getDimensionPixelSize(index, this.O000OOOo);
                            continue;
                        case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT /*12*/:
                            this.O000OOo0 = obtainStyledAttributes.getDimensionPixelSize(index, this.O000OOo0);
                            continue;
                        case 13:
                            this.O000OO00 = obtainStyledAttributes.getDimensionPixelSize(index, this.O000OO00);
                            continue;
                        case 14:
                            this.O000OO = obtainStyledAttributes.getDimensionPixelSize(index, this.O000OO);
                            continue;
                        case GmsLogger.MAX_PII_TAG_LENGTH /*15*/:
                            this.O000OOo = obtainStyledAttributes.getDimensionPixelSize(index, this.O000OOo);
                            continue;
                        case 16:
                            this.O000OO0o = obtainStyledAttributes.getDimensionPixelSize(index, this.O000OO0o);
                            continue;
                        case 17:
                            this.O00000oO = obtainStyledAttributes.getDimensionPixelOffset(index, this.O00000oO);
                            continue;
                        case 18:
                            this.O00000oo = obtainStyledAttributes.getDimensionPixelOffset(index, this.O00000oo);
                            continue;
                        case 19:
                            this.O0000O0o = obtainStyledAttributes.getFloat(index, this.O0000O0o);
                            continue;
                        case 20:
                            this.O0000oOo = obtainStyledAttributes.getFloat(index, this.O0000oOo);
                            continue;
                        case 21:
                            this.O00000o = obtainStyledAttributes.getLayoutDimension(index, this.O00000o);
                            continue;
                        case 22:
                            this.O00000o0 = obtainStyledAttributes.getLayoutDimension(index, this.O00000o0);
                            continue;
                        case 23:
                            this.O000O0Oo = obtainStyledAttributes.getDimensionPixelSize(index, this.O000O0Oo);
                            continue;
                        case 24:
                            this.O0000OOo = oOO0OOo0.O000000o(obtainStyledAttributes, index, this.O0000OOo);
                            continue;
                        case 25:
                            this.O0000Oo0 = oOO0OOo0.O000000o(obtainStyledAttributes, index, this.O0000Oo0);
                            continue;
                        case 26:
                            this.O000O0OO = obtainStyledAttributes.getInt(index, this.O000O0OO);
                            continue;
                        case 27:
                            this.O00oOoOo = obtainStyledAttributes.getDimensionPixelSize(index, this.O00oOoOo);
                            continue;
                        case 28:
                            this.O0000Oo = oOO0OOo0.O000000o(obtainStyledAttributes, index, this.O0000Oo);
                            continue;
                        case 29:
                            this.O0000OoO = oOO0OOo0.O000000o(obtainStyledAttributes, index, this.O0000OoO);
                            continue;
                        case 30:
                            if (Build.VERSION.SDK_INT >= 17) {
                                this.O000O0oo = obtainStyledAttributes.getDimensionPixelSize(index, this.O000O0oo);
                                break;
                            } else {
                                continue;
                            }
                        case 31:
                            this.O0000o = oOO0OOo0.O000000o(obtainStyledAttributes, index, this.O0000o);
                            continue;
                        case 32:
                            this.O0000oO0 = oOO0OOo0.O000000o(obtainStyledAttributes, index, this.O0000oO0);
                            continue;
                        case 33:
                            this.O000O0o0 = obtainStyledAttributes.getDimensionPixelSize(index, this.O000O0o0);
                            continue;
                        case 34:
                            this.O0000o00 = oOO0OOo0.O000000o(obtainStyledAttributes, index, this.O0000o00);
                            continue;
                        case 35:
                            this.O0000Ooo = oOO0OOo0.O000000o(obtainStyledAttributes, index, this.O0000Ooo);
                            continue;
                        case 36:
                            this.O0000oo0 = obtainStyledAttributes.getFloat(index, this.O0000oo0);
                            continue;
                        case 37:
                            this.O000OOoo = obtainStyledAttributes.getFloat(index, this.O000OOoo);
                            continue;
                        case 38:
                            this.O000OOoO = obtainStyledAttributes.getFloat(index, this.O000OOoO);
                            continue;
                        case 39:
                            this.O000Oo00 = obtainStyledAttributes.getInt(index, this.O000Oo00);
                            continue;
                        case 40:
                            this.O000Oo0 = obtainStyledAttributes.getInt(index, this.O000Oo0);
                            continue;
                        default:
                            switch (i2) {
                                case 54:
                                    this.O000Oo0O = obtainStyledAttributes.getInt(index, this.O000Oo0O);
                                    continue;
                                case 55:
                                    this.O000Oo0o = obtainStyledAttributes.getInt(index, this.O000Oo0o);
                                    continue;
                                case 56:
                                    this.O000OoO0 = obtainStyledAttributes.getDimensionPixelSize(index, this.O000OoO0);
                                    continue;
                                case 57:
                                    this.O00O0Oo = obtainStyledAttributes.getDimensionPixelSize(index, this.O00O0Oo);
                                    continue;
                                case 58:
                                    this.O000OoO = obtainStyledAttributes.getDimensionPixelSize(index, this.O000OoO);
                                    continue;
                                case 59:
                                    this.O000OoOO = obtainStyledAttributes.getDimensionPixelSize(index, this.O000OoOO);
                                    continue;
                                default:
                                    switch (i2) {
                                        case 61:
                                            this.O0000ooO = oOO0OOo0.O000000o(obtainStyledAttributes, index, this.O0000ooO);
                                            continue;
                                        case 62:
                                            this.O0000ooo = obtainStyledAttributes.getDimensionPixelSize(index, this.O0000ooo);
                                            continue;
                                        case 63:
                                            this.O00oOooO = obtainStyledAttributes.getFloat(index, this.O00oOooO);
                                            continue;
                                        default:
                                            switch (i2) {
                                                case 69:
                                                    this.O000OoOo = obtainStyledAttributes.getFloat(index, 1.0f);
                                                    continue;
                                                case 70:
                                                    this.O000Ooo0 = obtainStyledAttributes.getFloat(index, 1.0f);
                                                    continue;
                                                case 71:
                                                    Log.e("ConstraintSet", "CURRENTLY UNSUPPORTED");
                                                    continue;
                                                case 72:
                                                    this.O000Ooo = obtainStyledAttributes.getInt(index, this.O000Ooo);
                                                    continue;
                                                case 73:
                                                    this.O000OooO = obtainStyledAttributes.getDimensionPixelSize(index, this.O000OooO);
                                                    continue;
                                                case 74:
                                                    this.O000o00 = obtainStyledAttributes.getString(index);
                                                    continue;
                                                case 75:
                                                    this.O000o0O0 = obtainStyledAttributes.getBoolean(index, this.O000o0O0);
                                                    continue;
                                                case 76:
                                                    Log.w("ConstraintSet", "unused attribute 0x" + Integer.toHexString(index) + "   " + O000o0O.get(index));
                                                    continue;
                                                case 77:
                                                    this.O000o00O = obtainStyledAttributes.getString(index);
                                                    continue;
                                                default:
                                                    Log.w("ConstraintSet", "Unknown attribute 0x" + Integer.toHexString(index) + "   " + O000o0O.get(index));
                                                    continue;
                                                    continue;
                                                    continue;
                                                    continue;
                                            }
                                    }
                            }
                    }
                } else {
                    this.O000o0 = obtainStyledAttributes.getBoolean(index, this.O000o0);
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    public static class O0000O0o {
        private static SparseIntArray O0000o0;

        /* renamed from: O000000o  reason: collision with root package name */
        public boolean f2308O000000o = false;
        public float O00000Oo = 0.0f;
        public float O00000o = 0.0f;
        public float O00000o0 = 0.0f;
        public float O00000oO = 1.0f;
        public float O00000oo = 1.0f;
        public float O0000O0o = Float.NaN;
        public float O0000OOo = Float.NaN;
        public float O0000Oo = 0.0f;
        public float O0000Oo0 = 0.0f;
        public float O0000OoO = 0.0f;
        public boolean O0000Ooo = false;
        public float O0000o00 = 0.0f;

        public final void O000000o(O0000O0o o0000O0o) {
            this.f2308O000000o = o0000O0o.f2308O000000o;
            this.O00000Oo = o0000O0o.O00000Oo;
            this.O00000o0 = o0000O0o.O00000o0;
            this.O00000o = o0000O0o.O00000o;
            this.O00000oO = o0000O0o.O00000oO;
            this.O00000oo = o0000O0o.O00000oo;
            this.O0000O0o = o0000O0o.O0000O0o;
            this.O0000OOo = o0000O0o.O0000OOo;
            this.O0000Oo0 = o0000O0o.O0000Oo0;
            this.O0000Oo = o0000O0o.O0000Oo;
            this.O0000OoO = o0000O0o.O0000OoO;
            this.O0000Ooo = o0000O0o.O0000Ooo;
            this.O0000o00 = o0000O0o.O0000o00;
        }

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            O0000o0 = sparseIntArray;
            sparseIntArray.append(6, 1);
            O0000o0.append(7, 2);
            O0000o0.append(8, 3);
            O0000o0.append(4, 4);
            O0000o0.append(5, 5);
            O0000o0.append(0, 6);
            O0000o0.append(1, 7);
            O0000o0.append(2, 8);
            O0000o0.append(3, 9);
            O0000o0.append(9, 10);
            O0000o0.append(10, 11);
        }

        /* access modifiers changed from: package-private */
        public final void O000000o(Context context, AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{16843552, 16843553, 16843554, 16843555, 16843556, 16843557, 16843558, 16843559, 16843560, 16843770, 16843840});
            this.f2308O000000o = true;
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                switch (O0000o0.get(index)) {
                    case 1:
                        this.O00000Oo = obtainStyledAttributes.getFloat(index, this.O00000Oo);
                        break;
                    case 2:
                        this.O00000o0 = obtainStyledAttributes.getFloat(index, this.O00000o0);
                        break;
                    case 3:
                        this.O00000o = obtainStyledAttributes.getFloat(index, this.O00000o);
                        break;
                    case 4:
                        this.O00000oO = obtainStyledAttributes.getFloat(index, this.O00000oO);
                        break;
                    case 5:
                        this.O00000oo = obtainStyledAttributes.getFloat(index, this.O00000oo);
                        break;
                    case 6:
                        this.O0000O0o = obtainStyledAttributes.getDimension(index, this.O0000O0o);
                        break;
                    case 7:
                        this.O0000OOo = obtainStyledAttributes.getDimension(index, this.O0000OOo);
                        break;
                    case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER /*8*/:
                        this.O0000Oo0 = obtainStyledAttributes.getDimension(index, this.O0000Oo0);
                        break;
                    case 9:
                        this.O0000Oo = obtainStyledAttributes.getDimension(index, this.O0000Oo);
                        break;
                    case 10:
                        if (Build.VERSION.SDK_INT < 21) {
                            break;
                        } else {
                            this.O0000OoO = obtainStyledAttributes.getDimension(index, this.O0000OoO);
                            break;
                        }
                    case 11:
                        if (Build.VERSION.SDK_INT < 21) {
                            break;
                        } else {
                            this.O0000Ooo = true;
                            this.O0000o00 = obtainStyledAttributes.getDimension(index, this.O0000o00);
                            break;
                        }
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    public static class O00000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public boolean f2306O000000o = false;
        public int O00000Oo = 0;
        public float O00000o = 1.0f;
        public int O00000o0 = 0;
        public float O00000oO = Float.NaN;

        public final void O000000o(O00000o o00000o) {
            this.f2306O000000o = o00000o.f2306O000000o;
            this.O00000Oo = o00000o.O00000Oo;
            this.O00000o = o00000o.O00000o;
            this.O00000oO = o00000o.O00000oO;
            this.O00000o0 = o00000o.O00000o0;
        }

        /* access modifiers changed from: package-private */
        public final void O000000o(Context context, AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{16842972, 16843551, R.attr.layout_constraintTag, R.attr.motionProgress, R.attr.visibilityMode});
            this.f2306O000000o = true;
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == 1) {
                    this.O00000o = obtainStyledAttributes.getFloat(index, this.O00000o);
                } else if (index == 0) {
                    this.O00000Oo = obtainStyledAttributes.getInt(index, this.O00000Oo);
                    this.O00000Oo = oOO0OOo0.O00000o0[this.O00000Oo];
                } else if (index == 4) {
                    this.O00000o0 = obtainStyledAttributes.getInt(index, this.O00000o0);
                } else if (index == 3) {
                    this.O00000oO = obtainStyledAttributes.getFloat(index, this.O00000oO);
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    public static class O00000o0 {
        private static SparseIntArray O0000OOo;

        /* renamed from: O000000o  reason: collision with root package name */
        public boolean f2307O000000o = false;
        public int O00000Oo = -1;
        public int O00000o = -1;
        public String O00000o0 = null;
        public int O00000oO = 0;
        public float O00000oo = Float.NaN;
        public float O0000O0o = Float.NaN;

        public final void O000000o(O00000o0 o00000o0) {
            this.f2307O000000o = o00000o0.f2307O000000o;
            this.O00000Oo = o00000o0.O00000Oo;
            this.O00000o0 = o00000o0.O00000o0;
            this.O00000o = o00000o0.O00000o;
            this.O00000oO = o00000o0.O00000oO;
            this.O0000O0o = o00000o0.O0000O0o;
            this.O00000oo = o00000o0.O00000oo;
        }

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            O0000OOo = sparseIntArray;
            sparseIntArray.append(2, 1);
            O0000OOo.append(4, 2);
            O0000OOo.append(5, 3);
            O0000OOo.append(1, 4);
            O0000OOo.append(0, 5);
            O0000OOo.append(3, 6);
        }

        /* access modifiers changed from: package-private */
        public final void O000000o(Context context, AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.animate_relativeTo, R.attr.drawPath, R.attr.motionPathRotate, R.attr.motionStagger, R.attr.pathMotionArc, R.attr.transitionEasing});
            this.f2307O000000o = true;
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                switch (O0000OOo.get(index)) {
                    case 1:
                        this.O0000O0o = obtainStyledAttributes.getFloat(index, this.O0000O0o);
                        break;
                    case 2:
                        this.O00000o = obtainStyledAttributes.getInt(index, this.O00000o);
                        break;
                    case 3:
                        if (obtainStyledAttributes.peekValue(index).type != 3) {
                            this.O00000o0 = o0OO0o00.O00000o0[obtainStyledAttributes.getInteger(index, 0)];
                            break;
                        } else {
                            this.O00000o0 = obtainStyledAttributes.getString(index);
                            break;
                        }
                    case 4:
                        this.O00000oO = obtainStyledAttributes.getInt(index, 0);
                        break;
                    case 5:
                        this.O00000Oo = oOO0OOo0.O000000o(obtainStyledAttributes, index, this.O00000Oo);
                        break;
                    case 6:
                        this.O00000oo = obtainStyledAttributes.getFloat(index, this.O00000oo);
                        break;
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    public static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        int f2304O000000o;
        public final O00000o O00000Oo = new O00000o();
        public final O00000Oo O00000o = new O00000Oo();
        public final O00000o0 O00000o0 = new O00000o0();
        public final O0000O0o O00000oO = new O0000O0o();
        public HashMap<String, ConstraintAttribute> O00000oo = new HashMap<>();

        /* renamed from: O000000o */
        public final O000000o clone() {
            O000000o o000000o = new O000000o();
            o000000o.O00000o.O000000o(this.O00000o);
            o000000o.O00000o0.O000000o(this.O00000o0);
            o000000o.O00000Oo.O000000o(this.O00000Oo);
            o000000o.O00000oO.O000000o(this.O00000oO);
            o000000o.f2304O000000o = this.f2304O000000o;
            return o000000o;
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: _m_j.oOO0OOo0.O000000o.O000000o(int, androidx.constraintlayout.widget.ConstraintLayout$LayoutParams):void
         arg types: [int, androidx.constraintlayout.widget.Constraints$LayoutParams]
         candidates:
          _m_j.oOO0OOo0.O000000o.O000000o(int, androidx.constraintlayout.widget.Constraints$LayoutParams):void
          _m_j.oOO0OOo0.O000000o.O000000o(int, androidx.constraintlayout.widget.ConstraintLayout$LayoutParams):void */
        public final void O000000o(int i, Constraints.LayoutParams layoutParams) {
            O000000o(i, (ConstraintLayout.LayoutParams) layoutParams);
            this.O00000Oo.O00000o = layoutParams.O000o0oo;
            this.O00000oO.O00000Oo = layoutParams.O000oO0;
            this.O00000oO.O00000o0 = layoutParams.O000oO0O;
            this.O00000oO.O00000o = layoutParams.O000oO0o;
            this.O00000oO.O00000oO = layoutParams.O000oO;
            this.O00000oO.O00000oo = layoutParams.O000oOO0;
            this.O00000oO.O0000O0o = layoutParams.O000oOO;
            this.O00000oO.O0000OOo = layoutParams.O000oOOO;
            this.O00000oO.O0000Oo0 = layoutParams.O000oOOo;
            this.O00000oO.O0000Oo = layoutParams.O000oOo0;
            this.O00000oO.O0000OoO = layoutParams.O000oOo;
            this.O00000oO.O0000o00 = layoutParams.O000oO00;
            this.O00000oO.O0000Ooo = layoutParams.O000o;
        }

        public final void O000000o(int i, ConstraintLayout.LayoutParams layoutParams) {
            this.f2304O000000o = i;
            this.O00000o.O0000OOo = layoutParams.O00000o;
            this.O00000o.O0000Oo0 = layoutParams.O00000oO;
            this.O00000o.O0000Oo = layoutParams.O00000oo;
            this.O00000o.O0000OoO = layoutParams.O0000O0o;
            this.O00000o.O0000Ooo = layoutParams.O0000OOo;
            this.O00000o.O0000o00 = layoutParams.O0000Oo0;
            this.O00000o.O0000o0 = layoutParams.O0000Oo;
            this.O00000o.O0000o0O = layoutParams.O0000OoO;
            this.O00000o.O0000o0o = layoutParams.O0000Ooo;
            this.O00000o.O0000o = layoutParams.O0000o0o;
            this.O00000o.O0000oO0 = layoutParams.O0000o;
            this.O00000o.O0000oO = layoutParams.O0000oO0;
            this.O00000o.O0000oOO = layoutParams.O0000oO;
            this.O00000o.O0000oOo = layoutParams.O00oOooO;
            this.O00000o.O0000oo0 = layoutParams.O00oOooo;
            this.O00000o.O0000oo = layoutParams.O000O00o;
            this.O00000o.O0000ooO = layoutParams.O0000o00;
            this.O00000o.O0000ooo = layoutParams.O0000o0;
            this.O00000o.O00oOooO = layoutParams.O0000o0O;
            this.O00000o.O00oOooo = layoutParams.O000OOoo;
            this.O00000o.O000O00o = layoutParams.O000Oo00;
            this.O00000o.O000O0OO = layoutParams.O000Oo0;
            this.O00000o.O0000O0o = layoutParams.O00000o0;
            this.O00000o.O00000oO = layoutParams.f2804O000000o;
            this.O00000o.O00000oo = layoutParams.O00000Oo;
            this.O00000o.O00000o0 = layoutParams.width;
            this.O00000o.O00000o = layoutParams.height;
            this.O00000o.O000O0Oo = layoutParams.leftMargin;
            this.O00000o.O00oOoOo = layoutParams.rightMargin;
            this.O00000o.O000O0o0 = layoutParams.topMargin;
            this.O00000o.O000O0o = layoutParams.bottomMargin;
            this.O00000o.O000OOoO = layoutParams.O000O0o0;
            this.O00000o.O000OOoo = layoutParams.O00oOoOo;
            this.O00000o.O000Oo0 = layoutParams.O000O0oO;
            this.O00000o.O000Oo00 = layoutParams.O000O0o;
            this.O00000o.O000o00o = layoutParams.O000Oo0O;
            this.O00000o.O000o0 = layoutParams.O000Oo0o;
            this.O00000o.O000Oo0O = layoutParams.O000O0oo;
            this.O00000o.O000Oo0o = layoutParams.O000OO00;
            this.O00000o.O000OoO0 = layoutParams.O000OOOo;
            this.O00000o.O00O0Oo = layoutParams.O000OOo0;
            this.O00000o.O000OoO = layoutParams.O000OO0o;
            this.O00000o.O000OoOO = layoutParams.O000OO;
            this.O00000o.O000OoOo = layoutParams.O000OOo;
            this.O00000o.O000Ooo0 = layoutParams.O000OOoO;
            this.O00000o.O000o00O = layoutParams.O000OoO0;
            this.O00000o.O000OO0o = layoutParams.O0000oOo;
            this.O00000o.O000OOOo = layoutParams.O0000oo;
            this.O00000o.O000OO00 = layoutParams.O0000oOO;
            this.O00000o.O000OO = layoutParams.O0000oo0;
            this.O00000o.O000OOo = layoutParams.O0000ooO;
            this.O00000o.O000OOo0 = layoutParams.O0000ooo;
            if (Build.VERSION.SDK_INT >= 17) {
                this.O00000o.O000O0oO = layoutParams.getMarginEnd();
                this.O00000o.O000O0oo = layoutParams.getMarginStart();
            }
        }

        public final void O000000o(ConstraintLayout.LayoutParams layoutParams) {
            layoutParams.O00000o = this.O00000o.O0000OOo;
            layoutParams.O00000oO = this.O00000o.O0000Oo0;
            layoutParams.O00000oo = this.O00000o.O0000Oo;
            layoutParams.O0000O0o = this.O00000o.O0000OoO;
            layoutParams.O0000OOo = this.O00000o.O0000Ooo;
            layoutParams.O0000Oo0 = this.O00000o.O0000o00;
            layoutParams.O0000Oo = this.O00000o.O0000o0;
            layoutParams.O0000OoO = this.O00000o.O0000o0O;
            layoutParams.O0000Ooo = this.O00000o.O0000o0o;
            layoutParams.O0000o0o = this.O00000o.O0000o;
            layoutParams.O0000o = this.O00000o.O0000oO0;
            layoutParams.O0000oO0 = this.O00000o.O0000oO;
            layoutParams.O0000oO = this.O00000o.O0000oOO;
            layoutParams.leftMargin = this.O00000o.O000O0Oo;
            layoutParams.rightMargin = this.O00000o.O00oOoOo;
            layoutParams.topMargin = this.O00000o.O000O0o0;
            layoutParams.bottomMargin = this.O00000o.O000O0o;
            layoutParams.O0000ooO = this.O00000o.O000OOo;
            layoutParams.O0000ooo = this.O00000o.O000OOo0;
            layoutParams.O0000oOo = this.O00000o.O000OO0o;
            layoutParams.O0000oo = this.O00000o.O000OOOo;
            layoutParams.O00oOooO = this.O00000o.O0000oOo;
            layoutParams.O00oOooo = this.O00000o.O0000oo0;
            layoutParams.O0000o00 = this.O00000o.O0000ooO;
            layoutParams.O0000o0 = this.O00000o.O0000ooo;
            layoutParams.O0000o0O = this.O00000o.O00oOooO;
            layoutParams.O000O00o = this.O00000o.O0000oo;
            layoutParams.O000OOoo = this.O00000o.O00oOooo;
            layoutParams.O000Oo00 = this.O00000o.O000O00o;
            layoutParams.O000O0o0 = this.O00000o.O000OOoO;
            layoutParams.O00oOoOo = this.O00000o.O000OOoo;
            layoutParams.O000O0oO = this.O00000o.O000Oo0;
            layoutParams.O000O0o = this.O00000o.O000Oo00;
            layoutParams.O000Oo0O = this.O00000o.O000o00o;
            layoutParams.O000Oo0o = this.O00000o.O000o0;
            layoutParams.O000O0oo = this.O00000o.O000Oo0O;
            layoutParams.O000OO00 = this.O00000o.O000Oo0o;
            layoutParams.O000OOOo = this.O00000o.O000OoO0;
            layoutParams.O000OOo0 = this.O00000o.O00O0Oo;
            layoutParams.O000OO0o = this.O00000o.O000OoO;
            layoutParams.O000OO = this.O00000o.O000OoOO;
            layoutParams.O000OOo = this.O00000o.O000OoOo;
            layoutParams.O000OOoO = this.O00000o.O000Ooo0;
            layoutParams.O000Oo0 = this.O00000o.O000O0OO;
            layoutParams.O00000o0 = this.O00000o.O0000O0o;
            layoutParams.f2804O000000o = this.O00000o.O00000oO;
            layoutParams.O00000Oo = this.O00000o.O00000oo;
            layoutParams.width = this.O00000o.O00000o0;
            layoutParams.height = this.O00000o.O00000o;
            if (this.O00000o.O000o00O != null) {
                layoutParams.O000OoO0 = this.O00000o.O000o00O;
            }
            if (Build.VERSION.SDK_INT >= 17) {
                layoutParams.setMarginStart(this.O00000o.O000O0oo);
                layoutParams.setMarginEnd(this.O00000o.O000O0oO);
            }
            layoutParams.O000000o();
        }
    }

    public final void O000000o(Context context, int i) {
        O00000Oo((ConstraintLayout) LayoutInflater.from(context).inflate(i, (ViewGroup) null));
    }

    public final void O00000Oo(ConstraintLayout constraintLayout) {
        int childCount = constraintLayout.getChildCount();
        this.O00000o.clear();
        int i = 0;
        while (i < childCount) {
            View childAt = constraintLayout.getChildAt(i);
            ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) childAt.getLayoutParams();
            int id = childAt.getId();
            if (!this.O00000Oo || id != -1) {
                if (!this.O00000o.containsKey(Integer.valueOf(id))) {
                    this.O00000o.put(Integer.valueOf(id), new O000000o());
                }
                O000000o o000000o = this.O00000o.get(Integer.valueOf(id));
                o000000o.O00000oo = ConstraintAttribute.O000000o(this.O00000oO, childAt);
                o000000o.O000000o(id, layoutParams);
                o000000o.O00000Oo.O00000Oo = childAt.getVisibility();
                if (Build.VERSION.SDK_INT >= 17) {
                    o000000o.O00000Oo.O00000o = childAt.getAlpha();
                    o000000o.O00000oO.O00000Oo = childAt.getRotation();
                    o000000o.O00000oO.O00000o0 = childAt.getRotationX();
                    o000000o.O00000oO.O00000o = childAt.getRotationY();
                    o000000o.O00000oO.O00000oO = childAt.getScaleX();
                    o000000o.O00000oO.O00000oo = childAt.getScaleY();
                    float pivotX = childAt.getPivotX();
                    float pivotY = childAt.getPivotY();
                    if (!(((double) pivotX) == 0.0d && ((double) pivotY) == 0.0d)) {
                        o000000o.O00000oO.O0000O0o = pivotX;
                        o000000o.O00000oO.O0000OOo = pivotY;
                    }
                    o000000o.O00000oO.O0000Oo0 = childAt.getTranslationX();
                    o000000o.O00000oO.O0000Oo = childAt.getTranslationY();
                    if (Build.VERSION.SDK_INT >= 21) {
                        o000000o.O00000oO.O0000OoO = childAt.getTranslationZ();
                        if (o000000o.O00000oO.O0000Ooo) {
                            o000000o.O00000oO.O0000o00 = childAt.getElevation();
                        }
                    }
                }
                if (childAt instanceof Barrier) {
                    Barrier barrier = (Barrier) childAt;
                    o000000o.O00000o.O000o0O0 = barrier.f2799O000000o.O00000Oo;
                    o000000o.O00000o.O000o000 = barrier.getReferencedIds();
                    o000000o.O00000o.O000Ooo = barrier.getType();
                    o000000o.O00000o.O000OooO = barrier.getMargin();
                }
                i++;
            } else {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            }
        }
    }

    public final void O00000o0(ConstraintLayout constraintLayout) {
        O00000oO(constraintLayout);
        constraintLayout.setConstraintSet(null);
        constraintLayout.requestLayout();
    }

    public final void O00000o(ConstraintLayout constraintLayout) {
        int childCount = constraintLayout.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = constraintLayout.getChildAt(i);
            int id = childAt.getId();
            if (!this.O00000o.containsKey(Integer.valueOf(id))) {
                Log.v("ConstraintSet", "id unknown " + oO00000o.O000000o(childAt));
            } else if (this.O00000Oo && id == -1) {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            } else if (this.O00000o.containsKey(Integer.valueOf(id))) {
                ConstraintAttribute.O000000o(childAt, this.O00000o.get(Integer.valueOf(id)).O00000oo);
            }
        }
    }

    public final void O000000o(ConstraintHelper constraintHelper, ConstraintWidget constraintWidget, ConstraintLayout.LayoutParams layoutParams, SparseArray<ConstraintWidget> sparseArray) {
        int id = constraintHelper.getId();
        if (this.O00000o.containsKey(Integer.valueOf(id))) {
            O000000o o000000o = this.O00000o.get(Integer.valueOf(id));
            if (constraintWidget instanceof oO0O00o0) {
                constraintHelper.O000000o(o000000o, (oO0O00o0) constraintWidget, layoutParams, sparseArray);
            }
        }
    }

    public final void O000000o(int i, ConstraintLayout.LayoutParams layoutParams) {
        if (this.O00000o.containsKey(Integer.valueOf(i))) {
            this.O00000o.get(Integer.valueOf(i)).O000000o(layoutParams);
        }
    }

    public final void O00000oO(ConstraintLayout constraintLayout) {
        int childCount = constraintLayout.getChildCount();
        HashSet hashSet = new HashSet(this.O00000o.keySet());
        for (int i = 0; i < childCount; i++) {
            View childAt = constraintLayout.getChildAt(i);
            int id = childAt.getId();
            if (!this.O00000o.containsKey(Integer.valueOf(id))) {
                Log.w("ConstraintSet", "id unknown " + oO00000o.O000000o(childAt));
            } else if (this.O00000Oo && id == -1) {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            } else if (id != -1) {
                if (this.O00000o.containsKey(Integer.valueOf(id))) {
                    hashSet.remove(Integer.valueOf(id));
                    O000000o o000000o = this.O00000o.get(Integer.valueOf(id));
                    if (childAt instanceof Barrier) {
                        o000000o.O00000o.O000Oooo = 1;
                    }
                    if (o000000o.O00000o.O000Oooo != -1 && o000000o.O00000o.O000Oooo == 1) {
                        Barrier barrier = (Barrier) childAt;
                        barrier.setId(id);
                        barrier.setType(o000000o.O00000o.O000Ooo);
                        barrier.setMargin(o000000o.O00000o.O000OooO);
                        barrier.setAllowsGoneWidget(o000000o.O00000o.O000o0O0);
                        if (o000000o.O00000o.O000o000 != null) {
                            barrier.setReferencedIds(o000000o.O00000o.O000o000);
                        } else if (o000000o.O00000o.O000o00 != null) {
                            o000000o.O00000o.O000o000 = O000000o(barrier, o000000o.O00000o.O000o00);
                            barrier.setReferencedIds(o000000o.O00000o.O000o000);
                        }
                    }
                    ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) childAt.getLayoutParams();
                    layoutParams.O000000o();
                    o000000o.O000000o(layoutParams);
                    ConstraintAttribute.O000000o(childAt, o000000o.O00000oo);
                    childAt.setLayoutParams(layoutParams);
                    if (o000000o.O00000Oo.O00000o0 == 0) {
                        childAt.setVisibility(o000000o.O00000Oo.O00000Oo);
                    }
                    if (Build.VERSION.SDK_INT >= 17) {
                        childAt.setAlpha(o000000o.O00000Oo.O00000o);
                        childAt.setRotation(o000000o.O00000oO.O00000Oo);
                        childAt.setRotationX(o000000o.O00000oO.O00000o0);
                        childAt.setRotationY(o000000o.O00000oO.O00000o);
                        childAt.setScaleX(o000000o.O00000oO.O00000oO);
                        childAt.setScaleY(o000000o.O00000oO.O00000oo);
                        if (!Float.isNaN(o000000o.O00000oO.O0000O0o)) {
                            childAt.setPivotX(o000000o.O00000oO.O0000O0o);
                        }
                        if (!Float.isNaN(o000000o.O00000oO.O0000OOo)) {
                            childAt.setPivotY(o000000o.O00000oO.O0000OOo);
                        }
                        childAt.setTranslationX(o000000o.O00000oO.O0000Oo0);
                        childAt.setTranslationY(o000000o.O00000oO.O0000Oo);
                        if (Build.VERSION.SDK_INT >= 21) {
                            childAt.setTranslationZ(o000000o.O00000oO.O0000OoO);
                            if (o000000o.O00000oO.O0000Ooo) {
                                childAt.setElevation(o000000o.O00000oO.O0000o00);
                            }
                        }
                    }
                } else {
                    Log.v("ConstraintSet", "WARNING NO CONSTRAINTS for view ".concat(String.valueOf(id)));
                }
            }
        }
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            Integer num = (Integer) it.next();
            O000000o o000000o2 = this.O00000o.get(num);
            if (o000000o2.O00000o.O000Oooo != -1 && o000000o2.O00000o.O000Oooo == 1) {
                Barrier barrier2 = new Barrier(constraintLayout.getContext());
                barrier2.setId(num.intValue());
                if (o000000o2.O00000o.O000o000 != null) {
                    barrier2.setReferencedIds(o000000o2.O00000o.O000o000);
                } else if (o000000o2.O00000o.O000o00 != null) {
                    o000000o2.O00000o.O000o000 = O000000o(barrier2, o000000o2.O00000o.O000o00);
                    barrier2.setReferencedIds(o000000o2.O00000o.O000o000);
                }
                barrier2.setType(o000000o2.O00000o.O000Ooo);
                barrier2.setMargin(o000000o2.O00000o.O000OooO);
                ConstraintLayout.LayoutParams generateDefaultLayoutParams = constraintLayout.generateDefaultLayoutParams();
                barrier2.O00000Oo();
                o000000o2.O000000o(generateDefaultLayoutParams);
                constraintLayout.addView(barrier2, generateDefaultLayoutParams);
            }
            if (o000000o2.O00000o.f2305O000000o) {
                Guideline guideline = new Guideline(constraintLayout.getContext());
                guideline.setId(num.intValue());
                ConstraintLayout.LayoutParams generateDefaultLayoutParams2 = constraintLayout.generateDefaultLayoutParams();
                o000000o2.O000000o(generateDefaultLayoutParams2);
                constraintLayout.addView(guideline, generateDefaultLayoutParams2);
            }
        }
    }

    public final void O000000o(int i, int i2, int i3, int i4, int i5) {
        HashMap<Integer, O000000o> hashMap = this.O00000o;
        Integer valueOf = Integer.valueOf((int) R.id.float_main);
        if (!hashMap.containsKey(valueOf)) {
            this.O00000o.put(valueOf, new O000000o());
        }
        O000000o o000000o = this.O00000o.get(valueOf);
        switch (i2) {
            case 1:
                if (i4 == 1) {
                    o000000o.O00000o.O0000OOo = 0;
                    o000000o.O00000o.O0000Oo0 = -1;
                } else if (i4 == 2) {
                    o000000o.O00000o.O0000Oo0 = 0;
                    o000000o.O00000o.O0000OOo = -1;
                } else {
                    throw new IllegalArgumentException("Left to " + O0000O0o(i4) + " undefined");
                }
                o000000o.O00000o.O000O0Oo = 0;
                return;
            case 2:
                if (i4 == 1) {
                    o000000o.O00000o.O0000Oo = 0;
                    o000000o.O00000o.O0000OoO = -1;
                } else if (i4 == 2) {
                    o000000o.O00000o.O0000OoO = 0;
                    o000000o.O00000o.O0000Oo = -1;
                } else {
                    throw new IllegalArgumentException("right to " + O0000O0o(i4) + " undefined");
                }
                o000000o.O00000o.O00oOoOo = 0;
                return;
            case 3:
                if (i4 == 3) {
                    o000000o.O00000o.O0000Ooo = 0;
                    o000000o.O00000o.O0000o00 = -1;
                    o000000o.O00000o.O0000o0o = -1;
                } else if (i4 == 4) {
                    o000000o.O00000o.O0000o00 = 0;
                    o000000o.O00000o.O0000Ooo = -1;
                    o000000o.O00000o.O0000o0o = -1;
                } else {
                    throw new IllegalArgumentException("right to " + O0000O0o(i4) + " undefined");
                }
                o000000o.O00000o.O000O0o0 = 0;
                return;
            case 4:
                if (i4 == 4) {
                    o000000o.O00000o.O0000o0O = 0;
                    o000000o.O00000o.O0000o0 = -1;
                    o000000o.O00000o.O0000o0o = -1;
                } else if (i4 == 3) {
                    o000000o.O00000o.O0000o0 = 0;
                    o000000o.O00000o.O0000o0O = -1;
                    o000000o.O00000o.O0000o0o = -1;
                } else {
                    throw new IllegalArgumentException("right to " + O0000O0o(i4) + " undefined");
                }
                o000000o.O00000o.O000O0o = 0;
                return;
            case 5:
                if (i4 == 5) {
                    o000000o.O00000o.O0000o0o = 0;
                    o000000o.O00000o.O0000o0O = -1;
                    o000000o.O00000o.O0000o0 = -1;
                    o000000o.O00000o.O0000Ooo = -1;
                    o000000o.O00000o.O0000o00 = -1;
                    return;
                }
                throw new IllegalArgumentException("right to " + O0000O0o(i4) + " undefined");
            case 6:
                if (i4 == 6) {
                    o000000o.O00000o.O0000oO0 = 0;
                    o000000o.O00000o.O0000o = -1;
                } else if (i4 == 7) {
                    o000000o.O00000o.O0000o = 0;
                    o000000o.O00000o.O0000oO0 = -1;
                } else {
                    throw new IllegalArgumentException("right to " + O0000O0o(i4) + " undefined");
                }
                o000000o.O00000o.O000O0oo = 0;
                return;
            case 7:
                if (i4 == 7) {
                    o000000o.O00000o.O0000oOO = 0;
                    o000000o.O00000o.O0000oO = -1;
                } else if (i4 == 6) {
                    o000000o.O00000o.O0000oO = 0;
                    o000000o.O00000o.O0000oOO = -1;
                } else {
                    throw new IllegalArgumentException("right to " + O0000O0o(i4) + " undefined");
                }
                o000000o.O00000o.O000O0oO = 0;
                return;
            default:
                throw new IllegalArgumentException(O0000O0o(i2) + " to " + O0000O0o(i4) + " unknown");
        }
    }

    public final void O000000o(int i) {
        HashMap<Integer, O000000o> hashMap = this.O00000o;
        Integer valueOf = Integer.valueOf((int) R.id.material_clock_display);
        if (hashMap.containsKey(valueOf)) {
            O000000o o000000o = this.O00000o.get(valueOf);
            switch (i) {
                case 1:
                    o000000o.O00000o.O0000Oo0 = -1;
                    o000000o.O00000o.O0000OOo = -1;
                    o000000o.O00000o.O000O0Oo = -1;
                    o000000o.O00000o.O000OO00 = -1;
                    return;
                case 2:
                    o000000o.O00000o.O0000OoO = -1;
                    o000000o.O00000o.O0000Oo = -1;
                    o000000o.O00000o.O00oOoOo = -1;
                    o000000o.O00000o.O000OO = -1;
                    return;
                case 3:
                    o000000o.O00000o.O0000o00 = -1;
                    o000000o.O00000o.O0000Ooo = -1;
                    o000000o.O00000o.O000O0o0 = -1;
                    o000000o.O00000o.O000OO0o = -1;
                    return;
                case 4:
                    o000000o.O00000o.O0000o0 = -1;
                    o000000o.O00000o.O0000o0O = -1;
                    o000000o.O00000o.O000O0o = -1;
                    o000000o.O00000o.O000OOOo = -1;
                    return;
                case 5:
                    o000000o.O00000o.O0000o0o = -1;
                    return;
                case 6:
                    o000000o.O00000o.O0000o = -1;
                    o000000o.O00000o.O0000oO0 = -1;
                    o000000o.O00000o.O000O0oo = -1;
                    o000000o.O00000o.O000OOo = -1;
                    return;
                case 7:
                    o000000o.O00000o.O0000oO = -1;
                    o000000o.O00000o.O0000oOO = -1;
                    o000000o.O00000o.O000O0oO = -1;
                    o000000o.O00000o.O000OOo0 = -1;
                    return;
                default:
                    throw new IllegalArgumentException("unknown constraint");
            }
        }
    }

    public final void O000000o(int i, int i2, int i3) {
        O000000o O00000oo2 = O00000oo(i);
        switch (i2) {
            case 1:
                O00000oo2.O00000o.O000O0Oo = i3;
                return;
            case 2:
                O00000oo2.O00000o.O00oOoOo = i3;
                return;
            case 3:
                O00000oo2.O00000o.O000O0o0 = i3;
                return;
            case 4:
                O00000oo2.O00000o.O000O0o = i3;
                return;
            case 5:
                throw new IllegalArgumentException("baseline does not support margins");
            case 6:
                O00000oo2.O00000o.O000O0oo = i3;
                return;
            case 7:
                O00000oo2.O00000o.O000O0oO = i3;
                return;
            default:
                throw new IllegalArgumentException("unknown constraint");
        }
    }

    public final void O000000o(String str) {
        O00000oo(R.id.op_banner).O00000o.O0000oo = str;
    }

    public final int O00000Oo(int i) {
        return O00000oo(i).O00000Oo.O00000o0;
    }

    public final int O00000o0(int i) {
        return O00000oo(i).O00000Oo.O00000Oo;
    }

    public final int O00000o(int i) {
        return O00000oo(i).O00000o.O00000o;
    }

    public final int O00000oO(int i) {
        return O00000oo(i).O00000o.O00000o0;
    }

    public final void O000000o(int i, int i2) {
        O00000oo(i).O00000o.O00000o = i2;
    }

    public final void O00000Oo(int i, int i2) {
        O00000oo(i).O00000o.O00000o0 = i2;
    }

    public final void O000000o(int i, int i2, float f) {
        O000000o O00000oo2 = O00000oo(i);
        O00000oo2.O00000o.O0000ooO = R.id.circle_center;
        O00000oo2.O00000o.O0000ooo = i2;
        O00000oo2.O00000o.O00oOooO = f;
    }

    public final O000000o O00000oo(int i) {
        if (!this.O00000o.containsKey(Integer.valueOf(i))) {
            this.O00000o.put(Integer.valueOf(i), new O000000o());
        }
        return this.O00000o.get(Integer.valueOf(i));
    }

    public final void O00000Oo(Context context, int i) {
        XmlResourceParser xml = context.getResources().getXml(i);
        try {
            for (int eventType = xml.getEventType(); eventType != 1; eventType = xml.next()) {
                if (eventType == 0) {
                    xml.getName();
                } else if (eventType == 2) {
                    String name = xml.getName();
                    O000000o O000000o2 = O000000o(context, Xml.asAttributeSet(xml));
                    if (name.equalsIgnoreCase("Guideline")) {
                        O000000o2.O00000o.f2305O000000o = true;
                    }
                    this.O00000o.put(Integer.valueOf(O000000o2.f2304O000000o), O000000o2);
                }
            }
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:97:0x016d, code lost:
        continue;
     */
    public final void O000000o(Context context, XmlPullParser xmlPullParser) {
        char c;
        O000000o o000000o;
        try {
            int eventType = xmlPullParser.getEventType();
            O000000o o000000o2 = null;
            while (eventType != 1) {
                if (eventType == 0) {
                    xmlPullParser.getName();
                } else if (eventType == 2) {
                    String name = xmlPullParser.getName();
                    switch (name.hashCode()) {
                        case -2025855158:
                            if (name.equals("Layout")) {
                                c = 5;
                                break;
                            }
                            c = 65535;
                            break;
                        case -1984451626:
                            if (name.equals("Motion")) {
                                c = 6;
                                break;
                            }
                            c = 65535;
                            break;
                        case -1269513683:
                            if (name.equals("PropertySet")) {
                                c = 3;
                                break;
                            }
                            c = 65535;
                            break;
                        case -1238332596:
                            if (name.equals("Transform")) {
                                c = 4;
                                break;
                            }
                            c = 65535;
                            break;
                        case -71750448:
                            if (name.equals("Guideline")) {
                                c = 1;
                                break;
                            }
                            c = 65535;
                            break;
                        case 1331510167:
                            if (name.equals("Barrier")) {
                                c = 2;
                                break;
                            }
                            c = 65535;
                            break;
                        case 1791837707:
                            if (name.equals("CustomAttribute")) {
                                c = 7;
                                break;
                            }
                            c = 65535;
                            break;
                        case 1803088381:
                            if (name.equals("Constraint")) {
                                c = 0;
                                break;
                            }
                            c = 65535;
                            break;
                        default:
                            c = 65535;
                            break;
                    }
                    switch (c) {
                        case 0:
                            o000000o = O000000o(context, Xml.asAttributeSet(xmlPullParser));
                            o000000o2 = o000000o;
                            break;
                        case 1:
                            o000000o = O000000o(context, Xml.asAttributeSet(xmlPullParser));
                            o000000o.O00000o.f2305O000000o = true;
                            o000000o.O00000o.O00000Oo = true;
                            o000000o2 = o000000o;
                            break;
                        case 2:
                            o000000o = O000000o(context, Xml.asAttributeSet(xmlPullParser));
                            o000000o.O00000o.O000Oooo = 1;
                            o000000o2 = o000000o;
                            break;
                        case 3:
                            if (o000000o2 != null) {
                                o000000o2.O00000Oo.O000000o(context, Xml.asAttributeSet(xmlPullParser));
                                break;
                            } else {
                                throw new RuntimeException("XML parser error must be within a Constraint " + xmlPullParser.getLineNumber());
                            }
                        case 4:
                            if (o000000o2 != null) {
                                o000000o2.O00000oO.O000000o(context, Xml.asAttributeSet(xmlPullParser));
                                break;
                            } else {
                                throw new RuntimeException("XML parser error must be within a Constraint " + xmlPullParser.getLineNumber());
                            }
                        case 5:
                            if (o000000o2 != null) {
                                o000000o2.O00000o.O000000o(context, Xml.asAttributeSet(xmlPullParser));
                                break;
                            } else {
                                throw new RuntimeException("XML parser error must be within a Constraint " + xmlPullParser.getLineNumber());
                            }
                        case 6:
                            if (o000000o2 != null) {
                                o000000o2.O00000o0.O000000o(context, Xml.asAttributeSet(xmlPullParser));
                                break;
                            } else {
                                throw new RuntimeException("XML parser error must be within a Constraint " + xmlPullParser.getLineNumber());
                            }
                        case 7:
                            if (o000000o2 != null) {
                                ConstraintAttribute.O000000o(context, xmlPullParser, o000000o2.O00000oo);
                                break;
                            } else {
                                throw new RuntimeException("XML parser error must be within a Constraint " + xmlPullParser.getLineNumber());
                            }
                    }
                } else if (eventType != 3) {
                    continue;
                } else {
                    String name2 = xmlPullParser.getName();
                    if (!"ConstraintSet".equals(name2)) {
                        if (name2.equalsIgnoreCase("Constraint")) {
                            this.O00000o.put(Integer.valueOf(o000000o2.f2304O000000o), o000000o2);
                            o000000o2 = null;
                        }
                    } else {
                        return;
                    }
                }
                eventType = xmlPullParser.next();
            }
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    public static int O000000o(TypedArray typedArray, int i, int i2) {
        int resourceId = typedArray.getResourceId(i, i2);
        return resourceId == -1 ? typedArray.getInt(i, -1) : resourceId;
    }

    private static O000000o O000000o(Context context, AttributeSet attributeSet) {
        O000000o o000000o = new O000000o();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{16842948, 16842960, 16842972, 16842996, 16842997, 16842999, 16843000, 16843001, 16843002, 16843039, 16843040, 16843071, 16843072, 16843551, 16843552, 16843553, 16843554, 16843555, 16843556, 16843557, 16843558, 16843559, 16843560, 16843701, 16843702, 16843770, 16843840, R.attr.animate_relativeTo, R.attr.barrierAllowsGoneWidgets, R.attr.barrierDirection, R.attr.barrierMargin, R.attr.chainUseRtl, R.attr.constraint_referenced_ids, R.attr.drawPath, R.attr.flow_firstHorizontalBias, R.attr.flow_firstHorizontalStyle, R.attr.flow_firstVerticalBias, R.attr.flow_firstVerticalStyle, R.attr.flow_horizontalAlign, R.attr.flow_horizontalBias, R.attr.flow_horizontalGap, R.attr.flow_horizontalStyle, R.attr.flow_lastHorizontalBias, R.attr.flow_lastHorizontalStyle, R.attr.flow_lastVerticalBias, R.attr.flow_lastVerticalStyle, R.attr.flow_maxElementsWrap, R.attr.flow_verticalAlign, R.attr.flow_verticalBias, R.attr.flow_verticalGap, R.attr.flow_verticalStyle, R.attr.flow_wrapMode, R.attr.layout_constrainedHeight, R.attr.layout_constrainedWidth, R.attr.layout_constraintBaseline_creator, R.attr.layout_constraintBaseline_toBaselineOf, R.attr.layout_constraintBottom_creator, R.attr.layout_constraintBottom_toBottomOf, R.attr.layout_constraintBottom_toTopOf, R.attr.layout_constraintCircle, R.attr.layout_constraintCircleAngle, R.attr.layout_constraintCircleRadius, R.attr.layout_constraintDimensionRatio, R.attr.layout_constraintEnd_toEndOf, R.attr.layout_constraintEnd_toStartOf, R.attr.layout_constraintGuide_begin, R.attr.layout_constraintGuide_end, R.attr.layout_constraintGuide_percent, R.attr.layout_constraintHeight_default, R.attr.layout_constraintHeight_max, R.attr.layout_constraintHeight_min, R.attr.layout_constraintHeight_percent, R.attr.layout_constraintHorizontal_bias, R.attr.layout_constraintHorizontal_chainStyle, R.attr.layout_constraintHorizontal_weight, R.attr.layout_constraintLeft_creator, R.attr.layout_constraintLeft_toLeftOf, R.attr.layout_constraintLeft_toRightOf, R.attr.layout_constraintRight_creator, R.attr.layout_constraintRight_toLeftOf, R.attr.layout_constraintRight_toRightOf, R.attr.layout_constraintStart_toEndOf, R.attr.layout_constraintStart_toStartOf, R.attr.layout_constraintTag, R.attr.layout_constraintTop_creator, R.attr.layout_constraintTop_toBottomOf, R.attr.layout_constraintTop_toTopOf, R.attr.layout_constraintVertical_bias, R.attr.layout_constraintVertical_chainStyle, R.attr.layout_constraintVertical_weight, R.attr.layout_constraintWidth_default, R.attr.layout_constraintWidth_max, R.attr.layout_constraintWidth_min, R.attr.layout_constraintWidth_percent, R.attr.layout_editor_absoluteX, R.attr.layout_editor_absoluteY, R.attr.layout_goneMarginBottom, R.attr.layout_goneMarginEnd, R.attr.layout_goneMarginLeft, R.attr.layout_goneMarginRight, R.attr.layout_goneMarginStart, R.attr.layout_goneMarginTop, R.attr.motionProgress, R.attr.motionStagger, R.attr.pathMotionArc, R.attr.pivotAnchor, R.attr.transitionEasing, R.attr.transitionPathRotate, R.attr.visibilityMode});
        O000000o(o000000o, obtainStyledAttributes);
        obtainStyledAttributes.recycle();
        return o000000o;
    }

    private static void O000000o(O000000o o000000o, TypedArray typedArray) {
        int indexCount = typedArray.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            int index = typedArray.getIndex(i);
            if (!(index == 1 || 23 == index || 24 == index)) {
                o000000o.O00000o0.f2307O000000o = true;
                o000000o.O00000o.O00000Oo = true;
                o000000o.O00000Oo.f2306O000000o = true;
                o000000o.O00000oO.f2308O000000o = true;
            }
            switch (O00000oo.get(index)) {
                case 1:
                    o000000o.O00000o.O0000o0o = O000000o(typedArray, index, o000000o.O00000o.O0000o0o);
                    break;
                case 2:
                    o000000o.O00000o.O000O0o = typedArray.getDimensionPixelSize(index, o000000o.O00000o.O000O0o);
                    break;
                case 3:
                    o000000o.O00000o.O0000o0O = O000000o(typedArray, index, o000000o.O00000o.O0000o0O);
                    break;
                case 4:
                    o000000o.O00000o.O0000o0 = O000000o(typedArray, index, o000000o.O00000o.O0000o0);
                    break;
                case 5:
                    o000000o.O00000o.O0000oo = typedArray.getString(index);
                    break;
                case 6:
                    o000000o.O00000o.O00oOooo = typedArray.getDimensionPixelOffset(index, o000000o.O00000o.O00oOooo);
                    break;
                case 7:
                    o000000o.O00000o.O000O00o = typedArray.getDimensionPixelOffset(index, o000000o.O00000o.O000O00o);
                    break;
                case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER /*8*/:
                    if (Build.VERSION.SDK_INT < 17) {
                        break;
                    } else {
                        o000000o.O00000o.O000O0oO = typedArray.getDimensionPixelSize(index, o000000o.O00000o.O000O0oO);
                        break;
                    }
                case 9:
                    o000000o.O00000o.O0000oOO = O000000o(typedArray, index, o000000o.O00000o.O0000oOO);
                    break;
                case 10:
                    o000000o.O00000o.O0000oO = O000000o(typedArray, index, o000000o.O00000o.O0000oO);
                    break;
                case 11:
                    o000000o.O00000o.O000OOOo = typedArray.getDimensionPixelSize(index, o000000o.O00000o.O000OOOo);
                    break;
                case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT /*12*/:
                    o000000o.O00000o.O000OOo0 = typedArray.getDimensionPixelSize(index, o000000o.O00000o.O000OOo0);
                    break;
                case 13:
                    o000000o.O00000o.O000OO00 = typedArray.getDimensionPixelSize(index, o000000o.O00000o.O000OO00);
                    break;
                case 14:
                    o000000o.O00000o.O000OO = typedArray.getDimensionPixelSize(index, o000000o.O00000o.O000OO);
                    break;
                case GmsLogger.MAX_PII_TAG_LENGTH /*15*/:
                    o000000o.O00000o.O000OOo = typedArray.getDimensionPixelSize(index, o000000o.O00000o.O000OOo);
                    break;
                case 16:
                    o000000o.O00000o.O000OO0o = typedArray.getDimensionPixelSize(index, o000000o.O00000o.O000OO0o);
                    break;
                case 17:
                    o000000o.O00000o.O00000oO = typedArray.getDimensionPixelOffset(index, o000000o.O00000o.O00000oO);
                    break;
                case 18:
                    o000000o.O00000o.O00000oo = typedArray.getDimensionPixelOffset(index, o000000o.O00000o.O00000oo);
                    break;
                case 19:
                    o000000o.O00000o.O0000O0o = typedArray.getFloat(index, o000000o.O00000o.O0000O0o);
                    break;
                case 20:
                    o000000o.O00000o.O0000oOo = typedArray.getFloat(index, o000000o.O00000o.O0000oOo);
                    break;
                case 21:
                    o000000o.O00000o.O00000o = typedArray.getLayoutDimension(index, o000000o.O00000o.O00000o);
                    break;
                case 22:
                    o000000o.O00000Oo.O00000Oo = typedArray.getInt(index, o000000o.O00000Oo.O00000Oo);
                    o000000o.O00000Oo.O00000Oo = O00000o0[o000000o.O00000Oo.O00000Oo];
                    break;
                case 23:
                    o000000o.O00000o.O00000o0 = typedArray.getLayoutDimension(index, o000000o.O00000o.O00000o0);
                    break;
                case 24:
                    o000000o.O00000o.O000O0Oo = typedArray.getDimensionPixelSize(index, o000000o.O00000o.O000O0Oo);
                    break;
                case 25:
                    o000000o.O00000o.O0000OOo = O000000o(typedArray, index, o000000o.O00000o.O0000OOo);
                    break;
                case 26:
                    o000000o.O00000o.O0000Oo0 = O000000o(typedArray, index, o000000o.O00000o.O0000Oo0);
                    break;
                case 27:
                    o000000o.O00000o.O000O0OO = typedArray.getInt(index, o000000o.O00000o.O000O0OO);
                    break;
                case 28:
                    o000000o.O00000o.O00oOoOo = typedArray.getDimensionPixelSize(index, o000000o.O00000o.O00oOoOo);
                    break;
                case 29:
                    o000000o.O00000o.O0000Oo = O000000o(typedArray, index, o000000o.O00000o.O0000Oo);
                    break;
                case 30:
                    o000000o.O00000o.O0000OoO = O000000o(typedArray, index, o000000o.O00000o.O0000OoO);
                    break;
                case 31:
                    if (Build.VERSION.SDK_INT < 17) {
                        break;
                    } else {
                        o000000o.O00000o.O000O0oo = typedArray.getDimensionPixelSize(index, o000000o.O00000o.O000O0oo);
                        break;
                    }
                case 32:
                    o000000o.O00000o.O0000o = O000000o(typedArray, index, o000000o.O00000o.O0000o);
                    break;
                case 33:
                    o000000o.O00000o.O0000oO0 = O000000o(typedArray, index, o000000o.O00000o.O0000oO0);
                    break;
                case 34:
                    o000000o.O00000o.O000O0o0 = typedArray.getDimensionPixelSize(index, o000000o.O00000o.O000O0o0);
                    break;
                case 35:
                    o000000o.O00000o.O0000o00 = O000000o(typedArray, index, o000000o.O00000o.O0000o00);
                    break;
                case 36:
                    o000000o.O00000o.O0000Ooo = O000000o(typedArray, index, o000000o.O00000o.O0000Ooo);
                    break;
                case 37:
                    o000000o.O00000o.O0000oo0 = typedArray.getFloat(index, o000000o.O00000o.O0000oo0);
                    break;
                case 38:
                    o000000o.f2304O000000o = typedArray.getResourceId(index, o000000o.f2304O000000o);
                    break;
                case 39:
                    o000000o.O00000o.O000OOoo = typedArray.getFloat(index, o000000o.O00000o.O000OOoo);
                    break;
                case 40:
                    o000000o.O00000o.O000OOoO = typedArray.getFloat(index, o000000o.O00000o.O000OOoO);
                    break;
                case 41:
                    o000000o.O00000o.O000Oo00 = typedArray.getInt(index, o000000o.O00000o.O000Oo00);
                    break;
                case 42:
                    o000000o.O00000o.O000Oo0 = typedArray.getInt(index, o000000o.O00000o.O000Oo0);
                    break;
                case 43:
                    o000000o.O00000Oo.O00000o = typedArray.getFloat(index, o000000o.O00000Oo.O00000o);
                    break;
                case 44:
                    if (Build.VERSION.SDK_INT < 21) {
                        break;
                    } else {
                        o000000o.O00000oO.O0000Ooo = true;
                        o000000o.O00000oO.O0000o00 = typedArray.getDimension(index, o000000o.O00000oO.O0000o00);
                        break;
                    }
                case 45:
                    o000000o.O00000oO.O00000o0 = typedArray.getFloat(index, o000000o.O00000oO.O00000o0);
                    break;
                case 46:
                    o000000o.O00000oO.O00000o = typedArray.getFloat(index, o000000o.O00000oO.O00000o);
                    break;
                case 47:
                    o000000o.O00000oO.O00000oO = typedArray.getFloat(index, o000000o.O00000oO.O00000oO);
                    break;
                case 48:
                    o000000o.O00000oO.O00000oo = typedArray.getFloat(index, o000000o.O00000oO.O00000oo);
                    break;
                case 49:
                    o000000o.O00000oO.O0000O0o = typedArray.getDimension(index, o000000o.O00000oO.O0000O0o);
                    break;
                case 50:
                    o000000o.O00000oO.O0000OOo = typedArray.getDimension(index, o000000o.O00000oO.O0000OOo);
                    break;
                case 51:
                    o000000o.O00000oO.O0000Oo0 = typedArray.getDimension(index, o000000o.O00000oO.O0000Oo0);
                    break;
                case 52:
                    o000000o.O00000oO.O0000Oo = typedArray.getDimension(index, o000000o.O00000oO.O0000Oo);
                    break;
                case 53:
                    if (Build.VERSION.SDK_INT < 21) {
                        break;
                    } else {
                        o000000o.O00000oO.O0000OoO = typedArray.getDimension(index, o000000o.O00000oO.O0000OoO);
                        break;
                    }
                case 54:
                    o000000o.O00000o.O000Oo0O = typedArray.getInt(index, o000000o.O00000o.O000Oo0O);
                    break;
                case 55:
                    o000000o.O00000o.O000Oo0o = typedArray.getInt(index, o000000o.O00000o.O000Oo0o);
                    break;
                case 56:
                    o000000o.O00000o.O000OoO0 = typedArray.getDimensionPixelSize(index, o000000o.O00000o.O000OoO0);
                    break;
                case 57:
                    o000000o.O00000o.O00O0Oo = typedArray.getDimensionPixelSize(index, o000000o.O00000o.O00O0Oo);
                    break;
                case 58:
                    o000000o.O00000o.O000OoO = typedArray.getDimensionPixelSize(index, o000000o.O00000o.O000OoO);
                    break;
                case 59:
                    o000000o.O00000o.O000OoOO = typedArray.getDimensionPixelSize(index, o000000o.O00000o.O000OoOO);
                    break;
                case 60:
                    o000000o.O00000oO.O00000Oo = typedArray.getFloat(index, o000000o.O00000oO.O00000Oo);
                    break;
                case 61:
                    o000000o.O00000o.O0000ooO = O000000o(typedArray, index, o000000o.O00000o.O0000ooO);
                    break;
                case 62:
                    o000000o.O00000o.O0000ooo = typedArray.getDimensionPixelSize(index, o000000o.O00000o.O0000ooo);
                    break;
                case 63:
                    o000000o.O00000o.O00oOooO = typedArray.getFloat(index, o000000o.O00000o.O00oOooO);
                    break;
                case 64:
                    o000000o.O00000o0.O00000Oo = O000000o(typedArray, index, o000000o.O00000o0.O00000Oo);
                    break;
                case 65:
                    if (typedArray.peekValue(index).type != 3) {
                        o000000o.O00000o0.O00000o0 = o0OO0o00.O00000o0[typedArray.getInteger(index, 0)];
                        break;
                    } else {
                        o000000o.O00000o0.O00000o0 = typedArray.getString(index);
                        break;
                    }
                case 66:
                    o000000o.O00000o0.O00000oO = typedArray.getInt(index, 0);
                    break;
                case 67:
                    o000000o.O00000o0.O0000O0o = typedArray.getFloat(index, o000000o.O00000o0.O0000O0o);
                    break;
                case 68:
                    o000000o.O00000Oo.O00000oO = typedArray.getFloat(index, o000000o.O00000Oo.O00000oO);
                    break;
                case 69:
                    o000000o.O00000o.O000OoOo = typedArray.getFloat(index, 1.0f);
                    break;
                case 70:
                    o000000o.O00000o.O000Ooo0 = typedArray.getFloat(index, 1.0f);
                    break;
                case 71:
                    Log.e("ConstraintSet", "CURRENTLY UNSUPPORTED");
                    break;
                case 72:
                    o000000o.O00000o.O000Ooo = typedArray.getInt(index, o000000o.O00000o.O000Ooo);
                    break;
                case 73:
                    o000000o.O00000o.O000OooO = typedArray.getDimensionPixelSize(index, o000000o.O00000o.O000OooO);
                    break;
                case 74:
                    o000000o.O00000o.O000o00 = typedArray.getString(index);
                    break;
                case 75:
                    o000000o.O00000o.O000o0O0 = typedArray.getBoolean(index, o000000o.O00000o.O000o0O0);
                    break;
                case 76:
                    o000000o.O00000o0.O00000o = typedArray.getInt(index, o000000o.O00000o0.O00000o);
                    break;
                case 77:
                    o000000o.O00000o.O000o00O = typedArray.getString(index);
                    break;
                case 78:
                    o000000o.O00000Oo.O00000o0 = typedArray.getInt(index, o000000o.O00000Oo.O00000o0);
                    break;
                case 79:
                    o000000o.O00000o0.O00000oo = typedArray.getFloat(index, o000000o.O00000o0.O00000oo);
                    break;
                case 80:
                    o000000o.O00000o.O000o00o = typedArray.getBoolean(index, o000000o.O00000o.O000o00o);
                    break;
                case 81:
                    o000000o.O00000o.O000o0 = typedArray.getBoolean(index, o000000o.O00000o.O000o0);
                    break;
                case XiaomiOAuthConstants.VERSION_MINOR /*82*/:
                    Log.w("ConstraintSet", "unused attribute 0x" + Integer.toHexString(index) + "   " + O00000oo.get(index));
                    break;
                default:
                    Log.w("ConstraintSet", "Unknown attribute 0x" + Integer.toHexString(index) + "   " + O00000oo.get(index));
                    break;
            }
        }
    }

    private static int[] O000000o(View view, String str) {
        int i;
        Object designInformation;
        String[] split = str.split(",");
        Context context = view.getContext();
        int[] iArr = new int[split.length];
        int i2 = 0;
        int i3 = 0;
        while (i2 < split.length) {
            String trim = split[i2].trim();
            try {
                i = R$id.class.getField(trim).getInt(null);
            } catch (Exception unused) {
                i = 0;
            }
            if (i == 0) {
                i = context.getResources().getIdentifier(trim, "id", context.getPackageName());
            }
            if (i == 0 && view.isInEditMode() && (view.getParent() instanceof ConstraintLayout) && (designInformation = ((ConstraintLayout) view.getParent()).getDesignInformation(0, trim)) != null && (designInformation instanceof Integer)) {
                i = ((Integer) designInformation).intValue();
            }
            iArr[i3] = i;
            i2++;
            i3++;
        }
        return i3 != split.length ? Arrays.copyOf(iArr, i3) : iArr;
    }

    public final int[] O000000o() {
        Integer[] numArr = (Integer[]) this.O00000o.keySet().toArray(new Integer[0]);
        int[] iArr = new int[numArr.length];
        for (int i = 0; i < iArr.length; i++) {
            iArr[i] = numArr[i].intValue();
        }
        return iArr;
    }
}
