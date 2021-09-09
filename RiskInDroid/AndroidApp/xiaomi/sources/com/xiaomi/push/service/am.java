package com.xiaomi.push.service;

import android.app.Notification;
import android.content.Context;
import com.xiaomi.push.ex;
import com.xiaomi.push.il;
import java.util.Map;

public abstract class am {
    /* access modifiers changed from: package-private */
    public abstract ex a(Context context, int i, String str, Map<String, String> map);

    /* access modifiers changed from: package-private */
    public abstract void a(il ilVar, Map<String, String> map, int i, Notification notification);

    /* access modifiers changed from: package-private */
    /* renamed from: a  reason: collision with other method in class */
    public abstract boolean m156a(Context context, int i, String str, Map<String, String> map);

    /* access modifiers changed from: package-private */
    public abstract boolean a(Map<String, String> map, int i, Notification notification);
}
