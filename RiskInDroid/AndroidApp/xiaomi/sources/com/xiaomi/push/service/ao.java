package com.xiaomi.push.service;

import _m_j.duv;
import _m_j.emg;
import _m_j.esl;
import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationChannel;
import android.content.Context;
import android.graphics.drawable.Icon;
import android.os.Build;
import android.os.Bundle;
import android.service.notification.StatusBarNotification;
import android.text.TextUtils;
import com.xiaomi.push.hu;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@TargetApi(24)
class ao {

    /* renamed from: a  reason: collision with root package name */
    private static ao f6499a = new ao();

    class a {

        /* renamed from: a  reason: collision with other field name */
        List<b> f250a;
        List<b> b;

        private a() {
            this.f250a = new ArrayList();
            this.b = new ArrayList();
        }
    }

    class b {

        /* renamed from: a  reason: collision with root package name */
        int f6501a;

        /* renamed from: a  reason: collision with other field name */
        Notification f251a;

        public b(int i, Notification notification) {
            this.f6501a = i;
            this.f251a = notification;
        }

        public String toString() {
            return "id:" + this.f6501a;
        }
    }

    private ao() {
    }

    private int a(String str, String str2) {
        return ("GroupSummary" + str + str2).hashCode();
    }

    public static ao a() {
        return f6499a;
    }

    private String a(Notification notification) {
        if (notification == null || notification.extras == null) {
            return null;
        }
        return notification.extras.getString("push_src_group_name");
    }

    private List<StatusBarNotification> a(ar arVar) {
        List<StatusBarNotification> b2 = arVar != null ? arVar.m171b() : null;
        if (b2 == null || b2.size() == 0) {
            return null;
        }
        return b2;
    }

    private void a(Context context, int i, Notification notification, boolean z) {
        String str;
        String c = as.c(notification);
        if (TextUtils.isEmpty(c)) {
            str = "group auto not extract pkg from notification:".concat(String.valueOf(i));
        } else {
            List<StatusBarNotification> a2 = a(ar.a(context, c));
            if (a2 == null) {
                str = "group auto not get notifications";
            } else {
                String b2 = b(notification);
                HashMap hashMap = new HashMap();
                for (StatusBarNotification next : a2) {
                    if (!(next.getNotification() == null || next.getId() == i)) {
                        a(hashMap, next);
                    }
                }
                for (Map.Entry entry : hashMap.entrySet()) {
                    String str2 = (String) entry.getKey();
                    if (!TextUtils.isEmpty(str2)) {
                        a aVar = (a) entry.getValue();
                        if (z && str2.equals(b2) && !m160b(notification)) {
                            (m159a(notification) ? aVar.b : aVar.f250a).add(new b(i, notification));
                        }
                        int size = aVar.f250a.size();
                        if (aVar.b.size() <= 0) {
                            if (z && size >= 2) {
                                a(context, c, str2, aVar.f250a.get(0).f251a);
                            }
                        } else if (size <= 0) {
                            a(context, c, str2);
                        }
                    }
                }
                return;
            }
        }
        duv.O000000o(str);
    }

    private void a(Context context, String str, String str2) {
        duv.O00000Oo("group cancel summary:".concat(String.valueOf(str2)));
        ar.a(context, str).a(a(str, str2));
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.push.service.as.a(android.app.Notification$Builder, boolean):boolean
     arg types: [android.app.Notification$Builder, int]
     candidates:
      com.xiaomi.push.service.as.a(android.content.Context, java.lang.String):int
      com.xiaomi.push.service.as.a(android.app.Notification, java.lang.String):T
      com.xiaomi.push.service.as.a(android.app.Notification, int):void
      com.xiaomi.push.service.as.a(android.app.Notification, java.lang.String):void
      com.xiaomi.push.service.as.a(android.app.Notification, boolean):void
      com.xiaomi.push.service.as.a(android.content.Context, android.content.Intent):void
      com.xiaomi.push.service.as.a(android.app.Notification$Builder, boolean):boolean */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.push.service.as.a(android.app.Notification, java.lang.String):void
     arg types: [android.app.Notification, java.lang.String]
     candidates:
      com.xiaomi.push.service.as.a(android.content.Context, java.lang.String):int
      com.xiaomi.push.service.as.a(android.app.Notification, java.lang.String):T
      com.xiaomi.push.service.as.a(android.app.Notification, int):void
      com.xiaomi.push.service.as.a(android.app.Notification, boolean):void
      com.xiaomi.push.service.as.a(android.content.Context, android.content.Intent):void
      com.xiaomi.push.service.as.a(android.app.Notification$Builder, boolean):boolean
      com.xiaomi.push.service.as.a(android.app.Notification, java.lang.String):void */
    private void a(Context context, String str, String str2, Notification notification) {
        Notification.Builder builder;
        try {
            if (TextUtils.isEmpty(str2)) {
                duv.O000000o("group show summary group is null");
                return;
            }
            int a2 = as.a(context, str);
            if (a2 == 0) {
                duv.O000000o("group show summary not get icon from ".concat(String.valueOf(str)));
                return;
            }
            ar a3 = ar.a(context, str);
            if (Build.VERSION.SDK_INT >= 26) {
                String b2 = a3.b(notification.getChannelId(), "groupSummary");
                NotificationChannel a4 = a3.m165a(b2);
                if ("groupSummary".equals(b2) && a4 == null) {
                    a3.a(new NotificationChannel(b2, "group_summary", 3));
                }
                builder = new Notification.Builder(context, b2);
            } else {
                builder = new Notification.Builder(context).setPriority(0).setDefaults(-1);
            }
            as.a(builder, true);
            Notification build = builder.setContentTitle("GroupSummary").setContentText("GroupSummary").setSmallIcon(Icon.createWithResource(str, a2)).setAutoCancel(true).setGroup(str2).setGroupSummary(true).build();
            if (!esl.O00000o() && "com.xiaomi.xmsf".equals(context.getPackageName())) {
                as.m172a(build, str);
            }
            int a5 = a(str, str2);
            a3.a(a5, build);
            duv.O00000Oo("group show summary notify:".concat(String.valueOf(a5)));
        } catch (Exception e) {
            duv.O000000o("group show summary error ".concat(String.valueOf(e)));
        }
    }

    private void a(Map<String, a> map, StatusBarNotification statusBarNotification) {
        String b2 = b(statusBarNotification.getNotification());
        a aVar = map.get(b2);
        if (aVar == null) {
            aVar = new a();
            map.put(b2, aVar);
        }
        (m159a(statusBarNotification.getNotification()) ? aVar.b : aVar.f250a).add(new b(statusBarNotification.getId(), statusBarNotification.getNotification()));
    }

    /* renamed from: a  reason: collision with other method in class */
    private boolean m158a() {
        return Build.VERSION.SDK_INT >= 24;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.emg.O000000o(java.lang.Object, java.lang.String, java.lang.Object[]):T
     arg types: [android.app.Notification, java.lang.String, ?[OBJECT, ARRAY]]
     candidates:
      _m_j.emg.O000000o(java.lang.Class<? extends java.lang.Object>, java.lang.Object, java.lang.String):T
      _m_j.emg.O000000o(java.lang.String, java.lang.String, java.lang.Object[]):T
      _m_j.emg.O000000o(java.lang.Class<?>, java.lang.String, java.lang.Class<?>[]):java.lang.reflect.Method
      _m_j.emg.O000000o(java.lang.reflect.Method[], java.lang.String, java.lang.Class<?>[]):java.lang.reflect.Method
      _m_j.emg.O000000o(java.lang.Object, java.lang.String, java.lang.Object):void
      _m_j.emg.O000000o(java.lang.Object, java.lang.String, java.lang.Object[]):T */
    /* renamed from: a  reason: collision with other method in class */
    private boolean m159a(Notification notification) {
        if (notification == null) {
            return false;
        }
        Object O000000o2 = emg.O000000o((Object) notification, "isGroupSummary", (Object[]) null);
        if (O000000o2 instanceof Boolean) {
            return ((Boolean) O000000o2).booleanValue();
        }
        return false;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.push.service.at.a(int, boolean):boolean
     arg types: [int, int]
     candidates:
      com.xiaomi.push.service.at.a(int, int):int
      com.xiaomi.push.service.at.a(com.xiaomi.push.hv, int):int
      com.xiaomi.push.service.at.a(int, long):long
      com.xiaomi.push.service.at.a(int, java.lang.String):java.lang.String
      com.xiaomi.push.service.at.a(java.util.List<android.util.Pair<com.xiaomi.push.hv, java.lang.Integer>>, java.util.List<android.util.Pair<java.lang.Integer, java.lang.Object>>):void
      com.xiaomi.push.service.at.a(int, boolean):boolean */
    private boolean a(Context context) {
        if (b(context) && ar.m163a(context)) {
            return at.a(context).a(hu.aX.a(), false);
        }
        return false;
    }

    private String b(Notification notification) {
        if (notification == null) {
            return null;
        }
        return m160b(notification) ? a(notification) : notification.getGroup();
    }

    private void b(Context context, int i, Notification notification) {
        String str;
        String c = as.c(notification);
        if (TextUtils.isEmpty(c)) {
            str = "group restore not extract pkg from notification:".concat(String.valueOf(i));
        } else {
            ar a2 = ar.a(context, c);
            List<StatusBarNotification> a3 = a(a2);
            if (a3 == null) {
                str = "group restore not get notifications";
            } else {
                for (StatusBarNotification next : a3) {
                    Notification notification2 = next.getNotification();
                    if (!(notification2 == null || !m160b(notification2) || next.getId() == i)) {
                        Notification.Builder recoverBuilder = Notification.Builder.recoverBuilder(context, next.getNotification());
                        recoverBuilder.setGroup(a(notification2));
                        as.a(recoverBuilder, m159a(notification2));
                        a2.a(next.getId(), recoverBuilder.build());
                        duv.O00000Oo("group restore notification:" + next.getId());
                    }
                }
                return;
            }
        }
        duv.O000000o(str);
    }

    /* renamed from: b  reason: collision with other method in class */
    private boolean m160b(Notification notification) {
        if (notification == null || notification.getGroup() == null || notification.extras == null) {
            return false;
        }
        long j = notification.extras.getLong("push_src_group_time");
        String a2 = a(notification);
        return notification.getGroup().equals(String.format("pushmask_%s_%s", Long.valueOf(j), a2));
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.push.service.at.a(int, boolean):boolean
     arg types: [int, int]
     candidates:
      com.xiaomi.push.service.at.a(int, int):int
      com.xiaomi.push.service.at.a(com.xiaomi.push.hv, int):int
      com.xiaomi.push.service.at.a(int, long):long
      com.xiaomi.push.service.at.a(int, java.lang.String):java.lang.String
      com.xiaomi.push.service.at.a(java.util.List<android.util.Pair<com.xiaomi.push.hv, java.lang.Integer>>, java.util.List<android.util.Pair<java.lang.Integer, java.lang.Object>>):void
      com.xiaomi.push.service.at.a(int, boolean):boolean */
    private boolean b(Context context) {
        return at.a(context).a(hu.aW.a(), true);
    }

    public String a(Context context, Notification.Builder builder, String str) {
        if (!m158a() || !a(context)) {
            return str;
        }
        long currentTimeMillis = System.currentTimeMillis();
        Bundle extras = builder.getExtras();
        extras.putString("push_src_group_name", str);
        extras.putLong("push_src_group_time", currentTimeMillis);
        return String.format("pushmask_%s_%s", Long.valueOf(currentTimeMillis), str);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.push.service.ao.a(android.content.Context, int, android.app.Notification, boolean):void
     arg types: [android.content.Context, int, android.app.Notification, int]
     candidates:
      com.xiaomi.push.service.ao.a(android.content.Context, java.lang.String, java.lang.String, android.app.Notification):void
      com.xiaomi.push.service.ao.a(android.content.Context, int, android.app.Notification, boolean):void */
    public void a(Context context, int i, Notification notification) {
        if (m158a()) {
            if (a(context)) {
                try {
                    b(context, i, notification);
                } catch (Exception e) {
                    duv.O000000o("group notify handle restore error ".concat(String.valueOf(e)));
                }
            }
            if (b(context)) {
                try {
                    a(context, i, notification, true);
                } catch (Exception e2) {
                    duv.O000000o("group notify handle auto error ".concat(String.valueOf(e2)));
                }
            }
        }
    }
}
