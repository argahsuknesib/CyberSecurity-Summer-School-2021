package com.xiaomi.mico.api;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.xiaomi.mico.api.AccountInfo;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Map;

class SharedPrefsStore implements AccountStore {
    private Context mContext;

    SharedPrefsStore(Context context) {
        this.mContext = context;
    }

    private SharedPreferences getSP() {
        return this.mContext.getSharedPreferences("Account", 0);
    }

    public AccountType getAccountType() {
        int i = getSP().getInt("account_type", -1);
        AccountType[] values = AccountType.values();
        return (i < 0 || i >= values.length) ? AccountType.UNKNOWN : values[i];
    }

    public void setAccountType(AccountType accountType) {
        getSP().edit().putInt("account_type", accountType.ordinal()).apply();
    }

    public AccountInfo loadAccountInfo() {
        String string = getSP().getString("encoded_account", null);
        if (!TextUtils.isEmpty(string)) {
            return new SerializableAccountInfo().decode(string);
        }
        return null;
    }

    public void saveAccountInfo(AccountInfo accountInfo) {
        getSP().edit().putString("encoded_account", new SerializableAccountInfo().encode(accountInfo)).apply();
    }

    public void removeAccountInfo() {
        getSP().edit().remove("encoded_account").apply();
    }

    static class SerializableAccountInfo implements Serializable {
        private static final long serialVersionUID = -5499321915333515087L;
        private transient AccountInfo accountInfo;

        private SerializableAccountInfo() {
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Removed duplicated region for block: B:15:0x0027 A[SYNTHETIC, Splitter:B:15:0x0027] */
        /* JADX WARNING: Removed duplicated region for block: B:24:0x0033 A[SYNTHETIC, Splitter:B:24:0x0033] */
        public String encode(AccountInfo accountInfo2) {
            ObjectOutputStream objectOutputStream;
            this.accountInfo = accountInfo2;
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream2 = null;
            try {
                objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
                try {
                    objectOutputStream.writeObject(this);
                    try {
                        objectOutputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    return byteArrayToHexString(byteArrayOutputStream.toByteArray());
                } catch (IOException unused) {
                    if (objectOutputStream != null) {
                    }
                    return null;
                } catch (Throwable th) {
                    th = th;
                    objectOutputStream2 = objectOutputStream;
                    if (objectOutputStream2 != null) {
                    }
                    throw th;
                }
            } catch (IOException unused2) {
                objectOutputStream = null;
                if (objectOutputStream != null) {
                    try {
                        objectOutputStream.close();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                }
                return null;
            } catch (Throwable th2) {
                th = th2;
                if (objectOutputStream2 != null) {
                    try {
                        objectOutputStream2.close();
                    } catch (IOException e3) {
                        e3.printStackTrace();
                    }
                }
                throw th;
            }
        }

        private static String byteArrayToHexString(byte[] bArr) {
            StringBuilder sb = new StringBuilder(bArr.length * 2);
            for (byte b : bArr) {
                byte b2 = b & 255;
                if (b2 < 16) {
                    sb.append('0');
                }
                sb.append(Integer.toHexString(b2));
            }
            return sb.toString();
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Removed duplicated region for block: B:17:0x0031 A[SYNTHETIC, Splitter:B:17:0x0031] */
        /* JADX WARNING: Removed duplicated region for block: B:22:0x0038 A[SYNTHETIC, Splitter:B:22:0x0038] */
        public AccountInfo decode(String str) {
            ObjectInputStream objectInputStream;
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(hexStringToByteArray(str));
            AccountInfo accountInfo2 = null;
            try {
                objectInputStream = new ObjectInputStream(byteArrayInputStream);
                try {
                    accountInfo2 = ((SerializableAccountInfo) objectInputStream.readObject()).accountInfo;
                } catch (IOException | ClassNotFoundException e) {
                    e = e;
                    try {
                        e.printStackTrace();
                        if (objectInputStream != null) {
                        }
                        return accountInfo2;
                    } catch (Throwable th) {
                        th = th;
                        if (objectInputStream != null) {
                        }
                        throw th;
                    }
                }
                try {
                    objectInputStream.close();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            } catch (IOException | ClassNotFoundException e3) {
                e = e3;
                objectInputStream = null;
                e.printStackTrace();
                if (objectInputStream != null) {
                    objectInputStream.close();
                }
                return accountInfo2;
            } catch (Throwable th2) {
                objectInputStream = null;
                th = th2;
                if (objectInputStream != null) {
                    try {
                        objectInputStream.close();
                    } catch (IOException e4) {
                        e4.printStackTrace();
                    }
                }
                throw th;
            }
            return accountInfo2;
        }

        private static byte[] hexStringToByteArray(String str) {
            int length = str.length();
            byte[] bArr = new byte[(length / 2)];
            for (int i = 0; i < length; i += 2) {
                bArr[i / 2] = (byte) ((Character.digit(str.charAt(i), 16) << 4) + Character.digit(str.charAt(i + 1), 16));
            }
            return bArr;
        }

        private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
            objectOutputStream.writeObject(this.accountInfo.getPassportInfo());
            objectOutputStream.writeObject(this.accountInfo.getServiceInfoMap());
        }

        private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
            this.accountInfo = AccountInfo.newAccountInfo((AccountInfo.PassportInfo) objectInputStream.readObject(), (Map) objectInputStream.readObject());
        }
    }
}
