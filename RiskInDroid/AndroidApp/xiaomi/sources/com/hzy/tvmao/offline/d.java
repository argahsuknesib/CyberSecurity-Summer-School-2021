package com.hzy.tvmao.offline;

import com.hzy.tvmao.utils.LogUtil;
import com.lidroid.xutils.DbUtils;

final class d implements DbUtils.O000000o {
    d() {
    }

    public final void onUpgrade(DbUtils dbUtils, int i, int i2) {
        LogUtil.d("onUpgrade ---- old   " + i + " arg2 " + i2);
    }
}
