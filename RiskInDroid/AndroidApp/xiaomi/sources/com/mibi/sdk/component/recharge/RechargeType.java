package com.mibi.sdk.component.recharge;

import java.io.Serializable;
import java.util.ArrayList;

public class RechargeType implements Serializable {
    public String mCurrencyUnit = null;
    public boolean mFavorite = false;
    public String mIcon = "";
    public int mLocalIconRes = -1;
    public ArrayList<RechargeMethod> mRechargeMethods = new ArrayList<>();
    public String mTitle = null;
    public String mTitleHint = null;
    public String mType = null;
}
