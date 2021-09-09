package com.xiaomi.smarthome.uwb.mico;

import _m_j.fg;
import _m_j.ixc;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \u0007*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002:\u0001\u0007B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0014J\b\u0010\u0006\u001a\u00020\u0005H\u0014¨\u0006\b"}, d2 = {"Lcom/xiaomi/smarthome/uwb/mico/RemoteLiveData;", "T", "Landroidx/lifecycle/MutableLiveData;", "()V", "onActive", "", "onInactive", "Companion", "uwb-mico_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class RemoteLiveData<T> extends fg<T> {
    public static final Companion Companion = new Companion(null);

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/xiaomi/smarthome/uwb/mico/RemoteLiveData$Companion;", "", "()V", "TAG", "", "uwb-mico_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(ixc ixc) {
            this();
        }

        private Companion() {
        }
    }

    public final void onActive() {
        super.onActive();
    }

    public final void onInactive() {
        super.onInactive();
        setValue(null);
    }
}
