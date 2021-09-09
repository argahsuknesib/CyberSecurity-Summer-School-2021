package androidx.transition;

import _m_j.cb;
import _m_j.hw;
import _m_j.in;
import _m_j.iq;
import _m_j.is;
import _m_j.it;
import _m_j.jd;
import _m_j.jn;
import _m_j.n;
import _m_j.o0O0OOO0;
import _m_j.o0O0Oo00;
import _m_j.o0O0o000;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Path;
import android.graphics.Rect;
import android.os.Build;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.InflateException;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;
import org.xmlpull.v1.XmlPullParser;

public abstract class Transition implements Cloneable {
    private static final int[] DEFAULT_MATCH_ORDER = {2, 1, 3, 4};
    private static final PathMotion STRAIGHT_PATH_MOTION = new PathMotion() {
        /* class androidx.transition.Transition.AnonymousClass1 */

        public final Path getPath(float f, float f2, float f3, float f4) {
            Path path = new Path();
            path.moveTo(f, f2);
            path.lineTo(f3, f4);
            return path;
        }
    };
    private static ThreadLocal<o0O0OOO0<Animator, O000000o>> sRunningAnimators = new ThreadLocal<>();
    private ArrayList<Animator> mAnimators = new ArrayList<>();
    boolean mCanRemoveViews = false;
    ArrayList<Animator> mCurrentAnimators = new ArrayList<>();
    long mDuration = -1;
    private it mEndValues = new it();
    private ArrayList<is> mEndValuesList;
    private boolean mEnded = false;
    private O00000o0 mEpicenterCallback;
    private TimeInterpolator mInterpolator = null;
    private ArrayList<O00000o> mListeners = null;
    private int[] mMatchOrder = DEFAULT_MATCH_ORDER;
    private String mName = getClass().getName();
    private o0O0OOO0<String, String> mNameOverrides;
    private int mNumInstances = 0;
    public TransitionSet mParent = null;
    private PathMotion mPathMotion = STRAIGHT_PATH_MOTION;
    private boolean mPaused = false;
    iq mPropagation;
    private ViewGroup mSceneRoot = null;
    private long mStartDelay = -1;
    private it mStartValues = new it();
    private ArrayList<is> mStartValuesList;
    private ArrayList<View> mTargetChildExcludes = null;
    private ArrayList<View> mTargetExcludes = null;
    private ArrayList<Integer> mTargetIdChildExcludes = null;
    private ArrayList<Integer> mTargetIdExcludes = null;
    ArrayList<Integer> mTargetIds = new ArrayList<>();
    private ArrayList<String> mTargetNameExcludes = null;
    private ArrayList<String> mTargetNames = null;
    private ArrayList<Class<?>> mTargetTypeChildExcludes = null;
    private ArrayList<Class<?>> mTargetTypeExcludes = null;
    private ArrayList<Class<?>> mTargetTypes = null;
    ArrayList<View> mTargets = new ArrayList<>();

    public interface O00000o {
        void onTransitionCancel(Transition transition);

        void onTransitionEnd(Transition transition);

        void onTransitionPause(Transition transition);

        void onTransitionResume(Transition transition);

        void onTransitionStart(Transition transition);
    }

    public static abstract class O00000o0 {
        public abstract Rect O000000o();
    }

    private static boolean isValidMatch(int i) {
        return i > 0 && i <= 4;
    }

    public abstract void captureEndValues(is isVar);

    public abstract void captureStartValues(is isVar);

    public Animator createAnimator(ViewGroup viewGroup, is isVar, is isVar2) {
        return null;
    }

    public String[] getTransitionProperties() {
        return null;
    }

    public Transition() {
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.n.O000000o(android.content.res.TypedArray, org.xmlpull.v1.XmlPullParser, java.lang.String, int, int):int
     arg types: [android.content.res.TypedArray, android.content.res.XmlResourceParser, java.lang.String, int, int]
     candidates:
      _m_j.n.O000000o(android.content.res.TypedArray, org.xmlpull.v1.XmlPullParser, java.lang.String, int, float):float
      _m_j.n.O000000o(android.content.res.TypedArray, org.xmlpull.v1.XmlPullParser, android.content.res.Resources$Theme, java.lang.String, int):_m_j.i
      _m_j.n.O000000o(android.content.res.TypedArray, org.xmlpull.v1.XmlPullParser, java.lang.String, int, boolean):boolean
      _m_j.n.O000000o(android.content.res.TypedArray, org.xmlpull.v1.XmlPullParser, java.lang.String, int, int):int */
    @SuppressLint({"RestrictedApi"})
    public Transition(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, in.O00000o0);
        XmlResourceParser xmlResourceParser = (XmlResourceParser) attributeSet;
        long O000000o2 = (long) n.O000000o(obtainStyledAttributes, (XmlPullParser) xmlResourceParser, "duration", 1, -1);
        if (O000000o2 >= 0) {
            setDuration(O000000o2);
        }
        long O000000o3 = (long) n.O000000o(obtainStyledAttributes, (XmlPullParser) xmlResourceParser, "startDelay", 2, -1);
        if (O000000o3 > 0) {
            setStartDelay(O000000o3);
        }
        int O00000Oo2 = n.O00000Oo(obtainStyledAttributes, xmlResourceParser, "interpolator", 0);
        if (O00000Oo2 > 0) {
            setInterpolator(AnimationUtils.loadInterpolator(context, O00000Oo2));
        }
        String O00000o02 = n.O00000o0(obtainStyledAttributes, xmlResourceParser, "matchOrder", 3);
        if (O00000o02 != null) {
            setMatchOrder(parseMatchOrder(O00000o02));
        }
        obtainStyledAttributes.recycle();
    }

    private static int[] parseMatchOrder(String str) {
        StringTokenizer stringTokenizer = new StringTokenizer(str, ",");
        int[] iArr = new int[stringTokenizer.countTokens()];
        int i = 0;
        while (stringTokenizer.hasMoreTokens()) {
            String trim = stringTokenizer.nextToken().trim();
            if ("id".equalsIgnoreCase(trim)) {
                iArr[i] = 3;
            } else if ("instance".equalsIgnoreCase(trim)) {
                iArr[i] = 1;
            } else if ("name".equalsIgnoreCase(trim)) {
                iArr[i] = 2;
            } else if ("itemId".equalsIgnoreCase(trim)) {
                iArr[i] = 4;
            } else if (trim.isEmpty()) {
                int[] iArr2 = new int[(iArr.length - 1)];
                System.arraycopy(iArr, 0, iArr2, 0, i);
                i--;
                iArr = iArr2;
            } else {
                throw new InflateException("Unknown match type in matchOrder: '" + trim + "'");
            }
            i++;
        }
        return iArr;
    }

    public Transition setDuration(long j) {
        this.mDuration = j;
        return this;
    }

    public long getDuration() {
        return this.mDuration;
    }

    public Transition setStartDelay(long j) {
        this.mStartDelay = j;
        return this;
    }

    public long getStartDelay() {
        return this.mStartDelay;
    }

    public Transition setInterpolator(TimeInterpolator timeInterpolator) {
        this.mInterpolator = timeInterpolator;
        return this;
    }

    public TimeInterpolator getInterpolator() {
        return this.mInterpolator;
    }

    public void setMatchOrder(int... iArr) {
        if (iArr == null || iArr.length == 0) {
            this.mMatchOrder = DEFAULT_MATCH_ORDER;
            return;
        }
        int i = 0;
        while (i < iArr.length) {
            if (!isValidMatch(iArr[i])) {
                throw new IllegalArgumentException("matches contains invalid value");
            } else if (!alreadyContains(iArr, i)) {
                i++;
            } else {
                throw new IllegalArgumentException("matches contains a duplicate value");
            }
        }
        this.mMatchOrder = (int[]) iArr.clone();
    }

    private static boolean alreadyContains(int[] iArr, int i) {
        int i2 = iArr[i];
        for (int i3 = 0; i3 < i; i3++) {
            if (iArr[i3] == i2) {
                return true;
            }
        }
        return false;
    }

    private void matchInstances(o0O0OOO0<View, is> o0o0ooo0, o0O0OOO0<View, is> o0o0ooo02) {
        is remove;
        for (int size = o0o0ooo0.size() - 1; size >= 0; size--) {
            View O00000Oo2 = o0o0ooo0.O00000Oo(size);
            if (O00000Oo2 != null && isValidTarget(O00000Oo2) && (remove = o0o0ooo02.remove(O00000Oo2)) != null && isValidTarget(remove.O00000Oo)) {
                this.mStartValuesList.add(o0o0ooo0.O00000o(size));
                this.mEndValuesList.add(remove);
            }
        }
    }

    private void matchItemIds(o0O0OOO0<View, is> o0o0ooo0, o0O0OOO0<View, is> o0o0ooo02, o0O0o000<View> o0o0o000, o0O0o000<View> o0o0o0002) {
        View O000000o2;
        int O00000o02 = o0o0o000.O00000o0();
        for (int i = 0; i < O00000o02; i++) {
            View O00000o03 = o0o0o000.O00000o0(i);
            if (O00000o03 != null && isValidTarget(O00000o03) && (O000000o2 = o0o0o0002.O000000o(o0o0o000.O00000Oo(i), null)) != null && isValidTarget(O000000o2)) {
                is isVar = o0o0ooo0.get(O00000o03);
                is isVar2 = o0o0ooo02.get(O000000o2);
                if (!(isVar == null || isVar2 == null)) {
                    this.mStartValuesList.add(isVar);
                    this.mEndValuesList.add(isVar2);
                    o0o0ooo0.remove(O00000o03);
                    o0o0ooo02.remove(O000000o2);
                }
            }
        }
    }

    private void matchIds(o0O0OOO0<View, is> o0o0ooo0, o0O0OOO0<View, is> o0o0ooo02, SparseArray<View> sparseArray, SparseArray<View> sparseArray2) {
        View view;
        int size = sparseArray.size();
        for (int i = 0; i < size; i++) {
            View valueAt = sparseArray.valueAt(i);
            if (valueAt != null && isValidTarget(valueAt) && (view = sparseArray2.get(sparseArray.keyAt(i))) != null && isValidTarget(view)) {
                is isVar = o0o0ooo0.get(valueAt);
                is isVar2 = o0o0ooo02.get(view);
                if (!(isVar == null || isVar2 == null)) {
                    this.mStartValuesList.add(isVar);
                    this.mEndValuesList.add(isVar2);
                    o0o0ooo0.remove(valueAt);
                    o0o0ooo02.remove(view);
                }
            }
        }
    }

    private void matchNames(o0O0OOO0<View, is> o0o0ooo0, o0O0OOO0<View, is> o0o0ooo02, o0O0OOO0<String, View> o0o0ooo03, o0O0OOO0<String, View> o0o0ooo04) {
        View view;
        int size = o0o0ooo03.size();
        for (int i = 0; i < size; i++) {
            View O00000o02 = o0o0ooo03.O00000o0(i);
            if (O00000o02 != null && isValidTarget(O00000o02) && (view = o0o0ooo04.get(o0o0ooo03.O00000Oo(i))) != null && isValidTarget(view)) {
                is isVar = o0o0ooo0.get(O00000o02);
                is isVar2 = o0o0ooo02.get(view);
                if (!(isVar == null || isVar2 == null)) {
                    this.mStartValuesList.add(isVar);
                    this.mEndValuesList.add(isVar2);
                    o0o0ooo0.remove(O00000o02);
                    o0o0ooo02.remove(view);
                }
            }
        }
    }

    private void addUnmatched(o0O0OOO0<View, is> o0o0ooo0, o0O0OOO0<View, is> o0o0ooo02) {
        for (int i = 0; i < o0o0ooo0.size(); i++) {
            is O00000o02 = o0o0ooo0.O00000o0(i);
            if (isValidTarget(O00000o02.O00000Oo)) {
                this.mStartValuesList.add(O00000o02);
                this.mEndValuesList.add(null);
            }
        }
        for (int i2 = 0; i2 < o0o0ooo02.size(); i2++) {
            is O00000o03 = o0o0ooo02.O00000o0(i2);
            if (isValidTarget(O00000o03.O00000Oo)) {
                this.mEndValuesList.add(O00000o03);
                this.mStartValuesList.add(null);
            }
        }
    }

    private void matchStartAndEnd(it itVar, it itVar2) {
        o0O0OOO0 o0o0ooo0 = new o0O0OOO0(itVar.f1616O000000o);
        o0O0OOO0 o0o0ooo02 = new o0O0OOO0(itVar2.f1616O000000o);
        int i = 0;
        while (true) {
            int[] iArr = this.mMatchOrder;
            if (i < iArr.length) {
                int i2 = iArr[i];
                if (i2 == 1) {
                    matchInstances(o0o0ooo0, o0o0ooo02);
                } else if (i2 == 2) {
                    matchNames(o0o0ooo0, o0o0ooo02, itVar.O00000o, itVar2.O00000o);
                } else if (i2 == 3) {
                    matchIds(o0o0ooo0, o0o0ooo02, itVar.O00000Oo, itVar2.O00000Oo);
                } else if (i2 == 4) {
                    matchItemIds(o0o0ooo0, o0o0ooo02, itVar.O00000o0, itVar2.O00000o0);
                }
                i++;
            } else {
                addUnmatched(o0o0ooo0, o0o0ooo02);
                return;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void createAnimators(ViewGroup viewGroup, it itVar, it itVar2, ArrayList<is> arrayList, ArrayList<is> arrayList2) {
        int i;
        int i2;
        Animator createAnimator;
        View view;
        Animator animator;
        is isVar;
        Animator animator2;
        is isVar2;
        ViewGroup viewGroup2 = viewGroup;
        o0O0OOO0<Animator, O000000o> runningAnimators = getRunningAnimators();
        SparseIntArray sparseIntArray = new SparseIntArray();
        int size = arrayList.size();
        long j = Long.MAX_VALUE;
        int i3 = 0;
        while (i3 < size) {
            is isVar3 = arrayList.get(i3);
            is isVar4 = arrayList2.get(i3);
            if (isVar3 != null && !isVar3.O00000o0.contains(this)) {
                isVar3 = null;
            }
            if (isVar4 != null && !isVar4.O00000o0.contains(this)) {
                isVar4 = null;
            }
            if (!(isVar3 == null && isVar4 == null)) {
                if ((isVar3 == null || isVar4 == null || isTransitionRequired(isVar3, isVar4)) && (createAnimator = createAnimator(viewGroup2, isVar3, isVar4)) != null) {
                    if (isVar4 != null) {
                        view = isVar4.O00000Oo;
                        String[] transitionProperties = getTransitionProperties();
                        if (transitionProperties != null && transitionProperties.length > 0) {
                            isVar2 = new is(view);
                            animator2 = createAnimator;
                            i2 = size;
                            is isVar5 = itVar2.f1616O000000o.get(view);
                            if (isVar5 != null) {
                                int i4 = 0;
                                while (i4 < transitionProperties.length) {
                                    isVar2.f1596O000000o.put(transitionProperties[i4], isVar5.f1596O000000o.get(transitionProperties[i4]));
                                    i4++;
                                    i3 = i3;
                                    isVar5 = isVar5;
                                }
                            }
                            i = i3;
                            int size2 = runningAnimators.size();
                            int i5 = 0;
                            while (true) {
                                if (i5 >= size2) {
                                    break;
                                }
                                O000000o o000000o = runningAnimators.get(runningAnimators.O00000Oo(i5));
                                if (o000000o.O00000o0 != null && o000000o.f3018O000000o == view && o000000o.O00000Oo.equals(getName()) && o000000o.O00000o0.equals(isVar2)) {
                                    isVar = isVar2;
                                    animator = null;
                                    break;
                                }
                                i5++;
                            }
                        } else {
                            animator2 = createAnimator;
                            i2 = size;
                            i = i3;
                            isVar2 = null;
                        }
                        isVar = isVar2;
                        animator = animator2;
                    } else {
                        i2 = size;
                        i = i3;
                        view = isVar3.O00000Oo;
                        animator = createAnimator;
                        isVar = null;
                    }
                    if (animator != null) {
                        iq iqVar = this.mPropagation;
                        if (iqVar != null) {
                            long O000000o2 = iqVar.O000000o(viewGroup2, this, isVar3, isVar4);
                            sparseIntArray.put(this.mAnimators.size(), (int) O000000o2);
                            j = Math.min(O000000o2, j);
                        }
                        runningAnimators.put(animator, new O000000o(view, getName(), this, jd.O00000Oo(viewGroup), isVar));
                        this.mAnimators.add(animator);
                        j = j;
                    }
                    i3 = i + 1;
                    size = i2;
                }
            }
            i2 = size;
            i = i3;
            i3 = i + 1;
            size = i2;
        }
        if (sparseIntArray.size() != 0) {
            for (int i6 = 0; i6 < sparseIntArray.size(); i6++) {
                Animator animator3 = this.mAnimators.get(sparseIntArray.keyAt(i6));
                animator3.setStartDelay((((long) sparseIntArray.valueAt(i6)) - j) + animator3.getStartDelay());
            }
        }
    }

    /* access modifiers changed from: package-private */
    public boolean isValidTarget(View view) {
        ArrayList<Class<?>> arrayList;
        ArrayList<String> arrayList2;
        int id = view.getId();
        ArrayList<Integer> arrayList3 = this.mTargetIdExcludes;
        if (arrayList3 != null && arrayList3.contains(Integer.valueOf(id))) {
            return false;
        }
        ArrayList<View> arrayList4 = this.mTargetExcludes;
        if (arrayList4 != null && arrayList4.contains(view)) {
            return false;
        }
        ArrayList<Class<?>> arrayList5 = this.mTargetTypeExcludes;
        if (arrayList5 != null) {
            int size = arrayList5.size();
            for (int i = 0; i < size; i++) {
                if (this.mTargetTypeExcludes.get(i).isInstance(view)) {
                    return false;
                }
            }
        }
        if (this.mTargetNameExcludes != null && cb.O0000oo0(view) != null && this.mTargetNameExcludes.contains(cb.O0000oo0(view))) {
            return false;
        }
        if ((this.mTargetIds.size() == 0 && this.mTargets.size() == 0 && (((arrayList = this.mTargetTypes) == null || arrayList.isEmpty()) && ((arrayList2 = this.mTargetNames) == null || arrayList2.isEmpty()))) || this.mTargetIds.contains(Integer.valueOf(id)) || this.mTargets.contains(view)) {
            return true;
        }
        ArrayList<String> arrayList6 = this.mTargetNames;
        if (arrayList6 != null && arrayList6.contains(cb.O0000oo0(view))) {
            return true;
        }
        if (this.mTargetTypes != null) {
            for (int i2 = 0; i2 < this.mTargetTypes.size(); i2++) {
                if (this.mTargetTypes.get(i2).isInstance(view)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static o0O0OOO0<Animator, O000000o> getRunningAnimators() {
        o0O0OOO0<Animator, O000000o> o0o0ooo0 = sRunningAnimators.get();
        if (o0o0ooo0 != null) {
            return o0o0ooo0;
        }
        o0O0OOO0<Animator, O000000o> o0o0ooo02 = new o0O0OOO0<>();
        sRunningAnimators.set(o0o0ooo02);
        return o0o0ooo02;
    }

    /* access modifiers changed from: protected */
    public void runAnimators() {
        start();
        o0O0OOO0<Animator, O000000o> runningAnimators = getRunningAnimators();
        Iterator<Animator> it = this.mAnimators.iterator();
        while (it.hasNext()) {
            Animator next = it.next();
            if (runningAnimators.containsKey(next)) {
                start();
                runAnimator(next, runningAnimators);
            }
        }
        this.mAnimators.clear();
        end();
    }

    private void runAnimator(Animator animator, final o0O0OOO0<Animator, O000000o> o0o0ooo0) {
        if (animator != null) {
            animator.addListener(new AnimatorListenerAdapter() {
                /* class androidx.transition.Transition.AnonymousClass2 */

                public final void onAnimationStart(Animator animator) {
                    Transition.this.mCurrentAnimators.add(animator);
                }

                public final void onAnimationEnd(Animator animator) {
                    o0o0ooo0.remove(animator);
                    Transition.this.mCurrentAnimators.remove(animator);
                }
            });
            animate(animator);
        }
    }

    public Transition addTarget(View view) {
        this.mTargets.add(view);
        return this;
    }

    public Transition addTarget(int i) {
        if (i != 0) {
            this.mTargetIds.add(Integer.valueOf(i));
        }
        return this;
    }

    public Transition addTarget(String str) {
        if (this.mTargetNames == null) {
            this.mTargetNames = new ArrayList<>();
        }
        this.mTargetNames.add(str);
        return this;
    }

    public Transition addTarget(Class<?> cls) {
        if (this.mTargetTypes == null) {
            this.mTargetTypes = new ArrayList<>();
        }
        this.mTargetTypes.add(cls);
        return this;
    }

    public Transition removeTarget(View view) {
        this.mTargets.remove(view);
        return this;
    }

    public Transition removeTarget(int i) {
        if (i != 0) {
            this.mTargetIds.remove(Integer.valueOf(i));
        }
        return this;
    }

    public Transition removeTarget(String str) {
        ArrayList<String> arrayList = this.mTargetNames;
        if (arrayList != null) {
            arrayList.remove(str);
        }
        return this;
    }

    public Transition removeTarget(Class<?> cls) {
        ArrayList<Class<?>> arrayList = this.mTargetTypes;
        if (arrayList != null) {
            arrayList.remove(cls);
        }
        return this;
    }

    private static <T> ArrayList<T> excludeObject(ArrayList<T> arrayList, T t, boolean z) {
        if (t == null) {
            return arrayList;
        }
        if (z) {
            return O00000Oo.O000000o(arrayList, t);
        }
        return O00000Oo.O00000Oo(arrayList, t);
    }

    public Transition excludeTarget(View view, boolean z) {
        this.mTargetExcludes = excludeView(this.mTargetExcludes, view, z);
        return this;
    }

    public Transition excludeTarget(int i, boolean z) {
        this.mTargetIdExcludes = excludeId(this.mTargetIdExcludes, i, z);
        return this;
    }

    public Transition excludeTarget(String str, boolean z) {
        this.mTargetNameExcludes = excludeObject(this.mTargetNameExcludes, str, z);
        return this;
    }

    public Transition excludeChildren(View view, boolean z) {
        this.mTargetChildExcludes = excludeView(this.mTargetChildExcludes, view, z);
        return this;
    }

    public Transition excludeChildren(int i, boolean z) {
        this.mTargetIdChildExcludes = excludeId(this.mTargetIdChildExcludes, i, z);
        return this;
    }

    private ArrayList<Integer> excludeId(ArrayList<Integer> arrayList, int i, boolean z) {
        if (i <= 0) {
            return arrayList;
        }
        if (z) {
            return O00000Oo.O000000o(arrayList, Integer.valueOf(i));
        }
        return O00000Oo.O00000Oo(arrayList, Integer.valueOf(i));
    }

    private ArrayList<View> excludeView(ArrayList<View> arrayList, View view, boolean z) {
        if (view == null) {
            return arrayList;
        }
        if (z) {
            return O00000Oo.O000000o(arrayList, view);
        }
        return O00000Oo.O00000Oo(arrayList, view);
    }

    public Transition excludeTarget(Class<?> cls, boolean z) {
        this.mTargetTypeExcludes = excludeType(this.mTargetTypeExcludes, cls, z);
        return this;
    }

    public Transition excludeChildren(Class<?> cls, boolean z) {
        this.mTargetTypeChildExcludes = excludeType(this.mTargetTypeChildExcludes, cls, z);
        return this;
    }

    private ArrayList<Class<?>> excludeType(ArrayList<Class<?>> arrayList, Class<?> cls, boolean z) {
        if (cls == null) {
            return arrayList;
        }
        if (z) {
            return O00000Oo.O000000o(arrayList, cls);
        }
        return O00000Oo.O00000Oo(arrayList, cls);
    }

    public List<Integer> getTargetIds() {
        return this.mTargetIds;
    }

    public List<View> getTargets() {
        return this.mTargets;
    }

    public List<String> getTargetNames() {
        return this.mTargetNames;
    }

    public List<Class<?>> getTargetTypes() {
        return this.mTargetTypes;
    }

    public void captureValues(ViewGroup viewGroup, boolean z) {
        o0O0OOO0<String, String> o0o0ooo0;
        ArrayList<String> arrayList;
        ArrayList<Class<?>> arrayList2;
        clearValues(z);
        if ((this.mTargetIds.size() > 0 || this.mTargets.size() > 0) && (((arrayList = this.mTargetNames) == null || arrayList.isEmpty()) && ((arrayList2 = this.mTargetTypes) == null || arrayList2.isEmpty()))) {
            for (int i = 0; i < this.mTargetIds.size(); i++) {
                View findViewById = viewGroup.findViewById(this.mTargetIds.get(i).intValue());
                if (findViewById != null) {
                    is isVar = new is(findViewById);
                    if (z) {
                        captureStartValues(isVar);
                    } else {
                        captureEndValues(isVar);
                    }
                    isVar.O00000o0.add(this);
                    capturePropagationValues(isVar);
                    if (z) {
                        addViewValues(this.mStartValues, findViewById, isVar);
                    } else {
                        addViewValues(this.mEndValues, findViewById, isVar);
                    }
                }
            }
            for (int i2 = 0; i2 < this.mTargets.size(); i2++) {
                View view = this.mTargets.get(i2);
                is isVar2 = new is(view);
                if (z) {
                    captureStartValues(isVar2);
                } else {
                    captureEndValues(isVar2);
                }
                isVar2.O00000o0.add(this);
                capturePropagationValues(isVar2);
                if (z) {
                    addViewValues(this.mStartValues, view, isVar2);
                } else {
                    addViewValues(this.mEndValues, view, isVar2);
                }
            }
        } else {
            captureHierarchy(viewGroup, z);
        }
        if (!z && (o0o0ooo0 = this.mNameOverrides) != null) {
            int size = o0o0ooo0.size();
            ArrayList arrayList3 = new ArrayList(size);
            for (int i3 = 0; i3 < size; i3++) {
                arrayList3.add(this.mStartValues.O00000o.remove(this.mNameOverrides.O00000Oo(i3)));
            }
            for (int i4 = 0; i4 < size; i4++) {
                View view2 = (View) arrayList3.get(i4);
                if (view2 != null) {
                    this.mStartValues.O00000o.put(this.mNameOverrides.O00000o0(i4), view2);
                }
            }
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.cb.O000000o(android.view.View, boolean):void
     arg types: [android.view.View, int]
     candidates:
      _m_j.cb.O000000o(int, int):int
      _m_j.cb.O000000o(android.view.View, _m_j.ci):_m_j.ci
      _m_j.cb.O000000o(int, android.view.View):void
      _m_j.cb.O000000o(android.view.View, float):void
      _m_j.cb.O000000o(android.view.View, _m_j.bh):void
      _m_j.cb.O000000o(android.view.View, _m_j.bw):void
      _m_j.cb.O000000o(android.view.View, _m_j.by):void
      _m_j.cb.O000000o(android.view.View, _m_j.cl$O000000o):void
      _m_j.cb.O000000o(android.view.View, _m_j.cl):void
      _m_j.cb.O000000o(android.view.View, android.content.res.ColorStateList):void
      _m_j.cb.O000000o(android.view.View, android.graphics.Paint):void
      _m_j.cb.O000000o(android.view.View, android.graphics.PorterDuff$Mode):void
      _m_j.cb.O000000o(android.view.View, android.graphics.Rect):void
      _m_j.cb.O000000o(android.view.View, android.graphics.drawable.Drawable):void
      _m_j.cb.O000000o(android.view.View, java.lang.Runnable):void
      _m_j.cb.O000000o(android.view.View, java.lang.String):void
      _m_j.cb.O000000o(android.view.View, int):boolean
      _m_j.cb.O000000o(android.view.View, android.view.KeyEvent):boolean
      _m_j.cb.O000000o(android.view.View, boolean):void */
    private static void addViewValues(it itVar, View view, is isVar) {
        itVar.f1616O000000o.put(view, isVar);
        int id = view.getId();
        if (id >= 0) {
            if (itVar.O00000Oo.indexOfKey(id) >= 0) {
                itVar.O00000Oo.put(id, null);
            } else {
                itVar.O00000Oo.put(id, view);
            }
        }
        String O0000oo0 = cb.O0000oo0(view);
        if (O0000oo0 != null) {
            if (itVar.O00000o.containsKey(O0000oo0)) {
                itVar.O00000o.put(O0000oo0, null);
            } else {
                itVar.O00000o.put(O0000oo0, view);
            }
        }
        if (view.getParent() instanceof ListView) {
            ListView listView = (ListView) view.getParent();
            if (listView.getAdapter().hasStableIds()) {
                long itemIdAtPosition = listView.getItemIdAtPosition(listView.getPositionForView(view));
                o0O0o000<View> o0o0o000 = itVar.O00000o0;
                if (o0o0o000.O00000Oo) {
                    o0o0o000.O00000Oo();
                }
                if (o0O0Oo00.O000000o(o0o0o000.O00000o0, o0o0o000.O00000oO, itemIdAtPosition) >= 0) {
                    View O000000o2 = itVar.O00000o0.O000000o(itemIdAtPosition, null);
                    if (O000000o2 != null) {
                        cb.O000000o(O000000o2, false);
                        itVar.O00000o0.O00000Oo(itemIdAtPosition, null);
                        return;
                    }
                    return;
                }
                cb.O000000o(view, true);
                itVar.O00000o0.O00000Oo(itemIdAtPosition, view);
            }
        }
    }

    public void clearValues(boolean z) {
        if (z) {
            this.mStartValues.f1616O000000o.clear();
            this.mStartValues.O00000Oo.clear();
            this.mStartValues.O00000o0.O00000o();
            return;
        }
        this.mEndValues.f1616O000000o.clear();
        this.mEndValues.O00000Oo.clear();
        this.mEndValues.O00000o0.O00000o();
    }

    private void captureHierarchy(View view, boolean z) {
        if (view != null) {
            int id = view.getId();
            ArrayList<Integer> arrayList = this.mTargetIdExcludes;
            if (arrayList == null || !arrayList.contains(Integer.valueOf(id))) {
                ArrayList<View> arrayList2 = this.mTargetExcludes;
                if (arrayList2 == null || !arrayList2.contains(view)) {
                    ArrayList<Class<?>> arrayList3 = this.mTargetTypeExcludes;
                    if (arrayList3 != null) {
                        int size = arrayList3.size();
                        int i = 0;
                        while (i < size) {
                            if (!this.mTargetTypeExcludes.get(i).isInstance(view)) {
                                i++;
                            } else {
                                return;
                            }
                        }
                    }
                    if (view.getParent() instanceof ViewGroup) {
                        is isVar = new is(view);
                        if (z) {
                            captureStartValues(isVar);
                        } else {
                            captureEndValues(isVar);
                        }
                        isVar.O00000o0.add(this);
                        capturePropagationValues(isVar);
                        if (z) {
                            addViewValues(this.mStartValues, view, isVar);
                        } else {
                            addViewValues(this.mEndValues, view, isVar);
                        }
                    }
                    if (view instanceof ViewGroup) {
                        ArrayList<Integer> arrayList4 = this.mTargetIdChildExcludes;
                        if (arrayList4 == null || !arrayList4.contains(Integer.valueOf(id))) {
                            ArrayList<View> arrayList5 = this.mTargetChildExcludes;
                            if (arrayList5 == null || !arrayList5.contains(view)) {
                                ArrayList<Class<?>> arrayList6 = this.mTargetTypeChildExcludes;
                                if (arrayList6 != null) {
                                    int size2 = arrayList6.size();
                                    int i2 = 0;
                                    while (i2 < size2) {
                                        if (!this.mTargetTypeChildExcludes.get(i2).isInstance(view)) {
                                            i2++;
                                        } else {
                                            return;
                                        }
                                    }
                                }
                                ViewGroup viewGroup = (ViewGroup) view;
                                for (int i3 = 0; i3 < viewGroup.getChildCount(); i3++) {
                                    captureHierarchy(viewGroup.getChildAt(i3), z);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public is getTransitionValues(View view, boolean z) {
        TransitionSet transitionSet = this.mParent;
        if (transitionSet != null) {
            return transitionSet.getTransitionValues(view, z);
        }
        return (z ? this.mStartValues : this.mEndValues).f1616O000000o.get(view);
    }

    /* access modifiers changed from: package-private */
    public is getMatchedTransitionValues(View view, boolean z) {
        TransitionSet transitionSet = this.mParent;
        if (transitionSet != null) {
            return transitionSet.getMatchedTransitionValues(view, z);
        }
        ArrayList<is> arrayList = z ? this.mStartValuesList : this.mEndValuesList;
        if (arrayList == null) {
            return null;
        }
        int size = arrayList.size();
        int i = -1;
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                break;
            }
            is isVar = (is) arrayList.get(i2);
            if (isVar == null) {
                return null;
            }
            if (isVar.O00000Oo == view) {
                i = i2;
                break;
            }
            i2++;
        }
        if (i < 0) {
            return null;
        }
        return (is) (z ? this.mEndValuesList : this.mStartValuesList).get(i);
    }

    public void pause(View view) {
        int i;
        if (!this.mEnded) {
            o0O0OOO0<Animator, O000000o> runningAnimators = getRunningAnimators();
            int size = runningAnimators.size();
            jn O00000Oo2 = jd.O00000Oo(view);
            int i2 = size - 1;
            while (true) {
                i = 0;
                if (i2 < 0) {
                    break;
                }
                O000000o O00000o02 = runningAnimators.O00000o0(i2);
                if (O00000o02.f3018O000000o != null && O00000Oo2.equals(O00000o02.O00000o)) {
                    Animator O00000Oo3 = runningAnimators.O00000Oo(i2);
                    if (Build.VERSION.SDK_INT >= 19) {
                        O00000Oo3.pause();
                    } else {
                        ArrayList<Animator.AnimatorListener> listeners = O00000Oo3.getListeners();
                        if (listeners != null) {
                            int size2 = listeners.size();
                            while (i < size2) {
                                Animator.AnimatorListener animatorListener = listeners.get(i);
                                if (animatorListener instanceof hw.O000000o) {
                                    ((hw.O000000o) animatorListener).onAnimationPause(O00000Oo3);
                                }
                                i++;
                            }
                        }
                    }
                }
                i2--;
            }
            ArrayList<O00000o> arrayList = this.mListeners;
            if (arrayList != null && arrayList.size() > 0) {
                ArrayList arrayList2 = (ArrayList) this.mListeners.clone();
                int size3 = arrayList2.size();
                while (i < size3) {
                    ((O00000o) arrayList2.get(i)).onTransitionPause(this);
                    i++;
                }
            }
            this.mPaused = true;
        }
    }

    public void resume(View view) {
        if (this.mPaused) {
            if (!this.mEnded) {
                o0O0OOO0<Animator, O000000o> runningAnimators = getRunningAnimators();
                int size = runningAnimators.size();
                jn O00000Oo2 = jd.O00000Oo(view);
                for (int i = size - 1; i >= 0; i--) {
                    O000000o O00000o02 = runningAnimators.O00000o0(i);
                    if (O00000o02.f3018O000000o != null && O00000Oo2.equals(O00000o02.O00000o)) {
                        Animator O00000Oo3 = runningAnimators.O00000Oo(i);
                        if (Build.VERSION.SDK_INT >= 19) {
                            O00000Oo3.resume();
                        } else {
                            ArrayList<Animator.AnimatorListener> listeners = O00000Oo3.getListeners();
                            if (listeners != null) {
                                int size2 = listeners.size();
                                for (int i2 = 0; i2 < size2; i2++) {
                                    Animator.AnimatorListener animatorListener = listeners.get(i2);
                                    if (animatorListener instanceof hw.O000000o) {
                                        ((hw.O000000o) animatorListener).onAnimationResume(O00000Oo3);
                                    }
                                }
                            }
                        }
                    }
                }
                ArrayList<O00000o> arrayList = this.mListeners;
                if (arrayList != null && arrayList.size() > 0) {
                    ArrayList arrayList2 = (ArrayList) this.mListeners.clone();
                    int size3 = arrayList2.size();
                    for (int i3 = 0; i3 < size3; i3++) {
                        ((O00000o) arrayList2.get(i3)).onTransitionResume(this);
                    }
                }
            }
            this.mPaused = false;
        }
    }

    public void playTransition(ViewGroup viewGroup) {
        O000000o o000000o;
        this.mStartValuesList = new ArrayList<>();
        this.mEndValuesList = new ArrayList<>();
        matchStartAndEnd(this.mStartValues, this.mEndValues);
        o0O0OOO0<Animator, O000000o> runningAnimators = getRunningAnimators();
        int size = runningAnimators.size();
        jn O00000Oo2 = jd.O00000Oo(viewGroup);
        for (int i = size - 1; i >= 0; i--) {
            Animator O00000Oo3 = runningAnimators.O00000Oo(i);
            if (!(O00000Oo3 == null || (o000000o = runningAnimators.get(O00000Oo3)) == null || o000000o.f3018O000000o == null || !O00000Oo2.equals(o000000o.O00000o))) {
                is isVar = o000000o.O00000o0;
                View view = o000000o.f3018O000000o;
                is transitionValues = getTransitionValues(view, true);
                is matchedTransitionValues = getMatchedTransitionValues(view, true);
                if (transitionValues == null && matchedTransitionValues == null) {
                    matchedTransitionValues = this.mEndValues.f1616O000000o.get(view);
                }
                if (!(transitionValues == null && matchedTransitionValues == null) && o000000o.O00000oO.isTransitionRequired(isVar, matchedTransitionValues)) {
                    if (O00000Oo3.isRunning() || O00000Oo3.isStarted()) {
                        O00000Oo3.cancel();
                    } else {
                        runningAnimators.remove(O00000Oo3);
                    }
                }
            }
        }
        createAnimators(viewGroup, this.mStartValues, this.mEndValues, this.mStartValuesList, this.mEndValuesList);
        runAnimators();
    }

    public boolean isTransitionRequired(is isVar, is isVar2) {
        if (!(isVar == null || isVar2 == null)) {
            String[] transitionProperties = getTransitionProperties();
            if (transitionProperties != null) {
                for (String isValueChanged : transitionProperties) {
                    if (isValueChanged(isVar, isVar2, isValueChanged)) {
                        return true;
                    }
                }
            } else {
                for (String isValueChanged2 : isVar.f1596O000000o.keySet()) {
                    if (isValueChanged(isVar, isVar2, isValueChanged2)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private static boolean isValueChanged(is isVar, is isVar2, String str) {
        Object obj = isVar.f1596O000000o.get(str);
        Object obj2 = isVar2.f1596O000000o.get(str);
        if (obj == null && obj2 == null) {
            return false;
        }
        if (obj == null || obj2 == null || !obj.equals(obj2)) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public void animate(Animator animator) {
        if (animator == null) {
            end();
            return;
        }
        if (getDuration() >= 0) {
            animator.setDuration(getDuration());
        }
        if (getStartDelay() >= 0) {
            animator.setStartDelay(getStartDelay() + animator.getStartDelay());
        }
        if (getInterpolator() != null) {
            animator.setInterpolator(getInterpolator());
        }
        animator.addListener(new AnimatorListenerAdapter() {
            /* class androidx.transition.Transition.AnonymousClass3 */

            public final void onAnimationEnd(Animator animator) {
                Transition.this.end();
                animator.removeListener(this);
            }
        });
        animator.start();
    }

    /* access modifiers changed from: protected */
    public void start() {
        if (this.mNumInstances == 0) {
            ArrayList<O00000o> arrayList = this.mListeners;
            if (arrayList != null && arrayList.size() > 0) {
                ArrayList arrayList2 = (ArrayList) this.mListeners.clone();
                int size = arrayList2.size();
                for (int i = 0; i < size; i++) {
                    ((O00000o) arrayList2.get(i)).onTransitionStart(this);
                }
            }
            this.mEnded = false;
        }
        this.mNumInstances++;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.cb.O000000o(android.view.View, boolean):void
     arg types: [android.view.View, int]
     candidates:
      _m_j.cb.O000000o(int, int):int
      _m_j.cb.O000000o(android.view.View, _m_j.ci):_m_j.ci
      _m_j.cb.O000000o(int, android.view.View):void
      _m_j.cb.O000000o(android.view.View, float):void
      _m_j.cb.O000000o(android.view.View, _m_j.bh):void
      _m_j.cb.O000000o(android.view.View, _m_j.bw):void
      _m_j.cb.O000000o(android.view.View, _m_j.by):void
      _m_j.cb.O000000o(android.view.View, _m_j.cl$O000000o):void
      _m_j.cb.O000000o(android.view.View, _m_j.cl):void
      _m_j.cb.O000000o(android.view.View, android.content.res.ColorStateList):void
      _m_j.cb.O000000o(android.view.View, android.graphics.Paint):void
      _m_j.cb.O000000o(android.view.View, android.graphics.PorterDuff$Mode):void
      _m_j.cb.O000000o(android.view.View, android.graphics.Rect):void
      _m_j.cb.O000000o(android.view.View, android.graphics.drawable.Drawable):void
      _m_j.cb.O000000o(android.view.View, java.lang.Runnable):void
      _m_j.cb.O000000o(android.view.View, java.lang.String):void
      _m_j.cb.O000000o(android.view.View, int):boolean
      _m_j.cb.O000000o(android.view.View, android.view.KeyEvent):boolean
      _m_j.cb.O000000o(android.view.View, boolean):void */
    /* access modifiers changed from: protected */
    public void end() {
        this.mNumInstances--;
        if (this.mNumInstances == 0) {
            ArrayList<O00000o> arrayList = this.mListeners;
            if (arrayList != null && arrayList.size() > 0) {
                ArrayList arrayList2 = (ArrayList) this.mListeners.clone();
                int size = arrayList2.size();
                for (int i = 0; i < size; i++) {
                    ((O00000o) arrayList2.get(i)).onTransitionEnd(this);
                }
            }
            for (int i2 = 0; i2 < this.mStartValues.O00000o0.O00000o0(); i2++) {
                View O00000o02 = this.mStartValues.O00000o0.O00000o0(i2);
                if (O00000o02 != null) {
                    cb.O000000o(O00000o02, false);
                }
            }
            for (int i3 = 0; i3 < this.mEndValues.O00000o0.O00000o0(); i3++) {
                View O00000o03 = this.mEndValues.O00000o0.O00000o0(i3);
                if (O00000o03 != null) {
                    cb.O000000o(O00000o03, false);
                }
            }
            this.mEnded = true;
        }
    }

    /* access modifiers changed from: package-private */
    public void forceToEnd(ViewGroup viewGroup) {
        o0O0OOO0<Animator, O000000o> runningAnimators = getRunningAnimators();
        int size = runningAnimators.size();
        if (viewGroup != null && size != 0) {
            jn O00000Oo2 = jd.O00000Oo(viewGroup);
            o0O0OOO0 o0o0ooo0 = new o0O0OOO0(runningAnimators);
            runningAnimators.clear();
            for (int i = size - 1; i >= 0; i--) {
                O000000o o000000o = (O000000o) o0o0ooo0.O00000o0(i);
                if (o000000o.f3018O000000o != null && O00000Oo2.equals(o000000o.O00000o)) {
                    ((Animator) o0o0ooo0.O00000Oo(i)).end();
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void cancel() {
        for (int size = this.mCurrentAnimators.size() - 1; size >= 0; size--) {
            this.mCurrentAnimators.get(size).cancel();
        }
        ArrayList<O00000o> arrayList = this.mListeners;
        if (arrayList != null && arrayList.size() > 0) {
            ArrayList arrayList2 = (ArrayList) this.mListeners.clone();
            int size2 = arrayList2.size();
            for (int i = 0; i < size2; i++) {
                ((O00000o) arrayList2.get(i)).onTransitionCancel(this);
            }
        }
    }

    public Transition addListener(O00000o o00000o) {
        if (this.mListeners == null) {
            this.mListeners = new ArrayList<>();
        }
        this.mListeners.add(o00000o);
        return this;
    }

    public Transition removeListener(O00000o o00000o) {
        ArrayList<O00000o> arrayList = this.mListeners;
        if (arrayList == null) {
            return this;
        }
        arrayList.remove(o00000o);
        if (this.mListeners.size() == 0) {
            this.mListeners = null;
        }
        return this;
    }

    public void setPathMotion(PathMotion pathMotion) {
        if (pathMotion == null) {
            this.mPathMotion = STRAIGHT_PATH_MOTION;
        } else {
            this.mPathMotion = pathMotion;
        }
    }

    public PathMotion getPathMotion() {
        return this.mPathMotion;
    }

    public void setEpicenterCallback(O00000o0 o00000o0) {
        this.mEpicenterCallback = o00000o0;
    }

    public O00000o0 getEpicenterCallback() {
        return this.mEpicenterCallback;
    }

    public Rect getEpicenter() {
        O00000o0 o00000o0 = this.mEpicenterCallback;
        if (o00000o0 == null) {
            return null;
        }
        return o00000o0.O000000o();
    }

    public void setPropagation(iq iqVar) {
        this.mPropagation = iqVar;
    }

    public iq getPropagation() {
        return this.mPropagation;
    }

    /* access modifiers changed from: package-private */
    public void capturePropagationValues(is isVar) {
        String[] O000000o2;
        if (this.mPropagation != null && !isVar.f1596O000000o.isEmpty() && (O000000o2 = this.mPropagation.O000000o()) != null) {
            boolean z = false;
            int i = 0;
            while (true) {
                if (i >= O000000o2.length) {
                    z = true;
                    break;
                } else if (!isVar.f1596O000000o.containsKey(O000000o2[i])) {
                    break;
                } else {
                    i++;
                }
            }
            if (!z) {
                this.mPropagation.O000000o(isVar);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public Transition setSceneRoot(ViewGroup viewGroup) {
        this.mSceneRoot = viewGroup;
        return this;
    }

    /* access modifiers changed from: package-private */
    public void setCanRemoveViews(boolean z) {
        this.mCanRemoveViews = z;
    }

    public String toString() {
        return toString("");
    }

    public Transition clone() {
        try {
            Transition transition = (Transition) super.clone();
            transition.mAnimators = new ArrayList<>();
            transition.mStartValues = new it();
            transition.mEndValues = new it();
            transition.mStartValuesList = null;
            transition.mEndValuesList = null;
            return transition;
        } catch (CloneNotSupportedException unused) {
            return null;
        }
    }

    public String getName() {
        return this.mName;
    }

    /* access modifiers changed from: package-private */
    public String toString(String str) {
        String str2 = str + getClass().getSimpleName() + "@" + Integer.toHexString(hashCode()) + ": ";
        if (this.mDuration != -1) {
            str2 = str2 + "dur(" + this.mDuration + ") ";
        }
        if (this.mStartDelay != -1) {
            str2 = str2 + "dly(" + this.mStartDelay + ") ";
        }
        if (this.mInterpolator != null) {
            str2 = str2 + "interp(" + this.mInterpolator + ") ";
        }
        if (this.mTargetIds.size() <= 0 && this.mTargets.size() <= 0) {
            return str2;
        }
        String str3 = str2 + "tgts(";
        if (this.mTargetIds.size() > 0) {
            String str4 = str3;
            for (int i = 0; i < this.mTargetIds.size(); i++) {
                if (i > 0) {
                    str4 = str4 + ", ";
                }
                str4 = str4 + this.mTargetIds.get(i);
            }
            str3 = str4;
        }
        if (this.mTargets.size() > 0) {
            for (int i2 = 0; i2 < this.mTargets.size(); i2++) {
                if (i2 > 0) {
                    str3 = str3 + ", ";
                }
                str3 = str3 + this.mTargets.get(i2);
            }
        }
        return str3 + ")";
    }

    static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        View f3018O000000o;
        String O00000Oo;
        jn O00000o;
        is O00000o0;
        Transition O00000oO;

        O000000o(View view, String str, Transition transition, jn jnVar, is isVar) {
            this.f3018O000000o = view;
            this.O00000Oo = str;
            this.O00000o0 = isVar;
            this.O00000o = jnVar;
            this.O00000oO = transition;
        }
    }

    static class O00000Oo {
        static <T> ArrayList<T> O000000o(ArrayList<T> arrayList, T t) {
            if (arrayList == null) {
                arrayList = new ArrayList<>();
            }
            if (!arrayList.contains(t)) {
                arrayList.add(t);
            }
            return arrayList;
        }

        static <T> ArrayList<T> O00000Oo(ArrayList<T> arrayList, T t) {
            if (arrayList == null) {
                return arrayList;
            }
            arrayList.remove(t);
            if (arrayList.isEmpty()) {
                return null;
            }
            return arrayList;
        }
    }
}
