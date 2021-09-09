package com.tiqiaa.client.impl;

import _m_j.bqi;
import _m_j.bqm;
import android.content.Context;
import com.lidroid.xutils.exception.HttpException;
import com.tiqiaa.client.IUserClient;
import com.tiqiaa.icontrol.util.NetUtils;
import com.tiqiaa.icontrol.util.TQResponse;
import com.tiqiaa.icontrol.util.TiqiaaService;
import com.tiqiaa.icontrol.util.Utils;
import com.tiqiaa.remote.entity.User;

public class UserClient implements IUserClient {
    private static final String BASE_USER_URL = (TiqiaaService.isLocalServer() ? "http://192.168.0.108:8080/tqir/tjtt/user" : "https://irdna.izazamall.com/tqir/tjtt/user");
    public static User currentUser;
    private NetUtils client;

    public void forgetPassword(String str, String str2, IUserClient.CallBackOnGetPasswordDone callBackOnGetPasswordDone) {
    }

    public void retrievePassword(User user, IUserClient.CallBackOnRetrievePasswordDone callBackOnRetrievePasswordDone) {
    }

    public void update_user(User user, IUserClient.CallBackOnUpdateUserDone callBackOnUpdateUserDone) {
    }

    public UserClient(Context context) {
        this.client = new NetUtils(context);
    }

    public void register(String str, String str2, String str3, String str4, final IUserClient.CallBackOnRegisterDone callBackOnRegisterDone) {
        User user = new User();
        user.setPhone(str);
        user.setEmail(str2);
        user.setName(str3);
        user.setPassword(str4);
        this.client.doPost(String.valueOf(BASE_USER_URL) + "/register", user, new bqm<String>() {
            /* class com.tiqiaa.client.impl.UserClient.AnonymousClass1 */

            public void onSuccess(bqi<String> bqi) {
                if (bqi.O00000o == 200 && bqi.f13200O000000o != null) {
                    TQResponse tQResponse = (TQResponse) Utils.JsonParseObject((String) bqi.f13200O000000o, TQResponse.class);
                    if (tQResponse == null) {
                        callBackOnRegisterDone.onRegisterDone(1);
                        return;
                    } else if (tQResponse.getErrcode() != 10000) {
                        if (tQResponse.getErrcode() == 10101) {
                            callBackOnRegisterDone.onRegisterDone(1001);
                            return;
                        } else if (tQResponse.getErrcode() == 10102) {
                            callBackOnRegisterDone.onRegisterDone(1002);
                            return;
                        } else if (tQResponse.getErrcode() == 10003) {
                            callBackOnRegisterDone.onRegisterDone(3);
                            return;
                        } else if (tQResponse.getErrcode() == 10005) {
                            callBackOnRegisterDone.onRegisterDone(4);
                            return;
                        } else if (tQResponse.getErrcode() == 10002 || tQResponse.getErrcode() == 10004) {
                            callBackOnRegisterDone.onRegisterDone(5);
                            return;
                        } else {
                            callBackOnRegisterDone.onRegisterDone(1);
                            return;
                        }
                    }
                }
                callBackOnRegisterDone.onRegisterDone(0);
            }

            public void onFailure(HttpException httpException, String str) {
                callBackOnRegisterDone.onRegisterDone(1);
            }
        });
    }

    public void login(String str, String str2, String str3, final IUserClient.CallBackOnLoginDone callBackOnLoginDone) {
        User user = new User();
        user.setEmail(str2);
        user.setPhone(str);
        user.setPassword(str3);
        this.client.doPost(String.valueOf(BASE_USER_URL) + "/login", user, new bqm<String>() {
            /* class com.tiqiaa.client.impl.UserClient.AnonymousClass2 */

            public void onFailure(HttpException httpException, String str) {
                callBackOnLoginDone.onLoginDone(1, null);
            }

            public void onSuccess(bqi<String> bqi) {
                if (bqi.O00000o != 200 || bqi.f13200O000000o == null) {
                    callBackOnLoginDone.onLoginDone(1, null);
                    return;
                }
                TQResponse tQResponse = (TQResponse) Utils.JsonParseObject((String) bqi.f13200O000000o, TQResponse.class);
                if (tQResponse == null) {
                    callBackOnLoginDone.onLoginDone(1, null);
                } else if (tQResponse.getErrcode() == 10000) {
                    User user = (User) tQResponse.getData(User.class);
                    callBackOnLoginDone.onLoginDone(0, user);
                    UserClient.currentUser = user;
                } else if (tQResponse.getErrcode() == 10101) {
                    callBackOnLoginDone.onLoginDone(2001, null);
                } else if (tQResponse.getErrcode() == 10202) {
                    callBackOnLoginDone.onLoginDone(2002, null);
                } else if (tQResponse.getErrcode() == 10003) {
                    callBackOnLoginDone.onLoginDone(3, null);
                } else if (tQResponse.getErrcode() == 10005) {
                    callBackOnLoginDone.onLoginDone(4, null);
                } else if (tQResponse.getErrcode() == 10201) {
                    callBackOnLoginDone.onLoginDone(2001, null);
                } else if (tQResponse.getErrcode() == 10002 || tQResponse.getErrcode() == 10004) {
                    callBackOnLoginDone.onLoginDone(5, null);
                } else {
                    callBackOnLoginDone.onLoginDone(1, null);
                }
            }
        });
    }

    public static User getCurrentUser() {
        return currentUser;
    }
}
