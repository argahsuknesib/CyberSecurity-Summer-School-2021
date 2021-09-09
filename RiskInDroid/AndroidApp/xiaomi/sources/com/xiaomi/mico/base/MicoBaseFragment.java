package com.xiaomi.mico.base;

import _m_j.drr;
import _m_j.drs;
import _m_j.gvz;
import _m_j.gwg;
import android.content.DialogInterface;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import com.xiaomi.mico.api.ApiRequest;
import com.xiaomi.smarthome.library.common.dialog.XQProgressDialog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import rx.subjects.BehaviorSubject;

public class MicoBaseFragment extends gvz implements ApiRequest.ICleanQueue {
    private boolean mActivated;
    private BehaviorSubject<FragmentEvent> mLifeSubject = BehaviorSubject.create();
    protected volatile boolean mPageSelected = false;
    private ArrayList<WeakReference<ApiRequest>> mRequestQueue;
    private XQProgressDialog progressDialog;

    public enum FragmentEvent {
        ATTACH,
        CREATE,
        CREATE_VIEW,
        START,
        RESUME,
        PAUSE,
        STOP,
        DESTROY_VIEW,
        DESTROY,
        DETACH
    }

    public void bindToLifecycle(ApiRequest apiRequest) {
        if (this.mRequestQueue == null) {
            this.mRequestQueue = new ArrayList<>();
        }
        this.mRequestQueue.add(new WeakReference(apiRequest));
    }

    public <T> drr<T> bindToLifecycle() {
        return drs.O000000o(this.mLifeSubject, FragmentEvent.DESTROY);
    }

    public void onDestroy() {
        super.onDestroy();
        this.mLifeSubject.onNext(FragmentEvent.DESTROY);
    }

    public boolean isActivated() {
        return isAdded() && !isHidden() && this.mActivated;
    }

    public void onDestroyView() {
        super.onDestroyView();
        this.mLifeSubject.onNext(FragmentEvent.DESTROY_VIEW);
        ArrayList<WeakReference<ApiRequest>> arrayList = this.mRequestQueue;
        if (arrayList != null) {
            Iterator<WeakReference<ApiRequest>> it = arrayList.iterator();
            while (it.hasNext()) {
                WeakReference next = it.next();
                if (next.get() != null) {
                    ((ApiRequest) next.get()).cancel();
                }
            }
            this.mRequestQueue.clear();
        }
        this.mRequestQueue = null;
    }

    private void notifyChildFragment() {
        List<Fragment> O00000oo = getChildFragmentManager().O00000oo();
        if (O00000oo != null && !O00000oo.isEmpty()) {
            for (Fragment next : O00000oo) {
                if (next != null && next.isVisible() && !next.isHidden() && next.getUserVisibleHint() && (next instanceof MicoBaseFragment)) {
                    if (this.mActivated) {
                        ((MicoBaseFragment) next).onActivate();
                    } else {
                        ((MicoBaseFragment) next).onDeactivate();
                    }
                }
            }
        }
    }

    public void onResume() {
        super.onResume();
        if (!isHidden() && !this.mActivated) {
            onActivate();
        }
    }

    public void onPause() {
        super.onPause();
        if (!isHidden() && this.mActivated) {
            onDeactivate();
        }
    }

    /* access modifiers changed from: protected */
    public void onActivate() {
        this.mActivated = true;
        notifyChildFragment();
        Object[] objArr = {"Fragment onActivate %s", getClass().getSimpleName()};
    }

    /* access modifiers changed from: protected */
    public void onDeactivate() {
        this.mActivated = false;
        notifyChildFragment();
        Object[] objArr = {"Fragment onDeactivate %s", getClass().getSimpleName()};
    }

    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        if (isAdded()) {
            dispatchUserVisibleChange(z);
        }
    }

    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        dispatchUserVisibleChange(!z);
        Object[] objArr = {"Fragment onHiddenChanged %s", getClass().getSimpleName()};
    }

    private void dispatchUserVisibleChange(boolean z) {
        if (z == this.mActivated) {
            return;
        }
        if (z) {
            onActivate();
        } else {
            onDeactivate();
        }
    }

    public void onPageSelected() {
        this.mPageSelected = true;
    }

    public void onPageDeselected() {
        this.mPageSelected = false;
    }

    public void dismissProgressDialog() {
        XQProgressDialog xQProgressDialog = this.progressDialog;
        if (xQProgressDialog != null) {
            xQProgressDialog.dismiss();
        }
    }

    public void showProgressDialog(CharSequence charSequence) {
        showProgressDialog(charSequence, false, null);
    }

    public void showProgressDialog(CharSequence charSequence, boolean z, DialogInterface.OnCancelListener onCancelListener) {
        if (this.progressDialog == null) {
            this.progressDialog = new XQProgressDialog(getContext());
        }
        if (!TextUtils.isEmpty(charSequence)) {
            this.progressDialog.setMessage(charSequence);
        }
        this.progressDialog.setCancelable(z);
        if (onCancelListener != null) {
            this.progressDialog.setOnCancelListener(onCancelListener);
        }
        if (isValid()) {
            this.progressDialog.show();
        }
    }

    public void refreshTitleBar() {
        gwg.O00000Oo(getActivity().getWindow());
    }
}
