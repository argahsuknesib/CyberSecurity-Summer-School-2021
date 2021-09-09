package com.xiaomi.mico.api.service;

import android.text.TextUtils;
import com.xiaomi.mico.api.AccountInfo;
import com.xiaomi.mico.api.ApiManager;
import com.xiaomi.mico.api.LoginManager;
import com.xiaomi.mico.api.model.ThirdPartyResponse;
import java.net.URI;
import java.util.ArrayList;
import okhttp3.Cookie;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Response;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import rx.Observable;
import rx.functions.Func1;

public interface AiFileService {
    @FormUrlEncoded
    @POST("/file/request/upload")
    Observable<Response<ThirdPartyResponse.AiFileToken>> requestFieUpload(@Field("sha1") String str);

    @Multipart
    @POST("/file")
    @Headers({"Not-Log-Request-Body: true"})
    Observable<Response<ThirdPartyResponse.AiFileUploadResult>> uploadVideo(@Part("uploadToken") RequestBody requestBody, @Part MultipartBody.Part part);

    public static class Helper {
        public static boolean sPrepared = false;

        public static String host() {
            return "https://file.ai.xiaomi.com/";
        }

        public static Observable<AiFileService> prepare() {
            if (sPrepared) {
                return Observable.just(ApiManager.getThirdPartyInstance().getService(AiFileService.class, host()));
            }
            return Observable.just(1).flatMap(new Func1<Integer, Observable<String>>() {
                /* class com.xiaomi.mico.api.service.AiFileService.Helper.AnonymousClass2 */

                public final Observable<String> call(Integer num) {
                    AccountInfo.ServiceInfo serviceInfo = LoginManager.getInstance().getServiceInfo("ai-service");
                    if (serviceInfo == null || !serviceInfo.isServiceTokenValid()) {
                        return LoginManager.getInstance().refreshServiceToken("ai-service");
                    }
                    return Observable.just(serviceInfo.getServiceToken());
                }
            }).flatMap(new Func1<String, Observable<AiFileService>>() {
                /* class com.xiaomi.mico.api.service.AiFileService.Helper.AnonymousClass1 */

                public final Observable<AiFileService> call(String str) {
                    if (TextUtils.isEmpty(str)) {
                        return Observable.error(new Throwable("token is null"));
                    }
                    URI create = URI.create(Helper.host());
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(new Cookie.Builder().domain(create.getHost()).name("serviceToken").value(str).build());
                    arrayList.add(new Cookie.Builder().domain(create.getHost()).name("userId").value(LoginManager.getInstance().getPassportInfo().getUserId()).build());
                    arrayList.add(new Cookie.Builder().domain(create.getHost()).name("cUserId").value(LoginManager.getInstance().getPassportInfo().getCUserId()).build());
                    ApiManager.getThirdPartyInstance().setCookie(Helper.host(), arrayList);
                    Helper.sPrepared = true;
                    return Observable.just(ApiManager.getThirdPartyInstance().getService(AiFileService.class, Helper.host()));
                }
            });
        }
    }
}
