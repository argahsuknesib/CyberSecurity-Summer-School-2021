package com.google.firebase.analytics.connector;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.measurement.AppMeasurement;
import com.google.firebase.FirebaseApp;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.analytics.connector.internal.Adapter;
import com.google.firebase.analytics.connector.internal.zzb;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class AnalyticsConnectorImpl implements AnalyticsConnector {
    private static volatile AnalyticsConnector zzbof;
    private final AppMeasurement zzboe;
    @VisibleForTesting
    final Map<String, Adapter> zzbog = new ConcurrentHashMap();

    private AnalyticsConnectorImpl(AppMeasurement appMeasurement) {
        Preconditions.checkNotNull(appMeasurement);
        this.zzboe = appMeasurement;
    }

    @KeepForSdk
    public static AnalyticsConnector getInstance() {
        return getInstance(FirebaseApp.getInstance());
    }

    @KeepForSdk
    public static AnalyticsConnector getInstance(Context context) {
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(context.getApplicationContext());
        if (zzbof == null) {
            synchronized (AnalyticsConnector.class) {
                if (zzbof == null) {
                    zzbof = new AnalyticsConnectorImpl(AppMeasurement.getInstance(context));
                }
            }
        }
        return zzbof;
    }

    @KeepForSdk
    public static AnalyticsConnector getInstance(FirebaseApp firebaseApp) {
        return (AnalyticsConnector) firebaseApp.get(AnalyticsConnector.class);
    }

    /* access modifiers changed from: private */
    public final boolean zzfc(String str) {
        return !str.isEmpty() && this.zzbog.containsKey(str) && this.zzbog.get(str) != null;
    }

    @KeepForSdk
    public void clearConditionalUserProperty(String str, String str2, Bundle bundle) {
        if (str2 == null || zzb.zza(str2, bundle)) {
            this.zzboe.clearConditionalUserProperty(str, str2, bundle);
        } else {
            Log.d("FA-C", "Event or Params not allowed");
        }
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* access modifiers changed from: protected */
    @VisibleForTesting
    public Adapter createAdapter(String str, AppMeasurement appMeasurement, AnalyticsConnector.AnalyticsConnectorListener analyticsConnectorListener) {
        char c;
        String str2;
        switch (str.hashCode()) {
            case 3308:
                if (str.equals("gs")) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case 101200:
                if (str.equals("fcm")) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case 101230:
                if (str.equals("fdl")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case 101655:
                if (str.equals("frc")) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case 94921639:
                if (str.equals("crash")) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        if (c == 0) {
            str2 = "FCM Adapter not implemented";
        } else if (c == 1) {
            str2 = "FDL Adapter not implemented";
        } else if (c == 2) {
            str2 = "FRC Adapter not implemented";
        } else if (c == 3) {
            str2 = "Search Adapter not implemented";
        } else if (c != 4) {
            String valueOf = String.valueOf(str);
            Log.d("FA-C", valueOf.length() != 0 ? "Adapter not defined for ".concat(valueOf) : new String("Adapter not defined for "));
            return null;
        } else {
            str2 = "Crash Adapter not implemented";
        }
        Log.d("FA-C", str2);
        return null;
    }

    @KeepForSdk
    public List<AnalyticsConnector.ConditionalUserProperty> getConditionalUserProperties(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        for (AppMeasurement.ConditionalUserProperty zzd : this.zzboe.getConditionalUserProperties(str, str2)) {
            arrayList.add(zzb.zzd(zzd));
        }
        return arrayList;
    }

    @KeepForSdk
    public int getMaxUserProperties(String str) {
        return this.zzboe.getMaxUserProperties(str);
    }

    @KeepForSdk
    public Map<String, Object> getUserProperties(boolean z) {
        return this.zzboe.getUserProperties(z);
    }

    @KeepForSdk
    public void logEvent(String str, String str2, Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        if (!zzb.zzfd(str)) {
            String valueOf = String.valueOf(str);
            Log.d("FA-C", valueOf.length() != 0 ? "Origin not allowed : ".concat(valueOf) : new String("Origin not allowed : "));
        } else if (!zzb.zza(str2, bundle)) {
            Log.d("FA-C", "Event or Params not allowed");
        } else if (!zzb.zzb(str, str2, bundle)) {
            Log.d("FA-C", "Campaign events not allowed");
        } else {
            this.zzboe.logEventInternal(str, str2, bundle);
        }
    }

    @KeepForSdk
    public AnalyticsConnector.AnalyticsConnectorHandle registerAnalyticsConnectorListener(String str, AnalyticsConnector.AnalyticsConnectorListener analyticsConnectorListener) {
        String str2;
        Preconditions.checkNotNull(analyticsConnectorListener);
        if (!zzb.zzfd(str)) {
            str2 = "Registering with non allowed origin";
        } else if (zzfc(str)) {
            str2 = "Registering duplicate listener";
        } else {
            Adapter createAdapter = createAdapter(str, this.zzboe, analyticsConnectorListener);
            if (createAdapter == null) {
                return null;
            }
            this.zzbog.put(str, createAdapter);
            return new zza(this, str);
        }
        Log.d("FA-C", str2);
        return null;
    }

    @KeepForSdk
    public void setConditionalUserProperty(AnalyticsConnector.ConditionalUserProperty conditionalUserProperty) {
        if (!zzb.zza(conditionalUserProperty)) {
            Log.d("FA-C", "Conditional user property has invalid event or params");
        } else {
            this.zzboe.setConditionalUserProperty(zzb.zzb(conditionalUserProperty));
        }
    }

    @KeepForSdk
    public void setUserProperty(String str, String str2, Object obj) {
        if (!zzb.zzfd(str)) {
            String valueOf = String.valueOf(str);
            Log.d("FA-C", valueOf.length() != 0 ? "Origin not allowed : ".concat(valueOf) : new String("Origin not allowed : "));
        } else if (!zzb.zzfe(str2)) {
            String valueOf2 = String.valueOf(str2);
            Log.d("FA-C", valueOf2.length() != 0 ? "User Property not allowed : ".concat(valueOf2) : new String("User Property not allowed : "));
        } else if ((str2.equals("_ce1") || str2.equals("_ce2")) && !str.equals("fcm") && !str.equals("frc")) {
            String valueOf3 = String.valueOf(str2);
            Log.d("FA-C", valueOf3.length() != 0 ? "User Property not allowed for this origin: ".concat(valueOf3) : new String("User Property not allowed for this origin: "));
        } else {
            this.zzboe.setUserPropertyInternal(str, str2, obj);
        }
    }
}
