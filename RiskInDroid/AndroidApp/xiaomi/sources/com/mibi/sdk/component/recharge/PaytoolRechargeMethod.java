package com.mibi.sdk.component.recharge;

import java.util.ArrayList;

public class PaytoolRechargeMethod extends RechargeMethod {
    public long mMaxMibiValue;
    public long mMaxMoneyValue;
    public ArrayList<Long> mMibiValues = new ArrayList<>();
    public long mMinMibiValue;
    public long mMinMoneyValue;
    public ArrayList<Long> mMoneyValues = new ArrayList<>();
    public long mWarnMibiValue;
    public long mWarnValue;
}
