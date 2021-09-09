package com.xiaomi.aiot.mibeacon;

import java.util.Collection;

public interface RangeNotifier {
    void didRangeBeaconsInScan(Collection<MiBeacon> collection);
}
