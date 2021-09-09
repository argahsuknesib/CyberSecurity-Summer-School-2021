package _m_j;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.xiaomi.accountsdk.account.XMPassport;
import com.xiaomi.accountsdk.account.data.ActivatorPhoneInfo;
import com.xiaomi.accountsdk.account.data.QueryPhoneInfoParams;
import com.xiaomi.accountsdk.account.data.RegisterUserInfo;
import com.xiaomi.accountsdk.account.exception.InvalidPhoneNumException;
import com.xiaomi.accountsdk.account.exception.InvalidVerifyCodeException;
import com.xiaomi.accountsdk.request.AccessDeniedException;
import com.xiaomi.accountsdk.request.AuthenticationFailureException;
import com.xiaomi.accountsdk.request.InvalidResponseException;
import com.xiaomi.accountsdk.utils.AccountLog;
import com.xiaomi.passport.ui.R$id;
import com.xiaomi.passport.ui.data.PhoneAccount;
import com.xiaomi.passport.ui.view.DoublePhoneAccountLayout;
import com.xiaomi.passport.ui.view.QueryPhoneAccountLayout;
import com.xiaomi.passport.ui.view.SinglePhoneAccountLayout;
import com.xiaomi.phonenum.data.AccountCertification;
import com.xiaomi.phonenum.procedure.AccountPhoneNumberManagerFactory;
import com.xiaomi.phonenum.procedure.AccountPhoneNumberSourceFlag;
import com.xiaomi.phonenum.procedure.IAccountPhoneNumberManager;
import com.xiaomi.smarthome.R;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public final class eji extends Fragment implements ekm, DoublePhoneAccountLayout.O000000o, QueryPhoneAccountLayout.O000000o, SinglePhoneAccountLayout.O000000o {

    /* renamed from: O000000o  reason: collision with root package name */
    public ekk f15502O000000o;
    public List<PhoneAccount> O00000Oo;
    private O000000o O00000o;
    private ekl O00000o0;
    private QueryPhoneAccountLayout O00000oO;
    private SinglePhoneAccountLayout O00000oo;
    private DoublePhoneAccountLayout O0000O0o;

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, android.view.ViewGroup, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate((int) R.layout.passport_fragment_phone_account, viewGroup, false);
    }

    public final void onViewCreated(View view, Bundle bundle) {
        this.O00000oO = (QueryPhoneAccountLayout) view.findViewById(R$id.query_phone_account);
        this.O00000oO.setOnActionClickListener(this);
        this.O00000oo = (SinglePhoneAccountLayout) view.findViewById(R$id.single_phone_account);
        this.O00000oo.setOnActionListener(this);
        this.O0000O0o = (DoublePhoneAccountLayout) view.findViewById(R$id.double_phone_account);
        this.O0000O0o.setOnActionListener(this);
        if (this.O00000Oo == null) {
            O00000o();
            this.O00000o = new O000000o(getActivity(), getArguments().getString("sid"), new AccountPhoneNumberSourceFlag(getArguments().getInt("account_phone_number_source_flag")));
            this.O00000o.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        }
        O00000o0();
    }

    public final void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof ekk) {
            this.f15502O000000o = (ekk) context;
            if (context instanceof ekl) {
                this.O00000o0 = (ekl) context;
                return;
            }
            throw new IllegalStateException("attached context is not instance of AccountLoginUiUpdater");
        }
        throw new IllegalStateException("attached context is not instance of AccountLoginController");
    }

    public final void onDestroyView() {
        super.onDestroyView();
        O00000o();
    }

    public static eji O000000o(String str, int i) {
        eji eji = new eji();
        Bundle bundle = new Bundle();
        bundle.putString("sid", str);
        bundle.putInt("account_phone_number_source_flag", i);
        eji.setArguments(bundle);
        return eji;
    }

    private void O00000o() {
        O000000o o000000o = this.O00000o;
        if (o000000o != null) {
            o000000o.cancel(true);
            this.O00000o = null;
        }
    }

    public final void O000000o() {
        O00000o();
        this.f15502O000000o.onSkipQueryPhoneAccount();
    }

    public final void O00000Oo() {
        this.f15502O000000o.onUseManualInputLogin();
    }

    public final void O000000o(PhoneAccount phoneAccount) {
        this.f15502O000000o.onRequestPhoneLogin(phoneAccount);
    }

    public final void O00000Oo(PhoneAccount phoneAccount) {
        this.f15502O000000o.onRequestPhoneRegisterAndLogin(phoneAccount);
    }

    private void O00000oO() {
        this.O00000oO.setVisibility(0);
        this.O00000oo.setVisibility(8);
        this.O0000O0o.setVisibility(8);
        this.O00000o0.updateHeaderVisibility(true, false);
        this.O00000o0.updateFooterVisibility(false, false);
    }

    private void O00000o0(PhoneAccount phoneAccount) {
        this.O00000oO.setVisibility(8);
        this.O00000oo.setVisibility(0);
        this.O0000O0o.setVisibility(8);
        this.O00000oo.O00000Oo.O000000o(phoneAccount);
        this.O00000o0.updateHeaderVisibility(true, true);
        this.O00000o0.updateFooterVisibility(true, true);
        this.O00000o0.updateUserAgreement(new PhoneAccount[]{phoneAccount});
    }

    private void O000000o(PhoneAccount phoneAccount, PhoneAccount phoneAccount2) {
        this.O00000oO.setVisibility(8);
        this.O00000oo.setVisibility(8);
        this.O0000O0o.setVisibility(0);
        DoublePhoneAccountLayout doublePhoneAccountLayout = this.O0000O0o;
        if (phoneAccount.O00000o0() || phoneAccount2.O00000o0()) {
            doublePhoneAccountLayout.f6330O000000o.setUserAvatarPlaceholder(R.drawable.passport_ic_user_avatar_sim);
            doublePhoneAccountLayout.O00000Oo.setUserAvatarPlaceholder(R.drawable.passport_ic_user_avatar_sim);
        } else {
            doublePhoneAccountLayout.f6330O000000o.setUserAvatarPlaceholder(R.drawable.passport_ic_user_avatar_sim1);
            doublePhoneAccountLayout.O00000Oo.setUserAvatarPlaceholder(R.drawable.passport_ic_user_avatar_sim2);
        }
        if (!phoneAccount.O000000o() || !phoneAccount2.O000000o()) {
            doublePhoneAccountLayout.f6330O000000o.setCustomUserNameVisible(true);
            doublePhoneAccountLayout.O00000Oo.setCustomUserNameVisible(true);
        } else {
            doublePhoneAccountLayout.f6330O000000o.setCustomUserNameVisible(false);
            doublePhoneAccountLayout.O00000Oo.setCustomUserNameVisible(false);
        }
        doublePhoneAccountLayout.f6330O000000o.O000000o(phoneAccount);
        doublePhoneAccountLayout.O00000Oo.O000000o(phoneAccount2);
        boolean O00000Oo2 = phoneAccount.O00000Oo();
        int i = R.string.login_register_by_local_phone_long_text;
        if (O00000Oo2) {
            if (phoneAccount2.O00000Oo()) {
                i = R.string.login_by_local_phone_long_text;
            }
        } else if (!phoneAccount2.O00000Oo()) {
            i = R.string.register_by_local_phone_long_text;
        }
        doublePhoneAccountLayout.O00000o0.setText(i);
        this.O00000o0.updateHeaderVisibility(true, true);
        this.O00000o0.updateFooterVisibility(true, true);
        this.O00000o0.updateUserAgreement(new PhoneAccount[]{phoneAccount, phoneAccount2});
    }

    public final void O00000o0() {
        List<PhoneAccount> list = this.O00000Oo;
        if (list == null) {
            O00000oO();
            return;
        }
        int size = list.size();
        if (size == 0) {
            this.f15502O000000o.onUseManualInputLogin();
        } else if (size != 1) {
            O000000o(this.O00000Oo.get(0), this.O00000Oo.get(1));
        } else {
            O00000o0(this.O00000Oo.get(0));
        }
    }

    class O000000o extends AsyncTask<Void, Void, PhoneAccount[]> {
        private final Context O00000Oo;
        private final AccountPhoneNumberSourceFlag O00000o;
        private final String O00000o0;

        /* access modifiers changed from: protected */
        public final /* synthetic */ Object doInBackground(Object[] objArr) {
            return O000000o();
        }

        /* access modifiers changed from: protected */
        public final /* synthetic */ void onPostExecute(Object obj) {
            PhoneAccount[] phoneAccountArr = (PhoneAccount[]) obj;
            if (phoneAccountArr == null) {
                eji.this.f15502O000000o.onQueryPhoneAccountFailed();
                return;
            }
            ArrayList arrayList = new ArrayList();
            for (PhoneAccount phoneAccount : phoneAccountArr) {
                if (phoneAccount != null) {
                    arrayList.add(phoneAccount);
                }
            }
            eji eji = eji.this;
            eji.O00000Oo = arrayList;
            eji.O00000o0();
        }

        public O000000o(Context context, String str, AccountPhoneNumberSourceFlag accountPhoneNumberSourceFlag) {
            this.O00000Oo = context.getApplicationContext();
            this.O00000o0 = str;
            this.O00000o = accountPhoneNumberSourceFlag;
        }

        /* access modifiers changed from: protected */
        public final void onPreExecute() {
            eji.this.O00000o0();
        }

        private PhoneAccount[] O000000o() {
            IAccountPhoneNumberManager createProperManager = AccountPhoneNumberManagerFactory.createProperManager(this.O00000Oo);
            AccountLog.i("QueryPhoneAccountFragment", "query sid=" + this.O00000o0 + ", flag=" + this.O00000o.sourceFlag);
            AccountCertification[] accountCertifications = createProperManager.getAccountCertifications(this.O00000Oo, this.O00000o0, this.O00000o);
            PhoneAccount[] phoneAccountArr = new PhoneAccount[accountCertifications.length];
            for (int i = 0; i < phoneAccountArr.length; i++) {
                if (accountCertifications[i] != null) {
                    AccountLog.i("QueryPhoneAccountFragment", "query account slot " + i + " is valid, accountCert=" + accountCertifications[i]);
                    try {
                        RegisterUserInfo queryPhoneUserInfo = XMPassport.queryPhoneUserInfo(new QueryPhoneInfoParams.Builder().serviceId(this.O00000o0).subId(String.valueOf(accountCertifications[i].subId)).phoneHashActivatorToken(new ActivatorPhoneInfo.Builder().slotId(i).activatorToken(accountCertifications[i].activatorToken).phoneHash(accountCertifications[i].hashedPhoneNumber).build()).build());
                        phoneAccountArr[i] = new PhoneAccount(accountCertifications[i], queryPhoneUserInfo);
                        if (queryPhoneUserInfo != null) {
                            ekf.O000000o(this.O00000Oo, queryPhoneUserInfo.avatarAddress);
                        }
                    } catch (AccessDeniedException e) {
                        AccountLog.e("QueryPhoneAccountFragment", "queryPhoneUserInfo", e);
                    } catch (AuthenticationFailureException e2) {
                        AccountLog.e("QueryPhoneAccountFragment", "queryPhoneUserInfo", e2);
                    } catch (IOException e3) {
                        AccountLog.e("QueryPhoneAccountFragment", "queryPhoneUserInfo", e3);
                    } catch (InvalidResponseException e4) {
                        AccountLog.e("QueryPhoneAccountFragment", "queryPhoneUserInfo", e4);
                    } catch (InvalidVerifyCodeException e5) {
                        createProperManager.invalidateAccountCertification(this.O00000Oo, this.O00000o0, accountCertifications[i]);
                        AccountLog.e("QueryPhoneAccountFragment", "queryPhoneUserInfo", e5);
                    } catch (InvalidPhoneNumException e6) {
                        AccountLog.e("QueryPhoneAccountFragment", "queryPhoneUserInfo", e6);
                    }
                }
            }
            return phoneAccountArr;
        }
    }
}
