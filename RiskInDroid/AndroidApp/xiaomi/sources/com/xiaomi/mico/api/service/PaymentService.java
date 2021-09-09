package com.xiaomi.mico.api.service;

import com.xiaomi.mico.api.model.GetPurchasedRecordResponse;
import com.xiaomi.mico.api.model.MinaResponse;
import com.xiaomi.mico.api.model.Music;
import com.xiaomi.mico.api.model.Payment;
import java.util.ArrayList;
import java.util.List;
import retrofit2.Response;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;

public interface PaymentService {
    @GET("/payment/mipay/micoin/contract")
    Observable<Response<MinaResponse<String>>> getContractState(@Query("origin") String str, @Query("cpAlbumId") String str2);

    @GET("/virtual_account/micoin/balance")
    Observable<Response<MinaResponse<Long>>> getMiCoinBalance();

    @GET("/payment/purchased_record/list")
    Observable<Response<MinaResponse<GetPurchasedRecordResponse>>> getPurchasedRecord(@Query("limit") long j, @Query("nextIndex") long j2);

    @GET("/payment/get_qqmusic_member_status")
    Observable<Response<MinaResponse<Payment.MemberStatus>>> getQQMusicMemberStatus();

    @GET("/payment/get_qqmusic_member_price")
    Observable<Response<MinaResponse<List<Payment.PriceItem>>>> getQQMusicVIPPriceList(@Query("type") String str, @Query("supportContract") boolean z);

    @GET("virtual_account/query_bill")
    Observable<Response<MinaResponse<Payment.TransactionRecord>>> getTransactionRecord(@Query("limit") long j, @Query("platform") String str, @Query("nextIndex") long j2);

    @GET("/payment/unpurchased/sound_list")
    Observable<Response<MinaResponse<ArrayList<String>>>> getUnpurchasedQuantity(@Query("cpAlbumId") String str, @Query("origin") String str2, @Query("orderType") String str3, @Query("startEpisodesNum") int i);

    @FormUrlEncoded
    @POST("/payment/v2/mipay/sound/unified_order")
    Observable<Response<MinaResponse<String>>> payForEpisodes(@Field("productName") String str, @Field("pictureUrl") String str2, @Field("origin") String str3, @Field("cpAlbumId") String str4, @Field("category") String str5, @Field("startEpisodesNum") Integer num, @Field("productCount") Integer num2, @Field("orderType") String str6, @Field("cpSoundIds") String str7, @Field("action") String str8, @Field("operateMode") int i, @Field("platform") String str9, @Field("saleType") int i2);

    @GET("/payment/scan_order_dedao")
    Observable<Response<MinaResponse<List<Music.Station>>>> paymentOrderDedao(@Query("type") int i, @Query("page") int i2, @Query("pageSize") int i3);

    @POST("/virtual_account/micoin/recharge")
    Observable<Response<MinaResponse<Long>>> rechargeMiCoin(@Query("amount") long j);

    @POST("/payment/mipay/micoin/contract")
    Observable<Response<MinaResponse<String>>> setContractState(@Query("origin") String str, @Query("cpAlbumId") String str2, @Query("pictureUrl") String str3, @Query("type") String str4, @Query("contractId") String str5, @Query("supportContract") boolean z);

    @FormUrlEncoded
    @POST("/station/play_sequence/set_reverse")
    Observable<Response<MinaResponse<Boolean>>> setStationReverse(@Field("stationId") String str, @Field("origin") String str2, @Field("reverse") String str3);
}
