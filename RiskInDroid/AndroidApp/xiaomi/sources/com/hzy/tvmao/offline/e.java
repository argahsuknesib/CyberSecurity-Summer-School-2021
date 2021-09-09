package com.hzy.tvmao.offline;

import android.content.Context;
import com.hzy.tvmao.KKSingleMatchManager;
import com.hzy.tvmao.KookongSDK;
import com.hzy.tvmao.interf.IRequestResult;
import com.hzy.tvmao.utils.LogUtil;
import com.kookong.app.data.BrandList;
import com.kookong.app.data.CountryList;
import com.kookong.app.data.IrDataList;
import com.kookong.app.data.RemoteList;
import com.kookong.app.data.SpList;
import com.kookong.app.data.StbList;
import com.lidroid.xutils.DbUtils;

public class e implements BaseSDK {

    /* renamed from: a  reason: collision with root package name */
    private DbUtils f4443a;
    /* access modifiers changed from: private */
    public b b;

    public interface a<T> {
        T b() throws Exception;
    }

    public interface b {
        <T> void a(a<T> aVar, IRequestResult<T> iRequestResult);
    }

    public e(b bVar) {
        this.b = bVar;
    }

    public void getBrandList(int i, String str, IRequestResult<BrandList> iRequestResult) {
        LogUtil.d("getBrandList typeId:" + i + ",countryCode:" + str);
        this.b.a(new f(this, i), iRequestResult);
    }

    public DbUtils a() {
        if (this.f4443a == null) {
            this.f4443a = c.a();
            LogUtil.d("DBUtils is " + this.f4443a);
        }
        DbUtils dbUtils = this.f4443a;
        if (dbUtils != null) {
            return dbUtils;
        }
        LogUtil.e("请确保assets目录下有kkoffline.db");
        throw new RuntimeException("请确保assets目录下有kkoffline.db");
    }

    public void getAllRemoteIdsInChina(int i, int i2, int i3, int i4, IRequestResult<RemoteList> iRequestResult) {
        LogUtil.d("getAllRemoteIdsInChina");
        this.b.a(new g(this, i, i2, i4, i3), iRequestResult);
    }

    public void getAllRemoteIdsInternational(int i, int i2, String str, IRequestResult<RemoteList> iRequestResult) {
        LogUtil.d("getAllRemoteIdsInternational");
        this.b.a(new h(this, i, i2), iRequestResult);
    }

    public void getRemoteDataById(String str, int i, boolean z, IRequestResult<IrDataList> iRequestResult) {
        LogUtil.d("getRemoteDataById");
        this.b.a(new i(this, str), iRequestResult);
    }

    public void getAreaId(String str, String str2, String str3, IRequestResult<Integer> iRequestResult) {
        LogUtil.d("getAreaId");
        this.b.a(new j(this, str, str2, str3), iRequestResult);
    }

    public void getOperater(int i, IRequestResult<SpList> iRequestResult) {
        LogUtil.d("getOperater");
        this.b.a(new k(this, i), iRequestResult);
    }

    public void getIptvBrandList(int i, IRequestResult<StbList> iRequestResult) {
        LogUtil.d("getIptvBrandList：".concat(String.valueOf(i)));
        this.b.a(new l(this), iRequestResult);
    }

    public void getCountryList(IRequestResult<CountryList> iRequestResult) {
        LogUtil.d("getCountryList");
        this.b.a(new m(this), iRequestResult);
    }

    public Context getContext() {
        return KookongSDK.getContext();
    }

    public KKSingleMatchManager getSingleMatchManager() {
        return new KKSingleMatchManager().setOnGetSingleKeyDataListener(new n(this));
    }
}
