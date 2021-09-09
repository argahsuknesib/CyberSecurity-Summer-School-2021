package com.xiaomi.mico.api.service;

import _m_j.hsk;
import com.xiaomi.mico.api.model.IntelligentModel;
import com.xiaomi.mico.api.model.IntelligentMoreModel;
import com.xiaomi.mico.api.model.MinaResponse;
import com.xiaomi.mico.main.MicoTabsInfo;
import com.xiaomi.mico.music.patchwall.micoselect.model.MicoHandpickInfo;
import com.xiaomi.smarthome.application.CommonApplication;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

public interface MiHomeService {
    @GET("/cgi-op/api/v1/content/toApp/xiaoai/handpick")
    Observable<Response<MinaResponse<MicoHandpickInfo>>> getHandpick();

    @GET("/cgi-op/api/v1/content/toApp/intelligent/v2")
    Observable<Response<MinaResponse<IntelligentModel>>> getIntelligentFlow(@Query("infoStreamLastId") String str, @Query("pageSize") int i, @Query("changeTime") long j);

    @GET("/cgi-op/api/v1/content/toApp/intelligent/content/more")
    Observable<Response<MinaResponse<IntelligentMoreModel>>> getIntelligentMoreFlow(@Query("business") String str, @Query("groupId") int i);

    @GET("/cgi-op/api/v1/content/toApp/tab/0")
    Observable<Response<MinaResponse<MicoTabsInfo>>> getMiTabInfo();

    @GET("/cgi-op/api/v1/content/toApp/noDevice/handpick")
    Observable<Response<MinaResponse<MicoHandpickInfo>>> getNoDeviceHandpick();

    @GET("/cgi-op/api/v1/content/toApp/noDevice/tab")
    Observable<Response<MinaResponse<MicoTabsInfo>>> getNoDeviceTabInfo();

    @GET("/cgi-op/api/v1/content/toApp/tab/1")
    Observable<Response<MinaResponse<MicoTabsInfo>>> getQQTabInfo();

    /* renamed from: com.xiaomi.mico.api.service.MiHomeService$-CC  reason: invalid class name */
    public final /* synthetic */ class CC {
        public static boolean usingStgDev() {
            return false;
        }

        public static String getHostUrl() {
            return usingStgDev() ? "http://st.iot.home.mi.com" : hsk.O00000Oo(CommonApplication.getAppContext());
        }
    }
}
