package com.xiaomi.push;

import _m_j.epi;
import android.text.TextUtils;

/* JADX INFO: Failed to restore enum class, 'enum' modifier removed */
public final class ff extends Enum<ff> {

    /* renamed from: a  reason: collision with root package name */
    public static final ff f6377a = new ff("COMMAND_REGISTER", 0, "register");

    /* renamed from: a  reason: collision with other field name */
    private static final /* synthetic */ ff[] f29a = a();
    public static final ff b = new ff("COMMAND_UNREGISTER", 1, "unregister");
    public static final ff c = new ff("COMMAND_SET_ALIAS", 2, "set-alias");
    public static final ff d = new ff("COMMAND_UNSET_ALIAS", 3, "unset-alias");
    public static final ff e = new ff("COMMAND_SET_ACCOUNT", 4, "set-account");
    public static final ff f = new ff("COMMAND_UNSET_ACCOUNT", 5, "unset-account");
    public static final ff g = new ff("COMMAND_SUBSCRIBE_TOPIC", 6, "subscribe-topic");
    public static final ff h = new ff("COMMAND_UNSUBSCRIBE_TOPIC", 7, "unsubscibe-topic");
    public static final ff i = new ff("COMMAND_SET_ACCEPT_TIME", 8, "accept-time");
    public static final ff j = new ff("COMMAND_CHK_VDEVID", 9, "check-vdeviceid");

    /* renamed from: a  reason: collision with other field name */
    public final String f30a;

    private ff(String str, int i2, String str2) {
        this.f30a = str2;
    }

    public static int a(String str) {
        int i2 = -1;
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        for (ff ffVar : values()) {
            if (ffVar.f30a.equals(str)) {
                i2 = epi.O000000o(ffVar);
            }
        }
        return i2;
    }

    private static /* synthetic */ ff[] a() {
        return new ff[]{f6377a, b, c, d, e, f, g, h, i, j};
    }

    public static ff valueOf(String str) {
        return (ff) Enum.valueOf(ff.class, str);
    }

    public static ff[] values() {
        return (ff[]) f29a.clone();
    }
}
