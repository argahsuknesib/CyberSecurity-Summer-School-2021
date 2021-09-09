package com.xiaomi.mico.api.service;

import com.xiaomi.mico.api.model.MinaResponse;
import retrofit2.Response;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;

public interface DisplayService {
    @FormUrlEncoded
    @POST("ai/file/file_user")
    Observable<Response<MinaResponse<String>>> bindUploadedVideo(@Field("token") String str, @Field("fileHash") String str2);

    @GET("ai/file/url")
    Observable<Response<MinaResponse<String>>> getVideoFileUrl(@Query("fileID") String str);
}
