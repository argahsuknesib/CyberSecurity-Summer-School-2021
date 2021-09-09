package com.xiaomi.smarthome.framework.plugin.rn.nativemodule.thirdparty.hanto;

import _m_j.O00o000;
import _m_j.ayv;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.WritableNativeMap;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SecryptModule extends HTReactContextBaseJavaModule {
    public String getName() {
        return "HTRCTSecryptModule";
    }

    public SecryptModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @ReactMethod
    public void encrypt(String str, String str2, String str3, Callback callback) {
        if (callback == null) {
            showMessage("回调函数不能为空");
            return;
        }
        $$Lambda$SecryptModule$_GeYoSogqxEx6FPWcVM9pVwhg3E r0 = new ayv.O000000o(callback) {
            /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.thirdparty.hanto.$$Lambda$SecryptModule$_GeYoSogqxEx6FPWcVM9pVwhg3E */
            private final /* synthetic */ Callback f$1;

            {
                this.f$1 = r2;
            }

            public final void result(String str, int i) {
                SecryptModule.this.lambda$encrypt$0$SecryptModule(this.f$1, str, i);
            }
        };
        if (str2.equals("aes")) {
            O00o000.O000000o();
            O00o000.O000000o(new Runnable(str3, str, r0) {
                /* class _m_j.ayv.AnonymousClass1 */

                /* renamed from: O000000o  reason: collision with root package name */
                public final /* synthetic */ String f12714O000000o;
                public final /* synthetic */ String O00000Oo;
                public final /* synthetic */ O000000o O00000o0;

                {
                    this.f12714O000000o = r1;
                    this.O00000Oo = r2;
                    this.O00000o0 = r3;
                }

                public final void run() {
                    try {
                        this.O00000o0.result(ayv.O000000o(ayw.O000000o(this.f12714O000000o.toCharArray()), this.O00000Oo, true), 0);
                    } catch (Exception e) {
                        e.printStackTrace();
                        this.O00000o0.result(e.getMessage(), -1);
                    }
                }
            });
        }
    }

    public /* synthetic */ void lambda$encrypt$0$SecryptModule(Callback callback, String str, int i) {
        WritableNativeMap resultMap = getResultMap(i);
        if (i == 0) {
            WritableNativeMap writableNativeMap = new WritableNativeMap();
            writableNativeMap.putString("dst", str);
            resultMap.putMap(RESULT_DATA, writableNativeMap);
        } else {
            resultMap.putString(RESULT_MESSAGE, str);
        }
        callback.invoke(resultMap);
    }

    private WritableNativeMap getResultMap(int i) {
        WritableNativeMap writableNativeMap = new WritableNativeMap();
        writableNativeMap.putInt(RESULT_CODE, i);
        return writableNativeMap;
    }

    @ReactMethod
    public void decrypt(String str, String str2, String str3, Callback callback) {
        if (callback == null) {
            showMessage("回调函数不能为空");
            return;
        }
        $$Lambda$SecryptModule$qjAXvq5YmEE58W7PRW98HStmdYI r0 = new ayv.O000000o(callback) {
            /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.thirdparty.hanto.$$Lambda$SecryptModule$qjAXvq5YmEE58W7PRW98HStmdYI */
            private final /* synthetic */ Callback f$1;

            {
                this.f$1 = r2;
            }

            public final void result(String str, int i) {
                SecryptModule.this.lambda$decrypt$1$SecryptModule(this.f$1, str, i);
            }
        };
        if (str2.equals("aes")) {
            O00o000.O000000o();
            O00o000.O000000o(new Runnable(str3, str, r0) {
                /* class _m_j.ayv.AnonymousClass2 */

                /* renamed from: O000000o  reason: collision with root package name */
                public final /* synthetic */ String f12715O000000o;
                public final /* synthetic */ String O00000Oo;
                public final /* synthetic */ O000000o O00000o0;

                {
                    this.f12715O000000o = r1;
                    this.O00000Oo = r2;
                    this.O00000o0 = r3;
                }

                public final void run() {
                    try {
                        this.O00000o0.result(ayv.O000000o(ayw.O000000o(this.f12715O000000o.toCharArray()), this.O00000Oo, false), 0);
                    } catch (Exception e) {
                        e.printStackTrace();
                        this.O00000o0.result(e.getMessage(), -1);
                    }
                }
            });
        }
    }

    public /* synthetic */ void lambda$decrypt$1$SecryptModule(Callback callback, String str, int i) {
        WritableNativeMap resultMap = getResultMap(i);
        if (i == 0) {
            WritableNativeMap writableNativeMap = new WritableNativeMap();
            writableNativeMap.putString("dst", str);
            resultMap.putMap(RESULT_DATA, writableNativeMap);
        } else {
            resultMap.putString(RESULT_MESSAGE, str);
        }
        callback.invoke(resultMap);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0092, code lost:
        if (r2 != null) goto L_0x0094;
     */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0089 A[Catch:{ IOException -> 0x008a, NoSuchAlgorithmException -> 0x007f, all -> 0x007d }] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00a4 A[SYNTHETIC, Splitter:B:53:0x00a4] */
    @ReactMethod
    public void fileSha1(String str, Callback callback) {
        String str2;
        if (callback == null) {
            showMessage("回调函数不能为空");
            return;
        }
        $$Lambda$SecryptModule$T1ZAT10bCOKc0DAep1tek2sEMf0 r0 = new ayv.O000000o(callback) {
            /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.thirdparty.hanto.$$Lambda$SecryptModule$T1ZAT10bCOKc0DAep1tek2sEMf0 */
            private final /* synthetic */ Callback f$1;

            {
                this.f$1 = r2;
            }

            public final void result(String str, int i) {
                SecryptModule.this.lambda$fileSha1$2$SecryptModule(this.f$1, str, i);
            }
        };
        File file = new File(str);
        int i = -1;
        if (!file.exists()) {
            r0.result("文件不存在", -1);
            return;
        }
        FileInputStream fileInputStream = null;
        try {
            FileInputStream fileInputStream2 = new FileInputStream(file);
            try {
                MessageDigest instance = MessageDigest.getInstance("SHA-1");
                byte[] bArr = new byte[10485760];
                while (true) {
                    int read = fileInputStream2.read(bArr);
                    if (read <= 0) {
                        break;
                    }
                    instance.update(bArr, 0, read);
                }
                str2 = new BigInteger(1, instance.digest()).toString(16);
                int length = 40 - str2.length();
                if (length > 0) {
                    String str3 = str2;
                    for (int i2 = 0; i2 < length; i2++) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("0");
                        sb.append(str3);
                        str3 = sb.toString();
                    }
                    str2 = str3;
                }
                try {
                    fileInputStream2.close();
                    i = 0;
                } catch (IOException e) {
                    e = e;
                    i = 0;
                    System.out.println(e);
                    r0.result(str2, i);
                }
            } catch (IOException e2) {
                e = e2;
                fileInputStream = fileInputStream2;
                e.printStackTrace();
                str2 = e.getMessage();
            } catch (NoSuchAlgorithmException e3) {
                e = e3;
                fileInputStream = fileInputStream2;
                e.printStackTrace();
                str2 = e.getMessage();
                if (fileInputStream != null) {
                }
                r0.result(str2, i);
            } catch (Throwable th) {
                th = th;
                fileInputStream = fileInputStream2;
                if (fileInputStream != null) {
                }
                throw th;
            }
        } catch (IOException e4) {
            e = e4;
            e.printStackTrace();
            str2 = e.getMessage();
        } catch (NoSuchAlgorithmException e5) {
            e = e5;
            e.printStackTrace();
            str2 = e.getMessage();
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e6) {
                    e = e6;
                }
            }
            r0.result(str2, i);
        } catch (Throwable th2) {
            th = th2;
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e7) {
                    System.out.println(e7);
                }
            }
            throw th;
        }
        r0.result(str2, i);
    }

    public /* synthetic */ void lambda$fileSha1$2$SecryptModule(Callback callback, String str, int i) {
        WritableNativeMap resultMap = getResultMap(i);
        if (i == 0) {
            WritableNativeMap writableNativeMap = new WritableNativeMap();
            writableNativeMap.putString("dst", str);
            resultMap.putMap(RESULT_DATA, writableNativeMap);
        } else {
            resultMap.putString(RESULT_MESSAGE, str);
        }
        callback.invoke(resultMap);
    }

    private int[] getInts(ReadableArray readableArray) {
        int[] iArr = new int[readableArray.size()];
        for (int i = 0; i < readableArray.size(); i++) {
            iArr[i] = readableArray.getInt(i);
        }
        return iArr;
    }
}
