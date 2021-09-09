package com.payu.custombrowser.cbinterface;

import java.util.Map;

public interface MagicRetryCallbacks {
    void hideMagicRetry();

    void initMagicRetry();

    void setMagicRetry(Map<String, String> map);

    void showMagicRetry();

    void toggleFragmentVisibility(int i);
}
