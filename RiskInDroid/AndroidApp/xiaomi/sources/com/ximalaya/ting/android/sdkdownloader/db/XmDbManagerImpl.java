package com.ximalaya.ting.android.sdkdownloader.db;

import android.content.Context;
import com.ximalaya.ting.android.sdkdownloader.downloadutil.DownloadState;

public class XmDbManagerImpl {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final String f12237O000000o = XmSqLiteHelper.O000000o("Track");
    public static final String O00000Oo = XmSqLiteHelper.O000000o("dataId");
    public static final String O00000o = XmSqLiteHelper.O000000o("albumId");
    public static final String O00000o0 = XmSqLiteHelper.O000000o("announcerId");
    public static final int O00000oO = DownloadState.FINISHED.value();
    private XmSqLiteHelper O00000oo;

    public XmDbManagerImpl(Context context) {
        this.O00000oo = new XmSqLiteHelper(context);
    }
}
