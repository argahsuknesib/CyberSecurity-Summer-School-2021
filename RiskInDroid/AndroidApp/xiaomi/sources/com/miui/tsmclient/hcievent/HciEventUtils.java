package com.miui.tsmclient.hcievent;

import com.miui.tsmclient.util.LogUtils;
import java.util.ArrayList;

public class HciEventUtils {
    public static IHciEventHandler getHciEventHandler(byte[] bArr, byte[] bArr2) {
        if (bArr == null) {
            return null;
        }
        ArrayList<IHciEventHandler> arrayList = new ArrayList<>();
        arrayList.add(new BankHciEventHandler());
        arrayList.add(new TLVHciHandler());
        arrayList.add(new ShHciEventHandler());
        arrayList.add(new SZTHciHandler());
        arrayList.add(new CQV2HciHandler());
        arrayList.add(new CityUCardHciHandler());
        arrayList.add(new NonTransactionHciHandler());
        arrayList.add(new CpuCardHciEventHandler());
        for (IHciEventHandler iHciEventHandler : arrayList) {
            if (iHciEventHandler.isSupport(bArr, bArr2)) {
                LogUtils.d("hci will be handled by " + iHciEventHandler.getClass().getName());
                return iHciEventHandler;
            }
        }
        return null;
    }
}
