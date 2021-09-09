package _m_j;

import _m_j.egc;
import _m_j.ejr;
import _m_j.ejx;
import _m_j.ekb;
import android.accounts.Account;
import android.accounts.AccountManagerCallback;
import android.accounts.AccountManagerFuture;
import android.accounts.AuthenticatorException;
import android.accounts.OperationCanceledException;
import android.app.Activity;
import android.app.Fragment;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import com.xiaomi.accountsdk.account.ServerError;
import com.xiaomi.accountsdk.account.data.Gender;
import com.xiaomi.accountsdk.account.data.IdentityAuthReason;
import com.xiaomi.accountsdk.utils.AccountLog;
import com.xiaomi.passport.AccountChangedBroadcastHelper;
import com.xiaomi.passport.accountmanager.MiAccountManager;
import com.xiaomi.passport.ui.R$id;
import com.xiaomi.passport.ui.onetrack.Analytics;
import com.xiaomi.passport.ui.settings.AccountPreferenceView;
import com.xiaomi.passport.ui.settings.BindSafeEmailActivity;
import com.xiaomi.passport.ui.settings.ChangePasswordActivity;
import com.xiaomi.passport.ui.settings.UploadProfileType;
import com.xiaomi.passport.ui.settings.UserAvatarUpdateActivity;
import com.xiaomi.passport.ui.settings.UserPhoneInfoActivity;
import com.xiaomi.passport.ui.settings.utils.UserDataProxy;
import com.xiaomi.smarthome.R;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;

public class ejl extends Fragment {

    /* renamed from: O000000o  reason: collision with root package name */
    public Account f15508O000000o;
    public Activity O00000Oo;
    public IdentityAuthReason O00000o;
    Handler O00000o0 = new Handler(Looper.getMainLooper());
    public ejr O00000oO;
    public AccountPreferenceView O00000oo;
    public AccountPreferenceView O0000O0o;
    AccountPreferenceView O0000OOo;
    public AccountPreferenceView O0000Oo;
    public AccountPreferenceView O0000Oo0;
    public AccountPreferenceView O0000OoO;
    public AccountPreferenceView O0000Ooo;
    private HashMap<UploadProfileType, ekb> O0000o = new HashMap<>();
    public DialogInterface.OnClickListener O0000o0 = new DialogInterface.OnClickListener() {
        /* class _m_j.ejl.AnonymousClass6 */

        public final void onClick(DialogInterface dialogInterface, int i) {
            if (i == 0) {
                ejl.this.O000000o("camera");
            } else if (i == 1) {
                ejl.this.O000000o("gallery");
            }
            dialogInterface.dismiss();
        }
    };
    Bitmap O0000o00;
    AccountManagerCallback<Boolean> O0000o0O = new AccountManagerCallback<Boolean>() {
        /* class _m_j.ejl.AnonymousClass8 */

        public final void run(AccountManagerFuture<Boolean> accountManagerFuture) {
            boolean z;
            Activity activity;
            try {
                z = accountManagerFuture.getResult().booleanValue();
            } catch (AuthenticatorException | OperationCanceledException | IOException e) {
                AccountLog.e("AccountSettingsFragment", "sign out failed", e);
                z = false;
            }
            if (z && (activity = ejl.this.getActivity()) != null) {
                AccountChangedBroadcastHelper.O000000o(activity, ejl.this.f15508O000000o, AccountChangedBroadcastHelper.UpdateType.POST_REMOVE);
                if (!activity.isFinishing()) {
                    activity.finish();
                }
            }
        }
    };
    private ejx O0000o0o;
    private View.OnClickListener O0000oO0 = new View.OnClickListener() {
        /* class _m_j.ejl.AnonymousClass7 */

        public final void onClick(View view) {
            try {
                if (view == ejl.this.O0000O0o) {
                    ejl ejl = ejl.this;
                    EditText editText = new EditText(ejl.getActivity());
                    editText.setText(ejl.O0000O0o.getValue());
                    editText.setSelection(editText.getText().length());
                    AlertDialog show = new AlertDialog.Builder(ejl.getActivity()).setTitle((int) R.string.account_user_name_dialog_title).setView(editText).setPositiveButton(17039370, (DialogInterface.OnClickListener) null).setNegativeButton(17039360, (DialogInterface.OnClickListener) null).show();
                    ((ViewGroup.MarginLayoutParams) editText.getLayoutParams()).setMarginStart((int) ejl.getResources().getDimension(R.dimen.preference_left_margin));
                    show.f2647O000000o.O0000o0O.setOnClickListener(new View.OnClickListener(editText, show) {
                        /* class _m_j.ejl.AnonymousClass9 */

                        /* renamed from: O000000o  reason: collision with root package name */
                        final /* synthetic */ EditText f15519O000000o;
                        final /* synthetic */ AlertDialog O00000Oo;

                        {
                            this.f15519O000000o = r2;
                            this.O00000Oo = r3;
                        }

                        public final void onClick(View view) {
                            String str;
                            String obj = this.f15519O000000o.getText().toString();
                            ejl ejl = ejl.this;
                            if (TextUtils.isEmpty(obj)) {
                                str = ejl.getString(R.string.account_empty_user_name);
                            } else if (obj.length() < 2) {
                                str = ejl.getString(R.string.account_error_shorter_user_name);
                            } else if (obj.length() > 20) {
                                str = ejl.getString(R.string.account_error_longer_user_name);
                            } else if (obj.matches("\\s+")) {
                                str = ejl.getString(R.string.account_error_all_space_user_name);
                            } else if (obj.contains("<") || obj.contains(">") || obj.contains("/")) {
                                str = ejl.getString(R.string.account_error_invalid_user_name);
                            } else {
                                str = null;
                            }
                            if (!TextUtils.isEmpty(str)) {
                                this.f15519O000000o.setError(str);
                                return;
                            }
                            this.O00000Oo.dismiss();
                            ejl.this.O000000o(UploadProfileType.TYPE_USER_NAME, obj, null);
                        }
                    });
                    return;
                }
                int i = 0;
                if (view == ejl.this.O0000Oo0) {
                    ejl ejl2 = ejl.this;
                    AlertDialog.Builder builder = new AlertDialog.Builder(ejl2.getActivity());
                    builder.setTitle((int) R.string.account_user_gender);
                    String[] stringArray = ejl2.getResources().getStringArray(R.array.account_user_gender_name);
                    if (ejl2.O0000Oo0.getValue().toString().equals(stringArray[1])) {
                        i = 1;
                    }
                    builder.setSingleChoiceItems(stringArray, i, new DialogInterface.OnClickListener() {
                        /* class _m_j.ejl.AnonymousClass10 */

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            ejl.this.O000000o(UploadProfileType.TYPE_GENDER, null, i == 0 ? Gender.MALE : Gender.FEMALE);
                            dialogInterface.dismiss();
                        }
                    });
                    builder.create().show();
                } else if (view == ejl.this.O00000oo) {
                    AlertDialog.Builder builder2 = new AlertDialog.Builder(ejl.this.O00000Oo);
                    builder2.setTitle((int) R.string.user_avatar_update_title);
                    builder2.setSingleChoiceItems(new String[]{ejl.this.getString(R.string.account_user_avatar_from_camera), ejl.this.getString(R.string.account_user_avatar_from_album)}, 0, ejl.this.O0000o0);
                    builder2.show();
                    Analytics.O00000Oo("profile_image");
                } else if (view == ejl.this.O0000Oo) {
                    Intent intent = new Intent(ejl.this.getActivity(), UserPhoneInfoActivity.class);
                    intent.setPackage("com.xiaomi.account");
                    intent.putExtra("stat_key_source", "AccountSettingsFragment");
                    ejl.this.startActivity(intent);
                    Analytics.O00000Oo("info_change_phone");
                } else if (view == ejl.this.O0000OoO) {
                    ejl ejl3 = ejl.this;
                    SharedPreferences sharedPreferences = ejl3.getActivity().getSharedPreferences(ejl3.f15508O000000o.name, 0);
                    String string = sharedPreferences.getString("unactivated_email_address", null);
                    long j = sharedPreferences.getLong("unactivated_email_time_stamp", 0);
                    String O000000o2 = new UserDataProxy(ejl3.getActivity()).O000000o(ejl3.f15508O000000o, "acc_user_email");
                    if (System.currentTimeMillis() - j > 86400000) {
                        sharedPreferences.edit().clear().apply();
                    } else {
                        if (!TextUtils.isEmpty(string) && (TextUtils.isEmpty(O000000o2) || !string.equals(O000000o2))) {
                            i = 1;
                        }
                        if (i != 0) {
                            ejl3.O000000o(true, string);
                            Analytics.O00000Oo("info_change_email");
                        }
                    }
                    if (TextUtils.isEmpty(O000000o2)) {
                        ejl3.O00000Oo(IdentityAuthReason.SEND_EMAIL_ACTIVATE_MESSAGE);
                    } else {
                        new AlertDialog.Builder(ejl3.getActivity()).setTitle((int) R.string.update_email_address_dialog_title).setMessage((int) R.string.update_email_address_dialog_message).setPositiveButton(17039370, new DialogInterface.OnClickListener() {
                            /* class _m_j.ejl.AnonymousClass2 */

                            public final void onClick(DialogInterface dialogInterface, int i) {
                                ejl.this.O00000Oo(IdentityAuthReason.SEND_EMAIL_ACTIVATE_MESSAGE);
                            }
                        }).setNegativeButton(17039360, (DialogInterface.OnClickListener) null).create().show();
                    }
                    Analytics.O00000Oo("info_change_email");
                } else if (view == ejl.this.O0000Ooo) {
                    ejl ejl4 = ejl.this;
                    Intent newIntent = ChangePasswordActivity.newIntent(ejl4.getActivity());
                    ejl4.getActivity().overridePendingTransition(0, 0);
                    ejl4.startActivityForResult(newIntent, 18);
                }
            } catch (ActivityNotFoundException e) {
                AccountLog.e("AccountSettingsFragment", "activity not found", e);
                Toast.makeText(ejl.this.getActivity(), (int) R.string.activity_not_found_notice, 1).show();
            }
        }
    };

    public void onAttach(Context context) {
        super.onAttach(context);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.O00000Oo = getActivity();
        this.f15508O000000o = MiAccountManager.O00000Oo(this.O00000Oo).O00000oo();
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, android.view.ViewGroup, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate((int) R.layout.account_settings_layout, viewGroup, false);
        this.O00000oo = (AccountPreferenceView) inflate.findViewById(R$id.pref_account_avatar);
        this.O0000O0o = (AccountPreferenceView) inflate.findViewById(R$id.pref_account_user_name);
        this.O0000OOo = (AccountPreferenceView) inflate.findViewById(R$id.pref_account_user_id);
        this.O0000Oo0 = (AccountPreferenceView) inflate.findViewById(R$id.pref_account_user_gender);
        this.O0000Oo = (AccountPreferenceView) inflate.findViewById(R$id.pref_account_user_phone);
        this.O0000OoO = (AccountPreferenceView) inflate.findViewById(R$id.pref_account_user_email);
        this.O0000Ooo = (AccountPreferenceView) inflate.findViewById(R$id.pref_account_password);
        this.O00000oo.setOnClickListener(this.O0000oO0);
        this.O0000O0o.setOnClickListener(this.O0000oO0);
        this.O0000OOo.setRightArrowVisible(false);
        this.O0000Oo0.setOnClickListener(this.O0000oO0);
        this.O0000Oo.setOnClickListener(this.O0000oO0);
        this.O0000OoO.setOnClickListener(this.O0000oO0);
        this.O0000Ooo.setOnClickListener(this.O0000oO0);
        ((Button) inflate.findViewById(R$id.logout_btn)).setOnClickListener(new View.OnClickListener() {
            /* class _m_j.ejl.AnonymousClass1 */

            public final void onClick(View view) {
                ejl ejl = ejl.this;
                Activity activity = ejl.getActivity();
                AccountChangedBroadcastHelper.O000000o(activity, ejl.f15508O000000o, AccountChangedBroadcastHelper.UpdateType.PRE_REMOVE);
                MiAccountManager.O00000Oo(activity).O000000o(ejl.O0000o0O, ejl.O00000o0);
                Analytics.O00000Oo("logout");
            }
        });
        inflate.findViewById(R$id.profile_back).setOnClickListener(new View.OnClickListener() {
            /* class _m_j.ejl.AnonymousClass4 */

            public final void onClick(View view) {
                ejl.this.getActivity().onBackPressed();
            }
        });
        inflate.findViewById(R$id.help_center).setOnClickListener(new View.OnClickListener() {
            /* class _m_j.ejl.AnonymousClass5 */

            public final void onClick(View view) {
                eik.O000000o(ejl.this.getActivity(), "https://account.xiaomi.com/helpcenter");
            }
        });
        Analytics.O000000o("setting_page");
        return inflate;
    }

    public final void O000000o(String str) {
        Intent intent = new Intent(getActivity(), UserAvatarUpdateActivity.class);
        intent.setPackage(getActivity().getPackageName());
        intent.putExtra("update_avatar_type", str);
        startActivity(intent);
    }

    public void onResume() {
        super.onResume();
        if (this.O0000o0o == null || AsyncTask.Status.RUNNING != this.O0000o0o.getStatus()) {
            this.O0000o0o = new ejx(this.O00000Oo.getApplicationContext(), new O000000o(this));
            this.O0000o0o.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        }
    }

    public void onStart() {
        super.onStart();
        this.O00000Oo = getActivity();
    }

    class O000000o implements ejx.O000000o {
        private final WeakReference<ejl> O00000Oo;

        O000000o(ejl ejl) {
            this.O00000Oo = new WeakReference<>(ejl);
        }

        public final void O000000o() {
            String str;
            ejl ejl = this.O00000Oo.get();
            if (ejl != null && ejl.O00000Oo != null && !ejl.O00000Oo.isFinishing()) {
                if (ejl.f15508O000000o == null) {
                    ejl.O00000Oo.finish();
                } else if (ejl.O00000Oo != null) {
                    UserDataProxy userDataProxy = new UserDataProxy(ejl.O00000Oo);
                    String O000000o2 = userDataProxy.O000000o(ejl.f15508O000000o, "acc_user_name");
                    if (TextUtils.isEmpty(O000000o2)) {
                        O000000o2 = ejl.getString(R.string.account_none_user_name);
                    }
                    ejl.O0000O0o.setValue(O000000o2);
                    ejl.O0000OOo.setValue(ejl.f15508O000000o.name);
                    String O000000o3 = userDataProxy.O000000o(ejl.f15508O000000o, "acc_user_gender");
                    if (TextUtils.isEmpty(O000000o3)) {
                        str = ejl.getString(R.string.account_no_set);
                    } else {
                        str = ejl.getResources().getStringArray(R.array.account_user_gender_name)[!O000000o3.equals(Gender.MALE.getType())];
                    }
                    ejl.O0000Oo0.setValue(str);
                    String O000000o4 = userDataProxy.O000000o(ejl.f15508O000000o, "acc_avatar_file_name");
                    if (ejl.O0000o00 != null) {
                        ejl.O0000o00.recycle();
                    }
                    Activity activity = ejl.getActivity();
                    Bitmap bitmap = null;
                    Bitmap O000000o5 = O000000o4 != null ? ein.O000000o(activity, O000000o4) : null;
                    if (O000000o5 == null) {
                        O000000o5 = eim.decodeResource(activity.getResources(), R.drawable.passport_default_avatar);
                    }
                    if (O000000o5 != null) {
                        bitmap = eim.O000000o(activity, O000000o5);
                        O000000o5.recycle();
                    }
                    ejl.O0000o00 = bitmap;
                    if (ejl.O0000o00 != null) {
                        ejl.O00000oo.setImageBitmap(ejl.O0000o00);
                    }
                    String O000000o6 = userDataProxy.O000000o(ejl.f15508O000000o, "acc_user_email");
                    AccountPreferenceView accountPreferenceView = ejl.O0000OoO;
                    if (TextUtils.isEmpty(O000000o6)) {
                        O000000o6 = ejl.getString(R.string.account_none_bind_info);
                    }
                    accountPreferenceView.setValue(O000000o6);
                    String O000000o7 = userDataProxy.O000000o(ejl.f15508O000000o, "acc_user_phone");
                    AccountPreferenceView accountPreferenceView2 = ejl.O0000Oo;
                    if (TextUtils.isEmpty(O000000o7)) {
                        O000000o7 = ejl.getString(R.string.account_none_bind_info);
                    }
                    accountPreferenceView2.setValue(O000000o7);
                }
            }
        }
    }

    public final void O000000o(UploadProfileType uploadProfileType, String str, Gender gender) {
        if (uploadProfileType != null) {
            ekb ekb = this.O0000o.get(uploadProfileType);
            if (ekb != null) {
                ekb.cancel(true);
            }
            new ekb(getActivity(), str, gender, new O00000Oo(this, (byte) 0)).executeOnExecutor(ekx.O000000o(), new Void[0]);
        }
    }

    class O00000Oo implements ekb.O000000o {
        private O00000Oo() {
        }

        /* synthetic */ O00000Oo(ejl ejl, byte b) {
            this();
        }

        public final void O000000o(String str, Gender gender) {
            UserDataProxy userDataProxy = new UserDataProxy(ejl.this.getActivity());
            if (!TextUtils.isEmpty(str)) {
                ejl.this.O0000O0o.setValue(str);
                userDataProxy.O000000o(ejl.this.f15508O000000o, "acc_user_name", str);
            } else if (gender != null) {
                ejl.this.O0000Oo0.setValue(ejl.this.getResources().getStringArray(R.array.account_user_gender_name)[gender == Gender.MALE ? (char) 0 : 1]);
                userDataProxy.O000000o(ejl.this.f15508O000000o, "acc_user_gender", gender.getType());
            }
        }
    }

    /* renamed from: _m_j.ejl$3  reason: invalid class name */
    static /* synthetic */ class AnonymousClass3 {

        /* renamed from: O000000o  reason: collision with root package name */
        static final /* synthetic */ int[] f15513O000000o = new int[IdentityAuthReason.values().length];

        static {
            try {
                f15513O000000o[IdentityAuthReason.SEND_EMAIL_ACTIVATE_MESSAGE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public final void O000000o(IdentityAuthReason identityAuthReason) {
        if (identityAuthReason != null && AnonymousClass3.f15513O000000o[identityAuthReason.ordinal()] == 1) {
            O000000o(false, null);
        }
    }

    public final void O00000Oo(IdentityAuthReason identityAuthReason) {
        if (this.O00000oO == null) {
            this.O00000o = identityAuthReason;
            this.O00000oO = new ejr(getActivity(), new UserDataProxy(getActivity()).O000000o(this.f15508O000000o, "identity_auth_token"), identityAuthReason, new ejr.O000000o() {
                /* class _m_j.ejl.AnonymousClass11 */

                public final void O000000o(int i) {
                    ejl ejl = ejl.this;
                    ejl.O00000oO = null;
                    Toast.makeText(ejl.getActivity(), i, 1).show();
                }

                public final void O000000o(String str) {
                    ejl ejl = ejl.this;
                    ejl.O00000oO = null;
                    Intent O000000o2 = eks.O000000o(ejl.getActivity(), null, str, "passportapi", null);
                    O000000o2.putExtra("userId", ejl.this.f15508O000000o.name);
                    O000000o2.putExtra("passToken", eks.O00000o0(ejl.this.getActivity().getApplicationContext(), ejl.this.f15508O000000o));
                    ejl.this.getActivity().overridePendingTransition(0, 0);
                    ejl.this.getActivity().startActivityForResult(O000000o2, 16);
                }

                public final void O000000o() {
                    ejl ejl = ejl.this;
                    ejl.O00000oO = null;
                    ejl.O000000o(ejl.O00000o);
                }

                public final void O000000o(ServerError serverError) {
                    ejl ejl = ejl.this;
                    ejl.O00000oO = null;
                    if (ejl.getActivity() != null && !ejl.this.getActivity().isFinishing()) {
                        egc.O000000o o000000o = egc.O00000Oo;
                        egc.O000000o.O000000o(ejl.this.getActivity(), serverError);
                    }
                }
            });
            this.O00000oO.executeOnExecutor(ekx.O000000o(), new Void[0]);
        }
    }

    /* access modifiers changed from: package-private */
    public final void O000000o(boolean z, String str) {
        Intent intent = new Intent(getActivity(), BindSafeEmailActivity.class);
        intent.putExtra("extra_has_unactivated_email", z);
        intent.putExtra("unactivated_email_address", str);
        getActivity().startActivityForResult(intent, 17);
    }

    public void onDestroy() {
        HashMap<UploadProfileType, ekb> hashMap = this.O0000o;
        if (hashMap != null) {
            Iterator<UploadProfileType> it = hashMap.keySet().iterator();
            while (it.hasNext()) {
                ekb ekb = this.O0000o.get(it.next());
                if (ekb != null) {
                    ekb.cancel(true);
                }
                it.remove();
            }
        }
        Bitmap bitmap = this.O0000o00;
        if (bitmap != null) {
            bitmap.recycle();
            this.O0000o00 = null;
        }
        ejr ejr = this.O00000oO;
        if (ejr != null) {
            ejr.cancel(true);
            this.O00000oO = null;
        }
        this.O00000Oo = null;
        super.onDestroy();
    }
}
