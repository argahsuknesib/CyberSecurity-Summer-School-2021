package com.amap.api.services.a;

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

public final class d {
    private static d e;

    /* renamed from: a  reason: collision with root package name */
    private List<String> f3389a;
    /* access modifiers changed from: private */
    public String b;
    /* access modifiers changed from: private */
    public final Context c;
    private final Handler d;

    public static d a(Context context) {
        if (e == null) {
            synchronized (d.class) {
                if (e == null) {
                    e = new d(context);
                }
            }
        }
        return e;
    }

    private d(Context context) {
        this.c = context.getApplicationContext();
        if (Looper.myLooper() == null) {
            this.d = new a(Looper.getMainLooper(), this);
        } else {
            this.d = new a(this);
        }
    }

    public final void a(String str) {
        this.b = str;
    }

    public final List<String> a() {
        List<String> list = this.f3389a;
        if (list != null && list.size() > 0 && !TextUtils.isEmpty(this.f3389a.get(0))) {
            return this.f3389a;
        }
        this.f3389a = b();
        return this.f3389a;
    }

    public final void b(String str) {
        List<String> list = this.f3389a;
        if (list != null) {
            list.clear();
            this.f3389a.add(str);
        }
        a(str, 273);
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x002d  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0044  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0054  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0081  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x008b  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0028  */
    private List<String> b() {
        String str;
        String string;
        String str2 = "";
        try {
            String string2 = Settings.System.getString(this.c.getContentResolver(), this.b);
            if (!TextUtils.isEmpty(string2)) {
                str = i.c(string2);
                String a2 = e.a(this.c, this.b);
                String c2 = TextUtils.isEmpty(a2) ? i.c(a2) : str2;
                int i = 0;
                string = this.c.getSharedPreferences("SharedPreferenceAdiu", 0).getString(this.b, null);
                if (!TextUtils.isEmpty(string)) {
                    str2 = i.c(string);
                }
                ArrayList arrayList = new ArrayList(3);
                if (TextUtils.isEmpty(str)) {
                    arrayList.add(str);
                    if (!TextUtils.isEmpty(c2)) {
                        if (!TextUtils.equals(c2, str)) {
                            arrayList.add(c2);
                        }
                        if (!TextUtils.isEmpty(str2)) {
                            if (!TextUtils.equals(str2, str)) {
                                if (!TextUtils.equals(str2, c2)) {
                                    arrayList.add(str2);
                                }
                            }
                            if (i > 0) {
                                Handler handler = this.d;
                                handler.sendMessage(handler.obtainMessage(i, str));
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
                } else if (!TextUtils.isEmpty(c2)) {
                    arrayList.add(c2);
                    if (!TextUtils.isEmpty(str2)) {
                        if (!TextUtils.equals(str2, c2)) {
                            arrayList.add(str2);
                        }
                        Handler handler2 = this.d;
                        handler2.sendMessage(handler2.obtainMessage(i | 1, c2));
                        return arrayList;
                    }
                    i = 256;
                    Handler handler22 = this.d;
                    handler22.sendMessage(handler22.obtainMessage(i | 1, c2));
                    return arrayList;
                } else if (TextUtils.isEmpty(str2)) {
                    return null;
                } else {
                    arrayList.add(str2);
                    Handler handler3 = this.d;
                    handler3.sendMessage(handler3.obtainMessage(17, str2));
                    return arrayList;
                }
            }
        } catch (Exception unused) {
        }
        str = str2;
        String a22 = e.a(this.c, this.b);
        if (TextUtils.isEmpty(a22)) {
        }
        int i2 = 0;
        string = this.c.getSharedPreferences("SharedPreferenceAdiu", 0).getString(this.b, null);
        if (!TextUtils.isEmpty(string)) {
        }
        ArrayList arrayList2 = new ArrayList(3);
        if (TextUtils.isEmpty(str)) {
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0072, code lost:
        return;
     */
    public synchronized void a(final String str, final int i) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            new Thread() {
                /* class com.amap.api.services.a.d.AnonymousClass1 */

                public void run() {
                    String b2 = i.b(str);
                    if (!TextUtils.isEmpty(b2)) {
                        if ((i & 1) > 0) {
                            try {
                                if (Build.VERSION.SDK_INT >= 23) {
                                    Settings.System.putString(d.this.c.getContentResolver(), d.this.b, b2);
                                } else {
                                    Settings.System.putString(d.this.c.getContentResolver(), d.this.b, b2);
                                }
                            } catch (Exception unused) {
                            }
                        }
                        if ((i & 16) > 0) {
                            e.a(d.this.c, d.this.b, b2);
                        }
                        if ((i & 256) > 0) {
                            SharedPreferences.Editor edit = d.this.c.getSharedPreferences("SharedPreferenceAdiu", 0).edit();
                            edit.putString(d.this.b, b2);
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
        String b2 = i.b(str);
        if (!TextUtils.isEmpty(b2)) {
            if ((i & 1) > 0) {
                try {
                    if (Build.VERSION.SDK_INT >= 23) {
                        Settings.System.putString(this.c.getContentResolver(), this.b, b2);
                    } else {
                        Settings.System.putString(this.c.getContentResolver(), this.b, b2);
                    }
                } catch (Exception unused) {
                }
            }
            if ((i & 16) > 0) {
                e.a(this.c, this.b, b2);
            }
            if ((i & 256) > 0) {
                SharedPreferences.Editor edit = this.c.getSharedPreferences("SharedPreferenceAdiu", 0).edit();
                edit.putString(this.b, b2);
                if (Build.VERSION.SDK_INT >= 9) {
                    edit.apply();
                    return;
                }
                edit.commit();
            }
        }
    }

    static final class a extends Handler {

        /* renamed from: a  reason: collision with root package name */
        private final WeakReference<d> f3391a;

        a(d dVar) {
            this.f3391a = new WeakReference<>(dVar);
        }

        a(Looper looper, d dVar) {
            super(looper);
            this.f3391a = new WeakReference<>(dVar);
        }

        public final void handleMessage(Message message) {
            d dVar = this.f3391a.get();
            if (dVar != null && message != null && message.obj != null) {
                dVar.a((String) message.obj, message.what);
            }
        }
    }
}
