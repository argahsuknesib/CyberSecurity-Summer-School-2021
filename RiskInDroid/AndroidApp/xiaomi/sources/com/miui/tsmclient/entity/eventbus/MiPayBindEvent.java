package com.miui.tsmclient.entity.eventbus;

public class MiPayBindEvent {
    private boolean isShowList;

    public MiPayBindEvent(boolean z) {
        this.isShowList = z;
    }

    public boolean isShowList() {
        return this.isShowList;
    }
}
