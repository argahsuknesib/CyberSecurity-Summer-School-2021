package com.hzy.tvmao.offline;

import android.content.Context;
import com.hzy.tvmao.KKSingleMatchManager;
import com.hzy.tvmao.interf.IRequestResult;
import com.kookong.app.data.BrandList;
import com.kookong.app.data.CountryList;
import com.kookong.app.data.IrDataList;
import com.kookong.app.data.RemoteList;
import com.kookong.app.data.SpList;
import com.kookong.app.data.StbList;

public interface BaseSDK {
    void getAllRemoteIdsInChina(int i, int i2, int i3, int i4, IRequestResult<RemoteList> iRequestResult);

    void getAllRemoteIdsInternational(int i, int i2, String str, IRequestResult<RemoteList> iRequestResult);

    void getAreaId(String str, String str2, String str3, IRequestResult<Integer> iRequestResult);

    void getBrandList(int i, String str, IRequestResult<BrandList> iRequestResult);

    Context getContext();

    void getCountryList(IRequestResult<CountryList> iRequestResult);

    void getIptvBrandList(int i, IRequestResult<StbList> iRequestResult);

    void getOperater(int i, IRequestResult<SpList> iRequestResult);

    void getRemoteDataById(String str, int i, boolean z, IRequestResult<IrDataList> iRequestResult);

    KKSingleMatchManager getSingleMatchManager();
}
