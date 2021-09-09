package _m_j;

import android.app.Dialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Window;
import androidx.appcompat.app.AlertDialog;
import com.xiaomi.accountsdk.utils.AccountLog;
import java.lang.reflect.InvocationTargetException;

public final class ejz extends DialogFragment {

    /* renamed from: O000000o  reason: collision with root package name */
    public int f15550O000000o;
    public DialogInterface.OnClickListener O00000Oo;
    private CharSequence O00000o;
    public DialogInterface.OnDismissListener O00000o0;
    private boolean O00000oO = true;
    private String O00000oo;
    private int O0000O0o;
    private int O0000OOo;
    private DialogInterface.OnClickListener O0000Oo0;

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.O0000O0o = arguments.getInt("type");
            this.O00000o = arguments.getCharSequence("msg_res_id");
            this.O00000oo = arguments.getString("title");
            this.O00000oO = arguments.getBoolean("cancelable", true);
            return;
        }
        throw new IllegalStateException("no argument");
    }

    public final Dialog onCreateDialog(Bundle bundle) {
        int i = this.O0000O0o;
        if (i == 1) {
            try {
                if (O000000o()) {
                    Class<?> cls = Class.forName("miui.app.AlertDialog$Builder");
                    Object newInstance = cls.getConstructor(Context.class).newInstance(getActivity());
                    cls.getMethod("setTitle", CharSequence.class).invoke(newInstance, this.O00000oo);
                    cls.getMethod("setMessage", CharSequence.class).invoke(newInstance, this.O00000o);
                    cls.getMethod("setCancelable", Boolean.TYPE).invoke(newInstance, Boolean.valueOf(this.O00000oO));
                    if (this.f15550O000000o > 0) {
                        cls.getMethod("setPositiveButton", Integer.TYPE, DialogInterface.OnClickListener.class).invoke(newInstance, Integer.valueOf(this.f15550O000000o), this.O00000Oo);
                    }
                    if (this.O0000OOo > 0) {
                        cls.getMethod("setNegativeButton", Integer.TYPE, DialogInterface.OnClickListener.class).invoke(newInstance, Integer.valueOf(this.O0000OOo), this.O0000Oo0);
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
            AlertDialog.Builder title = new AlertDialog.Builder(getActivity()).setMessage(this.O00000o).setCancelable(this.O00000oO).setTitle(this.O00000oo);
            int i2 = this.f15550O000000o;
            if (i2 > 0) {
                title.setPositiveButton(i2, this.O00000Oo);
            }
            int i3 = this.O0000OOo;
            if (i3 > 0) {
                title.setNegativeButton(i3, this.O0000Oo0);
            }
            return title.create();
        } else if (i == 2) {
            try {
                if (O000000o()) {
                    Class<?> cls2 = Class.forName("miui.app.ProgressDialog");
                    Object newInstance2 = cls2.getConstructor(Context.class).newInstance(getActivity());
                    cls2.getMethod("setMessage", CharSequence.class).invoke(newInstance2, this.O00000o);
                    cls2.getMethod("setCancelable", Boolean.TYPE).invoke(newInstance2, Boolean.valueOf(this.O00000oO));
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
            progressDialog.setMessage(this.O00000o);
            progressDialog.setCancelable(this.O00000oO);
            progressDialog.getWindow().setGravity(80);
            return progressDialog;
        } else {
            throw new IllegalStateException("unknown dialog type:" + this.O0000O0o);
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
        DialogInterface.OnDismissListener onDismissListener = this.O00000o0;
        if (onDismissListener != null) {
            onDismissListener.onDismiss(dialogInterface);
        }
    }

    public static final class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public String f15551O000000o;
        public CharSequence O00000Oo;
        private boolean O00000o;
        boolean O00000o0 = true;
        private int O00000oO;

        public O000000o(int i) {
            this.O00000oO = i;
        }

        public final ejz O000000o() {
            if (!this.O00000o) {
                this.O00000o = true;
                ejz ejz = new ejz();
                Bundle bundle = new Bundle();
                bundle.putString("title", this.f15551O000000o);
                bundle.putCharSequence("msg_res_id", this.O00000Oo);
                bundle.putBoolean("cancelable", this.O00000o0);
                bundle.putInt("type", this.O00000oO);
                ejz.setArguments(bundle);
                return ejz;
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
