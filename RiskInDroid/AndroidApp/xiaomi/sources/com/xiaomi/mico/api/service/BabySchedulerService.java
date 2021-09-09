package com.xiaomi.mico.api.service;

import com.xiaomi.mico.api.model.MinaResponse;
import com.xiaomi.mico.setting.babyschedule.bean.BabySchedule;
import com.xiaomi.mico.setting.babyschedule.bean.BabyScheduleCategory;
import com.xiaomi.mico.setting.babyschedule.bean.ScheduleItem;
import java.util.ArrayList;
import retrofit2.Response;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;

public interface BabySchedulerService {
    @FormUrlEncoded
    @POST("babycourse/device/course/delete")
    Observable<Response<MinaResponse<String>>> deleteDeviceCourses(@Field("alarmId") String str, @Field("deviceId") String str2);

    @GET("babycourse/device/course/list")
    Observable<Response<MinaResponse<ArrayList<BabySchedule>>>> loadDeviceCourses(@Query("deviceId") String str, @Query("alarmId") String str2);

    @GET("babycourse/course/recommend/list")
    Observable<Response<MinaResponse<ArrayList<ScheduleItem>>>> loadRecommendation(@Query("recommendType") int i, @Query("top") int i2);

    @GET("babycourse/course/list")
    Observable<Response<MinaResponse<ArrayList<ScheduleItem>>>> loadScheduler(@Query("categories") String str);

    @GET("babycourse/category/list")
    Observable<Response<MinaResponse<BabyScheduleCategory>>> loadSchedulerCategories();

    @FormUrlEncoded
    @POST("babycourse/device/course/update")
    Observable<Response<MinaResponse<String>>> postDeviceCourses(@Field("alarmId") String str, @Field("deviceId") String str2, @Field("stopByCount") int i, @Field("stopByTime") long j, @Field("resourceData") String str3, @Field("alarmData") String str4);
}
