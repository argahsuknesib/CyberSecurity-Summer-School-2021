package com.xiaomi.mico.api.service;

import com.xiaomi.mico.api.model.Conversation;
import com.xiaomi.mico.api.model.MinaResponse;
import com.xiaomi.mico.api.model.ThirdPartyResponse;
import java.util.List;
import retrofit2.Response;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;

public interface UserProfile {
    @FormUrlEncoded
    @POST("/voiceprint/delete")
    Observable<Response<MinaResponse<Boolean>>> deleteVoice(@Field("nickname") String str, @Field("voiceId") String str2);

    @GET("/children_profile/get_children_profiles")
    Observable<Response<MinaResponse<List<ThirdPartyResponse.ChildProfile>>>> getChildrenProfile();

    @GET("/userprofile/get_all_news_favourites")
    Observable<Response<MinaResponse<List<String>>>> getInterests();

    @GET("/userprofile/language_map_store")
    Observable<Response<MinaResponse<ThirdPartyResponse.LanguageMap>>> getLanguageMap(@Query("locale") String str);

    @GET("/device_profile/conversation")
    Observable<Response<MinaResponse<Conversation>>> getMicoConversation(@Query("userId") String str, @Query("deviceId") String str2, @Query("timestamp") long j, @Query("limit") int i);

    @GET("/userprofile/prefered_source")
    Observable<Response<MinaResponse<String>>> getMusicSource();

    @GET("/userprofile/user_phone/self/nickname")
    Observable<Response<MinaResponse<String>>> getNickname(@Query("userId") long j);

    @GET("/children_profile/get_baby_sleepy_mode")
    Observable<Response<MinaResponse<ThirdPartyResponse.BabySleepMode>>> getSleepMode();

    @GET("/userprofile/user_privacy")
    Observable<Response<MinaResponse<ThirdPartyResponse.UserPrivacy>>> getUserPrivacy();

    @GET("/voiceprint/list")
    Observable<Response<MinaResponse<List<ThirdPartyResponse.VoiceInfo>>>> getVoices();

    @FormUrlEncoded
    @POST("/voiceprint/save")
    Observable<Response<MinaResponse<Boolean>>> saveVoice(@Field("nickname") String str, @Field("voiceId") String str2, @Field("cmd") String str3);

    @FormUrlEncoded
    @POST("/children_profile/set_children_profiles")
    Observable<Response<MinaResponse<String>>> setChildrenProfile(@Field("data") String str);

    @FormUrlEncoded
    @POST("/userprofile/sex")
    Observable<Response<MinaResponse<String>>> setGender(@Field("sex") String str);

    @FormUrlEncoded
    @POST("/userprofile/prefered_source")
    Observable<Response<MinaResponse<Boolean>>> setMusicSource(@Field("source") String str);

    @FormUrlEncoded
    @POST("/userprofile/favorite_news_category")
    Observable<Response<MinaResponse<String>>> setNews(@Field("favoriteNewsCategory") String str);

    @FormUrlEncoded
    @POST("/userprofile/user_phone/self/nickname")
    Observable<Response<MinaResponse<String>>> setNickname(@Field("userId") long j, @Field("nickname") String str);

    @FormUrlEncoded
    @POST("/children_profile/set_baby_sleepy_mode")
    Observable<Response<MinaResponse<String>>> setSleepMode(@Field("isOpen") boolean z, @Field("start") String str, @Field("end") String str2);

    @FormUrlEncoded
    @POST("/station/play_sequence/set_reverse")
    Observable<Response<MinaResponse<Boolean>>> setStationReverse(@Field("stationId") String str, @Field("origin") String str2, @Field("reverse") String str3);

    @FormUrlEncoded
    @POST("/userprofile/user_privacy")
    Observable<Response<MinaResponse<Boolean>>> setUserPrivacy(@Field("value") String str);

    @FormUrlEncoded
    @POST("/userprofile/zodiac_sign")
    Observable<Response<MinaResponse<String>>> setXingzuo(@Field("zodiacSign") String str);
}
