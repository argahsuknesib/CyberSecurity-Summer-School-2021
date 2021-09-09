package com.xiaomi.mico.api.service;

import com.google.gson.JsonElement;
import com.xiaomi.mico.api.model.AiSkill;
import com.xiaomi.mico.api.model.BaseResponse;
import com.xiaomi.mico.api.model.IRDevice;
import com.xiaomi.mico.api.model.ThirdPartyResponse;
import okhttp3.RequestBody;
import retrofit2.Response;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;
import retrofit2.http.Url;
import rx.Observable;

public interface ThirdPartyService {
    @FormUrlEncoded
    @POST("")
    @Headers({"Not-Log-Request-Body: true"})
    Observable<AiSkill.CreateResponse> createSkills(@Url String str, @Field("data") String str2, @Field("groupName") String str3);

    @DELETE("")
    @Headers({"Not-Log-Request-Body: true"})
    Observable<BaseResponse> deleteSkillList(@Url String str, @Query("sidList") String str2);

    @FormUrlEncoded
    @POST("")
    @Headers({"Not-Log-Request-Body: true"})
    Observable<AiSkill.EditResponse> editSkills(@Url String str, @Field("data") String str2, @Field("groupName") String str3);

    @FormUrlEncoded
    @POST("")
    @Headers({"Not-Log-Request-Body: true"})
    Observable<Response<BaseResponse>> feedbackToMiUI(@Url String str, @Field("deviceID") String str2, @Field("data") String str3);

    @GET("")
    Observable<ThirdPartyResponse.FeedbackTags> getFeedbackTags(@Url String str, @Query("problemType") String str2, @Query("language") String str3);

    @GET("")
    Observable<IRDevice.MatchNodeList> getNodesList(@Url String str);

    @GET("")
    Observable<AiSkill.SkillListResponse> getSkillList(@Url String str, @Query("status") int i, @Query("lastSkillId") int i2, @Query("limit") int i3, @Query("groupName") String str2);

    @GET("")
    Observable<ThirdPartyResponse.UpdateResponse> getUpdateInfo(@Url String str, @Query("channel") String str2, @Query("version") String str3, @Query("filterId") String str4, @Query("platform") String str5, @Query("checkUpgrade") String str6, @Query("locale") String str7, @Query("deviceIdList") String str8);

    @GET("")
    Observable<ThirdPartyResponse.WXTokenResponse> getWXAccessToken(@Url String str, @Query("appid") String str2, @Query("secret") String str3, @Query("code") String str4);

    @GET("")
    Observable<ThirdPartyResponse.GrayUpgradeResponse> greyUpgrade(@Url String str, @Query("model") String str2, @Query("version") String str3, @Query("channel") String str4, @Query("filterID") String str5, @Query("locale") String str6, @Query("time") String str7, @Query("s") String str8);

    @POST("")
    Observable<Response<ThirdPartyResponse.ImsToken>> loadImsToken(@Url String str, @Header("Authorization") String str2, @Query("grant_type") String str3, @Query("mfgId") String str4);

    @FormUrlEncoded
    @POST("/file/request/upload")
    Observable<Response<ThirdPartyResponse.AiFileToken>> requestFileUpload(@Url String str, @Field("sha1") String str2);

    @Multipart
    @POST("/file")
    @Headers({"Not-Log-Request-Body: true"})
    Observable<JsonElement> uploadAlarmVideo(@Url String str, @Part("prefix") RequestBody requestBody, @Part("file \"; filename=video.mp4") RequestBody requestBody2);

    @Multipart
    @POST("")
    @Headers({"Not-Log-Request-Body: true"})
    Observable<JsonElement> uploadAudio(@Url String str, @Part("prefix") RequestBody requestBody, @Part("file \"; filename=audio.m4a") RequestBody requestBody2);

    @Multipart
    @POST("")
    @Headers({"Not-Log-Request-Body: true"})
    Observable<JsonElement> uploadImage(@Url String str, @Part("prefix") RequestBody requestBody, @Part("file \"; filename=image.webp") RequestBody requestBody2);

    @FormUrlEncoded
    @POST("")
    @Headers({"Not-Log-Request-Body: true"})
    Observable<Response<ThirdPartyResponse.ImageUploadResponse>> uploadImages(@Url String str, @Field("payload") String str2, @Field("_n") String str3, @Field("_t") String str4, @Field("id") String str5, @Field("_s") String str6);

    @FormUrlEncoded
    @POST("")
    @Headers({"Not-Log-Request-Body: true"})
    Observable<ThirdPartyResponse.UploadLog> uploadLog(@Url String str, @Field("payload") String str2, @Field("_n") String str3, @Field("_t") String str4, @Field("extra_data") String str5, @Field("id") String str6, @Field("_s") String str7);

    @Multipart
    @POST("")
    @Headers({"Not-Log-Request-Body: true"})
    Observable<JsonElement> uploadVideo(@Url String str, @Part("prefix") RequestBody requestBody, @Part("file \"; filename=video.mp4") RequestBody requestBody2);
}
