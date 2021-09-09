package android.support.v4.app;

import android.graphics.Rect;
import android.os.Build;
import android.support.v4.app.BackStackRecord;
import android.support.v4.util.ArrayMap;
import android.support.v4.view.ViewCompat;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Collection;

class FragmentTransition {
    private static final int[] INVERSE_OPS = {0, 3, 0, 1, 5, 4, 7, 6};

    FragmentTransition() {
    }

    static void startTransitions(FragmentManagerImpl fragmentManagerImpl, ArrayList<BackStackRecord> arrayList, ArrayList<Boolean> arrayList2, int i, int i2, boolean z) {
        if (fragmentManagerImpl.mCurState > 0 && Build.VERSION.SDK_INT >= 21) {
            SparseArray sparseArray = new SparseArray();
            for (int i3 = i; i3 < i2; i3++) {
                BackStackRecord backStackRecord = arrayList.get(i3);
                if (arrayList2.get(i3).booleanValue()) {
                    calculatePopFragments(backStackRecord, sparseArray, z);
                } else {
                    calculateFragments(backStackRecord, sparseArray, z);
                }
            }
            if (sparseArray.size() != 0) {
                View view = new View(fragmentManagerImpl.mHost.getContext());
                int size = sparseArray.size();
                for (int i4 = 0; i4 < size; i4++) {
                    int keyAt = sparseArray.keyAt(i4);
                    ArrayMap<String, String> calculateNameOverrides = calculateNameOverrides(keyAt, arrayList, arrayList2, i, i2);
                    FragmentContainerTransition fragmentContainerTransition = (FragmentContainerTransition) sparseArray.valueAt(i4);
                    if (z) {
                        configureTransitionsOptimized(fragmentManagerImpl, keyAt, fragmentContainerTransition, view, calculateNameOverrides);
                    } else {
                        configureTransitionsUnoptimized(fragmentManagerImpl, keyAt, fragmentContainerTransition, view, calculateNameOverrides);
                    }
                }
            }
        }
    }

    private static ArrayMap<String, String> calculateNameOverrides(int i, ArrayList<BackStackRecord> arrayList, ArrayList<Boolean> arrayList2, int i2, int i3) {
        ArrayList<String> arrayList3;
        ArrayList<String> arrayList4;
        ArrayMap<String, String> arrayMap = new ArrayMap<>();
        for (int i4 = i3 - 1; i4 >= i2; i4--) {
            BackStackRecord backStackRecord = arrayList.get(i4);
            if (backStackRecord.interactsWith(i)) {
                boolean booleanValue = arrayList2.get(i4).booleanValue();
                if (backStackRecord.mSharedElementSourceNames != null) {
                    int size = backStackRecord.mSharedElementSourceNames.size();
                    if (booleanValue) {
                        arrayList3 = backStackRecord.mSharedElementSourceNames;
                        arrayList4 = backStackRecord.mSharedElementTargetNames;
                    } else {
                        ArrayList<String> arrayList5 = backStackRecord.mSharedElementSourceNames;
                        arrayList3 = backStackRecord.mSharedElementTargetNames;
                        arrayList4 = arrayList5;
                    }
                    for (int i5 = 0; i5 < size; i5++) {
                        String str = (String) arrayList4.get(i5);
                        String str2 = (String) arrayList3.get(i5);
                        String remove = arrayMap.remove(str2);
                        if (remove != null) {
                            arrayMap.put(str, remove);
                        } else {
                            arrayMap.put(str, str2);
                        }
                    }
                }
            }
        }
        return arrayMap;
    }

    private static void configureTransitionsOptimized(FragmentManagerImpl fragmentManagerImpl, int i, FragmentContainerTransition fragmentContainerTransition, View view, ArrayMap<String, String> arrayMap) {
        Object obj;
        FragmentManagerImpl fragmentManagerImpl2 = fragmentManagerImpl;
        FragmentContainerTransition fragmentContainerTransition2 = fragmentContainerTransition;
        View view2 = view;
        ViewGroup viewGroup = fragmentManagerImpl2.mContainer.onHasView() ? (ViewGroup) fragmentManagerImpl2.mContainer.onFindViewById(i) : null;
        if (viewGroup != null) {
            Fragment fragment = fragmentContainerTransition2.lastIn;
            Fragment fragment2 = fragmentContainerTransition2.firstOut;
            boolean z = fragmentContainerTransition2.lastInIsPop;
            boolean z2 = fragmentContainerTransition2.firstOutIsPop;
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            Object enterTransition = getEnterTransition(fragment, z);
            Object exitTransition = getExitTransition(fragment2, z2);
            Object obj2 = exitTransition;
            Object configureSharedElementsOptimized = configureSharedElementsOptimized(viewGroup, view, arrayMap, fragmentContainerTransition, arrayList2, arrayList, enterTransition, exitTransition);
            if (enterTransition == null && configureSharedElementsOptimized == null) {
                obj = obj2;
                if (obj == null) {
                    return;
                }
            } else {
                obj = obj2;
            }
            ArrayList<View> configureEnteringExitingViews = configureEnteringExitingViews(obj, fragment2, arrayList2, view2);
            ArrayList<View> configureEnteringExitingViews2 = configureEnteringExitingViews(enterTransition, fragment, arrayList, view2);
            setViewVisibility(configureEnteringExitingViews2, 4);
            Object mergeTransitions = mergeTransitions(enterTransition, obj, configureSharedElementsOptimized, fragment, z);
            if (mergeTransitions != null) {
                replaceHide(obj, fragment2, configureEnteringExitingViews);
                ArrayList<String> prepareSetNameOverridesOptimized = FragmentTransitionCompat21.prepareSetNameOverridesOptimized(arrayList);
                FragmentTransitionCompat21.scheduleRemoveTargets(mergeTransitions, enterTransition, configureEnteringExitingViews2, obj, configureEnteringExitingViews, configureSharedElementsOptimized, arrayList);
                FragmentTransitionCompat21.beginDelayedTransition(viewGroup, mergeTransitions);
                FragmentTransitionCompat21.setNameOverridesOptimized(viewGroup, arrayList2, arrayList, prepareSetNameOverridesOptimized, arrayMap);
                setViewVisibility(configureEnteringExitingViews2, 0);
                FragmentTransitionCompat21.swapSharedElementTargets(configureSharedElementsOptimized, arrayList2, arrayList);
            }
        }
    }

    private static void replaceHide(Object obj, Fragment fragment, final ArrayList<View> arrayList) {
        if (fragment != null && obj != null && fragment.mAdded && fragment.mHidden && fragment.mHiddenChanged) {
            fragment.setHideReplaced(true);
            FragmentTransitionCompat21.scheduleHideFragmentView(obj, fragment.getView(), arrayList);
            OneShotPreDrawListener.add(fragment.mContainer, new Runnable() {
                /* class android.support.v4.app.FragmentTransition.AnonymousClass1 */

                public final void run() {
                    FragmentTransition.setViewVisibility(arrayList, 4);
                }
            });
        }
    }

    private static void configureTransitionsUnoptimized(FragmentManagerImpl fragmentManagerImpl, int i, FragmentContainerTransition fragmentContainerTransition, View view, ArrayMap<String, String> arrayMap) {
        Object obj;
        FragmentManagerImpl fragmentManagerImpl2 = fragmentManagerImpl;
        FragmentContainerTransition fragmentContainerTransition2 = fragmentContainerTransition;
        View view2 = view;
        ArrayMap<String, String> arrayMap2 = arrayMap;
        ViewGroup viewGroup = fragmentManagerImpl2.mContainer.onHasView() ? (ViewGroup) fragmentManagerImpl2.mContainer.onFindViewById(i) : null;
        if (viewGroup != null) {
            Fragment fragment = fragmentContainerTransition2.lastIn;
            Fragment fragment2 = fragmentContainerTransition2.firstOut;
            boolean z = fragmentContainerTransition2.lastInIsPop;
            boolean z2 = fragmentContainerTransition2.firstOutIsPop;
            Object enterTransition = getEnterTransition(fragment, z);
            Object exitTransition = getExitTransition(fragment2, z2);
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = arrayList2;
            ArrayList arrayList4 = arrayList;
            Object obj2 = exitTransition;
            Object configureSharedElementsUnoptimized = configureSharedElementsUnoptimized(viewGroup, view, arrayMap, fragmentContainerTransition, arrayList, arrayList2, enterTransition, exitTransition);
            if (enterTransition == null && configureSharedElementsUnoptimized == null) {
                obj = obj2;
                if (obj == null) {
                    return;
                }
            } else {
                obj = obj2;
            }
            ArrayList<View> configureEnteringExitingViews = configureEnteringExitingViews(obj, fragment2, arrayList4, view2);
            Object obj3 = (configureEnteringExitingViews == null || configureEnteringExitingViews.isEmpty()) ? null : obj;
            FragmentTransitionCompat21.addTarget(enterTransition, view2);
            Object mergeTransitions = mergeTransitions(enterTransition, obj3, configureSharedElementsUnoptimized, fragment, fragmentContainerTransition2.lastInIsPop);
            if (mergeTransitions != null) {
                ArrayList arrayList5 = new ArrayList();
                FragmentTransitionCompat21.scheduleRemoveTargets(mergeTransitions, enterTransition, arrayList5, obj3, configureEnteringExitingViews, configureSharedElementsUnoptimized, arrayList3);
                scheduleTargetChange(viewGroup, fragment, view, arrayList3, enterTransition, arrayList5, obj3, configureEnteringExitingViews);
                ArrayList arrayList6 = arrayList3;
                FragmentTransitionCompat21.setNameOverridesUnoptimized(viewGroup, arrayList6, arrayMap2);
                FragmentTransitionCompat21.beginDelayedTransition(viewGroup, mergeTransitions);
                FragmentTransitionCompat21.scheduleNameReset(viewGroup, arrayList6, arrayMap2);
            }
        }
    }

    private static void scheduleTargetChange(ViewGroup viewGroup, Fragment fragment, View view, ArrayList<View> arrayList, Object obj, ArrayList<View> arrayList2, Object obj2, ArrayList<View> arrayList3) {
        final Object obj3 = obj;
        final View view2 = view;
        final Fragment fragment2 = fragment;
        final ArrayList<View> arrayList4 = arrayList;
        final ArrayList<View> arrayList5 = arrayList2;
        final ArrayList<View> arrayList6 = arrayList3;
        final Object obj4 = obj2;
        OneShotPreDrawListener.add(viewGroup, new Runnable() {
            /* class android.support.v4.app.FragmentTransition.AnonymousClass2 */

            public final void run() {
                Object obj = obj3;
                if (obj != null) {
                    FragmentTransitionCompat21.removeTarget(obj, view2);
                    arrayList5.addAll(FragmentTransition.configureEnteringExitingViews(obj3, fragment2, arrayList4, view2));
                }
                if (arrayList6 != null) {
                    if (obj4 != null) {
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(view2);
                        FragmentTransitionCompat21.replaceTargets(obj4, arrayList6, arrayList);
                    }
                    arrayList6.clear();
                    arrayList6.add(view2);
                }
            }
        });
    }

    private static Object getSharedElementTransition(Fragment fragment, Fragment fragment2, boolean z) {
        Object obj;
        if (fragment == null || fragment2 == null) {
            return null;
        }
        if (z) {
            obj = fragment2.getSharedElementReturnTransition();
        } else {
            obj = fragment.getSharedElementEnterTransition();
        }
        return FragmentTransitionCompat21.wrapTransitionInSet(FragmentTransitionCompat21.cloneTransition(obj));
    }

    private static Object getEnterTransition(Fragment fragment, boolean z) {
        Object obj;
        if (fragment == null) {
            return null;
        }
        if (z) {
            obj = fragment.getReenterTransition();
        } else {
            obj = fragment.getEnterTransition();
        }
        return FragmentTransitionCompat21.cloneTransition(obj);
    }

    private static Object getExitTransition(Fragment fragment, boolean z) {
        Object obj;
        if (fragment == null) {
            return null;
        }
        if (z) {
            obj = fragment.getReturnTransition();
        } else {
            obj = fragment.getExitTransition();
        }
        return FragmentTransitionCompat21.cloneTransition(obj);
    }

    private static Object configureSharedElementsOptimized(ViewGroup viewGroup, View view, ArrayMap<String, String> arrayMap, FragmentContainerTransition fragmentContainerTransition, ArrayList<View> arrayList, ArrayList<View> arrayList2, Object obj, Object obj2) {
        Object obj3;
        final Rect rect;
        final View view2;
        Fragment fragment = fragmentContainerTransition.lastIn;
        Fragment fragment2 = fragmentContainerTransition.firstOut;
        if (fragment != null) {
            fragment.getView().setVisibility(0);
        }
        if (fragment == null || fragment2 == null) {
            return null;
        }
        boolean z = fragmentContainerTransition.lastInIsPop;
        if (arrayMap.isEmpty()) {
            obj3 = null;
        } else {
            obj3 = getSharedElementTransition(fragment, fragment2, z);
        }
        ArrayMap<String, View> captureOutSharedElements = captureOutSharedElements(arrayMap, obj3, fragmentContainerTransition);
        ArrayMap<String, View> captureInSharedElements = captureInSharedElements(arrayMap, obj3, fragmentContainerTransition);
        if (arrayMap.isEmpty()) {
            if (captureOutSharedElements != null) {
                captureOutSharedElements.clear();
            }
            if (captureInSharedElements != null) {
                captureInSharedElements.clear();
            }
            obj3 = null;
        } else {
            addSharedElementsWithMatchingNames(arrayList, captureOutSharedElements, arrayMap.keySet());
            addSharedElementsWithMatchingNames(arrayList2, captureInSharedElements, arrayMap.values());
        }
        if (obj == null && obj2 == null && obj3 == null) {
            return null;
        }
        callSharedElementStartEnd(fragment, fragment2, z, captureOutSharedElements, true);
        if (obj3 != null) {
            arrayList2.add(view);
            FragmentTransitionCompat21.setSharedElementTargets(obj3, view, arrayList);
            setOutEpicenter(obj3, obj2, captureOutSharedElements, fragmentContainerTransition.firstOutIsPop, fragmentContainerTransition.firstOutTransaction);
            Rect rect2 = new Rect();
            View inEpicenterView = getInEpicenterView(captureInSharedElements, fragmentContainerTransition, obj, z);
            if (inEpicenterView != null) {
                FragmentTransitionCompat21.setEpicenter(obj, rect2);
            }
            rect = rect2;
            view2 = inEpicenterView;
        } else {
            view2 = null;
            rect = null;
        }
        final Fragment fragment3 = fragment;
        final Fragment fragment4 = fragment2;
        final boolean z2 = z;
        final ArrayMap<String, View> arrayMap2 = captureInSharedElements;
        OneShotPreDrawListener.add(viewGroup, new Runnable() {
            /* class android.support.v4.app.FragmentTransition.AnonymousClass3 */

            public final void run() {
                FragmentTransition.callSharedElementStartEnd(fragment3, fragment4, z2, arrayMap2, false);
                View view = view2;
                if (view != null) {
                    FragmentTransitionCompat21.getBoundsOnScreen(view, rect);
                }
            }
        });
        return obj3;
    }

    private static void addSharedElementsWithMatchingNames(ArrayList<View> arrayList, ArrayMap<String, View> arrayMap, Collection<String> collection) {
        for (int size = arrayMap.size() - 1; size >= 0; size--) {
            View valueAt = arrayMap.valueAt(size);
            if (collection.contains(ViewCompat.getTransitionName(valueAt))) {
                arrayList.add(valueAt);
            }
        }
    }

    private static Object configureSharedElementsUnoptimized(ViewGroup viewGroup, View view, ArrayMap<String, String> arrayMap, FragmentContainerTransition fragmentContainerTransition, ArrayList<View> arrayList, ArrayList<View> arrayList2, Object obj, Object obj2) {
        Object obj3;
        ArrayMap<String, String> arrayMap2;
        Object obj4;
        FragmentContainerTransition fragmentContainerTransition2 = fragmentContainerTransition;
        ArrayList<View> arrayList3 = arrayList;
        Object obj5 = obj;
        Object obj6 = obj2;
        final Fragment fragment = fragmentContainerTransition2.lastIn;
        final Fragment fragment2 = fragmentContainerTransition2.firstOut;
        Rect rect = null;
        if (fragment == null || fragment2 == null) {
            return null;
        }
        final boolean z = fragmentContainerTransition2.lastInIsPop;
        if (arrayMap.isEmpty()) {
            arrayMap2 = arrayMap;
            obj3 = null;
        } else {
            obj3 = getSharedElementTransition(fragment, fragment2, z);
            arrayMap2 = arrayMap;
        }
        ArrayMap<String, View> captureOutSharedElements = captureOutSharedElements(arrayMap2, obj3, fragmentContainerTransition2);
        if (arrayMap.isEmpty()) {
            obj4 = null;
        } else {
            arrayList3.addAll(captureOutSharedElements.values());
            obj4 = obj3;
        }
        if (obj5 == null && obj6 == null && obj4 == null) {
            return null;
        }
        callSharedElementStartEnd(fragment, fragment2, z, captureOutSharedElements, true);
        if (obj4 != null) {
            rect = new Rect();
            FragmentTransitionCompat21.setSharedElementTargets(obj4, view, arrayList3);
            setOutEpicenter(obj4, obj6, captureOutSharedElements, fragmentContainerTransition2.firstOutIsPop, fragmentContainerTransition2.firstOutTransaction);
            if (obj5 != null) {
                FragmentTransitionCompat21.setEpicenter(obj5, rect);
            }
        }
        Rect rect2 = rect;
        final ArrayMap<String, String> arrayMap3 = arrayMap;
        final Object obj7 = obj4;
        final FragmentContainerTransition fragmentContainerTransition3 = fragmentContainerTransition;
        final ArrayList<View> arrayList4 = arrayList2;
        final View view2 = view;
        final ArrayList<View> arrayList5 = arrayList;
        final Object obj8 = obj;
        final Rect rect3 = rect2;
        OneShotPreDrawListener.add(viewGroup, new Runnable() {
            /* class android.support.v4.app.FragmentTransition.AnonymousClass4 */

            public final void run() {
                ArrayMap<String, View> captureInSharedElements = FragmentTransition.captureInSharedElements(arrayMap3, obj7, fragmentContainerTransition3);
                if (captureInSharedElements != null) {
                    arrayList4.addAll(captureInSharedElements.values());
                    arrayList4.add(view2);
                }
                FragmentTransition.callSharedElementStartEnd(fragment, fragment2, z, captureInSharedElements, false);
                Object obj = obj7;
                if (obj != null) {
                    FragmentTransitionCompat21.swapSharedElementTargets(obj, arrayList5, arrayList4);
                    View inEpicenterView = FragmentTransition.getInEpicenterView(captureInSharedElements, fragmentContainerTransition3, obj8, z);
                    if (inEpicenterView != null) {
                        FragmentTransitionCompat21.getBoundsOnScreen(inEpicenterView, rect3);
                    }
                }
            }
        });
        return obj4;
    }

    private static ArrayMap<String, View> captureOutSharedElements(ArrayMap<String, String> arrayMap, Object obj, FragmentContainerTransition fragmentContainerTransition) {
        ArrayList<String> arrayList;
        SharedElementCallback sharedElementCallback;
        if (arrayMap.isEmpty() || obj == null) {
            arrayMap.clear();
            return null;
        }
        Fragment fragment = fragmentContainerTransition.firstOut;
        ArrayMap<String, View> arrayMap2 = new ArrayMap<>();
        FragmentTransitionCompat21.findNamedViews(arrayMap2, fragment.getView());
        BackStackRecord backStackRecord = fragmentContainerTransition.firstOutTransaction;
        if (fragmentContainerTransition.firstOutIsPop) {
            sharedElementCallback = fragment.getEnterTransitionCallback();
            arrayList = backStackRecord.mSharedElementTargetNames;
        } else {
            sharedElementCallback = fragment.getExitTransitionCallback();
            arrayList = backStackRecord.mSharedElementSourceNames;
        }
        arrayMap2.retainAll(arrayList);
        if (sharedElementCallback != null) {
            sharedElementCallback.onMapSharedElements(arrayList, arrayMap2);
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                String str = (String) arrayList.get(size);
                View view = arrayMap2.get(str);
                if (view == null) {
                    arrayMap.remove(str);
                } else if (!str.equals(ViewCompat.getTransitionName(view))) {
                    arrayMap.put(ViewCompat.getTransitionName(view), arrayMap.remove(str));
                }
            }
        } else {
            arrayMap.retainAll(arrayMap2.keySet());
        }
        return arrayMap2;
    }

    public static ArrayMap<String, View> captureInSharedElements(ArrayMap<String, String> arrayMap, Object obj, FragmentContainerTransition fragmentContainerTransition) {
        SharedElementCallback sharedElementCallback;
        ArrayList<String> arrayList;
        String findKeyForValue;
        Fragment fragment = fragmentContainerTransition.lastIn;
        View view = fragment.getView();
        if (arrayMap.isEmpty() || obj == null || view == null) {
            arrayMap.clear();
            return null;
        }
        ArrayMap<String, View> arrayMap2 = new ArrayMap<>();
        FragmentTransitionCompat21.findNamedViews(arrayMap2, view);
        BackStackRecord backStackRecord = fragmentContainerTransition.lastInTransaction;
        if (fragmentContainerTransition.lastInIsPop) {
            sharedElementCallback = fragment.getExitTransitionCallback();
            arrayList = backStackRecord.mSharedElementSourceNames;
        } else {
            sharedElementCallback = fragment.getEnterTransitionCallback();
            arrayList = backStackRecord.mSharedElementTargetNames;
        }
        if (arrayList != null) {
            arrayMap2.retainAll(arrayList);
        }
        if (sharedElementCallback != null) {
            sharedElementCallback.onMapSharedElements(arrayList, arrayMap2);
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                String str = (String) arrayList.get(size);
                View view2 = arrayMap2.get(str);
                if (view2 == null) {
                    String findKeyForValue2 = findKeyForValue(arrayMap, str);
                    if (findKeyForValue2 != null) {
                        arrayMap.remove(findKeyForValue2);
                    }
                } else if (!str.equals(ViewCompat.getTransitionName(view2)) && (findKeyForValue = findKeyForValue(arrayMap, str)) != null) {
                    arrayMap.put(findKeyForValue, ViewCompat.getTransitionName(view2));
                }
            }
        } else {
            retainValues(arrayMap, arrayMap2);
        }
        return arrayMap2;
    }

    private static String findKeyForValue(ArrayMap<String, String> arrayMap, String str) {
        int size = arrayMap.size();
        for (int i = 0; i < size; i++) {
            if (str.equals(arrayMap.valueAt(i))) {
                return arrayMap.keyAt(i);
            }
        }
        return null;
    }

    public static View getInEpicenterView(ArrayMap<String, View> arrayMap, FragmentContainerTransition fragmentContainerTransition, Object obj, boolean z) {
        String str;
        BackStackRecord backStackRecord = fragmentContainerTransition.lastInTransaction;
        if (obj == null || arrayMap == null || backStackRecord.mSharedElementSourceNames == null || backStackRecord.mSharedElementSourceNames.isEmpty()) {
            return null;
        }
        if (z) {
            str = backStackRecord.mSharedElementSourceNames.get(0);
        } else {
            str = backStackRecord.mSharedElementTargetNames.get(0);
        }
        return arrayMap.get(str);
    }

    private static void setOutEpicenter(Object obj, Object obj2, ArrayMap<String, View> arrayMap, boolean z, BackStackRecord backStackRecord) {
        String str;
        if (backStackRecord.mSharedElementSourceNames != null && !backStackRecord.mSharedElementSourceNames.isEmpty()) {
            if (z) {
                str = backStackRecord.mSharedElementTargetNames.get(0);
            } else {
                str = backStackRecord.mSharedElementSourceNames.get(0);
            }
            View view = arrayMap.get(str);
            FragmentTransitionCompat21.setEpicenter(obj, view);
            if (obj2 != null) {
                FragmentTransitionCompat21.setEpicenter(obj2, view);
            }
        }
    }

    private static void retainValues(ArrayMap<String, String> arrayMap, ArrayMap<String, View> arrayMap2) {
        for (int size = arrayMap.size() - 1; size >= 0; size--) {
            if (!arrayMap2.containsKey(arrayMap.valueAt(size))) {
                arrayMap.removeAt(size);
            }
        }
    }

    public static void callSharedElementStartEnd(Fragment fragment, Fragment fragment2, boolean z, ArrayMap<String, View> arrayMap, boolean z2) {
        SharedElementCallback sharedElementCallback;
        int i;
        if (z) {
            sharedElementCallback = fragment2.getEnterTransitionCallback();
        } else {
            sharedElementCallback = fragment.getEnterTransitionCallback();
        }
        if (sharedElementCallback != null) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            if (arrayMap == null) {
                i = 0;
            } else {
                i = arrayMap.size();
            }
            for (int i2 = 0; i2 < i; i2++) {
                arrayList2.add(arrayMap.keyAt(i2));
                arrayList.add(arrayMap.valueAt(i2));
            }
            if (z2) {
                sharedElementCallback.onSharedElementStart(arrayList2, arrayList, null);
            } else {
                sharedElementCallback.onSharedElementEnd(arrayList2, arrayList, null);
            }
        }
    }

    public static ArrayList<View> configureEnteringExitingViews(Object obj, Fragment fragment, ArrayList<View> arrayList, View view) {
        if (obj == null) {
            return null;
        }
        ArrayList<View> arrayList2 = new ArrayList<>();
        View view2 = fragment.getView();
        if (view2 != null) {
            FragmentTransitionCompat21.captureTransitioningViews(arrayList2, view2);
        }
        if (arrayList != null) {
            arrayList2.removeAll(arrayList);
        }
        if (arrayList2.isEmpty()) {
            return arrayList2;
        }
        arrayList2.add(view);
        FragmentTransitionCompat21.addTargets(obj, arrayList2);
        return arrayList2;
    }

    public static void setViewVisibility(ArrayList<View> arrayList, int i) {
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                arrayList.get(size).setVisibility(i);
            }
        }
    }

    private static Object mergeTransitions(Object obj, Object obj2, Object obj3, Fragment fragment, boolean z) {
        boolean z2;
        if (obj == null || obj2 == null || fragment == null) {
            z2 = true;
        } else {
            z2 = z ? fragment.getAllowReturnTransitionOverlap() : fragment.getAllowEnterTransitionOverlap();
        }
        if (z2) {
            return FragmentTransitionCompat21.mergeTransitionsTogether(obj2, obj, obj3);
        }
        return FragmentTransitionCompat21.mergeTransitionsInSequence(obj2, obj, obj3);
    }

    public static void calculateFragments(BackStackRecord backStackRecord, SparseArray<FragmentContainerTransition> sparseArray, boolean z) {
        int size = backStackRecord.mOps.size();
        for (int i = 0; i < size; i++) {
            addToFirstInLastOut(backStackRecord, backStackRecord.mOps.get(i), sparseArray, false, z);
        }
    }

    public static void calculatePopFragments(BackStackRecord backStackRecord, SparseArray<FragmentContainerTransition> sparseArray, boolean z) {
        if (backStackRecord.mManager.mContainer.onHasView()) {
            for (int size = backStackRecord.mOps.size() - 1; size >= 0; size--) {
                addToFirstInLastOut(backStackRecord, backStackRecord.mOps.get(size), sparseArray, true, z);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0036, code lost:
        if (r6.mAdded != false) goto L_0x008b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x006d, code lost:
        r12 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x0089, code lost:
        if (r6.mHidden == false) goto L_0x008b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x008b, code lost:
        r12 = true;
     */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x0099  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x00de A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:93:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    private static void addToFirstInLastOut(BackStackRecord backStackRecord, BackStackRecord.Op op, SparseArray<FragmentContainerTransition> sparseArray, boolean z, boolean z2) {
        boolean z3;
        boolean z4;
        FragmentContainerTransition fragmentContainerTransition;
        FragmentManagerImpl fragmentManagerImpl;
        boolean z5;
        Fragment fragment = op.fragment;
        int i = fragment.mContainerId;
        if (i != 0) {
            int i2 = z ? INVERSE_OPS[op.cmd] : op.cmd;
            boolean z6 = false;
            boolean z7 = true;
            if (i2 != 1) {
                if (i2 != 3) {
                    if (i2 != 4) {
                        if (i2 != 5) {
                            if (i2 != 6) {
                                if (i2 != 7) {
                                    z3 = false;
                                    z7 = false;
                                    z4 = false;
                                    FragmentContainerTransition fragmentContainerTransition2 = sparseArray.get(i);
                                    if (z6) {
                                        fragmentContainerTransition2 = ensureContainer(fragmentContainerTransition2, sparseArray, i);
                                        fragmentContainerTransition2.lastIn = fragment;
                                        fragmentContainerTransition2.lastInIsPop = z;
                                        fragmentContainerTransition2.lastInTransaction = backStackRecord;
                                    }
                                    fragmentContainerTransition = fragmentContainerTransition2;
                                    if (!z2 && z7) {
                                        if (fragmentContainerTransition != null && fragmentContainerTransition.firstOut == fragment) {
                                            fragmentContainerTransition.firstOut = null;
                                        }
                                        fragmentManagerImpl = backStackRecord.mManager;
                                        if (fragment.mState <= 0 && fragmentManagerImpl.mCurState > 0 && !backStackRecord.mAllowOptimization) {
                                            fragmentManagerImpl.makeActive(fragment);
                                            fragmentManagerImpl.moveToState(fragment, 1, 0, 0, false);
                                        }
                                    }
                                    if (z4 && (fragmentContainerTransition == null || fragmentContainerTransition.firstOut == null)) {
                                        fragmentContainerTransition = ensureContainer(fragmentContainerTransition, sparseArray, i);
                                        fragmentContainerTransition.firstOut = fragment;
                                        fragmentContainerTransition.firstOutIsPop = z;
                                        fragmentContainerTransition.firstOutTransaction = backStackRecord;
                                    }
                                    if (z2 && z3 && fragmentContainerTransition != null && fragmentContainerTransition.lastIn == fragment) {
                                        fragmentContainerTransition.lastIn = null;
                                        return;
                                    }
                                    return;
                                }
                            }
                        } else if (z2) {
                            if (fragment.mHiddenChanged) {
                                if (!fragment.mHidden) {
                                }
                            }
                            z5 = false;
                            z6 = z5;
                            z3 = false;
                            z4 = false;
                            FragmentContainerTransition fragmentContainerTransition22 = sparseArray.get(i);
                            if (z6) {
                            }
                            fragmentContainerTransition = fragmentContainerTransition22;
                            fragmentContainerTransition.firstOut = null;
                            fragmentManagerImpl = backStackRecord.mManager;
                            fragmentManagerImpl.makeActive(fragment);
                            fragmentManagerImpl.moveToState(fragment, 1, 0, 0, false);
                            fragmentContainerTransition = ensureContainer(fragmentContainerTransition, sparseArray, i);
                            fragmentContainerTransition.firstOut = fragment;
                            fragmentContainerTransition.firstOutIsPop = z;
                            fragmentContainerTransition.firstOutTransaction = backStackRecord;
                            if (z2) {
                                return;
                            }
                            return;
                        } else {
                            z5 = fragment.mHidden;
                            z6 = z5;
                            z3 = false;
                            z4 = false;
                            FragmentContainerTransition fragmentContainerTransition222 = sparseArray.get(i);
                            if (z6) {
                            }
                            fragmentContainerTransition = fragmentContainerTransition222;
                            fragmentContainerTransition.firstOut = null;
                            fragmentManagerImpl = backStackRecord.mManager;
                            fragmentManagerImpl.makeActive(fragment);
                            fragmentManagerImpl.moveToState(fragment, 1, 0, 0, false);
                            fragmentContainerTransition = ensureContainer(fragmentContainerTransition, sparseArray, i);
                            fragmentContainerTransition.firstOut = fragment;
                            fragmentContainerTransition.firstOutIsPop = z;
                            fragmentContainerTransition.firstOutTransaction = backStackRecord;
                            if (z2) {
                            }
                        }
                    } else if (!z2) {
                        boolean z8 = false;
                        z4 = z8;
                        z3 = true;
                        z7 = false;
                        FragmentContainerTransition fragmentContainerTransition2222 = sparseArray.get(i);
                        if (z6) {
                        }
                        fragmentContainerTransition = fragmentContainerTransition2222;
                        fragmentContainerTransition.firstOut = null;
                        fragmentManagerImpl = backStackRecord.mManager;
                        fragmentManagerImpl.makeActive(fragment);
                        fragmentManagerImpl.moveToState(fragment, 1, 0, 0, false);
                        fragmentContainerTransition = ensureContainer(fragmentContainerTransition, sparseArray, i);
                        fragmentContainerTransition.firstOut = fragment;
                        fragmentContainerTransition.firstOutIsPop = z;
                        fragmentContainerTransition.firstOutTransaction = backStackRecord;
                        if (z2) {
                        }
                    } else {
                        boolean z82 = false;
                        z4 = z82;
                        z3 = true;
                        z7 = false;
                        FragmentContainerTransition fragmentContainerTransition22222 = sparseArray.get(i);
                        if (z6) {
                        }
                        fragmentContainerTransition = fragmentContainerTransition22222;
                        fragmentContainerTransition.firstOut = null;
                        fragmentManagerImpl = backStackRecord.mManager;
                        fragmentManagerImpl.makeActive(fragment);
                        fragmentManagerImpl.moveToState(fragment, 1, 0, 0, false);
                        fragmentContainerTransition = ensureContainer(fragmentContainerTransition, sparseArray, i);
                        fragmentContainerTransition.firstOut = fragment;
                        fragmentContainerTransition.firstOutIsPop = z;
                        fragmentContainerTransition.firstOutTransaction = backStackRecord;
                        if (z2) {
                        }
                    }
                }
                if (!z2) {
                    boolean z822 = false;
                    z4 = z822;
                    z3 = true;
                    z7 = false;
                    FragmentContainerTransition fragmentContainerTransition222222 = sparseArray.get(i);
                    if (z6) {
                    }
                    fragmentContainerTransition = fragmentContainerTransition222222;
                    fragmentContainerTransition.firstOut = null;
                    fragmentManagerImpl = backStackRecord.mManager;
                    fragmentManagerImpl.makeActive(fragment);
                    fragmentManagerImpl.moveToState(fragment, 1, 0, 0, false);
                    fragmentContainerTransition = ensureContainer(fragmentContainerTransition, sparseArray, i);
                    fragmentContainerTransition.firstOut = fragment;
                    fragmentContainerTransition.firstOutIsPop = z;
                    fragmentContainerTransition.firstOutTransaction = backStackRecord;
                    if (z2) {
                    }
                } else {
                    boolean z8222 = false;
                    z4 = z8222;
                    z3 = true;
                    z7 = false;
                    FragmentContainerTransition fragmentContainerTransition2222222 = sparseArray.get(i);
                    if (z6) {
                    }
                    fragmentContainerTransition = fragmentContainerTransition2222222;
                    fragmentContainerTransition.firstOut = null;
                    fragmentManagerImpl = backStackRecord.mManager;
                    fragmentManagerImpl.makeActive(fragment);
                    fragmentManagerImpl.moveToState(fragment, 1, 0, 0, false);
                    fragmentContainerTransition = ensureContainer(fragmentContainerTransition, sparseArray, i);
                    fragmentContainerTransition.firstOut = fragment;
                    fragmentContainerTransition.firstOutIsPop = z;
                    fragmentContainerTransition.firstOutTransaction = backStackRecord;
                    if (z2) {
                    }
                }
            }
            if (z2) {
                z5 = fragment.mIsNewlyAdded;
                z6 = z5;
                z3 = false;
                z4 = false;
                FragmentContainerTransition fragmentContainerTransition22222222 = sparseArray.get(i);
                if (z6) {
                }
                fragmentContainerTransition = fragmentContainerTransition22222222;
                fragmentContainerTransition.firstOut = null;
                fragmentManagerImpl = backStackRecord.mManager;
                fragmentManagerImpl.makeActive(fragment);
                fragmentManagerImpl.moveToState(fragment, 1, 0, 0, false);
                fragmentContainerTransition = ensureContainer(fragmentContainerTransition, sparseArray, i);
                fragmentContainerTransition.firstOut = fragment;
                fragmentContainerTransition.firstOutIsPop = z;
                fragmentContainerTransition.firstOutTransaction = backStackRecord;
                if (z2) {
                }
            } else {
                if (!fragment.mAdded) {
                }
                z5 = false;
                z6 = z5;
                z3 = false;
                z4 = false;
                FragmentContainerTransition fragmentContainerTransition222222222 = sparseArray.get(i);
                if (z6) {
                }
                fragmentContainerTransition = fragmentContainerTransition222222222;
                fragmentContainerTransition.firstOut = null;
                fragmentManagerImpl = backStackRecord.mManager;
                fragmentManagerImpl.makeActive(fragment);
                fragmentManagerImpl.moveToState(fragment, 1, 0, 0, false);
                fragmentContainerTransition = ensureContainer(fragmentContainerTransition, sparseArray, i);
                fragmentContainerTransition.firstOut = fragment;
                fragmentContainerTransition.firstOutIsPop = z;
                fragmentContainerTransition.firstOutTransaction = backStackRecord;
                if (z2) {
                }
            }
        }
    }

    private static FragmentContainerTransition ensureContainer(FragmentContainerTransition fragmentContainerTransition, SparseArray<FragmentContainerTransition> sparseArray, int i) {
        if (fragmentContainerTransition != null) {
            return fragmentContainerTransition;
        }
        FragmentContainerTransition fragmentContainerTransition2 = new FragmentContainerTransition();
        sparseArray.put(i, fragmentContainerTransition2);
        return fragmentContainerTransition2;
    }

    static class FragmentContainerTransition {
        public Fragment firstOut;
        public boolean firstOutIsPop;
        public BackStackRecord firstOutTransaction;
        public Fragment lastIn;
        public boolean lastInIsPop;
        public BackStackRecord lastInTransaction;

        FragmentContainerTransition() {
        }
    }
}
