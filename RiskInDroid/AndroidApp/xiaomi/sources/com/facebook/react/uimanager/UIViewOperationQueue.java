package com.facebook.react.uimanager;

import android.os.SystemClock;
import android.view.View;
import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.GuardedRunnable;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.SoftAssertions;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.modules.core.ReactChoreographer;
import com.facebook.react.uimanager.UIImplementation;
import com.facebook.react.uimanager.debug.NotThreadSafeViewHierarchyUpdateDebugListener;
import com.facebook.systrace.Systrace;
import com.facebook.systrace.SystraceMessage;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class UIViewOperationQueue {
    private final Object mDispatchRunnablesLock = new Object();
    private final DispatchUIFrameCallback mDispatchUIFrameCallback;
    private ArrayList<Runnable> mDispatchUIRunnables = new ArrayList<>();
    private boolean mIsDispatchUIFrameCallbackEnqueued = false;
    public boolean mIsInIllegalUIState = false;
    public boolean mIsProfilingNextBatch = false;
    public final int[] mMeasureBuffer = new int[4];
    public final NativeViewHierarchyManager mNativeViewHierarchyManager;
    public long mNonBatchedExecutionTotalTime;
    public ArrayDeque<UIOperation> mNonBatchedOperations = new ArrayDeque<>();
    public final Object mNonBatchedOperationsLock = new Object();
    private ArrayList<UIOperation> mOperations = new ArrayList<>();
    private long mProfiledBatchBatchedExecutionTime;
    public long mProfiledBatchCommitStartTime;
    public long mProfiledBatchDispatchViewUpdatesTime;
    public long mProfiledBatchLayoutTime;
    private long mProfiledBatchNonBatchedExecutionTime;
    public long mProfiledBatchRunStartTime;
    public final ReactApplicationContext mReactApplicationContext;
    public long mThreadCpuTime;
    public NotThreadSafeViewHierarchyUpdateDebugListener mViewHierarchyUpdateDebugListener;

    public interface UIOperation {
        void execute();
    }

    abstract class ViewOperation implements UIOperation {
        public int mTag;

        public ViewOperation(int i) {
            this.mTag = i;
        }
    }

    final class RemoveRootViewOperation extends ViewOperation {
        public RemoveRootViewOperation(int i) {
            super(i);
        }

        public final void execute() {
            UIViewOperationQueue.this.mNativeViewHierarchyManager.removeRootView(this.mTag);
        }
    }

    final class UpdatePropertiesOperation extends ViewOperation {
        private final ReactStylesDiffMap mProps;

        private UpdatePropertiesOperation(int i, ReactStylesDiffMap reactStylesDiffMap) {
            super(i);
            this.mProps = reactStylesDiffMap;
        }

        public final void execute() {
            UIViewOperationQueue.this.mNativeViewHierarchyManager.updateProperties(this.mTag, this.mProps);
        }
    }

    final class EmitOnLayoutEventOperation extends ViewOperation {
        private final int mScreenHeight;
        private final int mScreenWidth;
        private final int mScreenX;
        private final int mScreenY;

        public EmitOnLayoutEventOperation(int i, int i2, int i3, int i4, int i5) {
            super(i);
            this.mScreenX = i2;
            this.mScreenY = i3;
            this.mScreenWidth = i4;
            this.mScreenHeight = i5;
        }

        public final void execute() {
            ((UIManagerModule) UIViewOperationQueue.this.mReactApplicationContext.getNativeModule(UIManagerModule.class)).getEventDispatcher().dispatchEvent(OnLayoutEvent.obtain(this.mTag, this.mScreenX, this.mScreenY, this.mScreenWidth, this.mScreenHeight));
        }
    }

    final class UpdateInstanceHandleOperation extends ViewOperation {
        private final long mInstanceHandle;

        private UpdateInstanceHandleOperation(int i, long j) {
            super(i);
            this.mInstanceHandle = j;
        }

        public final void execute() {
            UIViewOperationQueue.this.mNativeViewHierarchyManager.updateInstanceHandle(this.mTag, this.mInstanceHandle);
        }
    }

    final class UpdateLayoutOperation extends ViewOperation {
        private final int mHeight;
        private final int mParentTag;
        private final int mWidth;
        private final int mX;
        private final int mY;

        public UpdateLayoutOperation(int i, int i2, int i3, int i4, int i5, int i6) {
            super(i2);
            this.mParentTag = i;
            this.mX = i3;
            this.mY = i4;
            this.mWidth = i5;
            this.mHeight = i6;
            Systrace.startAsyncFlow(0, "updateLayout", this.mTag);
        }

        public final void execute() {
            Systrace.endAsyncFlow(0, "updateLayout", this.mTag);
            UIViewOperationQueue.this.mNativeViewHierarchyManager.updateLayout(this.mParentTag, this.mTag, this.mX, this.mY, this.mWidth, this.mHeight);
        }
    }

    final class CreateViewOperation extends ViewOperation {
        private final String mClassName;
        private final ReactStylesDiffMap mInitialProps;
        private final ThemedReactContext mThemedContext;

        public CreateViewOperation(ThemedReactContext themedReactContext, int i, String str, ReactStylesDiffMap reactStylesDiffMap) {
            super(i);
            this.mThemedContext = themedReactContext;
            this.mClassName = str;
            this.mInitialProps = reactStylesDiffMap;
            Systrace.startAsyncFlow(0, "createView", this.mTag);
        }

        public final void execute() {
            Systrace.endAsyncFlow(0, "createView", this.mTag);
            UIViewOperationQueue.this.mNativeViewHierarchyManager.createView(this.mThemedContext, this.mTag, this.mClassName, this.mInitialProps);
        }
    }

    final class ManageChildrenOperation extends ViewOperation {
        private final int[] mIndicesToDelete;
        private final int[] mIndicesToRemove;
        private final int[] mTagsToDelete;
        private final ViewAtIndex[] mViewsToAdd;

        public ManageChildrenOperation(int i, int[] iArr, ViewAtIndex[] viewAtIndexArr, int[] iArr2, int[] iArr3) {
            super(i);
            this.mIndicesToRemove = iArr;
            this.mViewsToAdd = viewAtIndexArr;
            this.mTagsToDelete = iArr2;
            this.mIndicesToDelete = iArr3;
        }

        public final void execute() {
            UIViewOperationQueue.this.mNativeViewHierarchyManager.manageChildren(this.mTag, this.mIndicesToRemove, this.mViewsToAdd, this.mTagsToDelete, this.mIndicesToDelete);
        }
    }

    final class SetChildrenOperation extends ViewOperation {
        private final ReadableArray mChildrenTags;

        public SetChildrenOperation(int i, ReadableArray readableArray) {
            super(i);
            this.mChildrenTags = readableArray;
        }

        public final void execute() {
            UIViewOperationQueue.this.mNativeViewHierarchyManager.setChildren(this.mTag, this.mChildrenTags);
        }
    }

    final class UpdateViewExtraData extends ViewOperation {
        private final Object mExtraData;

        public UpdateViewExtraData(int i, Object obj) {
            super(i);
            this.mExtraData = obj;
        }

        public final void execute() {
            UIViewOperationQueue.this.mNativeViewHierarchyManager.updateViewExtraData(this.mTag, this.mExtraData);
        }
    }

    final class ChangeJSResponderOperation extends ViewOperation {
        private final boolean mBlockNativeResponder;
        private final boolean mClearResponder;
        private final int mInitialTag;

        public ChangeJSResponderOperation(int i, int i2, boolean z, boolean z2) {
            super(i);
            this.mInitialTag = i2;
            this.mClearResponder = z;
            this.mBlockNativeResponder = z2;
        }

        public final void execute() {
            if (!this.mClearResponder) {
                UIViewOperationQueue.this.mNativeViewHierarchyManager.setJSResponder(this.mTag, this.mInitialTag, this.mBlockNativeResponder);
            } else {
                UIViewOperationQueue.this.mNativeViewHierarchyManager.clearJSResponder();
            }
        }
    }

    @Deprecated
    final class DispatchCommandOperation extends ViewOperation {
        private final ReadableArray mArgs;
        private final int mCommand;

        public DispatchCommandOperation(int i, int i2, ReadableArray readableArray) {
            super(i);
            this.mCommand = i2;
            this.mArgs = readableArray;
        }

        public final void execute() {
            UIViewOperationQueue.this.mNativeViewHierarchyManager.dispatchCommand(this.mTag, this.mCommand, this.mArgs);
        }
    }

    final class DispatchStringCommandOperation extends ViewOperation {
        private final ReadableArray mArgs;
        private final String mCommand;

        public DispatchStringCommandOperation(int i, String str, ReadableArray readableArray) {
            super(i);
            this.mCommand = str;
            this.mArgs = readableArray;
        }

        public final void execute() {
            UIViewOperationQueue.this.mNativeViewHierarchyManager.dispatchCommand(this.mTag, this.mCommand, this.mArgs);
        }
    }

    final class ShowPopupMenuOperation extends ViewOperation {
        private final Callback mError;
        private final ReadableArray mItems;
        private final Callback mSuccess;

        public ShowPopupMenuOperation(int i, ReadableArray readableArray, Callback callback, Callback callback2) {
            super(i);
            this.mItems = readableArray;
            this.mError = callback;
            this.mSuccess = callback2;
        }

        public final void execute() {
            UIViewOperationQueue.this.mNativeViewHierarchyManager.showPopupMenu(this.mTag, this.mItems, this.mSuccess, this.mError);
        }
    }

    final class DismissPopupMenuOperation implements UIOperation {
        private DismissPopupMenuOperation() {
        }

        public final void execute() {
            UIViewOperationQueue.this.mNativeViewHierarchyManager.dismissPopupMenu();
        }
    }

    static abstract class AnimationOperation implements UIOperation {
        protected final int mAnimationID;

        public AnimationOperation(int i) {
            this.mAnimationID = i;
        }
    }

    class SetLayoutAnimationEnabledOperation implements UIOperation {
        private final boolean mEnabled;

        private SetLayoutAnimationEnabledOperation(boolean z) {
            this.mEnabled = z;
        }

        public void execute() {
            UIViewOperationQueue.this.mNativeViewHierarchyManager.setLayoutAnimationEnabled(this.mEnabled);
        }
    }

    class ConfigureLayoutAnimationOperation implements UIOperation {
        private final Callback mAnimationComplete;
        private final ReadableMap mConfig;

        private ConfigureLayoutAnimationOperation(ReadableMap readableMap, Callback callback) {
            this.mConfig = readableMap;
            this.mAnimationComplete = callback;
        }

        public void execute() {
            UIViewOperationQueue.this.mNativeViewHierarchyManager.configureLayoutAnimation(this.mConfig, this.mAnimationComplete);
        }
    }

    final class MeasureOperation implements UIOperation {
        private final Callback mCallback;
        private final int mReactTag;

        private MeasureOperation(int i, Callback callback) {
            this.mReactTag = i;
            this.mCallback = callback;
        }

        public final void execute() {
            try {
                UIViewOperationQueue.this.mNativeViewHierarchyManager.measure(this.mReactTag, UIViewOperationQueue.this.mMeasureBuffer);
                float dIPFromPixel = PixelUtil.toDIPFromPixel((float) UIViewOperationQueue.this.mMeasureBuffer[0]);
                float dIPFromPixel2 = PixelUtil.toDIPFromPixel((float) UIViewOperationQueue.this.mMeasureBuffer[1]);
                float dIPFromPixel3 = PixelUtil.toDIPFromPixel((float) UIViewOperationQueue.this.mMeasureBuffer[2]);
                float dIPFromPixel4 = PixelUtil.toDIPFromPixel((float) UIViewOperationQueue.this.mMeasureBuffer[3]);
                this.mCallback.invoke(0, 0, Float.valueOf(dIPFromPixel3), Float.valueOf(dIPFromPixel4), Float.valueOf(dIPFromPixel), Float.valueOf(dIPFromPixel2));
            } catch (NoSuchNativeViewException unused) {
                this.mCallback.invoke(new Object[0]);
            }
        }
    }

    final class MeasureInWindowOperation implements UIOperation {
        private final Callback mCallback;
        private final int mReactTag;

        private MeasureInWindowOperation(int i, Callback callback) {
            this.mReactTag = i;
            this.mCallback = callback;
        }

        public final void execute() {
            try {
                UIViewOperationQueue.this.mNativeViewHierarchyManager.measureInWindow(this.mReactTag, UIViewOperationQueue.this.mMeasureBuffer);
                float dIPFromPixel = PixelUtil.toDIPFromPixel((float) UIViewOperationQueue.this.mMeasureBuffer[0]);
                float dIPFromPixel2 = PixelUtil.toDIPFromPixel((float) UIViewOperationQueue.this.mMeasureBuffer[1]);
                float dIPFromPixel3 = PixelUtil.toDIPFromPixel((float) UIViewOperationQueue.this.mMeasureBuffer[2]);
                float dIPFromPixel4 = PixelUtil.toDIPFromPixel((float) UIViewOperationQueue.this.mMeasureBuffer[3]);
                this.mCallback.invoke(Float.valueOf(dIPFromPixel), Float.valueOf(dIPFromPixel2), Float.valueOf(dIPFromPixel3), Float.valueOf(dIPFromPixel4));
            } catch (NoSuchNativeViewException unused) {
                this.mCallback.invoke(new Object[0]);
            }
        }
    }

    final class FindTargetForTouchOperation implements UIOperation {
        private final Callback mCallback;
        private final int mReactTag;
        private final float mTargetX;
        private final float mTargetY;

        private FindTargetForTouchOperation(int i, float f, float f2, Callback callback) {
            this.mReactTag = i;
            this.mTargetX = f;
            this.mTargetY = f2;
            this.mCallback = callback;
        }

        public final void execute() {
            try {
                UIViewOperationQueue.this.mNativeViewHierarchyManager.measure(this.mReactTag, UIViewOperationQueue.this.mMeasureBuffer);
                float f = (float) UIViewOperationQueue.this.mMeasureBuffer[0];
                float f2 = (float) UIViewOperationQueue.this.mMeasureBuffer[1];
                int findTargetTagForTouch = UIViewOperationQueue.this.mNativeViewHierarchyManager.findTargetTagForTouch(this.mReactTag, this.mTargetX, this.mTargetY);
                try {
                    UIViewOperationQueue.this.mNativeViewHierarchyManager.measure(findTargetTagForTouch, UIViewOperationQueue.this.mMeasureBuffer);
                    float dIPFromPixel = PixelUtil.toDIPFromPixel(((float) UIViewOperationQueue.this.mMeasureBuffer[0]) - f);
                    float dIPFromPixel2 = PixelUtil.toDIPFromPixel(((float) UIViewOperationQueue.this.mMeasureBuffer[1]) - f2);
                    float dIPFromPixel3 = PixelUtil.toDIPFromPixel((float) UIViewOperationQueue.this.mMeasureBuffer[2]);
                    float dIPFromPixel4 = PixelUtil.toDIPFromPixel((float) UIViewOperationQueue.this.mMeasureBuffer[3]);
                    this.mCallback.invoke(Integer.valueOf(findTargetTagForTouch), Float.valueOf(dIPFromPixel), Float.valueOf(dIPFromPixel2), Float.valueOf(dIPFromPixel3), Float.valueOf(dIPFromPixel4));
                } catch (IllegalViewOperationException unused) {
                    this.mCallback.invoke(new Object[0]);
                }
            } catch (IllegalViewOperationException unused2) {
                this.mCallback.invoke(new Object[0]);
            }
        }
    }

    final class LayoutUpdateFinishedOperation implements UIOperation {
        private final UIImplementation.LayoutUpdateListener mListener;
        private final ReactShadowNode mNode;

        private LayoutUpdateFinishedOperation(ReactShadowNode reactShadowNode, UIImplementation.LayoutUpdateListener layoutUpdateListener) {
            this.mNode = reactShadowNode;
            this.mListener = layoutUpdateListener;
        }

        public final void execute() {
            this.mListener.onLayoutUpdated(this.mNode);
        }
    }

    class UIBlockOperation implements UIOperation {
        private final UIBlock mBlock;

        public UIBlockOperation(UIBlock uIBlock) {
            this.mBlock = uIBlock;
        }

        public void execute() {
            this.mBlock.execute(UIViewOperationQueue.this.mNativeViewHierarchyManager);
        }
    }

    final class SendAccessibilityEvent extends ViewOperation {
        private final int mEventType;

        private SendAccessibilityEvent(int i, int i2) {
            super(i);
            this.mEventType = i2;
        }

        public final void execute() {
            UIViewOperationQueue.this.mNativeViewHierarchyManager.sendAccessibilityEvent(this.mTag, this.mEventType);
        }
    }

    public UIViewOperationQueue(ReactApplicationContext reactApplicationContext, NativeViewHierarchyManager nativeViewHierarchyManager, int i) {
        this.mNativeViewHierarchyManager = nativeViewHierarchyManager;
        this.mDispatchUIFrameCallback = new DispatchUIFrameCallback(reactApplicationContext, i == -1 ? 8 : i);
        this.mReactApplicationContext = reactApplicationContext;
    }

    /* access modifiers changed from: package-private */
    public NativeViewHierarchyManager getNativeViewHierarchyManager() {
        return this.mNativeViewHierarchyManager;
    }

    public void setViewHierarchyUpdateDebugListener(NotThreadSafeViewHierarchyUpdateDebugListener notThreadSafeViewHierarchyUpdateDebugListener) {
        this.mViewHierarchyUpdateDebugListener = notThreadSafeViewHierarchyUpdateDebugListener;
    }

    public void profileNextBatch() {
        this.mIsProfilingNextBatch = true;
        this.mProfiledBatchCommitStartTime = 0;
    }

    public Map<String, Long> getProfiledBatchPerfCounters() {
        HashMap hashMap = new HashMap();
        hashMap.put("CommitStartTime", Long.valueOf(this.mProfiledBatchCommitStartTime));
        hashMap.put("LayoutTime", Long.valueOf(this.mProfiledBatchLayoutTime));
        hashMap.put("DispatchViewUpdatesTime", Long.valueOf(this.mProfiledBatchDispatchViewUpdatesTime));
        hashMap.put("RunStartTime", Long.valueOf(this.mProfiledBatchRunStartTime));
        hashMap.put("BatchedExecutionTime", Long.valueOf(this.mProfiledBatchBatchedExecutionTime));
        hashMap.put("NonBatchedExecutionTime", Long.valueOf(this.mProfiledBatchNonBatchedExecutionTime));
        hashMap.put("NativeModulesThreadCpuTime", Long.valueOf(this.mThreadCpuTime));
        return hashMap;
    }

    public boolean isEmpty() {
        return this.mOperations.isEmpty();
    }

    public void addRootView(int i, View view) {
        this.mNativeViewHierarchyManager.addRootView(i, view);
    }

    /* access modifiers changed from: protected */
    public void enqueueUIOperation(UIOperation uIOperation) {
        SoftAssertions.assertNotNull(uIOperation);
        this.mOperations.add(uIOperation);
    }

    public void enqueueRemoveRootView(int i) {
        this.mOperations.add(new RemoveRootViewOperation(i));
    }

    public void enqueueSetJSResponder(int i, int i2, boolean z) {
        this.mOperations.add(new ChangeJSResponderOperation(i, i2, false, z));
    }

    public void enqueueClearJSResponder() {
        this.mOperations.add(new ChangeJSResponderOperation(0, 0, true, false));
    }

    @Deprecated
    public void enqueueDispatchCommand(int i, int i2, ReadableArray readableArray) {
        this.mOperations.add(new DispatchCommandOperation(i, i2, readableArray));
    }

    public void enqueueDispatchCommand(int i, String str, ReadableArray readableArray) {
        this.mOperations.add(new DispatchStringCommandOperation(i, str, readableArray));
    }

    public void enqueueUpdateExtraData(int i, Object obj) {
        this.mOperations.add(new UpdateViewExtraData(i, obj));
    }

    public void enqueueShowPopupMenu(int i, ReadableArray readableArray, Callback callback, Callback callback2) {
        this.mOperations.add(new ShowPopupMenuOperation(i, readableArray, callback, callback2));
    }

    public void enqueueDismissPopupMenu() {
        this.mOperations.add(new DismissPopupMenuOperation());
    }

    public void enqueueCreateView(ThemedReactContext themedReactContext, int i, String str, ReactStylesDiffMap reactStylesDiffMap) {
        synchronized (this.mNonBatchedOperationsLock) {
            this.mNonBatchedOperations.addLast(new CreateViewOperation(themedReactContext, i, str, reactStylesDiffMap));
        }
    }

    public void enqueueUpdateInstanceHandle(int i, long j) {
        this.mOperations.add(new UpdateInstanceHandleOperation(i, j));
    }

    public void enqueueUpdateProperties(int i, String str, ReactStylesDiffMap reactStylesDiffMap) {
        this.mOperations.add(new UpdatePropertiesOperation(i, reactStylesDiffMap));
    }

    public void enqueueOnLayoutEvent(int i, int i2, int i3, int i4, int i5) {
        this.mOperations.add(new EmitOnLayoutEventOperation(i, i2, i3, i4, i5));
    }

    public void enqueueUpdateLayout(int i, int i2, int i3, int i4, int i5, int i6) {
        this.mOperations.add(new UpdateLayoutOperation(i, i2, i3, i4, i5, i6));
    }

    public void enqueueManageChildren(int i, int[] iArr, ViewAtIndex[] viewAtIndexArr, int[] iArr2, int[] iArr3) {
        this.mOperations.add(new ManageChildrenOperation(i, iArr, viewAtIndexArr, iArr2, iArr3));
    }

    public void enqueueSetChildren(int i, ReadableArray readableArray) {
        this.mOperations.add(new SetChildrenOperation(i, readableArray));
    }

    public void enqueueSetLayoutAnimationEnabled(boolean z) {
        this.mOperations.add(new SetLayoutAnimationEnabledOperation(z));
    }

    public void enqueueConfigureLayoutAnimation(ReadableMap readableMap, Callback callback) {
        this.mOperations.add(new ConfigureLayoutAnimationOperation(readableMap, callback));
    }

    public void enqueueMeasure(int i, Callback callback) {
        this.mOperations.add(new MeasureOperation(i, callback));
    }

    public void enqueueMeasureInWindow(int i, Callback callback) {
        this.mOperations.add(new MeasureInWindowOperation(i, callback));
    }

    public void enqueueFindTargetForTouch(int i, float f, float f2, Callback callback) {
        this.mOperations.add(new FindTargetForTouchOperation(i, f, f2, callback));
    }

    public void enqueueSendAccessibilityEvent(int i, int i2) {
        this.mOperations.add(new SendAccessibilityEvent(i, i2));
    }

    public void enqueueLayoutUpdateFinished(ReactShadowNode reactShadowNode, UIImplementation.LayoutUpdateListener layoutUpdateListener) {
        this.mOperations.add(new LayoutUpdateFinishedOperation(reactShadowNode, layoutUpdateListener));
    }

    public void enqueueUIBlock(UIBlock uIBlock) {
        this.mOperations.add(new UIBlockOperation(uIBlock));
    }

    public void prependUIBlock(UIBlock uIBlock) {
        this.mOperations.add(0, new UIBlockOperation(uIBlock));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00a0, code lost:
        r0 = th;
     */
    public void dispatchViewUpdates(int i, long j, long j2) {
        long j3;
        final ArrayList<UIOperation> arrayList;
        final ArrayDeque<UIOperation> arrayDeque;
        AnonymousClass1 r1;
        int i2 = i;
        SystraceMessage.beginSection(0, "UIViewOperationQueue.dispatchViewUpdates").arg("batchId", i2).flush();
        try {
            final long uptimeMillis = SystemClock.uptimeMillis();
            long currentThreadTimeMillis = SystemClock.currentThreadTimeMillis();
            ArrayDeque<UIOperation> arrayDeque2 = null;
            if (!this.mOperations.isEmpty()) {
                ArrayList<UIOperation> arrayList2 = this.mOperations;
                this.mOperations = new ArrayList<>();
                arrayList = arrayList2;
            } else {
                arrayList = null;
            }
            synchronized (this.mNonBatchedOperationsLock) {
                try {
                    if (!this.mNonBatchedOperations.isEmpty()) {
                        arrayDeque2 = this.mNonBatchedOperations;
                        this.mNonBatchedOperations = new ArrayDeque<>();
                    }
                    arrayDeque = arrayDeque2;
                } catch (Throwable th) {
                    th = th;
                }
            }
            if (this.mViewHierarchyUpdateDebugListener != null) {
                this.mViewHierarchyUpdateDebugListener.onViewHierarchyUpdateEnqueued();
            }
            final int i3 = i;
            final long j4 = j;
            AnonymousClass1 r17 = r1;
            final long j5 = j2;
            final long j6 = currentThreadTimeMillis;
            try {
                r1 = new Runnable() {
                    /* class com.facebook.react.uimanager.UIViewOperationQueue.AnonymousClass1 */

                    public void run() {
                        SystraceMessage.beginSection(0, "DispatchUI").arg("BatchId", i3).flush();
                        try {
                            long uptimeMillis = SystemClock.uptimeMillis();
                            if (arrayDeque != null) {
                                Iterator it = arrayDeque.iterator();
                                while (it.hasNext()) {
                                    ((UIOperation) it.next()).execute();
                                }
                            }
                            if (arrayList != null) {
                                Iterator it2 = arrayList.iterator();
                                while (it2.hasNext()) {
                                    ((UIOperation) it2.next()).execute();
                                }
                            }
                            if (UIViewOperationQueue.this.mIsProfilingNextBatch && UIViewOperationQueue.this.mProfiledBatchCommitStartTime == 0) {
                                UIViewOperationQueue.this.mProfiledBatchCommitStartTime = j4;
                                UIViewOperationQueue.this.mProfiledBatchLayoutTime = j5;
                                UIViewOperationQueue.this.mProfiledBatchDispatchViewUpdatesTime = uptimeMillis;
                                UIViewOperationQueue.this.mProfiledBatchRunStartTime = uptimeMillis;
                                UIViewOperationQueue.this.mThreadCpuTime = j6;
                                Systrace.beginAsyncSection(0, "delayBeforeDispatchViewUpdates", 0, UIViewOperationQueue.this.mProfiledBatchCommitStartTime * 1000000);
                                Systrace.endAsyncSection(0, "delayBeforeDispatchViewUpdates", 0, UIViewOperationQueue.this.mProfiledBatchDispatchViewUpdatesTime * 1000000);
                                Systrace.beginAsyncSection(0, "delayBeforeBatchRunStart", 0, UIViewOperationQueue.this.mProfiledBatchDispatchViewUpdatesTime * 1000000);
                                Systrace.endAsyncSection(0, "delayBeforeBatchRunStart", 0, UIViewOperationQueue.this.mProfiledBatchRunStartTime * 1000000);
                            }
                            UIViewOperationQueue.this.mNativeViewHierarchyManager.clearLayoutAnimation();
                            if (UIViewOperationQueue.this.mViewHierarchyUpdateDebugListener != null) {
                                UIViewOperationQueue.this.mViewHierarchyUpdateDebugListener.onViewHierarchyUpdateFinished();
                            }
                            Systrace.endSection(0);
                        } catch (Exception e) {
                            UIViewOperationQueue.this.mIsInIllegalUIState = true;
                            throw e;
                        } catch (Throwable th) {
                            Systrace.endSection(0);
                            throw th;
                        }
                    }
                };
                j3 = 0;
                SystraceMessage.beginSection(0, "acquiring mDispatchRunnablesLock").arg("batchId", i2).flush();
                synchronized (this.mDispatchRunnablesLock) {
                    Systrace.endSection(0);
                    this.mDispatchUIRunnables.add(r17);
                }
                if (!this.mIsDispatchUIFrameCallbackEnqueued) {
                    UiThreadUtil.runOnUiThread(new GuardedRunnable(this.mReactApplicationContext) {
                        /* class com.facebook.react.uimanager.UIViewOperationQueue.AnonymousClass2 */

                        public void runGuarded() {
                            UIViewOperationQueue.this.flushPendingBatches();
                        }
                    });
                }
                Systrace.endSection(0);
            } catch (Throwable th2) {
                th = th2;
                j3 = 0;
                Systrace.endSection(j3);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            j3 = 0;
            Systrace.endSection(j3);
            throw th;
        }
    }

    /* access modifiers changed from: package-private */
    public void resumeFrameCallback() {
        this.mIsDispatchUIFrameCallbackEnqueued = true;
        ReactChoreographer.getInstance().postFrameCallback(ReactChoreographer.CallbackType.DISPATCH_UI, this.mDispatchUIFrameCallback);
    }

    /* access modifiers changed from: package-private */
    public void pauseFrameCallback() {
        this.mIsDispatchUIFrameCallbackEnqueued = false;
        ReactChoreographer.getInstance().removeFrameCallback(ReactChoreographer.CallbackType.DISPATCH_UI, this.mDispatchUIFrameCallback);
        flushPendingBatches();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0021, code lost:
        r2 = android.os.SystemClock.uptimeMillis();
        r0 = r1.iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002d, code lost:
        if (r0.hasNext() == false) goto L_0x0039;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x002f, code lost:
        r0.next().run();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x003d, code lost:
        if (r12.mIsProfilingNextBatch == false) goto L_0x005f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x003f, code lost:
        r12.mProfiledBatchBatchedExecutionTime = android.os.SystemClock.uptimeMillis() - r2;
        r12.mProfiledBatchNonBatchedExecutionTime = r12.mNonBatchedExecutionTotalTime;
        r12.mIsProfilingNextBatch = false;
        com.facebook.systrace.Systrace.beginAsyncSection(0, "batchedExecutionTime", 0, 1000000 * r2);
        com.facebook.systrace.Systrace.endAsyncSection(0, "batchedExecutionTime", 0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x005f, code lost:
        r12.mNonBatchedExecutionTotalTime = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0061, code lost:
        return;
     */
    public void flushPendingBatches() {
        if (this.mIsInIllegalUIState) {
            FLog.w("ReactNative", "Not flushing pending UI operations because of previously thrown Exception");
            return;
        }
        synchronized (this.mDispatchRunnablesLock) {
            if (!this.mDispatchUIRunnables.isEmpty()) {
                ArrayList<Runnable> arrayList = this.mDispatchUIRunnables;
                this.mDispatchUIRunnables = new ArrayList<>();
            }
        }
    }

    class DispatchUIFrameCallback extends GuardedFrameCallback {
        private final int mMinTimeLeftInFrameForNonBatchedOperationMs;

        private DispatchUIFrameCallback(ReactContext reactContext, int i) {
            super(reactContext);
            this.mMinTimeLeftInFrameForNonBatchedOperationMs = i;
        }

        /* JADX INFO: finally extract failed */
        public void doFrameGuarded(long j) {
            if (UIViewOperationQueue.this.mIsInIllegalUIState) {
                FLog.w("ReactNative", "Not flushing pending UI operations because of previously thrown Exception");
                return;
            }
            Systrace.beginSection(0, "dispatchNonBatchedUIOperations");
            try {
                dispatchPendingNonBatchedOperations(j);
                Systrace.endSection(0);
                UIViewOperationQueue.this.flushPendingBatches();
                ReactChoreographer.getInstance().postFrameCallback(ReactChoreographer.CallbackType.DISPATCH_UI, this);
            } catch (Throwable th) {
                Systrace.endSection(0);
                throw th;
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:12:?, code lost:
            r2 = android.os.SystemClock.uptimeMillis();
            r1.execute();
            r8.this$0.mNonBatchedExecutionTotalTime += android.os.SystemClock.uptimeMillis() - r2;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x0045, code lost:
            r9 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x0046, code lost:
            r8.this$0.mIsInIllegalUIState = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x004b, code lost:
            throw r9;
         */
        private void dispatchPendingNonBatchedOperations(long j) {
            while (16 - ((System.nanoTime() - j) / 1000000) >= ((long) this.mMinTimeLeftInFrameForNonBatchedOperationMs)) {
                synchronized (UIViewOperationQueue.this.mNonBatchedOperationsLock) {
                    if (!UIViewOperationQueue.this.mNonBatchedOperations.isEmpty()) {
                        UIOperation pollFirst = UIViewOperationQueue.this.mNonBatchedOperations.pollFirst();
                    } else {
                        return;
                    }
                }
            }
        }
    }
}
