package com.miui.tsmclient.pay;

public interface IPayRule {
    int checkPayAmount(int i, int i2);

    int getMaxPayAmount();

    int getMaxTotalAmount();

    int getMinBalance();

    int getMinPayAmount();
}
