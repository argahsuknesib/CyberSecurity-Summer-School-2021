package com.hzy.tvmao.offline;

import android.content.Context;
import com.hzy.tvmao.KKSingleMatchManager;
import com.hzy.tvmao.KookongSDK;
import com.hzy.tvmao.b.a.a;
import com.hzy.tvmao.b.b;
import com.hzy.tvmao.b.d;
import com.hzy.tvmao.b.f;
import com.hzy.tvmao.interf.IRequestResult;
import com.kookong.app.data.BrandList;
import com.kookong.app.data.CountryList;
import com.kookong.app.data.IrDataList;
import com.kookong.app.data.RemoteList;
import com.kookong.app.data.SpList;
import com.kookong.app.data.StbList;

public class q implements BaseSDK {
    public void getBrandList(int i, String str, IRequestResult<BrandList> iRequestResult) {
        new b().a(i, str, new r(this, iRequestResult));
    }

    public void getAllRemoteIdsInChina(int i, int i2, int i3, int i4, IRequestResult<RemoteList> iRequestResult) {
        a(i, i2, i3, i4, "", iRequestResult);
    }

    public void getAllRemoteIdsInternational(int i, int i2, String str, IRequestResult<RemoteList> iRequestResult) {
        a(i, i2, 0, 0, str, iRequestResult);
    }

    public void getRemoteDataById(String str, int i, boolean z, IRequestResult<IrDataList> iRequestResult) {
        a(str, i, "0", z, iRequestResult);
    }

    public void getAreaId(String str, String str2, String str3, IRequestResult<Integer> iRequestResult) {
        new com.hzy.tvmao.b.q().a(str, str2, str3, new s(this, iRequestResult));
    }

    public void getOperater(int i, IRequestResult<SpList> iRequestResult) {
        new com.hzy.tvmao.b.q().a(i, new t(this, iRequestResult));
    }

    public void getIptvBrandList(int i, IRequestResult<StbList> iRequestResult) {
        new com.hzy.tvmao.b.q().b(i, new u(this, iRequestResult));
    }

    public void getCountryList(IRequestResult<CountryList> iRequestResult) {
        new d().a(new v(this, iRequestResult));
    }

    public Context getContext() {
        return KookongSDK.getContext();
    }

    public KKSingleMatchManager getSingleMatchManager() {
        return new KKSingleMatchManager();
    }

    /* access modifiers changed from: private */
    public static <T> void b(a aVar, IRequestResult<T> iRequestResult) {
        if (!aVar.d() || aVar.c() == null) {
            iRequestResult.onFail(Integer.valueOf(aVar.a()), aVar.b());
        } else {
            iRequestResult.onSuccess(aVar.b(), aVar.c());
        }
    }

    private static void a(int i, int i2, int i3, int i4, String str, IRequestResult<RemoteList> iRequestResult) {
        new f().a(i, i2, i3, i4, str, new w(iRequestResult));
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.hzy.tvmao.offline.q.a(java.lang.String, int, java.lang.String, boolean, boolean, com.hzy.tvmao.interf.IRequestResult<com.kookong.app.data.IrDataList>):void
     arg types: [java.lang.String, int, java.lang.String, boolean, int, com.hzy.tvmao.interf.IRequestResult<com.kookong.app.data.IrDataList>]
     candidates:
      com.hzy.tvmao.offline.q.a(int, int, int, int, java.lang.String, com.hzy.tvmao.interf.IRequestResult<com.kookong.app.data.RemoteList>):void
      com.hzy.tvmao.offline.q.a(java.lang.String, int, java.lang.String, boolean, boolean, com.hzy.tvmao.interf.IRequestResult<com.kookong.app.data.IrDataList>):void */
    private static void a(String str, int i, String str2, boolean z, IRequestResult<IrDataList> iRequestResult) {
        a(str, i, str2, z, false, iRequestResult);
    }

    private static void a(String str, int i, String str2, boolean z, boolean z2, IRequestResult<IrDataList> iRequestResult) {
        new f().a(str, i, str2, z, z2, new x(iRequestResult));
    }
}
