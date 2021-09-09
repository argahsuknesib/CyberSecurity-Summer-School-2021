package com.google.android.play.core.splitinstall.testing;

import com.google.android.play.core.splitinstall.SplitInstallSessionState;
import java.util.ArrayList;
import java.util.List;

final class b implements i {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Integer f3831a;
    final /* synthetic */ int b;
    final /* synthetic */ int c;
    final /* synthetic */ Long d;
    final /* synthetic */ Long e;
    final /* synthetic */ List f;
    final /* synthetic */ List g;

    b(Integer num, int i, int i2, Long l, Long l2, List list, List list2) {
        this.f3831a = num;
        this.b = i;
        this.c = i2;
        this.d = l;
        this.e = l2;
        this.f = list;
        this.g = list2;
    }

    public final SplitInstallSessionState a(SplitInstallSessionState splitInstallSessionState) {
        if (splitInstallSessionState == null) {
            splitInstallSessionState = SplitInstallSessionState.create(0, 0, 0, 0, 0, new ArrayList(), new ArrayList());
        }
        Integer num = this.f3831a;
        int intValue = num != null ? num.intValue() : splitInstallSessionState.sessionId();
        int i = this.b;
        int i2 = this.c;
        Long l = this.d;
        long longValue = l != null ? l.longValue() : splitInstallSessionState.bytesDownloaded();
        Long l2 = this.e;
        long longValue2 = l2 == null ? splitInstallSessionState.totalBytesToDownload() : l2.longValue();
        List<String> list = this.f;
        if (list == null) {
            list = splitInstallSessionState.moduleNames();
        }
        List<String> list2 = list;
        List<String> list3 = this.g;
        return SplitInstallSessionState.create(intValue, i, i2, longValue, longValue2, list2, list3 == null ? splitInstallSessionState.languages() : list3);
    }
}
