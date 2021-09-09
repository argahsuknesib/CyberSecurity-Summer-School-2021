package com.tiqiaa.client.impl;

import _m_j.bdf;
import _m_j.bdi;
import _m_j.bqi;
import _m_j.bqm;
import android.content.Context;
import com.imi.fastjson.JSONArray;
import com.lidroid.xutils.exception.HttpException;
import com.tiqiaa.client.ITvClient;
import com.tiqiaa.database.DataBaseManager;
import com.tiqiaa.database.TvForenoticeCacheHelper;
import com.tiqiaa.icontrol.util.LogUtil;
import com.tiqiaa.icontrol.util.NetUtils;
import com.tiqiaa.icontrol.util.RequestDTO;
import com.tiqiaa.icontrol.util.ResponseDTO;
import com.tiqiaa.icontrol.util.StringUtil;
import com.tiqiaa.icontrol.util.TQJSON;
import com.tiqiaa.icontrol.util.TiqiaaService;
import com.tiqiaa.icontrol.util.TvForeRequestParams;
import com.tiqiaa.icontrol.util.Utils;
import com.tiqiaa.ircode.impl.InfraredFetcher;
import com.tiqiaa.remote.entity.Infrared;
import com.tiqiaa.remote.entity.Key;
import com.tiqiaa.remote.entity.Remote;
import com.tiqiaa.tv.TvShowPropertyComparator;
import com.tiqiaa.tv.entity.ChannelNum;
import com.tiqiaa.tv.entity.City;
import com.tiqiaa.tv.entity.CityProvider;
import com.tiqiaa.tv.entity.CityProviderRemote;
import com.tiqiaa.tv.entity.Province;
import com.tiqiaa.tv.entity.ResultForLoadProviderChannelNumSetting;
import com.tiqiaa.tv.entity.TvChannel;
import com.tiqiaa.tv.entity.TvForenotice;
import com.tiqiaa.tv.entity.TvProvider;
import com.tiqiaa.tv.entity.TvShow;
import com.tiqiaa.tv.entity.UserProviderSetting;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class TvClient extends TiqiaaService implements ITvClient {
    public static final String TV_URL_ROOT = (TiqiaaService.isLocalServer() ? "http://192.168.0.108:8080/epg/shtj/tv" : "http://223.6.254.203:8080/epg/shtj/tv");
    public static List<ChannelNum> currentSetting = new ArrayList();
    private NetUtils client;
    private Context context;
    public TvForenoticeCacheHelper tvForenoticeCacheHelper = new TvForenoticeCacheHelper();

    public List<TvShow> recommendTvShows() {
        return null;
    }

    public TvClient(Context context2) {
        super(context2);
        this.client = new NetUtils(context2);
        this.context = context2;
    }

    public void loadChannels(int[] iArr, final ITvClient.CallBackOnTvChannelsDownloaded callBackOnTvChannelsDownloaded) {
        LogUtil.e("ITvClient", "load_tvchannels...............##########################");
        String str = String.valueOf(TV_URL_ROOT) + "/load_channels";
        if (iArr != null) {
            LogUtil.w("ITvClient", "load_tvchannels.......channel_ids.json=" + bdf.O000000o(iArr));
            RequestDTO requestDTO = new RequestDTO(mContext);
            requestDTO.setData(iArr);
            this.client.doPostTv(str, requestDTO, new bqm<String>() {
                /* class com.tiqiaa.client.impl.TvClient.AnonymousClass1 */

                public void onSuccess(bqi<String> bqi) {
                    try {
                        if (bqi.O00000o != 200 || bqi.f13200O000000o == null || !TvClient.this.verifyResponse((String) bqi.f13200O000000o)) {
                            LogUtil.d("ITvClient", "-------------loadChannels------------failed2!");
                            callBackOnTvChannelsDownloaded.onDownloaded(1, null);
                            return;
                        }
                        ResponseDTO responseDTO = TvClient.this.getResponseDTO();
                        if (responseDTO == null || responseDTO.getResponseType() != 0 || responseDTO.getData() == null || responseDTO.getData().getResultType() != 0) {
                            callBackOnTvChannelsDownloaded.onDownloaded(1, null);
                            return;
                        }
                        callBackOnTvChannelsDownloaded.onDownloaded(0, (List) TvClient.this.response_dto.getData().getConcernObj(new bdi<List<TvChannel>>() {
                            /* class com.tiqiaa.client.impl.TvClient.AnonymousClass1.AnonymousClass1 */
                        }));
                    } catch (Exception unused) {
                        LogUtil.d("ITvClient", "-------------loadChannels------------failed3!");
                    }
                }

                public void onFailure(HttpException httpException, String str) {
                    LogUtil.d("ITvClient", "-------------loadChannels------------failed!");
                    callBackOnTvChannelsDownloaded.onDownloaded(1, null);
                }
            });
        }
    }

    public void loadPlayingTvforenotces(int[] iArr, final ITvClient.CallBackOnChannelForenoticeDownloaded callBackOnChannelForenoticeDownloaded) {
        LogUtil.e("ITvClient", "load_tvchannels_playing...............##########################");
        TvForeRequestParams tvForeRequestParams = new TvForeRequestParams();
        tvForeRequestParams.setChannel_ids(iArr);
        tvForeRequestParams.setPlaying(true);
        RequestDTO requestDTO = new RequestDTO(this.context);
        requestDTO.setData(tvForeRequestParams);
        this.client.doPostTv(String.valueOf(TV_URL_ROOT) + "/load_tv_forenotices", requestDTO, new bqm<String>() {
            /* class com.tiqiaa.client.impl.TvClient.AnonymousClass2 */

            public void onFailure(HttpException httpException, String str) {
                LogUtil.d("ITvClient", "-------------loadChannelsPlaying------------failed!");
                callBackOnChannelForenoticeDownloaded.onDownloaded(1, null);
            }

            public void onSuccess(bqi<String> bqi) {
                try {
                    if (bqi.O00000o != 200 || bqi.f13200O000000o == null || !TvClient.this.verifyResponse((String) bqi.f13200O000000o)) {
                        LogUtil.d("ITvClient", "-------------loadPlayingTvforenotces------------failed2!");
                        callBackOnChannelForenoticeDownloaded.onDownloaded(1, null);
                        return;
                    }
                    ResponseDTO responseDTO = TvClient.this.getResponseDTO();
                    if (responseDTO == null || responseDTO.getResponseType() != 0 || responseDTO.getData() == null || responseDTO.getData().getResultType() != 0) {
                        LogUtil.d("ITvClient", "-------------loadChannelsPlaying------------failed1!");
                        callBackOnChannelForenoticeDownloaded.onDownloaded(1, null);
                        return;
                    }
                    List list = (List) TvClient.this.response_dto.getData().getConcernObj(new bdi<List<TvForenotice>>() {
                        /* class com.tiqiaa.client.impl.TvClient.AnonymousClass2.AnonymousClass1 */
                    });
                    LogUtil.d("ITvClient", "-------------loadChannelsPlaying------------success!");
                    callBackOnChannelForenoticeDownloaded.onDownloaded(0, list);
                    TvClient.this.tvForenoticeCacheHelper.cacheTvForenotices(new Date(), list);
                } catch (Exception unused) {
                    LogUtil.d("ITvClient", "-------------loadPlayingTvforenotces------------failed3!");
                    callBackOnChannelForenoticeDownloaded.onDownloaded(1, null);
                }
            }
        });
    }

    public void loadTvforenotces(final Date date, int[] iArr, final ITvClient.CallBackOnChannelForenoticeDownloaded callBackOnChannelForenoticeDownloaded) {
        boolean z;
        ArrayList arrayList = new ArrayList();
        final ArrayList arrayList2 = new ArrayList();
        for (int i : iArr) {
            List<TvForenotice> cachedTvForenotices = this.tvForenoticeCacheHelper.getCachedTvForenotices(date, i);
            if (cachedTvForenotices == null || cachedTvForenotices.size() < 10) {
                arrayList.add(Integer.valueOf(i));
            } else {
                Iterator<TvForenotice> it = cachedTvForenotices.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (it.next().getType() == 0) {
                            z = false;
                            break;
                        }
                    } else {
                        z = true;
                        break;
                    }
                }
                if (z) {
                    arrayList.add(Integer.valueOf(i));
                } else {
                    arrayList2.addAll(cachedTvForenotices);
                }
            }
        }
        if (arrayList.size() == 0) {
            callBackOnChannelForenoticeDownloaded.onDownloaded(0, arrayList2);
            return;
        }
        int[] iArr2 = new int[arrayList.size()];
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            iArr2[i2] = ((Integer) arrayList.get(i2)).intValue();
        }
        TvForeRequestParams tvForeRequestParams = new TvForeRequestParams();
        tvForeRequestParams.setChannel_ids(iArr2);
        tvForeRequestParams.setDate(date);
        RequestDTO requestDTO = new RequestDTO(this.context);
        requestDTO.setData(tvForeRequestParams);
        this.client.doPostTv(String.valueOf(TV_URL_ROOT) + "/load_tv_forenotices", requestDTO, new bqm<String>() {
            /* class com.tiqiaa.client.impl.TvClient.AnonymousClass3 */

            public void onFailure(HttpException httpException, String str) {
                LogUtil.d("ITvClient", "-------------loadTvforenotces------------failed0!");
                callBackOnChannelForenoticeDownloaded.onDownloaded(1, null);
            }

            public void onSuccess(bqi<String> bqi) {
                try {
                    if (bqi.O00000o != 200 || bqi.f13200O000000o == null || !TvClient.this.verifyResponse((String) bqi.f13200O000000o)) {
                        LogUtil.d("ITvClient", "-------------loadTvforenotces------------failed1!");
                        callBackOnChannelForenoticeDownloaded.onDownloaded(1, null);
                        LogUtil.d("ITvClient", "-------------loadTvforenotces------------failed3!");
                        callBackOnChannelForenoticeDownloaded.onDownloaded(1, null);
                        return;
                    }
                    ResponseDTO responseDTO = TvClient.this.getResponseDTO();
                    if (responseDTO == null || responseDTO.getResponseType() != 0 || responseDTO.getData() == null || responseDTO.getData().getResultType() != 0) {
                        callBackOnChannelForenoticeDownloaded.onDownloaded(1, null);
                        return;
                    }
                    List list = (List) TvClient.this.response_dto.getData().getConcernObj(new bdi<List<TvForenotice>>() {
                        /* class com.tiqiaa.client.impl.TvClient.AnonymousClass3.AnonymousClass1 */
                    });
                    arrayList2.addAll(list);
                    LogUtil.d("ITvClient", "-------------loadTvforenotces------------success!");
                    callBackOnChannelForenoticeDownloaded.onDownloaded(0, arrayList2);
                    TvClient.this.tvForenoticeCacheHelper.cacheTvForenotices(date, list);
                } catch (Exception unused) {
                    LogUtil.d("ITvClient", "-------------loadTvforenotces------------failed2!");
                }
            }
        });
    }

    public void loadTvforenotces(Date date, int i, ITvClient.CallBackOnChannelForenoticeDownloaded callBackOnChannelForenoticeDownloaded) {
        loadTvforenotces(date, new int[]{i}, callBackOnChannelForenoticeDownloaded);
    }

    public void loadTvforenotces(Date date, ITvClient.CallBackOnChannelForenoticeDownloaded callBackOnChannelForenoticeDownloaded) {
        loadTvforenotces(date, getDefaultChannelIds(), callBackOnChannelForenoticeDownloaded);
    }

    private int[] getDefaultChannelIds() {
        List<ChannelNum> channelNums = DataBaseManager.getInstance().getChannelNums();
        if (channelNums == null || channelNums.size() == 0) {
            return new int[0];
        }
        int[] iArr = new int[channelNums.size()];
        for (int i = 0; i < iArr.length; i++) {
            iArr[i] = channelNums.get(i).getChannel_id();
        }
        return iArr;
    }

    public void loadProviderChannelNumConfig(int i, TvProvider tvProvider, final ITvClient.CallBackOnProviderChannelNumsDownloaded callBackOnProviderChannelNumsDownloaded) {
        JSONArray jSONArray = new JSONArray(2);
        jSONArray.add(0, Integer.valueOf(i));
        jSONArray.add(1, bdf.O00000Oo(tvProvider));
        RequestDTO requestDTO = new RequestDTO(mContext);
        requestDTO.setData(jSONArray);
        this.client.doPostTv(String.valueOf(TV_URL_ROOT) + "/load_provider_channel_num_settings", requestDTO, new bqm<String>() {
            /* class com.tiqiaa.client.impl.TvClient.AnonymousClass4 */

            public void onFailure(HttpException httpException, String str) {
                LogUtil.d("ITvClient", "-------------loadProviderChannelNumConfig------------failed0!");
                callBackOnProviderChannelNumsDownloaded.onDownloaded(1, null);
            }

            public void onSuccess(bqi<String> bqi) {
                try {
                    if (bqi.O00000o != 200 || bqi.f13200O000000o == null || !TvClient.this.verifyResponse((String) bqi.f13200O000000o)) {
                        LogUtil.d("ITvClient", "-------------loadProviderChannelNumConfig------------failed1!");
                        callBackOnProviderChannelNumsDownloaded.onDownloaded(1, null);
                        LogUtil.d("ITvClient", "-------------loadProviderChannelNumConfig------------failed3!");
                        callBackOnProviderChannelNumsDownloaded.onDownloaded(1, null);
                        return;
                    }
                    ResponseDTO responseDTO = TvClient.this.getResponseDTO();
                    if (responseDTO == null || responseDTO.getResponseType() != 0 || responseDTO.getData() == null || responseDTO.getData().getResultType() != 0) {
                        callBackOnProviderChannelNumsDownloaded.onDownloaded(1, null);
                        return;
                    }
                    ResultForLoadProviderChannelNumSetting resultForLoadProviderChannelNumSetting = (ResultForLoadProviderChannelNumSetting) TvClient.this.response_dto.getData().getConcernObj(ResultForLoadProviderChannelNumSetting.class);
                    LogUtil.d("ITvClient", "-------------loadProviderChannelNumConfig------------success!");
                    TvClient.currentSetting.clear();
                    if (!(resultForLoadProviderChannelNumSetting == null || resultForLoadProviderChannelNumSetting.getNums() == null)) {
                        TvClient.currentSetting.addAll(resultForLoadProviderChannelNumSetting.getNums());
                    }
                    callBackOnProviderChannelNumsDownloaded.onDownloaded(0, resultForLoadProviderChannelNumSetting);
                } catch (Exception e) {
                    e.printStackTrace();
                    LogUtil.d("ITvClient", "-------------loadProviderChannelNumConfig------------failed2!");
                }
            }
        });
    }

    public void uploadUserChannelNumConfig(UserProviderSetting userProviderSetting) {
        RequestDTO requestDTO = new RequestDTO(this.context);
        requestDTO.setData(userProviderSetting);
        this.client.doPostTv(String.valueOf(TV_URL_ROOT) + "/upload_provider_setting", requestDTO, new bqm<String>() {
            /* class com.tiqiaa.client.impl.TvClient.AnonymousClass5 */

            public void onFailure(HttpException httpException, String str) {
                LogUtil.e("ITvClient", "uploadUserChannelNumConfig failed!");
            }

            public void onSuccess(bqi<String> bqi) {
                LogUtil.i("ITvClient", "uploadUserChannelNumConfig success!");
            }
        });
    }

    public void load_provider_remotes(int i, int i2, final ITvClient.CallBackOnCityProviderRemotesLoaded callBackOnCityProviderRemotesLoaded) {
        RequestDTO requestDTO = new RequestDTO(this.context);
        JSONArray jSONArray = new JSONArray(2);
        jSONArray.add(0, Integer.valueOf(i));
        jSONArray.add(1, Integer.valueOf(i2));
        requestDTO.setData(jSONArray);
        this.client.doPostTv(String.valueOf(TV_URL_ROOT) + "/load_provider_remotes", requestDTO, new bqm<String>() {
            /* class com.tiqiaa.client.impl.TvClient.AnonymousClass6 */

            public void onFailure(HttpException httpException, String str) {
                LogUtil.e("ITvClient", "load_provider_remotes failed!");
                callBackOnCityProviderRemotesLoaded.onLoaded(1, null);
            }

            public void onSuccess(bqi<String> bqi) {
                try {
                    if (bqi.O00000o != 200 || bqi.f13200O000000o == null || !TvClient.this.verifyResponse((String) bqi.f13200O000000o)) {
                        LogUtil.d("ITvClient", "-------------load_provider_remotes------------failed2!");
                        callBackOnCityProviderRemotesLoaded.onLoaded(1, null);
                        LogUtil.d("ITvClient", "-------------load_provider_remotes------------failed1!");
                        callBackOnCityProviderRemotesLoaded.onLoaded(1, null);
                        return;
                    }
                    ResponseDTO responseDTO = TvClient.this.getResponseDTO();
                    if (responseDTO == null || responseDTO.getResponseType() != 0 || responseDTO.getData() == null || responseDTO.getData().getResultType() != 700) {
                        callBackOnCityProviderRemotesLoaded.onLoaded(1, null);
                        return;
                    }
                    callBackOnCityProviderRemotesLoaded.onLoaded(0, (List) TvClient.this.response_dto.getData().getConcernObj(new bdi<List<CityProviderRemote>>() {
                        /* class com.tiqiaa.client.impl.TvClient.AnonymousClass6.AnonymousClass1 */
                    }));
                    LogUtil.d("ITvClient", "-------------load_provider_remotes------------success!");
                } catch (Exception unused) {
                    LogUtil.d("ITvClient", "-------------load_provider_remotes------------failed3!");
                }
            }
        });
    }

    public void load_provinces_from_server(final ITvClient.CallBackOnProvincesLoaded callBackOnProvincesLoaded) {
        LogUtil.e("ITvClient", "load_provinces...............##########################");
        this.client.doPostTv(String.valueOf(TV_URL_ROOT) + "/load_provinces", new RequestDTO(mContext), new bqm<String>() {
            /* class com.tiqiaa.client.impl.TvClient.AnonymousClass7 */

            public void onSuccess(bqi<String> bqi) {
                try {
                    if (bqi.O00000o != 200 || bqi.f13200O000000o == null || !TvClient.this.verifyResponse((String) bqi.f13200O000000o)) {
                        LogUtil.d("ITvClient", "-------------load_provinces------------failed2!");
                        callBackOnProvincesLoaded.onProviceLoaded(1, null);
                        return;
                    }
                    ResponseDTO responseDTO = TvClient.this.getResponseDTO();
                    if (responseDTO == null || responseDTO.getResponseType() != 0 || responseDTO.getData() == null || responseDTO.getData().getResultType() != 900) {
                        callBackOnProvincesLoaded.onProviceLoaded(1, null);
                        return;
                    }
                    callBackOnProvincesLoaded.onProviceLoaded(0, (List) TvClient.this.response_dto.getData().getConcernObj(new bdi<List<Province>>() {
                        /* class com.tiqiaa.client.impl.TvClient.AnonymousClass7.AnonymousClass1 */
                    }));
                } catch (Exception unused) {
                    LogUtil.d("ITvClient", "-------------load_provinces------------failed3!");
                }
            }

            public void onFailure(HttpException httpException, String str) {
                LogUtil.d("ITvClient", "-------------load_provinces------------failed!");
                callBackOnProvincesLoaded.onProviceLoaded(1, null);
            }
        });
    }

    public void load_cities_from_server(final ITvClient.CallBackOnCitiesLoaded callBackOnCitiesLoaded) {
        LogUtil.e("ITvClient", "load_cities...............##########################");
        this.client.doPostTv(String.valueOf(TV_URL_ROOT) + "/load_citys", new RequestDTO(mContext), new bqm<String>() {
            /* class com.tiqiaa.client.impl.TvClient.AnonymousClass8 */

            public void onSuccess(bqi<String> bqi) {
                try {
                    if (bqi.O00000o != 200 || bqi.f13200O000000o == null || !TvClient.this.verifyResponse((String) bqi.f13200O000000o)) {
                        LogUtil.d("ITvClient", "-------------load_citys------------failed2!");
                        callBackOnCitiesLoaded.onCityLoaded(1, null);
                        return;
                    }
                    ResponseDTO responseDTO = TvClient.this.getResponseDTO();
                    if (responseDTO == null || responseDTO.getResponseType() != 0 || responseDTO.getData() == null || responseDTO.getData().getResultType() != 910) {
                        callBackOnCitiesLoaded.onCityLoaded(1, null);
                        return;
                    }
                    callBackOnCitiesLoaded.onCityLoaded(0, (List) TvClient.this.response_dto.getData().getConcernObj(new bdi<List<City>>() {
                        /* class com.tiqiaa.client.impl.TvClient.AnonymousClass8.AnonymousClass1 */
                    }));
                } catch (Exception unused) {
                    LogUtil.d("ITvClient", "-------------load_citys------------failed3!");
                }
            }

            public void onFailure(HttpException httpException, String str) {
                LogUtil.d("ITvClient", "-------------load_citys------------failed!");
                callBackOnCitiesLoaded.onCityLoaded(1, null);
            }
        });
    }

    public void load_providers_from_server(final ITvClient.CallBackOnProvidersLoaded callBackOnProvidersLoaded) {
        LogUtil.e("ITvClient", "load_providers...............##########################");
        this.client.doPostTv(String.valueOf(TV_URL_ROOT) + "/load_providers", new RequestDTO(mContext), new bqm<String>() {
            /* class com.tiqiaa.client.impl.TvClient.AnonymousClass9 */

            public void onSuccess(bqi<String> bqi) {
                try {
                    if (bqi.O00000o != 200 || bqi.f13200O000000o == null || !TvClient.this.verifyResponse((String) bqi.f13200O000000o)) {
                        LogUtil.d("ITvClient", "-------------load_providers------------failed2!");
                        callBackOnProvidersLoaded.onProviderLoaded(1, null);
                        return;
                    }
                    ResponseDTO responseDTO = TvClient.this.getResponseDTO();
                    if (responseDTO == null || responseDTO.getResponseType() != 0 || responseDTO.getData() == null || responseDTO.getData().getResultType() != 920) {
                        callBackOnProvidersLoaded.onProviderLoaded(1, null);
                        return;
                    }
                    callBackOnProvidersLoaded.onProviderLoaded(0, (List) TvClient.this.response_dto.getData().getConcernObj(new bdi<List<TvProvider>>() {
                        /* class com.tiqiaa.client.impl.TvClient.AnonymousClass9.AnonymousClass1 */
                    }));
                } catch (Exception unused) {
                    LogUtil.d("ITvClient", "-------------load_providers------------failed3!");
                }
            }

            public void onFailure(HttpException httpException, String str) {
                LogUtil.d("ITvClient", "-------------load_providers------------failed!");
                callBackOnProvidersLoaded.onProviderLoaded(1, null);
            }
        });
    }

    public void load_cityproviders_from_server(final ITvClient.CallBackOnCityProvidersLoaded callBackOnCityProvidersLoaded) {
        LogUtil.e("ITvClient", "load_city_provider...............##########################");
        this.client.doPostTv(String.valueOf(TV_URL_ROOT) + "/load_city_provider", new RequestDTO(mContext), new bqm<String>() {
            /* class com.tiqiaa.client.impl.TvClient.AnonymousClass10 */

            public void onSuccess(bqi<String> bqi) {
                try {
                    if (bqi.O00000o != 200 || bqi.f13200O000000o == null || !TvClient.this.verifyResponse((String) bqi.f13200O000000o)) {
                        LogUtil.d("ITvClient", "-------------load_city_provider------------failed2!");
                        callBackOnCityProvidersLoaded.onCityProviderLoaded(1, null);
                        return;
                    }
                    ResponseDTO responseDTO = TvClient.this.getResponseDTO();
                    if (responseDTO == null || responseDTO.getResponseType() != 0 || responseDTO.getData() == null || responseDTO.getData().getResultType() != 930) {
                        callBackOnCityProvidersLoaded.onCityProviderLoaded(1, null);
                        return;
                    }
                    callBackOnCityProvidersLoaded.onCityProviderLoaded(0, (List) TvClient.this.response_dto.getData().getConcernObj(new bdi<List<CityProvider>>() {
                        /* class com.tiqiaa.client.impl.TvClient.AnonymousClass10.AnonymousClass1 */
                    }));
                } catch (Exception unused) {
                    LogUtil.d("ITvClient", "-------------load_city_provider------------failed3!");
                }
            }

            public void onFailure(HttpException httpException, String str) {
                LogUtil.d("ITvClient", "-------------load_city_provider------------failed!");
                callBackOnCityProvidersLoaded.onCityProviderLoaded(1, null);
            }
        });
    }

    public List<Province> getAllProvinces() {
        return DataBaseManager.getInstance().getProvinces();
    }

    public List<City> getProvinceCities(int i) {
        if (isCityOverdue()) {
            LogUtil.e("ITvClient", "城市数据过期，先返回本地数据，后台从服务器获取刷新。");
            new Thread(new Runnable() {
                /* class com.tiqiaa.client.impl.TvClient.AnonymousClass11 */

                public void run() {
                    TvClient.this.load_cities_from_server(new ITvClient.CallBackOnCitiesLoaded() {
                        /* class com.tiqiaa.client.impl.TvClient.AnonymousClass11.AnonymousClass1 */

                        public void onCityLoaded(int i, List<City> list) {
                            if (list != null && list.size() > 0) {
                                TvClient.this.refreshCitySaveTime();
                                DataBaseManager.getInstance().dropCities();
                                DataBaseManager.getInstance().saveCities(list);
                            }
                        }
                    });
                }
            }).start();
        }
        return DataBaseManager.getInstance().getProvinceCities(i);
    }

    public List<TvProvider> getProvidersFromCity(int i) {
        if (isProviderOverdue()) {
            LogUtil.e("ITvClient", "运营商数据过期，先返回本地数据，后台从服务器获取刷新。");
            new Thread(new Runnable() {
                /* class com.tiqiaa.client.impl.TvClient.AnonymousClass12 */

                public void run() {
                    TvClient.this.load_providers_from_server(new ITvClient.CallBackOnProvidersLoaded() {
                        /* class com.tiqiaa.client.impl.TvClient.AnonymousClass12.AnonymousClass1 */

                        public void onProviderLoaded(int i, List<TvProvider> list) {
                            if (list != null && list.size() > 0) {
                                TvClient.this.refreshProviderSaveTime();
                                DataBaseManager.getInstance().dropProviders();
                                DataBaseManager.getInstance().saveProviders(list);
                            }
                        }
                    });
                    TvClient.this.load_cityproviders_from_server(new ITvClient.CallBackOnCityProvidersLoaded() {
                        /* class com.tiqiaa.client.impl.TvClient.AnonymousClass12.AnonymousClass2 */

                        public void onCityProviderLoaded(int i, List<CityProvider> list) {
                            if (list != null && list.size() > 0) {
                                DataBaseManager.getInstance().dropCityProviders();
                                DataBaseManager.getInstance().saveCityProviders(list);
                            }
                        }
                    });
                }
            }).start();
        }
        return DataBaseManager.getInstance().getProvidersFromCity(i);
    }

    public List<Infrared> switchChannel(int i, Remote remote) {
        return switchChannel(i, remote, true, false);
    }

    public List<Infrared> switchChannel(int i, Remote remote, boolean z, boolean z2) {
        List<Infrared> fetchKeyInfrareds;
        if (remote.getType() != 1 && remote.getType() != 5 && remote.getType() != 10 && remote.getType() != 4) {
            return null;
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        List<Integer> disintegrateChannelNum = Utils.disintegrateChannelNum(i);
        if (disintegrateChannelNum.size() <= 1 || !z) {
            LogUtil.w("ITvClient", "switchChannel..........频道为个位数 或设置了不发送“DIGITAL数位键...”");
        } else {
            arrayList.add(805);
        }
        for (Integer intValue : disintegrateChannelNum) {
            arrayList.add(Integer.valueOf(intValue.intValue()));
        }
        if (z2) {
            arrayList.add(817);
        }
        LogUtil.i("ITvClient", "switchChannel.........更换频道........最终要发送的按键集合   " + bdf.O000000o(arrayList));
        ArrayList arrayList2 = new ArrayList();
        for (Integer intValue2 : arrayList) {
            int intValue3 = intValue2.intValue();
            for (Key next : remote.getKeys()) {
                if (!(next == null || next.getType() != intValue3 || (fetchKeyInfrareds = fetchKeyInfrareds(remote, next)) == null)) {
                    arrayList2.addAll(fetchKeyInfrareds);
                }
            }
        }
        return arrayList2;
    }

    private List<Infrared> fetchKeyInfrareds(Remote remote, Key key) {
        return new InfraredFetcher(this.context).fetchInfrareds(remote, key);
    }

    public List<TvForenotice> searchForenotices(String str) {
        boolean z;
        LogUtil.i("ITvClient", "getMatchedForenotices.......匹配节目预报........fore_name -> ".concat(String.valueOf(str)));
        if (str == null || str.trim().length() == 0) {
            LogUtil.e("ITvClient", "getMatchedForenotices.......匹配节目预报........fore_name 为空");
            return null;
        }
        List<String> div_word = StringUtil.div_word(str);
        if (div_word == null || div_word.size() == 0) {
            LogUtil.e("ITvClient", "getMatchedForenotices.......匹配节目预报........分词 为空");
            return null;
        }
        ArrayList arrayList = new ArrayList();
        List<TvForenotice> allCachedTvForenotices = this.tvForenoticeCacheHelper.getAllCachedTvForenotices();
        if (allCachedTvForenotices != null) {
            Date date = new Date();
            for (TvForenotice next : allCachedTvForenotices) {
                if (next != null && next.getPn() != null && !next.getPn().trim().equals("")) {
                    if (next.getEt() != null && next.getEt().after(date)) {
                        if (arrayList.size() >= 10) {
                            break;
                        } else if (next.getPn() != null) {
                            Iterator<String> it = div_word.iterator();
                            while (true) {
                                if (it.hasNext()) {
                                    String next2 = it.next();
                                    if (next2 != null && !next.getPn().contains(next2)) {
                                        z = false;
                                        break;
                                    }
                                } else {
                                    z = true;
                                    break;
                                }
                            }
                            if (z) {
                                LogUtil.i("ITvClient", "getMatchedForenotices....fore 符合要求");
                                arrayList.add(next);
                            }
                        }
                    }
                } else {
                    LogUtil.w("ITvClient", "getMatchedForenotices....fore = null 或者 fore.Pn=null");
                }
            }
        }
        LogUtil.d("ITvClient", "getMatchedForenotices........matched_fores.size = " + arrayList.size() + " , fore_name = " + str);
        if (arrayList.size() != 0 || str.trim().length() <= 1) {
            return arrayList;
        }
        LogUtil.w("ITvClient", "getMatchedForenotices........没有匹配结果，且关键词长度大于 1 ，length = " + str.trim().length() + " 满足递归匹配条件");
        return searchForenotices(str.substring(0, str.length() - 1));
    }

    public List<String> getAllTvShowNames() {
        ArrayList arrayList = new ArrayList();
        List<TvForenotice> allCachedTvForenotices = this.tvForenoticeCacheHelper.getAllCachedTvForenotices();
        if (allCachedTvForenotices == null) {
            return null;
        }
        for (TvForenotice next : allCachedTvForenotices) {
            if (!arrayList.contains(next.getPn())) {
                arrayList.add(next.getPn());
            }
        }
        return arrayList;
    }

    public void saveAppoitedForenotice(TvForenotice tvForenotice) {
        this.tvForenoticeCacheHelper.saveAppoitedForenotice(tvForenotice);
    }

    public void removeAppointemnt(TvForenotice tvForenotice) {
        this.tvForenoticeCacheHelper.removeAppointForenotice(tvForenotice);
    }

    public List<TvForenotice> getAppointedTvForenotices() {
        return this.tvForenoticeCacheHelper.getAppointedForenotices();
    }

    public List<TvForenotice> fetchSimilarForenotices(TvForenotice tvForenotice, int i) {
        List<TvForenotice> allCachedTvForenotices = this.tvForenoticeCacheHelper.getAllCachedTvForenotices();
        List<ChannelNum> list = currentSetting;
        if (list != null && list.size() > 0) {
            HashSet hashSet = new HashSet();
            for (ChannelNum channel_id : currentSetting) {
                hashSet.add(Integer.valueOf(channel_id.getChannel_id()));
            }
            Iterator<TvForenotice> it = allCachedTvForenotices.iterator();
            while (it.hasNext()) {
                if (!hashSet.contains(Integer.valueOf(it.next().getChannel_id()))) {
                    it.remove();
                }
            }
        }
        if (allCachedTvForenotices == null || allCachedTvForenotices.size() == 0) {
            return null;
        }
        return new TvShowPropertyComparator().getMostLikelyForenotices(allCachedTvForenotices, tvForenotice, i);
    }

    public void saveFavoriteTvShow(TvShow tvShow) {
        this.tvForenoticeCacheHelper.saveFavoriteTvShow(tvShow);
    }

    public void removeFavoriteTvShow(TvShow tvShow) {
        this.tvForenoticeCacheHelper.removeFavoriteTvShow(tvShow);
    }

    public List<TvShow> getFavoriteTvShows() {
        return this.tvForenoticeCacheHelper.getAllFavoriteTvShow();
    }

    public List<TvForenotice> recommendTvForenotices() {
        List<TvShow> favoriteTvShows = getFavoriteTvShows();
        if (favoriteTvShows == null || favoriteTvShows.size() <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (TvShow id : favoriteTvShows) {
            new ArrayList();
            List<TvForenotice> findTvForenoticeByshowid = DataBaseManager.getInstance().findTvForenoticeByshowid(id.getId());
            if (findTvForenoticeByshowid != null && findTvForenoticeByshowid.size() > 0) {
                new ArrayList();
                List<TvForenotice> fetchSimilarForenotices = fetchSimilarForenotices(findTvForenoticeByshowid.get(0), 3);
                if (fetchSimilarForenotices != null && fetchSimilarForenotices.size() > 0) {
                    for (TvForenotice next : fetchSimilarForenotices) {
                        if (!arrayList.contains(next)) {
                            arrayList.add(next);
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    public List<TvForenotice> getTvForenotices(int[] iArr) {
        return this.tvForenoticeCacheHelper.getTvForenotices(iArr);
    }

    public void load_tvshow(int i, int i2, final ITvClient.CallBackOnTvShowDownloaded callBackOnTvShowDownloaded) {
        String str = String.valueOf(TV_URL_ROOT) + "/load_tvshow";
        if (i2 > 0) {
            i = i2;
        }
        TvShow tvShowByShowId = this.tvForenoticeCacheHelper.getTvShowByShowId(i);
        if (tvShowByShowId != null) {
            callBackOnTvShowDownloaded.onDownloaded(0, tvShowByShowId);
            return;
        }
        RequestDTO requestDTO = new RequestDTO(mContext);
        requestDTO.setData(Integer.valueOf(i));
        LogUtil.w("ITvClient", "load_tvshow........json=" + TQJSON.toJSONString(requestDTO));
        this.client.doPostTv(str, requestDTO, new bqm<String>() {
            /* class com.tiqiaa.client.impl.TvClient.AnonymousClass13 */

            public void onFailure(HttpException httpException, String str) {
                callBackOnTvShowDownloaded.onDownloaded(1, null);
            }

            public void onSuccess(bqi<String> bqi) {
                List<TvForenotice> findTvForenoticeByshowid;
                try {
                    if (bqi.O00000o != 200 || bqi.f13200O000000o == null || !TvClient.this.verifyResponse((String) bqi.f13200O000000o)) {
                        LogUtil.d("ITvClient", "-------------load_tvshow------------failed2!");
                        callBackOnTvShowDownloaded.onDownloaded(1, null);
                        LogUtil.d("ITvClient", "-------------load_tvshow------------failed1!");
                        callBackOnTvShowDownloaded.onDownloaded(1, null);
                        return;
                    }
                    ResponseDTO responseDTO = TvClient.this.getResponseDTO();
                    if (responseDTO == null || responseDTO.getResponseType() != 0 || responseDTO.getData() == null || responseDTO.getData().getResultType() != 2001) {
                        callBackOnTvShowDownloaded.onDownloaded(1, null);
                        return;
                    }
                    TvShow tvShow = (TvShow) TvClient.this.response_dto.getData().getConcernObj(TvShow.class);
                    if (tvShow != null && tvShow.getPp() == null && (findTvForenoticeByshowid = DataBaseManager.getInstance().findTvForenoticeByshowid(tvShow.getId())) != null && findTvForenoticeByshowid.size() > 0) {
                        tvShow.setPp(findTvForenoticeByshowid.get(0).getPp());
                    }
                    callBackOnTvShowDownloaded.onDownloaded(0, tvShow);
                    LogUtil.d("ITvClient", "-------------load_tvshow------------success!");
                    TvClient.this.tvForenoticeCacheHelper.cacheTvShow(tvShow);
                } catch (Exception unused) {
                    LogUtil.d("ITvClient", "-------------load_tvshow------------failed3!");
                }
            }
        });
    }

    private boolean isProvinceOverdue() {
        long j = this.context.getSharedPreferences("Overdue", 0).getLong("ProviceSaveDate", 0);
        Date date = new Date();
        if (j == 0) {
            refreshProvinceSaveTime();
            return false;
        } else if (date.getTime() - j < 604800000) {
            return false;
        } else {
            return true;
        }
    }

    private void refreshProvinceSaveTime() {
        this.context.getSharedPreferences("Overdue", 0).edit().putLong("ProviceSaveDate", new Date().getTime()).commit();
    }

    private boolean isCityOverdue() {
        long j = this.context.getSharedPreferences("Overdue", 0).getLong("CitySaveDate", 0);
        Date date = new Date();
        if (j == 0) {
            refreshCitySaveTime();
            return false;
        } else if (j == 0 || date.getTime() - j < 604800000) {
            return false;
        } else {
            return true;
        }
    }

    public void refreshCitySaveTime() {
        this.context.getSharedPreferences("Overdue", 0).edit().putLong("CitySaveDate", new Date().getTime()).commit();
    }

    private boolean isProviderOverdue() {
        long j = this.context.getSharedPreferences("Overdue", 0).getLong("ProviderSaveDate2", 0);
        Date date = new Date();
        if (j == 0) {
            refreshProviderSaveTime();
            return true;
        } else if (j == 0 || date.getTime() - j < 604800000) {
            return false;
        } else {
            return true;
        }
    }

    public void refreshProviderSaveTime() {
        this.context.getSharedPreferences("Overdue", 0).edit().putLong("ProviderSaveDate2", new Date().getTime()).commit();
    }
}
