package com.xiaomi.smarthome.uwb.mico;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0007\"\u0004\b\u000b\u0010\t¨\u0006\u0015"}, d2 = {"Lcom/xiaomi/smarthome/uwb/mico/BaseControl;", "", "status", "", "volume", "(II)V", "getStatus", "()I", "setStatus", "(I)V", "getVolume", "setVolume", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "uwb-mico_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class BaseControl {
    private int status;
    private int volume;

    public static /* synthetic */ BaseControl copy$default(BaseControl baseControl, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = baseControl.status;
        }
        if ((i3 & 2) != 0) {
            i2 = baseControl.volume;
        }
        return baseControl.copy(i, i2);
    }

    public final int component1() {
        return this.status;
    }

    public final int component2() {
        return this.volume;
    }

    public final BaseControl copy(int i, int i2) {
        return new BaseControl(i, i2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BaseControl)) {
            return false;
        }
        BaseControl baseControl = (BaseControl) obj;
        return this.status == baseControl.status && this.volume == baseControl.volume;
    }

    public final int hashCode() {
        return (Integer.valueOf(this.status).hashCode() * 31) + Integer.valueOf(this.volume).hashCode();
    }

    public final String toString() {
        return "BaseControl(status=" + this.status + ", volume=" + this.volume + ')';
    }

    public BaseControl(int i, int i2) {
        this.status = i;
        this.volume = i2;
    }

    public final int getStatus() {
        return this.status;
    }

    public final int getVolume() {
        return this.volume;
    }

    public final void setStatus(int i) {
        this.status = i;
    }

    public final void setVolume(int i) {
        this.volume = i;
    }
}
