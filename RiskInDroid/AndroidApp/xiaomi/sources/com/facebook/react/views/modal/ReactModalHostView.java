package com.facebook.react.views.modal;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStructure;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;
import android.widget.FrameLayout;
import com.facebook.common.logging.FLog;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.bridge.GuardedRunnable;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.WritableNativeMap;
import com.facebook.react.uimanager.JSTouchDispatcher;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.RootView;
import com.facebook.react.uimanager.StateWrapper;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.facebook.react.util.padcompat.PadCompatUtil;
import com.facebook.react.views.common.ContextUtils;
import com.facebook.react.views.view.ReactViewGroup;
import java.util.ArrayList;

public class ReactModalHostView extends ViewGroup implements LifecycleEventListener {
    private String mAnimationType;
    private Dialog mDialog;
    private boolean mHardwareAccelerated;
    private DialogRootViewGroup mHostView;
    public OnRequestCloseListener mOnRequestCloseListener;
    private DialogInterface.OnShowListener mOnShowListener;
    private boolean mPropertyRequiresNewDialog;
    private boolean mTransparent;

    public interface OnRequestCloseListener {
        void onRequestClose(DialogInterface dialogInterface);
    }

    public void addChildrenForAccessibility(ArrayList<View> arrayList) {
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return false;
    }

    public void onHostPause() {
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
    }

    public ReactModalHostView(Context context) {
        super(context);
        ((ReactContext) context).addLifecycleEventListener(this);
        this.mHostView = new DialogRootViewGroup(context);
    }

    @TargetApi(23)
    public void dispatchProvideStructure(ViewStructure viewStructure) {
        this.mHostView.dispatchProvideStructure(viewStructure);
    }

    public void addView(View view, int i) {
        this.mHostView.addView(view, i);
    }

    public int getChildCount() {
        return this.mHostView.getChildCount();
    }

    public View getChildAt(int i) {
        return this.mHostView.getChildAt(i);
    }

    public void removeView(View view) {
        this.mHostView.removeView(view);
    }

    public void removeViewAt(int i) {
        this.mHostView.removeView(getChildAt(i));
    }

    public void onDropInstance() {
        ((ReactContext) getContext()).removeLifecycleEventListener(this);
        dismiss();
    }

    private void dismiss() {
        Activity activity;
        Dialog dialog = this.mDialog;
        if (dialog != null) {
            if (dialog.isShowing() && ((activity = (Activity) ContextUtils.findContextOfType(this.mDialog.getContext(), Activity.class)) == null || !activity.isFinishing())) {
                this.mDialog.dismiss();
            }
            this.mDialog = null;
            ((ViewGroup) this.mHostView.getParent()).removeViewAt(0);
        }
    }

    /* access modifiers changed from: protected */
    public void setOnRequestCloseListener(OnRequestCloseListener onRequestCloseListener) {
        this.mOnRequestCloseListener = onRequestCloseListener;
    }

    /* access modifiers changed from: protected */
    public void setOnShowListener(DialogInterface.OnShowListener onShowListener) {
        this.mOnShowListener = onShowListener;
    }

    /* access modifiers changed from: protected */
    public void setTransparent(boolean z) {
        this.mTransparent = z;
    }

    /* access modifiers changed from: protected */
    public void setAnimationType(String str) {
        this.mAnimationType = str;
        this.mPropertyRequiresNewDialog = true;
    }

    /* access modifiers changed from: protected */
    public void setHardwareAccelerated(boolean z) {
        this.mHardwareAccelerated = z;
        this.mPropertyRequiresNewDialog = true;
    }

    public void onHostResume() {
        showOrUpdate();
    }

    public void onHostDestroy() {
        onDropInstance();
    }

    public Dialog getDialog() {
        return this.mDialog;
    }

    private Activity getCurrentActivity() {
        return ((ReactContext) getContext()).getCurrentActivity();
    }

    /* access modifiers changed from: protected */
    public void showOrUpdate() {
        if (this.mDialog != null) {
            if (this.mPropertyRequiresNewDialog) {
                dismiss();
            } else {
                updateProperties();
                return;
            }
        }
        this.mPropertyRequiresNewDialog = false;
        int i = 2132738852;
        if (this.mAnimationType.equals("fade")) {
            i = 2132738853;
        } else if (this.mAnimationType.equals("slide")) {
            i = 2132738854;
        }
        Activity currentActivity = getCurrentActivity();
        Context context = currentActivity == null ? getContext() : currentActivity;
        this.mDialog = new Dialog(context, i);
        this.mDialog.getWindow().setFlags(8, 8);
        this.mDialog.setContentView(getContentView());
        updateProperties();
        this.mDialog.setOnShowListener(this.mOnShowListener);
        this.mDialog.setOnKeyListener(new DialogInterface.OnKeyListener() {
            /* class com.facebook.react.views.modal.ReactModalHostView.AnonymousClass1 */

            public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                if (keyEvent.getAction() != 1) {
                    return false;
                }
                if (i == 4) {
                    Assertions.assertNotNull(ReactModalHostView.this.mOnRequestCloseListener, "setOnRequestCloseListener must be called by the manager");
                    ReactModalHostView.this.mOnRequestCloseListener.onRequestClose(dialogInterface);
                    return true;
                }
                Activity currentActivity = ((ReactContext) ReactModalHostView.this.getContext()).getCurrentActivity();
                if (currentActivity != null) {
                    return currentActivity.onKeyUp(i, keyEvent);
                }
                return false;
            }
        });
        this.mDialog.getWindow().setSoftInputMode(16);
        if (this.mHardwareAccelerated) {
            this.mDialog.getWindow().addFlags(16777216);
        }
        if (currentActivity != null && !currentActivity.isFinishing()) {
            try {
                this.mDialog.show();
                if (context instanceof Activity) {
                    this.mDialog.getWindow().getDecorView().setSystemUiVisibility(((Activity) context).getWindow().getDecorView().getSystemUiVisibility());
                }
                this.mDialog.getWindow().clearFlags(8);
            } catch (WindowManager.BadTokenException e) {
                FLog.w(ReactModalHostView.class, "mDialog.show error:", e);
            }
        }
    }

    public void updateState(StateWrapper stateWrapper, int i, int i2) {
        this.mHostView.updateState(stateWrapper, i, i2);
    }

    private View getContentView() {
        View handleModalContentViewWhenPad;
        if (PadCompatUtil.getInstance().isDialogThemePlugin() && (handleModalContentViewWhenPad = PadCompatUtil.getInstance().handleModalContentViewWhenPad(this.mHostView, getCurrentActivity())) != null) {
            return handleModalContentViewWhenPad;
        }
        FrameLayout frameLayout = new FrameLayout(getContext());
        frameLayout.addView(this.mHostView);
        frameLayout.setFitsSystemWindows(true);
        return frameLayout;
    }

    private void updateProperties() {
        Assertions.assertNotNull(this.mDialog, "mDialog must exist when we call updateProperties");
        Activity currentActivity = getCurrentActivity();
        if (currentActivity != null) {
            if ((currentActivity.getWindow().getAttributes().flags & 1024) != 0) {
                this.mDialog.getWindow().addFlags(1024);
            } else {
                this.mDialog.getWindow().clearFlags(1024);
            }
        }
        if (this.mTransparent) {
            this.mDialog.getWindow().clearFlags(2);
            return;
        }
        this.mDialog.getWindow().setDimAmount(0.5f);
        this.mDialog.getWindow().setFlags(2, 2);
    }

    static class DialogRootViewGroup extends ReactViewGroup implements RootView {
        private boolean hasAdjustedSize = false;
        private final JSTouchDispatcher mJSTouchDispatcher = new JSTouchDispatcher(this);
        private StateWrapper mStateWrapper;
        public int viewHeight;
        public int viewWidth;

        public void requestDisallowInterceptTouchEvent(boolean z) {
        }

        public DialogRootViewGroup(Context context) {
            super(context);
        }

        public void onSizeChanged(int i, int i2, int i3, int i4) {
            super.onSizeChanged(i, i2, i3, i4);
            this.viewWidth = i;
            this.viewHeight = i2;
            updateFirstChildView();
        }

        private void updateFirstChildView() {
            if (getChildCount() > 0) {
                this.hasAdjustedSize = false;
                final int id = getChildAt(0).getId();
                StateWrapper stateWrapper = this.mStateWrapper;
                if (stateWrapper != null) {
                    updateState(stateWrapper, this.viewWidth, this.viewHeight);
                    return;
                }
                ReactContext reactContext = getReactContext();
                reactContext.runOnNativeModulesQueueThread(new GuardedRunnable(reactContext) {
                    /* class com.facebook.react.views.modal.ReactModalHostView.DialogRootViewGroup.AnonymousClass1 */

                    public void runGuarded() {
                        ((UIManagerModule) DialogRootViewGroup.this.getReactContext().getNativeModule(UIManagerModule.class)).updateNodeSize(id, DialogRootViewGroup.this.viewWidth, DialogRootViewGroup.this.viewHeight);
                    }
                });
                return;
            }
            this.hasAdjustedSize = true;
        }

        public void updateState(StateWrapper stateWrapper, int i, int i2) {
            this.mStateWrapper = stateWrapper;
            WritableNativeMap writableNativeMap = new WritableNativeMap();
            writableNativeMap.putDouble("screenWidth", (double) PixelUtil.toDIPFromPixel((float) i));
            writableNativeMap.putDouble("screenHeight", (double) PixelUtil.toDIPFromPixel((float) i2));
            stateWrapper.updateState(writableNativeMap);
        }

        public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
            super.addView(view, i, layoutParams);
            if (this.hasAdjustedSize) {
                updateFirstChildView();
            }
        }

        public void handleException(Throwable th) {
            getReactContext().handleException(new RuntimeException(th));
        }

        public ReactContext getReactContext() {
            return (ReactContext) getContext();
        }

        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            this.mJSTouchDispatcher.handleTouchEvent(motionEvent, getEventDispatcher());
            return super.onInterceptTouchEvent(motionEvent);
        }

        public boolean onTouchEvent(MotionEvent motionEvent) {
            this.mJSTouchDispatcher.handleTouchEvent(motionEvent, getEventDispatcher());
            super.onTouchEvent(motionEvent);
            return true;
        }

        public void onChildStartedNativeGesture(MotionEvent motionEvent) {
            this.mJSTouchDispatcher.onChildStartedNativeGesture(motionEvent, getEventDispatcher());
        }

        private EventDispatcher getEventDispatcher() {
            return ((UIManagerModule) getReactContext().getNativeModule(UIManagerModule.class)).getEventDispatcher();
        }
    }
}
