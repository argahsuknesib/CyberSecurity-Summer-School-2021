package com.xiaomi.push.service;

import _m_j.duv;
import _m_j.ele;
import _m_j.eml;
import _m_j.eru;
import _m_j.esu;
import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.push.hs;
import com.xiaomi.push.ht;
import com.xiaomi.push.hz;
import com.xiaomi.push.io;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class bs {

    /* renamed from: a  reason: collision with root package name */
    private static String f6535a;

    /* renamed from: a  reason: collision with other field name */
    private static SimpleDateFormat f304a;

    /* renamed from: a  reason: collision with other field name */
    private static AtomicLong f305a = new AtomicLong(0);

    static {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
        f304a = simpleDateFormat;
        f6535a = simpleDateFormat.format(Long.valueOf(System.currentTimeMillis()));
    }

    public static synchronized String a() {
        String str;
        synchronized (bs.class) {
            String format = f304a.format(Long.valueOf(System.currentTimeMillis()));
            if (!TextUtils.equals(f6535a, format)) {
                f305a.set(0);
                f6535a = format;
            }
            str = format + "-" + f305a.incrementAndGet();
        }
        return str;
    }

    public static boolean a(ht htVar, boolean z) {
        String str;
        if (htVar == null) {
            str = "item is null, verfiy ClientUploadDataItem failed.";
        } else if (!z && TextUtils.isEmpty(htVar.f52a)) {
            str = "item.channel is null or empty, verfiy ClientUploadDataItem failed.";
        } else if (TextUtils.isEmpty(htVar.d)) {
            str = "item.category is null or empty, verfiy ClientUploadDataItem failed.";
        } else if (TextUtils.isEmpty(htVar.c)) {
            str = "item.name is null or empty, verfiy ClientUploadDataItem failed.";
        } else if (!eml.O00000o(htVar.d)) {
            str = "item.category can only contain ascii char, verfiy ClientUploadDataItem failed.";
        } else if (!eml.O00000o(htVar.c)) {
            str = "item.name can only contain ascii char, verfiy ClientUploadDataItem failed.";
        } else if (htVar.f56b == null || htVar.f56b.length() <= 10240) {
            return false;
        } else {
            str = "item.data is too large(" + htVar.f56b.length() + "), max size for data is 10240 , verfiy ClientUploadDataItem failed.";
        }
        duv.O000000o(str);
        return true;
    }

    public static boolean a(String str) {
        return !esu.O00000o() || "com.miui.hybrid".equals(str);
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x0059  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x005c  */
    public static ArrayList<io> a(List<ht> list, String str, String str2, int i) {
        int i2;
        String str3;
        if (list == null) {
            str3 = "requests can not be null in TinyDataHelper.transToThriftObj().";
        } else if (list.size() == 0) {
            str3 = "requests.length is 0 in TinyDataHelper.transToThriftObj().";
        } else {
            ArrayList<io> arrayList = new ArrayList<>();
            int i3 = 0;
            hs hsVar = new hs();
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                ht htVar = list.get(i5);
                if (htVar != null) {
                    if (htVar.f54a == null || !htVar.f54a.containsKey("item_size")) {
                        i2 = 0;
                    } else {
                        String str4 = htVar.f54a.get("item_size");
                        if (!TextUtils.isEmpty(str4)) {
                            try {
                                i2 = Integer.parseInt(str4);
                            } catch (Exception unused) {
                            }
                            if (htVar.f54a.size() != 1) {
                                htVar.f54a = null;
                            } else {
                                htVar.f54a.remove("item_size");
                            }
                        }
                        i2 = 0;
                        if (htVar.f54a.size() != 1) {
                        }
                    }
                    if (i2 <= 0) {
                        i2 = eru.O000000o(htVar).length;
                    }
                    if (i2 > i) {
                        duv.O00000o("TinyData is too big, ignore upload request item:" + htVar.f);
                    } else {
                        if (i4 + i2 > i) {
                            arrayList.add(a(str, str2, hsVar));
                            hsVar = new hs();
                            i4 = 0;
                        }
                        if (hsVar.f6393a == null) {
                            hsVar.f6393a = new ArrayList();
                        }
                        hsVar.f6393a.add(htVar);
                        i4 += i2;
                    }
                }
            }
            if (hsVar.f6393a != null) {
                i3 = hsVar.f6393a.size();
            }
            if (i3 != 0) {
                arrayList.add(a(str, str2, hsVar));
            }
            return arrayList;
        }
        duv.O00000o(str3);
        return null;
    }

    private static io a(String str, String str2, hs hsVar) {
        io ioVar = new io("-1", false);
        ioVar.f = str;
        ioVar.c = str2;
        io O000000o2 = ioVar.O000000o(ele.O000000o(eru.O000000o(hsVar)));
        O000000o2.d = hz.B.f70a;
        return O000000o2;
    }

    public static void a(Context context, String str, String str2, long j, String str3) {
        ht htVar = new ht();
        htVar.d = str;
        htVar.c = str2;
        htVar.O000000o(j);
        htVar.f56b = str3;
        htVar.f52a = "push_sdk_channel";
        htVar.g = context.getPackageName();
        htVar.e = context.getPackageName();
        htVar.O000000o(true);
        htVar.O00000Oo(System.currentTimeMillis());
        htVar.f = a();
        bt.a(context, htVar);
    }
}
