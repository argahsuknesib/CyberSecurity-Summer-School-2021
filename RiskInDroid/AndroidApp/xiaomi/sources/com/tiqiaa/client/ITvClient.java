package com.tiqiaa.client;

import com.tiqiaa.client.IBaseClient;
import com.tiqiaa.remote.entity.Infrared;
import com.tiqiaa.remote.entity.Remote;
import com.tiqiaa.tv.entity.City;
import com.tiqiaa.tv.entity.CityProvider;
import com.tiqiaa.tv.entity.CityProviderRemote;
import com.tiqiaa.tv.entity.Province;
import com.tiqiaa.tv.entity.ResultForLoadProviderChannelNumSetting;
import com.tiqiaa.tv.entity.Star;
import com.tiqiaa.tv.entity.TvChannel;
import com.tiqiaa.tv.entity.TvForenotice;
import com.tiqiaa.tv.entity.TvProvider;
import com.tiqiaa.tv.entity.TvShow;
import com.tiqiaa.tv.entity.UserProviderSetting;
import java.util.Date;
import java.util.List;

public interface ITvClient extends IBaseClient {

    public interface CallBackOnChannelForenoticeDownloaded extends IBaseClient.BaseCallBack {
        void onDownloaded(int i, List<TvForenotice> list);
    }

    public interface CallBackOnChannelNumConfigUploaded extends IBaseClient.BaseCallBack {
        void onUploaded(int i);
    }

    public interface CallBackOnCitiesLoaded extends IBaseClient.BaseCallBack {
        void onCityLoaded(int i, List<City> list);
    }

    public interface CallBackOnCityProviderRemotesLoaded extends IBaseClient.BaseCallBack {
        void onLoaded(int i, List<CityProviderRemote> list);
    }

    public interface CallBackOnCityProvidersLoaded extends IBaseClient.BaseCallBack {
        void onCityProviderLoaded(int i, List<CityProvider> list);
    }

    public interface CallBackOnProviderChannelNumsDownloaded extends IBaseClient.BaseCallBack {
        void onDownloaded(int i, ResultForLoadProviderChannelNumSetting resultForLoadProviderChannelNumSetting);
    }

    public interface CallBackOnProvidersLoaded extends IBaseClient.BaseCallBack {
        void onProviderLoaded(int i, List<TvProvider> list);
    }

    public interface CallBackOnProvincesLoaded extends IBaseClient.BaseCallBack {
        void onProviceLoaded(int i, List<Province> list);
    }

    public interface CallBackOnStarLoaded extends IBaseClient.BaseCallBack {
        void onStarLoaded(int i, Star star);
    }

    public interface CallBackOnTvChannelsDownloaded extends IBaseClient.BaseCallBack {
        void onDownloaded(int i, List<TvChannel> list);
    }

    public interface CallBackOnTvShowDownloaded extends IBaseClient.BaseCallBack {
        void onDownloaded(int i, TvShow tvShow);
    }

    public interface CallBackOnTvWatchRecsUploaded extends IBaseClient.BaseCallBack {
        void onUploaded(int i);
    }

    List<TvForenotice> fetchSimilarForenotices(TvForenotice tvForenotice, int i);

    List<Province> getAllProvinces();

    List<String> getAllTvShowNames();

    List<TvForenotice> getAppointedTvForenotices();

    List<TvShow> getFavoriteTvShows();

    List<TvProvider> getProvidersFromCity(int i);

    List<City> getProvinceCities(int i);

    List<TvForenotice> getTvForenotices(int[] iArr);

    void loadChannels(int[] iArr, CallBackOnTvChannelsDownloaded callBackOnTvChannelsDownloaded);

    void loadPlayingTvforenotces(int[] iArr, CallBackOnChannelForenoticeDownloaded callBackOnChannelForenoticeDownloaded);

    void loadProviderChannelNumConfig(int i, TvProvider tvProvider, CallBackOnProviderChannelNumsDownloaded callBackOnProviderChannelNumsDownloaded);

    void loadTvforenotces(Date date, int i, CallBackOnChannelForenoticeDownloaded callBackOnChannelForenoticeDownloaded);

    void loadTvforenotces(Date date, CallBackOnChannelForenoticeDownloaded callBackOnChannelForenoticeDownloaded);

    void loadTvforenotces(Date date, int[] iArr, CallBackOnChannelForenoticeDownloaded callBackOnChannelForenoticeDownloaded);

    void load_provider_remotes(int i, int i2, CallBackOnCityProviderRemotesLoaded callBackOnCityProviderRemotesLoaded);

    void load_tvshow(int i, int i2, CallBackOnTvShowDownloaded callBackOnTvShowDownloaded);

    List<TvForenotice> recommendTvForenotices();

    List<TvShow> recommendTvShows();

    void removeAppointemnt(TvForenotice tvForenotice);

    void removeFavoriteTvShow(TvShow tvShow);

    void saveAppoitedForenotice(TvForenotice tvForenotice);

    void saveFavoriteTvShow(TvShow tvShow);

    List<TvForenotice> searchForenotices(String str);

    List<Infrared> switchChannel(int i, Remote remote);

    List<Infrared> switchChannel(int i, Remote remote, boolean z, boolean z2);

    void uploadUserChannelNumConfig(UserProviderSetting userProviderSetting);
}
