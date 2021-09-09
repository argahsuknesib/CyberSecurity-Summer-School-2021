package com.miui.tsmclient.model;

import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.miui.tsmclient.common.net.HttpClient;
import com.miui.tsmclient.entity.GroupConfigInfo;
import com.miui.tsmclient.entity.f;
import com.miui.tsmclient.net.request.ConfigListRequest;
import com.miui.tsmclient.util.EnvironmentConfig;
import com.miui.tsmclient.util.LogUtils;
import com.miui.tsmclient.util.PrefUtils;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class h {

    /* renamed from: a  reason: collision with root package name */
    private static volatile h f3883a;
    private WeakReference<Context> b;

    private h(Context context) {
        this.b = new WeakReference<>(context);
    }

    public static h a() {
        if (f3883a == null) {
            synchronized (h.class) {
                if (f3883a == null) {
                    f3883a = new h(EnvironmentConfig.getContext());
                }
            }
        }
        return f3883a;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v3, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v2, resolved type: com.miui.tsmclient.entity.GroupConfigInfo} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0082  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x009c  */
    /* JADX WARNING: Removed duplicated region for block: B:28:? A[RETURN, SYNTHETIC] */
    private List<f> c() {
        GroupConfigInfo groupConfigInfo;
        boolean d = d();
        StringBuilder sb = new StringBuilder("fetchNonTransactionHciEvent");
        sb.append(d ? " on main thread" : "");
        LogUtils.i(sb.toString());
        Context context = this.b.get();
        ArrayList arrayList = new ArrayList();
        if (context == null) {
            return arrayList;
        }
        if (!d) {
            ConfigListRequest configListRequest = new ConfigListRequest(null, "NON_TRANSACTION_HCI_CONFIG", null);
            configListRequest.addParams("configCategory", "nonTransactionHciEvent");
            try {
                groupConfigInfo = (GroupConfigInfo) HttpClient.getInstance(context).execute(configListRequest).getResult();
                try {
                    LogUtils.d("fetchNonTransactionHciEvent isSuccess:" + configListRequest.isSuccess());
                    if (configListRequest.isSuccess()) {
                        PrefUtils.putString(context, "key_non_transaction_hci_config", new Gson().toJson(groupConfigInfo));
                    }
                } catch (IOException e) {
                    e = e;
                    LogUtils.e("ConfigListSyncRequest Exception occurred when fetchNonTransactionHciEvent", e);
                    if (groupConfigInfo == null) {
                    }
                    if (groupConfigInfo != null) {
                    }
                }
            } catch (IOException e2) {
                e = e2;
                groupConfigInfo = null;
                LogUtils.e("ConfigListSyncRequest Exception occurred when fetchNonTransactionHciEvent", e);
                if (groupConfigInfo == null) {
                }
                if (groupConfigInfo != null) {
                }
            }
        } else {
            groupConfigInfo = null;
        }
        if (groupConfigInfo == null) {
            String string = PrefUtils.getString(context, "key_non_transaction_hci_config", null);
            if (!TextUtils.isEmpty(string)) {
                groupConfigInfo = new Gson().fromJson(string, GroupConfigInfo.class);
            }
        }
        return groupConfigInfo != null ? groupConfigInfo.getInfoList((String) null, "NON_TRANSACTION_HCI_CONFIG", f.class) : arrayList;
    }

    private boolean d() {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    public f a(String str) {
        for (f next : c()) {
            if (next.a(str)) {
                return next;
            }
        }
        return null;
    }

    public void b() {
        c();
    }
}
