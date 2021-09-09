package com.google.firebase.messaging;

import _m_j.o0O0OOO0;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Map;

@SafeParcelable.Class(creator = "RemoteMessageCreator")
@SafeParcelable.Reserved({1})
public final class RemoteMessage extends AbstractSafeParcelable {
    public static final Parcelable.Creator<RemoteMessage> CREATOR = new zzd();
    @SafeParcelable.Field(id = 2)
    Bundle zzdh;
    private Map<String, String> zzdi;
    private Notification zzdj;

    public static class Builder {
        private final Bundle zzdh = new Bundle();
        private final Map<String, String> zzdi = new o0O0OOO0();

        public Builder(String str) {
            if (TextUtils.isEmpty(str)) {
                String valueOf = String.valueOf(str);
                throw new IllegalArgumentException(valueOf.length() != 0 ? "Invalid to: ".concat(valueOf) : new String("Invalid to: "));
            } else {
                this.zzdh.putString("google.to", str);
            }
        }

        public Builder addData(String str, String str2) {
            this.zzdi.put(str, str2);
            return this;
        }

        public RemoteMessage build() {
            Bundle bundle = new Bundle();
            for (Map.Entry next : this.zzdi.entrySet()) {
                bundle.putString((String) next.getKey(), (String) next.getValue());
            }
            bundle.putAll(this.zzdh);
            this.zzdh.remove("from");
            return new RemoteMessage(bundle);
        }

        public Builder clearData() {
            this.zzdi.clear();
            return this;
        }

        public Builder setCollapseKey(String str) {
            this.zzdh.putString("collapse_key", str);
            return this;
        }

        public Builder setData(Map<String, String> map) {
            this.zzdi.clear();
            this.zzdi.putAll(map);
            return this;
        }

        public Builder setMessageId(String str) {
            this.zzdh.putString("google.message_id", str);
            return this;
        }

        public Builder setMessageType(String str) {
            this.zzdh.putString("message_type", str);
            return this;
        }

        public Builder setTtl(int i) {
            this.zzdh.putString("google.ttl", String.valueOf(i));
            return this;
        }
    }

    public static class Notification {
        private final String tag;
        private final String zzdk;
        private final String zzdl;
        private final String[] zzdm;
        private final String zzdn;
        private final String zzdo;
        private final String[] zzdp;
        private final String zzdq;
        private final String zzdr;
        private final String zzds;
        private final String zzdt;
        private final Uri zzdu;

        private Notification(Bundle bundle) {
            this.zzdk = zza.zza(bundle, "gcm.n.title");
            this.zzdl = zza.zzb(bundle, "gcm.n.title");
            this.zzdm = zze(bundle, "gcm.n.title");
            this.zzdn = zza.zza(bundle, "gcm.n.body");
            this.zzdo = zza.zzb(bundle, "gcm.n.body");
            this.zzdp = zze(bundle, "gcm.n.body");
            this.zzdq = zza.zza(bundle, "gcm.n.icon");
            this.zzdr = zza.zzi(bundle);
            this.tag = zza.zza(bundle, "gcm.n.tag");
            this.zzds = zza.zza(bundle, "gcm.n.color");
            this.zzdt = zza.zza(bundle, "gcm.n.click_action");
            this.zzdu = zza.zzg(bundle);
        }

        private static String[] zze(Bundle bundle, String str) {
            Object[] zzc = zza.zzc(bundle, str);
            if (zzc == null) {
                return null;
            }
            String[] strArr = new String[zzc.length];
            for (int i = 0; i < zzc.length; i++) {
                strArr[i] = String.valueOf(zzc[i]);
            }
            return strArr;
        }

        public String getBody() {
            return this.zzdn;
        }

        public String[] getBodyLocalizationArgs() {
            return this.zzdp;
        }

        public String getBodyLocalizationKey() {
            return this.zzdo;
        }

        public String getClickAction() {
            return this.zzdt;
        }

        public String getColor() {
            return this.zzds;
        }

        public String getIcon() {
            return this.zzdq;
        }

        public Uri getLink() {
            return this.zzdu;
        }

        public String getSound() {
            return this.zzdr;
        }

        public String getTag() {
            return this.tag;
        }

        public String getTitle() {
            return this.zzdk;
        }

        public String[] getTitleLocalizationArgs() {
            return this.zzdm;
        }

        public String getTitleLocalizationKey() {
            return this.zzdl;
        }
    }

    @SafeParcelable.Constructor
    public RemoteMessage(@SafeParcelable.Param(id = 2) Bundle bundle) {
        this.zzdh = bundle;
    }

    public final String getCollapseKey() {
        return this.zzdh.getString("collapse_key");
    }

    public final Map<String, String> getData() {
        if (this.zzdi == null) {
            this.zzdi = new o0O0OOO0();
            for (String next : this.zzdh.keySet()) {
                Object obj = this.zzdh.get(next);
                if (obj instanceof String) {
                    String str = (String) obj;
                    if (!next.startsWith("google.") && !next.startsWith("gcm.") && !next.equals("from") && !next.equals("message_type") && !next.equals("collapse_key")) {
                        this.zzdi.put(next, str);
                    }
                }
            }
        }
        return this.zzdi;
    }

    public final String getFrom() {
        return this.zzdh.getString("from");
    }

    public final String getMessageId() {
        String string = this.zzdh.getString("google.message_id");
        return string == null ? this.zzdh.getString("message_id") : string;
    }

    public final String getMessageType() {
        return this.zzdh.getString("message_type");
    }

    public final Notification getNotification() {
        if (this.zzdj == null && zza.zzf(this.zzdh)) {
            this.zzdj = new Notification(this.zzdh);
        }
        return this.zzdj;
    }

    public final long getSentTime() {
        Object obj = this.zzdh.get("google.sent_time");
        if (obj instanceof Long) {
            return ((Long) obj).longValue();
        }
        if (!(obj instanceof String)) {
            return 0;
        }
        try {
            return Long.parseLong((String) obj);
        } catch (NumberFormatException unused) {
            String valueOf = String.valueOf(obj);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 19);
            sb.append("Invalid sent time: ");
            sb.append(valueOf);
            Log.w("FirebaseMessaging", sb.toString());
            return 0;
        }
    }

    public final String getTo() {
        return this.zzdh.getString("google.to");
    }

    public final int getTtl() {
        Object obj = this.zzdh.get("google.ttl");
        if (obj instanceof Integer) {
            return ((Integer) obj).intValue();
        }
        if (!(obj instanceof String)) {
            return 0;
        }
        try {
            return Integer.parseInt((String) obj);
        } catch (NumberFormatException unused) {
            String valueOf = String.valueOf(obj);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 13);
            sb.append("Invalid TTL: ");
            sb.append(valueOf);
            Log.w("FirebaseMessaging", sb.toString());
            return 0;
        }
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeBundle(parcel, 2, this.zzdh, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
