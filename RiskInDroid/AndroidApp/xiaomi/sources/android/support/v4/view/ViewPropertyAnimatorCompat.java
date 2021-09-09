package android.support.v4.view;

import android.os.Build;
import android.view.View;
import android.view.animation.Interpolator;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

public final class ViewPropertyAnimatorCompat {
    static final ViewPropertyAnimatorCompatImpl IMPL;
    Runnable mEndAction = null;
    int mOldLayerType = -1;
    Runnable mStartAction = null;
    private WeakReference<View> mView;

    interface ViewPropertyAnimatorCompatImpl {
        void alpha(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f);

        void alphaBy(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f);

        void cancel(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view);

        long getDuration(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view);

        Interpolator getInterpolator(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view);

        long getStartDelay(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view);

        void rotation(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f);

        void rotationBy(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f);

        void rotationX(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f);

        void rotationXBy(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f);

        void rotationY(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f);

        void rotationYBy(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f);

        void scaleX(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f);

        void scaleXBy(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f);

        void scaleY(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f);

        void scaleYBy(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f);

        void setDuration(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, long j);

        void setInterpolator(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, Interpolator interpolator);

        void setListener(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, ViewPropertyAnimatorListener viewPropertyAnimatorListener);

        void setStartDelay(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, long j);

        void setUpdateListener(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, ViewPropertyAnimatorUpdateListener viewPropertyAnimatorUpdateListener);

        void start(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view);

        void translationX(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f);

        void translationXBy(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f);

        void translationY(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f);

        void translationYBy(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f);

        void translationZ(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f);

        void translationZBy(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f);

        void withEndAction(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, Runnable runnable);

        void withLayer(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view);

        void withStartAction(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, Runnable runnable);

        void x(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f);

        void xBy(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f);

        void y(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f);

        void yBy(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f);

        void z(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f);

        void zBy(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f);
    }

    ViewPropertyAnimatorCompat(View view) {
        this.mView = new WeakReference<>(view);
    }

    static class BaseViewPropertyAnimatorCompatImpl implements ViewPropertyAnimatorCompatImpl {
        WeakHashMap<View, Runnable> mStarterMap = null;

        public long getDuration(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view) {
            return 0;
        }

        public Interpolator getInterpolator(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view) {
            return null;
        }

        public long getStartDelay(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view) {
            return 0;
        }

        public void setDuration(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, long j) {
        }

        public void setInterpolator(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, Interpolator interpolator) {
        }

        public void setStartDelay(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, long j) {
        }

        public void setUpdateListener(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, ViewPropertyAnimatorUpdateListener viewPropertyAnimatorUpdateListener) {
        }

        public void translationZ(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f) {
        }

        public void translationZBy(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f) {
        }

        public void withLayer(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view) {
        }

        public void z(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f) {
        }

        public void zBy(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f) {
        }

        BaseViewPropertyAnimatorCompatImpl() {
        }

        public void alpha(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f) {
            postStartMessage(viewPropertyAnimatorCompat, view);
        }

        public void translationX(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f) {
            postStartMessage(viewPropertyAnimatorCompat, view);
        }

        public void translationY(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f) {
            postStartMessage(viewPropertyAnimatorCompat, view);
        }

        public void withEndAction(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, Runnable runnable) {
            viewPropertyAnimatorCompat.mEndAction = runnable;
            postStartMessage(viewPropertyAnimatorCompat, view);
        }

        public void alphaBy(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f) {
            postStartMessage(viewPropertyAnimatorCompat, view);
        }

        public void rotation(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f) {
            postStartMessage(viewPropertyAnimatorCompat, view);
        }

        public void rotationBy(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f) {
            postStartMessage(viewPropertyAnimatorCompat, view);
        }

        public void rotationX(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f) {
            postStartMessage(viewPropertyAnimatorCompat, view);
        }

        public void rotationXBy(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f) {
            postStartMessage(viewPropertyAnimatorCompat, view);
        }

        public void rotationY(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f) {
            postStartMessage(viewPropertyAnimatorCompat, view);
        }

        public void rotationYBy(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f) {
            postStartMessage(viewPropertyAnimatorCompat, view);
        }

        public void scaleX(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f) {
            postStartMessage(viewPropertyAnimatorCompat, view);
        }

        public void scaleXBy(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f) {
            postStartMessage(viewPropertyAnimatorCompat, view);
        }

        public void scaleY(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f) {
            postStartMessage(viewPropertyAnimatorCompat, view);
        }

        public void scaleYBy(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f) {
            postStartMessage(viewPropertyAnimatorCompat, view);
        }

        public void cancel(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view) {
            postStartMessage(viewPropertyAnimatorCompat, view);
        }

        public void x(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f) {
            postStartMessage(viewPropertyAnimatorCompat, view);
        }

        public void xBy(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f) {
            postStartMessage(viewPropertyAnimatorCompat, view);
        }

        public void y(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f) {
            postStartMessage(viewPropertyAnimatorCompat, view);
        }

        public void yBy(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f) {
            postStartMessage(viewPropertyAnimatorCompat, view);
        }

        public void translationXBy(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f) {
            postStartMessage(viewPropertyAnimatorCompat, view);
        }

        public void translationYBy(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f) {
            postStartMessage(viewPropertyAnimatorCompat, view);
        }

        public void start(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view) {
            removeStartMessage(view);
            startAnimation(viewPropertyAnimatorCompat, view);
        }

        public void withStartAction(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, Runnable runnable) {
            viewPropertyAnimatorCompat.mStartAction = runnable;
            postStartMessage(viewPropertyAnimatorCompat, view);
        }

        public void setListener(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, ViewPropertyAnimatorListener viewPropertyAnimatorListener) {
            view.setTag(2113929216, viewPropertyAnimatorListener);
        }

        /* access modifiers changed from: package-private */
        public void startAnimation(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view) {
            Object tag = view.getTag(2113929216);
            ViewPropertyAnimatorListener viewPropertyAnimatorListener = tag instanceof ViewPropertyAnimatorListener ? (ViewPropertyAnimatorListener) tag : null;
            Runnable runnable = viewPropertyAnimatorCompat.mStartAction;
            Runnable runnable2 = viewPropertyAnimatorCompat.mEndAction;
            viewPropertyAnimatorCompat.mStartAction = null;
            viewPropertyAnimatorCompat.mEndAction = null;
            if (runnable != null) {
                runnable.run();
            }
            if (viewPropertyAnimatorListener != null) {
                viewPropertyAnimatorListener.onAnimationStart(view);
                viewPropertyAnimatorListener.onAnimationEnd(view);
            }
            if (runnable2 != null) {
                runnable2.run();
            }
            WeakHashMap<View, Runnable> weakHashMap = this.mStarterMap;
            if (weakHashMap != null) {
                weakHashMap.remove(view);
            }
        }

        class Starter implements Runnable {
            WeakReference<View> mViewRef;
            ViewPropertyAnimatorCompat mVpa;

            Starter(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view) {
                this.mViewRef = new WeakReference<>(view);
                this.mVpa = viewPropertyAnimatorCompat;
            }

            public void run() {
                View view = this.mViewRef.get();
                if (view != null) {
                    BaseViewPropertyAnimatorCompatImpl.this.startAnimation(this.mVpa, view);
                }
            }
        }

        private void removeStartMessage(View view) {
            Runnable runnable;
            WeakHashMap<View, Runnable> weakHashMap = this.mStarterMap;
            if (weakHashMap != null && (runnable = weakHashMap.get(view)) != null) {
                view.removeCallbacks(runnable);
            }
        }

        private void postStartMessage(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view) {
            WeakHashMap<View, Runnable> weakHashMap = this.mStarterMap;
            Runnable runnable = weakHashMap != null ? weakHashMap.get(view) : null;
            if (runnable == null) {
                runnable = new Starter(viewPropertyAnimatorCompat, view);
                if (this.mStarterMap == null) {
                    this.mStarterMap = new WeakHashMap<>();
                }
                this.mStarterMap.put(view, runnable);
            }
            view.removeCallbacks(runnable);
            view.post(runnable);
        }
    }

    static class ICSViewPropertyAnimatorCompatImpl extends BaseViewPropertyAnimatorCompatImpl {
        WeakHashMap<View, Integer> mLayerMap = null;

        ICSViewPropertyAnimatorCompatImpl() {
        }

        public void setDuration(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, long j) {
            ViewPropertyAnimatorCompatICS.setDuration(view, j);
        }

        public void alpha(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f) {
            ViewPropertyAnimatorCompatICS.alpha(view, f);
        }

        public void translationX(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f) {
            ViewPropertyAnimatorCompatICS.translationX(view, f);
        }

        public void translationY(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f) {
            ViewPropertyAnimatorCompatICS.translationY(view, f);
        }

        public long getDuration(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view) {
            return ViewPropertyAnimatorCompatICS.getDuration(view);
        }

        public void setInterpolator(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, Interpolator interpolator) {
            ViewPropertyAnimatorCompatICS.setInterpolator(view, interpolator);
        }

        public void setStartDelay(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, long j) {
            ViewPropertyAnimatorCompatICS.setStartDelay(view, j);
        }

        public long getStartDelay(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view) {
            return ViewPropertyAnimatorCompatICS.getStartDelay(view);
        }

        public void alphaBy(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f) {
            ViewPropertyAnimatorCompatICS.alphaBy(view, f);
        }

        public void rotation(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f) {
            ViewPropertyAnimatorCompatICS.rotation(view, f);
        }

        public void rotationBy(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f) {
            ViewPropertyAnimatorCompatICS.rotationBy(view, f);
        }

        public void rotationX(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f) {
            ViewPropertyAnimatorCompatICS.rotationX(view, f);
        }

        public void rotationXBy(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f) {
            ViewPropertyAnimatorCompatICS.rotationXBy(view, f);
        }

        public void rotationY(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f) {
            ViewPropertyAnimatorCompatICS.rotationY(view, f);
        }

        public void rotationYBy(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f) {
            ViewPropertyAnimatorCompatICS.rotationYBy(view, f);
        }

        public void scaleX(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f) {
            ViewPropertyAnimatorCompatICS.scaleX(view, f);
        }

        public void scaleXBy(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f) {
            ViewPropertyAnimatorCompatICS.scaleXBy(view, f);
        }

        public void scaleY(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f) {
            ViewPropertyAnimatorCompatICS.scaleY(view, f);
        }

        public void scaleYBy(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f) {
            ViewPropertyAnimatorCompatICS.scaleYBy(view, f);
        }

        public void cancel(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view) {
            ViewPropertyAnimatorCompatICS.cancel(view);
        }

        public void x(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f) {
            ViewPropertyAnimatorCompatICS.x(view, f);
        }

        public void xBy(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f) {
            ViewPropertyAnimatorCompatICS.xBy(view, f);
        }

        public void y(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f) {
            ViewPropertyAnimatorCompatICS.y(view, f);
        }

        public void yBy(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f) {
            ViewPropertyAnimatorCompatICS.yBy(view, f);
        }

        public void translationXBy(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f) {
            ViewPropertyAnimatorCompatICS.translationXBy(view, f);
        }

        public void translationYBy(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f) {
            ViewPropertyAnimatorCompatICS.translationYBy(view, f);
        }

        public void start(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view) {
            ViewPropertyAnimatorCompatICS.start(view);
        }

        public void setListener(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, ViewPropertyAnimatorListener viewPropertyAnimatorListener) {
            view.setTag(2113929216, viewPropertyAnimatorListener);
            ViewPropertyAnimatorCompatICS.setListener(view, new MyVpaListener(viewPropertyAnimatorCompat));
        }

        public void withEndAction(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, Runnable runnable) {
            ViewPropertyAnimatorCompatICS.setListener(view, new MyVpaListener(viewPropertyAnimatorCompat));
            viewPropertyAnimatorCompat.mEndAction = runnable;
        }

        public void withStartAction(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, Runnable runnable) {
            ViewPropertyAnimatorCompatICS.setListener(view, new MyVpaListener(viewPropertyAnimatorCompat));
            viewPropertyAnimatorCompat.mStartAction = runnable;
        }

        public void withLayer(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view) {
            viewPropertyAnimatorCompat.mOldLayerType = ViewCompat.getLayerType(view);
            ViewPropertyAnimatorCompatICS.setListener(view, new MyVpaListener(viewPropertyAnimatorCompat));
        }

        static class MyVpaListener implements ViewPropertyAnimatorListener {
            boolean mAnimEndCalled;
            ViewPropertyAnimatorCompat mVpa;

            MyVpaListener(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat) {
                this.mVpa = viewPropertyAnimatorCompat;
            }

            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v6, resolved type: java.lang.Object} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: android.support.v4.view.ViewPropertyAnimatorListener} */
            /* JADX WARNING: Multi-variable type inference failed */
            public void onAnimationStart(View view) {
                this.mAnimEndCalled = false;
                ViewPropertyAnimatorListener viewPropertyAnimatorListener = null;
                if (this.mVpa.mOldLayerType >= 0) {
                    ViewCompat.setLayerType(view, 2, null);
                }
                if (this.mVpa.mStartAction != null) {
                    Runnable runnable = this.mVpa.mStartAction;
                    this.mVpa.mStartAction = null;
                    runnable.run();
                }
                Object tag = view.getTag(2113929216);
                if (tag instanceof ViewPropertyAnimatorListener) {
                    viewPropertyAnimatorListener = tag;
                }
                if (viewPropertyAnimatorListener != null) {
                    viewPropertyAnimatorListener.onAnimationStart(view);
                }
            }

            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v6, resolved type: java.lang.Object} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: android.support.v4.view.ViewPropertyAnimatorListener} */
            /* JADX WARNING: Multi-variable type inference failed */
            public void onAnimationEnd(View view) {
                ViewPropertyAnimatorListener viewPropertyAnimatorListener = null;
                if (this.mVpa.mOldLayerType >= 0) {
                    ViewCompat.setLayerType(view, this.mVpa.mOldLayerType, null);
                    this.mVpa.mOldLayerType = -1;
                }
                if (Build.VERSION.SDK_INT >= 16 || !this.mAnimEndCalled) {
                    if (this.mVpa.mEndAction != null) {
                        Runnable runnable = this.mVpa.mEndAction;
                        this.mVpa.mEndAction = null;
                        runnable.run();
                    }
                    Object tag = view.getTag(2113929216);
                    if (tag instanceof ViewPropertyAnimatorListener) {
                        viewPropertyAnimatorListener = tag;
                    }
                    if (viewPropertyAnimatorListener != null) {
                        viewPropertyAnimatorListener.onAnimationEnd(view);
                    }
                    this.mAnimEndCalled = true;
                }
            }

            public void onAnimationCancel(View view) {
                Object tag = view.getTag(2113929216);
                ViewPropertyAnimatorListener viewPropertyAnimatorListener = tag instanceof ViewPropertyAnimatorListener ? (ViewPropertyAnimatorListener) tag : null;
                if (viewPropertyAnimatorListener != null) {
                    viewPropertyAnimatorListener.onAnimationCancel(view);
                }
            }
        }
    }

    static class JBViewPropertyAnimatorCompatImpl extends ICSViewPropertyAnimatorCompatImpl {
        JBViewPropertyAnimatorCompatImpl() {
        }

        public void setListener(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, ViewPropertyAnimatorListener viewPropertyAnimatorListener) {
            ViewPropertyAnimatorCompatJB.setListener(view, viewPropertyAnimatorListener);
        }

        public void withStartAction(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, Runnable runnable) {
            ViewPropertyAnimatorCompatJB.withStartAction(view, runnable);
        }

        public void withEndAction(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, Runnable runnable) {
            ViewPropertyAnimatorCompatJB.withEndAction(view, runnable);
        }

        public void withLayer(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view) {
            ViewPropertyAnimatorCompatJB.withLayer(view);
        }
    }

    static class JBMr2ViewPropertyAnimatorCompatImpl extends JBViewPropertyAnimatorCompatImpl {
        JBMr2ViewPropertyAnimatorCompatImpl() {
        }

        public Interpolator getInterpolator(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view) {
            return ViewPropertyAnimatorCompatJellybeanMr2.getInterpolator(view);
        }
    }

    static class KitKatViewPropertyAnimatorCompatImpl extends JBMr2ViewPropertyAnimatorCompatImpl {
        KitKatViewPropertyAnimatorCompatImpl() {
        }

        public void setUpdateListener(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, ViewPropertyAnimatorUpdateListener viewPropertyAnimatorUpdateListener) {
            ViewPropertyAnimatorCompatKK.setUpdateListener(view, viewPropertyAnimatorUpdateListener);
        }
    }

    static class LollipopViewPropertyAnimatorCompatImpl extends KitKatViewPropertyAnimatorCompatImpl {
        LollipopViewPropertyAnimatorCompatImpl() {
        }

        public void translationZ(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f) {
            ViewPropertyAnimatorCompatLollipop.translationZ(view, f);
        }

        public void translationZBy(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f) {
            ViewPropertyAnimatorCompatLollipop.translationZBy(view, f);
        }

        public void z(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f) {
            ViewPropertyAnimatorCompatLollipop.z(view, f);
        }

        public void zBy(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f) {
            ViewPropertyAnimatorCompatLollipop.zBy(view, f);
        }
    }

    static {
        int i = Build.VERSION.SDK_INT;
        if (i >= 21) {
            IMPL = new LollipopViewPropertyAnimatorCompatImpl();
        } else if (i >= 19) {
            IMPL = new KitKatViewPropertyAnimatorCompatImpl();
        } else if (i >= 18) {
            IMPL = new JBMr2ViewPropertyAnimatorCompatImpl();
        } else if (i >= 16) {
            IMPL = new JBViewPropertyAnimatorCompatImpl();
        } else if (i >= 14) {
            IMPL = new ICSViewPropertyAnimatorCompatImpl();
        } else {
            IMPL = new BaseViewPropertyAnimatorCompatImpl();
        }
    }

    public final ViewPropertyAnimatorCompat setDuration(long j) {
        View view = this.mView.get();
        if (view != null) {
            IMPL.setDuration(this, view, j);
        }
        return this;
    }

    public final ViewPropertyAnimatorCompat alpha(float f) {
        View view = this.mView.get();
        if (view != null) {
            IMPL.alpha(this, view, f);
        }
        return this;
    }

    public final ViewPropertyAnimatorCompat alphaBy(float f) {
        View view = this.mView.get();
        if (view != null) {
            IMPL.alphaBy(this, view, f);
        }
        return this;
    }

    public final ViewPropertyAnimatorCompat translationX(float f) {
        View view = this.mView.get();
        if (view != null) {
            IMPL.translationX(this, view, f);
        }
        return this;
    }

    public final ViewPropertyAnimatorCompat translationY(float f) {
        View view = this.mView.get();
        if (view != null) {
            IMPL.translationY(this, view, f);
        }
        return this;
    }

    public final ViewPropertyAnimatorCompat withEndAction(Runnable runnable) {
        View view = this.mView.get();
        if (view != null) {
            IMPL.withEndAction(this, view, runnable);
        }
        return this;
    }

    public final long getDuration() {
        View view = this.mView.get();
        if (view != null) {
            return IMPL.getDuration(this, view);
        }
        return 0;
    }

    public final ViewPropertyAnimatorCompat setInterpolator(Interpolator interpolator) {
        View view = this.mView.get();
        if (view != null) {
            IMPL.setInterpolator(this, view, interpolator);
        }
        return this;
    }

    public final Interpolator getInterpolator() {
        View view = this.mView.get();
        if (view != null) {
            return IMPL.getInterpolator(this, view);
        }
        return null;
    }

    public final ViewPropertyAnimatorCompat setStartDelay(long j) {
        View view = this.mView.get();
        if (view != null) {
            IMPL.setStartDelay(this, view, j);
        }
        return this;
    }

    public final long getStartDelay() {
        View view = this.mView.get();
        if (view != null) {
            return IMPL.getStartDelay(this, view);
        }
        return 0;
    }

    public final ViewPropertyAnimatorCompat rotation(float f) {
        View view = this.mView.get();
        if (view != null) {
            IMPL.rotation(this, view, f);
        }
        return this;
    }

    public final ViewPropertyAnimatorCompat rotationBy(float f) {
        View view = this.mView.get();
        if (view != null) {
            IMPL.rotationBy(this, view, f);
        }
        return this;
    }

    public final ViewPropertyAnimatorCompat rotationX(float f) {
        View view = this.mView.get();
        if (view != null) {
            IMPL.rotationX(this, view, f);
        }
        return this;
    }

    public final ViewPropertyAnimatorCompat rotationXBy(float f) {
        View view = this.mView.get();
        if (view != null) {
            IMPL.rotationXBy(this, view, f);
        }
        return this;
    }

    public final ViewPropertyAnimatorCompat rotationY(float f) {
        View view = this.mView.get();
        if (view != null) {
            IMPL.rotationY(this, view, f);
        }
        return this;
    }

    public final ViewPropertyAnimatorCompat rotationYBy(float f) {
        View view = this.mView.get();
        if (view != null) {
            IMPL.rotationYBy(this, view, f);
        }
        return this;
    }

    public final ViewPropertyAnimatorCompat scaleX(float f) {
        View view = this.mView.get();
        if (view != null) {
            IMPL.scaleX(this, view, f);
        }
        return this;
    }

    public final ViewPropertyAnimatorCompat scaleXBy(float f) {
        View view = this.mView.get();
        if (view != null) {
            IMPL.scaleXBy(this, view, f);
        }
        return this;
    }

    public final ViewPropertyAnimatorCompat scaleY(float f) {
        View view = this.mView.get();
        if (view != null) {
            IMPL.scaleY(this, view, f);
        }
        return this;
    }

    public final ViewPropertyAnimatorCompat scaleYBy(float f) {
        View view = this.mView.get();
        if (view != null) {
            IMPL.scaleYBy(this, view, f);
        }
        return this;
    }

    public final void cancel() {
        View view = this.mView.get();
        if (view != null) {
            IMPL.cancel(this, view);
        }
    }

    public final ViewPropertyAnimatorCompat x(float f) {
        View view = this.mView.get();
        if (view != null) {
            IMPL.x(this, view, f);
        }
        return this;
    }

    public final ViewPropertyAnimatorCompat xBy(float f) {
        View view = this.mView.get();
        if (view != null) {
            IMPL.xBy(this, view, f);
        }
        return this;
    }

    public final ViewPropertyAnimatorCompat y(float f) {
        View view = this.mView.get();
        if (view != null) {
            IMPL.y(this, view, f);
        }
        return this;
    }

    public final ViewPropertyAnimatorCompat yBy(float f) {
        View view = this.mView.get();
        if (view != null) {
            IMPL.yBy(this, view, f);
        }
        return this;
    }

    public final ViewPropertyAnimatorCompat translationXBy(float f) {
        View view = this.mView.get();
        if (view != null) {
            IMPL.translationXBy(this, view, f);
        }
        return this;
    }

    public final ViewPropertyAnimatorCompat translationYBy(float f) {
        View view = this.mView.get();
        if (view != null) {
            IMPL.translationYBy(this, view, f);
        }
        return this;
    }

    public final ViewPropertyAnimatorCompat translationZBy(float f) {
        View view = this.mView.get();
        if (view != null) {
            IMPL.translationZBy(this, view, f);
        }
        return this;
    }

    public final ViewPropertyAnimatorCompat translationZ(float f) {
        View view = this.mView.get();
        if (view != null) {
            IMPL.translationZ(this, view, f);
        }
        return this;
    }

    public final ViewPropertyAnimatorCompat z(float f) {
        View view = this.mView.get();
        if (view != null) {
            IMPL.z(this, view, f);
        }
        return this;
    }

    public final ViewPropertyAnimatorCompat zBy(float f) {
        View view = this.mView.get();
        if (view != null) {
            IMPL.zBy(this, view, f);
        }
        return this;
    }

    public final void start() {
        View view = this.mView.get();
        if (view != null) {
            IMPL.start(this, view);
        }
    }

    public final ViewPropertyAnimatorCompat withLayer() {
        View view = this.mView.get();
        if (view != null) {
            IMPL.withLayer(this, view);
        }
        return this;
    }

    public final ViewPropertyAnimatorCompat withStartAction(Runnable runnable) {
        View view = this.mView.get();
        if (view != null) {
            IMPL.withStartAction(this, view, runnable);
        }
        return this;
    }

    public final ViewPropertyAnimatorCompat setListener(ViewPropertyAnimatorListener viewPropertyAnimatorListener) {
        View view = this.mView.get();
        if (view != null) {
            IMPL.setListener(this, view, viewPropertyAnimatorListener);
        }
        return this;
    }

    public final ViewPropertyAnimatorCompat setUpdateListener(ViewPropertyAnimatorUpdateListener viewPropertyAnimatorUpdateListener) {
        View view = this.mView.get();
        if (view != null) {
            IMPL.setUpdateListener(this, view, viewPropertyAnimatorUpdateListener);
        }
        return this;
    }
}
