package _m_j;

import android.content.ContentResolver;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.provider.Settings;
import android.text.TextUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public final class buk {
    private static buk O00000oO;

    /* renamed from: O000000o  reason: collision with root package name */
    List<String> f13288O000000o;
    /* access modifiers changed from: package-private */
    public String O00000Oo;
    private final Handler O00000o;
    /* access modifiers changed from: private */
    public final Context O00000o0;

    static final class O000000o extends Handler {

        /* renamed from: O000000o  reason: collision with root package name */
        private final WeakReference<buk> f13290O000000o;

        O000000o(buk buk) {
            this.f13290O000000o = new WeakReference<>(buk);
        }

        O000000o(Looper looper, buk buk) {
            super(looper);
            this.f13290O000000o = new WeakReference<>(buk);
        }

        public final void handleMessage(Message message) {
            buk buk = this.f13290O000000o.get();
            if (buk != null && message != null && message.obj != null) {
                buk.O000000o((String) message.obj, message.what);
            }
        }
    }

    private buk(Context context) {
        this.O00000o0 = context.getApplicationContext();
        this.O00000o = Looper.myLooper() == null ? new O000000o(Looper.getMainLooper(), this) : new O000000o(this);
    }

    public static buk O000000o(Context context) {
        if (O00000oO == null) {
            synchronized (buk.class) {
                if (O00000oO == null) {
                    O00000oO = new buk(context);
                }
            }
        }
        return O00000oO;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x002d  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0044  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0054  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0081  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x008b  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0028  */
    public final List<String> O000000o() {
        String str;
        String string;
        Handler handler;
        Message obtainMessage;
        String str2 = "";
        try {
            String string2 = Settings.System.getString(this.O00000o0.getContentResolver(), this.O00000Oo);
            if (!TextUtils.isEmpty(string2)) {
                str = bwo.O00000o0(string2);
                String O000000o2 = bvj.O000000o(this.O00000o0, this.O00000Oo);
                String O00000o02 = TextUtils.isEmpty(O000000o2) ? bwo.O00000o0(O000000o2) : str2;
                int i = 0;
                string = this.O00000o0.getSharedPreferences("SharedPreferenceAdiu", 0).getString(this.O00000Oo, null);
                if (!TextUtils.isEmpty(string)) {
                    str2 = bwo.O00000o0(string);
                }
                ArrayList arrayList = new ArrayList(3);
                if (TextUtils.isEmpty(str)) {
                    arrayList.add(str);
                    if (!TextUtils.isEmpty(O00000o02)) {
                        if (!TextUtils.equals(O00000o02, str)) {
                            arrayList.add(O00000o02);
                        }
                        if (!TextUtils.isEmpty(str2)) {
                            if (!TextUtils.equals(str2, str)) {
                                if (!TextUtils.equals(str2, O00000o02)) {
                                    arrayList.add(str2);
                                }
                            }
                            if (i > 0) {
                                Handler handler2 = this.O00000o;
                                handler2.sendMessage(handler2.obtainMessage(i, str));
                            }
                            return arrayList;
                        }
                        i |= 256;
                        if (i > 0) {
                        }
                        return arrayList;
                    }
                    i = 16;
                    if (!TextUtils.isEmpty(str2)) {
                    }
                    i |= 256;
                    if (i > 0) {
                    }
                    return arrayList;
                }
                if (!TextUtils.isEmpty(O00000o02)) {
                    arrayList.add(O00000o02);
                    if (!TextUtils.isEmpty(str2)) {
                        if (!TextUtils.equals(str2, O00000o02)) {
                            arrayList.add(str2);
                        }
                        handler = this.O00000o;
                        obtainMessage = handler.obtainMessage(i | 1, O00000o02);
                    }
                    i = 256;
                    handler = this.O00000o;
                    obtainMessage = handler.obtainMessage(i | 1, O00000o02);
                } else if (TextUtils.isEmpty(str2)) {
                    return null;
                } else {
                    arrayList.add(str2);
                    handler = this.O00000o;
                    obtainMessage = handler.obtainMessage(17, str2);
                }
                handler.sendMessage(obtainMessage);
                return arrayList;
            }
        } catch (Exception unused) {
        }
        str = str2;
        String O000000o22 = bvj.O000000o(this.O00000o0, this.O00000Oo);
        if (TextUtils.isEmpty(O000000o22)) {
        }
        int i2 = 0;
        string = this.O00000o0.getSharedPreferences("SharedPreferenceAdiu", 0).getString(this.O00000Oo, null);
        if (!TextUtils.isEmpty(string)) {
        }
        ArrayList arrayList2 = new ArrayList(3);
        if (TextUtils.isEmpty(str)) {
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x006f, code lost:
        return;
     */
    public final synchronized void O000000o(final String str, final int i) {
        ContentResolver contentResolver;
        String str2;
        if (Looper.myLooper() == Looper.getMainLooper()) {
            new Thread() {
                /* class _m_j.buk.AnonymousClass1 */

                public final void run() {
                    ContentResolver contentResolver;
                    String O00000Oo2;
                    String O00000Oo3 = bwo.O00000Oo(str);
                    if (!TextUtils.isEmpty(O00000Oo3)) {
                        if ((i & 1) > 0) {
                            try {
                                if (Build.VERSION.SDK_INT >= 23) {
                                    contentResolver = buk.this.O00000o0.getContentResolver();
                                    O00000Oo2 = buk.this.O00000Oo;
                                } else {
                                    contentResolver = buk.this.O00000o0.getContentResolver();
                                    O00000Oo2 = buk.this.O00000Oo;
                                }
                                Settings.System.putString(contentResolver, O00000Oo2, O00000Oo3);
                            } catch (Exception unused) {
                            }
                        }
                        if ((i & 16) > 0) {
                            bvj.O000000o(buk.this.O00000o0, buk.this.O00000Oo, O00000Oo3);
                        }
                        if ((i & 256) > 0) {
                            SharedPreferences.Editor edit = buk.this.O00000o0.getSharedPreferences("SharedPreferenceAdiu", 0).edit();
                            edit.putString(buk.this.O00000Oo, O00000Oo3);
                            if (Build.VERSION.SDK_INT >= 9) {
                                edit.apply();
                            } else {
                                edit.commit();
                            }
                        }
                    }
                }
            }.start();
            return;
        }
        String O00000Oo2 = bwo.O00000Oo(str);
        if (!TextUtils.isEmpty(O00000Oo2)) {
            if ((i & 1) > 0) {
                try {
                    if (Build.VERSION.SDK_INT >= 23) {
                        contentResolver = this.O00000o0.getContentResolver();
                        str2 = this.O00000Oo;
                    } else {
                        contentResolver = this.O00000o0.getContentResolver();
                        str2 = this.O00000Oo;
                    }
                    Settings.System.putString(contentResolver, str2, O00000Oo2);
                } catch (Exception unused) {
                }
            }
            if ((i & 16) > 0) {
                bvj.O000000o(this.O00000o0, this.O00000Oo, O00000Oo2);
            }
            if ((i & 256) > 0) {
                SharedPreferences.Editor edit = this.O00000o0.getSharedPreferences("SharedPreferenceAdiu", 0).edit();
                edit.putString(this.O00000Oo, O00000Oo2);
                if (Build.VERSION.SDK_INT >= 9) {
                    edit.apply();
                    return;
                }
                edit.commit();
            }
        }
    }
}
