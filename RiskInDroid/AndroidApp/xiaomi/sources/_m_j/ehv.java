package _m_j;

import android.app.Dialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Window;
import com.xiaomi.accountsdk.utils.AccountLog;
import com.xiaomi.passport.ui.internal.AlertDialog;
import com.xiaomi.passport.ui.internal.ProgressDialog;
import java.lang.reflect.InvocationTargetException;

public final class ehv extends DialogFragment {

    /* renamed from: O000000o  reason: collision with root package name */
    private CharSequence f15302O000000o;
    private boolean O00000Oo = true;
    private int O00000o;
    private String O00000o0;
    private int O00000oO;
    private int O00000oo;
    private DialogInterface.OnClickListener O0000O0o;
    private DialogInterface.OnClickListener O0000OOo;
    private DialogInterface.OnDismissListener O0000Oo0;

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.O00000o = arguments.getInt("type");
            this.f15302O000000o = arguments.getCharSequence("msg_res_id");
            this.O00000o0 = arguments.getString("title");
            this.O00000Oo = arguments.getBoolean("cancelable", true);
            return;
        }
        throw new IllegalStateException("no argument");
    }

    public final Dialog onCreateDialog(Bundle bundle) {
        int i = this.O00000o;
        if (i == 1) {
            try {
                if (O000000o()) {
                    Class<?> cls = Class.forName("miui.app.AlertDialog$Builder");
                    Object newInstance = cls.getConstructor(Context.class).newInstance(getActivity());
                    cls.getMethod("setTitle", CharSequence.class).invoke(newInstance, this.O00000o0);
                    cls.getMethod("setMessage", CharSequence.class).invoke(newInstance, this.f15302O000000o);
                    cls.getMethod("setCancelable", Boolean.TYPE).invoke(newInstance, Boolean.valueOf(this.O00000Oo));
                    if (this.O00000oO > 0) {
                        cls.getMethod("setPositiveButton", Integer.TYPE, DialogInterface.OnClickListener.class).invoke(newInstance, Integer.valueOf(this.O00000oO), this.O0000O0o);
                    }
                    if (this.O00000oo > 0) {
                        cls.getMethod("setNegativeButton", Integer.TYPE, DialogInterface.OnClickListener.class).invoke(newInstance, Integer.valueOf(this.O00000oo), this.O0000OOo);
                    }
                    return (Dialog) cls.getMethod("create", new Class[0]).invoke(newInstance, new Object[0]);
                }
            } catch (ClassNotFoundException e) {
                AccountLog.e("SimpleDialogFragment", "AlertDialog reflect exception: ", e);
            } catch (InstantiationException e2) {
                AccountLog.e("SimpleDialogFragment", "AlertDialog reflect exception: ", e2);
            } catch (IllegalAccessException e3) {
                AccountLog.e("SimpleDialogFragment", "AlertDialog reflect exception: ", e3);
            } catch (IllegalArgumentException e4) {
                AccountLog.e("SimpleDialogFragment", "AlertDialog reflect exception: ", e4);
            } catch (InvocationTargetException e5) {
                AccountLog.e("SimpleDialogFragment", "AlertDialog reflect exception: ", e5);
            } catch (NoSuchMethodException e6) {
                AccountLog.e("SimpleDialogFragment", "AlertDialog reflect exception: ", e6);
            }
            AlertDialog.Builder O000000o2 = new AlertDialog.Builder(getActivity()).O000000o(this.f15302O000000o);
            O000000o2.f6230O000000o.O0000o = this.O00000Oo;
            O000000o2.f6230O000000o.O0000OOo = this.O00000o0;
            int i2 = this.O00000oO;
            if (i2 > 0) {
                DialogInterface.OnClickListener onClickListener = this.O0000O0o;
                O000000o2.f6230O000000o.O0000OoO = O000000o2.f6230O000000o.O00000oo.getText(i2);
                O000000o2.f6230O000000o.O0000Ooo = onClickListener;
            }
            int i3 = this.O00000oo;
            if (i3 > 0) {
                DialogInterface.OnClickListener onClickListener2 = this.O0000OOo;
                O000000o2.f6230O000000o.O0000o00 = O000000o2.f6230O000000o.O00000oo.getText(i3);
                O000000o2.f6230O000000o.O0000o0 = onClickListener2;
            }
            return O000000o2.O00000Oo();
        } else if (i == 2) {
            try {
                if (O000000o()) {
                    Class<?> cls2 = Class.forName("miui.app.ProgressDialog");
                    Object newInstance2 = cls2.getConstructor(Context.class).newInstance(getActivity());
                    cls2.getMethod("setMessage", CharSequence.class).invoke(newInstance2, this.f15302O000000o);
                    cls2.getMethod("setCancelable", Boolean.TYPE).invoke(newInstance2, Boolean.valueOf(this.O00000Oo));
                    ((Window) cls2.getMethod("getWindow", new Class[0]).invoke(newInstance2, new Object[0])).setGravity(80);
                    return (Dialog) newInstance2;
                }
            } catch (ClassNotFoundException e7) {
                AccountLog.e("SimpleDialogFragment", "ProgressDialog reflect exception: ", e7);
            } catch (InstantiationException e8) {
                AccountLog.e("SimpleDialogFragment", "ProgressDialog reflect exception: ", e8);
            } catch (IllegalAccessException e9) {
                AccountLog.e("SimpleDialogFragment", "ProgressDialog reflect exception: ", e9);
            } catch (IllegalArgumentException e10) {
                AccountLog.e("SimpleDialogFragment", "ProgressDialog reflect exception: ", e10);
            } catch (InvocationTargetException e11) {
                AccountLog.e("SimpleDialogFragment", "ProgressDialog reflect exception: ", e11);
            } catch (NoSuchMethodException e12) {
                AccountLog.e("SimpleDialogFragment", "ProgressDialog reflect exception: ", e12);
            }
            ProgressDialog progressDialog = new ProgressDialog(getActivity());
            progressDialog.O000000o(this.f15302O000000o);
            progressDialog.setCancelable(this.O00000Oo);
            progressDialog.getWindow().setGravity(80);
            return progressDialog;
        } else {
            throw new IllegalStateException("unknown dialog type:" + this.O00000o);
        }
    }

    private boolean O000000o() {
        try {
            return Class.forName("miui.app.Activity").isInstance(getActivity());
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    public final void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        DialogInterface.OnDismissListener onDismissListener = this.O0000Oo0;
        if (onDismissListener != null) {
            onDismissListener.onDismiss(dialogInterface);
        }
    }

    public static final class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public CharSequence f15303O000000o;
        private String O00000Oo;
        private boolean O00000o;
        private boolean O00000o0 = true;
        private int O00000oO = 2;

        public final ehv O000000o() {
            if (!this.O00000o) {
                this.O00000o = true;
                ehv ehv = new ehv();
                Bundle bundle = new Bundle();
                bundle.putString("title", this.O00000Oo);
                bundle.putCharSequence("msg_res_id", this.f15303O000000o);
                bundle.putBoolean("cancelable", this.O00000o0);
                bundle.putInt("type", this.O00000oO);
                ehv.setArguments(bundle);
                return ehv;
            }
            throw new IllegalStateException("dialog has been created");
        }
    }

    @Deprecated
    public final void dismiss() {
        super.dismiss();
    }

    public final void O000000o(FragmentManager fragmentManager, String str) {
        if (fragmentManager == null) {
            AccountLog.w("SimpleDialogFragment", "invalid parameter");
            return;
        }
        FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
        beginTransaction.add(this, str);
        beginTransaction.commitAllowingStateLoss();
    }
}
