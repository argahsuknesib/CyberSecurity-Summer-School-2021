package com.xiaomi.mico.setting.babyschedule;

import com.google.gson.GsonBuilder;
import com.xiaomi.mico.api.ApiError;
import com.xiaomi.mico.api.ApiHelper;
import com.xiaomi.mico.api.ApiManager;
import com.xiaomi.mico.api.ApiProviderV2;
import com.xiaomi.mico.api.ApiRequest;
import com.xiaomi.mico.api.model.Music;
import com.xiaomi.mico.api.service.BabySchedulerService;
import com.xiaomi.mico.application.MicoManager;
import com.xiaomi.mico.common.util.ContainerUtil;
import com.xiaomi.mico.setting.babyschedule.bean.BabySchedule;
import com.xiaomi.mico.setting.babyschedule.bean.BabyScheduleCategory;
import com.xiaomi.mico.setting.babyschedule.bean.RequestParamsGetSchedule;
import com.xiaomi.mico.setting.babyschedule.bean.ScheduleItem;
import java.util.ArrayList;
import java.util.List;
import rx.Observable;

class BabySchedulerApiHelper {

    public interface BabyScheduleCollectionCallback {
        void onFailed(ApiError apiError);

        void onSuccess(List<ScheduleItem> list);
    }

    BabySchedulerApiHelper() {
    }

    static void loadDeviceCourses(ApiRequest.Listener<ArrayList<BabySchedule>> listener) {
        ApiManager.getInstance().enqueue($$Lambda$BabySchedulerApiHelper$_w6F8hF7NCbAPn6oc0SBX1C7eao.INSTANCE, BabySchedulerService.class, listener);
    }

    static void loadRecommendation(int i, ApiRequest.Listener<ArrayList<ScheduleItem>> listener) {
        ApiManager.getInstance().enqueue(new ApiProviderV2(i) {
            /* class com.xiaomi.mico.setting.babyschedule.$$Lambda$BabySchedulerApiHelper$C5XZ7XLWxShjx715JnMwcByGSDc */
            private final /* synthetic */ int f$0;

            {
                this.f$0 = r1;
            }

            public final Observable observable(Object obj) {
                return ((BabySchedulerService) obj).loadRecommendation(this.f$0, 5);
            }
        }, BabySchedulerService.class, listener);
    }

    static void loadScheduler(long j, long j2, final BabyScheduleCollectionCallback babyScheduleCollectionCallback) {
        if (j2 == 0) {
            getBabyScheduleCollection(babyScheduleCollectionCallback);
            return;
        }
        ApiManager.getInstance().enqueue(new ApiProviderV2(new RequestParamsGetSchedule(j, j2).toRequestParams()) {
            /* class com.xiaomi.mico.setting.babyschedule.$$Lambda$BabySchedulerApiHelper$Rfzay2lbZSebsLSNUlmrH863Q */
            private final /* synthetic */ String f$0;

            {
                this.f$0 = r1;
            }

            public final Observable observable(Object obj) {
                return ((BabySchedulerService) obj).loadScheduler(this.f$0);
            }
        }, BabySchedulerService.class, new ApiRequest.Listener<ArrayList<ScheduleItem>>() {
            /* class com.xiaomi.mico.setting.babyschedule.BabySchedulerApiHelper.AnonymousClass1 */

            public final /* bridge */ /* synthetic */ void onSuccess(Object obj) {
                onSuccess((ArrayList<ScheduleItem>) ((ArrayList) obj));
            }

            public final void onSuccess(ArrayList<ScheduleItem> arrayList) {
                babyScheduleCollectionCallback.onSuccess(arrayList);
            }

            public final void onFailure(ApiError apiError) {
                babyScheduleCollectionCallback.onFailed(apiError);
            }
        });
    }

    static void loadSchedulerCategories(ApiRequest.Listener<BabyScheduleCategory> listener) {
        ApiManager.getInstance().enqueue($$Lambda$kutH7SpUKUrdwUzvHq6uwXL9Y2Q.INSTANCE, BabySchedulerService.class, listener);
    }

    static void postDeviceCourses(String str, String str2, int i, long j, List list, String str3, ApiRequest.Listener<String> listener) {
        ApiManager.getInstance().enqueue(new ApiProviderV2(str, str2, i, j, new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create().toJson(list), str3) {
            /* class com.xiaomi.mico.setting.babyschedule.$$Lambda$BabySchedulerApiHelper$6587y8t3MVv0GlDeRGamKyiTWLo */
            private final /* synthetic */ String f$0;
            private final /* synthetic */ String f$1;
            private final /* synthetic */ int f$2;
            private final /* synthetic */ long f$3;
            private final /* synthetic */ String f$4;
            private final /* synthetic */ String f$5;

            {
                this.f$0 = r1;
                this.f$1 = r2;
                this.f$2 = r3;
                this.f$3 = r4;
                this.f$4 = r6;
                this.f$5 = r7;
            }

            public final Observable observable(Object obj) {
                return ((BabySchedulerService) obj).postDeviceCourses(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, this.f$5);
            }
        }, BabySchedulerService.class, listener);
    }

    static void deleteDeviceCourses(String str, ApiRequest.Listener<String> listener) {
        ApiManager.getInstance().enqueue(new ApiProviderV2(str) {
            /* class com.xiaomi.mico.setting.babyschedule.$$Lambda$BabySchedulerApiHelper$KrAnXNwL_OXvaRsNFhLIjr1KdFo */
            private final /* synthetic */ String f$0;

            {
                this.f$0 = r1;
            }

            public final Observable observable(Object obj) {
                return ((BabySchedulerService) obj).deleteDeviceCourses(this.f$0, MicoManager.getInstance().getCurrentMicoID());
            }
        }, BabySchedulerService.class, listener);
    }

    private static void getBabyScheduleCollection(final BabyScheduleCollectionCallback babyScheduleCollectionCallback) {
        ApiHelper.getStationLikeList("kid", new ApiRequest.Listener<List<Music.Station>>() {
            /* class com.xiaomi.mico.setting.babyschedule.BabySchedulerApiHelper.AnonymousClass2 */

            public final /* bridge */ /* synthetic */ void onSuccess(Object obj) {
                onSuccess((List<Music.Station>) ((List) obj));
            }

            public final void onSuccess(List<Music.Station> list) {
                if (ContainerUtil.isEmpty(list)) {
                    babyScheduleCollectionCallback.onSuccess(new ArrayList());
                    return;
                }
                ArrayList arrayList = new ArrayList();
                for (Music.Station scheduleItem : list) {
                    arrayList.add(new ScheduleItem(scheduleItem));
                }
                babyScheduleCollectionCallback.onSuccess(arrayList);
            }

            public final void onFailure(ApiError apiError) {
                babyScheduleCollectionCallback.onFailed(apiError);
            }
        });
    }
}
