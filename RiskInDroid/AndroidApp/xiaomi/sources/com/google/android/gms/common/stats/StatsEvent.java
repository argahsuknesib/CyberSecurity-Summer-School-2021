package com.google.android.gms.common.stats;

import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

public abstract class StatsEvent extends AbstractSafeParcelable implements ReflectedParcelable {

    public interface Types {
    }

    public abstract StatsEvent ReconstructCloseEvent(StatsEvent statsEvent);

    public abstract long getDurationMillis();

    public abstract long getElapsedRealtime();

    public abstract String getEventKey();

    public abstract int getEventType();

    public abstract String getSpecificString();

    public abstract long getTimeMillis();

    public abstract long getTimeout();

    public abstract StatsEvent markTimeOut();

    public abstract StatsEvent setDurationMillis(long j);

    public abstract StatsEvent setEventType(int i);

    public String toString() {
        long timeMillis = getTimeMillis();
        int eventType = getEventType();
        long durationMillis = getDurationMillis();
        String specificString = getSpecificString();
        StringBuilder sb = new StringBuilder(String.valueOf(specificString).length() + 53);
        sb.append(timeMillis);
        sb.append("\t");
        sb.append(eventType);
        sb.append("\t");
        sb.append(durationMillis);
        sb.append(specificString);
        return sb.toString();
    }
}
