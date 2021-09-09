package com.xiaomi.push.service;

import _m_j.duv;
import _m_j.emg;
import _m_j.esl;
import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.xiaomi.push.g;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class an {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f6498a = Log.isLoggable("NCHelper", 3);

    @TargetApi(26)
    private static NotificationChannel a(String str, NotificationChannel notificationChannel) {
        NotificationChannel notificationChannel2 = new NotificationChannel(str, notificationChannel.getName(), notificationChannel.getImportance());
        notificationChannel2.setDescription(notificationChannel.getDescription());
        notificationChannel2.enableVibration(notificationChannel.shouldVibrate());
        notificationChannel2.enableLights(notificationChannel.shouldShowLights());
        notificationChannel2.setSound(notificationChannel.getSound(), notificationChannel.getAudioAttributes());
        notificationChannel2.setLockscreenVisibility(notificationChannel.getLockscreenVisibility());
        return notificationChannel2;
    }

    private static SharedPreferences a(Context context) {
        return context.getSharedPreferences("mipush_channel_copy_sp", 0);
    }

    @TargetApi(26)
    public static String a(ar arVar) {
        String b = arVar.b();
        try {
            NotificationChannel notificationChannel = new NotificationChannel(b, g.O00000oO(arVar.m166a(), arVar.m167a()), 3);
            if (f6498a) {
                a("create default channel:".concat(String.valueOf(notificationChannel)));
            }
            a(arVar, notificationChannel);
        } catch (Exception e) {
            duv.O000000o("NCHelper", "create default channel error ".concat(String.valueOf(e)));
        }
        return b;
    }

    @TargetApi(26)
    public static String a(ar arVar, String str, CharSequence charSequence, String str2, int i, int i2, String str3) {
        String a2 = arVar.m168a(str);
        try {
            if (f6498a) {
                a("createChannel: appChannelId:" + a2 + " serverChannelId:" + str + " serverChannelName:" + ((Object) charSequence) + " serverChannelDesc:" + str2 + " serverChannelNotifyType:" + i + " serverChannelName:" + ((Object) charSequence) + " serverChannelImportance:" + i2 + " channelSoundStr:" + str3);
            }
            NotificationChannel notificationChannel = new NotificationChannel(a2, charSequence, i2);
            notificationChannel.setDescription(str2);
            boolean z = false;
            notificationChannel.enableVibration((i & 2) != 0);
            if ((i & 4) != 0) {
                z = true;
            }
            notificationChannel.enableLights(z);
            if ((i & 1) == 0) {
                notificationChannel.setSound(null, null);
            } else if (!TextUtils.isEmpty(str3)) {
                if (str3.startsWith("android.resource://" + arVar.m167a())) {
                    notificationChannel.setSound(Uri.parse(str3), Notification.AUDIO_ATTRIBUTES_DEFAULT);
                }
            }
            if (f6498a) {
                a("create channel:".concat(String.valueOf(notificationChannel)));
            }
            a(arVar, notificationChannel);
        } catch (Exception e) {
            duv.O000000o("NCHelper", "create channel error ".concat(String.valueOf(e)));
        }
        return a2;
    }

    public static void a(Context context, String str) {
        if (esl.O000000o(context) && !TextUtils.isEmpty(str)) {
            try {
                ar a2 = ar.a(context, str);
                Set<String> keySet = a(context).getAll().keySet();
                ArrayList arrayList = new ArrayList();
                for (String next : keySet) {
                    if (a2.m170a(next)) {
                        arrayList.add(next);
                        if (f6498a) {
                            a("delete channel copy record:".concat(String.valueOf(next)));
                        }
                    }
                }
                a(context, arrayList);
            } catch (Exception unused) {
            }
        }
    }

    private static void a(Context context, List<String> list) {
        if (f6498a) {
            a("deleteCopiedChannelRecord:".concat(String.valueOf(list)));
        }
        if (!list.isEmpty()) {
            SharedPreferences.Editor edit = a(context).edit();
            for (String remove : list) {
                edit.remove(remove);
            }
            edit.apply();
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.push.service.an.a(android.content.Context, java.lang.String):boolean
     arg types: [android.content.Context, java.lang.String]
     candidates:
      com.xiaomi.push.service.an.a(java.lang.String, android.app.NotificationChannel):android.app.NotificationChannel
      com.xiaomi.push.service.an.a(android.content.Context, java.lang.String):void
      com.xiaomi.push.service.an.a(android.content.Context, java.util.List<java.lang.String>):void
      com.xiaomi.push.service.an.a(com.xiaomi.push.service.ar, android.app.NotificationChannel):void
      com.xiaomi.push.service.an.a(android.app.NotificationChannel, android.app.NotificationChannel):boolean
      com.xiaomi.push.service.an.a(android.content.Context, java.lang.String):boolean */
    @TargetApi(26)
    private static void a(ar arVar, NotificationChannel notificationChannel) {
        if (arVar == null || notificationChannel == null) {
            throw new Exception("params cannot be null");
        } else if (!TextUtils.isEmpty(notificationChannel.getId())) {
            Context a2 = arVar.m166a();
            String id = notificationChannel.getId();
            String a3 = ar.a(id, arVar.m167a());
            if (f6498a) {
                a("appChannelId:" + id + " oldChannelId:" + a3);
            }
            if (!esl.O000000o(a2) || TextUtils.equals(id, a3)) {
                NotificationChannel a4 = arVar.m165a(id);
                if (f6498a) {
                    a("elseLogic getNotificationChannel:".concat(String.valueOf(a4)));
                }
                if (a4 == null) {
                    arVar.a(notificationChannel);
                    return;
                }
                return;
            }
            NotificationManager notificationManager = (NotificationManager) a2.getSystemService("notification");
            NotificationChannel notificationChannel2 = notificationManager.getNotificationChannel(a3);
            NotificationChannel a5 = arVar.m165a(id);
            if (f6498a) {
                a("xmsfChannel:".concat(String.valueOf(notificationChannel2)));
                a("appChannel:".concat(String.valueOf(a5)));
            }
            if (notificationChannel2 != null) {
                NotificationChannel a6 = a(id, notificationChannel2);
                if (f6498a) {
                    a("copyXmsf copyXmsfChannel:".concat(String.valueOf(a6)));
                }
                if (a5 != null) {
                    arVar.a(a6, !a(a5));
                } else {
                    arVar.a(a6);
                }
                b(a2, id);
                notificationManager.deleteNotificationChannel(a3);
            } else if (a5 == null) {
                if (f6498a) {
                    a("appHack createNotificationChannel:".concat(String.valueOf(notificationChannel)));
                }
                arVar.a(notificationChannel);
            } else if (!m157a(a2, id) && a(notificationChannel, a5)) {
                if (f6498a) {
                    a("appHack updateNotificationChannel:".concat(String.valueOf(notificationChannel)));
                }
                arVar.a(notificationChannel, !a(a5));
            }
        } else {
            throw new Exception("serverChannel id cannot be empty");
        }
    }

    private static void a(String str) {
        duv.O000000o("NCHelper", str);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0042 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0044 A[RETURN] */
    private static boolean a(NotificationChannel notificationChannel) {
        int i;
        try {
            i = ((Integer) emg.O00000Oo(notificationChannel, "getUserLockedFields", new Object[0])).intValue();
            try {
                if (f6498a) {
                    a("isUserLockedChannel:" + i + " " + notificationChannel);
                }
            } catch (Exception e) {
                e = e;
                duv.O000000o("NCHelper", "is user locked error".concat(String.valueOf(e)));
                if (i > 0) {
                }
            }
        } catch (Exception e2) {
            e = e2;
            i = 0;
            duv.O000000o("NCHelper", "is user locked error".concat(String.valueOf(e)));
            if (i > 0) {
            }
        }
        return i > 0;
    }

    @TargetApi(26)
    private static boolean a(NotificationChannel notificationChannel, NotificationChannel notificationChannel2) {
        boolean z;
        boolean z2 = false;
        if (notificationChannel == null || notificationChannel2 == null) {
            return false;
        }
        if (!TextUtils.equals(notificationChannel.getName(), notificationChannel2.getName())) {
            if (f6498a) {
                a("appHack channelConfigLowerCompare:getName");
            }
            z = true;
        } else {
            z = false;
        }
        if (!TextUtils.equals(notificationChannel.getDescription(), notificationChannel2.getDescription())) {
            if (f6498a) {
                a("appHack channelConfigLowerCompare:getDescription");
            }
            z = true;
        }
        if (notificationChannel.getImportance() != notificationChannel2.getImportance()) {
            notificationChannel.setImportance(Math.min(notificationChannel.getImportance(), notificationChannel2.getImportance()));
            if (f6498a) {
                a("appHack channelConfigLowerCompare:getImportance  " + notificationChannel.getImportance() + " " + notificationChannel2.getImportance());
            }
            z = true;
        }
        if (notificationChannel.shouldVibrate() != notificationChannel2.shouldVibrate()) {
            notificationChannel.enableVibration(false);
            if (f6498a) {
                a("appHack channelConfigLowerCompare:enableVibration");
            }
            z = true;
        }
        if (notificationChannel.shouldShowLights() != notificationChannel2.shouldShowLights()) {
            notificationChannel.enableLights(false);
            if (f6498a) {
                a("appHack channelConfigLowerCompare:enableLights");
            }
            z = true;
        }
        boolean z3 = notificationChannel.getSound() != null;
        if (notificationChannel2.getSound() != null) {
            z2 = true;
        }
        if (z3 != z2) {
            notificationChannel.setSound(null, null);
            if (f6498a) {
                a("appHack channelConfigLowerCompare:setSound");
            }
            z = true;
        }
        if (f6498a) {
            a("appHack channelConfigLowerCompare:isDifferent:".concat(String.valueOf(z)));
        }
        return z;
    }

    /* renamed from: a  reason: collision with other method in class */
    private static boolean m157a(Context context, String str) {
        if (f6498a) {
            a("checkCopeidChannel:newFullChannelId:" + str + "  " + a(context).getBoolean(str, false));
        }
        return a(context).getBoolean(str, false);
    }

    private static void b(Context context, String str) {
        if (f6498a) {
            a("recordCopiedChannel:".concat(String.valueOf(str)));
        }
        a(context).edit().putBoolean(str, true).apply();
    }
}
