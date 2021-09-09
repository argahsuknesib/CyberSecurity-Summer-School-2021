package com.tiqiaa.client;

import com.tiqiaa.client.IBaseClient;
import com.tiqiaa.remote.entity.Brand;
import com.tiqiaa.remote.entity.Infrared;
import com.tiqiaa.remote.entity.IrMatchParam;
import com.tiqiaa.remote.entity.Key;
import com.tiqiaa.remote.entity.MatchPage;
import com.tiqiaa.remote.entity.Page;
import com.tiqiaa.remote.entity.Remote;
import com.tiqiaa.remote.entity.Room;
import java.util.List;

public interface IRemoteClient extends IBaseClient {

    public interface CallBackOnIrMatchDone extends IBaseClient.BaseCallBack {
        void onMatched(int i, int i2, List<String> list);
    }

    public interface CallBackOnKeyInfraredsLoaded extends IBaseClient.BaseCallBack {
        void onInfraredsLoaded(int i, List<Infrared> list);
    }

    public interface CallBackOnRemoteDeleted extends IBaseClient.BaseCallBack {
        void onDeleted(int i);
    }

    public interface CallBackOnRemoteDownloaded extends IBaseClient.BaseCallBack {
        void onRemoteDownloaded(int i, Remote remote);
    }

    public interface CallBackOnRemoteUploaded extends IBaseClient.BaseCallBack {
        void onUploaded(int i, Remote remote);
    }

    public interface CallBackOnRoomRemoteSettingsDownloaded extends IBaseClient.BaseCallBack {
        void onDownloaded(int i, List<Room> list);
    }

    public interface CallBackOnRoomRemoteSettingsUploaded extends IBaseClient.BaseCallBack {
        void onUploaded(int i);
    }

    public interface CallBackOnTestKeysLoaded extends IBaseClient.BaseCallBack {
        void onTestKeysLoaded(List<Key> list);
    }

    public interface CallbackOnAutoMatchDone extends IBaseClient.BaseCallBack {
        void onAutoMatchDone(int i, List<Remote> list);
    }

    public interface CallbackOnBrandLoaded extends IBaseClient.BaseCallBack {
        void onBrandLoaded(int i, List<Brand> list);
    }

    public interface CallbackOnMatchDone extends IBaseClient.BaseCallBack {
        void onMatchDone(int i, List<Remote> list);
    }

    public interface CallbackOnSearchDone extends IBaseClient.BaseCallBack {
        void onSearchDone(int i, List<Remote> list);
    }

    void autoMatchRemotes(Page page, CallbackOnAutoMatchDone callbackOnAutoMatchDone);

    void delete_remote(String str, CallBackOnRemoteDeleted callBackOnRemoteDeleted);

    void downloadRoomRemoteSettings(Long l, CallBackOnRoomRemoteSettingsDownloaded callBackOnRoomRemoteSettingsDownloaded);

    void download_reomte(String str, CallBackOnRemoteDownloaded callBackOnRemoteDownloaded);

    void exactMatchReomtes(MatchPage matchPage, CallbackOnMatchDone callbackOnMatchDone);

    void exactMatchReomtes(MatchPage matchPage, boolean z, CallbackOnMatchDone callbackOnMatchDone);

    void getDataBrands(int i, int i2, String str, CallbackOnBrandLoaded callbackOnBrandLoaded);

    void irmatch(IrMatchParam irMatchParam, CallBackOnIrMatchDone callBackOnIrMatchDone);

    void load_brands(CallbackOnBrandLoaded callbackOnBrandLoaded);

    void miss_model(int i, long j, String str);

    void searchAirRemote(Page page, CallbackOnSearchDone callbackOnSearchDone);

    void searchDiy(Page page, CallbackOnSearchDone callbackOnSearchDone);

    void searchOfficial(Page page, CallbackOnSearchDone callbackOnSearchDone);

    void uploadReomte(Remote remote, CallBackOnRemoteUploaded callBackOnRemoteUploaded);

    void uploadRoomRemoteSettings(Long l, List<Room> list, CallBackOnRoomRemoteSettingsUploaded callBackOnRoomRemoteSettingsUploaded);
}
