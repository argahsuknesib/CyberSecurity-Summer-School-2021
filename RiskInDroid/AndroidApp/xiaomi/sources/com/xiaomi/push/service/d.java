package com.xiaomi.push.service;

import _m_j.esl;
import android.app.Notification;
import android.content.Context;
import android.os.Build;
import android.os.SystemClock;
import android.service.notification.StatusBarNotification;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class d {

    /* renamed from: a  reason: collision with root package name */
    private static List<a> f6556a = new CopyOnWriteArrayList();

    static class a {

        /* renamed from: a  reason: collision with root package name */
        public final int f6557a;

        /* renamed from: a  reason: collision with other field name */
        public final long f315a;

        /* renamed from: a  reason: collision with other field name */
        public final String f316a;

        /* renamed from: a  reason: collision with other field name */
        public final Notification.Action[] f317a;

        a(String str, long j, int i, Notification.Action[] actionArr) {
            this.f316a = str;
            this.f315a = j;
            this.f6557a = i;
            this.f317a = actionArr;
        }
    }

    private static void a() {
        for (int size = f6556a.size() - 1; size >= 0; size--) {
            a aVar = f6556a.get(size);
            if (SystemClock.elapsedRealtime() - aVar.f315a > 5000) {
                f6556a.remove(aVar);
            }
        }
        if (f6556a.size() > 10) {
            f6556a.remove(0);
        }
    }

    protected static void a(Context context, StatusBarNotification statusBarNotification, int i) {
        if (esl.O000000o(context) && i > 0 && statusBarNotification != null && Build.VERSION.SDK_INT >= 20) {
            a(new a(statusBarNotification.getKey(), SystemClock.elapsedRealtime(), i, as.m174a(statusBarNotification.getNotification())));
        }
    }

    private static void a(a aVar) {
        f6556a.add(aVar);
        a();
    }
}
