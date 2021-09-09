package _m_j;

import javax.crypto.Cipher;

public interface fwe {
    void onGetCipherError(int i, String str);

    void onGetCipherSuccess(Cipher cipher);

    void onGetResetCipherSuccess(Cipher cipher);
}
