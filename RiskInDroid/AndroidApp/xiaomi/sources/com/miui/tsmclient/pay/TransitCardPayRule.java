package com.miui.tsmclient.pay;

public class TransitCardPayRule implements IPayRule {
    public int getMaxPayAmount() {
        return 100000;
    }

    public int getMaxTotalAmount() {
        return 100000;
    }

    public int getMinBalance() {
        return 0;
    }

    public int getMinPayAmount() {
        return 0;
    }

    public int checkPayAmount(int i, int i2) {
        if (i < getMinPayAmount()) {
            return 1006;
        }
        if (i > getMaxPayAmount()) {
            return 1007;
        }
        int i3 = i + i2;
        if (i3 > getMaxTotalAmount()) {
            return 1008;
        }
        return i3 < getMinBalance() ? 1013 : 0;
    }
}
