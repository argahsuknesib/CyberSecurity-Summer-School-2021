package com.miui.tsmclient.model;

import android.content.Context;
import android.nfc.Tag;
import android.os.Bundle;
import com.miui.tsmclient.entity.PayableCardInfo;
import com.miui.tsmclient.pay.OrderInfo;

public interface j<T extends PayableCardInfo> extends i<T> {
    BaseResponse a(Context context, T t, OrderInfo orderInfo, Tag tag, Bundle bundle);
}
