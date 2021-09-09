package _m_j;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

public class dz extends Fragment implements DialogInterface.OnCancelListener, DialogInterface.OnDismissListener {
    int mBackStackId = -1;
    boolean mCancelable = true;
    Dialog mDialog;
    private Runnable mDismissRunnable = new Runnable() {
        /* class _m_j.dz.AnonymousClass1 */

        public final void run() {
            if (dz.this.mDialog != null) {
                dz dzVar = dz.this;
                dzVar.onDismiss(dzVar.mDialog);
            }
        }
    };
    boolean mDismissed;
    private Handler mHandler;
    boolean mShownByMe;
    boolean mShowsDialog = true;
    int mStyle = 0;
    int mTheme = 0;
    boolean mViewDestroyed;

    public void onCancel(DialogInterface dialogInterface) {
    }

    public void setStyle(int i, int i2) {
        this.mStyle = i;
        int i3 = this.mStyle;
        if (i3 == 2 || i3 == 3) {
            this.mTheme = 16973913;
        }
        if (i2 != 0) {
            this.mTheme = i2;
        }
    }

    public void show(ee eeVar, String str) {
        this.mDismissed = false;
        this.mShownByMe = true;
        ei O000000o2 = eeVar.O000000o();
        O000000o2.O000000o(this, str);
        O000000o2.O00000Oo();
    }

    public int show(ei eiVar, String str) {
        this.mDismissed = false;
        this.mShownByMe = true;
        eiVar.O000000o(this, str);
        this.mViewDestroyed = false;
        this.mBackStackId = eiVar.O00000Oo();
        return this.mBackStackId;
    }

    public void showNow(ee eeVar, String str) {
        this.mDismissed = false;
        this.mShownByMe = true;
        ei O000000o2 = eeVar.O000000o();
        O000000o2.O000000o(this, str);
        O000000o2.O00000o();
    }

    public void dismiss() {
        dismissInternal(false, false);
    }

    public void dismissAllowingStateLoss() {
        dismissInternal(true, false);
    }

    /* access modifiers changed from: package-private */
    public void dismissInternal(boolean z, boolean z2) {
        if (!this.mDismissed) {
            this.mDismissed = true;
            this.mShownByMe = false;
            Dialog dialog = this.mDialog;
            if (dialog != null) {
                dialog.setOnDismissListener(null);
                this.mDialog.dismiss();
                if (!z2) {
                    if (Looper.myLooper() == this.mHandler.getLooper()) {
                        onDismiss(this.mDialog);
                    } else {
                        this.mHandler.post(this.mDismissRunnable);
                    }
                }
            }
            this.mViewDestroyed = true;
            if (this.mBackStackId >= 0) {
                requireFragmentManager().O00000Oo(this.mBackStackId);
                this.mBackStackId = -1;
                return;
            }
            ei O000000o2 = requireFragmentManager().O000000o();
            O000000o2.O000000o(this);
            if (z) {
                O000000o2.O00000o0();
            } else {
                O000000o2.O00000Oo();
            }
        }
    }

    public Dialog getDialog() {
        return this.mDialog;
    }

    public final Dialog requireDialog() {
        Dialog dialog = getDialog();
        if (dialog != null) {
            return dialog;
        }
        throw new IllegalStateException("DialogFragment " + this + " does not have a Dialog.");
    }

    public int getTheme() {
        return this.mTheme;
    }

    public void setCancelable(boolean z) {
        this.mCancelable = z;
        Dialog dialog = this.mDialog;
        if (dialog != null) {
            dialog.setCancelable(z);
        }
    }

    public boolean isCancelable() {
        return this.mCancelable;
    }

    public void setShowsDialog(boolean z) {
        this.mShowsDialog = z;
    }

    public boolean getShowsDialog() {
        return this.mShowsDialog;
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        if (!this.mShownByMe) {
            this.mDismissed = false;
        }
    }

    public void onDetach() {
        super.onDetach();
        if (!this.mShownByMe && !this.mDismissed) {
            this.mDismissed = true;
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mHandler = new Handler();
        this.mShowsDialog = this.mContainerId == 0;
        if (bundle != null) {
            this.mStyle = bundle.getInt("android:style", 0);
            this.mTheme = bundle.getInt("android:theme", 0);
            this.mCancelable = bundle.getBoolean("android:cancelable", true);
            this.mShowsDialog = bundle.getBoolean("android:showsDialog", this.mShowsDialog);
            this.mBackStackId = bundle.getInt("android:backStackId", -1);
        }
    }

    public LayoutInflater onGetLayoutInflater(Bundle bundle) {
        if (!this.mShowsDialog) {
            return super.onGetLayoutInflater(bundle);
        }
        this.mDialog = onCreateDialog(bundle);
        Dialog dialog = this.mDialog;
        if (dialog == null) {
            return (LayoutInflater) this.mHost.O00000o0.getSystemService("layout_inflater");
        }
        setupDialog(dialog, this.mStyle);
        return (LayoutInflater) this.mDialog.getContext().getSystemService("layout_inflater");
    }

    public void setupDialog(Dialog dialog, int i) {
        if (!(i == 1 || i == 2)) {
            if (i == 3) {
                dialog.getWindow().addFlags(24);
            } else {
                return;
            }
        }
        dialog.requestWindowFeature(1);
    }

    public Dialog onCreateDialog(Bundle bundle) {
        return new Dialog(requireContext(), getTheme());
    }

    public void onDismiss(DialogInterface dialogInterface) {
        if (!this.mViewDestroyed) {
            dismissInternal(true, true);
        }
    }

    public void onActivityCreated(Bundle bundle) {
        Bundle bundle2;
        super.onActivityCreated(bundle);
        if (this.mShowsDialog) {
            View view = getView();
            if (view != null) {
                if (view.getParent() == null) {
                    this.mDialog.setContentView(view);
                } else {
                    throw new IllegalStateException("DialogFragment can not be attached to a container view");
                }
            }
            FragmentActivity activity = getActivity();
            if (activity != null) {
                this.mDialog.setOwnerActivity(activity);
            }
            this.mDialog.setCancelable(this.mCancelable);
            this.mDialog.setOnCancelListener(this);
            this.mDialog.setOnDismissListener(this);
            if (bundle != null && (bundle2 = bundle.getBundle("android:savedDialogState")) != null) {
                this.mDialog.onRestoreInstanceState(bundle2);
            }
        }
    }

    public void onStart() {
        super.onStart();
        Dialog dialog = this.mDialog;
        if (dialog != null) {
            this.mViewDestroyed = false;
            dialog.show();
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        Bundle onSaveInstanceState;
        super.onSaveInstanceState(bundle);
        Dialog dialog = this.mDialog;
        if (!(dialog == null || (onSaveInstanceState = dialog.onSaveInstanceState()) == null)) {
            bundle.putBundle("android:savedDialogState", onSaveInstanceState);
        }
        int i = this.mStyle;
        if (i != 0) {
            bundle.putInt("android:style", i);
        }
        int i2 = this.mTheme;
        if (i2 != 0) {
            bundle.putInt("android:theme", i2);
        }
        boolean z = this.mCancelable;
        if (!z) {
            bundle.putBoolean("android:cancelable", z);
        }
        boolean z2 = this.mShowsDialog;
        if (!z2) {
            bundle.putBoolean("android:showsDialog", z2);
        }
        int i3 = this.mBackStackId;
        if (i3 != -1) {
            bundle.putInt("android:backStackId", i3);
        }
    }

    public void onStop() {
        super.onStop();
        Dialog dialog = this.mDialog;
        if (dialog != null) {
            dialog.hide();
        }
    }

    public void onDestroyView() {
        super.onDestroyView();
        Dialog dialog = this.mDialog;
        if (dialog != null) {
            this.mViewDestroyed = true;
            dialog.setOnDismissListener(null);
            this.mDialog.dismiss();
            if (!this.mDismissed) {
                onDismiss(this.mDialog);
            }
            this.mDialog = null;
        }
    }
}
