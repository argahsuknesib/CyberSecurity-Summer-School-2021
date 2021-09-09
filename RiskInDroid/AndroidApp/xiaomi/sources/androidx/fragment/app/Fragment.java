package androidx.fragment.app;

import _m_j.bb;
import _m_j.bm;
import _m_j.d;
import _m_j.ea;
import _m_j.ec;
import _m_j.ed;
import _m_j.ee;
import _m_j.ef;
import _m_j.eg;
import _m_j.em;
import _m_j.ey;
import _m_j.fa;
import _m_j.fb;
import _m_j.fg;
import _m_j.fp;
import _m_j.fq;
import _m_j.fr;
import _m_j.ht;
import _m_j.hu;
import _m_j.hv;
import android.animation.Animator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.app.NotificationCompat;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LiveData;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class Fragment implements fa, fq, hv, ComponentCallbacks, View.OnCreateContextMenuListener {
    static final Object USE_DEFAULT_TRANSITION = new Object();
    public boolean mAdded;
    O000000o mAnimationInfo;
    Bundle mArguments;
    public int mBackStackNesting;
    private boolean mCalled;
    public ef mChildFragmentManager;
    public ViewGroup mContainer;
    public int mContainerId;
    private int mContentLayoutId;
    public boolean mDeferStart;
    public boolean mDetached;
    public int mFragmentId;
    public ef mFragmentManager;
    public boolean mFromLayout;
    public boolean mHasMenu;
    public boolean mHidden;
    public boolean mHiddenChanged;
    public ed mHost;
    public boolean mInLayout;
    public View mInnerView;
    public boolean mIsCreated;
    public boolean mIsNewlyAdded;
    private Boolean mIsPrimaryNavigationFragment;
    LayoutInflater mLayoutInflater;
    fb mLifecycleRegistry;
    public Lifecycle.State mMaxState;
    public boolean mMenuVisible;
    public Fragment mParentFragment;
    public boolean mPerformedCreateView;
    public float mPostponedAlpha;
    Runnable mPostponedDurationRunnable;
    public boolean mRemoving;
    public boolean mRestored;
    public boolean mRetainInstance;
    public boolean mRetainInstanceChangedWhileDetached;
    public Bundle mSavedFragmentState;
    hu mSavedStateRegistryController;
    public Boolean mSavedUserVisibleHint;
    public SparseArray<Parcelable> mSavedViewState;
    public int mState;
    public String mTag;
    public Fragment mTarget;
    public int mTargetRequestCode;
    public String mTargetWho;
    public boolean mUserVisibleHint;
    public View mView;
    public em mViewLifecycleOwner;
    public fg<fa> mViewLifecycleOwnerLiveData;
    public String mWho;

    public interface O00000Oo {
        void O000000o();

        void O00000Oo();
    }

    public void onActivityResult(int i, int i2, Intent intent) {
    }

    public void onAttachFragment(Fragment fragment) {
    }

    public boolean onContextItemSelected(MenuItem menuItem) {
        return false;
    }

    public Animation onCreateAnimation(int i, boolean z, int i2) {
        return null;
    }

    public Animator onCreateAnimator(int i, boolean z, int i2) {
        return null;
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
    }

    public void onDestroyOptionsMenu() {
    }

    public void onHiddenChanged(boolean z) {
    }

    public void onMultiWindowModeChanged(boolean z) {
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        return false;
    }

    public void onOptionsMenuClosed(Menu menu) {
    }

    public void onPictureInPictureModeChanged(boolean z) {
    }

    public void onPrepareOptionsMenu(Menu menu) {
    }

    public void onPrimaryNavigationFragmentChanged(boolean z) {
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
    }

    public void onSaveInstanceState(Bundle bundle) {
    }

    public void onViewCreated(View view, Bundle bundle) {
    }

    public Lifecycle getLifecycle() {
        return this.mLifecycleRegistry;
    }

    public fa getViewLifecycleOwner() {
        em emVar = this.mViewLifecycleOwner;
        if (emVar != null) {
            return emVar;
        }
        throw new IllegalStateException("Can't access the Fragment View's LifecycleOwner when getView() is null i.e., before onCreateView() or after onDestroyView()");
    }

    public LiveData<fa> getViewLifecycleOwnerLiveData() {
        return this.mViewLifecycleOwnerLiveData;
    }

    public fp getViewModelStore() {
        ef efVar = this.mFragmentManager;
        if (efVar != null) {
            eg egVar = efVar.O000O0o0;
            fp fpVar = egVar.O00000o0.get(this.mWho);
            if (fpVar != null) {
                return fpVar;
            }
            fp fpVar2 = new fp();
            egVar.O00000o0.put(this.mWho, fpVar2);
            return fpVar2;
        }
        throw new IllegalStateException("Can't access ViewModels from detached fragment");
    }

    public final ht getSavedStateRegistry() {
        return this.mSavedStateRegistryController.f690O000000o;
    }

    @SuppressLint({"BanParcelableUsage"})
    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() {
            /* class androidx.fragment.app.Fragment.SavedState.AnonymousClass1 */

            public final /* synthetic */ Object createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new SavedState[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }
        };

        /* renamed from: O000000o  reason: collision with root package name */
        final Bundle f2863O000000o;

        public int describeContents() {
            return 0;
        }

        SavedState(Parcel parcel, ClassLoader classLoader) {
            Bundle bundle;
            this.f2863O000000o = parcel.readBundle();
            if (classLoader != null && (bundle = this.f2863O000000o) != null) {
                bundle.setClassLoader(classLoader);
            }
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeBundle(this.f2863O000000o);
        }
    }

    public static class InstantiationException extends RuntimeException {
        public InstantiationException(String str, Exception exc) {
            super(str, exc);
        }
    }

    public Fragment() {
        this.mState = 0;
        this.mWho = UUID.randomUUID().toString();
        this.mTargetWho = null;
        this.mIsPrimaryNavigationFragment = null;
        this.mChildFragmentManager = new ef();
        this.mMenuVisible = true;
        this.mUserVisibleHint = true;
        this.mPostponedDurationRunnable = new Runnable() {
            /* class androidx.fragment.app.Fragment.AnonymousClass1 */

            public final void run() {
                Fragment.this.startPostponedEnterTransition();
            }
        };
        this.mMaxState = Lifecycle.State.RESUMED;
        this.mViewLifecycleOwnerLiveData = new fg<>();
        initLifecycle();
    }

    public Fragment(int i) {
        this();
        this.mContentLayoutId = i;
    }

    private void initLifecycle() {
        this.mLifecycleRegistry = new fb(this);
        this.mSavedStateRegistryController = hu.O000000o(this);
        if (Build.VERSION.SDK_INT >= 19) {
            this.mLifecycleRegistry.O000000o(new ey() {
                /* class androidx.fragment.app.Fragment.AnonymousClass2 */

                public final void O000000o(fa faVar, Lifecycle.Event event) {
                    if (event == Lifecycle.Event.ON_STOP && Fragment.this.mView != null) {
                        Fragment.this.mView.cancelPendingInputEvents();
                    }
                }
            });
        }
    }

    @Deprecated
    public static Fragment instantiate(Context context, String str) {
        return instantiate(context, str, null);
    }

    @Deprecated
    public static Fragment instantiate(Context context, String str, Bundle bundle) {
        try {
            Fragment fragment = (Fragment) ec.O00000Oo(context.getClassLoader(), str).getConstructor(new Class[0]).newInstance(new Object[0]);
            if (bundle != null) {
                bundle.setClassLoader(fragment.getClass().getClassLoader());
                fragment.setArguments(bundle);
            }
            return fragment;
        } catch (InstantiationException e) {
            throw new InstantiationException("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an empty constructor that is public", e);
        } catch (IllegalAccessException e2) {
            throw new InstantiationException("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an empty constructor that is public", e2);
        } catch (NoSuchMethodException e3) {
            throw new InstantiationException("Unable to instantiate fragment " + str + ": could not find Fragment constructor", e3);
        } catch (InvocationTargetException e4) {
            throw new InstantiationException("Unable to instantiate fragment " + str + ": calling Fragment constructor caused an exception", e4);
        }
    }

    public final void restoreViewState(Bundle bundle) {
        SparseArray<Parcelable> sparseArray = this.mSavedViewState;
        if (sparseArray != null) {
            this.mInnerView.restoreHierarchyState(sparseArray);
            this.mSavedViewState = null;
        }
        this.mCalled = false;
        onViewStateRestored(bundle);
        if (!this.mCalled) {
            throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onViewStateRestored()");
        } else if (this.mView != null) {
            this.mViewLifecycleOwner.O000000o(Lifecycle.Event.ON_CREATE);
        }
    }

    public final boolean isInBackStack() {
        return this.mBackStackNesting > 0;
    }

    public final boolean equals(Object obj) {
        return super.equals(obj);
    }

    public final int hashCode() {
        return super.hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder((int) NotificationCompat.FLAG_HIGH_PRIORITY);
        bb.O000000o(this, sb);
        sb.append(" (");
        sb.append(this.mWho);
        sb.append(")");
        if (this.mFragmentId != 0) {
            sb.append(" id=0x");
            sb.append(Integer.toHexString(this.mFragmentId));
        }
        if (this.mTag != null) {
            sb.append(" ");
            sb.append(this.mTag);
        }
        sb.append('}');
        return sb.toString();
    }

    public final int getId() {
        return this.mFragmentId;
    }

    public final String getTag() {
        return this.mTag;
    }

    public void setArguments(Bundle bundle) {
        if (this.mFragmentManager == null || !isStateSaved()) {
            this.mArguments = bundle;
            return;
        }
        throw new IllegalStateException("Fragment already added and state has been saved");
    }

    public final Bundle getArguments() {
        return this.mArguments;
    }

    public final Bundle requireArguments() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            return arguments;
        }
        throw new IllegalStateException("Fragment " + this + " does not have any arguments.");
    }

    public final boolean isStateSaved() {
        ef efVar = this.mFragmentManager;
        if (efVar == null) {
            return false;
        }
        return efVar.O0000Oo0();
    }

    public void setInitialSavedState(SavedState savedState) {
        if (this.mFragmentManager == null) {
            this.mSavedFragmentState = (savedState == null || savedState.f2863O000000o == null) ? null : savedState.f2863O000000o;
            return;
        }
        throw new IllegalStateException("Fragment already added");
    }

    public void setTargetFragment(Fragment fragment, int i) {
        ee fragmentManager = getFragmentManager();
        ee fragmentManager2 = fragment != null ? fragment.getFragmentManager() : null;
        if (fragmentManager == null || fragmentManager2 == null || fragmentManager == fragmentManager2) {
            Fragment fragment2 = fragment;
            while (fragment2 != null) {
                if (fragment2 != this) {
                    fragment2 = fragment2.getTargetFragment();
                } else {
                    throw new IllegalArgumentException("Setting " + fragment + " as the target of " + this + " would create a target cycle");
                }
            }
            if (fragment == null) {
                this.mTargetWho = null;
                this.mTarget = null;
            } else if (this.mFragmentManager == null || fragment.mFragmentManager == null) {
                this.mTargetWho = null;
                this.mTarget = fragment;
            } else {
                this.mTargetWho = fragment.mWho;
                this.mTarget = null;
            }
            this.mTargetRequestCode = i;
            return;
        }
        throw new IllegalArgumentException("Fragment " + fragment + " must share the same FragmentManager to be set as a target fragment");
    }

    public final Fragment getTargetFragment() {
        Fragment fragment = this.mTarget;
        if (fragment != null) {
            return fragment;
        }
        ef efVar = this.mFragmentManager;
        if (efVar == null || this.mTargetWho == null) {
            return null;
        }
        return efVar.O0000OOo.get(this.mTargetWho);
    }

    public final int getTargetRequestCode() {
        return this.mTargetRequestCode;
    }

    public Context getContext() {
        ed edVar = this.mHost;
        if (edVar == null) {
            return null;
        }
        return edVar.O00000o0;
    }

    public final Context requireContext() {
        Context context = getContext();
        if (context != null) {
            return context;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to a context.");
    }

    public final FragmentActivity getActivity() {
        ed edVar = this.mHost;
        if (edVar == null) {
            return null;
        }
        return (FragmentActivity) edVar.O00000Oo;
    }

    public final FragmentActivity requireActivity() {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            return activity;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to an activity.");
    }

    public final Object getHost() {
        ed edVar = this.mHost;
        if (edVar == null) {
            return null;
        }
        return edVar.O0000O0o();
    }

    public final Object requireHost() {
        Object host = getHost();
        if (host != null) {
            return host;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to a host.");
    }

    public final Resources getResources() {
        return requireContext().getResources();
    }

    public final CharSequence getText(int i) {
        return getResources().getText(i);
    }

    public final String getString(int i) {
        return getResources().getString(i);
    }

    public final String getString(int i, Object... objArr) {
        return getResources().getString(i, objArr);
    }

    public final ee getFragmentManager() {
        return this.mFragmentManager;
    }

    public final ee requireFragmentManager() {
        ee fragmentManager = getFragmentManager();
        if (fragmentManager != null) {
            return fragmentManager;
        }
        throw new IllegalStateException("Fragment " + this + " not associated with a fragment manager.");
    }

    public final ee getChildFragmentManager() {
        if (this.mHost != null) {
            return this.mChildFragmentManager;
        }
        throw new IllegalStateException("Fragment " + this + " has not been attached yet.");
    }

    public final Fragment getParentFragment() {
        return this.mParentFragment;
    }

    public final Fragment requireParentFragment() {
        Fragment parentFragment = getParentFragment();
        if (parentFragment != null) {
            return parentFragment;
        }
        if (getContext() == null) {
            throw new IllegalStateException("Fragment " + this + " is not attached to any Fragment or host");
        }
        throw new IllegalStateException("Fragment " + this + " is not a child Fragment, it is directly attached to " + getContext());
    }

    public final boolean isAdded() {
        return this.mHost != null && this.mAdded;
    }

    public final boolean isDetached() {
        return this.mDetached;
    }

    public final boolean isRemoving() {
        return this.mRemoving;
    }

    public final boolean isInLayout() {
        return this.mInLayout;
    }

    public final boolean isResumed() {
        return this.mState >= 4;
    }

    public final boolean isVisible() {
        View view;
        return isAdded() && !isHidden() && (view = this.mView) != null && view.getWindowToken() != null && this.mView.getVisibility() == 0;
    }

    public final boolean isHidden() {
        return this.mHidden;
    }

    public final boolean hasOptionsMenu() {
        return this.mHasMenu;
    }

    public final boolean isMenuVisible() {
        return this.mMenuVisible;
    }

    public void setRetainInstance(boolean z) {
        this.mRetainInstance = z;
        ef efVar = this.mFragmentManager;
        if (efVar == null) {
            this.mRetainInstanceChangedWhileDetached = true;
        } else if (z) {
            efVar.O00000Oo(this);
        } else {
            efVar.O00000o0(this);
        }
    }

    public final boolean getRetainInstance() {
        return this.mRetainInstance;
    }

    public void setHasOptionsMenu(boolean z) {
        if (this.mHasMenu != z) {
            this.mHasMenu = z;
            if (isAdded() && !isHidden()) {
                this.mHost.O00000o();
            }
        }
    }

    public void setMenuVisibility(boolean z) {
        if (this.mMenuVisible != z) {
            this.mMenuVisible = z;
            if (this.mHasMenu && isAdded() && !isHidden()) {
                this.mHost.O00000o();
            }
        }
    }

    @Deprecated
    public void setUserVisibleHint(boolean z) {
        if (!this.mUserVisibleHint && z && this.mState < 3 && this.mFragmentManager != null && isAdded() && this.mIsCreated) {
            this.mFragmentManager.O00000o(this);
        }
        this.mUserVisibleHint = z;
        this.mDeferStart = this.mState < 3 && !z;
        if (this.mSavedFragmentState != null) {
            this.mSavedUserVisibleHint = Boolean.valueOf(z);
        }
    }

    @Deprecated
    public boolean getUserVisibleHint() {
        return this.mUserVisibleHint;
    }

    @Deprecated
    public fr getLoaderManager() {
        return fr.O000000o(this);
    }

    public void startActivity(@SuppressLint({"UnknownNullness"}) Intent intent) {
        startActivity(intent, null);
    }

    public void startActivity(@SuppressLint({"UnknownNullness"}) Intent intent, Bundle bundle) {
        ed edVar = this.mHost;
        if (edVar != null) {
            edVar.O000000o(this, intent, -1, bundle);
            return;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to Activity");
    }

    public void startActivityForResult(@SuppressLint({"UnknownNullness"}) Intent intent, int i) {
        startActivityForResult(intent, i, null);
    }

    public void startActivityForResult(@SuppressLint({"UnknownNullness"}) Intent intent, int i, Bundle bundle) {
        ed edVar = this.mHost;
        if (edVar != null) {
            edVar.O000000o(this, intent, i, bundle);
            return;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to Activity");
    }

    public void startIntentSenderForResult(@SuppressLint({"UnknownNullness"}) IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4, Bundle bundle) throws IntentSender.SendIntentException {
        ed edVar = this.mHost;
        if (edVar != null) {
            edVar.O000000o(this, intentSender, i, intent, i2, i3, i4, bundle);
            return;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to Activity");
    }

    public final void requestPermissions(String[] strArr, int i) {
        ed edVar = this.mHost;
        if (edVar != null) {
            edVar.O000000o(this, strArr, i);
            return;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to Activity");
    }

    public boolean shouldShowRequestPermissionRationale(String str) {
        ed edVar = this.mHost;
        if (edVar != null) {
            return edVar.O000000o(str);
        }
        return false;
    }

    public LayoutInflater onGetLayoutInflater(Bundle bundle) {
        return getLayoutInflater(bundle);
    }

    public final LayoutInflater getLayoutInflater() {
        LayoutInflater layoutInflater = this.mLayoutInflater;
        return layoutInflater == null ? performGetLayoutInflater(null) : layoutInflater;
    }

    public LayoutInflater performGetLayoutInflater(Bundle bundle) {
        this.mLayoutInflater = onGetLayoutInflater(bundle);
        return this.mLayoutInflater;
    }

    @Deprecated
    public LayoutInflater getLayoutInflater(Bundle bundle) {
        ed edVar = this.mHost;
        if (edVar != null) {
            LayoutInflater O00000o0 = edVar.O00000o0();
            bm.O000000o(O00000o0, this.mChildFragmentManager);
            return O00000o0;
        }
        throw new IllegalStateException("onGetLayoutInflater() cannot be executed until the Fragment is attached to the FragmentManager.");
    }

    public void onInflate(Context context, AttributeSet attributeSet, Bundle bundle) {
        this.mCalled = true;
        ed edVar = this.mHost;
        Activity activity = edVar == null ? null : edVar.O00000Oo;
        if (activity != null) {
            this.mCalled = false;
            onInflate(activity, attributeSet, bundle);
        }
    }

    @Deprecated
    public void onInflate(Activity activity, AttributeSet attributeSet, Bundle bundle) {
        this.mCalled = true;
    }

    public void onAttach(Context context) {
        this.mCalled = true;
        ed edVar = this.mHost;
        Activity activity = edVar == null ? null : edVar.O00000Oo;
        if (activity != null) {
            this.mCalled = false;
            onAttach(activity);
        }
    }

    @Deprecated
    public void onAttach(Activity activity) {
        this.mCalled = true;
    }

    public void onCreate(Bundle bundle) {
        boolean z = true;
        this.mCalled = true;
        restoreChildFragmentState(bundle);
        if (this.mChildFragmentManager.O0000o0o <= 0) {
            z = false;
        }
        if (!z) {
            this.mChildFragmentManager.O0000o0O();
        }
    }

    public void restoreChildFragmentState(Bundle bundle) {
        Parcelable parcelable;
        if (bundle != null && (parcelable = bundle.getParcelable("android:support:fragments")) != null) {
            this.mChildFragmentManager.O000000o(parcelable);
            this.mChildFragmentManager.O0000o0O();
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [int, android.view.ViewGroup, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int i = this.mContentLayoutId;
        if (i != 0) {
            return layoutInflater.inflate(i, viewGroup, false);
        }
        return null;
    }

    public View getView() {
        return this.mView;
    }

    public final View requireView() {
        View view = getView();
        if (view != null) {
            return view;
        }
        throw new IllegalStateException("Fragment " + this + " did not return a View from onCreateView() or this was called before onCreateView().");
    }

    public void onActivityCreated(Bundle bundle) {
        this.mCalled = true;
    }

    public void onViewStateRestored(Bundle bundle) {
        this.mCalled = true;
    }

    public void onStart() {
        this.mCalled = true;
    }

    public void onResume() {
        this.mCalled = true;
    }

    public void onConfigurationChanged(Configuration configuration) {
        this.mCalled = true;
    }

    public void onPause() {
        this.mCalled = true;
    }

    public void onStop() {
        this.mCalled = true;
    }

    public void onLowMemory() {
        this.mCalled = true;
    }

    public void onDestroyView() {
        this.mCalled = true;
    }

    public void onDestroy() {
        this.mCalled = true;
    }

    public void initState() {
        initLifecycle();
        this.mWho = UUID.randomUUID().toString();
        this.mAdded = false;
        this.mRemoving = false;
        this.mFromLayout = false;
        this.mInLayout = false;
        this.mRestored = false;
        this.mBackStackNesting = 0;
        this.mFragmentManager = null;
        this.mChildFragmentManager = new ef();
        this.mHost = null;
        this.mFragmentId = 0;
        this.mContainerId = 0;
        this.mTag = null;
        this.mHidden = false;
        this.mDetached = false;
    }

    public void onDetach() {
        this.mCalled = true;
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        requireActivity().onCreateContextMenu(contextMenu, view, contextMenuInfo);
    }

    public void registerForContextMenu(View view) {
        view.setOnCreateContextMenuListener(this);
    }

    public void unregisterForContextMenu(View view) {
        view.setOnCreateContextMenuListener(null);
    }

    public void setEnterSharedElementCallback(d dVar) {
        ensureAnimationInfo().O0000o0O = dVar;
    }

    public void setExitSharedElementCallback(d dVar) {
        ensureAnimationInfo().O0000o0o = dVar;
    }

    public void setEnterTransition(Object obj) {
        ensureAnimationInfo().O0000O0o = obj;
    }

    public Object getEnterTransition() {
        O000000o o000000o = this.mAnimationInfo;
        if (o000000o == null) {
            return null;
        }
        return o000000o.O0000O0o;
    }

    public void setReturnTransition(Object obj) {
        ensureAnimationInfo().O0000OOo = obj;
    }

    public Object getReturnTransition() {
        O000000o o000000o = this.mAnimationInfo;
        if (o000000o == null) {
            return null;
        }
        return o000000o.O0000OOo == USE_DEFAULT_TRANSITION ? getEnterTransition() : this.mAnimationInfo.O0000OOo;
    }

    public void setExitTransition(Object obj) {
        ensureAnimationInfo().O0000Oo0 = obj;
    }

    public Object getExitTransition() {
        O000000o o000000o = this.mAnimationInfo;
        if (o000000o == null) {
            return null;
        }
        return o000000o.O0000Oo0;
    }

    public void setReenterTransition(Object obj) {
        ensureAnimationInfo().O0000Oo = obj;
    }

    public Object getReenterTransition() {
        O000000o o000000o = this.mAnimationInfo;
        if (o000000o == null) {
            return null;
        }
        return o000000o.O0000Oo == USE_DEFAULT_TRANSITION ? getExitTransition() : this.mAnimationInfo.O0000Oo;
    }

    public void setSharedElementEnterTransition(Object obj) {
        ensureAnimationInfo().O0000OoO = obj;
    }

    public Object getSharedElementEnterTransition() {
        O000000o o000000o = this.mAnimationInfo;
        if (o000000o == null) {
            return null;
        }
        return o000000o.O0000OoO;
    }

    public void setSharedElementReturnTransition(Object obj) {
        ensureAnimationInfo().O0000Ooo = obj;
    }

    public Object getSharedElementReturnTransition() {
        O000000o o000000o = this.mAnimationInfo;
        if (o000000o == null) {
            return null;
        }
        return o000000o.O0000Ooo == USE_DEFAULT_TRANSITION ? getSharedElementEnterTransition() : this.mAnimationInfo.O0000Ooo;
    }

    public void setAllowEnterTransitionOverlap(boolean z) {
        ensureAnimationInfo().O0000o0 = Boolean.valueOf(z);
    }

    public boolean getAllowEnterTransitionOverlap() {
        O000000o o000000o = this.mAnimationInfo;
        if (o000000o == null || o000000o.O0000o0 == null) {
            return true;
        }
        return this.mAnimationInfo.O0000o0.booleanValue();
    }

    public void setAllowReturnTransitionOverlap(boolean z) {
        ensureAnimationInfo().O0000o00 = Boolean.valueOf(z);
    }

    public boolean getAllowReturnTransitionOverlap() {
        O000000o o000000o = this.mAnimationInfo;
        if (o000000o == null || o000000o.O0000o00 == null) {
            return true;
        }
        return this.mAnimationInfo.O0000o00.booleanValue();
    }

    public void postponeEnterTransition() {
        ensureAnimationInfo().O0000o = true;
    }

    public final void postponeEnterTransition(long j, TimeUnit timeUnit) {
        Handler handler;
        ensureAnimationInfo().O0000o = true;
        ef efVar = this.mFragmentManager;
        if (efVar != null) {
            handler = efVar.O0000o.O00000o;
        } else {
            handler = new Handler(Looper.getMainLooper());
        }
        handler.removeCallbacks(this.mPostponedDurationRunnable);
        handler.postDelayed(this.mPostponedDurationRunnable, timeUnit.toMillis(j));
    }

    public void startPostponedEnterTransition() {
        ef efVar = this.mFragmentManager;
        if (efVar == null || efVar.O0000o == null) {
            ensureAnimationInfo().O0000o = false;
        } else if (Looper.myLooper() != this.mFragmentManager.O0000o.O00000o.getLooper()) {
            this.mFragmentManager.O0000o.O00000o.postAtFrontOfQueue(new Runnable() {
                /* class androidx.fragment.app.Fragment.AnonymousClass3 */

                public final void run() {
                    Fragment.this.callStartTransitionListener();
                }
            });
        } else {
            callStartTransitionListener();
        }
    }

    /* access modifiers changed from: package-private */
    public void callStartTransitionListener() {
        O00000Oo o00000Oo;
        O000000o o000000o = this.mAnimationInfo;
        if (o000000o == null) {
            o00000Oo = null;
        } else {
            o000000o.O0000o = false;
            o00000Oo = o000000o.O0000oO0;
            this.mAnimationInfo.O0000oO0 = null;
        }
        if (o00000Oo != null) {
            o00000Oo.O000000o();
        }
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.print(str);
        printWriter.print("mFragmentId=#");
        printWriter.print(Integer.toHexString(this.mFragmentId));
        printWriter.print(" mContainerId=#");
        printWriter.print(Integer.toHexString(this.mContainerId));
        printWriter.print(" mTag=");
        printWriter.println(this.mTag);
        printWriter.print(str);
        printWriter.print("mState=");
        printWriter.print(this.mState);
        printWriter.print(" mWho=");
        printWriter.print(this.mWho);
        printWriter.print(" mBackStackNesting=");
        printWriter.println(this.mBackStackNesting);
        printWriter.print(str);
        printWriter.print("mAdded=");
        printWriter.print(this.mAdded);
        printWriter.print(" mRemoving=");
        printWriter.print(this.mRemoving);
        printWriter.print(" mFromLayout=");
        printWriter.print(this.mFromLayout);
        printWriter.print(" mInLayout=");
        printWriter.println(this.mInLayout);
        printWriter.print(str);
        printWriter.print("mHidden=");
        printWriter.print(this.mHidden);
        printWriter.print(" mDetached=");
        printWriter.print(this.mDetached);
        printWriter.print(" mMenuVisible=");
        printWriter.print(this.mMenuVisible);
        printWriter.print(" mHasMenu=");
        printWriter.println(this.mHasMenu);
        printWriter.print(str);
        printWriter.print("mRetainInstance=");
        printWriter.print(this.mRetainInstance);
        printWriter.print(" mUserVisibleHint=");
        printWriter.println(this.mUserVisibleHint);
        if (this.mFragmentManager != null) {
            printWriter.print(str);
            printWriter.print("mFragmentManager=");
            printWriter.println(this.mFragmentManager);
        }
        if (this.mHost != null) {
            printWriter.print(str);
            printWriter.print("mHost=");
            printWriter.println(this.mHost);
        }
        if (this.mParentFragment != null) {
            printWriter.print(str);
            printWriter.print("mParentFragment=");
            printWriter.println(this.mParentFragment);
        }
        if (this.mArguments != null) {
            printWriter.print(str);
            printWriter.print("mArguments=");
            printWriter.println(this.mArguments);
        }
        if (this.mSavedFragmentState != null) {
            printWriter.print(str);
            printWriter.print("mSavedFragmentState=");
            printWriter.println(this.mSavedFragmentState);
        }
        if (this.mSavedViewState != null) {
            printWriter.print(str);
            printWriter.print("mSavedViewState=");
            printWriter.println(this.mSavedViewState);
        }
        Fragment targetFragment = getTargetFragment();
        if (targetFragment != null) {
            printWriter.print(str);
            printWriter.print("mTarget=");
            printWriter.print(targetFragment);
            printWriter.print(" mTargetRequestCode=");
            printWriter.println(this.mTargetRequestCode);
        }
        if (getNextAnim() != 0) {
            printWriter.print(str);
            printWriter.print("mNextAnim=");
            printWriter.println(getNextAnim());
        }
        if (this.mContainer != null) {
            printWriter.print(str);
            printWriter.print("mContainer=");
            printWriter.println(this.mContainer);
        }
        if (this.mView != null) {
            printWriter.print(str);
            printWriter.print("mView=");
            printWriter.println(this.mView);
        }
        if (this.mInnerView != null) {
            printWriter.print(str);
            printWriter.print("mInnerView=");
            printWriter.println(this.mView);
        }
        if (getAnimatingAway() != null) {
            printWriter.print(str);
            printWriter.print("mAnimatingAway=");
            printWriter.println(getAnimatingAway());
            printWriter.print(str);
            printWriter.print("mStateAfterAnimating=");
            printWriter.println(getStateAfterAnimating());
        }
        if (getContext() != null) {
            fr.O000000o(this).O000000o(str, fileDescriptor, printWriter, strArr);
        }
        printWriter.print(str);
        printWriter.println("Child " + this.mChildFragmentManager + ":");
        ef efVar = this.mChildFragmentManager;
        efVar.O000000o(str + "  ", fileDescriptor, printWriter, strArr);
    }

    public Fragment findFragmentByWho(String str) {
        if (str.equals(this.mWho)) {
            return this;
        }
        return this.mChildFragmentManager.O00000o0(str);
    }

    public void performAttach() {
        this.mChildFragmentManager.O000000o(this.mHost, new ea() {
            /* class androidx.fragment.app.Fragment.AnonymousClass4 */

            public final View O000000o(int i) {
                if (Fragment.this.mView != null) {
                    return Fragment.this.mView.findViewById(i);
                }
                throw new IllegalStateException("Fragment " + this + " does not have a view");
            }

            public final boolean O000000o() {
                return Fragment.this.mView != null;
            }
        }, this);
        this.mCalled = false;
        onAttach(this.mHost.O00000o0);
        if (!this.mCalled) {
            throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onAttach()");
        }
    }

    public void performCreate(Bundle bundle) {
        this.mChildFragmentManager.O0000o0();
        this.mState = 1;
        this.mCalled = false;
        this.mSavedStateRegistryController.O000000o(bundle);
        onCreate(bundle);
        this.mIsCreated = true;
        if (this.mCalled) {
            this.mLifecycleRegistry.O000000o(Lifecycle.Event.ON_CREATE);
            return;
        }
        throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onCreate()");
    }

    public void performCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mChildFragmentManager.O0000o0();
        boolean z = true;
        this.mPerformedCreateView = true;
        this.mViewLifecycleOwner = new em();
        this.mView = onCreateView(layoutInflater, viewGroup, bundle);
        if (this.mView != null) {
            this.mViewLifecycleOwner.O000000o();
            this.mViewLifecycleOwnerLiveData.setValue(this.mViewLifecycleOwner);
            return;
        }
        if (this.mViewLifecycleOwner.f15620O000000o == null) {
            z = false;
        }
        if (!z) {
            this.mViewLifecycleOwner = null;
            return;
        }
        throw new IllegalStateException("Called getViewLifecycleOwner() but onCreateView() returned null");
    }

    public void performActivityCreated(Bundle bundle) {
        this.mChildFragmentManager.O0000o0();
        this.mState = 2;
        this.mCalled = false;
        onActivityCreated(bundle);
        if (this.mCalled) {
            this.mChildFragmentManager.O0000o0o();
            return;
        }
        throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onActivityCreated()");
    }

    public void performStart() {
        this.mChildFragmentManager.O0000o0();
        this.mChildFragmentManager.O0000Ooo();
        this.mState = 3;
        this.mCalled = false;
        onStart();
        if (this.mCalled) {
            this.mLifecycleRegistry.O000000o(Lifecycle.Event.ON_START);
            if (this.mView != null) {
                this.mViewLifecycleOwner.O000000o(Lifecycle.Event.ON_START);
            }
            this.mChildFragmentManager.O0000o();
            return;
        }
        throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onStart()");
    }

    public void performResume() {
        this.mChildFragmentManager.O0000o0();
        this.mChildFragmentManager.O0000Ooo();
        this.mState = 4;
        this.mCalled = false;
        onResume();
        if (this.mCalled) {
            this.mLifecycleRegistry.O000000o(Lifecycle.Event.ON_RESUME);
            if (this.mView != null) {
                this.mViewLifecycleOwner.O000000o(Lifecycle.Event.ON_RESUME);
            }
            this.mChildFragmentManager.O0000oO0();
            this.mChildFragmentManager.O0000Ooo();
            return;
        }
        throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onResume()");
    }

    public void noteStateNotSaved() {
        this.mChildFragmentManager.O0000o0();
    }

    public void performPrimaryNavigationFragmentChanged() {
        boolean O000000o2 = this.mFragmentManager.O000000o(this);
        Boolean bool = this.mIsPrimaryNavigationFragment;
        if (bool == null || bool.booleanValue() != O000000o2) {
            this.mIsPrimaryNavigationFragment = Boolean.valueOf(O000000o2);
            onPrimaryNavigationFragmentChanged(O000000o2);
            ef efVar = this.mChildFragmentManager;
            efVar.O0000Oo();
            efVar.O0000o00(efVar.O0000oOO);
        }
    }

    public void performMultiWindowModeChanged(boolean z) {
        onMultiWindowModeChanged(z);
        this.mChildFragmentManager.O000000o(z);
    }

    public void performPictureInPictureModeChanged(boolean z) {
        onPictureInPictureModeChanged(z);
        this.mChildFragmentManager.O00000Oo(z);
    }

    public void performConfigurationChanged(Configuration configuration) {
        onConfigurationChanged(configuration);
        this.mChildFragmentManager.O000000o(configuration);
    }

    public void performLowMemory() {
        onLowMemory();
        this.mChildFragmentManager.O0000oOo();
    }

    public boolean performCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        boolean z = false;
        if (this.mHidden) {
            return false;
        }
        if (this.mHasMenu && this.mMenuVisible) {
            z = true;
            onCreateOptionsMenu(menu, menuInflater);
        }
        return z | this.mChildFragmentManager.O000000o(menu, menuInflater);
    }

    public boolean performPrepareOptionsMenu(Menu menu) {
        boolean z = false;
        if (this.mHidden) {
            return false;
        }
        if (this.mHasMenu && this.mMenuVisible) {
            z = true;
            onPrepareOptionsMenu(menu);
        }
        return z | this.mChildFragmentManager.O000000o(menu);
    }

    public boolean performOptionsItemSelected(MenuItem menuItem) {
        if (this.mHidden) {
            return false;
        }
        if ((!this.mHasMenu || !this.mMenuVisible || !onOptionsItemSelected(menuItem)) && !this.mChildFragmentManager.O000000o(menuItem)) {
            return false;
        }
        return true;
    }

    public boolean performContextItemSelected(MenuItem menuItem) {
        if (this.mHidden) {
            return false;
        }
        if (!onContextItemSelected(menuItem) && !this.mChildFragmentManager.O00000Oo(menuItem)) {
            return false;
        }
        return true;
    }

    public void performOptionsMenuClosed(Menu menu) {
        if (!this.mHidden) {
            if (this.mHasMenu && this.mMenuVisible) {
                onOptionsMenuClosed(menu);
            }
            this.mChildFragmentManager.O00000Oo(menu);
        }
    }

    public void performSaveInstanceState(Bundle bundle) {
        onSaveInstanceState(bundle);
        this.mSavedStateRegistryController.O00000Oo(bundle);
        Parcelable O0000o00 = this.mChildFragmentManager.O0000o00();
        if (O0000o00 != null) {
            bundle.putParcelable("android:support:fragments", O0000o00);
        }
    }

    public void performPause() {
        this.mChildFragmentManager.O00000o0(3);
        if (this.mView != null) {
            this.mViewLifecycleOwner.O000000o(Lifecycle.Event.ON_PAUSE);
        }
        this.mLifecycleRegistry.O000000o(Lifecycle.Event.ON_PAUSE);
        this.mState = 3;
        this.mCalled = false;
        onPause();
        if (!this.mCalled) {
            throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onPause()");
        }
    }

    public void performStop() {
        this.mChildFragmentManager.O0000oO();
        if (this.mView != null) {
            this.mViewLifecycleOwner.O000000o(Lifecycle.Event.ON_STOP);
        }
        this.mLifecycleRegistry.O000000o(Lifecycle.Event.ON_STOP);
        this.mState = 2;
        this.mCalled = false;
        onStop();
        if (!this.mCalled) {
            throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onStop()");
        }
    }

    public void performDestroyView() {
        this.mChildFragmentManager.O00000o0(1);
        if (this.mView != null) {
            this.mViewLifecycleOwner.O000000o(Lifecycle.Event.ON_DESTROY);
        }
        this.mState = 1;
        this.mCalled = false;
        onDestroyView();
        if (this.mCalled) {
            fr.O000000o(this).O000000o();
            this.mPerformedCreateView = false;
            return;
        }
        throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onDestroyView()");
    }

    public void performDestroy() {
        this.mChildFragmentManager.O0000oOO();
        this.mLifecycleRegistry.O000000o(Lifecycle.Event.ON_DESTROY);
        this.mState = 0;
        this.mCalled = false;
        this.mIsCreated = false;
        onDestroy();
        if (!this.mCalled) {
            throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onDestroy()");
        }
    }

    public void performDetach() {
        this.mCalled = false;
        onDetach();
        this.mLayoutInflater = null;
        if (!this.mCalled) {
            throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onDetach()");
        } else if (!this.mChildFragmentManager.O0000ooO) {
            this.mChildFragmentManager.O0000oOO();
            this.mChildFragmentManager = new ef();
        }
    }

    public void setOnStartEnterTransitionListener(O00000Oo o00000Oo) {
        ensureAnimationInfo();
        if (o00000Oo != this.mAnimationInfo.O0000oO0) {
            if (o00000Oo == null || this.mAnimationInfo.O0000oO0 == null) {
                if (this.mAnimationInfo.O0000o) {
                    this.mAnimationInfo.O0000oO0 = o00000Oo;
                }
                if (o00000Oo != null) {
                    o00000Oo.O00000Oo();
                    return;
                }
                return;
            }
            throw new IllegalStateException("Trying to set a replacement startPostponedEnterTransition on ".concat(String.valueOf(this)));
        }
    }

    private O000000o ensureAnimationInfo() {
        if (this.mAnimationInfo == null) {
            this.mAnimationInfo = new O000000o();
        }
        return this.mAnimationInfo;
    }

    public int getNextAnim() {
        O000000o o000000o = this.mAnimationInfo;
        if (o000000o == null) {
            return 0;
        }
        return o000000o.O00000o;
    }

    public void setNextAnim(int i) {
        if (this.mAnimationInfo != null || i != 0) {
            ensureAnimationInfo().O00000o = i;
        }
    }

    public int getNextTransition() {
        O000000o o000000o = this.mAnimationInfo;
        if (o000000o == null) {
            return 0;
        }
        return o000000o.O00000oO;
    }

    public void setNextTransition(int i, int i2) {
        if (this.mAnimationInfo != null || i != 0 || i2 != 0) {
            ensureAnimationInfo();
            O000000o o000000o = this.mAnimationInfo;
            o000000o.O00000oO = i;
            o000000o.O00000oo = i2;
        }
    }

    public int getNextTransitionStyle() {
        O000000o o000000o = this.mAnimationInfo;
        if (o000000o == null) {
            return 0;
        }
        return o000000o.O00000oo;
    }

    public d getEnterTransitionCallback() {
        O000000o o000000o = this.mAnimationInfo;
        if (o000000o == null) {
            return null;
        }
        return o000000o.O0000o0O;
    }

    public d getExitTransitionCallback() {
        O000000o o000000o = this.mAnimationInfo;
        if (o000000o == null) {
            return null;
        }
        return o000000o.O0000o0o;
    }

    public View getAnimatingAway() {
        O000000o o000000o = this.mAnimationInfo;
        if (o000000o == null) {
            return null;
        }
        return o000000o.f2862O000000o;
    }

    public void setAnimatingAway(View view) {
        ensureAnimationInfo().f2862O000000o = view;
    }

    public void setAnimator(Animator animator) {
        ensureAnimationInfo().O00000Oo = animator;
    }

    public Animator getAnimator() {
        O000000o o000000o = this.mAnimationInfo;
        if (o000000o == null) {
            return null;
        }
        return o000000o.O00000Oo;
    }

    public int getStateAfterAnimating() {
        O000000o o000000o = this.mAnimationInfo;
        if (o000000o == null) {
            return 0;
        }
        return o000000o.O00000o0;
    }

    public void setStateAfterAnimating(int i) {
        ensureAnimationInfo().O00000o0 = i;
    }

    public boolean isPostponed() {
        O000000o o000000o = this.mAnimationInfo;
        if (o000000o == null) {
            return false;
        }
        return o000000o.O0000o;
    }

    public boolean isHideReplaced() {
        O000000o o000000o = this.mAnimationInfo;
        if (o000000o == null) {
            return false;
        }
        return o000000o.O0000oO;
    }

    public void setHideReplaced(boolean z) {
        ensureAnimationInfo().O0000oO = z;
    }

    static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        View f2862O000000o;
        Animator O00000Oo;
        int O00000o;
        int O00000o0;
        int O00000oO;
        int O00000oo;
        Object O0000O0o = null;
        Object O0000OOo = Fragment.USE_DEFAULT_TRANSITION;
        Object O0000Oo = Fragment.USE_DEFAULT_TRANSITION;
        Object O0000Oo0 = null;
        Object O0000OoO = null;
        Object O0000Ooo = Fragment.USE_DEFAULT_TRANSITION;
        boolean O0000o;
        Boolean O0000o0;
        Boolean O0000o00;
        d O0000o0O = null;
        d O0000o0o = null;
        boolean O0000oO;
        O00000Oo O0000oO0;

        O000000o() {
        }
    }
}
