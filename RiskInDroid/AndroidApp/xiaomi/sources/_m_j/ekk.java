package _m_j;

import com.xiaomi.passport.ui.data.PhoneAccount;

public interface ekk {
    boolean isUserAgreedProtocol();

    void onQueryPhoneAccountFailed();

    void onRequestPhoneLogin(PhoneAccount phoneAccount);

    void onRequestPhoneRegisterAndLogin(PhoneAccount phoneAccount);

    void onRequestSendTicketAndLogin(PhoneAccount phoneAccount);

    void onRequestSnsLogin(ehr ehr, ehq ehq);

    void onSkipQueryPhoneAccount();

    void onSnsLoginFailed();

    void onUseManualInputLogin();
}
