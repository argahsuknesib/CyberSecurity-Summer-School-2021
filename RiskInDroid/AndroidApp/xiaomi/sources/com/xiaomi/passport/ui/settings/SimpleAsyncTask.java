package com.xiaomi.passport.ui.settings;

import _m_j.ejz;
import _m_j.ekr;
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.xiaomi.smarthome.R;

public final class SimpleAsyncTask<T> extends AsyncTask<Void, Void, T> {

    /* renamed from: O000000o  reason: collision with root package name */
    private final FragmentManager f6309O000000o;
    private final String O00000Oo;
    private final O00000Oo<T> O00000o;
    private boolean O00000o0;
    private final O00000o0<T> O00000oO;
    private ejz O00000oo;

    public interface O00000Oo<T> {
        T O000000o();
    }

    public interface O00000o0<T> {
        void O000000o(T t);
    }

    /* synthetic */ SimpleAsyncTask(O000000o o000000o, byte b) {
        this(o000000o);
    }

    private SimpleAsyncTask(O000000o<T> o000000o) {
        this.f6309O000000o = o000000o.f6311O000000o;
        this.O00000Oo = o000000o.O00000Oo;
        this.O00000o0 = o000000o.O00000o0;
        this.O00000o = o000000o.O00000o;
        this.O00000oO = o000000o.O00000oO;
    }

    /* access modifiers changed from: protected */
    public final void onPreExecute() {
        super.onPreExecute();
        if (this.f6309O000000o != null && !TextUtils.isEmpty(this.O00000Oo)) {
            ejz.O000000o o000000o = new ejz.O000000o(2);
            o000000o.O00000Oo = this.O00000Oo;
            this.O00000oo = o000000o.O000000o();
            this.O00000oo.O00000o0 = new DialogInterface.OnDismissListener() {
                /* class com.xiaomi.passport.ui.settings.SimpleAsyncTask.AnonymousClass1 */

                public final void onDismiss(DialogInterface dialogInterface) {
                    SimpleAsyncTask.this.cancel(true);
                }
            };
            this.O00000oo.setCancelable(this.O00000o0);
            this.O00000oo.O000000o(this.f6309O000000o, "SimpleAsyncTask");
        }
        ekr.O000000o();
    }

    /* access modifiers changed from: protected */
    public final void onPostExecute(T t) {
        O00000Oo();
        super.onPostExecute(t);
        O00000o0<T> o00000o0 = this.O00000oO;
        if (o00000o0 != null) {
            o00000o0.O000000o(t);
        }
        ekr.O00000Oo();
    }

    /* access modifiers changed from: protected */
    public final void onCancelled(T t) {
        super.onCancelled(t);
        O00000Oo();
        ekr.O00000Oo();
    }

    public final boolean O000000o() {
        return getStatus() != AsyncTask.Status.FINISHED;
    }

    private void O00000Oo() {
        ejz ejz = this.O00000oo;
        if (ejz != null && ejz.getActivity() != null && !this.O00000oo.getActivity().isFinishing()) {
            this.O00000oo.dismissAllowingStateLoss();
            this.O00000oo = null;
        }
    }

    public static class O000000o<T> {

        /* renamed from: O000000o  reason: collision with root package name */
        public FragmentManager f6311O000000o;
        public String O00000Oo;
        public O00000Oo<T> O00000o;
        public boolean O00000o0 = true;
        public O00000o0<T> O00000oO;

        public final O000000o<T> O000000o(FragmentManager fragmentManager, String str) {
            this.f6311O000000o = fragmentManager;
            this.O00000Oo = str;
            return this;
        }

        public final SimpleAsyncTask<T> O000000o() {
            return new SimpleAsyncTask<>(this, (byte) 0);
        }
    }

    public enum ResultType {
        SUCCESS {
            public final int getErrorMessageResId() {
                return 0;
            }
        },
        ERROR_PASSWORD {
            public final int getErrorMessageResId() {
                return R.string.passport_bad_authentication;
            }
        },
        ERROR_AUTH_FAIL {
            public final int getErrorMessageResId() {
                return R.string.auth_fail_warning;
            }
        },
        ERROR_NETWORK {
            public final int getErrorMessageResId() {
                return R.string.passport_error_network;
            }
        },
        ERROR_SERVER {
            public final int getErrorMessageResId() {
                return R.string.passport_error_server;
            }
        },
        ERROR_ACCESS_DENIED {
            public final int getErrorMessageResId() {
                return R.string.passport_access_denied;
            }
        },
        ERROR_CAPTCHA {
            public final int getErrorMessageResId() {
                return R.string.passport_wrong_captcha;
            }
        },
        ERROR_DEVICE_ID {
            public final int getErrorMessageResId() {
                return R.string.passport_error_device_id;
            }
        },
        ERROR_VERIFY_CODE {
            public final int getErrorMessageResId() {
                return R.string.passport_wrong_vcode;
            }
        },
        ERROR_USER_ACTION_RESTRICTED {
            public final int getErrorMessageResId() {
                return R.string.service_error;
            }
        },
        ERROR_GET_PHONE_VERIFY_CODE_OVER_LIMIT {
            public final int getErrorMessageResId() {
                return R.string.get_phone_verifycode_exceed_limit;
            }
        },
        ERROR_SAME_NEW_AND_OLD_PASS {
            public final int getErrorMessageResId() {
                return R.string.same_new_and_old_pwd;
            }
        },
        ERROR_UNKNOWN {
            public final int getErrorMessageResId() {
                return R.string.passport_error_unknown;
            }
        };

        public abstract int getErrorMessageResId();

        public boolean success() {
            return this == SUCCESS;
        }
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ Object doInBackground(Object[] objArr) {
        O00000Oo<T> o00000Oo = this.O00000o;
        if (o00000Oo != null) {
            return o00000Oo.O000000o();
        }
        return null;
    }
}
