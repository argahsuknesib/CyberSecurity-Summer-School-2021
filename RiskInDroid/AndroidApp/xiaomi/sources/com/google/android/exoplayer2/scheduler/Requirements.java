package com.google.android.exoplayer2.scheduler;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.PowerManager;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public final class Requirements implements Parcelable {
    public static final Parcelable.Creator<Requirements> CREATOR = new Parcelable.Creator<Requirements>() {
        /* class com.google.android.exoplayer2.scheduler.Requirements.AnonymousClass1 */

        public final Requirements createFromParcel(Parcel parcel) {
            return new Requirements(parcel.readInt());
        }

        public final Requirements[] newArray(int i) {
            return new Requirements[i];
        }
    };
    private final int requirements;

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface RequirementFlags {
    }

    public final int describeContents() {
        return 0;
    }

    public Requirements(int i) {
        this.requirements = (i & 2) != 0 ? i | 1 : i;
    }

    public final int getRequirements() {
        return this.requirements;
    }

    public final boolean isNetworkRequired() {
        return (this.requirements & 1) != 0;
    }

    public final boolean isUnmeteredNetworkRequired() {
        return (this.requirements & 2) != 0;
    }

    public final boolean isChargingRequired() {
        return (this.requirements & 8) != 0;
    }

    public final boolean isIdleRequired() {
        return (this.requirements & 4) != 0;
    }

    public final boolean checkRequirements(Context context) {
        return getNotMetRequirements(context) == 0;
    }

    public final int getNotMetRequirements(Context context) {
        int notMetNetworkRequirements = getNotMetNetworkRequirements(context);
        if (isChargingRequired() && !isDeviceCharging(context)) {
            notMetNetworkRequirements |= 8;
        }
        return (!isIdleRequired() || isDeviceIdle(context)) ? notMetNetworkRequirements : notMetNetworkRequirements | 4;
    }

    private int getNotMetNetworkRequirements(Context context) {
        if (!isNetworkRequired()) {
            return 0;
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) Assertions.checkNotNull(connectivityManager)).getActiveNetworkInfo();
        if (activeNetworkInfo == null || !activeNetworkInfo.isConnected() || !isInternetConnectivityValidated(connectivityManager)) {
            return this.requirements & 3;
        }
        if (!isUnmeteredNetworkRequired() || !connectivityManager.isActiveNetworkMetered()) {
            return 0;
        }
        return 2;
    }

    private boolean isDeviceCharging(Context context) {
        Intent registerReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (registerReceiver == null) {
            return false;
        }
        int intExtra = registerReceiver.getIntExtra("status", -1);
        if (intExtra == 2 || intExtra == 5) {
            return true;
        }
        return false;
    }

    private boolean isDeviceIdle(Context context) {
        PowerManager powerManager = (PowerManager) context.getSystemService("power");
        if (Util.SDK_INT >= 23) {
            return powerManager.isDeviceIdleMode();
        }
        return Util.SDK_INT >= 20 ? !powerManager.isInteractive() : !powerManager.isScreenOn();
    }

    private static boolean isInternetConnectivityValidated(ConnectivityManager connectivityManager) {
        NetworkCapabilities networkCapabilities;
        if (Util.SDK_INT < 24) {
            return true;
        }
        Network activeNetwork = connectivityManager.getActiveNetwork();
        if (activeNetwork == null || (networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork)) == null || !networkCapabilities.hasCapability(16)) {
            return false;
        }
        return true;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && this.requirements == ((Requirements) obj).requirements;
    }

    public final int hashCode() {
        return this.requirements;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.requirements);
    }
}
