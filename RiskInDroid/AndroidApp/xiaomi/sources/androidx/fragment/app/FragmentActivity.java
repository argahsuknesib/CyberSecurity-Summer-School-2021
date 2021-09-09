package androidx.fragment.app;

import _m_j.O0Oo;
import _m_j.d;
import _m_j.eb;
import _m_j.ed;
import _m_j.ee;
import _m_j.fb;
import _m_j.fp;
import _m_j.fq;
import _m_j.fr;
import _m_j.o0OO00o0;
import _m_j.oOOO00o0;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import androidx.activity.ComponentActivity;
import androidx.activity.OnBackPressedDispatcher;
import androidx.lifecycle.Lifecycle;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public class FragmentActivity extends ComponentActivity implements oOOO00o0.O000000o, oOOO00o0.O00000o0 {
    boolean mCreated;
    final fb mFragmentLifecycleRegistry = new fb(this);
    final eb mFragments = eb.O000000o(new O000000o());
    int mNextCandidateRequestIndex;
    o0OO00o0<String> mPendingFragmentActivityResults;
    boolean mRequestedPermissionsFromFragment;
    boolean mResumed;
    boolean mStartedActivityFromFragment;
    boolean mStartedIntentSenderFromFragment;
    boolean mStopped = true;

    public void onAttachFragment(Fragment fragment) {
    }

    public FragmentActivity() {
    }

    public FragmentActivity(int i) {
        super(i);
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        this.mFragments.O000000o();
        int i3 = i >> 16;
        if (i3 != 0) {
            int i4 = i3 - 1;
            String O000000o2 = this.mPendingFragmentActivityResults.O000000o(i4, null);
            this.mPendingFragmentActivityResults.O000000o(i4);
            if (O000000o2 == null) {
                Log.w("FragmentActivity", "Activity result delivered for unknown Fragment.");
                return;
            }
            Fragment O000000o3 = this.mFragments.O000000o(O000000o2);
            if (O000000o3 == null) {
                Log.w("FragmentActivity", "Activity result no fragment exists for who: ".concat(String.valueOf(O000000o2)));
            } else {
                O000000o3.onActivityResult(i & 65535, i2, intent);
            }
        } else {
            oOOO00o0.O00000Oo O000000o4 = oOOO00o0.O000000o();
            if (O000000o4 == null || !O000000o4.O00000Oo()) {
                super.onActivityResult(i, i2, intent);
            }
        }
    }

    public void supportFinishAfterTransition() {
        oOOO00o0.O00000Oo((Activity) this);
    }

    public void setEnterSharedElementCallback(d dVar) {
        oOOO00o0.O000000o(this, dVar);
    }

    public void setExitSharedElementCallback(d dVar) {
        oOOO00o0.O00000Oo(this, dVar);
    }

    public void supportPostponeEnterTransition() {
        oOOO00o0.O00000o0((Activity) this);
    }

    public void supportStartPostponedEnterTransition() {
        oOOO00o0.O00000o((Activity) this);
    }

    public void onMultiWindowModeChanged(boolean z) {
        this.mFragments.f15137O000000o.O00000oO.O000000o(z);
    }

    public void onPictureInPictureModeChanged(boolean z) {
        this.mFragments.f15137O000000o.O00000oO.O00000Oo(z);
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.mFragments.O000000o();
        this.mFragments.f15137O000000o.O00000oO.O000000o(configuration);
    }

    public void onCreate(Bundle bundle) {
        eb ebVar = this.mFragments;
        ebVar.f15137O000000o.O00000oO.O000000o(ebVar.f15137O000000o, ebVar.f15137O000000o, (Fragment) null);
        if (bundle != null) {
            Parcelable parcelable = bundle.getParcelable("android:support:fragments");
            eb ebVar2 = this.mFragments;
            if (ebVar2.f15137O000000o instanceof fq) {
                ebVar2.f15137O000000o.O00000oO.O000000o(parcelable);
                if (bundle.containsKey("android:support:next_request_index")) {
                    this.mNextCandidateRequestIndex = bundle.getInt("android:support:next_request_index");
                    int[] intArray = bundle.getIntArray("android:support:request_indicies");
                    String[] stringArray = bundle.getStringArray("android:support:request_fragment_who");
                    if (intArray == null || stringArray == null || intArray.length != stringArray.length) {
                        Log.w("FragmentActivity", "Invalid requestCode mapping in savedInstanceState.");
                    } else {
                        this.mPendingFragmentActivityResults = new o0OO00o0<>(intArray.length);
                        for (int i = 0; i < intArray.length; i++) {
                            this.mPendingFragmentActivityResults.O00000Oo(intArray[i], stringArray[i]);
                        }
                    }
                }
            } else {
                throw new IllegalStateException("Your FragmentHostCallback must implement ViewModelStoreOwner to call restoreSaveState(). Call restoreAllState()  if you're still using retainNestedNonConfig().");
            }
        }
        if (this.mPendingFragmentActivityResults == null) {
            this.mPendingFragmentActivityResults = new o0OO00o0<>();
            this.mNextCandidateRequestIndex = 0;
        }
        super.onCreate(bundle);
        this.mFragmentLifecycleRegistry.O000000o(Lifecycle.Event.ON_CREATE);
        this.mFragments.f15137O000000o.O00000oO.O0000o0O();
    }

    public boolean onCreatePanelMenu(int i, Menu menu) {
        if (i != 0) {
            return super.onCreatePanelMenu(i, menu);
        }
        boolean onCreatePanelMenu = super.onCreatePanelMenu(i, menu);
        eb ebVar = this.mFragments;
        return onCreatePanelMenu | ebVar.f15137O000000o.O00000oO.O000000o(menu, getMenuInflater());
    }

    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        View dispatchFragmentsOnCreateView = dispatchFragmentsOnCreateView(view, str, context, attributeSet);
        return dispatchFragmentsOnCreateView == null ? super.onCreateView(view, str, context, attributeSet) : dispatchFragmentsOnCreateView;
    }

    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        View dispatchFragmentsOnCreateView = dispatchFragmentsOnCreateView(null, str, context, attributeSet);
        return dispatchFragmentsOnCreateView == null ? super.onCreateView(str, context, attributeSet) : dispatchFragmentsOnCreateView;
    }

    /* access modifiers changed from: package-private */
    public final View dispatchFragmentsOnCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        return this.mFragments.f15137O000000o.O00000oO.onCreateView(view, str, context, attributeSet);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        this.mFragments.f15137O000000o.O00000oO.O0000oOO();
        this.mFragmentLifecycleRegistry.O000000o(Lifecycle.Event.ON_DESTROY);
    }

    public void onLowMemory() {
        super.onLowMemory();
        this.mFragments.f15137O000000o.O00000oO.O0000oOo();
    }

    public boolean onMenuItemSelected(int i, MenuItem menuItem) {
        if (super.onMenuItemSelected(i, menuItem)) {
            return true;
        }
        if (i == 0) {
            return this.mFragments.f15137O000000o.O00000oO.O000000o(menuItem);
        }
        if (i != 6) {
            return false;
        }
        return this.mFragments.f15137O000000o.O00000oO.O00000Oo(menuItem);
    }

    public void onPanelClosed(int i, Menu menu) {
        if (i == 0) {
            this.mFragments.f15137O000000o.O00000oO.O00000Oo(menu);
        }
        super.onPanelClosed(i, menu);
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        this.mResumed = false;
        this.mFragments.f15137O000000o.O00000oO.O00000o0(3);
        this.mFragmentLifecycleRegistry.O000000o(Lifecycle.Event.ON_PAUSE);
    }

    /* access modifiers changed from: protected */
    public void onNewIntent(@SuppressLint({"UnknownNullness"}) Intent intent) {
        super.onNewIntent(intent);
        this.mFragments.O000000o();
    }

    public void onStateNotSaved() {
        this.mFragments.O000000o();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        this.mResumed = true;
        this.mFragments.O000000o();
        this.mFragments.O00000Oo();
    }

    /* access modifiers changed from: protected */
    public void onPostResume() {
        super.onPostResume();
        onResumeFragments();
    }

    /* access modifiers changed from: protected */
    public void onResumeFragments() {
        this.mFragmentLifecycleRegistry.O000000o(Lifecycle.Event.ON_RESUME);
        this.mFragments.f15137O000000o.O00000oO.O0000oO0();
    }

    public boolean onPreparePanel(int i, View view, Menu menu) {
        return i == 0 ? onPrepareOptionsPanel(view, menu) | this.mFragments.f15137O000000o.O00000oO.O000000o(menu) : super.onPreparePanel(i, view, menu);
    }

    /* access modifiers changed from: protected */
    @Deprecated
    public boolean onPrepareOptionsPanel(View view, Menu menu) {
        return super.onPreparePanel(0, view, menu);
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        markFragmentsCreated();
        this.mFragmentLifecycleRegistry.O000000o(Lifecycle.Event.ON_STOP);
        Parcelable O0000o00 = this.mFragments.f15137O000000o.O00000oO.O0000o00();
        if (O0000o00 != null) {
            bundle.putParcelable("android:support:fragments", O0000o00);
        }
        if (this.mPendingFragmentActivityResults.O00000Oo() > 0) {
            bundle.putInt("android:support:next_request_index", this.mNextCandidateRequestIndex);
            int[] iArr = new int[this.mPendingFragmentActivityResults.O00000Oo()];
            String[] strArr = new String[this.mPendingFragmentActivityResults.O00000Oo()];
            for (int i = 0; i < this.mPendingFragmentActivityResults.O00000Oo(); i++) {
                iArr[i] = this.mPendingFragmentActivityResults.O00000Oo(i);
                strArr[i] = this.mPendingFragmentActivityResults.O00000o0(i);
            }
            bundle.putIntArray("android:support:request_indicies", iArr);
            bundle.putStringArray("android:support:request_fragment_who", strArr);
        }
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        this.mStopped = false;
        if (!this.mCreated) {
            this.mCreated = true;
            this.mFragments.f15137O000000o.O00000oO.O0000o0o();
        }
        this.mFragments.O000000o();
        this.mFragments.O00000Oo();
        this.mFragmentLifecycleRegistry.O000000o(Lifecycle.Event.ON_START);
        this.mFragments.f15137O000000o.O00000oO.O0000o();
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
        this.mStopped = true;
        markFragmentsCreated();
        this.mFragments.f15137O000000o.O00000oO.O0000oO();
        this.mFragmentLifecycleRegistry.O000000o(Lifecycle.Event.ON_STOP);
    }

    @Deprecated
    public void supportInvalidateOptionsMenu() {
        invalidateOptionsMenu();
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        printWriter.print(str);
        printWriter.print("Local FragmentActivity ");
        printWriter.print(Integer.toHexString(System.identityHashCode(this)));
        printWriter.println(" State:");
        String str2 = str + "  ";
        printWriter.print(str2);
        printWriter.print("mCreated=");
        printWriter.print(this.mCreated);
        printWriter.print(" mResumed=");
        printWriter.print(this.mResumed);
        printWriter.print(" mStopped=");
        printWriter.print(this.mStopped);
        if (getApplication() != null) {
            fr.O000000o(this).O000000o(str2, fileDescriptor, printWriter, strArr);
        }
        this.mFragments.f15137O000000o.O00000oO.O000000o(str, fileDescriptor, printWriter, strArr);
    }

    public ee getSupportFragmentManager() {
        return this.mFragments.f15137O000000o.O00000oO;
    }

    @Deprecated
    public fr getSupportLoaderManager() {
        return fr.O000000o(this);
    }

    public void startActivityForResult(@SuppressLint({"UnknownNullness"}) Intent intent, int i) {
        if (!this.mStartedActivityFromFragment && i != -1) {
            checkForValidRequestCode(i);
        }
        super.startActivityForResult(intent, i);
    }

    public void startActivityForResult(@SuppressLint({"UnknownNullness"}) Intent intent, int i, Bundle bundle) {
        if (!this.mStartedActivityFromFragment && i != -1) {
            checkForValidRequestCode(i);
        }
        super.startActivityForResult(intent, i, bundle);
    }

    public void startIntentSenderForResult(@SuppressLint({"UnknownNullness"}) IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4) throws IntentSender.SendIntentException {
        if (!this.mStartedIntentSenderFromFragment && i != -1) {
            checkForValidRequestCode(i);
        }
        super.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4);
    }

    public void startIntentSenderForResult(@SuppressLint({"UnknownNullness"}) IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4, Bundle bundle) throws IntentSender.SendIntentException {
        if (!this.mStartedIntentSenderFromFragment && i != -1) {
            checkForValidRequestCode(i);
        }
        super.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4, bundle);
    }

    static void checkForValidRequestCode(int i) {
        if ((i & -65536) != 0) {
            throw new IllegalArgumentException("Can only use lower 16 bits for requestCode");
        }
    }

    public final void validateRequestPermissionsRequestCode(int i) {
        if (!this.mRequestedPermissionsFromFragment && i != -1) {
            checkForValidRequestCode(i);
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        this.mFragments.O000000o();
        int i2 = (i >> 16) & 65535;
        if (i2 != 0) {
            int i3 = i2 - 1;
            String O000000o2 = this.mPendingFragmentActivityResults.O000000o(i3, null);
            this.mPendingFragmentActivityResults.O000000o(i3);
            if (O000000o2 == null) {
                Log.w("FragmentActivity", "Activity result delivered for unknown Fragment.");
                return;
            }
            Fragment O000000o3 = this.mFragments.O000000o(O000000o2);
            if (O000000o3 == null) {
                Log.w("FragmentActivity", "Activity result no fragment exists for who: ".concat(String.valueOf(O000000o2)));
            } else {
                O000000o3.onRequestPermissionsResult(i & 65535, strArr, iArr);
            }
        }
    }

    public void startActivityFromFragment(Fragment fragment, @SuppressLint({"UnknownNullness"}) Intent intent, int i) {
        startActivityFromFragment(fragment, intent, i, null);
    }

    public void startActivityFromFragment(Fragment fragment, @SuppressLint({"UnknownNullness"}) Intent intent, int i, Bundle bundle) {
        this.mStartedActivityFromFragment = true;
        if (i == -1) {
            try {
                oOOO00o0.O000000o(this, intent, -1, bundle);
            } finally {
                this.mStartedActivityFromFragment = false;
            }
        } else {
            checkForValidRequestCode(i);
            oOOO00o0.O000000o(this, intent, ((allocateRequestIndex(fragment) + 1) << 16) + (i & 65535), bundle);
            this.mStartedActivityFromFragment = false;
        }
    }

    public void startIntentSenderFromFragment(Fragment fragment, @SuppressLint({"UnknownNullness"}) IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4, Bundle bundle) throws IntentSender.SendIntentException {
        int i5 = i;
        this.mStartedIntentSenderFromFragment = true;
        if (i5 == -1) {
            try {
                oOOO00o0.O000000o(this, intentSender, i, intent, i2, i3, i4, bundle);
            } finally {
                this.mStartedIntentSenderFromFragment = false;
            }
        } else {
            checkForValidRequestCode(i);
            oOOO00o0.O000000o(this, intentSender, ((allocateRequestIndex(fragment) + 1) << 16) + (i5 & 65535), intent, i2, i3, i4, bundle);
            this.mStartedIntentSenderFromFragment = false;
        }
    }

    private int allocateRequestIndex(Fragment fragment) {
        if (this.mPendingFragmentActivityResults.O00000Oo() < 65534) {
            while (this.mPendingFragmentActivityResults.O00000o(this.mNextCandidateRequestIndex) >= 0) {
                this.mNextCandidateRequestIndex = (this.mNextCandidateRequestIndex + 1) % 65534;
            }
            int i = this.mNextCandidateRequestIndex;
            this.mPendingFragmentActivityResults.O00000Oo(i, fragment.mWho);
            this.mNextCandidateRequestIndex = (this.mNextCandidateRequestIndex + 1) % 65534;
            return i;
        }
        throw new IllegalStateException("Too many pending Fragment activity results.");
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: package-private */
    public void requestPermissionsFromFragment(Fragment fragment, String[] strArr, int i) {
        if (i == -1) {
            oOOO00o0.O000000o(this, strArr, i);
            return;
        }
        checkForValidRequestCode(i);
        try {
            this.mRequestedPermissionsFromFragment = true;
            oOOO00o0.O000000o(this, strArr, ((allocateRequestIndex(fragment) + 1) << 16) + (i & 65535));
            this.mRequestedPermissionsFromFragment = false;
        } catch (Throwable th) {
            this.mRequestedPermissionsFromFragment = false;
            throw th;
        }
    }

    class O000000o extends ed<FragmentActivity> implements O0Oo, fq {
        public O000000o() {
            super(FragmentActivity.this);
        }

        public final Lifecycle getLifecycle() {
            return FragmentActivity.this.mFragmentLifecycleRegistry;
        }

        public final fp getViewModelStore() {
            return FragmentActivity.this.getViewModelStore();
        }

        public final OnBackPressedDispatcher getOnBackPressedDispatcher() {
            return FragmentActivity.this.getOnBackPressedDispatcher();
        }

        public final void O000000o(String str, PrintWriter printWriter, String[] strArr) {
            FragmentActivity.this.dump(str, null, printWriter, strArr);
        }

        public final boolean O00000Oo() {
            return !FragmentActivity.this.isFinishing();
        }

        public final LayoutInflater O00000o0() {
            return FragmentActivity.this.getLayoutInflater().cloneInContext(FragmentActivity.this);
        }

        public final void O00000o() {
            FragmentActivity.this.supportInvalidateOptionsMenu();
        }

        public final void O000000o(Fragment fragment, Intent intent, int i, Bundle bundle) {
            FragmentActivity.this.startActivityFromFragment(fragment, intent, i, bundle);
        }

        public final void O000000o(Fragment fragment, IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4, Bundle bundle) throws IntentSender.SendIntentException {
            FragmentActivity.this.startIntentSenderFromFragment(fragment, intentSender, i, intent, i2, i3, i4, bundle);
        }

        public final void O000000o(Fragment fragment, String[] strArr, int i) {
            FragmentActivity.this.requestPermissionsFromFragment(fragment, strArr, i);
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: _m_j.oOOO00o0.O000000o(android.app.Activity, java.lang.String):boolean
         arg types: [androidx.fragment.app.FragmentActivity, java.lang.String]
         candidates:
          _m_j.oOOO00o0.O000000o(android.app.Activity, _m_j.d):void
          androidx.core.content.ContextCompat.O000000o(android.content.Context, java.lang.String):int
          androidx.core.content.ContextCompat.O000000o(android.content.Context, int):android.graphics.drawable.Drawable
          androidx.core.content.ContextCompat.O000000o(android.content.Context, java.lang.Class):T
          _m_j.oOOO00o0.O000000o(android.app.Activity, java.lang.String):boolean */
        public final boolean O000000o(String str) {
            return oOOO00o0.O000000o((Activity) FragmentActivity.this, str);
        }

        public final boolean O00000oO() {
            return FragmentActivity.this.getWindow() != null;
        }

        public final int O00000oo() {
            Window window = FragmentActivity.this.getWindow();
            if (window == null) {
                return 0;
            }
            return window.getAttributes().windowAnimations;
        }

        public final void O000000o(Fragment fragment) {
            FragmentActivity.this.onAttachFragment(fragment);
        }

        public final View O000000o(int i) {
            return FragmentActivity.this.findViewById(i);
        }

        public final boolean O000000o() {
            Window window = FragmentActivity.this.getWindow();
            return (window == null || window.peekDecorView() == null) ? false : true;
        }

        public final /* bridge */ /* synthetic */ Object O0000O0o() {
            return FragmentActivity.this;
        }
    }

    private void markFragmentsCreated() {
        do {
        } while (markState(getSupportFragmentManager(), Lifecycle.State.CREATED));
    }

    private static boolean markState(ee eeVar, Lifecycle.State state) {
        boolean z = false;
        for (Fragment next : eeVar.O00000oo()) {
            if (next != null) {
                if (next.getLifecycle().O000000o().isAtLeast(Lifecycle.State.STARTED)) {
                    next.mLifecycleRegistry.O000000o(state);
                    z = true;
                }
                if (next.getHost() != null) {
                    z |= markState(next.getChildFragmentManager(), state);
                }
            }
        }
        return z;
    }
}
