package com.xiaomi.accountsdk.utils;

import java.util.Date;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

public class ServerTimeUtil {
    private static volatile IServerTimeComputer computer;
    private static final CopyOnWriteArraySet<ServerTimeAlignedListener> listeners = new CopyOnWriteArraySet<>();

    public interface IServerTimeComputer {
        void alignWithServerDateHeader(String str, String str2);

        void alignWithServerTime(Date date);

        long computeServerTime();
    }

    public interface ServerTimeAlignedListener {
        void onServerTimeAligned();
    }

    public static IServerTimeComputer getComputer() {
        return computer;
    }

    public static void setComputer(IServerTimeComputer iServerTimeComputer) {
        computer = iServerTimeComputer;
    }

    public static void addServerTimeChangedListener(ServerTimeAlignedListener serverTimeAlignedListener) {
        if (serverTimeAlignedListener != null) {
            listeners.add(serverTimeAlignedListener);
            return;
        }
        throw new IllegalArgumentException("listener == null");
    }

    public static void removeServerTimeChangedListener(ServerTimeAlignedListener serverTimeAlignedListener) {
        listeners.remove(serverTimeAlignedListener);
    }

    public static void notifyServerTimeAligned() {
        Iterator<ServerTimeAlignedListener> it = listeners.iterator();
        while (it.hasNext()) {
            it.next().onServerTimeAligned();
        }
    }
}
