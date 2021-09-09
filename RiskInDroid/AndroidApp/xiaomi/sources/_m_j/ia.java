package _m_j;

import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.transition.Transition;
import androidx.transition.TransitionSet;
import java.util.ArrayList;
import java.util.List;

@SuppressLint({"RestrictedApi"})
public class ia extends el {
    public final boolean O000000o(Object obj) {
        return obj instanceof Transition;
    }

    public final Object O00000Oo(Object obj) {
        if (obj != null) {
            return ((Transition) obj).clone();
        }
        return null;
    }

    public final Object O00000o0(Object obj) {
        if (obj == null) {
            return null;
        }
        TransitionSet transitionSet = new TransitionSet();
        transitionSet.O000000o((Transition) obj);
        return transitionSet;
    }

    public final void O000000o(Object obj, View view, ArrayList<View> arrayList) {
        TransitionSet transitionSet = (TransitionSet) obj;
        List<View> targets = transitionSet.getTargets();
        targets.clear();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            O000000o(targets, arrayList.get(i));
        }
        targets.add(view);
        arrayList.add(view);
        O000000o(transitionSet, arrayList);
    }

    public final void O000000o(Object obj, View view) {
        if (view != null) {
            final Rect rect = new Rect();
            O000000o(view, rect);
            ((Transition) obj).setEpicenterCallback(new Transition.O00000o0() {
                /* class _m_j.ia.AnonymousClass1 */

                public final Rect O000000o() {
                    return rect;
                }
            });
        }
    }

    public final void O000000o(Object obj, ArrayList<View> arrayList) {
        Transition transition = (Transition) obj;
        if (transition != null) {
            int i = 0;
            if (transition instanceof TransitionSet) {
                TransitionSet transitionSet = (TransitionSet) transition;
                int size = transitionSet.f3019O000000o.size();
                while (i < size) {
                    O000000o(transitionSet.O00000Oo(i), arrayList);
                    i++;
                }
            } else if (!O000000o(transition) && O000000o((List) transition.getTargets())) {
                int size2 = arrayList.size();
                while (i < size2) {
                    transition.addTarget(arrayList.get(i));
                    i++;
                }
            }
        }
    }

    private static boolean O000000o(Transition transition) {
        return !O000000o(transition.getTargetIds()) || !O000000o(transition.getTargetNames()) || !O000000o(transition.getTargetTypes());
    }

    public final Object O000000o(Object obj, Object obj2, Object obj3) {
        TransitionSet transitionSet = new TransitionSet();
        if (obj != null) {
            transitionSet.O000000o((Transition) obj);
        }
        if (obj2 != null) {
            transitionSet.O000000o((Transition) obj2);
        }
        if (obj3 != null) {
            transitionSet.O000000o((Transition) obj3);
        }
        return transitionSet;
    }

    public final void O00000Oo(Object obj, final View view, final ArrayList<View> arrayList) {
        ((Transition) obj).addListener(new Transition.O00000o() {
            /* class _m_j.ia.AnonymousClass2 */

            public final void onTransitionCancel(Transition transition) {
            }

            public final void onTransitionPause(Transition transition) {
            }

            public final void onTransitionResume(Transition transition) {
            }

            public final void onTransitionStart(Transition transition) {
            }

            public final void onTransitionEnd(Transition transition) {
                transition.removeListener(this);
                view.setVisibility(8);
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    ((View) arrayList.get(i)).setVisibility(0);
                }
            }
        });
    }

    public final Object O00000Oo(Object obj, Object obj2, Object obj3) {
        Transition transition = (Transition) obj;
        Transition transition2 = (Transition) obj2;
        Transition transition3 = (Transition) obj3;
        if (transition != null && transition2 != null) {
            transition = new TransitionSet().O000000o(transition).O000000o(transition2).O000000o(1);
        } else if (transition == null) {
            transition = transition2 != null ? transition2 : null;
        }
        if (transition3 == null) {
            return transition;
        }
        TransitionSet transitionSet = new TransitionSet();
        if (transition != null) {
            transitionSet.O000000o(transition);
        }
        transitionSet.O000000o(transition3);
        return transitionSet;
    }

    public final void O000000o(ViewGroup viewGroup, Object obj) {
        ip.O000000o(viewGroup, (Transition) obj);
    }

    public final void O000000o(Object obj, Object obj2, ArrayList<View> arrayList, Object obj3, ArrayList<View> arrayList2, Object obj4, ArrayList<View> arrayList3) {
        final Object obj5 = obj2;
        final ArrayList<View> arrayList4 = arrayList;
        final Object obj6 = obj3;
        final ArrayList<View> arrayList5 = arrayList2;
        final Object obj7 = obj4;
        final ArrayList<View> arrayList6 = arrayList3;
        ((Transition) obj).addListener(new io() {
            /* class _m_j.ia.AnonymousClass3 */

            public final void onTransitionStart(Transition transition) {
                Object obj = obj5;
                if (obj != null) {
                    ia.this.O00000Oo(obj, (ArrayList<View>) arrayList4, (ArrayList<View>) null);
                }
                Object obj2 = obj6;
                if (obj2 != null) {
                    ia.this.O00000Oo(obj2, (ArrayList<View>) arrayList5, (ArrayList<View>) null);
                }
                Object obj3 = obj7;
                if (obj3 != null) {
                    ia.this.O00000Oo(obj3, (ArrayList<View>) arrayList6, (ArrayList<View>) null);
                }
            }

            public final void onTransitionEnd(Transition transition) {
                transition.removeListener(this);
            }
        });
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ia.O00000Oo(java.lang.Object, java.util.ArrayList<android.view.View>, java.util.ArrayList<android.view.View>):void
     arg types: [androidx.transition.TransitionSet, java.util.ArrayList<android.view.View>, java.util.ArrayList<android.view.View>]
     candidates:
      _m_j.ia.O00000Oo(java.lang.Object, java.lang.Object, java.lang.Object):java.lang.Object
      _m_j.ia.O00000Oo(java.lang.Object, android.view.View, java.util.ArrayList<android.view.View>):void
      _m_j.el.O00000Oo(java.lang.Object, java.lang.Object, java.lang.Object):java.lang.Object
      _m_j.el.O00000Oo(java.lang.Object, android.view.View, java.util.ArrayList<android.view.View>):void
      _m_j.ia.O00000Oo(java.lang.Object, java.util.ArrayList<android.view.View>, java.util.ArrayList<android.view.View>):void */
    public final void O000000o(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2) {
        TransitionSet transitionSet = (TransitionSet) obj;
        if (transitionSet != null) {
            transitionSet.getTargets().clear();
            transitionSet.getTargets().addAll(arrayList2);
            O00000Oo((Object) transitionSet, arrayList, arrayList2);
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ia.O00000Oo(java.lang.Object, java.util.ArrayList<android.view.View>, java.util.ArrayList<android.view.View>):void
     arg types: [androidx.transition.Transition, java.util.ArrayList<android.view.View>, java.util.ArrayList<android.view.View>]
     candidates:
      _m_j.ia.O00000Oo(java.lang.Object, java.lang.Object, java.lang.Object):java.lang.Object
      _m_j.ia.O00000Oo(java.lang.Object, android.view.View, java.util.ArrayList<android.view.View>):void
      _m_j.el.O00000Oo(java.lang.Object, java.lang.Object, java.lang.Object):java.lang.Object
      _m_j.el.O00000Oo(java.lang.Object, android.view.View, java.util.ArrayList<android.view.View>):void
      _m_j.ia.O00000Oo(java.lang.Object, java.util.ArrayList<android.view.View>, java.util.ArrayList<android.view.View>):void */
    public final void O00000Oo(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2) {
        int i;
        Transition transition = (Transition) obj;
        int i2 = 0;
        if (transition instanceof TransitionSet) {
            TransitionSet transitionSet = (TransitionSet) transition;
            int size = transitionSet.f3019O000000o.size();
            while (i2 < size) {
                O00000Oo((Object) transitionSet.O00000Oo(i2), arrayList, arrayList2);
                i2++;
            }
        } else if (!O000000o(transition)) {
            List<View> targets = transition.getTargets();
            if (targets.size() == arrayList.size() && targets.containsAll(arrayList)) {
                if (arrayList2 == null) {
                    i = 0;
                } else {
                    i = arrayList2.size();
                }
                while (i2 < i) {
                    transition.addTarget(arrayList2.get(i2));
                    i2++;
                }
                for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
                    transition.removeTarget(arrayList.get(size2));
                }
            }
        }
    }

    public final void O00000Oo(Object obj, View view) {
        if (obj != null) {
            ((Transition) obj).addTarget(view);
        }
    }

    public final void O00000o0(Object obj, View view) {
        if (obj != null) {
            ((Transition) obj).removeTarget(view);
        }
    }

    public final void O000000o(Object obj, final Rect rect) {
        if (obj != null) {
            ((Transition) obj).setEpicenterCallback(new Transition.O00000o0() {
                /* class _m_j.ia.AnonymousClass4 */

                public final Rect O000000o() {
                    Rect rect = rect;
                    if (rect == null || rect.isEmpty()) {
                        return null;
                    }
                    return rect;
                }
            });
        }
    }
}
