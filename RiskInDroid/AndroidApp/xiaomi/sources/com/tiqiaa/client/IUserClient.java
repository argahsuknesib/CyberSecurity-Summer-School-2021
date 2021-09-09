package com.tiqiaa.client;

import com.tiqiaa.client.IBaseClient;
import com.tiqiaa.remote.entity.User;

public interface IUserClient extends IBaseClient {

    public interface CallBackOnGetPasswordDone extends IBaseClient.BaseCallBack {
        void onGetPasswordDone(int i);
    }

    public interface CallBackOnLoginDone extends IBaseClient.BaseCallBack {
        void onLoginDone(int i, User user);
    }

    public interface CallBackOnRegisterDone extends IBaseClient.BaseCallBack {
        void onRegisterDone(int i);
    }

    public interface CallBackOnRetrievePasswordDone extends IBaseClient.BaseCallBack {
        void onRetrievePasswordDone(int i);
    }

    public interface CallBackOnUpdateUserDone extends IBaseClient.BaseCallBack {
        void onUpdateUserDone(int i);
    }

    void forgetPassword(String str, String str2, CallBackOnGetPasswordDone callBackOnGetPasswordDone);

    void login(String str, String str2, String str3, CallBackOnLoginDone callBackOnLoginDone);

    void register(String str, String str2, String str3, String str4, CallBackOnRegisterDone callBackOnRegisterDone);

    void retrievePassword(User user, CallBackOnRetrievePasswordDone callBackOnRetrievePasswordDone);

    void update_user(User user, CallBackOnUpdateUserDone callBackOnUpdateUserDone);
}
