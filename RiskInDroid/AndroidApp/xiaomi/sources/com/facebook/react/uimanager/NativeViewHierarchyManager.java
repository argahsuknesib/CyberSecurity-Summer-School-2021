package com.facebook.react.uimanager;

import android.content.res.Resources;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.PopupMenu;
import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.SoftAssertions;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.config.ReactFeatureFlags;
import com.facebook.react.touch.JSResponderHandler;
import com.facebook.react.uimanager.layoutanimation.LayoutAnimationController;
import com.facebook.react.uimanager.layoutanimation.LayoutAnimationListener;
import com.facebook.systrace.Systrace;
import com.facebook.systrace.SystraceMessage;
import com.xiaomi.smarthome.R;
import java.util.Arrays;

public class NativeViewHierarchyManager {
    private static final String TAG = "NativeViewHierarchyManager";
    private final RectF mBoundingBox;
    private final int[] mDroppedViewArray;
    private int mDroppedViewIndex;
    private final JSResponderHandler mJSResponderHandler;
    private boolean mLayoutAnimationEnabled;
    private final LayoutAnimationController mLayoutAnimator;
    private PopupMenu mPopupMenu;
    private final SparseBooleanArray mRootTags;
    private final RootViewManager mRootViewManager;
    private final SparseArray<SparseIntArray> mTagsToPendingIndicesToDelete;
    private final SparseArray<ViewManager> mTagsToViewManagers;
    private final SparseArray<View> mTagsToViews;
    private final ViewManagerRegistry mViewManagers;

    public NativeViewHierarchyManager(ViewManagerRegistry viewManagerRegistry) {
        this(viewManagerRegistry, new RootViewManager());
    }

    public NativeViewHierarchyManager(ViewManagerRegistry viewManagerRegistry, RootViewManager rootViewManager) {
        this.mJSResponderHandler = new JSResponderHandler();
        this.mLayoutAnimator = new LayoutAnimationController();
        this.mTagsToPendingIndicesToDelete = new SparseArray<>();
        this.mDroppedViewArray = new int[100];
        this.mBoundingBox = new RectF();
        this.mDroppedViewIndex = 0;
        this.mViewManagers = viewManagerRegistry;
        this.mTagsToViews = new SparseArray<>();
        this.mTagsToViewManagers = new SparseArray<>();
        this.mRootTags = new SparseBooleanArray();
        this.mRootViewManager = rootViewManager;
    }

    public final synchronized View resolveView(int i) {
        View view;
        view = this.mTagsToViews.get(i);
        if (view == null) {
            throw new IllegalViewOperationException("Trying to resolve view with tag " + i + " which doesn't exist");
        }
        return view;
    }

    public final synchronized ViewManager resolveViewManager(int i) {
        ViewManager viewManager;
        viewManager = this.mTagsToViewManagers.get(i);
        if (viewManager == null) {
            boolean contains = Arrays.asList(this.mDroppedViewArray).contains(Integer.valueOf(i));
            throw new IllegalViewOperationException("ViewManager for tag " + i + " could not be found.\n View already dropped? " + contains + ".\nLast index " + this.mDroppedViewIndex + " in last 100 views" + this.mDroppedViewArray.toString());
        }
        return viewManager;
    }

    public void setLayoutAnimationEnabled(boolean z) {
        this.mLayoutAnimationEnabled = z;
    }

    public synchronized void updateInstanceHandle(int i, long j) {
        UiThreadUtil.assertOnUiThread();
        try {
            updateInstanceHandle(resolveView(i), j);
        } catch (IllegalViewOperationException e) {
            FLog.e(TAG, "Unable to update properties for view tag ".concat(String.valueOf(i)), e);
        }
    }

    public synchronized void updateProperties(int i, ReactStylesDiffMap reactStylesDiffMap) {
        UiThreadUtil.assertOnUiThread();
        try {
            ViewManager resolveViewManager = resolveViewManager(i);
            View resolveView = resolveView(i);
            if (reactStylesDiffMap != null) {
                resolveViewManager.updateProperties(resolveView, reactStylesDiffMap);
            }
        } catch (IllegalViewOperationException e) {
            FLog.e(TAG, "Unable to update properties for view tag ".concat(String.valueOf(i)), e);
        }
    }

    public synchronized void updateViewExtraData(int i, Object obj) {
        UiThreadUtil.assertOnUiThread();
        resolveViewManager(i).updateExtraData(resolveView(i), obj);
    }

    public synchronized void updateLayout(int i, int i2, int i3, int i4, int i5, int i6) {
        UiThreadUtil.assertOnUiThread();
        SystraceMessage.beginSection(0, "NativeViewHierarchyManager_updateLayout").arg("parentTag", i).arg("tag", i2).flush();
        try {
            View resolveView = resolveView(i2);
            resolveView.measure(View.MeasureSpec.makeMeasureSpec(i5, 1073741824), View.MeasureSpec.makeMeasureSpec(i6, 1073741824));
            ViewParent parent = resolveView.getParent();
            if (parent instanceof RootView) {
                parent.requestLayout();
            }
            if (!this.mRootTags.get(i)) {
                ViewManager viewManager = this.mTagsToViewManagers.get(i);
                if (viewManager instanceof IViewManagerWithChildren) {
                    IViewManagerWithChildren iViewManagerWithChildren = (IViewManagerWithChildren) viewManager;
                    if (iViewManagerWithChildren != null && !iViewManagerWithChildren.needsCustomLayoutForChildren()) {
                        updateLayout(resolveView, i3, i4, i5, i6);
                    }
                } else {
                    throw new IllegalViewOperationException("Trying to use view with tag " + i + " as a parent, but its Manager doesn't implement IViewManagerWithChildren");
                }
            } else {
                updateLayout(resolveView, i3, i4, i5, i6);
            }
        } finally {
            Systrace.endSection(0);
        }
    }

    private void updateInstanceHandle(View view, long j) {
        UiThreadUtil.assertOnUiThread();
        view.setTag(R.id.view_tag_instance_handle, Long.valueOf(j));
    }

    public long getInstanceHandle(int i) {
        View view = this.mTagsToViews.get(i);
        if (view != null) {
            Long l = (Long) view.getTag(R.id.view_tag_instance_handle);
            if (l != null) {
                return l.longValue();
            }
            throw new IllegalViewOperationException("Unable to find instanceHandle for tag: ".concat(String.valueOf(i)));
        }
        throw new IllegalViewOperationException("Unable to find view for tag: ".concat(String.valueOf(i)));
    }

    private void updateLayout(View view, int i, int i2, int i3, int i4) {
        if (!this.mLayoutAnimationEnabled || !this.mLayoutAnimator.shouldAnimateLayout(view)) {
            view.layout(i, i2, i3 + i, i4 + i2);
        } else {
            this.mLayoutAnimator.applyLayoutUpdate(view, i, i2, i3, i4);
        }
    }

    public synchronized void createView(ThemedReactContext themedReactContext, int i, String str, ReactStylesDiffMap reactStylesDiffMap) {
        UiThreadUtil.assertOnUiThread();
        SystraceMessage.beginSection(0, "NativeViewHierarchyManager_createView").arg("tag", i).arg("className", str).flush();
        try {
            ViewManager viewManager = this.mViewManagers.get(str);
            View createView = viewManager.createView(themedReactContext, null, null, this.mJSResponderHandler);
            this.mTagsToViews.put(i, createView);
            this.mTagsToViewManagers.put(i, viewManager);
            createView.setId(i);
            if (reactStylesDiffMap != null) {
                viewManager.updateProperties(createView, reactStylesDiffMap);
            }
        } finally {
            Systrace.endSection(0);
        }
    }

    private static String constructManageChildrenErrorMessage(ViewGroup viewGroup, ViewGroupManager viewGroupManager, int[] iArr, ViewAtIndex[] viewAtIndexArr, int[] iArr2) {
        StringBuilder sb = new StringBuilder();
        if (viewGroup != null) {
            sb.append("View tag:" + viewGroup.getId() + "\n");
            sb.append("  children(" + viewGroupManager.getChildCount(viewGroup) + "): [\n");
            for (int i = 0; i < viewGroupManager.getChildCount(viewGroup); i += 16) {
                int i2 = 0;
                while (true) {
                    int i3 = i + i2;
                    if (i3 >= viewGroupManager.getChildCount(viewGroup) || i2 >= 16) {
                        sb.append("\n");
                    } else {
                        sb.append(viewGroupManager.getChildAt(viewGroup, i3).getId() + ",");
                        i2++;
                    }
                }
                sb.append("\n");
            }
            sb.append(" ],\n");
        }
        if (iArr != null) {
            sb.append("  indicesToRemove(" + iArr.length + "): [\n");
            for (int i4 = 0; i4 < iArr.length; i4 += 16) {
                int i5 = 0;
                while (true) {
                    int i6 = i4 + i5;
                    if (i6 >= iArr.length || i5 >= 16) {
                        sb.append("\n");
                    } else {
                        sb.append(iArr[i6] + ",");
                        i5++;
                    }
                }
                sb.append("\n");
            }
            sb.append(" ],\n");
        }
        if (viewAtIndexArr != null) {
            sb.append("  viewsToAdd(" + viewAtIndexArr.length + "): [\n");
            for (int i7 = 0; i7 < viewAtIndexArr.length; i7 += 16) {
                int i8 = 0;
                while (true) {
                    int i9 = i7 + i8;
                    if (i9 >= viewAtIndexArr.length || i8 >= 16) {
                        sb.append("\n");
                    } else {
                        sb.append("[" + viewAtIndexArr[i9].mIndex + "," + viewAtIndexArr[i9].mTag + "],");
                        i8++;
                    }
                }
                sb.append("\n");
            }
            sb.append(" ],\n");
        }
        if (iArr2 != null) {
            sb.append("  tagsToDelete(" + iArr2.length + "): [\n");
            for (int i10 = 0; i10 < iArr2.length; i10 += 16) {
                int i11 = 0;
                while (true) {
                    int i12 = i10 + i11;
                    if (i12 >= iArr2.length || i11 >= 16) {
                        sb.append("\n");
                    } else {
                        sb.append(iArr2[i12] + ",");
                        i11++;
                    }
                }
                sb.append("\n");
            }
            sb.append(" ]\n");
        }
        return sb.toString();
    }

    private int normalizeIndex(int i, SparseIntArray sparseIntArray) {
        int i2 = i;
        for (int i3 = 0; i3 <= i; i3++) {
            i2 += sparseIntArray.get(i3);
        }
        return i2;
    }

    private SparseIntArray getOrCreatePendingIndicesToDelete(int i) {
        SparseIntArray sparseIntArray = this.mTagsToPendingIndicesToDelete.get(i);
        if (sparseIntArray != null) {
            return sparseIntArray;
        }
        SparseIntArray sparseIntArray2 = new SparseIntArray();
        this.mTagsToPendingIndicesToDelete.put(i, sparseIntArray2);
        return sparseIntArray2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:62:0x019d, code lost:
        return;
     */
    public synchronized void manageChildren(int i, int[] iArr, ViewAtIndex[] viewAtIndexArr, int[] iArr2, int[] iArr3) {
        int i2 = i;
        int[] iArr4 = iArr;
        ViewAtIndex[] viewAtIndexArr2 = viewAtIndexArr;
        int[] iArr5 = iArr2;
        synchronized (this) {
            UiThreadUtil.assertOnUiThread();
            SparseIntArray orCreatePendingIndicesToDelete = getOrCreatePendingIndicesToDelete(i);
            ViewGroup viewGroup = (ViewGroup) this.mTagsToViews.get(i2);
            ViewGroupManager viewGroupManager = (ViewGroupManager) resolveViewManager(i);
            if (viewGroup != null) {
                int childCount = viewGroupManager.getChildCount(viewGroup);
                if (iArr4 != null) {
                    int length = iArr4.length - 1;
                    while (length >= 0) {
                        int i3 = iArr4[length];
                        if (i3 < 0) {
                            throw new IllegalViewOperationException("Trying to remove a negative view index:" + i3 + " view tag: " + i2 + "\n detail: " + constructManageChildrenErrorMessage(viewGroup, viewGroupManager, iArr4, viewAtIndexArr2, iArr5));
                        } else if (i3 >= viewGroupManager.getChildCount(viewGroup)) {
                            if (!this.mRootTags.get(i2) || viewGroupManager.getChildCount(viewGroup) != 0) {
                                throw new IllegalViewOperationException("Trying to remove a view index above child count " + i3 + " view tag: " + i2 + "\n detail: " + constructManageChildrenErrorMessage(viewGroup, viewGroupManager, iArr4, viewAtIndexArr2, iArr5));
                            }
                            return;
                        } else if (i3 < childCount) {
                            int normalizeIndex = normalizeIndex(i3, orCreatePendingIndicesToDelete);
                            View childAt = viewGroupManager.getChildAt(viewGroup, normalizeIndex);
                            if (!this.mLayoutAnimationEnabled || !this.mLayoutAnimator.shouldAnimateLayout(childAt) || !arrayContains(iArr5, childAt.getId())) {
                                viewGroupManager.removeViewAt(viewGroup, normalizeIndex);
                            }
                            length--;
                            childCount = i3;
                        } else {
                            throw new IllegalViewOperationException("Trying to remove an out of order view index:" + i3 + " view tag: " + i2 + "\n detail: " + constructManageChildrenErrorMessage(viewGroup, viewGroupManager, iArr4, viewAtIndexArr2, iArr5));
                        }
                    }
                }
                int i4 = 0;
                if (iArr5 != null) {
                    int i5 = 0;
                    while (i5 < iArr5.length) {
                        int i6 = iArr5[i5];
                        final int i7 = iArr3[i5];
                        View view = this.mTagsToViews.get(i6);
                        if (view != null) {
                            if (!this.mLayoutAnimationEnabled || !this.mLayoutAnimator.shouldAnimateLayout(view)) {
                                dropView(view);
                            } else {
                                orCreatePendingIndicesToDelete.put(i7, orCreatePendingIndicesToDelete.get(i7, i4) + 1);
                                final ViewGroupManager viewGroupManager2 = viewGroupManager;
                                AnonymousClass1 r0 = r1;
                                final ViewGroup viewGroup2 = viewGroup;
                                LayoutAnimationController layoutAnimationController = this.mLayoutAnimator;
                                final View view2 = view;
                                View view3 = view;
                                final SparseIntArray sparseIntArray = orCreatePendingIndicesToDelete;
                                AnonymousClass1 r1 = new LayoutAnimationListener() {
                                    /* class com.facebook.react.uimanager.NativeViewHierarchyManager.AnonymousClass1 */

                                    public void onAnimationEnd() {
                                        viewGroupManager2.removeView(viewGroup2, view2);
                                        NativeViewHierarchyManager.this.dropView(view2);
                                        sparseIntArray.put(i7, Math.max(0, sparseIntArray.get(i7, 0) - 1));
                                    }
                                };
                                layoutAnimationController.deleteView(view3, r0);
                            }
                            i5++;
                            iArr4 = iArr;
                            viewAtIndexArr2 = viewAtIndexArr;
                            i4 = 0;
                        } else {
                            throw new IllegalViewOperationException("Trying to destroy unknown view tag: " + i6 + "\n detail: " + constructManageChildrenErrorMessage(viewGroup, viewGroupManager, iArr, viewAtIndexArr, iArr5));
                        }
                    }
                }
                int[] iArr6 = iArr4;
                ViewAtIndex[] viewAtIndexArr3 = viewAtIndexArr2;
                if (viewAtIndexArr3 != null) {
                    int i8 = 0;
                    while (i8 < viewAtIndexArr3.length) {
                        ViewAtIndex viewAtIndex = viewAtIndexArr3[i8];
                        View view4 = this.mTagsToViews.get(viewAtIndex.mTag);
                        if (view4 != null) {
                            viewGroupManager.addView(viewGroup, view4, normalizeIndex(viewAtIndex.mIndex, orCreatePendingIndicesToDelete));
                            i8++;
                        } else {
                            throw new IllegalViewOperationException("Trying to add unknown view tag: " + viewAtIndex.mTag + "\n detail: " + constructManageChildrenErrorMessage(viewGroup, viewGroupManager, iArr6, viewAtIndexArr3, iArr5));
                        }
                    }
                }
            } else {
                int[] iArr7 = iArr4;
                ViewAtIndex[] viewAtIndexArr4 = viewAtIndexArr2;
                throw new IllegalViewOperationException("Trying to manageChildren view with tag " + i2 + " which doesn't exist\n detail: " + constructManageChildrenErrorMessage(viewGroup, viewGroupManager, iArr7, viewAtIndexArr4, iArr5));
            }
        }
    }

    private boolean arrayContains(int[] iArr, int i) {
        if (iArr == null) {
            return false;
        }
        for (int i2 : iArr) {
            if (i2 == i) {
                return true;
            }
        }
        return false;
    }

    private static String constructSetChildrenErrorMessage(ViewGroup viewGroup, ViewGroupManager viewGroupManager, ReadableArray readableArray) {
        ViewAtIndex[] viewAtIndexArr = new ViewAtIndex[readableArray.size()];
        for (int i = 0; i < readableArray.size(); i++) {
            viewAtIndexArr[i] = new ViewAtIndex(readableArray.getInt(i), i);
        }
        return constructManageChildrenErrorMessage(viewGroup, viewGroupManager, null, viewAtIndexArr, null);
    }

    public synchronized void setChildren(int i, ReadableArray readableArray) {
        UiThreadUtil.assertOnUiThread();
        ViewGroup viewGroup = (ViewGroup) this.mTagsToViews.get(i);
        ViewGroupManager viewGroupManager = (ViewGroupManager) resolveViewManager(i);
        int i2 = 0;
        while (i2 < readableArray.size()) {
            View view = this.mTagsToViews.get(readableArray.getInt(i2));
            if (view != null) {
                viewGroupManager.addView(viewGroup, view, i2);
                i2++;
            } else {
                throw new IllegalViewOperationException("Trying to add unknown view tag: " + readableArray.getInt(i2) + "\n detail: " + constructSetChildrenErrorMessage(viewGroup, viewGroupManager, readableArray));
            }
        }
    }

    public synchronized void addRootView(int i, View view) {
        addRootViewGroup(i, view);
    }

    /* access modifiers changed from: protected */
    public final synchronized void addRootViewGroup(int i, View view) {
        if (view.getId() != -1) {
            String str = TAG;
            FLog.e(str, "Trying to add a root view with an explicit id (" + view.getId() + ") already set. React Native uses the id field to track react tags and will overwrite this field. If that is fine, explicitly overwrite the id field to View.NO_ID before calling addRootView.");
        }
        this.mTagsToViews.put(i, view);
        this.mTagsToViewManagers.put(i, this.mRootViewManager);
        this.mRootTags.put(i, true);
        view.setId(i);
    }

    private void cacheDroppedTag(int i) {
        int[] iArr = this.mDroppedViewArray;
        int i2 = this.mDroppedViewIndex;
        iArr[i2] = i;
        this.mDroppedViewIndex = (i2 + 1) % 100;
    }

    /* access modifiers changed from: protected */
    public synchronized void dropView(View view) {
        UiThreadUtil.assertOnUiThread();
        if (view != null) {
            if (ReactFeatureFlags.logDroppedViews) {
                cacheDroppedTag(view.getId());
            }
            if (this.mTagsToViewManagers.get(view.getId()) != null) {
                if (!this.mRootTags.get(view.getId())) {
                    resolveViewManager(view.getId()).onDropViewInstance(view);
                }
                ViewManager viewManager = this.mTagsToViewManagers.get(view.getId());
                if ((view instanceof ViewGroup) && (viewManager instanceof ViewGroupManager)) {
                    ViewGroup viewGroup = (ViewGroup) view;
                    ViewGroupManager viewGroupManager = (ViewGroupManager) viewManager;
                    for (int childCount = viewGroupManager.getChildCount(viewGroup) - 1; childCount >= 0; childCount--) {
                        View childAt = viewGroupManager.getChildAt(viewGroup, childCount);
                        if (childAt == null) {
                            FLog.e(TAG, "Unable to drop null child view");
                        } else if (this.mTagsToViews.get(childAt.getId()) != null) {
                            dropView(childAt);
                        }
                    }
                    viewGroupManager.removeAllViews(viewGroup);
                }
                this.mTagsToPendingIndicesToDelete.remove(view.getId());
                this.mTagsToViews.remove(view.getId());
                this.mTagsToViewManagers.remove(view.getId());
            }
        }
    }

    public synchronized void removeRootView(int i) {
        UiThreadUtil.assertOnUiThread();
        if (!this.mRootTags.get(i)) {
            SoftAssertions.assertUnreachable("View with tag " + i + " is not registered as a root view");
        }
        dropView(this.mTagsToViews.get(i));
        this.mRootTags.delete(i);
    }

    public synchronized void measure(int i, int[] iArr) {
        UiThreadUtil.assertOnUiThread();
        View view = this.mTagsToViews.get(i);
        if (view != null) {
            View view2 = (View) RootViewUtil.getRootView(view);
            if (view2 != null) {
                computeBoundingBox(view2, iArr);
                int i2 = iArr[0];
                int i3 = iArr[1];
                computeBoundingBox(view, iArr);
                iArr[0] = iArr[0] - i2;
                iArr[1] = iArr[1] - i3;
            } else {
                throw new NoSuchNativeViewException("Native view " + i + " is no longer on screen");
            }
        } else {
            throw new NoSuchNativeViewException("No native view for " + i + " currently exists");
        }
    }

    private void computeBoundingBox(View view, int[] iArr) {
        this.mBoundingBox.set(0.0f, 0.0f, (float) view.getWidth(), (float) view.getHeight());
        mapRectFromViewToWindowCoords(view, this.mBoundingBox);
        iArr[0] = Math.round(this.mBoundingBox.left);
        iArr[1] = Math.round(this.mBoundingBox.top);
        iArr[2] = Math.round(this.mBoundingBox.right - this.mBoundingBox.left);
        iArr[3] = Math.round(this.mBoundingBox.bottom - this.mBoundingBox.top);
    }

    private void mapRectFromViewToWindowCoords(View view, RectF rectF) {
        Matrix matrix = view.getMatrix();
        if (!matrix.isIdentity()) {
            matrix.mapRect(rectF);
        }
        rectF.offset((float) view.getLeft(), (float) view.getTop());
        ViewParent parent = view.getParent();
        while (parent instanceof View) {
            View view2 = (View) parent;
            rectF.offset((float) (-view2.getScrollX()), (float) (-view2.getScrollY()));
            Matrix matrix2 = view2.getMatrix();
            if (!matrix2.isIdentity()) {
                matrix2.mapRect(rectF);
            }
            rectF.offset((float) view2.getLeft(), (float) view2.getTop());
            parent = view2.getParent();
        }
    }

    public synchronized void measureInWindow(int i, int[] iArr) {
        UiThreadUtil.assertOnUiThread();
        View view = this.mTagsToViews.get(i);
        if (view != null) {
            view.getLocationOnScreen(iArr);
            Resources resources = view.getContext().getResources();
            int identifier = resources.getIdentifier("status_bar_height", "dimen", "android");
            if (identifier > 0) {
                iArr[1] = iArr[1] - ((int) resources.getDimension(identifier));
            }
            iArr[2] = view.getWidth();
            iArr[3] = view.getHeight();
        } else {
            throw new NoSuchNativeViewException("No native view for " + i + " currently exists");
        }
    }

    public synchronized int findTargetTagForTouch(int i, float f, float f2) {
        View view;
        UiThreadUtil.assertOnUiThread();
        view = this.mTagsToViews.get(i);
        if (view != null) {
        } else {
            throw new JSApplicationIllegalArgumentException("Could not find view with tag ".concat(String.valueOf(i)));
        }
        return TouchTargetHelper.findTargetTagForTouch(f, f2, (ViewGroup) view);
    }

    public synchronized void setJSResponder(int i, int i2, boolean z) {
        if (!z) {
            this.mJSResponderHandler.setJSResponder(i2, null);
            return;
        }
        View view = this.mTagsToViews.get(i);
        if (i2 == i || !(view instanceof ViewParent)) {
            if (this.mRootTags.get(i)) {
                SoftAssertions.assertUnreachable("Cannot block native responder on " + i + " that is a root view");
            }
            this.mJSResponderHandler.setJSResponder(i2, view.getParent());
            return;
        }
        this.mJSResponderHandler.setJSResponder(i2, (ViewParent) view);
    }

    public void clearJSResponder() {
        this.mJSResponderHandler.clearJSResponder();
    }

    /* access modifiers changed from: package-private */
    public void configureLayoutAnimation(ReadableMap readableMap, Callback callback) {
        this.mLayoutAnimator.initializeFromConfig(readableMap, callback);
    }

    /* access modifiers changed from: package-private */
    public void clearLayoutAnimation() {
        this.mLayoutAnimator.reset();
    }

    @Deprecated
    public synchronized void dispatchCommand(int i, int i2, ReadableArray readableArray) {
        UiThreadUtil.assertOnUiThread();
        View view = this.mTagsToViews.get(i);
        if (view != null) {
            resolveViewManager(i).receiveCommand(view, i2, readableArray);
        } else {
            throw new IllegalViewOperationException("Trying to send command to a non-existing view with tag ".concat(String.valueOf(i)));
        }
    }

    public synchronized void dispatchCommand(int i, String str, ReadableArray readableArray) {
        UiThreadUtil.assertOnUiThread();
        View view = this.mTagsToViews.get(i);
        if (view != null) {
            resolveViewManager(i).receiveCommand(view, str, readableArray);
        } else {
            throw new IllegalViewOperationException("Trying to send command to a non-existing view with tag ".concat(String.valueOf(i)));
        }
    }

    public synchronized void showPopupMenu(int i, ReadableArray readableArray, Callback callback, Callback callback2) {
        UiThreadUtil.assertOnUiThread();
        View view = this.mTagsToViews.get(i);
        if (view == null) {
            callback2.invoke("Can't display popup. Could not find view with tag ".concat(String.valueOf(i)));
            return;
        }
        this.mPopupMenu = new PopupMenu(getReactContextForView(i), view);
        Menu menu = this.mPopupMenu.getMenu();
        for (int i2 = 0; i2 < readableArray.size(); i2++) {
            menu.add(0, 0, i2, readableArray.getString(i2));
        }
        PopupMenuCallbackHandler popupMenuCallbackHandler = new PopupMenuCallbackHandler(callback);
        this.mPopupMenu.setOnMenuItemClickListener(popupMenuCallbackHandler);
        this.mPopupMenu.setOnDismissListener(popupMenuCallbackHandler);
        this.mPopupMenu.show();
    }

    public void dismissPopupMenu() {
        PopupMenu popupMenu = this.mPopupMenu;
        if (popupMenu != null) {
            popupMenu.dismiss();
        }
    }

    static class PopupMenuCallbackHandler implements PopupMenu.OnDismissListener, PopupMenu.OnMenuItemClickListener {
        boolean mConsumed;
        final Callback mSuccess;

        private PopupMenuCallbackHandler(Callback callback) {
            this.mConsumed = false;
            this.mSuccess = callback;
        }

        public void onDismiss(PopupMenu popupMenu) {
            if (!this.mConsumed) {
                this.mSuccess.invoke("dismissed");
                this.mConsumed = true;
            }
        }

        public boolean onMenuItemClick(MenuItem menuItem) {
            if (this.mConsumed) {
                return false;
            }
            this.mSuccess.invoke("itemSelected", Integer.valueOf(menuItem.getOrder()));
            this.mConsumed = true;
            return true;
        }
    }

    private ThemedReactContext getReactContextForView(int i) {
        View view = this.mTagsToViews.get(i);
        if (view != null) {
            return (ThemedReactContext) view.getContext();
        }
        throw new JSApplicationIllegalArgumentException("Could not find view with tag ".concat(String.valueOf(i)));
    }

    public void sendAccessibilityEvent(int i, int i2) {
        View view = this.mTagsToViews.get(i);
        if (view != null) {
            view.sendAccessibilityEvent(i2);
            return;
        }
        throw new JSApplicationIllegalArgumentException("Could not find view with tag ".concat(String.valueOf(i)));
    }
}
