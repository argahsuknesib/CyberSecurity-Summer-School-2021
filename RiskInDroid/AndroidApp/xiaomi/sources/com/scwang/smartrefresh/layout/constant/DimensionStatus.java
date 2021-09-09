package com.scwang.smartrefresh.layout.constant;

public enum DimensionStatus {
    DefaultUnNotify(false),
    Default(true),
    XmlWrapUnNotify(false),
    XmlWrap(true),
    XmlExactUnNotify(false),
    XmlExact(true),
    XmlLayoutUnNotify(false),
    XmlLayout(true),
    CodeExactUnNotify(false),
    CodeExact(true),
    DeadLockUnNotify(false),
    DeadLock(true);
    
    public final boolean notified;

    private DimensionStatus(boolean z) {
        this.notified = z;
    }

    public final DimensionStatus unNotify() {
        if (!this.notified) {
            return this;
        }
        DimensionStatus dimensionStatus = values()[ordinal() - 1];
        if (!dimensionStatus.notified) {
            return dimensionStatus;
        }
        return DefaultUnNotify;
    }

    public final DimensionStatus notified() {
        return !this.notified ? values()[ordinal() + 1] : this;
    }

    public final boolean canReplaceWith(DimensionStatus dimensionStatus) {
        if (ordinal() >= dimensionStatus.ordinal()) {
            return (!this.notified || CodeExact == this) && ordinal() == dimensionStatus.ordinal();
        }
        return true;
    }
}
