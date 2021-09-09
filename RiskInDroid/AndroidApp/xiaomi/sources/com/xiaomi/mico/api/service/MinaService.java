package com.xiaomi.mico.api.service;

import com.xiaomi.mico.api.model.Admin;
import com.xiaomi.mico.api.model.Banner;
import com.xiaomi.mico.api.model.LanGroupInfo;
import com.xiaomi.mico.api.model.MiBrain;
import com.xiaomi.mico.api.model.MicoLanGroup;
import com.xiaomi.mico.api.model.MinaResponse;
import com.xiaomi.mico.api.model.Miot;
import com.xiaomi.mico.api.model.MultiRoomData;
import com.xiaomi.mico.api.model.Music;
import com.xiaomi.mico.api.model.PatchWall;
import com.xiaomi.mico.api.model.QqMiniProgramResponse;
import com.xiaomi.mico.api.model.Remote;
import com.xiaomi.mico.api.model.SkillStore;
import com.xiaomi.mico.api.model.SoundEffect;
import com.xiaomi.mico.api.model.StereoData;
import com.xiaomi.mico.api.model.ThirdPartyResponse;
import java.util.List;
import java.util.Map;
import retrofit2.Response;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;

public interface MinaService {
    @FormUrlEncoded
    @POST("/kkbox/acquire_membership")
    Observable<Response<MinaResponse<String>>> acquireMembership(@Field("deviceId") String str);

    @FormUrlEncoded
    @POST("/aivs3/audio/collect")
    Observable<Response<MinaResponse<Boolean>>> addCollectV3(@Field("audioId") String str, @Field("listId") String str2);

    @FormUrlEncoded
    @POST("/miai/express/add_phone_number")
    Observable<Response<MinaResponse<String>>> addExpressNumber(@Field("phone") String str, @Field("code") String str2);

    @FormUrlEncoded
    @POST("miai/todolist/add_item")
    Observable<Response<MinaResponse<Long>>> addMemo(@Field("value") String str);

    @FormUrlEncoded
    @POST("/music/playlist/v2/add_songs")
    Observable<Response<MinaResponse<Boolean>>> addSongs(@Field("listId") long j, @Field("songs") String str);

    @FormUrlEncoded
    @POST("admin/v2/bind_device")
    Observable<Response<MinaResponse<List<Admin.Mico>>>> bindDevice(@Field("payload") String str, @Field("alias") String str2, @Field("region") String str3);

    @FormUrlEncoded
    @POST("/didi/bind")
    Observable<Response<MinaResponse<String>>> bindDevice(@Field("deviceId") String str, @Field("device") String str2, @Field("code") String str3, @Field("randStr") String str4);

    @FormUrlEncoded
    @POST("/tencent/oauth2/qqmusic")
    Observable<Response<MinaResponse<String>>> bindQQMusicAuth(@Field("userId") String str, @Field("linkType") String str2, @Field("providerName") String str3, @Field("providerId") String str4, @Field("ret") String str5, @Field("encryptString") String str6);

    @FormUrlEncoded
    @POST("/tencent/bind")
    Observable<Response<MinaResponse<String>>> bindTencentService(@Field("tencentAppId") String str, @Field("tencentIdType") String str2, @Field("tencentId") String str3, @Field("accessToken") String str4, @Field("refreshToken") String str5, @Field("expiresIn") long j);

    @FormUrlEncoded
    @POST("music/playlist/v2/station/remove_collected/batch")
    Observable<Response<MinaResponse<String>>> bulkStationUnlike(@Field("globalIDs") String str);

    @FormUrlEncoded
    @POST("music/like/bulk_unlike")
    Observable<Response<MinaResponse<String>>> bulkUnlike(@Field("itemType") int i, @Field("itemIdList") String str);

    @GET("/common_config/")
    Observable<Response<MinaResponse<String>>> config(@Query("configName") String str);

    @FormUrlEncoded
    @POST("/music/playlist/v2/create")
    Observable<Response<MinaResponse<Long>>> createChannel(@Field("listName") String str);

    @FormUrlEncoded
    @POST("iot/dcm/create_multi_room_group")
    Observable<Response<MinaResponse<String>>> createMultiRoomGroup(@Field("groupInfo") String str);

    @FormUrlEncoded
    @POST("iot/dcm/create_stereo_group")
    Observable<Response<MinaResponse<String>>> createStereoGroup(@Field("groupInfo") String str);

    @FormUrlEncoded
    @POST("/aivs3/audio/cancel_collect")
    Observable<Response<MinaResponse<Boolean>>> delCollectV3(@Field("audioId") String str, @Field("listId") String str2);

    @FormUrlEncoded
    @POST("/music/playlist/v2/delete")
    Observable<Response<MinaResponse<Boolean>>> deleteChannel(@Field("listId") long j);

    @FormUrlEncoded
    @POST("miai/todolist/delete_item")
    Observable<Response<MinaResponse<String>>> deleteMemo(@Field("itemId") long j);

    @FormUrlEncoded
    @POST("iot/dcm/delete_multi_room_group")
    Observable<Response<MinaResponse<Boolean>>> deleteMultiRoomGroup(@Field("groupId") String str, @Field("stereoDeviceList") String str2);

    @FormUrlEncoded
    @POST("/ai_token/delete")
    Observable<Response<MinaResponse<String>>> deleteOAuthInfo(@Field("providerId") String str);

    @FormUrlEncoded
    @POST("/music/playlist/v2/delete_songs")
    Observable<Response<MinaResponse<Boolean>>> deleteSongs(@Field("listId") long j, @Field("songs") String str);

    @FormUrlEncoded
    @POST("iot/dcm/delete_stereo_group")
    Observable<Response<MinaResponse<Boolean>>> deleteStereoGroup(@Field("groupId") String str, @Field("multiRoomDeviceList") String str2);

    @GET("music/album_info")
    Observable<Response<MinaResponse<Music.Album>>> getAlbumInfo(@Query("albumId") long j);

    @FormUrlEncoded
    @POST("music/album_info")
    Observable<Response<MinaResponse<List<Music.Album>>>> getAlbumInfo(@Field("albumIdList") String str);

    @GET("music/artist/homepage")
    Observable<Response<MinaResponse<Music.ArtistHomepage>>> getArtistHomepage(@Query("artistId") long j);

    @GET("music/artist/info")
    Observable<Response<MinaResponse<Music.Artist>>> getArtistInfo(@Query("artistId") long j);

    @FormUrlEncoded
    @POST("music/artist/info")
    Observable<Response<MinaResponse<List<Music.Artist>>>> getArtistInfo(@Field("artistIdList") String str);

    @GET("/music/preference/artist_list")
    Observable<Response<MinaResponse<List<Music.Artist>>>> getArtistList(@Query("start") int i, @Query("count") int i2);

    @GET("/music/preference/list")
    Observable<Response<MinaResponse<Music.TagsArtist>>> getArtistList(@Query("artistCount") int i, @Query("tagCount") int i2, @Query("brand") String str, @Query("latitude") String str2, @Query("longitude") String str3);

    @GET("apphomepage/station/station_list/all")
    Observable<Response<MinaResponse<List<Music.Station>>>> getAudioBooksAll(@Query("tag") String str, @Query("stationCategoryType") int i, @Query("cpList") String str2, @Query("type") String str3, @Query("pageNumber") int i2, @Query("pageSize") int i3, @Query("locale") String str4);

    @GET("apphomepage/station/audio_books/flow")
    Observable<Response<MinaResponse<PatchWall>>> getAudioBooksFlow(@Query("pageNum") int i, @Query("pageSize") int i2);

    @GET("apphomepage/station/station_list/random")
    Observable<Response<MinaResponse<List<Music.Station>>>> getAudioBooksRandom(@Query("tag") String str, @Query("stationCategoryType") int i, @Query("cpList") String str2, @Query("type") String str3);

    @FormUrlEncoded
    @POST("aivs3/audio/info")
    Observable<Response<MinaResponse<List<Music.Song>>>> getAudioInfoV3(@Field("audioIdList") String str);

    @GET("banner/get")
    Observable<Response<MinaResponse<Banner>>> getBanner(@Query("tab") int i, @Query("hardware") String str, @Query("origin") String str2);

    @GET("apphomepage/station/category_list")
    Observable<Response<MinaResponse<List<Music.CategoryItem>>>> getCategoryList();

    @GET("/music/playlist/v2/songs")
    Observable<Response<MinaResponse<Music.Channel>>> getChannelInfo(@Query("listId") long j, @Query("offset") int i, @Query("count") int i2);

    @GET("/music/playlist/v2/lists")
    Observable<Response<MinaResponse<List<Music.Channel>>>> getChannelList();

    @GET("apphomepage/station/get_collected")
    Observable<Response<MinaResponse<List<Music.Station>>>> getCollection(@Query("pageType") String str);

    @GET("/apphomepage/dedao/flow")
    Observable<Response<MinaResponse<PatchWall>>> getDeDaoPathWallFlow(@Query("bindStatus") int i, @Query("previewFlag") int i2);

    @GET("admin/v2/device_list")
    Observable<Response<MinaResponse<List<Admin.Mico>>>> getDeviceList();

    @GET("/device_status/v2")
    Observable<Response<MinaResponse<String>>> getDeviceStatus(@Query("deviceId") String str, @Query("catagory") String str2);

    @GET("/miai/express/get_phone_number")
    Observable<Response<MinaResponse<List<MiBrain.ExpressInfo>>>> getExpressBindState();

    @FormUrlEncoded
    @POST("/music/song/is_favourite")
    Observable<Response<MinaResponse<List<Music.Favourite>>>> getFavouriteStatus(@Field("originSongIdList") String str);

    @GET("apphomepage/station/stationHistory")
    Observable<Response<MinaResponse<List<Music.Station>>>> getHistory(@Query("hardware") String str, @Query("num") int i, @Query("pageType") String str2);

    @GET("/aivs3/audio/history")
    Observable<Response<MinaResponse<List<Long>>>> getHistoryV3();

    @GET("music/hot_query")
    Observable<Response<MinaResponse<List<String>>>> getHotKeys();

    @GET("apphomepage/patchwall/kkbox/audiobook/block")
    Observable<Response<MinaResponse<PatchWall.Block>>> getKKboxPathWallAudioBookBlock(@Query("blockId") long j, @Query("pageNumber") int i);

    @GET("apphomepage/patchwall/kkbox/block")
    Observable<Response<MinaResponse<PatchWall.Block>>> getKKboxPathWallBlock(@Query("blockId") long j, @Query("pageNumber") int i);

    @GET("apphomepage/station/kids/flow")
    Observable<Response<MinaResponse<PatchWall>>> getKaishuFlow(@Query("pageNum") int i, @Query("userLevel") int i2);

    @GET("apphomepage/patchwall/kkbox/audiobook/flow")
    Observable<Response<MinaResponse<PatchWall>>> getKkboxAudiobooxPathWallFlow(@Query("pageNum") int i, @Query("userLevel") int i2);

    @GET("apphomepage/patchwall/kkbox/flow")
    Observable<Response<MinaResponse<PatchWall>>> getKkboxPathWallFlow(@Query("pageNum") int i, @Query("userLevel") int i2);

    @GET("apphomepage/station/knowledge/flow")
    Observable<Response<MinaResponse<PatchWall>>> getKnowledgeFlow(@Query("pageNum") int i, @Query("pageSize") int i2);

    @GET("apphomepage/station/knowledge/block")
    Observable<Response<MinaResponse<PatchWall.Block>>> getKnowledgePathWallBlock(@Query("blockId") long j, @Query("pageNumber") int i);

    @GET("music/like/list")
    Observable<Response<MinaResponse<List<Long>>>> getLikeList(@Query("itemType") int i);

    @GET("music/like/")
    Observable<Response<MinaResponse<Boolean>>> getLikeStatus(@Query("itemType") int i, @Query("itemId") long j);

    @FormUrlEncoded
    @POST("music/like/status")
    Observable<Response<MinaResponse<Map<String, Boolean>>>> getLikeStatus(@Field("itemType") int i, @Field("itemIdList") String str);

    @GET("miai/todolist/list")
    Observable<Response<MinaResponse<List<Remote.Response.Memo>>>> getMemoList(@Query("locale") String str);

    @GET("/remote/mibrainlevel")
    Observable<Response<MinaResponse<String>>> getMiBrainLevel(@Query("deviceId") String str);

    @GET("/apphomepage/patchwall/mimusic/flow")
    Observable<Response<MinaResponse<PatchWall>>> getMiPathWallFlow(@Query("pageNum") int i, @Query("userLevel") int i2);

    @GET("iot/dcm/get_functional_lan_groups")
    Observable<Response<MinaResponse<MicoLanGroup>>> getMicoLanGroup(@Query("deviceId") String str, @Query("hardware") String str2, @Query("resource") String str3);

    @GET("miot/product_details")
    Observable<Response<MinaResponse<Miot.DeviceCmdDetail>>> getMiotDeviceCmdDetail(@Query("productId") String str);

    @GET("miot/v2/product_details")
    Observable<Response<MinaResponse<SkillStore.SkillDetail>>> getMiotDeviceCmdDetailV2(@Query("productURN") String str, @Query("model") String str2);

    @GET("miot/device_list")
    Observable<Response<MinaResponse<List<Miot.Device>>>> getMiotDevices(@Query("deviceId") String str);

    @GET("miot/v2/device_list")
    Observable<Response<MinaResponse<List<Miot.Device>>>> getMiotDevicesV2(@Query("deviceId") String str, @Query("offset") int i);

    @GET("iot/dcm/get_multi_room_groups")
    Observable<Response<MinaResponse<MultiRoomData>>> getMultiRoomGroup(@Query("deviceId") String str, @Query("hardware") String str2, @Query("resource") String str3);

    @GET("/music/preference/genre_list")
    Observable<Response<MinaResponse<List<String>>>> getMusicGenreList(@Query("start") int i, @Query("count") int i2);

    @GET("apphomepage/station/novel/flow")
    Observable<Response<MinaResponse<PatchWall>>> getNovelFlow(@Query("pageNum") int i, @Query("pageSize") int i2);

    @GET("apphomepage/station/novel/block")
    Observable<Response<MinaResponse<PatchWall.Block>>> getNovelPathWallBlock(@Query("blockId") long j, @Query("pageNumber") int i);

    @FormUrlEncoded
    @POST("/ai_token/get_bind_info")
    Observable<Response<MinaResponse<MiBrain.OAuthInfo>>> getOAuthInfo(@Field("providerId") String str);

    @GET("/music/origin_map")
    Observable<Response<MinaResponse<Map<String, String>>>> getOriginNameMap();

    @GET("/miai/lbs/poi_suggest")
    Observable<Response<MinaResponse<List<ThirdPartyResponse.POIResponse>>>> getPOISuggest(@Query("place") String str, @Query("region") String str2);

    @GET("apphomepage/patchwall/block")
    Observable<Response<MinaResponse<PatchWall.Block>>> getPathWallBlock(@Query("blockId") long j, @Query("pageNumber") int i);

    @GET("apphomepage/dedao/station_list/all")
    Observable<Response<MinaResponse<List<Music.Station>>>> getPathWallDedaoBlock(@Query("cpList") String str, @Query("pageNumber") int i, @Query("pageSize") int i2);

    @GET("apphomepage/patchwall/flow")
    Observable<Response<MinaResponse<PatchWall>>> getPathWallFlow(@Query("pageNum") int i, @Query("userLevel") int i2);

    @GET("apphomepage/patchwall/flow/v2")
    Observable<Response<MinaResponse<PatchWall>>> getPathWallFlowV2(@Query("pageNum") int i, @Query("userLevel") int i2);

    @GET("apphomepage/station/kids/block")
    Observable<Response<MinaResponse<PatchWall.Block>>> getPathWallKidsBlock(@Query("blockId") long j, @Query("pageNumber") int i);

    @GET("/miai/lbs/plate_info/get")
    Observable<Response<MinaResponse<List<ThirdPartyResponse.PlateInfo>>>> getPlateInfo(@Query("userId") String str);

    @GET("tencent/user_info")
    Observable<Response<MinaResponse<MiBrain.CPAccountInfo>>> getQQAccountInfo(@Query("userId") long j, @Query("providerName") String str);

    @FormUrlEncoded
    @POST("tencent/oauth2/status")
    Observable<Response<MinaResponse<MiBrain.CPBindStatus>>> getQQBindStatus(@Field("placeholder") String str);

    @GET("/music/playlist/v2/collections")
    Observable<Response<MinaResponse<List<Music.Channel>>>> getQQCollections();

    @GET("music/qq/lyric")
    Observable<Response<MinaResponse<String>>> getQQMusicLyric(@Query("userId") String str, @Query("originSongId") String str2);

    @GET("/apphomepage/patchwall/appv2/songbook")
    Observable<Response<MinaResponse<Music.SongBook>>> getQQMusicSongs(@Query("id") String str, @Query("type") String str2);

    @GET("apphomepage/patchwall/qqmusic/block")
    Observable<Response<MinaResponse<PatchWall.Block>>> getQQPathWallBlock(@Query("blockId") long j, @Query("pageNumber") int i);

    @GET("apphomepage/patchwall/qqmusic/flow")
    Observable<Response<MinaResponse<PatchWall>>> getQQPathWallFlow(@Query("pageNum") int i, @Query("userLevel") int i2);

    @GET("apphomepage/patchwall/appv2/flow/qqmusic")
    Observable<Response<MinaResponse<PatchWall>>> getQQPathWallFlowV2(@Query("pageNum") int i, @Query("userLevel") int i2);

    @GET("/tencent/qqmusic/encrypt_cmd_params")
    Observable<Response<MinaResponse<QqMiniProgramResponse>>> getQqMiniProgramAuthQrCode(@Query("params") String str);

    @GET("apphomepage/v3.2/section")
    Observable<Response<MinaResponse<Music.Section>>> getSection(@Query("sectionId") long j, @Query("offset") int i, @Query("count") int i2);

    @GET("apphomepage/v3.2")
    Observable<Response<MinaResponse<List<Music.Section>>>> getSectionList();

    @GET("/music/preference/artist")
    Observable<Response<MinaResponse<List<Long>>>> getSelectedArtistList();

    @GET("/music/preference/genre")
    Observable<Response<MinaResponse<List<String>>>> getSelectedGenreList();

    @GET("/skillstore/item")
    Observable<Response<MinaResponse<SkillStore.Skill>>> getSkillDetail(@Query("skillId") String str);

    @GET("/skillstore/privacy")
    Observable<Response<MinaResponse<SkillStore.Privacy>>> getSkillPrivacy(@Query("skillId") String str);

    @GET("/skillstore/category/v2")
    Observable<Response<MinaResponse<SkillStore.SubCategory>>> getSkillSubCategoryList(@Query("categoryId") String str);

    @GET("music/song_info")
    Observable<Response<MinaResponse<Music.Song>>> getSongInfo(@Query("songId") long j);

    @FormUrlEncoded
    @POST("music/song_info")
    Observable<Response<MinaResponse<List<Music.Song>>>> getSongInfo(@Field("songIdList") String str);

    @GET("/music/playlist/v2/songs_in_channel")
    Observable<Response<MinaResponse<Music.Channel>>> getSongsInChannel(@Query("listId") long j, @Query("offset") int i, @Query("count") int i2);

    @GET("/music/playlist/v2/station/get_collected")
    Observable<Response<MinaResponse<List<Music.Station>>>> getStationCollected();

    @FormUrlEncoded
    @POST("music/station/info")
    Observable<Response<MinaResponse<List<Music.Station>>>> getStationInfo(@Field("stationMetaList") String str, @Field("region") String str2);

    @GET("music/station/info")
    Observable<Response<MinaResponse<Music.Station>>> getStationInfoV2(@Query("globalId") long j, @Query("stationId") String str, @Query("origin") String str2, @Query("stationType") int i, @Query("region") String str3);

    @GET("/music/playlist/v2/station/is_collected")
    Observable<Response<MinaResponse<Boolean>>> getStationLikeStatus(@Query("globalId") long j);

    @GET("music/station/sound_list")
    Observable<Response<MinaResponse<Music.StationSoundList>>> getStationSoundList(@Query("stationId") String str, @Query("origin") String str2, @Query("category") String str3, @Query("offset") int i, @Query("count") int i2, @Query("reverse") String str4, @Query("albumSaleType") Integer num);

    @Deprecated
    @GET("iot/dcm/get_user_stereo_groups")
    Observable<Response<MinaResponse<StereoData>>> getStereoGroup(@Query("deviceId") String str, @Query("hardware") String str2, @Query("resource") String str3);

    @GET("apphomepage/station/squality/flow")
    Observable<Response<MinaResponse<PatchWall>>> getTopQualityFlow(@Query("pageNum") int i, @Query("pageSize") int i2);

    @GET("apphomepage/station/squality/block")
    Observable<Response<MinaResponse<PatchWall.Block>>> getTopQualityPathWallBlock(@Query("blockId") long j, @Query("pageNumber") int i);

    @GET("/miai/lbs/get_e2e_info")
    Observable<Response<MinaResponse<ThirdPartyResponse.TrafficInfo>>> getTrafficeInfo(@Query("deviceId") String str);

    @GET("/skillstore/getUserRating")
    Observable<Response<MinaResponse<Integer>>> getUserRating(@Query("skillId") String str);

    @FormUrlEncoded
    @POST("/tencent/wx_tokens")
    Observable<Response<MinaResponse<ThirdPartyResponse.WXTokenResponse>>> getWXToken(@Field("code") String str);

    @GET("/miai/vendor_account/sales_promotion")
    Observable<Response<MinaResponse<String>>> kkboxSalesPromotion(@Query("deviceId") String str, @Query("sn") String str2);

    @GET("iot/dcm/get_user_lan_groups")
    Observable<Response<MinaResponse<List<LanGroupInfo.LanGroup>>>> lanAwakeGroup(@Query("userId") String str);

    @FormUrlEncoded
    @POST("music/like/")
    Observable<Response<MinaResponse<String>>> like(@Field("itemType") int i, @Field("itemId") long j);

    @GET("/tencent/qqmusic/encrypt")
    Observable<Response<MinaResponse<String>>> qqMusicAuthEncrypt(@Query("callback") String str);

    @FormUrlEncoded
    @POST("/client_info/register")
    Observable<Response<MinaResponse<String>>> registerPushInfo(@Field("clientId") String str, @Field("platform") int i, @Field("version") String str2, @Field("pushId") String str3);

    @FormUrlEncoded
    @POST("remote/ubus")
    Observable<Response<MinaResponse<Remote.Response>>> remote(@Field("deviceId") String str, @Field("path") String str2, @Field("method") String str3, @Field("message") String str4);

    @FormUrlEncoded
    @POST("remote/ubus")
    Observable<Response<MinaResponse<SoundEffect>>> remote4Dts(@Field("deviceId") String str, @Field("path") String str2, @Field("method") String str3, @Field("message") String str4);

    @FormUrlEncoded
    @POST("/miai/express/delete_phone_number")
    Observable<Response<MinaResponse<String>>> removeExpressNumber(@Field("phone") String str);

    @FormUrlEncoded
    @POST("/miai/lbs/plate_info/delete")
    Observable<Response<MinaResponse<Boolean>>> removePlateInfo(@Field("userId") String str, @Field("plateIndex") int i);

    @FormUrlEncoded
    @POST("/music/playlist/v2/modify_name")
    Observable<Response<MinaResponse<Boolean>>> renameChannel(@Field("listId") long j, @Field("listName") String str);

    @FormUrlEncoded
    @POST("admin/alias")
    Observable<Response<MinaResponse<String>>> renameDevice(@Field("deviceId") String str, @Field("alias") String str2);

    @FormUrlEncoded
    @POST("initialization/decrypt")
    Observable<Response<MinaResponse<String>>> requestDecryptRc4(@Field("encryptedKey") String str);

    @GET("/admin/revokePrivacy")
    Observable<Response<MinaResponse<String>>> revokePrivacy();

    @GET("apphomepage/station/station_list/search")
    Observable<Response<MinaResponse<List<Music.Station>>>> searchCategoryItem(@Query("tag") String str, @Query("stationCategoryType") int i, @Query("cpList") String str2, @Query("type") String str3, @Query("query") String str4, @Query("pageNum") int i2, @Query("pageSize") int i3, @Query("locale") String str5);

    @FormUrlEncoded
    @POST("music/search")
    Observable<Response<MinaResponse<Music.SearchResult>>> searchMusic(@Field("query") String str, @Field("queryType") int i, @Field("offset") int i2, @Field("count") int i3, @Field("supportPayment") boolean z);

    @FormUrlEncoded
    @POST("/miai/express/send_code")
    Observable<Response<MinaResponse<String>>> sendExpressCode(@Field("phone") String str);

    @FormUrlEncoded
    @POST("/device_status/")
    Observable<Response<MinaResponse<String>>> setDeviceStatus(@Field("deviceId") String str, @Field("catagory") String str2, @Field("status") String str3);

    @FormUrlEncoded
    @POST("/remote/mibrainlevel")
    Observable<Response<MinaResponse<String>>> setMiBrainLevel(@Field("deviceId") String str, @Field("level") String str2);

    @FormUrlEncoded
    @POST("/ai_token/save")
    Observable<Response<MinaResponse<String>>> setOAuthToken(@Field("accessToken") String str, @Field("providerId") String str2, @Field("expireAt") long j, @Field("context") String str3, @Field("openid") String str4);

    @FormUrlEncoded
    @POST("/music/preference/artist")
    Observable<Response<MinaResponse<String>>> setSelectedArtistList(@Field("artist_list") String str);

    @FormUrlEncoded
    @POST("/music/preference/genre")
    Observable<Response<MinaResponse<String>>> setSelectedGenreList(@Field("genre_list") String str);

    @FormUrlEncoded
    @POST("/skillstore/privacy")
    Observable<Response<MinaResponse<Boolean>>> setSkillPrivacy(@Field("skillId") String str, @Field("enabled") boolean z);

    @FormUrlEncoded
    @POST("/miai/lbs/add_e2e_info")
    Observable<Response<MinaResponse<Object>>> setTrafficeInfo(@Field("deviceId") String str, @Field("jsonOrigination") String str2, @Field("jsonDestination") String str3, @Field("jsonSpeakerLocation") String str4, @Field("navigationMode") int i, @Field("arriveTime") String str5, @Field("alarmMode") int i2, @Field("alarmCycle") int i3);

    @FormUrlEncoded
    @POST("/skillstore/rate")
    Observable<Response<MinaResponse<Boolean>>> setUserRating(@Field("skillId") String str, @Field("score") int i, @Field("comment") String str2);

    @FormUrlEncoded
    @POST("/action_log/")
    Observable<Response<MinaResponse<String>>> statLog(@Field("jsonPayload") String str);

    @FormUrlEncoded
    @POST("music/playlist/v2/station/collect")
    Observable<Response<MinaResponse<String>>> stationLike(@Field("globalId") long j);

    @FormUrlEncoded
    @POST("music/playlist/v2/station/remove_collected")
    Observable<Response<MinaResponse<String>>> stationUnlike(@Field("globalId") long j);

    @FormUrlEncoded
    @POST("/miai/subscribe/operate")
    Observable<Response<MinaResponse<Boolean>>> stockOperate(@Field("status") String str, @Field("type") String str2, @Field("subscriptionCode") String str3, @Field("dataType") String str4);

    @GET("/miai/subscribe/search")
    Observable<Response<MinaResponse<List<SkillStore.Stock>>>> stockSearch(@Query("type") String str, @Query("query") String str2, @Query("maxNum") int i);

    @GET("/miai/subscribe/list")
    Observable<Response<MinaResponse<List<SkillStore.Stock>>>> stockSubscribtions(@Query("type") String str);

    @FormUrlEncoded
    @POST("miai/subscribe/update_rank")
    Observable<Response<MinaResponse<Boolean>>> stockUpdateRank(@Field("type") String str, @Field("subscriptionIds") String str2);

    @FormUrlEncoded
    @POST("/skillstore/rss_skills/operate")
    Observable<Response<MinaResponse<String>>> subscribeRssSkill(@Field("skillId") String str, @Field("operateType") String str2);

    @FormUrlEncoded
    @POST("/tencent/oauth2/bind")
    Observable<Response<MinaResponse<String>>> tencentQQBind(@Field("userId") String str, @Field("linkType") String str2, @Field("providerName") String str3, @Field("accessToken") String str4, @Field("expiresIn") long j, @Field("openId") String str5);

    @GET("/tencent/unbind")
    Observable<Response<MinaResponse<String>>> tencentQQUnbind(@Query("userId") String str);

    @FormUrlEncoded
    @POST("/tencent/oauth2/bind_by_code")
    Observable<Response<MinaResponse<String>>> tencentWechatBind(@Field("userId") String str, @Field("linkType") String str2, @Field("providerName") String str3, @Field("code") String str4);

    @FormUrlEncoded
    @POST("iot/dcm/turn_on_all_device_awake")
    Observable<Response<MinaResponse<String>>> turnonAllDevcieAwake(@Field("deviceId") String str, @Field("hardware") String str2, @Field("resource") String str3);

    @POST("/didi/unbind_all")
    Observable<Response<MinaResponse<Remote.Response.NullInfo>>> unbindAll();

    @FormUrlEncoded
    @POST("admin/unbind_device")
    Observable<Response<MinaResponse<List<String>>>> unbindDevice(@Field("deviceId") String str);

    @FormUrlEncoded
    @POST("music/like/unlike")
    Observable<Response<MinaResponse<String>>> unlike(@Field("itemType") int i, @Field("itemId") long j);

    @FormUrlEncoded
    @POST("iot/dcm/update_awake_status")
    Observable<Response<MinaResponse<Boolean>>> updateAwakeStatus(@Field("deviceId") String str, @Field("hardware") String str2, @Field("awakeStatus") int i, @Field("resource") String str3);

    @FormUrlEncoded
    @POST("miai/todolist/update_item")
    Observable<Response<MinaResponse<String>>> updateMemo(@Field("itemId") long j, @Field("value") String str);

    @FormUrlEncoded
    @POST("iot/dcm/update_multi_room_group")
    Observable<Response<MinaResponse<Boolean>>> updateMultiRoomGroup(@Field("groupId") String str, @Field("groupInfo") String str2, @Field("stereoDeviceList") String str3);

    @FormUrlEncoded
    @POST("/miai/lbs/plate_info/update")
    Observable<Response<MinaResponse<Boolean>>> updatePlateInfo(@Field("userId") String str, @Field("plateIndex") int i, @Field("jsonPlateInfo") String str2);

    @FormUrlEncoded
    @POST("/skillstore/rss_skills/update_rank")
    Observable<Response<MinaResponse<String>>> updateRssRank(@Field("skillIDs") String str);

    @FormUrlEncoded
    @POST("iot/dcm/update_stereo_group")
    Observable<Response<MinaResponse<Boolean>>> updateStereoGroup(@Field("groupInfo") String str);

    @FormUrlEncoded
    @POST("/tencent/update")
    Observable<Response<MinaResponse<String>>> updateTencentService(@Field("tencentAppId") String str, @Field("tencentIdType") String str2, @Field("tencentId") String str3, @Field("accessToken") String str4, @Field("refreshToken") String str5, @Field("expiresIn") long j);

    @FormUrlEncoded
    @POST("remote/ota")
    Observable<Response<MinaResponse<String>>> upgrade(@Field("deviceId") String str, @Field("url") String str2, @Field("checksum") String str3);

    @FormUrlEncoded
    @POST("remote/ota/v2")
    Observable<Response<MinaResponse<String>>> upgradeV2(@Field("deviceId") String str, @Field("url") String str2, @Field("checksum") String str3, @Field("version") String str4, @Field("hardware") String str5, @Field("extra") String str6);

    @FormUrlEncoded
    @POST("/remote/upload_log")
    Observable<Response<MinaResponse<String>>> uploadLog(@Field("deviceId") String str);
}
