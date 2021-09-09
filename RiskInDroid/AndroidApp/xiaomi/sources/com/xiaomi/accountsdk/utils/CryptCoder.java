package com.xiaomi.accountsdk.utils;

import com.xiaomi.accountsdk.request.CipherException;

public interface CryptCoder {
    String decrypt(String str) throws CipherException;

    String encrypt(String str) throws CipherException;
}
